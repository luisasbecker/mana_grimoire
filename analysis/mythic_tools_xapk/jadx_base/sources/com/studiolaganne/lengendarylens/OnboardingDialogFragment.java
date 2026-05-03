package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: OnboardingDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/OnboardingDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "dotsIndicator", "Lcom/tbuonomo/viewpagerdotsindicator/WormDotsIndicator;", "closeImage", "Landroid/widget/ImageView;", "versionLabel", "Landroid/widget/TextView;", "adapter", "Lcom/studiolaganne/lengendarylens/OnboardingAdapter;", "pages", "", "Lcom/studiolaganne/lengendarylens/MTOnboardingPage;", "autoScrollJob", "Lkotlinx/coroutines/Job;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "onResume", "onDestroyView", "startAutoScroll", "stopAutoScroll", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OnboardingDialogFragment extends DialogFragment {
    public static final String ARG_PAGES = "ARG_PAGES";
    private OnboardingAdapter adapter;
    private Job autoScrollJob;
    private ImageView closeImage;
    private WormDotsIndicator dotsIndicator;
    private List<MTOnboardingPage> pages;
    private TextView versionLabel;
    private ViewPager2 viewPager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: OnboardingDialogFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/OnboardingDialogFragment$Companion;", "", "<init>", "()V", OnboardingDialogFragment.ARG_PAGES, "", "newInstance", "Lcom/studiolaganne/lengendarylens/OnboardingDialogFragment;", "pages", "", "Lcom/studiolaganne/lengendarylens/MTOnboardingPage;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OnboardingDialogFragment newInstance(List<MTOnboardingPage> pages) {
            Intrinsics.checkNotNullParameter(pages, "pages");
            OnboardingDialogFragment onboardingDialogFragment = new OnboardingDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(OnboardingDialogFragment.ARG_PAGES, new ArrayList<>(pages));
            onboardingDialogFragment.setArguments(bundle);
            return onboardingDialogFragment;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.OnboardingDialogFragment$startAutoScroll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OnboardingDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.OnboardingDialogFragment$startAutoScroll$1", f = "OnboardingDialogFragment.kt", i = {0}, l = {106}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
    static final class C12241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C12241(Continuation<? super C12241> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12241 c12241 = OnboardingDialogFragment.this.new C12241(continuation);
            c12241.L$0 = obj;
            return c12241;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0031 -> B:14:0x0034). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ViewPager2 viewPager2 = OnboardingDialogFragment.this.viewPager;
                ViewPager2 viewPager22 = null;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager2 = null;
                }
                int currentItem = viewPager2.getCurrentItem() + 1;
                List list = OnboardingDialogFragment.this.pages;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pages");
                    list = null;
                }
                int size = currentItem % list.size();
                ViewPager2 viewPager23 = OnboardingDialogFragment.this.viewPager;
                if (viewPager23 != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                } else {
                    viewPager22 = viewPager23;
                }
                viewPager22.setCurrentItem(size, true);
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    if (DelayKt.delay(5000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ViewPager2 viewPager24 = OnboardingDialogFragment.this.viewPager;
                    ViewPager2 viewPager222 = null;
                    if (viewPager24 == null) {
                    }
                    int currentItem2 = viewPager24.getCurrentItem() + 1;
                    List list2 = OnboardingDialogFragment.this.pages;
                    if (list2 == null) {
                    }
                    int size2 = currentItem2 % list2.size();
                    ViewPager2 viewPager232 = OnboardingDialogFragment.this.viewPager;
                    if (viewPager232 != null) {
                    }
                    viewPager222.setCurrentItem(size2, true);
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }

    static final Unit onViewCreated$lambda$0(OnboardingDialogFragment onboardingDialogFragment) {
        onboardingDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    private final void startAutoScroll() {
        this.autoScrollJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C12241(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopAutoScroll() {
        Job job = this.autoScrollJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_onboarding, container, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        stopAutoScroll();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), (int) (((double) getResources().getDisplayMetrics().heightPixels) * 0.8d));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        ArrayList parcelableArrayList;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        this.pages = (arguments == null || (parcelableArrayList = arguments.getParcelableArrayList(ARG_PAGES)) == null) ? CollectionsKt.emptyList() : parcelableArrayList;
        View viewFindViewById = view.findViewById(R.id.onboarding_viewpager);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.viewPager = (ViewPager2) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.dots_indicator);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.dotsIndicator = (WormDotsIndicator) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.close_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.closeImage = (ImageView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.onboarding_version);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.versionLabel = (TextView) viewFindViewById4;
        List<MTOnboardingPage> list = this.pages;
        TextView textView = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pages");
            list = null;
        }
        this.adapter = new OnboardingAdapter(list);
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        OnboardingAdapter onboardingAdapter = this.adapter;
        if (onboardingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            onboardingAdapter = null;
        }
        viewPager2.setAdapter(onboardingAdapter);
        WormDotsIndicator wormDotsIndicator = this.dotsIndicator;
        if (wormDotsIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dotsIndicator");
            wormDotsIndicator = null;
        }
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager22 = null;
        }
        wormDotsIndicator.setViewPager2(viewPager22);
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager23 = null;
        }
        viewPager23.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.studiolaganne.lengendarylens.OnboardingDialogFragment.onViewCreated.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int state) {
                if (state == 1) {
                    OnboardingDialogFragment.this.stopAutoScroll();
                }
            }
        });
        ImageView imageView = this.closeImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeImage");
            imageView = null;
        }
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.OnboardingDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return OnboardingDialogFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        String appVersion = MTApiKt.getAppVersion();
        TextView textView2 = this.versionLabel;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("versionLabel");
        } else {
            textView = textView2;
        }
        textView.setText("Mythic Tools v" + appVersion);
        startAutoScroll();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
    }
}
