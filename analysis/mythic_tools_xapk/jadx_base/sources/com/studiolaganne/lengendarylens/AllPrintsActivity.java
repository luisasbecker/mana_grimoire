package com.studiolaganne.lengendarylens;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.gson.Gson;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.studiolaganne.lengendarylens.databinding.ActivityAllPrintsBinding;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AllPrintsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016H\u0016J\b\u0010#\u001a\u00020!H\u0002J\u0014\u0010$\u001a\u0004\u0018\u00010\r2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0006\u0010'\u001a\u00020!J\u0012\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020!H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/studiolaganne/lengendarylens/AllPrintsActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "Lcom/studiolaganne/lengendarylens/OnPrintClickListener;", "<init>", "()V", "cardSets", "", "Lcom/studiolaganne/lengendarylens/CardSet;", "binding", "Lcom/studiolaganne/lengendarylens/databinding/ActivityAllPrintsBinding;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "currentMTCardId", "", "currentFace", "", "onlineOnlySets", "isMTCards", "", "cards", "Lcom/studiolaganne/lengendarylens/Card;", "mtCards", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "originalCards", "originalMTCards", "filteredCards", "filteredMTCards", "adapter", "Lcom/studiolaganne/lengendarylens/PrintsAdapter;", "descending", "selectedSortItem", "currentFilter", "onMTPrintClick", "", "print", "filterCards", "getSetNameForCard", "card", "", "sortCardsAndReload", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "finishWithTransition", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AllPrintsActivity extends BaseActivity implements OnPrintClickListener {
    public static final int $stable = 8;
    private PrintsAdapter adapter;
    private ActivityAllPrintsBinding binding;
    private int currentFace;
    private String currentMTCardId;
    private RecyclerView recyclerView;
    private List<CardSet> cardSets = CollectionsKt.emptyList();
    private final List<String> onlineOnlySets = CollectionsKt.listOf((Object[]) new String[]{"prm", "pmoa", "ydmu", "hbg", "ysnc", "yneo", "ymid", "ha1", "ha2", "ha3", "ha4", "ha5", "ha6", "j21", "ea1", "ajmp", "akr", "ana", "klr", "aana", "pana", "anb", "xana", "pz2", "ea2", "past", "sis", "sir", "ha7", "ea3", "a24", "y22", "a22", "hbg", "a23", "ywoe", "yone"});
    private boolean isMTCards = true;
    private List<Card> cards = CollectionsKt.emptyList();
    private List<MTFullCard> mtCards = CollectionsKt.emptyList();
    private List<Card> originalCards = CollectionsKt.emptyList();
    private List<MTFullCard> originalMTCards = CollectionsKt.emptyList();
    private List<Card> filteredCards = CollectionsKt.emptyList();
    private List<MTFullCard> filteredMTCards = CollectionsKt.emptyList();
    private boolean descending = true;
    private int selectedSortItem = 1;
    private String currentFilter = "";

    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void filterCards() {
        String lowerCase;
        if (this.currentFilter.length() == 0) {
            this.filteredCards = this.originalCards;
            this.filteredMTCards = this.originalMTCards;
            return;
        }
        String lowerCase2 = this.currentFilter.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        List<MTFullCard> list = this.originalMTCards;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            MTFullCard mTFullCard = (MTFullCard) obj;
            String setNameForCard = getSetNameForCard(mTFullCard);
            String str = "";
            if (setNameForCard != null) {
                lowerCase = setNameForCard.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (lowerCase == null) {
                    lowerCase = "";
                }
            }
            String set_code = mTFullCard.getSet_code();
            if (set_code != null) {
                String lowerCase3 = set_code.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                if (lowerCase3 != null) {
                    str = lowerCase3;
                }
            }
            String str2 = lowerCase2;
            if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) str2, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) str2, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        this.filteredMTCards = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishWithTransition() {
        finish();
        if (Build.VERSION.SDK_INT >= 34) {
            overrideActivityTransition(1, R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        } else {
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        }
    }

    private final String getSetNameForCard(Object card) {
        Object next;
        CardSet cardSet;
        Object next2;
        PreferencesManager preferencesManager = new PreferencesManager(this);
        boolean z = Intrinsics.areEqual(preferencesManager.getString(PreferencesManager.APP_LANGUAGE, AndroidContextPlugin.DEVICE_KEY), "fr") || Intrinsics.areEqual(preferencesManager.getDeviceLanguage(), "fr");
        String set = card instanceof Card ? ((Card) card).getSet() : card instanceof MTFullCard ? ((MTFullCard) card).getSet_code() : null;
        if (set == null) {
            return null;
        }
        if (!z || CardSetsManager.INSTANCE.getFrCardSets().isEmpty()) {
            Iterator<T> it = CardSetsManager.INSTANCE.getCardSets().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (StringsKt.equals(((CardSet) next).getCode(), set, true)) {
                    break;
                }
            }
            cardSet = (CardSet) next;
        } else {
            Iterator<T> it2 = CardSetsManager.INSTANCE.getFrCardSets().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
                if (StringsKt.equals(((CardSet) next2).getCode(), set, true)) {
                    break;
                }
            }
            cardSet = (CardSet) next2;
        }
        if (cardSet != null) {
            return cardSet.getName();
        }
        return null;
    }

    static final Unit onCreate$lambda$0(AllPrintsActivity allPrintsActivity) {
        allPrintsActivity.finishWithTransition();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$1(AllPrintsActivity allPrintsActivity, ImageView imageView) {
        if (allPrintsActivity.descending) {
            allPrintsActivity.descending = false;
            imageView.setImageResource(R.drawable.up_circle);
            allPrintsActivity.sortCardsAndReload();
        } else {
            allPrintsActivity.descending = true;
            imageView.setImageResource(R.drawable.down_circle);
            allPrintsActivity.sortCardsAndReload();
        }
        return Unit.INSTANCE;
    }

    static final void onMTPrintClick$lambda$0(View view, LottieAnimationView lottieAnimationView) {
        view.setVisibility(0);
        lottieAnimationView.setVisibility(0);
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.currentMTCardId = getIntent().getStringExtra("currentMTCardId");
        this.currentFace = getIntent().getIntExtra("currentFace", 0);
        this.adapter = new PrintsAdapter(this, this.cardSets, this.currentMTCardId, this.currentFace, this.cards, this.mtCards);
        ActivityAllPrintsBinding activityAllPrintsBindingInflate = ActivityAllPrintsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityAllPrintsBindingInflate, "inflate(...)");
        this.binding = activityAllPrintsBindingInflate;
        if (activityAllPrintsBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAllPrintsBindingInflate = null;
        }
        setContentView(activityAllPrintsBindingInflate.getRoot());
        if (CardSetsManager.INSTANCE.getCardSets().isEmpty()) {
            CardSetsManager.INSTANCE.loadCardSets();
        }
        this.cardSets = CardSetsManager.INSTANCE.getCardSets();
        PrintsAdapter printsAdapter = this.adapter;
        if (printsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            printsAdapter = null;
        }
        printsAdapter.updateSets(this.cardSets);
        View viewFindViewById = findViewById(R.id.prints_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        this.recyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        AllPrintsActivity allPrintsActivity = this;
        recyclerView.setLayoutManager(new GridLayoutManager(allPrintsActivity, 2));
        PrintsAdapter printsAdapter2 = this.adapter;
        if (printsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            printsAdapter2 = null;
        }
        printsAdapter2.updateSets(this.cardSets);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        PrintsAdapter printsAdapter3 = this.adapter;
        if (printsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            printsAdapter3 = null;
        }
        recyclerView2.setAdapter(printsAdapter3);
        Button button = (Button) findViewById(R.id.backButton);
        Intrinsics.checkNotNull(button);
        ViewExtensionsKt.setOnClickWithFade(button, new Function0() { // from class: com.studiolaganne.lengendarylens.AllPrintsActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AllPrintsActivity.onCreate$lambda$0(this.f$0);
            }
        });
        Spinner spinner = (Spinner) findViewById(R.id.sort_spinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(allPrintsActivity, R.layout.custom_spinner_item, new String[]{getString(R.string.price), getString(R.string.date)});
        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setSelection(1);
        this.selectedSortItem = 1;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.AllPrintsActivity.onCreate.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                if (AllPrintsActivity.this.isDestroyed()) {
                    return;
                }
                AllPrintsActivity.this.selectedSortItem = position;
                AllPrintsActivity.this.sortCardsAndReload();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }
        });
        final ImageView imageView = (ImageView) findViewById(R.id.sort_order_image_view);
        Intrinsics.checkNotNull(imageView);
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.AllPrintsActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AllPrintsActivity.onCreate$lambda$1(this.f$0, imageView);
            }
        });
        ((EditText) findViewById(R.id.filter_edit_text)).addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.AllPrintsActivity.onCreate.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String string;
                AllPrintsActivity allPrintsActivity2 = AllPrintsActivity.this;
                if (s == null || (string = s.toString()) == null) {
                    string = "";
                }
                allPrintsActivity2.currentFilter = string;
                AllPrintsActivity.this.sortCardsAndReload();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        View viewFindViewById2 = findViewById(R.id.loadingBackgroundView);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.loadingAnimationView);
        viewFindViewById2.setVisibility(0);
        lottieAnimationView.setVisibility(0);
        String str = this.currentMTCardId;
        if (str == null || str.length() == 0) {
            finishWithTransition();
            return;
        }
        this.isMTCards = true;
        MTUser currentUser = new PreferencesManager(allPrintsActivity).getCurrentUser();
        String str2 = this.currentMTCardId;
        if (str2 != null) {
            MTApiKt.getMtApi().getCardPrints(str2, currentUser != null ? Integer.valueOf(currentUser.getId()) : null).enqueue(new AllPrintsActivity$onCreate$5$1(viewFindViewById2, lottieAnimationView, this));
        }
    }

    @Override // com.studiolaganne.lengendarylens.OnPrintClickListener
    public void onMTPrintClick(MTFullCard print) {
        Intrinsics.checkNotNullParameter(print, "print");
        Intent intent = new Intent();
        intent.putExtra("newCardId", print.getCardid());
        intent.putExtra("newCardJson", new Gson().toJson(print));
        setResult(-1, intent);
        final View viewFindViewById = findViewById(R.id.loadingBackgroundView);
        final LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.loadingAnimationView);
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.AllPrintsActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AllPrintsActivity.onMTPrintClick$lambda$0(viewFindViewById, lottieAnimationView);
            }
        }, 50L);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.AllPrintsActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.finishWithTransition();
            }
        }, 250L);
    }

    public final void sortCardsAndReload() {
        filterCards();
        PreferencesManager preferencesManager = new PreferencesManager(this);
        preferencesManager.getPreferredCurrency();
        final String preferredMarket = preferencesManager.getPreferredMarket();
        List<MTFullCard> list = this.filteredMTCards;
        this.mtCards = list;
        int i = this.selectedSortItem;
        boolean z = this.descending;
        if (i == 0) {
            if (z) {
                this.mtCards = CollectionsKt.sortedWith(list, new Comparator() { // from class: com.studiolaganne.lengendarylens.AllPrintsActivity$sortCardsAndReload$$inlined$compareByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Double.valueOf(GameUtils.INSTANCE.getInstance().getCardPrice((MTFullCard) t2, preferredMarket)), Double.valueOf(GameUtils.INSTANCE.getInstance().getCardPrice((MTFullCard) t, preferredMarket)));
                    }
                });
            } else {
                this.mtCards = CollectionsKt.sortedWith(list, new Comparator() { // from class: com.studiolaganne.lengendarylens.AllPrintsActivity$sortCardsAndReload$$inlined$compareBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Double.valueOf(GameUtils.INSTANCE.getInstance().getCardPrice((MTFullCard) t, preferredMarket)), Double.valueOf(GameUtils.INSTANCE.getInstance().getCardPrice((MTFullCard) t2, preferredMarket)));
                    }
                });
            }
        } else if (z) {
            this.mtCards = CollectionsKt.sortedWith(list, new Comparator() { // from class: com.studiolaganne.lengendarylens.AllPrintsActivity$sortCardsAndReload$$inlined$compareByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((MTFullCard) t2).getReleased_at(), ((MTFullCard) t).getReleased_at());
                }
            });
        } else {
            this.mtCards = CollectionsKt.sortedWith(list, new Comparator() { // from class: com.studiolaganne.lengendarylens.AllPrintsActivity$sortCardsAndReload$$inlined$compareBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((MTFullCard) t).getReleased_at(), ((MTFullCard) t2).getReleased_at());
                }
            });
        }
        PrintsAdapter printsAdapter = this.adapter;
        if (printsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            printsAdapter = null;
        }
        printsAdapter.updateMTData(this.mtCards);
    }
}
