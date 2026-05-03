package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.credentials.provider.CredentialEntry;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.Operator;
import com.studiolaganne.lengendarylens.SearchKeyword;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FilterDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010*\u001a\u00020+H\u0016J&\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020-2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u00106\u001a\u00020+2\u0006\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020+H\u0002J\u0012\u0010:\u001a\u00020+2\b\u00105\u001a\u0004\u0018\u00010-H\u0002J\u0010\u0010;\u001a\u00020+2\u0006\u00107\u001a\u000208H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001a\u0010$\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u000e\u0010'\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/studiolaganne/lengendarylens/FilterDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/FilterDialogListener;", "include", "", "getInclude", "()Z", "setInclude", "(Z)V", "keyword", "Lcom/studiolaganne/lengendarylens/SearchKeyword;", "getKeyword", "()Lcom/studiolaganne/lengendarylens/SearchKeyword;", "setKeyword", "(Lcom/studiolaganne/lengendarylens/SearchKeyword;)V", "operator", "Lcom/studiolaganne/lengendarylens/Operator;", "getOperator", "()Lcom/studiolaganne/lengendarylens/Operator;", "setOperator", "(Lcom/studiolaganne/lengendarylens/Operator;)V", "value", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "editMode", "getEditMode", "setEditMode", "originalToken", "getOriginalToken", "setOriginalToken", "alwaysKeywordsInEnglish", "getAlwaysKeywordsInEnglish", "setAlwaysKeywordsInEnglish", "lang", "positiveButton", "Lcom/google/android/material/button/MaterialButton;", "onStart", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "updateManaCostDisplay", "context", "Landroid/content/Context;", "updateSubmitButton", "setupTags", "updateColorDisplay", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilterDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private boolean alwaysKeywordsInEnglish;
    private boolean editMode;
    private FilterDialogListener listener;
    private MaterialButton positiveButton;
    private boolean include = true;
    private SearchKeyword keyword = SearchKeyword.NAME;
    private Operator operator = Operator.CONTAINS;
    private String value = "";
    private String originalToken = "";
    private String lang = "en";

    /* JADX INFO: compiled from: FilterDialogFragment.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/FilterDialogFragment$Builder;", "", "<init>", "()V", "keyword", "Lcom/studiolaganne/lengendarylens/SearchKeyword;", "searchElement", "Lcom/studiolaganne/lengendarylens/SearchCondition;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/FilterDialogListener;", "lang", "", "alwaysKeywordsInEnglish", "", "setKeyword", "setAlwaysKeywordsInEnglish", "always", "setSearchElement", InAppPurchaseConstants.METHOD_SET_LISTENER, "setLang", "l", "build", "Lcom/studiolaganne/lengendarylens/FilterDialogFragment;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private boolean alwaysKeywordsInEnglish;
        private SearchKeyword keyword;
        private String lang = "en";
        private FilterDialogListener listener;
        private SearchCondition searchElement;

        public final FilterDialogFragment build() {
            FilterDialogFragment filterDialogFragment = new FilterDialogFragment();
            filterDialogFragment.listener = this.listener;
            filterDialogFragment.lang = this.lang;
            filterDialogFragment.setAlwaysKeywordsInEnglish(this.alwaysKeywordsInEnglish);
            SearchCondition searchCondition = this.searchElement;
            if (searchCondition != null) {
                filterDialogFragment.setInclude(searchCondition.getInclude());
                filterDialogFragment.setKeyword(searchCondition.getKeyword());
                filterDialogFragment.setOperator(searchCondition.getOperator());
                filterDialogFragment.setValue(searchCondition.getValue());
                return filterDialogFragment;
            }
            SearchKeyword searchKeyword = this.keyword;
            if (searchKeyword == null) {
                searchKeyword = SearchKeyword.NAME;
            }
            filterDialogFragment.setKeyword(searchKeyword);
            return filterDialogFragment;
        }

        public final Builder setAlwaysKeywordsInEnglish(boolean always) {
            this.alwaysKeywordsInEnglish = always;
            return this;
        }

        public final Builder setKeyword(SearchKeyword keyword) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            this.keyword = keyword;
            return this;
        }

        public final Builder setLang(String l) {
            Intrinsics.checkNotNullParameter(l, "l");
            this.lang = l;
            return this;
        }

        public final Builder setListener(FilterDialogListener listener) {
            this.listener = listener;
            return this;
        }

        public final Builder setSearchElement(SearchCondition searchElement) {
            Intrinsics.checkNotNullParameter(searchElement, "searchElement");
            this.searchElement = searchElement;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    /* JADX INFO: compiled from: FilterDialogFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SearchKeyword.values().length];
            try {
                iArr[SearchKeyword.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SearchKeyword.TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SearchKeyword.MANA_COST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SearchKeyword.LANGUAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SearchKeyword.LEGAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SearchKeyword.BANNED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SearchKeyword.IS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SearchKeyword.ALTERED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SearchKeyword.MISPRINT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[SearchKeyword.SIGNED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[SearchKeyword.PROXY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[SearchKeyword.IN_DECK.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[SearchKeyword.OTAG.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[SearchKeyword.GAME.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[SearchKeyword.RESTRICTED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[SearchKeyword.POWER.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[SearchKeyword.TOUGHNESS.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[SearchKeyword.LOYALTY.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[SearchKeyword.DEFENSE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[SearchKeyword.NUMBER.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[SearchKeyword.MANA_VALUE.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[SearchKeyword.PRICE.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[SearchKeyword.COLOR.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[SearchKeyword.IDENTITY.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[SearchKeyword.RARITY.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[SearchKeyword.SET.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[SearchKeyword.ORACLE_TEXT.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[SearchKeyword.LAYOUT.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[SearchKeyword.KEYWORD.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final void onCreateView$lambda$0(FilterDialogFragment filterDialogFragment, View view, ImageView imageView) {
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        filterDialogFragment.updateManaCostDisplay(context);
        imageView.setVisibility(0);
    }

    static final void onCreateView$lambda$10(EditText editText, FilterDialogFragment filterDialogFragment) {
        Window window;
        if (editText != null) {
            editText.requestFocus();
        }
        FragmentActivity activity = filterDialogFragment.getActivity();
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        Dialog dialog = filterDialogFragment.getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setSoftInputMode(4);
    }

    static final Unit onCreateView$lambda$22(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value += "x";
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        filterDialogFragment.updateManaCostDisplay(context);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$23(FilterDialogFragment filterDialogFragment, View view) {
        if (Regex.find$default(new Regex("\\d+"), filterDialogFragment.value, 0, 2, null) == null) {
            filterDialogFragment.value += AppEventsConstants.EVENT_PARAM_VALUE_NO;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            filterDialogFragment.updateManaCostDisplay(context);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$24(FilterDialogFragment filterDialogFragment, View view) {
        kotlin.text.MatchResult matchResultFind$default = Regex.find$default(new Regex("\\d+"), filterDialogFragment.value, 0, 2, null);
        if (matchResultFind$default != null) {
            filterDialogFragment.value = StringsKt.replace$default(filterDialogFragment.value, matchResultFind$default.getValue(), String.valueOf(Integer.parseInt(matchResultFind$default.getValue()) + 1), false, 4, (Object) null);
        } else {
            filterDialogFragment.value += "1";
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        filterDialogFragment.updateManaCostDisplay(context);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$25(FilterDialogFragment filterDialogFragment, View view) {
        if (filterDialogFragment.keyword == SearchKeyword.MANA_COST) {
            filterDialogFragment.value += "c";
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            filterDialogFragment.updateManaCostDisplay(context);
        } else {
            filterDialogFragment.value = "colorless";
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context2);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$26(FilterDialogFragment filterDialogFragment, View view) {
        if (filterDialogFragment.keyword == SearchKeyword.MANA_COST) {
            filterDialogFragment.value += "w";
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            filterDialogFragment.updateManaCostDisplay(context);
        } else if (Intrinsics.areEqual(filterDialogFragment.value, "colorless")) {
            filterDialogFragment.value = "w";
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context2);
        } else if (StringsKt.contains$default((CharSequence) filterDialogFragment.value, (CharSequence) "w", false, 2, (Object) null)) {
            filterDialogFragment.value = StringsKt.replace$default(filterDialogFragment.value, "w", "", false, 4, (Object) null);
            Context context3 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context3);
        } else {
            filterDialogFragment.value += "w";
            Context context4 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context4);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$27(FilterDialogFragment filterDialogFragment, View view) {
        if (filterDialogFragment.keyword == SearchKeyword.MANA_COST) {
            filterDialogFragment.value += "u";
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            filterDialogFragment.updateManaCostDisplay(context);
        } else if (Intrinsics.areEqual(filterDialogFragment.value, "colorless")) {
            filterDialogFragment.value = "u";
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context2);
        } else if (StringsKt.contains$default((CharSequence) filterDialogFragment.value, (CharSequence) "u", false, 2, (Object) null)) {
            filterDialogFragment.value = StringsKt.replace$default(filterDialogFragment.value, "u", "", false, 4, (Object) null);
            Context context3 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context3);
        } else {
            filterDialogFragment.value += "u";
            Context context4 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context4);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$28(FilterDialogFragment filterDialogFragment, View view) {
        if (filterDialogFragment.keyword == SearchKeyword.MANA_COST) {
            filterDialogFragment.value += "b";
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            filterDialogFragment.updateManaCostDisplay(context);
        } else if (Intrinsics.areEqual(filterDialogFragment.value, "colorless")) {
            filterDialogFragment.value = "b";
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context2);
        } else if (StringsKt.contains$default((CharSequence) filterDialogFragment.value, (CharSequence) "b", false, 2, (Object) null)) {
            filterDialogFragment.value = StringsKt.replace$default(filterDialogFragment.value, "b", "", false, 4, (Object) null);
            Context context3 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context3);
        } else {
            filterDialogFragment.value += "b";
            Context context4 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context4);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$29(FilterDialogFragment filterDialogFragment, View view) {
        if (filterDialogFragment.keyword == SearchKeyword.MANA_COST) {
            filterDialogFragment.value += "r";
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            filterDialogFragment.updateManaCostDisplay(context);
        } else if (Intrinsics.areEqual(filterDialogFragment.value, "colorless")) {
            filterDialogFragment.value = "r";
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context2);
        } else if (StringsKt.contains$default((CharSequence) filterDialogFragment.value, (CharSequence) "r", false, 2, (Object) null)) {
            filterDialogFragment.value = StringsKt.replace$default(filterDialogFragment.value, "r", "", false, 4, (Object) null);
            Context context3 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context3);
        } else {
            filterDialogFragment.value += "r";
            Context context4 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context4);
        }
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$3(FilterDialogFragment filterDialogFragment, View view, ImageView imageView) {
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        filterDialogFragment.updateColorDisplay(context);
        imageView.setVisibility(0);
    }

    static final Unit onCreateView$lambda$30(FilterDialogFragment filterDialogFragment, View view) {
        if (filterDialogFragment.keyword == SearchKeyword.MANA_COST) {
            filterDialogFragment.value += "g";
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            filterDialogFragment.updateManaCostDisplay(context);
        } else if (Intrinsics.areEqual(filterDialogFragment.value, "colorless")) {
            filterDialogFragment.value = "g";
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context2);
        } else if (StringsKt.contains$default((CharSequence) filterDialogFragment.value, (CharSequence) "g", false, 2, (Object) null)) {
            filterDialogFragment.value = StringsKt.replace$default(filterDialogFragment.value, "g", "", false, 4, (Object) null);
            Context context3 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context3);
        } else {
            filterDialogFragment.value += "g";
            Context context4 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context4);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$31(FilterDialogFragment filterDialogFragment) {
        Log.d("FilterDialogFragment", "Positive button clicked: value is " + filterDialogFragment.value);
        if (filterDialogFragment.value.length() > 0) {
            SearchCondition searchCondition = new SearchCondition(filterDialogFragment.include, filterDialogFragment.keyword, filterDialogFragment.operator, filterDialogFragment.value, "");
            if (filterDialogFragment.editMode) {
                searchCondition.setOriginalToken(filterDialogFragment.originalToken);
            } else {
                searchCondition.setOriginalToken(searchCondition.toShortString());
            }
            FilterDialogListener filterDialogListener = filterDialogFragment.listener;
            if (filterDialogListener != null) {
                filterDialogListener.onFilterSubmitButton(searchCondition);
            }
        }
        filterDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$32(FilterDialogFragment filterDialogFragment) {
        filterDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$3(View view, boolean z) {
        if (z) {
            AutoCompleteTextView autoCompleteTextView = view instanceof AutoCompleteTextView ? (AutoCompleteTextView) view : null;
            if (autoCompleteTextView != null) {
                autoCompleteTextView.showDropDown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$4(FilterDialogFragment filterDialogFragment, AdapterView adapterView, View view, int i, long j) {
        Object itemAtPosition = adapterView.getItemAtPosition(i);
        Intrinsics.checkNotNull(itemAtPosition, "null cannot be cast to non-null type kotlin.String");
        String lowerCase = StringsKt.substringBeforeLast$default(StringsKt.substringAfterLast$default((String) itemAtPosition, "(", (String) null, 2, (Object) null), ")", (String) null, 2, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        filterDialogFragment.value = lowerCase;
        MaterialButton materialButton = filterDialogFragment.positiveButton;
        if (materialButton != null) {
            materialButton.setEnabled(true);
        }
        MaterialButton materialButton2 = filterDialogFragment.positiveButton;
        if (materialButton2 != null) {
            materialButton2.setTextColor(ContextCompat.getColor(filterDialogFragment.requireContext(), R.color.almost_white));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7$1(View view, boolean z) {
        if (z) {
            AutoCompleteTextView autoCompleteTextView = view instanceof AutoCompleteTextView ? (AutoCompleteTextView) view : null;
            if (autoCompleteTextView != null) {
                autoCompleteTextView.showDropDown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7$4(FilterDialogFragment filterDialogFragment, Map map, AdapterView adapterView, View view, int i, long j) {
        Object itemAtPosition = adapterView.getItemAtPosition(i);
        Intrinsics.checkNotNull(itemAtPosition, "null cannot be cast to non-null type kotlin.String");
        String str = (String) itemAtPosition;
        if (Intrinsics.areEqual(filterDialogFragment.lang, "fr")) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (Intrinsics.areEqual((String) entry.getValue(), str)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            String str2 = (String) CollectionsKt.firstOrNull(linkedHashMap.keySet());
            if (str2 != null) {
                filterDialogFragment.value = str2;
            }
        } else {
            filterDialogFragment.value = str;
        }
        MaterialButton materialButton = filterDialogFragment.positiveButton;
        if (materialButton != null) {
            materialButton.setEnabled(true);
        }
        MaterialButton materialButton2 = filterDialogFragment.positiveButton;
        if (materialButton2 != null) {
            materialButton2.setTextColor(ContextCompat.getColor(filterDialogFragment.requireContext(), R.color.almost_white));
        }
    }

    static final Unit onCreateView$lambda$8(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = "";
        if (filterDialogFragment.keyword == SearchKeyword.MANA_COST) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            filterDialogFragment.updateManaCostDisplay(context);
        }
        if (filterDialogFragment.keyword == SearchKeyword.COLOR || filterDialogFragment.keyword == SearchKeyword.IDENTITY) {
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            filterDialogFragment.updateColorDisplay(context2);
        }
        return Unit.INSTANCE;
    }

    static final boolean onCreateView$lambda$9(EditText editText, FilterDialogFragment filterDialogFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        String string = editText.getText().toString();
        if (string.length() > 0) {
            filterDialogFragment.value = StringsKt.trim((CharSequence) string).toString();
            MaterialButton materialButton = filterDialogFragment.positiveButton;
            if (materialButton != null) {
                materialButton.setEnabled(true);
            }
            MaterialButton materialButton2 = filterDialogFragment.positiveButton;
            if (materialButton2 != null) {
                materialButton2.setTextColor(ContextCompat.getColor(filterDialogFragment.requireContext(), R.color.almost_white));
            }
        } else {
            MaterialButton materialButton3 = filterDialogFragment.positiveButton;
            if (materialButton3 != null) {
                materialButton3.setEnabled(false);
            }
            MaterialButton materialButton4 = filterDialogFragment.positiveButton;
            if (materialButton4 != null) {
                materialButton4.setTextColor(ContextCompat.getColor(filterDialogFragment.requireContext(), R.color.middle_grey));
            }
        }
        return true;
    }

    private final void setupTags(final View view) {
        if (view != null) {
            Log.d("FilterDialogFragment", "Setting up tags");
            TextView textView = (TextView) view.findViewById(R.id.tagArtifact);
            textView.setText(SearchDataUtils.INSTANCE.getInstance().translateTag("artifact", this.lang));
            if (textView != null) {
                ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.setupTags$lambda$0$0$0(this.f$0, view);
                    }
                });
            }
            TextView textView2 = (TextView) view.findViewById(R.id.tagCreature);
            textView2.setText(SearchDataUtils.INSTANCE.getInstance().translateTag("creature", this.lang));
            if (textView2 != null) {
                ViewExtensionsKt.setOnClickWithFade(textView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.setupTags$lambda$0$1$0(this.f$0, view);
                    }
                });
            }
            TextView textView3 = (TextView) view.findViewById(R.id.tagEnchantment);
            textView3.setText(SearchDataUtils.INSTANCE.getInstance().translateTag("enchantment", this.lang));
            if (textView3 != null) {
                ViewExtensionsKt.setOnClickWithFade(textView3, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda34
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.setupTags$lambda$0$2$0(this.f$0, view);
                    }
                });
            }
            TextView textView4 = (TextView) view.findViewById(R.id.tagInstant);
            textView4.setText(SearchDataUtils.INSTANCE.getInstance().translateTag("instant", this.lang));
            if (textView4 != null) {
                ViewExtensionsKt.setOnClickWithFade(textView4, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda35
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.setupTags$lambda$0$3$0(this.f$0, view);
                    }
                });
            }
            TextView textView5 = (TextView) view.findViewById(R.id.tagSorcery);
            textView5.setText(SearchDataUtils.INSTANCE.getInstance().translateTag("sorcery", this.lang));
            if (textView5 != null) {
                ViewExtensionsKt.setOnClickWithFade(textView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda36
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.setupTags$lambda$0$4$0(this.f$0, view);
                    }
                });
            }
            TextView textView6 = (TextView) view.findViewById(R.id.tagPlaneswalker);
            textView6.setText(SearchDataUtils.INSTANCE.getInstance().translateTag("planeswalker", this.lang));
            if (textView6 != null) {
                ViewExtensionsKt.setOnClickWithFade(textView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.setupTags$lambda$0$5$0(this.f$0, view);
                    }
                });
            }
            TextView textView7 = (TextView) view.findViewById(R.id.tagLand);
            textView7.setText(SearchDataUtils.INSTANCE.getInstance().translateTag("land", this.lang));
            if (textView7 != null) {
                ViewExtensionsKt.setOnClickWithFade(textView7, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.setupTags$lambda$0$6$0(this.f$0, view);
                    }
                });
            }
            TextView textView8 = (TextView) view.findViewById(R.id.tagLegendary);
            textView8.setText(SearchDataUtils.INSTANCE.getInstance().translateTag("legendary", this.lang));
            if (textView8 != null) {
                ViewExtensionsKt.setOnClickWithFade(textView8, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.setupTags$lambda$0$7$0(this.f$0, view);
                    }
                });
            }
            TextView textView9 = (TextView) view.findViewById(R.id.tagSnow);
            textView9.setText(SearchDataUtils.INSTANCE.getInstance().translateTag("snow", this.lang));
            if (textView9 != null) {
                ViewExtensionsKt.setOnClickWithFade(textView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.setupTags$lambda$0$8$0(this.f$0, view);
                    }
                });
            }
            TextView textView10 = (TextView) view.findViewById(R.id.tagBasic);
            textView10.setText(SearchDataUtils.INSTANCE.getInstance().translateTag("basic", this.lang));
            if (textView10 != null) {
                ViewExtensionsKt.setOnClickWithFade(textView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.setupTags$lambda$0$9$0(this.f$0, view);
                    }
                });
            }
            TextView textView11 = (TextView) view.findViewById(R.id.tagTribal);
            textView11.setText(SearchDataUtils.INSTANCE.getInstance().translateTag("tribal", this.lang));
            if (textView11 != null) {
                ViewExtensionsKt.setOnClickWithFade(textView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.setupTags$lambda$0$10$0(this.f$0, view);
                    }
                });
            }
            TextView textView12 = (TextView) view.findViewById(R.id.tagBattle);
            textView12.setText(SearchDataUtils.INSTANCE.getInstance().translateTag("battle", this.lang));
            if (textView12 != null) {
                ViewExtensionsKt.setOnClickWithFade(textView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.setupTags$lambda$0$11$0(this.f$0, view);
                    }
                });
            }
            TextView textView13 = (TextView) view.findViewById(R.id.tagToken);
            textView13.setText(SearchDataUtils.INSTANCE.getInstance().translateTag("token", this.lang));
            if (textView13 != null) {
                ViewExtensionsKt.setOnClickWithFade(textView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.setupTags$lambda$0$12$0(this.f$0, view);
                    }
                });
            }
            TextView textView14 = (TextView) view.findViewById(R.id.tagEmblem);
            textView14.setText(SearchDataUtils.INSTANCE.getInstance().translateTag("emblem", this.lang));
            if (textView14 != null) {
                ViewExtensionsKt.setOnClickWithFade(textView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.setupTags$lambda$0$13$0(this.f$0, view);
                    }
                });
            }
            TextView textView15 = (TextView) view.findViewById(R.id.tagDungeon);
            textView15.setText(SearchDataUtils.INSTANCE.getInstance().translateTag("dungeon", this.lang));
            if (textView15 != null) {
                ViewExtensionsKt.setOnClickWithFade(textView15, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.setupTags$lambda$0$14$0(this.f$0, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTags$lambda$0$0$0(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = SearchDataUtils.INSTANCE.getInstance().translateTag("artifact", filterDialogFragment.lang);
        if (filterDialogFragment.alwaysKeywordsInEnglish) {
            filterDialogFragment.value = "artifact";
        }
        ((EditText) view.findViewById(R.id.filterValueEditText)).setText(filterDialogFragment.value);
        filterDialogFragment.updateSubmitButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTags$lambda$0$1$0(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = SearchDataUtils.INSTANCE.getInstance().translateTag("creature", filterDialogFragment.lang);
        if (filterDialogFragment.alwaysKeywordsInEnglish) {
            filterDialogFragment.value = "creature";
        }
        ((EditText) view.findViewById(R.id.filterValueEditText)).setText(filterDialogFragment.value);
        filterDialogFragment.updateSubmitButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTags$lambda$0$10$0(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = SearchDataUtils.INSTANCE.getInstance().translateTag("tribal", filterDialogFragment.lang);
        if (filterDialogFragment.alwaysKeywordsInEnglish) {
            filterDialogFragment.value = "tribal";
        }
        ((EditText) view.findViewById(R.id.filterValueEditText)).setText(filterDialogFragment.value);
        filterDialogFragment.updateSubmitButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTags$lambda$0$11$0(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = SearchDataUtils.INSTANCE.getInstance().translateTag("battle", filterDialogFragment.lang);
        if (filterDialogFragment.alwaysKeywordsInEnglish) {
            filterDialogFragment.value = "battle";
        }
        ((EditText) view.findViewById(R.id.filterValueEditText)).setText(filterDialogFragment.value);
        filterDialogFragment.updateSubmitButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTags$lambda$0$12$0(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = SearchDataUtils.INSTANCE.getInstance().translateTag("token", filterDialogFragment.lang);
        if (filterDialogFragment.alwaysKeywordsInEnglish) {
            filterDialogFragment.value = "token";
        }
        ((EditText) view.findViewById(R.id.filterValueEditText)).setText(filterDialogFragment.value);
        filterDialogFragment.updateSubmitButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTags$lambda$0$13$0(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = SearchDataUtils.INSTANCE.getInstance().translateTag("emblem", filterDialogFragment.lang);
        if (filterDialogFragment.alwaysKeywordsInEnglish) {
            filterDialogFragment.value = "emblem";
        }
        ((EditText) view.findViewById(R.id.filterValueEditText)).setText(filterDialogFragment.value);
        filterDialogFragment.updateSubmitButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTags$lambda$0$14$0(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = SearchDataUtils.INSTANCE.getInstance().translateTag("dungeon", filterDialogFragment.lang);
        if (filterDialogFragment.alwaysKeywordsInEnglish) {
            filterDialogFragment.value = "dungeon";
        }
        ((EditText) view.findViewById(R.id.filterValueEditText)).setText(filterDialogFragment.value);
        filterDialogFragment.updateSubmitButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTags$lambda$0$2$0(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = SearchDataUtils.INSTANCE.getInstance().translateTag("enchantment", filterDialogFragment.lang);
        if (filterDialogFragment.alwaysKeywordsInEnglish) {
            filterDialogFragment.value = "enchantment";
        }
        ((EditText) view.findViewById(R.id.filterValueEditText)).setText(filterDialogFragment.value);
        filterDialogFragment.updateSubmitButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTags$lambda$0$3$0(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = SearchDataUtils.INSTANCE.getInstance().translateTag("instant", filterDialogFragment.lang);
        if (filterDialogFragment.alwaysKeywordsInEnglish) {
            filterDialogFragment.value = "instant";
        }
        ((EditText) view.findViewById(R.id.filterValueEditText)).setText(filterDialogFragment.value);
        filterDialogFragment.updateSubmitButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTags$lambda$0$4$0(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = SearchDataUtils.INSTANCE.getInstance().translateTag("sorcery", filterDialogFragment.lang);
        if (filterDialogFragment.alwaysKeywordsInEnglish) {
            filterDialogFragment.value = "sorcery";
        }
        ((EditText) view.findViewById(R.id.filterValueEditText)).setText(filterDialogFragment.value);
        filterDialogFragment.updateSubmitButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTags$lambda$0$5$0(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = SearchDataUtils.INSTANCE.getInstance().translateTag("planeswalker", filterDialogFragment.lang);
        if (filterDialogFragment.alwaysKeywordsInEnglish) {
            filterDialogFragment.value = "planeswalker";
        }
        ((EditText) view.findViewById(R.id.filterValueEditText)).setText(filterDialogFragment.value);
        filterDialogFragment.updateSubmitButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTags$lambda$0$6$0(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = SearchDataUtils.INSTANCE.getInstance().translateTag("land", filterDialogFragment.lang);
        if (filterDialogFragment.alwaysKeywordsInEnglish) {
            filterDialogFragment.value = "land";
        }
        ((EditText) view.findViewById(R.id.filterValueEditText)).setText(filterDialogFragment.value);
        filterDialogFragment.updateSubmitButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTags$lambda$0$7$0(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = SearchDataUtils.INSTANCE.getInstance().translateTag("legendary", filterDialogFragment.lang);
        if (filterDialogFragment.alwaysKeywordsInEnglish) {
            filterDialogFragment.value = "legendary";
        }
        ((EditText) view.findViewById(R.id.filterValueEditText)).setText(filterDialogFragment.value);
        filterDialogFragment.updateSubmitButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTags$lambda$0$8$0(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = SearchDataUtils.INSTANCE.getInstance().translateTag("snow", filterDialogFragment.lang);
        if (filterDialogFragment.alwaysKeywordsInEnglish) {
            filterDialogFragment.value = "snow";
        }
        ((EditText) view.findViewById(R.id.filterValueEditText)).setText(filterDialogFragment.value);
        filterDialogFragment.updateSubmitButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTags$lambda$0$9$0(FilterDialogFragment filterDialogFragment, View view) {
        filterDialogFragment.value = SearchDataUtils.INSTANCE.getInstance().translateTag("basic", filterDialogFragment.lang);
        if (filterDialogFragment.alwaysKeywordsInEnglish) {
            filterDialogFragment.value = "basic";
        }
        ((EditText) view.findViewById(R.id.filterValueEditText)).setText(filterDialogFragment.value);
        filterDialogFragment.updateSubmitButton();
        return Unit.INSTANCE;
    }

    private final void updateColorDisplay(Context context) {
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.filterValueTextView) : null;
        View view2 = getView();
        ImageView imageView = view2 != null ? (ImageView) view2.findViewById(R.id.clearFilterValue) : null;
        int length = this.value.length();
        MaterialButton materialButton = this.positiveButton;
        if (length == 0) {
            if (materialButton != null) {
                materialButton.setEnabled(false);
            }
            MaterialButton materialButton2 = this.positiveButton;
            if (materialButton2 != null) {
                materialButton2.setTextColor(ContextCompat.getColor(requireContext(), R.color.middle_grey));
            }
            if (textView != null) {
                textView.setTextSize(18.0f);
            }
            if (textView != null) {
                textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.light_grey));
            }
            if (textView != null) {
                textView.setText(getResources().getString(R.string.add_color_below));
            }
            if (imageView != null) {
                imageView.setVisibility(4);
                return;
            }
            return;
        }
        if (materialButton != null) {
            materialButton.setEnabled(true);
        }
        MaterialButton materialButton3 = this.positiveButton;
        if (materialButton3 != null) {
            materialButton3.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
        }
        if (textView != null) {
            textView.setTextSize(24.0f);
        }
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
        }
        String str = this.value;
        if (Intrinsics.areEqual(str, "colorless")) {
            str = "C";
        }
        SpannableString spannableStringStringToAttributedStringWithSymbols = new SymbolToImage(context).stringToAttributedStringWithSymbols(SearchDataUtils.INSTANCE.getInstance().standardizeManaCost(str), context.getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_big), new CharacterStyle[0]);
        if (textView != null) {
            textView.setText(spannableStringStringToAttributedStringWithSymbols);
        }
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private final void updateManaCostDisplay(Context context) {
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.filterValueTextView) : null;
        View view2 = getView();
        ImageView imageView = view2 != null ? (ImageView) view2.findViewById(R.id.clearFilterValue) : null;
        int length = this.value.length();
        MaterialButton materialButton = this.positiveButton;
        if (length == 0) {
            if (materialButton != null) {
                materialButton.setEnabled(false);
            }
            MaterialButton materialButton2 = this.positiveButton;
            if (materialButton2 != null) {
                materialButton2.setTextColor(ContextCompat.getColor(requireContext(), R.color.middle_grey));
            }
            if (textView != null) {
                textView.setTextSize(18.0f);
            }
            if (textView != null) {
                textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.light_grey));
            }
            if (textView != null) {
                textView.setText(getResources().getString(R.string.add_mana_below));
            }
            if (imageView != null) {
                imageView.setVisibility(4);
                return;
            }
            return;
        }
        if (materialButton != null) {
            materialButton.setEnabled(true);
        }
        MaterialButton materialButton3 = this.positiveButton;
        if (materialButton3 != null) {
            materialButton3.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
        }
        if (textView != null) {
            textView.setTextSize(24.0f);
        }
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
        }
        SpannableString spannableStringStringToAttributedStringWithSymbols = new SymbolToImage(context).stringToAttributedStringWithSymbols(SearchDataUtils.INSTANCE.getInstance().standardizeManaCost(this.value), context.getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_big), new CharacterStyle[0]);
        if (textView != null) {
            textView.setText(spannableStringStringToAttributedStringWithSymbols);
        }
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private final void updateSubmitButton() {
        int length = this.value.length();
        MaterialButton materialButton = this.positiveButton;
        if (length > 0) {
            if (materialButton != null) {
                materialButton.setEnabled(true);
            }
            MaterialButton materialButton2 = this.positiveButton;
            if (materialButton2 != null) {
                materialButton2.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
                return;
            }
            return;
        }
        if (materialButton != null) {
            materialButton.setEnabled(false);
        }
        MaterialButton materialButton3 = this.positiveButton;
        if (materialButton3 != null) {
            materialButton3.setTextColor(ContextCompat.getColor(requireContext(), R.color.middle_grey));
        }
    }

    public final boolean getAlwaysKeywordsInEnglish() {
        return this.alwaysKeywordsInEnglish;
    }

    public final boolean getEditMode() {
        return this.editMode;
    }

    public final boolean getInclude() {
        return this.include;
    }

    public final SearchKeyword getKeyword() {
        return this.keyword;
    }

    public final Operator getOperator() {
        return this.operator;
    }

    public final String getOriginalToken() {
        return this.originalToken;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x08d7  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0916  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0928  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x093d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0956  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0988  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x09b6  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x09e4  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0a12  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0a40  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0a6e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0a9c  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0aac  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0ac1  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0afc  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0b3f A[LOOP:9: B:235:0x0b39->B:237:0x0b3f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0c22  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0c42  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0c90  */
    /* JADX WARN: Type inference failed for: r3v53, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v39, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v50, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v67, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v72, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v75, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v78, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v81, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v84, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v87, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v90, types: [T, java.util.List] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ImageView imageView;
        ImageView imageView2;
        final View view;
        int iIndexOf;
        String str;
        ImageView imageView3;
        String str2;
        String str3;
        ImageView imageView4;
        boolean z;
        final Ref.ObjectRef objectRef;
        MaterialButton materialButton;
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.filter_dialog, container, false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            Unit unit = Unit.INSTANCE;
        }
        Spinner spinner = (Spinner) viewInflate.findViewById(R.id.includeSpinner);
        CollectionsKt.listOf((Object[]) new String[]{"include", "exclude"});
        String string = getResources().getString(R.string.include);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getResources().getString(R.string.exclude);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        ArrayAdapter arrayAdapter = new ArrayAdapter(viewInflate.getContext(), R.layout.custom_spinner_item, CollectionsKt.listOf((Object[]) new String[]{string, string2}));
        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        if (this.include) {
            spinner.setSelection(0);
        } else {
            spinner.setSelection(1);
        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                FilterDialogFragment.this.setInclude(position == 0);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> p0) {
            }
        });
        TextView textView = (TextView) viewInflate.findViewById(R.id.filterTitleTextView);
        SearchKeyword.Companion companion = SearchKeyword.INSTANCE;
        SearchKeyword searchKeyword = this.keyword;
        Context context = viewInflate.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText(companion.keywordDisplayName(searchKeyword, context));
        final EditText editText = (EditText) viewInflate.findViewById(R.id.filterValueEditText);
        editText.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.filterValueLinearLayout);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.filterValueTextView);
        final ImageView imageView5 = (ImageView) viewInflate.findViewById(R.id.clearFilterValue);
        View viewFindViewById = viewInflate.findViewById(R.id.separator1);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.manaSymbolsLayout1);
        LinearLayout linearLayout3 = (LinearLayout) viewInflate.findViewById(R.id.manaSymbolsLayout2);
        FlexboxLayout flexboxLayout = (FlexboxLayout) viewInflate.findViewById(R.id.flexboxLayout);
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.setTextView);
        autoCompleteTextView.setVisibility(8);
        ImageView imageView6 = (ImageView) viewInflate.findViewById(R.id.xManaAdd);
        ImageView imageView7 = (ImageView) viewInflate.findViewById(R.id.zeroManaAdd);
        ImageView imageView8 = (ImageView) viewInflate.findViewById(R.id.oneManaAdd);
        ImageView imageView9 = (ImageView) viewInflate.findViewById(R.id.cManaAdd);
        ImageView imageView10 = (ImageView) viewInflate.findViewById(R.id.wManaAdd);
        ImageView imageView11 = (ImageView) viewInflate.findViewById(R.id.uManaAdd);
        ImageView imageView12 = (ImageView) viewInflate.findViewById(R.id.bManaAdd);
        ImageView imageView13 = (ImageView) viewInflate.findViewById(R.id.rManaAdd);
        ImageView imageView14 = (ImageView) viewInflate.findViewById(R.id.gManaAdd);
        Spinner spinner2 = (Spinner) viewInflate.findViewById(R.id.raritySpinner);
        spinner2.setVisibility(8);
        linearLayout.setVisibility(8);
        viewFindViewById.setVisibility(8);
        linearLayout2.setVisibility(8);
        linearLayout3.setVisibility(8);
        flexboxLayout.setVisibility(8);
        String str4 = "substring(...)";
        String str5 = "null cannot be cast to non-null type java.lang.String";
        switch (WhenMappings.$EnumSwitchMapping$0[this.keyword.ordinal()]) {
            case 1:
                imageView = imageView8;
                imageView2 = imageView7;
                view = viewInflate;
                editText.setVisibility(0);
                editText.setInputType(524288);
                editText.setImportantForAutofill(2);
                if (this.value.length() > 0) {
                    editText.setText(this.value);
                }
                Unit unit2 = Unit.INSTANCE;
                z = true;
                Intrinsics.checkNotNull(imageView5);
                ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                    }
                });
                if (z) {
                    editText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.13
                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable s) {
                            String string3 = editText.getText().toString();
                            int length = string3.length();
                            FilterDialogFragment filterDialogFragment = this;
                            if (length > 0) {
                                MaterialButton materialButton2 = filterDialogFragment.positiveButton;
                                if (materialButton2 != null) {
                                    materialButton2.setEnabled(true);
                                }
                                MaterialButton materialButton3 = this.positiveButton;
                                if (materialButton3 != null) {
                                    materialButton3.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.almost_white));
                                }
                                this.setValue(StringsKt.trim((CharSequence) string3).toString());
                                return;
                            }
                            MaterialButton materialButton4 = filterDialogFragment.positiveButton;
                            if (materialButton4 != null) {
                                materialButton4.setEnabled(false);
                            }
                            MaterialButton materialButton5 = this.positiveButton;
                            if (materialButton5 != null) {
                                materialButton5.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.middle_grey));
                            }
                        }

                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }
                    });
                    editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda29
                        @Override // android.widget.TextView.OnEditorActionListener
                        public final boolean onEditorAction(TextView textView3, int i, KeyEvent keyEvent) {
                            return FilterDialogFragment.onCreateView$lambda$9(editText, this, textView3, i, keyEvent);
                        }
                    });
                    if (editText != null) {
                        Boolean.valueOf(editText.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda7
                            @Override // java.lang.Runnable
                            public final void run() {
                                FilterDialogFragment.onCreateView$lambda$10(editText, this);
                            }
                        }, 100L));
                    }
                }
                Spinner spinner3 = (Spinner) view.findViewById(R.id.operatorSpinner);
                objectRef = new Ref.ObjectRef();
                objectRef.element = ArraysKt.toList(Operator.values());
                if (this.keyword != SearchKeyword.NAME || this.keyword == SearchKeyword.TYPE || this.keyword == SearchKeyword.ORACLE_TEXT || this.keyword == SearchKeyword.LANGUAGE) {
                    Iterable iterable = (Iterable) objectRef.element;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : iterable) {
                        if (((Operator) obj) == Operator.CONTAINS) {
                            arrayList.add(obj);
                        }
                    }
                    objectRef.element = arrayList;
                }
                if (this.keyword == SearchKeyword.MANA_COST) {
                    Iterable iterable2 = (Iterable) objectRef.element;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : iterable2) {
                        Operator operator = (Operator) obj2;
                        if (operator != Operator.LESS_THAN && operator != Operator.LESS_THAN_OR_EQUAL) {
                            arrayList2.add(obj2);
                        }
                    }
                    objectRef.element = arrayList2;
                }
                if (this.keyword == SearchKeyword.MANA_VALUE) {
                    Iterable iterable3 = (Iterable) objectRef.element;
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj3 : iterable3) {
                        if (((Operator) obj3) != Operator.CONTAINS) {
                            arrayList3.add(obj3);
                        }
                    }
                    objectRef.element = arrayList3;
                }
                if (this.keyword == SearchKeyword.PRICE) {
                    Iterable iterable4 = (Iterable) objectRef.element;
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj4 : iterable4) {
                        if (((Operator) obj4) != Operator.CONTAINS) {
                            arrayList4.add(obj4);
                        }
                    }
                    objectRef.element = arrayList4;
                }
                if (this.keyword == SearchKeyword.RARITY) {
                    Iterable iterable5 = (Iterable) objectRef.element;
                    ArrayList arrayList5 = new ArrayList();
                    for (Object obj5 : iterable5) {
                        if (((Operator) obj5) != Operator.CONTAINS) {
                            arrayList5.add(obj5);
                        }
                    }
                    objectRef.element = arrayList5;
                }
                if (this.keyword == SearchKeyword.SET) {
                    Iterable iterable6 = (Iterable) objectRef.element;
                    ArrayList arrayList6 = new ArrayList();
                    for (Object obj6 : iterable6) {
                        if (((Operator) obj6) == Operator.EQUAL) {
                            arrayList6.add(obj6);
                        }
                    }
                    objectRef.element = arrayList6;
                }
                if (this.keyword == SearchKeyword.LAYOUT) {
                    Iterable iterable7 = (Iterable) objectRef.element;
                    ArrayList arrayList7 = new ArrayList();
                    for (Object obj7 : iterable7) {
                        if (((Operator) obj7) == Operator.EQUAL) {
                            arrayList7.add(obj7);
                        }
                    }
                    objectRef.element = arrayList7;
                }
                if (this.keyword == SearchKeyword.KEYWORD) {
                    Iterable iterable8 = (Iterable) objectRef.element;
                    ArrayList arrayList8 = new ArrayList();
                    for (Object obj8 : iterable8) {
                        if (((Operator) obj8) == Operator.CONTAINS) {
                            arrayList8.add(obj8);
                        }
                    }
                    objectRef.element = arrayList8;
                }
                if (this.keyword != SearchKeyword.LEGAL || this.keyword == SearchKeyword.BANNED || this.keyword == SearchKeyword.IS) {
                    Iterable iterable9 = (Iterable) objectRef.element;
                    ArrayList arrayList9 = new ArrayList();
                    for (Object obj9 : iterable9) {
                        if (((Operator) obj9) == Operator.CONTAINS) {
                            arrayList9.add(obj9);
                        }
                    }
                    objectRef.element = arrayList9;
                }
                if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                    Iterable iterable10 = (Iterable) objectRef.element;
                    ArrayList arrayList10 = new ArrayList();
                    for (Object obj10 : iterable10) {
                        if (((Operator) obj10) == Operator.CONTAINS) {
                            arrayList10.add(obj10);
                        }
                    }
                    objectRef.element = arrayList10;
                }
                Iterable<Operator> iterable11 = (Iterable) objectRef.element;
                ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable11, 10));
                for (Operator operator2 : iterable11) {
                    Operator.Companion companion2 = Operator.INSTANCE;
                    Context context2 = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    arrayList11.add(companion2.operatorDisplayName(operator2, context2));
                }
                ArrayAdapter arrayAdapter2 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList11);
                arrayAdapter2.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner3.setAdapter((SpinnerAdapter) arrayAdapter2);
                spinner3.setSelection(((List) objectRef.element).indexOf(this.operator));
                spinner3.requestLayout();
                spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setOperator(objectRef.element.get(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Intrinsics.checkNotNull(imageView6);
                ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView2);
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView);
                ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView9);
                ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView10);
                ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView11);
                ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView12);
                ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView13);
                ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView14);
                ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                    }
                });
                this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                if (this.value.length() != 0) {
                    this.editMode = false;
                    MaterialButton materialButton2 = this.positiveButton;
                    if (materialButton2 != null) {
                        materialButton2.setEnabled(false);
                        Unit unit3 = Unit.INSTANCE;
                    }
                    MaterialButton materialButton3 = this.positiveButton;
                    if (materialButton3 != null) {
                        materialButton3.setTextColor(ContextCompat.getColor(requireContext(), R.color.middle_grey));
                        Unit unit4 = Unit.INSTANCE;
                    }
                } else {
                    this.editMode = true;
                    this.originalToken = new SearchCondition(this.include, this.keyword, this.operator, this.value, "").toShortString();
                    MaterialButton materialButton4 = this.positiveButton;
                    if (materialButton4 != null) {
                        materialButton4.setEnabled(true);
                        Unit unit5 = Unit.INSTANCE;
                    }
                    MaterialButton materialButton5 = this.positiveButton;
                    if (materialButton5 != null) {
                        materialButton5.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
                        Unit unit6 = Unit.INSTANCE;
                    }
                    MaterialButton materialButton6 = this.positiveButton;
                    if (materialButton6 != null) {
                        materialButton6.setText(getResources().getString(R.string.update_filter));
                        Unit unit7 = Unit.INSTANCE;
                    }
                }
                materialButton = this.positiveButton;
                if (materialButton != null) {
                    ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilterDialogFragment.onCreateView$lambda$31(this.f$0);
                        }
                    });
                    Unit unit8 = Unit.INSTANCE;
                }
                MaterialButton materialButton7 = (MaterialButton) view.findViewById(R.id.negative_button);
                Intrinsics.checkNotNull(materialButton7);
                ViewExtensionsKt.setOnClickWithFade(materialButton7, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                    }
                });
                return view;
            case 2:
                imageView = imageView8;
                imageView2 = imageView7;
                view = viewInflate;
                editText.setVisibility(0);
                editText.setInputType(524288);
                editText.setImportantForAutofill(2);
                flexboxLayout.setVisibility(0);
                if (this.value.length() > 0) {
                    editText.setText(this.value);
                }
                Unit unit9 = Unit.INSTANCE;
                z = true;
                Intrinsics.checkNotNull(imageView5);
                ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                    }
                });
                if (z) {
                }
                Spinner spinner32 = (Spinner) view.findViewById(R.id.operatorSpinner);
                objectRef = new Ref.ObjectRef();
                objectRef.element = ArraysKt.toList(Operator.values());
                if (this.keyword != SearchKeyword.NAME) {
                    Iterable iterable12 = (Iterable) objectRef.element;
                    ArrayList arrayList12 = new ArrayList();
                    while (r3.hasNext()) {
                    }
                    objectRef.element = arrayList12;
                }
                if (this.keyword == SearchKeyword.MANA_COST) {
                }
                if (this.keyword == SearchKeyword.MANA_VALUE) {
                }
                if (this.keyword == SearchKeyword.PRICE) {
                }
                if (this.keyword == SearchKeyword.RARITY) {
                }
                if (this.keyword == SearchKeyword.SET) {
                }
                if (this.keyword == SearchKeyword.LAYOUT) {
                }
                if (this.keyword == SearchKeyword.KEYWORD) {
                }
                if (this.keyword != SearchKeyword.LEGAL) {
                    Iterable iterable92 = (Iterable) objectRef.element;
                    ArrayList arrayList92 = new ArrayList();
                    while (r3.hasNext()) {
                    }
                    objectRef.element = arrayList92;
                }
                if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                }
                Iterable<Operator> iterable112 = (Iterable) objectRef.element;
                ArrayList arrayList112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable112, 10));
                while (r3.hasNext()) {
                }
                ArrayAdapter arrayAdapter22 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList112);
                arrayAdapter22.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner32.setAdapter((SpinnerAdapter) arrayAdapter22);
                spinner32.setSelection(((List) objectRef.element).indexOf(this.operator));
                spinner32.requestLayout();
                spinner32.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setOperator(objectRef.element.get(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Intrinsics.checkNotNull(imageView6);
                ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView2);
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView);
                ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView9);
                ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView10);
                ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView11);
                ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView12);
                ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView13);
                ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView14);
                ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                    }
                });
                this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                if (this.value.length() != 0) {
                }
                materialButton = this.positiveButton;
                if (materialButton != null) {
                }
                MaterialButton materialButton72 = (MaterialButton) view.findViewById(R.id.negative_button);
                Intrinsics.checkNotNull(materialButton72);
                ViewExtensionsKt.setOnClickWithFade(materialButton72, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                    }
                });
                return view;
            case 3:
                imageView = imageView8;
                imageView2 = imageView7;
                view = viewInflate;
                linearLayout.setVisibility(0);
                viewFindViewById.setVisibility(0);
                linearLayout2.setVisibility(0);
                linearLayout3.setVisibility(0);
                imageView5.setVisibility(0);
                if (this.value.length() == 0) {
                    textView2.setTextSize(18.0f);
                    textView2.setTextColor(ContextCompat.getColor(requireContext(), R.color.light_grey));
                    textView2.setText(getResources().getString(R.string.add_mana_below));
                    imageView5.setVisibility(4);
                    Unit unit10 = Unit.INSTANCE;
                } else {
                    Boolean.valueOf(textView2.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            FilterDialogFragment.onCreateView$lambda$0(this.f$0, view, imageView5);
                        }
                    }));
                }
                z = false;
                Intrinsics.checkNotNull(imageView5);
                ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                    }
                });
                if (z) {
                }
                Spinner spinner322 = (Spinner) view.findViewById(R.id.operatorSpinner);
                objectRef = new Ref.ObjectRef();
                objectRef.element = ArraysKt.toList(Operator.values());
                if (this.keyword != SearchKeyword.NAME) {
                }
                if (this.keyword == SearchKeyword.MANA_COST) {
                }
                if (this.keyword == SearchKeyword.MANA_VALUE) {
                }
                if (this.keyword == SearchKeyword.PRICE) {
                }
                if (this.keyword == SearchKeyword.RARITY) {
                }
                if (this.keyword == SearchKeyword.SET) {
                }
                if (this.keyword == SearchKeyword.LAYOUT) {
                }
                if (this.keyword == SearchKeyword.KEYWORD) {
                }
                if (this.keyword != SearchKeyword.LEGAL) {
                }
                if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                }
                Iterable<Operator> iterable1122 = (Iterable) objectRef.element;
                ArrayList arrayList1122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable1122, 10));
                while (r3.hasNext()) {
                }
                ArrayAdapter arrayAdapter222 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList1122);
                arrayAdapter222.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner322.setAdapter((SpinnerAdapter) arrayAdapter222);
                spinner322.setSelection(((List) objectRef.element).indexOf(this.operator));
                spinner322.requestLayout();
                spinner322.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setOperator(objectRef.element.get(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Intrinsics.checkNotNull(imageView6);
                ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView2);
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView);
                ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView9);
                ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView10);
                ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView11);
                ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView12);
                ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView13);
                ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView14);
                ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                    }
                });
                this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                if (this.value.length() != 0) {
                }
                materialButton = this.positiveButton;
                if (materialButton != null) {
                }
                MaterialButton materialButton722 = (MaterialButton) view.findViewById(R.id.negative_button);
                Intrinsics.checkNotNull(materialButton722);
                ViewExtensionsKt.setOnClickWithFade(materialButton722, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                    }
                });
                return view;
            case 4:
                imageView = imageView8;
                imageView2 = imageView7;
                view = viewInflate;
                spinner2.setVisibility(0);
                final List listListOf = CollectionsKt.listOf((Object[]) new String[]{"en", "fr", "es", "de", "it", "pt", "ja", "ko", "zht", "zhs", "ru"});
                ArrayAdapter arrayAdapter3 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, CollectionsKt.listOf((Object[]) new String[]{"English", "Français", "Español", "Deutsch", "Italiano", "Português", "日本語", "한국어", "繁體中文", "简体中文", "Русский"}));
                arrayAdapter3.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter3);
                spinner2.requestLayout();
                if (this.value.length() > 0 && (iIndexOf = listListOf.indexOf(this.value)) >= 0) {
                    spinner2.setSelection(iIndexOf);
                }
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.3
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        FilterDialogFragment.this.setValue(listListOf.get(position));
                        MaterialButton materialButton8 = FilterDialogFragment.this.positiveButton;
                        if (materialButton8 != null) {
                            materialButton8.setEnabled(true);
                        }
                        MaterialButton materialButton9 = FilterDialogFragment.this.positiveButton;
                        if (materialButton9 != null) {
                            materialButton9.setTextColor(ContextCompat.getColor(FilterDialogFragment.this.requireContext(), R.color.almost_white));
                        }
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        FilterDialogFragment.this.setValue("");
                        MaterialButton materialButton8 = FilterDialogFragment.this.positiveButton;
                        if (materialButton8 != null) {
                            materialButton8.setEnabled(false);
                        }
                        MaterialButton materialButton9 = FilterDialogFragment.this.positiveButton;
                        if (materialButton9 != null) {
                            materialButton9.setTextColor(ContextCompat.getColor(FilterDialogFragment.this.requireContext(), R.color.middle_grey));
                        }
                    }
                });
                Unit unit11 = Unit.INSTANCE;
                z = false;
                Intrinsics.checkNotNull(imageView5);
                ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                    }
                });
                if (z) {
                }
                Spinner spinner3222 = (Spinner) view.findViewById(R.id.operatorSpinner);
                objectRef = new Ref.ObjectRef();
                objectRef.element = ArraysKt.toList(Operator.values());
                if (this.keyword != SearchKeyword.NAME) {
                }
                if (this.keyword == SearchKeyword.MANA_COST) {
                }
                if (this.keyword == SearchKeyword.MANA_VALUE) {
                }
                if (this.keyword == SearchKeyword.PRICE) {
                }
                if (this.keyword == SearchKeyword.RARITY) {
                }
                if (this.keyword == SearchKeyword.SET) {
                }
                if (this.keyword == SearchKeyword.LAYOUT) {
                }
                if (this.keyword == SearchKeyword.KEYWORD) {
                }
                if (this.keyword != SearchKeyword.LEGAL) {
                }
                if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                }
                Iterable<Operator> iterable11222 = (Iterable) objectRef.element;
                ArrayList arrayList11222 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable11222, 10));
                while (r3.hasNext()) {
                }
                ArrayAdapter arrayAdapter2222 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList11222);
                arrayAdapter2222.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner3222.setAdapter((SpinnerAdapter) arrayAdapter2222);
                spinner3222.setSelection(((List) objectRef.element).indexOf(this.operator));
                spinner3222.requestLayout();
                spinner3222.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setOperator(objectRef.element.get(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Intrinsics.checkNotNull(imageView6);
                ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView2);
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView);
                ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView9);
                ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView10);
                ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView11);
                ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView12);
                ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView13);
                ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView14);
                ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                    }
                });
                this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                if (this.value.length() != 0) {
                }
                materialButton = this.positiveButton;
                if (materialButton != null) {
                }
                MaterialButton materialButton7222 = (MaterialButton) view.findViewById(R.id.negative_button);
                Intrinsics.checkNotNull(materialButton7222);
                ViewExtensionsKt.setOnClickWithFade(materialButton7222, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                    }
                });
                return view;
            case 5:
            case 6:
                imageView = imageView8;
                String str6 = str5;
                view = viewInflate;
                imageView2 = imageView7;
                spinner2.setVisibility(0);
                final List listListOf2 = CollectionsKt.listOf((Object[]) new String[]{"standard", "pioneer", "modern", "legacy", "vintage", "commander", "pauper", "oathbreaker", "historic", "duel"});
                List<String> list = listListOf2;
                ArrayList arrayList13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (String string3 : list) {
                    if (string3.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        String strValueOf = String.valueOf(string3.charAt(0));
                        Intrinsics.checkNotNull(strValueOf, str6);
                        str = str6;
                        String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                        StringBuilder sbAppend = sb.append((Object) upperCase);
                        String strSubstring = string3.substring(1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, str4);
                        string3 = sbAppend.append(strSubstring).toString();
                    } else {
                        str = str6;
                    }
                    arrayList13.add(string3);
                    str6 = str;
                }
                ArrayAdapter arrayAdapter4 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList13);
                arrayAdapter4.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter4);
                spinner2.requestLayout();
                if (this.value.length() > 0) {
                    String lowerCase = this.value.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    int iIndexOf2 = listListOf2.indexOf(lowerCase);
                    if (iIndexOf2 >= 0) {
                        spinner2.setSelection(iIndexOf2);
                    }
                }
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.4
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        FilterDialogFragment.this.setValue(listListOf2.get(position));
                        MaterialButton materialButton8 = FilterDialogFragment.this.positiveButton;
                        if (materialButton8 != null) {
                            materialButton8.setEnabled(true);
                        }
                        MaterialButton materialButton9 = FilterDialogFragment.this.positiveButton;
                        if (materialButton9 != null) {
                            materialButton9.setTextColor(ContextCompat.getColor(FilterDialogFragment.this.requireContext(), R.color.almost_white));
                        }
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Unit unit12 = Unit.INSTANCE;
                z = false;
                Intrinsics.checkNotNull(imageView5);
                ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                    }
                });
                if (z) {
                }
                Spinner spinner32222 = (Spinner) view.findViewById(R.id.operatorSpinner);
                objectRef = new Ref.ObjectRef();
                objectRef.element = ArraysKt.toList(Operator.values());
                if (this.keyword != SearchKeyword.NAME) {
                }
                if (this.keyword == SearchKeyword.MANA_COST) {
                }
                if (this.keyword == SearchKeyword.MANA_VALUE) {
                }
                if (this.keyword == SearchKeyword.PRICE) {
                }
                if (this.keyword == SearchKeyword.RARITY) {
                }
                if (this.keyword == SearchKeyword.SET) {
                }
                if (this.keyword == SearchKeyword.LAYOUT) {
                }
                if (this.keyword == SearchKeyword.KEYWORD) {
                }
                if (this.keyword != SearchKeyword.LEGAL) {
                }
                if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                }
                Iterable<Operator> iterable112222 = (Iterable) objectRef.element;
                ArrayList arrayList112222 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable112222, 10));
                while (r3.hasNext()) {
                }
                ArrayAdapter arrayAdapter22222 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList112222);
                arrayAdapter22222.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner32222.setAdapter((SpinnerAdapter) arrayAdapter22222);
                spinner32222.setSelection(((List) objectRef.element).indexOf(this.operator));
                spinner32222.requestLayout();
                spinner32222.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setOperator(objectRef.element.get(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Intrinsics.checkNotNull(imageView6);
                ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView2);
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView);
                ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView9);
                ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView10);
                ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView11);
                ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView12);
                ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView13);
                ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView14);
                ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                    }
                });
                this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                if (this.value.length() != 0) {
                }
                materialButton = this.positiveButton;
                if (materialButton != null) {
                }
                MaterialButton materialButton72222 = (MaterialButton) view.findViewById(R.id.negative_button);
                Intrinsics.checkNotNull(materialButton72222);
                ViewExtensionsKt.setOnClickWithFade(materialButton72222, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                    }
                });
                return view;
            case 7:
                view = viewInflate;
                spinner2.setVisibility(0);
                final List listListOf3 = CollectionsKt.listOf((Object[]) new String[]{"spell", "permanent", "vanilla", "hybrid", "phyrexian", "reserved"});
                List<String> list2 = listListOf3;
                ArrayList arrayList14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (String string4 : list2) {
                    if (string4.length() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        String strValueOf2 = String.valueOf(string4.charAt(0));
                        imageView3 = imageView8;
                        str3 = str5;
                        Intrinsics.checkNotNull(strValueOf2, str3);
                        imageView4 = imageView7;
                        String upperCase2 = strValueOf2.toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                        StringBuilder sbAppend2 = sb2.append((Object) upperCase2);
                        String strSubstring2 = string4.substring(1);
                        str2 = str4;
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, str2);
                        string4 = sbAppend2.append(strSubstring2).toString();
                    } else {
                        imageView3 = imageView8;
                        str2 = str4;
                        str3 = str5;
                        imageView4 = imageView7;
                    }
                    arrayList14.add(string4);
                    str4 = str2;
                    imageView7 = imageView4;
                    str5 = str3;
                    imageView8 = imageView3;
                }
                imageView = imageView8;
                imageView2 = imageView7;
                ArrayAdapter arrayAdapter5 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList14);
                arrayAdapter5.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter5);
                spinner2.requestLayout();
                if (this.value.length() > 0) {
                    String lowerCase2 = this.value.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    int iIndexOf3 = listListOf3.indexOf(lowerCase2);
                    if (iIndexOf3 >= 0) {
                        spinner2.setSelection(iIndexOf3);
                    }
                }
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.5
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        FilterDialogFragment.this.setValue(listListOf3.get(position));
                        MaterialButton materialButton8 = FilterDialogFragment.this.positiveButton;
                        if (materialButton8 != null) {
                            materialButton8.setEnabled(true);
                        }
                        MaterialButton materialButton9 = FilterDialogFragment.this.positiveButton;
                        if (materialButton9 != null) {
                            materialButton9.setTextColor(ContextCompat.getColor(FilterDialogFragment.this.requireContext(), R.color.almost_white));
                        }
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Unit unit13 = Unit.INSTANCE;
                z = false;
                Intrinsics.checkNotNull(imageView5);
                ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                    }
                });
                if (z) {
                }
                Spinner spinner322222 = (Spinner) view.findViewById(R.id.operatorSpinner);
                objectRef = new Ref.ObjectRef();
                objectRef.element = ArraysKt.toList(Operator.values());
                if (this.keyword != SearchKeyword.NAME) {
                }
                if (this.keyword == SearchKeyword.MANA_COST) {
                }
                if (this.keyword == SearchKeyword.MANA_VALUE) {
                }
                if (this.keyword == SearchKeyword.PRICE) {
                }
                if (this.keyword == SearchKeyword.RARITY) {
                }
                if (this.keyword == SearchKeyword.SET) {
                }
                if (this.keyword == SearchKeyword.LAYOUT) {
                }
                if (this.keyword == SearchKeyword.KEYWORD) {
                }
                if (this.keyword != SearchKeyword.LEGAL) {
                }
                if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                }
                Iterable<Operator> iterable1122222 = (Iterable) objectRef.element;
                ArrayList arrayList1122222 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable1122222, 10));
                while (r3.hasNext()) {
                }
                ArrayAdapter arrayAdapter222222 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList1122222);
                arrayAdapter222222.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner322222.setAdapter((SpinnerAdapter) arrayAdapter222222);
                spinner322222.setSelection(((List) objectRef.element).indexOf(this.operator));
                spinner322222.requestLayout();
                spinner322222.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setOperator(objectRef.element.get(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Intrinsics.checkNotNull(imageView6);
                ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView2);
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView);
                ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView9);
                ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView10);
                ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView11);
                ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView12);
                ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView13);
                ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView14);
                ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                    }
                });
                this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                if (this.value.length() != 0) {
                }
                materialButton = this.positiveButton;
                if (materialButton != null) {
                }
                MaterialButton materialButton722222 = (MaterialButton) view.findViewById(R.id.negative_button);
                Intrinsics.checkNotNull(materialButton722222);
                ViewExtensionsKt.setOnClickWithFade(materialButton722222, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                    }
                });
                return view;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                view = viewInflate;
                spinner2.setVisibility(0);
                final List listListOf4 = CollectionsKt.listOf((Object[]) new String[]{"true", CredentialEntry.FALSE_STRING});
                ArrayAdapter arrayAdapter6 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, CollectionsKt.listOf((Object[]) new String[]{getResources().getString(R.string.toggle_yes), getResources().getString(R.string.toggle_no)}));
                arrayAdapter6.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter6);
                spinner2.requestLayout();
                if (this.value.length() > 0) {
                    String lowerCase3 = this.value.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    int iIndexOf4 = listListOf4.indexOf(lowerCase3);
                    if (iIndexOf4 >= 0) {
                        spinner2.setSelection(iIndexOf4);
                    }
                }
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.6
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        FilterDialogFragment.this.setValue(listListOf4.get(position));
                        MaterialButton materialButton8 = FilterDialogFragment.this.positiveButton;
                        if (materialButton8 != null) {
                            materialButton8.setEnabled(true);
                        }
                        MaterialButton materialButton9 = FilterDialogFragment.this.positiveButton;
                        if (materialButton9 != null) {
                            materialButton9.setTextColor(ContextCompat.getColor(FilterDialogFragment.this.requireContext(), R.color.almost_white));
                        }
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Unit unit14 = Unit.INSTANCE;
                imageView = imageView8;
                imageView2 = imageView7;
                z = false;
                Intrinsics.checkNotNull(imageView5);
                ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                    }
                });
                if (z) {
                }
                Spinner spinner3222222 = (Spinner) view.findViewById(R.id.operatorSpinner);
                objectRef = new Ref.ObjectRef();
                objectRef.element = ArraysKt.toList(Operator.values());
                if (this.keyword != SearchKeyword.NAME) {
                }
                if (this.keyword == SearchKeyword.MANA_COST) {
                }
                if (this.keyword == SearchKeyword.MANA_VALUE) {
                }
                if (this.keyword == SearchKeyword.PRICE) {
                }
                if (this.keyword == SearchKeyword.RARITY) {
                }
                if (this.keyword == SearchKeyword.SET) {
                }
                if (this.keyword == SearchKeyword.LAYOUT) {
                }
                if (this.keyword == SearchKeyword.KEYWORD) {
                }
                if (this.keyword != SearchKeyword.LEGAL) {
                }
                if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                }
                Iterable<Operator> iterable11222222 = (Iterable) objectRef.element;
                ArrayList arrayList11222222 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable11222222, 10));
                while (r3.hasNext()) {
                }
                ArrayAdapter arrayAdapter2222222 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList11222222);
                arrayAdapter2222222.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner3222222.setAdapter((SpinnerAdapter) arrayAdapter2222222);
                spinner3222222.setSelection(((List) objectRef.element).indexOf(this.operator));
                spinner3222222.requestLayout();
                spinner3222222.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setOperator(objectRef.element.get(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Intrinsics.checkNotNull(imageView6);
                ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView2);
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView);
                ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView9);
                ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView10);
                ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView11);
                ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView12);
                ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView13);
                ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView14);
                ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                    }
                });
                this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                if (this.value.length() != 0) {
                }
                materialButton = this.positiveButton;
                if (materialButton != null) {
                }
                MaterialButton materialButton7222222 = (MaterialButton) view.findViewById(R.id.negative_button);
                Intrinsics.checkNotNull(materialButton7222222);
                ViewExtensionsKt.setOnClickWithFade(materialButton7222222, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                    }
                });
                return view;
            case 13:
            case 14:
            case 15:
                view = viewInflate;
                Unit unit142 = Unit.INSTANCE;
                imageView = imageView8;
                imageView2 = imageView7;
                z = false;
                Intrinsics.checkNotNull(imageView5);
                ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                    }
                });
                if (z) {
                }
                Spinner spinner32222222 = (Spinner) view.findViewById(R.id.operatorSpinner);
                objectRef = new Ref.ObjectRef();
                objectRef.element = ArraysKt.toList(Operator.values());
                if (this.keyword != SearchKeyword.NAME) {
                }
                if (this.keyword == SearchKeyword.MANA_COST) {
                }
                if (this.keyword == SearchKeyword.MANA_VALUE) {
                }
                if (this.keyword == SearchKeyword.PRICE) {
                }
                if (this.keyword == SearchKeyword.RARITY) {
                }
                if (this.keyword == SearchKeyword.SET) {
                }
                if (this.keyword == SearchKeyword.LAYOUT) {
                }
                if (this.keyword == SearchKeyword.KEYWORD) {
                }
                if (this.keyword != SearchKeyword.LEGAL) {
                }
                if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                }
                Iterable<Operator> iterable112222222 = (Iterable) objectRef.element;
                ArrayList arrayList112222222 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable112222222, 10));
                while (r3.hasNext()) {
                }
                ArrayAdapter arrayAdapter22222222 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList112222222);
                arrayAdapter22222222.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner32222222.setAdapter((SpinnerAdapter) arrayAdapter22222222);
                spinner32222222.setSelection(((List) objectRef.element).indexOf(this.operator));
                spinner32222222.requestLayout();
                spinner32222222.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setOperator(objectRef.element.get(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Intrinsics.checkNotNull(imageView6);
                ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView2);
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView);
                ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView9);
                ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView10);
                ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView11);
                ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView12);
                ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView13);
                ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView14);
                ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                    }
                });
                this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                if (this.value.length() != 0) {
                }
                materialButton = this.positiveButton;
                if (materialButton != null) {
                }
                MaterialButton materialButton72222222 = (MaterialButton) view.findViewById(R.id.negative_button);
                Intrinsics.checkNotNull(materialButton72222222);
                ViewExtensionsKt.setOnClickWithFade(materialButton72222222, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                    }
                });
                return view;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                view = viewInflate;
                editText.setVisibility(0);
                editText.setInputType(8194);
                linearLayout.setVisibility(4);
                if (this.value.length() > 0) {
                    editText.setText(this.value);
                }
                Unit unit15 = Unit.INSTANCE;
                imageView = imageView8;
                imageView2 = imageView7;
                z = true;
                Intrinsics.checkNotNull(imageView5);
                ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                    }
                });
                if (z) {
                }
                Spinner spinner322222222 = (Spinner) view.findViewById(R.id.operatorSpinner);
                objectRef = new Ref.ObjectRef();
                objectRef.element = ArraysKt.toList(Operator.values());
                if (this.keyword != SearchKeyword.NAME) {
                }
                if (this.keyword == SearchKeyword.MANA_COST) {
                }
                if (this.keyword == SearchKeyword.MANA_VALUE) {
                }
                if (this.keyword == SearchKeyword.PRICE) {
                }
                if (this.keyword == SearchKeyword.RARITY) {
                }
                if (this.keyword == SearchKeyword.SET) {
                }
                if (this.keyword == SearchKeyword.LAYOUT) {
                }
                if (this.keyword == SearchKeyword.KEYWORD) {
                }
                if (this.keyword != SearchKeyword.LEGAL) {
                }
                if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                }
                Iterable<Operator> iterable1122222222 = (Iterable) objectRef.element;
                ArrayList arrayList1122222222 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable1122222222, 10));
                while (r3.hasNext()) {
                }
                ArrayAdapter arrayAdapter222222222 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList1122222222);
                arrayAdapter222222222.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner322222222.setAdapter((SpinnerAdapter) arrayAdapter222222222);
                spinner322222222.setSelection(((List) objectRef.element).indexOf(this.operator));
                spinner322222222.requestLayout();
                spinner322222222.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setOperator(objectRef.element.get(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Intrinsics.checkNotNull(imageView6);
                ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView2);
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView);
                ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView9);
                ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView10);
                ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView11);
                ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView12);
                ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView13);
                ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView14);
                ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                    }
                });
                this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                if (this.value.length() != 0) {
                }
                materialButton = this.positiveButton;
                if (materialButton != null) {
                }
                MaterialButton materialButton722222222 = (MaterialButton) view.findViewById(R.id.negative_button);
                Intrinsics.checkNotNull(materialButton722222222);
                ViewExtensionsKt.setOnClickWithFade(materialButton722222222, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                    }
                });
                return view;
            case 23:
            case 24:
                linearLayout.setVisibility(0);
                viewFindViewById.setVisibility(0);
                linearLayout2.setVisibility(0);
                linearLayout3.setVisibility(0);
                imageView5.setVisibility(0);
                imageView6.setVisibility(8);
                imageView7.setVisibility(8);
                imageView8.setVisibility(8);
                if (this.value.length() != 0) {
                    view = viewInflate;
                    Boolean.valueOf(textView2.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda18
                        @Override // java.lang.Runnable
                        public final void run() {
                            FilterDialogFragment.onCreateView$lambda$3(this.f$0, view, imageView5);
                        }
                    }));
                    imageView = imageView8;
                    imageView2 = imageView7;
                    z = false;
                    Intrinsics.checkNotNull(imageView5);
                    ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                        }
                    });
                    if (z) {
                    }
                    Spinner spinner3222222222 = (Spinner) view.findViewById(R.id.operatorSpinner);
                    objectRef = new Ref.ObjectRef();
                    objectRef.element = ArraysKt.toList(Operator.values());
                    if (this.keyword != SearchKeyword.NAME) {
                    }
                    if (this.keyword == SearchKeyword.MANA_COST) {
                    }
                    if (this.keyword == SearchKeyword.MANA_VALUE) {
                    }
                    if (this.keyword == SearchKeyword.PRICE) {
                    }
                    if (this.keyword == SearchKeyword.RARITY) {
                    }
                    if (this.keyword == SearchKeyword.SET) {
                    }
                    if (this.keyword == SearchKeyword.LAYOUT) {
                    }
                    if (this.keyword == SearchKeyword.KEYWORD) {
                    }
                    if (this.keyword != SearchKeyword.LEGAL) {
                    }
                    if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                    }
                    Iterable<Operator> iterable11222222222 = (Iterable) objectRef.element;
                    ArrayList arrayList11222222222 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable11222222222, 10));
                    while (r3.hasNext()) {
                    }
                    ArrayAdapter arrayAdapter2222222222 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList11222222222);
                    arrayAdapter2222222222.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                    spinner3222222222.setAdapter((SpinnerAdapter) arrayAdapter2222222222);
                    spinner3222222222.setSelection(((List) objectRef.element).indexOf(this.operator));
                    spinner3222222222.requestLayout();
                    spinner3222222222.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                        @Override // android.widget.AdapterView.OnItemSelectedListener
                        public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                            Intrinsics.checkNotNullParameter(parent, "parent");
                            this.setOperator(objectRef.element.get(position));
                        }

                        @Override // android.widget.AdapterView.OnItemSelectedListener
                        public void onNothingSelected(AdapterView<?> parent) {
                            Intrinsics.checkNotNullParameter(parent, "parent");
                        }
                    });
                    Intrinsics.checkNotNull(imageView6);
                    ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                        }
                    });
                    Intrinsics.checkNotNull(imageView2);
                    ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                        }
                    });
                    Intrinsics.checkNotNull(imageView);
                    ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                        }
                    });
                    Intrinsics.checkNotNull(imageView9);
                    ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                        }
                    });
                    Intrinsics.checkNotNull(imageView10);
                    ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                        }
                    });
                    Intrinsics.checkNotNull(imageView11);
                    ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                        }
                    });
                    Intrinsics.checkNotNull(imageView12);
                    ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                        }
                    });
                    Intrinsics.checkNotNull(imageView13);
                    ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                        }
                    });
                    Intrinsics.checkNotNull(imageView14);
                    ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                        }
                    });
                    this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                    if (this.value.length() != 0) {
                    }
                    materialButton = this.positiveButton;
                    if (materialButton != null) {
                    }
                    MaterialButton materialButton7222222222 = (MaterialButton) view.findViewById(R.id.negative_button);
                    Intrinsics.checkNotNull(materialButton7222222222);
                    ViewExtensionsKt.setOnClickWithFade(materialButton7222222222, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                        }
                    });
                    return view;
                }
                textView2.setTextSize(18.0f);
                textView2.setTextColor(ContextCompat.getColor(requireContext(), R.color.light_grey));
                textView2.setText(getResources().getString(R.string.add_color_below));
                imageView5.setVisibility(4);
                Unit unit16 = Unit.INSTANCE;
                imageView = imageView8;
                imageView2 = imageView7;
                view = viewInflate;
                z = false;
                Intrinsics.checkNotNull(imageView5);
                ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                    }
                });
                if (z) {
                }
                Spinner spinner32222222222 = (Spinner) view.findViewById(R.id.operatorSpinner);
                objectRef = new Ref.ObjectRef();
                objectRef.element = ArraysKt.toList(Operator.values());
                if (this.keyword != SearchKeyword.NAME) {
                }
                if (this.keyword == SearchKeyword.MANA_COST) {
                }
                if (this.keyword == SearchKeyword.MANA_VALUE) {
                }
                if (this.keyword == SearchKeyword.PRICE) {
                }
                if (this.keyword == SearchKeyword.RARITY) {
                }
                if (this.keyword == SearchKeyword.SET) {
                }
                if (this.keyword == SearchKeyword.LAYOUT) {
                }
                if (this.keyword == SearchKeyword.KEYWORD) {
                }
                if (this.keyword != SearchKeyword.LEGAL) {
                }
                if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                }
                Iterable<Operator> iterable112222222222 = (Iterable) objectRef.element;
                ArrayList arrayList112222222222 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable112222222222, 10));
                while (r3.hasNext()) {
                }
                ArrayAdapter arrayAdapter22222222222 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList112222222222);
                arrayAdapter22222222222.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner32222222222.setAdapter((SpinnerAdapter) arrayAdapter22222222222);
                spinner32222222222.setSelection(((List) objectRef.element).indexOf(this.operator));
                spinner32222222222.requestLayout();
                spinner32222222222.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setOperator(objectRef.element.get(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Intrinsics.checkNotNull(imageView6);
                ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView2);
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView);
                ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView9);
                ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView10);
                ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView11);
                ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView12);
                ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView13);
                ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView14);
                ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                    }
                });
                this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                if (this.value.length() != 0) {
                }
                materialButton = this.positiveButton;
                if (materialButton != null) {
                }
                MaterialButton materialButton72222222222 = (MaterialButton) view.findViewById(R.id.negative_button);
                Intrinsics.checkNotNull(materialButton72222222222);
                ViewExtensionsKt.setOnClickWithFade(materialButton72222222222, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                    }
                });
                return view;
            case 25:
                spinner2.setVisibility(0);
                final List listListOf5 = CollectionsKt.listOf((Object[]) new String[]{"c", "u", "r", "m", "b", "s"});
                List list3 = listListOf5;
                ArrayList arrayList15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                Iterator it = list3.iterator();
                while (it.hasNext()) {
                    arrayList15.add(SearchDataUtils.INSTANCE.getInstance().transformRarity((String) it.next(), this.lang));
                }
                ArrayAdapter arrayAdapter7 = new ArrayAdapter(viewInflate.getContext(), R.layout.custom_spinner_item, arrayList15);
                arrayAdapter7.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter7);
                spinner2.requestLayout();
                if (this.value.length() > 0) {
                    spinner2.setSelection(listListOf5.indexOf(this.value));
                }
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.8
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setValue(listListOf5.get(position));
                        MaterialButton materialButton8 = this.positiveButton;
                        if (materialButton8 != null) {
                            materialButton8.setEnabled(true);
                        }
                        MaterialButton materialButton9 = this.positiveButton;
                        if (materialButton9 != null) {
                            materialButton9.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.almost_white));
                        }
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setValue("");
                        MaterialButton materialButton8 = this.positiveButton;
                        if (materialButton8 != null) {
                            materialButton8.setEnabled(false);
                        }
                        MaterialButton materialButton9 = this.positiveButton;
                        if (materialButton9 != null) {
                            materialButton9.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.middle_grey));
                        }
                    }
                });
                Unit unit17 = Unit.INSTANCE;
                imageView = imageView8;
                imageView2 = imageView7;
                view = viewInflate;
                z = false;
                Intrinsics.checkNotNull(imageView5);
                ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                    }
                });
                if (z) {
                }
                Spinner spinner322222222222 = (Spinner) view.findViewById(R.id.operatorSpinner);
                objectRef = new Ref.ObjectRef();
                objectRef.element = ArraysKt.toList(Operator.values());
                if (this.keyword != SearchKeyword.NAME) {
                }
                if (this.keyword == SearchKeyword.MANA_COST) {
                }
                if (this.keyword == SearchKeyword.MANA_VALUE) {
                }
                if (this.keyword == SearchKeyword.PRICE) {
                }
                if (this.keyword == SearchKeyword.RARITY) {
                }
                if (this.keyword == SearchKeyword.SET) {
                }
                if (this.keyword == SearchKeyword.LAYOUT) {
                }
                if (this.keyword == SearchKeyword.KEYWORD) {
                }
                if (this.keyword != SearchKeyword.LEGAL) {
                }
                if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                }
                Iterable<Operator> iterable1122222222222 = (Iterable) objectRef.element;
                ArrayList arrayList1122222222222 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable1122222222222, 10));
                while (r3.hasNext()) {
                }
                ArrayAdapter arrayAdapter222222222222 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList1122222222222);
                arrayAdapter222222222222.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner322222222222.setAdapter((SpinnerAdapter) arrayAdapter222222222222);
                spinner322222222222.setSelection(((List) objectRef.element).indexOf(this.operator));
                spinner322222222222.requestLayout();
                spinner322222222222.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setOperator(objectRef.element.get(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Intrinsics.checkNotNull(imageView6);
                ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView2);
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView);
                ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView9);
                ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView10);
                ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView11);
                ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView12);
                ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView13);
                ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView14);
                ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                    }
                });
                this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                if (this.value.length() != 0) {
                }
                materialButton = this.positiveButton;
                if (materialButton != null) {
                }
                MaterialButton materialButton722222222222 = (MaterialButton) view.findViewById(R.id.negative_button);
                Intrinsics.checkNotNull(materialButton722222222222);
                ViewExtensionsKt.setOnClickWithFade(materialButton722222222222, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                    }
                });
                return view;
            case 26:
                autoCompleteTextView.setVisibility(0);
                autoCompleteTextView.setHint(getResources().getString(R.string.select_a_set));
                Context context3 = getContext();
                if (context3 != null) {
                    List<CardSet> listSortedWith = CollectionsKt.sortedWith(CardSetsManager.INSTANCE.getCardSets(), new Comparator() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$onCreateView$lambda$5$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(((CardSet) t2).getReleased_at(), ((CardSet) t).getReleased_at());
                        }
                    });
                    ArrayList arrayList16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
                    for (CardSet cardSet : listSortedWith) {
                        String name = cardSet.getName();
                        String upperCase3 = cardSet.getCode().toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
                        arrayList16.add(name + " (" + upperCase3 + ")");
                    }
                    autoCompleteTextView.setAdapter(new ArrayAdapter(context3, android.R.layout.simple_dropdown_item_1line, arrayList16));
                    autoCompleteTextView.setInputType(524288);
                    autoCompleteTextView.setImportantForAutofill(2);
                    autoCompleteTextView.setThreshold(1);
                    autoCompleteTextView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda21
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            autoCompleteTextView.showDropDown();
                        }
                    });
                    autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda23
                        @Override // android.view.View.OnFocusChangeListener
                        public final void onFocusChange(View view2, boolean z2) {
                            FilterDialogFragment.onCreateView$lambda$5$3(view2, z2);
                        }
                    });
                    this.value.length();
                    autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda24
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                            FilterDialogFragment.onCreateView$lambda$5$4(this.f$0, adapterView, view2, i, j);
                        }
                    });
                    Unit unit18 = Unit.INSTANCE;
                    Unit unit19 = Unit.INSTANCE;
                }
                imageView = imageView8;
                imageView2 = imageView7;
                view = viewInflate;
                z = false;
                Intrinsics.checkNotNull(imageView5);
                ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                    }
                });
                if (z) {
                }
                Spinner spinner3222222222222 = (Spinner) view.findViewById(R.id.operatorSpinner);
                objectRef = new Ref.ObjectRef();
                objectRef.element = ArraysKt.toList(Operator.values());
                if (this.keyword != SearchKeyword.NAME) {
                }
                if (this.keyword == SearchKeyword.MANA_COST) {
                }
                if (this.keyword == SearchKeyword.MANA_VALUE) {
                }
                if (this.keyword == SearchKeyword.PRICE) {
                }
                if (this.keyword == SearchKeyword.RARITY) {
                }
                if (this.keyword == SearchKeyword.SET) {
                }
                if (this.keyword == SearchKeyword.LAYOUT) {
                }
                if (this.keyword == SearchKeyword.KEYWORD) {
                }
                if (this.keyword != SearchKeyword.LEGAL) {
                }
                if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                }
                Iterable<Operator> iterable11222222222222 = (Iterable) objectRef.element;
                ArrayList arrayList11222222222222 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable11222222222222, 10));
                while (r3.hasNext()) {
                }
                ArrayAdapter arrayAdapter2222222222222 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList11222222222222);
                arrayAdapter2222222222222.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner3222222222222.setAdapter((SpinnerAdapter) arrayAdapter2222222222222);
                spinner3222222222222.setSelection(((List) objectRef.element).indexOf(this.operator));
                spinner3222222222222.requestLayout();
                spinner3222222222222.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setOperator(objectRef.element.get(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Intrinsics.checkNotNull(imageView6);
                ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView2);
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView);
                ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView9);
                ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView10);
                ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView11);
                ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView12);
                ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView13);
                ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView14);
                ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                    }
                });
                this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                if (this.value.length() != 0) {
                }
                materialButton = this.positiveButton;
                if (materialButton != null) {
                }
                MaterialButton materialButton7222222222222 = (MaterialButton) view.findViewById(R.id.negative_button);
                Intrinsics.checkNotNull(materialButton7222222222222);
                ViewExtensionsKt.setOnClickWithFade(materialButton7222222222222, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                    }
                });
                return view;
            case 27:
                editText.setVisibility(0);
                editText.setInputType(524288);
                editText.setImportantForAutofill(2);
                if (this.value.length() > 0) {
                    editText.setText(this.value);
                }
                Unit unit20 = Unit.INSTANCE;
                imageView = imageView8;
                imageView2 = imageView7;
                view = viewInflate;
                z = true;
                Intrinsics.checkNotNull(imageView5);
                ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                    }
                });
                if (z) {
                }
                Spinner spinner32222222222222 = (Spinner) view.findViewById(R.id.operatorSpinner);
                objectRef = new Ref.ObjectRef();
                objectRef.element = ArraysKt.toList(Operator.values());
                if (this.keyword != SearchKeyword.NAME) {
                }
                if (this.keyword == SearchKeyword.MANA_COST) {
                }
                if (this.keyword == SearchKeyword.MANA_VALUE) {
                }
                if (this.keyword == SearchKeyword.PRICE) {
                }
                if (this.keyword == SearchKeyword.RARITY) {
                }
                if (this.keyword == SearchKeyword.SET) {
                }
                if (this.keyword == SearchKeyword.LAYOUT) {
                }
                if (this.keyword == SearchKeyword.KEYWORD) {
                }
                if (this.keyword != SearchKeyword.LEGAL) {
                }
                if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                }
                Iterable<Operator> iterable112222222222222 = (Iterable) objectRef.element;
                ArrayList arrayList112222222222222 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable112222222222222, 10));
                while (r3.hasNext()) {
                }
                ArrayAdapter arrayAdapter22222222222222 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList112222222222222);
                arrayAdapter22222222222222.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner32222222222222.setAdapter((SpinnerAdapter) arrayAdapter22222222222222);
                spinner32222222222222.setSelection(((List) objectRef.element).indexOf(this.operator));
                spinner32222222222222.requestLayout();
                spinner32222222222222.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setOperator(objectRef.element.get(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Intrinsics.checkNotNull(imageView6);
                ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView2);
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView);
                ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView9);
                ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView10);
                ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView11);
                ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView12);
                ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView13);
                ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView14);
                ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                    }
                });
                this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                if (this.value.length() != 0) {
                }
                materialButton = this.positiveButton;
                if (materialButton != null) {
                }
                MaterialButton materialButton72222222222222 = (MaterialButton) view.findViewById(R.id.negative_button);
                Intrinsics.checkNotNull(materialButton72222222222222);
                ViewExtensionsKt.setOnClickWithFade(materialButton72222222222222, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                    }
                });
                return view;
            case 28:
                spinner2.setVisibility(0);
                final List<String> layoutTypes = SearchDataUtils.INSTANCE.getInstance().getLayoutTypes();
                List<String> list4 = layoutTypes;
                ArrayList arrayList17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                Iterator<T> it2 = list4.iterator();
                while (it2.hasNext()) {
                    arrayList17.add(SearchDataUtils.INSTANCE.getInstance().transformLayout((String) it2.next(), this.lang));
                }
                ArrayAdapter arrayAdapter8 = new ArrayAdapter(viewInflate.getContext(), R.layout.custom_spinner_item, arrayList17);
                arrayAdapter8.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter8);
                spinner2.requestLayout();
                if (this.value.length() > 0) {
                    spinner2.setSelection(layoutTypes.indexOf(this.value));
                }
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.10
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setValue(layoutTypes.get(position));
                        MaterialButton materialButton8 = this.positiveButton;
                        if (materialButton8 != null) {
                            materialButton8.setEnabled(true);
                        }
                        MaterialButton materialButton9 = this.positiveButton;
                        if (materialButton9 != null) {
                            materialButton9.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.almost_white));
                        }
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setValue("");
                        MaterialButton materialButton8 = this.positiveButton;
                        if (materialButton8 != null) {
                            materialButton8.setEnabled(false);
                        }
                        MaterialButton materialButton9 = this.positiveButton;
                        if (materialButton9 != null) {
                            materialButton9.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.middle_grey));
                        }
                    }
                });
                Unit unit21 = Unit.INSTANCE;
                imageView = imageView8;
                imageView2 = imageView7;
                view = viewInflate;
                z = false;
                Intrinsics.checkNotNull(imageView5);
                ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                    }
                });
                if (z) {
                }
                Spinner spinner322222222222222 = (Spinner) view.findViewById(R.id.operatorSpinner);
                objectRef = new Ref.ObjectRef();
                objectRef.element = ArraysKt.toList(Operator.values());
                if (this.keyword != SearchKeyword.NAME) {
                }
                if (this.keyword == SearchKeyword.MANA_COST) {
                }
                if (this.keyword == SearchKeyword.MANA_VALUE) {
                }
                if (this.keyword == SearchKeyword.PRICE) {
                }
                if (this.keyword == SearchKeyword.RARITY) {
                }
                if (this.keyword == SearchKeyword.SET) {
                }
                if (this.keyword == SearchKeyword.LAYOUT) {
                }
                if (this.keyword == SearchKeyword.KEYWORD) {
                }
                if (this.keyword != SearchKeyword.LEGAL) {
                }
                if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                }
                Iterable<Operator> iterable1122222222222222 = (Iterable) objectRef.element;
                ArrayList arrayList1122222222222222 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable1122222222222222, 10));
                while (r3.hasNext()) {
                }
                ArrayAdapter arrayAdapter222222222222222 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList1122222222222222);
                arrayAdapter222222222222222.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner322222222222222.setAdapter((SpinnerAdapter) arrayAdapter222222222222222);
                spinner322222222222222.setSelection(((List) objectRef.element).indexOf(this.operator));
                spinner322222222222222.requestLayout();
                spinner322222222222222.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setOperator(objectRef.element.get(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Intrinsics.checkNotNull(imageView6);
                ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView2);
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView);
                ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView9);
                ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView10);
                ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView11);
                ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView12);
                ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView13);
                ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView14);
                ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                    }
                });
                this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                if (this.value.length() != 0) {
                }
                materialButton = this.positiveButton;
                if (materialButton != null) {
                }
                MaterialButton materialButton722222222222222 = (MaterialButton) view.findViewById(R.id.negative_button);
                Intrinsics.checkNotNull(materialButton722222222222222);
                ViewExtensionsKt.setOnClickWithFade(materialButton722222222222222, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                    }
                });
                return view;
            case 29:
                autoCompleteTextView.setVisibility(0);
                autoCompleteTextView.setHint(getResources().getString(R.string.select_a_keyword));
                Context context4 = getContext();
                if (context4 != null) {
                    final Map<String, String> keywords = SearchDataUtils.INSTANCE.getInstance().getKeywords();
                    List listSorted = CollectionsKt.sorted(keywords.keySet());
                    if (Intrinsics.areEqual(this.lang, "fr")) {
                        listSorted = CollectionsKt.sorted(keywords.values());
                    }
                    autoCompleteTextView.setAdapter(new ArrayAdapter(context4, android.R.layout.simple_dropdown_item_1line, listSorted));
                    autoCompleteTextView.setInputType(524288);
                    autoCompleteTextView.setImportantForAutofill(2);
                    autoCompleteTextView.setThreshold(1);
                    autoCompleteTextView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda25
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            autoCompleteTextView.showDropDown();
                        }
                    });
                    autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda26
                        @Override // android.view.View.OnFocusChangeListener
                        public final void onFocusChange(View view2, boolean z2) {
                            FilterDialogFragment.onCreateView$lambda$7$1(view2, z2);
                        }
                    });
                    if (this.value.length() > 0) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (Map.Entry<String, String> entry : keywords.entrySet()) {
                            if (Intrinsics.areEqual(entry.getKey(), this.value)) {
                                linkedHashMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                        String str7 = (String) CollectionsKt.firstOrNull(linkedHashMap.values());
                        if (str7 != null) {
                            autoCompleteTextView.setText((CharSequence) str7, false);
                            Unit unit22 = Unit.INSTANCE;
                            Unit unit23 = Unit.INSTANCE;
                        }
                    }
                    autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda27
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                            FilterDialogFragment.onCreateView$lambda$7$4(this.f$0, keywords, adapterView, view2, i, j);
                        }
                    });
                    Unit unit24 = Unit.INSTANCE;
                    Unit unit25 = Unit.INSTANCE;
                }
                imageView = imageView8;
                imageView2 = imageView7;
                view = viewInflate;
                z = false;
                Intrinsics.checkNotNull(imageView5);
                ViewExtensionsKt.setOnClickWithFade(imageView5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$8(this.f$0, view);
                    }
                });
                if (z) {
                }
                Spinner spinner3222222222222222 = (Spinner) view.findViewById(R.id.operatorSpinner);
                objectRef = new Ref.ObjectRef();
                objectRef.element = ArraysKt.toList(Operator.values());
                if (this.keyword != SearchKeyword.NAME) {
                }
                if (this.keyword == SearchKeyword.MANA_COST) {
                }
                if (this.keyword == SearchKeyword.MANA_VALUE) {
                }
                if (this.keyword == SearchKeyword.PRICE) {
                }
                if (this.keyword == SearchKeyword.RARITY) {
                }
                if (this.keyword == SearchKeyword.SET) {
                }
                if (this.keyword == SearchKeyword.LAYOUT) {
                }
                if (this.keyword == SearchKeyword.KEYWORD) {
                }
                if (this.keyword != SearchKeyword.LEGAL) {
                }
                if (CollectionsKt.listOf((Object[]) new SearchKeyword[]{SearchKeyword.ALTERED, SearchKeyword.MISPRINT, SearchKeyword.SIGNED, SearchKeyword.PROXY, SearchKeyword.IN_DECK}).contains(this.keyword)) {
                }
                Iterable<Operator> iterable11222222222222222 = (Iterable) objectRef.element;
                ArrayList arrayList11222222222222222 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable11222222222222222, 10));
                while (r3.hasNext()) {
                }
                ArrayAdapter arrayAdapter2222222222222222 = new ArrayAdapter(view.getContext(), R.layout.custom_spinner_item, arrayList11222222222222222);
                arrayAdapter2222222222222222.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
                spinner3222222222222222.setAdapter((SpinnerAdapter) arrayAdapter2222222222222222);
                spinner3222222222222222.setSelection(((List) objectRef.element).indexOf(this.operator));
                spinner3222222222222222.requestLayout();
                spinner3222222222222222.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment.onCreateView.26
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view2, int position, long id) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        this.setOperator(objectRef.element.get(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                    }
                });
                Intrinsics.checkNotNull(imageView6);
                ViewExtensionsKt.setOnClickWithFade(imageView6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$22(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView2);
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$23(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView);
                ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$24(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView9);
                ViewExtensionsKt.setOnClickWithFade(imageView9, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$25(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView10);
                ViewExtensionsKt.setOnClickWithFade(imageView10, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$26(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView11);
                ViewExtensionsKt.setOnClickWithFade(imageView11, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$27(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView12);
                ViewExtensionsKt.setOnClickWithFade(imageView12, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$28(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView13);
                ViewExtensionsKt.setOnClickWithFade(imageView13, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$29(this.f$0, view);
                    }
                });
                Intrinsics.checkNotNull(imageView14);
                ViewExtensionsKt.setOnClickWithFade(imageView14, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$30(this.f$0, view);
                    }
                });
                this.positiveButton = (MaterialButton) view.findViewById(R.id.positive_button);
                if (this.value.length() != 0) {
                }
                materialButton = this.positiveButton;
                if (materialButton != null) {
                }
                MaterialButton materialButton7222222222222222 = (MaterialButton) view.findViewById(R.id.negative_button);
                Intrinsics.checkNotNull(materialButton7222222222222222);
                ViewExtensionsKt.setOnClickWithFade(materialButton7222222222222222, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterDialogFragment$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterDialogFragment.onCreateView$lambda$32(this.f$0);
                    }
                });
                return view;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (this.keyword == SearchKeyword.TYPE) {
            setupTags(getView());
        }
    }

    public final void setAlwaysKeywordsInEnglish(boolean z) {
        this.alwaysKeywordsInEnglish = z;
    }

    public final void setEditMode(boolean z) {
        this.editMode = z;
    }

    public final void setInclude(boolean z) {
        this.include = z;
    }

    public final void setKeyword(SearchKeyword searchKeyword) {
        Intrinsics.checkNotNullParameter(searchKeyword, "<set-?>");
        this.keyword = searchKeyword;
    }

    public final void setOperator(Operator operator) {
        Intrinsics.checkNotNullParameter(operator, "<set-?>");
        this.operator = operator;
    }

    public final void setOriginalToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originalToken = str;
    }

    public final void setValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.value = str;
    }
}
