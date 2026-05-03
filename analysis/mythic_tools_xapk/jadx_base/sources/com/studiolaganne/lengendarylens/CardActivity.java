package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.activity.OnBackPressedCallback;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardActivity extends BaseActivity {
    public static final int $stable = BaseActivity.$stable;

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        String stringExtra = getIntent().getStringExtra("scryfallId");
        String stringExtra2 = getIntent().getStringExtra("oracleId");
        String stringExtra3 = getIntent().getStringExtra("lang");
        String stringExtra4 = getIntent().getStringExtra("singleMTCard");
        boolean booleanExtra = getIntent().getBooleanExtra("hasMTCards", false);
        int intExtra = getIntent().getIntExtra("currentMTIndex", -1);
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.studiolaganne.lengendarylens.CardActivity.onCreate.1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                CardActivity.this.finish();
            }
        });
        int intExtra2 = getIntent().getIntExtra("mtCardListId", -1);
        int intExtra3 = getIntent().getIntExtra("mtDeckListId", -1);
        String stringExtra5 = getIntent().getStringExtra("mtDeck");
        int intExtra4 = getIntent().getIntExtra("mtDeckMainListId", -1);
        int intExtra5 = getIntent().getIntExtra("mtDeckMainListCount", 0);
        int intExtra6 = getIntent().getIntExtra("mtDeckSideboardListId", -1);
        int intExtra7 = getIntent().getIntExtra("mtDeckSideboardListCount", 0);
        int intExtra8 = getIntent().getIntExtra("mtDeckMaybeboardListId", -1);
        int intExtra9 = getIntent().getIntExtra("mtDeckMaybeboardListCount", 0);
        String stringExtra6 = getIntent().getStringExtra("currentGroupBy");
        String stringExtra7 = getIntent().getStringExtra("currentOrderBy");
        String stringExtra8 = getIntent().getStringExtra("currentOrderDirection");
        String stringExtra9 = getIntent().getStringExtra("currentNameFilter");
        String stringExtra10 = getIntent().getStringExtra("currentScryfallFilter");
        int intExtra10 = getIntent().getIntExtra("currentPage", 1);
        int intExtra11 = getIntent().getIntExtra("cardsPerPage", 100);
        int intExtra12 = getIntent().getIntExtra("totalCards", 0);
        boolean booleanExtra2 = getIntent().getBooleanExtra("readOnly", false);
        int intExtra13 = getIntent().getIntExtra(OptionalModuleUtils.FACE, 0);
        String stringExtra11 = getIntent().getStringExtra("enTitle");
        String stringExtra12 = getIntent().getStringExtra("localizedTitle");
        String stringExtra13 = getIntent().getStringExtra("localizedTypeLine");
        String stringExtra14 = getIntent().getStringExtra("localizedOracle");
        String stringExtra15 = getIntent().getStringExtra("enScryfallId");
        boolean booleanExtra3 = getIntent().getBooleanExtra("comboMode", false);
        String stringExtra16 = getIntent().getStringExtra("comboData");
        Bundle bundle = new Bundle();
        bundle.putBoolean("noScanMode", true);
        bundle.putString("scryfallId", stringExtra);
        bundle.putString("oracleId", stringExtra2);
        bundle.putString("lang", stringExtra3);
        bundle.putString("singleMTCard", stringExtra4);
        bundle.putInt("currentMTIndex", intExtra);
        bundle.putBoolean("hasMTCards", booleanExtra);
        bundle.putInt("mtCardListId", intExtra2);
        bundle.putInt("mtDeckListId", intExtra3);
        bundle.putString("mtDeck", stringExtra5);
        bundle.putInt("mtDeckMainListId", intExtra4);
        bundle.putInt("mtDeckMainListCount", intExtra5);
        bundle.putInt("mtDeckSideboardListId", intExtra6);
        bundle.putInt("mtDeckSideboardListCount", intExtra7);
        bundle.putInt("mtDeckMaybeboardListId", intExtra8);
        bundle.putInt("mtDeckMaybeboardListCount", intExtra9);
        bundle.putString("currentGroupBy", stringExtra6);
        bundle.putString("currentOrderBy", stringExtra7);
        bundle.putString("currentOrderDirection", stringExtra8);
        bundle.putString("currentNameFilter", stringExtra9);
        bundle.putString("currentScryfallFilter", stringExtra10);
        bundle.putInt("currentPage", intExtra10);
        bundle.putInt("cardsPerPage", intExtra11);
        bundle.putInt("totalCards", intExtra12);
        bundle.putBoolean("readOnly", booleanExtra2);
        bundle.putInt(OptionalModuleUtils.FACE, intExtra13);
        bundle.putString("enTitle", stringExtra11);
        bundle.putString("localizedTitle", stringExtra12);
        bundle.putString("localizedTypeLine", stringExtra13);
        bundle.putString("localizedOracle", stringExtra14);
        bundle.putString("enScryfallId", stringExtra15);
        bundle.putBoolean("comboMode", booleanExtra3);
        if (stringExtra16 != null) {
            bundle.putString("comboData", stringExtra16);
        }
        ScanFragment scanFragment = new ScanFragment();
        scanFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.rootFragment, scanFragment).commit();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }
}
