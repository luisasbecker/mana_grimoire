package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.studiolaganne.lengendarylens.databinding.FragmentBrowseSetsBinding;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BrowseSetsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0012\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/studiolaganne/lengendarylens/BrowseSetsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/SetClickHandler;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentBrowseSetsBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentBrowseSetsBinding;", "cardSets", "", "Lcom/studiolaganne/lengendarylens/CardSet;", "lastQuery", "", "pickACardMode", "", "currentLanguage", "cardSelectionListener", "Lcom/studiolaganne/lengendarylens/CardSelectionListener;", "setCardSelectionListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "browseCardsActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "setClicked", "setCode", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseSetsFragment extends Fragment implements SetClickHandler {
    private FragmentBrowseSetsBinding _binding;
    private final ActivityResultLauncher<Intent> browseCardsActivityLauncher;
    private CardSelectionListener cardSelectionListener;
    private boolean pickACardMode;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private List<CardSet> cardSets = new ArrayList();
    private String lastQuery = "";
    private String currentLanguage = "en";

    /* JADX INFO: compiled from: BrowseSetsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/BrowseSetsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/BrowseSetsFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final BrowseSetsFragment newInstance() {
            BrowseSetsFragment browseSetsFragment = new BrowseSetsFragment();
            browseSetsFragment.setArguments(new Bundle());
            return browseSetsFragment;
        }
    }

    public BrowseSetsFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.BrowseSetsFragment$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Intrinsics.checkNotNullParameter((ActivityResult) obj, "result");
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.browseCardsActivityLauncher = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentBrowseSetsBinding getBinding() {
        FragmentBrowseSetsBinding fragmentBrowseSetsBinding = this._binding;
        Intrinsics.checkNotNull(fragmentBrowseSetsBinding);
        return fragmentBrowseSetsBinding;
    }

    @JvmStatic
    public static final BrowseSetsFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final boolean onViewCreated$lambda$2(BrowseSetsFragment browseSetsFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        Object systemService = browseSetsFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
        return true;
    }

    static final boolean onViewCreated$lambda$3(EditText editText, BrowseSetsFragment browseSetsFragment, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 || editText.getCompoundDrawables()[2] == null || motionEvent.getRawX() < editText.getRight() - (editText.getCompoundDrawables()[2].getBounds().width() * 2.0f)) {
            return false;
        }
        if (browseSetsFragment.getContext() == null) {
            return true;
        }
        editText.setText("");
        editText.requestFocus();
        Object systemService = browseSetsFragment.requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        return true;
    }

    static final void setClicked$lambda$0(String str, BrowseSetsFragment browseSetsFragment) {
        BrowseCardsFragment browseCardsFragmentNewInstance = BrowseCardsFragment.INSTANCE.newInstance(str, browseSetsFragment.currentLanguage, browseSetsFragment.pickACardMode);
        CardSelectionListener cardSelectionListener = browseSetsFragment.cardSelectionListener;
        if (cardSelectionListener != null) {
            browseCardsFragmentNewInstance.setCardSelectionListener(cardSelectionListener);
        }
        browseSetsFragment.getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.cardsContainer, browseCardsFragmentNewInstance).addToBackStack(null).commit();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.pickACardMode = arguments.getBoolean("pickACardMode", false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentBrowseSetsBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.cardSets = CollectionsKt.sortedWith(CardSetsManager.INSTANCE.getCardSets(), new Comparator() { // from class: com.studiolaganne.lengendarylens.BrowseSetsFragment$onViewCreated$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((CardSet) t2).getReleased_at(), ((CardSet) t).getReleased_at());
            }
        });
        super.onViewCreated(view, savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        String deviceLanguage = preferencesManager.getDeviceLanguage();
        this.currentLanguage = deviceLanguage;
        String str = "zh";
        if (Intrinsics.areEqual(deviceLanguage, "zh")) {
            String script = Locale.getDefault().getScript();
            if (Intrinsics.areEqual(script, "Hans")) {
                str = "zhs";
            } else if (Intrinsics.areEqual(script, "Hant")) {
                str = "zht";
            }
            this.currentLanguage = str;
        }
        if (!Intrinsics.areEqual(this.currentLanguage, "en") && !Intrinsics.areEqual(this.currentLanguage, "fr")) {
            this.currentLanguage = "en";
        }
        if (Intrinsics.areEqual(this.currentLanguage, "fr") && !CardSetsManager.INSTANCE.getFrCardSets().isEmpty()) {
            this.cardSets = CollectionsKt.sortedWith(CardSetsManager.INSTANCE.getFrCardSets(), new Comparator() { // from class: com.studiolaganne.lengendarylens.BrowseSetsFragment$onViewCreated$$inlined$sortedByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((CardSet) t2).getReleased_at(), ((CardSet) t).getReleased_at());
                }
            });
        }
        ImageView flagImage = getBinding().flagImage;
        Intrinsics.checkNotNullExpressionValue(flagImage, "flagImage");
        int identifier = getResources().getIdentifier("flag_" + this.currentLanguage, "drawable", flagImage.getContext().getPackageName());
        if (identifier != 0) {
            flagImage.setImageResource(identifier);
        }
        RecyclerView setListRecyclerView = getBinding().setListRecyclerView;
        Intrinsics.checkNotNullExpressionValue(setListRecyclerView, "setListRecyclerView");
        setListRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        setListRecyclerView.setAdapter(new SetsAdapter(this.cardSets, this, this.currentLanguage));
        final EditText searchEditText = getBinding().searchEditText;
        Intrinsics.checkNotNullExpressionValue(searchEditText, "searchEditText");
        searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.BrowseSetsFragment$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return BrowseSetsFragment.onViewCreated$lambda$2(this.f$0, textView, i, keyEvent);
            }
        });
        searchEditText.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.BrowseSetsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return BrowseSetsFragment.onViewCreated$lambda$3(searchEditText, this, view2, motionEvent);
            }
        });
        searchEditText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.BrowseSetsFragment.onViewCreated.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    searchEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {
                    searchEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_clear, 0);
                }
                this.lastQuery = String.valueOf(s);
                if (this.getContext() != null) {
                    PreferencesManager preferencesManager2 = preferencesManager;
                    preferencesManager2.setCurrentSetFilter(this.lastQuery);
                    PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager2, null, 1, null);
                }
                int length = this.lastQuery.length();
                BrowseSetsFragment browseSetsFragment = this;
                if (length == 0) {
                    RecyclerView recyclerView = browseSetsFragment.getBinding().setListRecyclerView;
                    List list = this.cardSets;
                    BrowseSetsFragment browseSetsFragment2 = this;
                    recyclerView.setAdapter(new SetsAdapter(list, browseSetsFragment2, browseSetsFragment2.currentLanguage));
                    return;
                }
                List list2 = browseSetsFragment.cardSets;
                BrowseSetsFragment browseSetsFragment3 = this;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list2) {
                    String lowerCase = ((CardSet) obj).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = browseSetsFragment3.lastQuery.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                        arrayList.add(obj);
                    }
                }
                RecyclerView recyclerView2 = this.getBinding().setListRecyclerView;
                BrowseSetsFragment browseSetsFragment4 = this;
                recyclerView2.setAdapter(new SetsAdapter(arrayList, browseSetsFragment4, browseSetsFragment4.currentLanguage));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        String currentSetFilter = preferencesManager.getCurrentSetFilter();
        String str2 = currentSetFilter;
        if (str2.length() > 0) {
            getBinding().searchEditText.setText(str2);
            this.lastQuery = currentSetFilter;
        }
    }

    public final void setCardSelectionListener(CardSelectionListener listener) {
        this.cardSelectionListener = listener;
    }

    @Override // com.studiolaganne.lengendarylens.SetClickHandler
    public void setClicked(final String setCode) {
        Intrinsics.checkNotNullParameter(setCode, "setCode");
        if (getContext() == null || this._binding == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("set_click_from_browse_sets");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("set_click_from_browse_sets", null);
        getBinding().setListRecyclerView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseSetsFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                BrowseSetsFragment.setClicked$lambda$0(setCode, this);
            }
        }, 150L);
    }
}
