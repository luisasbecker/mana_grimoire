package androidx.compose.material3;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.DatePickerKt;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.Icons;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import org.opencv.imgcodecs.Imgcodecs;

/* JADX INFO: compiled from: DatePicker.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001aE\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001aO\u0010\u001f\u001a\u00020\u00032\n\u0010 \u001a\u00060!j\u0002`\"2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b#\u0010$\u001a\u0081\u0001\u0010%\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0004\b,\u0010-\u001a;\u0010.\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u001a2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0001012\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0004\b2\u00103\u001a£\u0001\u00104\u001a\u00020\u00012\b\u00105\u001a\u0004\u0018\u00010\u00152\u0006\u00106\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u001a2#\u00107\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\b?\u0010@\u001a\u008d\u0001\u0010A\u001a\u00020\u00012\b\u00105\u001a\u0004\u0018\u00010\u00152\u0006\u00106\u001a\u00020\u00152!\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010B\u001aW\u0010C\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0004\bH\u0010I\u001a\u008d\u0001\u0010J\u001a\u00020\u00012\u0006\u0010K\u001a\u00020L2\b\u00105\u001a\u0004\u0018\u00010\u00152!\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010M\u001aI\u0010N\u001a\u00020\u00012\u0006\u0010K\u001a\u00020L2!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0017\u001a\u00020\u0018H\u0080@¢\u0006\u0002\u0010O\u001a\u001d\u0010P\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\u0010Q\u001a\u0082\u0001\u0010R\u001a\u00020\u00012\u0006\u0010S\u001a\u00020T2!\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012\u0006\u0010U\u001a\u00020\u00152\b\u0010V\u001a\u0004\u0018\u00010\u00152\b\u0010W\u001a\u0004\u0018\u00010\u00152\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\n\u0010 \u001a\u00060!j\u0002`\"H\u0001¢\u0006\u0002\u0010Z\u001a\u0010\u0010[\u001a\u00020\\2\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a7\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\u000f2\u0006\u0010b\u001a\u00020\u000f2\u0006\u0010c\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010d\u001ac\u0010e\u001a\u00020\u00012\u0006\u0010f\u001a\u00020^2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u000f2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010i\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020^2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010n\u001a`\u0010o\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00152!\u0010p\u001a\u001d\u0012\u0013\u0012\u00110\\¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(q\u0012\u0004\u0012\u00020\u0001012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010r\u001aS\u0010s\u001a\u00020\u00012\u0006\u0010f\u001a\u00020^2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u000f2\u0006\u0010t\u001a\u00020\u000f2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010j\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020^2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010u\u001ag\u0010v\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010w\u001a\u00020\u000f2\u0006\u0010x\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020\u000f2\u0006\u0010z\u001a\u00020^2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010~\u001aB\u0010\u007f\u001a\u00020\u00012\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0007\u0010\u0080\u0001\u001a\u00020\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0003\u0010\u0081\u0001\u001aD\u0010\u0082\u0001\u001a\u00020\u00012\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020^2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010j\u001a\u00020\u000fH\u0003¢\u0006\u0003\u0010\u0086\u0001\"\u001a\u0010\u0087\u0001\u001a\u00020*X\u0080\u0004¢\u0006\r\n\u0003\u0010\u008a\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u001a\u0010\u008b\u0001\u001a\u00020*X\u0080\u0004¢\u0006\r\n\u0003\u0010\u008a\u0001\u001a\u0006\b\u008c\u0001\u0010\u0089\u0001\"\u001a\u0010\u008d\u0001\u001a\u00020*X\u0080\u0004¢\u0006\r\n\u0003\u0010\u008a\u0001\u001a\u0006\b\u008e\u0001\u0010\u0089\u0001\"\u0018\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0010\u0010\u0093\u0001\u001a\u00030\u0090\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0094\u0001\u001a\u00030\u0090\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\u0095\u0001\u001a\u00020*X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008a\u0001\"\u000f\u0010\u0096\u0001\u001a\u00020\\X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0097\u0001\u001a\u00020\\X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0098\u0001²\u0006\n\u0010y\u001a\u00020\u000fX\u008a\u008e\u0002"}, d2 = {"DatePicker", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material3/DatePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "colors", "Landroidx/compose/material3/DatePickerColors;", Constants.GP_IAP_TITLE, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "rememberDatePickerState", "initialSelectedDateMillis", "", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "rememberDatePickerState-EU0dCGE", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerState;", "DatePickerState", AndroidContextPlugin.LOCALE_KEY, "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DatePickerState-sHin3Bw", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DatePickerState;", "DateEntryContainer", "modeToggleButton", "headlineTextStyle", "Landroidx/compose/ui/text/TextStyle;", "headerMinHeight", "Landroidx/compose/ui/unit/Dp;", FirebaseAnalytics.Param.CONTENT, "DateEntryContainer-au3_HiA", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DisplayModeToggleButton", "displayMode", "onDisplayModeChange", "Lkotlin/Function1;", "DisplayModeToggleButton-iUJLfQg", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "SwitchableDateEntryContent", "selectedDateMillis", "displayedMonthMillis", "onDateSelectionChange", "Lkotlin/ParameterName;", "name", "dateInMillis", "onDisplayedMonthChange", "monthInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "SwitchableDateEntryContent-KaiTk9E", "(Ljava/lang/Long;JILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "DatePickerContent", "(Ljava/lang/Long;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DatePickerHeader", "titleContentColor", "Landroidx/compose/ui/graphics/Color;", "headlineContentColor", "minHeight", "DatePickerHeader-pc5RIQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "HorizontalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "updateDisplayedMonth", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "WeekDays", "(Landroidx/compose/material3/DatePickerColors;Landroidx/compose/material3/internal/CalendarModel;Landroidx/compose/runtime/Composer;I)V", "Month", "month", "Landroidx/compose/material3/internal/CalendarMonth;", "todayMillis", "startDateMillis", "endDateMillis", "rangeSelectionInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "(Landroidx/compose/material3/internal/CalendarMonth;Lkotlin/jvm/functions/Function1;JLjava/lang/Long;Ljava/lang/Long;Landroidx/compose/material3/SelectedRangeInfo;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Ljava/util/Locale;Landroidx/compose/runtime/Composer;I)V", "numberOfMonthsInRange", "", "dayContentDescription", "", "rangeSelectionEnabled", "isToday", "isStartDate", "isEndDate", "isInRange", "(ZZZZZLandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "Day", "text", "selected", "onClick", "animateChecked", "enabled", "today", "inRange", "description", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;ZZZZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "YearPicker", "onYearSelected", "year", "(Landroidx/compose/ui/Modifier;JLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "Year", "currentYear", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function0;ZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "MonthsNavigation", "nextAvailable", "previousAvailable", "yearPickerVisible", "yearPickerText", "onNextClicked", "onPreviousClicked", "onYearPickerButtonClicked", "(Landroidx/compose/ui/Modifier;ZZZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "YearPickerMenuButton", "expanded", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconButtonWithTooltip", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "contentDescription", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "RecommendedSizeForAccessibility", "getRecommendedSizeForAccessibility", "()F", "F", "MonthYearHeight", "getMonthYearHeight", "DatePickerHorizontalPadding", "getDatePickerHorizontalPadding", "DatePickerModeTogglePadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getDatePickerModeTogglePadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerTitlePadding", "DatePickerHeadlinePadding", "YearsVerticalPadding", "MaxCalendarRows", "YearsInRow", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DatePickerKt {
    private static final int MaxCalendarRows = 6;
    private static final int YearsInRow = 3;
    private static final float RecommendedSizeForAccessibility = Dp.m9114constructorimpl(48.0f);
    private static final float MonthYearHeight = Dp.m9114constructorimpl(56.0f);
    private static final float DatePickerHorizontalPadding = Dp.m9114constructorimpl(12.0f);
    private static final PaddingValues DatePickerModeTogglePadding = PaddingKt.m2034PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m9114constructorimpl(12.0f), Dp.m9114constructorimpl(12.0f), 3, null);
    private static final PaddingValues DatePickerTitlePadding = PaddingKt.m2034PaddingValuesa9UjIt4$default(Dp.m9114constructorimpl(24.0f), Dp.m9114constructorimpl(16.0f), Dp.m9114constructorimpl(12.0f), 0.0f, 8, null);
    private static final PaddingValues DatePickerHeadlinePadding = PaddingKt.m2034PaddingValuesa9UjIt4$default(Dp.m9114constructorimpl(24.0f), 0.0f, Dp.m9114constructorimpl(12.0f), Dp.m9114constructorimpl(12.0f), 2, null);
    private static final float YearsVerticalPadding = Dp.m9114constructorimpl(16.0f);

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePicker$5, reason: invalid class name */
    /* JADX INFO: compiled from: DatePicker.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass5 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerState $state;

        AnonymousClass5(DatePickerState datePickerState, DatePickerColors datePickerColors) {
            this.$state = datePickerState;
            this.$colors = datePickerColors;
        }

        static final Unit invoke$lambda$1$lambda$0(DatePickerState datePickerState, DisplayMode displayMode) {
            datePickerState.mo3574setDisplayModevCnGnXg(displayMode.getValue());
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C209@9650L50,206@9440L324:DatePicker.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1483431603, i, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:206)");
            }
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
            int iMo3573getDisplayModejFl4v0 = this.$state.mo3573getDisplayModejFl4v0();
            ComposerKt.sourceInformationMarkerStart(composer, 351379263, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged = composer.changed(this.$state);
            final DatePickerState datePickerState = this.$state;
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.AnonymousClass5.invoke$lambda$1$lambda$0(datePickerState, (DisplayMode) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DatePickerKt.m3568DisplayModeToggleButtoniUJLfQg(modifierPadding, iMo3573getDisplayModejFl4v0, (Function1) objRememberedValue, this.$colors, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePicker$6, reason: invalid class name */
    /* JADX INFO: compiled from: DatePicker.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass6 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ CalendarModel $calendarModel;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ FocusRequester $focusRequester;
        final /* synthetic */ DatePickerState $state;

        AnonymousClass6(DatePickerState datePickerState, CalendarModel calendarModel, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, FocusRequester focusRequester) {
            this.$state = datePickerState;
            this.$calendarModel = calendarModel;
            this.$dateFormatter = datePickerFormatter;
            this.$colors = datePickerColors;
            this.$focusRequester = focusRequester;
        }

        static final Unit invoke$lambda$1$lambda$0(DatePickerState datePickerState, Long l) {
            datePickerState.setSelectedDateMillis(l);
            return Unit.INSTANCE;
        }

        static final Unit invoke$lambda$3$lambda$2(DatePickerState datePickerState, long j) {
            datePickerState.setDisplayedMonthMillis(j);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C224@10259L59,225@10357L91,220@10028L685:DatePicker.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1346903698, i, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:220)");
            }
            Long selectedDateMillis = this.$state.getSelectedDateMillis();
            long displayedMonthMillis = this.$state.getDisplayedMonthMillis();
            int iMo3573getDisplayModejFl4v0 = this.$state.mo3573getDisplayModejFl4v0();
            ComposerKt.sourceInformationMarkerStart(composer, -1589289911, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged = composer.changed(this.$state);
            final DatePickerState datePickerState = this.$state;
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$6$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.AnonymousClass6.invoke$lambda$1$lambda$0(datePickerState, (Long) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1589286743, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged2 = composer.changed(this.$state);
            final DatePickerState datePickerState2 = this.$state;
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$6$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.AnonymousClass6.invoke$lambda$3$lambda$2(datePickerState2, ((Long) obj).longValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DatePickerKt.m3569SwitchableDateEntryContentKaiTk9E(selectedDateMillis, displayedMonthMillis, iMo3573getDisplayModejFl4v0, function1, (Function1) objRememberedValue2, this.$calendarModel, this.$state.getYearRange(), this.$dateFormatter, this.$state.getSelectableDates(), this.$colors, this.$focusRequester, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$Day$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DatePicker.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class C04302 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ boolean $inRange;
        final /* synthetic */ boolean $selected;
        final /* synthetic */ String $text;
        final /* synthetic */ boolean $today;

        C04302(String str, DatePickerColors datePickerColors, boolean z, boolean z2, boolean z3, boolean z4) {
            this.$text = str;
            this.$colors = datePickerColors;
            this.$today = z;
            this.$selected = z2;
            this.$inRange = z3;
            this.$enabled = z4;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C2032@92937L851:DatePicker.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1126347158, i, -1, "androidx.compose.material3.Day.<anonymous> (DatePicker.kt:2032)");
            }
            Modifier modifierM2077requiredSizeVpY3zN4 = SizeKt.m2077requiredSizeVpY3zN4(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m4904getDateContainerWidthD9Ej5fM(), DatePickerModalTokens.INSTANCE.m4903getDateContainerHeightD9Ej5fM());
            Alignment center = Alignment.INSTANCE.getCenter();
            String str = this.$text;
            DatePickerColors datePickerColors = this.$colors;
            boolean z = this.$today;
            boolean z2 = this.$selected;
            boolean z3 = this.$inRange;
            boolean z4 = this.$enabled;
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2077requiredSizeVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 781235302, "C2043@93376L2,2046@93456L230,2040@93221L557:DatePicker.kt#uh7d8r");
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1775909774, "CC(remember):DatePicker.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$Day$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m4288TextNvy7gAk(str, SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue), datePickerColors.dayContentColor$material3(z, z2, z3, z4, composer, 0).getValue().m6335unboximpl(), null, 0L, null, null, null, 0L, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 0, 0, 261112);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1, reason: invalid class name */
    /* JADX INFO: compiled from: DatePicker.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ CalendarModel $calendarModel;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ CalendarMonth $firstMonth;
        final /* synthetic */ LazyListState $lazyListState;
        final /* synthetic */ Function1<Long, Unit> $onDateSelectionChange;
        final /* synthetic */ SelectableDates $selectableDates;
        final /* synthetic */ Long $selectedDateMillis;
        final /* synthetic */ CalendarDate $today;
        final /* synthetic */ IntRange $yearRange;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(LazyListState lazyListState, IntRange intRange, CalendarModel calendarModel, CalendarMonth calendarMonth, Function1<? super Long, Unit> function1, CalendarDate calendarDate, Long l, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors) {
            this.$lazyListState = lazyListState;
            this.$yearRange = intRange;
            this.$calendarModel = calendarModel;
            this.$firstMonth = calendarMonth;
            this.$onDateSelectionChange = function1;
            this.$today = calendarDate;
            this.$selectedDateMillis = l;
            this.$dateFormatter = datePickerFormatter;
            this.$selectableDates = selectableDates;
            this.$colors = datePickerColors;
        }

        static final Unit invoke$lambda$3$lambda$2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            SemanticsPropertiesKt.setHorizontalScrollAxisRange(semanticsPropertyReceiver, new ScrollAxisRange(new Function0() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Float.valueOf(DatePickerKt.AnonymousClass1.invoke$lambda$3$lambda$2$lambda$0());
                }
            }, new Function0() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Float.valueOf(DatePickerKt.AnonymousClass1.invoke$lambda$3$lambda$2$lambda$1());
                }
            }, false, 4, null));
            return Unit.INSTANCE;
        }

        static final float invoke$lambda$3$lambda$2$lambda$0() {
            return 0.0f;
        }

        static final float invoke$lambda$3$lambda$2$lambda$1() {
            return 0.0f;
        }

        static final Unit invoke$lambda$5$lambda$4(IntRange intRange, final CalendarModel calendarModel, final CalendarMonth calendarMonth, final Function1 function1, final CalendarDate calendarDate, final Long l, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, LazyListScope lazyListScope) {
            LazyListScope.items$default(lazyListScope, DatePickerKt.numberOfMonthsInRange(intRange), null, null, ComposableLambdaKt.composableLambdaInstance(72599078, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1$2$1$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                    int i3;
                    ComposerKt.sourceInformation(composer, "CN(it)1734@80317L652:DatePicker.kt#uh7d8r");
                    if ((i2 & 6) == 0) {
                        i3 = i2 | (composer.changed(lazyItemScope) ? 4 : 2);
                    } else {
                        i3 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        i3 |= composer.changed(i) ? 32 : 16;
                    }
                    if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(72599078, i3, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1733)");
                    }
                    CalendarMonth calendarMonthPlusMonths = calendarModel.plusMonths(calendarMonth, i);
                    Modifier modifierFillParentMaxWidth$default = LazyItemScope.fillParentMaxWidth$default(lazyItemScope, Modifier.INSTANCE, 0.0f, 1, null);
                    Function1<Long, Unit> function12 = function1;
                    CalendarDate calendarDate2 = calendarDate;
                    Long l2 = l;
                    DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
                    SelectableDates selectableDates2 = selectableDates;
                    DatePickerColors datePickerColors2 = datePickerColors;
                    CalendarModel calendarModel2 = calendarModel;
                    ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillParentMaxWidth$default);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor);
                    } else {
                        composer.useNode();
                    }
                    Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer);
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer, -438536543, "C1735@80385L566:DatePicker.kt#uh7d8r");
                    DatePickerKt.Month(calendarMonthPlusMonths, function12, calendarDate2.getUtcTimeMillis(), l2, null, null, datePickerFormatter2, selectableDates2, datePickerColors2, calendarModel2.getLocale(), composer, 221184);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 6, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C1726@79896L118,1730@80098L40,1731@80150L843,1721@79587L1406:DatePicker.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1504086906, i, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous> (DatePicker.kt:1721)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1976451760, "CC(remember):DatePicker.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.AnonymousClass1.invoke$lambda$3$lambda$2((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
            LazyListState lazyListState = this.$lazyListState;
            FlingBehavior flingBehaviorRememberSnapFlingBehavior$material3 = DatePickerDefaults.INSTANCE.rememberSnapFlingBehavior$material3(this.$lazyListState, null, composer, 384, 2);
            ComposerKt.sourceInformationMarkerStart(composer, -1976442907, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(this.$yearRange) | composer.changedInstance(this.$calendarModel) | composer.changed(this.$firstMonth) | composer.changed(this.$onDateSelectionChange) | composer.changed(this.$today) | composer.changed(this.$selectedDateMillis) | composer.changedInstance(this.$dateFormatter) | composer.changed(this.$selectableDates) | composer.changed(this.$colors);
            final IntRange intRange = this.$yearRange;
            final CalendarModel calendarModel = this.$calendarModel;
            final CalendarMonth calendarMonth = this.$firstMonth;
            final Function1<Long, Unit> function1 = this.$onDateSelectionChange;
            final CalendarDate calendarDate = this.$today;
            final Long l = this.$selectedDateMillis;
            final DatePickerFormatter datePickerFormatter = this.$dateFormatter;
            final SelectableDates selectableDates = this.$selectableDates;
            final DatePickerColors datePickerColors = this.$colors;
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function1 function12 = new Function1() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.AnonymousClass1.invoke$lambda$5$lambda$4(intRange, calendarModel, calendarMonth, function1, calendarDate, l, datePickerFormatter, selectableDates, datePickerColors, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(function12);
                objRememberedValue2 = function12;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LazyDslKt.LazyRow(modifierSemantics$default, lazyListState, null, false, null, null, flingBehaviorRememberSnapFlingBehavior$material3, false, null, (Function1) objRememberedValue2, composer, 0, 444);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$Year$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DatePicker.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class C04332 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ boolean $currentYear;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ boolean $selected;
        final /* synthetic */ String $text;

        C04332(String str, DatePickerColors datePickerColors, boolean z, boolean z2, boolean z3) {
            this.$text = str;
            this.$colors = datePickerColors;
            this.$currentYear = z;
            this.$selected = z2;
            this.$enabled = z3;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C2157@97703L622:DatePicker.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-564400443, i, -1, "androidx.compose.material3.Year.<anonymous> (DatePicker.kt:2157)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            String str = this.$text;
            DatePickerColors datePickerColors = this.$colors;
            boolean z = this.$currentYear;
            boolean z2 = this.$selected;
            boolean z3 = this.$enabled;
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1181166895, "C2161@97949L2,2164@98029L194,2158@97794L521:DatePicker.kt#uh7d8r");
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1901556051, "CC(remember):DatePicker.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$Year$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m4288TextNvy7gAk(str, SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue), datePickerColors.yearContentColor$material3(z, z2, z3, composer, 0).getValue().m6335unboximpl(), null, 0L, null, null, null, 0L, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 0, 0, 261112);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$YearPicker$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DatePicker.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class C04341 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ CalendarModel $calendarModel;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ long $displayedMonthMillis;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Function1<Integer, Unit> $onYearSelected;
        final /* synthetic */ SelectableDates $selectableDates;
        final /* synthetic */ IntRange $yearRange;

        /* JADX WARN: Multi-variable type inference failed */
        C04341(CalendarModel calendarModel, long j, IntRange intRange, Modifier modifier, DatePickerColors datePickerColors, Function1<? super Integer, Unit> function1, SelectableDates selectableDates) {
            this.$calendarModel = calendarModel;
            this.$displayedMonthMillis = j;
            this.$yearRange = intRange;
            this.$modifier = modifier;
            this.$colors = datePickerColors;
            this.$onYearSelected = function1;
            this.$selectableDates = selectableDates;
        }

        static final Unit invoke$lambda$1$lambda$0(IntRange intRange, CalendarModel calendarModel, int i, int i2, Function1 function1, SelectableDates selectableDates, DatePickerColors datePickerColors, LazyGridScope lazyGridScope) {
            LazyGridScope.items$default(lazyGridScope, CollectionsKt.count(intRange), null, null, null, ComposableLambdaKt.composableLambdaInstance(674613074, true, new DatePickerKt$YearPicker$1$1$1$1(intRange, calendarModel, i, i2, function1, selectableDates, datePickerColors)), 14, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C2073@94342L281,2086@95071L1131,2078@94632L1570:DatePicker.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1301915789, i, -1, "androidx.compose.material3.YearPicker.<anonymous> (DatePicker.kt:2070)");
            }
            CalendarModel calendarModel = this.$calendarModel;
            final int year = calendarModel.getMonth(calendarModel.getToday()).getYear();
            final int year2 = this.$calendarModel.getMonth(this.$displayedMonthMillis).getYear();
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(Math.max(0, (year2 - this.$yearRange.getFirst()) - 3), 0, composer, 0, 2);
            GridCells.Fixed fixed = new GridCells.Fixed(3);
            Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(this.$modifier, this.$colors.getContainerColor(), null, 2, null);
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            GridCells.Fixed fixed2 = fixed;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(DatePickerKt.YearsVerticalPadding);
            Arrangement.HorizontalOrVertical horizontalOrVertical = spaceEvenly;
            ComposerKt.sourceInformationMarkerStart(composer, 1305620792, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(this.$yearRange) | composer.changedInstance(this.$calendarModel) | composer.changed(year2) | composer.changed(year) | composer.changed(this.$onYearSelected) | composer.changed(this.$selectableDates) | composer.changed(this.$colors);
            final IntRange intRange = this.$yearRange;
            final CalendarModel calendarModel2 = this.$calendarModel;
            final Function1<Integer, Unit> function1 = this.$onYearSelected;
            final SelectableDates selectableDates = this.$selectableDates;
            final DatePickerColors datePickerColors = this.$colors;
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Function1 function12 = new Function1() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.C04341.invoke$lambda$1$lambda$0(intRange, calendarModel2, year2, year, function1, selectableDates, datePickerColors, (LazyGridScope) obj);
                    }
                };
                composer.updateRememberedValue(function12);
                objRememberedValue = function12;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LazyGridDslKt.LazyVerticalGrid(fixed2, modifierM1483backgroundbw27NRU$default, lazyGridStateRememberLazyGridState, null, false, horizontalOrVerticalM1907spacedBy0680j_4, horizontalOrVertical, null, false, null, (Function1) objRememberedValue, composer, 1769472, 0, 920);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: DateEntryContainer-au3_HiA, reason: not valid java name */
    public static final void m3564DateEntryContainerau3_HiA(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final DatePickerColors datePickerColors, final TextStyle textStyle, final float f, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        DatePickerColors datePickerColors2;
        TextStyle textStyle2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1539132883);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateEntryContainer)N(modifier,title,headline,modeToggleButton,colors,headlineTextStyle,headerMinHeight:c#ui.unit.Dp,content)1356@63459L236,1352@63311L1910:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            function25 = function2;
            i2 |= composerStartRestartGroup.changedInstance(function25) ? 32 : 16;
        } else {
            function25 = function2;
        }
        if ((i & 384) == 0) {
            function26 = function22;
            i2 |= composerStartRestartGroup.changedInstance(function26) ? 256 : 128;
        } else {
            function26 = function22;
        }
        if ((i & 3072) == 0) {
            function27 = function23;
            i2 |= composerStartRestartGroup.changedInstance(function27) ? 2048 : 1024;
        } else {
            function27 = function23;
        }
        if ((i & 24576) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= composerStartRestartGroup.changed(datePickerColors2) ? 16384 : 8192;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((196608 & i) == 0) {
            textStyle2 = textStyle;
            i2 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
        } else {
            textStyle2 = textStyle;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if (composerStartRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1539132883, i2, -1, "androidx.compose.material3.DateEntryContainer (DatePicker.kt:1351)");
            }
            int i3 = i2;
            Modifier modifierM2087sizeInqDBjuR0$default = SizeKt.m2087sizeInqDBjuR0$default(modifier, DatePickerModalTokens.INSTANCE.m4902getContainerWidthD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1637966303, "CC(remember):DatePicker.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.DateEntryContainer_au3_HiA$lambda$8$lambda$7((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(SemanticsModifierKt.semantics$default(modifierM2087sizeInqDBjuR0$default, false, (Function1) objRememberedValue, 1, null), datePickerColors2.getContainerColor(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1483backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1831145178, "C1370@64014L1183,1364@63763L1434,1396@65206L9:DatePicker.kt#uh7d8r");
            final Function2<? super Composer, ? super Integer, Unit> function28 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function29 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function210 = function27;
            final DatePickerColors datePickerColors3 = datePickerColors2;
            final TextStyle textStyle3 = textStyle2;
            m3565DatePickerHeaderpc5RIQQ(Modifier.INSTANCE, function2, datePickerColors2.getTitleContentColor(), datePickerColors2.getHeadlineContentColor(), f, ComposableLambdaKt.rememberComposableLambda(-1658370654, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C1371@64028L1159:DatePicker.kt#uh7d8r");
                    if (!composer3.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1658370654, i4, -1, "androidx.compose.material3.DateEntryContainer.<anonymous>.<anonymous> (DatePicker.kt:1371)");
                    }
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    final Function2<Composer, Integer, Unit> function211 = function29;
                    Function2<Composer, Integer, Unit> function212 = function210;
                    Function2<Composer, Integer, Unit> function213 = function28;
                    DatePickerColors datePickerColors4 = datePickerColors3;
                    TextStyle textStyle4 = textStyle3;
                    ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor2);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer3);
                    Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -251319653, "C1378@64389L521:DatePicker.kt#uh7d8r");
                    Arrangement.HorizontalOrVertical start = (function211 == null || function212 == null) ? function211 != null ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getEnd() : Arrangement.INSTANCE.getSpaceBetween();
                    Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 48);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default2);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor3);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer3);
                    Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    final RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -516047984, "C:DatePicker.kt#uh7d8r");
                    if (function211 != null) {
                        composer3.startReplaceGroup(-516028300);
                        ComposerKt.sourceInformation(composer3, "1384@64717L106,1384@64673L150");
                        TextKt.ProvideTextStyle(textStyle4, ComposableLambdaKt.rememberComposableLambda(-738208900, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$2$1$1$1$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i5) {
                                ComposerKt.sourceInformation(composer4, "C1385@64747L50:DatePicker.kt#uh7d8r");
                                if (!composer4.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-738208900, i5, -1, "androidx.compose.material3.DateEntryContainer.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1385)");
                                }
                                Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                Function2<Composer, Integer, Unit> function214 = function211;
                                ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer4, modifierWeight$default);
                                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor4);
                                } else {
                                    composer4.useNode();
                                }
                                Composer composerM5595constructorimpl4 = Updater.m5595constructorimpl(composer4);
                                Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                    composerM5595constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                    composerM5595constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, -1330662525, "C1385@64785L10:DatePicker.kt#uh7d8r");
                                function214.invoke(composer4, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, 48);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-515838022);
                        composer3.endReplaceGroup();
                    }
                    if (function212 == null) {
                        composer3.startReplaceGroup(-515799087);
                    } else {
                        composer3.startReplaceGroup(260455984);
                        ComposerKt.sourceInformation(composer3, "1388@64884L8");
                        function212.invoke(composer3, 0);
                    }
                    composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (function213 == null && function211 == null && function212 == null) {
                        composer3.startReplaceGroup(-250277930);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-250360576);
                        ComposerKt.sourceInformation(composer3, "1392@65109L46");
                        DividerKt.m3615HorizontalDivider9IZ8Weo(null, 0.0f, datePickerColors4.getDividerColor(), composer3, 0, 3);
                        composer3.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 112) | 196614 | (57344 & (i3 >> 6)));
            composer2 = composerStartRestartGroup;
            function24.invoke(composer2, Integer.valueOf((i3 >> 21) & 14));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.DateEntryContainer_au3_HiA$lambda$10(modifier, function2, function22, function23, datePickerColors, textStyle, f, function24, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit DateEntryContainer_au3_HiA$lambda$10(Modifier modifier, Function2 function2, Function2 function22, Function2 function23, DatePickerColors datePickerColors, TextStyle textStyle, float f, Function2 function24, int i, Composer composer, int i2) {
        m3564DateEntryContainerau3_HiA(modifier, function2, function22, function23, datePickerColors, textStyle, f, function24, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit DateEntryContainer_au3_HiA$lambda$8$lambda$7(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DatePicker(final DatePickerState datePickerState, Modifier modifier, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z, FocusRequester focusRequester, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        DatePickerColors datePickerColors2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda2;
        int i6;
        boolean z2;
        int i7;
        Composer composer2;
        final DatePickerFormatter datePickerFormatter2;
        final FocusRequester focusRequester2;
        final Modifier modifier3;
        final DatePickerColors datePickerColors3;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final DatePickerFormatter datePickerFormatter3;
        final DatePickerColors datePickerColorsColors;
        int i8;
        boolean z4;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function24;
        boolean z5;
        DatePickerColors datePickerColors4;
        Modifier modifier4;
        int i10;
        FocusRequester focusRequester3;
        DatePickerFormatter datePickerFormatter4;
        ComposableLambda composableLambdaRememberComposableLambda;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(1105472031);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DatePicker)N(state,modifier,dateFormatter,colors,title,headline,showModeToggle,focusRequester)192@9028L207,216@9909L5,219@10018L701,199@9240L1479:DatePicker.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(datePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) != 0) {
                    i11 = 128;
                    i3 |= i11;
                } else {
                    if ((i & 512) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter)) {
                        i11 = 256;
                    }
                    i3 |= i11;
                }
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    datePickerColors2 = datePickerColors;
                    int i13 = composerStartRestartGroup.changed(datePickerColors2) ? 2048 : 1024;
                    i3 |= i13;
                } else {
                    datePickerColors2 = datePickerColors;
                }
                i3 |= i13;
            } else {
                datePickerColors2 = datePickerColors;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    function2RememberComposableLambda = function2;
                    i3 |= composerStartRestartGroup.changedInstance(function2RememberComposableLambda) ? 16384 : 8192;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i) == 0) {
                        function2RememberComposableLambda2 = function22;
                        i3 |= composerStartRestartGroup.changedInstance(function2RememberComposableLambda2) ? 131072 : 65536;
                    }
                    i6 = i2 & 64;
                    if (i6 != 0) {
                        if ((1572864 & i) == 0) {
                            z2 = z;
                            i3 |= composerStartRestartGroup.changed(z2) ? 1048576 : 524288;
                        }
                        i7 = i2 & 128;
                        if (i7 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i3 |= composerStartRestartGroup.changed(focusRequester) ? 8388608 : 4194304;
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "170@8134L47,171@8233L8,172@8282L224,179@8550L335,189@8961L29");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i2 & 4) != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703950, "CC(remember):DatePicker.kt#9igjgp");
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    datePickerFormatter3 = (DatePickerFormatter) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    i3 &= -897;
                                } else {
                                    datePickerFormatter3 = datePickerFormatter;
                                }
                                if ((i2 & 8) != 0) {
                                    datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    i3 &= -7169;
                                } else {
                                    datePickerColorsColors = datePickerColors2;
                                }
                                if (i4 != 0) {
                                    i8 = i3;
                                    z4 = true;
                                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt.DatePicker.2
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i14) {
                                            ComposerKt.sourceInformation(composer3, "C173@8311L189:DatePicker.kt#uh7d8r");
                                            if (!composer3.shouldExecute((i14 & 3) != 2, i14 & 1)) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1655706771, i14, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:173)");
                                            }
                                            DatePickerDefaults.INSTANCE.m3560DatePickerTitleFNtVw6o(datePickerState.mo3573getDisplayModejFl4v0(), PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.DatePickerTitlePadding), datePickerColorsColors.getTitleContentColor(), composer3, 3120, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54);
                                    i9 = 54;
                                } else {
                                    i8 = i3;
                                    z4 = true;
                                    i9 = 54;
                                }
                                if (i5 != 0) {
                                    function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt.DatePicker.3
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i14) {
                                            ComposerKt.sourceInformation(composer3, "C180@8579L300:DatePicker.kt#uh7d8r");
                                            if (!composer3.shouldExecute((i14 & 3) != 2, i14 & 1)) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1439279037, i14, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:180)");
                                            }
                                            DatePickerDefaults.INSTANCE.m3559DatePickerHeadlineISIPfiY(datePickerState.getSelectedDateMillis(), datePickerState.mo3573getDisplayModejFl4v0(), datePickerFormatter3, PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.DatePickerHeadlinePadding), datePickerColorsColors.getHeadlineContentColor(), composer3, 199680, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, i9);
                                }
                                if (i6 != 0) {
                                    z2 = true;
                                }
                                if (i7 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730396, "CC(remember):DatePicker.kt#9igjgp");
                                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new FocusRequester();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    DatePickerColors datePickerColors5 = datePickerColorsColors;
                                    focusRequester3 = (FocusRequester) objRememberedValue2;
                                    z5 = z2;
                                    datePickerColors4 = datePickerColors5;
                                    function24 = function2RememberComposableLambda;
                                    modifier4 = modifier2;
                                    i10 = i8;
                                } else {
                                    function24 = function2RememberComposableLambda;
                                    z5 = z2;
                                    datePickerColors4 = datePickerColorsColors;
                                    modifier4 = modifier2;
                                    i10 = i8;
                                    focusRequester3 = focusRequester;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                datePickerFormatter3 = datePickerFormatter;
                                focusRequester3 = focusRequester;
                                function24 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i10 = i3;
                                z5 = z2;
                                datePickerColors4 = datePickerColors2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1105472031, i10, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:190)");
                            }
                            Locale locale = datePickerState.getLocale();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732718, "CC(remember):DatePicker.kt#9igjgp");
                            boolean zChanged = composerStartRestartGroup.changed(locale);
                            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = datePickerState instanceof BaseDatePickerStateImpl ? ((BaseDatePickerStateImpl) datePickerState).getCalendarModel() : CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            CalendarModel calendarModel = (CalendarModel) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z5) {
                                composerStartRestartGroup.startReplaceGroup(-690551113);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "205@9418L364");
                                datePickerFormatter4 = datePickerFormatter3;
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new AnonymousClass5(datePickerState, datePickerColors4), composerStartRestartGroup, 54);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                datePickerFormatter4 = datePickerFormatter3;
                                composerStartRestartGroup.startReplaceGroup(-690163489);
                                composerStartRestartGroup.endReplaceGroup();
                                composableLambdaRememberComposableLambda = null;
                            }
                            FocusRequester focusRequester4 = focusRequester3;
                            DatePickerFormatter datePickerFormatter5 = datePickerFormatter4;
                            int i14 = i10 >> 9;
                            composer2 = composerStartRestartGroup;
                            m3564DateEntryContainerau3_HiA(modifier4, function24, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6), DatePickerModalTokens.INSTANCE.m4908getHeaderContainerHeightD9Ej5fM(), ComposableLambdaKt.rememberComposableLambda(-1346903698, true, new AnonymousClass6(datePickerState, calendarModel, datePickerFormatter4, datePickerColors4, focusRequester4), composerStartRestartGroup, 54), composer2, ((i10 >> 3) & 14) | 14155776 | (i14 & 112) | (i14 & 896) | (57344 & (i10 << 3)));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            datePickerFormatter2 = datePickerFormatter5;
                            focusRequester2 = focusRequester4;
                            z3 = z5;
                            modifier3 = modifier4;
                            function23 = function24;
                            datePickerColors3 = datePickerColors4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            datePickerFormatter2 = datePickerFormatter;
                            focusRequester2 = focusRequester;
                            modifier3 = modifier2;
                            datePickerColors3 = datePickerColors2;
                            function23 = function2RememberComposableLambda;
                            z3 = z2;
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function25 = function2RememberComposableLambda2;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$3(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function23, function25, z3, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 1572864;
                    z2 = z;
                    i7 = i2 & 128;
                    if (i7 != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                    }
                    final Function2 function252 = function2RememberComposableLambda2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function2RememberComposableLambda2 = function22;
                i6 = i2 & 64;
                if (i6 != 0) {
                }
                z2 = z;
                i7 = i2 & 128;
                if (i7 != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                }
                final Function2 function2522 = function2RememberComposableLambda2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function2RememberComposableLambda = function2;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            function2RememberComposableLambda2 = function22;
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            z2 = z;
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            }
            final Function2 function25222 = function2RememberComposableLambda2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) == 0) {
        }
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        function2RememberComposableLambda = function2;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        function2RememberComposableLambda2 = function22;
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        z2 = z;
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
        }
        final Function2 function252222 = function2RememberComposableLambda2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit DatePicker$lambda$3(DatePickerState datePickerState, Modifier modifier, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, Function2 function2, Function2 function22, boolean z, FocusRequester focusRequester, int i, int i2, Composer composer, int i3) {
        DatePicker(datePickerState, modifier, datePickerFormatter, datePickerColors, function2, function22, z, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DatePickerContent(final Long l, final long j, final Function1<? super Long, Unit> function1, final Function1<? super Long, Unit> function12, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-434467002);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DatePickerContent)N(selectedDateMillis,displayedMonthMillis,onDateSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors)1540@71327L64,1543@71481L466,1543@71454L493,1555@71974L24,1556@72045L25,1556@72028L42,1557@72075L5753:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(l) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(calendarModel) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(intRange) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= (2097152 & i) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(selectableDates) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 67108864 : 33554432;
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-434467002, i2, -1, "androidx.compose.material3.DatePickerContent (DatePicker.kt:1537)");
            }
            CalendarMonth month = calendarModel.getMonth(j);
            int iCoerceAtLeast = RangesKt.coerceAtLeast(month.indexIn(intRange), 0);
            final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(iCoerceAtLeast, 0, composerStartRestartGroup, 0, 2);
            Integer numValueOf = Integer.valueOf(iCoerceAtLeast);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -910937864, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(lazyListStateRememberLazyListState) | composerStartRestartGroup.changed(iCoerceAtLeast);
            DatePickerKt$DatePickerContent$1$1 datePickerKt$DatePickerContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || datePickerKt$DatePickerContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                datePickerKt$DatePickerContent$1$1RememberedValue = new DatePickerKt$DatePickerContent$1$1(lazyListStateRememberLazyListState, iCoerceAtLeast, null);
                composerStartRestartGroup.updateRememberedValue(datePickerKt$DatePickerContent$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) datePickerKt$DatePickerContent$1$1RememberedValue, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -910920257, "CC(remember):DatePicker.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            int i3 = i2;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -520273647, "C1568@72610L511,1580@73155L520,1592@73717L42,1558@72092L1707,1596@73809L4013:DatePicker.kt#uh7d8r");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f = DatePickerHorizontalPadding;
            Modifier modifierM2039paddingVpY3zN4$default = PaddingKt.m2039paddingVpY3zN4$default(companion2, f, 0.0f, 2, null);
            boolean canScrollForward = lazyListStateRememberLazyListState.getCanScrollForward();
            boolean canScrollBackward = lazyListStateRememberLazyListState.getCanScrollBackward();
            boolean zDatePickerContent$lambda$26 = DatePickerContent$lambda$26(mutableState);
            String monthYear = datePickerFormatter.formatMonthYear(Long.valueOf(j), calendarModel.getLocale());
            if (monthYear == null) {
                monthYear = "-";
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1125150321, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
            String str = monthYear;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerKt.DatePickerContent$lambda$36$lambda$29$lambda$28(coroutineScope, lazyListStateRememberLazyListState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function0 function0 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1125132872, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerKt.DatePickerContent$lambda$36$lambda$31$lambda$30(coroutineScope, lazyListStateRememberLazyListState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function0 function02 = (Function0) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1125115366, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerKt.DatePickerContent$lambda$36$lambda$33$lambda$32(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i4 = i3 & 234881024;
            MonthsNavigation(modifierM2039paddingVpY3zN4$default, canScrollForward, canScrollBackward, zDatePickerContent$lambda$26, str, function0, function02, (Function0) objRememberedValue5, datePickerColors, composerStartRestartGroup, i4 | 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1335239864, "C1597@73827L684,1613@74711L7,1615@74836L7,1617@74971L7,1627@75521L2291,1618@75018L2794:DatePicker.kt#uh7d8r");
            Modifier modifierM2039paddingVpY3zN4$default2 = PaddingKt.m2039paddingVpY3zN4$default(Modifier.INSTANCE, f, 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2039paddingVpY3zN4$default2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1070154161, "C1598@73923L31,1599@73971L526:DatePicker.kt#uh7d8r");
            WeekDays(datePickerColors, calendarModel, composerStartRestartGroup, ((i3 >> 24) & 14) | ((i3 >> 9) & 112));
            HorizontalMonthsList(lazyListStateRememberLazyListState, l, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composerStartRestartGroup, ((i3 << 3) & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | i4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
            FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            FiniteAnimationSpec finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
            AnimatedVisibilityKt.AnimatedVisibility(DatePickerContent$lambda$26(mutableState), ClipKt.clipToBounds(Modifier.INSTANCE), EnterExitTransitionKt.expandVertically$default(finiteAnimationSpecValue3, null, false, null, 14, null).plus(EnterExitTransitionKt.fadeIn(finiteAnimationSpecValue, 0.6f)), EnterExitTransitionKt.shrinkVertically$default(finiteAnimationSpecValue3, null, false, null, 14, null).plus(EnterExitTransitionKt.fadeOut$default(finiteAnimationSpecValue2, 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1193716082, true, new DatePickerKt$DatePickerContent$2$4$2(j, mutableState, coroutineScope, lazyListStateRememberLazyListState, intRange, month, selectableDates, calendarModel, datePickerColors), composerStartRestartGroup, 54), composerStartRestartGroup, 196656, 16);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.DatePickerContent$lambda$37(l, j, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DatePickerContent$lambda$26(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DatePickerContent$lambda$27(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final Unit DatePickerContent$lambda$36$lambda$29$lambda$28(CoroutineScope coroutineScope, LazyListState lazyListState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DatePickerKt$DatePickerContent$2$1$1$1(lazyListState, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit DatePickerContent$lambda$36$lambda$31$lambda$30(CoroutineScope coroutineScope, LazyListState lazyListState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DatePickerKt$DatePickerContent$2$2$1$1(lazyListState, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit DatePickerContent$lambda$36$lambda$33$lambda$32(MutableState mutableState) {
        DatePickerContent$lambda$27(mutableState, !DatePickerContent$lambda$26(mutableState));
        return Unit.INSTANCE;
    }

    static final Unit DatePickerContent$lambda$37(Long l, long j, Function1 function1, Function1 function12, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, int i, Composer composer, int i2) {
        DatePickerContent(l, j, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: DatePickerHeader-pc5RIQQ, reason: not valid java name */
    public static final void m3565DatePickerHeaderpc5RIQQ(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final long j, final long j2, final float f, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2020490761);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DatePickerHeader)N(modifier,title,titleContentColor:c#ui.graphics.Color,headlineContentColor:c#ui.graphics.Color,minHeight:c#ui.unit.Dp,content)1685@78288L540:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2020490761, i2, -1, "androidx.compose.material3.DatePickerHeader (DatePicker.kt:1677)");
            }
            Modifier modifierThen = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null).then(function2 != null ? SizeKt.m2068defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, f, 1, null) : Modifier.INSTANCE);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i3 = i2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 396879060, "C1695@78730L92:DatePicker.kt#uh7d8r");
            if (function2 != null) {
                composerStartRestartGroup.startReplaceGroup(396894187);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1690@78518L5,1691@78622L89,1691@78536L175");
                ProvideContentColorTextStyleKt.m4595ProvideContentColorTextStyle3JVO9M(j, TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderSupportingTextFont(), composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1344395458, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerHeader$1$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i4) {
                        ComposerKt.sourceInformation(composer2, "C1692@78640L57:DatePicker.kt#uh7d8r");
                        if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1344395458, i4, -1, "androidx.compose.material3.DatePickerHeader.<anonymous>.<anonymous> (DatePicker.kt:1692)");
                        }
                        Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                        Function2<Composer, Integer, Unit> function23 = function2;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart, false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer2);
                        Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 562743380, "C1692@78688L7:DatePicker.kt#uh7d8r");
                        function23.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 6) & 14) | 384);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(397163267);
                composerStartRestartGroup.endReplaceGroup();
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(j2)), function22, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.DatePickerHeader_pc5RIQQ$lambda$39(modifier, function2, j, j2, f, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit DatePickerHeader_pc5RIQQ$lambda$39(Modifier modifier, Function2 function2, long j, long j2, float f, Function2 function22, int i, Composer composer, int i2) {
        m3565DatePickerHeaderpc5RIQQ(modifier, function2, j, j2, f, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: DatePickerState-sHin3Bw, reason: not valid java name */
    public static final DatePickerState m3566DatePickerStatesHin3Bw(Locale locale, Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates) {
        return new DatePickerStateImpl(l, l2, intRange, i, selectableDates, locale, null);
    }

    /* JADX INFO: renamed from: DatePickerState-sHin3Bw$default, reason: not valid java name */
    public static /* synthetic */ DatePickerState m3567DatePickerStatesHin3Bw$default(Locale locale, Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = null;
        }
        if ((i2 & 4) != 0) {
            l2 = l;
        }
        if ((i2 & 8) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i2 & 16) != 0) {
            i = DisplayMode.INSTANCE.m3612getPickerjFl4v0();
        }
        if ((i2 & 32) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        SelectableDates selectableDates2 = selectableDates;
        IntRange intRange2 = intRange;
        return m3566DatePickerStatesHin3Bw(locale, l, l2, intRange2, i, selectableDates2);
    }

    private static final void Day(final String str, final Modifier modifier, final boolean z, final Function0<Unit> function0, final boolean z2, final boolean z3, final boolean z4, final boolean z5, final String str2, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        boolean z6;
        boolean z7;
        boolean z8;
        DatePickerColors datePickerColors2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-945355136);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Day)N(text,modifier,selected,onClick,animateChecked,enabled,today,inRange,description,colors)2012@92261L124,2017@92471L5,2020@92530L83,2031@92927L867,2004@91851L1943:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            z6 = z2;
            i2 |= composerStartRestartGroup.changed(z6) ? 16384 : 8192;
        } else {
            z6 = z2;
        }
        if ((196608 & i) == 0) {
            z7 = z3;
            i2 |= composerStartRestartGroup.changed(z7) ? 131072 : 65536;
        } else {
            z7 = z3;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z4) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            z8 = z5;
            i2 |= composerStartRestartGroup.changed(z8) ? 8388608 : 4194304;
        } else {
            z8 = z5;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= composerStartRestartGroup.changed(datePickerColors2) ? 536870912 : 268435456;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if (composerStartRestartGroup.shouldExecute((306783379 & i2) != 306783378, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-945355136, i2, -1, "androidx.compose.material3.Day (DatePicker.kt:2003)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2046803100, "CC(remember):DatePicker.kt#9igjgp");
            boolean z9 = (234881024 & i2) == 67108864;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z9 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.Day$lambda$61$lambda$60(str2, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier, true, (Function1) objRememberedValue);
            int i3 = i2 >> 6;
            SurfaceKt.m4146Surfaced85dljk(z, function0, modifierSemantics, z3, ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getDateContainerShape(), composerStartRestartGroup, 6), datePickerColors2.dayContainerColor$material3(z, z7, z6, composerStartRestartGroup, (i3 & 14) | ((i2 >> 12) & 112) | (i3 & 896) | ((i2 >> 18) & 7168)).getValue().m6335unboximpl(), 0L, 0.0f, 0.0f, (!z4 || z) ? null : BorderStrokeKt.m1509BorderStrokecXLIe8U(DatePickerModalTokens.INSTANCE.m4907getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors.getTodayDateBorderColor()), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1126347158, true, new C04302(str, datePickerColors, z4, z, z8, z3), composerStartRestartGroup, 54), composerStartRestartGroup, i3 & 7294, 48, 1472);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.Day$lambda$62(str, modifier, z, function0, z2, z3, z4, z5, str2, datePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit Day$lambda$61$lambda$60(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, new AnnotatedString(str, null, 2, null));
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8327getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Day$lambda$62(String str, Modifier modifier, boolean z, Function0 function0, boolean z2, boolean z3, boolean z4, boolean z5, String str2, DatePickerColors datePickerColors, int i, Composer composer, int i2) {
        Day(str, modifier, z, function0, z2, z3, z4, z5, str2, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: DisplayModeToggleButton-iUJLfQg, reason: not valid java name */
    public static final void m3568DisplayModeToggleButtoniUJLfQg(final Modifier modifier, final int i, final Function1<? super DisplayMode, Unit> function1, final DatePickerColors datePickerColors, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1461252485);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DisplayModeToggleButton)N(modifier,displayMode:c#material3.DisplayMode,onDisplayModeChange,colors)1407@65496L658,1407@65415L739:DatePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(datePickerColors) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1461252485, i3, -1, "androidx.compose.material3.DisplayModeToggleButton (DatePicker.kt:1406)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(datePickerColors.getHeadlineContentColor())), ComposableLambdaKt.rememberComposableLambda(-1734512197, true, new DatePickerKt$DisplayModeToggleButton$1(i, function1, modifier), composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.DisplayModeToggleButton_iUJLfQg$lambda$11(modifier, i, function1, datePickerColors, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit DisplayModeToggleButton_iUJLfQg$lambda$11(Modifier modifier, int i, Function1 function1, DatePickerColors datePickerColors, int i2, Composer composer, int i3) {
        m3568DisplayModeToggleButtoniUJLfQg(modifier, i, function1, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    private static final void HorizontalMonthsList(LazyListState lazyListState, final Long l, final Function1<? super Long, Unit> function1, final Function1<? super Long, Unit> function12, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Long l2;
        Function1<? super Long, Unit> function13;
        SelectableDates selectableDates2;
        DatePickerColors datePickerColors2;
        DatePickerKt$HorizontalMonthsList$2$1 datePickerKt$HorizontalMonthsList$2$1;
        final LazyListState lazyListState2 = lazyListState;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1994757941);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalMonthsList)N(lazyListState,selectedDateMillis,onDateSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors)1714@79349L159,1720@79570L5,1720@79577L1422,1720@79513L1486,1752@81035L229,1752@81005L259:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(lazyListState2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            l2 = l;
            i2 |= composerStartRestartGroup.changed(l2) ? 32 : 16;
        } else {
            l2 = l;
        }
        if ((i & 384) == 0) {
            function13 = function1;
            i2 |= composerStartRestartGroup.changedInstance(function13) ? 256 : 128;
        } else {
            function13 = function1;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(calendarModel) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(intRange) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= (2097152 & i) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            selectableDates2 = selectableDates;
            i2 |= composerStartRestartGroup.changed(selectableDates2) ? 8388608 : 4194304;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((100663296 & i) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= composerStartRestartGroup.changed(datePickerColors2) ? 67108864 : 33554432;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1994757941, i2, -1, "androidx.compose.material3.HorizontalMonthsList (DatePicker.kt:1711)");
            }
            CalendarDate today = calendarModel.getToday();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1406952310, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(intRange);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                CalendarMonth month = calendarModel.getMonth(intRange.getFirst(), 1);
                composerStartRestartGroup.updateRememberedValue(month);
                objRememberedValue = month;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2;
            TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getDateLabelTextFont(), composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1504086906, true, new AnonymousClass1(lazyListState2, intRange, calendarModel, (CalendarMonth) objRememberedValue, function13, today, l2, datePickerFormatter, selectableDates2, datePickerColors2), composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1406898288, "CC(remember):DatePicker.kt#9igjgp");
            int i4 = i3 & 14;
            boolean zChangedInstance = (i4 == 4) | ((i3 & 7168) == 2048) | composerStartRestartGroup.changedInstance(calendarModel) | composerStartRestartGroup.changedInstance(intRange);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                lazyListState2 = lazyListState;
                datePickerKt$HorizontalMonthsList$2$1 = new DatePickerKt$HorizontalMonthsList$2$1(lazyListState2, function12, calendarModel, intRange, null);
                composerStartRestartGroup.updateRememberedValue(datePickerKt$HorizontalMonthsList$2$1);
            } else {
                datePickerKt$HorizontalMonthsList$2$1 = objRememberedValue2;
                lazyListState2 = lazyListState;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(lazyListState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) datePickerKt$HorizontalMonthsList$2$1, composerStartRestartGroup, i4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.HorizontalMonthsList$lambda$42(lazyListState2, l, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit HorizontalMonthsList$lambda$42(LazyListState lazyListState, Long l, Function1 function1, Function1 function12, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, int i, Composer composer, int i2) {
        HorizontalMonthsList(lazyListState, l, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IconButtonWithTooltip(final Function0<Unit> function0, final ImageVector imageVector, final String str, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        final Function0<Unit> function02;
        int i3;
        final ImageVector imageVector2;
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        final Modifier modifier3;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-368059805);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconButtonWithTooltip)N(onClick,icon,contentDescription,modifier,enabled)2282@102053L60,2283@102133L45,2284@102196L22,2285@102226L175,2280@101986L415:DatePicker.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else if ((i & 6) == 0) {
            function02 = function0;
            i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
        } else {
            function02 = function0;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                imageVector2 = imageVector;
                i3 |= composerStartRestartGroup.changed(imageVector2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changed(str) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        z2 = z;
                        i3 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z3 = z2;
                    } else {
                        Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                        boolean z4 = i5 != 0 ? true : z2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368059805, i3, -1, "androidx.compose.material3.IconButtonWithTooltip (DatePicker.kt:2279)");
                        }
                        final Modifier modifier4 = companion;
                        final boolean z5 = z4;
                        TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4467rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4454getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-456272562, true, new Function3<TooltipScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt.IconButtonWithTooltip.1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(TooltipScope tooltipScope, Composer composer2, Integer num) {
                                invoke(tooltipScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(TooltipScope tooltipScope, Composer composer2, int i6) {
                                int i7;
                                ComposerKt.sourceInformation(composer2, "C2283@102148L28,2283@102135L41:DatePicker.kt#uh7d8r");
                                if ((i6 & 6) == 0) {
                                    i7 = i6 | ((i6 & 8) == 0 ? composer2.changed(tooltipScope) : composer2.changedInstance(tooltipScope) ? 4 : 2);
                                } else {
                                    i7 = i6;
                                }
                                if (!composer2.shouldExecute((i7 & 19) != 18, i7 & 1)) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-456272562, i7, -1, "androidx.compose.material3.IconButtonWithTooltip.<anonymous> (DatePicker.kt:2283)");
                                }
                                final String str2 = str;
                                TooltipKt.m4470PlainTooltipgv3ox5I(tooltipScope, null, null, 0.0f, null, 0L, 0L, 0.0f, 0.0f, ComposableLambdaKt.rememberComposableLambda(1905952188, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt.IconButtonWithTooltip.1.1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i8) {
                                        ComposerKt.sourceInformation(composer3, "C2283@102150L24:DatePicker.kt#uh7d8r");
                                        if (!composer3.shouldExecute((i8 & 3) != 2, i8 & 1)) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1905952188, i8, -1, "androidx.compose.material3.IconButtonWithTooltip.<anonymous>.<anonymous> (DatePicker.kt:2283)");
                                        }
                                        TextKt.m4288TextNvy7gAk(str2, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 262142);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), composer2, (i7 & 14) | 805306368, 255);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-1124908186, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt.IconButtonWithTooltip.2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i6) {
                                ComposerKt.sourceInformation(composer2, "C2286@102306L89,2286@102236L159:DatePicker.kt#uh7d8r");
                                if (!composer2.shouldExecute((i6 & 3) != 2, i6 & 1)) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1124908186, i6, -1, "androidx.compose.material3.IconButtonWithTooltip.<anonymous> (DatePicker.kt:2286)");
                                }
                                Function0<Unit> function03 = function02;
                                Modifier modifier5 = modifier4;
                                boolean z6 = z5;
                                final ImageVector imageVector3 = imageVector2;
                                final String str2 = str;
                                IconButtonKt.IconButton(function03, modifier5, z6, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1301085432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt.IconButtonWithTooltip.2.1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i7) {
                                        ComposerKt.sourceInformation(composer3, "C2287@102320L65:DatePicker.kt#uh7d8r");
                                        if (!composer3.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1301085432, i7, -1, "androidx.compose.material3.IconButtonWithTooltip.<anonymous>.<anonymous> (DatePicker.kt:2287)");
                                        }
                                        IconKt.m3736Iconww6aTOc(imageVector3, str2, (Modifier) null, 0L, composer3, 0, 12);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), composer2, 1572864, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, Imgcodecs.IMWRITE_PNG_ALL_FILTERS);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z3 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda28
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.IconButtonWithTooltip$lambda$71(function0, imageVector, str, modifier3, z3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                z2 = z;
                if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            z2 = z;
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        imageVector2 = imageVector;
        if ((i2 & 4) == 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        z2 = z;
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit IconButtonWithTooltip$lambda$71(Function0 function0, ImageVector imageVector, String str, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        IconButtonWithTooltip(function0, imageVector, str, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:174:0x03bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Month(final CalendarMonth calendarMonth, final Function1<? super Long, Unit> function1, final long j, final Long l, final Long l2, final SelectedRangeInfo selectedRangeInfo, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, final Locale locale, Composer composer, final int i) {
        CalendarMonth calendarMonth2;
        int i2;
        Composer composer2;
        int i3;
        Modifier.Companion companionDrawWithContent;
        String str;
        String str2;
        String str3;
        int i4;
        int i5;
        Composer composer3;
        int i6;
        String str4;
        int i7;
        boolean z;
        String str5;
        boolean z2;
        int i8;
        char c;
        boolean z3;
        String str6;
        Modifier.Companion companion;
        boolean z4;
        boolean z5;
        Object objMutableStateOf$default;
        final Function1<? super Long, Unit> function12 = function1;
        Locale locale2 = locale;
        Composer composerStartRestartGroup = composer.startRestartGroup(-333300603);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Month)N(month,onDateSelectionChange,todayMillis,startDateMillis,endDateMillis,rangeSelectionInfo,dateFormatter,selectableDates,colors,locale)1856@84862L5585:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            calendarMonth2 = calendarMonth;
            i2 = (composerStartRestartGroup.changed(calendarMonth2) ? 4 : 2) | i;
        } else {
            calendarMonth2 = calendarMonth;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(l) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(l2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(selectedRangeInfo) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= (2097152 & i) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(selectableDates) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(locale2) ? 536870912 : 268435456;
        }
        int i9 = i2;
        if (composerStartRestartGroup.shouldExecute((306783379 & i9) != 306783378, i9 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-333300603, i9, -1, "androidx.compose.material3.Month (DatePicker.kt:1844)");
            }
            String str7 = "CC(remember):DatePicker.kt#9igjgp";
            if (selectedRangeInfo != null) {
                composerStartRestartGroup.startReplaceGroup(606579709);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1847@84643L143");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                i3 = 458752;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1820683604, "CC(remember):DatePicker.kt#9igjgp");
                boolean z6 = ((i9 & 458752) == 131072) | ((234881024 & i9) == 67108864);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z6 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DatePickerKt.Month$lambda$51$lambda$50(selectedRangeInfo, datePickerColors, (ContentDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionDrawWithContent = DrawModifierKt.drawWithContent(companion2, (Function1) objRememberedValue);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                i3 = 458752;
                composerStartRestartGroup.startReplaceGroup(606771165);
                composerStartRestartGroup.endReplaceGroup();
                companionDrawWithContent = Modifier.INSTANCE;
            }
            Modifier modifierThen = SizeKt.m2072requiredHeight3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(RecommendedSizeForAccessibility * 6.0f)).then(companionDrawWithContent);
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceEvenly, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            String str8 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            String str9 = "C:DatePicker.kt#uh7d8r";
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 392093417, "C:DatePicker.kt#uh7d8r");
            composerStartRestartGroup.startReplaceGroup(-680088486);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*1863@85155L5276");
            int i10 = 0;
            int i11 = 0;
            int i12 = 6;
            while (i11 < i12) {
                int i13 = i10;
                int i14 = i11;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical spaceEvenly2 = Arrangement.INSTANCE.getSpaceEvenly();
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly2, centerVertically, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, str8);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 576651822, str9);
                composerStartRestartGroup.startReplaceGroup(1542622325);
                String str10 = "";
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                int i15 = i13;
                int i16 = 0;
                while (i16 < 7) {
                    if (i15 < calendarMonth2.getDaysFromStartOfWeekToFirstOfMonth() || i15 >= calendarMonth2.getDaysFromStartOfWeekToFirstOfMonth() + calendarMonth2.getNumberOfDays()) {
                        str = str10;
                        str2 = str7;
                        str3 = str9;
                        i4 = i15;
                        i5 = i16;
                        composer3 = composerStartRestartGroup;
                        i6 = i9;
                        str4 = str8;
                        composer3.startReplaceGroup(576825328);
                        ComposerKt.sourceInformation(composer3, "1886@86494L7,1887@86589L7,1879@86044L617");
                        Modifier modifierM2087sizeInqDBjuR0$default = SizeKt.m2087sizeInqDBjuR0$default(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m4904getDateContainerWidthD9Ej5fM(), DatePickerModalTokens.INSTANCE.m4903getDateContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null);
                        ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composer3.consume(localMinimumInteractiveComponentSize);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        float fM9128unboximpl = ((Dp) objConsume).m9128unboximpl();
                        ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composer3.consume(localMinimumInteractiveComponentSize2);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        SpacerKt.Spacer(SizeKt.m2085sizeVpY3zN4(modifierM2087sizeInqDBjuR0$default, fM9128unboximpl, ((Dp) objConsume2).m9128unboximpl()), composer3, 0);
                        composer3.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(577914947);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "1911@87935L366,1928@88871L39,1934@89278L567,1924@88619L1726");
                        int daysFromStartOfWeekToFirstOfMonth = i15 - calendarMonth2.getDaysFromStartOfWeekToFirstOfMonth();
                        str3 = str9;
                        i4 = i15;
                        final long startUtcTimeMillis = calendarMonth2.getStartUtcTimeMillis() + (((long) daysFromStartOfWeekToFirstOfMonth) * 86400000);
                        boolean z7 = startUtcTimeMillis == j;
                        if (l != null && startUtcTimeMillis == l.longValue()) {
                            i7 = i9;
                            z = true;
                        } else {
                            i7 = i9;
                            z = false;
                        }
                        if (l2 != null && startUtcTimeMillis == l2.longValue()) {
                            str5 = str8;
                            z2 = true;
                        } else {
                            str5 = str8;
                            z2 = false;
                        }
                        if (selectedRangeInfo != null) {
                            str = str10;
                            composerStartRestartGroup.startReplaceGroup(578361347);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1899@87271L435");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1542678452, str7);
                            i5 = i16;
                            boolean zChanged = ((i7 & i3) == 131072) | composerStartRestartGroup.changed(startUtcTimeMillis);
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                if (startUtcTimeMillis < (l != null ? l.longValue() : Long.MAX_VALUE)) {
                                    z5 = false;
                                    i8 = daysFromStartOfWeekToFirstOfMonth;
                                    c = 2;
                                    objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z5), null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objMutableStateOf$default);
                                } else {
                                    if (startUtcTimeMillis <= (l2 != null ? l2.longValue() : Long.MIN_VALUE)) {
                                        z5 = true;
                                    }
                                    i8 = daysFromStartOfWeekToFirstOfMonth;
                                    c = 2;
                                    objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z5), null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objMutableStateOf$default);
                                }
                            } else {
                                objMutableStateOf$default = objRememberedValue2;
                                i8 = daysFromStartOfWeekToFirstOfMonth;
                                c = 2;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            boolean zBooleanValue = ((Boolean) ((MutableState) objMutableStateOf$default).getValue()).booleanValue();
                            composerStartRestartGroup.endReplaceGroup();
                            z3 = zBooleanValue;
                        } else {
                            str = str10;
                            i5 = i16;
                            i8 = daysFromStartOfWeekToFirstOfMonth;
                            c = 2;
                            composerStartRestartGroup.startReplaceGroup(578890300);
                            composerStartRestartGroup.endReplaceGroup();
                            z3 = false;
                        }
                        Composer composer4 = composerStartRestartGroup;
                        int i17 = i7;
                        str4 = str5;
                        String strDayContentDescription = dayContentDescription(selectedRangeInfo != null, z7, z, z2, z3, composer4, 0);
                        boolean z8 = z7;
                        boolean z9 = z;
                        boolean z10 = z2;
                        boolean z11 = z3;
                        String date = datePickerFormatter.formatDate(Long.valueOf(startUtcTimeMillis), locale2, true);
                        if (date == null) {
                            date = str;
                        }
                        i6 = i17;
                        String str11 = date;
                        String localString$default = CalendarLocale_jvmKt.toLocalString$default(i8 + 1, 0, 0, false, locale2, 7, null);
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        if (z9 || z10) {
                            str6 = localString$default;
                            companion = companion3;
                            z4 = true;
                        } else {
                            str6 = localString$default;
                            companion = companion3;
                            z4 = false;
                        }
                        ComposerKt.sourceInformationMarkerStart(composer4, 1542729256, str7);
                        boolean zChanged2 = ((i6 & 112) == 32) | composer4.changed(startUtcTimeMillis);
                        Object objRememberedValue3 = composer4.rememberedValue();
                        if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return DatePickerKt.Month$lambda$58$lambda$57$lambda$54$lambda$53(function12, startUtcTimeMillis);
                                }
                            };
                            composer4.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function0 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerStart(composer4, 1542742808, str7);
                        str2 = str7;
                        boolean zChanged3 = ((i6 & 29360128) == 8388608) | composer4.changed(startUtcTimeMillis);
                        Object objRememberedValue4 = composer4.rememberedValue();
                        if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = Boolean.valueOf(selectableDates.isSelectableYear(calendarMonth.getYear()) && selectableDates.isSelectableDate(startUtcTimeMillis));
                            composer4.updateRememberedValue(objRememberedValue4);
                        }
                        boolean zBooleanValue2 = ((Boolean) objRememberedValue4).booleanValue();
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        if (strDayContentDescription != null) {
                            str11 = strDayContentDescription + ", " + str11;
                        }
                        Day(str6, companion, z4, function0, z9, zBooleanValue2, z8, z11, str11, datePickerColors, composer4, ((i6 << 3) & 1879048192) | 48);
                        composer3 = composer4;
                        composer3.endReplaceGroup();
                    }
                    calendarMonth2 = calendarMonth;
                    function12 = function1;
                    locale2 = locale;
                    i15 = i4 + 1;
                    str8 = str4;
                    composerStartRestartGroup = composer3;
                    i9 = i6;
                    str10 = str;
                    str7 = str2;
                    i16 = i5 + 1;
                    str9 = str3;
                }
                int i18 = i15;
                Composer composer5 = composerStartRestartGroup;
                composer5.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                calendarMonth2 = calendarMonth;
                function12 = function1;
                locale2 = locale;
                i11 = i14 + 1;
                i10 = i18;
                i12 = 6;
                str7 = str7;
            }
            composer2 = composerStartRestartGroup;
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.Month$lambda$59(calendarMonth, function1, j, l, l2, selectedRangeInfo, datePickerFormatter, selectableDates, datePickerColors, locale, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit Month$lambda$51$lambda$50(SelectedRangeInfo selectedRangeInfo, DatePickerColors datePickerColors, ContentDrawScope contentDrawScope) {
        DateRangePickerKt.m3588drawRangeBackgroundmxwnekA(contentDrawScope, selectedRangeInfo, datePickerColors.getDayInSelectionRangeContainerColor());
        contentDrawScope.drawContent();
        return Unit.INSTANCE;
    }

    static final Unit Month$lambda$58$lambda$57$lambda$54$lambda$53(Function1 function1, long j) {
        function1.invoke(Long.valueOf(j));
        return Unit.INSTANCE;
    }

    static final Unit Month$lambda$59(CalendarMonth calendarMonth, Function1 function1, long j, Long l, Long l2, SelectedRangeInfo selectedRangeInfo, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, Locale locale, int i, Composer composer, int i2) {
        Month(calendarMonth, function1, j, l, l2, selectedRangeInfo, datePickerFormatter, selectableDates, datePickerColors, locale, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final void MonthsNavigation(final Modifier modifier, final boolean z, final boolean z2, final boolean z3, final String str, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Function0<Unit> function04;
        Composer composerStartRestartGroup = composer.startRestartGroup(-773929258);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MonthsNavigation)N(modifier,nextAvailable,previousAvailable,yearPickerVisible,yearPickerText,onNextClicked,onPreviousClicked,onYearPickerButtonClicked,colors)2192@98798L2005:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            function04 = function03;
            i2 |= composerStartRestartGroup.changedInstance(function04) ? 8388608 : 4194304;
        } else {
            function04 = function03;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 67108864 : 33554432;
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-773929258, i2, -1, "androidx.compose.material3.MonthsNavigation (DatePicker.kt:2191)");
            }
            Modifier modifierM2072requiredHeight3ABfNKs = SizeKt.m2072requiredHeight3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), MonthYearHeight);
            Arrangement.HorizontalOrVertical start = z3 ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2072requiredHeight3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i3 = i2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 280876222, "C2203@99266L567,2203@99178L655:DatePicker.kt#uh7d8r");
            YearPickerMenuButton(function04, z3, null, ComposableLambdaKt.rememberComposableLambda(619076006, true, new DatePickerKt$MonthsNavigation$1$1(str, datePickerColors), composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 21) & 14) | 3072 | ((i3 >> 6) & 112), 4);
            if (z3) {
                composerStartRestartGroup.startReplaceGroup(282432080);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(281624840);
                ComposerKt.sourceInformation(composerStartRestartGroup, "2219@100054L733,2219@99971L816");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(datePickerColors.getNavigationContentColor())), ComposableLambdaKt.rememberComposableLambda(-128317193, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i4) {
                        ComposerKt.sourceInformation(composer2, "C2220@100072L701:DatePicker.kt#uh7d8r");
                        if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-128317193, i4, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous> (DatePicker.kt:2220)");
                        }
                        Function0<Unit> function05 = function02;
                        boolean z4 = z2;
                        Function0<Unit> function06 = function0;
                        boolean z5 = z;
                        ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer2);
                        Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1643424289, "C2225@100348L50,2221@100098L323,2232@100686L46,2228@100443L312:DatePicker.kt#uh7d8r");
                        ImageVector keyboardArrowLeft$material3 = Icons.AutoMirrored.Filled.INSTANCE.getKeyboardArrowLeft$material3();
                        Strings.Companion companion2 = Strings.INSTANCE;
                        DatePickerKt.IconButtonWithTooltip(function05, keyboardArrowLeft$material3, Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_picker_switch_to_previous_month), composer2, 0), null, z4, composer2, 0, 8);
                        ImageVector keyboardArrowRight$material3 = Icons.AutoMirrored.Filled.INSTANCE.getKeyboardArrowRight$material3();
                        Strings.Companion companion3 = Strings.INSTANCE;
                        DatePickerKt.IconButtonWithTooltip(function06, keyboardArrowRight$material3, Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_picker_switch_to_next_month), composer2, 0), null, z5, composer2, 0, 8);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.MonthsNavigation$lambda$69(modifier, z, z2, z3, str, function0, function02, function03, datePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit MonthsNavigation$lambda$69(Modifier modifier, boolean z, boolean z2, boolean z3, String str, Function0 function0, Function0 function02, Function0 function03, DatePickerColors datePickerColors, int i, Composer composer, int i2) {
        MonthsNavigation(modifier, z, z2, z3, str, function0, function02, function03, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: SwitchableDateEntryContent-KaiTk9E, reason: not valid java name */
    public static final void m3569SwitchableDateEntryContentKaiTk9E(final Long l, final long j, final int i, final Function1<? super Long, Unit> function1, final Function1<? super Long, Unit> function12, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, final FocusRequester focusRequester, Composer composer, final int i2, final int i3) {
        int i4;
        IntRange intRange2;
        SelectableDates selectableDates2;
        int i5;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2053685029);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwitchableDateEntryContent)N(selectedDateMillis,displayedMonthMillis,displayMode:c#material3.DisplayMode,onDateSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors,focusRequester)1446@66942L7,1449@67152L7,1451@67264L7,1453@67385L7,1455@67503L7,1459@67617L216,1465@67860L1708,1497@69626L1136,1456@67515L3247:DatePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(l) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function12) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(calendarModel) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            intRange2 = intRange;
            i4 |= composerStartRestartGroup.changedInstance(intRange2) ? 1048576 : 524288;
        } else {
            intRange2 = intRange;
        }
        if ((12582912 & i2) == 0) {
            i4 |= (16777216 & i2) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            selectableDates2 = selectableDates;
            i4 |= composerStartRestartGroup.changed(selectableDates2) ? 67108864 : 33554432;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changed(datePickerColors) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (composerStartRestartGroup.changed(focusRequester) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i5 & 3) == 2) ? false : true, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2053685029, i4, i5, "androidx.compose.material3.SwitchableDateEntryContent (DatePicker.kt:1443)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final int i6 = -((Density) objConsume).mo1618roundToPx0680j_4(Dp.m9114constructorimpl(48.0f));
            final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            int i7 = i4;
            final FiniteAnimationSpec finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue4 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            DisplayMode displayModeM3604boximpl = DisplayMode.m3604boximpl(i);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093685971, "CC(remember):DatePicker.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$14$lambda$13((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093695239, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changed(i6) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        FiniteAnimationSpec finiteAnimationSpec = finiteAnimationSpecValue3;
                        FiniteAnimationSpec finiteAnimationSpec2 = finiteAnimationSpecValue;
                        FiniteAnimationSpec finiteAnimationSpec3 = finiteAnimationSpecValue2;
                        int i8 = i6;
                        AnimatedContentTransitionScope animatedContentTransitionScope = (AnimatedContentTransitionScope) obj;
                        return animatedContentTransitionScope.using(DisplayMode.m3607equalsimpl0(((DisplayMode) animatedContentTransitionScope.getTargetState()).getValue(), DisplayMode.INSTANCE.m3611getInputjFl4v0()) ? AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically(finiteAnimationSpec, new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$15(((Integer) obj2).intValue()));
                            }
                        }).plus(EnterExitTransitionKt.fadeIn$default(finiteAnimationSpec2, 0.0f, 2, null)), EnterExitTransitionKt.fadeOut$default(finiteAnimationSpec3, 0.0f, 2, null).plus(EnterExitTransitionKt.slideOutVertically(finiteAnimationSpec, new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$16(i8, ((Integer) obj2).intValue()));
                            }
                        }))) : AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically(finiteAnimationSpec, new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$17(i8, ((Integer) obj2).intValue()));
                            }
                        }).plus(EnterExitTransitionKt.fadeIn$default(finiteAnimationSpec2, 0.0f, 2, null)), EnterExitTransitionKt.slideOutVertically(finiteAnimationSpec, new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Integer.valueOf(DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$18(((Integer) obj2).intValue()));
                            }
                        }).plus(EnterExitTransitionKt.fadeOut$default(finiteAnimationSpec3, 0.0f, 2, null))), AnimatedContentKt.SizeTransform(true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$19(finiteAnimationSpec, (IntSize) obj2, (IntSize) obj3);
                            }
                        }));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final IntRange intRange3 = intRange2;
            final SelectableDates selectableDates3 = selectableDates2;
            composer2 = composerStartRestartGroup;
            AnimatedContentKt.AnimatedContent(displayModeM3604boximpl, modifierSemantics$default, (Function1) objRememberedValue2, null, "DatePickerDisplayModeAnimation", null, ComposableLambdaKt.rememberComposableLambda(1838500091, true, new Function4<AnimatedContentScope, DisplayMode, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$3
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, DisplayMode displayMode, Composer composer3, Integer num) {
                    m3572invokefYndouo(animatedContentScope, displayMode.getValue(), composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-fYndouo, reason: not valid java name */
                public final void m3572invokefYndouo(AnimatedContentScope animatedContentScope, int i8, Composer composer3, int i9) {
                    ComposerKt.sourceInformation(composer3, "CN(mode:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1838500091, i9, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DatePicker.kt:1498)");
                    }
                    if (DisplayMode.m3607equalsimpl0(i8, DisplayMode.INSTANCE.m3612getPickerjFl4v0())) {
                        composer3.startReplaceGroup(1567031954);
                        ComposerKt.sourceInformation(composer3, "1500@69708L535");
                        DatePickerKt.DatePickerContent(l, j, function1, function12, calendarModel, intRange3, datePickerFormatter, selectableDates3, datePickerColors, composer3, 0);
                        composer3.endReplaceGroup();
                    } else if (DisplayMode.m3607equalsimpl0(i8, DisplayMode.INSTANCE.m3611getInputjFl4v0())) {
                        composer3.startReplaceGroup(1567050592);
                        ComposerKt.sourceInformation(composer3, "1512@70293L453");
                        DateInputKt.DateInputContent(l, function1, calendarModel, intRange3, datePickerFormatter, selectableDates3, datePickerColors, focusRequester, composer3, 0);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(1334373351);
                        composer3.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, ((i7 >> 6) & 14) | 1597440, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$22(l, j, i, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SwitchableDateEntryContent_KaiTk9E$lambda$14$lambda$13(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    static final int SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$15(int i) {
        return i;
    }

    static final int SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$16(int i, int i2) {
        return i;
    }

    static final int SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$17(int i, int i2) {
        return i;
    }

    static final int SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$18(int i) {
        return i;
    }

    static final FiniteAnimationSpec SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$19(FiniteAnimationSpec finiteAnimationSpec, IntSize intSize, IntSize intSize2) {
        return finiteAnimationSpec;
    }

    static final Unit SwitchableDateEntryContent_KaiTk9E$lambda$22(Long l, long j, int i, Function1 function1, Function1 function12, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, FocusRequester focusRequester, int i2, int i3, Composer composer, int i4) {
        m3569SwitchableDateEntryContentKaiTk9E(l, j, i, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v13 */
    public static final void WeekDays(final DatePickerColors datePickerColors, final CalendarModel calendarModel, Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1849465391);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WeekDays)N(colors,calendarModel)1793@82488L5,1795@82499L1567:DatePicker.kt#uh7d8r");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changed(datePickerColors) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(calendarModel) ? 32 : 16;
        }
        ?? r8 = 0;
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1849465391, i2, -1, "androidx.compose.material3.WeekDays (DatePicker.kt:1782)");
            }
            int firstDayOfWeek = calendarModel.getFirstDayOfWeek();
            List<Pair<String, String>> weekdayNames = calendarModel.getWeekdayNames();
            ArrayList arrayList = new ArrayList();
            int i3 = firstDayOfWeek - 1;
            int size = weekdayNames.size();
            for (int i4 = i3; i4 < size; i4++) {
                arrayList.add(weekdayNames.get(i4));
            }
            for (int i5 = 0; i5 < i3; i5++) {
                arrayList.add(weekdayNames.get(i5));
            }
            TextStyle value = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextFont(), composerStartRestartGroup, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m2068defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, RecommendedSizeForAccessibility, 1, null), 0.0f, 1, null);
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly, centerVertically, composerStartRestartGroup, 54);
            String str = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            String str2 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 761451639, "C:DatePicker.kt#uh7d8r");
            composerStartRestartGroup.startReplaceGroup(24563235);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*1804@82866L33,1814@83567L7,1815@83650L7,1802@82784L1266");
            ArrayList arrayList2 = arrayList;
            int size2 = arrayList2.size();
            int i6 = 0;
            while (i6 < size2) {
                final Pair pair = (Pair) arrayList2.get(i6);
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1806140369, "CC(remember):DatePicker.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(pair);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda31
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DatePickerKt.WeekDays$lambda$48$lambda$47$lambda$45$lambda$44(pair, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM2087sizeInqDBjuR0$default = SizeKt.m2087sizeInqDBjuR0$default(SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue), DatePickerModalTokens.INSTANCE.m4904getDateContainerWidthD9Ej5fM(), DatePickerModalTokens.INSTANCE.m4903getDateContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null);
                ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fM9128unboximpl = ((Dp) objConsume).m9128unboximpl();
                ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM2085sizeVpY3zN4 = SizeKt.m2085sizeVpY3zN4(modifierM2087sizeInqDBjuR0$default, fM9128unboximpl, ((Dp) objConsume2).m9128unboximpl());
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, r8);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, str);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, r8);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2085sizeVpY3zN4);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, str2);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1708069020, "C1819@83771L265:DatePicker.kt#uh7d8r");
                Composer composer3 = composerStartRestartGroup;
                TextKt.m4288TextNvy7gAk((String) pair.getSecond(), SizeKt.wrapContentSize$default(Modifier.INSTANCE, null, false, 3, null), datePickerColors.getWeekdayContentColor(), null, 0L, null, null, null, 0L, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, null, value, composer3, 48, 0, 130040);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                i6++;
                composerStartRestartGroup = composer3;
                str = str;
                r8 = 0;
                size2 = size2;
                str2 = str2;
            }
            composer2 = composerStartRestartGroup;
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.WeekDays$lambda$49(datePickerColors, calendarModel, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit WeekDays$lambda$48$lambda$47$lambda$45$lambda$44(Pair pair, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, (String) pair.getFirst());
        return Unit.INSTANCE;
    }

    static final Unit WeekDays$lambda$49(DatePickerColors datePickerColors, CalendarModel calendarModel, int i, Composer composer, int i2) {
        WeekDays(datePickerColors, calendarModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Year(final String str, final Modifier modifier, final boolean z, final boolean z2, final Function0<Unit> function0, final boolean z3, final String str2, final DatePickerColors datePickerColors, Composer composer, final int i) {
        String str3;
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1153850597);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Year)N(text,modifier,selected,currentYear,onClick,enabled,description,colors)2130@96589L394,2148@97358L112,2153@97566L5,2154@97596L58,2156@97693L638,2141@96988L1343:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            str3 = str;
            i2 = (composerStartRestartGroup.changed(str3) ? 4 : 2) | i;
        } else {
            str3 = str;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 8388608 : 4194304;
        }
        if (composerStartRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1153850597, i2, -1, "androidx.compose.material3.Year (DatePicker.kt:2128)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -748852891, "CC(remember):DatePicker.kt#9igjgp");
            boolean z4 = ((i2 & 7168) == 2048) | ((i2 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (!z2 || z) ? null : BorderStrokeKt.m1509BorderStrokecXLIe8U(DatePickerModalTokens.INSTANCE.m4907getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors.getTodayDateBorderColor());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            BorderStroke borderStroke = (BorderStroke) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -748828565, "CC(remember):DatePicker.kt#9igjgp");
            boolean z5 = (3670016 & i2) == 1048576;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z5 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.Year$lambda$66$lambda$65(str2, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2 >> 6;
            int i4 = i3 & 14;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4146Surfaced85dljk(z, function0, SemanticsModifierKt.semantics(modifier, true, (Function1) objRememberedValue2), z3, ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearStateLayerShape(), composerStartRestartGroup, 6), datePickerColors.yearContainerColor$material3(z, z3, composerStartRestartGroup, i4 | ((i2 >> 12) & 112) | ((i2 >> 15) & 896)).getValue().m6335unboximpl(), 0L, 0.0f, 0.0f, borderStroke, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-564400443, true, new C04332(str3, datePickerColors, z2, z, z3), composerStartRestartGroup, 54), composer2, i4 | ((i2 >> 9) & 112) | (i3 & 7168), 48, 1472);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.Year$lambda$67(str, modifier, z, z2, function0, z3, str2, datePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit Year$lambda$66$lambda$65(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, new AnnotatedString(str, null, 2, null));
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8327getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Year$lambda$67(String str, Modifier modifier, boolean z, boolean z2, Function0 function0, boolean z3, String str2, DatePickerColors datePickerColors, int i, Composer composer, int i2) {
        Year(str, modifier, z, z2, function0, z3, str2, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void YearPicker(final Modifier modifier, final long j, final Function1<? super Integer, Unit> function1, final SelectableDates selectableDates, final CalendarModel calendarModel, final IntRange intRange, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1286899812);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(YearPicker)N(modifier,displayedMonthMillis,onYearSelected,selectableDates,calendarModel,yearRange,colors)2069@94140L5,2069@94147L2061,2069@94066L2142:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(selectableDates) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(calendarModel) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(intRange) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1286899812, i2, -1, "androidx.compose.material3.YearPicker (DatePicker.kt:2068)");
            }
            TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearLabelTextFont(), composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1301915789, true, new C04341(calendarModel, j, intRange, modifier, datePickerColors, function1, selectableDates), composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.YearPicker$lambda$63(modifier, j, function1, selectableDates, calendarModel, intRange, datePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit YearPicker$lambda$63(Modifier modifier, long j, Function1 function1, SelectableDates selectableDates, CalendarModel calendarModel, IntRange intRange, DatePickerColors datePickerColors, int i, Composer composer, int i2) {
        YearPicker(modifier, j, function1, selectableDates, calendarModel, intRange, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void YearPickerMenuButton(final Function0<Unit> function0, final boolean z, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-709923073);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(YearPickerMenuButton)N(onClick,expanded,modifier,content)2252@101224L7,2252@101174L58,2255@101289L454,2248@101045L698:DatePicker.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else if ((i & 6) == 0) {
            function02 = function0;
            i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
        } else {
            function02 = function0;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                Modifier modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-709923073, i3, -1, "androidx.compose.material3.YearPickerMenuButton (DatePicker.kt:2247)");
                }
                RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
                ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContentColor);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifier2 = modifier3;
                ButtonKt.TextButton(function02, modifier2, false, circleShape, buttonDefaults.m3351textButtonColorsro_MJ88(0L, ((Color) objConsume).m6335unboximpl(), 0L, 0L, composerStartRestartGroup, 24576, 13), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1899489890, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt.YearPickerMenuButton.1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                        invoke(rowScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope rowScope, Composer composer2, int i5) {
                        String strM4676getString2EP1pXo;
                        ComposerKt.sourceInformation(composer2, "C2256@101299L9,2257@101317L49,2258@101375L362:DatePicker.kt#uh7d8r");
                        if (!composer2.shouldExecute((i5 & 17) != 16, i5 & 1)) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1899489890, i5, -1, "androidx.compose.material3.YearPickerMenuButton.<anonymous> (DatePicker.kt:2256)");
                        }
                        function2.invoke(composer2, 0);
                        SpacerKt.Spacer(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m3347getIconSpacingD9Ej5fM()), composer2, 6);
                        ImageVector arrowDropDown$material3 = Icons.Filled.INSTANCE.getArrowDropDown$material3();
                        if (z) {
                            composer2.startReplaceGroup(1509384391);
                            ComposerKt.sourceInformation(composer2, "2262@101506L49");
                            Strings.Companion companion = Strings.INSTANCE;
                            strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_picker_switch_to_day_selection), composer2, 0);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(1509478662);
                            ComposerKt.sourceInformation(composer2, "2264@101601L50");
                            Strings.Companion companion2 = Strings.INSTANCE;
                            strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_picker_switch_to_year_selection), composer2, 0);
                            composer2.endReplaceGroup();
                        }
                        IconKt.m3736Iconww6aTOc(arrowDropDown$material3, strM4676getString2EP1pXo, RotateKt.rotate(Modifier.INSTANCE, z ? 180.0f : 0.0f), 0L, composer2, 0, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 807075840 | ((i3 >> 3) & 112), 388);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            final Modifier modifier4 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.YearPickerMenuButton$lambda$70(function0, z, modifier4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
        }
        final Modifier modifier42 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit YearPickerMenuButton$lambda$70(Function0 function0, boolean z, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        YearPickerMenuButton(function0, z, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final String dayContentDescription(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 502032503, "C(dayContentDescription)N(rangeSelectionEnabled,isToday,isStartDate,isEndDate,isInRange):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(502032503, i, -1, "androidx.compose.material3.dayContentDescription (DatePicker.kt:1972)");
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            composer.startReplaceGroup(974450583);
            ComposerKt.sourceInformation(composer, "");
            if (z3) {
                composer.startReplaceGroup(1416909399);
                ComposerKt.sourceInformation(composer, "1977@90977L56");
                Strings.Companion companion = Strings.INSTANCE;
                sb.append(Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_range_picker_start_headline), composer, 0));
                composer.endReplaceGroup();
            } else if (z4) {
                composer.startReplaceGroup(1416913397);
                ComposerKt.sourceInformation(composer, "1979@91102L54");
                Strings.Companion companion2 = Strings.INSTANCE;
                sb.append(Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_range_picker_end_headline), composer, 0));
                composer.endReplaceGroup();
            } else if (z5) {
                composer.startReplaceGroup(1416917332);
                ComposerKt.sourceInformation(composer, "1981@91225L53");
                Strings.Companion companion3 = Strings.INSTANCE;
                sb.append(Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_range_picker_day_in_range), composer, 0));
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(974832875);
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(974838827);
            composer.endReplaceGroup();
        }
        if (z2) {
            composer.startReplaceGroup(1416920485);
            ComposerKt.sourceInformation(composer, "1986@91426L54");
            if (sb.length() > 0) {
                sb.append(", ");
            }
            Strings.Companion companion4 = Strings.INSTANCE;
            sb.append(Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_date_picker_today_description), composer, 0));
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(975029291);
            composer.endReplaceGroup();
        }
        String string = sb.length() == 0 ? null : sb.toString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return string;
    }

    public static final float getDatePickerHorizontalPadding() {
        return DatePickerHorizontalPadding;
    }

    public static final PaddingValues getDatePickerModeTogglePadding() {
        return DatePickerModeTogglePadding;
    }

    public static final float getMonthYearHeight() {
        return MonthYearHeight;
    }

    public static final float getRecommendedSizeForAccessibility() {
        return RecommendedSizeForAccessibility;
    }

    public static final int numberOfMonthsInRange(IntRange intRange) {
        return ((intRange.getLast() - intRange.getFirst()) + 1) * 12;
    }

    /* JADX INFO: renamed from: rememberDatePickerState-EU0dCGE, reason: not valid java name */
    public static final DatePickerState m3571rememberDatePickerStateEU0dCGE(Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 2065763010, "C(rememberDatePickerState)N(initialSelectedDateMillis,initialDisplayedMonthMillis,yearRange,initialDisplayMode:c#material3.DisplayMode,selectableDates)374@15968L15,375@16072L384,375@15995L461:DatePicker.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            l = null;
        }
        final Long l3 = l;
        final Long l4 = (i3 & 2) != 0 ? l3 : l2;
        final IntRange yearRange = (i3 & 4) != 0 ? DatePickerDefaults.INSTANCE.getYearRange() : intRange;
        final int iM3612getPickerjFl4v0 = (i3 & 8) != 0 ? DisplayMode.INSTANCE.m3612getPickerjFl4v0() : i;
        final SelectableDates allDates = (i3 & 16) != 0 ? DatePickerDefaults.INSTANCE.getAllDates() : selectableDates;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2065763010, i2, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.kt:373)");
        }
        final Locale localeDefaultLocale = CalendarLocale_androidKt.defaultLocale(composer, 0);
        Object[] objArr = new Object[0];
        Saver<DatePickerStateImpl, Object> Saver = DatePickerStateImpl.INSTANCE.Saver(allDates, localeDefaultLocale);
        ComposerKt.sourceInformationMarkerStart(composer, 923379074, "CC(remember):DatePicker.kt#9igjgp");
        boolean z = true;
        boolean zChangedInstance = ((((i2 & 14) ^ 6) > 4 && composer.changed(l3)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(l4)) || (i2 & 48) == 32) | composer.changedInstance(yearRange) | ((((i2 & 7168) ^ 3072) > 2048 && composer.changed(iM3612getPickerjFl4v0)) || (i2 & 3072) == 2048);
        if ((((57344 & i2) ^ 24576) <= 16384 || !composer.changed(allDates)) && (i2 & 24576) != 16384) {
            z = false;
        }
        boolean zChangedInstance2 = zChangedInstance | z | composer.changedInstance(localeDefaultLocale);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DatePickerKt.rememberDatePickerState_EU0dCGE$lambda$5$lambda$4(l3, l4, yearRange, iM3612getPickerjFl4v0, allDates, localeDefaultLocale);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        DatePickerStateImpl datePickerStateImpl = (DatePickerStateImpl) RememberSaveableKt.m5766rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue, composer, 0);
        datePickerStateImpl.setSelectableDates(allDates);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return datePickerStateImpl;
    }

    static final DatePickerStateImpl rememberDatePickerState_EU0dCGE$lambda$5$lambda$4(Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, Locale locale) {
        return new DatePickerStateImpl(l, l2, intRange, i, selectableDates, locale, null);
    }

    public static final Object updateDisplayedMonth(final LazyListState lazyListState, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, Continuation<? super Unit> continuation) {
        Object objCollect = SnapshotStateKt.snapshotFlow(new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(lazyListState.getFirstVisibleItemIndex());
            }
        }).collect(new FlowCollector() { // from class: androidx.compose.material3.DatePickerKt.updateDisplayedMonth.3
            public final Object emit(int i, Continuation<? super Unit> continuation2) {
                int firstVisibleItemIndex = lazyListState.getFirstVisibleItemIndex() / 12;
                function1.invoke(Boxing.boxLong(calendarModel.getMonth(intRange.getFirst() + firstVisibleItemIndex, (lazyListState.getFirstVisibleItemIndex() % 12) + 1).getStartUtcTimeMillis()));
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit(((Number) obj).intValue(), (Continuation<? super Unit>) continuation2);
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}
