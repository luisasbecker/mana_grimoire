package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScanToDeckActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/ScanToDeckActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScanToDeckActivity extends BaseActivity {
    public static final int $stable = BaseActivity.$stable;

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_to_deck);
        getIntent().getIntExtra("scanToDeckId", -1);
        String stringExtra = getIntent().getStringExtra("scanToDeckName");
        if (stringExtra == null) {
            stringExtra = "Deck";
        }
        if (savedInstanceState == null) {
            ScanFragment scanFragmentNewScanToDeckInstance = ScanFragment.INSTANCE.newScanToDeckInstance(stringExtra);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.add(R.id.scan_fragment_container, scanFragmentNewScanToDeckInstance);
            fragmentTransactionBeginTransaction.commit();
        }
    }
}
