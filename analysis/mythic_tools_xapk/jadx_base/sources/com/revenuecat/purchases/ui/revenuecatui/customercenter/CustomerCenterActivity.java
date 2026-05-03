package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.SdkConfigurationStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomerCenterActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0014¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/CustomerCenterActivity;", "Landroidx/activity/ComponentActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterActivity extends ComponentActivity {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_WAS_LAUNCHED_THROUGH_SDK = "was_launched_through_sdk";

    /* JADX INFO: compiled from: CustomerCenterActivity.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/CustomerCenterActivity$Companion;", "", "()V", "EXTRA_WAS_LAUNCHED_THROUGH_SDK", "", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "createIntent$revenuecatui_defaultsBc8Release", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent createIntent$revenuecatui_defaultsBc8Release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) CustomerCenterActivity.class);
            intent.putExtra(CustomerCenterActivity.EXTRA_WAS_LAUNCHED_THROUGH_SDK, true);
            return intent;
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SdkConfigurationStateKt.restoreSdkConfigurationIfNeeded(this, savedInstanceState);
        if (getIntent().getBooleanExtra(EXTRA_WAS_LAUNCHED_THROUGH_SDK, false) || Purchases.INSTANCE.isConfigured()) {
            ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(2072096008, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterActivity.onCreate.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C46@1934L21,51@2130L255,49@2058L327:CustomerCenterActivity.kt#5a5ul8");
                    if ((i & 3) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2072096008, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterActivity.onCreate.<anonymous> (CustomerCenterActivity.kt:46)");
                    }
                    ColorScheme colorSchemeM3481darkColorSchemeCXl9yA$default = DarkThemeKt.isSystemInDarkTheme(composer, 0) ? ColorSchemeKt.m3481darkColorSchemeCXl9yA$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null) : ColorSchemeKt.m3487lightColorSchemeCXl9yA$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null);
                    final CustomerCenterActivity customerCenterActivity = CustomerCenterActivity.this;
                    MaterialThemeKt.MaterialTheme(colorSchemeM3481darkColorSchemeCXl9yA$default, null, null, ComposableLambdaKt.rememberComposableLambda(1428363188, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterActivity.onCreate.1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i2) {
                            ComposerKt.sourceInformation(composer2, "C54@2251L101,52@2148L223:CustomerCenterActivity.kt#5a5ul8");
                            if ((i2 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1428363188, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterActivity.onCreate.<anonymous>.<anonymous> (CustomerCenterActivity.kt:52)");
                            }
                            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            composer2.startReplaceGroup(1948489528);
                            ComposerKt.sourceInformation(composer2, "CC(remember):CustomerCenterActivity.kt#9igjgp");
                            boolean zChanged = composer2.changed(customerCenterActivity);
                            final CustomerCenterActivity customerCenterActivity2 = customerCenterActivity;
                            Object objRememberedValue = composer2.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterActivity$onCreate$1$1$1$1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        customerCenterActivity2.setResult(-1);
                                        customerCenterActivity2.finish();
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            composer2.endReplaceGroup();
                            CustomerCenterKt.CustomerCenter(modifierFillMaxSize$default, null, (Function0) objRememberedValue, composer2, 6, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer, 54), composer, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 1, null);
        } else {
            Logger.INSTANCE.e("CustomerCenterActivity was launched incorrectly. Please use ShowCustomerCenter activity result contract, CustomerCenter composable, or CustomerCenterView to display the Customer Center.");
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        SdkConfigurationStateKt.saveSdkConfiguration(outState);
        super.onSaveInstanceState(outState);
    }
}
