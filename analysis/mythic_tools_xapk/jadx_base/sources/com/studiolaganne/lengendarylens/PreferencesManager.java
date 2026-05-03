package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.util.Log;
import androidx.preference.PreferenceManager;
import androidx.window.reflection.WindowExtensionsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: PreferencesManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b'\b\u0007\u0018\u0000 \u0087\u00022\u00020\u0001:\u0002\u0087\u0002B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0011J\u0018\u0010\u0016\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0018J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\fJ\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\fJ\u000e\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\fJ\u000e\u0010&\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\fJ\u0006\u0010'\u001a\u00020\u001fJ\b\u0010(\u001a\u0004\u0018\u00010)J\u000e\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020)J\u0006\u0010,\u001a\u00020\u000eJ\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.J\u000e\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000200J\u0006\u00103\u001a\u00020\u000eJ\u0006\u00104\u001a\u00020\u001fJ\b\u00105\u001a\u0004\u0018\u000106J\u000e\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u000206J\u0006\u00109\u001a\u00020\u000eJ\f\u0010:\u001a\b\u0012\u0004\u0012\u00020)0\u000bJ\u0014\u0010;\u001a\u00020\u000e2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020)0\u000bJ\u0006\u0010=\u001a\u00020\u000eJ\f\u0010>\u001a\b\u0012\u0004\u0012\u0002060\u000bJ\u0014\u0010?\u001a\u00020\u000e2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002060\u000bJ\u0006\u0010A\u001a\u00020\u000eJ\b\u0010B\u001a\u0004\u0018\u00010CJ\u0006\u0010D\u001a\u00020EJ\u000e\u0010F\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020EJ\u0006\u0010H\u001a\u00020\u001fJ\u000e\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020CJ\u0006\u0010K\u001a\u00020\u001fJ\u000e\u0010L\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020\u001fJ\u0006\u0010N\u001a\u00020\u001fJ\u000e\u0010O\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001fJ\u0006\u0010P\u001a\u00020\u000eJ\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\u000bJ\u0014\u0010S\u001a\u00020\u000e2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020R0\u000bJ\u0006\u0010U\u001a\u00020\u000eJ\u0018\u0010V\u001a\u0014\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000b0.J \u0010W\u001a\u00020\u000e2\u0018\u0010X\u001a\u0014\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000b0.J\u0006\u0010Y\u001a\u00020\u000eJ\f\u0010Z\u001a\b\u0012\u0004\u0012\u0002000\u000bJ\f\u0010[\u001a\b\u0012\u0004\u0012\u0002000\u000bJ\u0014\u0010\\\u001a\u00020\u000e2\f\u0010X\u001a\b\u0012\u0004\u0012\u0002000\u000bJ\u0014\u0010]\u001a\u00020\u000e2\f\u0010X\u001a\b\u0012\u0004\u0012\u0002000\u000bJ\u0006\u0010^\u001a\u00020\u000eJ\u0006\u0010_\u001a\u00020\u000eJ\f\u0010`\u001a\b\u0012\u0004\u0012\u00020a0\u000bJ\u0014\u0010b\u001a\u00020\u000e2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020a0\u000bJ\u0006\u0010d\u001a\u00020\u000eJ\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000bJ\u0014\u0010f\u001a\u00020\u000e2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000bJ\u0006\u0010h\u001a\u00020\u000eJ\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000bJ\u0014\u0010j\u001a\u00020\u000e2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000bJ\u0006\u0010k\u001a\u00020\u000eJ\u0014\u0010l\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000b2\u0006\u0010m\u001a\u00020/J\u001c\u0010n\u001a\u00020\u000e2\u0006\u0010m\u001a\u00020/2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000bJ\u000e\u0010o\u001a\u00020\u000e2\u0006\u0010m\u001a\u00020/J\b\u0010p\u001a\u0004\u0018\u00010qJ\u000e\u0010r\u001a\u00020\u000e2\u0006\u0010c\u001a\u00020qJ\u0006\u0010s\u001a\u00020\u000eJ\b\u0010t\u001a\u0004\u0018\u00010uJ\u000e\u0010v\u001a\u00020\u000e2\u0006\u0010c\u001a\u00020uJ\u0006\u0010w\u001a\u00020\u000eJ\f\u0010x\u001a\b\u0012\u0004\u0012\u00020y0\u000bJ\u0014\u0010z\u001a\u00020\u000e2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020y0\u000bJ\u0006\u0010{\u001a\u00020\u000eJ\f\u0010|\u001a\b\u0012\u0004\u0012\u00020C0\u000bJ\u0014\u0010}\u001a\u00020\u000e2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020C0\u000bJ\u0006\u0010~\u001a\u00020\u000eJ\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001J\u0011\u0010\u0081\u0001\u001a\u00020\u000e2\b\u0010\u0082\u0001\u001a\u00030\u0080\u0001J\u0007\u0010\u0083\u0001\u001a\u00020\u000eJ\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001J\u0011\u0010\u0086\u0001\u001a\u00020\u000e2\b\u0010\u0087\u0001\u001a\u00030\u0085\u0001J\u0007\u0010\u0088\u0001\u001a\u00020\u000eJ\r\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020/0\u000bJ\u0015\u0010\u008a\u0001\u001a\u00020\u000e2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020/0\u000bJ\u0007\u0010\u008b\u0001\u001a\u00020\u000eJ\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020/0\u000bJ\u0015\u0010\u008d\u0001\u001a\u00020\u000e2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020/0\u000bJ\u0007\u0010\u008e\u0001\u001a\u00020\u000eJ\u0007\u0010\u008f\u0001\u001a\u00020\u001fJ\u0010\u0010\u0090\u0001\u001a\u00020\u000e2\u0007\u0010\u0091\u0001\u001a\u00020\u001fJ\u0007\u0010\u0092\u0001\u001a\u00020EJ\u000f\u0010\u0093\u0001\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020EJ\u0007\u0010\u0094\u0001\u001a\u00020EJ\u000f\u0010\u0095\u0001\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020EJ\u0007\u0010\u0096\u0001\u001a\u00020\u001fJ\n\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001J\u0010\u0010\u0099\u0001\u001a\u00020\u000e2\u0007\u0010+\u001a\u00030\u0098\u0001J\u0007\u0010\u009a\u0001\u001a\u00020\u000eJ\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001J\u0007\u0010\u009d\u0001\u001a\u00020\u001fJ\u000f\u0010\u009e\u0001\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001fJ\u0007\u0010\u009f\u0001\u001a\u00020\u001fJ\u000f\u0010 \u0001\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001fJ\u0007\u0010¡\u0001\u001a\u00020\u001fJ\u000f\u0010¢\u0001\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001fJ\r\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\r\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0010\u0010¥\u0001\u001a\u00020\u001f2\u0007\u0010¦\u0001\u001a\u00020\fJ\u0019\u0010§\u0001\u001a\u00020\u000e2\u0007\u0010¦\u0001\u001a\u00020\f2\u0007\u0010¨\u0001\u001a\u00020\u001fJ\u0010\u0010©\u0001\u001a\u00020\f2\u0007\u0010ª\u0001\u001a\u00020\fJ\u0007\u0010«\u0001\u001a\u00020\fJ\b\u0010¬\u0001\u001a\u00030\u00ad\u0001J\b\u0010®\u0001\u001a\u00030¯\u0001J\u0011\u0010°\u0001\u001a\u00020\u000e2\b\u0010±\u0001\u001a\u00030¯\u0001J\u0007\u0010²\u0001\u001a\u00020\fJ\n\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001J\u0007\u0010µ\u0001\u001a\u00020\fJ\u0010\u0010¶\u0001\u001a\u00020\u000e2\u0007\u0010·\u0001\u001a\u00020\fJ\r\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0010\u0010¹\u0001\u001a\u00020\u000e2\u0007\u0010º\u0001\u001a\u00020\fJ\u0007\u0010»\u0001\u001a\u00020\u000eJ\r\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0016\u0010½\u0001\u001a\u00020\u000e2\r\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0010\u0010¿\u0001\u001a\u00020\u000e2\u0007\u0010º\u0001\u001a\u00020\fJ\u0007\u0010À\u0001\u001a\u00020\u000eJ\u000e\u0010Á\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u00010\u000bJ\u0017\u0010Ã\u0001\u001a\u00020\u000e2\u000e\u0010¾\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u00010\u000bJ\u0007\u0010Ä\u0001\u001a\u00020\u000eJ\u0013\u0010Å\u0001\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0.J\u001b\u0010Æ\u0001\u001a\u00020\u000e2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0.J\u0007\u0010Ç\u0001\u001a\u00020\u000eJ\u0013\u0010È\u0001\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020/0.J\u001b\u0010É\u0001\u001a\u00020\u000e2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020/0.J\r\u0010Ê\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000bJ\u0015\u0010Ë\u0001\u001a\u00020\u000e2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000bJ\u000f\u0010Ì\u0001\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0007\u0010Í\u0001\u001a\u00020\u000eJ\u000e\u0010Î\u0001\u001a\t\u0012\u0005\u0012\u00030Ï\u00010\u000bJ\u0007\u0010Ð\u0001\u001a\u00020\u000eJ\u0019\u0010Ñ\u0001\u001a\u00020\u001f2\u0007\u0010Ò\u0001\u001a\u00020\f2\u0007\u0010Ó\u0001\u001a\u00020\u001fJ\u0018\u0010Ô\u0001\u001a\u00020\u000e2\u0007\u0010Ò\u0001\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001fJ\u0019\u0010Õ\u0001\u001a\u00020/2\u0007\u0010Ò\u0001\u001a\u00020\f2\u0007\u0010Ó\u0001\u001a\u00020/J\u0019\u0010Ö\u0001\u001a\u00020/2\u0007\u0010Ò\u0001\u001a\u00020\f2\u0007\u0010Ó\u0001\u001a\u00020/J\u0018\u0010×\u0001\u001a\u00020\u000e2\u0007\u0010Ò\u0001\u001a\u00020\f2\u0006\u0010!\u001a\u00020/J\u0019\u0010Ø\u0001\u001a\u00020\f2\u0007\u0010Ò\u0001\u001a\u00020\f2\u0007\u0010Ó\u0001\u001a\u00020\fJ\u0018\u0010Ù\u0001\u001a\u00020\u000e2\u0007\u0010Ò\u0001\u001a\u00020\f2\u0006\u0010!\u001a\u00020\fJ\u001b\u0010Ú\u0001\u001a\u00030Û\u00012\u0007\u0010Ò\u0001\u001a\u00020\f2\b\u0010Ó\u0001\u001a\u00030Û\u0001J\u0019\u0010Ü\u0001\u001a\u00020\u000e2\u0007\u0010Ò\u0001\u001a\u00020\f2\u0007\u0010!\u001a\u00030Û\u0001J\u0010\u0010Ý\u0001\u001a\u00020\u000e2\u0007\u0010Ò\u0001\u001a\u00020/J\u0010\u0010Þ\u0001\u001a\u00020\u001f2\u0007\u0010Ò\u0001\u001a\u00020/J\u0011\u0010ß\u0001\u001a\u00020\u000e2\b\u0010à\u0001\u001a\u00030á\u0001J\n\u0010â\u0001\u001a\u0005\u0018\u00010á\u0001J\u0007\u0010ã\u0001\u001a\u00020\u000eJ\u0007\u0010ä\u0001\u001a\u00020\fJ\u0010\u0010å\u0001\u001a\u00020\u000e2\u0007\u0010æ\u0001\u001a\u00020\fJ\u0007\u0010ç\u0001\u001a\u00020\u000eJ\t\u0010è\u0001\u001a\u0004\u0018\u00010\fJ\u0011\u0010é\u0001\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\fJ\t\u0010ê\u0001\u001a\u0004\u0018\u00010\fJ\u0011\u0010ë\u0001\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\fJ\t\u0010ì\u0001\u001a\u0004\u0018\u00010\fJ\u0011\u0010í\u0001\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\fJ\u0007\u0010î\u0001\u001a\u00020\u001fJ\u000f\u0010ï\u0001\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001fJ\t\u0010ð\u0001\u001a\u0004\u0018\u00010\fJ\u0011\u0010ñ\u0001\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\fJ\t\u0010ò\u0001\u001a\u0004\u0018\u00010\fJ\u0011\u0010ó\u0001\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\fJ\t\u0010ô\u0001\u001a\u0004\u0018\u00010\fJ\u0011\u0010õ\u0001\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\fJ\u0007\u0010ö\u0001\u001a\u00020\u001fJ\u000f\u0010÷\u0001\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001fJ\u0007\u0010ø\u0001\u001a\u00020\fJ\u000f\u0010ù\u0001\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\fJ\u0007\u0010ú\u0001\u001a\u00020\u001fJ\u000f\u0010û\u0001\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001fJ\u0007\u0010ü\u0001\u001a\u00020/J\u0007\u0010ý\u0001\u001a\u00020\u000eJ\u0007\u0010þ\u0001\u001a\u00020/J\u0007\u0010ÿ\u0001\u001a\u00020\u000eJ\u0007\u0010\u0080\u0002\u001a\u00020/J\u0007\u0010\u0081\u0002\u001a\u00020\u000eJ\u0010\u0010\u0082\u0002\u001a\u00020/2\u0007\u0010\u0083\u0002\u001a\u00020/J\u0010\u0010\u0084\u0002\u001a\u00020\u000e2\u0007\u0010\u0083\u0002\u001a\u00020/J\u0007\u0010\u0085\u0002\u001a\u00020\u000eJ\u0007\u0010\u0086\u0002\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0088\u0002"}, d2 = {"Lcom/studiolaganne/lengendarylens/PreferencesManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "editor", "Landroid/content/SharedPreferences$Editor;", "languages", "", "", "debugDeviceLanguage", "", "debugCompiledResources", "getMTUserSettings", "Lcom/studiolaganne/lengendarylens/MTUserSettings;", "convertIOSFontNameToAndroid", "iosFontName", "applyMTUserSettings", "settings", "syncCurrentSettingsToAPI", "onComplete", "Lkotlin/Function0;", "syncThemePurchase", "currentSku", "syncRecentCard", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "isBatterySavingMode", "", "setBatterySavingMode", "value", "getCurrentSearch", "getCurrentSetFilter", "setCurrentSearch", FirebaseAnalytics.Event.SEARCH, "setCurrentSetFilter", "hasGame", "getCurrentGame", "Lcom/studiolaganne/lengendarylens/GameState;", "saveCurrentGame", ServerProtocol.DIALOG_PARAM_STATE, "clearCurrentGame", "getGameSelectedDecks", "", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "saveGameSelectedDeck", "deck", "clearGameSelectedDecks", "hasSet", "getCurrentSet", "Lcom/studiolaganne/lengendarylens/GameSet;", "saveCurrentSet", "set", "clearCurrentSet", "getUnSyncedGames", "saveUnSyncedGames", "games", "clearUnSyncedGames", "getUnSyncedSets", "saveUnSyncedSets", "sets", "clearUnSyncedSets", "getCurrentUser", "Lcom/studiolaganne/lengendarylens/MTUser;", "getTokenExpiryTime", "", "setTokenExpiryTime", "time", "hasValidUser", "saveCurrentUser", "user", "isMythicPlusActive", "setMythicPlusActive", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "isMythicPlusBannerDismissed", "setMythicPlusBannerDismissed", "clearCurrentUser", "getCurrentUserPlaygroups", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "saveCurrentUserPlaygroups", "playgroups", "clearCurrentUserPlaygroups", "getAllUsersDecks", "saveAllUsersDecks", "decks", "clearAllUsersDecks", "getCurrentUserDecks", "getCurrentUserArchivedDecks", "saveCurrentUserArchivedDecks", "saveCurrentUserDecks", "clearCurrentUserArchivedDecks", "clearCurrentUserDecks", "getCurrentUserFriends", "Lcom/studiolaganne/lengendarylens/MTFriend;", "saveCurrentUserFriends", NativeProtocol.AUDIENCE_FRIENDS, "clearCurrentUserFriends", "getCurrentUserScanList", "saveCurrentUserScanList", "list", "clearCurrentUserScanList", "getCurrentDeckScanList", "saveCurrentDeckScanList", "clearCurrentDeckScanList", "getCurrentListScanList", "listId", "saveCurrentListScanList", "clearCurrentListScanList", "getCurrentUserCollection", "Lcom/studiolaganne/lengendarylens/MTCollection;", "saveCurrentUserCollection", "clearCurrentUserCollection", "getCurrentUserLists", "Lcom/studiolaganne/lengendarylens/MTUserLists;", "saveCurrentUserLists", "clearCurrentUserLists", "getCurrentUserTrophies", "Lcom/studiolaganne/lengendarylens/MTTrophy;", "saveCurrentUserTrophies", "clearCurrentUserTrophies", "getCurrentUserCache", "saveCurrentUserCache", "clearCurrentUserCache", "getCurrentUserTags", "Lcom/studiolaganne/lengendarylens/MTUserTags;", "saveCurrentUserTags", "tags", "clearCurrentUserTags", "getCurrentUserPrivacy", "Lcom/studiolaganne/lengendarylens/MTUserPrivacy;", "saveCurrentUserPrivacy", "privacy", "clearCurrentUserPrivacy", "getUndoKOs", "saveUndoKOs", "clearUndoKOs", "getUndoWins", "saveUndoWins", "clearUndoWins", "getForcedApiUpdate", "setForcedApiUpdate", "forced", "getLastApiUpdate", "setLastApiUpdate", "getLastMessagesUpdate", "setLastMessagesUpdate", "hasTournament", "getCurrentTournament", "Lcom/studiolaganne/lengendarylens/Tournament;", "saveCurrentTournament", "clearCurrentTournament", "getLowlifeEffect", "Lcom/studiolaganne/lengendarylens/LowlifeEffect;", "isFirstRun", "setFirstRun", "isFirstRunV2", "setFirstRunV2", "isSecondRun", "setSecondRun", "getSupportedLanguages", "getEnabledLanguages", "isLanguageEnabled", "language", "setLanguageEnabled", "enabled", "getNameForLanguage", "lang", "getDeviceLanguage", "getScanDisplayLanguage", "Lcom/studiolaganne/lengendarylens/ScanDisplayLanguage;", "getPreferredCardLayout", "Lcom/studiolaganne/lengendarylens/CardsLayout;", "setPreferredCardLayout", WindowExtensionsConstants.LAYOUT_PACKAGE, "getPreferredCurrency", "getPreferredCurrencyInfo", "Lcom/studiolaganne/lengendarylens/CurrencyInfo;", "getPreferredMarket", "setPreferredMarket", "market", "getUnlockedPlaymats", "addUnlockedPlaymat", "code", "clearUnlockedPlaymats", "getThemesPurchased", "setThemesPurchased", "themes", "addThemePurchased", "clearAllThemesPurchased", "getLocalThemesCache", "Lcom/studiolaganne/lengendarylens/MTTheme;", "saveLocalThemesCache", "clearLocalThemesCache", "getAllThemeTokens", "saveAllThemeTokens", "clearAllThemeTokens", "getAllThemeVersions", "saveAllThemeVersions", "getRecentCardsNew", "setRecentCardsNew", "addRecentCardNew", "clearRecentCardsNew", "getRecentCardsOld", "Lcom/studiolaganne/lengendarylens/CardState;", "clearRecentCardsOld", "getBoolean", "id", "defaultValue", "setBoolean", "getIntFromString", "getInt", "setInt", "getString", "setString", "getFloat", "", "setFloat", "setOnboardingSeen", "wasOnboardingSeen", "saveCurrentUserFavorites", "favorites", "Lcom/studiolaganne/lengendarylens/MTFavorites;", "getCurrentUserFavorites", "clearCurrentUserFavorites", "getLastDeckListSelection", "setLastDeckListSelection", "selection", "resetDeckListSelection", "getLastGroupBy", "setLastGroupBy", "getLastOrderBy", "setLastOrderBy", "getLastOrderDirection", "setLastOrderDirection", "getSaveSortingGroupingSettings", "setSaveSortingGroupingSettings", "getLastDeckListGroupBy", "setLastDeckListGroupBy", "getLastDeckListOrderBy", "setLastDeckListOrderBy", "getLastDeckListOrderDirection", "setLastDeckListOrderDirection", "getSaveDeckListSortingGroupingSettings", "setSaveDeckListSortingGroupingSettings", "getDeckSortOrder", "setDeckSortOrder", "getClearScanListAfterAdd", "setClearScanListAfterAdd", "getCollectionVersion", "incrementCollectionVersion", "getListsVersion", "incrementListsVersion", "getDecksVersion", "incrementDecksVersion", "getContainerVersion", "containerId", "incrementContainerVersion", "incrementAllContainerVersions", "invalidateAllContainers", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreferencesManager {
    public static final String AF_PURCHASE = "afterhours";
    public static final String AF_THEME = "theme_afterhours";
    public static final String ALL_THEME_TOKENS = "all_themes_tokens";
    public static final String ALL_THEME_VERSIONS = "all_themes_versions";
    public static final String ALL_USER_DECKS = "all_user_decks";
    public static final String ALWAYS_SHOW_TIMER = "always_show_timer";
    public static final String APP_LANGUAGE = "app_language";
    public static final String ASK_FOR_NOTIFICATIONS = "ASK_FOR_NOTIFICATIONS";
    public static final String AUTH_PROVIDER = "auth_provider";
    public static final String AUTO_ENABLE_TURN_TIMER = "auto_enable_turn_timer";
    public static final String AUTO_START_TIMER = "auto_start_timer";
    public static final String BACKGROUND_BLACK = "black";
    public static final String BACKGROUND_BY_DEFAULT = "default_background";
    public static final String BACKGROUND_COLOR = "color";
    public static final String BACKGROUND_PLAYMAT = "playmat";
    public static final String BATTERY_SAVING_MODE = "battery_saving_mode";
    public static final String BO_HELP_DISMISSED = "bo_help_dismissed";
    public static final String BRACKET_TYPE_AUTO = "auto_set";
    public static final String BRACKET_TYPE_NOT_SET = "not_set";
    public static final String BRACKET_TYPE_USER = "user_set";
    public static final String BURN_PURCHASE = "mythic_burn";
    public static final String BURN_THEME = "theme_burn";
    public static final String CAMERA_PERMISSION_ASKED_BEFORE = "camera_permission_asked_before";
    public static final String CARD_RATING_PROMPT_SHOWN = "card_rating_prompt_shown";
    public static final String CLEAR_SCAN_LIST_AFTER_ADD = "clear_scan_list_after_add";
    public static final String COLLECTION_VERSION = "collection_version";
    public static final String CONDENSE_SEARCH = "condense_search";
    public static final String CONTAINER_VERSION_PREFIX = "container_version_";
    public static final String CREATOR_CODE = "creator_code";
    public static final String CURRENT_DECK_SCAN_LIST = "current_deck_scan_list";
    public static final String CURRENT_FRIEND_CODE = "current_friend_code";
    private static final String CURRENT_GAME = "current_game";
    public static final String CURRENT_QR_CODE = "current_qr_code";
    public static final String CURRENT_SEARCH = "current_search";
    public static final String CURRENT_SEARCH_LANGUAGE = "current_search_language";
    private static final String CURRENT_SET = "current_set";
    public static final String CURRENT_SET_FILTER = "current_set_filter";
    private static final String CURRENT_TOURNAMENT = "current_tournament";
    public static final String CURRENT_USER = "current_user";
    public static final String CURRENT_USER_ARCHIVED_DECKS = "current_user_archived_decks";
    public static final String CURRENT_USER_CACHE = "current_user_cache";
    public static final String CURRENT_USER_COLLECTION = "current_user_collection";
    public static final String CURRENT_USER_DECKS = "current_user_decks";
    public static final String CURRENT_USER_FAVORITES = "current_user_favorites";
    public static final String CURRENT_USER_FRIENDS = "current_user_friends";
    public static final String CURRENT_USER_LISTS = "current_user_lists";
    public static final String CURRENT_USER_PLAYGROUPS = "current_user_playgroups";
    public static final String CURRENT_USER_PRIVACY = "current_user_privacy";
    public static final String CURRENT_USER_SCAN_LIST = "current_user_scan_list";
    public static final String CURRENT_USER_TAGS = "current_user_tags";
    public static final String CURRENT_USER_TROPHIES = "current_user_trophies";
    public static final String CUSTOM_API_HOST = "custom_api_host";
    public static final String CUSTOM_API_HOST_ENABLED = "custom_api_host_enabled";
    public static final String DECKS_VERSION = "decks_version";
    public static final String DECK_RATING_PROMPT_SHOWN = "deck_rating_prompt_shown";
    public static final String DECK_SORT_ORDER = "deck_sort_order";
    public static final String DEFAULT_DECK_DURATION = "default_deck_duration";
    public static final String DEFAULT_DRAFT_DURATION = "default_draft_duration";
    public static final String DEFAULT_TIMER_TIME = "default_timer_time";
    public static final String DISABLE_WIN_LOSE_ANIMATIONS = "disable_win_lose_animations";
    public static final String DISABLE_WIN_LOSE_QUESTIONS = "disable_win_lose_questions";
    public static final String DISPLAY_GAME_EVENTS = "display_game_events";
    public static final String EMAIL_BANNER_DISMISSED = "email_banner_dismissed";
    public static final String EMAIL_OPT_IN = "email_opt_in";
    public static final String ENABLE_BATTERY_SAVING_PROMPTS = "enable_battery_saving_prompts";
    public static final String ENABLE_COMMANDER_TAX_BY_DEFAULT = "enable_commander_tax_by_default";
    public static final String ENABLE_FULLSCREEN_MODE = "enable_fullscreen_mode";
    public static final String ENABLE_HIGH_CMD_DAMAGE_ANIM = "enable_high_cmd_damage_anim";
    public static final String ENABLE_HIGH_POISON_ANIM = "enable_high_poison_counters_anim";
    public static final String ENABLE_KO_MESSAGES = "enable_ko_messages";
    public static final String ENABLE_LOW_LIFE_ANIM = "enable_low_life_anim";
    public static final String ENABLE_LOW_LIFE_BKG = "enable_low_life_bkg";
    public static final String ENABLE_PLAYER_TOSS = "enable_player_toss";
    public static final String ENABLE_POISON_COUNTERS_BY_DEFAULT = "enable_poison_counters_by_default";
    public static final String ENABLE_SCAN_BEEPS = "enable_scan_beeps";
    public static final String ENABLE_STREAMING = "enable_streaming";
    public static final String ENABLE_TIMER_BY_DEFAULT = "enable_timer_by_default";
    public static final String ENABLE_UDED_Q = "enable_uded_q";
    public static final String FCM_TOKEN = "fcm_token";
    public static final String FIREBASE_TOKEN = "firebase_id_token";
    private static final String FIRST_RUN = "first_run";
    private static final String FIRST_RUN_V2 = "first_run_v2";
    public static final String FORCE_PREPROD_API = "force_preprod_api";
    public static final String GAME_FONT_DEFAULT = "game_font_default";
    public static final String GAME_MENU_RATING_BANNER_DISMISSED = "game_menu_rating_banner_dismissed";
    public static final String GAME_RATING_PROMPT_SHOWN = "game_rating_prompt_shown";
    private static final String GAME_SELECTED_DECKS = "game_selected_decks";
    public static final String GAME_TUTORIAL_SHOWN = "game_tutorial_shown";
    public static final String GOOGLE_TOKEN = "google_token";
    public static final String GO_TO_SIGN_IN = "GO_TO_SIGN_IN";
    public static final String HIGH_CMD_DAMAGE_THRESHOLD = "high_cmd_damage_threshold";
    public static final String HIGH_POISON_THRESHOLD = "high_poison_threshold";
    public static final String IGNORE_BASIC_LANDS = "ignore_basic_lands";
    public static final String IGNORE_COLLECTION = "ignore_collection";
    public static final String IGNORE_PRINTINGS = "ignore_printings";
    public static final String INTENT_TO_PROCESS = "intent_to_process";
    public static final String LAST_CARD_PICKER_LANGUAGE = "last_card_picker_language";
    public static final String LAST_COLLECTION_LAYOUT_TYPE = "last_collection_layout_type";
    public static final String LAST_DECK_LAYOUT_TYPE = "last_deck_layout_type";
    public static final String LAST_DECK_LIST_GROUP_BY = "last_deck_list_group_by";
    public static final String LAST_DECK_LIST_ORDER_BY = "last_deck_list_order_by";
    public static final String LAST_DECK_LIST_ORDER_DIRECTION = "last_deck_list_order_direction";
    public static final String LAST_DECK_LIST_SELECTION = "last_deck_list_selection";
    public static final String LAST_GROUP_BY = "last_group_by";
    public static final String LAST_ORDER_BY = "last_order_by";
    public static final String LAST_ORDER_DIRECTION = "last_order_direction";
    public static final String LAST_RULEBOOK_LANGUAGE = "last_rulebook_language";
    public static final String LAST_SCAN_DATE = "last_scan_date";
    public static final String LISTS_VERSION = "lists_version";
    public static final String LOCAL_THEMES_CACHE = "local_themes_cache";
    public static final String LOVE_PURCHASE = "mythic_love";
    public static final String LOVE_THEME = "theme_love";
    private static final String LOW_LIFE_ANIM = "low_life_anim_default";
    public static final String LOW_LIFE_THRESHOLD = "low_life_threshold";
    public static final String LUPO_PURCHASE = "DrLupo";
    public static final String LUPO_THEME = "theme_drlupo";
    public static final String MESSAGE_INTENT = "com.studiolaganne.mythictools.MESSAGE_RECEIVED";
    public static final String MSG_TYPE_FRIENDSHIP_ACCEPTED = "FRIENDSHIP_ACCEPTED";
    public static final String MSG_TYPE_FRIENDSHIP_REQUEST = "REQUEST_FRIENDSHIP";
    public static final String MSG_TYPE_PLAYGROUP_INVITE = "PLAYGROUP_INVITE";
    public static final String MSG_TYPE_PLAYGROUP_JOIN = "PLAYGROUP_INVITE_ACCEPTED";
    public static final String MSG_TYPE_PLAYGROUP_MESSAGE = "PLAYGROUP_MESSAGE";
    public static final String MSG_TYPE_SHARED_COLLECTION_ACCEPTED = "SHARED_COLLECTION_ACCEPTED";
    public static final String MSG_TYPE_SHARED_COLLECTION_INVITE = "SHARED_COLLECTION_INVITE";
    public static final String MSG_TYPE_SHARED_COLLECTION_REJECTED = "SHARED_COLLECTION_REJECTED";
    public static final String MSG_TYPE_UNSHARE_COLLECTION_ACCEPTED = "UNSHARE_COLLECTION_ACCEPTED";
    public static final String MSG_TYPE_UNSHARE_COLLECTION_INVITE = "UNSHARE_COLLECTION_INVITE";
    public static final String MSG_TYPE_UNSHARE_COLLECTION_REJECTED = "UNSHARE_COLLECTION_REJECTED";
    public static final String MYTHIC_PLUS_ACTIVE = "mythic_plus_active";
    public static final String MYTHIC_PLUS_BANNER_DISMISSED = "mythic_plus_banner_dismissed";
    public static final String NEED_USER_RELOAD = "need_user_reload";
    public static final String NUM_EVENTS = "num_events";
    public static final String NUM_GAMES = "num_games";
    public static final String NUM_SCANS = "num_scans";
    public static final String ONBOARDING_DONE = "onboarding_done";
    private static final String ONBOARDING_SEEN_PREFIX = "onboarding_seen_";
    public static final String PREFERRED_CARDS_LAYOUT = "preferred_card_layout";
    public static final String PREFERRED_CURRENCY = "preferred_currency";
    public static final String PREFERRED_CURRENCY_V2 = "preferred_currency_v2";
    public static final String PREFERRED_MARKET = "preferred_market";
    public static final String RATING_BANNER_DISMISSED = "rating_banner_dismissed";
    public static final String RECENT_CARDS = "recent_cards";
    public static final String RECENT_CARDS_LIST_NAME = "recent";
    public static final String RECENT_CARDS_NEW = "recent_cards_new";
    public static final String REFRESH_THEMES = "refresh_themes";
    public static final String SAVE_DECK_LIST_SORTING_GROUPING_SETTINGS = "save_deck_list_sorting_grouping_settings";
    public static final String SAVE_SORTING_GROUPING_SETTINGS = "save_sorting_grouping_settings";
    public static final String SCAN_DISPLAY_LANGUAGE = "scan_display_language";
    public static final String SCAN_HIGH_PRICE_BEEP_ENABLED = "scan_high_price_beep_enabled";
    public static final String SCAN_HIGH_PRICE_THRESHOLD = "scan_high_price_threshold";
    public static final String SCAN_OVERRIDE_FINISH = "scan_override_finish";
    public static final String SCAN_OVERRIDE_FINISH_ENABLED = "scan_override_finish_enabled";
    public static final String SCAN_OVERRIDE_LANGUAGE = "scan_override_language";
    public static final String SCAN_OVERRIDE_LANGUAGE_ENABLED = "scan_override_language_enabled";
    public static final String SCAN_OVERRIDE_SET = "scan_override_set";
    public static final String SCAN_OVERRIDE_SET_ENABLED = "scan_override_set_enabled";
    public static final String SCAN_PURCHASE_PRICE_ENABLED = "scan_purchase_price_enabled";
    public static final String SCAN_PURCHASE_PRICE_FIXED = "scan_purchase_price_fixed";
    public static final String SCAN_PURCHASE_PRICE_MODE = "scan_purchase_price_mode";
    public static final String SCAN_RATING_PROMPT_SHOWN = "scan_rating_prompt_shown";
    public static final String SCAN_TUTORIAL_DONE = "scan_tutorial_done";
    public static final String SEARCH_LANGUAGE_FILTER = "search_language_filter";
    private static final String SECOND_RUN = "second_run";
    public static final String SHARED_COLLECTION_BADGE_COUNT = "shared_collection_badge_count";
    public static final String SIGN_UP_ACTIVE = "SIGN_UP_ACTIVE";
    public static final String SOLRING_PURCHASE = "solring";
    public static final String SOLRING_THEME = "theme_solring";
    public static final String STORE_BANNER_DISMISSED = "store_banner_dismissed";
    public static final String SWIPE_TUTORIAL_DONE = "swipe_tutorial_done";
    public static final String THEMES_PUCHASED = "themes_purchased";
    public static final String TIMER_HINT_SHOWN = "timer_hint_shown";
    public static final String TIMER_SHOW_SECONDS = "timer_show_seconds";
    public static final String TOKEN_EXPIRY_TIME = "token_expiry_time";
    public static final String TRANSLATE_RULINGS = "translate_rulings";
    public static final String TURN_TIMER_DISPLAY = "turn_timer_display";
    public static final String TURN_TIMER_DISPLAY_CURRENT = "current_turn";
    public static final String TURN_TIMER_DISPLAY_TOTAL = "total_time";
    public static final String UNDO_KO_INDEXES = "undo_ko_indexes";
    public static final String UNDO_WIN_INDEXES = "undo_win_indexes";
    public static final String UNLOCKED_PLAYMATS = "unlocked_playmats";
    public static final String UNSYNCED_GAMES = "unsynced_games";
    public static final String UNSYNCED_SETS = "unsynced_sets";
    public static final String UPDATE_MESSAGES = "update_messages";
    public static final String USER_ROLE_ADMIN = "admin";
    public static final String USER_ROLE_CREATOR = "creator";
    public static final String USER_ROLE_INFLUENCER = "influencer";
    public static final String XMAS_PURCHASE = "mt_xmas";
    public static final String XMAS_THEME = "theme_mt_xmas";
    private final Context context;
    private final SharedPreferences.Editor editor;
    private final List<String> languages;
    private final SharedPreferences sharedPreferences;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static int recentCardListId = -1;

    /* JADX INFO: compiled from: PreferencesManager.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0003\b¼\u0001\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0095\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0096\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0097\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0098\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009a\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009b\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009c\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010 \u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¡\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010£\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¤\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¥\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¦\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010§\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¨\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010©\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010ª\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010«\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¬\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u00ad\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010®\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¯\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010°\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010±\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010²\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010³\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010´\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010µ\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¶\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010·\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¸\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¹\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010º\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010»\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¼\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010½\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¾\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¿\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010À\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010Á\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010Â\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010Ã\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010Ä\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010Å\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010Æ\u0001\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006Ç\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/PreferencesManager$Companion;", "", "<init>", "()V", "recentCardListId", "", "getRecentCardListId", "()I", "setRecentCardListId", "(I)V", "ONBOARDING_DONE", "", "SCAN_TUTORIAL_DONE", "SWIPE_TUTORIAL_DONE", "FIRST_RUN", "FIRST_RUN_V2", "SECOND_RUN", "EMAIL_BANNER_DISMISSED", "EMAIL_OPT_IN", "RATING_BANNER_DISMISSED", "GAME_MENU_RATING_BANNER_DISMISSED", "CURRENT_GAME", "GAME_SELECTED_DECKS", "CURRENT_SET", "CURRENT_TOURNAMENT", "LOW_LIFE_ANIM", "ONBOARDING_SEEN_PREFIX", "LOW_LIFE_THRESHOLD", "ENABLE_LOW_LIFE_BKG", "ENABLE_LOW_LIFE_ANIM", "HIGH_CMD_DAMAGE_THRESHOLD", "ENABLE_HIGH_CMD_DAMAGE_ANIM", "HIGH_POISON_THRESHOLD", "ENABLE_HIGH_POISON_ANIM", "ENABLE_KO_MESSAGES", "ENABLE_POISON_COUNTERS_BY_DEFAULT", "ENABLE_COMMANDER_TAX_BY_DEFAULT", "DISPLAY_GAME_EVENTS", "BACKGROUND_BY_DEFAULT", "ENABLE_PLAYER_TOSS", "BACKGROUND_PLAYMAT", "BACKGROUND_COLOR", "BACKGROUND_BLACK", "GAME_FONT_DEFAULT", "CONDENSE_SEARCH", "CURRENT_SEARCH_LANGUAGE", "SEARCH_LANGUAGE_FILTER", "CURRENT_SEARCH", "CURRENT_SET_FILTER", "SOLRING_THEME", "XMAS_THEME", "BURN_THEME", "LOVE_THEME", "AF_THEME", "LUPO_THEME", "SOLRING_PURCHASE", "XMAS_PURCHASE", "BURN_PURCHASE", "LOVE_PURCHASE", "AF_PURCHASE", "LUPO_PURCHASE", "UNLOCKED_PLAYMATS", "THEMES_PUCHASED", "ALL_THEME_TOKENS", "ALL_THEME_VERSIONS", "LAST_SCAN_DATE", "PREFERRED_CURRENCY", "PREFERRED_CURRENCY_V2", "PREFERRED_MARKET", "NUM_SCANS", "NUM_GAMES", "NUM_EVENTS", "SCAN_RATING_PROMPT_SHOWN", "GAME_RATING_PROMPT_SHOWN", "CARD_RATING_PROMPT_SHOWN", "DECK_RATING_PROMPT_SHOWN", "DEFAULT_DRAFT_DURATION", "DEFAULT_DECK_DURATION", "GAME_TUTORIAL_SHOWN", "TRANSLATE_RULINGS", "SCAN_DISPLAY_LANGUAGE", "RECENT_CARDS", "RECENT_CARDS_NEW", "PREFERRED_CARDS_LAYOUT", "ENABLE_UDED_Q", "TIMER_HINT_SHOWN", "BO_HELP_DISMISSED", "STORE_BANNER_DISMISSED", "MYTHIC_PLUS_BANNER_DISMISSED", "ENABLE_TIMER_BY_DEFAULT", "AUTO_START_TIMER", "ALWAYS_SHOW_TIMER", "DEFAULT_TIMER_TIME", "TIMER_SHOW_SECONDS", "CREATOR_CODE", "APP_LANGUAGE", "DISABLE_WIN_LOSE_QUESTIONS", "DISABLE_WIN_LOSE_ANIMATIONS", "BATTERY_SAVING_MODE", "ENABLE_BATTERY_SAVING_PROMPTS", "AUTO_ENABLE_TURN_TIMER", "TURN_TIMER_DISPLAY", "ENABLE_STREAMING", "ENABLE_SCAN_BEEPS", "SCAN_OVERRIDE_LANGUAGE_ENABLED", "SCAN_OVERRIDE_LANGUAGE", "SCAN_OVERRIDE_SET_ENABLED", "SCAN_OVERRIDE_SET", "SCAN_OVERRIDE_FINISH_ENABLED", "SCAN_OVERRIDE_FINISH", "SCAN_HIGH_PRICE_BEEP_ENABLED", "SCAN_HIGH_PRICE_THRESHOLD", "SCAN_PURCHASE_PRICE_ENABLED", "SCAN_PURCHASE_PRICE_MODE", "SCAN_PURCHASE_PRICE_FIXED", "CLEAR_SCAN_LIST_AFTER_ADD", "TURN_TIMER_DISPLAY_CURRENT", "TURN_TIMER_DISPLAY_TOTAL", "ENABLE_FULLSCREEN_MODE", "LAST_RULEBOOK_LANGUAGE", "LAST_CARD_PICKER_LANGUAGE", "LAST_COLLECTION_LAYOUT_TYPE", "LAST_DECK_LAYOUT_TYPE", "FCM_TOKEN", "GOOGLE_TOKEN", "FIREBASE_TOKEN", "AUTH_PROVIDER", "TOKEN_EXPIRY_TIME", "CURRENT_USER", "CURRENT_USER_COLLECTION", "CURRENT_USER_LISTS", "CURRENT_USER_PLAYGROUPS", "CURRENT_USER_DECKS", "CURRENT_USER_ARCHIVED_DECKS", "CURRENT_USER_FRIENDS", "CURRENT_USER_TROPHIES", "CURRENT_QR_CODE", "CURRENT_FRIEND_CODE", "ALL_USER_DECKS", "CURRENT_USER_CACHE", "CURRENT_USER_FAVORITES", "CURRENT_USER_TAGS", "CURRENT_USER_PRIVACY", "CURRENT_USER_SCAN_LIST", "CURRENT_DECK_SCAN_LIST", "MYTHIC_PLUS_ACTIVE", "NEED_USER_RELOAD", "COLLECTION_VERSION", "LISTS_VERSION", "DECKS_VERSION", "CONTAINER_VERSION_PREFIX", "REFRESH_THEMES", "UNDO_KO_INDEXES", "UNDO_WIN_INDEXES", "LOCAL_THEMES_CACHE", "MESSAGE_INTENT", "MSG_TYPE_FRIENDSHIP_REQUEST", "MSG_TYPE_FRIENDSHIP_ACCEPTED", "MSG_TYPE_PLAYGROUP_INVITE", "MSG_TYPE_PLAYGROUP_JOIN", "MSG_TYPE_PLAYGROUP_MESSAGE", "MSG_TYPE_SHARED_COLLECTION_INVITE", "MSG_TYPE_SHARED_COLLECTION_ACCEPTED", "MSG_TYPE_SHARED_COLLECTION_REJECTED", "MSG_TYPE_UNSHARE_COLLECTION_INVITE", "MSG_TYPE_UNSHARE_COLLECTION_ACCEPTED", "MSG_TYPE_UNSHARE_COLLECTION_REJECTED", "SHARED_COLLECTION_BADGE_COUNT", "INTENT_TO_PROCESS", "UPDATE_MESSAGES", "UNSYNCED_GAMES", "UNSYNCED_SETS", "RECENT_CARDS_LIST_NAME", PreferencesManager.GO_TO_SIGN_IN, PreferencesManager.SIGN_UP_ACTIVE, PreferencesManager.ASK_FOR_NOTIFICATIONS, "USER_ROLE_ADMIN", "USER_ROLE_CREATOR", "USER_ROLE_INFLUENCER", "BRACKET_TYPE_NOT_SET", "BRACKET_TYPE_USER", "BRACKET_TYPE_AUTO", "CAMERA_PERMISSION_ASKED_BEFORE", "LAST_DECK_LIST_SELECTION", "LAST_GROUP_BY", "LAST_ORDER_BY", "LAST_ORDER_DIRECTION", "SAVE_SORTING_GROUPING_SETTINGS", "LAST_DECK_LIST_GROUP_BY", "LAST_DECK_LIST_ORDER_BY", "LAST_DECK_LIST_ORDER_DIRECTION", "SAVE_DECK_LIST_SORTING_GROUPING_SETTINGS", "IGNORE_BASIC_LANDS", "IGNORE_COLLECTION", "IGNORE_PRINTINGS", "DECK_SORT_ORDER", "FORCE_PREPROD_API", "CUSTOM_API_HOST_ENABLED", "CUSTOM_API_HOST", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getRecentCardListId() {
            return PreferencesManager.recentCardListId;
        }

        public final void setRecentCardListId(int i) {
            PreferencesManager.recentCardListId = i;
        }
    }

    /* JADX INFO: compiled from: PreferencesManager.kt */
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

    public PreferencesManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.sharedPreferences = defaultSharedPreferences;
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(editorEdit, "edit(...)");
        this.editor = editorEdit;
        this.languages = CollectionsKt.listOf((Object[]) new String[]{"en", "fr", "de", "it", "es", "pt", "ja", "ko", "ru", "zhs", "zht"});
        setLanguageEnabled("en", true);
    }

    static final boolean addRecentCardNew$lambda$0(MTFullCard mTFullCard, MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getScryfallid(), mTFullCard.getScryfallid());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void syncCurrentSettingsToAPI$default(PreferencesManager preferencesManager, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        preferencesManager.syncCurrentSettingsToAPI(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean syncRecentCard$lambda$1$1(MTFullCard mTFullCard, MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getLang(), mTFullCard.getLang()) && Intrinsics.areEqual(it.getSet_code(), mTFullCard.getSet_code()) && Intrinsics.areEqual(it.getCollector_number(), mTFullCard.getCollector_number());
    }

    public final void addRecentCardNew(final MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        List mutableList = CollectionsKt.toMutableList((Collection) getRecentCardsNew());
        final Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(PreferencesManager.addRecentCardNew$lambda$0(card, (MTFullCard) obj));
            }
        };
        mutableList.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Boolean) function1.invoke(obj)).booleanValue();
            }
        });
        mutableList.add(0, card);
        this.editor.putString(RECENT_CARDS_NEW, new Gson().toJson(mutableList)).apply();
    }

    public final void addThemePurchased(String code) {
        Object next;
        Intrinsics.checkNotNullParameter(code, "code");
        List mutableList = CollectionsKt.toMutableList((Collection) getThemesPurchased());
        Iterator it = mutableList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual((String) next, code)) {
                    break;
                }
            }
        }
        if (next != null) {
            return;
        }
        mutableList.add(code);
        this.editor.putString(THEMES_PUCHASED, new Gson().toJson(mutableList)).apply();
    }

    public final void addUnlockedPlaymat(String code) {
        Object next;
        Intrinsics.checkNotNullParameter(code, "code");
        List mutableList = CollectionsKt.toMutableList((Collection) getUnlockedPlaymats());
        Iterator it = mutableList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual((String) next, code)) {
                    break;
                }
            }
        }
        if (next != null) {
            return;
        }
        mutableList.add(code);
        this.editor.putString(UNLOCKED_PLAYMATS, new Gson().toJson(mutableList)).apply();
    }

    public final void applyMTUserSettings(MTUserSettings settings) {
        MTUser currentUser;
        Intrinsics.checkNotNullParameter(settings, "settings");
        String low_life_anim_default = settings.getLow_life_anim_default();
        if (low_life_anim_default != null) {
            setString(LOW_LIFE_ANIM, low_life_anim_default);
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        String low_life_threshold = settings.getLow_life_threshold();
        if (low_life_threshold != null) {
            setString(LOW_LIFE_THRESHOLD, low_life_threshold);
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        Boolean enable_low_life_bkg = settings.getEnable_low_life_bkg();
        if (enable_low_life_bkg != null) {
            setBoolean(ENABLE_LOW_LIFE_BKG, enable_low_life_bkg.booleanValue());
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        Boolean enable_low_life_anim = settings.getEnable_low_life_anim();
        if (enable_low_life_anim != null) {
            setBoolean(ENABLE_LOW_LIFE_ANIM, enable_low_life_anim.booleanValue());
            Unit unit7 = Unit.INSTANCE;
            Unit unit8 = Unit.INSTANCE;
        }
        String high_cmd_damage_threshold = settings.getHigh_cmd_damage_threshold();
        if (high_cmd_damage_threshold != null) {
            setString(HIGH_CMD_DAMAGE_THRESHOLD, high_cmd_damage_threshold);
            Unit unit9 = Unit.INSTANCE;
            Unit unit10 = Unit.INSTANCE;
        }
        Boolean enable_high_cmd_damage_anim = settings.getEnable_high_cmd_damage_anim();
        if (enable_high_cmd_damage_anim != null) {
            setBoolean(ENABLE_HIGH_CMD_DAMAGE_ANIM, enable_high_cmd_damage_anim.booleanValue());
            Unit unit11 = Unit.INSTANCE;
            Unit unit12 = Unit.INSTANCE;
        }
        String high_poison_threshold = settings.getHigh_poison_threshold();
        if (high_poison_threshold != null) {
            setString(HIGH_POISON_THRESHOLD, high_poison_threshold);
            Unit unit13 = Unit.INSTANCE;
            Unit unit14 = Unit.INSTANCE;
        }
        Boolean enable_high_poison_counters_anim = settings.getEnable_high_poison_counters_anim();
        if (enable_high_poison_counters_anim != null) {
            setBoolean(ENABLE_HIGH_POISON_ANIM, enable_high_poison_counters_anim.booleanValue());
            Unit unit15 = Unit.INSTANCE;
            Unit unit16 = Unit.INSTANCE;
        }
        Boolean enable_ko_messages = settings.getEnable_ko_messages();
        if (enable_ko_messages != null) {
            setBoolean(ENABLE_KO_MESSAGES, enable_ko_messages.booleanValue());
            Unit unit17 = Unit.INSTANCE;
            Unit unit18 = Unit.INSTANCE;
        }
        Boolean enable_poison_counters_by_default = settings.getEnable_poison_counters_by_default();
        if (enable_poison_counters_by_default != null) {
            setBoolean(ENABLE_POISON_COUNTERS_BY_DEFAULT, enable_poison_counters_by_default.booleanValue());
            Unit unit19 = Unit.INSTANCE;
            Unit unit20 = Unit.INSTANCE;
        }
        Boolean enable_commander_tax_by_default = settings.getEnable_commander_tax_by_default();
        if (enable_commander_tax_by_default != null) {
            setBoolean(ENABLE_COMMANDER_TAX_BY_DEFAULT, enable_commander_tax_by_default.booleanValue());
            Unit unit21 = Unit.INSTANCE;
            Unit unit22 = Unit.INSTANCE;
        }
        Boolean display_game_events = settings.getDisplay_game_events();
        if (display_game_events != null) {
            setBoolean(DISPLAY_GAME_EVENTS, display_game_events.booleanValue());
            Unit unit23 = Unit.INSTANCE;
            Unit unit24 = Unit.INSTANCE;
        }
        String default_background = settings.getDefault_background();
        if (default_background != null) {
            setString(BACKGROUND_BY_DEFAULT, default_background);
            Unit unit25 = Unit.INSTANCE;
            Unit unit26 = Unit.INSTANCE;
        }
        Boolean enable_player_toss = settings.getEnable_player_toss();
        if (enable_player_toss != null) {
            setBoolean(ENABLE_PLAYER_TOSS, enable_player_toss.booleanValue());
            Unit unit27 = Unit.INSTANCE;
            Unit unit28 = Unit.INSTANCE;
        }
        String game_font_default = settings.getGame_font_default();
        if (game_font_default != null) {
            setString(GAME_FONT_DEFAULT, convertIOSFontNameToAndroid(game_font_default));
            Unit unit29 = Unit.INSTANCE;
            Unit unit30 = Unit.INSTANCE;
        }
        Boolean condense_search = settings.getCondense_search();
        if (condense_search != null) {
            setBoolean(CONDENSE_SEARCH, condense_search.booleanValue());
            Unit unit31 = Unit.INSTANCE;
            Unit unit32 = Unit.INSTANCE;
        }
        String current_search_language = settings.getCurrent_search_language();
        if (current_search_language != null) {
            setString(CURRENT_SEARCH_LANGUAGE, current_search_language);
            Unit unit33 = Unit.INSTANCE;
            Unit unit34 = Unit.INSTANCE;
        }
        String search_language_filter = settings.getSearch_language_filter();
        if (search_language_filter != null) {
            setString(SEARCH_LANGUAGE_FILTER, search_language_filter);
            Unit unit35 = Unit.INSTANCE;
            Unit unit36 = Unit.INSTANCE;
        }
        String current_search = settings.getCurrent_search();
        if (current_search != null) {
            setString(CURRENT_SEARCH, current_search);
            Unit unit37 = Unit.INSTANCE;
            Unit unit38 = Unit.INSTANCE;
        }
        String current_set_filter = settings.getCurrent_set_filter();
        if (current_set_filter != null) {
            setString(CURRENT_SET_FILTER, current_set_filter);
            Unit unit39 = Unit.INSTANCE;
            Unit unit40 = Unit.INSTANCE;
        }
        String preferred_currency = settings.getPreferred_currency();
        if (preferred_currency != null) {
            setString(PREFERRED_CURRENCY, preferred_currency);
            Unit unit41 = Unit.INSTANCE;
            Unit unit42 = Unit.INSTANCE;
        }
        String preferred_currency_v2 = settings.getPreferred_currency_v2();
        if (preferred_currency_v2 != null) {
            setString(PREFERRED_CURRENCY_V2, preferred_currency_v2);
            Unit unit43 = Unit.INSTANCE;
            Unit unit44 = Unit.INSTANCE;
        }
        String default_draft_duration = settings.getDefault_draft_duration();
        if (default_draft_duration != null) {
            setString(DEFAULT_DRAFT_DURATION, default_draft_duration);
            Unit unit45 = Unit.INSTANCE;
            Unit unit46 = Unit.INSTANCE;
        }
        String default_deck_duration = settings.getDefault_deck_duration();
        if (default_deck_duration != null) {
            setString(DEFAULT_DECK_DURATION, default_deck_duration);
            Unit unit47 = Unit.INSTANCE;
            Unit unit48 = Unit.INSTANCE;
        }
        Boolean game_tutorial_shown = settings.getGame_tutorial_shown();
        if (game_tutorial_shown != null) {
            setBoolean(GAME_TUTORIAL_SHOWN, game_tutorial_shown.booleanValue());
            Unit unit49 = Unit.INSTANCE;
            Unit unit50 = Unit.INSTANCE;
        }
        Boolean translate_rulings = settings.getTranslate_rulings();
        if (translate_rulings != null) {
            setBoolean(TRANSLATE_RULINGS, translate_rulings.booleanValue());
            Unit unit51 = Unit.INSTANCE;
            Unit unit52 = Unit.INSTANCE;
        }
        String scan_display_language = settings.getScan_display_language();
        if (scan_display_language != null) {
            setString(SCAN_DISPLAY_LANGUAGE, scan_display_language);
            Unit unit53 = Unit.INSTANCE;
            Unit unit54 = Unit.INSTANCE;
        }
        String preferred_card_layout = settings.getPreferred_card_layout();
        if (preferred_card_layout != null) {
            setString(PREFERRED_CARDS_LAYOUT, preferred_card_layout);
            Unit unit55 = Unit.INSTANCE;
            Unit unit56 = Unit.INSTANCE;
        }
        Boolean enable_uded_q = settings.getEnable_uded_q();
        if (enable_uded_q != null) {
            setBoolean(ENABLE_UDED_Q, enable_uded_q.booleanValue());
            Unit unit57 = Unit.INSTANCE;
            Unit unit58 = Unit.INSTANCE;
        }
        Boolean timer_hint_shown = settings.getTimer_hint_shown();
        if (timer_hint_shown != null) {
            setBoolean(TIMER_HINT_SHOWN, timer_hint_shown.booleanValue());
            Unit unit59 = Unit.INSTANCE;
            Unit unit60 = Unit.INSTANCE;
        }
        Boolean bo_help_dismissed = settings.getBo_help_dismissed();
        if (bo_help_dismissed != null) {
            setBoolean(BO_HELP_DISMISSED, bo_help_dismissed.booleanValue());
            Unit unit61 = Unit.INSTANCE;
            Unit unit62 = Unit.INSTANCE;
        }
        Boolean store_banner_dismissed = settings.getStore_banner_dismissed();
        if (store_banner_dismissed != null) {
            setBoolean(STORE_BANNER_DISMISSED, store_banner_dismissed.booleanValue());
            Unit unit63 = Unit.INSTANCE;
            Unit unit64 = Unit.INSTANCE;
        }
        Boolean always_show_timer = settings.getAlways_show_timer();
        if (always_show_timer != null) {
            setBoolean(ALWAYS_SHOW_TIMER, always_show_timer.booleanValue());
            Unit unit65 = Unit.INSTANCE;
            Unit unit66 = Unit.INSTANCE;
        }
        String default_timer_time = settings.getDefault_timer_time();
        if (default_timer_time != null) {
            setString(DEFAULT_TIMER_TIME, default_timer_time);
            Unit unit67 = Unit.INSTANCE;
            Unit unit68 = Unit.INSTANCE;
        }
        Boolean timer_show_seconds = settings.getTimer_show_seconds();
        if (timer_show_seconds != null) {
            setBoolean(TIMER_SHOW_SECONDS, timer_show_seconds.booleanValue());
            Unit unit69 = Unit.INSTANCE;
            Unit unit70 = Unit.INSTANCE;
        }
        String creator_code = settings.getCreator_code();
        if (creator_code != null) {
            setString(CREATOR_CODE, creator_code);
            Unit unit71 = Unit.INSTANCE;
            Unit unit72 = Unit.INSTANCE;
        }
        Boolean disable_win_lose_questions = settings.getDisable_win_lose_questions();
        if (disable_win_lose_questions != null) {
            setBoolean(DISABLE_WIN_LOSE_QUESTIONS, disable_win_lose_questions.booleanValue());
            Unit unit73 = Unit.INSTANCE;
            Unit unit74 = Unit.INSTANCE;
        }
        Boolean disable_win_lose_animations = settings.getDisable_win_lose_animations();
        if (disable_win_lose_animations != null) {
            setBoolean(DISABLE_WIN_LOSE_ANIMATIONS, disable_win_lose_animations.booleanValue());
            Unit unit75 = Unit.INSTANCE;
            Unit unit76 = Unit.INSTANCE;
        }
        Boolean auto_enable_turn_timer = settings.getAuto_enable_turn_timer();
        if (auto_enable_turn_timer != null) {
            setBoolean(AUTO_ENABLE_TURN_TIMER, auto_enable_turn_timer.booleanValue());
            Unit unit77 = Unit.INSTANCE;
            Unit unit78 = Unit.INSTANCE;
        }
        String turn_timer_display = settings.getTurn_timer_display();
        if (turn_timer_display != null) {
            setString(TURN_TIMER_DISPLAY, turn_timer_display);
            Unit unit79 = Unit.INSTANCE;
            Unit unit80 = Unit.INSTANCE;
        }
        Boolean enable_fullscreen_mode = settings.getEnable_fullscreen_mode();
        if (enable_fullscreen_mode != null) {
            setBoolean(ENABLE_FULLSCREEN_MODE, enable_fullscreen_mode.booleanValue());
            Unit unit81 = Unit.INSTANCE;
            Unit unit82 = Unit.INSTANCE;
        }
        Boolean enable_battery_saving_prompts = settings.getEnable_battery_saving_prompts();
        if (enable_battery_saving_prompts != null) {
            setBoolean(ENABLE_BATTERY_SAVING_PROMPTS, enable_battery_saving_prompts.booleanValue());
            Unit unit83 = Unit.INSTANCE;
            Unit unit84 = Unit.INSTANCE;
        }
        String last_rulebook_language = settings.getLast_rulebook_language();
        if (last_rulebook_language != null) {
            if (last_rulebook_language.length() > 0) {
                setString(LAST_RULEBOOK_LANGUAGE, last_rulebook_language);
            }
            Unit unit85 = Unit.INSTANCE;
            Unit unit86 = Unit.INSTANCE;
        }
        String last_card_picker_language = settings.getLast_card_picker_language();
        if (last_card_picker_language != null) {
            if (last_card_picker_language.length() > 0) {
                setString(LAST_CARD_PICKER_LANGUAGE, last_card_picker_language);
            }
            Unit unit87 = Unit.INSTANCE;
            Unit unit88 = Unit.INSTANCE;
        }
        Boolean enable_streaming = settings.getEnable_streaming();
        if (enable_streaming != null) {
            setBoolean(ENABLE_STREAMING, enable_streaming.booleanValue());
            Unit unit89 = Unit.INSTANCE;
            Unit unit90 = Unit.INSTANCE;
        }
        Boolean enable_scan_beeps = settings.getEnable_scan_beeps();
        if (enable_scan_beeps != null) {
            setBoolean(ENABLE_SCAN_BEEPS, enable_scan_beeps.booleanValue());
            Unit unit91 = Unit.INSTANCE;
            Unit unit92 = Unit.INSTANCE;
        }
        Boolean enable_timer_by_default = settings.getEnable_timer_by_default();
        if (enable_timer_by_default != null) {
            setBoolean(ENABLE_TIMER_BY_DEFAULT, enable_timer_by_default.booleanValue());
            Unit unit93 = Unit.INSTANCE;
            Unit unit94 = Unit.INSTANCE;
        }
        Boolean auto_start_timer = settings.getAuto_start_timer();
        if (auto_start_timer != null) {
            setBoolean(AUTO_START_TIMER, auto_start_timer.booleanValue());
            Unit unit95 = Unit.INSTANCE;
            Unit unit96 = Unit.INSTANCE;
        }
        String app_language = settings.getApp_language();
        if (app_language != null) {
            setString(APP_LANGUAGE, app_language);
            Unit unit97 = Unit.INSTANCE;
            Unit unit98 = Unit.INSTANCE;
        }
        String last_group_by = settings.getLast_group_by();
        if (last_group_by != null) {
            setString(LAST_GROUP_BY, last_group_by);
            Unit unit99 = Unit.INSTANCE;
            Unit unit100 = Unit.INSTANCE;
        } else {
            SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
            editorEdit.remove(LAST_GROUP_BY);
            editorEdit.apply();
            Unit unit101 = Unit.INSTANCE;
        }
        String last_order_by = settings.getLast_order_by();
        if (last_order_by != null) {
            setString(LAST_ORDER_BY, last_order_by);
            Unit unit102 = Unit.INSTANCE;
            Unit unit103 = Unit.INSTANCE;
        } else {
            SharedPreferences.Editor editorEdit2 = this.sharedPreferences.edit();
            editorEdit2.remove(LAST_ORDER_BY);
            editorEdit2.apply();
            Unit unit104 = Unit.INSTANCE;
        }
        String last_order_direction = settings.getLast_order_direction();
        if (last_order_direction != null) {
            setString(LAST_ORDER_DIRECTION, last_order_direction);
            Unit unit105 = Unit.INSTANCE;
            Unit unit106 = Unit.INSTANCE;
        } else {
            SharedPreferences.Editor editorEdit3 = this.sharedPreferences.edit();
            editorEdit3.remove(LAST_ORDER_DIRECTION);
            editorEdit3.apply();
            Unit unit107 = Unit.INSTANCE;
        }
        Boolean save_sorting_grouping_settings = settings.getSave_sorting_grouping_settings();
        if (save_sorting_grouping_settings != null) {
            setBoolean(SAVE_SORTING_GROUPING_SETTINGS, save_sorting_grouping_settings.booleanValue());
            Unit unit108 = Unit.INSTANCE;
            Unit unit109 = Unit.INSTANCE;
        }
        String last_deck_list_group_by = settings.getLast_deck_list_group_by();
        if (last_deck_list_group_by != null) {
            setString(LAST_DECK_LIST_GROUP_BY, last_deck_list_group_by);
            Unit unit110 = Unit.INSTANCE;
            Unit unit111 = Unit.INSTANCE;
        } else {
            SharedPreferences.Editor editorEdit4 = this.sharedPreferences.edit();
            editorEdit4.remove(LAST_DECK_LIST_GROUP_BY);
            editorEdit4.apply();
            Unit unit112 = Unit.INSTANCE;
        }
        String last_deck_list_order_by = settings.getLast_deck_list_order_by();
        if (last_deck_list_order_by != null) {
            setString(LAST_DECK_LIST_ORDER_BY, last_deck_list_order_by);
            Unit unit113 = Unit.INSTANCE;
            Unit unit114 = Unit.INSTANCE;
        } else {
            SharedPreferences.Editor editorEdit5 = this.sharedPreferences.edit();
            editorEdit5.remove(LAST_DECK_LIST_ORDER_BY);
            editorEdit5.apply();
            Unit unit115 = Unit.INSTANCE;
        }
        String last_deck_list_order_direction = settings.getLast_deck_list_order_direction();
        if (last_deck_list_order_direction != null) {
            setString(LAST_DECK_LIST_ORDER_DIRECTION, last_deck_list_order_direction);
            Unit unit116 = Unit.INSTANCE;
            Unit unit117 = Unit.INSTANCE;
        } else {
            SharedPreferences.Editor editorEdit6 = this.sharedPreferences.edit();
            editorEdit6.remove(LAST_DECK_LIST_ORDER_DIRECTION);
            editorEdit6.apply();
            Unit unit118 = Unit.INSTANCE;
        }
        Boolean save_deck_list_sorting_grouping_settings = settings.getSave_deck_list_sorting_grouping_settings();
        if (save_deck_list_sorting_grouping_settings != null) {
            setBoolean(SAVE_DECK_LIST_SORTING_GROUPING_SETTINGS, save_deck_list_sorting_grouping_settings.booleanValue());
            Unit unit119 = Unit.INSTANCE;
            Unit unit120 = Unit.INSTANCE;
        }
        String preferred_market = settings.getPreferred_market();
        if (preferred_market != null) {
            setString(PREFERRED_MARKET, preferred_market);
            Unit unit121 = Unit.INSTANCE;
            Unit unit122 = Unit.INSTANCE;
        }
        Boolean scan_override_language_enabled = settings.getScan_override_language_enabled();
        if (scan_override_language_enabled != null) {
            setBoolean(SCAN_OVERRIDE_LANGUAGE_ENABLED, scan_override_language_enabled.booleanValue());
            Unit unit123 = Unit.INSTANCE;
            Unit unit124 = Unit.INSTANCE;
        }
        String scan_override_language = settings.getScan_override_language();
        if (scan_override_language != null) {
            setString(SCAN_OVERRIDE_LANGUAGE, scan_override_language);
            Unit unit125 = Unit.INSTANCE;
            Unit unit126 = Unit.INSTANCE;
        }
        Boolean scan_override_set_enabled = settings.getScan_override_set_enabled();
        if (scan_override_set_enabled != null) {
            setBoolean(SCAN_OVERRIDE_SET_ENABLED, scan_override_set_enabled.booleanValue());
            Unit unit127 = Unit.INSTANCE;
            Unit unit128 = Unit.INSTANCE;
        }
        String scan_override_set = settings.getScan_override_set();
        if (scan_override_set != null) {
            setString(SCAN_OVERRIDE_SET, scan_override_set);
            Unit unit129 = Unit.INSTANCE;
            Unit unit130 = Unit.INSTANCE;
        }
        Boolean scan_override_finish_enabled = settings.getScan_override_finish_enabled();
        if (scan_override_finish_enabled != null) {
            setBoolean(SCAN_OVERRIDE_FINISH_ENABLED, scan_override_finish_enabled.booleanValue());
            Unit unit131 = Unit.INSTANCE;
            Unit unit132 = Unit.INSTANCE;
        }
        String scan_override_finish = settings.getScan_override_finish();
        if (scan_override_finish != null) {
            setString(SCAN_OVERRIDE_FINISH, scan_override_finish);
            Unit unit133 = Unit.INSTANCE;
            Unit unit134 = Unit.INSTANCE;
        }
        Boolean scan_high_price_beep_enabled = settings.getScan_high_price_beep_enabled();
        if (scan_high_price_beep_enabled != null) {
            setBoolean(SCAN_HIGH_PRICE_BEEP_ENABLED, scan_high_price_beep_enabled.booleanValue());
            Unit unit135 = Unit.INSTANCE;
            Unit unit136 = Unit.INSTANCE;
        }
        Float scan_high_price_threshold = settings.getScan_high_price_threshold();
        if (scan_high_price_threshold != null) {
            setFloat(SCAN_HIGH_PRICE_THRESHOLD, scan_high_price_threshold.floatValue());
            Unit unit137 = Unit.INSTANCE;
            Unit unit138 = Unit.INSTANCE;
        }
        Boolean scan_purchase_price_enabled = settings.getScan_purchase_price_enabled();
        if (scan_purchase_price_enabled != null) {
            setBoolean(SCAN_PURCHASE_PRICE_ENABLED, scan_purchase_price_enabled.booleanValue());
            Unit unit139 = Unit.INSTANCE;
            Unit unit140 = Unit.INSTANCE;
        }
        String scan_purchase_price_mode = settings.getScan_purchase_price_mode();
        if (scan_purchase_price_mode != null) {
            setString(SCAN_PURCHASE_PRICE_MODE, scan_purchase_price_mode);
            Unit unit141 = Unit.INSTANCE;
            Unit unit142 = Unit.INSTANCE;
        }
        Float scan_purchase_price_fixed = settings.getScan_purchase_price_fixed();
        if (scan_purchase_price_fixed != null) {
            setFloat(SCAN_PURCHASE_PRICE_FIXED, scan_purchase_price_fixed.floatValue());
            Unit unit143 = Unit.INSTANCE;
            Unit unit144 = Unit.INSTANCE;
        }
        Boolean ignore_basic_lands = settings.getIgnore_basic_lands();
        if (ignore_basic_lands != null) {
            setBoolean(IGNORE_BASIC_LANDS, ignore_basic_lands.booleanValue());
            Unit unit145 = Unit.INSTANCE;
            Unit unit146 = Unit.INSTANCE;
        }
        Boolean ignore_collection = settings.getIgnore_collection();
        if (ignore_collection != null) {
            setBoolean(IGNORE_COLLECTION, ignore_collection.booleanValue());
            Unit unit147 = Unit.INSTANCE;
            Unit unit148 = Unit.INSTANCE;
        }
        Boolean ignore_printings = settings.getIgnore_printings();
        if (ignore_printings != null) {
            setBoolean(IGNORE_PRINTINGS, ignore_printings.booleanValue());
            Unit unit149 = Unit.INSTANCE;
            Unit unit150 = Unit.INSTANCE;
        }
        Boolean clear_scan_list_after_add = settings.getClear_scan_list_after_add();
        if (clear_scan_list_after_add != null) {
            setBoolean(CLEAR_SCAN_LIST_AFTER_ADD, clear_scan_list_after_add.booleanValue());
            Unit unit151 = Unit.INSTANCE;
            Unit unit152 = Unit.INSTANCE;
        }
        String deck_sort_order = settings.getDeck_sort_order();
        if (deck_sort_order != null) {
            setDeckSortOrder(deck_sort_order);
            Unit unit153 = Unit.INSTANCE;
            Unit unit154 = Unit.INSTANCE;
        }
        Boolean email_opt_in = settings.getEmail_opt_in();
        if (email_opt_in != null) {
            boolean zBooleanValue = email_opt_in.booleanValue();
            boolean z = getBoolean(EMAIL_OPT_IN, false);
            setBoolean(EMAIL_OPT_IN, zBooleanValue);
            if (zBooleanValue && !z && (currentUser = getCurrentUser()) != null) {
                CustomerIOHelper.INSTANCE.identifyOptedInUser(currentUser, this);
                Unit unit155 = Unit.INSTANCE;
                Unit unit156 = Unit.INSTANCE;
            }
            Unit unit157 = Unit.INSTANCE;
            Unit unit158 = Unit.INSTANCE;
        }
    }

    public final void clearAllThemeTokens() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(ALL_THEME_TOKENS);
        editorEdit.apply();
    }

    public final void clearAllThemesPurchased() {
        this.editor.putString(THEMES_PUCHASED, "").apply();
    }

    public final void clearAllUsersDecks() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(ALL_USER_DECKS);
        editorEdit.apply();
    }

    public final void clearCurrentDeckScanList() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_DECK_SCAN_LIST);
        editorEdit.apply();
    }

    public final void clearCurrentGame() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_GAME);
        editorEdit.apply();
    }

    public final void clearCurrentListScanList(int listId) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove("current_list_scan_list_" + listId);
        editorEdit.apply();
    }

    public final void clearCurrentSet() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_SET);
        editorEdit.apply();
    }

    public final void clearCurrentTournament() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_TOURNAMENT);
        editorEdit.apply();
    }

    public final void clearCurrentUser() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_USER);
        editorEdit.remove(CURRENT_QR_CODE);
        editorEdit.remove(CURRENT_FRIEND_CODE);
        editorEdit.remove(GOOGLE_TOKEN);
        editorEdit.remove(FIREBASE_TOKEN);
        editorEdit.remove(MYTHIC_PLUS_ACTIVE);
        editorEdit.apply();
        clearCurrentUserPlaygroups();
        clearCurrentUserFriends();
        clearCurrentUserDecks();
        clearCurrentUserArchivedDecks();
        clearCurrentUserTrophies();
        clearCurrentUserCollection();
        clearCurrentUserLists();
        clearCurrentUserPrivacy();
    }

    public final void clearCurrentUserArchivedDecks() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_USER_ARCHIVED_DECKS);
        editorEdit.apply();
    }

    public final void clearCurrentUserCache() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_USER_CACHE);
        editorEdit.apply();
    }

    public final void clearCurrentUserCollection() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_USER_COLLECTION);
        editorEdit.apply();
    }

    public final void clearCurrentUserDecks() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_USER_DECKS);
        editorEdit.apply();
    }

    public final void clearCurrentUserFavorites() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_USER_FAVORITES);
        editorEdit.apply();
    }

    public final void clearCurrentUserFriends() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_USER_FRIENDS);
        editorEdit.apply();
    }

    public final void clearCurrentUserLists() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_USER_LISTS);
        editorEdit.apply();
    }

    public final void clearCurrentUserPlaygroups() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_USER_PLAYGROUPS);
        editorEdit.apply();
    }

    public final void clearCurrentUserPrivacy() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_USER_PRIVACY);
        editorEdit.apply();
    }

    public final void clearCurrentUserScanList() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_USER_SCAN_LIST);
        editorEdit.apply();
    }

    public final void clearCurrentUserTags() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_USER_TAGS);
        editorEdit.apply();
    }

    public final void clearCurrentUserTrophies() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(CURRENT_USER_TROPHIES);
        editorEdit.apply();
    }

    public final void clearGameSelectedDecks() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(GAME_SELECTED_DECKS);
        editorEdit.apply();
    }

    public final void clearLocalThemesCache() {
        this.editor.putString(LOCAL_THEMES_CACHE, "").apply();
    }

    public final void clearRecentCardsNew() {
        this.editor.putString(RECENT_CARDS_NEW, "").apply();
    }

    public final void clearRecentCardsOld() {
        this.editor.putString(RECENT_CARDS, "").apply();
    }

    public final void clearUnSyncedGames() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(UNSYNCED_GAMES);
        editorEdit.apply();
    }

    public final void clearUnSyncedSets() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(UNSYNCED_SETS);
        editorEdit.apply();
    }

    public final void clearUndoKOs() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(UNDO_KO_INDEXES);
        editorEdit.apply();
    }

    public final void clearUndoWins() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(UNDO_WIN_INDEXES);
        editorEdit.apply();
    }

    public final void clearUnlockedPlaymats() {
        this.editor.putString(UNLOCKED_PLAYMATS, "").apply();
    }

    public final String convertIOSFontNameToAndroid(String iosFontName) {
        Intrinsics.checkNotNullParameter(iosFontName, "iosFontName");
        String str = (String) MapsKt.mapOf(TuplesKt.to("Acme-Regular", "acme_regular"), TuplesKt.to("Anton-Regular", "anton_regular"), TuplesKt.to("Beleren-Bold", "beleren_bold"), TuplesKt.to("BigShouldersDisplay-SemiBold", "big_shoulders_semibold"), TuplesKt.to("ConcertOne-Regular", "concertone_regular"), TuplesKt.to("FrancoisOne-Regular", "francoisone_regular"), TuplesKt.to("LilitaOne", "lilitaone_regular"), TuplesKt.to("LondrinaSolid-Regular", "londrina_solid_regular"), TuplesKt.to("Outfit", "outfit"), TuplesKt.to("PassionOne-Regular", "passionone_regular"), TuplesKt.to("PermanentMarker-Regular", "permanent_marker_regular"), TuplesKt.to("UbuntuMono-Bold", "ubuntu_mono_bold")).get(iosFontName);
        return str == null ? iosFontName : str;
    }

    public final void debugCompiledResources() {
        try {
            String[] locales = this.context.getAssets().getLocales();
            Intrinsics.checkNotNull(locales);
            Log.d("ResourceDebug", "Compiled locales in APK: " + ArraysKt.joinToString$default(locales, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
            int length = locales.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str = locales[i];
                Intrinsics.checkNotNull(str);
                if (StringsKt.startsWith$default(str, "fr", false, 2, (Object) null)) {
                    z = true;
                    break;
                }
                i++;
            }
            Log.d("ResourceDebug", "French resources compiled: " + z);
        } catch (Exception e) {
            Log.e("ResourceDebug", "Error checking compiled resources", e);
        }
    }

    public final void debugDeviceLanguage() {
        String deviceLanguage = getDeviceLanguage();
        Locale locale = Locale.getDefault();
        Locale locale2 = this.context.getResources().getConfiguration().getLocales().get(0);
        Log.d("PreferencesManager", "Device language detected: " + deviceLanguage);
        Log.d("PreferencesManager", "System default locale: " + locale);
        Log.d("PreferencesManager", "Configuration locale: " + locale2);
        Log.d("PreferencesManager", "Supported languages: " + this.languages);
        Log.d("PreferencesManager", "Is French enabled: " + isLanguageEnabled("fr"));
        Configuration configuration = new Configuration(this.context.getResources().getConfiguration());
        configuration.setLocale(Locale.forLanguageTag("en"));
        Context contextCreateConfigurationContext = this.context.createConfigurationContext(configuration);
        Configuration configuration2 = new Configuration(this.context.getResources().getConfiguration());
        configuration2.setLocale(Locale.forLanguageTag("fr"));
        Context contextCreateConfigurationContext2 = this.context.createConfigurationContext(configuration2);
        String string = contextCreateConfigurationContext.getString(R.string.sign_in_with_email);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = contextCreateConfigurationContext2.getString(R.string.sign_in_with_email);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        Log.d("PreferencesManager", "Explicit English: '" + string + "'");
        Log.d("PreferencesManager", "Explicit French: '" + string2 + "'");
        Log.d("PreferencesManager", "Current context: '" + this.context.getString(R.string.sign_in_with_email) + "'");
        Log.d("PreferencesManager", "Strings are different: " + (!Intrinsics.areEqual(string, string2)));
    }

    public final Map<String, String> getAllThemeTokens() {
        String string = this.sharedPreferences.getString(ALL_THEME_TOKENS, "");
        if (string == null || string.length() <= 0) {
            return MapsKt.emptyMap();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<Map<String, ? extends String>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getAllThemeTokens$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (Map) objFromJson;
    }

    public final Map<String, Integer> getAllThemeVersions() {
        String string = this.sharedPreferences.getString(ALL_THEME_VERSIONS, "");
        if (string == null || string.length() <= 0) {
            return MapsKt.emptyMap();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<Map<String, ? extends Integer>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getAllThemeVersions$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (Map) objFromJson;
    }

    public final Map<Integer, List<MTDeck>> getAllUsersDecks() {
        String string = this.sharedPreferences.getString(ALL_USER_DECKS, "");
        if (string == null || string.length() <= 0) {
            return MapsKt.emptyMap();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<Map<Integer, ? extends List<? extends MTDeck>>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getAllUsersDecks$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (Map) objFromJson;
    }

    public final boolean getBoolean(String id, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.sharedPreferences.getBoolean(id, defaultValue);
    }

    public final boolean getClearScanListAfterAdd() {
        return getBoolean(CLEAR_SCAN_LIST_AFTER_ADD, false);
    }

    public final int getCollectionVersion() {
        return getInt(COLLECTION_VERSION, 0);
    }

    public final int getContainerVersion(int containerId) {
        return getInt(CONTAINER_VERSION_PREFIX + containerId, 0);
    }

    public final List<MTFullCard> getCurrentDeckScanList() {
        String string = this.sharedPreferences.getString(CURRENT_DECK_SCAN_LIST, "");
        if (string == null || string.length() <= 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends MTFullCard>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getCurrentDeckScanList$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final GameState getCurrentGame() {
        String string = this.sharedPreferences.getString(CURRENT_GAME, "");
        if (string == null || string.length() <= 0) {
            return null;
        }
        return (GameState) new Gson().fromJson(string, GameState.class);
    }

    public final List<MTFullCard> getCurrentListScanList(int listId) {
        String string = this.sharedPreferences.getString("current_list_scan_list_" + listId, "");
        if (string == null || string.length() <= 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends MTFullCard>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getCurrentListScanList$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final String getCurrentSearch() {
        String string = this.sharedPreferences.getString(CURRENT_SEARCH, "");
        return string != null ? string : "";
    }

    public final GameSet getCurrentSet() {
        String string = this.sharedPreferences.getString(CURRENT_SET, "");
        if (string == null || string.length() <= 0) {
            return null;
        }
        return (GameSet) new Gson().fromJson(string, GameSet.class);
    }

    public final String getCurrentSetFilter() {
        String string = this.sharedPreferences.getString(CURRENT_SET_FILTER, "");
        return string != null ? string : "";
    }

    public final Tournament getCurrentTournament() {
        String string = this.sharedPreferences.getString(CURRENT_TOURNAMENT, "");
        if (string == null || string.length() <= 0) {
            return null;
        }
        return (Tournament) new Gson().fromJson(string, Tournament.class);
    }

    public final MTUser getCurrentUser() {
        String string = this.sharedPreferences.getString(CURRENT_USER, "");
        if (string == null || string.length() <= 0) {
            return null;
        }
        return (MTUser) new Gson().fromJson(string, MTUser.class);
    }

    public final List<MTDeck> getCurrentUserArchivedDecks() {
        String string = this.sharedPreferences.getString(CURRENT_USER_ARCHIVED_DECKS, "");
        if (string == null || string.length() <= 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends MTDeck>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getCurrentUserArchivedDecks$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final List<MTUser> getCurrentUserCache() {
        String string = this.sharedPreferences.getString(CURRENT_USER_CACHE, "");
        if (string == null || string.length() <= 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends MTUser>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getCurrentUserCache$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final MTCollection getCurrentUserCollection() {
        String string = this.sharedPreferences.getString(CURRENT_USER_COLLECTION, "");
        if (string == null || string.length() <= 0) {
            return null;
        }
        return (MTCollection) new Gson().fromJson(string, new TypeToken<MTCollection>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getCurrentUserCollection$type$1
        }.getType());
    }

    public final List<MTDeck> getCurrentUserDecks() {
        String string = this.sharedPreferences.getString(CURRENT_USER_DECKS, "");
        if (string == null || string.length() <= 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends MTDeck>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getCurrentUserDecks$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final MTFavorites getCurrentUserFavorites() {
        String string = this.sharedPreferences.getString(CURRENT_USER_FAVORITES, "");
        if (string == null || string.length() <= 0) {
            return null;
        }
        return (MTFavorites) new Gson().fromJson(string, MTFavorites.class);
    }

    public final List<MTFriend> getCurrentUserFriends() {
        String string = this.sharedPreferences.getString(CURRENT_USER_FRIENDS, "");
        if (string == null || string.length() <= 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends MTFriend>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getCurrentUserFriends$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final MTUserLists getCurrentUserLists() {
        String string = this.sharedPreferences.getString(CURRENT_USER_LISTS, "");
        if (string == null || string.length() <= 0) {
            return null;
        }
        return (MTUserLists) new Gson().fromJson(string, new TypeToken<MTUserLists>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getCurrentUserLists$type$1
        }.getType());
    }

    public final List<MTPlaygroup> getCurrentUserPlaygroups() {
        String string = this.sharedPreferences.getString(CURRENT_USER_PLAYGROUPS, "");
        if (string == null || string.length() <= 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends MTPlaygroup>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getCurrentUserPlaygroups$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final MTUserPrivacy getCurrentUserPrivacy() {
        String string = this.sharedPreferences.getString(CURRENT_USER_PRIVACY, "");
        if (string == null || string.length() <= 0) {
            return null;
        }
        return (MTUserPrivacy) new Gson().fromJson(string, MTUserPrivacy.class);
    }

    public final List<MTFullCard> getCurrentUserScanList() {
        String string = this.sharedPreferences.getString(CURRENT_USER_SCAN_LIST, "");
        if (string == null || string.length() <= 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends MTFullCard>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getCurrentUserScanList$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final MTUserTags getCurrentUserTags() {
        String string = this.sharedPreferences.getString(CURRENT_USER_TAGS, "");
        if (string == null || string.length() <= 0) {
            return null;
        }
        return (MTUserTags) new Gson().fromJson(string, new TypeToken<MTUserTags>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getCurrentUserTags$type$1
        }.getType());
    }

    public final List<MTTrophy> getCurrentUserTrophies() {
        String string = this.sharedPreferences.getString(CURRENT_USER_TROPHIES, "");
        if (string == null || string.length() <= 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends MTTrophy>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getCurrentUserTrophies$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final String getDeckSortOrder() {
        return getString(DECK_SORT_ORDER, "UPDATED_AT");
    }

    public final int getDecksVersion() {
        return getInt(DECKS_VERSION, 0);
    }

    public final String getDeviceLanguage() {
        String string = getString(APP_LANGUAGE, AndroidContextPlugin.DEVICE_KEY);
        if (!Intrinsics.areEqual(string, AndroidContextPlugin.DEVICE_KEY)) {
            return string;
        }
        String language = Locale.getDefault().getLanguage();
        if (Intrinsics.areEqual(language, "zh")) {
            String script = Locale.getDefault().getScript();
            language = (!Intrinsics.areEqual(script, "Hans") && Intrinsics.areEqual(script, "Hant")) ? "zht" : "zhs";
        }
        if (!this.languages.contains(language)) {
            return "en";
        }
        Intrinsics.checkNotNull(language);
        return language;
    }

    public final List<String> getEnabledLanguages() {
        List<String> list = this.languages;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (isLanguageEnabled((String) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final float getFloat(String id, float defaultValue) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.sharedPreferences.getFloat(id, defaultValue);
    }

    public final boolean getForcedApiUpdate() {
        return this.sharedPreferences.getBoolean("forced_api_update", false);
    }

    public final Map<Integer, MTDeck> getGameSelectedDecks() {
        String string = this.sharedPreferences.getString(GAME_SELECTED_DECKS, "");
        String str = string;
        if (str == null || str.length() == 0) {
            return MapsKt.emptyMap();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<Map<Integer, ? extends MTDeck>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getGameSelectedDecks$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (Map) objFromJson;
    }

    public final int getInt(String id, int defaultValue) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.sharedPreferences.getInt(id, defaultValue);
    }

    public final int getIntFromString(String id, int defaultValue) {
        Intrinsics.checkNotNullParameter(id, "id");
        String string = this.sharedPreferences.getString(id, "");
        Integer intOrNull = string != null ? StringsKt.toIntOrNull(string) : null;
        return intOrNull != null ? intOrNull.intValue() : defaultValue;
    }

    public final long getLastApiUpdate() {
        return this.sharedPreferences.getLong("last_api_update", 0L);
    }

    public final String getLastDeckListGroupBy() {
        String string = this.sharedPreferences.getString(LAST_DECK_LIST_GROUP_BY, null);
        String str = string;
        if (str == null || str.length() == 0) {
            return null;
        }
        return string;
    }

    public final String getLastDeckListOrderBy() {
        String string = this.sharedPreferences.getString(LAST_DECK_LIST_ORDER_BY, null);
        String str = string;
        if (str == null || str.length() == 0) {
            return null;
        }
        return string;
    }

    public final String getLastDeckListOrderDirection() {
        String string = this.sharedPreferences.getString(LAST_DECK_LIST_ORDER_DIRECTION, null);
        String str = string;
        if (str == null || str.length() == 0) {
            return null;
        }
        return string;
    }

    public final String getLastDeckListSelection() {
        String string = this.sharedPreferences.getString(LAST_DECK_LIST_SELECTION, "main");
        return string == null ? "main" : string;
    }

    public final String getLastGroupBy() {
        String string = this.sharedPreferences.getString(LAST_GROUP_BY, null);
        String str = string;
        if (str == null || str.length() == 0) {
            return null;
        }
        return string;
    }

    public final long getLastMessagesUpdate() {
        return this.sharedPreferences.getLong("last_messages_update", 0L);
    }

    public final String getLastOrderBy() {
        String string = this.sharedPreferences.getString(LAST_ORDER_BY, null);
        String str = string;
        if (str == null || str.length() == 0) {
            return null;
        }
        return string;
    }

    public final String getLastOrderDirection() {
        String string = this.sharedPreferences.getString(LAST_ORDER_DIRECTION, null);
        String str = string;
        if (str == null || str.length() == 0) {
            return null;
        }
        return string;
    }

    public final int getListsVersion() {
        return getInt(LISTS_VERSION, 0);
    }

    public final List<MTTheme> getLocalThemesCache() {
        String string = this.sharedPreferences.getString(LOCAL_THEMES_CACHE, "");
        String str = string;
        if (str == null || str.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends MTTheme>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getLocalThemesCache$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final LowlifeEffect getLowlifeEffect() {
        String string = this.sharedPreferences.getString(LOW_LIFE_ANIM, "RANDOM");
        if (string == null) {
            return LowlifeEffect.RANDOM;
        }
        String upperCase = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (Intrinsics.areEqual(upperCase, "SCOREHEARTBEAT")) {
            upperCase = "SCORE_HEARTBEAT";
        }
        try {
            return LowlifeEffect.valueOf(Intrinsics.areEqual(upperCase, "IMAGE_HEARTBEAT") ? "SCORE_HEARTBEAT" : upperCase);
        } catch (Exception unused) {
            return LowlifeEffect.RANDOM;
        }
    }

    public final MTUserSettings getMTUserSettings() {
        MTUserSettings mTUserSettings = new MTUserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 4095, null);
        mTUserSettings.setLow_life_anim_default(getString(LOW_LIFE_ANIM, "RANDOM"));
        mTUserSettings.setLow_life_threshold(getString(LOW_LIFE_THRESHOLD, "10"));
        mTUserSettings.setEnable_low_life_bkg(Boolean.valueOf(getBoolean(ENABLE_LOW_LIFE_BKG, true)));
        mTUserSettings.setEnable_low_life_anim(Boolean.valueOf(getBoolean(ENABLE_LOW_LIFE_ANIM, true)));
        mTUserSettings.setHigh_cmd_damage_threshold(getString(HIGH_CMD_DAMAGE_THRESHOLD, "15"));
        mTUserSettings.setEnable_high_cmd_damage_anim(Boolean.valueOf(getBoolean(ENABLE_HIGH_CMD_DAMAGE_ANIM, true)));
        mTUserSettings.setHigh_poison_threshold(getString(HIGH_POISON_THRESHOLD, "8"));
        mTUserSettings.setEnable_high_poison_counters_anim(Boolean.valueOf(getBoolean(ENABLE_HIGH_POISON_ANIM, true)));
        mTUserSettings.setEnable_ko_messages(Boolean.valueOf(getBoolean(ENABLE_KO_MESSAGES, true)));
        mTUserSettings.setEnable_poison_counters_by_default(Boolean.valueOf(getBoolean(ENABLE_POISON_COUNTERS_BY_DEFAULT, false)));
        mTUserSettings.setEnable_commander_tax_by_default(Boolean.valueOf(getBoolean(ENABLE_COMMANDER_TAX_BY_DEFAULT, false)));
        mTUserSettings.setDisplay_game_events(Boolean.valueOf(getBoolean(DISPLAY_GAME_EVENTS, true)));
        mTUserSettings.setDefault_background(getString(BACKGROUND_BY_DEFAULT, BACKGROUND_PLAYMAT));
        mTUserSettings.setEnable_player_toss(Boolean.valueOf(getBoolean(ENABLE_PLAYER_TOSS, true)));
        mTUserSettings.setGame_font_default(getString(GAME_FONT_DEFAULT, "big_shoulders_semibold"));
        mTUserSettings.setCondense_search(Boolean.valueOf(getBoolean(CONDENSE_SEARCH, true)));
        mTUserSettings.setCurrent_search_language(getString(CURRENT_SEARCH_LANGUAGE, "en"));
        mTUserSettings.setSearch_language_filter(getString(SEARCH_LANGUAGE_FILTER, ""));
        mTUserSettings.setCurrent_search(getString(CURRENT_SEARCH, ""));
        mTUserSettings.setCurrent_set_filter(getString(CURRENT_SET_FILTER, ""));
        mTUserSettings.setPreferred_currency(getString(PREFERRED_CURRENCY, "USD"));
        String string = getString(PREFERRED_CURRENCY_V2, "");
        if (string.length() == 0) {
            String string2 = getString(PREFERRED_CURRENCY, "");
            if (string2.length() > 0) {
                mTUserSettings.setPreferred_currency_v2(string2);
            }
        } else {
            mTUserSettings.setPreferred_currency_v2(string);
        }
        mTUserSettings.setDefault_draft_duration(getString(DEFAULT_DRAFT_DURATION, "45"));
        mTUserSettings.setDefault_deck_duration(getString(DEFAULT_DECK_DURATION, "45"));
        mTUserSettings.setGame_tutorial_shown(Boolean.valueOf(getBoolean(GAME_TUTORIAL_SHOWN, false)));
        mTUserSettings.setTranslate_rulings(Boolean.valueOf(getBoolean(TRANSLATE_RULINGS, false)));
        mTUserSettings.setScan_display_language(getString(SCAN_DISPLAY_LANGUAGE, "TRANSLATED"));
        mTUserSettings.setPreferred_card_layout(getString(PREFERRED_CARDS_LAYOUT, "GRID_2"));
        mTUserSettings.setEnable_uded_q(Boolean.valueOf(getBoolean(ENABLE_UDED_Q, true)));
        mTUserSettings.setTimer_hint_shown(Boolean.valueOf(getBoolean(TIMER_HINT_SHOWN, false)));
        mTUserSettings.setBo_help_dismissed(Boolean.valueOf(getBoolean(BO_HELP_DISMISSED, false)));
        mTUserSettings.setStore_banner_dismissed(Boolean.valueOf(getBoolean(STORE_BANNER_DISMISSED, false)));
        mTUserSettings.setAlways_show_timer(Boolean.valueOf(getBoolean(ALWAYS_SHOW_TIMER, true)));
        mTUserSettings.setDefault_timer_time(getString(DEFAULT_TIMER_TIME, "90"));
        mTUserSettings.setTimer_show_seconds(Boolean.valueOf(getBoolean(TIMER_SHOW_SECONDS, false)));
        mTUserSettings.setCreator_code(getString(CREATOR_CODE, ""));
        mTUserSettings.setDisable_win_lose_questions(Boolean.valueOf(getBoolean(DISABLE_WIN_LOSE_QUESTIONS, false)));
        mTUserSettings.setDisable_win_lose_animations(Boolean.valueOf(getBoolean(DISABLE_WIN_LOSE_ANIMATIONS, false)));
        mTUserSettings.setAuto_enable_turn_timer(Boolean.valueOf(getBoolean(AUTO_ENABLE_TURN_TIMER, false)));
        mTUserSettings.setTurn_timer_display(getString(TURN_TIMER_DISPLAY, TURN_TIMER_DISPLAY_CURRENT));
        mTUserSettings.setEnable_fullscreen_mode(Boolean.valueOf(getBoolean(ENABLE_FULLSCREEN_MODE, true)));
        mTUserSettings.setEnable_battery_saving_prompts(Boolean.valueOf(getBoolean(ENABLE_BATTERY_SAVING_PROMPTS, true)));
        mTUserSettings.setLast_rulebook_language(getString(LAST_RULEBOOK_LANGUAGE, ""));
        mTUserSettings.setLast_card_picker_language(getString(LAST_CARD_PICKER_LANGUAGE, ""));
        mTUserSettings.setEnable_streaming(Boolean.valueOf(getBoolean(ENABLE_STREAMING, false)));
        mTUserSettings.setEnable_scan_beeps(Boolean.valueOf(getBoolean(ENABLE_SCAN_BEEPS, true)));
        mTUserSettings.setEnable_timer_by_default(Boolean.valueOf(getBoolean(ENABLE_TIMER_BY_DEFAULT, true)));
        mTUserSettings.setAuto_start_timer(Boolean.valueOf(getBoolean(AUTO_START_TIMER, true)));
        mTUserSettings.setApp_language(getString(APP_LANGUAGE, AndroidContextPlugin.DEVICE_KEY));
        mTUserSettings.setLast_group_by(getLastGroupBy());
        mTUserSettings.setLast_order_by(getLastOrderBy());
        mTUserSettings.setLast_order_direction(getLastOrderDirection());
        mTUserSettings.setSave_sorting_grouping_settings(Boolean.valueOf(getBoolean(SAVE_SORTING_GROUPING_SETTINGS, true)));
        mTUserSettings.setLast_deck_list_group_by(getLastDeckListGroupBy());
        mTUserSettings.setLast_deck_list_order_by(getLastDeckListOrderBy());
        mTUserSettings.setLast_deck_list_order_direction(getLastDeckListOrderDirection());
        mTUserSettings.setSave_deck_list_sorting_grouping_settings(Boolean.valueOf(getBoolean(SAVE_DECK_LIST_SORTING_GROUPING_SETTINGS, true)));
        mTUserSettings.setPreferred_market(getString(PREFERRED_MARKET, "mythictools"));
        mTUserSettings.setScan_override_language_enabled(Boolean.valueOf(getBoolean(SCAN_OVERRIDE_LANGUAGE_ENABLED, false)));
        mTUserSettings.setScan_override_language(getString(SCAN_OVERRIDE_LANGUAGE, "en"));
        mTUserSettings.setScan_override_set_enabled(Boolean.valueOf(getBoolean(SCAN_OVERRIDE_SET_ENABLED, false)));
        mTUserSettings.setScan_override_set(getString(SCAN_OVERRIDE_SET, ""));
        mTUserSettings.setScan_override_finish_enabled(Boolean.valueOf(getBoolean(SCAN_OVERRIDE_FINISH_ENABLED, false)));
        mTUserSettings.setScan_override_finish(getString(SCAN_OVERRIDE_FINISH, "nonfoil"));
        mTUserSettings.setScan_high_price_beep_enabled(Boolean.valueOf(getBoolean(SCAN_HIGH_PRICE_BEEP_ENABLED, false)));
        mTUserSettings.setScan_high_price_threshold(Float.valueOf(getFloat(SCAN_HIGH_PRICE_THRESHOLD, 2.0f)));
        mTUserSettings.setScan_purchase_price_enabled(Boolean.valueOf(getBoolean(SCAN_PURCHASE_PRICE_ENABLED, false)));
        mTUserSettings.setScan_purchase_price_mode(getString(SCAN_PURCHASE_PRICE_MODE, "current"));
        mTUserSettings.setScan_purchase_price_fixed(Float.valueOf(getFloat(SCAN_PURCHASE_PRICE_FIXED, 0.0f)));
        mTUserSettings.setIgnore_basic_lands(Boolean.valueOf(getBoolean(IGNORE_BASIC_LANDS, true)));
        mTUserSettings.setIgnore_collection(Boolean.valueOf(getBoolean(IGNORE_COLLECTION, false)));
        mTUserSettings.setIgnore_printings(Boolean.valueOf(getBoolean(IGNORE_PRINTINGS, false)));
        mTUserSettings.setClear_scan_list_after_add(Boolean.valueOf(getBoolean(CLEAR_SCAN_LIST_AFTER_ADD, false)));
        mTUserSettings.setDeck_sort_order(getDeckSortOrder());
        mTUserSettings.setEmail_opt_in(Boolean.valueOf(getBoolean(EMAIL_OPT_IN, false)));
        return mTUserSettings;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String getNameForLanguage(String lang) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        int iHashCode = lang.hashCode();
        if (iHashCode == 3201) {
            if (!lang.equals("de")) {
                return "";
            }
            String string = this.context.getString(R.string.german);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (iHashCode == 3241) {
            if (!lang.equals("en")) {
                return "";
            }
            String string2 = this.context.getString(R.string.english);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (iHashCode == 3246) {
            if (!lang.equals("es")) {
                return "";
            }
            String string3 = this.context.getString(R.string.spanish);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        if (iHashCode == 3276) {
            if (!lang.equals("fr")) {
                return "";
            }
            String string4 = this.context.getString(R.string.french);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        }
        if (iHashCode == 3371) {
            if (!lang.equals("it")) {
                return "";
            }
            String string5 = this.context.getString(R.string.italian);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return string5;
        }
        if (iHashCode == 3383) {
            if (!lang.equals("ja")) {
                return "";
            }
            String string6 = this.context.getString(R.string.japanese);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            return string6;
        }
        if (iHashCode == 3428) {
            if (!lang.equals("ko")) {
                return "";
            }
            String string7 = this.context.getString(R.string.korean);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            return string7;
        }
        if (iHashCode == 3588) {
            if (!lang.equals("pt")) {
                return "";
            }
            String string8 = this.context.getString(R.string.portuguese);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            return string8;
        }
        if (iHashCode == 3651) {
            if (!lang.equals("ru")) {
                return "";
            }
            String string9 = this.context.getString(R.string.russian);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            return string9;
        }
        switch (iHashCode) {
            case 120581:
                if (!lang.equals("zhs")) {
                    return "";
                }
                String string10 = this.context.getString(R.string.chinese_zhs);
                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                return string10;
            case 120582:
                if (!lang.equals("zht")) {
                    return "";
                }
                String string11 = this.context.getString(R.string.chinese_zht);
                Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                return string11;
            default:
                return "";
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final CardsLayout getPreferredCardLayout() {
        String string = this.sharedPreferences.getString(PREFERRED_CARDS_LAYOUT, "GRID_2");
        if (string != null && string.length() > 0) {
            switch (string.hashCode()) {
                case 2336926:
                    if (string.equals("LIST")) {
                        return CardsLayout.LIST;
                    }
                    break;
                case 2110641529:
                    if (string.equals("GRID_2")) {
                        return CardsLayout.GRID_BY_2;
                    }
                    break;
                case 2110641530:
                    if (string.equals("GRID_3")) {
                        return CardsLayout.GRID_BY_3;
                    }
                    break;
            }
        }
        return CardsLayout.GRID_BY_2;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x019d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getPreferredCurrency() {
        String string = this.sharedPreferences.getString(PREFERRED_CURRENCY_V2, "");
        String str = string;
        if (str != null && str.length() != 0) {
            return string;
        }
        String string2 = this.sharedPreferences.getString(PREFERRED_CURRENCY, "");
        String str2 = string2;
        if (str2 != null && str2.length() != 0) {
            setString(PREFERRED_CURRENCY_V2, string2);
            return string2;
        }
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
        String upperCase = country.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String language = locale.getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        String lowerCase = language.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str3 = "USD";
        if (!Intrinsics.areEqual(upperCase, "US")) {
            if (Intrinsics.areEqual(upperCase, "CA")) {
                str3 = "CAD";
            } else if (Intrinsics.areEqual(upperCase, "GB") || Intrinsics.areEqual(upperCase, "UK")) {
                str3 = "GBP";
            } else if (Intrinsics.areEqual(upperCase, "AU")) {
                str3 = "AUD";
            } else if (Intrinsics.areEqual(upperCase, "NZ")) {
                str3 = "NZD";
            } else if (Intrinsics.areEqual(upperCase, "JP")) {
                str3 = "JPY";
            } else if (Intrinsics.areEqual(upperCase, "CH")) {
                str3 = "CHF";
            } else if (Intrinsics.areEqual(upperCase, "CN")) {
                str3 = "CNY";
            } else if (Intrinsics.areEqual(upperCase, "KR")) {
                str3 = "KRW";
            } else if (Intrinsics.areEqual(upperCase, "IN")) {
                str3 = "INR";
            } else if (Intrinsics.areEqual(upperCase, "BR")) {
                str3 = "BRL";
            } else if (Intrinsics.areEqual(upperCase, "MX")) {
                str3 = "MXN";
            } else if (Intrinsics.areEqual(upperCase, "SG")) {
                str3 = "SGD";
            } else if (Intrinsics.areEqual(upperCase, "HK")) {
                str3 = "HKD";
            } else if (Intrinsics.areEqual(upperCase, "TW")) {
                str3 = "TWD";
            } else if (Intrinsics.areEqual(upperCase, "ZA")) {
                str3 = "ZAR";
            } else if (!CollectionsKt.listOf((Object[]) new String[]{"FR", "DE", "IT", "ES", "PT", "NL", "BE", "AT", "IE", "FI", "GR", "LU", "CY", "MT", "SI", "SK", "EE", "LV", "LT"}).contains(upperCase)) {
                if (Intrinsics.areEqual(upperCase, "SE")) {
                    str3 = "SEK";
                } else if (Intrinsics.areEqual(upperCase, "NO")) {
                    str3 = "NOK";
                } else if (Intrinsics.areEqual(upperCase, "DK")) {
                    str3 = "DKK";
                } else if (Intrinsics.areEqual(upperCase, GameUtils.CONDITION_PLAYED)) {
                    str3 = "PLN";
                } else if (Intrinsics.areEqual(upperCase, "CZ")) {
                    str3 = "CZK";
                } else if (Intrinsics.areEqual(upperCase, "HU")) {
                    str3 = "HUF";
                } else if (Intrinsics.areEqual(upperCase, "RO")) {
                    str3 = "RON";
                } else if (Intrinsics.areEqual(upperCase, "BG")) {
                    str3 = "BGN";
                } else if (Intrinsics.areEqual(upperCase, "TR")) {
                    str3 = "TRY";
                } else if (Intrinsics.areEqual(upperCase, "RU")) {
                    str3 = "RUB";
                } else if (Intrinsics.areEqual(upperCase, "UA")) {
                    str3 = "UAH";
                } else if (CollectionsKt.listOf((Object[]) new String[]{"fr", "de", "it", "es", "pt"}).contains(lowerCase)) {
                    str3 = "EUR";
                }
            }
        }
        setString(PREFERRED_CURRENCY_V2, str3);
        return str3;
    }

    public final CurrencyInfo getPreferredCurrencyInfo() {
        return CurrencyInfo.INSTANCE.fromCode(getPreferredCurrency());
    }

    public final String getPreferredMarket() {
        String string = this.sharedPreferences.getString(PREFERRED_MARKET, "mythictools");
        return string == null ? "mythictools" : string;
    }

    public final List<MTFullCard> getRecentCardsNew() {
        String string = this.sharedPreferences.getString(RECENT_CARDS_NEW, "");
        String str = string;
        if (str == null || str.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends MTFullCard>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getRecentCardsNew$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final List<CardState> getRecentCardsOld() {
        String string = this.sharedPreferences.getString(RECENT_CARDS, "");
        String str = string;
        if (str == null || str.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends CardState>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getRecentCardsOld$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final boolean getSaveDeckListSortingGroupingSettings() {
        return this.sharedPreferences.getBoolean(SAVE_DECK_LIST_SORTING_GROUPING_SETTINGS, true);
    }

    public final boolean getSaveSortingGroupingSettings() {
        return this.sharedPreferences.getBoolean(SAVE_SORTING_GROUPING_SETTINGS, true);
    }

    public final ScanDisplayLanguage getScanDisplayLanguage() {
        String string = this.sharedPreferences.getString(SCAN_DISPLAY_LANGUAGE, "TRANSLATED");
        return (string == null || string.length() <= 0) ? ScanDisplayLanguage.TRANSLATED : ScanDisplayLanguage.valueOf(string);
    }

    public final String getString(String id, String defaultValue) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String string = this.sharedPreferences.getString(id, defaultValue);
        return string == null ? defaultValue : string;
    }

    public final List<String> getSupportedLanguages() {
        return this.languages;
    }

    public final List<String> getThemesPurchased() {
        String string = this.sharedPreferences.getString(THEMES_PUCHASED, "");
        String str = string;
        if (str == null || str.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends String>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getThemesPurchased$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final long getTokenExpiryTime() {
        return this.sharedPreferences.getLong(TOKEN_EXPIRY_TIME, 0L);
    }

    public final List<GameState> getUnSyncedGames() {
        String string = this.sharedPreferences.getString(UNSYNCED_GAMES, "");
        if (string == null || string.length() <= 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends GameState>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getUnSyncedGames$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final List<GameSet> getUnSyncedSets() {
        String string = this.sharedPreferences.getString(UNSYNCED_SETS, "");
        if (string == null || string.length() <= 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends GameSet>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getUnSyncedSets$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final List<Integer> getUndoKOs() {
        String string = this.sharedPreferences.getString(UNDO_KO_INDEXES, "");
        if (string == null || string.length() <= 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends Integer>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getUndoKOs$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final List<Integer> getUndoWins() {
        String string = this.sharedPreferences.getString(UNDO_WIN_INDEXES, "");
        if (string == null || string.length() <= 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends Integer>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getUndoWins$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final List<String> getUnlockedPlaymats() {
        String string = this.sharedPreferences.getString(UNLOCKED_PLAYMATS, "");
        String str = string;
        if (str == null || str.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Object objFromJson = new Gson().fromJson(string, new TypeToken<List<? extends String>>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$getUnlockedPlaymats$type$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final boolean hasGame() {
        String string = this.sharedPreferences.getString(CURRENT_GAME, "");
        return string != null && string.length() > 0;
    }

    public final boolean hasSet() {
        String string = this.sharedPreferences.getString(CURRENT_SET, "");
        return string != null && string.length() > 0;
    }

    public final boolean hasTournament() {
        String string = this.sharedPreferences.getString(CURRENT_TOURNAMENT, "");
        return string != null && string.length() > 0;
    }

    public final boolean hasValidUser() {
        String string;
        String str;
        MTUser currentUser = getCurrentUser();
        String string2 = this.sharedPreferences.getString(AUTH_PROVIDER, "");
        if (Intrinsics.areEqual(string2, "google")) {
            string = this.sharedPreferences.getString(GOOGLE_TOKEN, "");
        } else {
            boolean zAreEqual = Intrinsics.areEqual(string2, FirebaseAuthProvider.PROVIDER_ID);
            SharedPreferences sharedPreferences = this.sharedPreferences;
            string = zAreEqual ? sharedPreferences.getString(FIREBASE_TOKEN, "") : sharedPreferences.getString(GOOGLE_TOKEN, "");
        }
        return (currentUser == null || (str = string) == null || str.length() == 0) ? false : true;
    }

    public final void incrementAllContainerVersions() {
        Iterator<Integer> it = CardContainerCache.INSTANCE.getAllContainerIds().iterator();
        while (it.hasNext()) {
            incrementContainerVersion(it.next().intValue());
        }
    }

    public final void incrementCollectionVersion() {
        setInt(COLLECTION_VERSION, getCollectionVersion() + 1);
        CardContainerCache.INSTANCE.incrementCollectionVersion();
    }

    public final void incrementContainerVersion(int containerId) {
        setInt(CONTAINER_VERSION_PREFIX + containerId, getContainerVersion(containerId) + 1);
        CardContainerCache.INSTANCE.incrementContainerVersion(containerId);
    }

    public final void incrementDecksVersion() {
        setInt(DECKS_VERSION, getDecksVersion() + 1);
        CardContainerCache.INSTANCE.incrementDecksVersion();
    }

    public final void incrementListsVersion() {
        setInt(LISTS_VERSION, getListsVersion() + 1);
        CardContainerCache.INSTANCE.incrementListsVersion();
    }

    public final void invalidateAllContainers() {
        incrementCollectionVersion();
        incrementListsVersion();
        incrementDecksVersion();
        CardContainerCache.INSTANCE.invalidateAll();
    }

    public final boolean isBatterySavingMode() {
        return this.sharedPreferences.getBoolean(BATTERY_SAVING_MODE, false);
    }

    public final boolean isFirstRun() {
        return this.sharedPreferences.getBoolean(FIRST_RUN, true);
    }

    public final boolean isFirstRunV2() {
        return this.sharedPreferences.getBoolean(FIRST_RUN_V2, true);
    }

    public final boolean isLanguageEnabled(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        if (this.languages.contains(language)) {
            return this.sharedPreferences.getBoolean(language, false);
        }
        return false;
    }

    public final boolean isMythicPlusActive() {
        return this.sharedPreferences.getBoolean(MYTHIC_PLUS_ACTIVE, false);
    }

    public final boolean isMythicPlusBannerDismissed() {
        return this.sharedPreferences.getBoolean(MYTHIC_PLUS_BANNER_DISMISSED, false);
    }

    public final boolean isSecondRun() {
        return this.sharedPreferences.getBoolean(SECOND_RUN, false);
    }

    public final void resetDeckListSelection() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(LAST_DECK_LIST_SELECTION, "main");
        editorEdit.apply();
    }

    public final void saveAllThemeTokens(Map<String, String> decks) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        String json = new Gson().toJson(decks);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(ALL_THEME_TOKENS, json);
        editorEdit.apply();
    }

    public final void saveAllThemeVersions(Map<String, Integer> decks) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        String json = new Gson().toJson(decks);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(ALL_THEME_VERSIONS, json);
        editorEdit.apply();
    }

    public final void saveAllUsersDecks(Map<Integer, ? extends List<MTDeck>> decks) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        String json = new Gson().toJson(decks);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(ALL_USER_DECKS, json);
        editorEdit.apply();
    }

    public final void saveCurrentDeckScanList(List<MTFullCard> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        String json = new Gson().toJson(list);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_DECK_SCAN_LIST, json);
        editorEdit.apply();
    }

    public final void saveCurrentGame(GameState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        String json = new Gson().toJson(state);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_GAME, json);
        editorEdit.apply();
    }

    public final void saveCurrentListScanList(int listId, List<MTFullCard> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        String json = new Gson().toJson(list);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString("current_list_scan_list_" + listId, json);
        editorEdit.apply();
    }

    public final void saveCurrentSet(GameSet set) {
        Intrinsics.checkNotNullParameter(set, "set");
        String json = new Gson().toJson(set);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_SET, json);
        editorEdit.apply();
    }

    public final void saveCurrentTournament(Tournament state) {
        Intrinsics.checkNotNullParameter(state, "state");
        String json = new Gson().toJson(state);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_TOURNAMENT, json);
        editorEdit.apply();
    }

    public final void saveCurrentUser(MTUser user) {
        Intrinsics.checkNotNullParameter(user, "user");
        String json = new Gson().toJson(user);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_USER, json);
        editorEdit.apply();
    }

    public final void saveCurrentUserArchivedDecks(List<MTDeck> decks) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        String json = new Gson().toJson(decks);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_USER_ARCHIVED_DECKS, json);
        editorEdit.apply();
    }

    public final void saveCurrentUserCache(List<MTUser> decks) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        String json = new Gson().toJson(decks);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_USER_CACHE, json);
        editorEdit.apply();
    }

    public final void saveCurrentUserCollection(MTCollection friends) {
        Intrinsics.checkNotNullParameter(friends, "friends");
        String json = new Gson().toJson(friends);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_USER_COLLECTION, json);
        editorEdit.apply();
    }

    public final void saveCurrentUserDecks(List<MTDeck> decks) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        String json = new Gson().toJson(decks);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_USER_DECKS, json);
        editorEdit.apply();
    }

    public final void saveCurrentUserFavorites(MTFavorites favorites) {
        Intrinsics.checkNotNullParameter(favorites, "favorites");
        String json = new Gson().toJson(favorites);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_USER_FAVORITES, json);
        editorEdit.apply();
    }

    public final void saveCurrentUserFriends(List<MTFriend> friends) {
        Intrinsics.checkNotNullParameter(friends, "friends");
        String json = new Gson().toJson(friends);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_USER_FRIENDS, json);
        editorEdit.apply();
    }

    public final void saveCurrentUserLists(MTUserLists friends) {
        Intrinsics.checkNotNullParameter(friends, "friends");
        String json = new Gson().toJson(friends);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_USER_LISTS, json);
        editorEdit.apply();
    }

    public final void saveCurrentUserPlaygroups(List<MTPlaygroup> playgroups) {
        Intrinsics.checkNotNullParameter(playgroups, "playgroups");
        String json = new Gson().toJson(playgroups);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_USER_PLAYGROUPS, json);
        editorEdit.apply();
    }

    public final void saveCurrentUserPrivacy(MTUserPrivacy privacy) {
        Intrinsics.checkNotNullParameter(privacy, "privacy");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_USER_PRIVACY, new Gson().toJson(privacy));
        editorEdit.apply();
    }

    public final void saveCurrentUserScanList(List<MTFullCard> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        String json = new Gson().toJson(list);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_USER_SCAN_LIST, json);
        editorEdit.apply();
    }

    public final void saveCurrentUserTags(MTUserTags tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        String json = new Gson().toJson(tags);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_USER_TAGS, json);
        editorEdit.apply();
    }

    public final void saveCurrentUserTrophies(List<MTTrophy> friends) {
        Intrinsics.checkNotNullParameter(friends, "friends");
        String json = new Gson().toJson(friends);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_USER_TROPHIES, json);
        editorEdit.apply();
    }

    public final void saveGameSelectedDeck(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        Map mutableMap = MapsKt.toMutableMap(getGameSelectedDecks());
        mutableMap.put(Integer.valueOf(deck.getId()), deck);
        Gson gson = new Gson();
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(GAME_SELECTED_DECKS, gson.toJson(mutableMap));
        editorEdit.apply();
    }

    public final void saveLocalThemesCache(List<MTTheme> themes) {
        Intrinsics.checkNotNullParameter(themes, "themes");
        String json = new Gson().toJson(themes);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(LOCAL_THEMES_CACHE, json);
        editorEdit.apply();
    }

    public final void saveUnSyncedGames(List<GameState> games) {
        Intrinsics.checkNotNullParameter(games, "games");
        String json = new Gson().toJson(games);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(UNSYNCED_GAMES, json);
        editorEdit.apply();
    }

    public final void saveUnSyncedSets(List<GameSet> sets) {
        Intrinsics.checkNotNullParameter(sets, "sets");
        String json = new Gson().toJson(sets);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(UNSYNCED_SETS, json);
        editorEdit.apply();
    }

    public final void saveUndoKOs(List<Integer> decks) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        String json = new Gson().toJson(decks);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(UNDO_KO_INDEXES, json);
        editorEdit.apply();
    }

    public final void saveUndoWins(List<Integer> decks) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        String json = new Gson().toJson(decks);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(UNDO_WIN_INDEXES, json);
        editorEdit.apply();
    }

    public final void setBatterySavingMode(boolean value) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(BATTERY_SAVING_MODE, value);
        editorEdit.apply();
    }

    public final void setBoolean(String id, boolean value) {
        Intrinsics.checkNotNullParameter(id, "id");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(id, value);
        editorEdit.apply();
    }

    public final void setClearScanListAfterAdd(boolean value) {
        setBoolean(CLEAR_SCAN_LIST_AFTER_ADD, value);
    }

    public final void setCurrentSearch(String search) {
        Intrinsics.checkNotNullParameter(search, "search");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_SEARCH, search);
        editorEdit.apply();
    }

    public final void setCurrentSetFilter(String search) {
        Intrinsics.checkNotNullParameter(search, "search");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(CURRENT_SET_FILTER, search);
        editorEdit.apply();
    }

    public final void setDeckSortOrder(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        setString(DECK_SORT_ORDER, value);
    }

    public final void setFirstRun(boolean value) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(FIRST_RUN, value);
        editorEdit.apply();
    }

    public final void setFirstRunV2(boolean value) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(FIRST_RUN_V2, value);
        editorEdit.apply();
    }

    public final void setFloat(String id, float value) {
        Intrinsics.checkNotNullParameter(id, "id");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putFloat(id, value);
        editorEdit.apply();
    }

    public final void setForcedApiUpdate(boolean forced) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean("forced_api_update", forced);
        editorEdit.apply();
    }

    public final void setInt(String id, int value) {
        Intrinsics.checkNotNullParameter(id, "id");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putInt(id, value);
        editorEdit.apply();
    }

    public final void setLanguageEnabled(String language, boolean enabled) {
        Intrinsics.checkNotNullParameter(language, "language");
        if (this.languages.contains(language)) {
            this.editor.putBoolean(language, enabled).apply();
        }
    }

    public final void setLastApiUpdate(long time) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putLong("last_api_update", time);
        editorEdit.apply();
    }

    public final void setLastDeckListGroupBy(String value) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        if (value == null || value.length() == 0) {
            editorEdit.remove(LAST_DECK_LIST_GROUP_BY);
        } else {
            editorEdit.putString(LAST_DECK_LIST_GROUP_BY, value);
        }
        editorEdit.apply();
    }

    public final void setLastDeckListOrderBy(String value) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        if (value == null || value.length() == 0) {
            editorEdit.remove(LAST_DECK_LIST_ORDER_BY);
        } else {
            editorEdit.putString(LAST_DECK_LIST_ORDER_BY, value);
        }
        editorEdit.apply();
    }

    public final void setLastDeckListOrderDirection(String value) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        if (value == null || value.length() == 0) {
            editorEdit.remove(LAST_DECK_LIST_ORDER_DIRECTION);
        } else {
            editorEdit.putString(LAST_DECK_LIST_ORDER_DIRECTION, value);
        }
        editorEdit.apply();
    }

    public final void setLastDeckListSelection(String selection) {
        Intrinsics.checkNotNullParameter(selection, "selection");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(LAST_DECK_LIST_SELECTION, selection);
        editorEdit.apply();
    }

    public final void setLastGroupBy(String value) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        if (value == null || value.length() == 0) {
            editorEdit.remove(LAST_GROUP_BY);
        } else {
            editorEdit.putString(LAST_GROUP_BY, value);
        }
        editorEdit.apply();
    }

    public final void setLastMessagesUpdate(long time) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putLong("last_messages_update", time);
        editorEdit.apply();
    }

    public final void setLastOrderBy(String value) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        if (value == null || value.length() == 0) {
            editorEdit.remove(LAST_ORDER_BY);
        } else {
            editorEdit.putString(LAST_ORDER_BY, value);
        }
        editorEdit.apply();
    }

    public final void setLastOrderDirection(String value) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        if (value == null || value.length() == 0) {
            editorEdit.remove(LAST_ORDER_DIRECTION);
        } else {
            editorEdit.putString(LAST_ORDER_DIRECTION, value);
        }
        editorEdit.apply();
    }

    public final void setMythicPlusActive(boolean active) {
        this.sharedPreferences.edit().putBoolean(MYTHIC_PLUS_ACTIVE, active).apply();
    }

    public final void setMythicPlusBannerDismissed(boolean value) {
        this.sharedPreferences.edit().putBoolean(MYTHIC_PLUS_BANNER_DISMISSED, value).apply();
    }

    public final void setOnboardingSeen(int id) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(ONBOARDING_SEEN_PREFIX + id, true);
        editorEdit.apply();
    }

    public final void setPreferredCardLayout(CardsLayout layout) {
        String str;
        Intrinsics.checkNotNullParameter(layout, "layout");
        int i = WhenMappings.$EnumSwitchMapping$0[layout.ordinal()];
        if (i == 1) {
            str = "GRID_2";
        } else if (i == 2) {
            str = "GRID_3";
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = "LIST";
        }
        setString(PREFERRED_CARDS_LAYOUT, str);
    }

    public final void setPreferredMarket(String market) {
        Intrinsics.checkNotNullParameter(market, "market");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(PREFERRED_MARKET, market);
        editorEdit.apply();
    }

    public final void setRecentCardsNew(List<MTFullCard> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.editor.putString(RECENT_CARDS_NEW, new Gson().toJson(list)).apply();
    }

    public final void setSaveDeckListSortingGroupingSettings(boolean value) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(SAVE_DECK_LIST_SORTING_GROUPING_SETTINGS, value);
        editorEdit.apply();
    }

    public final void setSaveSortingGroupingSettings(boolean value) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(SAVE_SORTING_GROUPING_SETTINGS, value);
        editorEdit.apply();
    }

    public final void setSecondRun(boolean value) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(SECOND_RUN, value);
        editorEdit.apply();
    }

    public final void setString(String id, String value) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(id, value);
        editorEdit.apply();
    }

    public final void setThemesPurchased(List<String> themes) {
        Intrinsics.checkNotNullParameter(themes, "themes");
        String json = new Gson().toJson(themes);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(THEMES_PUCHASED, json);
        editorEdit.apply();
    }

    public final void setTokenExpiryTime(long time) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putLong(TOKEN_EXPIRY_TIME, time);
        editorEdit.apply();
    }

    public final void syncCurrentSettingsToAPI(final Function0<Unit> onComplete) {
        MTUser currentUser = getCurrentUser();
        if (currentUser != null) {
            MTApiKt.getMtApi().syncSettings(currentUser.getId(), getMTUserSettings()).enqueue(new Callback<MTSuccessResponse>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$syncCurrentSettingsToAPI$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTSuccessResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    Function0<Unit> function0 = onComplete;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTSuccessResponse> call, Response<MTSuccessResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    Function0<Unit> function0 = onComplete;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            });
        } else if (onComplete != null) {
            onComplete.invoke();
        }
    }

    public final void syncRecentCard(final MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        MTUser currentUser = getCurrentUser();
        if (currentUser == null) {
            List<MTFullCard> mutableList = CollectionsKt.toMutableList((Collection) getRecentCardsNew());
            List<MTFullCard> list = mutableList;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MTFullCard mTFullCard = (MTFullCard) it.next();
                    if (Intrinsics.areEqual(mTFullCard.getLang(), card.getLang()) && Intrinsics.areEqual(mTFullCard.getSet_code(), card.getSet_code()) && Intrinsics.areEqual(mTFullCard.getCollector_number(), card.getCollector_number())) {
                        CollectionsKt.removeAll((List) mutableList, new Function1() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Boolean.valueOf(PreferencesManager.syncRecentCard$lambda$1$1(card, (MTFullCard) obj));
                            }
                        });
                        break;
                    }
                }
            }
            mutableList.add(0, card);
            setRecentCardsNew(mutableList);
            return;
        }
        if (recentCardListId >= 0) {
            MTCardListBody mTCardListBody = new MTCardListBody(null, 1, null);
            ArrayList arrayList = new ArrayList();
            MTFullCard mTFullCard2 = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
            mTFullCard2.setCardid(null);
            mTFullCard2.setSet_code(card.getSet_code());
            mTFullCard2.setCollector_number(card.getCollector_number());
            mTFullCard2.setLang(card.getLang());
            mTFullCard2.setFinish(card.getFinish());
            List<String> finishes = card.getFinishes();
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
            mTCardListBody.setCards(arrayList);
            MTApiKt.getMtApi().addCardsToList(currentUser.getId(), recentCardListId, null, null, null, null, null, null, mTCardListBody).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$syncRecentCard$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    Log.e("PreferencesManager", "Failed to add MT Card to recent list: " + t.getMessage());
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (response.isSuccessful()) {
                        MTCardListResponse mTCardListResponseBody = response.body();
                        MTCardContainer list2 = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                        if (list2 != null) {
                            PreferencesManager preferencesManager = this.this$0;
                            preferencesManager.incrementContainerVersion(list2.getId());
                            preferencesManager.incrementCollectionVersion();
                            preferencesManager.incrementListsVersion();
                            CardContainerCache.INSTANCE.setCachedContainer(list2, list2.getId());
                            List<MTFullCard> cards = list2.getCards();
                            if (cards == null) {
                                cards = CollectionsKt.emptyList();
                            }
                            preferencesManager.setRecentCardsNew(cards);
                        }
                    }
                }
            });
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void syncThemePurchase(String currentSku) {
        String str;
        Intrinsics.checkNotNullParameter(currentSku, "currentSku");
        MTUser currentUser = getCurrentUser();
        if (currentUser != null) {
            switch (currentSku.hashCode()) {
                case -2020138166:
                    str = !currentSku.equals(SOLRING_THEME) ? "" : SOLRING_PURCHASE;
                    break;
                case -907471348:
                    if (currentSku.equals(LUPO_THEME)) {
                        str = LUPO_PURCHASE;
                        break;
                    }
                    break;
                case 132555497:
                    if (currentSku.equals(AF_THEME)) {
                        str = AF_PURCHASE;
                        break;
                    }
                    break;
                case 548719237:
                    if (currentSku.equals(BURN_THEME)) {
                        str = BURN_PURCHASE;
                        break;
                    }
                    break;
                case 549011496:
                    if (currentSku.equals(LOVE_THEME)) {
                        str = LOVE_PURCHASE;
                        break;
                    }
                    break;
                case 1376096521:
                    if (currentSku.equals(XMAS_THEME)) {
                        str = XMAS_PURCHASE;
                        break;
                    }
                    break;
            }
            MTApiKt.getMtApi().syncPurchase(currentUser.getId(), str).enqueue(new Callback<MTSuccessResponse>() { // from class: com.studiolaganne.lengendarylens.PreferencesManager$syncThemePurchase$1$1
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

    public final boolean wasOnboardingSeen(int id) {
        return this.sharedPreferences.getBoolean(ONBOARDING_SEEN_PREFIX + id, false);
    }
}
