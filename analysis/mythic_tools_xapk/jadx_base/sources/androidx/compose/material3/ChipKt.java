package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.messaging.Constants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a¨\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a¦\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0018\u001a¨\u0001\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a¦\u0001\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0018\u001a°\u0001\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u001c2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u001e\u001a°\u0001\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u001c2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u001e\u001aÇ\u0001\u0010 \u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u001c2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\"\u001a\u0091\u0001\u0010#\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010%\u001a\u008f\u0001\u0010#\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010&\u001a\u0091\u0001\u0010'\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010%\u001a\u008f\u0001\u0010'\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010&\u001a¸\u0001\u0010(\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003¢\u0006\u0004\b1\u00102\u001aÍ\u0001\u00103\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u001c2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003¢\u0006\u0004\b4\u00105\u001a\u0091\u0001\u00106\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0003¢\u0006\u0004\b9\u0010:\u001a\u0091\u0001\u0010;\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0003¢\u0006\u0004\b<\u0010:\u001aN\u0010=\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00107\u001a\u00020,H\u0003¢\u0006\u0004\b>\u0010?\u001a9\u0010@\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00108\u001a\u00020,H\u0003¢\u0006\u0004\bA\u0010B\u001a%\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001HE0D\"\u0004\b\u0000\u0010E2\b\u0010F\u001a\u0004\u0018\u0001HEH\u0003¢\u0006\u0002\u0010G\u001a&\u0010L\u001a\u0002002\b\b\u0002\u0010M\u001a\u00020\t2\b\b\u0002\u0010N\u001a\u00020\t2\b\b\u0002\u0010O\u001a\u00020\tH\u0002\"\u0018\u0010H\u001a\u00020\u000f*\u00020I8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010K\"\u0010\u0010P\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Q\"\u000e\u0010R\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010S\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010T\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010U\u001a\u00020VX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010W\u001a\u00020VX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010X\u001a\u00020VX\u0082T¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"AssistChip", "", "onClick", "Lkotlin/Function0;", "label", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", ChipKt.LeadingIconLayoutId, ChipKt.TrailingIconLayoutId, "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ChipColors;", "elevation", "Landroidx/compose/material3/ChipElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/ChipBorder;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedAssistChip", "FilterChip", "selected", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/SelectableChipElevation;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedFilterChip", "InputChip", "avatar", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SuggestionChip", "icon", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ElevatedSuggestionChip", "Chip", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "minHeight", "Landroidx/compose/ui/unit/Dp;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "Chip-nkUnTEs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SelectableChip", "SelectableChip-u0RnIRE", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ChipContent", "leadingIconColor", "trailingIconColor", "ChipContent-fe0OD_I", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "AnimatingChipContent", "AnimatingChipContent-fe0OD_I", "leadingContent", "leadingContent-XO-JAsU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JLandroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "trailingContent", "trailingContent-RPmYEkk", "(Lkotlin/jvm/functions/Function2;JLandroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "rememberRetainedState", "Landroidx/compose/runtime/State;", ExifInterface.GPS_DIRECTION_TRUE, "targetValue", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "defaultSuggestionChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSuggestionChipColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "inputChipPadding", "hasAvatar", "hasLeadingIcon", "hasTrailingIcon", "HorizontalElementsPadding", "F", "AssistChipPadding", "FilterChipPadding", "SuggestionChipPadding", "LeadingIconLayoutId", "", "LabelLayoutId", "TrailingIconLayoutId", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ChipKt {
    private static final PaddingValues AssistChipPadding;
    private static final PaddingValues FilterChipPadding;
    private static final float HorizontalElementsPadding;
    private static final String LabelLayoutId = "label";
    private static final String LeadingIconLayoutId = "leadingIcon";
    private static final PaddingValues SuggestionChipPadding;
    private static final String TrailingIconLayoutId = "trailingIcon";

    /* JADX INFO: renamed from: androidx.compose.material3.ChipKt$InputChip$1, reason: invalid class name */
    /* JADX INFO: compiled from: Chip.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> $avatar;
        final /* synthetic */ float $avatarOpacity;
        final /* synthetic */ Shape $avatarShape;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(float f, Shape shape, Function2<? super Composer, ? super Integer, Unit> function2) {
            this.$avatarOpacity = f;
            this.$avatarShape = shape;
            this.$avatar = function2;
        }

        static final Unit invoke$lambda$1$lambda$0(float f, Shape shape, GraphicsLayerScope graphicsLayerScope) {
            graphicsLayerScope.setAlpha(f);
            graphicsLayerScope.setShape(shape);
            graphicsLayerScope.setClip(true);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C656@32117L180,654@32034L388:Chip.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-570452295, i, -1, "androidx.compose.material3.InputChip.<anonymous> (Chip.kt:654)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1551161805, "CC(remember):Chip.kt#9igjgp");
            boolean zChanged = composer.changed(this.$avatarOpacity) | composer.changed(this.$avatarShape);
            final float f = this.$avatarOpacity;
            final Shape shape = this.$avatarShape;
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ChipKt$InputChip$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChipKt.AnonymousClass1.invoke$lambda$1$lambda$0(f, shape, (GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue);
            Alignment center = Alignment.INSTANCE.getCenter();
            Function2<Composer, Integer, Unit> function2 = this.$avatar;
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierGraphicsLayer);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1351092324, "C663@32396L8:Chip.kt#uh7d8r");
            function2.invoke(composer, 0);
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

    static {
        float fM9114constructorimpl = Dp.m9114constructorimpl(8.0f);
        HorizontalElementsPadding = fM9114constructorimpl;
        AssistChipPadding = PaddingKt.m2032PaddingValuesYgX7TsA$default(fM9114constructorimpl, 0.0f, 2, null);
        FilterChipPadding = PaddingKt.m2032PaddingValuesYgX7TsA$default(fM9114constructorimpl, 0.0f, 2, null);
        SuggestionChipPadding = PaddingKt.m2032PaddingValuesYgX7TsA$default(fM9114constructorimpl, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: AnimatingChipContent-fe0OD_I, reason: not valid java name */
    public static final void m3404AnimatingChipContentfe0OD_I(final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, long j, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final long j2, final long j3, final float f, final PaddingValues paddingValues, Composer composer, final int i) {
        int i2;
        long j4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        long j5;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2070754602);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatingChipContent)N(label,labelTextStyle,labelColor:c#ui.graphics.Color,leadingIcon,avatar,trailingIcon,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,minHeight:c#ui.unit.Dp,paddingValues)2118@102851L4086,2115@102724L4213:Chip.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            j4 = j;
            i2 |= composerStartRestartGroup.changed(j4) ? 256 : 128;
        } else {
            j4 = j;
        }
        if ((i & 3072) == 0) {
            function25 = function22;
            i2 |= composerStartRestartGroup.changedInstance(function25) ? 2048 : 1024;
        } else {
            function25 = function22;
        }
        if ((i & 24576) == 0) {
            function26 = function23;
            i2 |= composerStartRestartGroup.changedInstance(function26) ? 16384 : 8192;
        } else {
            function26 = function23;
        }
        if ((196608 & i) == 0) {
            function27 = function24;
            i2 |= composerStartRestartGroup.changedInstance(function27) ? 131072 : 65536;
        } else {
            function27 = function24;
        }
        if ((1572864 & i) == 0) {
            j5 = j2;
            i2 |= composerStartRestartGroup.changed(j5) ? 1048576 : 524288;
        } else {
            j5 = j2;
        }
        if ((12582912 & i) == 0) {
            i3 = i2 | (composerStartRestartGroup.changed(j3) ? 8388608 : 4194304);
        } else {
            i3 = i2;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(paddingValues) ? 536870912 : 268435456;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2070754602, i3, -1, "androidx.compose.material3.AnimatingChipContent (Chip.kt:2114)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function28 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function29 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function210 = function27;
            final long j6 = j5;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(j4)), TextKt.getLocalTextStyle().provides(textStyle)}, ComposableLambdaKt.rememberComposableLambda(-668234218, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$AnimatingChipContent$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposerKt.sourceInformation(composer2, "C2120@102988L14,2121@103063L14,2122@103137L16,2123@103216L16,2197@106882L38,2124@103241L3690:Chip.kt#uh7d8r");
                    if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-668234218, i4, -1, "androidx.compose.material3.AnimatingChipContent.<anonymous> (Chip.kt:2120)");
                    }
                    FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.SlowEffects, composer2, 6);
                    FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer2, 6);
                    FiniteAnimationSpec finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer2, 6);
                    FiniteAnimationSpec finiteAnimationSpecValue4 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer2, 6);
                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m2068defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, f, 1, null), paddingValues);
                    ComposerKt.sourceInformationMarkerStart(composer2, 2072139932, "CC(remember):Chip.kt#9igjgp");
                    Object objRememberedValue = composer2.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new ChipLayoutMeasurePolicy();
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ChipLayoutMeasurePolicy chipLayoutMeasurePolicy = (ChipLayoutMeasurePolicy) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    final Function2<Composer, Integer, Unit> function211 = function29;
                    final Function2<Composer, Integer, Unit> function212 = function28;
                    final Function2<Composer, Integer, Unit> function213 = function210;
                    final long j7 = j6;
                    Function2<Composer, Integer, Unit> function214 = function2;
                    final long j8 = j3;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierPadding);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                    Updater.m5603setimpl(composerM5595constructorimpl, chipLayoutMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -564817408, "C2141@104124L826,2128@103442L1508,2158@104967L362,2179@106014L824,2168@105407L1431:Chip.kt#uh7d8r");
                    AnimatedVisibilityKt.AnimatedVisibility((function211 == null && function212 == null) ? false : true, LayoutIdKt.layoutId(Modifier.INSTANCE, "leadingIcon"), EnterExitTransitionKt.expandHorizontally$default(finiteAnimationSpecValue3, Alignment.INSTANCE.getStart(), false, null, 12, null).plus(EnterExitTransitionKt.fadeIn$default(finiteAnimationSpecValue, 0.0f, 2, null)), EnterExitTransitionKt.shrinkHorizontally$default(finiteAnimationSpecValue4, Alignment.INSTANCE.getStart(), false, null, 12, null).plus(EnterExitTransitionKt.fadeOut$default(finiteAnimationSpecValue2, 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(687705959, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$AnimatingChipContent$1$2$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                            invoke(animatedVisibilityScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i5) {
                            ComposerKt.sourceInformation(composer3, "C2147@104553L53,2146@104488L144,2150@104654L278:Chip.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(687705959, i5, -1, "androidx.compose.material3.AnimatingChipContent.<anonymous>.<anonymous>.<anonymous> (Chip.kt:2145)");
                            }
                            State stateRememberRetainedState = ChipKt.rememberRetainedState(ChipKt.m3412leadingContentXOJAsU(function211, function212, j7, composer3, 0), composer3, 0);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, companion);
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
                            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -1538137033, "C:Chip.kt#uh7d8r");
                            Function2 function215 = (Function2) stateRememberRetainedState.getValue();
                            if (function215 == null) {
                                composer3.startReplaceGroup(-1538103400);
                            } else {
                                composer3.startReplaceGroup(-326710903);
                                ComposerKt.sourceInformation(composer3, "2154@104875L8");
                                function215.invoke(composer3, 0);
                            }
                            composer3.endReplaceGroup();
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
                    }, composer2, 54), composer2, 196656, 16);
                    Modifier modifierM2039paddingVpY3zN4$default = PaddingKt.m2039paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, Constants.ScionAnalytics.PARAM_LABEL), ChipKt.HorizontalElementsPadding, 0.0f, 2, null);
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM2039paddingVpY3zN4$default);
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
                    Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 75607137, "C2164@105301L7:Chip.kt#uh7d8r");
                    function214.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    AnimatedVisibilityKt.AnimatedVisibility(function213 != null, LayoutIdKt.layoutId(Modifier.INSTANCE, "trailingIcon"), EnterExitTransitionKt.expandHorizontally$default(finiteAnimationSpecValue3, Alignment.INSTANCE.getEnd(), false, null, 12, null).plus(EnterExitTransitionKt.fadeIn$default(finiteAnimationSpecValue, 0.0f, 2, null)), EnterExitTransitionKt.shrinkHorizontally$default(finiteAnimationSpecValue4, Alignment.INSTANCE.getEnd(), false, null, 12, null).plus(EnterExitTransitionKt.fadeOut$default(finiteAnimationSpecValue2, 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1905252304, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$AnimatingChipContent$1$2$3
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                            invoke(animatedVisibilityScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i5) {
                            ComposerKt.sourceInformation(composer3, "C2185@106445L48,2184@106380L139,2188@106541L279:Chip.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1905252304, i5, -1, "androidx.compose.material3.AnimatingChipContent.<anonymous>.<anonymous>.<anonymous> (Chip.kt:2183)");
                            }
                            State stateRememberRetainedState = ChipKt.rememberRetainedState(ChipKt.m3413trailingContentRPmYEkk(function213, j8, composer3, 0), composer3, 0);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, companion);
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
                            Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -2101817907, "C:Chip.kt#uh7d8r");
                            Function2 function215 = (Function2) stateRememberRetainedState.getValue();
                            if (function215 == null) {
                                composer3.startReplaceGroup(-2101783313);
                            } else {
                                composer3.startReplaceGroup(-344894126);
                                ComposerKt.sourceInformation(composer3, "2192@106763L8");
                                function215.invoke(composer3, 0);
                            }
                            composer3.endReplaceGroup();
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
                    }, composer2, 54), composer2, 196656, 16);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final long j7 = j4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.AnimatingChipContent_fe0OD_I$lambda$24(function2, textStyle, j7, function22, function23, function24, j2, j3, f, paddingValues, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit AnimatingChipContent_fe0OD_I$lambda$24(Function2 function2, TextStyle textStyle, long j, Function2 function22, Function2 function23, Function2 function24, long j2, long j3, float f, PaddingValues paddingValues, int i, Composer composer, int i2) {
        m3404AnimatingChipContentfe0OD_I(function2, textStyle, j, function22, function23, function24, j2, j3, f, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AssistChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i7;
        ChipColors chipColorsAssistChipColors;
        int i8;
        int i9;
        int i10;
        int i11;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final ChipElevation chipElevation2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z3;
        Composer composer2;
        final Shape shape2;
        final ChipColors chipColors2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final BorderStroke borderStroke2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Shape shape3;
        int i12;
        Modifier modifier4;
        int i13;
        int i14;
        ChipElevation chipElevationM3315assistChipElevationaqJV_2Y;
        boolean z4;
        BorderStroke borderStrokeM3313assistChipBorderh1eTWw;
        int i15;
        MutableInteractionSource mutableInteractionSource3;
        BorderStroke borderStroke3;
        int i16;
        Shape shape4;
        ChipElevation chipElevation3;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Modifier modifier5;
        Composer composerStartRestartGroup = composer.startRestartGroup(1192083339);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AssistChip)N(onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)151@7455L5,146@7287L542:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function24 = function2;
        } else {
            function24 = function2;
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function24) ? 32 : 16;
            }
        }
        int i17 = i3 & 4;
        if (i17 != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 == 0) {
                    if ((i & 24576) == 0) {
                        function25 = function22;
                        i4 |= composerStartRestartGroup.changedInstance(function25) ? 16384 : 8192;
                    }
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(shape)) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i3 & 128) == 0) {
                            chipColorsAssistChipColors = chipColors;
                            int i18 = composerStartRestartGroup.changed(chipColorsAssistChipColors) ? 8388608 : 4194304;
                            i4 |= i18;
                        } else {
                            chipColorsAssistChipColors = chipColors;
                        }
                        i4 |= i18;
                    } else {
                        chipColorsAssistChipColors = chipColors;
                    }
                    if ((i & 100663296) == 0) {
                        i4 |= ((i3 & 256) == 0 && composerStartRestartGroup.changed(chipElevation)) ? 67108864 : 33554432;
                    }
                    if ((i & 805306368) == 0) {
                        i4 |= ((i3 & 512) == 0 && composerStartRestartGroup.changed(borderStroke)) ? 536870912 : 268435456;
                    }
                    i8 = i3 & 1024;
                    if (i8 == 0) {
                        i9 = i8;
                        i10 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i9 = i8;
                        i10 = i2 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                    } else {
                        i9 = i8;
                        i10 = i2;
                    }
                    i11 = i4;
                    if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function26 = function23;
                        chipElevation2 = chipElevation;
                        mutableInteractionSource2 = mutableInteractionSource;
                        z3 = z2;
                        composer2 = composerStartRestartGroup;
                        shape2 = shape;
                        chipColors2 = chipColorsAssistChipColors;
                        modifier3 = modifier2;
                        function27 = function25;
                        borderStroke2 = borderStroke;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "140@7003L5,141@7054L18,142@7125L21,143@7195L25");
                        int i19 = i10;
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i17 != 0 ? Modifier.INSTANCE : modifier2;
                            boolean z5 = i5 == 0 ? z2 : true;
                            function28 = i6 != 0 ? null : function25;
                            Function2<? super Composer, ? super Integer, Unit> function210 = i7 != 0 ? null : function23;
                            if ((i3 & 64) != 0) {
                                i12 = i11 & (-3670017);
                                shape3 = AssistChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                shape3 = shape;
                                i12 = i11;
                            }
                            if ((i3 & 128) != 0) {
                                chipColorsAssistChipColors = AssistChipDefaults.INSTANCE.assistChipColors(composerStartRestartGroup, 6);
                                i12 &= -29360129;
                            }
                            ChipColors chipColors3 = chipColorsAssistChipColors;
                            int i20 = i12;
                            if ((i3 & 256) != 0) {
                                modifier4 = companion;
                                i14 = i19;
                                i13 = 6;
                                i20 &= -234881025;
                                chipElevationM3315assistChipElevationaqJV_2Y = AssistChipDefaults.INSTANCE.m3315assistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            } else {
                                modifier4 = companion;
                                i13 = 6;
                                i14 = i19;
                                chipElevationM3315assistChipElevationaqJV_2Y = chipElevation;
                            }
                            if ((i3 & 512) != 0) {
                                z4 = z5;
                                borderStrokeM3313assistChipBorderh1eTWw = AssistChipDefaults.INSTANCE.m3313assistChipBorderh1eTWw(z4, 0L, 0L, 0.0f, composerStartRestartGroup, ((i20 >> 9) & 14) | 24576, 14);
                                i15 = i20 & (-1879048193);
                            } else {
                                z4 = z5;
                                borderStrokeM3313assistChipBorderh1eTWw = borderStroke;
                                i15 = i20;
                            }
                            if (i9 != 0) {
                                borderStroke3 = borderStrokeM3313assistChipBorderh1eTWw;
                                i16 = i15;
                                shape4 = shape3;
                                chipElevation3 = chipElevationM3315assistChipElevationaqJV_2Y;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                borderStroke3 = borderStrokeM3313assistChipBorderh1eTWw;
                                i16 = i15;
                                shape4 = shape3;
                                chipElevation3 = chipElevationM3315assistChipElevationaqJV_2Y;
                            }
                            chipColorsAssistChipColors = chipColors3;
                            function29 = function210;
                            modifier5 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            int i21 = (i3 & 64) != 0 ? i11 & (-3670017) : i11;
                            if ((i3 & 128) != 0) {
                                i21 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i21 &= -234881025;
                            }
                            if ((i3 & 512) != 0) {
                                i21 &= -1879048193;
                            }
                            function29 = function23;
                            shape4 = shape;
                            chipElevation3 = chipElevation;
                            borderStroke3 = borderStroke;
                            mutableInteractionSource3 = mutableInteractionSource;
                            i16 = i21;
                            i13 = 6;
                            modifier5 = modifier2;
                            z4 = z2;
                            function28 = function25;
                            i14 = i19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1192083339, i16, i14, "androidx.compose.material3.AssistChip (Chip.kt:146)");
                        }
                        int i22 = i16 << 6;
                        int i23 = ((i16 >> 6) & 14) | ((i16 << 3) & 112) | ((i16 >> 3) & 896) | (i22 & 7168) | (3670016 & i22) | (29360128 & i22) | (234881024 & i22) | (i22 & 1879048192);
                        int i24 = i16 >> 24;
                        boolean z6 = z4;
                        ChipColors chipColors4 = chipColorsAssistChipColors;
                        m3405ChipnkUnTEs(modifier5, function0, z6, function24, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, i13), chipColorsAssistChipColors.m3395labelColorvNxB06k$material3(z4), function28, function29, shape4, chipColors4, chipElevation3, borderStroke3, AssistChipDefaults.INSTANCE.m3318getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource3, composerStartRestartGroup, i23, (i24 & 112) | (i24 & 14) | 3456 | ((i14 << 12) & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier5;
                        z3 = z6;
                        function27 = function28;
                        function26 = function29;
                        shape2 = shape4;
                        chipColors2 = chipColors4;
                        chipElevation2 = chipElevation3;
                        borderStroke2 = borderStroke3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.AssistChip$lambda$0(function0, function2, modifier3, z3, function27, function26, shape2, chipColors2, chipElevation2, borderStroke2, mutableInteractionSource2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= 24576;
                function25 = function22;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                i8 = i3 & 1024;
                if (i8 == 0) {
                }
                i11 = i4;
                if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i6 = i3 & 16;
            if (i6 == 0) {
            }
            function25 = function22;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i8 = i3 & 1024;
            if (i8 == 0) {
            }
            i11 = i4;
            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i3 & 16;
        if (i6 == 0) {
        }
        function25 = function22;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i8 = i3 & 1024;
        if (i8 == 0) {
        }
        i11 = i4;
        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with AssistChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "AssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void AssistChip(final Function0 function0, final Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function2 function24;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        Function2 function25;
        int i7;
        ChipColors chipColorsAssistChipColors;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final Function2 function26;
        final Shape shape2;
        final ChipElevation chipElevation2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z3;
        final ChipColors chipColors2;
        final Modifier modifier3;
        final Function2 function27;
        final ChipBorder chipBorder2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2 function28;
        Shape shape3;
        int i12;
        Modifier modifier4;
        int i13;
        Composer composer3;
        int i14;
        ChipElevation chipElevationM3315assistChipElevationaqJV_2Y;
        ChipBorder chipBorderM3312assistChipBorderd_3_b6Q;
        int i15;
        MutableInteractionSource mutableInteractionSource3;
        ChipElevation chipElevation3;
        Shape shape4;
        Function2 function29;
        Modifier modifier5;
        State<BorderStroke> stateBorderStroke$material3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1930061919);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AssistChip)N(onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)236@11549L5,231@11381L572:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function24 = function2;
        } else {
            function24 = function2;
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function24) ? 32 : 16;
            }
        }
        int i16 = i3 & 4;
        if (i16 != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 == 0) {
                    if ((i & 24576) == 0) {
                        function25 = function22;
                        i4 |= composerStartRestartGroup.changedInstance(function25) ? 16384 : 8192;
                    }
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(shape)) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i3 & 128) == 0) {
                            chipColorsAssistChipColors = chipColors;
                            int i17 = composerStartRestartGroup.changed(chipColorsAssistChipColors) ? 8388608 : 4194304;
                            i4 |= i17;
                        } else {
                            chipColorsAssistChipColors = chipColors;
                        }
                        i4 |= i17;
                    } else {
                        chipColorsAssistChipColors = chipColors;
                    }
                    if ((i & 100663296) == 0) {
                        i4 |= ((i3 & 256) == 0 && composerStartRestartGroup.changed(chipElevation)) ? 67108864 : 33554432;
                    }
                    if ((i & 805306368) == 0) {
                        i4 |= ((i3 & 512) == 0 && composerStartRestartGroup.changed(chipBorder)) ? 536870912 : 268435456;
                    }
                    i8 = i3 & 1024;
                    if (i8 == 0) {
                        i9 = i8;
                        i10 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i9 = i8;
                        i10 = i2 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                    } else {
                        i9 = i8;
                        i10 = i2;
                    }
                    i11 = i4;
                    if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function26 = function23;
                        shape2 = shape;
                        chipElevation2 = chipElevation;
                        mutableInteractionSource2 = mutableInteractionSource;
                        z3 = z2;
                        chipColors2 = chipColorsAssistChipColors;
                        modifier3 = modifier2;
                        function27 = function25;
                        chipBorder2 = chipBorder;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "225@11072L5,226@11123L18,227@11194L21,228@11262L18,229@11332L39");
                        int i18 = i10;
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i16 != 0 ? Modifier.INSTANCE : modifier2;
                            boolean z4 = i5 == 0 ? z2 : true;
                            function28 = i6 != 0 ? null : function25;
                            Function2 function210 = i7 != 0 ? null : function23;
                            if ((i3 & 64) != 0) {
                                i12 = i11 & (-3670017);
                                shape3 = AssistChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                shape3 = shape;
                                i12 = i11;
                            }
                            if ((i3 & 128) != 0) {
                                chipColorsAssistChipColors = AssistChipDefaults.INSTANCE.assistChipColors(composerStartRestartGroup, 6);
                                i12 &= -29360129;
                            }
                            ChipColors chipColors3 = chipColorsAssistChipColors;
                            int i19 = i12;
                            if ((i3 & 256) != 0) {
                                composer3 = composerStartRestartGroup;
                                modifier4 = companion;
                                i13 = 6;
                                i14 = i18;
                                i19 &= -234881025;
                                chipElevationM3315assistChipElevationaqJV_2Y = AssistChipDefaults.INSTANCE.m3315assistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                            } else {
                                modifier4 = companion;
                                i13 = 6;
                                composer3 = composerStartRestartGroup;
                                i14 = i18;
                                chipElevationM3315assistChipElevationaqJV_2Y = chipElevation;
                            }
                            if ((i3 & 512) != 0) {
                                composerStartRestartGroup = composer3;
                                chipBorderM3312assistChipBorderd_3_b6Q = AssistChipDefaults.INSTANCE.m3312assistChipBorderd_3_b6Q(0L, 0L, 0.0f, composerStartRestartGroup, 3072, 7);
                                i15 = i19 & (-1879048193);
                            } else {
                                composerStartRestartGroup = composer3;
                                chipBorderM3312assistChipBorderd_3_b6Q = chipBorder;
                                i15 = i19;
                            }
                            if (i9 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -636337050, "CC(remember):Chip.kt#9igjgp");
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            chipElevation3 = chipElevationM3315assistChipElevationaqJV_2Y;
                            shape4 = shape3;
                            z2 = z4;
                            chipColorsAssistChipColors = chipColors3;
                            function29 = function210;
                            modifier5 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            int i20 = (i3 & 64) != 0 ? i11 & (-3670017) : i11;
                            if ((i3 & 128) != 0) {
                                i20 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i20 &= -234881025;
                            }
                            if ((i3 & 512) != 0) {
                                i20 &= -1879048193;
                            }
                            function29 = function23;
                            shape4 = shape;
                            chipElevation3 = chipElevation;
                            chipBorderM3312assistChipBorderd_3_b6Q = chipBorder;
                            mutableInteractionSource3 = mutableInteractionSource;
                            i13 = 6;
                            modifier5 = modifier2;
                            function28 = function25;
                            i15 = i20;
                            i14 = i18;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1930061919, i15, i14, "androidx.compose.material3.AssistChip (Chip.kt:231)");
                        }
                        TextStyle value = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, i13);
                        BorderStroke value2 = null;
                        long jM3395labelColorvNxB06k$material3 = chipColorsAssistChipColors.m3395labelColorvNxB06k$material3(z2);
                        if (chipBorderM3312assistChipBorderd_3_b6Q == null) {
                            composerStartRestartGroup.startReplaceGroup(1748832781);
                            composerStartRestartGroup.endReplaceGroup();
                            stateBorderStroke$material3 = null;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-636322700);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "243@11781L21");
                            stateBorderStroke$material3 = chipBorderM3312assistChipBorderd_3_b6Q.borderStroke$material3(z2, composerStartRestartGroup, ((i15 >> 9) & 14) | ((i15 >> 24) & 112));
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (stateBorderStroke$material3 != null) {
                            value2 = stateBorderStroke$material3.getValue();
                        }
                        int i21 = i15 << 6;
                        ChipColors chipColors4 = chipColorsAssistChipColors;
                        composer2 = composerStartRestartGroup;
                        boolean z5 = z2;
                        m3405ChipnkUnTEs(modifier5, function0, z5, function24, value, jM3395labelColorvNxB06k$material3, function28, function29, shape4, chipColors4, chipElevation3, value2, AssistChipDefaults.INSTANCE.m3318getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource3, composer2, ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896) | (i21 & 7168) | (3670016 & i21) | (29360128 & i21) | (234881024 & i21) | (i21 & 1879048192), ((i15 >> 24) & 14) | 3456 | ((i14 << 12) & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        chipBorder2 = chipBorderM3312assistChipBorderd_3_b6Q;
                        modifier3 = modifier5;
                        z3 = z5;
                        function27 = function28;
                        function26 = function29;
                        shape2 = shape4;
                        chipColors2 = chipColors4;
                        chipElevation2 = chipElevation3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.AssistChip$lambda$2(function0, function2, modifier3, z3, function27, function26, shape2, chipColors2, chipElevation2, chipBorder2, mutableInteractionSource2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= 24576;
                function25 = function22;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                i8 = i3 & 1024;
                if (i8 == 0) {
                }
                i11 = i4;
                if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i6 = i3 & 16;
            if (i6 == 0) {
            }
            function25 = function22;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i8 = i3 & 1024;
            if (i8 == 0) {
            }
            i11 = i4;
            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i3 & 16;
        if (i6 == 0) {
        }
        function25 = function22;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i8 = i3 & 1024;
        if (i8 == 0) {
        }
        i11 = i4;
        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit AssistChip$lambda$0(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        AssistChip((Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function2, modifier, z, (Function2<? super Composer, ? super Integer, Unit>) function22, (Function2<? super Composer, ? super Integer, Unit>) function23, shape, chipColors, chipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit AssistChip$lambda$2(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        AssistChip(function0, function2, modifier, z, function22, function23, shape, chipColors, chipElevation, chipBorder, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: Chip-nkUnTEs, reason: not valid java name */
    private static final void m3405ChipnkUnTEs(final Modifier modifier, final Function0<Unit> function0, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final long j, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Shape shape, final ChipColors chipColors, final ChipElevation chipElevation, final BorderStroke borderStroke, final float f, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i4;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        Composer composerStartRestartGroup = composer.startRestartGroup(892465622);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Chip)N(modifier,onClick,enabled,label,labelTextStyle,labelColor:c#ui.graphics.Color,leadingIcon,trailingIcon,shape,colors,elevation,border,minHeight:c#ui.unit.Dp,paddingValues,interactionSource)1962@97212L22,1969@97509L478,1960@97138L849:Chip.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function24 = function2;
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 2048 : 1024;
        } else {
            function24 = function2;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(textStyle) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(chipColors) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(chipElevation) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(borderStroke) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(paddingValues) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
        }
        int i5 = i4;
        if (composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i5 & 9363) == 9362) ? false : true, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(892465622, i3, i5, "androidx.compose.material3.Chip (Chip.kt:1957)");
            }
            if (mutableInteractionSource2 == null) {
                composerStartRestartGroup.startReplaceGroup(1596346437);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1959@97094L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1333978275, "CC(remember):Chip.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1333978926);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1333974516, "CC(remember):Chip.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChipKt.Chip_nkUnTEs$lambda$17$lambda$16((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            State<Dp> stateShadowElevation$material3 = null;
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue2, 1, null);
            long jM3385containerColorvNxB06k$material3 = chipColors.m3385containerColorvNxB06k$material3(z);
            if (chipElevation == null) {
                composerStartRestartGroup.startReplaceGroup(1596621344);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1333969407);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1966@97371L43");
                stateShadowElevation$material3 = chipElevation.shadowElevation$material3(z, mutableInteractionSource2, composerStartRestartGroup, ((i3 >> 6) & 14) | ((i5 << 6) & 896));
            }
            composerStartRestartGroup.endReplaceGroup();
            composer2 = composerStartRestartGroup;
            int i6 = i3;
            final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
            SurfaceKt.m4148Surfaceo_FOJdg(function0, modifierSemantics$default, z, shape, jM3385containerColorvNxB06k$material3, 0L, 0.0f, stateShadowElevation$material3 != null ? stateShadowElevation$material3.getValue().m9128unboximpl() : Dp.m9114constructorimpl(0.0f), borderStroke, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(-70915349, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i7) {
                    ComposerKt.sourceInformation(composer3, "C1970@97519L462:Chip.kt#uh7d8r");
                    if (!composer3.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-70915349, i7, -1, "androidx.compose.material3.Chip.<anonymous> (Chip.kt:1970)");
                    }
                    ChipKt.m3406ChipContentfe0OD_I(function25, textStyle, j, function22, null, function23, chipColors.m3396leadingIconContentColorvNxB06k$material3(z), chipColors.m3397trailingIconContentColorvNxB06k$material3(z), f, paddingValues, composer3, 24576);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), composer2, ((i6 >> 15) & 7168) | ((i6 >> 3) & 14) | (i6 & 896) | ((i5 << 21) & 234881024), 6, 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.Chip_nkUnTEs$lambda$18(modifier, function0, z, function2, textStyle, j, function22, function23, shape, chipColors, chipElevation, borderStroke, f, paddingValues, mutableInteractionSource, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ChipContent-fe0OD_I, reason: not valid java name */
    public static final void m3406ChipContentfe0OD_I(final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, long j, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final long j2, final long j3, final float f, final PaddingValues paddingValues, Composer composer, final int i) {
        int i2;
        long j4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        long j5;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1105630840);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ChipContent)N(label,labelTextStyle,labelColor:c#ui.graphics.Color,leadingIcon,avatar,trailingIcon,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,minHeight:c#ui.unit.Dp,paddingValues)2056@100480L1721,2053@100353L1848:Chip.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            j4 = j;
            i2 |= composerStartRestartGroup.changed(j4) ? 256 : 128;
        } else {
            j4 = j;
        }
        if ((i & 3072) == 0) {
            function25 = function22;
            i2 |= composerStartRestartGroup.changedInstance(function25) ? 2048 : 1024;
        } else {
            function25 = function22;
        }
        if ((i & 24576) == 0) {
            function26 = function23;
            i2 |= composerStartRestartGroup.changedInstance(function26) ? 16384 : 8192;
        } else {
            function26 = function23;
        }
        if ((196608 & i) == 0) {
            function27 = function24;
            i2 |= composerStartRestartGroup.changedInstance(function27) ? 131072 : 65536;
        } else {
            function27 = function24;
        }
        if ((1572864 & i) == 0) {
            j5 = j2;
            i2 |= composerStartRestartGroup.changed(j5) ? 1048576 : 524288;
        } else {
            j5 = j2;
        }
        if ((12582912 & i) == 0) {
            i3 = i2 | (composerStartRestartGroup.changed(j3) ? 8388608 : 4194304);
        } else {
            i3 = i2;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(paddingValues) ? 536870912 : 268435456;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1105630840, i3, -1, "androidx.compose.material3.ChipContent (Chip.kt:2052)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function28 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function29 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function210 = function27;
            final long j6 = j5;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(j4)), TextKt.getLocalTextStyle().provides(textStyle)}, ComposableLambdaKt.rememberComposableLambda(-2130105544, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    String str;
                    int i5;
                    ComposerKt.sourceInformation(composer2, "C2093@102146L38,2057@100490L1705:Chip.kt#uh7d8r");
                    if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2130105544, i4, -1, "androidx.compose.material3.ChipContent.<anonymous> (Chip.kt:2057)");
                    }
                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m2068defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, f, 1, null), paddingValues);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1668025758, "CC(remember):Chip.kt#9igjgp");
                    Object objRememberedValue = composer2.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new ChipLayoutMeasurePolicy();
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ChipLayoutMeasurePolicy chipLayoutMeasurePolicy = (ChipLayoutMeasurePolicy) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Function2<Composer, Integer, Unit> function211 = function29;
                    Function2<Composer, Integer, Unit> function212 = function28;
                    Function2<Composer, Integer, Unit> function213 = function210;
                    long j7 = j6;
                    Function2<Composer, Integer, Unit> function214 = function2;
                    long j8 = j3;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierPadding);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                    Updater.m5603setimpl(composerM5595constructorimpl, chipLayoutMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -411001482, "C2073@101229L326:Chip.kt#uh7d8r");
                    if (function211 == null && function212 == null) {
                        composer2.startReplaceGroup(-410471693);
                        composer2.endReplaceGroup();
                        str = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                        i5 = -692256719;
                    } else {
                        composer2.startReplaceGroup(-410987750);
                        ComposerKt.sourceInformation(composer2, "2061@100697L497");
                        Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "leadingIcon");
                        Alignment center = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierLayoutId);
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
                        ComposerKt.sourceInformationMarkerStart(composer2, -1737582560, "C2066@100955L53:Chip.kt#uh7d8r");
                        str = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                        i5 = -692256719;
                        Function2 function2M3412leadingContentXOJAsU = ChipKt.m3412leadingContentXOJAsU(function211, function212, j7, composer2, 0);
                        if (function2M3412leadingContentXOJAsU != null) {
                            composer2.startReplaceGroup(-1737425918);
                            ComposerKt.sourceInformation(composer2, "2068@101099L16");
                            function2M3412leadingContentXOJAsU.invoke(composer2, 0);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(-1737349038);
                            composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceGroup();
                    }
                    Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(LayoutIdKt.layoutId(Modifier.INSTANCE, Constants.ScionAnalytics.PARAM_LABEL), ChipKt.HorizontalElementsPadding, Dp.m9114constructorimpl(0.0f));
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierM2038paddingVpY3zN4);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, i5, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer2);
                    Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1437742697, "C2078@101527L7:Chip.kt#uh7d8r");
                    function214.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (function213 != null) {
                        composer2.startReplaceGroup(-410073157);
                        ComposerKt.sourceInformation(composer2, "2081@101620L464");
                        Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "trailingIcon");
                        Alignment center2 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str);
                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierLayoutId2);
                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor4);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM5595constructorimpl4 = Updater.m5595constructorimpl(composer2);
                        Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            composerM5595constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            composerM5595constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1073567083, "C2085@101848L48:Chip.kt#uh7d8r");
                        Function2 function2M3413trailingContentRPmYEkk = ChipKt.m3413trailingContentRPmYEkk(function213, j8, composer2, 0);
                        if (function2M3413trailingContentRPmYEkk != null) {
                            composer2.startReplaceGroup(1073690090);
                            ComposerKt.sourceInformation(composer2, "2087@101988L17");
                            function2M3413trailingContentRPmYEkk.invoke(composer2, 0);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(1073767931);
                            composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-409588813);
                        composer2.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final long j7 = j4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.ChipContent_fe0OD_I$lambda$23(function2, textStyle, j7, function22, function23, function24, j2, j3, f, paddingValues, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ChipContent_fe0OD_I$lambda$23(Function2 function2, TextStyle textStyle, long j, Function2 function22, Function2 function23, Function2 function24, long j2, long j3, float f, PaddingValues paddingValues, int i, Composer composer, int i2) {
        m3406ChipContentfe0OD_I(function2, textStyle, j, function22, function23, function24, j2, j3, f, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit Chip_nkUnTEs$lambda$17$lambda$16(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8327getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Chip_nkUnTEs$lambda$18(Modifier modifier, Function0 function0, boolean z, Function2 function2, TextStyle textStyle, long j, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, float f, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m3405ChipnkUnTEs(modifier, function0, z, function2, textStyle, j, function22, function23, shape, chipColors, chipElevation, borderStroke, f, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedAssistChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i7;
        ChipColors chipColorsElevatedAssistChipColors;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final ChipElevation chipElevation2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z3;
        Composer composer2;
        final Shape shape2;
        final ChipColors chipColors2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final BorderStroke borderStroke2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape shape3;
        int i14;
        Modifier modifier4;
        int i15;
        int i16;
        ChipElevation chipElevationM3317elevatedAssistChipElevationaqJV_2Y;
        int i17;
        MutableInteractionSource mutableInteractionSource3;
        ChipElevation chipElevation3;
        BorderStroke borderStroke3;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Modifier modifier5;
        Shape shape4;
        Composer composerStartRestartGroup = composer.startRestartGroup(2028863105);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ElevatedAssistChip)N(onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)310@15241L5,305@15073L542:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function24 = function2;
        } else {
            function24 = function2;
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function24) ? 32 : 16;
            }
        }
        int i18 = i3 & 4;
        if (i18 != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        function25 = function22;
                        i4 |= composerStartRestartGroup.changedInstance(function25) ? 16384 : 8192;
                    }
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(shape)) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i3 & 128) == 0) {
                            chipColorsElevatedAssistChipColors = chipColors;
                            int i19 = composerStartRestartGroup.changed(chipColorsElevatedAssistChipColors) ? 8388608 : 4194304;
                            i4 |= i19;
                        } else {
                            chipColorsElevatedAssistChipColors = chipColors;
                        }
                        i4 |= i19;
                    } else {
                        chipColorsElevatedAssistChipColors = chipColors;
                    }
                    if ((i & 100663296) == 0) {
                        i4 |= ((i3 & 256) == 0 && composerStartRestartGroup.changed(chipElevation)) ? 67108864 : 33554432;
                    }
                    i8 = i3 & 512;
                    if (i8 != 0) {
                        if ((i & 805306368) == 0) {
                            i9 = i8;
                            i4 |= composerStartRestartGroup.changed(borderStroke) ? 536870912 : 268435456;
                        }
                        i10 = i3 & 1024;
                        if (i10 != 0) {
                            i11 = i10;
                            i12 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i11 = i10;
                            i12 = i2 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                        } else {
                            i11 = i10;
                            i12 = i2;
                        }
                        i13 = i4;
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i12 & 3) == 2) ? false : true, i13 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "299@14813L5,300@14864L26,301@14943L29");
                            int i20 = i12;
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i18 != 0 ? Modifier.INSTANCE : modifier2;
                                boolean z4 = i5 == 0 ? z2 : true;
                                Function2<? super Composer, ? super Integer, Unit> function210 = i6 != 0 ? null : function25;
                                Function2<? super Composer, ? super Integer, Unit> function211 = i7 != 0 ? null : function23;
                                if ((i3 & 64) != 0) {
                                    i14 = i13 & (-3670017);
                                    shape3 = AssistChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                } else {
                                    shape3 = shape;
                                    i14 = i13;
                                }
                                if ((i3 & 128) != 0) {
                                    chipColorsElevatedAssistChipColors = AssistChipDefaults.INSTANCE.elevatedAssistChipColors(composerStartRestartGroup, 6);
                                    i14 &= -29360129;
                                }
                                ChipColors chipColors3 = chipColorsElevatedAssistChipColors;
                                int i21 = i14;
                                if ((i3 & 256) != 0) {
                                    modifier4 = companion;
                                    i16 = i20;
                                    i15 = 6;
                                    chipElevationM3317elevatedAssistChipElevationaqJV_2Y = AssistChipDefaults.INSTANCE.m3317elevatedAssistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                                    i17 = i21 & (-234881025);
                                } else {
                                    modifier4 = companion;
                                    i15 = 6;
                                    i16 = i20;
                                    chipElevationM3317elevatedAssistChipElevationaqJV_2Y = chipElevation;
                                    i17 = i21;
                                }
                                BorderStroke borderStroke4 = i9 != 0 ? null : borderStroke;
                                if (i11 != 0) {
                                    chipElevation3 = chipElevationM3317elevatedAssistChipElevationaqJV_2Y;
                                    borderStroke3 = borderStroke4;
                                    z2 = z4;
                                    mutableInteractionSource3 = null;
                                    function29 = function210;
                                    chipColorsElevatedAssistChipColors = chipColors3;
                                    function28 = function211;
                                    shape4 = shape3;
                                    modifier5 = modifier4;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    chipElevation3 = chipElevationM3317elevatedAssistChipElevationaqJV_2Y;
                                    borderStroke3 = borderStroke4;
                                    function28 = function211;
                                    z2 = z4;
                                    function29 = function210;
                                    chipColorsElevatedAssistChipColors = chipColors3;
                                    modifier5 = modifier4;
                                    shape4 = shape3;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                int i22 = (i3 & 64) != 0 ? i13 & (-3670017) : i13;
                                if ((i3 & 128) != 0) {
                                    i22 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i22 &= -234881025;
                                }
                                function28 = function23;
                                shape4 = shape;
                                chipElevation3 = chipElevation;
                                borderStroke3 = borderStroke;
                                mutableInteractionSource3 = mutableInteractionSource;
                                i15 = 6;
                                modifier5 = modifier2;
                                i17 = i22;
                                i16 = i20;
                                function29 = function25;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2028863105, i17, i16, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:305)");
                            }
                            int i23 = i17 << 6;
                            int i24 = i17 >> 24;
                            ChipColors chipColors4 = chipColorsElevatedAssistChipColors;
                            boolean z5 = z2;
                            m3405ChipnkUnTEs(modifier5, function0, z5, function24, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, i15), chipColorsElevatedAssistChipColors.m3395labelColorvNxB06k$material3(z2), function29, function28, shape4, chipColors4, chipElevation3, borderStroke3, AssistChipDefaults.INSTANCE.m3318getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource3, composerStartRestartGroup, ((i17 >> 6) & 14) | ((i17 << 3) & 112) | ((i17 >> 3) & 896) | (i23 & 7168) | (3670016 & i23) | (29360128 & i23) | (234881024 & i23) | (i23 & 1879048192), (i24 & 112) | (i24 & 14) | 3456 | ((i16 << 12) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier5;
                            z3 = z5;
                            function27 = function29;
                            function26 = function28;
                            shape2 = shape4;
                            chipColors2 = chipColors4;
                            chipElevation2 = chipElevation3;
                            borderStroke2 = borderStroke3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            function26 = function23;
                            chipElevation2 = chipElevation;
                            mutableInteractionSource2 = mutableInteractionSource;
                            z3 = z2;
                            composer2 = composerStartRestartGroup;
                            shape2 = shape;
                            chipColors2 = chipColorsElevatedAssistChipColors;
                            modifier3 = modifier2;
                            function27 = function25;
                            borderStroke2 = borderStroke;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ChipKt.ElevatedAssistChip$lambda$3(function0, function2, modifier3, z3, function27, function26, shape2, chipColors2, chipElevation2, borderStroke2, mutableInteractionSource2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 805306368;
                    i9 = i8;
                    i10 = i3 & 1024;
                    if (i10 != 0) {
                    }
                    i13 = i4;
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i12 & 3) == 2) ? false : true, i13 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function25 = function22;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i8 = i3 & 512;
                if (i8 != 0) {
                }
                i9 = i8;
                i10 = i3 & 1024;
                if (i10 != 0) {
                }
                i13 = i4;
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i12 & 3) == 2) ? false : true, i13 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            function25 = function22;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i8 = i3 & 512;
            if (i8 != 0) {
            }
            i9 = i8;
            i10 = i3 & 1024;
            if (i10 != 0) {
            }
            i13 = i4;
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i12 & 3) == 2) ? false : true, i13 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        function25 = function22;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i8 = i3 & 512;
        if (i8 != 0) {
        }
        i9 = i8;
        i10 = i3 & 1024;
        if (i10 != 0) {
        }
        i13 = i4;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i12 & 3) == 2) ? false : true, i13 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:196:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedAssistChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "ElevatedAssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void ElevatedAssistChip(final Function0 function0, final Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function2 function24;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        Function2 function25;
        int i7;
        ChipColors chipColorsElevatedAssistChipColors;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        final Function2 function26;
        final ChipElevation chipElevation2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z3;
        Composer composer2;
        final Shape shape2;
        final ChipColors chipColors2;
        final Modifier modifier3;
        final Function2 function27;
        final ChipBorder chipBorder2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape shape3;
        int i14;
        Modifier modifier4;
        int i15;
        int i16;
        ChipElevation chipElevationM3317elevatedAssistChipElevationaqJV_2Y;
        int i17;
        MutableInteractionSource mutableInteractionSource3;
        ChipElevation chipElevation3;
        ChipBorder chipBorder3;
        Function2 function28;
        Function2 function29;
        Shape shape4;
        Modifier modifier5;
        State<BorderStroke> stateBorderStroke$material3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-759567147);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ElevatedAssistChip)N(onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)394@19326L5,389@19158L572:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function24 = function2;
        } else {
            function24 = function2;
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function24) ? 32 : 16;
            }
        }
        int i18 = i3 & 4;
        if (i18 != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        function25 = function22;
                        i4 |= composerStartRestartGroup.changedInstance(function25) ? 16384 : 8192;
                    }
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(shape)) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i3 & 128) == 0) {
                            chipColorsElevatedAssistChipColors = chipColors;
                            int i19 = composerStartRestartGroup.changed(chipColorsElevatedAssistChipColors) ? 8388608 : 4194304;
                            i4 |= i19;
                        } else {
                            chipColorsElevatedAssistChipColors = chipColors;
                        }
                        i4 |= i19;
                    } else {
                        chipColorsElevatedAssistChipColors = chipColors;
                    }
                    if ((i & 100663296) == 0) {
                        i4 |= ((i3 & 256) == 0 && composerStartRestartGroup.changed(chipElevation)) ? 67108864 : 33554432;
                    }
                    i8 = i3 & 512;
                    if (i8 != 0) {
                        if ((i & 805306368) == 0) {
                            i9 = i8;
                            i4 |= composerStartRestartGroup.changed(chipBorder) ? 536870912 : 268435456;
                        }
                        i10 = i3 & 1024;
                        if (i10 != 0) {
                            i11 = i10;
                            i12 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i11 = i10;
                            i12 = i2 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                        } else {
                            i11 = i10;
                            i12 = i2;
                        }
                        i13 = i4;
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i12 & 3) == 2) ? false : true, i13 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "383@18866L5,384@18917L26,385@18996L29,387@19109L39");
                            int i20 = i12;
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i18 != 0 ? Modifier.INSTANCE : modifier2;
                                boolean z4 = i5 == 0 ? z2 : true;
                                Function2 function210 = i6 != 0 ? null : function25;
                                Function2 function211 = i7 != 0 ? null : function23;
                                if ((i3 & 64) != 0) {
                                    i14 = i13 & (-3670017);
                                    shape3 = AssistChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                } else {
                                    shape3 = shape;
                                    i14 = i13;
                                }
                                if ((i3 & 128) != 0) {
                                    chipColorsElevatedAssistChipColors = AssistChipDefaults.INSTANCE.elevatedAssistChipColors(composerStartRestartGroup, 6);
                                    i14 &= -29360129;
                                }
                                ChipColors chipColors3 = chipColorsElevatedAssistChipColors;
                                int i21 = i14;
                                if ((i3 & 256) != 0) {
                                    modifier4 = companion;
                                    i16 = i20;
                                    i15 = 6;
                                    chipElevationM3317elevatedAssistChipElevationaqJV_2Y = AssistChipDefaults.INSTANCE.m3317elevatedAssistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                                    i17 = i21 & (-234881025);
                                } else {
                                    modifier4 = companion;
                                    i15 = 6;
                                    i16 = i20;
                                    chipElevationM3317elevatedAssistChipElevationaqJV_2Y = chipElevation;
                                    i17 = i21;
                                }
                                ChipBorder chipBorder4 = i9 != 0 ? null : chipBorder;
                                if (i11 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 200442940, "CC(remember):Chip.kt#9igjgp");
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    chipElevation3 = chipElevationM3317elevatedAssistChipElevationaqJV_2Y;
                                    chipBorder3 = chipBorder4;
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    chipElevation3 = chipElevationM3317elevatedAssistChipElevationaqJV_2Y;
                                    chipBorder3 = chipBorder4;
                                }
                                z2 = z4;
                                function28 = function210;
                                chipColorsElevatedAssistChipColors = chipColors3;
                                function29 = function211;
                                shape4 = shape3;
                                modifier5 = modifier4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                int i22 = (i3 & 64) != 0 ? i13 & (-3670017) : i13;
                                if ((i3 & 128) != 0) {
                                    i22 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i22 &= -234881025;
                                }
                                function29 = function23;
                                shape4 = shape;
                                chipElevation3 = chipElevation;
                                chipBorder3 = chipBorder;
                                mutableInteractionSource3 = mutableInteractionSource;
                                i15 = 6;
                                modifier5 = modifier2;
                                i17 = i22;
                                i16 = i20;
                                function28 = function25;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-759567147, i17, i16, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:389)");
                            }
                            TextStyle value = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, i15);
                            BorderStroke value2 = null;
                            long jM3395labelColorvNxB06k$material3 = chipColorsElevatedAssistChipColors.m3395labelColorvNxB06k$material3(z2);
                            float fM3318getHeightD9Ej5fM = AssistChipDefaults.INSTANCE.m3318getHeightD9Ej5fM();
                            PaddingValues paddingValues = AssistChipPadding;
                            if (chipBorder3 == null) {
                                composerStartRestartGroup.startReplaceGroup(1919297975);
                                composerStartRestartGroup.endReplaceGroup();
                                stateBorderStroke$material3 = null;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(200460170);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "403@19648L21");
                                stateBorderStroke$material3 = chipBorder3.borderStroke$material3(z2, composerStartRestartGroup, ((i17 >> 9) & 14) | ((i17 >> 24) & 112));
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            if (stateBorderStroke$material3 != null) {
                                value2 = stateBorderStroke$material3.getValue();
                            }
                            int i23 = i17 << 6;
                            ChipColors chipColors4 = chipColorsElevatedAssistChipColors;
                            boolean z5 = z2;
                            m3405ChipnkUnTEs(modifier5, function0, z5, function24, value, jM3395labelColorvNxB06k$material3, function28, function29, shape4, chipColors4, chipElevation3, value2, fM3318getHeightD9Ej5fM, paddingValues, mutableInteractionSource3, composerStartRestartGroup, ((i17 >> 6) & 14) | ((i17 << 3) & 112) | ((i17 >> 3) & 896) | (i23 & 7168) | (3670016 & i23) | (29360128 & i23) | (234881024 & i23) | (i23 & 1879048192), ((i17 >> 24) & 14) | 3456 | ((i16 << 12) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            chipBorder2 = chipBorder3;
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier5;
                            z3 = z5;
                            function27 = function28;
                            function26 = function29;
                            shape2 = shape4;
                            chipColors2 = chipColors4;
                            chipElevation2 = chipElevation3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            function26 = function23;
                            chipElevation2 = chipElevation;
                            mutableInteractionSource2 = mutableInteractionSource;
                            z3 = z2;
                            composer2 = composerStartRestartGroup;
                            shape2 = shape;
                            chipColors2 = chipColorsElevatedAssistChipColors;
                            modifier3 = modifier2;
                            function27 = function25;
                            chipBorder2 = chipBorder;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ChipKt.ElevatedAssistChip$lambda$5(function0, function2, modifier3, z3, function27, function26, shape2, chipColors2, chipElevation2, chipBorder2, mutableInteractionSource2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 805306368;
                    i9 = i8;
                    i10 = i3 & 1024;
                    if (i10 != 0) {
                    }
                    i13 = i4;
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i12 & 3) == 2) ? false : true, i13 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function25 = function22;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i8 = i3 & 512;
                if (i8 != 0) {
                }
                i9 = i8;
                i10 = i3 & 1024;
                if (i10 != 0) {
                }
                i13 = i4;
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i12 & 3) == 2) ? false : true, i13 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            function25 = function22;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i8 = i3 & 512;
            if (i8 != 0) {
            }
            i9 = i8;
            i10 = i3 & 1024;
            if (i10 != 0) {
            }
            i13 = i4;
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i12 & 3) == 2) ? false : true, i13 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        function25 = function22;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i8 = i3 & 512;
        if (i8 != 0) {
        }
        i9 = i8;
        i10 = i3 & 1024;
        if (i10 != 0) {
        }
        i13 = i4;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i12 & 3) == 2) ? false : true, i13 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit ElevatedAssistChip$lambda$3(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        ElevatedAssistChip((Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function2, modifier, z, (Function2<? super Composer, ? super Integer, Unit>) function22, (Function2<? super Composer, ? super Integer, Unit>) function23, shape, chipColors, chipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit ElevatedAssistChip$lambda$5(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        ElevatedAssistChip(function0, function2, modifier, z, function22, function23, shape, chipColors, chipElevation, chipBorder, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedFilterChip(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function0<Unit> function02;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Shape shape2;
        SelectableChipColors selectableChipColors2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource2;
        final SelectableChipColors selectableChipColors3;
        final Modifier modifier3;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Shape shape3;
        final boolean z4;
        final SelectableChipElevation selectableChipElevation2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i15;
        Shape shape4;
        SelectableChipColors selectableChipColorsElevatedFilterChipColors;
        Modifier modifier4;
        int i16;
        int i17;
        SelectableChipElevation selectableChipElevationM3673elevatedFilterChipElevationaqJV_2Y;
        int i18;
        MutableInteractionSource mutableInteractionSource3;
        SelectableChipElevation selectableChipElevation3;
        BorderStroke borderStroke3;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        int i19;
        Shape shape5;
        int i20;
        Modifier modifier5;
        boolean z5;
        Composer composerStartRestartGroup = composer.startRestartGroup(1533553846);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ElevatedFilterChip)N(selected,onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)562@27590L5,556@27383L555:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
            function24 = function2;
        } else {
            function24 = function2;
            if ((i & 384) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function24) ? 256 : 128;
            }
        }
        int i21 = i3 & 8;
        if (i21 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i & 24576) == 0) {
                    z3 = z2;
                    i4 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(function22) ? 131072 : 65536;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    i4 |= 1572864;
                    function25 = function23;
                } else {
                    function25 = function23;
                    if ((i & 1572864) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function25) ? 1048576 : 524288;
                    }
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        shape2 = shape;
                        int i22 = composerStartRestartGroup.changed(shape2) ? 8388608 : 4194304;
                        i4 |= i22;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i22;
                } else {
                    shape2 = shape;
                }
                if ((i & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        selectableChipColors2 = selectableChipColors;
                        int i23 = composerStartRestartGroup.changed(selectableChipColors2) ? 67108864 : 33554432;
                        i4 |= i23;
                    } else {
                        selectableChipColors2 = selectableChipColors;
                    }
                    i4 |= i23;
                } else {
                    selectableChipColors2 = selectableChipColors;
                }
                if ((i & 805306368) == 0) {
                    i4 |= ((i3 & 512) == 0 && composerStartRestartGroup.changed(selectableChipElevation)) ? 536870912 : 268435456;
                }
                i8 = i3 & 1024;
                if (i8 != 0) {
                    i10 = i2 | 6;
                    i9 = i8;
                } else if ((i2 & 6) == 0) {
                    i9 = i8;
                    i10 = i2 | (composerStartRestartGroup.changed(borderStroke) ? 4 : 2);
                } else {
                    i9 = i8;
                    i10 = i2;
                }
                i11 = i3 & 2048;
                if (i11 != 0) {
                    i10 |= 48;
                    i12 = i11;
                } else if ((i2 & 48) == 0) {
                    i12 = i11;
                    i10 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 32 : 16;
                } else {
                    i12 = i11;
                }
                i13 = i10;
                i14 = i4;
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "550@27103L5,551@27164L26,552@27253L29");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i21 != 0 ? Modifier.INSTANCE : modifier2;
                        boolean z6 = i5 == 0 ? z3 : true;
                        Function2<? super Composer, ? super Integer, Unit> function210 = i6 != 0 ? null : function22;
                        Function2<? super Composer, ? super Integer, Unit> function211 = i7 != 0 ? null : function25;
                        if ((i3 & 128) != 0) {
                            i15 = i14 & (-29360129);
                            shape4 = FilterChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                            shape4 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            i15 &= -234881025;
                            selectableChipColorsElevatedFilterChipColors = FilterChipDefaults.INSTANCE.elevatedFilterChipColors(composerStartRestartGroup, 6);
                        } else {
                            selectableChipColorsElevatedFilterChipColors = selectableChipColors2;
                        }
                        int i24 = i15;
                        if ((i3 & 512) != 0) {
                            modifier4 = companion;
                            i17 = i13;
                            i16 = 6;
                            selectableChipElevationM3673elevatedFilterChipElevationaqJV_2Y = FilterChipDefaults.INSTANCE.m3673elevatedFilterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i18 = i24 & (-1879048193);
                        } else {
                            modifier4 = companion;
                            i16 = 6;
                            i17 = i13;
                            selectableChipElevationM3673elevatedFilterChipElevationaqJV_2Y = selectableChipElevation;
                            i18 = i24;
                        }
                        BorderStroke borderStroke4 = i9 != 0 ? null : borderStroke;
                        if (i12 != 0) {
                            selectableChipElevation3 = selectableChipElevationM3673elevatedFilterChipElevationaqJV_2Y;
                            borderStroke3 = borderStroke4;
                            function28 = function210;
                            function29 = function211;
                            i19 = 12582912;
                            mutableInteractionSource3 = null;
                            i20 = 1533553846;
                            modifier5 = modifier4;
                            z5 = z6;
                            shape5 = shape4;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            selectableChipElevation3 = selectableChipElevationM3673elevatedFilterChipElevationaqJV_2Y;
                            borderStroke3 = borderStroke4;
                            function28 = function210;
                            function29 = function211;
                            i19 = 12582912;
                            shape5 = shape4;
                            i20 = 1533553846;
                            modifier5 = modifier4;
                            z5 = z6;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        int i25 = (i3 & 128) != 0 ? i14 & (-29360129) : i14;
                        if ((i3 & 256) != 0) {
                            i25 &= -234881025;
                        }
                        if ((i3 & 512) != 0) {
                            i25 &= -1879048193;
                        }
                        function28 = function22;
                        selectableChipElevation3 = selectableChipElevation;
                        borderStroke3 = borderStroke;
                        mutableInteractionSource3 = mutableInteractionSource;
                        i16 = 6;
                        function29 = function25;
                        shape5 = shape2;
                        selectableChipColorsElevatedFilterChipColors = selectableChipColors2;
                        modifier5 = modifier2;
                        i19 = 12582912;
                        i20 = 1533553846;
                        i18 = i25;
                        z5 = z3;
                        i17 = i13;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i20, i18, i17, "androidx.compose.material3.ElevatedFilterChip (Chip.kt:556)");
                    }
                    int i26 = i18 << 3;
                    int i27 = i18 << 6;
                    int i28 = i19 | (i18 & 14) | ((i18 >> 6) & 112) | (i26 & 896) | ((i18 >> 3) & 7168) | (57344 & i27) | (i26 & 3670016) | (234881024 & i27) | (1879048192 & i27);
                    int i29 = i18 >> 24;
                    m3407SelectableChipu0RnIRE(z, modifier5, function02, z5, function24, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, i16), function28, null, function29, shape5, selectableChipColorsElevatedFilterChipColors, selectableChipElevation3, borderStroke3, FilterChipDefaults.INSTANCE.m3677getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource3, composerStartRestartGroup, i28, (i29 & 112) | (i29 & 14) | 27648 | ((i17 << 6) & 896) | ((i17 << 12) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                    z4 = z5;
                    function26 = function28;
                    function27 = function29;
                    shape3 = shape5;
                    selectableChipColors3 = selectableChipColorsElevatedFilterChipColors;
                    selectableChipElevation2 = selectableChipElevation3;
                    borderStroke2 = borderStroke3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    borderStroke2 = borderStroke;
                    mutableInteractionSource2 = mutableInteractionSource;
                    selectableChipColors3 = selectableChipColors2;
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    function26 = function22;
                    function27 = function25;
                    shape3 = shape2;
                    z4 = z3;
                    selectableChipElevation2 = selectableChipElevation;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.ElevatedFilterChip$lambda$7(z, function0, function2, modifier3, z4, function26, function27, shape3, selectableChipColors3, selectableChipElevation2, borderStroke2, mutableInteractionSource2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 24576;
            z3 = z2;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i3 & 64;
            if (i7 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i8 = i3 & 1024;
            if (i8 != 0) {
            }
            i11 = i3 & 2048;
            if (i11 != 0) {
            }
            i13 = i10;
            i14 = i4;
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i14 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 16;
        if (i5 != 0) {
        }
        z3 = z2;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i3 & 64;
        if (i7 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i8 = i3 & 1024;
        if (i8 != 0) {
        }
        i11 = i3 & 2048;
        if (i11 != 0) {
        }
        i13 = i10;
        i14 = i4;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i14 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit ElevatedFilterChip$lambda$7(boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function22, Function2 function23, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        ElevatedFilterChip(z, function0, function2, modifier, z2, function22, function23, shape, selectableChipColors, selectableChipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedSuggestionChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function23;
        final Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Shape shape2;
        ChipColors chipColors2;
        int i6;
        ChipElevation chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        final boolean z3;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        Composer composer2;
        final Shape shape3;
        final ChipColors chipColors3;
        final ChipElevation chipElevation2;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i12;
        Shape shape4;
        ChipColors chipColorsElevatedSuggestionChipColors;
        int i13;
        BorderStroke borderStroke3;
        int i14;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape5;
        Function2<? super Composer, ? super Integer, Unit> function26;
        ChipElevation chipElevation3;
        boolean z4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-894435833);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ElevatedSuggestionChip)N(onClick,label,modifier,enabled,icon,shape,colors,elevation,border,interactionSource)904@43788L5,899@43616L539:Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function23) ? 32 : 16;
            }
        }
        int i15 = i2 & 4;
        if (i15 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        function24 = function22;
                        i3 |= composerStartRestartGroup.changedInstance(function24) ? 16384 : 8192;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            shape2 = shape;
                            int i16 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                            i3 |= i16;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i16;
                    } else {
                        shape2 = shape;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            chipColors2 = chipColors;
                            int i17 = composerStartRestartGroup.changed(chipColors2) ? 1048576 : 524288;
                            i3 |= i17;
                        } else {
                            chipColors2 = chipColors;
                        }
                        i3 |= i17;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 12582912) != 0) {
                        i6 = 12582912;
                        if ((i2 & 128) == 0) {
                            chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y = chipElevation;
                            int i18 = composerStartRestartGroup.changed(chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y) ? 8388608 : 4194304;
                            i3 |= i18;
                        } else {
                            chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y = chipElevation;
                        }
                        i3 |= i18;
                    } else {
                        i6 = 12582912;
                        chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y = chipElevation;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i8 = i15;
                            i3 |= composerStartRestartGroup.changed(borderStroke) ? 67108864 : 33554432;
                        }
                        i9 = i2 & 512;
                        if (i9 == 0) {
                            if ((i & 805306368) == 0) {
                                i10 = i9;
                                i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                            }
                            i11 = i3;
                            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                z3 = z2;
                                function25 = function24;
                                composer2 = composerStartRestartGroup;
                                shape3 = shape2;
                                chipColors3 = chipColors2;
                                chipElevation2 = chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y;
                                borderStroke2 = borderStroke;
                                mutableInteractionSource2 = mutableInteractionSource;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "893@43340L5,894@43395L30,895@43482L33");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    companion = i8 != 0 ? Modifier.INSTANCE : modifier2;
                                    boolean z5 = i4 == 0 ? z2 : true;
                                    Function2<? super Composer, ? super Integer, Unit> function27 = i5 != 0 ? null : function24;
                                    if ((i2 & 32) != 0) {
                                        i12 = i11 & (-458753);
                                        shape4 = SuggestionChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                    } else {
                                        i12 = i11;
                                        shape4 = shape2;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i12 &= -3670017;
                                        chipColorsElevatedSuggestionChipColors = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipColors(composerStartRestartGroup, 6);
                                    } else {
                                        chipColorsElevatedSuggestionChipColors = chipColors2;
                                    }
                                    int i19 = i12;
                                    if ((i2 & 128) != 0) {
                                        i19 &= -29360129;
                                        i13 = 6;
                                        chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y = SuggestionChipDefaults.INSTANCE.m4138elevatedSuggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                                    } else {
                                        i13 = 6;
                                    }
                                    int i20 = i19;
                                    borderStroke3 = i7 != 0 ? null : borderStroke;
                                    i14 = i20;
                                    mutableInteractionSource3 = i10 != 0 ? null : mutableInteractionSource;
                                    shape5 = shape4;
                                    chipColors2 = chipColorsElevatedSuggestionChipColors;
                                    function26 = function27;
                                    chipElevation3 = chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y;
                                    z4 = z5;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 32) != 0) {
                                        i11 &= -458753;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i11 &= -3670017;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i11 &= -29360129;
                                    }
                                    borderStroke3 = borderStroke;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    companion = modifier2;
                                    function26 = function24;
                                    shape5 = shape2;
                                    chipElevation3 = chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y;
                                    i14 = i11;
                                    i13 = 6;
                                    z4 = z2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-894435833, i14, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:899)");
                                }
                                int i21 = i14 << 6;
                                int i22 = ((i14 >> 6) & 14) | i6 | ((i14 << 3) & 112) | ((i14 >> 3) & 896) | (i21 & 7168) | (i21 & 3670016);
                                int i23 = i14 << 9;
                                int i24 = i22 | (234881024 & i23) | (i23 & 1879048192);
                                int i25 = i14 >> 21;
                                ChipColors chipColors4 = chipColors2;
                                Function2<? super Composer, ? super Integer, Unit> function28 = function23;
                                Modifier modifier3 = companion;
                                m3405ChipnkUnTEs(modifier3, function02, z4, function28, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, i13), chipColors2.m3395labelColorvNxB06k$material3(z4), function26, null, shape5, chipColors4, chipElevation3, borderStroke3, SuggestionChipDefaults.INSTANCE.m4139getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composerStartRestartGroup, i24, (i25 & 112) | (i25 & 14) | 3456 | ((i14 >> 15) & 57344));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = composerStartRestartGroup;
                                modifier2 = modifier3;
                                z3 = z4;
                                function25 = function26;
                                shape3 = shape5;
                                chipColors3 = chipColors4;
                                chipElevation2 = chipElevation3;
                                borderStroke2 = borderStroke3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda15
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ChipKt.ElevatedSuggestionChip$lambda$12(function0, function2, modifier2, z3, function25, shape3, chipColors3, chipElevation2, borderStroke2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 805306368;
                        i10 = i9;
                        i11 = i3;
                        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i8 = i15;
                    i9 = i2 & 512;
                    if (i9 == 0) {
                    }
                    i10 = i9;
                    i11 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function24 = function22;
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                if ((i & 12582912) != 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i15;
                i9 = i2 & 512;
                if (i9 == 0) {
                }
                i10 = i9;
                i11 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function24 = function22;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            if ((i & 12582912) != 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i15;
            i9 = i2 & 512;
            if (i9 == 0) {
            }
            i10 = i9;
            i11 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function24 = function22;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i15;
        i9 = i2 & 512;
        if (i9 == 0) {
        }
        i10 = i9;
        i11 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ff  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedSuggestionChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "ElevatedSuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void ElevatedSuggestionChip(final Function0 function0, final Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        Function0 function02;
        int i3;
        Function2 function23;
        final Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Function2 function24;
        Shape shape2;
        ChipColors chipColors2;
        int i6;
        ChipElevation chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        final boolean z3;
        final Function2 function25;
        Composer composer2;
        final Shape shape3;
        final ChipColors chipColors3;
        final ChipElevation chipElevation2;
        final ChipBorder chipBorder2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i12;
        Shape shape4;
        ChipColors chipColorsElevatedSuggestionChipColors;
        int i13;
        ChipBorder chipBorder3;
        MutableInteractionSource mutableInteractionSource3;
        Function2 function26;
        Shape shape5;
        State<BorderStroke> state;
        int i14;
        ChipElevation chipElevation3;
        boolean z4;
        State<BorderStroke> stateBorderStroke$material3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1306662363);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ElevatedSuggestionChip)N(onClick,label,modifier,enabled,icon,shape,colors,elevation,border,interactionSource)985@47676L5,980@47504L569:Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function23) ? 32 : 16;
            }
        }
        int i15 = i2 & 4;
        if (i15 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        function24 = function22;
                        i3 |= composerStartRestartGroup.changedInstance(function24) ? 16384 : 8192;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            shape2 = shape;
                            int i16 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                            i3 |= i16;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i16;
                    } else {
                        shape2 = shape;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            chipColors2 = chipColors;
                            int i17 = composerStartRestartGroup.changed(chipColors2) ? 1048576 : 524288;
                            i3 |= i17;
                        } else {
                            chipColors2 = chipColors;
                        }
                        i3 |= i17;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 12582912) != 0) {
                        i6 = 12582912;
                        if ((i2 & 128) == 0) {
                            chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y = chipElevation;
                            int i18 = composerStartRestartGroup.changed(chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y) ? 8388608 : 4194304;
                            i3 |= i18;
                        } else {
                            chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y = chipElevation;
                        }
                        i3 |= i18;
                    } else {
                        i6 = 12582912;
                        chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y = chipElevation;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i8 = i15;
                            i3 |= composerStartRestartGroup.changed(chipBorder) ? 67108864 : 33554432;
                        }
                        i9 = i2 & 512;
                        if (i9 == 0) {
                            if ((i & 805306368) == 0) {
                                i10 = i9;
                                i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                            }
                            i11 = i3;
                            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                z3 = z2;
                                function25 = function24;
                                composer2 = composerStartRestartGroup;
                                shape3 = shape2;
                                chipColors3 = chipColors2;
                                chipElevation2 = chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y;
                                chipBorder2 = chipBorder;
                                mutableInteractionSource2 = mutableInteractionSource;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "974@47196L5,975@47251L30,976@47338L33,978@47455L39");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    companion = i8 != 0 ? Modifier.INSTANCE : modifier2;
                                    boolean z5 = i4 == 0 ? z2 : true;
                                    Function2 function27 = i5 != 0 ? null : function24;
                                    if ((i2 & 32) != 0) {
                                        i12 = i11 & (-458753);
                                        shape4 = SuggestionChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                    } else {
                                        i12 = i11;
                                        shape4 = shape2;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i12 &= -3670017;
                                        chipColorsElevatedSuggestionChipColors = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipColors(composerStartRestartGroup, 6);
                                    } else {
                                        chipColorsElevatedSuggestionChipColors = chipColors2;
                                    }
                                    int i19 = i12;
                                    if ((i2 & 128) != 0) {
                                        i19 &= -29360129;
                                        i13 = 6;
                                        chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y = SuggestionChipDefaults.INSTANCE.m4138elevatedSuggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                                    } else {
                                        i13 = 6;
                                    }
                                    chipBorder3 = i7 != 0 ? null : chipBorder;
                                    if (i10 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1572109794, "CC(remember):Chip.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    function26 = function27;
                                    shape5 = shape4;
                                    chipColors2 = chipColorsElevatedSuggestionChipColors;
                                    state = null;
                                    i14 = i19;
                                    chipElevation3 = chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y;
                                    z4 = z5;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 32) != 0) {
                                        i11 &= -458753;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i11 &= -3670017;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i11 &= -29360129;
                                    }
                                    chipBorder3 = chipBorder;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    companion = modifier2;
                                    function26 = function24;
                                    shape5 = shape2;
                                    state = null;
                                    i13 = 6;
                                    chipElevation3 = chipElevationM4138elevatedSuggestionChipElevationaqJV_2Y;
                                    i14 = i11;
                                    z4 = z2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1306662363, i14, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:980)");
                                }
                                TextStyle value = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, i13);
                                long jM3395labelColorvNxB06k$material3 = chipColors2.m3395labelColorvNxB06k$material3(z4);
                                float fM4139getHeightD9Ej5fM = SuggestionChipDefaults.INSTANCE.m4139getHeightD9Ej5fM();
                                PaddingValues paddingValues = SuggestionChipPadding;
                                if (chipBorder3 == null) {
                                    composerStartRestartGroup.startReplaceGroup(1491294513);
                                    composerStartRestartGroup.endReplaceGroup();
                                    stateBorderStroke$material3 = state;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1572126928);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "994@47991L21");
                                    stateBorderStroke$material3 = chipBorder3.borderStroke$material3(z4, composerStartRestartGroup, ((i14 >> 9) & 14) | ((i14 >> 21) & 112));
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                BorderStroke value2 = stateBorderStroke$material3 != null ? stateBorderStroke$material3.getValue() : state;
                                int i20 = i14 << 6;
                                int i21 = ((i14 >> 6) & 14) | i6 | ((i14 << 3) & 112) | ((i14 >> 3) & 896) | (i20 & 7168) | (i20 & 3670016);
                                int i22 = i14 << 9;
                                ChipColors chipColors4 = chipColors2;
                                Function2 function28 = function23;
                                Modifier modifier3 = companion;
                                m3405ChipnkUnTEs(modifier3, function02, z4, function28, value, jM3395labelColorvNxB06k$material3, function26, null, shape5, chipColors4, chipElevation3, value2, fM4139getHeightD9Ej5fM, paddingValues, mutableInteractionSource3, composerStartRestartGroup, i21 | (234881024 & i22) | (i22 & 1879048192), ((i14 >> 21) & 14) | 3456 | ((i14 >> 15) & 57344));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                chipBorder2 = chipBorder3;
                                composer2 = composerStartRestartGroup;
                                modifier2 = modifier3;
                                z3 = z4;
                                function25 = function26;
                                shape3 = shape5;
                                chipColors3 = chipColors4;
                                chipElevation2 = chipElevation3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ChipKt.ElevatedSuggestionChip$lambda$14(function0, function2, modifier2, z3, function25, shape3, chipColors3, chipElevation2, chipBorder2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 805306368;
                        i10 = i9;
                        i11 = i3;
                        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i8 = i15;
                    i9 = i2 & 512;
                    if (i9 == 0) {
                    }
                    i10 = i9;
                    i11 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function24 = function22;
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                if ((i & 12582912) != 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i15;
                i9 = i2 & 512;
                if (i9 == 0) {
                }
                i10 = i9;
                i11 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function24 = function22;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            if ((i & 12582912) != 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i15;
            i9 = i2 & 512;
            if (i9 == 0) {
            }
            i10 = i9;
            i11 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function24 = function22;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i15;
        i9 = i2 & 512;
        if (i9 == 0) {
        }
        i10 = i9;
        i11 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit ElevatedSuggestionChip$lambda$12(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        ElevatedSuggestionChip((Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function2, modifier, z, (Function2<? super Composer, ? super Integer, Unit>) function22, shape, chipColors, chipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit ElevatedSuggestionChip$lambda$14(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        ElevatedSuggestionChip(function0, function2, modifier, z, function22, shape, chipColors, chipElevation, chipBorder, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:205:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilterChip(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        boolean z3;
        int i4;
        Function0<Unit> function02;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Shape shape2;
        SelectableChipColors selectableChipColors2;
        int i8;
        int i9;
        int i10;
        MutableInteractionSource mutableInteractionSource2;
        int i11;
        int i12;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource3;
        final SelectableChipColors selectableChipColors3;
        final Modifier modifier3;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Shape shape3;
        final boolean z5;
        final SelectableChipElevation selectableChipElevation2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i13;
        Shape shape4;
        SelectableChipColors selectableChipColorsFilterChipColors;
        Modifier modifier4;
        int i14;
        int i15;
        SelectableChipElevation selectableChipElevationM3676filterChipElevationaqJV_2Y;
        int i16;
        BorderStroke borderStrokeM3674filterChipBorder_7El2pE;
        MutableInteractionSource mutableInteractionSource4;
        SelectableChipElevation selectableChipElevation3;
        BorderStroke borderStroke3;
        boolean z6;
        int i17;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Shape shape5;
        SelectableChipColors selectableChipColors4;
        Modifier modifier5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1385473344);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilterChip)N(selected,onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)480@23562L5,474@23355L555:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 6) == 0) {
                i4 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i4 = i;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
            function24 = function2;
        } else {
            function24 = function2;
            if ((i & 384) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function24) ? 256 : 128;
            }
        }
        int i18 = i3 & 8;
        if (i18 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i & 24576) == 0) {
                    z4 = z2;
                    i4 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(function22) ? 131072 : 65536;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    i4 |= 1572864;
                    function25 = function23;
                } else {
                    function25 = function23;
                    if ((i & 1572864) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function25) ? 1048576 : 524288;
                    }
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        shape2 = shape;
                        int i19 = composerStartRestartGroup.changed(shape2) ? 8388608 : 4194304;
                        i4 |= i19;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i19;
                } else {
                    shape2 = shape;
                }
                if ((i & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        selectableChipColors2 = selectableChipColors;
                        int i20 = composerStartRestartGroup.changed(selectableChipColors2) ? 67108864 : 33554432;
                        i4 |= i20;
                    } else {
                        selectableChipColors2 = selectableChipColors;
                    }
                    i4 |= i20;
                } else {
                    selectableChipColors2 = selectableChipColors;
                }
                if ((i & 805306368) == 0) {
                    i4 |= ((i3 & 512) == 0 && composerStartRestartGroup.changed(selectableChipElevation)) ? 536870912 : 268435456;
                }
                if ((i2 & 6) == 0) {
                    i8 = i2 | (((i3 & 1024) == 0 && composerStartRestartGroup.changed(borderStroke)) ? 4 : 2);
                } else {
                    i8 = i2;
                }
                i9 = i3 & 2048;
                if (i9 != 0) {
                    i10 = i9;
                    i11 = i8 | 48;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    if ((i2 & 48) == 0) {
                        i10 = i9;
                        mutableInteractionSource2 = mutableInteractionSource;
                        i8 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 32 : 16;
                    } else {
                        i10 = i9;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    i11 = i8;
                }
                i12 = i4;
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 19) == 18) ? false : true, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "468@23041L5,469@23102L18,470@23183L21,471@23253L35");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i18 != 0 ? Modifier.INSTANCE : modifier2;
                        boolean z7 = i5 != 0 ? true : z4;
                        Function2<? super Composer, ? super Integer, Unit> function210 = i6 != 0 ? null : function22;
                        Function2<? super Composer, ? super Integer, Unit> function211 = i7 != 0 ? null : function25;
                        if ((i3 & 128) != 0) {
                            i13 = i12 & (-29360129);
                            shape4 = FilterChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i13 = i12;
                            shape4 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            i13 &= -234881025;
                            selectableChipColorsFilterChipColors = FilterChipDefaults.INSTANCE.filterChipColors(composerStartRestartGroup, 6);
                        } else {
                            selectableChipColorsFilterChipColors = selectableChipColors2;
                        }
                        int i21 = i13;
                        if ((i3 & 512) != 0) {
                            modifier4 = companion;
                            i14 = 6;
                            i15 = i10;
                            selectableChipElevationM3676filterChipElevationaqJV_2Y = FilterChipDefaults.INSTANCE.m3676filterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            i16 = i21 & (-1879048193);
                        } else {
                            modifier4 = companion;
                            i14 = 6;
                            i15 = i10;
                            selectableChipElevationM3676filterChipElevationaqJV_2Y = selectableChipElevation;
                            i16 = i21;
                        }
                        if ((i3 & 1024) != 0) {
                            borderStrokeM3674filterChipBorder_7El2pE = FilterChipDefaults.INSTANCE.m3674filterChipBorder_7El2pE(z7, z3, 0L, 0L, 0L, 0L, 0.0f, 0.0f, composerStartRestartGroup, ((i16 >> 12) & 14) | 100663296 | ((i16 << 3) & 112), 252);
                            i11 &= -15;
                        } else {
                            borderStrokeM3674filterChipBorder_7El2pE = borderStroke;
                        }
                        if (i15 != 0) {
                            selectableChipElevation3 = selectableChipElevationM3676filterChipElevationaqJV_2Y;
                            borderStroke3 = borderStrokeM3674filterChipBorder_7El2pE;
                            z6 = z7;
                            i17 = i11;
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource;
                            selectableChipElevation3 = selectableChipElevationM3676filterChipElevationaqJV_2Y;
                            borderStroke3 = borderStrokeM3674filterChipBorder_7El2pE;
                            z6 = z7;
                            i17 = i11;
                        }
                        function28 = function210;
                        function29 = function211;
                        shape5 = shape4;
                        selectableChipColors4 = selectableChipColorsFilterChipColors;
                        modifier5 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        int i22 = (i3 & 128) != 0 ? i12 & (-29360129) : i12;
                        if ((i3 & 256) != 0) {
                            i22 &= -234881025;
                        }
                        if ((i3 & 512) != 0) {
                            i22 &= -1879048193;
                        }
                        if ((i3 & 1024) != 0) {
                            i11 &= -15;
                        }
                        function28 = function22;
                        selectableChipElevation3 = selectableChipElevation;
                        borderStroke3 = borderStroke;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        function29 = function25;
                        shape5 = shape2;
                        selectableChipColors4 = selectableChipColors2;
                        modifier5 = modifier2;
                        z6 = z4;
                        i16 = i22;
                        i14 = 6;
                        i17 = i11;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1385473344, i16, i17, "androidx.compose.material3.FilterChip (Chip.kt:474)");
                    }
                    int i23 = i16 << 3;
                    int i24 = i16 << 6;
                    int i25 = i16 >> 24;
                    m3407SelectableChipu0RnIRE(z, modifier5, function02, z6, function24, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, i14), function28, null, function29, shape5, selectableChipColors4, selectableChipElevation3, borderStroke3, FilterChipDefaults.INSTANCE.m3677getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource4, composerStartRestartGroup, (i16 & 14) | 12582912 | ((i16 >> 6) & 112) | (i23 & 896) | ((i16 >> 3) & 7168) | (57344 & i24) | (i23 & 3670016) | (234881024 & i24) | (1879048192 & i24), (i25 & 112) | (i25 & 14) | 27648 | ((i17 << 6) & 896) | ((i17 << 12) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                    z5 = z6;
                    function26 = function28;
                    function27 = function29;
                    shape3 = shape5;
                    selectableChipColors3 = selectableChipColors4;
                    selectableChipElevation2 = selectableChipElevation3;
                    borderStroke2 = borderStroke3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    borderStroke2 = borderStroke;
                    mutableInteractionSource3 = mutableInteractionSource;
                    selectableChipColors3 = selectableChipColors2;
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    function26 = function22;
                    function27 = function25;
                    shape3 = shape2;
                    z5 = z4;
                    selectableChipElevation2 = selectableChipElevation;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.FilterChip$lambda$6(z, function0, function2, modifier3, z5, function26, function27, shape3, selectableChipColors3, selectableChipElevation2, borderStroke2, mutableInteractionSource3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 24576;
            z4 = z2;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i3 & 64;
            if (i7 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i2 & 6) == 0) {
            }
            i9 = i3 & 2048;
            if (i9 != 0) {
            }
            i12 = i4;
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 19) == 18) ? false : true, i12 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 16;
        if (i5 != 0) {
        }
        z4 = z2;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i3 & 64;
        if (i7 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i2 & 6) == 0) {
        }
        i9 = i3 & 2048;
        if (i9 != 0) {
        }
        i12 = i4;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 19) == 18) ? false : true, i12 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit FilterChip$lambda$6(boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function22, Function2 function23, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        FilterChip(z, function0, function2, modifier, z2, function22, function23, shape, selectableChipColors, selectableChipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:234:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InputChip(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        boolean z3;
        int i4;
        Function0<Unit> function02;
        int i5;
        int i6;
        int i7;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        int i8;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        final Modifier modifier2;
        final boolean z4;
        final SelectableChipElevation selectableChipElevation2;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Shape shape2;
        final SelectableChipColors selectableChipColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape shape3;
        int i15;
        SelectableChipColors selectableChipColorsInputChipColors;
        Modifier modifier3;
        int i16;
        int i17;
        SelectableChipElevation selectableChipElevationM3758inputChipElevationaqJV_2Y;
        BorderStroke borderStrokeM3756inputChipBorder_7El2pE;
        MutableInteractionSource mutableInteractionSource3;
        SelectableChipElevation selectableChipElevation3;
        BorderStroke borderStroke3;
        boolean z5;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Shape shape4;
        SelectableChipColors selectableChipColors3;
        int i18;
        Modifier modifier4;
        boolean z6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1975409271);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InputChip)N(selected,onClick,label,modifier,enabled,leadingIcon,avatar,trailingIcon,shape,colors,elevation,border,interactionSource)673@32653L5,667@32447L747:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 6) == 0) {
                i4 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i4 = i;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    i4 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 == 0) {
                    if ((i & 24576) == 0) {
                        i4 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
                    }
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function25 = function22;
                    } else {
                        function25 = function22;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function25) ? 131072 : 65536;
                        }
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                        function26 = function23;
                    } else {
                        function26 = function23;
                        if ((i & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function26) ? 1048576 : 524288;
                        }
                    }
                    i9 = i3 & 128;
                    if (i9 == 0) {
                        i4 |= 12582912;
                        function27 = function24;
                    } else {
                        function27 = function24;
                        if ((i & 12582912) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function27) ? 8388608 : 4194304;
                        }
                    }
                    if ((i & 100663296) == 0) {
                        i4 |= ((i3 & 256) == 0 && composerStartRestartGroup.changed(shape)) ? 67108864 : 33554432;
                    }
                    if ((i & 805306368) == 0) {
                        i4 |= ((i3 & 512) == 0 && composerStartRestartGroup.changed(selectableChipColors)) ? 536870912 : 268435456;
                    }
                    if ((i2 & 6) != 0) {
                        i10 = i2 | (((i3 & 1024) == 0 && composerStartRestartGroup.changed(selectableChipElevation)) ? 4 : 2);
                    } else {
                        i10 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        i10 |= ((i3 & 2048) == 0 && composerStartRestartGroup.changed(borderStroke)) ? 32 : 16;
                    }
                    int i19 = i10;
                    i11 = i3 & 4096;
                    if (i11 == 0) {
                        i12 = i11;
                        i13 = i19 | 384;
                    } else {
                        int i20 = i19;
                        if ((i2 & 384) == 0) {
                            i20 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
                        }
                        i12 = i11;
                        i13 = i20;
                    }
                    i14 = i4;
                    if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 147) != 146, i14 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        z4 = z2;
                        selectableChipElevation2 = selectableChipElevation;
                        borderStroke2 = borderStroke;
                        mutableInteractionSource2 = mutableInteractionSource;
                        composer2 = composerStartRestartGroup;
                        function28 = function27;
                        shape2 = shape;
                        selectableChipColors2 = selectableChipColors;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "640@31314L5,641@31374L17,642@31453L20,643@31521L34");
                        ComposableLambda composableLambdaRememberComposableLambda = null;
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier;
                            boolean z7 = i6 != 0 ? true : z2;
                            Function2<? super Composer, ? super Integer, Unit> function211 = i7 != 0 ? null : function25;
                            Function2<? super Composer, ? super Integer, Unit> function212 = i8 != 0 ? null : function26;
                            Function2<? super Composer, ? super Integer, Unit> function213 = i9 != 0 ? null : function27;
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                shape3 = InputChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                shape3 = shape;
                                i15 = i14;
                            }
                            if ((i3 & 512) != 0) {
                                i15 &= -1879048193;
                                selectableChipColorsInputChipColors = InputChipDefaults.INSTANCE.inputChipColors(composerStartRestartGroup, 6);
                            } else {
                                selectableChipColorsInputChipColors = selectableChipColors;
                            }
                            int i21 = i15;
                            if ((i3 & 1024) != 0) {
                                modifier3 = companion;
                                i16 = 6;
                                i17 = i12;
                                selectableChipElevationM3758inputChipElevationaqJV_2Y = InputChipDefaults.INSTANCE.m3758inputChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                                i13 &= -15;
                            } else {
                                modifier3 = companion;
                                i16 = 6;
                                i17 = i12;
                                selectableChipElevationM3758inputChipElevationaqJV_2Y = selectableChipElevation;
                            }
                            if ((i3 & 2048) != 0) {
                                borderStrokeM3756inputChipBorder_7El2pE = InputChipDefaults.INSTANCE.m3756inputChipBorder_7El2pE(z7, z3, 0L, 0L, 0L, 0L, 0.0f, 0.0f, composerStartRestartGroup, ((i21 >> 12) & 14) | 100663296 | ((i21 << 3) & 112), 252);
                                i13 &= -113;
                            } else {
                                borderStrokeM3756inputChipBorder_7El2pE = borderStroke;
                            }
                            if (i17 != 0) {
                                selectableChipElevation3 = selectableChipElevationM3758inputChipElevationaqJV_2Y;
                                borderStroke3 = borderStrokeM3756inputChipBorder_7El2pE;
                                z5 = z7;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                selectableChipElevation3 = selectableChipElevationM3758inputChipElevationaqJV_2Y;
                                borderStroke3 = borderStrokeM3756inputChipBorder_7El2pE;
                                z5 = z7;
                            }
                            function29 = function211;
                            function26 = function212;
                            function210 = function213;
                            shape4 = shape3;
                            selectableChipColors3 = selectableChipColorsInputChipColors;
                            i18 = i21;
                            modifier4 = modifier3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            int i22 = (i3 & 256) != 0 ? i14 & (-234881025) : i14;
                            if ((i3 & 512) != 0) {
                                i22 &= -1879048193;
                            }
                            if ((i3 & 1024) != 0) {
                                i13 &= -15;
                            }
                            if ((i3 & 2048) != 0) {
                                i13 &= -113;
                            }
                            i18 = i22;
                            i16 = 6;
                            modifier4 = modifier;
                            z5 = z2;
                            shape4 = shape;
                            selectableChipColors3 = selectableChipColors;
                            selectableChipElevation3 = selectableChipElevation;
                            borderStroke3 = borderStroke;
                            mutableInteractionSource3 = mutableInteractionSource;
                            function29 = function25;
                            function210 = function27;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1975409271, i18, i13, "androidx.compose.material3.InputChip (Chip.kt:645)");
                        }
                        if (function26 != null) {
                            composerStartRestartGroup.startReplaceGroup(225175787);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "651@31963L5,653@32016L420");
                            z6 = true;
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-570452295, true, new AnonymousClass1(z5 ? 1.0f : InputChipTokens.INSTANCE.getDisabledAvatarOpacity(), ShapesKt.getValue(InputChipTokens.INSTANCE.getAvatarShape(), composerStartRestartGroup, i16), function26), composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            z6 = true;
                            composerStartRestartGroup.startReplaceGroup(225773529);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ComposableLambda composableLambda = composableLambdaRememberComposableLambda;
                        TextStyle value = TypographyKt.getValue(InputChipTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, i16);
                        float fM3754getHeightD9Ej5fM = InputChipDefaults.INSTANCE.m3754getHeightD9Ej5fM();
                        boolean z8 = composableLambda != null ? z6 : false;
                        boolean z9 = function29 != null ? z6 : false;
                        if (function210 == null) {
                            z6 = false;
                        }
                        PaddingValues paddingValuesInputChipPadding = inputChipPadding(z8, z9, z6);
                        int i23 = i18 << 3;
                        int i24 = (i18 & 14) | ((i18 >> 6) & 112) | (i23 & 896) | ((i18 >> 3) & 7168) | ((i18 << 6) & 57344) | (3670016 & i23) | (234881024 & i23) | (i23 & 1879048192);
                        int i25 = ((i18 >> 27) & 14) | 3072;
                        int i26 = i13 << 3;
                        m3407SelectableChipu0RnIRE(z, modifier4, function02, z5, function2, value, function29, composableLambda, function210, shape4, selectableChipColors3, selectableChipElevation3, borderStroke3, fM3754getHeightD9Ej5fM, paddingValuesInputChipPadding, mutableInteractionSource3, composerStartRestartGroup, i24, i25 | (i26 & 112) | (i26 & 896) | ((i13 << 9) & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2 = composerStartRestartGroup;
                        modifier2 = modifier4;
                        z4 = z5;
                        function25 = function29;
                        function28 = function210;
                        shape2 = shape4;
                        selectableChipColors2 = selectableChipColors3;
                        selectableChipElevation2 = selectableChipElevation3;
                        borderStroke2 = borderStroke3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.InputChip$lambda$8(z, function0, function2, modifier2, z4, function25, function26, function28, shape2, selectableChipColors2, selectableChipElevation2, borderStroke2, mutableInteractionSource2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= 24576;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                i9 = i3 & 128;
                if (i9 == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                if ((i2 & 6) != 0) {
                }
                if ((i2 & 48) == 0) {
                }
                int i192 = i10;
                i11 = i3 & 4096;
                if (i11 == 0) {
                }
                i14 = i4;
                if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 147) != 146, i14 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i6 = i3 & 16;
            if (i6 == 0) {
            }
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            i9 = i3 & 128;
            if (i9 == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i2 & 6) != 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i1922 = i10;
            i11 = i3 & 4096;
            if (i11 == 0) {
            }
            i14 = i4;
            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 147) != 146, i14 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        i6 = i3 & 16;
        if (i6 == 0) {
        }
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        i9 = i3 & 128;
        if (i9 == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i2 & 6) != 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i19222 = i10;
        i11 = i3 & 4096;
        if (i11 == 0) {
        }
        i14 = i4;
        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 147) != 146, i14 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit InputChip$lambda$8(boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function22, Function2 function23, Function2 function24, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        InputChip(z, function0, function2, modifier, z2, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: SelectableChip-u0RnIRE, reason: not valid java name */
    private static final void m3407SelectableChipu0RnIRE(final boolean z, final Modifier modifier, final Function0<Unit> function0, final boolean z2, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Shape shape, final SelectableChipColors selectableChipColors, final SelectableChipElevation selectableChipElevation, final BorderStroke borderStroke, final float f, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource2;
        State<Dp> stateShadowElevation$material3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1786844928);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectableChip)N(selected,modifier,onClick,enabled,label,labelTextStyle,leadingIcon,avatar,trailingIcon,shape,colors,elevation,border,minHeight:c#ui.unit.Dp,paddingValues,interactionSource)2009@98774L24,2016@99083L670,2006@98671L1082:Chip.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= composerStartRestartGroup.changed(textStyle) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(selectableChipColors) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(selectableChipElevation) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(borderStroke) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(paddingValues) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 131072 : 65536;
        }
        int i5 = i4;
        if (composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (74899 & i5) == 74898) ? false : true, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1786844928, i3, i5, "androidx.compose.material3.SelectableChip (Chip.kt:2003)");
            }
            if (mutableInteractionSource == null) {
                composerStartRestartGroup.startReplaceGroup(73215547);
                ComposerKt.sourceInformation(composerStartRestartGroup, "2005@98627L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -828922201, "CC(remember):Chip.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            } else {
                composerStartRestartGroup.startReplaceGroup(-828922852);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource2 = mutableInteractionSource;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -828917512, "CC(remember):Chip.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChipKt.SelectableChip_u0RnIRE$lambda$21$lambda$20((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i6 = i3;
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue2, 1, null);
            long jM4041containerColorWaAFU9c$material3 = selectableChipColors.m4041containerColorWaAFU9c$material3(z2, z);
            if (selectableChipElevation == null) {
                composerStartRestartGroup.startReplaceGroup(73531126);
                composerStartRestartGroup.endReplaceGroup();
                stateShadowElevation$material3 = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-828912021);
                ComposerKt.sourceInformation(composerStartRestartGroup, "2013@98945L43");
                stateShadowElevation$material3 = selectableChipElevation.shadowElevation$material3(z2, mutableInteractionSource2, composerStartRestartGroup, ((i6 >> 9) & 14) | ((i5 << 3) & 896));
                composerStartRestartGroup.endReplaceGroup();
            }
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4146Surfaced85dljk(z, function0, modifierSemantics$default, z2, shape, jM4041containerColorWaAFU9c$material3, 0L, 0.0f, stateShadowElevation$material3 != null ? stateShadowElevation$material3.getValue().m9128unboximpl() : Dp.m9114constructorimpl(0.0f), borderStroke, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(-990050154, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i7) {
                    ComposerKt.sourceInformation(composer3, "C2019@99228L519:Chip.kt#uh7d8r");
                    if (!composer3.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-990050154, i7, -1, "androidx.compose.material3.SelectableChip.<anonymous> (Chip.kt:2019)");
                    }
                    ChipKt.m3404AnimatingChipContentfe0OD_I(function2, textStyle, selectableChipColors.m4043labelColorWaAFU9c$material3(z2, z), function22, function23, function24, selectableChipColors.m4044leadingIconContentColorWaAFU9c$material3(z2, z), selectableChipColors.m4045trailingIconContentColorWaAFU9c$material3(z2, z), f, paddingValues, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), composer2, (i6 & 14) | ((i6 >> 3) & 112) | (i6 & 7168) | ((i6 >> 15) & 57344) | ((i5 << 21) & 1879048192), 48, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.SelectableChip_u0RnIRE$lambda$22(z, modifier, function0, z2, function2, textStyle, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, f, paddingValues, mutableInteractionSource, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SelectableChip_u0RnIRE$lambda$21$lambda$20(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8329getCheckboxo7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit SelectableChip_u0RnIRE$lambda$22(boolean z, Modifier modifier, Function0 function0, boolean z2, Function2 function2, TextStyle textStyle, Function2 function22, Function2 function23, Function2 function24, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, float f, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m3407SelectableChipu0RnIRE(z, modifier, function0, z2, function2, textStyle, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, f, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SuggestionChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function23;
        final Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Shape shape2;
        ChipColors chipColors2;
        int i6;
        ChipElevation chipElevationM4144suggestionChipElevationaqJV_2Y;
        int i7;
        int i8;
        int i9;
        final boolean z3;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        Composer composer2;
        final Shape shape3;
        final ChipColors chipColors3;
        final ChipElevation chipElevation2;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        Shape shape4;
        ChipColors chipColorsSuggestionChipColors;
        int i11;
        Modifier modifier3;
        int i12;
        boolean z4;
        BorderStroke borderStrokeM4142suggestionChipBorderh1eTWw;
        int i13;
        MutableInteractionSource mutableInteractionSource3;
        BorderStroke borderStroke3;
        int i14;
        Shape shape5;
        Function2<? super Composer, ? super Integer, Unit> function26;
        ChipElevation chipElevation3;
        boolean z5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-252243183);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SuggestionChip)N(onClick,label,modifier,enabled,icon,shape,colors,elevation,border,interactionSource)751@36361L5,746@36189L539:Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function23) ? 32 : 16;
            }
        }
        int i15 = i2 & 4;
        if (i15 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        function24 = function22;
                        i3 |= composerStartRestartGroup.changedInstance(function24) ? 16384 : 8192;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            shape2 = shape;
                            int i16 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                            i3 |= i16;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i16;
                    } else {
                        shape2 = shape;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            chipColors2 = chipColors;
                            int i17 = composerStartRestartGroup.changed(chipColors2) ? 1048576 : 524288;
                            i3 |= i17;
                        } else {
                            chipColors2 = chipColors;
                        }
                        i3 |= i17;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 12582912) != 0) {
                        i6 = 12582912;
                        if ((i2 & 128) == 0) {
                            chipElevationM4144suggestionChipElevationaqJV_2Y = chipElevation;
                            int i18 = composerStartRestartGroup.changed(chipElevationM4144suggestionChipElevationaqJV_2Y) ? 8388608 : 4194304;
                            i3 |= i18;
                        } else {
                            chipElevationM4144suggestionChipElevationaqJV_2Y = chipElevation;
                        }
                        i3 |= i18;
                    } else {
                        i6 = 12582912;
                        chipElevationM4144suggestionChipElevationaqJV_2Y = chipElevation;
                    }
                    if ((i & 100663296) == 0) {
                        i3 |= ((i2 & 256) == 0 && composerStartRestartGroup.changed(borderStroke)) ? 67108864 : 33554432;
                    }
                    i7 = i2 & 512;
                    if (i7 != 0) {
                        if ((i & 805306368) == 0) {
                            i8 = i7;
                            i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                        }
                        i9 = i3;
                        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "740@35881L5,741@35936L22,742@36015L25,743@36093L29");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i15 != 0 ? Modifier.INSTANCE : modifier2;
                                boolean z6 = i4 == 0 ? z2 : true;
                                Function2<? super Composer, ? super Integer, Unit> function27 = i5 != 0 ? null : function24;
                                if ((i2 & 32) != 0) {
                                    i10 = i9 & (-458753);
                                    shape4 = SuggestionChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                } else {
                                    i10 = i9;
                                    shape4 = shape2;
                                }
                                if ((i2 & 64) != 0) {
                                    i10 &= -3670017;
                                    chipColorsSuggestionChipColors = SuggestionChipDefaults.INSTANCE.suggestionChipColors(composerStartRestartGroup, 6);
                                } else {
                                    chipColorsSuggestionChipColors = chipColors2;
                                }
                                int i19 = i10;
                                if ((i2 & 128) != 0) {
                                    i19 &= -29360129;
                                    i11 = 6;
                                    chipElevationM4144suggestionChipElevationaqJV_2Y = SuggestionChipDefaults.INSTANCE.m4144suggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                                } else {
                                    i11 = 6;
                                }
                                if ((i2 & 256) != 0) {
                                    modifier3 = companion;
                                    i12 = i11;
                                    z4 = z6;
                                    borderStrokeM4142suggestionChipBorderh1eTWw = SuggestionChipDefaults.INSTANCE.m4142suggestionChipBorderh1eTWw(z4, 0L, 0L, 0.0f, composerStartRestartGroup, ((i19 >> 9) & 14) | 24576, 14);
                                    i13 = i19 & (-234881025);
                                } else {
                                    modifier3 = companion;
                                    i12 = i11;
                                    z4 = z6;
                                    borderStrokeM4142suggestionChipBorderh1eTWw = borderStroke;
                                    i13 = i19;
                                }
                                if (i8 != 0) {
                                    borderStroke3 = borderStrokeM4142suggestionChipBorderh1eTWw;
                                    i14 = i13;
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    borderStroke3 = borderStrokeM4142suggestionChipBorderh1eTWw;
                                    i14 = i13;
                                }
                                shape5 = shape4;
                                chipColors2 = chipColorsSuggestionChipColors;
                                function26 = function27;
                                modifier2 = modifier3;
                                chipElevation3 = chipElevationM4144suggestionChipElevationaqJV_2Y;
                                z5 = z4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i9 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i9 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i9 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i9 &= -234881025;
                                }
                                borderStroke3 = borderStroke;
                                mutableInteractionSource3 = mutableInteractionSource;
                                i12 = 6;
                                function26 = function24;
                                shape5 = shape2;
                                chipElevation3 = chipElevationM4144suggestionChipElevationaqJV_2Y;
                                i14 = i9;
                                z5 = z2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-252243183, i14, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:746)");
                            }
                            int i20 = i14 << 6;
                            int i21 = ((i14 >> 6) & 14) | i6 | ((i14 << 3) & 112) | ((i14 >> 3) & 896) | (i20 & 7168) | (i20 & 3670016);
                            int i22 = i14 << 9;
                            int i23 = i21 | (234881024 & i22) | (i22 & 1879048192);
                            int i24 = i14 >> 21;
                            ChipColors chipColors4 = chipColors2;
                            Function2<? super Composer, ? super Integer, Unit> function28 = function23;
                            Modifier modifier4 = modifier2;
                            m3405ChipnkUnTEs(modifier4, function02, z5, function28, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, i12), chipColors2.m3395labelColorvNxB06k$material3(z5), function26, null, shape5, chipColors4, chipElevation3, borderStroke3, SuggestionChipDefaults.INSTANCE.m4139getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composerStartRestartGroup, i23, (i24 & 112) | (i24 & 14) | 3456 | ((i14 >> 15) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = composerStartRestartGroup;
                            modifier2 = modifier4;
                            z3 = z5;
                            function25 = function26;
                            shape3 = shape5;
                            chipColors3 = chipColors4;
                            chipElevation2 = chipElevation3;
                            borderStroke2 = borderStroke3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            z3 = z2;
                            function25 = function24;
                            composer2 = composerStartRestartGroup;
                            shape3 = shape2;
                            chipColors3 = chipColors2;
                            chipElevation2 = chipElevationM4144suggestionChipElevationaqJV_2Y;
                            borderStroke2 = borderStroke;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ChipKt.SuggestionChip$lambda$9(function0, function2, modifier2, z3, function25, shape3, chipColors3, chipElevation2, borderStroke2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 805306368;
                    i8 = i7;
                    i9 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function24 = function22;
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i7 = i2 & 512;
                if (i7 != 0) {
                }
                i8 = i7;
                i9 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function24 = function22;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i7 = i2 & 512;
            if (i7 != 0) {
            }
            i8 = i7;
            i9 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function24 = function22;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i7 = i2 & 512;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0112  */
    /* JADX WARN: Type inference failed for: r5v16, types: [androidx.compose.runtime.State] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v31 */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with SuggestionChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "SuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void SuggestionChip(final Function0 function0, final Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        Function0 function02;
        int i3;
        Function2 function23;
        final Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Function2 function24;
        Shape shape2;
        ChipColors chipColors2;
        int i6;
        ChipElevation chipElevationM4144suggestionChipElevationaqJV_2Y;
        int i7;
        int i8;
        int i9;
        Composer composer2;
        final boolean z3;
        final Function2 function25;
        final Shape shape3;
        final ChipColors chipColors3;
        final ChipElevation chipElevation2;
        final ChipBorder chipBorder2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        Shape shape4;
        ChipColors chipColorsSuggestionChipColors;
        int i11;
        Composer composer3;
        ChipBorder chipBorderM4141suggestionChipBorderd_3_b6Q;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape5;
        ChipColors chipColors4;
        BorderStroke borderStroke;
        int i12;
        ChipElevation chipElevation3;
        boolean z4;
        Function2 function26;
        ?? r5;
        Composer composerStartRestartGroup = composer.startRestartGroup(270460261);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SuggestionChip)N(onClick,label,modifier,enabled,icon,shape,colors,elevation,border,interactionSource)833@40281L5,828@40109L569:Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function23) ? 32 : 16;
            }
        }
        int i13 = i2 & 4;
        if (i13 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        function24 = function22;
                        i3 |= composerStartRestartGroup.changedInstance(function24) ? 16384 : 8192;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            shape2 = shape;
                            int i14 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                            i3 |= i14;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i14;
                    } else {
                        shape2 = shape;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            chipColors2 = chipColors;
                            int i15 = composerStartRestartGroup.changed(chipColors2) ? 1048576 : 524288;
                            i3 |= i15;
                        } else {
                            chipColors2 = chipColors;
                        }
                        i3 |= i15;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 12582912) != 0) {
                        i6 = 12582912;
                        if ((i2 & 128) == 0) {
                            chipElevationM4144suggestionChipElevationaqJV_2Y = chipElevation;
                            int i16 = composerStartRestartGroup.changed(chipElevationM4144suggestionChipElevationaqJV_2Y) ? 8388608 : 4194304;
                            i3 |= i16;
                        } else {
                            chipElevationM4144suggestionChipElevationaqJV_2Y = chipElevation;
                        }
                        i3 |= i16;
                    } else {
                        i6 = 12582912;
                        chipElevationM4144suggestionChipElevationaqJV_2Y = chipElevation;
                    }
                    if ((i & 100663296) == 0) {
                        i3 |= ((i2 & 256) == 0 && composerStartRestartGroup.changed(chipBorder)) ? 67108864 : 33554432;
                    }
                    i7 = i2 & 512;
                    if (i7 != 0) {
                        if ((i & 805306368) == 0) {
                            i8 = i7;
                            i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                        }
                        i9 = i3;
                        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "822@39776L5,823@39831L22,824@39910L25,825@39986L22,826@40060L39");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i13 != 0 ? Modifier.INSTANCE : modifier2;
                                boolean z5 = i4 == 0 ? z2 : true;
                                Function2 function27 = i5 != 0 ? null : function24;
                                if ((i2 & 32) != 0) {
                                    i10 = i9 & (-458753);
                                    shape4 = SuggestionChipDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                } else {
                                    i10 = i9;
                                    shape4 = shape2;
                                }
                                if ((i2 & 64) != 0) {
                                    i10 &= -3670017;
                                    chipColorsSuggestionChipColors = SuggestionChipDefaults.INSTANCE.suggestionChipColors(composerStartRestartGroup, 6);
                                } else {
                                    chipColorsSuggestionChipColors = chipColors2;
                                }
                                int i17 = i10;
                                if ((i2 & 128) != 0) {
                                    composer3 = composerStartRestartGroup;
                                    i17 &= -29360129;
                                    i11 = 6;
                                    chipElevationM4144suggestionChipElevationaqJV_2Y = SuggestionChipDefaults.INSTANCE.m4144suggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                                } else {
                                    i11 = 6;
                                    composer3 = composerStartRestartGroup;
                                }
                                if ((i2 & 256) != 0) {
                                    composerStartRestartGroup = composer3;
                                    chipBorderM4141suggestionChipBorderd_3_b6Q = SuggestionChipDefaults.INSTANCE.m4141suggestionChipBorderd_3_b6Q(0L, 0L, 0.0f, composerStartRestartGroup, 3072, 7);
                                    i17 &= -234881025;
                                } else {
                                    composerStartRestartGroup = composer3;
                                    chipBorderM4141suggestionChipBorderd_3_b6Q = chipBorder;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2080664820, "CC(remember):Chip.kt#9igjgp");
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    modifier2 = companion;
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    modifier2 = companion;
                                }
                                shape5 = shape4;
                                chipColors4 = chipColorsSuggestionChipColors;
                                borderStroke = null;
                                i12 = i17;
                                chipElevation3 = chipElevationM4144suggestionChipElevationaqJV_2Y;
                                z4 = z5;
                                function26 = function27;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i9 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i9 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i9 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i9 &= -234881025;
                                }
                                chipBorderM4141suggestionChipBorderd_3_b6Q = chipBorder;
                                mutableInteractionSource3 = mutableInteractionSource;
                                function26 = function24;
                                shape5 = shape2;
                                chipColors4 = chipColors2;
                                borderStroke = null;
                                i11 = 6;
                                chipElevation3 = chipElevationM4144suggestionChipElevationaqJV_2Y;
                                i12 = i9;
                                z4 = z2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(270460261, i12, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:828)");
                            }
                            TextStyle value = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, i11);
                            long jM3395labelColorvNxB06k$material3 = chipColors4.m3395labelColorvNxB06k$material3(z4);
                            if (chipBorderM4141suggestionChipBorderd_3_b6Q == null) {
                                composerStartRestartGroup.startReplaceGroup(-75666041);
                                composerStartRestartGroup.endReplaceGroup();
                                r5 = borderStroke;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-2080650822);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "840@40498L21");
                                State<BorderStroke> stateBorderStroke$material3 = chipBorderM4141suggestionChipBorderd_3_b6Q.borderStroke$material3(z4, composerStartRestartGroup, ((i12 >> 9) & 14) | ((i12 >> 21) & 112));
                                composerStartRestartGroup.endReplaceGroup();
                                r5 = stateBorderStroke$material3;
                            }
                            if (r5 != 0) {
                                borderStroke = (BorderStroke) r5.getValue();
                            }
                            int i18 = i12 << 6;
                            int i19 = ((i12 >> 6) & 14) | i6 | ((i12 << 3) & 112) | ((i12 >> 3) & 896) | (i18 & 7168) | (i18 & 3670016);
                            int i20 = i12 << 9;
                            ChipColors chipColors5 = chipColors4;
                            composer2 = composerStartRestartGroup;
                            Function2 function28 = function23;
                            Modifier modifier3 = modifier2;
                            m3405ChipnkUnTEs(modifier3, function02, z4, function28, value, jM3395labelColorvNxB06k$material3, function26, null, shape5, chipColors5, chipElevation3, borderStroke, SuggestionChipDefaults.INSTANCE.m4139getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i19 | (234881024 & i20) | (i20 & 1879048192), ((i12 >> 21) & 14) | 3456 | ((i12 >> 15) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            chipBorder2 = chipBorderM4141suggestionChipBorderd_3_b6Q;
                            modifier2 = modifier3;
                            z3 = z4;
                            function25 = function26;
                            shape3 = shape5;
                            chipColors3 = chipColors5;
                            chipElevation2 = chipElevation3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            z3 = z2;
                            function25 = function24;
                            shape3 = shape2;
                            chipColors3 = chipColors2;
                            chipElevation2 = chipElevationM4144suggestionChipElevationaqJV_2Y;
                            chipBorder2 = chipBorder;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ChipKt.SuggestionChip$lambda$11(function0, function2, modifier2, z3, function25, shape3, chipColors3, chipElevation2, chipBorder2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 805306368;
                    i8 = i7;
                    i9 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function24 = function22;
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i7 = i2 & 512;
                if (i7 != 0) {
                }
                i8 = i7;
                i9 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function24 = function22;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i7 = i2 & 512;
            if (i7 != 0) {
            }
            i8 = i7;
            i9 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function24 = function22;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i7 = i2 & 512;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit SuggestionChip$lambda$11(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        SuggestionChip(function0, function2, modifier, z, function22, shape, chipColors, chipElevation, chipBorder, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit SuggestionChip$lambda$9(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        SuggestionChip((Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function2, modifier, z, (Function2<? super Composer, ? super Integer, Unit>) function22, shape, chipColors, chipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final ChipColors getDefaultSuggestionChipColors(ColorScheme colorScheme) {
        ChipColors defaultSuggestionChipColorsCached = colorScheme.getDefaultSuggestionChipColorsCached();
        if (defaultSuggestionChipColorsCached != null) {
            return defaultSuggestionChipColorsCached;
        }
        ChipColors chipColors = new ChipColors(Color.INSTANCE.m6360getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLeadingIconColor()), Color.INSTANCE.m6361getUnspecified0d7_KjU(), Color.INSTANCE.m6360getTransparent0d7_KjU(), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor()), SuggestionChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLeadingIconColor()), SuggestionChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6361getUnspecified0d7_KjU(), null);
        colorScheme.setDefaultSuggestionChipColorsCached$material3(chipColors);
        return chipColors;
    }

    private static final PaddingValues inputChipPadding(boolean z, boolean z2, boolean z3) {
        return PaddingKt.m2034PaddingValuesa9UjIt4$default((z || !z2) ? Dp.m9114constructorimpl(4.0f) : Dp.m9114constructorimpl(8.0f), 0.0f, z3 ? Dp.m9114constructorimpl(8.0f) : Dp.m9114constructorimpl(4.0f), 0.0f, 10, null);
    }

    static /* synthetic */ PaddingValues inputChipPadding$default(boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return inputChipPadding(z, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: leadingContent-XO-JAsU, reason: not valid java name */
    public static final Function2<Composer, Integer, Unit> m3412leadingContentXOJAsU(Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final long j, Composer composer, int i) {
        Function2 function23;
        ComposerKt.sourceInformationMarkerStart(composer, 1330309098, "C(leadingContent)N(avatar,leadingIcon,leadingIconColor:c#ui.graphics.Color):Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1330309098, i, -1, "androidx.compose.material3.leadingContent (Chip.kt:2212)");
        }
        if (function2 != null) {
            composer.startReplaceGroup(-1473203984);
            composer.endReplaceGroup();
            function23 = function2;
        } else if (function22 != null) {
            composer.startReplaceGroup(1575390813);
            ComposerKt.sourceInformation(composer, "2215@107394L183");
            Function2 function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-237350650, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$leadingContent$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C2216@107412L151:Chip.kt#uh7d8r");
                    if (!composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-237350650, i2, -1, "androidx.compose.material3.leadingContent.<anonymous> (Chip.kt:2216)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(j)), function22, composer2, ProvidedValue.$stable);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54);
            composer.endReplaceGroup();
            function23 = function2RememberComposableLambda;
        } else {
            composer.startReplaceGroup(1575618259);
            composer.endReplaceGroup();
            function23 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> State<T> rememberRetainedState(T t, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -618198444, "C(rememberRetainedState)N(targetValue)2249@108434L40:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-618198444, i, -1, "androidx.compose.material3.rememberRetainedState (Chip.kt:2248)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1383214468, "CC(remember):Chip.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (t != null) {
            mutableState.setValue(t);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: trailingContent-RPmYEkk, reason: not valid java name */
    public static final Function2<Composer, Integer, Unit> m3413trailingContentRPmYEkk(final Function2<? super Composer, ? super Integer, Unit> function2, final long j, Composer composer, int i) {
        ComposableLambda composableLambdaRememberComposableLambda;
        ComposerKt.sourceInformationMarkerStart(composer, -165980551, "C(trailingContent)N(trailingIcon,trailingIconColor:c#ui.graphics.Color):Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-165980551, i, -1, "androidx.compose.material3.trailingContent (Chip.kt:2231)");
        }
        if (function2 != null) {
            composer.startReplaceGroup(-1219055576);
            ComposerKt.sourceInformation(composer, "2232@107914L165");
            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-566924201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$trailingContent$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C2233@107928L141:Chip.kt#uh7d8r");
                    if (!composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-566924201, i2, -1, "androidx.compose.material3.trailingContent.<anonymous> (Chip.kt:2233)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(j)), function2, composer2, ProvidedValue.$stable);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1218863531);
            composer.endReplaceGroup();
            composableLambdaRememberComposableLambda = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return composableLambdaRememberComposableLambda;
    }
}
