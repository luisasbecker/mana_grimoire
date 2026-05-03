package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.media3.muxer.WebmConstants;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelperLocalized;
import com.studiolaganne.lengendarylens.SwipePlaymatAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.opencv.imgcodecs.Imgcodecs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: SwipeMenuView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002Ò\u0001B'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u0097\u0001\u001a\u00020\u000bJ\n\u0010\u0098\u0001\u001a\u00030\u0096\u0001H\u0016J\u0014\u0010\u0099\u0001\u001a\u00030\u0096\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0016J\n\u0010\u009c\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010\u009d\u0001\u001a\u00030\u0096\u0001H\u0016J\u0014\u0010\u009e\u0001\u001a\u00030\u0096\u00012\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0016J\n\u0010¡\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010¢\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010£\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010¤\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010¥\u0001\u001a\u00030\u0096\u0001H\u0002J\u0013\u0010¦\u0001\u001a\u00030\u0096\u00012\u0007\u0010§\u0001\u001a\u00020$H\u0002J\n\u0010¨\u0001\u001a\u00030\u0096\u0001H\u0002J\n\u0010©\u0001\u001a\u00030\u0096\u0001H\u0002J\u0013\u0010ª\u0001\u001a\u00030\u0096\u00012\u0007\u0010«\u0001\u001a\u00020$H\u0016J\n\u0010¬\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010\u00ad\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010®\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010¯\u0001\u001a\u00030\u0096\u0001H\u0016J\u0013\u0010°\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u009a\u0001\u001a\u00020-H\u0016J\u0014\u0010±\u0001\u001a\u0004\u0018\u00010t2\u0007\u0010\u009a\u0001\u001a\u00020-H\u0002J\u0011\u0010²\u0001\u001a\u00030\u0096\u00012\u0007\u0010³\u0001\u001a\u00020\u000bJ\u0012\u0010´\u0001\u001a\u00030\u0096\u00012\b\u0010µ\u0001\u001a\u00030¶\u0001J\u0010\u0010·\u0001\u001a\u00030\u0096\u00012\u0006\u0010,\u001a\u00020-J\u0012\u0010¸\u0001\u001a\u00030\u0096\u00012\b\u0010¹\u0001\u001a\u00030º\u0001J\u0011\u0010»\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u009a\u0001\u001a\u00020-J\u0011\u0010¼\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u009a\u0001\u001a\u00020-J\u0011\u0010½\u0001\u001a\u00030\u0096\u00012\u0007\u0010¾\u0001\u001a\u00020-J\u008d\u0001\u0010¿\u0001\u001a\u00030\u0096\u00012\u0007\u0010À\u0001\u001a\u00020-2\u0006\u0010,\u001a\u00020-2\n\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u00012\u0007\u0010Ã\u0001\u001a\u00020\u000b2\t\u0010Ä\u0001\u001a\u0004\u0018\u00010-2\u0006\u0010e\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020\u001c2\u0006\u0010Y\u001a\u00020\u001c2\n\u0010Å\u0001\u001a\u0005\u0018\u00010Æ\u00012\u0006\u0010Z\u001a\u00020\u001c2\u0006\u0010[\u001a\u00020\u001c2\u0006\u0010\\\u001a\u00020\u001c2\u0006\u0010]\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020\u001cJ\u001a\u0010Ç\u0001\u001a\u00020\u000b2\u0007\u0010È\u0001\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\\\u0010É\u0001\u001a\u00030\u0096\u00012\u0007\u0010Ê\u0001\u001a\u00020-2\n\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u00012\u0006\u0010,\u001a\u00020-2\u0007\u0010Ã\u0001\u001a\u00020\u000b2\t\u0010Ä\u0001\u001a\u0004\u0018\u00010-2\u0006\u0010z\u001a\u00020\u000b2\u0007\u0010Ë\u0001\u001a\u00020\u000b2\u0007\u0010Ì\u0001\u001a\u00020\u000b2\u0007\u0010Í\u0001\u001a\u00020\u000bJ\n\u0010Î\u0001\u001a\u00030\u0096\u0001H\u0002J\u0013\u0010Ï\u0001\u001a\u00020\u001c2\b\u0010Ð\u0001\u001a\u00030Ñ\u0001H\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010%\u001a\b\u0012\u0004\u0012\u00020 0&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u0004\u0018\u00010jX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010l\u001a\u0004\u0018\u00010mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010o\u001a\u0004\u0018\u00010pX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010r\u001a\b\u0012\u0004\u0012\u00020t0sX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010u\u001a\b\u0012\u0004\u0012\u00020v0sX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010y\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020}X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u007f\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u000f\u0010\u0084\u0001\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020}X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0001\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0001\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u008c\u0001\u001a\u00030\u008d\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0001\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ó\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/SwipeMenuView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/studiolaganne/lengendarylens/SwipePlaymatClickListener;", "Lcom/studiolaganne/lengendarylens/SimpleDeckClickListener;", "Lcom/studiolaganne/lengendarylens/SwipeCountersClickListener;", "Lcom/studiolaganne/lengendarylens/MythicUserClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callback", "Lcom/studiolaganne/lengendarylens/SwipeMenuViewCallback;", "getCallback", "()Lcom/studiolaganne/lengendarylens/SwipeMenuViewCallback;", "setCallback", "(Lcom/studiolaganne/lengendarylens/SwipeMenuViewCallback;)V", "purchaseLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "getPurchaseLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setPurchaseLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "enablePaidContent", "", "disableSwipe", "gamePlayerSummaryMode", "gamePlayerSummaryUser", "Lcom/studiolaganne/lengendarylens/MTUser;", "deckBrowsingState", "Lcom/studiolaganne/lengendarylens/SwipeMenuView$DeckBrowsingState;", "selectedFriendForDecks", "Lcom/studiolaganne/lengendarylens/MTFriend;", "playgroupGameUsers", "", "getPlaygroupGameUsers", "()Ljava/util/List;", "setPlaygroupGameUsers", "(Ljava/util/List;)V", "internalRotation", "playerName", "", "touchSlop", "touchStartX", "", "touchStartY", "centerView", "Landroid/view/View;", "inAdvanced", "inWinLose", "inCounters", "winLoseLayout", "Landroid/widget/LinearLayout;", "countersLayout", "bkgLayout", "advancedLayout", "advancedLayout1", "advancedLayout2", "advancedLayout3", "advancedLayout4", "countersLabel", "Landroid/widget/TextView;", "winLoseLabel", "bkgLabel", "advancedLabel", "advancedLabel1", "advancedLabel2", "advancedLabel3", "advancedLabel4", "countersImage", "Landroid/widget/ImageView;", "winLoseImage", "bkgImage", "advancedImage", "advancedImage1", "advancedImage2", "advancedImage3", "advancedImage4", "backgroundImage", "overlay", "loadingOverlay", "leftRightLayout", "leftRightInnerLayout", "leftButton", "rightButton", "partners", "energy", "storm", "experience", FirebaseAnalytics.Param.TAX, "radiation", "poison", "winEnabled", "killEnabled", "bkgEnabled", "partnersEnabled", "decksEnabled", "killed", "win", "playmatRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "currentPlaymatAdapter", "Lcom/studiolaganne/lengendarylens/SwipePlaymatAdapter;", "decksRecyclerView", "currentDecksAdapter", "Lcom/studiolaganne/lengendarylens/SimpleDecksAdapter;", "countersRecyclerView", "currentCountersAdapter", "Lcom/studiolaganne/lengendarylens/SwipeCountersAdapter;", "playerNameLabel", "playmatSets", "", "Lcom/studiolaganne/lengendarylens/PlaymatSet;", "rootList", "Lcom/studiolaganne/lengendarylens/SwipePlaymatAdapter$SwipeItemData;", "currentPlaymatSet", "currentUserId", "profileUrl", "currentFormatId", "profileLayout", "profileIcon", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "noPhotoIcon", "disableDeckAndAdvanced", "getDisableDeckAndAdvanced", "()Z", "setDisableDeckAndAdvanced", "(Z)V", "gamePlayerSummaryLayout", "gamePlayerSummaryInnerLayout", "gpsRootLineLayout", "profileIconSummary", "noPhotoIconSummary", "firstnameTextView", "usernameTextView", "resultTextView", "gpsDeckImage", "Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;", "deckName", "gpsTopLayout", "editIconTextViewResult", "editIconTextViewName", "editIconTextViewDeck", "gpsUserLayout", "gpsBottomLayout", "setCornerRadius", "", "radius", "onCountersBackTapped", "onCounterToggled", "id", "Lcom/studiolaganne/lengendarylens/CounterType;", "onGalleryTapped", "onPlainColorTapped", "onDeckSelected", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "onCreateDeckSelected", "onRefreshDecksSelected", "onBackFromDecksSelected", "onSharedDecksSelected", "showFriendSelectionForDecks", "showFriendDeckList", "friend", "showOwnDeckList", "showGuestDeckListForSummary", "onMythicUserSelected", "user", "onBackFromMythicUsersSelected", "onQrScanSelected", "onBackTapped", "onCardScanTapped", "onPlaymatSelected", "findSetForPlaymat", "updateGamePlayerSummaryDeck", "deckId", "enterGamePlayerSummaryMode", "playerResult", "Lcom/studiolaganne/lengendarylens/PlayerResultItem;", "updatePlayerName", "photoPicked", "uri", "Landroid/net/Uri;", "cardPicked", "playmatPicked", "colorPicked", "color", "setState", "playerId", "player", "Lcom/studiolaganne/lengendarylens/Player;", "userId", "profileURL", "playmatImage", "Landroid/graphics/drawable/Drawable;", "dpToPx", "dp", "setRotation", "currentPlayerId", Key.ROTATION, "width", "height", "setupAsGrid", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "DeckBrowsingState", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SwipeMenuView extends ConstraintLayout implements SwipePlaymatClickListener, SimpleDeckClickListener, SwipeCountersClickListener, MythicUserClickListener {
    public static final int $stable = 8;
    private ImageView advancedImage;
    private ImageView advancedImage1;
    private ImageView advancedImage2;
    private ImageView advancedImage3;
    private ImageView advancedImage4;
    private TextView advancedLabel;
    private TextView advancedLabel1;
    private TextView advancedLabel2;
    private TextView advancedLabel3;
    private TextView advancedLabel4;
    private LinearLayout advancedLayout;
    private LinearLayout advancedLayout1;
    private LinearLayout advancedLayout2;
    private LinearLayout advancedLayout3;
    private LinearLayout advancedLayout4;
    private ImageView backgroundImage;
    private boolean bkgEnabled;
    private ImageView bkgImage;
    private TextView bkgLabel;
    private LinearLayout bkgLayout;
    private SwipeMenuViewCallback callback;
    private View centerView;
    private ImageView countersImage;
    private TextView countersLabel;
    private LinearLayout countersLayout;
    private RecyclerView countersRecyclerView;
    private SwipeCountersAdapter currentCountersAdapter;
    private SimpleDecksAdapter currentDecksAdapter;
    private int currentFormatId;
    private SwipePlaymatAdapter currentPlaymatAdapter;
    private String currentPlaymatSet;
    private int currentUserId;
    private DeckBrowsingState deckBrowsingState;
    private TextView deckName;
    private boolean decksEnabled;
    private RecyclerView decksRecyclerView;
    private boolean disableDeckAndAdvanced;
    private boolean disableSwipe;
    private TextView editIconTextViewDeck;
    private TextView editIconTextViewName;
    private TextView editIconTextViewResult;
    private boolean enablePaidContent;
    private boolean energy;
    private boolean experience;
    private TextView firstnameTextView;
    private ConstraintLayout gamePlayerSummaryInnerLayout;
    private ConstraintLayout gamePlayerSummaryLayout;
    private boolean gamePlayerSummaryMode;
    private MTUser gamePlayerSummaryUser;
    private LinearLayout gpsBottomLayout;
    private LoadingImageViewDeck gpsDeckImage;
    private ConstraintLayout gpsRootLineLayout;
    private LinearLayout gpsTopLayout;
    private LinearLayout gpsUserLayout;
    private boolean inAdvanced;
    private boolean inCounters;
    private boolean inWinLose;
    private int internalRotation;
    private boolean killEnabled;
    private boolean killed;
    private ConstraintLayout leftButton;
    private ConstraintLayout leftRightInnerLayout;
    private ConstraintLayout leftRightLayout;
    private ConstraintLayout loadingOverlay;
    private ImageView noPhotoIcon;
    private ImageView noPhotoIconSummary;
    private View overlay;
    private boolean partners;
    private boolean partnersEnabled;
    private String playerName;
    private TextView playerNameLabel;
    private List<MTUser> playgroupGameUsers;
    private RecyclerView playmatRecyclerView;
    private List<PlaymatSet> playmatSets;
    private boolean poison;
    private CachedImageView profileIcon;
    private CachedImageView profileIconSummary;
    private ConstraintLayout profileLayout;
    private String profileUrl;
    private ActivityResultLauncher<Intent> purchaseLauncher;
    private boolean radiation;
    private TextView resultTextView;
    private ConstraintLayout rightButton;
    private List<SwipePlaymatAdapter.SwipeItemData> rootList;
    private MTFriend selectedFriendForDecks;
    private boolean storm;
    private boolean tax;
    private final int touchSlop;
    private float touchStartX;
    private float touchStartY;
    private TextView usernameTextView;
    private boolean win;
    private boolean winEnabled;
    private ImageView winLoseImage;
    private TextView winLoseLabel;
    private LinearLayout winLoseLayout;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SwipeMenuView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/SwipeMenuView$DeckBrowsingState;", "", "<init>", "(Ljava/lang/String;I)V", "OWN_DECKS", "FRIEND_SELECTION", "FRIEND_DECKS", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class DeckBrowsingState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DeckBrowsingState[] $VALUES;
        public static final DeckBrowsingState OWN_DECKS = new DeckBrowsingState("OWN_DECKS", 0);
        public static final DeckBrowsingState FRIEND_SELECTION = new DeckBrowsingState("FRIEND_SELECTION", 1);
        public static final DeckBrowsingState FRIEND_DECKS = new DeckBrowsingState("FRIEND_DECKS", 2);

        private static final /* synthetic */ DeckBrowsingState[] $values() {
            return new DeckBrowsingState[]{OWN_DECKS, FRIEND_SELECTION, FRIEND_DECKS};
        }

        static {
            DeckBrowsingState[] deckBrowsingStateArr$values = $values();
            $VALUES = deckBrowsingStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(deckBrowsingStateArr$values);
        }

        private DeckBrowsingState(String str, int i) {
        }

        public static EnumEntries<DeckBrowsingState> getEntries() {
            return $ENTRIES;
        }

        public static DeckBrowsingState valueOf(String str) {
            return (DeckBrowsingState) Enum.valueOf(DeckBrowsingState.class, str);
        }

        public static DeckBrowsingState[] values() {
            return (DeckBrowsingState[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: SwipeMenuView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CounterType.values().length];
            try {
                iArr[CounterType.Poison.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CounterType.Energy.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CounterType.Storm.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CounterType.Experience.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CounterType.Tax.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CounterType.Radiation.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwipeMenuView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwipeMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.enablePaidContent = true;
        this.deckBrowsingState = DeckBrowsingState.OWN_DECKS;
        this.playgroupGameUsers = CollectionsKt.emptyList();
        this.playerName = "";
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 6;
        this.winEnabled = true;
        this.killEnabled = true;
        this.bkgEnabled = true;
        this.partnersEnabled = true;
        this.decksEnabled = true;
        this.playmatSets = new ArrayList();
        this.rootList = new ArrayList();
        this.currentPlaymatSet = "";
        this.currentFormatId = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwipeMenuView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.SwipeMenuView_menu_rotation, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.internalRotation = i2;
        ConstraintLayout.inflate(context, R.layout.swipe_menu_view, this);
        setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
        View viewFindViewById = findViewById(R.id.centerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.centerView = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.winLoseLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.winLoseLayout = (LinearLayout) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.countersLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.countersLayout = (LinearLayout) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.bkgLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.bkgLayout = (LinearLayout) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.advancedLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.advancedLayout = (LinearLayout) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.advancedLayout1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.advancedLayout1 = (LinearLayout) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.advancedLayout2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.advancedLayout2 = (LinearLayout) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.advancedLayout3);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.advancedLayout3 = (LinearLayout) viewFindViewById8;
        View viewFindViewById9 = findViewById(R.id.advancedLayout4);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.advancedLayout4 = (LinearLayout) viewFindViewById9;
        View viewFindViewById10 = findViewById(R.id.countersLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.countersLabel = (TextView) viewFindViewById10;
        View viewFindViewById11 = findViewById(R.id.winLoseLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.winLoseLabel = (TextView) viewFindViewById11;
        View viewFindViewById12 = findViewById(R.id.bkgLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.bkgLabel = (TextView) viewFindViewById12;
        View viewFindViewById13 = findViewById(R.id.advancedLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.advancedLabel = (TextView) viewFindViewById13;
        View viewFindViewById14 = findViewById(R.id.advancedLabel1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.advancedLabel1 = (TextView) viewFindViewById14;
        View viewFindViewById15 = findViewById(R.id.advancedLabel2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.advancedLabel2 = (TextView) viewFindViewById15;
        View viewFindViewById16 = findViewById(R.id.advancedLabel3);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        this.advancedLabel3 = (TextView) viewFindViewById16;
        View viewFindViewById17 = findViewById(R.id.advancedLabel4);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        this.advancedLabel4 = (TextView) viewFindViewById17;
        View viewFindViewById18 = findViewById(R.id.countersImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        this.countersImage = (ImageView) viewFindViewById18;
        View viewFindViewById19 = findViewById(R.id.winLoseImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        this.winLoseImage = (ImageView) viewFindViewById19;
        View viewFindViewById20 = findViewById(R.id.bkgImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById20, "findViewById(...)");
        this.bkgImage = (ImageView) viewFindViewById20;
        View viewFindViewById21 = findViewById(R.id.advancedImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById21, "findViewById(...)");
        this.advancedImage = (ImageView) viewFindViewById21;
        View viewFindViewById22 = findViewById(R.id.advancedImage1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById22, "findViewById(...)");
        this.advancedImage1 = (ImageView) viewFindViewById22;
        View viewFindViewById23 = findViewById(R.id.advancedImage2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById23, "findViewById(...)");
        this.advancedImage2 = (ImageView) viewFindViewById23;
        View viewFindViewById24 = findViewById(R.id.advancedImage3);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById24, "findViewById(...)");
        this.advancedImage3 = (ImageView) viewFindViewById24;
        View viewFindViewById25 = findViewById(R.id.advancedImage4);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById25, "findViewById(...)");
        this.advancedImage4 = (ImageView) viewFindViewById25;
        View viewFindViewById26 = findViewById(R.id.card_background_image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById26, "findViewById(...)");
        this.backgroundImage = (ImageView) viewFindViewById26;
        View viewFindViewById27 = findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById27, "findViewById(...)");
        this.overlay = viewFindViewById27;
        View viewFindViewById28 = findViewById(R.id.loadingOverlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById28, "findViewById(...)");
        this.loadingOverlay = (ConstraintLayout) viewFindViewById28;
        View viewFindViewById29 = findViewById(R.id.playmat_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById29, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById29;
        this.playmatRecyclerView = recyclerView;
        recyclerView.setVisibility(8);
        View viewFindViewById30 = findViewById(R.id.decks_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById30, "findViewById(...)");
        RecyclerView recyclerView2 = (RecyclerView) viewFindViewById30;
        this.decksRecyclerView = recyclerView2;
        recyclerView2.setVisibility(8);
        View viewFindViewById31 = findViewById(R.id.counters_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById31, "findViewById(...)");
        RecyclerView recyclerView3 = (RecyclerView) viewFindViewById31;
        this.countersRecyclerView = recyclerView3;
        recyclerView3.setVisibility(8);
        View viewFindViewById32 = findViewById(R.id.profileLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById32, "findViewById(...)");
        this.profileLayout = (ConstraintLayout) viewFindViewById32;
        View viewFindViewById33 = findViewById(R.id.profile_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById33, "findViewById(...)");
        this.profileIcon = (CachedImageView) viewFindViewById33;
        View viewFindViewById34 = findViewById(R.id.no_photo_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById34, "findViewById(...)");
        this.noPhotoIcon = (ImageView) viewFindViewById34;
        View viewFindViewById35 = findViewById(R.id.leftRightLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById35, "findViewById(...)");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById35;
        this.leftRightLayout = constraintLayout;
        constraintLayout.setVisibility(8);
        ViewExtensionsKt.setOnClickWithFade(this.leftRightLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        });
        View viewFindViewById36 = findViewById(R.id.leftRightInnerLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById36, "findViewById(...)");
        this.leftRightInnerLayout = (ConstraintLayout) viewFindViewById36;
        View viewFindViewById37 = findViewById(R.id.leftLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById37, "findViewById(...)");
        this.leftButton = (ConstraintLayout) viewFindViewById37;
        View viewFindViewById38 = findViewById(R.id.rightLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById38, "findViewById(...)");
        this.rightButton = (ConstraintLayout) viewFindViewById38;
        ViewExtensionsKt.setOnClickWithFade(this.leftButton, new Function0() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SwipeMenuView._init_$lambda$1(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(this.rightButton, new Function0() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SwipeMenuView._init_$lambda$2(this.f$0);
            }
        });
        View viewFindViewById39 = findViewById(R.id.gamePlayerSummaryLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById39, "findViewById(...)");
        this.gamePlayerSummaryLayout = (ConstraintLayout) viewFindViewById39;
        View viewFindViewById40 = findViewById(R.id.gamePlayerSummaryInnerLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById40, "findViewById(...)");
        this.gamePlayerSummaryInnerLayout = (ConstraintLayout) viewFindViewById40;
        View viewFindViewById41 = findViewById(R.id.gpsRootLineLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById41, "findViewById(...)");
        this.gpsRootLineLayout = (ConstraintLayout) viewFindViewById41;
        View viewFindViewById42 = findViewById(R.id.profileIconSummary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById42, "findViewById(...)");
        this.profileIconSummary = (CachedImageView) viewFindViewById42;
        View viewFindViewById43 = findViewById(R.id.noPhotoIconSummary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById43, "findViewById(...)");
        this.noPhotoIconSummary = (ImageView) viewFindViewById43;
        View viewFindViewById44 = findViewById(R.id.firstnameTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById44, "findViewById(...)");
        this.firstnameTextView = (TextView) viewFindViewById44;
        View viewFindViewById45 = findViewById(R.id.usernameTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById45, "findViewById(...)");
        this.usernameTextView = (TextView) viewFindViewById45;
        View viewFindViewById46 = findViewById(R.id.resultTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById46, "findViewById(...)");
        this.resultTextView = (TextView) viewFindViewById46;
        View viewFindViewById47 = findViewById(R.id.gpsDeckImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById47, "findViewById(...)");
        this.gpsDeckImage = (LoadingImageViewDeck) viewFindViewById47;
        View viewFindViewById48 = findViewById(R.id.deckName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById48, "findViewById(...)");
        this.deckName = (TextView) viewFindViewById48;
        View viewFindViewById49 = findViewById(R.id.gpsTopLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById49, "findViewById(...)");
        this.gpsTopLayout = (LinearLayout) viewFindViewById49;
        View viewFindViewById50 = findViewById(R.id.editIconTextViewResult);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById50, "findViewById(...)");
        this.editIconTextViewResult = (TextView) viewFindViewById50;
        View viewFindViewById51 = findViewById(R.id.editIconTextViewName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById51, "findViewById(...)");
        this.editIconTextViewName = (TextView) viewFindViewById51;
        View viewFindViewById52 = findViewById(R.id.editIconTextViewDeck);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById52, "findViewById(...)");
        this.editIconTextViewDeck = (TextView) viewFindViewById52;
        View viewFindViewById53 = findViewById(R.id.gpsUserLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById53, "findViewById(...)");
        this.gpsUserLayout = (LinearLayout) viewFindViewById53;
        View viewFindViewById54 = findViewById(R.id.gpsBottomLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById54, "findViewById(...)");
        this.gpsBottomLayout = (LinearLayout) viewFindViewById54;
        this.inAdvanced = false;
        this.inWinLose = false;
        this.inCounters = false;
        this.advancedLayout1.setVisibility(8);
        this.advancedLayout2.setVisibility(8);
        this.advancedLayout3.setVisibility(8);
        this.advancedLayout4.setVisibility(8);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.playmatSets = new PlaymatUtils(context2).getPlaymatSets();
        this.rootList.clear();
        this.currentPlaymatSet = "";
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        new PreferencesManager(context3);
        View viewFindViewById55 = findViewById(R.id.playerNameLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById55, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById55;
        this.playerNameLabel = textView;
        ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SwipeMenuView._init_$lambda$3(this.f$0);
            }
        });
    }

    public /* synthetic */ SwipeMenuView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    static final Unit _init_$lambda$1(SwipeMenuView swipeMenuView) {
        SwipeMenuViewCallback swipeMenuViewCallback = swipeMenuView.callback;
        if (swipeMenuViewCallback != null) {
            swipeMenuViewCallback.leftPicked();
        }
        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$2(SwipeMenuView swipeMenuView) {
        SwipeMenuViewCallback swipeMenuViewCallback = swipeMenuView.callback;
        if (swipeMenuViewCallback != null) {
            swipeMenuViewCallback.rightPicked();
        }
        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$3(SwipeMenuView swipeMenuView) {
        SwipeMenuViewCallback swipeMenuViewCallback = swipeMenuView.callback;
        if (swipeMenuViewCallback != null) {
            swipeMenuViewCallback.editPlayerNameTapped();
        }
        return Unit.INSTANCE;
    }

    private final int dpToPx(int dp, Context context) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    static final Unit enterGamePlayerSummaryMode$lambda$1(SwipeMenuView swipeMenuView, MTDeckData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getDeckImageURL().length() > 0) {
            swipeMenuView.gpsDeckImage.setVisibility(0);
            swipeMenuView.gpsDeckImage.setImageUrl(data.getDeckImageURL());
            swipeMenuView.gpsDeckImage.setAutoLoad(false);
            swipeMenuView.gpsDeckImage.setArtCrop(data.isArtCrop());
            swipeMenuView.gpsDeckImage.loadSingleImage(data.getDeckImageURL());
        } else {
            swipeMenuView.gpsDeckImage.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    static final Unit enterGamePlayerSummaryMode$lambda$2(SwipeMenuView swipeMenuView, String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        swipeMenuView.gpsDeckImage.setVisibility(8);
        return Unit.INSTANCE;
    }

    static final void enterGamePlayerSummaryMode$lambda$3(View view) {
    }

    static final Unit enterGamePlayerSummaryMode$lambda$4(MTUser mTUser, SwipeMenuView swipeMenuView) {
        SwipeMenuViewCallback swipeMenuViewCallback;
        if (mTUser == null && (swipeMenuViewCallback = swipeMenuView.callback) != null) {
            swipeMenuViewCallback.editPlayerNameTapped();
        }
        return Unit.INSTANCE;
    }

    static final Unit enterGamePlayerSummaryMode$lambda$5(SwipeMenuView swipeMenuView, MTUser mTUser) {
        swipeMenuView.profileLayout.setVisibility(8);
        swipeMenuView.playerNameLabel.setVisibility(8);
        swipeMenuView.backgroundImage.setVisibility(8);
        swipeMenuView.winLoseLayout.setVisibility(8);
        swipeMenuView.countersLayout.setVisibility(8);
        swipeMenuView.bkgLayout.setVisibility(8);
        swipeMenuView.advancedLayout.setVisibility(8);
        if (mTUser == null) {
            swipeMenuView.showGuestDeckListForSummary();
        }
        swipeMenuView.decksRecyclerView.setVisibility(0);
        swipeMenuView.gamePlayerSummaryLayout.setVisibility(8);
        return Unit.INSTANCE;
    }

    private final PlaymatSet findSetForPlaymat(String id) {
        Object obj;
        PlaymatSet next;
        Iterator<PlaymatSet> it = this.playmatSets.iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                return null;
            }
            next = it.next();
            Iterator<T> it2 = next.getPlaymats().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                if (Intrinsics.areEqual(((Playmat) next2).getId(), id)) {
                    obj = next2;
                    break;
                }
            }
        } while (((Playmat) obj) == null);
        return next;
    }

    static final void onDeckSelected$lambda$0(SwipeMenuView swipeMenuView) {
        swipeMenuView.decksRecyclerView.setVisibility(8);
        swipeMenuView.gamePlayerSummaryLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouchEvent$lambda$0$0(LinearLayout linearLayout) {
        linearLayout.setVisibility(8);
        linearLayout.setScaleX(1.0f);
        linearLayout.setScaleY(1.0f);
    }

    static final void onTouchEvent$lambda$1(SwipeMenuView swipeMenuView, long j) {
        for (LinearLayout linearLayout : CollectionsKt.listOf((Object[]) new LinearLayout[]{swipeMenuView.advancedLayout1, swipeMenuView.advancedLayout2, swipeMenuView.advancedLayout3, swipeMenuView.advancedLayout4})) {
            linearLayout.setVisibility(0);
            linearLayout.setScaleX(0.0f);
            linearLayout.setScaleY(0.0f);
            linearLayout.animate().scaleX(1.0f).scaleY(1.0f).setDuration(j).setInterpolator(new DecelerateInterpolator()).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouchEvent$lambda$10$0(LinearLayout linearLayout) {
        linearLayout.setVisibility(8);
        linearLayout.setScaleX(1.0f);
        linearLayout.setScaleY(1.0f);
    }

    static final void onTouchEvent$lambda$11(final SwipeMenuView swipeMenuView, long j) {
        for (LinearLayout linearLayout : CollectionsKt.listOf((Object[]) new LinearLayout[]{swipeMenuView.winLoseLayout, swipeMenuView.countersLayout, swipeMenuView.bkgLayout, swipeMenuView.advancedLayout})) {
            linearLayout.setVisibility(0);
            linearLayout.setScaleX(0.0f);
            linearLayout.setScaleY(0.0f);
            linearLayout.animate().scaleX(1.0f).scaleY(1.0f).setDuration(j).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    SwipeMenuView.onTouchEvent$lambda$11$0$0(this.f$0);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouchEvent$lambda$11$0$0(SwipeMenuView swipeMenuView) {
        swipeMenuView.playerNameLabel.setVisibility(0);
        if (swipeMenuView.currentUserId > 0) {
            swipeMenuView.profileLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouchEvent$lambda$12$0(LinearLayout linearLayout) {
        linearLayout.setVisibility(8);
        linearLayout.setScaleX(1.0f);
        linearLayout.setScaleY(1.0f);
    }

    static final void onTouchEvent$lambda$13(final SwipeMenuView swipeMenuView, long j) {
        for (LinearLayout linearLayout : CollectionsKt.listOf((Object[]) new LinearLayout[]{swipeMenuView.winLoseLayout, swipeMenuView.countersLayout, swipeMenuView.bkgLayout, swipeMenuView.advancedLayout})) {
            linearLayout.setVisibility(0);
            linearLayout.setScaleX(0.0f);
            linearLayout.setScaleY(0.0f);
            linearLayout.animate().scaleX(1.0f).scaleY(1.0f).setDuration(j).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    SwipeMenuView.onTouchEvent$lambda$13$0$0(this.f$0);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouchEvent$lambda$13$0$0(SwipeMenuView swipeMenuView) {
        swipeMenuView.playerNameLabel.setVisibility(0);
        if (swipeMenuView.currentUserId > 0) {
            swipeMenuView.profileLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouchEvent$lambda$14$0(LinearLayout linearLayout) {
        linearLayout.setVisibility(8);
        linearLayout.setScaleX(1.0f);
        linearLayout.setScaleY(1.0f);
    }

    static final void onTouchEvent$lambda$15(final SwipeMenuView swipeMenuView, long j) {
        for (LinearLayout linearLayout : CollectionsKt.listOf((Object[]) new LinearLayout[]{swipeMenuView.winLoseLayout, swipeMenuView.countersLayout, swipeMenuView.bkgLayout, swipeMenuView.advancedLayout})) {
            linearLayout.setVisibility(0);
            linearLayout.setScaleX(0.0f);
            linearLayout.setScaleY(0.0f);
            linearLayout.animate().scaleX(1.0f).scaleY(1.0f).setDuration(j).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    SwipeMenuView.onTouchEvent$lambda$15$0$0(this.f$0);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouchEvent$lambda$15$0$0(SwipeMenuView swipeMenuView) {
        swipeMenuView.playerNameLabel.setVisibility(0);
        if (swipeMenuView.currentUserId > 0) {
            swipeMenuView.profileLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouchEvent$lambda$2$0(LinearLayout linearLayout) {
        linearLayout.setVisibility(8);
        linearLayout.setScaleX(1.0f);
        linearLayout.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouchEvent$lambda$4$0(View view) {
        view.setVisibility(8);
        view.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouchEvent$lambda$6$0(LinearLayout linearLayout) {
        linearLayout.setVisibility(8);
        linearLayout.setScaleX(1.0f);
        linearLayout.setScaleY(1.0f);
    }

    static final void onTouchEvent$lambda$7(SwipeMenuView swipeMenuView, long j) {
        for (LinearLayout linearLayout : CollectionsKt.listOf((Object[]) new LinearLayout[]{swipeMenuView.advancedLayout2, swipeMenuView.advancedLayout3})) {
            linearLayout.setVisibility(0);
            linearLayout.setScaleX(0.0f);
            linearLayout.setScaleY(0.0f);
            linearLayout.animate().scaleX(1.0f).scaleY(1.0f).setDuration(j).setInterpolator(new DecelerateInterpolator()).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouchEvent$lambda$8$0(View view) {
        view.setVisibility(8);
        view.setAlpha(1.0f);
    }

    private final void setupAsGrid() {
        RelativeLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout.LayoutParams layoutParams3;
        LinearLayout.LayoutParams layoutParams4;
        LinearLayout.LayoutParams layoutParams5;
        RelativeLayout.LayoutParams layoutParams6;
        LinearLayout.LayoutParams layoutParams7;
        int i = this.internalRotation;
        if (i == 0) {
            ViewGroup.LayoutParams layoutParams8 = this.winLoseLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams8, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) layoutParams8;
            layoutParams9.removeRule(15);
            layoutParams9.removeRule(0);
            layoutParams9.addRule(0, this.centerView.getId());
            layoutParams9.addRule(2, this.centerView.getId());
            this.winLoseLayout.setLayoutParams(layoutParams9);
            ViewGroup.LayoutParams layoutParams10 = this.countersLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams10, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) layoutParams10;
            layoutParams11.removeRule(15);
            layoutParams11.removeRule(0);
            layoutParams11.addRule(1, this.centerView.getId());
            layoutParams11.addRule(2, this.centerView.getId());
            this.countersLayout.setLayoutParams(layoutParams11);
            ViewGroup.LayoutParams layoutParams12 = this.bkgLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams12, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams13 = (RelativeLayout.LayoutParams) layoutParams12;
            layoutParams13.removeRule(15);
            layoutParams13.removeRule(1);
            layoutParams13.addRule(0, this.centerView.getId());
            layoutParams13.addRule(3, this.centerView.getId());
            this.bkgLayout.setLayoutParams(layoutParams13);
            ViewGroup.LayoutParams layoutParams14 = this.advancedLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams14, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams15 = (RelativeLayout.LayoutParams) layoutParams14;
            layoutParams15.removeRule(15);
            layoutParams15.removeRule(1);
            layoutParams15.addRule(1, this.centerView.getId());
            layoutParams15.addRule(3, this.centerView.getId());
            this.advancedLayout.setLayoutParams(layoutParams15);
            ViewGroup.LayoutParams layoutParams16 = this.advancedLayout1.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams16, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams17 = (RelativeLayout.LayoutParams) layoutParams16;
            layoutParams17.removeRule(15);
            layoutParams17.removeRule(0);
            layoutParams17.addRule(0, this.centerView.getId());
            layoutParams17.addRule(2, this.centerView.getId());
            this.advancedLayout1.setLayoutParams(layoutParams17);
            ViewGroup.LayoutParams layoutParams18 = this.advancedLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams18, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams19 = (RelativeLayout.LayoutParams) layoutParams18;
            layoutParams19.removeRule(15);
            layoutParams19.removeRule(0);
            layoutParams19.addRule(1, this.centerView.getId());
            layoutParams19.addRule(2, this.centerView.getId());
            this.advancedLayout2.setLayoutParams(layoutParams19);
            ViewGroup.LayoutParams layoutParams20 = this.advancedLayout3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams20, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams21 = (RelativeLayout.LayoutParams) layoutParams20;
            layoutParams21.removeRule(15);
            layoutParams21.removeRule(1);
            layoutParams21.addRule(0, this.centerView.getId());
            layoutParams21.addRule(3, this.centerView.getId());
            this.advancedLayout3.setLayoutParams(layoutParams21);
            ViewGroup.LayoutParams layoutParams22 = this.advancedLayout4.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams22, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams23 = (RelativeLayout.LayoutParams) layoutParams22;
            layoutParams23.removeRule(15);
            layoutParams23.removeRule(1);
            layoutParams23.addRule(1, this.centerView.getId());
            layoutParams23.addRule(3, this.centerView.getId());
            this.advancedLayout4.setLayoutParams(layoutParams23);
        } else if (i == 90) {
            ViewGroup.LayoutParams layoutParams24 = this.winLoseLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams24, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams25 = (RelativeLayout.LayoutParams) layoutParams24;
            layoutParams25.removeRule(15);
            layoutParams25.removeRule(0);
            layoutParams25.addRule(1, this.centerView.getId());
            layoutParams25.addRule(2, this.centerView.getId());
            this.winLoseLayout.setLayoutParams(layoutParams25);
            ViewGroup.LayoutParams layoutParams26 = this.countersLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams26, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams27 = (RelativeLayout.LayoutParams) layoutParams26;
            layoutParams27.removeRule(15);
            layoutParams27.removeRule(0);
            layoutParams27.addRule(1, this.centerView.getId());
            layoutParams27.addRule(3, this.centerView.getId());
            this.countersLayout.setLayoutParams(layoutParams27);
            ViewGroup.LayoutParams layoutParams28 = this.bkgLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams28, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams29 = (RelativeLayout.LayoutParams) layoutParams28;
            layoutParams29.removeRule(15);
            layoutParams29.removeRule(1);
            layoutParams29.addRule(0, this.centerView.getId());
            layoutParams29.addRule(2, this.centerView.getId());
            this.bkgLayout.setLayoutParams(layoutParams29);
            ViewGroup.LayoutParams layoutParams30 = this.advancedLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams30, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams31 = (RelativeLayout.LayoutParams) layoutParams30;
            layoutParams31.removeRule(15);
            layoutParams31.removeRule(1);
            layoutParams31.addRule(0, this.centerView.getId());
            layoutParams31.addRule(3, this.centerView.getId());
            this.advancedLayout.setLayoutParams(layoutParams31);
            ViewGroup.LayoutParams layoutParams32 = this.advancedLayout1.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams32, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams33 = (RelativeLayout.LayoutParams) layoutParams32;
            layoutParams33.removeRule(15);
            layoutParams33.removeRule(0);
            layoutParams33.addRule(1, this.centerView.getId());
            layoutParams33.addRule(2, this.centerView.getId());
            this.advancedLayout1.setLayoutParams(layoutParams33);
            ViewGroup.LayoutParams layoutParams34 = this.advancedLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams34, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams35 = (RelativeLayout.LayoutParams) layoutParams34;
            layoutParams35.removeRule(15);
            layoutParams35.removeRule(0);
            layoutParams35.addRule(1, this.centerView.getId());
            layoutParams35.addRule(3, this.centerView.getId());
            this.advancedLayout2.setLayoutParams(layoutParams35);
            ViewGroup.LayoutParams layoutParams36 = this.advancedLayout3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams36, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams37 = (RelativeLayout.LayoutParams) layoutParams36;
            layoutParams37.removeRule(15);
            layoutParams37.removeRule(1);
            layoutParams37.addRule(0, this.centerView.getId());
            layoutParams37.addRule(2, this.centerView.getId());
            this.advancedLayout3.setLayoutParams(layoutParams37);
            ViewGroup.LayoutParams layoutParams38 = this.advancedLayout4.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams38, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams39 = (RelativeLayout.LayoutParams) layoutParams38;
            layoutParams39.removeRule(15);
            layoutParams39.removeRule(1);
            layoutParams39.addRule(0, this.centerView.getId());
            layoutParams39.addRule(3, this.centerView.getId());
            this.advancedLayout4.setLayoutParams(layoutParams39);
        } else if (i == 180) {
            ViewGroup.LayoutParams layoutParams40 = this.winLoseLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams40, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams41 = (RelativeLayout.LayoutParams) layoutParams40;
            layoutParams41.removeRule(15);
            layoutParams41.removeRule(0);
            layoutParams41.addRule(1, this.centerView.getId());
            layoutParams41.addRule(3, this.centerView.getId());
            this.winLoseLayout.setLayoutParams(layoutParams41);
            ViewGroup.LayoutParams layoutParams42 = this.countersLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams42, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams43 = (RelativeLayout.LayoutParams) layoutParams42;
            layoutParams43.removeRule(15);
            layoutParams43.removeRule(0);
            layoutParams43.addRule(0, this.centerView.getId());
            layoutParams43.addRule(3, this.centerView.getId());
            this.countersLayout.setLayoutParams(layoutParams43);
            ViewGroup.LayoutParams layoutParams44 = this.bkgLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams44, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams45 = (RelativeLayout.LayoutParams) layoutParams44;
            layoutParams45.removeRule(15);
            layoutParams45.removeRule(1);
            layoutParams45.addRule(1, this.centerView.getId());
            layoutParams45.addRule(2, this.centerView.getId());
            this.bkgLayout.setLayoutParams(layoutParams45);
            ViewGroup.LayoutParams layoutParams46 = this.advancedLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams46, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams47 = (RelativeLayout.LayoutParams) layoutParams46;
            layoutParams47.removeRule(15);
            layoutParams47.removeRule(1);
            layoutParams47.addRule(0, this.centerView.getId());
            layoutParams47.addRule(2, this.centerView.getId());
            this.advancedLayout.setLayoutParams(layoutParams47);
            ViewGroup.LayoutParams layoutParams48 = this.advancedLayout1.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams48, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams49 = (RelativeLayout.LayoutParams) layoutParams48;
            layoutParams49.removeRule(15);
            layoutParams49.removeRule(0);
            layoutParams49.addRule(1, this.centerView.getId());
            layoutParams49.addRule(3, this.centerView.getId());
            this.advancedLayout1.setLayoutParams(layoutParams49);
            ViewGroup.LayoutParams layoutParams50 = this.advancedLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams50, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams51 = (RelativeLayout.LayoutParams) layoutParams50;
            layoutParams51.removeRule(15);
            layoutParams51.removeRule(0);
            layoutParams51.addRule(0, this.centerView.getId());
            layoutParams51.addRule(3, this.centerView.getId());
            this.advancedLayout2.setLayoutParams(layoutParams51);
            ViewGroup.LayoutParams layoutParams52 = this.advancedLayout3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams52, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams53 = (RelativeLayout.LayoutParams) layoutParams52;
            layoutParams53.removeRule(15);
            layoutParams53.removeRule(1);
            layoutParams53.addRule(1, this.centerView.getId());
            layoutParams53.addRule(2, this.centerView.getId());
            this.advancedLayout3.setLayoutParams(layoutParams53);
            ViewGroup.LayoutParams layoutParams54 = this.advancedLayout4.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams54, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams55 = (RelativeLayout.LayoutParams) layoutParams54;
            layoutParams55.removeRule(15);
            layoutParams55.removeRule(1);
            layoutParams55.addRule(0, this.centerView.getId());
            layoutParams55.addRule(2, this.centerView.getId());
            this.advancedLayout4.setLayoutParams(layoutParams55);
        } else if (i == 270) {
            ViewGroup.LayoutParams layoutParams56 = this.winLoseLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams56, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams57 = (RelativeLayout.LayoutParams) layoutParams56;
            layoutParams57.removeRule(15);
            layoutParams57.removeRule(0);
            layoutParams57.addRule(0, this.centerView.getId());
            layoutParams57.addRule(3, this.centerView.getId());
            this.winLoseLayout.setLayoutParams(layoutParams57);
            ViewGroup.LayoutParams layoutParams58 = this.countersLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams58, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams59 = (RelativeLayout.LayoutParams) layoutParams58;
            layoutParams59.removeRule(15);
            layoutParams59.removeRule(0);
            layoutParams59.addRule(0, this.centerView.getId());
            layoutParams59.addRule(2, this.centerView.getId());
            this.countersLayout.setLayoutParams(layoutParams59);
            ViewGroup.LayoutParams layoutParams60 = this.bkgLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams60, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams61 = (RelativeLayout.LayoutParams) layoutParams60;
            layoutParams61.removeRule(15);
            layoutParams61.removeRule(1);
            layoutParams61.addRule(1, this.centerView.getId());
            layoutParams61.addRule(3, this.centerView.getId());
            this.bkgLayout.setLayoutParams(layoutParams61);
            ViewGroup.LayoutParams layoutParams62 = this.advancedLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams62, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams63 = (RelativeLayout.LayoutParams) layoutParams62;
            layoutParams63.removeRule(15);
            layoutParams63.removeRule(1);
            layoutParams63.addRule(1, this.centerView.getId());
            layoutParams63.addRule(2, this.centerView.getId());
            this.advancedLayout.setLayoutParams(layoutParams63);
            ViewGroup.LayoutParams layoutParams64 = this.advancedLayout1.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams64, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams65 = (RelativeLayout.LayoutParams) layoutParams64;
            layoutParams65.removeRule(15);
            layoutParams65.removeRule(0);
            layoutParams65.addRule(0, this.centerView.getId());
            layoutParams65.addRule(3, this.centerView.getId());
            this.advancedLayout1.setLayoutParams(layoutParams65);
            ViewGroup.LayoutParams layoutParams66 = this.advancedLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams66, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams67 = (RelativeLayout.LayoutParams) layoutParams66;
            layoutParams67.removeRule(15);
            layoutParams67.removeRule(0);
            layoutParams67.addRule(0, this.centerView.getId());
            layoutParams67.addRule(2, this.centerView.getId());
            this.advancedLayout2.setLayoutParams(layoutParams67);
            ViewGroup.LayoutParams layoutParams68 = this.advancedLayout3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams68, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams69 = (RelativeLayout.LayoutParams) layoutParams68;
            layoutParams69.removeRule(15);
            layoutParams69.removeRule(1);
            layoutParams69.addRule(1, this.centerView.getId());
            layoutParams69.addRule(3, this.centerView.getId());
            this.advancedLayout3.setLayoutParams(layoutParams69);
            ViewGroup.LayoutParams layoutParams70 = this.advancedLayout4.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams70, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams71 = (RelativeLayout.LayoutParams) layoutParams70;
            layoutParams71.removeRule(15);
            layoutParams71.removeRule(1);
            layoutParams71.addRule(1, this.centerView.getId());
            layoutParams71.addRule(2, this.centerView.getId());
            this.advancedLayout4.setLayoutParams(layoutParams71);
        }
        ViewGroup.LayoutParams layoutParams72 = this.winLoseLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams72, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams73 = (RelativeLayout.LayoutParams) layoutParams72;
        ViewGroup.LayoutParams layoutParams74 = this.countersLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams74, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams75 = (RelativeLayout.LayoutParams) layoutParams74;
        ViewGroup.LayoutParams layoutParams76 = this.bkgLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams76, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams77 = (RelativeLayout.LayoutParams) layoutParams76;
        ViewGroup.LayoutParams layoutParams78 = this.advancedLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams78, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams79 = (RelativeLayout.LayoutParams) layoutParams78;
        ViewGroup.LayoutParams layoutParams80 = this.advancedLayout1.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams80, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams81 = (RelativeLayout.LayoutParams) layoutParams80;
        ViewGroup.LayoutParams layoutParams82 = this.advancedLayout2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams82, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams83 = (RelativeLayout.LayoutParams) layoutParams82;
        ViewGroup.LayoutParams layoutParams84 = this.advancedLayout3.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams84, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams85 = (RelativeLayout.LayoutParams) layoutParams84;
        ViewGroup.LayoutParams layoutParams86 = this.advancedLayout4.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams86, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams87 = (RelativeLayout.LayoutParams) layoutParams86;
        ViewGroup.LayoutParams layoutParams88 = this.winLoseImage.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams88, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams89 = (LinearLayout.LayoutParams) layoutParams88;
        ViewGroup.LayoutParams layoutParams90 = this.countersImage.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams90, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams91 = (LinearLayout.LayoutParams) layoutParams90;
        ViewGroup.LayoutParams layoutParams92 = this.bkgImage.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams92, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams93 = (LinearLayout.LayoutParams) layoutParams92;
        ViewGroup.LayoutParams layoutParams94 = this.advancedImage.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams94, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams95 = (LinearLayout.LayoutParams) layoutParams94;
        ViewGroup.LayoutParams layoutParams96 = this.advancedImage1.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams96, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams97 = (LinearLayout.LayoutParams) layoutParams96;
        ViewGroup.LayoutParams layoutParams98 = this.advancedImage2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams98, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams99 = (LinearLayout.LayoutParams) layoutParams98;
        ViewGroup.LayoutParams layoutParams100 = this.advancedImage3.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams100, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams101 = (LinearLayout.LayoutParams) layoutParams100;
        ViewGroup.LayoutParams layoutParams102 = this.advancedImage4.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams102, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams103 = (LinearLayout.LayoutParams) layoutParams102;
        int iMin = Math.min(getWidth(), getHeight());
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (iMin < dpToPx(140, context)) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            layoutParams73.width = dpToPx(62, context2);
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            layoutParams73.height = dpToPx(62, context3);
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            layoutParams75.width = dpToPx(62, context4);
            Context context5 = getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
            layoutParams75.height = dpToPx(62, context5);
            Context context6 = getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
            layoutParams77.width = dpToPx(62, context6);
            Context context7 = getContext();
            Intrinsics.checkNotNullExpressionValue(context7, "getContext(...)");
            layoutParams77.height = dpToPx(62, context7);
            Context context8 = getContext();
            Intrinsics.checkNotNullExpressionValue(context8, "getContext(...)");
            layoutParams79.width = dpToPx(62, context8);
            Context context9 = getContext();
            Intrinsics.checkNotNullExpressionValue(context9, "getContext(...)");
            layoutParams79.height = dpToPx(62, context9);
            Context context10 = getContext();
            Intrinsics.checkNotNullExpressionValue(context10, "getContext(...)");
            layoutParams83.width = dpToPx(62, context10);
            Context context11 = getContext();
            Intrinsics.checkNotNullExpressionValue(context11, "getContext(...)");
            layoutParams83.height = dpToPx(62, context11);
            Context context12 = getContext();
            Intrinsics.checkNotNullExpressionValue(context12, "getContext(...)");
            layoutParams85.width = dpToPx(62, context12);
            Context context13 = getContext();
            Intrinsics.checkNotNullExpressionValue(context13, "getContext(...)");
            layoutParams85.height = dpToPx(62, context13);
            Context context14 = getContext();
            Intrinsics.checkNotNullExpressionValue(context14, "getContext(...)");
            layoutParams81.width = dpToPx(62, context14);
            Context context15 = getContext();
            Intrinsics.checkNotNullExpressionValue(context15, "getContext(...)");
            layoutParams81.height = dpToPx(62, context15);
            Context context16 = getContext();
            Intrinsics.checkNotNullExpressionValue(context16, "getContext(...)");
            layoutParams87.width = dpToPx(62, context16);
            Context context17 = getContext();
            Intrinsics.checkNotNullExpressionValue(context17, "getContext(...)");
            layoutParams87.height = dpToPx(62, context17);
            Context context18 = getContext();
            Intrinsics.checkNotNullExpressionValue(context18, "getContext(...)");
            layoutParams89.width = dpToPx(38, context18);
            Context context19 = getContext();
            Intrinsics.checkNotNullExpressionValue(context19, "getContext(...)");
            layoutParams89.height = dpToPx(38, context19);
            Context context20 = getContext();
            Intrinsics.checkNotNullExpressionValue(context20, "getContext(...)");
            layoutParams91.width = dpToPx(38, context20);
            Context context21 = getContext();
            Intrinsics.checkNotNullExpressionValue(context21, "getContext(...)");
            layoutParams91.height = dpToPx(38, context21);
            Context context22 = getContext();
            Intrinsics.checkNotNullExpressionValue(context22, "getContext(...)");
            layoutParams93.width = dpToPx(38, context22);
            Context context23 = getContext();
            Intrinsics.checkNotNullExpressionValue(context23, "getContext(...)");
            layoutParams93.height = dpToPx(38, context23);
            Context context24 = getContext();
            Intrinsics.checkNotNullExpressionValue(context24, "getContext(...)");
            layoutParams5 = layoutParams95;
            layoutParams5.width = dpToPx(38, context24);
            Context context25 = getContext();
            Intrinsics.checkNotNullExpressionValue(context25, "getContext(...)");
            layoutParams5.height = dpToPx(38, context25);
            Context context26 = getContext();
            Intrinsics.checkNotNullExpressionValue(context26, "getContext(...)");
            layoutParams4 = layoutParams97;
            layoutParams4.width = dpToPx(38, context26);
            Context context27 = getContext();
            Intrinsics.checkNotNullExpressionValue(context27, "getContext(...)");
            layoutParams6 = layoutParams73;
            layoutParams4.height = dpToPx(38, context27);
            Context context28 = getContext();
            Intrinsics.checkNotNullExpressionValue(context28, "getContext(...)");
            layoutParams99.width = dpToPx(38, context28);
            Context context29 = getContext();
            Intrinsics.checkNotNullExpressionValue(context29, "getContext(...)");
            layoutParams = layoutParams75;
            layoutParams99.height = dpToPx(38, context29);
            Context context30 = getContext();
            Intrinsics.checkNotNullExpressionValue(context30, "getContext(...)");
            layoutParams2 = layoutParams101;
            layoutParams2.width = dpToPx(38, context30);
            Context context31 = getContext();
            Intrinsics.checkNotNullExpressionValue(context31, "getContext(...)");
            layoutParams3 = layoutParams99;
            layoutParams2.height = dpToPx(38, context31);
            Context context32 = getContext();
            Intrinsics.checkNotNullExpressionValue(context32, "getContext(...)");
            layoutParams7 = layoutParams103;
            layoutParams7.width = dpToPx(38, context32);
            Context context33 = getContext();
            Intrinsics.checkNotNullExpressionValue(context33, "getContext(...)");
            layoutParams7.height = dpToPx(38, context33);
        } else {
            layoutParams = layoutParams75;
            layoutParams2 = layoutParams101;
            layoutParams3 = layoutParams99;
            layoutParams4 = layoutParams97;
            layoutParams5 = layoutParams95;
            layoutParams6 = layoutParams73;
            layoutParams7 = layoutParams103;
        }
        this.winLoseLayout.setLayoutParams(layoutParams6);
        this.countersLayout.setLayoutParams(layoutParams);
        this.bkgLayout.setLayoutParams(layoutParams77);
        this.advancedLayout.setLayoutParams(layoutParams79);
        this.advancedLayout1.setLayoutParams(layoutParams81);
        this.advancedLayout2.setLayoutParams(layoutParams83);
        this.advancedLayout3.setLayoutParams(layoutParams85);
        this.advancedLayout4.setLayoutParams(layoutParams87);
        this.winLoseImage.setLayoutParams(layoutParams89);
        this.countersImage.setLayoutParams(layoutParams91);
        this.bkgImage.setLayoutParams(layoutParams93);
        this.advancedImage.setLayoutParams(layoutParams5);
        this.advancedImage1.setLayoutParams(layoutParams4);
        this.advancedImage2.setLayoutParams(layoutParams3);
        this.advancedImage3.setLayoutParams(layoutParams2);
        this.advancedImage4.setLayoutParams(layoutParams7);
        requestLayout();
    }

    private final void showFriendDeckList(MTFriend friend) {
        this.deckBrowsingState = DeckBrowsingState.FRIEND_DECKS;
        this.selectedFriendForDecks = friend;
        this.loadingOverlay.setVisibility(0);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(context);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            MTApiKt.getMtApi().getUserDecks(currentUser.getId(), friend.getId()).enqueue(new Callback<MTDecksResponse>() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$showFriendDeckList$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDecksResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.isAttachedToWindow()) {
                        this.this$0.loadingOverlay.setVisibility(8);
                        this.this$0.showFriendSelectionForDecks();
                    }
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDecksResponse> call, Response<MTDecksResponse> response) {
                    List<MTDeck> listEmptyList;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.isAttachedToWindow()) {
                        if (response.isSuccessful()) {
                            MTDecksResponse mTDecksResponseBody = response.body();
                            if (mTDecksResponseBody == null || (listEmptyList = mTDecksResponseBody.getDecks()) == null) {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
                            Context context2 = this.this$0.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                            List<MTFormat> formats = companion.getInstance(context2).getFormats();
                            MTGDBHelper.Companion companion2 = MTGDBHelper.INSTANCE;
                            Context context3 = this.this$0.getContext();
                            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                            MTGDBHelper companion3 = companion2.getInstance(context3);
                            ArrayList arrayList = new ArrayList();
                            for (String str : preferencesManager.getEnabledLanguages()) {
                                if (!Intrinsics.areEqual(str, "en")) {
                                    MTGDBHelperLocalized.Companion companion4 = MTGDBHelperLocalized.INSTANCE;
                                    Context context4 = this.this$0.getContext();
                                    Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                                    arrayList.add(companion4.getInstance(context4, str));
                                }
                            }
                            final SwipeMenuView swipeMenuView = this.this$0;
                            final Comparator comparator = new Comparator() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$showFriendDeckList$1$1$onResponse$$inlined$compareBy$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t, T t2) {
                                    return ComparisonsKt.compareValues(Boolean.valueOf(((MTDeck) t).getFormatid() != swipeMenuView.currentFormatId), Boolean.valueOf(((MTDeck) t2).getFormatid() != swipeMenuView.currentFormatId));
                                }
                            };
                            SimpleDecksAdapter simpleDecksAdapter = new SimpleDecksAdapter(CollectionsKt.sortedWith(listEmptyList, new Comparator() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$showFriendDeckList$1$1$onResponse$$inlined$thenBy$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t, T t2) {
                                    int iCompare = comparator.compare(t, t2);
                                    if (iCompare != 0) {
                                        return iCompare;
                                    }
                                    String lowerCase = ((MTDeck) t).getName().toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    String lowerCase2 = ((MTDeck) t2).getName().toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                    return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                                }
                            }), this.this$0.currentFormatId, formats, companion3, arrayList, this.this$0.internalRotation, this.this$0, false, true, false, Imgcodecs.IMWRITE_JPEGXL_QUALITY, null);
                            this.this$0.currentDecksAdapter = simpleDecksAdapter;
                            this.this$0.decksRecyclerView.setAdapter(simpleDecksAdapter);
                        } else {
                            this.this$0.showFriendSelectionForDecks();
                        }
                        this.this$0.loadingOverlay.setVisibility(8);
                    }
                }
            });
        } else {
            this.loadingOverlay.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0179  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void showFriendSelectionForDecks() {
        this.deckBrowsingState = DeckBrowsingState.FRIEND_SELECTION;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(context);
        ArrayList arrayList = new ArrayList();
        if (this.playgroupGameUsers.isEmpty()) {
            List<MTUser> gameParticipantUsers = GameUtils.INSTANCE.getInstance().getGameParticipantUsers();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : gameParticipantUsers) {
                if (((MTUser) obj).getId() != this.currentUserId) {
                    arrayList2.add(obj);
                }
            }
            ArrayList<MTUser> arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            for (MTUser mTUser : arrayList3) {
                int id = mTUser.getId();
                String firstname = mTUser.getFirstname();
                if (firstname == null) {
                    firstname = "";
                }
                String email = mTUser.getEmail();
                String username = mTUser.getUsername();
                if (username == null) {
                    username = "";
                }
                arrayList4.add(new MTFriend(id, firstname, email, username, mTUser.getPicture(), null, false, false, WebmConstants.MkvEbmlElement.VIDEO, null));
            }
            arrayList.addAll(arrayList4);
        } else {
            List<MTUser> list = this.playgroupGameUsers;
            ArrayList arrayList5 = new ArrayList();
            for (Object obj2 : list) {
                if (((MTUser) obj2).getId() != this.currentUserId) {
                    arrayList5.add(obj2);
                }
            }
            ArrayList<MTUser> arrayList6 = arrayList5;
            ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
            for (MTUser mTUser2 : arrayList6) {
                int id2 = mTUser2.getId();
                String firstname2 = mTUser2.getFirstname();
                if (firstname2 == null) {
                    firstname2 = "";
                }
                String email2 = mTUser2.getEmail();
                String username2 = mTUser2.getUsername();
                if (username2 == null) {
                    username2 = "";
                }
                arrayList7.add(new MTFriend(id2, firstname2, email2, username2, mTUser2.getPicture(), null, false, false, WebmConstants.MkvEbmlElement.VIDEO, null));
            }
            arrayList.addAll(arrayList7);
        }
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null && currentUser.getId() != this.currentUserId) {
            ArrayList arrayList8 = arrayList;
            if ((arrayList8 instanceof Collection) && arrayList8.isEmpty()) {
                int id3 = currentUser.getId();
                String firstname3 = currentUser.getFirstname();
                if (firstname3 != null) {
                }
                String email3 = currentUser.getEmail();
                String username3 = currentUser.getUsername();
                arrayList.add(0, new MTFriend(id3, str, email3, username3 != null ? "" : username3, currentUser.getPicture(), null, false, false, WebmConstants.MkvEbmlElement.VIDEO, null));
            } else {
                Iterator it = arrayList8.iterator();
                while (it.hasNext()) {
                    if (((MTFriend) it.next()).getId() == currentUser.getId()) {
                        break;
                    }
                }
                int id32 = currentUser.getId();
                String firstname32 = currentUser.getFirstname();
                String str = firstname32 != null ? "" : firstname32;
                String email32 = currentUser.getEmail();
                String username32 = currentUser.getUsername();
                arrayList.add(0, new MTFriend(id32, str, email32, username32 != null ? "" : username32, currentUser.getPicture(), null, false, false, WebmConstants.MkvEbmlElement.VIDEO, null));
            }
        }
        this.decksRecyclerView.setAdapter(new MythicUsersAdapter(arrayList, this.internalRotation, this, false));
    }

    private final void showGuestDeckListForSummary() {
        this.deckBrowsingState = DeckBrowsingState.OWN_DECKS;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(context);
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        List<MTFormat> formats = companion.getInstance(context2).getFormats();
        MTGDBHelper.Companion companion2 = MTGDBHelper.INSTANCE;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        MTGDBHelper companion3 = companion2.getInstance(context3);
        ArrayList arrayList = new ArrayList();
        for (String str : preferencesManager.getEnabledLanguages()) {
            if (!Intrinsics.areEqual(str, "en")) {
                MTGDBHelperLocalized.Companion companion4 = MTGDBHelperLocalized.INSTANCE;
                Context context4 = getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                arrayList.add(companion4.getInstance(context4, str));
            }
        }
        SimpleDecksAdapter simpleDecksAdapter = new SimpleDecksAdapter(CollectionsKt.emptyList(), this.currentFormatId, formats, companion3, arrayList, this.internalRotation, this, true, false, true, 256, null);
        this.currentDecksAdapter = simpleDecksAdapter;
        this.decksRecyclerView.setAdapter(simpleDecksAdapter);
    }

    private final void showOwnDeckList() {
        MTUser currentUser;
        this.deckBrowsingState = DeckBrowsingState.OWN_DECKS;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(context);
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        List<MTFormat> formats = companion.getInstance(context2).getFormats();
        MTGDBHelper.Companion companion2 = MTGDBHelper.INSTANCE;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        MTGDBHelper companion3 = companion2.getInstance(context3);
        ArrayList arrayList = new ArrayList();
        for (String str : preferencesManager.getEnabledLanguages()) {
            if (!Intrinsics.areEqual(str, "en")) {
                MTGDBHelperLocalized.Companion companion4 = MTGDBHelperLocalized.INSTANCE;
                Context context4 = getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                arrayList.add(companion4.getInstance(context4, str));
            }
        }
        List<MTDeck> currentUserDecks = preferencesManager.getAllUsersDecks().get(Integer.valueOf(this.currentUserId));
        if (currentUserDecks == null) {
            currentUserDecks = CollectionsKt.emptyList();
        }
        if (currentUserDecks.isEmpty() && (currentUser = preferencesManager.getCurrentUser()) != null && currentUser.getId() == this.currentUserId) {
            currentUserDecks = preferencesManager.getCurrentUserDecks();
        }
        final Comparator comparator = new Comparator() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$showOwnDeckList$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Boolean.valueOf(((MTDeck) t).getFormatid() != this.this$0.currentFormatId), Boolean.valueOf(((MTDeck) t2).getFormatid() != this.this$0.currentFormatId));
            }
        };
        SimpleDecksAdapter simpleDecksAdapter = new SimpleDecksAdapter(CollectionsKt.sortedWith(currentUserDecks, new Comparator() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$showOwnDeckList$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                if (iCompare != 0) {
                    return iCompare;
                }
                String lowerCase = ((MTDeck) t).getName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = ((MTDeck) t2).getName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                return ComparisonsKt.compareValues(lowerCase, lowerCase2);
            }
        }), this.currentFormatId, formats, companion3, arrayList, this.internalRotation, this, preferencesManager.getCurrentUser() != null, false, false, 768, null);
        this.currentDecksAdapter = simpleDecksAdapter;
        this.decksRecyclerView.setAdapter(simpleDecksAdapter);
    }

    static final Unit updateGamePlayerSummaryDeck$lambda$2(SwipeMenuView swipeMenuView, MTDeckData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getDeckImageURL().length() > 0) {
            swipeMenuView.gpsDeckImage.setVisibility(0);
            swipeMenuView.gpsDeckImage.setImageUrl(data.getDeckImageURL());
            swipeMenuView.gpsDeckImage.setAutoLoad(false);
            swipeMenuView.gpsDeckImage.setArtCrop(data.isArtCrop());
            swipeMenuView.gpsDeckImage.loadSingleImage(data.getDeckImageURL());
        } else {
            swipeMenuView.gpsDeckImage.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    static final Unit updateGamePlayerSummaryDeck$lambda$3(SwipeMenuView swipeMenuView, String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        swipeMenuView.gpsDeckImage.setVisibility(8);
        return Unit.INSTANCE;
    }

    public final void cardPicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.leftRightLayout.setVisibility(0);
    }

    public final void colorPicked(String color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.leftRightLayout.setVisibility(0);
    }

    public final void enterGamePlayerSummaryMode(PlayerResultItem playerResult) {
        Intrinsics.checkNotNullParameter(playerResult, "playerResult");
        this.disableSwipe = true;
        this.gamePlayerSummaryMode = true;
        this.gamePlayerSummaryUser = playerResult.getUser();
        Player player = playerResult.getPlayer();
        final MTUser user = playerResult.getUser();
        MTDeck deck = playerResult.getDeck();
        this.gpsRootLineLayout.setClipToOutline(true);
        this.gpsRootLineLayout.setClipChildren(true);
        this.profileIconSummary.setOutlineProvider(new CircularOutlineProvider());
        this.profileIconSummary.setClipToOutline(true);
        this.editIconTextViewName.setVisibility(0);
        TextView textView = this.firstnameTextView;
        if (user != null) {
            String firstname = user.getFirstname();
            textView.setText(firstname != null ? firstname : player.getName());
            String username = user.getUsername();
            if (username == null || username.length() == 0) {
                this.usernameTextView.setVisibility(8);
            } else {
                this.usernameTextView.setText("(@" + user.getUsername() + ")");
                this.usernameTextView.setVisibility(0);
            }
            this.editIconTextViewName.setVisibility(8);
            String picture = user.getPicture();
            String str = picture;
            if (str == null || str.length() == 0) {
                this.profileIconSummary.setVisibility(4);
                this.noPhotoIconSummary.setVisibility(0);
            } else {
                this.profileIconSummary.setVisibility(0);
                this.noPhotoIconSummary.setVisibility(4);
                this.profileIconSummary.setAutoLoad(false);
                this.profileIconSummary.reset();
                this.profileIconSummary.loadImage(picture);
            }
        } else {
            String name = player.getName();
            if (name.length() == 0) {
                name = "Guest";
            }
            textView.setText(name);
            this.usernameTextView.setVisibility(8);
            this.profileIconSummary.setVisibility(4);
            this.noPhotoIconSummary.setVisibility(0);
        }
        int resultId = playerResult.getResultId();
        if (resultId == 0) {
            this.resultTextView.setText(getContext().getString(R.string.lose));
            this.gpsTopLayout.setBackgroundResource(R.drawable.custom_loser_background);
        } else if (resultId == 1) {
            this.resultTextView.setText(getContext().getString(R.string.win));
            this.gpsTopLayout.setBackgroundResource(R.drawable.custom_winner_background);
        } else if (resultId != 2) {
            TextView textView2 = this.resultTextView;
            if (resultId != 3) {
                textView2.setText(getContext().getString(R.string.lose));
                this.gpsTopLayout.setBackgroundResource(R.drawable.custom_loser_background);
            } else {
                textView2.setText(getContext().getString(R.string.draw));
                this.gpsTopLayout.setBackgroundResource(R.drawable.custom_draw_background);
            }
        } else {
            this.resultTextView.setText(getContext().getString(R.string.conceded));
            this.gpsTopLayout.setBackgroundResource(R.drawable.custom_loser_background);
        }
        this.deckName.setText("");
        this.gpsDeckImage.setScaleX(-1.0f);
        if (deck != null) {
            this.deckName.setText(deck.getName());
            this.deckName.setTextColor(getContext().getColor(R.color.selected_color_new));
            DeckUtils companion = DeckUtils.INSTANCE.getInstance();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            companion.fetchDeckData(context, deck, new Function1() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SwipeMenuView.enterGamePlayerSummaryMode$lambda$1(this.f$0, (MTDeckData) obj);
                }
            }, new Function1() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SwipeMenuView.enterGamePlayerSummaryMode$lambda$2(this.f$0, (String) obj);
                }
            });
        } else {
            this.gpsDeckImage.setVisibility(8);
            this.deckName.setTextColor(getContext().getColor(R.color.text_color));
            this.deckName.setText(getContext().getString(R.string.no_deck_selected));
        }
        this.gamePlayerSummaryLayout.setVisibility(0);
        this.gamePlayerSummaryLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SwipeMenuView.enterGamePlayerSummaryMode$lambda$3(view);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(this.gpsUserLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SwipeMenuView.enterGamePlayerSummaryMode$lambda$4(user, this);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(this.gpsBottomLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SwipeMenuView.enterGamePlayerSummaryMode$lambda$5(this.f$0, user);
            }
        });
    }

    public final SwipeMenuViewCallback getCallback() {
        return this.callback;
    }

    public final boolean getDisableDeckAndAdvanced() {
        return this.disableDeckAndAdvanced;
    }

    public final List<MTUser> getPlaygroupGameUsers() {
        return this.playgroupGameUsers;
    }

    public final ActivityResultLauncher<Intent> getPurchaseLauncher() {
        return this.purchaseLauncher;
    }

    @Override // com.studiolaganne.lengendarylens.SimpleDeckClickListener
    public void onBackFromDecksSelected() {
        if (isAttachedToWindow()) {
            if (this.deckBrowsingState == DeckBrowsingState.FRIEND_DECKS) {
                showFriendSelectionForDecks();
                return;
            }
            this.deckBrowsingState = DeckBrowsingState.OWN_DECKS;
            this.selectedFriendForDecks = null;
            if (this.gamePlayerSummaryMode) {
                this.decksRecyclerView.setVisibility(8);
                this.gamePlayerSummaryLayout.setVisibility(0);
                return;
            }
            this.winLoseLayout.setVisibility(0);
            this.countersLayout.setVisibility(0);
            this.bkgLayout.setVisibility(0);
            this.advancedLayout.setVisibility(0);
            this.playerNameLabel.setVisibility(0);
            if (this.currentUserId > 0) {
                this.profileLayout.setVisibility(0);
            }
            this.inAdvanced = false;
            this.advancedLayout2.setVisibility(8);
            this.advancedLayout3.setVisibility(8);
            this.decksRecyclerView.setVisibility(8);
            this.countersRecyclerView.setVisibility(8);
        }
    }

    @Override // com.studiolaganne.lengendarylens.MythicUserClickListener
    public void onBackFromMythicUsersSelected() {
        if (this.deckBrowsingState == DeckBrowsingState.FRIEND_SELECTION) {
            showOwnDeckList();
        }
    }

    @Override // com.studiolaganne.lengendarylens.SwipePlaymatClickListener
    public void onBackTapped() {
        if (isAttachedToWindow()) {
            Breadcrumbs.INSTANCE.leaveBreadcrumb("swipe_menu_back_tapped");
            if (this.currentPlaymatSet.length() != 0) {
                SwipePlaymatAdapter swipePlaymatAdapter = new SwipePlaymatAdapter(this.internalRotation, this.rootList, "", this);
                this.playmatRecyclerView.setAdapter(swipePlaymatAdapter);
                this.currentPlaymatAdapter = swipePlaymatAdapter;
                this.currentPlaymatSet = "";
                return;
            }
            this.winLoseLayout.setVisibility(0);
            this.countersLayout.setVisibility(0);
            this.bkgLayout.setVisibility(0);
            this.advancedLayout.setVisibility(0);
            this.playerNameLabel.setVisibility(0);
            if (this.currentUserId > 0) {
                this.profileLayout.setVisibility(0);
            }
            this.advancedLayout2.setVisibility(8);
            this.advancedLayout3.setVisibility(8);
            this.playmatRecyclerView.setVisibility(8);
        }
    }

    @Override // com.studiolaganne.lengendarylens.SwipePlaymatClickListener
    public void onCardScanTapped() {
        Breadcrumbs.INSTANCE.leaveBreadcrumb("swipe_menu_scan_tapped");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(getContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("swipe_scan_card_tapped", null);
        SwipeMenuViewCallback swipeMenuViewCallback = this.callback;
        if (swipeMenuViewCallback != null) {
            swipeMenuViewCallback.pickACardTapped();
        }
    }

    @Override // com.studiolaganne.lengendarylens.SwipeCountersClickListener
    public void onCounterToggled(CounterType id) {
        Intrinsics.checkNotNullParameter(id, "id");
        switch (WhenMappings.$EnumSwitchMapping$0[id.ordinal()]) {
            case 1:
                if (this.poison) {
                    this.poison = false;
                    SwipeCountersAdapter swipeCountersAdapter = this.currentCountersAdapter;
                    if (swipeCountersAdapter != null) {
                        swipeCountersAdapter.setPoison(false);
                    }
                    SwipeMenuViewCallback swipeMenuViewCallback = this.callback;
                    if (swipeMenuViewCallback != null) {
                        swipeMenuViewCallback.poisonToggled(false);
                        return;
                    }
                    return;
                }
                this.poison = true;
                SwipeCountersAdapter swipeCountersAdapter2 = this.currentCountersAdapter;
                if (swipeCountersAdapter2 != null) {
                    swipeCountersAdapter2.setPoison(true);
                }
                SwipeMenuViewCallback swipeMenuViewCallback2 = this.callback;
                if (swipeMenuViewCallback2 != null) {
                    swipeMenuViewCallback2.poisonToggled(true);
                    return;
                }
                return;
            case 2:
                if (this.energy) {
                    this.energy = false;
                    SwipeCountersAdapter swipeCountersAdapter3 = this.currentCountersAdapter;
                    if (swipeCountersAdapter3 != null) {
                        swipeCountersAdapter3.setEnergy(false);
                    }
                    SwipeMenuViewCallback swipeMenuViewCallback3 = this.callback;
                    if (swipeMenuViewCallback3 != null) {
                        swipeMenuViewCallback3.energyToggled(false);
                        return;
                    }
                    return;
                }
                this.energy = true;
                SwipeCountersAdapter swipeCountersAdapter4 = this.currentCountersAdapter;
                if (swipeCountersAdapter4 != null) {
                    swipeCountersAdapter4.setEnergy(true);
                }
                SwipeMenuViewCallback swipeMenuViewCallback4 = this.callback;
                if (swipeMenuViewCallback4 != null) {
                    swipeMenuViewCallback4.energyToggled(true);
                    return;
                }
                return;
            case 3:
                if (this.storm) {
                    this.storm = false;
                    SwipeCountersAdapter swipeCountersAdapter5 = this.currentCountersAdapter;
                    if (swipeCountersAdapter5 != null) {
                        swipeCountersAdapter5.setStorm(false);
                    }
                    SwipeMenuViewCallback swipeMenuViewCallback5 = this.callback;
                    if (swipeMenuViewCallback5 != null) {
                        swipeMenuViewCallback5.stormToggled(false);
                        return;
                    }
                    return;
                }
                this.storm = true;
                SwipeCountersAdapter swipeCountersAdapter6 = this.currentCountersAdapter;
                if (swipeCountersAdapter6 != null) {
                    swipeCountersAdapter6.setStorm(true);
                }
                SwipeMenuViewCallback swipeMenuViewCallback6 = this.callback;
                if (swipeMenuViewCallback6 != null) {
                    swipeMenuViewCallback6.stormToggled(true);
                    return;
                }
                return;
            case 4:
                if (this.experience) {
                    this.experience = false;
                    SwipeCountersAdapter swipeCountersAdapter7 = this.currentCountersAdapter;
                    if (swipeCountersAdapter7 != null) {
                        swipeCountersAdapter7.setExperience(false);
                    }
                    SwipeMenuViewCallback swipeMenuViewCallback7 = this.callback;
                    if (swipeMenuViewCallback7 != null) {
                        swipeMenuViewCallback7.experienceToggled(false);
                        return;
                    }
                    return;
                }
                this.experience = true;
                SwipeCountersAdapter swipeCountersAdapter8 = this.currentCountersAdapter;
                if (swipeCountersAdapter8 != null) {
                    swipeCountersAdapter8.setExperience(true);
                }
                SwipeMenuViewCallback swipeMenuViewCallback8 = this.callback;
                if (swipeMenuViewCallback8 != null) {
                    swipeMenuViewCallback8.experienceToggled(true);
                    return;
                }
                return;
            case 5:
                if (this.tax) {
                    this.tax = false;
                    SwipeCountersAdapter swipeCountersAdapter9 = this.currentCountersAdapter;
                    if (swipeCountersAdapter9 != null) {
                        swipeCountersAdapter9.setTax(false);
                    }
                    SwipeMenuViewCallback swipeMenuViewCallback9 = this.callback;
                    if (swipeMenuViewCallback9 != null) {
                        swipeMenuViewCallback9.taxToggled(false);
                        return;
                    }
                    return;
                }
                this.tax = true;
                SwipeCountersAdapter swipeCountersAdapter10 = this.currentCountersAdapter;
                if (swipeCountersAdapter10 != null) {
                    swipeCountersAdapter10.setTax(true);
                }
                SwipeMenuViewCallback swipeMenuViewCallback10 = this.callback;
                if (swipeMenuViewCallback10 != null) {
                    swipeMenuViewCallback10.taxToggled(true);
                    return;
                }
                return;
            case 6:
                if (this.radiation) {
                    this.radiation = false;
                    SwipeCountersAdapter swipeCountersAdapter11 = this.currentCountersAdapter;
                    if (swipeCountersAdapter11 != null) {
                        swipeCountersAdapter11.setRadiation(false);
                    }
                    SwipeMenuViewCallback swipeMenuViewCallback11 = this.callback;
                    if (swipeMenuViewCallback11 != null) {
                        swipeMenuViewCallback11.radiationToggled(false);
                        return;
                    }
                    return;
                }
                this.radiation = true;
                SwipeCountersAdapter swipeCountersAdapter12 = this.currentCountersAdapter;
                if (swipeCountersAdapter12 != null) {
                    swipeCountersAdapter12.setRadiation(true);
                }
                SwipeMenuViewCallback swipeMenuViewCallback12 = this.callback;
                if (swipeMenuViewCallback12 != null) {
                    swipeMenuViewCallback12.radiationToggled(true);
                    return;
                }
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.studiolaganne.lengendarylens.SwipeCountersClickListener
    public void onCountersBackTapped() {
        if (isAttachedToWindow()) {
            this.inCounters = false;
            this.winLoseLayout.setVisibility(0);
            this.countersLayout.setVisibility(0);
            this.bkgLayout.setVisibility(0);
            this.advancedLayout.setVisibility(0);
            this.playerNameLabel.setVisibility(0);
            if (this.currentUserId > 0) {
                this.profileLayout.setVisibility(0);
            }
            this.advancedLayout2.setVisibility(8);
            this.advancedLayout3.setVisibility(8);
            this.countersRecyclerView.setVisibility(8);
        }
    }

    @Override // com.studiolaganne.lengendarylens.SimpleDeckClickListener
    public void onCreateDeckSelected() {
        if (this.gamePlayerSummaryMode && this.gamePlayerSummaryUser == null) {
            SwipeMenuViewCallback swipeMenuViewCallback = this.callback;
            if (swipeMenuViewCallback != null) {
                swipeMenuViewCallback.createGuestDeckSelected();
                return;
            }
            return;
        }
        SwipeMenuViewCallback swipeMenuViewCallback2 = this.callback;
        if (swipeMenuViewCallback2 != null) {
            swipeMenuViewCallback2.createDeckSelected();
        }
    }

    @Override // com.studiolaganne.lengendarylens.SimpleDeckClickListener
    public void onDeckSelected(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        Breadcrumbs.INSTANCE.leaveBreadcrumb("swipe_menu_deck_selected");
        this.deckBrowsingState = DeckBrowsingState.OWN_DECKS;
        this.selectedFriendForDecks = null;
        boolean z = this.gamePlayerSummaryMode;
        SwipeMenuViewCallback swipeMenuViewCallback = this.callback;
        if (z) {
            if (swipeMenuViewCallback != null) {
                swipeMenuViewCallback.deckSelectedFromSwipe(deck, true);
            }
            postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    SwipeMenuView.onDeckSelected$lambda$0(this.f$0);
                }
            }, 100L);
        } else if (swipeMenuViewCallback != null) {
            SwipeMenuViewCallback.deckSelectedFromSwipe$default(swipeMenuViewCallback, deck, false, 2, null);
        }
    }

    @Override // com.studiolaganne.lengendarylens.SwipePlaymatClickListener
    public void onGalleryTapped() {
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(getContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("swipe_photo_gallery_tapped", null);
        Breadcrumbs.INSTANCE.leaveBreadcrumb("swipe_menu_gallery_tapped");
        SwipeMenuViewCallback swipeMenuViewCallback = this.callback;
        if (swipeMenuViewCallback != null) {
            swipeMenuViewCallback.pickAPhotoTapped();
        }
    }

    @Override // com.studiolaganne.lengendarylens.MythicUserClickListener
    public void onMythicUserSelected(MTFriend user) {
        Intrinsics.checkNotNullParameter(user, "user");
        if (this.deckBrowsingState == DeckBrowsingState.FRIEND_SELECTION) {
            showFriendDeckList(user);
        }
    }

    @Override // com.studiolaganne.lengendarylens.SwipePlaymatClickListener
    public void onPlainColorTapped() {
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(getContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("swipe_plain_color_tapped", null);
        Breadcrumbs.INSTANCE.leaveBreadcrumb("swipe_menu_plain_color_tapped");
        SwipeMenuViewCallback swipeMenuViewCallback = this.callback;
        if (swipeMenuViewCallback != null) {
            swipeMenuViewCallback.plainColorTapped();
        }
    }

    @Override // com.studiolaganne.lengendarylens.SwipePlaymatClickListener
    public void onPlaymatSelected(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Breadcrumbs.INSTANCE.leaveBreadcrumb("swipe_menu_playmat_selected");
        if (this.currentPlaymatSet.length() != 0) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(getContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("swipe_playmat_selected", null);
            SwipeMenuViewCallback swipeMenuViewCallback = this.callback;
            if (swipeMenuViewCallback != null) {
                swipeMenuViewCallback.playmatSelected(id);
                return;
            }
            return;
        }
        PlaymatSet playmatSetFindSetForPlaymat = findSetForPlaymat(id);
        if (playmatSetFindSetForPlaymat != null) {
            this.currentPlaymatSet = playmatSetFindSetForPlaymat.getName();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new SwipePlaymatAdapter.SwipeItemData(1, "", "", "", false, 16, null));
            for (Playmat playmat : playmatSetFindSetForPlaymat.getPlaymats()) {
                arrayList.add(new SwipePlaymatAdapter.SwipeItemData(2, playmat.getName(), playmat.getId(), "", false, 16, null));
            }
            SwipePlaymatAdapter swipePlaymatAdapter = new SwipePlaymatAdapter(this.internalRotation, arrayList, "", this);
            this.playmatRecyclerView.setAdapter(swipePlaymatAdapter);
            this.currentPlaymatAdapter = swipePlaymatAdapter;
        }
    }

    @Override // com.studiolaganne.lengendarylens.MythicUserClickListener
    public void onQrScanSelected() {
    }

    @Override // com.studiolaganne.lengendarylens.SimpleDeckClickListener
    public void onRefreshDecksSelected() {
        this.loadingOverlay.setVisibility(0);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(context);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            MTApiKt.getMtApi().getUserDecks(currentUser.getId(), this.currentUserId).enqueue(new Callback<MTDecksResponse>() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$onRefreshDecksSelected$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDecksResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    this.this$0.loadingOverlay.setVisibility(8);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDecksResponse> call, Response<MTDecksResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (response.isSuccessful()) {
                        MTDecksResponse mTDecksResponseBody = response.body();
                        List<MTDeck> decks = mTDecksResponseBody != null ? mTDecksResponseBody.getDecks() : null;
                        if (decks != null) {
                            PreferencesManager preferencesManager2 = preferencesManager;
                            final SwipeMenuView swipeMenuView = this.this$0;
                            Map<Integer, ? extends List<MTDeck>> mutableMap = MapsKt.toMutableMap(preferencesManager2.getAllUsersDecks());
                            mutableMap.put(Integer.valueOf(swipeMenuView.currentUserId), decks);
                            preferencesManager2.saveAllUsersDecks(mutableMap);
                            DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
                            Context context2 = swipeMenuView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                            List<MTFormat> formats = companion.getInstance(context2).getFormats();
                            MTGDBHelper.Companion companion2 = MTGDBHelper.INSTANCE;
                            Context context3 = swipeMenuView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                            MTGDBHelper companion3 = companion2.getInstance(context3);
                            ArrayList arrayList = new ArrayList();
                            Context context4 = swipeMenuView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                            PreferencesManager preferencesManager3 = new PreferencesManager(context4);
                            for (String str : preferencesManager3.getEnabledLanguages()) {
                                if (!Intrinsics.areEqual(str, "en")) {
                                    MTGDBHelperLocalized.Companion companion4 = MTGDBHelperLocalized.INSTANCE;
                                    Context context5 = swipeMenuView.getContext();
                                    Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
                                    arrayList.add(companion4.getInstance(context5, str));
                                }
                            }
                            final Comparator comparator = new Comparator() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$onRefreshDecksSelected$1$1$onResponse$lambda$0$$inlined$compareBy$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t, T t2) {
                                    return ComparisonsKt.compareValues(Boolean.valueOf(((MTDeck) t).getFormatid() != swipeMenuView.currentFormatId), Boolean.valueOf(((MTDeck) t2).getFormatid() != swipeMenuView.currentFormatId));
                                }
                            };
                            SimpleDecksAdapter simpleDecksAdapter = new SimpleDecksAdapter(CollectionsKt.sortedWith(decks, new Comparator() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$onRefreshDecksSelected$1$1$onResponse$lambda$0$$inlined$thenBy$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t, T t2) {
                                    int iCompare = comparator.compare(t, t2);
                                    if (iCompare != 0) {
                                        return iCompare;
                                    }
                                    String lowerCase = ((MTDeck) t).getName().toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    String lowerCase2 = ((MTDeck) t2).getName().toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                    return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                                }
                            }), swipeMenuView.currentFormatId, formats, companion3, arrayList, swipeMenuView.internalRotation, swipeMenuView, preferencesManager3.getCurrentUser() != null, false, false, 768, null);
                            swipeMenuView.currentDecksAdapter = simpleDecksAdapter;
                            swipeMenuView.decksRecyclerView.setAdapter(simpleDecksAdapter);
                        }
                    }
                    this.this$0.loadingOverlay.setVisibility(8);
                }
            });
        }
    }

    @Override // com.studiolaganne.lengendarylens.SimpleDeckClickListener
    public void onSharedDecksSelected() {
        showFriendSelectionForDecks();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [com.studiolaganne.lengendarylens.SwipeMenuViewCallback] */
    /* JADX WARN: Type inference failed for: r1v139, types: [boolean] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        ?? r20;
        int i;
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d("SwipeEvents", "onTouchEvent - " + event.getAction());
        int action = event.getAction();
        if (action == 0) {
            Log.d("SwipeEvents", "DOWN EVENT - " + event.getX() + ", " + event.getY());
            this.touchStartX = event.getX();
            this.touchStartY = event.getY();
            return true;
        }
        if (action != 1) {
            return super.onTouchEvent(event);
        }
        Log.d("SwipeEvents", "UP EVENT - " + event.getX() + ", " + event.getY());
        float x = event.getX() - this.touchStartX;
        float y = event.getY() - this.touchStartY;
        if (((float) Math.sqrt((x * x) + (y * y))) < this.touchSlop || this.disableSwipe) {
            Log.d("SwipeEvents", "TAP TIME OK");
            final long j = 200;
            boolean z = false;
            if (event.getX() >= this.winLoseLayout.getLeft() && event.getX() <= this.winLoseLayout.getRight() && event.getY() >= this.winLoseLayout.getTop() && event.getY() <= this.winLoseLayout.getBottom() && !this.inAdvanced && !this.inWinLose && !this.inCounters) {
                this.inWinLose = true;
                this.playerNameLabel.setVisibility(8);
                this.profileLayout.setVisibility(8);
                for (final LinearLayout linearLayout : CollectionsKt.listOf((Object[]) new LinearLayout[]{this.winLoseLayout, this.countersLayout, this.bkgLayout, this.advancedLayout})) {
                    linearLayout.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200L).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            SwipeMenuView.onTouchEvent$lambda$0$0(linearLayout);
                        }
                    }).start();
                }
                this.advancedImage1.setImageResource(R.drawable.trophy);
                this.advancedImage2.setImageResource(R.drawable.skull);
                this.advancedImage3.setImageResource(R.drawable.ic_concede);
                this.advancedImage4.setImageResource(R.drawable.ic_draw);
                this.advancedLabel3.setText(getContext().getString(R.string.action_concede));
                this.advancedLabel4.setText(getContext().getString(R.string.action_draw));
                boolean z2 = this.killed;
                TextView textView = this.advancedLabel2;
                if (z2) {
                    textView.setText(getContext().getString(R.string.action_undo_kill));
                } else {
                    textView.setText(getContext().getString(R.string.action_kill));
                }
                boolean z3 = this.killEnabled;
                ImageView imageView = this.advancedImage2;
                if (z3) {
                    imageView.setAlpha(0.85f);
                    this.advancedLabel2.setTextColor(ContextCompat.getColor(getContext(), R.color.almost_white));
                } else {
                    imageView.setAlpha(0.35f);
                    this.advancedLabel2.setTextColor(ContextCompat.getColor(getContext(), R.color.dark_grey));
                }
                boolean z4 = this.win;
                TextView textView2 = this.advancedLabel1;
                if (z4) {
                    textView2.setText(getContext().getString(R.string.action_undo_win));
                } else {
                    textView2.setText(getContext().getString(R.string.action_win));
                }
                boolean z5 = this.winEnabled;
                ImageView imageView2 = this.advancedImage1;
                if (z5) {
                    imageView2.setAlpha(0.95f);
                    this.advancedLabel1.setTextColor(ContextCompat.getColor(getContext(), R.color.almost_white));
                } else {
                    imageView2.setAlpha(0.35f);
                    this.advancedLabel1.setTextColor(ContextCompat.getColor(getContext(), R.color.dark_grey));
                }
                Runnable runnable = new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        SwipeMenuView.onTouchEvent$lambda$1(this.f$0, j);
                    }
                };
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(getContext());
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                firebaseAnalytics.logEvent("swipe_win_lose_open", null);
                postDelayed(runnable, 100L);
                return true;
            }
            if (event.getX() >= this.countersLayout.getLeft() && event.getX() <= this.countersLayout.getRight() && event.getY() >= this.countersLayout.getTop() && event.getY() <= this.countersLayout.getBottom() && !this.inAdvanced && !this.inWinLose && !this.inCounters) {
                this.inCounters = true;
                this.playerNameLabel.setVisibility(8);
                this.profileLayout.setVisibility(8);
                for (final LinearLayout linearLayout2 : CollectionsKt.listOf((Object[]) new LinearLayout[]{this.winLoseLayout, this.countersLayout, this.bkgLayout, this.advancedLayout})) {
                    linearLayout2.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200L).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda12
                        @Override // java.lang.Runnable
                        public final void run() {
                            SwipeMenuView.onTouchEvent$lambda$2$0(linearLayout2);
                        }
                    }).start();
                }
                this.countersRecyclerView.setVisibility(0);
                this.countersRecyclerView.setAlpha(0.0f);
                postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda13
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.countersRecyclerView.setAlpha(1.0f);
                    }
                }, 200L);
                FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(getContext());
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
                firebaseAnalytics2.logEvent("swipe_counters_open", null);
                return true;
            }
            if (event.getX() >= this.bkgLayout.getLeft()) {
                i = 2;
                if (event.getX() > this.bkgLayout.getRight() || event.getY() < this.bkgLayout.getTop() || event.getY() > this.bkgLayout.getBottom() || this.inAdvanced || this.inCounters || this.inWinLose) {
                    r20 = 0;
                } else {
                    if (!this.bkgEnabled) {
                        return true;
                    }
                    for (final View view : CollectionsKt.listOf((Object[]) new View[]{this.winLoseLayout, this.countersLayout, this.bkgLayout, this.advancedLayout, this.playerNameLabel, this.profileLayout})) {
                        view.animate().alpha(0.0f).setDuration(200L).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda14
                            @Override // java.lang.Runnable
                            public final void run() {
                                SwipeMenuView.onTouchEvent$lambda$4$0(view);
                            }
                        }).start();
                        z = z;
                    }
                    r20 = z;
                    this.advancedLayout2.setVisibility(8);
                    this.advancedLayout3.setVisibility(8);
                    FirebaseAnalytics firebaseAnalytics3 = FirebaseAnalytics.getInstance(getContext());
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics3, "getInstance(...)");
                    firebaseAnalytics3.logEvent("swipe_playmats_open", null);
                    postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda15
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.playmatRecyclerView.setVisibility(0);
                        }
                    }, 200L);
                }
            } else {
                r20 = 0;
                i = 2;
            }
            if (event.getX() >= this.advancedLayout.getLeft() && event.getX() <= this.advancedLayout.getRight() && event.getY() >= this.advancedLayout.getTop() && event.getY() <= this.advancedLayout.getBottom()) {
                if (this.disableDeckAndAdvanced) {
                    return true;
                }
                Log.d("SwipeMenuView", "Advanced-Rect-Hit");
                if (!this.inAdvanced && !this.inWinLose && !this.inCounters) {
                    Log.d("SwipeMenuView", "Drill Down");
                    this.inAdvanced = true;
                    this.playerNameLabel.setVisibility(8);
                    this.profileLayout.setVisibility(8);
                    LinearLayout[] linearLayoutArr = new LinearLayout[4];
                    linearLayoutArr[r20] = this.winLoseLayout;
                    linearLayoutArr[1] = this.countersLayout;
                    linearLayoutArr[i] = this.bkgLayout;
                    linearLayoutArr[3] = this.advancedLayout;
                    for (final LinearLayout linearLayout3 : CollectionsKt.listOf((Object[]) linearLayoutArr)) {
                        linearLayout3.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200L).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda16
                            @Override // java.lang.Runnable
                            public final void run() {
                                SwipeMenuView.onTouchEvent$lambda$6$0(linearLayout3);
                            }
                        }).start();
                    }
                    this.advancedImage2.setImageResource(R.drawable.decks_white);
                    this.advancedLabel2.setText(getResources().getString(R.string.deck));
                    boolean z6 = this.decksEnabled;
                    ImageView imageView3 = this.advancedImage2;
                    if (z6) {
                        imageView3.setAlpha(0.95f);
                        this.advancedLabel2.setTextColor(ContextCompat.getColor(getContext(), R.color.almost_white));
                    } else {
                        imageView3.setAlpha(0.35f);
                        this.advancedLabel2.setTextColor(ContextCompat.getColor(getContext(), R.color.dark_grey));
                    }
                    boolean z7 = this.partners;
                    ImageView imageView4 = this.advancedImage3;
                    if (z7) {
                        imageView4.setImageResource(R.drawable.partners_on);
                    } else {
                        imageView4.setImageResource(R.drawable.partners_off);
                    }
                    this.advancedImage3.setAlpha(0.95f);
                    this.advancedLabel3.setText(getResources().getString(R.string.action_partners));
                    boolean z8 = this.partnersEnabled;
                    TextView textView3 = this.advancedLabel3;
                    if (z8) {
                        textView3.setTextColor(ContextCompat.getColor(getContext(), R.color.almost_white));
                    } else {
                        textView3.setTextColor(ContextCompat.getColor(getContext(), R.color.dark_grey));
                    }
                    Runnable runnable2 = new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda17
                        @Override // java.lang.Runnable
                        public final void run() {
                            SwipeMenuView.onTouchEvent$lambda$7(this.f$0, j);
                        }
                    };
                    FirebaseAnalytics firebaseAnalytics4 = FirebaseAnalytics.getInstance(getContext());
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics4, "getInstance(...)");
                    firebaseAnalytics4.logEvent("swipe_advanced_open", null);
                    postDelayed(runnable2, 100L);
                    return true;
                }
            }
            if (this.inAdvanced) {
                Log.d("SwipeMenuView", "InAdvanced");
                if (event.getX() >= this.advancedLayout2.getLeft() && event.getX() <= this.advancedLayout2.getRight() && event.getY() >= this.advancedLayout2.getTop() && event.getY() <= this.advancedLayout2.getBottom()) {
                    if (this.decksEnabled && this.currentUserId > 0) {
                        View[] viewArr = new View[6];
                        viewArr[r20] = this.winLoseLayout;
                        viewArr[1] = this.countersLayout;
                        viewArr[i] = this.bkgLayout;
                        viewArr[3] = this.advancedLayout;
                        viewArr[4] = this.playerNameLabel;
                        viewArr[5] = this.profileLayout;
                        for (final View view2 : CollectionsKt.listOf((Object[]) viewArr)) {
                            view2.animate().alpha(0.0f).setDuration(200L).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda18
                                @Override // java.lang.Runnable
                                public final void run() {
                                    SwipeMenuView.onTouchEvent$lambda$8$0(view2);
                                }
                            }).start();
                        }
                        this.advancedLayout2.setVisibility(8);
                        this.advancedLayout3.setVisibility(8);
                        FirebaseAnalytics firebaseAnalytics5 = FirebaseAnalytics.getInstance(getContext());
                        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics5, "getInstance(...)");
                        firebaseAnalytics5.logEvent("swipe_decks_open", null);
                        postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda19
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.decksRecyclerView.setVisibility(0);
                            }
                        }, 200L);
                    }
                    return true;
                }
                if (event.getX() >= this.advancedLayout3.getLeft() && event.getX() <= this.advancedLayout3.getRight() && event.getY() >= this.advancedLayout3.getTop() && event.getY() <= this.advancedLayout3.getBottom()) {
                    if (!this.partnersEnabled) {
                        return true;
                    }
                    if (this.partners) {
                        ?? r1 = r20;
                        this.partners = r1;
                        this.advancedImage3.setImageResource(R.drawable.partners_off);
                        ?? r0 = this.callback;
                        if (r0 != 0) {
                            r0.partnersToggled(r1);
                            Unit unit = Unit.INSTANCE;
                        }
                    } else {
                        this.partners = true;
                        this.advancedImage3.setImageResource(R.drawable.partners_on);
                        SwipeMenuViewCallback swipeMenuViewCallback = this.callback;
                        if (swipeMenuViewCallback != null) {
                            swipeMenuViewCallback.partnersToggled(true);
                            Unit unit2 = Unit.INSTANCE;
                        }
                        FirebaseAnalytics firebaseAnalytics6 = FirebaseAnalytics.getInstance(getContext());
                        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics6, "getInstance(...)");
                        firebaseAnalytics6.logEvent("partners_toggled", null);
                        Unit unit3 = Unit.INSTANCE;
                    }
                    return true;
                }
                Log.d("SwipeMenuView", "InAdvanced - Outside Hit");
                LinearLayout[] linearLayoutArr2 = new LinearLayout[i];
                linearLayoutArr2[0] = this.advancedLayout2;
                linearLayoutArr2[1] = this.advancedLayout3;
                for (final LinearLayout linearLayout4 : CollectionsKt.listOf((Object[]) linearLayoutArr2)) {
                    linearLayout4.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200L).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            SwipeMenuView.onTouchEvent$lambda$10$0(linearLayout4);
                        }
                    }).start();
                }
                postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        SwipeMenuView.onTouchEvent$lambda$11(this.f$0, j);
                    }
                }, 100L);
                this.inAdvanced = false;
            }
            if (this.inWinLose) {
                Log.d("SwipeMenuView", "InWinLose");
                if (event.getX() >= this.advancedLayout1.getLeft() && event.getX() <= this.advancedLayout1.getRight() && event.getY() >= this.advancedLayout1.getTop() && event.getY() <= this.advancedLayout1.getBottom()) {
                    if (!this.winEnabled) {
                        return true;
                    }
                    FirebaseAnalytics firebaseAnalytics7 = FirebaseAnalytics.getInstance(getContext());
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics7, "getInstance(...)");
                    firebaseAnalytics7.logEvent("swipe_win_tapped", null);
                    SwipeMenuViewCallback swipeMenuViewCallback2 = this.callback;
                    if (swipeMenuViewCallback2 != null) {
                        swipeMenuViewCallback2.winTapped();
                        Unit unit4 = Unit.INSTANCE;
                    }
                    return true;
                }
                if (event.getX() >= this.advancedLayout2.getLeft() && event.getX() <= this.advancedLayout2.getRight() && event.getY() >= this.advancedLayout2.getTop() && event.getY() <= this.advancedLayout2.getBottom()) {
                    if (!this.killEnabled) {
                        return true;
                    }
                    FirebaseAnalytics firebaseAnalytics8 = FirebaseAnalytics.getInstance(getContext());
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics8, "getInstance(...)");
                    firebaseAnalytics8.logEvent("swipe_kill_tapped", null);
                    SwipeMenuViewCallback swipeMenuViewCallback3 = this.callback;
                    if (swipeMenuViewCallback3 != null) {
                        swipeMenuViewCallback3.killTapped();
                        Unit unit5 = Unit.INSTANCE;
                    }
                    return true;
                }
                if (event.getX() >= this.advancedLayout3.getLeft() && event.getX() <= this.advancedLayout3.getRight() && event.getY() >= this.advancedLayout3.getTop() && event.getY() <= this.advancedLayout3.getBottom()) {
                    FirebaseAnalytics firebaseAnalytics9 = FirebaseAnalytics.getInstance(getContext());
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics9, "getInstance(...)");
                    firebaseAnalytics9.logEvent("swipe_concede_tapped", null);
                    SwipeMenuViewCallback swipeMenuViewCallback4 = this.callback;
                    if (swipeMenuViewCallback4 != null) {
                        swipeMenuViewCallback4.concedeTapped();
                        Unit unit6 = Unit.INSTANCE;
                    }
                    return true;
                }
                if (event.getX() >= this.advancedLayout4.getLeft() && event.getX() <= this.advancedLayout4.getRight() && event.getY() >= this.advancedLayout4.getTop() && event.getY() <= this.advancedLayout4.getBottom()) {
                    FirebaseAnalytics firebaseAnalytics10 = FirebaseAnalytics.getInstance(getContext());
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics10, "getInstance(...)");
                    firebaseAnalytics10.logEvent("swipe_draw_tapped", null);
                    SwipeMenuViewCallback swipeMenuViewCallback5 = this.callback;
                    if (swipeMenuViewCallback5 != null) {
                        swipeMenuViewCallback5.drawTapped();
                        Unit unit7 = Unit.INSTANCE;
                    }
                    return true;
                }
                Log.d("SwipeMenuView", "InWinLose - Outside Hit");
                for (final LinearLayout linearLayout5 : CollectionsKt.listOf((Object[]) new LinearLayout[]{this.advancedLayout1, this.advancedLayout2, this.advancedLayout3, this.advancedLayout4})) {
                    linearLayout5.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200L).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            SwipeMenuView.onTouchEvent$lambda$12$0(linearLayout5);
                        }
                    }).start();
                }
                postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        SwipeMenuView.onTouchEvent$lambda$13(this.f$0, j);
                    }
                }, 100L);
                this.inWinLose = false;
            }
            if (this.inCounters) {
                Log.d("SwipeMenuView", "InCounters");
                if (event.getX() >= this.advancedLayout2.getLeft() && event.getX() <= this.advancedLayout2.getRight() && event.getY() >= this.advancedLayout2.getTop() && event.getY() <= this.advancedLayout2.getBottom()) {
                    if (this.energy) {
                        this.energy = false;
                        this.advancedImage2.setImageResource(R.drawable.energy_off);
                        SwipeMenuViewCallback swipeMenuViewCallback6 = this.callback;
                        if (swipeMenuViewCallback6 != null) {
                            swipeMenuViewCallback6.energyToggled(false);
                            Unit unit8 = Unit.INSTANCE;
                        }
                    } else {
                        this.energy = true;
                        this.advancedImage2.setImageResource(R.drawable.energy_on);
                        SwipeMenuViewCallback swipeMenuViewCallback7 = this.callback;
                        if (swipeMenuViewCallback7 != null) {
                            swipeMenuViewCallback7.energyToggled(true);
                            Unit unit9 = Unit.INSTANCE;
                        }
                        FirebaseAnalytics firebaseAnalytics11 = FirebaseAnalytics.getInstance(getContext());
                        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics11, "getInstance(...)");
                        firebaseAnalytics11.logEvent("energy_toggled", null);
                        Unit unit10 = Unit.INSTANCE;
                    }
                    return true;
                }
                if (event.getX() >= this.advancedLayout3.getLeft() && event.getX() <= this.advancedLayout3.getRight() && event.getY() >= this.advancedLayout3.getTop() && event.getY() <= this.advancedLayout3.getBottom()) {
                    if (this.storm) {
                        this.storm = false;
                        this.advancedImage3.setImageResource(R.drawable.storm_off);
                        SwipeMenuViewCallback swipeMenuViewCallback8 = this.callback;
                        if (swipeMenuViewCallback8 != null) {
                            swipeMenuViewCallback8.stormToggled(false);
                            Unit unit11 = Unit.INSTANCE;
                        }
                    } else {
                        this.storm = true;
                        this.advancedImage3.setImageResource(R.drawable.storm_on);
                        SwipeMenuViewCallback swipeMenuViewCallback9 = this.callback;
                        if (swipeMenuViewCallback9 != null) {
                            swipeMenuViewCallback9.stormToggled(true);
                            Unit unit12 = Unit.INSTANCE;
                        }
                        FirebaseAnalytics firebaseAnalytics12 = FirebaseAnalytics.getInstance(getContext());
                        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics12, "getInstance(...)");
                        firebaseAnalytics12.logEvent("storm_toggled", null);
                        Unit unit13 = Unit.INSTANCE;
                    }
                    return true;
                }
                Log.d("SwipeMenuView", "InAdvanced - Outside Hit");
                for (final LinearLayout linearLayout6 : CollectionsKt.listOf((Object[]) new LinearLayout[]{this.advancedLayout2, this.advancedLayout3})) {
                    linearLayout6.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200L).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda8
                        @Override // java.lang.Runnable
                        public final void run() {
                            SwipeMenuView.onTouchEvent$lambda$14$0(linearLayout6);
                        }
                    }).start();
                }
                postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        SwipeMenuView.onTouchEvent$lambda$15(this.f$0, j);
                    }
                }, 100L);
                this.inCounters = false;
            }
            Unit unit14 = Unit.INSTANCE;
        } else {
            Log.d("SwipeEvents", "SWIPE DETECTED");
            Direction direction = Direction.UP;
            Direction direction2 = Math.abs(x) > Math.abs(y) ? x > 0.0f ? Direction.LEFT : Direction.RIGHT : y > 0.0f ? Direction.DOWN : Direction.UP;
            Log.d("LifeTotalView", "----> SWIPE <---- direction = " + direction2);
            SwipeMenuViewCallback swipeMenuViewCallback10 = this.callback;
            if (swipeMenuViewCallback10 != null) {
                swipeMenuViewCallback10.swipeClose(direction2);
                Unit unit15 = Unit.INSTANCE;
            }
        }
        return true;
    }

    public final void photoPicked(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.leftRightLayout.setVisibility(0);
    }

    public final void playmatPicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.leftRightLayout.setVisibility(0);
    }

    public final void setCallback(SwipeMenuViewCallback swipeMenuViewCallback) {
        this.callback = swipeMenuViewCallback;
    }

    public final void setCornerRadius(int radius) {
        CardView cardView = (CardView) findViewById(R.id.cardView);
        if (cardView != null) {
            cardView.setRadius(radius);
        }
    }

    public final void setDisableDeckAndAdvanced(boolean z) {
        this.disableDeckAndAdvanced = z;
    }

    public final void setPlaygroupGameUsers(List<MTUser> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.playgroupGameUsers = list;
    }

    public final void setPurchaseLauncher(ActivityResultLauncher<Intent> activityResultLauncher) {
        this.purchaseLauncher = activityResultLauncher;
    }

    public final void setRotation(String currentPlayerId, Player player, String playerName, int userId, String profileURL, final int currentFormatId, int rotation, int width, int height) {
        float f;
        float f2;
        MTUser currentUser;
        Intrinsics.checkNotNullParameter(currentPlayerId, "currentPlayerId");
        Intrinsics.checkNotNullParameter(playerName, "playerName");
        this.playerName = playerName;
        this.internalRotation = rotation;
        this.currentFormatId = currentFormatId;
        this.currentUserId = userId;
        this.profileUrl = profileURL;
        updatePlayerName(playerName);
        this.countersLayout.setRotation(this.internalRotation);
        this.winLoseLayout.setRotation(this.internalRotation);
        this.bkgLayout.setRotation(this.internalRotation);
        this.playerNameLabel.setRotation(this.internalRotation);
        this.advancedLayout.setRotation(this.internalRotation);
        this.leftRightInnerLayout.setRotation(this.internalRotation);
        this.profileLayout.setRotation(this.internalRotation);
        this.gamePlayerSummaryInnerLayout.setRotation(this.internalRotation);
        this.advancedLayout1.setRotation(this.internalRotation);
        this.advancedLayout2.setRotation(this.internalRotation);
        this.advancedLayout3.setRotation(this.internalRotation);
        this.advancedLayout4.setRotation(this.internalRotation);
        this.rootList.clear();
        this.rootList.add(new SwipePlaymatAdapter.SwipeItemData(1, "", "", "", false, 16, null));
        this.rootList.add(new SwipePlaymatAdapter.SwipeItemData(0, "", "", "", false, 16, null));
        this.rootList.add(new SwipePlaymatAdapter.SwipeItemData(4, "", "", "", false, 16, null));
        this.rootList.add(new SwipePlaymatAdapter.SwipeItemData(5, "", "", "", false, 16, null));
        for (PlaymatSet playmatSet : this.playmatSets) {
            this.rootList.add(new SwipePlaymatAdapter.SwipeItemData(2, playmatSet.getName(), playmatSet.getPlaymats().get(0).getId(), "category", !Intrinsics.areEqual(playmatSet.getName(), getResources().getString(R.string.character_playmats)) ? true ^ this.enablePaidContent : false));
        }
        SwipePlaymatAdapter swipePlaymatAdapter = new SwipePlaymatAdapter(this.internalRotation, this.rootList, "", this);
        this.playmatRecyclerView.setAdapter(swipePlaymatAdapter);
        this.currentPlaymatAdapter = swipePlaymatAdapter;
        if (this.currentUserId > 0) {
            DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            List<MTFormat> formats = companion.getInstance(context).getFormats();
            MTGDBHelper.Companion companion2 = MTGDBHelper.INSTANCE;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            MTGDBHelper companion3 = companion2.getInstance(context2);
            ArrayList arrayList = new ArrayList();
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(context3);
            for (String str : preferencesManager.getEnabledLanguages()) {
                if (!Intrinsics.areEqual(str, "en")) {
                    MTGDBHelperLocalized.Companion companion4 = MTGDBHelperLocalized.INSTANCE;
                    Context context4 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                    arrayList.add(companion4.getInstance(context4, str));
                }
            }
            List<MTDeck> currentUserDecks = preferencesManager.getAllUsersDecks().get(Integer.valueOf(this.currentUserId));
            if (currentUserDecks == null) {
                currentUserDecks = CollectionsKt.emptyList();
            }
            if (currentUserDecks.isEmpty() && (currentUser = preferencesManager.getCurrentUser()) != null) {
                if (currentUser.getId() == this.currentUserId) {
                    currentUserDecks = preferencesManager.getCurrentUserDecks();
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            final Comparator comparator = new Comparator() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$setRotation$$inlined$compareBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Boolean.valueOf(((MTDeck) t).getFormatid() != currentFormatId), Boolean.valueOf(((MTDeck) t2).getFormatid() != currentFormatId));
                }
            };
            SimpleDecksAdapter simpleDecksAdapter = new SimpleDecksAdapter(CollectionsKt.sortedWith(currentUserDecks, new Comparator() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$setRotation$$inlined$thenBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator.compare(t, t2);
                    if (iCompare != 0) {
                        return iCompare;
                    }
                    String lowerCase = ((MTDeck) t).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = ((MTDeck) t2).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                }
            }), this.currentFormatId, formats, companion3, arrayList, this.internalRotation, this, preferencesManager.getCurrentUser() != null, false, false, 768, null);
            this.currentDecksAdapter = simpleDecksAdapter;
            this.decksRecyclerView.setAdapter(simpleDecksAdapter);
        }
        if (player != null) {
            Context context5 = getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
            SwipeCountersAdapter swipeCountersAdapter = new SwipeCountersAdapter(context5, this.poison, player, this.internalRotation, this);
            this.countersRecyclerView.setAdapter(swipeCountersAdapter);
            this.currentCountersAdapter = swipeCountersAdapter;
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        int i = this.internalRotation;
        if (i == 0) {
            this.playmatRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.decksRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.countersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            Unit unit5 = Unit.INSTANCE;
        } else if (i == 90) {
            this.playmatRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            this.decksRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            this.countersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            Unit unit6 = Unit.INSTANCE;
        } else if (i != 180) {
            if (i == 270) {
                this.playmatRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, true));
                this.decksRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, true));
                this.countersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, true));
            }
            Unit unit7 = Unit.INSTANCE;
        } else {
            this.playmatRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, true));
            this.decksRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, true));
            this.countersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, true));
            Unit unit8 = Unit.INSTANCE;
        }
        Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
        int iDpToPx = (int) (((double) dpToPx(3, r2)) * 1.35d);
        int i2 = this.internalRotation;
        if (i2 == 90) {
            ViewGroup.LayoutParams layoutParams = this.playerNameLabel.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.removeRule(14);
            layoutParams2.addRule(15);
            layoutParams2.removeRule(10);
            layoutParams2.addRule(11);
            String str2 = playerName;
            layoutParams2.rightMargin = str2.length() < 5 ? 0 : str2.length() * (-iDpToPx);
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            layoutParams2.leftMargin = 0;
            this.playerNameLabel.setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = this.profileLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            layoutParams4.removeRule(9);
            layoutParams4.addRule(11);
            this.profileLayout.setLayoutParams(layoutParams4);
            ViewGroup.LayoutParams layoutParams5 = this.countersRecyclerView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
            layoutParams6.removeRule(15);
            layoutParams6.addRule(14);
            Context context6 = getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
            layoutParams6.width = dpToPx(140, context6);
            layoutParams6.height = -1;
            this.countersRecyclerView.setLayoutParams(layoutParams6);
            ViewGroup.LayoutParams layoutParams7 = this.decksRecyclerView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
            layoutParams8.removeRule(15);
            layoutParams8.addRule(14);
            Context context7 = getContext();
            Intrinsics.checkNotNullExpressionValue(context7, "getContext(...)");
            layoutParams8.width = dpToPx(140, context7);
            layoutParams8.height = -1;
            this.decksRecyclerView.setLayoutParams(layoutParams8);
            ViewGroup.LayoutParams layoutParams9 = this.playmatRecyclerView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams9, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) layoutParams9;
            layoutParams10.removeRule(15);
            layoutParams10.addRule(14);
            Context context8 = getContext();
            Intrinsics.checkNotNullExpressionValue(context8, "getContext(...)");
            layoutParams10.width = dpToPx(140, context8);
            layoutParams10.height = -1;
            this.playmatRecyclerView.setLayoutParams(layoutParams10);
        } else if (i2 == 180) {
            ViewGroup.LayoutParams layoutParams11 = this.playerNameLabel.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams11, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) layoutParams11;
            layoutParams12.removeRule(10);
            layoutParams12.addRule(12);
            this.playerNameLabel.setLayoutParams(layoutParams12);
            ViewGroup.LayoutParams layoutParams13 = this.profileLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams13, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams14 = (RelativeLayout.LayoutParams) layoutParams13;
            layoutParams14.removeRule(9);
            layoutParams14.removeRule(10);
            layoutParams14.addRule(11);
            layoutParams14.addRule(12);
            this.profileLayout.setLayoutParams(layoutParams14);
        } else if (i2 == 270) {
            ViewGroup.LayoutParams layoutParams15 = this.playerNameLabel.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams15, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams16 = (RelativeLayout.LayoutParams) layoutParams15;
            layoutParams16.removeRule(14);
            layoutParams16.addRule(15);
            layoutParams16.removeRule(10);
            layoutParams16.addRule(9);
            String str3 = playerName;
            layoutParams16.leftMargin = str3.length() < 5 ? 0 : str3.length() * (-iDpToPx);
            layoutParams16.topMargin = 0;
            layoutParams16.bottomMargin = 0;
            layoutParams16.rightMargin = 0;
            this.playerNameLabel.setLayoutParams(layoutParams16);
            ViewGroup.LayoutParams layoutParams17 = this.profileLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams17, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams18 = (RelativeLayout.LayoutParams) layoutParams17;
            layoutParams18.removeRule(10);
            layoutParams18.addRule(12);
            this.profileLayout.setLayoutParams(layoutParams18);
            ViewGroup.LayoutParams layoutParams19 = this.countersRecyclerView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams19, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams20 = (RelativeLayout.LayoutParams) layoutParams19;
            layoutParams20.removeRule(15);
            layoutParams20.addRule(14);
            Context context9 = getContext();
            Intrinsics.checkNotNullExpressionValue(context9, "getContext(...)");
            layoutParams20.width = dpToPx(140, context9);
            layoutParams20.height = -1;
            this.countersRecyclerView.setLayoutParams(layoutParams20);
            ViewGroup.LayoutParams layoutParams21 = this.decksRecyclerView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams21, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams22 = (RelativeLayout.LayoutParams) layoutParams21;
            layoutParams22.removeRule(15);
            layoutParams22.addRule(14);
            Context context10 = getContext();
            Intrinsics.checkNotNullExpressionValue(context10, "getContext(...)");
            layoutParams22.width = dpToPx(140, context10);
            layoutParams22.height = -1;
            this.decksRecyclerView.setLayoutParams(layoutParams22);
            ViewGroup.LayoutParams layoutParams23 = this.playmatRecyclerView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams23, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams24 = (RelativeLayout.LayoutParams) layoutParams23;
            layoutParams24.removeRule(15);
            layoutParams24.addRule(14);
            Context context11 = getContext();
            Intrinsics.checkNotNullExpressionValue(context11, "getContext(...)");
            layoutParams24.width = dpToPx(140, context11);
            layoutParams24.height = -1;
            this.playmatRecyclerView.setLayoutParams(layoutParams24);
        }
        int iCoerceAtMost = RangesKt.coerceAtMost(width, height);
        ViewGroup.LayoutParams layoutParams25 = this.gamePlayerSummaryInnerLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams25, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams26 = (ConstraintLayout.LayoutParams) layoutParams25;
        int i3 = (int) (((double) iCoerceAtMost) * 0.9d);
        layoutParams26.width = i3;
        layoutParams26.height = i3;
        this.gamePlayerSummaryInnerLayout.setLayoutParams(layoutParams26);
        if (width >= height) {
            f = width;
            f2 = height;
        } else {
            f = height;
            f2 = width;
        }
        if (f / f2 < 1.75f) {
            setupAsGrid();
            return;
        }
        int i4 = this.internalRotation;
        if (i4 == 90) {
            ViewGroup.LayoutParams layoutParams27 = this.winLoseLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams27, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams28 = (RelativeLayout.LayoutParams) layoutParams27;
            layoutParams28.removeRule(15);
            layoutParams28.addRule(14);
            layoutParams28.removeRule(0);
            layoutParams28.addRule(2, this.countersLayout.getId());
            this.winLoseLayout.setLayoutParams(layoutParams28);
            ViewGroup.LayoutParams layoutParams29 = this.countersLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams29, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams30 = (RelativeLayout.LayoutParams) layoutParams29;
            layoutParams30.removeRule(15);
            layoutParams30.addRule(14);
            layoutParams30.removeRule(0);
            layoutParams30.addRule(2, this.centerView.getId());
            this.countersLayout.setLayoutParams(layoutParams30);
            ViewGroup.LayoutParams layoutParams31 = this.bkgLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams31, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams32 = (RelativeLayout.LayoutParams) layoutParams31;
            layoutParams32.removeRule(15);
            layoutParams32.addRule(14);
            layoutParams32.removeRule(1);
            layoutParams32.addRule(3, this.countersLayout.getId());
            this.bkgLayout.setLayoutParams(layoutParams32);
            ViewGroup.LayoutParams layoutParams33 = this.advancedLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams33, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams34 = (RelativeLayout.LayoutParams) layoutParams33;
            layoutParams34.removeRule(15);
            layoutParams34.addRule(14);
            layoutParams34.removeRule(1);
            layoutParams34.addRule(3, this.bkgLayout.getId());
            this.advancedLayout.setLayoutParams(layoutParams34);
            ViewGroup.LayoutParams layoutParams35 = this.advancedLayout1.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams35, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams36 = (RelativeLayout.LayoutParams) layoutParams35;
            layoutParams36.removeRule(15);
            layoutParams36.addRule(14);
            layoutParams36.removeRule(0);
            layoutParams36.addRule(2, this.advancedLayout2.getId());
            this.advancedLayout1.setLayoutParams(layoutParams36);
            ViewGroup.LayoutParams layoutParams37 = this.advancedLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams37, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams38 = (RelativeLayout.LayoutParams) layoutParams37;
            layoutParams38.removeRule(15);
            layoutParams38.addRule(14);
            layoutParams38.removeRule(0);
            layoutParams38.addRule(2, this.centerView.getId());
            this.advancedLayout2.setLayoutParams(layoutParams38);
            ViewGroup.LayoutParams layoutParams39 = this.advancedLayout3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams39, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams40 = (RelativeLayout.LayoutParams) layoutParams39;
            layoutParams40.removeRule(15);
            layoutParams40.addRule(14);
            layoutParams40.removeRule(1);
            layoutParams40.addRule(3, this.advancedLayout2.getId());
            this.advancedLayout3.setLayoutParams(layoutParams40);
            ViewGroup.LayoutParams layoutParams41 = this.advancedLayout4.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams41, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams42 = (RelativeLayout.LayoutParams) layoutParams41;
            layoutParams42.removeRule(15);
            layoutParams42.addRule(14);
            layoutParams42.removeRule(1);
            layoutParams42.addRule(3, this.advancedLayout3.getId());
            this.advancedLayout4.setLayoutParams(layoutParams42);
        } else if (i4 == 180) {
            ViewGroup.LayoutParams layoutParams43 = this.winLoseLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams43, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams44 = (RelativeLayout.LayoutParams) layoutParams43;
            layoutParams44.removeRule(0);
            layoutParams44.addRule(1, this.countersLayout.getId());
            this.winLoseLayout.setLayoutParams(layoutParams44);
            ViewGroup.LayoutParams layoutParams45 = this.countersLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams45, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams46 = (RelativeLayout.LayoutParams) layoutParams45;
            layoutParams46.removeRule(0);
            layoutParams46.addRule(1, this.centerView.getId());
            this.countersLayout.setLayoutParams(layoutParams46);
            ViewGroup.LayoutParams layoutParams47 = this.bkgLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams47, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams48 = (RelativeLayout.LayoutParams) layoutParams47;
            layoutParams48.removeRule(1);
            layoutParams48.addRule(0, this.countersLayout.getId());
            this.bkgLayout.setLayoutParams(layoutParams48);
            ViewGroup.LayoutParams layoutParams49 = this.advancedLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams49, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams50 = (RelativeLayout.LayoutParams) layoutParams49;
            layoutParams50.removeRule(1);
            layoutParams50.addRule(0, this.bkgLayout.getId());
            this.advancedLayout.setLayoutParams(layoutParams50);
            ViewGroup.LayoutParams layoutParams51 = this.advancedLayout1.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams51, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams52 = (RelativeLayout.LayoutParams) layoutParams51;
            layoutParams52.removeRule(0);
            layoutParams52.addRule(1, this.advancedLayout2.getId());
            this.advancedLayout1.setLayoutParams(layoutParams52);
            ViewGroup.LayoutParams layoutParams53 = this.advancedLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams53, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams54 = (RelativeLayout.LayoutParams) layoutParams53;
            layoutParams54.removeRule(0);
            layoutParams54.addRule(1, this.centerView.getId());
            this.advancedLayout2.setLayoutParams(layoutParams54);
            ViewGroup.LayoutParams layoutParams55 = this.advancedLayout3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams55, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams56 = (RelativeLayout.LayoutParams) layoutParams55;
            layoutParams56.removeRule(1);
            layoutParams56.addRule(0, this.advancedLayout2.getId());
            this.advancedLayout3.setLayoutParams(layoutParams56);
            ViewGroup.LayoutParams layoutParams57 = this.advancedLayout4.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams57, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams58 = (RelativeLayout.LayoutParams) layoutParams57;
            layoutParams58.removeRule(1);
            layoutParams58.addRule(0, this.advancedLayout3.getId());
            this.advancedLayout4.setLayoutParams(layoutParams58);
        } else if (i4 == 270) {
            ViewGroup.LayoutParams layoutParams59 = this.winLoseLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams59, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams60 = (RelativeLayout.LayoutParams) layoutParams59;
            layoutParams60.removeRule(15);
            layoutParams60.addRule(14);
            layoutParams60.removeRule(0);
            layoutParams60.addRule(3, this.countersLayout.getId());
            this.winLoseLayout.setLayoutParams(layoutParams60);
            ViewGroup.LayoutParams layoutParams61 = this.countersLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams61, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams62 = (RelativeLayout.LayoutParams) layoutParams61;
            layoutParams62.removeRule(15);
            layoutParams62.addRule(14);
            layoutParams62.removeRule(0);
            layoutParams62.addRule(3, this.centerView.getId());
            this.countersLayout.setLayoutParams(layoutParams62);
            ViewGroup.LayoutParams layoutParams63 = this.bkgLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams63, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams64 = (RelativeLayout.LayoutParams) layoutParams63;
            layoutParams64.removeRule(15);
            layoutParams64.addRule(14);
            layoutParams64.removeRule(1);
            layoutParams64.addRule(2, this.countersLayout.getId());
            this.bkgLayout.setLayoutParams(layoutParams64);
            ViewGroup.LayoutParams layoutParams65 = this.advancedLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams65, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams66 = (RelativeLayout.LayoutParams) layoutParams65;
            layoutParams66.removeRule(15);
            layoutParams66.addRule(14);
            layoutParams66.removeRule(1);
            layoutParams66.addRule(2, this.bkgLayout.getId());
            this.advancedLayout.setLayoutParams(layoutParams66);
            ViewGroup.LayoutParams layoutParams67 = this.advancedLayout1.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams67, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams68 = (RelativeLayout.LayoutParams) layoutParams67;
            layoutParams68.removeRule(15);
            layoutParams68.addRule(14);
            layoutParams68.removeRule(0);
            layoutParams68.addRule(3, this.advancedLayout2.getId());
            this.advancedLayout1.setLayoutParams(layoutParams68);
            ViewGroup.LayoutParams layoutParams69 = this.advancedLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams69, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams70 = (RelativeLayout.LayoutParams) layoutParams69;
            layoutParams70.removeRule(15);
            layoutParams70.addRule(14);
            layoutParams70.removeRule(0);
            layoutParams70.addRule(3, this.centerView.getId());
            this.advancedLayout2.setLayoutParams(layoutParams70);
            ViewGroup.LayoutParams layoutParams71 = this.advancedLayout3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams71, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams72 = (RelativeLayout.LayoutParams) layoutParams71;
            layoutParams72.removeRule(15);
            layoutParams72.addRule(14);
            layoutParams72.removeRule(1);
            layoutParams72.addRule(2, this.advancedLayout2.getId());
            this.advancedLayout3.setLayoutParams(layoutParams72);
            ViewGroup.LayoutParams layoutParams73 = this.advancedLayout4.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams73, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams74 = (RelativeLayout.LayoutParams) layoutParams73;
            layoutParams74.removeRule(15);
            layoutParams74.addRule(14);
            layoutParams74.removeRule(1);
            layoutParams74.addRule(2, this.advancedLayout3.getId());
            this.advancedLayout4.setLayoutParams(layoutParams74);
        }
        requestLayout();
    }

    public final void setState(String playerId, String playerName, Player player, int userId, String profileURL, boolean killed, boolean win, boolean partners, Drawable playmatImage, boolean energy, boolean storm, boolean experience, boolean tax, boolean radiation, boolean poison) {
        Intrinsics.checkNotNullParameter(playerId, "playerId");
        Intrinsics.checkNotNullParameter(playerName, "playerName");
        this.playerName = playerName;
        this.currentUserId = userId;
        this.profileUrl = profileURL;
        updatePlayerName(playerName);
        this.killed = killed;
        this.win = win;
        this.decksEnabled = this.currentUserId > 0;
        this.winEnabled = !killed;
        this.killEnabled = !win;
        if (killed || win) {
            this.bkgEnabled = false;
            this.bkgImage.setAlpha(0.35f);
            this.bkgLabel.setTextColor(ContextCompat.getColor(getContext(), R.color.dark_grey));
            this.partnersEnabled = false;
            this.advancedImage3.setAlpha(0.35f);
            this.advancedLabel3.setTextColor(ContextCompat.getColor(getContext(), R.color.dark_grey));
        } else {
            this.bkgEnabled = true;
            this.bkgImage.setAlpha(0.85f);
            this.bkgLabel.setTextColor(ContextCompat.getColor(getContext(), R.color.almost_white));
            this.partnersEnabled = true;
            this.advancedImage3.setAlpha(0.85f);
            this.advancedLabel3.setTextColor(ContextCompat.getColor(getContext(), R.color.almost_white));
        }
        if (this.disableDeckAndAdvanced) {
            this.bkgEnabled = false;
            this.bkgImage.setAlpha(0.35f);
            this.bkgLabel.setTextColor(ContextCompat.getColor(getContext(), R.color.dark_grey));
            this.partnersEnabled = false;
            this.advancedImage3.setAlpha(0.35f);
            this.advancedLabel3.setTextColor(ContextCompat.getColor(getContext(), R.color.dark_grey));
            this.advancedImage.setAlpha(0.35f);
            this.advancedLabel.setTextColor(ContextCompat.getColor(getContext(), R.color.dark_grey));
        }
        this.partners = partners;
        this.energy = energy;
        this.storm = storm;
        this.experience = experience;
        this.tax = tax;
        this.radiation = radiation;
        this.poison = poison;
        if (player != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            SwipeCountersAdapter swipeCountersAdapter = new SwipeCountersAdapter(context, this.poison, player, this.internalRotation, this);
            this.countersRecyclerView.setAdapter(swipeCountersAdapter);
            this.currentCountersAdapter = swipeCountersAdapter;
        }
        boolean z = this.decksEnabled;
        ImageView imageView = this.advancedImage2;
        if (z) {
            imageView.setAlpha(0.95f);
            this.advancedLabel2.setTextColor(ContextCompat.getColor(getContext(), R.color.almost_white));
        } else {
            imageView.setAlpha(0.35f);
            this.advancedLabel2.setTextColor(ContextCompat.getColor(getContext(), R.color.dark_grey));
        }
        ImageView imageView2 = this.advancedImage3;
        if (partners) {
            imageView2.setImageResource(R.drawable.partners_on);
        } else {
            imageView2.setImageResource(R.drawable.partners_off);
        }
        ImageView imageView3 = this.backgroundImage;
        if (playmatImage != null) {
            imageView3.setVisibility(0);
            this.overlay.setVisibility(0);
            this.backgroundImage.setImageDrawable(playmatImage);
        } else {
            imageView3.setVisibility(8);
            this.overlay.setVisibility(8);
        }
        this.bkgImage.setImageResource(R.drawable.bkg);
        this.bkgLabel.setText(getResources().getString(R.string.action_bkg));
        this.advancedLabel2.setText(getResources().getString(R.string.deck));
        this.advancedImage2.setImageResource(R.drawable.decks_white);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateGamePlayerSummaryDeck(int deckId) {
        Object next;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(context);
        Map<Integer, List<MTDeck>> allUsersDecks = preferencesManager.getAllUsersDecks();
        List<MTDeck> currentUserDecks = preferencesManager.getCurrentUserDecks();
        Map<Integer, MTDeck> gameSelectedDecks = preferencesManager.getGameSelectedDecks();
        MTDeck mTDeck = null;
        Object obj = null;
        if (deckId > 0) {
            List<MTDeck> list = allUsersDecks.get(Integer.valueOf(this.currentUserId));
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (((MTDeck) next).getId() == deckId) {
                            break;
                        }
                    }
                }
                MTDeck mTDeck2 = (MTDeck) next;
                if (mTDeck2 == null) {
                    Iterator<T> it2 = currentUserDecks.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next2 = it2.next();
                        if (((MTDeck) next2).getId() == deckId) {
                            obj = next2;
                            break;
                        }
                    }
                    mTDeck = (MTDeck) obj;
                    if (mTDeck == null) {
                        mTDeck = gameSelectedDecks.get(Integer.valueOf(deckId));
                    }
                } else {
                    mTDeck = mTDeck2;
                }
            }
        }
        if (mTDeck == null) {
            this.gpsDeckImage.setVisibility(8);
            this.deckName.setTextColor(getContext().getColor(R.color.text_color));
            this.deckName.setText(getContext().getString(R.string.no_deck_selected));
        } else {
            this.deckName.setText(mTDeck.getName());
            this.deckName.setTextColor(getContext().getColor(R.color.selected_color_new));
            DeckUtils companion = DeckUtils.INSTANCE.getInstance();
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            companion.fetchDeckData(context2, mTDeck, new Function1() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return SwipeMenuView.updateGamePlayerSummaryDeck$lambda$2(this.f$0, (MTDeckData) obj2);
                }
            }, new Function1() { // from class: com.studiolaganne.lengendarylens.SwipeMenuView$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return SwipeMenuView.updateGamePlayerSummaryDeck$lambda$3(this.f$0, (String) obj2);
                }
            });
        }
    }

    public final void updatePlayerName(String playerName) {
        Intrinsics.checkNotNullParameter(playerName, "playerName");
        this.playerName = playerName;
        int length = playerName.length();
        Typeface font = getResources().getFont(R.font.fa5regular);
        Intrinsics.checkNotNullExpressionValue(font, "getFont(...)");
        SpannableString spannableString = new SpannableString(playerName + " \uf044");
        if (this.currentUserId > 0) {
            spannableString = new SpannableString(String.valueOf(playerName));
        } else {
            spannableString.setSpan(new CustomTypefaceSpan(font), length + 1, spannableString.length(), 18);
        }
        this.playerNameLabel.setText(spannableString);
        String str = playerName;
        this.firstnameTextView.setText(str);
        if (this.gamePlayerSummaryMode) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
        int iDpToPx = (int) (((double) dpToPx(3, r0)) * 1.35d);
        int i = this.internalRotation;
        if (i == 90) {
            ViewGroup.LayoutParams layoutParams = this.playerNameLabel.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.rightMargin = str.length() < 5 ? 0 : (-iDpToPx) * str.length();
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            layoutParams2.leftMargin = 0;
            this.playerNameLabel.setLayoutParams(layoutParams2);
        } else if (i == 270) {
            ViewGroup.LayoutParams layoutParams3 = this.playerNameLabel.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            layoutParams4.leftMargin = str.length() < 5 ? 0 : (-iDpToPx) * str.length();
            layoutParams4.topMargin = 0;
            layoutParams4.bottomMargin = 0;
            layoutParams4.rightMargin = 0;
            this.playerNameLabel.setLayoutParams(layoutParams4);
        }
        int i2 = this.currentUserId;
        ConstraintLayout constraintLayout = this.profileLayout;
        if (i2 <= 0) {
            constraintLayout.setVisibility(8);
            return;
        }
        constraintLayout.setVisibility(0);
        this.profileLayout.setOutlineProvider(new CircularOutlineProvider());
        this.profileLayout.setClipToOutline(true);
        this.profileIcon.setOutlineProvider(new CircularOutlineProvider());
        this.profileIcon.setClipToOutline(true);
        String str2 = this.profileUrl;
        if (str2 == null) {
            this.profileIcon.setVisibility(8);
            this.noPhotoIcon.setVisibility(0);
            return;
        }
        this.profileIcon.setVisibility(0);
        this.noPhotoIcon.setVisibility(8);
        this.profileIcon.reset();
        this.profileIcon.setAutoLoad(false);
        this.profileIcon.loadImage(str2);
    }
}
