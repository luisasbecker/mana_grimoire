package com.studiolaganne.lengendarylens;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.webkit.ProxyConfig;
import com.facebook.appevents.internal.Constants;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.studiolaganne.lengendarylens.RulesActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: RulesActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J8\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000eH\u0016J\u001c\u0010(\u001a\u0004\u0018\u00010\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u000e2\u0006\u0010*\u001a\u00020\u000eH\u0002J\u0012\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020!H\u0016J\u0016\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00020!2\u0006\u00100\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u00101J\b\u00103\u001a\u00020!H\u0002J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u000206H\u0002J\u0016\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:J\b\u0010;\u001a\u00020!H\u0002J\b\u0010<\u001a\u00020!H\u0002J\u0010\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020\u000eH\u0016J\u0010\u0010?\u001a\u00020!2\u0006\u0010>\u001a\u00020\u000eH\u0016J\u0010\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020\u000eH\u0016J\u0010\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020\u000eH\u0002J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/studiolaganne/lengendarylens/RulesActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "Lcom/studiolaganne/lengendarylens/RuleParagraphCallback;", "Lcom/studiolaganne/lengendarylens/CardLanguageClickListener;", "<init>", "()V", "sections", "", "Lcom/studiolaganne/lengendarylens/RuleSection;", "rules", "Lcom/studiolaganne/lengendarylens/RuleParagraph;", "glossary", "Lcom/studiolaganne/lengendarylens/GlossaryEntry;", "lang", "", "entries", "", "Lcom/studiolaganne/lengendarylens/RuleObject;", "lastQuery", "symbolToImage", "Lcom/studiolaganne/lengendarylens/SymbolToImage;", "popupWindow", "Landroid/widget/PopupWindow;", "popupView", "Landroid/view/View;", "cardsDBHelper", "Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "cardsDBHelperLocalized", "Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "selectionCount", "", "sectionNumberToDisplay", "onCardLanguageClick", "", "newScId", "oracleId", Constants.GP_IAP_TITLE, "language", "typeLine", "oracle", "formatEffectiveDate", "effectiveDate", AndroidContextPlugin.LOCALE_KEY, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onAttachedToWindow", "processData", "deviceLang", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadData", "loadItems", "showBottomSheetCardInfo", "cardRecord", "Lcom/studiolaganne/lengendarylens/CardRecord;", "dpToPx", "dp", "context", "Landroid/content/Context;", "showCopyButtonAnimated", "hideCopyButtonAnimated", "selectionAdded", "sectionNumber", "selectionRemoved", "linkClicked", "value", "openWebActivity", "url", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RulesActivity extends BaseActivity implements RuleParagraphCallback, CardLanguageClickListener {
    public static final int $stable = 8;
    private MTGDBHelper cardsDBHelper;
    private MTGDBHelperLocalized cardsDBHelperLocalized;
    private View popupView;
    private PopupWindow popupWindow;
    private int selectionCount;
    private SymbolToImage symbolToImage;
    private List<RuleSection> sections = CollectionsKt.emptyList();
    private List<RuleParagraph> rules = CollectionsKt.emptyList();
    private List<GlossaryEntry> glossary = CollectionsKt.emptyList();
    private String lang = "en";
    private List<RuleObject> entries = new ArrayList();
    private String lastQuery = "";
    private String sectionNumberToDisplay = "";

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.RulesActivity$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: RulesActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.RulesActivity$onCreate$2", f = "RulesActivity.kt", i = {}, l = {197, 199, 216}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $deviceLang;
        int label;

        /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.RulesActivity$onCreate$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RulesActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.studiolaganne.lengendarylens.RulesActivity$onCreate$2$1", f = "RulesActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ RulesActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RulesActivity rulesActivity, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = rulesActivity;
            }

            static final void invokeSuspend$lambda$1(RecyclerView recyclerView, int i) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager != null) {
                    linearLayoutManager.scrollToPositionWithOffset(i, 0);
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.loadItems();
                final RecyclerView recyclerView = (RecyclerView) this.this$0.findViewById(R.id.rulesRecyclerView);
                if (this.this$0.sectionNumberToDisplay.length() > 0) {
                    List list = this.this$0.entries;
                    RulesActivity rulesActivity = this.this$0;
                    Iterator it = list.iterator();
                    final int i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i = -1;
                            break;
                        }
                        if (StringsKt.contains$default((CharSequence) ((RuleObject) it.next()).getSectionNumber(), (CharSequence) rulesActivity.sectionNumberToDisplay, false, 2, (Object) null)) {
                            break;
                        }
                        i++;
                    }
                    if (i != -1) {
                        recyclerView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.RulesActivity$onCreate$2$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                RulesActivity.AnonymousClass2.AnonymousClass1.invokeSuspend$lambda$1(recyclerView, i);
                            }
                        }, 250L);
                    }
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$deviceLang = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RulesActivity.this.new AnonymousClass2(this.$deviceLang, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
        
            if (r6.this$0.processData(r6.$deviceLang.element, r6) != r0) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RulesActivity.this.loadData(this.$deviceLang.element, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                this.label = 3;
            }
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(RulesActivity.this, null), this) != coroutine_suspended) {
                this.label = 3;
            }
            return coroutine_suspended;
        }
    }

    private final String formatEffectiveDate(String effectiveDate, String locale) {
        if (effectiveDate == null) {
            return null;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("d MMMM yyyy", Intrinsics.areEqual(locale, "fr") ? Locale.FRENCH : Locale.ENGLISH);
            Date date = simpleDateFormat.parse(effectiveDate);
            if (date != null) {
                return simpleDateFormat2.format(date);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideCopyButtonAnimated() {
        final MaterialButton materialButton = (MaterialButton) findViewById(R.id.copy_button);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.copyLayout);
        final ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(dpToPx(80, this), 0);
        valueAnimatorOfInt.setDuration(350L);
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RulesActivity.hideCopyButtonAnimated$lambda$0$0(linearLayout, valueAnimator);
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.studiolaganne.lengendarylens.RulesActivity$hideCopyButtonAnimated$animator$1$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                linearLayout.getLayoutParams().height = 0;
                linearLayout.setVisibility(8);
            }
        });
        linearLayout.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                valueAnimatorOfInt.start();
            }
        }, 150L);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RulesActivity.hideCopyButtonAnimated$lambda$2$0(materialButton, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideCopyButtonAnimated$lambda$0$0(LinearLayout linearLayout, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        linearLayout.getLayoutParams().height = ((Integer) animatedValue).intValue();
        linearLayout.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideCopyButtonAnimated$lambda$2$0(MaterialButton materialButton, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        materialButton.setAlpha(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void linkClicked$lambda$4$1(RecyclerView recyclerView, int i) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadItems() {
        ViewGroup viewGroup;
        if (this.sections.isEmpty()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rulesRecyclerView);
        Menu menu = ((NavigationView) findViewById(R.id.nav_view)).getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
        menu.clear();
        this.entries.clear();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (RuleSection ruleSection : this.sections) {
            int i4 = i2 + 1;
            if (i2 == this.sections.size() - 1) {
                break;
            }
            int number = ruleSection.getNumber();
            int i5 = number - 1;
            this.entries.add(new RuleObject(1, i5, number + ".", false, 8, null));
            String strValueOf = String.valueOf((number + 1) * 100);
            if (i5 < this.sections.size() - 2) {
                while (i3 < this.rules.size() && this.rules.get(i3).getSectionNumber().compareTo(strValueOf) < 0) {
                    int i6 = i3;
                    this.entries.add(new RuleObject(2, i6, this.rules.get(i3).getSectionNumber(), false, 8, null));
                    i3 = i6 + 1;
                }
                i2 = i4;
                i3 = i3;
            } else {
                int i7 = i3;
                while (i7 < this.rules.size()) {
                    this.entries.add(new RuleObject(2, i7, this.rules.get(i7).getSectionNumber(), false, 8, null));
                    i7++;
                }
                i2 = i4;
                i3 = i7;
            }
        }
        this.entries.add(new RuleObject(1, this.sections.size() - 1, this.sections.size() + ".", false, 8, null));
        Iterator<T> it = this.glossary.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            this.entries.add(new RuleObject(3, i8, "g_" + ((GlossaryEntry) it.next()).getKey(), false, 8, null));
            i8++;
        }
        recyclerView.setAdapter(new RulesAdapter(this.symbolToImage, CollectionsKt.toList(this.entries), this.sections, this.rules, this.glossary, this));
        this.selectionCount = 0;
        ArrayList arrayList = new ArrayList();
        Iterator<RuleParagraph> it2 = this.rules.iterator();
        while (true) {
            viewGroup = null;
            if (!it2.hasNext()) {
                break;
            }
            RuleParagraph next = it2.next();
            if (StringsKt.endsWith$default(next.getSectionNumber(), ".", false, 2, (Object) null)) {
                arrayList.add(next);
            }
        }
        int i9 = 0;
        for (RuleSection ruleSection2 : this.sections) {
            int i10 = i + 1;
            if (i == this.sections.size() - 1) {
                break;
            }
            MenuItem menuItemAdd = menu.add("");
            View viewInflate = getLayoutInflater().inflate(R.layout.menu_item_with_divider, viewGroup);
            ((TextView) viewInflate.findViewById(R.id.menu_item_text)).setText(ruleSection2.getNumber() + ". " + ruleSection2.getTitle());
            ((TextView) viewInflate.findViewById(R.id.menu_item_text)).setTypeface(null, 1);
            viewInflate.setBackgroundColor(ContextCompat.getColor(this, R.color.dark_grey));
            menuItemAdd.setActionView(viewInflate);
            int number2 = ruleSection2.getNumber();
            String strValueOf2 = String.valueOf((number2 + 1) * 100);
            if (number2 < this.sections.size() - 1) {
                while (i9 < arrayList.size() && ((RuleParagraph) arrayList.get(i9)).getSectionNumber().compareTo(strValueOf2) < 0) {
                    RuleParagraph ruleParagraph = (RuleParagraph) arrayList.get(i9);
                    MenuItem menuItemAdd2 = menu.add("");
                    View viewInflate2 = getLayoutInflater().inflate(R.layout.menu_item_with_divider, (ViewGroup) null);
                    ((TextView) viewInflate2.findViewById(R.id.menu_item_text)).setText(ruleParagraph.getSectionNumber() + " " + ruleParagraph.getRulesText());
                    menuItemAdd2.setActionView(viewInflate2);
                    i9++;
                }
            } else {
                while (i9 < arrayList.size()) {
                    RuleParagraph ruleParagraph2 = (RuleParagraph) arrayList.get(i9);
                    MenuItem menuItemAdd3 = menu.add("");
                    View viewInflate3 = getLayoutInflater().inflate(R.layout.menu_item_with_divider, (ViewGroup) null);
                    ((TextView) viewInflate3.findViewById(R.id.menu_item_text)).setText(ruleParagraph2.getSectionNumber() + " " + ruleParagraph2.getRulesText());
                    menuItemAdd3.setActionView(viewInflate3);
                    i9++;
                }
            }
            i = i10;
            viewGroup = null;
        }
        if (this.sections.isEmpty()) {
            return;
        }
        MenuItem menuItemAdd4 = menu.add("");
        View viewInflate4 = getLayoutInflater().inflate(R.layout.menu_item_with_divider, (ViewGroup) null);
        ((TextView) viewInflate4.findViewById(R.id.menu_item_text)).setText(this.sections.size() + ". " + ((RuleSection) CollectionsKt.last((List) this.sections)).getTitle());
        ((TextView) viewInflate4.findViewById(R.id.menu_item_text)).setTypeface(null, 1);
        viewInflate4.setBackgroundColor(ContextCompat.getColor(this, R.color.dark_grey));
        menuItemAdd4.setActionView(viewInflate4);
    }

    static final Unit onCreate$lambda$2(final RulesActivity rulesActivity) {
        List<RuleObject> list = rulesActivity.entries;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((RuleObject) obj).isSelected()) {
                arrayList.add(obj);
            }
        }
        String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return RulesActivity.onCreate$lambda$2$1(this.f$0, (RuleObject) obj2);
            }
        }, 30, null), "[[", "", false, 4, (Object) null), "]]", "", false, 4, (Object) null);
        Object systemService = rulesActivity.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(rulesActivity.getString(R.string.rules_text_copied_short), strReplace$default));
        Toast.makeText(rulesActivity, rulesActivity.getString(R.string.rules_text_copied), 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onCreate$lambda$2$1(RulesActivity rulesActivity, RuleObject entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Object obj = null;
        String str = "\n";
        if (!StringsKt.startsWith$default(entry.getSectionNumber(), "g_", false, 2, (Object) null)) {
            Iterator<T> it = rulesActivity.rules.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((RuleParagraph) next).getSectionNumber(), entry.getSectionNumber())) {
                    obj = next;
                    break;
                }
            }
            RuleParagraph ruleParagraph = (RuleParagraph) obj;
            if (ruleParagraph != null) {
                String str2 = ruleParagraph.getSectionNumber() + " " + ruleParagraph.getRulesText() + "\n";
                if (str2 != null) {
                    str = str2;
                }
            }
            return str;
        }
        String strSubstring = entry.getSectionNumber().substring(2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        Iterator<T> it2 = rulesActivity.glossary.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (Intrinsics.areEqual(((GlossaryEntry) next2).getKey(), strSubstring)) {
                obj = next2;
                break;
            }
        }
        GlossaryEntry glossaryEntry = (GlossaryEntry) obj;
        if (glossaryEntry != null) {
            String str3 = glossaryEntry.getKey() + " - " + glossaryEntry.getValue() + "\n";
            if (str3 != null) {
                str = str3;
            }
        }
        return str;
    }

    static final Unit onCreate$lambda$3(ConstraintLayout constraintLayout, final RulesActivity rulesActivity) {
        constraintLayout.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.finish();
            }
        }, 150L);
        return Unit.INSTANCE;
    }

    static final boolean onCreate$lambda$4(RulesActivity rulesActivity, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        Object systemService = rulesActivity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
        return true;
    }

    static final boolean onCreate$lambda$5(EditText editText, RulesActivity rulesActivity, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 || editText.getCompoundDrawables()[2] == null) {
            return false;
        }
        if (rulesActivity.isDestroyed()) {
            return true;
        }
        if (motionEvent.getRawX() < editText.getRight() - (editText.getCompoundDrawables()[2].getBounds().width() * 2.0f)) {
            return false;
        }
        editText.setText("");
        rulesActivity.lastQuery = "";
        editText.requestFocus();
        Object systemService = rulesActivity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        return true;
    }

    static final void onCreate$lambda$6(RulesActivity rulesActivity, View view) {
        PopupWindow popupWindow = rulesActivity.popupWindow;
        if (popupWindow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupWindow");
            popupWindow = null;
        }
        popupWindow.showAsDropDown(view);
    }

    static final boolean onCreate$lambda$7(RulesActivity rulesActivity, DrawerLayout drawerLayout, LinearLayoutManager linearLayoutManager, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        rulesActivity.isDestroyed();
        Breadcrumbs.INSTANCE.leaveBreadcrumb("rules_menu_open");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(rulesActivity);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        Object obj = null;
        firebaseAnalytics.logEvent("rules_menu_open", null);
        View actionView = menuItem.getActionView();
        if (actionView != null) {
            CharSequence text = ((TextView) actionView.findViewById(R.id.menu_item_text)).getText();
            Intrinsics.checkNotNull(text);
            List listSplit$default = StringsKt.split$default(text, new String[]{" "}, false, 0, 6, (Object) null);
            if (!listSplit$default.isEmpty()) {
                String str = (String) CollectionsKt.first(listSplit$default);
                Iterator<T> it = rulesActivity.entries.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(((RuleObject) next).getSectionNumber(), str)) {
                        obj = next;
                        break;
                    }
                }
                RuleObject ruleObject = (RuleObject) obj;
                if (ruleObject != null) {
                    linearLayoutManager.scrollToPositionWithOffset(rulesActivity.entries.indexOf(ruleObject), 0);
                }
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    static final Unit onCreate$lambda$8(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return Unit.INSTANCE;
    }

    private final void openWebActivity(String url) {
        if (isDestroyed()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this, (Class<?>) WebActivity.class);
        intent2.setFlags(603979776);
        intent2.putExtra("url", url);
        startActivity(intent2);
    }

    private final void showBottomSheetCardInfo(final CardRecord cardRecord) {
        if (isDestroyed()) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("rules_show_card");
        RulesActivity rulesActivity = this;
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(rulesActivity);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("rules_show_card", null);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(rulesActivity, R.style.TransparentBottomSheetDialog);
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        bottomSheetDialog.setContentView(R.layout.card_list_view);
        final LoadingImageView loadingImageView = (LoadingImageView) bottomSheetDialog.findViewById(R.id.cardImage);
        TextView textView = (TextView) bottomSheetDialog.findViewById(R.id.titleLabel);
        TextView textView2 = (TextView) bottomSheetDialog.findViewById(R.id.typeLabel);
        TextView textView3 = (TextView) bottomSheetDialog.findViewById(R.id.manaCostLabel);
        TextView textView4 = (TextView) bottomSheetDialog.findViewById(R.id.oracleTextView);
        final TextView textView5 = (TextView) bottomSheetDialog.findViewById(R.id.priceLabel);
        TextView textView6 = (TextView) bottomSheetDialog.findViewById(R.id.bottomText);
        ConstraintLayout constraintLayout = (ConstraintLayout) bottomSheetDialog.findViewById(R.id.bottomLayout);
        TextView textView7 = (TextView) bottomSheetDialog.findViewById(R.id.powerToughnessTextView);
        if (textView != null) {
            textView.setVisibility(0);
        }
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        if (textView != null) {
            textView.setText(cardRecord.getTitle());
        }
        if (textView2 != null) {
            textView2.setText(cardRecord.getType_line());
        }
        SymbolToImage symbolToImage = new SymbolToImage(rulesActivity);
        String strReplace$default = StringsKt.replace$default(cardRecord.getMana_cost(), "}{", "} {", false, 4, (Object) null);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_smaller);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size_even_smaller);
        SpannableString spannableStringStringToAttributedStringWithSymbols = symbolToImage.stringToAttributedStringWithSymbols(strReplace$default, dimensionPixelSize, new CharacterStyle[0]);
        if (textView3 != null) {
            textView3.setText(spannableStringStringToAttributedStringWithSymbols);
        }
        SpannableString spannableStringStringToAttributedStringWithSymbols2 = symbolToImage.stringToAttributedStringWithSymbols(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(cardRecord.getOracle_text(), "\n", "\n\n", false, 4, (Object) null), "}:", "} :", false, 4, (Object) null), "}{", "} {", false, 4, (Object) null), dimensionPixelSize2, new ForegroundColorSpan(-3355444));
        if (textView4 != null) {
            textView4.setText(spannableStringStringToAttributedStringWithSymbols2);
        }
        if (loadingImageView != null) {
            loadingImageView.setAutoLoad(false);
        }
        if (loadingImageView != null) {
            String lowerCase = cardRecord.getSet().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            loadingImageView.setAlpha(Intrinsics.areEqual(lowerCase, "lea"));
        }
        if (loadingImageView != null) {
            loadingImageView.reset();
        }
        if (cardRecord.getInt_field_1().length() > 0 && cardRecord.getInt_field_2().length() > 0) {
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            if (textView7 != null) {
                textView7.setText(cardRecord.getInt_field_1() + " / " + cardRecord.getInt_field_2());
            }
        } else if (cardRecord.getInt_field_1().length() > 0) {
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            String lowerCase2 = cardRecord.getType_line().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "planeswalker", false, 2, (Object) null)) {
                if (textView6 != null) {
                    textView6.setText(getResources().getString(R.string.loyalty));
                }
            } else if (textView6 != null) {
                textView6.setText(getResources().getString(R.string.defense));
            }
            if (textView7 != null) {
                textView7.setText(cardRecord.getInt_field_1());
            }
        } else {
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
        }
        MTApiKt.getMtApi().getCardByScryfallId(cardRecord.getScryfall_id()).enqueue(new Callback<MTCardResponse>() { // from class: com.studiolaganne.lengendarylens.RulesActivity.showBottomSheetCardInfo.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                System.out.println((Object) ("Error: " + t.getMessage()));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardResponse> call, Response<MTCardResponse> response) {
                LoadingImageView loadingImageView2;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isSuccessful() || RulesActivity.this.isDestroyed()) {
                    return;
                }
                MTCardResponse mTCardResponseBody = response.body();
                MTFullCard card = mTCardResponseBody != null ? mTCardResponseBody.getCard() : null;
                if (card != null) {
                    TextView textView8 = textView5;
                    if (textView8 != null) {
                        textView8.setVisibility(8);
                    }
                    PreferencesManager preferencesManager = new PreferencesManager(RulesActivity.this);
                    String price = GameUtils.INSTANCE.getInstance().formatPrice(GameUtils.INSTANCE.getInstance().getCardPrice(card, preferencesManager.getPreferredMarket()), preferencesManager.getPreferredCurrency());
                    if (price.length() > 0) {
                        TextView textView9 = textView5;
                        if (textView9 != null) {
                            textView9.setVisibility(0);
                        }
                        TextView textView10 = textView5;
                        if (textView10 != null) {
                            textView10.setText(price);
                        }
                    }
                    String imageUrl = card.getImageUrl(cardRecord.getFace());
                    if (imageUrl.length() <= 0 || (loadingImageView2 = loadingImageView) == null) {
                        return;
                    }
                    loadingImageView2.loadImage(imageUrl);
                }
            }
        });
        bottomSheetDialog.show();
    }

    private final void showCopyButtonAnimated() {
        final MaterialButton materialButton = (MaterialButton) findViewById(R.id.copy_button);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.copyLayout);
        linearLayout.getLayoutParams().height = 0;
        materialButton.setAlpha(0.0f);
        linearLayout.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                linearLayout.setVisibility(0);
            }
        });
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, dpToPx(80, this));
        valueAnimatorOfInt.setDuration(350L);
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RulesActivity.showCopyButtonAnimated$lambda$1$0(linearLayout, valueAnimator);
            }
        });
        valueAnimatorOfInt.start();
        final ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RulesActivity.showCopyButtonAnimated$lambda$2$0(materialButton, valueAnimator);
            }
        });
        linearLayout.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                valueAnimatorOfFloat.start();
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCopyButtonAnimated$lambda$1$0(LinearLayout linearLayout, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        linearLayout.getLayoutParams().height = ((Integer) animatedValue).intValue();
        linearLayout.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCopyButtonAnimated$lambda$2$0(MaterialButton materialButton, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        materialButton.setAlpha(((Float) animatedValue).floatValue());
    }

    public final int dpToPx(int dp, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x01e5  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.studiolaganne.lengendarylens.RuleParagraphCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void linkClicked(String value) {
        Object next;
        Object objValueOf;
        String value2 = value;
        Intrinsics.checkNotNullParameter(value2, "value");
        if (isDestroyed()) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("rules_link_click");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("rules_link_click", null);
        MTGDBHelperLocalized mTGDBHelperLocalized = this.cardsDBHelperLocalized;
        if (mTGDBHelperLocalized != null) {
            List<CardRecord> cardsByTitle = mTGDBHelperLocalized.getCardsByTitle(value2);
            if (!cardsByTitle.isEmpty()) {
                showBottomSheetCardInfo((CardRecord) CollectionsKt.first((List) cardsByTitle));
                return;
            }
        }
        MTGDBHelper mTGDBHelper = this.cardsDBHelper;
        if (mTGDBHelper != null) {
            List<CardRecord> cardsByTitle2 = mTGDBHelper.getCardsByTitle(value2);
            if (!cardsByTitle2.isEmpty()) {
                showBottomSheetCardInfo((CardRecord) CollectionsKt.first((List) cardsByTitle2));
                return;
            }
        }
        String str = value2;
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                value2 = ((Object) value2) + ".";
                break;
            } else if (!Character.isDigit(str.charAt(i))) {
                break;
            } else {
                i++;
            }
        }
        String str2 = value2;
        Object objFirst = value2;
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "-", false, 2, (Object) null)) {
            objFirst = value2;
            if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) ".com", false, 2, (Object) null)) {
                List listSplit$default = StringsKt.split$default((CharSequence) str2, new String[]{"-"}, false, 0, 6, (Object) null);
                objFirst = value2;
                if (!listSplit$default.isEmpty()) {
                    objFirst = CollectionsKt.first((List<? extends Object>) listSplit$default);
                }
            }
        }
        CharSequence charSequence = (CharSequence) objFirst;
        Object objFirst2 = objFirst;
        if (StringsKt.contains$default(charSequence, (CharSequence) "–", false, 2, (Object) null)) {
            objFirst2 = objFirst;
            if (!StringsKt.contains$default(charSequence, (CharSequence) ".com", false, 2, (Object) null)) {
                List listSplit$default2 = StringsKt.split$default(charSequence, new String[]{"–"}, false, 0, 6, (Object) null);
                objFirst2 = objFirst;
                if (!listSplit$default2.isEmpty()) {
                    objFirst2 = CollectionsKt.first((List<? extends Object>) listSplit$default2);
                }
            }
        }
        Iterator<T> it = this.entries.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((RuleObject) next).getSectionNumber(), objFirst2)) {
                    break;
                }
            }
        }
        RuleObject ruleObject = (RuleObject) next;
        if (ruleObject != null) {
            final int iIndexOf = this.entries.indexOf(ruleObject);
            if (this.lastQuery.length() > 0) {
                ((EditText) findViewById(R.id.filterEditText)).setText("");
                this.lastQuery = "";
                if (this.selectionCount > 0) {
                    this.selectionCount = 0;
                    hideCopyButtonAnimated();
                    Iterator<T> it2 = this.entries.iterator();
                    while (it2.hasNext()) {
                        ((RuleObject) it2.next()).setSelected(false);
                    }
                }
                RulesAdapter rulesAdapter = new RulesAdapter(this.symbolToImage, CollectionsKt.toList(this.entries), this.sections, this.rules, this.glossary, this);
                final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rulesRecyclerView);
                recyclerView.setAdapter(rulesAdapter);
                objValueOf = Boolean.valueOf(recyclerView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        RulesActivity.linkClicked$lambda$4$1(recyclerView, iIndexOf);
                    }
                }, 250L));
            } else {
                RecyclerView.LayoutManager layoutManager = ((RecyclerView) findViewById(R.id.rulesRecyclerView)).getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager != null) {
                    linearLayoutManager.scrollToPositionWithOffset(iIndexOf, 0);
                    objValueOf = Unit.INSTANCE;
                } else {
                    objValueOf = null;
                }
            }
            if (objValueOf != null) {
                return;
            }
        }
        String str3 = (String) objFirst2;
        String lowerCase = str3.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) ".com", false, 2, (Object) null)) {
            String lowerCase2 = str3.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) ".net", false, 2, (Object) null)) {
                if (!StringsKt.startsWith$default(str3, ProxyConfig.MATCH_HTTP, false, 2, (Object) null)) {
                    str3 = "https://" + str3;
                }
                openWebActivity(str3);
            }
        }
        Unit unit = Unit.INSTANCE;
    }

    public final Object loadData(String str, Continuation<? super Unit> continuation) {
        if (Intrinsics.areEqual(str, "en")) {
            this.lang = "en";
            RulesActivity rulesActivity = this;
            RulesDBHelper companion = RulesDBHelper.INSTANCE.getInstance(rulesActivity);
            GlossaryDBHelper companion2 = GlossaryDBHelper.INSTANCE.getInstance(rulesActivity);
            this.sections = companion.getRuleSections();
            this.rules = companion.getRules();
            this.glossary = companion2.getGlossaryEntries();
        } else {
            this.lang = "fr";
            RulesActivity rulesActivity2 = this;
            RulesDBHelperLocalized companion3 = RulesDBHelperLocalized.INSTANCE.getInstance(rulesActivity2, str);
            GlossaryDBHelperLocalized companion4 = GlossaryDBHelperLocalized.INSTANCE.getInstance(rulesActivity2, str);
            this.sections = companion3.getRuleSections();
            this.rules = companion3.getRules();
            this.glossary = companion4.getGlossaryEntries();
            this.cardsDBHelperLocalized = MTGDBHelperLocalized.INSTANCE.getInstance(rulesActivity2, this.lang);
        }
        return Unit.INSTANCE;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((LinearLayout) findViewById(R.id.copyLayout)).setVisibility(8);
    }

    @Override // com.studiolaganne.lengendarylens.CardLanguageClickListener
    public void onCardLanguageClick(String newScId, String oracleId, String title, String language, String typeLine, String oracle) {
        Intrinsics.checkNotNullParameter(newScId, "newScId");
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(typeLine, "typeLine");
        Intrinsics.checkNotNullParameter(oracle, "oracle");
        if (isDestroyed()) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("rules_language_switch");
        RulesActivity rulesActivity = this;
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(rulesActivity);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        PopupWindow popupWindow = null;
        firebaseAnalytics.logEvent("rules_language_switch", null);
        this.lang = language;
        if (Intrinsics.areEqual(language, "en")) {
            RulesDBHelper companion = RulesDBHelper.INSTANCE.getInstance(rulesActivity);
            GlossaryDBHelper companion2 = GlossaryDBHelper.INSTANCE.getInstance(rulesActivity);
            this.sections = companion.getRuleSections();
            this.rules = companion.getRules();
            this.glossary = companion2.getGlossaryEntries();
            for (RuleParagraph ruleParagraph : this.rules) {
                ruleParagraph.setRulesTextFolded(ruleParagraph.getRulesText());
            }
            for (GlossaryEntry glossaryEntry : this.glossary) {
                glossaryEntry.setFoldedKey(glossaryEntry.getKey());
                glossaryEntry.setFoldedValue(glossaryEntry.getValue());
            }
        } else {
            RulesDBHelperLocalized companion3 = RulesDBHelperLocalized.INSTANCE.getInstance(rulesActivity, language);
            GlossaryDBHelperLocalized companion4 = GlossaryDBHelperLocalized.INSTANCE.getInstance(rulesActivity, language);
            this.sections = companion3.getRuleSections();
            this.rules = companion3.getRules();
            this.glossary = companion4.getGlossaryEntries();
            for (RuleParagraph ruleParagraph2 : this.rules) {
                String rulesText = ruleParagraph2.getRulesText();
                Locale localeForLanguageTag = Locale.forLanguageTag(language);
                Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
                ruleParagraph2.setRulesTextFolded(UtilsKt.removeDiacritics(rulesText, localeForLanguageTag));
            }
            for (GlossaryEntry glossaryEntry2 : this.glossary) {
                String key = glossaryEntry2.getKey();
                Locale localeForLanguageTag2 = Locale.forLanguageTag(language);
                Intrinsics.checkNotNullExpressionValue(localeForLanguageTag2, "forLanguageTag(...)");
                glossaryEntry2.setFoldedKey(UtilsKt.removeDiacritics(key, localeForLanguageTag2));
                String value = glossaryEntry2.getValue();
                Locale localeForLanguageTag3 = Locale.forLanguageTag(language);
                Intrinsics.checkNotNullExpressionValue(localeForLanguageTag3, "forLanguageTag(...)");
                glossaryEntry2.setFoldedValue(UtilsKt.removeDiacritics(value, localeForLanguageTag3));
            }
            this.cardsDBHelperLocalized = MTGDBHelperLocalized.INSTANCE.getInstance(rulesActivity, language);
        }
        PreferencesManager preferencesManager = new PreferencesManager(rulesActivity);
        preferencesManager.setString(PreferencesManager.LAST_RULEBOOK_LANGUAGE, language);
        PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
        ImageView imageView = (ImageView) findViewById(R.id.flag_image);
        int identifier = getResources().getIdentifier("flag_" + language, "drawable", imageView.getContext().getPackageName());
        if (identifier != 0) {
            imageView.setImageResource(identifier);
        }
        loadItems();
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupWindow");
        } else {
            popupWindow = popupWindow2;
        }
        popupWindow.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.String] */
    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String effectiveDate;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        String stringExtra = getIntent().getStringExtra("section");
        if (stringExtra != null && stringExtra.length() > 0) {
            this.sectionNumberToDisplay = stringExtra;
        }
        RulesActivity rulesActivity = this;
        PreferencesManager preferencesManager = new PreferencesManager(rulesActivity);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = preferencesManager.getDeviceLanguage();
        if (!Intrinsics.areEqual(objectRef.element, "fr")) {
            objectRef.element = "en";
        }
        ?? string = preferencesManager.getString(PreferencesManager.LAST_RULEBOOK_LANGUAGE, "");
        if (((CharSequence) string).length() > 0) {
            objectRef.element = string;
        }
        ImageView imageView = (ImageView) findViewById(R.id.flag_image);
        int identifier = getResources().getIdentifier("flag_" + objectRef.element, "drawable", imageView.getContext().getPackageName());
        if (identifier != 0) {
            imageView.setImageResource(identifier);
        }
        this.cardsDBHelper = MTGDBHelper.INSTANCE.getInstance(rulesActivity);
        PopupWindow popupWindow = null;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass2(objectRef, null), 3, null);
        this.symbolToImage = new SymbolToImage(rulesActivity);
        TextView textView = (TextView) findViewById(R.id.effectiveDateTextView);
        textView.setVisibility(8);
        String effectiveDate2 = Intrinsics.areEqual(objectRef.element, "fr") ? RulesDBHelperLocalized.INSTANCE.getInstance(rulesActivity, (String) objectRef.element).getEffectiveDate() : RulesDBHelper.INSTANCE.getInstance(rulesActivity).getEffectiveDate();
        if (effectiveDate2 != null && (effectiveDate = formatEffectiveDate(effectiveDate2, preferencesManager.getDeviceLanguage())) != null) {
            String string2 = getString(R.string.rules_effective_as_of, new Object[]{effectiveDate});
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            textView.setText(string2);
            textView.setVisibility(0);
        }
        MaterialButton materialButton = (MaterialButton) findViewById(R.id.copy_button);
        Intrinsics.checkNotNull(materialButton);
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RulesActivity.onCreate$lambda$2(this.f$0);
            }
        });
        final ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.close_button);
        Intrinsics.checkNotNull(constraintLayout);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RulesActivity.onCreate$lambda$3(constraintLayout, this);
            }
        });
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rulesRecyclerView);
        final EditText editText = (EditText) findViewById(R.id.filterEditText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda13
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                return RulesActivity.onCreate$lambda$4(this.f$0, textView2, i, keyEvent);
            }
        });
        editText.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return RulesActivity.onCreate$lambda$5(editText, this, view, motionEvent);
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.RulesActivity.onCreate.8
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ArrayList arrayList;
                if (s == null || s.length() <= 0) {
                    editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {
                    editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_clear, 0);
                }
                this.lastQuery = String.valueOf(s);
                int length = this.lastQuery.length();
                RulesActivity rulesActivity2 = this;
                if (length == 0) {
                    if (rulesActivity2.selectionCount > 0) {
                        this.selectionCount = 0;
                        this.hideCopyButtonAnimated();
                        Iterator it = this.entries.iterator();
                        while (it.hasNext()) {
                            ((RuleObject) it.next()).setSelected(false);
                        }
                    }
                    recyclerView.setAdapter(new RulesAdapter(this.symbolToImage, CollectionsKt.toList(this.entries), this.sections, this.rules, this.glossary, this));
                    return;
                }
                String lowerCase = rulesActivity2.lastQuery.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                List<String> listSplit = new Regex("[\\s-,]+").split(lowerCase, 0);
                if (Intrinsics.areEqual(this.lang, "en")) {
                    arrayList = listSplit;
                } else {
                    List<String> list = listSplit;
                    RulesActivity rulesActivity3 = this;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (String str : list) {
                        Locale localeForLanguageTag = Locale.forLanguageTag(rulesActivity3.lang);
                        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
                        arrayList2.add(UtilsKt.removeDiacritics(str, localeForLanguageTag));
                    }
                    arrayList = arrayList2;
                }
                List list2 = this.rules;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : list2) {
                    RuleParagraph ruleParagraph = (RuleParagraph) obj;
                    Iterator<String> it2 = arrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            arrayList3.add(obj);
                            break;
                        }
                        String next = it2.next();
                        String lowerCase2 = ruleParagraph.getRulesTextFolded().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        String str2 = next;
                        if (!StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) str2, false, 2, (Object) null)) {
                            String lowerCase3 = ruleParagraph.getSectionNumber().toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                            if (!StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) str2, false, 2, (Object) null)) {
                                break;
                            }
                        }
                    }
                }
                ArrayList arrayList4 = arrayList3;
                List list3 = this.glossary;
                ArrayList arrayList5 = new ArrayList();
                for (Object obj2 : list3) {
                    GlossaryEntry glossaryEntry = (GlossaryEntry) obj2;
                    Iterator<String> it3 = listSplit.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            arrayList5.add(obj2);
                            break;
                        }
                        String next2 = it3.next();
                        String lowerCase4 = glossaryEntry.getFoldedValue().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                        String str3 = next2;
                        if (!StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) str3, false, 2, (Object) null)) {
                            String lowerCase5 = glossaryEntry.getFoldedKey().toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                            if (!StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) str3, false, 2, (Object) null)) {
                                break;
                            }
                        }
                    }
                }
                ArrayList arrayList6 = arrayList5;
                ArrayList arrayList7 = new ArrayList();
                ArrayList arrayList8 = new ArrayList();
                Iterator it4 = arrayList4.iterator();
                int i = 0;
                while (it4.hasNext()) {
                    arrayList8.add(new RuleObject(2, i, ((RuleParagraph) it4.next()).getSectionNumber(), false, 8, null));
                    i++;
                }
                Iterator it5 = arrayList6.iterator();
                int i2 = 0;
                while (it5.hasNext()) {
                    arrayList8.add(new RuleObject(3, i2, "g_" + ((GlossaryEntry) it5.next()).getKey(), false, 8, null));
                    i2++;
                }
                if (this.selectionCount > 0) {
                    this.selectionCount = 0;
                    this.hideCopyButtonAnimated();
                    Iterator it6 = this.entries.iterator();
                    while (it6.hasNext()) {
                        ((RuleObject) it6.next()).setSelected(false);
                    }
                }
                recyclerView.setAdapter(new RulesAdapter(this.symbolToImage, arrayList8, arrayList7, arrayList4, arrayList6, this));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        View viewInflate = getLayoutInflater().inflate(R.layout.popup_language_list, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        this.popupView = viewInflate;
        if (viewInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupView");
            viewInflate = null;
        }
        RecyclerView recyclerView2 = (RecyclerView) viewInflate.findViewById(R.id.language_recycler_view);
        recyclerView2.setLayoutManager(new LinearLayoutManager(rulesActivity));
        View view = this.popupView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupView");
            view = null;
        }
        PopupWindow popupWindow2 = new PopupWindow(view, -2, -2);
        this.popupWindow = popupWindow2;
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0));
        PopupWindow popupWindow3 = this.popupWindow;
        if (popupWindow3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupWindow");
        } else {
            popupWindow = popupWindow3;
        }
        popupWindow.setOutsideTouchable(true);
        ArrayList arrayList = new ArrayList();
        String string3 = getString(R.string.english);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        arrayList.add(new CardLanguageRow("en", string3, "", null, null, null, 56, null));
        String string4 = getString(R.string.french);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        arrayList.add(new CardLanguageRow("fr", string4, "", null, null, null, 56, null));
        recyclerView2.setAdapter(new CardLanguageAdapter(arrayList, this));
        ((CardView) findViewById(R.id.flag_container)).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RulesActivity.onCreate$lambda$6(this.f$0, view2);
            }
        });
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rulesActivity);
        recyclerView.setLayoutManager(linearLayoutManager);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda16
            @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                return RulesActivity.onCreate$lambda$7(this.f$0, drawerLayout, linearLayoutManager, menuItem);
            }
        });
        View viewFindViewById = findViewById(R.id.menuImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.RulesActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RulesActivity.onCreate$lambda$8(drawerLayout);
            }
        });
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

    public final Object processData(String str, Continuation<? super Unit> continuation) {
        boolean zAreEqual = Intrinsics.areEqual(str, "en");
        List<RuleParagraph> list = this.rules;
        if (zAreEqual) {
            for (RuleParagraph ruleParagraph : list) {
                ruleParagraph.setRulesTextFolded(ruleParagraph.getRulesText());
            }
            for (GlossaryEntry glossaryEntry : this.glossary) {
                glossaryEntry.setFoldedKey(glossaryEntry.getKey());
                glossaryEntry.setFoldedValue(glossaryEntry.getValue());
            }
        } else {
            for (RuleParagraph ruleParagraph2 : list) {
                String rulesText = ruleParagraph2.getRulesText();
                Locale localeForLanguageTag = Locale.forLanguageTag(this.lang);
                Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
                ruleParagraph2.setRulesTextFolded(UtilsKt.removeDiacritics(rulesText, localeForLanguageTag));
            }
            for (GlossaryEntry glossaryEntry2 : this.glossary) {
                String key = glossaryEntry2.getKey();
                Locale localeForLanguageTag2 = Locale.forLanguageTag(this.lang);
                Intrinsics.checkNotNullExpressionValue(localeForLanguageTag2, "forLanguageTag(...)");
                glossaryEntry2.setFoldedKey(UtilsKt.removeDiacritics(key, localeForLanguageTag2));
                String value = glossaryEntry2.getValue();
                Locale localeForLanguageTag3 = Locale.forLanguageTag(this.lang);
                Intrinsics.checkNotNullExpressionValue(localeForLanguageTag3, "forLanguageTag(...)");
                glossaryEntry2.setFoldedValue(UtilsKt.removeDiacritics(value, localeForLanguageTag3));
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.studiolaganne.lengendarylens.RuleParagraphCallback
    public void selectionAdded(String sectionNumber) {
        Object next;
        Intrinsics.checkNotNullParameter(sectionNumber, "sectionNumber");
        if (isDestroyed()) {
            return;
        }
        Iterator<T> it = this.entries.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((RuleObject) next).getSectionNumber(), sectionNumber)) {
                    break;
                }
            }
        }
        RuleObject ruleObject = (RuleObject) next;
        if (ruleObject != null) {
            ruleObject.setSelected(true);
        }
        int i = this.selectionCount;
        this.selectionCount = i + 1;
        if (i == 0) {
            showCopyButtonAnimated();
        }
    }

    @Override // com.studiolaganne.lengendarylens.RuleParagraphCallback
    public void selectionRemoved(String sectionNumber) {
        Object next;
        Intrinsics.checkNotNullParameter(sectionNumber, "sectionNumber");
        if (!isDestroyed() && this.selectionCount > 0) {
            Iterator<T> it = this.entries.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((RuleObject) next).getSectionNumber(), sectionNumber)) {
                        break;
                    }
                }
            }
            RuleObject ruleObject = (RuleObject) next;
            if (ruleObject != null) {
                ruleObject.setSelected(false);
            }
            int i = this.selectionCount - 1;
            this.selectionCount = i;
            if (i == 0) {
                hideCopyButtonAnimated();
            }
        }
    }
}
