package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelperLocalized;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TriviaFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J&\u0010\u0017\u001a\u00020\r2\u001e\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\nJ\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\u001a\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b2\u0006\u0010\"\u001a\u00020\u001fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/TriviaFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "trivia", "Lcom/studiolaganne/lengendarylens/MTTrivia;", "selectedAnswers", "", "", "submitListener", "Lkotlin/Function2;", "", "Lcom/studiolaganne/lengendarylens/MTAnswerAttempt;", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setTrivia", "setSubmitListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setupTriviaUI", ViewHierarchyConstants.VIEW_KEY, "updateSubmitButtonState", "onViewCreated", "buildAnswerList", "getLocalizedText", "", "defaultText", "localization", AndroidContextPlugin.LOCALE_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TriviaFragment extends Fragment {
    public static final int $stable = 8;
    private final Map<Integer, Integer> selectedAnswers = new LinkedHashMap();
    private Function2<? super Integer, ? super List<MTAnswerAttempt>, Unit> submitListener;
    private MTTrivia trivia;

    private final List<MTAnswerAttempt> buildAnswerList() {
        Map<Integer, Integer> map = this.selectedAnswers;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arrayList.add(new MTAnswerAttempt(entry.getValue().intValue(), entry.getKey().intValue()));
        }
        return arrayList;
    }

    private final String getLocalizedText(String defaultText, List<?> localization, String locale) {
        if (Intrinsics.areEqual(locale, "fr") && localization != null) {
            for (Object obj : localization) {
                if (obj instanceof MTLocalizedQuestion) {
                    MTLocalizedQuestion mTLocalizedQuestion = (MTLocalizedQuestion) obj;
                    if (Intrinsics.areEqual(mTLocalizedQuestion.getLocale(), "fr")) {
                        return mTLocalizedQuestion.getQuestion();
                    }
                } else if (obj instanceof MTLocalizedAnswer) {
                    MTLocalizedAnswer mTLocalizedAnswer = (MTLocalizedAnswer) obj;
                    if (Intrinsics.areEqual(mTLocalizedAnswer.getLocale(), "fr")) {
                        return mTLocalizedAnswer.getAnswer();
                    }
                } else {
                    continue;
                }
            }
        }
        return defaultText;
    }

    static final WindowInsetsCompat onCreateView$lambda$0(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        v.setPadding(0, 0, 0, insets2.bottom);
        return insets;
    }

    static final Unit onCreateView$lambda$2(TriviaFragment triviaFragment) {
        Function2<? super Integer, ? super List<MTAnswerAttempt>, Unit> function2;
        MTTrivia mTTrivia = triviaFragment.trivia;
        if (mTTrivia != null && (function2 = triviaFragment.submitListener) != null) {
            function2.invoke(Integer.valueOf(mTTrivia.getId()), triviaFragment.buildAnswerList());
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0209  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setupTriviaUI(View view) {
        int iIntValue;
        boolean z;
        Integer num;
        TextView textView = (TextView) view.findViewById(R.id.triviaNameTextView);
        TextView textView2 = (TextView) view.findViewById(R.id.attemptsTextView);
        TextView textView3 = (TextView) view.findViewById(R.id.endDateTextView);
        TextView textView4 = (TextView) view.findViewById(R.id.bestScoreTextView);
        View viewFindViewById = view.findViewById(R.id.successMessageLayout);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.questionsContainer);
        TextView textView5 = (TextView) view.findViewById(R.id.noTriviaTextView);
        TextView textView6 = (TextView) view.findViewById(R.id.noMoreAttemptsTextView);
        View viewFindViewById2 = view.findViewById(R.id.submitButtonLayout);
        if (this.trivia == null) {
            textView5.setVisibility(0);
            textView.setVisibility(8);
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            textView4.setVisibility(8);
            viewGroup.setVisibility(8);
            viewFindViewById.setVisibility(8);
            textView6.setVisibility(8);
            viewFindViewById2.setVisibility(8);
            return;
        }
        textView5.setVisibility(8);
        textView.setVisibility(0);
        textView2.setVisibility(0);
        textView3.setVisibility(0);
        MTTrivia mTTrivia = this.trivia;
        Intrinsics.checkNotNull(mTTrivia);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String deviceLanguage = new PreferencesManager(contextRequireContext).getDeviceLanguage();
        textView.setText(mTTrivia.getName());
        for (MTEntryLocalization mTEntryLocalization : mTTrivia.getLocalization()) {
            String lowerCase = mTEntryLocalization.getLocale().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            MTTrivia mTTrivia2 = mTTrivia;
            String lowerCase2 = deviceLanguage.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                textView.setText(mTEntryLocalization.getName());
            }
            mTTrivia = mTTrivia2;
        }
        MTTrivia mTTrivia3 = mTTrivia;
        textView2.setText(getString(R.string.attempts_label, Integer.valueOf(mTTrivia3.getUser_attempts()), Integer.valueOf(mTTrivia3.getMax_attempts())));
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            SimpleDateFormat simpleDateFormat2 = Intrinsics.areEqual(deviceLanguage, "fr") ? new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.FRENCH) : new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH);
            simpleDateFormat2.setTimeZone(TimeZone.getDefault());
            Date date = simpleDateFormat.parse(mTTrivia3.getEnd_date());
            if (date != null) {
                textView3.setText(getString(R.string.ends_on_label, simpleDateFormat2.format(date)));
            }
        } catch (Exception unused) {
            textView3.setText(getString(R.string.ends_on_label, mTTrivia3.getEnd_date()));
        }
        List<MTTriviaAttempt> attempts = mTTrivia3.getAttempts();
        if (attempts != null) {
            Iterator<T> it = attempts.iterator();
            if (it.hasNext()) {
                Integer numValueOf = Integer.valueOf(((MTTriviaAttempt) it.next()).getScore());
                while (it.hasNext()) {
                    Integer numValueOf2 = Integer.valueOf(((MTTriviaAttempt) it.next()).getScore());
                    if (numValueOf.compareTo(numValueOf2) < 0) {
                        numValueOf = numValueOf2;
                    }
                }
                num = numValueOf;
            } else {
                num = null;
            }
            Integer num2 = num;
            iIntValue = num2 != null ? num2.intValue() : 0;
        }
        int size = mTTrivia3.getQuestions().size();
        if (iIntValue > 0) {
            textView4.setText(getString(R.string.best_score_label, Integer.valueOf(iIntValue), Integer.valueOf(size)));
            textView4.setVisibility(0);
        } else {
            textView4.setVisibility(8);
        }
        List<MTTriviaAttempt> attempts2 = mTTrivia3.getAttempts();
        if (attempts2 != null) {
            List<MTTriviaAttempt> list = attempts2;
            if ((list instanceof Collection) && list.isEmpty()) {
                z = false;
            } else {
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    if (((MTTriviaAttempt) it2.next()).getScore() == size) {
                        z = true;
                        break;
                    }
                }
                z = false;
            }
        }
        boolean z2 = mTTrivia3.getUser_attempts() >= mTTrivia3.getMax_attempts();
        if (z) {
            viewFindViewById.setVisibility(0);
            viewGroup.setVisibility(8);
            textView6.setVisibility(8);
            viewFindViewById2.setVisibility(8);
            return;
        }
        if (z2) {
            viewFindViewById.setVisibility(8);
            viewGroup.setVisibility(8);
            textView6.setVisibility(0);
            viewFindViewById2.setVisibility(8);
            return;
        }
        viewFindViewById.setVisibility(8);
        textView6.setVisibility(8);
        viewGroup.setVisibility(0);
        viewFindViewById2.setVisibility(0);
        viewGroup.removeAllViews();
        this.selectedAnswers.clear();
        for (final MTQuestion mTQuestion : CollectionsKt.sortedWith(mTTrivia3.getQuestions(), new Comparator() { // from class: com.studiolaganne.lengendarylens.TriviaFragment$setupTriviaUI$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((MTQuestion) t).getOrder()), Integer.valueOf(((MTQuestion) t2).getOrder()));
            }
        })) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.item_trivia_question, viewGroup, false);
            TextView textView7 = (TextView) viewInflate.findViewById(R.id.questionTextView);
            RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(R.id.answersRadioGroup);
            String localizedText = getLocalizedText(mTQuestion.getQuestion(), mTQuestion.getLocalization(), deviceLanguage);
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            SymbolToImage symbolToImage = new SymbolToImage(contextRequireContext2);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.symbol_oracle_size);
            Context contextRequireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
            textView7.setText(symbolToImage.stringToAttributedStringWithSymbolsAndLinks(localizedText, dimensionPixelSize, contextRequireContext3, new Function1() { // from class: com.studiolaganne.lengendarylens.TriviaFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TriviaFragment.setupTriviaUI$lambda$4(this.f$0, (String) obj);
                }
            }, new CharacterStyle[0]));
            textView7.setMovementMethod(LinkMovementMethod.getInstance());
            for (final MTAnswer mTAnswer : CollectionsKt.sortedWith(mTQuestion.getAnswers(), new Comparator() { // from class: com.studiolaganne.lengendarylens.TriviaFragment$setupTriviaUI$$inlined$sortedBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((MTAnswer) t).getId()), Integer.valueOf(((MTAnswer) t2).getId()));
                }
            })) {
                RadioButton radioButton = new RadioButton(getContext());
                radioButton.setId(View.generateViewId());
                radioButton.setText(getLocalizedText(mTAnswer.getAnswer(), mTAnswer.getLocalization(), deviceLanguage));
                radioButton.setTextSize(16.0f);
                radioButton.setTextColor(radioButton.getResources().getColorStateList(R.color.almost_white));
                radioButton.setPadding(0, 8, 0, 8);
                radioButton.setChecked(false);
                radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.TriviaFragment$$ExternalSyntheticLambda2
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                        TriviaFragment.setupTriviaUI$lambda$7(this.f$0, mTQuestion, mTAnswer, compoundButton, z3);
                    }
                });
                radioGroup.addView(radioButton);
            }
            viewGroup.addView(viewInflate);
        }
        updateSubmitButtonState();
    }

    static final Unit setupTriviaUI$lambda$4(TriviaFragment triviaFragment, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (triviaFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = triviaFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String deviceLanguage = new PreferencesManager(contextRequireContext).getDeviceLanguage();
        MTGDBHelper.Companion companion = MTGDBHelper.INSTANCE;
        Context contextRequireContext2 = triviaFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        List<CardRecord> cardsByTitle = companion.getInstance(contextRequireContext2).getCardsByTitle(it);
        if (cardsByTitle.isEmpty() && Intrinsics.areEqual(deviceLanguage, "fr")) {
            MTGDBHelperLocalized.Companion companion2 = MTGDBHelperLocalized.INSTANCE;
            Context contextRequireContext3 = triviaFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
            cardsByTitle = companion2.getInstance(contextRequireContext3, "fr").getCardsByTitle(it);
        }
        if (!cardsByTitle.isEmpty()) {
            CardRecord cardRecord = (CardRecord) CollectionsKt.first((List) cardsByTitle);
            Intent intent = new Intent(triviaFragment.requireContext(), (Class<?>) CardActivity.class);
            intent.putExtra("scryfallId", cardRecord.getScryfall_id());
            intent.putExtra("oracleId", cardRecord.getOracle_id());
            intent.putExtra("lang", cardRecord.getLang());
            triviaFragment.startActivity(intent);
        }
        return Unit.INSTANCE;
    }

    static final void setupTriviaUI$lambda$7(TriviaFragment triviaFragment, MTQuestion mTQuestion, MTAnswer mTAnswer, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            triviaFragment.selectedAnswers.put(Integer.valueOf(mTQuestion.getId()), Integer.valueOf(mTAnswer.getId()));
            triviaFragment.updateSubmitButtonState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSubmitButtonState() {
        View viewFindViewById;
        List<MTQuestion> questions;
        View view = getView();
        if (view == null || (viewFindViewById = view.findViewById(R.id.submitButtonLayout)) == null) {
            return;
        }
        MTTrivia mTTrivia = this.trivia;
        boolean z = false;
        if (mTTrivia != null && (questions = mTTrivia.getQuestions()) != null) {
            List<MTQuestion> list = questions;
            if ((list instanceof Collection) && list.isEmpty()) {
                z = true;
            } else {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (!this.selectedAnswers.containsKey(Integer.valueOf(((MTQuestion) it.next()).getId()))) {
                        break;
                    }
                }
                z = true;
            }
        }
        viewFindViewById.setAlpha(z ? 1.0f : 0.5f);
        viewFindViewById.setEnabled(z);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String string;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_trivia, container, false);
        ViewCompat.setOnApplyWindowInsetsListener(viewInflate, new OnApplyWindowInsetsListener() { // from class: com.studiolaganne.lengendarylens.TriviaFragment$$ExternalSyntheticLambda3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return TriviaFragment.onCreateView$lambda$0(view, windowInsetsCompat);
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("triviaJson")) != null) {
            this.trivia = (MTTrivia) new Gson().fromJson(string, MTTrivia.class);
        }
        Intrinsics.checkNotNull(viewInflate);
        setupTriviaUI(viewInflate);
        View viewFindViewById = viewInflate.findViewById(R.id.submitButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.TriviaFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TriviaFragment.onCreateView$lambda$2(this.f$0);
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.TriviaFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.updateSubmitButtonState();
            }
        });
    }

    public final void setSubmitListener(Function2<? super Integer, ? super List<MTAnswerAttempt>, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.submitListener = listener;
    }

    public final void setTrivia(MTTrivia trivia) {
        this.trivia = trivia;
        View view = getView();
        if (view != null) {
            setupTriviaUI(view);
        }
    }
}
