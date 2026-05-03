package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.actions.SearchIntents;
import com.studiolaganne.lengendarylens.databinding.ActivitySearchBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "<init>", "()V", "binding", "Lcom/studiolaganne/lengendarylens/databinding/ActivitySearchBinding;", "prefs", "Lcom/studiolaganne/lengendarylens/PreferencesManager;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchActivity extends BaseActivity {
    public static final int $stable = 8;
    private ActivitySearchBinding binding;
    private PreferencesManager prefs;

    static final Unit onCreate$lambda$0(SearchActivity searchActivity) {
        searchActivity.finish();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$1(SearchActivity searchActivity) {
        searchActivity.finish();
        return Unit.INSTANCE;
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.prefs = new PreferencesManager(this);
        ActivitySearchBinding activitySearchBindingInflate = ActivitySearchBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activitySearchBindingInflate, "inflate(...)");
        this.binding = activitySearchBindingInflate;
        PreferencesManager preferencesManager = null;
        if (activitySearchBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySearchBindingInflate = null;
        }
        setContentView(activitySearchBindingInflate.getRoot());
        ActivitySearchBinding activitySearchBinding = this.binding;
        if (activitySearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySearchBinding = null;
        }
        ImageView backImageView = activitySearchBinding.backImageView;
        Intrinsics.checkNotNullExpressionValue(backImageView, "backImageView");
        ViewExtensionsKt.setOnClickWithFade(backImageView, new Function0() { // from class: com.studiolaganne.lengendarylens.SearchActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SearchActivity.onCreate$lambda$0(this.f$0);
            }
        });
        ActivitySearchBinding activitySearchBinding2 = this.binding;
        if (activitySearchBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySearchBinding2 = null;
        }
        TextView backLabel = activitySearchBinding2.backLabel;
        Intrinsics.checkNotNullExpressionValue(backLabel, "backLabel");
        ViewExtensionsKt.setOnClickWithFade(backLabel, new Function0() { // from class: com.studiolaganne.lengendarylens.SearchActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SearchActivity.onCreate$lambda$1(this.f$0);
            }
        });
        PreferencesManager preferencesManager2 = this.prefs;
        if (preferencesManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
        } else {
            preferencesManager = preferencesManager2;
        }
        boolean booleanExtra = getIntent().getBooleanExtra("condense", preferencesManager.getBoolean(PreferencesManager.CONDENSE_SEARCH, true));
        String stringExtra = getIntent().getStringExtra(SearchIntents.EXTRA_QUERY);
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getIntent().getStringExtra("lang");
        String str = stringExtra2 != null ? stringExtra2 : "";
        boolean booleanExtra2 = getIntent().getBooleanExtra("forceLocalDb", false);
        Bundle bundle = new Bundle();
        bundle.putBoolean("pickACardMode", true);
        bundle.putBoolean("condense", booleanExtra);
        bundle.putBoolean("forceLocalDb", booleanExtra2);
        bundle.putString("lang", str);
        bundle.putString(SearchIntents.EXTRA_QUERY, stringExtra);
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, searchFragment).commit();
    }
}
