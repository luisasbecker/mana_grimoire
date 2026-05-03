package com.studiolaganne.lengendarylens;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.gson.Gson;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.studiolaganne.lengendarylens.ScanFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PickACardActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/studiolaganne/lengendarylens/PickACardActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "finishWithResult", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", OptionalModuleUtils.FACE, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PickACardActivity extends BaseActivity {
    public static final int $stable = BaseActivity.$stable;

    public final void finishWithResult(MTFullCard card, int face) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intent intent = new Intent();
        intent.putExtra("cardPicked", new Gson().toJson(card));
        intent.putExtra(OptionalModuleUtils.FACE, face);
        setResult(-1, intent);
        finish();
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_acard);
        if (savedInstanceState == null) {
            ScanFragment scanFragmentNewInstance$default = ScanFragment.Companion.newInstance$default(ScanFragment.INSTANCE, true, false, 2, null);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.add(R.id.scan_fragment_container, scanFragmentNewInstance$default);
            fragmentTransactionBeginTransaction.commit();
        }
    }
}
