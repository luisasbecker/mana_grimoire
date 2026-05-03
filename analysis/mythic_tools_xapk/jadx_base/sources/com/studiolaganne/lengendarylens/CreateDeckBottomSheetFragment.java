package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Size;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.studiolaganne.lengendarylens.BracketDialogFragment;
import com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelperLocalized;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: CreateDeckBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b^\n\u0002\u0010!\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u0081\u00022\u00020\u0001:\u0002\u0081\u0002B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010Î\u0001\u001a\u00030Ï\u00012\n\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u0001H\u0016J.\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u00012\b\u0010Ô\u0001\u001a\u00030Õ\u00012\n\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u00012\n\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u0001H\u0016J\n\u0010Ø\u0001\u001a\u00030Ï\u0001H\u0016J\u0014\u0010Ù\u0001\u001a\u00030Ï\u00012\b\u0010Ú\u0001\u001a\u00030Ó\u0001H\u0002J\u0014\u0010Û\u0001\u001a\u00030Ï\u00012\b\u0010Ú\u0001\u001a\u00030Ó\u0001H\u0002J\u0013\u0010Ü\u0001\u001a\u00030Ï\u00012\u0007\u0010Ý\u0001\u001a\u00020\u001cH\u0002J\n\u0010Þ\u0001\u001a\u00030Ï\u0001H\u0002J(\u0010ß\u0001\u001a\u00030Ï\u00012\b\u0010Ú\u0001\u001a\u00030Ó\u00012\u0007\u0010à\u0001\u001a\u00020\u000f2\t\u0010á\u0001\u001a\u0004\u0018\u00010\u001cH\u0002J0\u0010â\u0001\u001a\u00030Ï\u00012\u0007\u0010ã\u0001\u001a\u00020\u001c2\u0007\u0010ä\u0001\u001a\u00020\u001c2\u0007\u0010å\u0001\u001a\u00020\u00122\t\b\u0002\u0010æ\u0001\u001a\u00020\u000fH\u0002J\u001b\u0010ç\u0001\u001a\u00030Ï\u00012\b\u0010è\u0001\u001a\u00030é\u00012\u0007\u0010å\u0001\u001a\u00020\u0012J\u001d\u0010ê\u0001\u001a\u00030Ï\u00012\b\u0010è\u0001\u001a\u00030é\u00012\u0007\u0010å\u0001\u001a\u00020\u0012H\u0002J\u001b\u0010ë\u0001\u001a\u00030Ï\u00012\b\u0010è\u0001\u001a\u00030é\u00012\u0007\u0010å\u0001\u001a\u00020\u0012J\u001d\u0010ì\u0001\u001a\u00030Ï\u00012\b\u0010è\u0001\u001a\u00030é\u00012\u0007\u0010å\u0001\u001a\u00020\u0012H\u0002J\n\u0010í\u0001\u001a\u00030Ï\u0001H\u0002J \u0010î\u0001\u001a\u00030Ï\u00012\b\u0010Ú\u0001\u001a\u00030Ó\u00012\n\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u0001H\u0016J\u0014\u0010ï\u0001\u001a\u00030Ï\u00012\b\u0010Ú\u0001\u001a\u00030Ó\u0001H\u0002J\u001d\u0010ð\u0001\u001a\u00030Ï\u00012\b\u0010ñ\u0001\u001a\u00030Æ\u00012\u0007\u0010ò\u0001\u001a\u00020\u001cH\u0002J\u001a\u0010ó\u0001\u001a\u00030Ï\u00012\u0007\u0010ô\u0001\u001a\u00020\u001cH\u0082@¢\u0006\u0003\u0010õ\u0001J\u001a\u0010ö\u0001\u001a\u00030Ï\u00012\u0007\u0010ô\u0001\u001a\u00020\u001cH\u0082@¢\u0006\u0003\u0010õ\u0001J\u0014\u0010÷\u0001\u001a\u00030Ï\u00012\b\u0010ñ\u0001\u001a\u00030Æ\u0001H\u0002J\u001a\u0010ø\u0001\u001a\u00030Ï\u00012\u0007\u0010ô\u0001\u001a\u00020\u001cH\u0082@¢\u0006\u0003\u0010õ\u0001J\n\u0010ù\u0001\u001a\u00030Ï\u0001H\u0002J\u0014\u0010ú\u0001\u001a\u00020\u000f2\t\u0010û\u0001\u001a\u0004\u0018\u00010\u001cH\u0002J\u0014\u0010ü\u0001\u001a\u00020\u000f2\t\u0010û\u0001\u001a\u0004\u0018\u00010\u001cH\u0002J\u001e\u0010ý\u0001\u001a\u00030Ï\u00012\b\u0010þ\u0001\u001a\u00030ÿ\u00012\b\u0010Ö\u0001\u001a\u00030Ó\u0001H\u0002J\n\u0010\u0080\u0002\u001a\u00030Ï\u0001H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R\u001c\u0010/\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001e\"\u0004\b1\u0010 R\u001e\u00102\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00108\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001e\"\u0004\b:\u0010 R\u001c\u0010;\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u0010 R\u001c\u0010>\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001e\"\u0004\b@\u0010 R\u001c\u0010A\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001e\"\u0004\bC\u0010 R\u001c\u0010D\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001e\"\u0004\bF\u0010 R\u001c\u0010G\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u001e\"\u0004\bI\u0010 R\u001c\u0010J\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u001e\"\u0004\bL\u0010 R\u001c\u0010M\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u001e\"\u0004\bO\u0010 R\u001c\u0010P\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u001e\"\u0004\bR\u0010 R\u001e\u0010S\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\bT\u00104\"\u0004\bU\u00106R\u001c\u0010V\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u001e\"\u0004\bX\u0010 R\u001e\u0010Y\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\bZ\u00104\"\u0004\b[\u00106R\u0010\u0010\\\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u001e\"\u0004\bd\u0010 R\u001a\u0010e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u0018\"\u0004\bg\u0010\u001aR\u001a\u0010h\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0018\"\u0004\bj\u0010\u001aR\u000e\u0010k\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010l\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u0018\"\u0004\b1\u0010\u001aR\u001a\u0010m\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0018\"\u0004\bn\u0010\u001aR\u001a\u0010o\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0018\"\u0004\bp\u0010\u001aR\u001a\u0010q\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0018\"\u0004\br\u0010\u001aR\u001a\u0010s\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0018\"\u0004\bt\u0010\u001aR\u001a\u0010u\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u0018\"\u0004\bv\u0010\u001aR\u001a\u0010w\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u001e\"\u0004\by\u0010 R\u001a\u0010z\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u001e\"\u0004\b|\u0010 R\u001a\u0010}\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u001e\"\u0004\b\u007f\u0010 R&\u0010\u0080\u0001\u001a\t\u0012\u0004\u0012\u00020\u001c0\u0081\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R&\u0010\u0086\u0001\u001a\t\u0012\u0004\u0012\u00020\u001c0\u0081\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0083\u0001\"\u0006\b\u0088\u0001\u0010\u0085\u0001R\u001f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010\u001e\"\u0005\b\u008b\u0001\u0010 R\u001f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010\u001e\"\u0005\b\u008e\u0001\u0010 R\u000f\u0010\u008f\u0001\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0091\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\u0018\"\u0005\b\u0093\u0001\u0010\u001aR\u001d\u0010\u0094\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u0018\"\u0005\b\u0096\u0001\u0010\u001aR\u000f\u0010\u0097\u0001\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R\u000f\u0010\u009e\u0001\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0099\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010\u009b\u0001\"\u0006\b¡\u0001\u0010\u009d\u0001R\"\u0010¢\u0001\u001a\u0005\u0018\u00010£\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R\"\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R'\u0010®\u0001\u001a\n\u0012\u0005\u0012\u00030©\u00010\u0081\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¯\u0001\u0010\u0083\u0001\"\u0006\b°\u0001\u0010\u0085\u0001R\"\u0010±\u0001\u001a\u0005\u0018\u00010²\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R\"\u0010·\u0001\u001a\u0005\u0018\u00010²\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0001\u0010´\u0001\"\u0006\b¹\u0001\u0010¶\u0001R\"\u0010º\u0001\u001a\u0005\u0018\u00010²\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0001\u0010´\u0001\"\u0006\b¼\u0001\u0010¶\u0001R\u0011\u0010½\u0001\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¾\u0001\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¿\u0001\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010À\u0001\u001a\u0005\u0018\u00010\u0099\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÁ\u0001\u0010\u009b\u0001\"\u0006\bÂ\u0001\u0010\u009d\u0001R\u0010\u0010Ã\u0001\u001a\u00030Ä\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0017\u0010Å\u0001\u001a\n\u0012\u0005\u0012\u00030Æ\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030Æ\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010È\u0001\u001a\u00030Ä\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0017\u0010É\u0001\u001a\n\u0012\u0005\u0012\u00030Æ\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010Ê\u0001\u001a\n\u0012\u0005\u0012\u00030Æ\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Ë\u0001\u001a\u00030Ä\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0017\u0010Ì\u0001\u001a\n\u0012\u0005\u0012\u00030Æ\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010Í\u0001\u001a\n\u0012\u0005\u0012\u00030Æ\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0082\u0002"}, d2 = {"Lcom/studiolaganne/lengendarylens/CreateDeckBottomSheetFragment;", "Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "<init>", "()V", "callback", "Lcom/studiolaganne/lengendarylens/CreateDeckCallback;", "cardSearchLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "pickCardLauncher", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "editMode", "", "guestMode", "formatIdForGuest", "", "tempMode", "formatIdForTemp", "userIdForTemp", "deckNameWasTyped", "getDeckNameWasTyped", "()Z", "setDeckNameWasTyped", "(Z)V", "deckName", "", "getDeckName", "()Ljava/lang/String;", "setDeckName", "(Ljava/lang/String;)V", "format", "Lcom/studiolaganne/lengendarylens/MTFormat;", "getFormat", "()Lcom/studiolaganne/lengendarylens/MTFormat;", "setFormat", "(Lcom/studiolaganne/lengendarylens/MTFormat;)V", "deckType", "getDeckType", "()I", "setDeckType", "(I)V", "commander", "getCommander", "setCommander", "partner", "getPartner", "setPartner", "bracket", "getBracket", "()Ljava/lang/Integer;", "setBracket", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "signaturespell", "getSignaturespell", "setSignaturespell", "partnersignaturespell", "getPartnersignaturespell", "setPartnersignaturespell", "leftplaymat", "getLeftplaymat", "setLeftplaymat", "rightplaymat", "getRightplaymat", "setRightplaymat", "commanderCardId", "getCommanderCardId", "setCommanderCardId", "partnerCardId", "getPartnerCardId", "setPartnerCardId", "signatureSpellCardId", "getSignatureSpellCardId", "setSignatureSpellCardId", "partnerSignatureSpellCardId", "getPartnerSignatureSpellCardId", "setPartnerSignatureSpellCardId", "rightplaymatCardId", "getRightplaymatCardId", "setRightplaymatCardId", "rightplaymatFaceIndex", "getRightplaymatFaceIndex", "setRightplaymatFaceIndex", "leftplaymatCardId", "getLeftplaymatCardId", "setLeftplaymatCardId", "leftplaymatFaceIndex", "getLeftplaymatFaceIndex", "setLeftplaymatFaceIndex", "rightPlaymatPreviewUrl", "leftPlaymatPreviewUrl", "rightPlaymatScryfallId", "leftPlaymatScryfallId", "rightPlaymatPreviewUrlArtCrop", "leftPlaymatPreviewUrlArtCrop", "externalUrl", "getExternalUrl", "setExternalUrl", "shouldImport", "getShouldImport", "setShouldImport", "shouldAutoSync", "getShouldAutoSync", "setShouldAutoSync", "selectedPrivacyType", "isPartner", "isBackground", "setBackground", "isDoctor", "setDoctor", "isDoctorCompanion", "setDoctorCompanion", "isFriendsForever", "setFriendsForever", "isSignatureSpell", "setSignatureSpell", "commanderLang", "getCommanderLang", "setCommanderLang", "partnerLang", "getPartnerLang", "setPartnerLang", "playmatLang", "getPlaymatLang", "setPlaymatLang", "commanderIdentity", "", "getCommanderIdentity", "()Ljava/util/List;", "setCommanderIdentity", "(Ljava/util/List;)V", "partnerIdentity", "getPartnerIdentity", "setPartnerIdentity", "commanderColorOverride", "getCommanderColorOverride", "setCommanderColorOverride", "partnerColorOverride", "getPartnerColorOverride", "setPartnerColorOverride", "commanderIsColorChoosing", "partnerIsColorChoosing", "updatingCommander", "getUpdatingCommander", "setUpdatingCommander", "updatingPartner", "getUpdatingPartner", "setUpdatingPartner", "lastCommanderQuery", "searchCommanderJob", "Lkotlinx/coroutines/Job;", "getSearchCommanderJob", "()Lkotlinx/coroutines/Job;", "setSearchCommanderJob", "(Lkotlinx/coroutines/Job;)V", "lastPartnerQuery", "searchPartnerJob", "getSearchPartnerJob", "setSearchPartnerJob", "dbHelper", "Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "getDbHelper", "()Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "setDbHelper", "(Lcom/studiolaganne/lengendarylens/MTGDBHelper;)V", "localizedHelper", "Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "getLocalizedHelper", "()Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "setLocalizedHelper", "(Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;)V", "localizedHelpers", "getLocalizedHelpers", "setLocalizedHelpers", "commanderPopupWindow", "Landroid/widget/PopupWindow;", "getCommanderPopupWindow", "()Landroid/widget/PopupWindow;", "setCommanderPopupWindow", "(Landroid/widget/PopupWindow;)V", "partnerPopupWindow", "getPartnerPopupWindow", "setPartnerPopupWindow", "playmatCardPopupWindow", "getPlaymatCardPopupWindow", "setPlaymatCardPopupWindow", "selectedColors", "updatingPlaymatCard", "lastPlaymatCardQuery", "searchPlaymatCardJob", "getSearchPlaymatCardJob", "setSearchPlaymatCardJob", "searchViewModel", "Lcom/studiolaganne/lengendarylens/MTCardSearchViewModel;", "currentLocalCommanderCards", "Lcom/studiolaganne/lengendarylens/MTGCardRecord;", "currentOnlineCommanderCards", "partnerSearchViewModel", "currentLocalPartnerCards", "currentOnlinePartnerCards", "playmatSearchViewModel", "currentLocalPlaymatCards", "currentOnlinePlaymatCards", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "setupColorSelection", ViewHierarchyConstants.VIEW_KEY, "setupCommanderPartnerColorOverridePickers", "displayColorIdentity", "colors", "refreshDisplayColorIdentity", "applyOverridePipState", "isCommander", "override", "updateColorIdentity", "type", "cardId", OptionalModuleUtils.FACE, "isScryfallId", "updateCardId", "fullCard", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "applyCardUpdate", "cardScanned", "applyScannedCard", "updateBracketSelection", "onViewCreated", "updateTypeSelection", "applyMTCardId", "card", "role", "performPlaymatCardSearch", SearchIntents.EXTRA_QUERY, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performCommanderSearch", "acceptCommanderCard", "performPartnerSearch", "updatePlaymatPreview", "isValidDeckUrl", "url", "isMoxfieldUrl", "updatePrivacySelectorUI", Constants.ScionAnalytics.PARAM_LABEL, "Landroid/widget/TextView;", "updateSubmitButtonState", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateDeckBottomSheetFragment extends TransparentBottomSheet {
    private static final String ARG_DECK_FORMAT_FOR_GUEST = "guest_deck_formatId";
    private static final String ARG_DECK_FORMAT_FOR_MTUSER = "temp_deck_formatId";
    private static final String ARG_DECK_JSON = "deck_json";
    private static final String ARG_DECK_MTUSER_ID = "temp_deck_userId";
    private static final String ARG_USER_JSON = "user_json";
    public static final String TAG = "CreateDeckBottomSheetFragment";
    private Integer bracket;
    private CreateDeckCallback callback;
    private ActivityResultLauncher<Intent> cardSearchLauncher;
    private String commander;
    private String commanderCardId;
    private String commanderColorOverride;
    private boolean commanderIsColorChoosing;
    private PopupWindow commanderPopupWindow;
    private MTGDBHelper dbHelper;
    private MTDeck deck;
    private boolean deckNameWasTyped;
    private int deckType;
    private boolean editMode;
    private String externalUrl;
    private MTFormat format;
    private boolean guestMode;
    private boolean isBackground;
    private boolean isDoctor;
    private boolean isDoctorCompanion;
    private boolean isFriendsForever;
    private boolean isPartner;
    private boolean isSignatureSpell;
    private String leftPlaymatPreviewUrl;
    private boolean leftPlaymatPreviewUrlArtCrop;
    private String leftPlaymatScryfallId;
    private String leftplaymat;
    private String leftplaymatCardId;
    private Integer leftplaymatFaceIndex;
    private MTGDBHelperLocalized localizedHelper;
    private String partner;
    private String partnerCardId;
    private String partnerColorOverride;
    private boolean partnerIsColorChoosing;
    private PopupWindow partnerPopupWindow;
    private MTCardSearchViewModel partnerSearchViewModel;
    private String partnerSignatureSpellCardId;
    private String partnersignaturespell;
    private ActivityResultLauncher<Intent> pickCardLauncher;
    private PopupWindow playmatCardPopupWindow;
    private MTCardSearchViewModel playmatSearchViewModel;
    private String rightPlaymatPreviewUrl;
    private boolean rightPlaymatPreviewUrlArtCrop;
    private String rightPlaymatScryfallId;
    private String rightplaymat;
    private String rightplaymatCardId;
    private Integer rightplaymatFaceIndex;
    private Job searchCommanderJob;
    private Job searchPartnerJob;
    private Job searchPlaymatCardJob;
    private MTCardSearchViewModel searchViewModel;
    private String selectedColors;
    private boolean shouldAutoSync;
    private boolean shouldImport;
    private String signatureSpellCardId;
    private String signaturespell;
    private boolean tempMode;
    private boolean updatingCommander;
    private boolean updatingPartner;
    private boolean updatingPlaymatCard;
    private MTUser user;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private int formatIdForGuest = -1;
    private int formatIdForTemp = -1;
    private int userIdForTemp = -1;
    private String deckName = "";
    private String selectedPrivacyType = MTApiKt.PRIVACY_TYPE_PUBLIC;
    private String commanderLang = "en";
    private String partnerLang = "en";
    private String playmatLang = "en";
    private List<String> commanderIdentity = new ArrayList();
    private List<String> partnerIdentity = new ArrayList();
    private String lastCommanderQuery = "";
    private String lastPartnerQuery = "";
    private List<MTGDBHelperLocalized> localizedHelpers = new ArrayList();
    private String lastPlaymatCardQuery = "";
    private List<MTGCardRecord> currentLocalCommanderCards = new ArrayList();
    private List<MTGCardRecord> currentOnlineCommanderCards = new ArrayList();
    private List<MTGCardRecord> currentLocalPartnerCards = new ArrayList();
    private List<MTGCardRecord> currentOnlinePartnerCards = new ArrayList();
    private List<MTGCardRecord> currentLocalPlaymatCards = new ArrayList();
    private List<MTGCardRecord> currentOnlinePlaymatCards = new ArrayList();

    /* JADX INFO: compiled from: CreateDeckBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J:\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019JB\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/CreateDeckBottomSheetFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_USER_JSON", "ARG_DECK_JSON", "ARG_DECK_FORMAT_FOR_GUEST", "ARG_DECK_FORMAT_FOR_MTUSER", "ARG_DECK_MTUSER_ID", "newInstance", "Lcom/studiolaganne/lengendarylens/CreateDeckBottomSheetFragment;", "callback", "Lcom/studiolaganne/lengendarylens/CreateDeckCallback;", "cardSearchLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "pickCardLauncher", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "newInstanceForGuest", "formatId", "", "newInstanceForMTUser", "currentUser", "forUserId", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ CreateDeckBottomSheetFragment newInstance$default(Companion companion, CreateDeckCallback createDeckCallback, ActivityResultLauncher activityResultLauncher, ActivityResultLauncher activityResultLauncher2, MTUser mTUser, MTDeck mTDeck, int i, Object obj) {
            if ((i & 16) != 0) {
                mTDeck = null;
            }
            return companion.newInstance(createDeckCallback, activityResultLauncher, activityResultLauncher2, mTUser, mTDeck);
        }

        public final CreateDeckBottomSheetFragment newInstance(CreateDeckCallback callback, ActivityResultLauncher<Intent> cardSearchLauncher, ActivityResultLauncher<Intent> pickCardLauncher, MTUser user, MTDeck deck) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(cardSearchLauncher, "cardSearchLauncher");
            Intrinsics.checkNotNullParameter(pickCardLauncher, "pickCardLauncher");
            Intrinsics.checkNotNullParameter(user, "user");
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment = new CreateDeckBottomSheetFragment();
            createDeckBottomSheetFragment.callback = callback;
            createDeckBottomSheetFragment.cardSearchLauncher = cardSearchLauncher;
            createDeckBottomSheetFragment.pickCardLauncher = pickCardLauncher;
            String json = new Gson().toJson(user);
            String json2 = deck != null ? new Gson().toJson(deck) : null;
            Bundle bundle = new Bundle();
            bundle.putString(CreateDeckBottomSheetFragment.ARG_USER_JSON, json);
            bundle.putString(CreateDeckBottomSheetFragment.ARG_DECK_JSON, json2);
            createDeckBottomSheetFragment.setArguments(bundle);
            return createDeckBottomSheetFragment;
        }

        public final CreateDeckBottomSheetFragment newInstanceForGuest(CreateDeckCallback callback, ActivityResultLauncher<Intent> cardSearchLauncher, ActivityResultLauncher<Intent> pickCardLauncher, MTUser user, int formatId) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(cardSearchLauncher, "cardSearchLauncher");
            Intrinsics.checkNotNullParameter(pickCardLauncher, "pickCardLauncher");
            Intrinsics.checkNotNullParameter(user, "user");
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment = new CreateDeckBottomSheetFragment();
            createDeckBottomSheetFragment.callback = callback;
            createDeckBottomSheetFragment.cardSearchLauncher = cardSearchLauncher;
            createDeckBottomSheetFragment.pickCardLauncher = pickCardLauncher;
            String json = new Gson().toJson(user);
            Bundle bundle = new Bundle();
            bundle.putString(CreateDeckBottomSheetFragment.ARG_USER_JSON, json);
            bundle.putInt(CreateDeckBottomSheetFragment.ARG_DECK_FORMAT_FOR_GUEST, formatId);
            createDeckBottomSheetFragment.setArguments(bundle);
            return createDeckBottomSheetFragment;
        }

        public final CreateDeckBottomSheetFragment newInstanceForMTUser(CreateDeckCallback callback, ActivityResultLauncher<Intent> cardSearchLauncher, ActivityResultLauncher<Intent> pickCardLauncher, MTUser currentUser, int forUserId, int formatId) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(cardSearchLauncher, "cardSearchLauncher");
            Intrinsics.checkNotNullParameter(pickCardLauncher, "pickCardLauncher");
            Intrinsics.checkNotNullParameter(currentUser, "currentUser");
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment = new CreateDeckBottomSheetFragment();
            createDeckBottomSheetFragment.callback = callback;
            createDeckBottomSheetFragment.cardSearchLauncher = cardSearchLauncher;
            createDeckBottomSheetFragment.pickCardLauncher = pickCardLauncher;
            String json = new Gson().toJson(currentUser);
            Bundle bundle = new Bundle();
            bundle.putString(CreateDeckBottomSheetFragment.ARG_USER_JSON, json);
            bundle.putInt(CreateDeckBottomSheetFragment.ARG_DECK_FORMAT_FOR_MTUSER, formatId);
            bundle.putInt(CreateDeckBottomSheetFragment.ARG_DECK_MTUSER_ID, forUserId);
            createDeckBottomSheetFragment.setArguments(bundle);
            return createDeckBottomSheetFragment;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$performCommanderSearch$3, reason: invalid class name */
    /* JADX INFO: compiled from: CreateDeckBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$performCommanderSearch$3", f = "CreateDeckBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(String str, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        static final void invokeSuspend$lambda$1(final CreateDeckBottomSheetFragment createDeckBottomSheetFragment, final List list) {
            if (createDeckBottomSheetFragment.getContext() == null) {
                return;
            }
            createDeckBottomSheetFragment.currentLocalCommanderCards = list;
            View view = createDeckBottomSheetFragment.getView();
            final EditText editText = view != null ? (EditText) view.findViewById(R.id.commanderEditText) : null;
            if (editText != null) {
                PopupWindow commanderPopupWindow = createDeckBottomSheetFragment.getCommanderPopupWindow();
                if (commanderPopupWindow != null) {
                    commanderPopupWindow.dismiss();
                    createDeckBottomSheetFragment.setCommanderPopupWindow(null);
                }
                Object systemService = createDeckBottomSheetFragment.requireContext().getSystemService("layout_inflater");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.popup_suggestions, (ViewGroup) null);
                createDeckBottomSheetFragment.setCommanderPopupWindow(new PopupWindow(viewInflate, -2, -2, true));
                ListView listView = (ListView) viewInflate.findViewById(R.id.suggestions_list);
                List list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((MTGCardRecord) it.next()).getTitle());
                }
                final ArrayList arrayList2 = arrayList;
                listView.setAdapter((ListAdapter) new ArrayAdapter(createDeckBottomSheetFragment.requireContext(), android.R.layout.simple_list_item_1, arrayList2));
                final EditText editText2 = editText;
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$performCommanderSearch$3$$ExternalSyntheticLambda0
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                        CreateDeckBottomSheetFragment.AnonymousClass3.invokeSuspend$lambda$1$0$2(createDeckBottomSheetFragment, arrayList2, editText, list, editText2, adapterView, view2, i, j);
                    }
                });
                PopupWindow commanderPopupWindow2 = createDeckBottomSheetFragment.getCommanderPopupWindow();
                if (commanderPopupWindow2 != null) {
                    commanderPopupWindow2.setOutsideTouchable(true);
                }
                PopupWindow commanderPopupWindow3 = createDeckBottomSheetFragment.getCommanderPopupWindow();
                if (commanderPopupWindow3 != null) {
                    commanderPopupWindow3.setFocusable(false);
                }
                PopupWindow commanderPopupWindow4 = createDeckBottomSheetFragment.getCommanderPopupWindow();
                if (commanderPopupWindow4 != null) {
                    int[] iArr = new int[2];
                    editText.getLocationOnScreen(iArr);
                    View contentView = commanderPopupWindow4.getContentView();
                    contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    Size size = new Size(contentView.getMeasuredWidth(), contentView.getMeasuredHeight() * arrayList2.size());
                    int height = iArr[1] - editText.getHeight();
                    if (size.getHeight() > height) {
                        commanderPopupWindow4.setHeight(height);
                        size = new Size(commanderPopupWindow4.getContentView().getMeasuredWidth(), height);
                    }
                    if (size.getHeight() > 0) {
                        commanderPopupWindow4.setHeight(size.getHeight());
                    }
                    commanderPopupWindow4.showAtLocation(editText, 8388659, iArr[0], iArr[1] - size.getHeight());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1$0$2(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, List list, EditText editText, List list2, EditText editText2, AdapterView adapterView, View view, int i, long j) {
            if (createDeckBottomSheetFragment.getContext() == null) {
                return;
            }
            String str = (String) list.get(i);
            createDeckBottomSheetFragment.lastCommanderQuery = str;
            editText.setText(str);
            MTGCardRecord mTGCardRecord = (MTGCardRecord) list2.get(i);
            createDeckBottomSheetFragment.setCommanderLang(mTGCardRecord.getLang());
            String scryfallId = mTGCardRecord.getScryfallId();
            if (scryfallId.length() <= 0) {
                scryfallId = null;
            }
            if (scryfallId == null) {
                GameUtils companion = GameUtils.INSTANCE.getInstance();
                Context contextRequireContext = createDeckBottomSheetFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                scryfallId = companion.getFirstPrintScryfallId(contextRequireContext, mTGCardRecord);
            }
            if (scryfallId != null) {
                mTGCardRecord.setScryfallId(scryfallId);
                createDeckBottomSheetFragment.setCommander(scryfallId);
                createDeckBottomSheetFragment.applyMTCardId(mTGCardRecord, "commander");
                editText2.setBackground(ContextCompat.getDrawable(createDeckBottomSheetFragment.requireContext(), R.drawable.black_box_valid));
                editText2.clearFocus();
                createDeckBottomSheetFragment.updatePlaymatPreview();
                createDeckBottomSheetFragment.updateSubmitButtonState();
                View view2 = createDeckBottomSheetFragment.getView();
                TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.commanderTapToChange) : null;
                if (textView != null) {
                    textView.setVisibility(0);
                }
            }
            createDeckBottomSheetFragment.acceptCommanderCard(mTGCardRecord);
            Object systemService = createDeckBottomSheetFragment.requireActivity().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(editText2.getWindowToken(), 0);
            PopupWindow commanderPopupWindow = createDeckBottomSheetFragment.getCommanderPopupWindow();
            if (commanderPopupWindow != null) {
                commanderPopupWindow.dismiss();
            }
        }

        static final void invokeSuspend$lambda$2(CreateDeckBottomSheetFragment createDeckBottomSheetFragment) {
            if (createDeckBottomSheetFragment.getContext() == null) {
                return;
            }
            Log.d(CreateDeckBottomSheetFragment.TAG, "****** NO LOCAL RESULTS *******");
            createDeckBottomSheetFragment.currentLocalCommanderCards = new ArrayList();
            View view = createDeckBottomSheetFragment.getView();
            EditText editText = view != null ? (EditText) view.findViewById(R.id.commanderEditText) : null;
            if (editText != null) {
                editText.setBackground(ContextCompat.getDrawable(createDeckBottomSheetFragment.requireContext(), R.drawable.black_box_not_ok));
                PopupWindow commanderPopupWindow = createDeckBottomSheetFragment.getCommanderPopupWindow();
                if (commanderPopupWindow != null) {
                    commanderPopupWindow.dismiss();
                    createDeckBottomSheetFragment.setCommanderPopupWindow(null);
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CreateDeckBottomSheetFragment.this.new AnonymousClass3(this.$query, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int iD;
            MTGDBHelperLocalized localizedHelper;
            Object next;
            MTGDBHelperLocalized localizedHelper2;
            Object next2;
            MTGDBHelperLocalized localizedHelper3;
            Object next3;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Log.d(CreateDeckBottomSheetFragment.TAG, "------ Resetting");
            CreateDeckBottomSheetFragment.this.currentOnlineCommanderCards = new ArrayList();
            CreateDeckBottomSheetFragment.this.currentLocalCommanderCards = new ArrayList();
            final ArrayList arrayList = new ArrayList();
            Log.d(CreateDeckBottomSheetFragment.TAG, "Searching commander : " + this.$query);
            MTGDBHelper dbHelper = CreateDeckBottomSheetFragment.this.getDbHelper();
            if (dbHelper != null) {
                CreateDeckBottomSheetFragment createDeckBottomSheetFragment = CreateDeckBottomSheetFragment.this;
                String str = this.$query;
                MTFormat format = createDeckBottomSheetFragment.getFormat();
                if (Intrinsics.areEqual(format != null ? format.getScryfallid() : null, "oathbreaker")) {
                    arrayList.addAll(dbHelper.searchForPlaneswalker(str));
                    Context contextRequireContext = createDeckBottomSheetFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext).getDeviceLanguage(), "fr") && (localizedHelper3 = createDeckBottomSheetFragment.getLocalizedHelper()) != null) {
                        for (MTGCardRecord mTGCardRecord : localizedHelper3.searchForPlaneswalker(str)) {
                            Iterator it = arrayList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    next3 = null;
                                    break;
                                }
                                next3 = it.next();
                                if (Intrinsics.areEqual(((MTGCardRecord) next3).getTitle(), mTGCardRecord.getTitle())) {
                                    break;
                                }
                            }
                            if (next3 == null) {
                                arrayList.add(mTGCardRecord);
                            }
                        }
                    }
                    MTCardSearchViewModel mTCardSearchViewModel = createDeckBottomSheetFragment.searchViewModel;
                    if (mTCardSearchViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchViewModel");
                        mTCardSearchViewModel = null;
                    }
                    MTCardSearchType mTCardSearchType = MTCardSearchType.COMMANDER;
                    MTFormat format2 = createDeckBottomSheetFragment.getFormat();
                    mTCardSearchViewModel.performSearch(str, mTCardSearchType, format2 != null ? Boxing.boxInt(format2.getId()) : null);
                    iD = Log.d(CreateDeckBottomSheetFragment.TAG, "Searching online for commander: " + str);
                } else {
                    MTFormat format3 = createDeckBottomSheetFragment.getFormat();
                    if (Intrinsics.areEqual(format3 != null ? format3.getScryfallid() : null, "paupercommander")) {
                        arrayList.addAll(dbHelper.searchForUncommonCreature(str));
                        Context contextRequireContext2 = createDeckBottomSheetFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext2).getDeviceLanguage(), "fr") && (localizedHelper2 = createDeckBottomSheetFragment.getLocalizedHelper()) != null) {
                            for (MTGCardRecord mTGCardRecord2 : localizedHelper2.searchForUncommonCreature(str)) {
                                Iterator it2 = arrayList.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        next2 = null;
                                        break;
                                    }
                                    next2 = it2.next();
                                    if (Intrinsics.areEqual(((MTGCardRecord) next2).getTitle(), mTGCardRecord2.getTitle())) {
                                        break;
                                    }
                                }
                                if (next2 == null) {
                                    arrayList.add(mTGCardRecord2);
                                }
                            }
                        }
                        MTCardSearchViewModel mTCardSearchViewModel2 = createDeckBottomSheetFragment.searchViewModel;
                        if (mTCardSearchViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("searchViewModel");
                            mTCardSearchViewModel2 = null;
                        }
                        MTCardSearchType mTCardSearchType2 = MTCardSearchType.COMMANDER;
                        MTFormat format4 = createDeckBottomSheetFragment.getFormat();
                        mTCardSearchViewModel2.performSearch(str, mTCardSearchType2, format4 != null ? Boxing.boxInt(format4.getId()) : null);
                        iD = Log.d(CreateDeckBottomSheetFragment.TAG, "Searching online for commander: " + str);
                    } else {
                        arrayList.addAll(dbHelper.searchForLegendaryCreatureOrPlaneswalker(str));
                        arrayList.addAll(dbHelper.searchForCanBeYourCommander(str));
                        Context contextRequireContext3 = createDeckBottomSheetFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                        if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext3).getDeviceLanguage(), "fr") && (localizedHelper = createDeckBottomSheetFragment.getLocalizedHelper()) != null) {
                            for (MTGCardRecord mTGCardRecord3 : localizedHelper.searchForLegendaryCreatureOrPlaneswalker(str)) {
                                Iterator it3 = arrayList.iterator();
                                while (true) {
                                    if (!it3.hasNext()) {
                                        next = null;
                                        break;
                                    }
                                    next = it3.next();
                                    if (Intrinsics.areEqual(((MTGCardRecord) next).getTitle(), mTGCardRecord3.getTitle())) {
                                        break;
                                    }
                                }
                                if (next == null) {
                                    arrayList.add(mTGCardRecord3);
                                }
                            }
                        }
                        MTCardSearchViewModel mTCardSearchViewModel3 = createDeckBottomSheetFragment.searchViewModel;
                        if (mTCardSearchViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("searchViewModel");
                            mTCardSearchViewModel3 = null;
                        }
                        MTCardSearchType mTCardSearchType3 = MTCardSearchType.COMMANDER;
                        MTFormat format5 = createDeckBottomSheetFragment.getFormat();
                        mTCardSearchViewModel3.performSearch(str, mTCardSearchType3, format5 != null ? Boxing.boxInt(format5.getId()) : null);
                        iD = Log.d(CreateDeckBottomSheetFragment.TAG, "Searching online for commander: " + str);
                    }
                }
                Boxing.boxInt(iD);
            }
            boolean zIsEmpty = arrayList.isEmpty();
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment2 = CreateDeckBottomSheetFragment.this;
            if (zIsEmpty) {
                FragmentActivity activity = createDeckBottomSheetFragment2.getActivity();
                if (activity != null) {
                    final CreateDeckBottomSheetFragment createDeckBottomSheetFragment3 = CreateDeckBottomSheetFragment.this;
                    activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$performCommanderSearch$3$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            CreateDeckBottomSheetFragment.AnonymousClass3.invokeSuspend$lambda$2(createDeckBottomSheetFragment3);
                        }
                    });
                }
            } else {
                FragmentActivity activity2 = createDeckBottomSheetFragment2.getActivity();
                if (activity2 != null) {
                    final CreateDeckBottomSheetFragment createDeckBottomSheetFragment4 = CreateDeckBottomSheetFragment.this;
                    activity2.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$performCommanderSearch$3$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            CreateDeckBottomSheetFragment.AnonymousClass3.invokeSuspend$lambda$1(createDeckBottomSheetFragment4, arrayList);
                        }
                    });
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$performPartnerSearch$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CreateDeckBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$performPartnerSearch$3", f = "CreateDeckBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11423 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11423(String str, Continuation<? super C11423> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        static final void invokeSuspend$lambda$7(final CreateDeckBottomSheetFragment createDeckBottomSheetFragment, final List list) {
            if (createDeckBottomSheetFragment.getContext() == null) {
                return;
            }
            createDeckBottomSheetFragment.currentLocalPartnerCards = list;
            View view = createDeckBottomSheetFragment.getView();
            final EditText editText = view != null ? (EditText) view.findViewById(R.id.partnerEditText) : null;
            if (editText != null) {
                PopupWindow partnerPopupWindow = createDeckBottomSheetFragment.getPartnerPopupWindow();
                if (partnerPopupWindow != null) {
                    partnerPopupWindow.dismiss();
                    createDeckBottomSheetFragment.setPartnerPopupWindow(null);
                }
                Object systemService = createDeckBottomSheetFragment.requireContext().getSystemService("layout_inflater");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.popup_suggestions, (ViewGroup) null);
                createDeckBottomSheetFragment.setPartnerPopupWindow(new PopupWindow(viewInflate, -2, -2, true));
                ListView listView = (ListView) viewInflate.findViewById(R.id.suggestions_list);
                List list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((MTGCardRecord) it.next()).getTitle());
                }
                final ArrayList arrayList2 = arrayList;
                listView.setAdapter((ListAdapter) new ArrayAdapter(createDeckBottomSheetFragment.requireContext(), android.R.layout.simple_list_item_1, arrayList2));
                final EditText editText2 = editText;
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$performPartnerSearch$3$$ExternalSyntheticLambda0
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                        CreateDeckBottomSheetFragment.C11423.invokeSuspend$lambda$7$0$2(arrayList2, createDeckBottomSheetFragment, editText, list, editText2, adapterView, view2, i, j);
                    }
                });
                PopupWindow partnerPopupWindow2 = createDeckBottomSheetFragment.getPartnerPopupWindow();
                if (partnerPopupWindow2 != null) {
                    partnerPopupWindow2.setOutsideTouchable(true);
                }
                PopupWindow partnerPopupWindow3 = createDeckBottomSheetFragment.getPartnerPopupWindow();
                if (partnerPopupWindow3 != null) {
                    partnerPopupWindow3.setFocusable(false);
                }
                PopupWindow partnerPopupWindow4 = createDeckBottomSheetFragment.getPartnerPopupWindow();
                if (partnerPopupWindow4 != null) {
                    int[] iArr = new int[2];
                    editText.getLocationOnScreen(iArr);
                    View contentView = partnerPopupWindow4.getContentView();
                    contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    Size size = new Size(contentView.getMeasuredWidth(), contentView.getMeasuredHeight() * arrayList2.size());
                    int height = iArr[1] - editText.getHeight();
                    if (size.getHeight() > height) {
                        partnerPopupWindow4.setHeight(height);
                        size = new Size(partnerPopupWindow4.getContentView().getMeasuredWidth(), height);
                    }
                    if (size.getHeight() > 0) {
                        partnerPopupWindow4.setHeight(size.getHeight());
                    }
                    partnerPopupWindow4.showAtLocation(editText, 8388659, iArr[0], iArr[1] - size.getHeight());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$7$0$2(List list, CreateDeckBottomSheetFragment createDeckBottomSheetFragment, EditText editText, List list2, EditText editText2, AdapterView adapterView, View view, int i, long j) {
            String str = (String) list.get(i);
            createDeckBottomSheetFragment.lastPartnerQuery = str;
            editText.setText(str);
            MTGCardRecord mTGCardRecord = (MTGCardRecord) list2.get(i);
            createDeckBottomSheetFragment.setPartnerLang(mTGCardRecord.getLang());
            String scryfallId = mTGCardRecord.getScryfallId();
            if (scryfallId.length() <= 0) {
                scryfallId = null;
            }
            if (scryfallId == null) {
                GameUtils companion = GameUtils.INSTANCE.getInstance();
                Context contextRequireContext = createDeckBottomSheetFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                scryfallId = companion.getFirstPrintScryfallId(contextRequireContext, mTGCardRecord);
            }
            if (scryfallId != null) {
                createDeckBottomSheetFragment.setPartner(scryfallId);
                mTGCardRecord.setScryfallId(scryfallId);
                createDeckBottomSheetFragment.applyMTCardId(mTGCardRecord, "partner");
                editText2.setBackground(createDeckBottomSheetFragment.requireContext().getResources().getDrawable(R.drawable.black_box_valid, null));
                editText2.clearFocus();
                createDeckBottomSheetFragment.updateColorIdentity("partner", scryfallId, 0, true);
                createDeckBottomSheetFragment.updatePlaymatPreview();
                View view2 = createDeckBottomSheetFragment.getView();
                TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.partnerTapToChange) : null;
                if (textView != null) {
                    textView.setVisibility(0);
                }
            }
            Object systemService = createDeckBottomSheetFragment.requireActivity().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(editText2.getWindowToken(), 0);
            PopupWindow partnerPopupWindow = createDeckBottomSheetFragment.getPartnerPopupWindow();
            if (partnerPopupWindow != null) {
                partnerPopupWindow.dismiss();
            }
        }

        static final void invokeSuspend$lambda$8(CreateDeckBottomSheetFragment createDeckBottomSheetFragment) {
            if (createDeckBottomSheetFragment.getContext() == null) {
                return;
            }
            createDeckBottomSheetFragment.currentLocalPartnerCards = new ArrayList();
            View view = createDeckBottomSheetFragment.getView();
            EditText editText = view != null ? (EditText) view.findViewById(R.id.partnerEditText) : null;
            if (editText != null) {
                editText.setBackground(ContextCompat.getDrawable(createDeckBottomSheetFragment.requireContext(), R.drawable.black_box_not_ok));
                PopupWindow partnerPopupWindow = createDeckBottomSheetFragment.getPartnerPopupWindow();
                if (partnerPopupWindow != null) {
                    partnerPopupWindow.dismiss();
                    createDeckBottomSheetFragment.setPartnerPopupWindow(null);
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CreateDeckBottomSheetFragment.this.new C11423(this.$query, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11423) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MTGDBHelper dbHelper;
            MTGDBHelperLocalized localizedHelper;
            Object next;
            MTGDBHelper dbHelper2;
            MTGDBHelperLocalized localizedHelper2;
            Object next2;
            MTGDBHelper dbHelper3;
            MTGDBHelperLocalized localizedHelper3;
            Object next3;
            MTGDBHelper dbHelper4;
            MTGDBHelper dbHelper5;
            MTGDBHelperLocalized localizedHelper4;
            Object next4;
            MTGDBHelperLocalized localizedHelper5;
            Object next5;
            MTGDBHelperLocalized localizedHelper6;
            Object next6;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CreateDeckBottomSheetFragment.this.currentLocalPartnerCards = new ArrayList();
            CreateDeckBottomSheetFragment.this.currentOnlinePartnerCards = new ArrayList();
            final ArrayList arrayList = new ArrayList();
            if (CreateDeckBottomSheetFragment.this.getIsPartner()) {
                MTFormat format = CreateDeckBottomSheetFragment.this.getFormat();
                boolean zAreEqual = Intrinsics.areEqual(format != null ? format.getScryfallid() : null, "paupercommander");
                CreateDeckBottomSheetFragment createDeckBottomSheetFragment = CreateDeckBottomSheetFragment.this;
                if (zAreEqual) {
                    MTGDBHelper dbHelper6 = createDeckBottomSheetFragment.getDbHelper();
                    if (dbHelper6 != null) {
                        String str = this.$query;
                        CreateDeckBottomSheetFragment createDeckBottomSheetFragment2 = CreateDeckBottomSheetFragment.this;
                        arrayList.addAll(dbHelper6.searchForUncommonCreature(str));
                        Context contextRequireContext = createDeckBottomSheetFragment2.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                        if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext).getDeviceLanguage(), "fr") && (localizedHelper6 = createDeckBottomSheetFragment2.getLocalizedHelper()) != null) {
                            for (MTGCardRecord mTGCardRecord : localizedHelper6.searchForUncommonCreature(str)) {
                                Iterator it = arrayList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        next6 = null;
                                        break;
                                    }
                                    next6 = it.next();
                                    if (Intrinsics.areEqual(((MTGCardRecord) next6).getTitle(), mTGCardRecord.getTitle())) {
                                        break;
                                    }
                                }
                                if (next6 == null) {
                                    arrayList.add(mTGCardRecord);
                                }
                            }
                        }
                        MTCardSearchViewModel mTCardSearchViewModel = createDeckBottomSheetFragment2.partnerSearchViewModel;
                        if (mTCardSearchViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("partnerSearchViewModel");
                            mTCardSearchViewModel = null;
                        }
                        MTCardSearchType mTCardSearchType = MTCardSearchType.PARTNER;
                        MTFormat format2 = createDeckBottomSheetFragment2.getFormat();
                        mTCardSearchViewModel.performSearch(str, mTCardSearchType, format2 != null ? Boxing.boxInt(format2.getId()) : null);
                        Boxing.boxInt(Log.d(CreateDeckBottomSheetFragment.TAG, "Searching online for partner: " + str));
                    }
                } else {
                    MTGDBHelper dbHelper7 = createDeckBottomSheetFragment.getDbHelper();
                    if (dbHelper7 != null) {
                        String str2 = this.$query;
                        CreateDeckBottomSheetFragment createDeckBottomSheetFragment3 = CreateDeckBottomSheetFragment.this;
                        arrayList.addAll(dbHelper7.searchForLegendaryCreatureOrPlaneswalker(str2));
                        Context contextRequireContext2 = createDeckBottomSheetFragment3.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext2).getDeviceLanguage(), "fr") && (localizedHelper5 = createDeckBottomSheetFragment3.getLocalizedHelper()) != null) {
                            for (MTGCardRecord mTGCardRecord2 : localizedHelper5.searchForLegendaryCreatureOrPlaneswalker(str2)) {
                                Iterator it2 = arrayList.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        next5 = null;
                                        break;
                                    }
                                    next5 = it2.next();
                                    if (Intrinsics.areEqual(((MTGCardRecord) next5).getTitle(), mTGCardRecord2.getTitle())) {
                                        break;
                                    }
                                }
                                if (next5 == null) {
                                    arrayList.add(mTGCardRecord2);
                                }
                            }
                        }
                        MTCardSearchViewModel mTCardSearchViewModel2 = createDeckBottomSheetFragment3.partnerSearchViewModel;
                        if (mTCardSearchViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("partnerSearchViewModel");
                            mTCardSearchViewModel2 = null;
                        }
                        MTCardSearchType mTCardSearchType2 = MTCardSearchType.PARTNER;
                        MTFormat format3 = createDeckBottomSheetFragment3.getFormat();
                        mTCardSearchViewModel2.performSearch(str2, mTCardSearchType2, format3 != null ? Boxing.boxInt(format3.getId()) : null);
                        Boxing.boxInt(Log.d(CreateDeckBottomSheetFragment.TAG, "Searching online for partner: " + str2));
                    }
                }
            }
            if (CreateDeckBottomSheetFragment.this.getIsBackground() && (dbHelper5 = CreateDeckBottomSheetFragment.this.getDbHelper()) != null) {
                String str3 = this.$query;
                CreateDeckBottomSheetFragment createDeckBottomSheetFragment4 = CreateDeckBottomSheetFragment.this;
                arrayList.addAll(dbHelper5.searchForBackground(str3));
                Context contextRequireContext3 = createDeckBottomSheetFragment4.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext3).getDeviceLanguage(), "fr") && (localizedHelper4 = createDeckBottomSheetFragment4.getLocalizedHelper()) != null) {
                    for (MTGCardRecord mTGCardRecord3 : localizedHelper4.searchForBackground(str3)) {
                        Iterator it3 = arrayList.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                next4 = null;
                                break;
                            }
                            next4 = it3.next();
                            if (Intrinsics.areEqual(((MTGCardRecord) next4).getTitle(), mTGCardRecord3.getTitle())) {
                                break;
                            }
                        }
                        if (next4 == null) {
                            arrayList.add(mTGCardRecord3);
                        }
                    }
                }
                MTCardSearchViewModel mTCardSearchViewModel3 = createDeckBottomSheetFragment4.partnerSearchViewModel;
                if (mTCardSearchViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partnerSearchViewModel");
                    mTCardSearchViewModel3 = null;
                }
                MTCardSearchType mTCardSearchType3 = MTCardSearchType.PARTNER;
                MTFormat format4 = createDeckBottomSheetFragment4.getFormat();
                mTCardSearchViewModel3.performSearch(str3, mTCardSearchType3, format4 != null ? Boxing.boxInt(format4.getId()) : null);
                Boxing.boxInt(Log.d(CreateDeckBottomSheetFragment.TAG, "Searching online for partner/background: " + str3));
            }
            if (CreateDeckBottomSheetFragment.this.getIsFriendsForever() && (dbHelper4 = CreateDeckBottomSheetFragment.this.getDbHelper()) != null) {
                Boxing.boxBoolean(arrayList.addAll(dbHelper4.searchForFriendsForever(this.$query)));
            }
            if (CreateDeckBottomSheetFragment.this.getIsDoctor() && (dbHelper3 = CreateDeckBottomSheetFragment.this.getDbHelper()) != null) {
                String str4 = this.$query;
                CreateDeckBottomSheetFragment createDeckBottomSheetFragment5 = CreateDeckBottomSheetFragment.this;
                arrayList.addAll(dbHelper3.searchForDoctorCompanion(str4));
                Context contextRequireContext4 = createDeckBottomSheetFragment5.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext4).getDeviceLanguage(), "fr") && (localizedHelper3 = createDeckBottomSheetFragment5.getLocalizedHelper()) != null) {
                    for (MTGCardRecord mTGCardRecord4 : localizedHelper3.searchForDoctorCompanion(str4)) {
                        Iterator it4 = arrayList.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                next3 = null;
                                break;
                            }
                            next3 = it4.next();
                            if (Intrinsics.areEqual(((MTGCardRecord) next3).getTitle(), mTGCardRecord4.getTitle())) {
                                break;
                            }
                        }
                        if (next3 == null) {
                            arrayList.add(mTGCardRecord4);
                        }
                    }
                }
            }
            if (CreateDeckBottomSheetFragment.this.getIsDoctorCompanion() && (dbHelper2 = CreateDeckBottomSheetFragment.this.getDbHelper()) != null) {
                String str5 = this.$query;
                CreateDeckBottomSheetFragment createDeckBottomSheetFragment6 = CreateDeckBottomSheetFragment.this;
                arrayList.addAll(dbHelper2.searchForDoctor(str5));
                Context contextRequireContext5 = createDeckBottomSheetFragment6.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
                if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext5).getDeviceLanguage(), "fr") && (localizedHelper2 = createDeckBottomSheetFragment6.getLocalizedHelper()) != null) {
                    for (MTGCardRecord mTGCardRecord5 : localizedHelper2.searchForDoctor(str5)) {
                        Iterator it5 = arrayList.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it5.next();
                            if (Intrinsics.areEqual(((MTGCardRecord) next2).getTitle(), mTGCardRecord5.getTitle())) {
                                break;
                            }
                        }
                        if (next2 == null) {
                            arrayList.add(mTGCardRecord5);
                        }
                    }
                }
            }
            if (CreateDeckBottomSheetFragment.this.getIsSignatureSpell() && (dbHelper = CreateDeckBottomSheetFragment.this.getDbHelper()) != null) {
                String str6 = this.$query;
                CreateDeckBottomSheetFragment createDeckBottomSheetFragment7 = CreateDeckBottomSheetFragment.this;
                arrayList.addAll(dbHelper.searchForInstantOrSorcery(str6));
                Context contextRequireContext6 = createDeckBottomSheetFragment7.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext6, "requireContext(...)");
                if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext6).getDeviceLanguage(), "fr") && (localizedHelper = createDeckBottomSheetFragment7.getLocalizedHelper()) != null) {
                    for (MTGCardRecord mTGCardRecord6 : localizedHelper.searchForInstantOrSorcery(str6)) {
                        Iterator it6 = arrayList.iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it6.next();
                            if (Intrinsics.areEqual(((MTGCardRecord) next).getTitle(), mTGCardRecord6.getTitle())) {
                                break;
                            }
                        }
                        if (next == null) {
                            arrayList.add(mTGCardRecord6);
                        }
                    }
                }
                MTCardSearchViewModel mTCardSearchViewModel4 = createDeckBottomSheetFragment7.partnerSearchViewModel;
                if (mTCardSearchViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partnerSearchViewModel");
                    mTCardSearchViewModel4 = null;
                }
                MTCardSearchType mTCardSearchType4 = MTCardSearchType.SIGNATURE_SPELL;
                MTFormat format5 = createDeckBottomSheetFragment7.getFormat();
                mTCardSearchViewModel4.performSearch(str6, mTCardSearchType4, format5 != null ? Boxing.boxInt(format5.getId()) : null);
                Boxing.boxInt(Log.d(CreateDeckBottomSheetFragment.TAG, "Searching online for signature spell: " + str6));
            }
            boolean zIsEmpty = arrayList.isEmpty();
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment8 = CreateDeckBottomSheetFragment.this;
            if (zIsEmpty) {
                FragmentActivity activity = createDeckBottomSheetFragment8.getActivity();
                if (activity != null) {
                    final CreateDeckBottomSheetFragment createDeckBottomSheetFragment9 = CreateDeckBottomSheetFragment.this;
                    activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$performPartnerSearch$3$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            CreateDeckBottomSheetFragment.C11423.invokeSuspend$lambda$8(createDeckBottomSheetFragment9);
                        }
                    });
                }
            } else {
                FragmentActivity activity2 = createDeckBottomSheetFragment8.getActivity();
                if (activity2 != null) {
                    final CreateDeckBottomSheetFragment createDeckBottomSheetFragment10 = CreateDeckBottomSheetFragment.this;
                    activity2.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$performPartnerSearch$3$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            CreateDeckBottomSheetFragment.C11423.invokeSuspend$lambda$7(createDeckBottomSheetFragment10, arrayList);
                        }
                    });
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$performPlaymatCardSearch$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CreateDeckBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$performPlaymatCardSearch$3", f = "CreateDeckBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11433 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11433(String str, Continuation<? super C11433> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        static final void invokeSuspend$lambda$2(final CreateDeckBottomSheetFragment createDeckBottomSheetFragment, final List list) {
            if (createDeckBottomSheetFragment.getContext() == null) {
                return;
            }
            createDeckBottomSheetFragment.currentLocalPlaymatCards = list;
            View view = createDeckBottomSheetFragment.getView();
            final EditText editText = view != null ? (EditText) view.findViewById(R.id.playmatCardEditText) : null;
            if (editText != null) {
                PopupWindow playmatCardPopupWindow = createDeckBottomSheetFragment.getPlaymatCardPopupWindow();
                if (playmatCardPopupWindow != null) {
                    playmatCardPopupWindow.dismiss();
                    createDeckBottomSheetFragment.setPlaymatCardPopupWindow(null);
                }
                Object systemService = createDeckBottomSheetFragment.requireContext().getSystemService("layout_inflater");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.popup_suggestions, (ViewGroup) null);
                createDeckBottomSheetFragment.setPlaymatCardPopupWindow(new PopupWindow(viewInflate, -2, -2, true));
                ListView listView = (ListView) viewInflate.findViewById(R.id.suggestions_list);
                List list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((MTGCardRecord) it.next()).getTitle());
                }
                final ArrayList arrayList2 = arrayList;
                listView.setAdapter((ListAdapter) new ArrayAdapter(createDeckBottomSheetFragment.requireContext(), android.R.layout.simple_list_item_1, arrayList2));
                final EditText editText2 = editText;
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$performPlaymatCardSearch$3$$ExternalSyntheticLambda2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                        CreateDeckBottomSheetFragment.C11433.invokeSuspend$lambda$2$0$2(arrayList2, createDeckBottomSheetFragment, editText, list, editText2, adapterView, view2, i, j);
                    }
                });
                PopupWindow playmatCardPopupWindow2 = createDeckBottomSheetFragment.getPlaymatCardPopupWindow();
                if (playmatCardPopupWindow2 != null) {
                    playmatCardPopupWindow2.setOutsideTouchable(true);
                }
                PopupWindow playmatCardPopupWindow3 = createDeckBottomSheetFragment.getPlaymatCardPopupWindow();
                if (playmatCardPopupWindow3 != null) {
                    playmatCardPopupWindow3.setFocusable(false);
                }
                PopupWindow playmatCardPopupWindow4 = createDeckBottomSheetFragment.getPlaymatCardPopupWindow();
                if (playmatCardPopupWindow4 != null) {
                    int[] iArr = new int[2];
                    editText.getLocationOnScreen(iArr);
                    View contentView = playmatCardPopupWindow4.getContentView();
                    contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    Size size = new Size(contentView.getMeasuredWidth(), contentView.getMeasuredHeight() * arrayList2.size());
                    int height = iArr[1] - editText.getHeight();
                    if (size.getHeight() > height) {
                        playmatCardPopupWindow4.setHeight(height);
                        size = new Size(playmatCardPopupWindow4.getContentView().getMeasuredWidth(), height);
                    }
                    if (size.getHeight() > 0) {
                        playmatCardPopupWindow4.setHeight(size.getHeight());
                    }
                    playmatCardPopupWindow4.showAtLocation(editText, 8388659, iArr[0], iArr[1] - size.getHeight());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$2$0$2(List list, CreateDeckBottomSheetFragment createDeckBottomSheetFragment, EditText editText, List list2, EditText editText2, AdapterView adapterView, View view, int i, long j) {
            String str = (String) list.get(i);
            createDeckBottomSheetFragment.lastPlaymatCardQuery = str;
            editText.setText(str);
            MTGCardRecord mTGCardRecord = (MTGCardRecord) list2.get(i);
            createDeckBottomSheetFragment.setPlaymatLang(mTGCardRecord.getLang());
            String scryfallId = mTGCardRecord.getScryfallId();
            if (scryfallId.length() <= 0) {
                scryfallId = null;
            }
            if (scryfallId == null) {
                GameUtils companion = GameUtils.INSTANCE.getInstance();
                Context contextRequireContext = createDeckBottomSheetFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                scryfallId = companion.getFirstPrintScryfallId(contextRequireContext, mTGCardRecord);
            }
            if (scryfallId != null) {
                editText2.clearFocus();
                mTGCardRecord.setScryfallId(scryfallId);
                createDeckBottomSheetFragment.applyMTCardId(mTGCardRecord, "rightplaymat");
                createDeckBottomSheetFragment.updatePlaymatPreview();
                createDeckBottomSheetFragment.updateSubmitButtonState();
                View view2 = createDeckBottomSheetFragment.getView();
                TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.playmatCardTapToChange) : null;
                if (textView != null) {
                    textView.setVisibility(0);
                }
            }
            Object systemService = createDeckBottomSheetFragment.requireActivity().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(editText2.getWindowToken(), 0);
            PopupWindow playmatCardPopupWindow = createDeckBottomSheetFragment.getPlaymatCardPopupWindow();
            if (playmatCardPopupWindow != null) {
                playmatCardPopupWindow.dismiss();
            }
        }

        static final void invokeSuspend$lambda$3(CreateDeckBottomSheetFragment createDeckBottomSheetFragment) {
            PopupWindow playmatCardPopupWindow;
            if (createDeckBottomSheetFragment.getContext() == null) {
                return;
            }
            createDeckBottomSheetFragment.currentLocalPlaymatCards = new ArrayList();
            createDeckBottomSheetFragment.currentOnlinePlaymatCards = new ArrayList();
            View view = createDeckBottomSheetFragment.getView();
            if ((view != null ? (EditText) view.findViewById(R.id.playmatCardEditText) : null) == null || (playmatCardPopupWindow = createDeckBottomSheetFragment.getPlaymatCardPopupWindow()) == null) {
                return;
            }
            playmatCardPopupWindow.dismiss();
            createDeckBottomSheetFragment.setPlaymatCardPopupWindow(null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CreateDeckBottomSheetFragment.this.new C11433(this.$query, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11433) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MTGDBHelperLocalized localizedHelper;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            final ArrayList arrayList = new ArrayList();
            CreateDeckBottomSheetFragment.this.currentLocalPlaymatCards = new ArrayList();
            CreateDeckBottomSheetFragment.this.currentOnlinePlaymatCards = new ArrayList();
            MTGDBHelper dbHelper = CreateDeckBottomSheetFragment.this.getDbHelper();
            if (dbHelper != null) {
                Boxing.boxBoolean(arrayList.addAll(dbHelper.getCardsByTitleMatchingWordsWithWildcards(this.$query)));
            }
            Context contextRequireContext = CreateDeckBottomSheetFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext).getDeviceLanguage(), "fr") && (localizedHelper = CreateDeckBottomSheetFragment.this.getLocalizedHelper()) != null) {
                Boxing.boxBoolean(arrayList.addAll(localizedHelper.getCardsByFoldedTitleMatchingWords(this.$query)));
            }
            MTCardSearchViewModel mTCardSearchViewModel = CreateDeckBottomSheetFragment.this.playmatSearchViewModel;
            if (mTCardSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playmatSearchViewModel");
                mTCardSearchViewModel = null;
            }
            MTCardSearchViewModel.performSearch$default(mTCardSearchViewModel, this.$query, MTCardSearchType.PLAYMAT, null, 4, null);
            Log.d(CreateDeckBottomSheetFragment.TAG, "Searching online for playmat: " + this.$query);
            boolean zIsEmpty = arrayList.isEmpty();
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment = CreateDeckBottomSheetFragment.this;
            if (zIsEmpty) {
                FragmentActivity activity = createDeckBottomSheetFragment.getActivity();
                if (activity != null) {
                    final CreateDeckBottomSheetFragment createDeckBottomSheetFragment2 = CreateDeckBottomSheetFragment.this;
                    activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$performPlaymatCardSearch$3$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            CreateDeckBottomSheetFragment.C11433.invokeSuspend$lambda$3(createDeckBottomSheetFragment2);
                        }
                    });
                }
            } else {
                FragmentActivity activity2 = createDeckBottomSheetFragment.getActivity();
                if (activity2 != null) {
                    final CreateDeckBottomSheetFragment createDeckBottomSheetFragment3 = CreateDeckBottomSheetFragment.this;
                    activity2.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$performPlaymatCardSearch$3$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            CreateDeckBottomSheetFragment.C11433.invokeSuspend$lambda$2(createDeckBottomSheetFragment3, arrayList);
                        }
                    });
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void acceptCommanderCard(MTGCardRecord card) {
        boolean z;
        MTFormat mTFormat = this.format;
        boolean zAreEqual = Intrinsics.areEqual(mTFormat != null ? mTFormat.getScryfallid() : null, "oathbreaker");
        String strTranslateTag = Intrinsics.areEqual(card.getLang(), "en") ? "doctor" : SearchDataUtils.INSTANCE.getInstance().translateTag("doctor", card.getLang());
        String keywords = card.getKeywords();
        if (keywords != null) {
            String lowerCase = keywords.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "partner", false, 2, (Object) null) || zAreEqual) {
                z = false;
            } else {
                this.isPartner = true;
                this.isBackground = false;
                this.isDoctor = false;
                this.isDoctorCompanion = false;
                this.isFriendsForever = false;
                this.isSignatureSpell = false;
                View view = getView();
                LinearLayout linearLayout = view != null ? (LinearLayout) view.findViewById(R.id.partnerLayout) : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                View view2 = getView();
                EditText editText = view2 != null ? (EditText) view2.findViewById(R.id.partnerEditText) : null;
                if (editText != null) {
                    editText.setHint(getString(R.string.partner_hint));
                }
                z = true;
            }
            String lowerCase2 = keywords.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "choose a background", false, 2, (Object) null) && !zAreEqual) {
                this.isPartner = false;
                this.isBackground = true;
                this.isDoctor = false;
                this.isDoctorCompanion = false;
                this.isFriendsForever = false;
                this.isSignatureSpell = false;
                View view3 = getView();
                LinearLayout linearLayout2 = view3 != null ? (LinearLayout) view3.findViewById(R.id.partnerLayout) : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                View view4 = getView();
                EditText editText2 = view4 != null ? (EditText) view4.findViewById(R.id.partnerEditText) : null;
                if (editText2 != null) {
                    editText2.setHint(getString(R.string.background_hint));
                }
                z = true;
            }
            String lowerCase3 = keywords.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "friends forever", false, 2, (Object) null) && !zAreEqual) {
                this.isPartner = false;
                this.isBackground = false;
                this.isFriendsForever = true;
                this.isDoctor = false;
                this.isDoctorCompanion = false;
                this.isSignatureSpell = false;
                View view5 = getView();
                LinearLayout linearLayout3 = view5 != null ? (LinearLayout) view5.findViewById(R.id.partnerLayout) : null;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(0);
                }
                View view6 = getView();
                EditText editText3 = view6 != null ? (EditText) view6.findViewById(R.id.partnerEditText) : null;
                if (editText3 != null) {
                    editText3.setHint(getString(R.string.friends_forever_hint));
                }
                z = true;
            }
            String lowerCase4 = keywords.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) "doctor's companion", false, 2, (Object) null) && !zAreEqual) {
                this.isPartner = false;
                this.isBackground = false;
                this.isFriendsForever = false;
                this.isDoctor = false;
                this.isDoctorCompanion = true;
                this.isSignatureSpell = false;
                View view7 = getView();
                LinearLayout linearLayout4 = view7 != null ? (LinearLayout) view7.findViewById(R.id.partnerLayout) : null;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(0);
                }
                View view8 = getView();
                EditText editText4 = view8 != null ? (EditText) view8.findViewById(R.id.partnerEditText) : null;
                if (editText4 != null) {
                    editText4.setHint(getString(R.string.time_lord_hint));
                }
                z = true;
            }
        } else {
            z = false;
        }
        String type_line = card.getType_line();
        if (type_line != null) {
            String lowerCase5 = type_line.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) "time", false, 2, (Object) null)) {
                String lowerCase6 = type_line.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase6, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase6, (CharSequence) "lord", false, 2, (Object) null)) {
                    String lowerCase7 = type_line.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase7, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase7, (CharSequence) strTranslateTag, false, 2, (Object) null) && !zAreEqual) {
                        this.isPartner = false;
                        this.isBackground = false;
                        this.isDoctor = true;
                        this.isDoctorCompanion = false;
                        this.isFriendsForever = false;
                        this.isSignatureSpell = false;
                        View view9 = getView();
                        LinearLayout linearLayout5 = view9 != null ? (LinearLayout) view9.findViewById(R.id.partnerLayout) : null;
                        if (linearLayout5 != null) {
                            linearLayout5.setVisibility(0);
                        }
                        View view10 = getView();
                        EditText editText5 = view10 != null ? (EditText) view10.findViewById(R.id.partnerEditText) : null;
                        if (editText5 != null) {
                            editText5.setHint(getString(R.string.doctor_hint));
                        }
                        z = true;
                    }
                }
            }
        }
        if (!this.deckNameWasTyped) {
            String title = card.getTitle();
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) title, ",", 0, false, 6, (Object) null);
            if (iIndexOf$default > 0) {
                title = title.substring(0, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(title, "substring(...)");
            }
            this.deckName = title;
            View view11 = getView();
            EditText editText6 = view11 != null ? (EditText) view11.findViewById(R.id.deckName) : null;
            if (editText6 != null) {
                editText6.setText(this.deckName);
            }
            this.deckNameWasTyped = false;
        }
        if (zAreEqual) {
            this.isSignatureSpell = true;
            this.isPartner = false;
            this.isBackground = false;
            this.isFriendsForever = false;
            this.isDoctor = false;
            this.isDoctorCompanion = false;
            View view12 = getView();
            LinearLayout linearLayout6 = view12 != null ? (LinearLayout) view12.findViewById(R.id.partnerLayout) : null;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
            View view13 = getView();
            EditText editText7 = view13 != null ? (EditText) view13.findViewById(R.id.partnerEditText) : null;
            if (editText7 != null) {
                editText7.setHint(getString(R.string.signature_spell_hint));
            }
        }
        if (!z && !zAreEqual) {
            this.leftplaymat = null;
            this.partner = null;
            this.partnerCardId = null;
            this.leftplaymatCardId = null;
            this.leftplaymatFaceIndex = null;
            this.leftPlaymatPreviewUrl = null;
            this.lastPartnerQuery = "";
            View view14 = getView();
            EditText editText8 = view14 != null ? (EditText) view14.findViewById(R.id.partnerEditText) : null;
            if (editText8 != null) {
                editText8.setText("");
            }
            this.partnerIdentity = new ArrayList();
            updatePlaymatPreview();
            View view15 = getView();
            LinearLayout linearLayout7 = view15 != null ? (LinearLayout) view15.findViewById(R.id.partnerLayout) : null;
            if (linearLayout7 != null) {
                linearLayout7.setVisibility(8);
            }
            View view16 = getView();
            TextView textView = view16 != null ? (TextView) view16.findViewById(R.id.partnerTapToChange) : null;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
        updateColorIdentity("commander", card.getScryfallId(), card.getFace(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r3v13, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    public final void applyCardUpdate(MTFullCard fullCard, int face) {
        String str;
        String str2;
        String str3;
        String str4;
        ?? r2;
        String str5;
        boolean z;
        String scryfallid = fullCard.getScryfallid();
        String str6 = scryfallid == null ? "" : scryfallid;
        String printed_name = fullCard.getPrinted_name();
        String str7 = (printed_name == null && (printed_name = fullCard.getName()) == null) ? "" : printed_name;
        String cardid = fullCard.getCardid();
        String str8 = cardid == null ? "" : cardid;
        if (getContext() == null) {
            return;
        }
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        CardRecord cardLocal = companion.getCardLocal(contextRequireContext, str6, face);
        if (cardLocal != null) {
            String keywords = cardLocal.getKeywords();
            if (keywords == null) {
                keywords = "";
            }
            str = keywords;
        } else {
            str = "";
        }
        if (str8.length() > 0) {
            String oracleid = fullCard.getOracleid();
            if (oracleid == null) {
                oracleid = "";
            }
            Integer face2 = fullCard.getFace();
            int iIntValue = face2 != null ? face2.intValue() : face;
            String type_line = fullCard.getType_line();
            String str9 = oracleid;
            String oracle_text = fullCard.getOracle_text();
            int i = iIntValue;
            String lang = fullCard.getLang();
            String previewUrl = fullCard.getPreviewUrl(face);
            if (fullCard.getArtCropUrl(face).length() > 0) {
                str2 = "";
                str4 = "commander";
                z = true;
                str3 = "partner";
                r2 = 0;
            } else {
                str3 = "partner";
                str2 = "";
                str4 = "commander";
                r2 = 0;
                z = false;
            }
            MTGCardRecord mTGCardRecord = new MTGCardRecord(str9, i, str7, type_line, oracle_text, lang, str, str6, str8, previewUrl, z);
            String str10 = this.updatingPlaymatCard ? "rightplaymat" : this.updatingCommander ? str4 : this.updatingPartner ? str3 : null;
            if (str10 != null) {
                applyMTCardId(mTGCardRecord, str10);
            }
        } else {
            str2 = "";
            str3 = "partner";
            str4 = "commander";
            r2 = 0;
        }
        if (this.updatingPlaymatCard) {
            View view = getView();
            EditText editText = view != null ? (EditText) view.findViewById(R.id.playmatCardEditText) : null;
            this.lastPlaymatCardQuery = str7;
            if (editText != null) {
                editText.setText(str7);
            }
            if (editText != null) {
                editText.clearFocus();
            }
            View view2 = getView();
            ?? r4 = view2 != null ? (TextView) view2.findViewById(R.id.playmatCardTapToChange) : 0;
            if (r4 != 0) {
                r4.setVisibility(r2);
            }
            updatePlaymatPreview();
            this.updatingPlaymatCard = r2;
        }
        if (this.updatingCommander) {
            if (face == 0) {
                this.commander = str6;
            } else {
                this.commander = str6 + com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + face;
            }
            updatePlaymatPreview();
            updateSubmitButtonState();
            View view3 = getView();
            EditText editText2 = view3 != null ? (EditText) view3.findViewById(R.id.commanderEditText) : null;
            this.lastCommanderQuery = str7;
            if (editText2 != null) {
                editText2.setText(str7);
            }
            if (editText2 != null) {
                editText2.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.black_box_valid));
            }
            if (editText2 != null) {
                editText2.clearFocus();
            }
            View view4 = getView();
            ?? r42 = view4 != null ? (TextView) view4.findViewById(R.id.commanderTapToChange) : 0;
            if (r42 != 0) {
                r42.setVisibility(r2);
            }
            String oracleid2 = fullCard.getOracleid();
            if (oracleid2 != null) {
                str2 = oracleid2;
            }
            Integer face3 = fullCard.getFace();
            int iIntValue2 = face3 != null ? face3.intValue() : face;
            String type_line2 = fullCard.getType_line();
            String oracle_text2 = fullCard.getOracle_text();
            String lang2 = fullCard.getLang();
            str5 = com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
            acceptCommanderCard(new MTGCardRecord(str2, iIntValue2, str7, type_line2, oracle_text2, lang2, str, str6, null, null, false, 1792, null));
            updateColorIdentity(str4, str6, face, true);
            this.updatingCommander = r2;
        } else {
            str5 = com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        }
        if (this.updatingPartner) {
            if (face == 0) {
                this.partner = str6;
            } else {
                this.partner = str6 + str5 + face;
            }
            updatePlaymatPreview();
            View view5 = getView();
            EditText editText3 = view5 != null ? (EditText) view5.findViewById(R.id.partnerEditText) : null;
            this.lastPartnerQuery = str7;
            if (editText3 != null) {
                editText3.setText(str7);
            }
            if (editText3 != null) {
                editText3.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.black_box_valid));
            }
            if (editText3 != null) {
                editText3.clearFocus();
            }
            View view6 = getView();
            ?? r3 = view6 != null ? (TextView) view6.findViewById(R.id.partnerTapToChange) : null;
            if (r3 != 0) {
                r3.setVisibility(r2);
            }
            updateColorIdentity(str3, str6, face, true);
            this.updatingPartner = r2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void applyMTCardId(final MTGCardRecord card, final String role) {
        if (card.getMtCardId().length() == 0) {
            MTApiKt.getMtApi().getCardByScryfallId(card.getScryfallId()).enqueue(new Callback<MTCardResponse>() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment.applyMTCardId.1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCardResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (CreateDeckBottomSheetFragment.this.getContext() == null) {
                        return;
                    }
                    Toast.makeText(CreateDeckBottomSheetFragment.this.requireContext(), CreateDeckBottomSheetFragment.this.getString(R.string.error_fetching_card_details), 0).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCardResponse> call, Response<MTCardResponse> response) {
                    MTFullCard card2;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (CreateDeckBottomSheetFragment.this.getContext() == null) {
                        return;
                    }
                    MTCardResponse mTCardResponseBody = response.body();
                    if (mTCardResponseBody == null || (card2 = mTCardResponseBody.getCard()) == null) {
                        CreateDeckBottomSheetFragment createDeckBottomSheetFragment = CreateDeckBottomSheetFragment.this;
                        Toast.makeText(createDeckBottomSheetFragment.requireContext(), createDeckBottomSheetFragment.getString(R.string.error_fetching_card_details), 0).show();
                        return;
                    }
                    CreateDeckBottomSheetFragment createDeckBottomSheetFragment2 = CreateDeckBottomSheetFragment.this;
                    MTGCardRecord mTGCardRecord = card;
                    String str = role;
                    String cardid = card2.getCardid();
                    if (cardid == null) {
                        Toast.makeText(createDeckBottomSheetFragment2.requireContext(), createDeckBottomSheetFragment2.getString(R.string.error_fetching_card_details), 0).show();
                        return;
                    }
                    createDeckBottomSheetFragment2.applyMTCardId(MTGCardRecord.copy$default(mTGCardRecord, null, 0, null, null, null, null, null, null, cardid, card2.getPreviewUrl(mTGCardRecord.getFace()), card2.getArtCropUrl(mTGCardRecord.getFace()).length() > 0, 255, null), str);
                    createDeckBottomSheetFragment2.updatePlaymatPreview();
                    createDeckBottomSheetFragment2.updateSubmitButtonState();
                }
            });
        }
        String mtCardId = card.getMtCardId();
        if (mtCardId.length() <= 0) {
            mtCardId = null;
        }
        if (mtCardId == null) {
            return;
        }
        String previewImageUrl = card.getPreviewImageUrl();
        String str = previewImageUrl.length() > 0 ? previewImageUrl : null;
        boolean zIsArtCropPreview = card.isArtCropPreview();
        switch (role.hashCode()) {
            case -1498725064:
                if (role.equals("commander")) {
                    this.commanderCardId = mtCardId;
                    this.rightplaymatCardId = mtCardId;
                    this.rightplaymatFaceIndex = Integer.valueOf(card.getFace());
                    this.rightPlaymatPreviewUrl = str;
                    this.rightPlaymatScryfallId = card.getScryfallId();
                    this.rightPlaymatPreviewUrlArtCrop = zIsArtCropPreview;
                    break;
                }
                break;
            case -792929080:
                if (role.equals("partner")) {
                    this.partnerCardId = mtCardId;
                    this.leftplaymatCardId = mtCardId;
                    this.leftplaymatFaceIndex = Integer.valueOf(card.getFace());
                    this.leftPlaymatPreviewUrl = str;
                    this.leftPlaymatScryfallId = card.getScryfallId();
                    this.leftPlaymatPreviewUrlArtCrop = zIsArtCropPreview;
                    break;
                }
                break;
            case -683271312:
                if (role.equals("signaturespell")) {
                    this.signatureSpellCardId = mtCardId;
                    break;
                }
                break;
            case -119553008:
                if (role.equals("rightplaymat")) {
                    this.rightplaymatCardId = mtCardId;
                    this.rightplaymatFaceIndex = Integer.valueOf(card.getFace());
                    this.rightPlaymatPreviewUrl = str;
                    this.rightPlaymatScryfallId = card.getScryfallId();
                    this.rightPlaymatPreviewUrlArtCrop = zIsArtCropPreview;
                    break;
                }
                break;
            case 961968069:
                if (role.equals("leftplaymat")) {
                    this.leftplaymatCardId = mtCardId;
                    this.leftplaymatFaceIndex = Integer.valueOf(card.getFace());
                    this.leftPlaymatPreviewUrl = str;
                    this.leftPlaymatScryfallId = card.getScryfallId();
                    this.leftPlaymatPreviewUrlArtCrop = zIsArtCropPreview;
                    break;
                }
                break;
            case 1908210232:
                if (role.equals("partnersignaturespell")) {
                    this.partnerSignatureSpellCardId = mtCardId;
                    break;
                }
                break;
        }
    }

    private final void applyOverridePipState(View view, boolean isCommander, String override) {
        List listListOf = isCommander ? CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.commander_color_w), Integer.valueOf(R.id.commander_color_u), Integer.valueOf(R.id.commander_color_b), Integer.valueOf(R.id.commander_color_r), Integer.valueOf(R.id.commander_color_g)}) : CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.partner_color_w), Integer.valueOf(R.id.partner_color_u), Integer.valueOf(R.id.partner_color_b), Integer.valueOf(R.id.partner_color_r), Integer.valueOf(R.id.partner_color_g)});
        List listListOf2 = CollectionsKt.listOf((Object[]) new String[]{ExifInterface.LONGITUDE_WEST, "U", "B", "R", GameUtils.CONDITION_GOOD});
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.commander_color_pip_selected);
        int size = listListOf.size();
        for (int i = 0; i < size; i++) {
            ImageView imageView = (ImageView) view.findViewById(((Number) listListOf.get(i)).intValue());
            imageView.setAlpha(Intrinsics.areEqual(override, listListOf2.get(i)) ? 1.0f : 0.25f);
            ViewParent parent = imageView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.setBackground(Intrinsics.areEqual(override, listListOf2.get(i)) ? drawable : null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    public final void applyScannedCard(MTFullCard fullCard, int face) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        ?? r3;
        boolean z;
        int i;
        String scryfallid = fullCard.getScryfallid();
        String str6 = scryfallid == null ? "" : scryfallid;
        String name = fullCard.getName();
        String str7 = name == null ? "" : name;
        if (getContext() == null) {
            return;
        }
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        CardRecord cardLocal = companion.getCardLocal(contextRequireContext, str6, face);
        if (cardLocal != null) {
            String keywords = cardLocal.getKeywords();
            if (keywords == null) {
                keywords = "";
            }
            str = keywords;
        } else {
            str = "";
        }
        String str8 = this.updatingCommander ? "commander" : this.updatingPartner ? "partner" : this.updatingPlaymatCard ? "rightplaymat" : null;
        if (str8 != null) {
            String oracleid = fullCard.getOracleid();
            if (oracleid == null) {
                oracleid = "";
            }
            Integer face2 = fullCard.getFace();
            int iIntValue = face2 != null ? face2.intValue() : face;
            String type_line = fullCard.getType_line();
            String oracle_text = fullCard.getOracle_text();
            String str9 = oracleid;
            String lang = fullCard.getLang();
            String cardid = fullCard.getCardid();
            if (cardid == null) {
                cardid = "";
            }
            String previewUrl = fullCard.getPreviewUrl(face);
            if (fullCard.getArtCropUrl(face).length() > 0) {
                str2 = "";
                str3 = "partner";
                str4 = "commander";
                z = true;
                i = iIntValue;
            } else {
                str3 = "partner";
                z = false;
                str2 = "";
                i = iIntValue;
                str4 = "commander";
            }
            applyMTCardId(new MTGCardRecord(str9, i, str7, type_line, oracle_text, lang, str, str6, cardid, previewUrl, z), str8);
        } else {
            str2 = "";
            str3 = "partner";
            str4 = "commander";
        }
        if (this.updatingCommander) {
            if (face == 0) {
                this.commander = str6;
            } else {
                this.commander = str6 + com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + face;
            }
            View view = getView();
            EditText editText = view != null ? (EditText) view.findViewById(R.id.commanderEditText) : null;
            this.lastCommanderQuery = str7;
            if (editText != null) {
                editText.setText(str7);
            }
            updateColorIdentity(str4, str6, face, true);
            updatePlaymatPreview();
            updateSubmitButtonState();
            if (editText != null) {
                editText.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.black_box_valid));
            }
            if (editText != null) {
                editText.clearFocus();
            }
            View view2 = getView();
            TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.commanderTapToChange) : null;
            r3 = 0;
            if (textView != null) {
                textView.setVisibility(0);
            }
            str5 = com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
            String oracleid2 = fullCard.getOracleid();
            if (oracleid2 != null) {
                str2 = oracleid2;
            }
            Integer face3 = fullCard.getFace();
            acceptCommanderCard(new MTGCardRecord(str2, face3 != null ? face3.intValue() : face, str7, fullCard.getType_line(), fullCard.getOracle_text(), fullCard.getLang(), str, str6, null, null, false, 1792, null));
            this.updatingCommander = false;
        } else {
            str5 = com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
            r3 = 0;
        }
        if (this.updatingPartner) {
            if (face == 0) {
                this.partner = str6;
            } else {
                this.partner = str6 + str5 + face;
            }
            View view3 = getView();
            EditText editText2 = view3 != null ? (EditText) view3.findViewById(R.id.partnerEditText) : null;
            this.lastPartnerQuery = str7;
            if (editText2 != null) {
                editText2.setText(str7);
            }
            if (editText2 != null) {
                editText2.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.black_box_valid));
            }
            if (editText2 != null) {
                editText2.clearFocus();
            }
            View view4 = getView();
            TextView textView2 = view4 != null ? (TextView) view4.findViewById(R.id.partnerTapToChange) : 0;
            if (textView2 != 0) {
                textView2.setVisibility(r3);
            }
            updateColorIdentity(str3, str6, face, true);
            updatePlaymatPreview();
            this.updatingPartner = r3;
        }
        if (this.updatingPlaymatCard) {
            View view5 = getView();
            EditText editText3 = view5 != null ? (EditText) view5.findViewById(R.id.playmatCardEditText) : null;
            this.lastPlaymatCardQuery = str7;
            if (editText3 != null) {
                editText3.setText(str7);
            }
            if (editText3 != null) {
                editText3.clearFocus();
            }
            View view6 = getView();
            TextView textView3 = view6 != null ? (TextView) view6.findViewById(R.id.playmatCardTapToChange) : null;
            if (textView3 != 0) {
                textView3.setVisibility(r3);
            }
            updatePlaymatPreview();
            this.updatingPlaymatCard = r3;
        }
    }

    private final void displayColorIdentity(String colors) {
        Log.d("CREATE_DECK", "Displaying color identity: " + colors);
        View view = getView();
        if (view != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.manaLayout);
            ImageView imageView = (ImageView) view.findViewById(R.id.w_mana);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.u_mana);
            ImageView imageView3 = (ImageView) view.findViewById(R.id.b_mana);
            ImageView imageView4 = (ImageView) view.findViewById(R.id.r_mana);
            ImageView imageView5 = (ImageView) view.findViewById(R.id.g_mana);
            ImageView imageView6 = (ImageView) view.findViewById(R.id.c_mana);
            linearLayout.setVisibility(0);
            imageView.setVisibility(8);
            imageView2.setVisibility(8);
            imageView3.setVisibility(8);
            imageView4.setVisibility(8);
            imageView5.setVisibility(8);
            imageView6.setVisibility(8);
            Log.d("CREATE_DECK", "Colors: " + colors);
            String str = colors;
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt == 'B') {
                    imageView3.setVisibility(0);
                } else if (cCharAt == 'G') {
                    imageView5.setVisibility(0);
                } else if (cCharAt == 'R') {
                    imageView4.setVisibility(0);
                } else if (cCharAt == 'U') {
                    imageView2.setVisibility(0);
                } else if (cCharAt == 'W') {
                    imageView.setVisibility(0);
                }
            }
            if (str.length() == 0) {
                imageView6.setVisibility(0);
            }
        }
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
    public final boolean isValidDeckUrl(String url) {
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

    static final Unit onViewCreated$lambda$0(final CreateDeckBottomSheetFragment createDeckBottomSheetFragment, final LinearLayout linearLayout, final TextView textView) {
        Context contextRequireContext = createDeckBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PrivacyPopupMenu privacyPopupMenu = new PrivacyPopupMenu(contextRequireContext, createDeckBottomSheetFragment.selectedPrivacyType, PrivacyContext.DECK, new Function1() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$0$0(this.f$0, textView, linearLayout, (String) obj);
            }
        });
        Intrinsics.checkNotNull(linearLayout);
        privacyPopupMenu.show(linearLayout, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, TextView textView, LinearLayout linearLayout, String selectedType) {
        Intrinsics.checkNotNullParameter(selectedType, "selectedType");
        createDeckBottomSheetFragment.selectedPrivacyType = selectedType;
        Intrinsics.checkNotNull(textView);
        Intrinsics.checkNotNull(linearLayout);
        createDeckBottomSheetFragment.updatePrivacySelectorUI(textView, linearLayout);
        return Unit.INSTANCE;
    }

    static final void onViewCreated$lambda$1(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, View view, View view2) {
        createDeckBottomSheetFragment.deckType = 0;
        createDeckBottomSheetFragment.updateTypeSelection(view);
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [T, java.util.List] */
    static final Unit onViewCreated$lambda$10(final CreateDeckBottomSheetFragment createDeckBottomSheetFragment, final View view, final List list) {
        Intrinsics.checkNotNull(list);
        List list2 = list;
        Log.d(TAG, "Searching on scryfall (partner) : count = " + list2.size());
        Log.d(TAG, "Searching on scryfall (partner) : results = " + list);
        if (list2.isEmpty()) {
            createDeckBottomSheetFragment.currentOnlinePartnerCards = new ArrayList();
        } else {
            Log.d(TAG, "--> Current local count (partner) = " + createDeckBottomSheetFragment.currentLocalPartnerCards.size());
            Log.d(TAG, "--> Current local cards (partner) = " + createDeckBottomSheetFragment.currentLocalPartnerCards);
            createDeckBottomSheetFragment.currentOnlinePartnerCards = CollectionsKt.toMutableList((Collection) list2);
            List list3 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(((MTGCardRecord) it.next()).getTitle());
            }
            ArrayList<String> arrayList2 = arrayList;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            List<MTGCardRecord> list4 = createDeckBottomSheetFragment.currentLocalPartnerCards;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator<T> it2 = list4.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((MTGCardRecord) it2.next()).getTitle());
            }
            objectRef.element = CollectionsKt.toMutableList((Collection) arrayList3);
            for (String str : arrayList2) {
                if (!((List) objectRef.element).contains(str)) {
                    ((List) objectRef.element).add(str);
                }
            }
            Log.d(TAG, "TOTAL suggestions count (partner) = " + ((Collection) objectRef.element).size());
            PopupWindow popupWindow = createDeckBottomSheetFragment.partnerPopupWindow;
            if (popupWindow != null) {
                Log.d(TAG, "Popup menu already up, updating... (partner)");
                ListView listView = (ListView) popupWindow.getContentView().findViewById(R.id.suggestions_list);
                listView.setAdapter((ListAdapter) new ArrayAdapter(createDeckBottomSheetFragment.requireContext(), android.R.layout.simple_list_item_1, (List) objectRef.element));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda52
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                        CreateDeckBottomSheetFragment.onViewCreated$lambda$10$2$0(objectRef, createDeckBottomSheetFragment, view, adapterView, view2, i, j);
                    }
                });
            } else {
                Log.d(TAG, "Creating new popup menu (partner)");
                final EditText editText = view != null ? (EditText) view.findViewById(R.id.partnerEditText) : null;
                if (editText != null) {
                    Object systemService = createDeckBottomSheetFragment.requireContext().getSystemService("layout_inflater");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                    View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.popup_suggestions, (ViewGroup) null);
                    createDeckBottomSheetFragment.partnerPopupWindow = new PopupWindow(viewInflate, -2, -2, true);
                    ListView listView2 = (ListView) viewInflate.findViewById(R.id.suggestions_list);
                    listView2.setAdapter((ListAdapter) new ArrayAdapter(createDeckBottomSheetFragment.requireContext(), android.R.layout.simple_list_item_1, (List) objectRef.element));
                    final EditText editText2 = editText;
                    listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda1
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                            CreateDeckBottomSheetFragment.onViewCreated$lambda$10$3$0$0(list, createDeckBottomSheetFragment, editText, editText2, createDeckBottomSheetFragment, view, adapterView, view2, i, j);
                        }
                    });
                    PopupWindow popupWindow2 = createDeckBottomSheetFragment.partnerPopupWindow;
                    if (popupWindow2 != null) {
                        popupWindow2.setOutsideTouchable(true);
                    }
                    PopupWindow popupWindow3 = createDeckBottomSheetFragment.partnerPopupWindow;
                    if (popupWindow3 != null) {
                        popupWindow3.setFocusable(false);
                    }
                    PopupWindow popupWindow4 = createDeckBottomSheetFragment.partnerPopupWindow;
                    if (popupWindow4 != null) {
                        int[] iArr = new int[2];
                        editText.getLocationOnScreen(iArr);
                        View contentView = popupWindow4.getContentView();
                        contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        Size size = new Size(contentView.getMeasuredWidth(), contentView.getMeasuredHeight() * ((List) objectRef.element).size());
                        int height = iArr[1] - editText.getHeight();
                        if (size.getHeight() > height) {
                            popupWindow4.setHeight(height);
                            size = new Size(popupWindow4.getContentView().getMeasuredWidth(), height);
                        }
                        if (size.getHeight() > 0) {
                            popupWindow4.setHeight(size.getHeight());
                        }
                        popupWindow4.showAtLocation(editText, 8388659, iArr[0], iArr[1] - size.getHeight());
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$2$0(Ref.ObjectRef objectRef, CreateDeckBottomSheetFragment createDeckBottomSheetFragment, View view, AdapterView adapterView, View view2, int i, long j) {
        Object next;
        String str = (String) ((List) objectRef.element).get(i);
        Iterator<T> it = createDeckBottomSheetFragment.currentLocalPartnerCards.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((MTGCardRecord) next).getTitle(), str)) {
                    break;
                }
            }
        }
        if (next == null) {
            Iterator<T> it2 = createDeckBottomSheetFragment.currentOnlinePartnerCards.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    if (Intrinsics.areEqual(((MTGCardRecord) next).getTitle(), str)) {
                        break;
                    }
                }
            }
        }
        MTGCardRecord mTGCardRecord = (MTGCardRecord) next;
        if (mTGCardRecord != null) {
            EditText editText = view != null ? (EditText) view.findViewById(R.id.partnerEditText) : null;
            if (editText != null) {
                createDeckBottomSheetFragment.lastPartnerQuery = mTGCardRecord.getTitle();
                editText.setText(mTGCardRecord.getTitle());
                createDeckBottomSheetFragment.partnerLang = mTGCardRecord.getLang();
                String scryfallId = mTGCardRecord.getScryfallId();
                if (scryfallId.length() <= 0) {
                    scryfallId = null;
                }
                if (scryfallId == null) {
                    GameUtils companion = GameUtils.INSTANCE.getInstance();
                    Context contextRequireContext = createDeckBottomSheetFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    scryfallId = companion.getFirstPrintScryfallId(contextRequireContext, mTGCardRecord);
                }
                if (scryfallId != null) {
                    createDeckBottomSheetFragment.partner = scryfallId;
                    mTGCardRecord.setScryfallId(scryfallId);
                    createDeckBottomSheetFragment.applyMTCardId(mTGCardRecord, "partner");
                    editText.setBackground(createDeckBottomSheetFragment.requireContext().getResources().getDrawable(R.drawable.black_box_valid, null));
                    editText.clearFocus();
                    createDeckBottomSheetFragment.updateColorIdentity("partner", scryfallId, 0, true);
                    createDeckBottomSheetFragment.updatePlaymatPreview();
                    TextView textView = view != null ? (TextView) view.findViewById(R.id.partnerTapToChange) : null;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                }
                Object systemService = createDeckBottomSheetFragment.requireActivity().getSystemService("input_method");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                PopupWindow popupWindow = createDeckBottomSheetFragment.partnerPopupWindow;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$3$0$0(List list, CreateDeckBottomSheetFragment createDeckBottomSheetFragment, EditText editText, EditText editText2, CreateDeckBottomSheetFragment createDeckBottomSheetFragment2, View view, AdapterView adapterView, View view2, int i, long j) {
        MTGCardRecord mTGCardRecord = (MTGCardRecord) list.get(i);
        createDeckBottomSheetFragment.lastPartnerQuery = mTGCardRecord.getTitle();
        editText.setText(mTGCardRecord.getTitle());
        createDeckBottomSheetFragment.partnerLang = mTGCardRecord.getLang();
        String scryfallId = mTGCardRecord.getScryfallId();
        if (scryfallId.length() <= 0) {
            scryfallId = null;
        }
        if (scryfallId == null) {
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = createDeckBottomSheetFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            scryfallId = companion.getFirstPrintScryfallId(contextRequireContext, mTGCardRecord);
        }
        if (scryfallId != null) {
            createDeckBottomSheetFragment2.partner = scryfallId;
            mTGCardRecord.setScryfallId(scryfallId);
            createDeckBottomSheetFragment.applyMTCardId(mTGCardRecord, "partner");
            editText2.setBackground(createDeckBottomSheetFragment.requireContext().getResources().getDrawable(R.drawable.black_box_valid, null));
            editText2.clearFocus();
            createDeckBottomSheetFragment2.updateColorIdentity("partner", scryfallId, 0, true);
            createDeckBottomSheetFragment2.updatePlaymatPreview();
            TextView textView = view != null ? (TextView) view.findViewById(R.id.partnerTapToChange) : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
        Object systemService = createDeckBottomSheetFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText2.getWindowToken(), 0);
        PopupWindow popupWindow = createDeckBottomSheetFragment2.partnerPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    static final void onViewCreated$lambda$11(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, EditText editText, View view) {
        if (createDeckBottomSheetFragment.getContext() == null) {
            return;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = createDeckBottomSheetFragment.cardSearchLauncher;
        if (activityResultLauncher == null) {
            Log.e(TAG, "cardSearchLauncher not initialized - fragment may have been recreated");
            Toast.makeText(createDeckBottomSheetFragment.requireContext(), createDeckBottomSheetFragment.getString(R.string.server_error), 0).show();
            createDeckBottomSheetFragment.dismiss();
            return;
        }
        String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(editText.getText().toString(), ",", "", false, 4, (Object) null), "-", "", false, 4, (Object) null), "\"", "", false, 4, (Object) null), "&", "", false, 4, (Object) null);
        createDeckBottomSheetFragment.updatingPartner = true;
        Intent intent = new Intent(createDeckBottomSheetFragment.requireContext(), (Class<?>) SearchActivity.class);
        intent.putExtra("pickACardMode", true);
        intent.putExtra("condense", false);
        intent.putExtra(SearchIntents.EXTRA_QUERY, strReplace$default);
        intent.putExtra("lang", createDeckBottomSheetFragment.partnerLang);
        activityResultLauncher.launch(intent);
    }

    static final void onViewCreated$lambda$12(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, View view) {
        if (createDeckBottomSheetFragment.getContext() == null) {
            return;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = createDeckBottomSheetFragment.pickCardLauncher;
        if (activityResultLauncher != null) {
            createDeckBottomSheetFragment.updatingPartner = true;
            activityResultLauncher.launch(new Intent(createDeckBottomSheetFragment.requireContext(), (Class<?>) PickACardActivity.class));
        } else {
            Log.e(TAG, "pickCardLauncher not initialized - fragment may have been recreated");
            Toast.makeText(createDeckBottomSheetFragment.requireContext(), createDeckBottomSheetFragment.getString(R.string.server_error), 0).show();
            createDeckBottomSheetFragment.dismiss();
        }
    }

    static final boolean onViewCreated$lambda$13(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        Object systemService = createDeckBottomSheetFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
        return true;
    }

    static final boolean onViewCreated$lambda$14(EditText editText, CreateDeckBottomSheetFragment createDeckBottomSheetFragment, View view, View view2, MotionEvent motionEvent) {
        LinearLayout linearLayout;
        if (motionEvent.getAction() != 1 || editText.getCompoundDrawables()[2] == null || motionEvent.getRawX() < editText.getRight() - (editText.getCompoundDrawables()[2].getBounds().width() * 2.0f)) {
            return false;
        }
        if (createDeckBottomSheetFragment.getContext() == null) {
            return true;
        }
        editText.setText("");
        createDeckBottomSheetFragment.partner = null;
        createDeckBottomSheetFragment.leftplaymat = null;
        createDeckBottomSheetFragment.partnerCardId = null;
        createDeckBottomSheetFragment.leftplaymatCardId = null;
        createDeckBottomSheetFragment.leftplaymatFaceIndex = null;
        createDeckBottomSheetFragment.leftPlaymatPreviewUrl = null;
        createDeckBottomSheetFragment.partnerIdentity.clear();
        createDeckBottomSheetFragment.partnerColorOverride = null;
        createDeckBottomSheetFragment.partnerIsColorChoosing = false;
        if (view != null && (linearLayout = (LinearLayout) view.findViewById(R.id.partnerColorOverrideLayout)) != null) {
            linearLayout.setVisibility(8);
        }
        createDeckBottomSheetFragment.refreshDisplayColorIdentity();
        editText.requestFocus();
        Object systemService = createDeckBottomSheetFragment.requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        return true;
    }

    static final void onViewCreated$lambda$15(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, EditText editText, View view) {
        if (createDeckBottomSheetFragment.getContext() == null) {
            return;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = createDeckBottomSheetFragment.cardSearchLauncher;
        if (activityResultLauncher == null) {
            Log.e(TAG, "cardSearchLauncher not initialized - fragment may have been recreated");
            Toast.makeText(createDeckBottomSheetFragment.requireContext(), createDeckBottomSheetFragment.getString(R.string.server_error), 0).show();
            createDeckBottomSheetFragment.dismiss();
            return;
        }
        String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(editText.getText().toString(), ",", "", false, 4, (Object) null), "-", "", false, 4, (Object) null), "\"", "", false, 4, (Object) null), "&", "", false, 4, (Object) null);
        createDeckBottomSheetFragment.updatingPartner = true;
        Intent intent = new Intent(createDeckBottomSheetFragment.requireContext(), (Class<?>) SearchActivity.class);
        intent.putExtra("pickACardMode", true);
        intent.putExtra("condense", false);
        intent.putExtra("forceLocalDb", true);
        intent.putExtra(SearchIntents.EXTRA_QUERY, strReplace$default);
        intent.putExtra("lang", createDeckBottomSheetFragment.partnerLang);
        activityResultLauncher.launch(intent);
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.util.List] */
    static final Unit onViewCreated$lambda$16(final CreateDeckBottomSheetFragment createDeckBottomSheetFragment, final View view, final List list) {
        Intrinsics.checkNotNull(list);
        List list2 = list;
        Log.d(TAG, "Searching on scryfall (playmat) : count = " + list2.size());
        Log.d(TAG, "Searching on scryfall (playmat) : results = " + list);
        if (list2.isEmpty()) {
            createDeckBottomSheetFragment.currentOnlinePlaymatCards = new ArrayList();
        } else {
            Log.d(TAG, "--> Current local count (playmat) = " + createDeckBottomSheetFragment.currentLocalPlaymatCards.size());
            Log.d(TAG, "--> Current local cards (playmat) = " + createDeckBottomSheetFragment.currentLocalPlaymatCards);
            createDeckBottomSheetFragment.currentOnlinePlaymatCards = CollectionsKt.toMutableList((Collection) list2);
            List list3 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(((MTGCardRecord) it.next()).getTitle());
            }
            ArrayList<String> arrayList2 = arrayList;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            List<MTGCardRecord> list4 = createDeckBottomSheetFragment.currentLocalPlaymatCards;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator<T> it2 = list4.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((MTGCardRecord) it2.next()).getTitle());
            }
            objectRef.element = CollectionsKt.toMutableList((Collection) arrayList3);
            for (String str : arrayList2) {
                if (!((List) objectRef.element).contains(str)) {
                    ((List) objectRef.element).add(str);
                }
            }
            Log.d(TAG, "TOTAL suggestions count (playmat) = " + ((Collection) objectRef.element).size());
            PopupWindow popupWindow = createDeckBottomSheetFragment.playmatCardPopupWindow;
            if (popupWindow != null) {
                Log.d(TAG, "Popup menu already up, updating... (playmat)");
                ListView listView = (ListView) popupWindow.getContentView().findViewById(R.id.suggestions_list);
                listView.setAdapter((ListAdapter) new ArrayAdapter(createDeckBottomSheetFragment.requireContext(), android.R.layout.simple_list_item_1, (List) objectRef.element));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda7
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                        CreateDeckBottomSheetFragment.onViewCreated$lambda$16$2$0(objectRef, createDeckBottomSheetFragment, view, adapterView, view2, i, j);
                    }
                });
            } else {
                Log.d(TAG, "Creating new popup menu (playmat)");
                final EditText editText = view != null ? (EditText) view.findViewById(R.id.playmatCardEditText) : null;
                if (editText != null) {
                    Object systemService = createDeckBottomSheetFragment.requireContext().getSystemService("layout_inflater");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                    View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.popup_suggestions, (ViewGroup) null);
                    createDeckBottomSheetFragment.playmatCardPopupWindow = new PopupWindow(viewInflate, -2, -2, true);
                    ListView listView2 = (ListView) viewInflate.findViewById(R.id.suggestions_list);
                    listView2.setAdapter((ListAdapter) new ArrayAdapter(createDeckBottomSheetFragment.requireContext(), android.R.layout.simple_list_item_1, (List) objectRef.element));
                    listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda8
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                            CreateDeckBottomSheetFragment.onViewCreated$lambda$16$3$0$0(list, objectRef, createDeckBottomSheetFragment, editText, createDeckBottomSheetFragment, view, adapterView, view2, i, j);
                        }
                    });
                    PopupWindow popupWindow2 = createDeckBottomSheetFragment.playmatCardPopupWindow;
                    if (popupWindow2 != null) {
                        popupWindow2.setOutsideTouchable(true);
                    }
                    PopupWindow popupWindow3 = createDeckBottomSheetFragment.playmatCardPopupWindow;
                    if (popupWindow3 != null) {
                        popupWindow3.setFocusable(false);
                    }
                    PopupWindow popupWindow4 = createDeckBottomSheetFragment.playmatCardPopupWindow;
                    if (popupWindow4 != null) {
                        int[] iArr = new int[2];
                        editText.getLocationOnScreen(iArr);
                        View contentView = popupWindow4.getContentView();
                        contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        Size size = new Size(contentView.getMeasuredWidth(), contentView.getMeasuredHeight() * ((List) objectRef.element).size());
                        int height = iArr[1] - editText.getHeight();
                        if (size.getHeight() > height) {
                            popupWindow4.setHeight(height);
                            size = new Size(popupWindow4.getContentView().getMeasuredWidth(), height);
                        }
                        if (size.getHeight() > 0) {
                            popupWindow4.setHeight(size.getHeight());
                        }
                        popupWindow4.showAtLocation(editText, 8388659, iArr[0], iArr[1] - size.getHeight());
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$16$2$0(Ref.ObjectRef objectRef, CreateDeckBottomSheetFragment createDeckBottomSheetFragment, View view, AdapterView adapterView, View view2, int i, long j) {
        Object next;
        String str = (String) ((List) objectRef.element).get(i);
        Iterator<T> it = createDeckBottomSheetFragment.currentLocalPlaymatCards.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((MTGCardRecord) next).getTitle(), str)) {
                    break;
                }
            }
        }
        if (next == null) {
            Iterator<T> it2 = createDeckBottomSheetFragment.currentOnlinePlaymatCards.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    if (Intrinsics.areEqual(((MTGCardRecord) next).getTitle(), str)) {
                        break;
                    }
                }
            }
        }
        MTGCardRecord mTGCardRecord = (MTGCardRecord) next;
        if (mTGCardRecord != null) {
            EditText editText = view != null ? (EditText) view.findViewById(R.id.playmatCardEditText) : null;
            if (editText != null) {
                String title = mTGCardRecord.getTitle();
                createDeckBottomSheetFragment.lastPlaymatCardQuery = title;
                editText.setText(title);
                createDeckBottomSheetFragment.playmatLang = mTGCardRecord.getLang();
                String scryfallId = mTGCardRecord.getScryfallId();
                if (scryfallId.length() <= 0) {
                    scryfallId = null;
                }
                if (scryfallId == null) {
                    GameUtils companion = GameUtils.INSTANCE.getInstance();
                    Context contextRequireContext = createDeckBottomSheetFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    scryfallId = companion.getFirstPrintScryfallId(contextRequireContext, mTGCardRecord);
                }
                if (scryfallId != null) {
                    editText.clearFocus();
                    mTGCardRecord.setScryfallId(scryfallId);
                    createDeckBottomSheetFragment.applyMTCardId(mTGCardRecord, "rightplaymat");
                    createDeckBottomSheetFragment.updatePlaymatPreview();
                    createDeckBottomSheetFragment.updateSubmitButtonState();
                    TextView textView = view != null ? (TextView) view.findViewById(R.id.playmatCardTapToChange) : null;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                }
                Object systemService = createDeckBottomSheetFragment.requireActivity().getSystemService("input_method");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                PopupWindow popupWindow = createDeckBottomSheetFragment.playmatCardPopupWindow;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$16$3$0$0(List list, Ref.ObjectRef objectRef, CreateDeckBottomSheetFragment createDeckBottomSheetFragment, EditText editText, CreateDeckBottomSheetFragment createDeckBottomSheetFragment2, View view, AdapterView adapterView, View view2, int i, long j) {
        MTGCardRecord mTGCardRecord = (MTGCardRecord) list.get(i);
        String str = (String) ((List) objectRef.element).get(i);
        createDeckBottomSheetFragment.lastPlaymatCardQuery = str;
        editText.setText(str);
        createDeckBottomSheetFragment.playmatLang = mTGCardRecord.getLang();
        String scryfallId = mTGCardRecord.getScryfallId();
        if (scryfallId.length() <= 0) {
            scryfallId = null;
        }
        if (scryfallId == null) {
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = createDeckBottomSheetFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            scryfallId = companion.getFirstPrintScryfallId(contextRequireContext, mTGCardRecord);
        }
        if (scryfallId != null) {
            editText.clearFocus();
            mTGCardRecord.setScryfallId(scryfallId);
            createDeckBottomSheetFragment.applyMTCardId(mTGCardRecord, "rightplaymat");
            createDeckBottomSheetFragment2.updatePlaymatPreview();
            createDeckBottomSheetFragment2.updateSubmitButtonState();
            TextView textView = view != null ? (TextView) view.findViewById(R.id.playmatCardTapToChange) : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
        Object systemService = createDeckBottomSheetFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        PopupWindow popupWindow = createDeckBottomSheetFragment2.playmatCardPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    static final void onViewCreated$lambda$17(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, EditText editText, View view) {
        if (createDeckBottomSheetFragment.getContext() == null) {
            return;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = createDeckBottomSheetFragment.cardSearchLauncher;
        if (activityResultLauncher == null) {
            Log.e(TAG, "cardSearchLauncher not initialized - fragment may have been recreated");
            Toast.makeText(createDeckBottomSheetFragment.requireContext(), createDeckBottomSheetFragment.getString(R.string.server_error), 0).show();
            createDeckBottomSheetFragment.dismiss();
            return;
        }
        String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(editText.getText().toString(), ",", "", false, 4, (Object) null), "-", "", false, 4, (Object) null), "\"", "", false, 4, (Object) null), "&", "", false, 4, (Object) null);
        createDeckBottomSheetFragment.updatingPlaymatCard = true;
        Intent intent = new Intent(createDeckBottomSheetFragment.requireContext(), (Class<?>) SearchActivity.class);
        intent.putExtra("pickACardMode", true);
        intent.putExtra("condense", false);
        intent.putExtra(SearchIntents.EXTRA_QUERY, strReplace$default);
        intent.putExtra("lang", createDeckBottomSheetFragment.playmatLang);
        activityResultLauncher.launch(intent);
    }

    static final void onViewCreated$lambda$18(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, View view) {
        if (createDeckBottomSheetFragment.getContext() == null) {
            return;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = createDeckBottomSheetFragment.pickCardLauncher;
        if (activityResultLauncher != null) {
            createDeckBottomSheetFragment.updatingPlaymatCard = true;
            activityResultLauncher.launch(new Intent(createDeckBottomSheetFragment.requireContext(), (Class<?>) PickACardActivity.class));
        } else {
            Log.e(TAG, "pickCardLauncher not initialized - fragment may have been recreated");
            Toast.makeText(createDeckBottomSheetFragment.requireContext(), createDeckBottomSheetFragment.getString(R.string.server_error), 0).show();
            createDeckBottomSheetFragment.dismiss();
        }
    }

    static final boolean onViewCreated$lambda$19(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        Object systemService = createDeckBottomSheetFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
        return true;
    }

    static final void onViewCreated$lambda$2(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, View view, View view2) {
        createDeckBottomSheetFragment.deckType = 1;
        createDeckBottomSheetFragment.updateTypeSelection(view);
    }

    static final boolean onViewCreated$lambda$20(EditText editText, CreateDeckBottomSheetFragment createDeckBottomSheetFragment, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 || editText.getCompoundDrawables()[2] == null || motionEvent.getRawX() < editText.getRight() - (editText.getCompoundDrawables()[2].getBounds().width() * 2.0f)) {
            return false;
        }
        if (createDeckBottomSheetFragment.getContext() == null) {
            return true;
        }
        editText.setText("");
        createDeckBottomSheetFragment.rightplaymat = null;
        createDeckBottomSheetFragment.rightplaymatCardId = null;
        createDeckBottomSheetFragment.rightplaymatFaceIndex = null;
        createDeckBottomSheetFragment.rightPlaymatPreviewUrl = null;
        createDeckBottomSheetFragment.updateSubmitButtonState();
        editText.requestFocus();
        Object systemService = createDeckBottomSheetFragment.requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        return true;
    }

    static final void onViewCreated$lambda$21(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, EditText editText, View view) {
        if (createDeckBottomSheetFragment.getContext() == null) {
            return;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = createDeckBottomSheetFragment.cardSearchLauncher;
        if (activityResultLauncher == null) {
            Log.e(TAG, "cardSearchLauncher not initialized - fragment may have been recreated");
            Toast.makeText(createDeckBottomSheetFragment.requireContext(), createDeckBottomSheetFragment.getString(R.string.server_error), 0).show();
            createDeckBottomSheetFragment.dismiss();
            return;
        }
        String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(editText.getText().toString(), ",", "", false, 4, (Object) null), "-", "", false, 4, (Object) null), "\"", "", false, 4, (Object) null), "&", "", false, 4, (Object) null);
        createDeckBottomSheetFragment.updatingPlaymatCard = true;
        Intent intent = new Intent(createDeckBottomSheetFragment.requireContext(), (Class<?>) SearchActivity.class);
        intent.putExtra("pickACardMode", true);
        intent.putExtra("condense", false);
        intent.putExtra("forceLocalDb", true);
        intent.putExtra("lang", createDeckBottomSheetFragment.playmatLang);
        intent.putExtra(SearchIntents.EXTRA_QUERY, strReplace$default);
        activityResultLauncher.launch(intent);
    }

    static final boolean onViewCreated$lambda$26(TextView textView, CreateDeckBottomSheetFragment createDeckBottomSheetFragment, List list, EditText editText, LinearLayout linearLayout, ConstraintLayout constraintLayout, View view, LinearLayout linearLayout2, TextView textView2, EditText editText2, LinearLayout linearLayout3, LinearLayout linearLayout4, MenuItem menuItem) {
        Object next;
        Log.d("CREATE_DECK", "Selected format: " + ((Object) menuItem.getTitle()));
        textView.setText(menuItem.getTitle());
        textView.setTextColor(ContextCompat.getColor(createDeckBottomSheetFragment.requireContext(), R.color.almost_white));
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((MTFormat) next).getId() == menuItem.getItemId()) {
                break;
            }
        }
        createDeckBottomSheetFragment.format = (MTFormat) next;
        editText.setVisibility(0);
        linearLayout.setVisibility(0);
        constraintLayout.setVisibility(0);
        View viewFindViewById = view.findViewById(R.id.bracketLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById;
        constraintLayout2.setVisibility(8);
        MTFormat mTFormat = createDeckBottomSheetFragment.format;
        if (mTFormat == null) {
            return true;
        }
        if (Intrinsics.areEqual(mTFormat.getScryfallid(), "commander")) {
            constraintLayout2.setVisibility(0);
        }
        if (mTFormat.getHascommander()) {
            Log.d("CREATE_DECK", "Format with commander.");
            linearLayout2.setVisibility(0);
            if (createDeckBottomSheetFragment.commander != null) {
                textView2.setVisibility(0);
            }
            if (Intrinsics.areEqual(mTFormat.getScryfallid(), "oathbreaker")) {
                editText2.setHint(createDeckBottomSheetFragment.getString(R.string.oathbreaker_hint));
            } else {
                editText2.setHint(createDeckBottomSheetFragment.getString(R.string.commander_hint));
            }
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
        } else {
            Log.d("CREATE_DECK", "Format with NO commander.");
            linearLayout2.setVisibility(8);
            textView2.setVisibility(8);
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
            }
        }
        createDeckBottomSheetFragment.updateSubmitButtonState();
        return true;
    }

    static final boolean onViewCreated$lambda$27(PopupMenu popupMenu, TextView textView, CreateDeckBottomSheetFragment createDeckBottomSheetFragment, List list, EditText editText, LinearLayout linearLayout, ConstraintLayout constraintLayout, View view, LinearLayout linearLayout2, TextView textView2, EditText editText2, LinearLayout linearLayout3, LinearLayout linearLayout4, MenuItem menuItem) {
        Object next;
        if (menuItem.getItemId() == -1) {
            popupMenu.show();
            return true;
        }
        textView.setText(menuItem.getTitle());
        textView.setTextColor(ContextCompat.getColor(createDeckBottomSheetFragment.requireContext(), R.color.almost_white));
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((MTFormat) next).getId() == menuItem.getItemId()) {
                break;
            }
        }
        createDeckBottomSheetFragment.format = (MTFormat) next;
        editText.setVisibility(0);
        linearLayout.setVisibility(0);
        constraintLayout.setVisibility(0);
        View viewFindViewById = view.findViewById(R.id.bracketLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById;
        constraintLayout2.setVisibility(8);
        MTFormat mTFormat = createDeckBottomSheetFragment.format;
        if (mTFormat != null) {
            if (Intrinsics.areEqual(mTFormat.getScryfallid(), "commander")) {
                constraintLayout2.setVisibility(0);
            }
            if (mTFormat.getHascommander()) {
                linearLayout2.setVisibility(0);
                if (createDeckBottomSheetFragment.commander != null) {
                    textView2.setVisibility(0);
                }
                if (Intrinsics.areEqual(mTFormat.getScryfallid(), "oathbreaker")) {
                    editText2.setHint(createDeckBottomSheetFragment.getString(R.string.oathbreaker_hint));
                } else {
                    editText2.setHint(createDeckBottomSheetFragment.getString(R.string.commander_hint));
                }
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                }
            } else {
                linearLayout2.setVisibility(8);
                textView2.setVisibility(8);
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(0);
                }
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(0);
                }
            }
            createDeckBottomSheetFragment.updateSubmitButtonState();
        }
        return true;
    }

    static final Unit onViewCreated$lambda$28(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, PopupMenu popupMenu) {
        MTDeck mTDeck;
        MTStats stats;
        if (createDeckBottomSheetFragment.guestMode || createDeckBottomSheetFragment.tempMode) {
            return Unit.INSTANCE;
        }
        if (!createDeckBottomSheetFragment.editMode || (mTDeck = createDeckBottomSheetFragment.deck) == null || mTDeck == null || (stats = mTDeck.getStats()) == null || stats.getGames() <= 0) {
            popupMenu.show();
            return Unit.INSTANCE;
        }
        Toast.makeText(createDeckBottomSheetFragment.requireContext(), createDeckBottomSheetFragment.getString(R.string.deck_has_games), 1).show();
        return Unit.INSTANCE;
    }

    static final void onViewCreated$lambda$29(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, CheckBox checkBox, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        createDeckBottomSheetFragment.shouldImport = z;
        checkBox.setVisibility(8);
        checkBox.setChecked(false);
        createDeckBottomSheetFragment.shouldAutoSync = false;
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [T, java.util.List] */
    static final Unit onViewCreated$lambda$3(final CreateDeckBottomSheetFragment createDeckBottomSheetFragment, final View view, final List list) {
        Intrinsics.checkNotNull(list);
        List list2 = list;
        Log.d(TAG, "Searching on scryfall (commander) : count = " + list2.size());
        Log.d(TAG, "Searching on scryfall (commander) : results = " + list);
        if (list2.isEmpty()) {
            createDeckBottomSheetFragment.currentOnlineCommanderCards = new ArrayList();
        } else {
            Log.d(TAG, "--> Current local count (commander) = " + createDeckBottomSheetFragment.currentLocalCommanderCards.size());
            Log.d(TAG, "--> Current local cards (commander) = " + createDeckBottomSheetFragment.currentLocalCommanderCards);
            createDeckBottomSheetFragment.currentOnlineCommanderCards = CollectionsKt.toMutableList((Collection) list2);
            List list3 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(((MTGCardRecord) it.next()).getTitle());
            }
            ArrayList<String> arrayList2 = arrayList;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            List<MTGCardRecord> list4 = createDeckBottomSheetFragment.currentLocalCommanderCards;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator<T> it2 = list4.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((MTGCardRecord) it2.next()).getTitle());
            }
            objectRef.element = CollectionsKt.toMutableList((Collection) arrayList3);
            for (String str : arrayList2) {
                if (!((List) objectRef.element).contains(str)) {
                    ((List) objectRef.element).add(str);
                }
            }
            Log.d(TAG, "TOTAL suggestions count (commander) = " + ((Collection) objectRef.element).size());
            PopupWindow popupWindow = createDeckBottomSheetFragment.commanderPopupWindow;
            if (popupWindow != null) {
                Log.d(TAG, "Popup menu already up, updating... (commander)");
                ListView listView = (ListView) popupWindow.getContentView().findViewById(R.id.suggestions_list);
                listView.setAdapter((ListAdapter) new ArrayAdapter(createDeckBottomSheetFragment.requireContext(), android.R.layout.simple_list_item_1, (List) objectRef.element));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda33
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                        CreateDeckBottomSheetFragment.onViewCreated$lambda$3$2$0(objectRef, createDeckBottomSheetFragment, view, adapterView, view2, i, j);
                    }
                });
            } else {
                Log.d(TAG, "Creating new popup menu (commander)");
                final EditText editText = view != null ? (EditText) view.findViewById(R.id.commanderEditText) : null;
                if (editText != null) {
                    Object systemService = createDeckBottomSheetFragment.requireContext().getSystemService("layout_inflater");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                    View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.popup_suggestions, (ViewGroup) null);
                    createDeckBottomSheetFragment.commanderPopupWindow = new PopupWindow(viewInflate, -2, -2, true);
                    ListView listView2 = (ListView) viewInflate.findViewById(R.id.suggestions_list);
                    listView2.setAdapter((ListAdapter) new ArrayAdapter(createDeckBottomSheetFragment.requireContext(), android.R.layout.simple_list_item_1, (List) objectRef.element));
                    final EditText editText2 = editText;
                    listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda44
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                            CreateDeckBottomSheetFragment.onViewCreated$lambda$3$3$0$0(list, createDeckBottomSheetFragment, editText, createDeckBottomSheetFragment, editText2, view, adapterView, view2, i, j);
                        }
                    });
                    PopupWindow popupWindow2 = createDeckBottomSheetFragment.commanderPopupWindow;
                    if (popupWindow2 != null) {
                        popupWindow2.setOutsideTouchable(true);
                    }
                    PopupWindow popupWindow3 = createDeckBottomSheetFragment.commanderPopupWindow;
                    if (popupWindow3 != null) {
                        popupWindow3.setFocusable(false);
                    }
                    PopupWindow popupWindow4 = createDeckBottomSheetFragment.commanderPopupWindow;
                    if (popupWindow4 != null) {
                        int[] iArr = new int[2];
                        editText.getLocationOnScreen(iArr);
                        View contentView = popupWindow4.getContentView();
                        contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        Size size = new Size(contentView.getMeasuredWidth(), contentView.getMeasuredHeight() * ((List) objectRef.element).size());
                        int height = iArr[1] - editText.getHeight();
                        if (size.getHeight() > height) {
                            popupWindow4.setHeight(height);
                            size = new Size(popupWindow4.getContentView().getMeasuredWidth(), height);
                        }
                        if (size.getHeight() > 0) {
                            popupWindow4.setHeight(size.getHeight());
                        }
                        popupWindow4.showAtLocation(editText, 8388659, iArr[0], iArr[1] - size.getHeight());
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$2$0(Ref.ObjectRef objectRef, CreateDeckBottomSheetFragment createDeckBottomSheetFragment, View view, AdapterView adapterView, View view2, int i, long j) {
        Object next;
        String str = (String) ((List) objectRef.element).get(i);
        Iterator<T> it = createDeckBottomSheetFragment.currentLocalCommanderCards.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((MTGCardRecord) next).getTitle(), str)) {
                    break;
                }
            }
        }
        if (next == null) {
            Iterator<T> it2 = createDeckBottomSheetFragment.currentOnlineCommanderCards.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    if (Intrinsics.areEqual(((MTGCardRecord) next).getTitle(), str)) {
                        break;
                    }
                }
            }
        }
        MTGCardRecord mTGCardRecord = (MTGCardRecord) next;
        if (mTGCardRecord != null) {
            EditText editText = view != null ? (EditText) view.findViewById(R.id.commanderEditText) : null;
            if (editText != null) {
                createDeckBottomSheetFragment.commanderLang = mTGCardRecord.getLang();
                createDeckBottomSheetFragment.lastCommanderQuery = mTGCardRecord.getTitle();
                editText.setText(mTGCardRecord.getTitle());
                String scryfallId = mTGCardRecord.getScryfallId();
                if (scryfallId.length() <= 0) {
                    scryfallId = null;
                }
                if (scryfallId == null) {
                    GameUtils companion = GameUtils.INSTANCE.getInstance();
                    Context contextRequireContext = createDeckBottomSheetFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    scryfallId = companion.getFirstPrintScryfallId(contextRequireContext, mTGCardRecord);
                }
                if (scryfallId != null) {
                    mTGCardRecord.setScryfallId(scryfallId);
                    createDeckBottomSheetFragment.commander = scryfallId;
                    createDeckBottomSheetFragment.applyMTCardId(mTGCardRecord, "commander");
                    editText.setBackground(createDeckBottomSheetFragment.requireContext().getResources().getDrawable(R.drawable.black_box_valid, null));
                    editText.clearFocus();
                    createDeckBottomSheetFragment.updatePlaymatPreview();
                    createDeckBottomSheetFragment.updateSubmitButtonState();
                    TextView textView = view != null ? (TextView) view.findViewById(R.id.commanderTapToChange) : null;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                }
                createDeckBottomSheetFragment.acceptCommanderCard(mTGCardRecord);
                Object systemService = createDeckBottomSheetFragment.requireActivity().getSystemService("input_method");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                PopupWindow popupWindow = createDeckBottomSheetFragment.commanderPopupWindow;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$3$0$0(List list, CreateDeckBottomSheetFragment createDeckBottomSheetFragment, EditText editText, CreateDeckBottomSheetFragment createDeckBottomSheetFragment2, EditText editText2, View view, AdapterView adapterView, View view2, int i, long j) {
        MTGCardRecord mTGCardRecord = (MTGCardRecord) list.get(i);
        createDeckBottomSheetFragment.commanderLang = mTGCardRecord.getLang();
        createDeckBottomSheetFragment.lastCommanderQuery = mTGCardRecord.getTitle();
        editText.setText(mTGCardRecord.getTitle());
        String scryfallId = mTGCardRecord.getScryfallId();
        if (scryfallId.length() <= 0) {
            scryfallId = null;
        }
        if (scryfallId == null) {
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = createDeckBottomSheetFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            scryfallId = companion.getFirstPrintScryfallId(contextRequireContext, mTGCardRecord);
        }
        if (scryfallId != null) {
            mTGCardRecord.setScryfallId(scryfallId);
            createDeckBottomSheetFragment2.commander = scryfallId;
            createDeckBottomSheetFragment.applyMTCardId(mTGCardRecord, "commander");
            editText2.setBackground(createDeckBottomSheetFragment.requireContext().getResources().getDrawable(R.drawable.black_box_valid, null));
            editText2.clearFocus();
            createDeckBottomSheetFragment2.updatePlaymatPreview();
            createDeckBottomSheetFragment2.updateSubmitButtonState();
            TextView textView = view != null ? (TextView) view.findViewById(R.id.commanderTapToChange) : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
        createDeckBottomSheetFragment2.acceptCommanderCard(mTGCardRecord);
        Object systemService = createDeckBottomSheetFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText2.getWindowToken(), 0);
        PopupWindow popupWindow = createDeckBottomSheetFragment2.commanderPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    static final void onViewCreated$lambda$30(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        createDeckBottomSheetFragment.shouldAutoSync = z;
    }

    static final Unit onViewCreated$lambda$31(CreateDeckBottomSheetFragment createDeckBottomSheetFragment) {
        createDeckBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$32(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, View view) {
        String str;
        boolean z;
        MTCreateDeckPrivacy mTCreateDeckPrivacy;
        MTUser mTUser;
        MTUser mTUser2;
        MTUser mTUser3;
        MTUser mTUser4;
        int i;
        if (createDeckBottomSheetFragment.getContext() != null && createDeckBottomSheetFragment.deckName.length() != 0) {
            ((ConstraintLayout) view.findViewById(R.id.overlay)).setVisibility(0);
            Ref.IntRef intRef = new Ref.IntRef();
            MTUser mTUser5 = createDeckBottomSheetFragment.user;
            if (mTUser5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
                mTUser5 = null;
            }
            intRef.element = mTUser5.getId();
            if (createDeckBottomSheetFragment.tempMode && (i = createDeckBottomSheetFragment.userIdForTemp) > 0) {
                intRef.element = i;
            }
            Boolean boolValueOf = (!createDeckBottomSheetFragment.editMode && createDeckBottomSheetFragment.isValidDeckUrl(createDeckBottomSheetFragment.externalUrl)) ? Boolean.valueOf(createDeckBottomSheetFragment.shouldImport) : null;
            MTFormat mTFormat = createDeckBottomSheetFragment.format;
            int id = mTFormat != null ? mTFormat.getId() : 6;
            String str2 = createDeckBottomSheetFragment.deckName;
            int i2 = createDeckBottomSheetFragment.deckType;
            String str3 = createDeckBottomSheetFragment.selectedColors;
            String str4 = createDeckBottomSheetFragment.commander;
            String str5 = createDeckBottomSheetFragment.partner;
            String str6 = createDeckBottomSheetFragment.signaturespell;
            String str7 = createDeckBottomSheetFragment.partnersignaturespell;
            String str8 = createDeckBottomSheetFragment.leftplaymatCardId != null ? null : createDeckBottomSheetFragment.leftplaymat;
            String str9 = createDeckBottomSheetFragment.rightplaymatCardId != null ? null : createDeckBottomSheetFragment.rightplaymat;
            String str10 = createDeckBottomSheetFragment.externalUrl;
            Boolean boolValueOf2 = Boolean.valueOf(createDeckBottomSheetFragment.guestMode);
            Integer numValueOf = Integer.valueOf(intRef.element);
            Integer num = createDeckBottomSheetFragment.bracket;
            String str11 = createDeckBottomSheetFragment.commanderColorOverride;
            String str12 = createDeckBottomSheetFragment.partnerColorOverride;
            String str13 = createDeckBottomSheetFragment.commanderCardId;
            String str14 = createDeckBottomSheetFragment.partnerCardId;
            String str15 = createDeckBottomSheetFragment.signatureSpellCardId;
            String str16 = createDeckBottomSheetFragment.partnerSignatureSpellCardId;
            String str17 = createDeckBottomSheetFragment.leftplaymatCardId;
            String str18 = createDeckBottomSheetFragment.rightplaymatCardId;
            Integer num2 = createDeckBottomSheetFragment.leftplaymatFaceIndex;
            Integer num3 = createDeckBottomSheetFragment.rightplaymatFaceIndex;
            if (createDeckBottomSheetFragment.editMode) {
                str = str5;
                z = true;
                mTCreateDeckPrivacy = null;
            } else {
                z = true;
                str = str5;
                mTCreateDeckPrivacy = new MTCreateDeckPrivacy(createDeckBottomSheetFragment.selectedPrivacyType, null, new MTDeckPrivacyOptions(true, false), 2, null);
            }
            boolean z2 = z;
            MTCreateDeck mTCreateDeck = new MTCreateDeck(null, id, str2, i2, str3, "", str4, boolValueOf, str, str6, str7, str8, str9, false, str10, boolValueOf2, numValueOf, num, str11, str12, str13, str14, str15, str16, null, str17, str18, num2, num3, null, null, null, null, mTCreateDeckPrivacy, -520093696, 1, null);
            if (createDeckBottomSheetFragment.editMode) {
                MTApi mtApi = MTApiKt.getMtApi();
                MTUser mTUser6 = createDeckBottomSheetFragment.user;
                if (mTUser6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("user");
                    mTUser4 = null;
                } else {
                    mTUser4 = mTUser6;
                }
                int id2 = mTUser4.getId();
                MTDeck mTDeck = createDeckBottomSheetFragment.deck;
                mtApi.editDeck(id2, mTDeck != null ? mTDeck.getId() : -1, mTCreateDeck).enqueue(new CreateDeckBottomSheetFragment$onViewCreated$38$1(createDeckBottomSheetFragment, view));
            } else if (createDeckBottomSheetFragment.guestMode) {
                MTApi mtApi2 = MTApiKt.getMtApi();
                MTUser mTUser7 = createDeckBottomSheetFragment.user;
                if (mTUser7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("user");
                    mTUser3 = null;
                } else {
                    mTUser3 = mTUser7;
                }
                mtApi2.createGhostDeck(mTUser3.getId(), z2, mTCreateDeck).enqueue(new CreateDeckBottomSheetFragment$onViewCreated$38$2(createDeckBottomSheetFragment, view));
            } else if (createDeckBottomSheetFragment.tempMode) {
                MTApi mtApi3 = MTApiKt.getMtApi();
                MTUser mTUser8 = createDeckBottomSheetFragment.user;
                if (mTUser8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("user");
                    mTUser2 = null;
                } else {
                    mTUser2 = mTUser8;
                }
                mtApi3.createTempDeck(mTUser2.getId(), mTCreateDeck).enqueue(new CreateDeckBottomSheetFragment$onViewCreated$38$3(createDeckBottomSheetFragment, view, intRef));
            } else {
                MTApi mtApi4 = MTApiKt.getMtApi();
                MTUser mTUser9 = createDeckBottomSheetFragment.user;
                if (mTUser9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("user");
                    mTUser = null;
                } else {
                    mTUser = mTUser9;
                }
                mtApi4.createDeck(mTUser.getId(), mTCreateDeck).enqueue(new CreateDeckBottomSheetFragment$onViewCreated$38$4(createDeckBottomSheetFragment, view));
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$35$2$1$0(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, EditText editText, TextView textView, View view, CardRecord cardRecord) {
        if (cardRecord != null) {
            createDeckBottomSheetFragment.lastCommanderQuery = cardRecord.getTitle();
            editText.setText(cardRecord.getTitle());
            editText.setBackground(createDeckBottomSheetFragment.requireContext().getResources().getDrawable(R.drawable.black_box_valid, null));
            editText.clearFocus();
            textView.setVisibility(0);
            if (GameUtilsKt.getColorChoosingCommanders().contains(cardRecord.getOracle_id())) {
                createDeckBottomSheetFragment.commanderIsColorChoosing = true;
                ((LinearLayout) view.findViewById(R.id.commanderColorOverrideLayout)).setVisibility(0);
                createDeckBottomSheetFragment.applyOverridePipState(view, true, createDeckBottomSheetFragment.commanderColorOverride);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$35$2$2$0(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, EditText editText, View view, TextView textView, CardRecord cardRecord) {
        if (cardRecord != null) {
            createDeckBottomSheetFragment.lastPartnerQuery = cardRecord.getTitle();
            editText.setText(cardRecord.getTitle());
            editText.setBackground(createDeckBottomSheetFragment.requireContext().getResources().getDrawable(R.drawable.black_box_valid, null));
            editText.clearFocus();
            ((LinearLayout) view.findViewById(R.id.partnerLayout)).setVisibility(0);
            textView.setVisibility(0);
            if (GameUtilsKt.getColorChoosingCommanders().contains(cardRecord.getOracle_id())) {
                createDeckBottomSheetFragment.partnerIsColorChoosing = true;
                ((LinearLayout) view.findViewById(R.id.partnerColorOverrideLayout)).setVisibility(0);
                createDeckBottomSheetFragment.applyOverridePipState(view, false, createDeckBottomSheetFragment.partnerColorOverride);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$35$2$3$0(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, EditText editText, View view, TextView textView, CardRecord cardRecord) {
        if (cardRecord != null) {
            createDeckBottomSheetFragment.lastPartnerQuery = cardRecord.getTitle();
            editText.setText(cardRecord.getTitle());
            editText.setBackground(createDeckBottomSheetFragment.requireContext().getResources().getDrawable(R.drawable.black_box_valid, null));
            editText.clearFocus();
            ((LinearLayout) view.findViewById(R.id.partnerLayout)).setVisibility(0);
            textView.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$35$2$4$0(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, EditText editText, TextView textView, CardRecord cardRecord) {
        if (cardRecord != null) {
            createDeckBottomSheetFragment.lastPlaymatCardQuery = cardRecord.getTitle();
            editText.setText(cardRecord.getTitle());
            editText.clearFocus();
            textView.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$35$2$5$0(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, String str, CheckBox checkBox, TextView textView, CheckBox checkBox2) {
        if (createDeckBottomSheetFragment.isValidDeckUrl(str)) {
            checkBox.setVisibility(8);
            checkBox.setChecked(false);
            createDeckBottomSheetFragment.shouldImport = false;
            textView.setVisibility(8);
            checkBox2.setVisibility(8);
            checkBox2.setChecked(false);
            createDeckBottomSheetFragment.shouldAutoSync = false;
        }
    }

    static final Unit onViewCreated$lambda$4(final CreateDeckBottomSheetFragment createDeckBottomSheetFragment) {
        if (createDeckBottomSheetFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        BracketDialogFragment.Builder builder = new BracketDialogFragment.Builder();
        MTDeck mTDeck = createDeckBottomSheetFragment.deck;
        BracketDialogFragment.Builder initialUserBracket = builder.setBracketInfo(mTDeck != null ? mTDeck.getBracket() : null).setInitialUserBracket(createDeckBottomSheetFragment.bracket);
        MTDeck mTDeck2 = createDeckBottomSheetFragment.deck;
        BracketDialogFragment.Builder onCloseCallback = initialUserBracket.setDeckId(mTDeck2 != null ? Integer.valueOf(mTDeck2.getId()) : null).setOnCloseCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda51
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$4$0(this.f$0, (Integer) obj);
            }
        });
        FragmentManager childFragmentManager = createDeckBottomSheetFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        onCloseCallback.show(childFragmentManager, "BracketDialogFragment");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$4$0(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, Integer num) {
        createDeckBottomSheetFragment.bracket = num;
        createDeckBottomSheetFragment.updateBracketSelection();
        return Unit.INSTANCE;
    }

    static final void onViewCreated$lambda$5(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, EditText editText, View view) {
        if (createDeckBottomSheetFragment.getContext() == null) {
            return;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = createDeckBottomSheetFragment.cardSearchLauncher;
        if (activityResultLauncher == null) {
            Log.e(TAG, "cardSearchLauncher not initialized - fragment may have been recreated");
            Toast.makeText(createDeckBottomSheetFragment.requireContext(), createDeckBottomSheetFragment.getString(R.string.server_error), 0).show();
            createDeckBottomSheetFragment.dismiss();
            return;
        }
        String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(editText.getText().toString(), ",", "", false, 4, (Object) null), "-", "", false, 4, (Object) null), "\"", "", false, 4, (Object) null), "&", "", false, 4, (Object) null);
        createDeckBottomSheetFragment.updatingCommander = true;
        Intent intent = new Intent(createDeckBottomSheetFragment.requireContext(), (Class<?>) SearchActivity.class);
        intent.putExtra("pickACardMode", true);
        intent.putExtra("condense", false);
        intent.putExtra(SearchIntents.EXTRA_QUERY, strReplace$default);
        intent.putExtra("lang", createDeckBottomSheetFragment.commanderLang);
        activityResultLauncher.launch(intent);
    }

    static final void onViewCreated$lambda$6(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, View view) {
        if (createDeckBottomSheetFragment.getContext() == null) {
            return;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = createDeckBottomSheetFragment.pickCardLauncher;
        if (activityResultLauncher != null) {
            createDeckBottomSheetFragment.updatingCommander = true;
            activityResultLauncher.launch(new Intent(createDeckBottomSheetFragment.requireContext(), (Class<?>) PickACardActivity.class));
        } else {
            Log.e(TAG, "pickCardLauncher not initialized - fragment may have been recreated");
            Toast.makeText(createDeckBottomSheetFragment.requireContext(), createDeckBottomSheetFragment.getString(R.string.server_error), 0).show();
            createDeckBottomSheetFragment.dismiss();
        }
    }

    static final boolean onViewCreated$lambda$7(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        Object systemService = createDeckBottomSheetFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
        return true;
    }

    static final boolean onViewCreated$lambda$8(EditText editText, CreateDeckBottomSheetFragment createDeckBottomSheetFragment, View view, View view2, MotionEvent motionEvent) {
        LinearLayout linearLayout;
        if (motionEvent.getAction() != 1 || editText.getCompoundDrawables()[2] == null || motionEvent.getRawX() < editText.getRight() - (editText.getCompoundDrawables()[2].getBounds().width() * 2.0f)) {
            return false;
        }
        if (createDeckBottomSheetFragment.getContext() == null) {
            return true;
        }
        editText.setText("");
        createDeckBottomSheetFragment.commander = null;
        createDeckBottomSheetFragment.rightplaymat = null;
        createDeckBottomSheetFragment.commanderCardId = null;
        createDeckBottomSheetFragment.rightplaymatCardId = null;
        createDeckBottomSheetFragment.rightplaymatFaceIndex = null;
        createDeckBottomSheetFragment.rightPlaymatPreviewUrl = null;
        createDeckBottomSheetFragment.commanderIdentity.clear();
        createDeckBottomSheetFragment.commanderColorOverride = null;
        createDeckBottomSheetFragment.commanderIsColorChoosing = false;
        if (view != null && (linearLayout = (LinearLayout) view.findViewById(R.id.commanderColorOverrideLayout)) != null) {
            linearLayout.setVisibility(8);
        }
        createDeckBottomSheetFragment.refreshDisplayColorIdentity();
        createDeckBottomSheetFragment.updateSubmitButtonState();
        editText.requestFocus();
        Object systemService = createDeckBottomSheetFragment.requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        return true;
    }

    static final void onViewCreated$lambda$9(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, EditText editText, View view) {
        if (createDeckBottomSheetFragment.getContext() == null) {
            return;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = createDeckBottomSheetFragment.cardSearchLauncher;
        if (activityResultLauncher == null) {
            Log.e(TAG, "cardSearchLauncher not initialized - fragment may have been recreated");
            Toast.makeText(createDeckBottomSheetFragment.requireContext(), createDeckBottomSheetFragment.getString(R.string.server_error), 0).show();
            createDeckBottomSheetFragment.dismiss();
            return;
        }
        String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(editText.getText().toString(), ",", "", false, 4, (Object) null), "-", "", false, 4, (Object) null), "\"", "", false, 4, (Object) null), "&", "", false, 4, (Object) null);
        createDeckBottomSheetFragment.updatingCommander = true;
        Intent intent = new Intent(createDeckBottomSheetFragment.requireContext(), (Class<?>) SearchActivity.class);
        intent.putExtra("pickACardMode", true);
        intent.putExtra("condense", false);
        intent.putExtra("forceLocalDb", true);
        intent.putExtra("lang", createDeckBottomSheetFragment.commanderLang);
        intent.putExtra(SearchIntents.EXTRA_QUERY, strReplace$default);
        activityResultLauncher.launch(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performCommanderSearch(String str, Continuation<? super Unit> continuation) {
        if (getContext() == null) {
            return Unit.INSTANCE;
        }
        String str2 = str;
        if (StringsKt.trim((CharSequence) str2).toString().length() == 0) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda49
                    @Override // java.lang.Runnable
                    public final void run() {
                        CreateDeckBottomSheetFragment.performCommanderSearch$lambda$0(this.f$0);
                    }
                });
            }
            return Unit.INSTANCE;
        }
        JobKt.ensureActive(GlobalScope.INSTANCE.getCoroutineContext());
        if (StringsKt.trim((CharSequence) str2).toString().length() >= 2) {
            Log.d(TAG, "------ NEW SEARCH : " + str);
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass3(str, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    static final void performCommanderSearch$lambda$0(CreateDeckBottomSheetFragment createDeckBottomSheetFragment) {
        if (createDeckBottomSheetFragment.getContext() == null) {
            return;
        }
        Log.d(TAG, "!!! Empty QUERY !!!");
        createDeckBottomSheetFragment.currentOnlineCommanderCards = new ArrayList();
        createDeckBottomSheetFragment.currentLocalCommanderCards = new ArrayList();
        View view = createDeckBottomSheetFragment.getView();
        EditText editText = view != null ? (EditText) view.findViewById(R.id.commanderEditText) : null;
        if (editText != null) {
            editText.setBackground(ContextCompat.getDrawable(createDeckBottomSheetFragment.requireContext(), R.drawable.black_box_not_ok));
            PopupWindow popupWindow = createDeckBottomSheetFragment.commanderPopupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
                createDeckBottomSheetFragment.commanderPopupWindow = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performPartnerSearch(String str, Continuation<? super Unit> continuation) {
        FragmentActivity activity;
        if (getContext() == null) {
            return Unit.INSTANCE;
        }
        String str2 = str;
        if (StringsKt.trim((CharSequence) str2).toString().length() == 0 && (activity = getActivity()) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda47
                @Override // java.lang.Runnable
                public final void run() {
                    CreateDeckBottomSheetFragment.performPartnerSearch$lambda$0(this.f$0);
                }
            });
        }
        JobKt.ensureActive(GlobalScope.INSTANCE.getCoroutineContext());
        if (StringsKt.trim((CharSequence) str2).toString().length() >= 2) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C11423(str, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    static final void performPartnerSearch$lambda$0(CreateDeckBottomSheetFragment createDeckBottomSheetFragment) {
        if (createDeckBottomSheetFragment.getContext() == null) {
            return;
        }
        createDeckBottomSheetFragment.currentLocalPartnerCards = new ArrayList();
        createDeckBottomSheetFragment.currentOnlinePartnerCards = new ArrayList();
        View view = createDeckBottomSheetFragment.getView();
        EditText editText = view != null ? (EditText) view.findViewById(R.id.partnerEditText) : null;
        if (editText != null) {
            editText.setBackground(ContextCompat.getDrawable(createDeckBottomSheetFragment.requireContext(), R.drawable.black_box_not_ok));
            PopupWindow popupWindow = createDeckBottomSheetFragment.partnerPopupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
                createDeckBottomSheetFragment.partnerPopupWindow = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performPlaymatCardSearch(String str, Continuation<? super Unit> continuation) {
        FragmentActivity activity;
        if (getContext() == null) {
            return Unit.INSTANCE;
        }
        String str2 = str;
        if (StringsKt.trim((CharSequence) str2).toString().length() == 0 && (activity = getActivity()) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda50
                @Override // java.lang.Runnable
                public final void run() {
                    CreateDeckBottomSheetFragment.performPlaymatCardSearch$lambda$0(this.f$0);
                }
            });
        }
        JobKt.ensureActive(GlobalScope.INSTANCE.getCoroutineContext());
        if (StringsKt.trim((CharSequence) str2).toString().length() >= 2) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C11433(str, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    static final void performPlaymatCardSearch$lambda$0(CreateDeckBottomSheetFragment createDeckBottomSheetFragment) {
        PopupWindow popupWindow;
        if (createDeckBottomSheetFragment.getContext() == null) {
            return;
        }
        createDeckBottomSheetFragment.currentLocalPlaymatCards = new ArrayList();
        createDeckBottomSheetFragment.currentOnlinePlaymatCards = new ArrayList();
        View view = createDeckBottomSheetFragment.getView();
        if ((view != null ? (EditText) view.findViewById(R.id.playmatCardEditText) : null) == null || (popupWindow = createDeckBottomSheetFragment.playmatCardPopupWindow) == null) {
            return;
        }
        popupWindow.dismiss();
        createDeckBottomSheetFragment.playmatCardPopupWindow = null;
    }

    private final void refreshDisplayColorIdentity() {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        for (String str3 : this.commanderIdentity) {
            if (!arrayList.contains(str3) && str3.length() > 0) {
                arrayList.add(str3);
            }
        }
        for (String str4 : this.partnerIdentity) {
            if (!arrayList.contains(str4) && str4.length() > 0) {
                arrayList.add(str4);
            }
        }
        if (this.commanderIsColorChoosing && (str2 = this.commanderColorOverride) != null && str2.length() != 0 && !CollectionsKt.contains(arrayList, this.commanderColorOverride)) {
            String str5 = this.commanderColorOverride;
            Intrinsics.checkNotNull(str5);
            arrayList.add(str5);
        }
        if (this.partnerIsColorChoosing && (str = this.partnerColorOverride) != null && str.length() != 0 && !CollectionsKt.contains(arrayList, this.partnerColorOverride)) {
            String str6 = this.partnerColorOverride;
            Intrinsics.checkNotNull(str6);
            arrayList.add(str6);
        }
        displayColorIdentity(CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null));
    }

    private final void setupColorSelection(final View view) {
        final ImageView imageView = (ImageView) view.findViewById(R.id.w_color);
        final ImageView imageView2 = (ImageView) view.findViewById(R.id.u_color);
        final ImageView imageView3 = (ImageView) view.findViewById(R.id.b_color);
        final ImageView imageView4 = (ImageView) view.findViewById(R.id.r_color);
        final ImageView imageView5 = (ImageView) view.findViewById(R.id.g_color);
        final ImageView imageView6 = (ImageView) view.findViewById(R.id.c_color);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateDeckBottomSheetFragment.setupColorSelection$lambda$0(imageView, imageView2, imageView3, imageView4, imageView5, this, imageView6, view, view2);
            }
        };
        imageView.setOnClickListener(onClickListener);
        imageView2.setOnClickListener(onClickListener);
        imageView3.setOnClickListener(onClickListener);
        imageView4.setOnClickListener(onClickListener);
        imageView5.setOnClickListener(onClickListener);
        imageView6.setOnClickListener(onClickListener);
    }

    static final void setupColorSelection$lambda$0(ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, CreateDeckBottomSheetFragment createDeckBottomSheetFragment, ImageView imageView6, View view, View view2) {
        String str;
        String str2;
        String strReplace$default = null;
        if (view2.getId() == R.id.c_color) {
            imageView.setAlpha(0.25f);
            imageView2.setAlpha(0.25f);
            imageView3.setAlpha(0.25f);
            imageView4.setAlpha(0.25f);
            imageView5.setAlpha(0.25f);
            String str3 = createDeckBottomSheetFragment.selectedColors;
            if (str3 != null) {
                Intrinsics.checkNotNull(str3);
                if (str3.length() == 0) {
                    createDeckBottomSheetFragment.selectedColors = null;
                    imageView6.setAlpha(0.25f);
                } else {
                    createDeckBottomSheetFragment.selectedColors = "";
                    imageView6.setAlpha(1.0f);
                }
            } else {
                createDeckBottomSheetFragment.selectedColors = "";
                imageView6.setAlpha(1.0f);
            }
        } else {
            int id = view2.getId();
            if (id == R.id.w_color) {
                str = ExifInterface.LONGITUDE_WEST;
            } else if (id == R.id.u_color) {
                str = "U";
            } else if (id == R.id.b_color) {
                str = "B";
            } else if (id == R.id.r_color) {
                str = "R";
            } else if (id != R.id.g_color) {
                return;
            } else {
                str = GameUtils.CONDITION_GOOD;
            }
            String str4 = str;
            String str5 = createDeckBottomSheetFragment.selectedColors;
            if (str5 == null) {
                createDeckBottomSheetFragment.selectedColors = str4;
                imageView6.setAlpha(0.25f);
                view2.setAlpha(1.0f);
            } else if (StringsKt.contains$default((CharSequence) str5, (CharSequence) str4, false, 2, (Object) null)) {
                if (str5.length() != 1 && (str2 = createDeckBottomSheetFragment.selectedColors) != null) {
                    strReplace$default = StringsKt.replace$default(str2, str4, "", false, 4, (Object) null);
                }
                createDeckBottomSheetFragment.selectedColors = strReplace$default;
                view2.setAlpha(0.25f);
            } else {
                createDeckBottomSheetFragment.selectedColors += str4;
                imageView6.setAlpha(0.25f);
                view2.setAlpha(1.0f);
            }
        }
        String str6 = createDeckBottomSheetFragment.selectedColors;
        if (str6 != null) {
            createDeckBottomSheetFragment.displayColorIdentity(str6);
        } else {
            ((LinearLayout) view.findViewById(R.id.manaLayout)).setVisibility(4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setupCommanderPartnerColorOverridePickers(final View view) {
        final int i = 0;
        List listListOf = CollectionsKt.listOf((Object[]) new ImageView[]{view.findViewById(R.id.commander_color_w), view.findViewById(R.id.commander_color_u), view.findViewById(R.id.commander_color_b), view.findViewById(R.id.commander_color_r), view.findViewById(R.id.commander_color_g)});
        List listListOf2 = CollectionsKt.listOf((Object[]) new ImageView[]{view.findViewById(R.id.partner_color_w), view.findViewById(R.id.partner_color_u), view.findViewById(R.id.partner_color_b), view.findViewById(R.id.partner_color_r), view.findViewById(R.id.partner_color_g)});
        final List listListOf3 = CollectionsKt.listOf((Object[]) new String[]{ExifInterface.LONGITUDE_WEST, "U", "B", "R", GameUtils.CONDITION_GOOD});
        final int i2 = 0;
        for (Object obj : listListOf) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((ImageView) obj).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CreateDeckBottomSheetFragment.setupCommanderPartnerColorOverridePickers$lambda$0$0(this.f$0, listListOf3, i2, view, view2);
                }
            });
            i2 = i3;
        }
        for (Object obj2 : listListOf2) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((ImageView) obj2).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CreateDeckBottomSheetFragment.setupCommanderPartnerColorOverridePickers$lambda$1$0(this.f$0, listListOf3, i, view, view2);
                }
            });
            i = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCommanderPartnerColorOverridePickers$lambda$0$0(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, List list, int i, View view, View view2) {
        String str = (String) list.get(i);
        createDeckBottomSheetFragment.commanderColorOverride = str;
        createDeckBottomSheetFragment.applyOverridePipState(view, true, str);
        createDeckBottomSheetFragment.refreshDisplayColorIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCommanderPartnerColorOverridePickers$lambda$1$0(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, List list, int i, View view, View view2) {
        String str = (String) list.get(i);
        createDeckBottomSheetFragment.partnerColorOverride = str;
        createDeckBottomSheetFragment.applyOverridePipState(view, false, str);
        createDeckBottomSheetFragment.refreshDisplayColorIdentity();
    }

    private final void updateBracketSelection() {
        MTBracket bracket;
        Integer auto;
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.bracketValueTextView) : null;
        View view2 = getView();
        TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.bracketNameTextView) : null;
        View view3 = getView();
        ConstraintLayout constraintLayout = view3 != null ? (ConstraintLayout) view3.findViewById(R.id.autoBracketIconLayout) : null;
        Integer num = this.bracket;
        if (num != null) {
            if (textView != null) {
                textView.setText(String.valueOf(num.intValue()));
            }
            if (textView2 != null) {
                int iIntValue = num.intValue();
                textView2.setText(iIntValue != 1 ? iIntValue != 2 ? iIntValue != 3 ? iIntValue != 4 ? iIntValue != 5 ? getString(R.string.bracket_caps) : getString(R.string.cedh_caps) : getString(R.string.optimized_caps) : getString(R.string.upgraded_caps) : getString(R.string.core_caps) : getString(R.string.exhibition_caps));
            }
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
                return;
            }
            return;
        }
        MTDeck mTDeck = this.deck;
        if (mTDeck == null || (bracket = mTDeck.getBracket()) == null || (auto = bracket.getAuto()) == null) {
            if (textView != null) {
                textView.setText("?");
            }
            if (textView2 != null) {
                textView2.setText(getString(R.string.bracket_caps));
            }
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
                return;
            }
            return;
        }
        int iIntValue2 = auto.intValue();
        if (textView != null) {
            textView.setText(String.valueOf(iIntValue2));
        }
        if (textView2 != null) {
            textView2.setText(iIntValue2 != 1 ? iIntValue2 != 2 ? iIntValue2 != 3 ? iIntValue2 != 4 ? iIntValue2 != 5 ? getString(R.string.bracket_caps) : getString(R.string.cedh_caps) : getString(R.string.optimized_caps) : getString(R.string.upgraded_caps) : getString(R.string.core_caps) : getString(R.string.exhibition_caps));
        }
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateColorIdentity(final String type, String cardId, int face, boolean isScryfallId) {
        final View view;
        MTGDBHelper mTGDBHelper = this.dbHelper;
        if (mTGDBHelper != null) {
            if (!isScryfallId) {
                cardId = MTGDBHelper.getFirstPrintScryfallId$default(mTGDBHelper, cardId, 0, 2, null);
            }
            if (cardId == null || (view = getView()) == null) {
                return;
            }
            final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.manaLayout);
            final ArrayList arrayList = new ArrayList();
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            companion.getCard(contextRequireContext, cardId, face, new Function1() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda48
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CreateDeckBottomSheetFragment.updateColorIdentity$lambda$0$0$0$0(this.f$0, linearLayout, type, arrayList, view, (CardRecord) obj);
                }
            });
        }
    }

    static /* synthetic */ void updateColorIdentity$default(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        createDeckBottomSheetFragment.updateColorIdentity(str, str2, i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateColorIdentity$lambda$0$0$0$0(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, LinearLayout linearLayout, String str, List list, View view, CardRecord cardRecord) {
        if (cardRecord != null) {
            linearLayout.setVisibility(0);
            for (String str2 : StringsKt.split$default((CharSequence) cardRecord.getIdentity(), new String[]{"|"}, false, 0, 6, (Object) null)) {
                if (!list.contains(str2) && str2.length() > 0) {
                    list.add(str2);
                }
            }
            if (Intrinsics.areEqual(str, "partner")) {
                createDeckBottomSheetFragment.partnerIdentity = list;
                boolean zContains = GameUtilsKt.getColorChoosingCommanders().contains(cardRecord.getOracle_id());
                createDeckBottomSheetFragment.partnerIsColorChoosing = zContains;
                if (zContains) {
                    ((LinearLayout) view.findViewById(R.id.partnerColorOverrideLayout)).setVisibility(0);
                    createDeckBottomSheetFragment.applyOverridePipState(view, false, createDeckBottomSheetFragment.partnerColorOverride);
                } else {
                    createDeckBottomSheetFragment.partnerColorOverride = null;
                    ((LinearLayout) view.findViewById(R.id.partnerColorOverrideLayout)).setVisibility(8);
                }
                for (String str3 : createDeckBottomSheetFragment.commanderIdentity) {
                    if (!list.contains(str3) && str3.length() > 0) {
                        list.add(str3);
                    }
                }
            } else {
                createDeckBottomSheetFragment.commanderIdentity = list;
                boolean zContains2 = GameUtilsKt.getColorChoosingCommanders().contains(cardRecord.getOracle_id());
                createDeckBottomSheetFragment.commanderIsColorChoosing = zContains2;
                if (zContains2) {
                    ((LinearLayout) view.findViewById(R.id.commanderColorOverrideLayout)).setVisibility(0);
                    createDeckBottomSheetFragment.applyOverridePipState(view, true, createDeckBottomSheetFragment.commanderColorOverride);
                } else {
                    createDeckBottomSheetFragment.commanderColorOverride = null;
                    ((LinearLayout) view.findViewById(R.id.commanderColorOverrideLayout)).setVisibility(8);
                }
                for (String str4 : createDeckBottomSheetFragment.partnerIdentity) {
                    if (!list.contains(str4) && str4.length() > 0) {
                        list.add(str4);
                    }
                }
            }
            createDeckBottomSheetFragment.refreshDisplayColorIdentity();
        } else {
            if (Intrinsics.areEqual(str, "commander")) {
                createDeckBottomSheetFragment.commanderIsColorChoosing = false;
                createDeckBottomSheetFragment.commanderColorOverride = null;
                ((LinearLayout) view.findViewById(R.id.commanderColorOverrideLayout)).setVisibility(8);
            } else {
                createDeckBottomSheetFragment.partnerIsColorChoosing = false;
                createDeckBottomSheetFragment.partnerColorOverride = null;
                ((LinearLayout) view.findViewById(R.id.partnerColorOverrideLayout)).setVisibility(8);
            }
            createDeckBottomSheetFragment.refreshDisplayColorIdentity();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePlaymatPreview() {
        View view;
        final LoadingImageViewPlaymat loadingImageViewPlaymat;
        if (getContext() == null || (view = getView()) == null || (loadingImageViewPlaymat = (LoadingImageViewPlaymat) view.findViewById(R.id.playmatImageView)) == null) {
            return;
        }
        View view2 = getView();
        final TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.playmatText) : null;
        if (textView != null) {
            textView.setVisibility(4);
        }
        loadingImageViewPlaymat.setAutoLoad(false);
        loadingImageViewPlaymat.setImageUrl("");
        loadingImageViewPlaymat.setLeftImageUrl("");
        loadingImageViewPlaymat.setRightArtCrop(false);
        loadingImageViewPlaymat.setLeftArtCrop(false);
        loadingImageViewPlaymat.reset();
        loadingImageViewPlaymat.showLoading();
        String str = this.rightPlaymatPreviewUrl;
        if (str == null || str.length() == 0) {
            String str2 = this.rightplaymat;
            if (str2 == null || str2.length() == 0) {
                loadingImageViewPlaymat.setImageUrl("");
                loadingImageViewPlaymat.reset();
                loadingImageViewPlaymat.loadImages();
            } else {
                DeckUtils companion = DeckUtils.INSTANCE.getInstance();
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                String str3 = this.rightplaymat;
                Intrinsics.checkNotNull(str3);
                companion.fetchPlaymatURL(contextRequireContext, str3, new Function1() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateDeckBottomSheetFragment.updatePlaymatPreview$lambda$0(loadingImageViewPlaymat, textView, (MTPlaymatData) obj);
                    }
                }, new Function1() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateDeckBottomSheetFragment.updatePlaymatPreview$lambda$1(loadingImageViewPlaymat, (String) obj);
                    }
                });
            }
        } else {
            String str4 = this.rightPlaymatPreviewUrl;
            Intrinsics.checkNotNull(str4);
            loadingImageViewPlaymat.setImageUrl(str4);
            loadingImageViewPlaymat.setRightArtCrop(this.rightPlaymatPreviewUrlArtCrop);
            loadingImageViewPlaymat.loadImages();
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
        String str5 = this.leftPlaymatPreviewUrl;
        if (str5 != null && str5.length() != 0) {
            String str6 = this.leftPlaymatPreviewUrl;
            Intrinsics.checkNotNull(str6);
            loadingImageViewPlaymat.setLeftImageUrl(str6);
            loadingImageViewPlaymat.setLeftArtCrop(this.leftPlaymatPreviewUrlArtCrop);
            loadingImageViewPlaymat.loadImages();
            if (textView != null) {
                textView.setVisibility(0);
                return;
            }
            return;
        }
        String str7 = this.leftplaymat;
        if (str7 == null || str7.length() == 0) {
            loadingImageViewPlaymat.setLeftImageUrl("");
            loadingImageViewPlaymat.reset();
            loadingImageViewPlaymat.loadImages();
        } else {
            DeckUtils companion2 = DeckUtils.INSTANCE.getInstance();
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            String str8 = this.leftplaymat;
            Intrinsics.checkNotNull(str8);
            companion2.fetchPlaymatURL(contextRequireContext2, str8, new Function1() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CreateDeckBottomSheetFragment.updatePlaymatPreview$lambda$2(loadingImageViewPlaymat, textView, (MTPlaymatData) obj);
                }
            }, new Function1() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CreateDeckBottomSheetFragment.updatePlaymatPreview$lambda$3(loadingImageViewPlaymat, (String) obj);
                }
            });
        }
    }

    static final Unit updatePlaymatPreview$lambda$0(LoadingImageViewPlaymat loadingImageViewPlaymat, TextView textView, MTPlaymatData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        loadingImageViewPlaymat.setImageUrl(data.getPlaymatImageURL());
        loadingImageViewPlaymat.setRightArtCrop(data.isArtCrop());
        loadingImageViewPlaymat.loadImages();
        if (textView != null) {
            textView.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    static final Unit updatePlaymatPreview$lambda$1(LoadingImageViewPlaymat loadingImageViewPlaymat, String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        loadingImageViewPlaymat.loadDefault();
        return Unit.INSTANCE;
    }

    static final Unit updatePlaymatPreview$lambda$2(LoadingImageViewPlaymat loadingImageViewPlaymat, TextView textView, MTPlaymatData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        loadingImageViewPlaymat.setLeftArtCrop(data.isArtCrop());
        loadingImageViewPlaymat.setLeftImageUrl(data.getPlaymatImageURL());
        loadingImageViewPlaymat.loadImages();
        if (textView != null) {
            textView.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    static final Unit updatePlaymatPreview$lambda$3(LoadingImageViewPlaymat loadingImageViewPlaymat, String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        loadingImageViewPlaymat.loadDefault();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updatePrivacySelectorUI(TextView label, View container) {
        Pair pair;
        String str = this.selectedPrivacyType;
        int iHashCode = str.hashCode();
        if (iHashCode != -903566235) {
            if (iHashCode != -314497661) {
                pair = (iHashCode == -216005226 && str.equals(MTApiKt.PRIVACY_TYPE_UNLISTED)) ? TuplesKt.to(Integer.valueOf(R.string.privacy_unlisted), Integer.valueOf(R.drawable.privacy_selector_background_unlisted)) : TuplesKt.to(Integer.valueOf(R.string.privacy_public), Integer.valueOf(R.drawable.privacy_selector_background_public));
            } else if (str.equals(MTApiKt.PRIVACY_TYPE_PRIVATE)) {
                pair = TuplesKt.to(Integer.valueOf(R.string.privacy_private), Integer.valueOf(R.drawable.privacy_selector_background_private));
            }
        } else if (str.equals(MTApiKt.PRIVACY_TYPE_SHARED)) {
            pair = TuplesKt.to(Integer.valueOf(R.string.privacy_shared), Integer.valueOf(R.drawable.privacy_selector_background_shared));
        }
        int iIntValue = ((Number) pair.component1()).intValue();
        int iIntValue2 = ((Number) pair.component2()).intValue();
        label.setText(getString(iIntValue));
        container.setBackgroundResource(iIntValue2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSubmitButtonState() {
        View view = getView();
        if (view != null) {
            View viewFindViewById = view.findViewById(R.id.createButtonLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.createButtonText);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            TextView textView = (TextView) viewFindViewById2;
            if (this.editMode) {
                textView.setText(getResources().getString(R.string.edit_deck_button));
            } else if (this.guestMode) {
                textView.setText(getResources().getString(R.string.create_guest_deck_button));
            } else if (this.tempMode) {
                textView.setText(getResources().getString(R.string.create_temp_deck_button));
            } else {
                textView.setText(getResources().getString(R.string.create_deck_button));
            }
            boolean z = false;
            boolean z2 = this.deckName.length() > 0 && this.format != null;
            MTFormat mTFormat = this.format;
            if (mTFormat != null && mTFormat.getHascommander()) {
                if (z2 && this.commander != null) {
                    z = true;
                }
                z2 = z;
            }
            constraintLayout.setEnabled(z2);
            if (constraintLayout.isEnabled()) {
                constraintLayout.setAlpha(1.0f);
                textView.setAlpha(1.0f);
            } else {
                constraintLayout.setAlpha(0.5f);
                textView.setAlpha(0.5f);
            }
        }
    }

    private final void updateTypeSelection(View view) {
        TextView textView = (TextView) view.findViewById(R.id.constructedType);
        TextView textView2 = (TextView) view.findViewById(R.id.limitedType);
        if (this.deckType == 0) {
            textView.setBackgroundResource(R.drawable.type_selected_background);
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
            textView2.setBackground(null);
            textView2.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
            return;
        }
        textView2.setBackgroundResource(R.drawable.type_selected_background);
        textView2.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
        textView.setBackground(null);
        textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
    }

    public final void cardScanned(final MTFullCard fullCard, final int face) {
        String scryfallid;
        Intrinsics.checkNotNullParameter(fullCard, "fullCard");
        String cardid = fullCard.getCardid();
        if ((cardid != null && cardid.length() != 0) || (scryfallid = fullCard.getScryfallid()) == null || scryfallid.length() == 0) {
            applyScannedCard(fullCard, face);
            return;
        }
        MTApi mtApi = MTApiKt.getMtApi();
        String scryfallid2 = fullCard.getScryfallid();
        Intrinsics.checkNotNull(scryfallid2);
        mtApi.getCardByScryfallId(scryfallid2).enqueue(new Callback<MTCardResponse>() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment.cardScanned.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (CreateDeckBottomSheetFragment.this.getContext() == null) {
                    return;
                }
                CreateDeckBottomSheetFragment.this.applyScannedCard(fullCard, face);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardResponse> call, Response<MTCardResponse> response) {
                MTFullCard card;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (CreateDeckBottomSheetFragment.this.getContext() == null) {
                    return;
                }
                CreateDeckBottomSheetFragment createDeckBottomSheetFragment = CreateDeckBottomSheetFragment.this;
                MTCardResponse mTCardResponseBody = response.body();
                if (mTCardResponseBody == null || (card = mTCardResponseBody.getCard()) == null) {
                    card = fullCard;
                }
                createDeckBottomSheetFragment.applyScannedCard(card, face);
            }
        });
    }

    public final Integer getBracket() {
        return this.bracket;
    }

    public final String getCommander() {
        return this.commander;
    }

    public final String getCommanderCardId() {
        return this.commanderCardId;
    }

    public final String getCommanderColorOverride() {
        return this.commanderColorOverride;
    }

    public final List<String> getCommanderIdentity() {
        return this.commanderIdentity;
    }

    public final String getCommanderLang() {
        return this.commanderLang;
    }

    public final PopupWindow getCommanderPopupWindow() {
        return this.commanderPopupWindow;
    }

    public final MTGDBHelper getDbHelper() {
        return this.dbHelper;
    }

    public final String getDeckName() {
        return this.deckName;
    }

    public final boolean getDeckNameWasTyped() {
        return this.deckNameWasTyped;
    }

    public final int getDeckType() {
        return this.deckType;
    }

    public final String getExternalUrl() {
        return this.externalUrl;
    }

    public final MTFormat getFormat() {
        return this.format;
    }

    public final String getLeftplaymat() {
        return this.leftplaymat;
    }

    public final String getLeftplaymatCardId() {
        return this.leftplaymatCardId;
    }

    public final Integer getLeftplaymatFaceIndex() {
        return this.leftplaymatFaceIndex;
    }

    public final MTGDBHelperLocalized getLocalizedHelper() {
        return this.localizedHelper;
    }

    public final List<MTGDBHelperLocalized> getLocalizedHelpers() {
        return this.localizedHelpers;
    }

    public final String getPartner() {
        return this.partner;
    }

    public final String getPartnerCardId() {
        return this.partnerCardId;
    }

    public final String getPartnerColorOverride() {
        return this.partnerColorOverride;
    }

    public final List<String> getPartnerIdentity() {
        return this.partnerIdentity;
    }

    public final String getPartnerLang() {
        return this.partnerLang;
    }

    public final PopupWindow getPartnerPopupWindow() {
        return this.partnerPopupWindow;
    }

    public final String getPartnerSignatureSpellCardId() {
        return this.partnerSignatureSpellCardId;
    }

    public final String getPartnersignaturespell() {
        return this.partnersignaturespell;
    }

    public final PopupWindow getPlaymatCardPopupWindow() {
        return this.playmatCardPopupWindow;
    }

    public final String getPlaymatLang() {
        return this.playmatLang;
    }

    public final String getRightplaymat() {
        return this.rightplaymat;
    }

    public final String getRightplaymatCardId() {
        return this.rightplaymatCardId;
    }

    public final Integer getRightplaymatFaceIndex() {
        return this.rightplaymatFaceIndex;
    }

    public final Job getSearchCommanderJob() {
        return this.searchCommanderJob;
    }

    public final Job getSearchPartnerJob() {
        return this.searchPartnerJob;
    }

    public final Job getSearchPlaymatCardJob() {
        return this.searchPlaymatCardJob;
    }

    public final boolean getShouldAutoSync() {
        return this.shouldAutoSync;
    }

    public final boolean getShouldImport() {
        return this.shouldImport;
    }

    public final String getSignatureSpellCardId() {
        return this.signatureSpellCardId;
    }

    public final String getSignaturespell() {
        return this.signaturespell;
    }

    public final boolean getUpdatingCommander() {
        return this.updatingCommander;
    }

    public final boolean getUpdatingPartner() {
        return this.updatingPartner;
    }

    /* JADX INFO: renamed from: isBackground, reason: from getter */
    public final boolean getIsBackground() {
        return this.isBackground;
    }

    /* JADX INFO: renamed from: isDoctor, reason: from getter */
    public final boolean getIsDoctor() {
        return this.isDoctor;
    }

    /* JADX INFO: renamed from: isDoctorCompanion, reason: from getter */
    public final boolean getIsDoctorCompanion() {
        return this.isDoctorCompanion;
    }

    /* JADX INFO: renamed from: isFriendsForever, reason: from getter */
    public final boolean getIsFriendsForever() {
        return this.isFriendsForever;
    }

    /* JADX INFO: renamed from: isPartner, reason: from getter */
    public final boolean getIsPartner() {
        return this.isPartner;
    }

    /* JADX INFO: renamed from: isSignatureSpell, reason: from getter */
    public final boolean getIsSignatureSpell() {
        return this.isSignatureSpell;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        int i;
        int i2;
        String string;
        String string2;
        super.onCreate(savedInstanceState);
        CreateDeckBottomSheetFragment createDeckBottomSheetFragment = this;
        MTCardSearchViewModelFactory mTCardSearchViewModelFactory = new MTCardSearchViewModelFactory();
        this.searchViewModel = (MTCardSearchViewModel) new ViewModelProvider(createDeckBottomSheetFragment, mTCardSearchViewModelFactory).get("commander", MTCardSearchViewModel.class);
        this.partnerSearchViewModel = (MTCardSearchViewModel) new ViewModelProvider(createDeckBottomSheetFragment, mTCardSearchViewModelFactory).get("partner", MTCardSearchViewModel.class);
        this.playmatSearchViewModel = (MTCardSearchViewModel) new ViewModelProvider(createDeckBottomSheetFragment, mTCardSearchViewModelFactory).get(PreferencesManager.BACKGROUND_PLAYMAT, MTCardSearchViewModel.class);
        Bundle arguments = getArguments();
        if (arguments == null || (string2 = arguments.getString(ARG_USER_JSON)) == null) {
            this.user = new MTUser(false, 0, null, null, null, null, null, null, null, null, 1023, null);
        } else {
            Object objFromJson = new Gson().fromJson(string2, (Class<Object>) MTUser.class);
            Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
            this.user = (MTUser) objFromJson;
        }
        this.tempMode = false;
        this.guestMode = false;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string = arguments2.getString(ARG_DECK_JSON)) == null) {
            this.deck = null;
        } else {
            MTDeck mTDeck = (MTDeck) new Gson().fromJson(string, MTDeck.class);
            this.deck = mTDeck;
            this.tempMode = false;
            this.guestMode = false;
            boolean z = mTDeck != null;
            this.editMode = z;
            this.deckNameWasTyped = z;
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null && (i2 = arguments3.getInt(ARG_DECK_FORMAT_FOR_GUEST, -1)) != -1) {
            this.tempMode = false;
            this.guestMode = true;
            this.formatIdForGuest = i2;
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null && (i = arguments4.getInt(ARG_DECK_FORMAT_FOR_MTUSER, -1)) != -1) {
            this.tempMode = true;
            this.guestMode = false;
            this.formatIdForTemp = i;
        }
        Bundle arguments5 = getArguments();
        if (arguments5 != null) {
            this.userIdForTemp = arguments5.getInt(ARG_DECK_MTUSER_ID);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (this.deck != null) {
            this.editMode = true;
            this.deckNameWasTyped = true;
        }
        return inflater.inflate(R.layout.bottom_sheet_deck, container, false);
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
            layoutParams.height = -2;
        }
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(viewFindViewById);
        Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
        bottomSheetBehaviorFrom.setState(3);
        bottomSheetBehaviorFrom.setSkipCollapsed(true);
        bottomSheetBehaviorFrom.setDraggable(true);
        bottomSheetBehaviorFrom.setExpandedOffset(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x0854  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Object next;
        MTDeck mTDeck;
        MTDeck mTDeck2;
        Object obj;
        TextView textView;
        EditText editText;
        LinearLayout linearLayout;
        EditText editText2;
        TextView textView2;
        int i;
        Object next2;
        boolean z;
        LinearLayout linearLayout2;
        String str;
        final TextView textView3;
        final EditText editText3;
        final EditText editText4;
        final TextView textView4;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.textLayout);
        final EditText editText5 = (EditText) linearLayoutCompat.findViewById(R.id.deckName);
        final LinearLayout linearLayout3 = (LinearLayout) linearLayoutCompat.findViewById(R.id.commanderLayout);
        final LinearLayout linearLayout4 = (LinearLayout) linearLayoutCompat.findViewById(R.id.externalLayout);
        final ConstraintLayout constraintLayout = (ConstraintLayout) linearLayoutCompat.findViewById(R.id.playmatLayout);
        final LinearLayout linearLayout5 = (LinearLayout) linearLayoutCompat.findViewById(R.id.playmatCardLayout);
        editText5.setVisibility(8);
        linearLayout3.setVisibility(8);
        linearLayout5.setVisibility(8);
        linearLayout4.setVisibility(8);
        final LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.privacySelectorContainer);
        final TextView textView5 = (TextView) view.findViewById(R.id.privacyLabel);
        if (this.editMode || this.guestMode || this.tempMode) {
            linearLayout6.setVisibility(8);
        } else {
            linearLayout6.setVisibility(0);
            Intrinsics.checkNotNull(textView5);
            Intrinsics.checkNotNull(linearLayout6);
            LinearLayout linearLayout7 = linearLayout6;
            updatePrivacySelectorUI(textView5, linearLayout7);
            ViewExtensionsKt.setOnClickWithFade(linearLayout7, new Function0() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CreateDeckBottomSheetFragment.onViewCreated$lambda$0(this.f$0, linearLayout6, textView5);
                }
            });
        }
        setupColorSelection(view);
        setupCommanderPartnerColorOverridePickers(view);
        TextView textView6 = (TextView) view.findViewById(R.id.deckName);
        final TextView textView7 = (TextView) view.findViewById(R.id.playmatText);
        constraintLayout.setClipToOutline(true);
        constraintLayout.setClipChildren(true);
        View viewFindViewById = view.findViewById(R.id.playmatImageView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        LoadingImageViewPlaymat loadingImageViewPlaymat = (LoadingImageViewPlaymat) viewFindViewById;
        loadingImageViewPlaymat.setAutoLoad(false);
        loadingImageViewPlaymat.loadDefault();
        View viewFindViewById2 = view.findViewById(R.id.createButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        View viewFindViewById3 = view.findViewById(R.id.createButtonText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        TextView textView8 = (TextView) view.findViewById(R.id.constructedType);
        TextView textView9 = (TextView) view.findViewById(R.id.limitedType);
        textView8.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateDeckBottomSheetFragment.onViewCreated$lambda$1(this.f$0, view, view2);
            }
        });
        textView9.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateDeckBottomSheetFragment.onViewCreated$lambda$2(this.f$0, view, view2);
            }
        });
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String deviceLanguage = new PreferencesManager(contextRequireContext).getDeviceLanguage();
        MTGDBHelper.Companion companion = MTGDBHelper.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        this.dbHelper = companion.getInstance(contextRequireContext2);
        MTGDBHelperLocalized.Companion companion2 = MTGDBHelperLocalized.INSTANCE;
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        this.localizedHelper = companion2.getInstance(contextRequireContext3, deviceLanguage);
        MTCardSearchViewModel mTCardSearchViewModel = this.searchViewModel;
        if (mTCardSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchViewModel");
            mTCardSearchViewModel = null;
        }
        mTCardSearchViewModel.getSearchResults().observe(getViewLifecycleOwner(), new CreateDeckBottomSheetFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$3(this.f$0, view, (List) obj2);
            }
        }));
        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.bracketLayout);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.autoBracketIconLayout);
        constraintLayout3.setVisibility(8);
        Intrinsics.checkNotNull(constraintLayout2);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$4(this.f$0);
            }
        });
        View viewFindViewById4 = view.findViewById(R.id.commanderEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        final EditText editText6 = (EditText) viewFindViewById4;
        editText6.setInputType(524288);
        editText6.setImportantForAutofill(2);
        View viewFindViewById5 = view.findViewById(R.id.searchIconCommander);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        ((ImageView) viewFindViewById5).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateDeckBottomSheetFragment.onViewCreated$lambda$5(this.f$0, editText6, view2);
            }
        });
        View viewFindViewById6 = view.findViewById(R.id.scanIconCommander);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        ((ImageView) viewFindViewById6).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateDeckBottomSheetFragment.onViewCreated$lambda$6(this.f$0, view2);
            }
        });
        editText6.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda43
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView10, int i2, KeyEvent keyEvent) {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$7(this.f$0, textView10, i2, keyEvent);
            }
        });
        editText6.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda45
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$8(editText6, this, view, view2, motionEvent);
            }
        });
        editText6.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment.onViewCreated.10
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    editText6.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {
                    editText6.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_clear, 0);
                }
                String strValueOf = String.valueOf(s);
                if (Intrinsics.areEqual(strValueOf, "")) {
                    editText6.setBackground(ContextCompat.getDrawable(this.requireContext(), R.drawable.black_box_not_ok));
                    PopupWindow commanderPopupWindow = this.getCommanderPopupWindow();
                    if (commanderPopupWindow != null) {
                        commanderPopupWindow.dismiss();
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(strValueOf, this.lastCommanderQuery)) {
                    return;
                }
                this.lastCommanderQuery = strValueOf;
                Job searchCommanderJob = this.getSearchCommanderJob();
                if (searchCommanderJob != null) {
                    Job.DefaultImpls.cancel$default(searchCommanderJob, (CancellationException) null, 1, (Object) null);
                }
                CreateDeckBottomSheetFragment createDeckBottomSheetFragment = this;
                createDeckBottomSheetFragment.setSearchCommanderJob(BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(createDeckBottomSheetFragment), Dispatchers.getIO(), null, new CreateDeckBottomSheetFragment$onViewCreated$10$afterTextChanged$2(this, strValueOf, null), 2, null));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        View viewFindViewById7 = view.findViewById(R.id.commanderTapToChange);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        final TextView textView10 = (TextView) viewFindViewById7;
        textView10.setVisibility(8);
        textView10.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateDeckBottomSheetFragment.onViewCreated$lambda$9(this.f$0, editText6, view2);
            }
        });
        MTCardSearchViewModel mTCardSearchViewModel2 = this.partnerSearchViewModel;
        if (mTCardSearchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partnerSearchViewModel");
            mTCardSearchViewModel2 = null;
        }
        mTCardSearchViewModel2.getSearchResults().observe(getViewLifecycleOwner(), new CreateDeckBottomSheetFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$10(this.f$0, view, (List) obj2);
            }
        }));
        View viewFindViewById8 = view.findViewById(R.id.partnerEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        final EditText editText7 = (EditText) viewFindViewById8;
        editText7.setInputType(524288);
        editText7.setImportantForAutofill(2);
        View viewFindViewById9 = view.findViewById(R.id.searchIconPartner);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        ((ImageView) viewFindViewById9).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateDeckBottomSheetFragment.onViewCreated$lambda$11(this.f$0, editText7, view2);
            }
        });
        View viewFindViewById10 = view.findViewById(R.id.scanIconPartner);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        ((ImageView) viewFindViewById10).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateDeckBottomSheetFragment.onViewCreated$lambda$12(this.f$0, view2);
            }
        });
        editText7.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda14
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView11, int i2, KeyEvent keyEvent) {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$13(this.f$0, textView11, i2, keyEvent);
            }
        });
        editText7.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$14(editText7, this, view, view2, motionEvent);
            }
        });
        editText7.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment.onViewCreated.17
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    editText7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {
                    editText7.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_clear, 0);
                }
                String strValueOf = String.valueOf(s);
                if (Intrinsics.areEqual(strValueOf, "")) {
                    editText7.setBackground(ContextCompat.getDrawable(this.requireContext(), R.drawable.black_box_not_ok));
                    PopupWindow partnerPopupWindow = this.getPartnerPopupWindow();
                    if (partnerPopupWindow != null) {
                        partnerPopupWindow.dismiss();
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(strValueOf, this.lastPartnerQuery)) {
                    return;
                }
                this.lastPartnerQuery = strValueOf;
                Job searchPartnerJob = this.getSearchPartnerJob();
                if (searchPartnerJob != null) {
                    Job.DefaultImpls.cancel$default(searchPartnerJob, (CancellationException) null, 1, (Object) null);
                }
                CreateDeckBottomSheetFragment createDeckBottomSheetFragment = this;
                createDeckBottomSheetFragment.setSearchPartnerJob(BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(createDeckBottomSheetFragment), Dispatchers.getIO(), null, new CreateDeckBottomSheetFragment$onViewCreated$17$afterTextChanged$2(this, strValueOf, null), 2, null));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        View viewFindViewById11 = view.findViewById(R.id.partnerTapToChange);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        TextView textView11 = (TextView) viewFindViewById11;
        textView11.setVisibility(8);
        textView11.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateDeckBottomSheetFragment.onViewCreated$lambda$15(this.f$0, editText7, view2);
            }
        });
        MTCardSearchViewModel mTCardSearchViewModel3 = this.playmatSearchViewModel;
        if (mTCardSearchViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playmatSearchViewModel");
            mTCardSearchViewModel3 = null;
        }
        mTCardSearchViewModel3.getSearchResults().observe(getViewLifecycleOwner(), new CreateDeckBottomSheetFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$16(this.f$0, view, (List) obj2);
            }
        }));
        View viewFindViewById12 = view.findViewById(R.id.playmatCardEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        final EditText editText8 = (EditText) viewFindViewById12;
        editText8.setInputType(524288);
        editText8.setImportantForAutofill(2);
        View viewFindViewById13 = view.findViewById(R.id.searchIconPlaymatCard);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        ((ImageView) viewFindViewById13).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateDeckBottomSheetFragment.onViewCreated$lambda$17(this.f$0, editText8, view2);
            }
        });
        View viewFindViewById14 = view.findViewById(R.id.scanIconPlaymatCard);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        ((ImageView) viewFindViewById14).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateDeckBottomSheetFragment.onViewCreated$lambda$18(this.f$0, view2);
            }
        });
        editText8.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda20
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView12, int i2, KeyEvent keyEvent) {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$19(this.f$0, textView12, i2, keyEvent);
            }
        });
        editText8.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda23
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$20(editText8, this, view2, motionEvent);
            }
        });
        editText8.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment.onViewCreated.24
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    editText8.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {
                    editText8.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_clear, 0);
                }
                String strValueOf = String.valueOf(s);
                boolean zAreEqual = Intrinsics.areEqual(strValueOf, "");
                CreateDeckBottomSheetFragment createDeckBottomSheetFragment = this;
                if (zAreEqual) {
                    PopupWindow playmatCardPopupWindow = createDeckBottomSheetFragment.getPlaymatCardPopupWindow();
                    if (playmatCardPopupWindow != null) {
                        playmatCardPopupWindow.dismiss();
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(strValueOf, createDeckBottomSheetFragment.lastPlaymatCardQuery)) {
                    return;
                }
                this.lastPlaymatCardQuery = strValueOf;
                Job searchPlaymatCardJob = this.getSearchPlaymatCardJob();
                if (searchPlaymatCardJob != null) {
                    Job.DefaultImpls.cancel$default(searchPlaymatCardJob, (CancellationException) null, 1, (Object) null);
                }
                CreateDeckBottomSheetFragment createDeckBottomSheetFragment2 = this;
                createDeckBottomSheetFragment2.setSearchPlaymatCardJob(BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(createDeckBottomSheetFragment2), Dispatchers.getIO(), null, new CreateDeckBottomSheetFragment$onViewCreated$24$afterTextChanged$2(this, strValueOf, null), 2, null));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        View viewFindViewById15 = view.findViewById(R.id.playmatCardTapToChange);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        TextView textView12 = (TextView) viewFindViewById15;
        textView12.setVisibility(8);
        textView12.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateDeckBottomSheetFragment.onViewCreated$lambda$21(this.f$0, editText8, view2);
            }
        });
        ((TextView) view.findViewById(R.id.bracketNameTextView)).setText(getString(R.string.bracket_caps));
        View viewFindViewById16 = view.findViewById(R.id.formatLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        LinearLayout linearLayout8 = (LinearLayout) viewFindViewById16;
        View viewFindViewById17 = view.findViewById(R.id.formatTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        final TextView textView13 = (TextView) viewFindViewById17;
        DecksDBHelper.Companion companion3 = DecksDBHelper.INSTANCE;
        Context contextRequireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
        final List mutableList = CollectionsKt.toMutableList((Collection) companion3.getInstance(contextRequireContext4).getFormats());
        final LinearLayout linearLayout9 = (LinearLayout) view.findViewById(R.id.colorsLayout);
        if (mutableList.size() > 1) {
            CollectionsKt.sortWith(mutableList, new Comparator() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$onViewCreated$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((MTFormat) t).getName(), ((MTFormat) t2).getName());
                }
            });
        }
        LinearLayout linearLayout10 = linearLayout8;
        PopupMenu popupMenu = new PopupMenu(requireContext(), linearLayout10);
        ArrayList arrayList = new ArrayList();
        List<String> mainFormatIds = GameUtils.INSTANCE.getInstance().getMainFormatIds();
        List<MTFormat> list = mutableList;
        for (MTFormat mTFormat : list) {
            PopupMenu popupMenu2 = popupMenu;
            TextView textView14 = textView12;
            if (mainFormatIds.contains(mTFormat.getScryfallid())) {
                arrayList.add(mTFormat);
            }
            textView12 = textView14;
            popupMenu = popupMenu2;
        }
        final PopupMenu popupMenu3 = popupMenu;
        final TextView textView15 = textView12;
        for (Iterator it = arrayList.iterator(); it.hasNext(); it = it) {
            MTFormat mTFormat2 = (MTFormat) it.next();
            popupMenu3.getMenu().add(0, mTFormat2.getId(), 0, mTFormat2.getName());
        }
        popupMenu3.getMenu().add(-1, -1, 0, getResources().getString(R.string.other_formats));
        PopupMenu popupMenu4 = new PopupMenu(requireContext(), linearLayout10);
        Menu menu = popupMenu4.getMenu();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            MTFormat mTFormat3 = (MTFormat) it2.next();
            menu.add(0, mTFormat3.getId(), 0, mTFormat3.getName());
            it2 = it2;
            popupMenu4 = popupMenu4;
        }
        final PopupMenu popupMenu5 = popupMenu4;
        popupMenu5.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda25
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$26(textView13, this, mutableList, editText5, linearLayout4, constraintLayout, view, linearLayout3, textView10, editText6, linearLayout9, linearLayout5, menuItem);
            }
        });
        popupMenu3.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda26
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$27(popupMenu5, textView13, this, mutableList, editText5, linearLayout4, constraintLayout, view, linearLayout3, textView10, editText6, linearLayout9, linearLayout5, menuItem);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(linearLayout10, new Function0() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$28(this.f$0, popupMenu3);
            }
        });
        updateSubmitButtonState();
        textView6.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment.onViewCreated.33
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CreateDeckBottomSheetFragment.this.setDeckName(StringsKt.trim((CharSequence) String.valueOf(s)).toString());
                CreateDeckBottomSheetFragment.this.setDeckNameWasTyped(true);
                int length = CreateDeckBottomSheetFragment.this.getDeckName().length();
                TextView textView16 = textView7;
                if (length > 0) {
                    textView16.setText(CreateDeckBottomSheetFragment.this.getDeckName());
                } else {
                    textView16.setText(CreateDeckBottomSheetFragment.this.getString(R.string.create_deck));
                }
                CreateDeckBottomSheetFragment.this.updateSubmitButtonState();
            }
        });
        EditText editText9 = (EditText) view.findViewById(R.id.externalURL);
        final CheckBox checkBox = (CheckBox) view.findViewById(R.id.importCheckbox);
        final CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.autoSyncCheckbox);
        final TextView textView16 = (TextView) view.findViewById(R.id.moxfieldIssueTextView);
        checkBox.setVisibility(8);
        checkBox2.setVisibility(8);
        textView16.setVisibility(8);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda28
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                CreateDeckBottomSheetFragment.onViewCreated$lambda$29(this.f$0, checkBox2, compoundButton, z2);
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda29
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                CreateDeckBottomSheetFragment.onViewCreated$lambda$30(this.f$0, compoundButton, z2);
            }
        });
        editText9.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment.onViewCreated.36
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
                String string;
                String string2;
                if (p0 == null || (string2 = p0.toString()) == null || (string = StringsKt.trim((CharSequence) string2).toString()) == null) {
                    string = "";
                }
                if (!CreateDeckBottomSheetFragment.this.isValidDeckUrl(string)) {
                    checkBox.setVisibility(8);
                    checkBox2.setVisibility(8);
                    textView16.setVisibility(8);
                    checkBox.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox.setEnabled(true);
                    CreateDeckBottomSheetFragment.this.setShouldImport(false);
                    CreateDeckBottomSheetFragment.this.setShouldAutoSync(false);
                    return;
                }
                boolean z2 = CreateDeckBottomSheetFragment.this.editMode;
                CheckBox checkBox3 = checkBox;
                if (!z2) {
                    checkBox3.setVisibility(0);
                    checkBox.setEnabled(true);
                    textView16.setVisibility(8);
                    checkBox2.setVisibility(8);
                    return;
                }
                checkBox3.setVisibility(8);
                checkBox.setChecked(false);
                CreateDeckBottomSheetFragment.this.setShouldImport(false);
                textView16.setVisibility(8);
                checkBox2.setVisibility(8);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CreateDeckBottomSheetFragment.this.setExternalUrl(String.valueOf(s));
            }
        });
        View viewFindViewById18 = view.findViewById(R.id.chevron_down);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById18, new Function0() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$31(this.f$0);
            }
        });
        View viewFindViewById19 = view.findViewById(R.id.createButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById19, new Function0() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CreateDeckBottomSheetFragment.onViewCreated$lambda$32(this.f$0, view);
            }
        });
        if (this.guestMode || this.tempMode) {
            ((LinearLayout) view.findViewById(R.id.typeLayout)).setVisibility(8);
            textView7.setText(getString(R.string.new_guest_deck));
            if (this.tempMode) {
                textView7.setText(getString(R.string.new_temp_deck));
            }
            editText5.setVisibility(8);
            linearLayout4.setVisibility(8);
            int i2 = this.formatIdForGuest;
            if (this.tempMode) {
                i2 = this.formatIdForTemp;
            }
            if (i2 != -1) {
                Iterator it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it3.next();
                    Iterator it4 = it3;
                    if (((MTFormat) next).getId() == i2) {
                        break;
                    } else {
                        it3 = it4;
                    }
                }
                MTFormat mTFormat4 = (MTFormat) next;
                this.format = mTFormat4;
                if (mTFormat4 != null) {
                    textView13.setText(mTFormat4.getName());
                    textView13.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
                    if (mTFormat4.getHascommander()) {
                        Log.d("CREATE_DECK", "Format with commander.");
                        editText5.setVisibility(8);
                        linearLayout3.setVisibility(0);
                        if (this.commander != null) {
                            textView10.setVisibility(0);
                        }
                        if (Intrinsics.areEqual(mTFormat4.getScryfallid(), "oathbreaker")) {
                            editText6.setHint(getString(R.string.oathbreaker_hint));
                        } else {
                            editText6.setHint(getString(R.string.commander_hint));
                        }
                        if (linearLayout9 != null) {
                            linearLayout9.setVisibility(8);
                            Unit unit = Unit.INSTANCE;
                        }
                        if (linearLayout5 != null) {
                            linearLayout5.setVisibility(8);
                            Unit unit2 = Unit.INSTANCE;
                        }
                    } else {
                        Log.d("CREATE_DECK", "Format with NO commander.");
                        linearLayout3.setVisibility(8);
                        textView10.setVisibility(8);
                        if (linearLayout9 != null) {
                            linearLayout9.setVisibility(0);
                            Unit unit3 = Unit.INSTANCE;
                        }
                        if (linearLayout5 != null) {
                            linearLayout5.setVisibility(0);
                            Unit unit4 = Unit.INSTANCE;
                        }
                        editText5.setVisibility(0);
                    }
                    Unit unit5 = Unit.INSTANCE;
                    Unit unit6 = Unit.INSTANCE;
                }
                updateSubmitButtonState();
            }
        }
        if (!this.editMode || (mTDeck = this.deck) == null) {
            return;
        }
        this.deckName = mTDeck.getName();
        textView6.setText(mTDeck.getName());
        linearLayout4.setVisibility(0);
        editText5.setVisibility(0);
        this.deckType = mTDeck.getType();
        updateTypeSelection(view);
        this.commander = mTDeck.getCommander();
        this.partner = mTDeck.getPartner();
        this.commanderColorOverride = mTDeck.getCommander_color_override();
        this.partnerColorOverride = mTDeck.getPartner_color_override();
        this.signaturespell = mTDeck.getSignaturespell();
        this.partnersignaturespell = mTDeck.getPartnersignaturespell();
        this.leftplaymat = mTDeck.getLeftplaymat();
        this.rightplaymat = mTDeck.getRightplaymat();
        this.commanderCardId = mTDeck.getCommander_card_id();
        this.partnerCardId = mTDeck.getPartner_card_id();
        this.signatureSpellCardId = mTDeck.getSignature_spell_card_id();
        this.partnerSignatureSpellCardId = mTDeck.getPartner_signature_spell_card_id();
        this.rightplaymatCardId = mTDeck.getRightplaymat_card_id();
        this.rightplaymatFaceIndex = mTDeck.getRightplaymat_face_index();
        this.leftplaymatCardId = mTDeck.getLeftplaymat_card_id();
        this.leftplaymatFaceIndex = mTDeck.getLeftplaymat_face_index();
        this.bracket = null;
        this.selectedColors = null;
        String colors = mTDeck.getColors();
        if (colors != null) {
            this.selectedColors = colors;
            displayColorIdentity(colors);
            ImageView imageView = (ImageView) view.findViewById(R.id.w_color);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.u_color);
            ImageView imageView3 = (ImageView) view.findViewById(R.id.b_color);
            mTDeck2 = mTDeck;
            ImageView imageView4 = (ImageView) view.findViewById(R.id.r_color);
            ImageView imageView5 = (ImageView) view.findViewById(R.id.g_color);
            textView2 = textView16;
            ImageView imageView6 = (ImageView) view.findViewById(R.id.c_color);
            editText2 = editText9;
            String str2 = colors;
            editText = editText6;
            obj = "oathbreaker";
            textView = textView10;
            linearLayout = linearLayout5;
            i = 2;
            imageView.setAlpha(StringsKt.contains$default((CharSequence) str2, (CharSequence) ExifInterface.LONGITUDE_WEST, false, 2, (Object) null) ? 1.0f : 0.25f);
            imageView2.setAlpha(StringsKt.contains$default((CharSequence) str2, (CharSequence) "U", false, 2, (Object) null) ? 1.0f : 0.25f);
            imageView3.setAlpha(StringsKt.contains$default((CharSequence) str2, (CharSequence) "B", false, 2, (Object) null) ? 1.0f : 0.25f);
            imageView4.setAlpha(StringsKt.contains$default((CharSequence) str2, (CharSequence) "R", false, 2, (Object) null) ? 1.0f : 0.25f);
            imageView5.setAlpha(StringsKt.contains$default((CharSequence) str2, (CharSequence) GameUtils.CONDITION_GOOD, false, 2, (Object) null) ? 1.0f : 0.25f);
            imageView6.setAlpha(str2.length() == 0 ? 1.0f : 0.25f);
            Unit unit7 = Unit.INSTANCE;
            Unit unit8 = Unit.INSTANCE;
        } else {
            mTDeck2 = mTDeck;
            obj = "oathbreaker";
            textView = textView10;
            editText = editText6;
            linearLayout = linearLayout5;
            editText2 = editText9;
            textView2 = textView16;
            i = 2;
        }
        Iterator it5 = list.iterator();
        while (true) {
            if (it5.hasNext()) {
                next2 = it5.next();
                if (((MTFormat) next2).getId() == mTDeck2.getFormatid()) {
                    break;
                }
            } else {
                next2 = null;
                break;
            }
        }
        MTFormat mTFormat5 = (MTFormat) next2;
        this.format = mTFormat5;
        if (mTFormat5 != null) {
            textView13.setText(mTFormat5.getName());
            textView13.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
            constraintLayout2.setVisibility(8);
            if (Intrinsics.areEqual(mTFormat5.getScryfallid(), "commander")) {
                constraintLayout2.setVisibility(0);
                MTBracket bracket = mTDeck2.getBracket();
                if (bracket != null) {
                    this.bracket = bracket.getUser();
                    Integer user = bracket.getUser();
                    if (user != null) {
                        user.intValue();
                        updateBracketSelection();
                        constraintLayout3.setVisibility(8);
                        Unit unit9 = Unit.INSTANCE;
                        Unit unit10 = Unit.INSTANCE;
                    } else {
                        Integer auto = bracket.getAuto();
                        if (auto != null) {
                            int iIntValue = auto.intValue();
                            constraintLayout2.setVisibility(0);
                            Unit unit11 = Unit.INSTANCE;
                            TextView textView17 = (TextView) view.findViewById(R.id.bracketValueTextView);
                            if (textView17 != null) {
                                textView17.setText(String.valueOf(iIntValue));
                                Unit unit12 = Unit.INSTANCE;
                            }
                            TextView textView18 = (TextView) view.findViewById(R.id.bracketNameTextView);
                            z = true;
                            if (iIntValue != 1) {
                                if (iIntValue != i) {
                                    if (iIntValue != 3) {
                                        if (iIntValue != 4) {
                                            if (iIntValue == 5 && textView18 != null) {
                                                textView18.setText(getString(R.string.cedh_caps));
                                                Unit unit13 = Unit.INSTANCE;
                                            }
                                        } else if (textView18 != null) {
                                            textView18.setText(getString(R.string.optimized_caps));
                                            Unit unit14 = Unit.INSTANCE;
                                        }
                                    } else if (textView18 != null) {
                                        textView18.setText(getString(R.string.upgraded_caps));
                                        Unit unit15 = Unit.INSTANCE;
                                    }
                                } else if (textView18 != null) {
                                    textView18.setText(getString(R.string.core_caps));
                                    Unit unit16 = Unit.INSTANCE;
                                }
                            } else if (textView18 != null) {
                                textView18.setText(getString(R.string.exhibition_caps));
                                Unit unit17 = Unit.INSTANCE;
                            }
                            constraintLayout3.setVisibility(0);
                            Unit unit18 = Unit.INSTANCE;
                            Unit unit19 = Unit.INSTANCE;
                        }
                    }
                    z = true;
                } else {
                    z = true;
                }
            }
            if (mTFormat5.getHascommander()) {
                linearLayout3.setVisibility(0);
                if (linearLayout9 != null) {
                    linearLayout9.setVisibility(8);
                    Unit unit20 = Unit.INSTANCE;
                }
                linearLayout2 = linearLayout;
                if (linearLayout != null) {
                    linearLayout2.setVisibility(8);
                    Unit unit21 = Unit.INSTANCE;
                }
                if (this.commander != null) {
                    textView3 = textView;
                    textView3.setVisibility(0);
                } else {
                    textView3 = textView;
                }
                if (Intrinsics.areEqual(mTFormat5.getScryfallid(), obj)) {
                    editText3 = editText;
                    editText3.setHint(getString(R.string.oathbreaker_hint));
                } else {
                    editText3 = editText;
                    editText3.setHint(getString(R.string.commander_hint));
                }
                String commander = mTDeck2.getCommander();
                if (commander != null) {
                    Pair<String, Integer> pairExtractIdAndFace = DeckUtils.INSTANCE.extractIdAndFace(commander);
                    String strComponent1 = pairExtractIdAndFace.component1();
                    int iIntValue2 = pairExtractIdAndFace.component2().intValue();
                    GameUtils companion4 = GameUtils.INSTANCE.getInstance();
                    Context contextRequireContext5 = requireContext();
                    str = "requireContext(...)";
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext5, str);
                    companion4.getCard(contextRequireContext5, strComponent1, iIntValue2, new Function1() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return CreateDeckBottomSheetFragment.onViewCreated$lambda$35$2$1$0(this.f$0, editText3, textView3, view, (CardRecord) obj2);
                        }
                    });
                    Unit unit22 = Unit.INSTANCE;
                    Unit unit23 = Unit.INSTANCE;
                } else {
                    str = "requireContext(...)";
                }
                String partner = mTDeck2.getPartner();
                if (partner != null) {
                    Pair<String, Integer> pairExtractIdAndFace2 = DeckUtils.INSTANCE.extractIdAndFace(partner);
                    String strComponent12 = pairExtractIdAndFace2.component1();
                    int iIntValue3 = pairExtractIdAndFace2.component2().intValue();
                    GameUtils companion5 = GameUtils.INSTANCE.getInstance();
                    Context contextRequireContext6 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext6, str);
                    editText4 = editText7;
                    textView4 = textView11;
                    companion5.getCard(contextRequireContext6, strComponent12, iIntValue3, new Function1() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda35
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return CreateDeckBottomSheetFragment.onViewCreated$lambda$35$2$2$0(this.f$0, editText4, view, textView4, (CardRecord) obj2);
                        }
                    });
                    Unit unit24 = Unit.INSTANCE;
                    Unit unit25 = Unit.INSTANCE;
                } else {
                    editText4 = editText7;
                    textView4 = textView11;
                }
                String signaturespell = mTDeck2.getSignaturespell();
                if (signaturespell != null) {
                    Pair<String, Integer> pairExtractIdAndFace3 = DeckUtils.INSTANCE.extractIdAndFace(signaturespell);
                    String strComponent13 = pairExtractIdAndFace3.component1();
                    int iIntValue4 = pairExtractIdAndFace3.component2().intValue();
                    GameUtils companion6 = GameUtils.INSTANCE.getInstance();
                    Context contextRequireContext7 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext7, str);
                    companion6.getCard(contextRequireContext7, strComponent13, iIntValue4, new Function1() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda36
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return CreateDeckBottomSheetFragment.onViewCreated$lambda$35$2$3$0(this.f$0, editText4, view, textView4, (CardRecord) obj2);
                        }
                    });
                    Unit unit26 = Unit.INSTANCE;
                    Unit unit27 = Unit.INSTANCE;
                }
            } else {
                linearLayout2 = linearLayout;
                str = "requireContext(...)";
                linearLayout3.setVisibility(8);
                textView.setVisibility(8);
                Unit unit28 = Unit.INSTANCE;
            }
            if (!mTFormat5.getHascommander()) {
                this.commander = null;
                this.partner = null;
                this.commanderCardId = null;
                this.partnerCardId = null;
                this.rightplaymatCardId = null;
                this.rightplaymatFaceIndex = null;
                this.rightPlaymatPreviewUrl = null;
                this.leftplaymatCardId = null;
                this.leftplaymatFaceIndex = null;
                this.leftPlaymatPreviewUrl = null;
                this.commanderColorOverride = null;
                this.partnerColorOverride = null;
                this.commanderIsColorChoosing = false;
                this.partnerIsColorChoosing = false;
                ((LinearLayout) view.findViewById(R.id.commanderColorOverrideLayout)).setVisibility(8);
                ((LinearLayout) view.findViewById(R.id.partnerColorOverrideLayout)).setVisibility(8);
                if (linearLayout9 != null) {
                    linearLayout9.setVisibility(0);
                    Unit unit29 = Unit.INSTANCE;
                }
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                    Unit unit30 = Unit.INSTANCE;
                }
                textView15.setVisibility(8);
                String str3 = this.rightplaymat;
                if (str3 != null) {
                    Pair<String, Integer> pairExtractIdAndFace4 = DeckUtils.INSTANCE.extractIdAndFace(str3);
                    String strComponent14 = pairExtractIdAndFace4.component1();
                    int iIntValue5 = pairExtractIdAndFace4.component2().intValue();
                    GameUtils companion7 = GameUtils.INSTANCE.getInstance();
                    Context contextRequireContext8 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext8, str);
                    companion7.getCard(contextRequireContext8, strComponent14, iIntValue5, new Function1() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda37
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return CreateDeckBottomSheetFragment.onViewCreated$lambda$35$2$4$0(this.f$0, editText8, textView15, (CardRecord) obj2);
                        }
                    });
                    Unit unit31 = Unit.INSTANCE;
                    Unit unit32 = Unit.INSTANCE;
                }
            }
            final String externalurl = mTDeck2.getExternalurl();
            if (externalurl != null) {
                this.externalUrl = externalurl;
                EditText editText10 = editText2;
                editText10.setText(externalurl);
                final TextView textView19 = textView2;
                Boolean.valueOf(editText10.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$$ExternalSyntheticLambda38
                    @Override // java.lang.Runnable
                    public final void run() {
                        CreateDeckBottomSheetFragment.onViewCreated$lambda$35$2$5$0(this.f$0, externalurl, checkBox, textView19, checkBox2);
                    }
                }));
            }
            updatePlaymatPreview();
            String str4 = this.commander;
            if (str4 != null) {
                updateColorIdentity("commander", str4, 0, z);
                Unit unit33 = Unit.INSTANCE;
                Unit unit34 = Unit.INSTANCE;
            }
            String str5 = this.partner;
            if (str5 != null) {
                updateColorIdentity("partner", str5, 0, z);
                Unit unit35 = Unit.INSTANCE;
                Unit unit36 = Unit.INSTANCE;
            }
            updateSubmitButtonState();
            Unit unit37 = Unit.INSTANCE;
            Unit unit38 = Unit.INSTANCE;
        }
    }

    public final void setBackground(boolean z) {
        this.isBackground = z;
    }

    public final void setBracket(Integer num) {
        this.bracket = num;
    }

    public final void setCommander(String str) {
        this.commander = str;
    }

    public final void setCommanderCardId(String str) {
        this.commanderCardId = str;
    }

    public final void setCommanderColorOverride(String str) {
        this.commanderColorOverride = str;
    }

    public final void setCommanderIdentity(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.commanderIdentity = list;
    }

    public final void setCommanderLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.commanderLang = str;
    }

    public final void setCommanderPopupWindow(PopupWindow popupWindow) {
        this.commanderPopupWindow = popupWindow;
    }

    public final void setDbHelper(MTGDBHelper mTGDBHelper) {
        this.dbHelper = mTGDBHelper;
    }

    public final void setDeckName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deckName = str;
    }

    public final void setDeckNameWasTyped(boolean z) {
        this.deckNameWasTyped = z;
    }

    public final void setDeckType(int i) {
        this.deckType = i;
    }

    public final void setDoctor(boolean z) {
        this.isDoctor = z;
    }

    public final void setDoctorCompanion(boolean z) {
        this.isDoctorCompanion = z;
    }

    public final void setExternalUrl(String str) {
        this.externalUrl = str;
    }

    public final void setFormat(MTFormat mTFormat) {
        this.format = mTFormat;
    }

    public final void setFriendsForever(boolean z) {
        this.isFriendsForever = z;
    }

    public final void setLeftplaymat(String str) {
        this.leftplaymat = str;
    }

    public final void setLeftplaymatCardId(String str) {
        this.leftplaymatCardId = str;
    }

    public final void setLeftplaymatFaceIndex(Integer num) {
        this.leftplaymatFaceIndex = num;
    }

    public final void setLocalizedHelper(MTGDBHelperLocalized mTGDBHelperLocalized) {
        this.localizedHelper = mTGDBHelperLocalized;
    }

    public final void setLocalizedHelpers(List<MTGDBHelperLocalized> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.localizedHelpers = list;
    }

    public final void setPartner(String str) {
        this.partner = str;
    }

    public final void setPartner(boolean z) {
        this.isPartner = z;
    }

    public final void setPartnerCardId(String str) {
        this.partnerCardId = str;
    }

    public final void setPartnerColorOverride(String str) {
        this.partnerColorOverride = str;
    }

    public final void setPartnerIdentity(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.partnerIdentity = list;
    }

    public final void setPartnerLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.partnerLang = str;
    }

    public final void setPartnerPopupWindow(PopupWindow popupWindow) {
        this.partnerPopupWindow = popupWindow;
    }

    public final void setPartnerSignatureSpellCardId(String str) {
        this.partnerSignatureSpellCardId = str;
    }

    public final void setPartnersignaturespell(String str) {
        this.partnersignaturespell = str;
    }

    public final void setPlaymatCardPopupWindow(PopupWindow popupWindow) {
        this.playmatCardPopupWindow = popupWindow;
    }

    public final void setPlaymatLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playmatLang = str;
    }

    public final void setRightplaymat(String str) {
        this.rightplaymat = str;
    }

    public final void setRightplaymatCardId(String str) {
        this.rightplaymatCardId = str;
    }

    public final void setRightplaymatFaceIndex(Integer num) {
        this.rightplaymatFaceIndex = num;
    }

    public final void setSearchCommanderJob(Job job) {
        this.searchCommanderJob = job;
    }

    public final void setSearchPartnerJob(Job job) {
        this.searchPartnerJob = job;
    }

    public final void setSearchPlaymatCardJob(Job job) {
        this.searchPlaymatCardJob = job;
    }

    public final void setShouldAutoSync(boolean z) {
        this.shouldAutoSync = z;
    }

    public final void setShouldImport(boolean z) {
        this.shouldImport = z;
    }

    public final void setSignatureSpell(boolean z) {
        this.isSignatureSpell = z;
    }

    public final void setSignatureSpellCardId(String str) {
        this.signatureSpellCardId = str;
    }

    public final void setSignaturespell(String str) {
        this.signaturespell = str;
    }

    public final void setUpdatingCommander(boolean z) {
        this.updatingCommander = z;
    }

    public final void setUpdatingPartner(boolean z) {
        this.updatingPartner = z;
    }

    public final void updateCardId(final MTFullCard fullCard, final int face) {
        String scryfallid;
        Intrinsics.checkNotNullParameter(fullCard, "fullCard");
        String cardid = fullCard.getCardid();
        if ((cardid != null && cardid.length() != 0) || (scryfallid = fullCard.getScryfallid()) == null || scryfallid.length() == 0) {
            applyCardUpdate(fullCard, face);
            return;
        }
        MTApi mtApi = MTApiKt.getMtApi();
        String scryfallid2 = fullCard.getScryfallid();
        Intrinsics.checkNotNull(scryfallid2);
        mtApi.getCardByScryfallId(scryfallid2).enqueue(new Callback<MTCardResponse>() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment.updateCardId.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (CreateDeckBottomSheetFragment.this.getContext() == null) {
                    return;
                }
                CreateDeckBottomSheetFragment.this.applyCardUpdate(fullCard, face);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardResponse> call, Response<MTCardResponse> response) {
                MTFullCard card;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (CreateDeckBottomSheetFragment.this.getContext() == null) {
                    return;
                }
                CreateDeckBottomSheetFragment createDeckBottomSheetFragment = CreateDeckBottomSheetFragment.this;
                MTCardResponse mTCardResponseBody = response.body();
                if (mTCardResponseBody == null || (card = mTCardResponseBody.getCard()) == null) {
                    card = fullCard;
                }
                createDeckBottomSheetFragment.applyCardUpdate(card, face);
            }
        });
    }
}
