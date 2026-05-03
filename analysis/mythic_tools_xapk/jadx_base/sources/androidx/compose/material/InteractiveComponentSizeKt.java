package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: InteractiveComponentSize.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\"\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b\"\u0010\u0010\u0000\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u000e"}, d2 = {"minimumInteractiveComponentSize", "Landroidx/compose/ui/Modifier;", "LocalMinimumInteractiveComponentEnforcement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalMinimumInteractiveComponentEnforcement$annotations", "()V", "getLocalMinimumInteractiveComponentEnforcement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalMinimumTouchTargetEnforcement", "getLocalMinimumTouchTargetEnforcement$annotations", "getLocalMinimumTouchTargetEnforcement", "Landroidx/compose/ui/unit/DpSize;", "J", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class InteractiveComponentSizeKt {
    private static final ProvidableCompositionLocal<Boolean> LocalMinimumInteractiveComponentEnforcement;
    private static final ProvidableCompositionLocal<Boolean> LocalMinimumTouchTargetEnforcement;
    private static final long minimumInteractiveComponentSize;

    static {
        ProvidableCompositionLocal<Boolean> providableCompositionLocalStaticCompositionLocalOf = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material.InteractiveComponentSizeKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(InteractiveComponentSizeKt.LocalMinimumInteractiveComponentEnforcement$lambda$0());
            }
        });
        LocalMinimumInteractiveComponentEnforcement = providableCompositionLocalStaticCompositionLocalOf;
        LocalMinimumTouchTargetEnforcement = providableCompositionLocalStaticCompositionLocalOf;
        minimumInteractiveComponentSize = DpKt.m9136DpSizeYgX7TsA(Dp.m9114constructorimpl(48.0f), Dp.m9114constructorimpl(48.0f));
    }

    static final boolean LocalMinimumInteractiveComponentEnforcement$lambda$0() {
        return true;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalMinimumInteractiveComponentEnforcement() {
        return LocalMinimumInteractiveComponentEnforcement;
    }

    public static /* synthetic */ void getLocalMinimumInteractiveComponentEnforcement$annotations() {
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalMinimumTouchTargetEnforcement() {
        return LocalMinimumTouchTargetEnforcement;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use LocalMinimumInteractiveComponentEnforcement instead.", replaceWith = @ReplaceWith(expression = "LocalMinimumInteractiveComponentEnforcement", imports = {}))
    public static /* synthetic */ void getLocalMinimumTouchTargetEnforcement$annotations() {
    }

    public static final Modifier minimumInteractiveComponentSize(Modifier modifier) {
        return modifier.then(MinimumInteractiveModifier.INSTANCE);
    }
}
