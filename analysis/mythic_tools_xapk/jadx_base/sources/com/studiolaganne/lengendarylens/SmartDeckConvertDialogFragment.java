package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: SmartDeckConvertDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0006H\u0002J\b\u0010'\u001a\u00020\u0006H\u0002R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/studiolaganne/lengendarylens/SmartDeckConvertDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onConvert", "Lkotlin/Function0;", "", "getOnConvert", "()Lkotlin/jvm/functions/Function0;", "setOnConvert", "(Lkotlin/jvm/functions/Function0;)V", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "dotsIndicator", "Lcom/tbuonomo/viewpagerdotsindicator/WormDotsIndicator;", "slideTitleText", "Landroid/widget/TextView;", "slideSubtitleText", "autoScrollJob", "Lkotlinx/coroutines/Job;", "slides", "", "Lcom/studiolaganne/lengendarylens/SmartDeckConvertDialogFragment$Slide;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "onStart", "onDestroyView", "updateSlideLabels", "position", "", "startAutoScroll", "stopAutoScroll", "Slide", "SmartDeckPagerAdapter", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SmartDeckConvertDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private Job autoScrollJob;
    private WormDotsIndicator dotsIndicator;
    private Function0<Unit> onConvert;
    private TextView slideSubtitleText;
    private TextView slideTitleText;
    private final List<Slide> slides = CollectionsKt.listOf((Object[]) new Slide[]{new Slide(R.drawable.pager_main1, R.string.smart_deck_slide1_title, R.string.smart_deck_slide1_subtitle), new Slide(R.drawable.pager_main2, R.string.smart_deck_slide2_title, R.string.smart_deck_slide2_subtitle), new Slide(R.drawable.pager_main3, R.string.smart_deck_slide3_title, R.string.smart_deck_slide3_subtitle)});
    private ViewPager2 viewPager;

    /* JADX INFO: compiled from: SmartDeckConvertDialogFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/SmartDeckConvertDialogFragment$Slide;", "", "drawableRes", "", "titleRes", "subtitleRes", "<init>", "(III)V", "getDrawableRes", "()I", "getTitleRes", "getSubtitleRes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class Slide {
        private final int drawableRes;
        private final int subtitleRes;
        private final int titleRes;

        public Slide(int i, int i2, int i3) {
            this.drawableRes = i;
            this.titleRes = i2;
            this.subtitleRes = i3;
        }

        public static /* synthetic */ Slide copy$default(Slide slide, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = slide.drawableRes;
            }
            if ((i4 & 2) != 0) {
                i2 = slide.titleRes;
            }
            if ((i4 & 4) != 0) {
                i3 = slide.subtitleRes;
            }
            return slide.copy(i, i2, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getDrawableRes() {
            return this.drawableRes;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTitleRes() {
            return this.titleRes;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getSubtitleRes() {
            return this.subtitleRes;
        }

        public final Slide copy(int drawableRes, int titleRes, int subtitleRes) {
            return new Slide(drawableRes, titleRes, subtitleRes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Slide)) {
                return false;
            }
            Slide slide = (Slide) other;
            return this.drawableRes == slide.drawableRes && this.titleRes == slide.titleRes && this.subtitleRes == slide.subtitleRes;
        }

        public final int getDrawableRes() {
            return this.drawableRes;
        }

        public final int getSubtitleRes() {
            return this.subtitleRes;
        }

        public final int getTitleRes() {
            return this.titleRes;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.drawableRes) * 31) + Integer.hashCode(this.titleRes)) * 31) + Integer.hashCode(this.subtitleRes);
        }

        public String toString() {
            return "Slide(drawableRes=" + this.drawableRes + ", titleRes=" + this.titleRes + ", subtitleRes=" + this.subtitleRes + ")";
        }
    }

    /* JADX INFO: compiled from: SmartDeckConvertDialogFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/SmartDeckConvertDialogFragment$SmartDeckPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/SmartDeckConvertDialogFragment$SmartDeckPagerAdapter$SlideViewHolder;", "slides", "", "Lcom/studiolaganne/lengendarylens/SmartDeckConvertDialogFragment$Slide;", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "SlideViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class SmartDeckPagerAdapter extends RecyclerView.Adapter<SlideViewHolder> {
        private final List<Slide> slides;

        /* JADX INFO: compiled from: SmartDeckConvertDialogFragment.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/SmartDeckConvertDialogFragment$SmartDeckPagerAdapter$SlideViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "imageView", "Landroid/widget/ImageView;", "<init>", "(Landroid/widget/ImageView;)V", "getImageView", "()Landroid/widget/ImageView;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class SlideViewHolder extends RecyclerView.ViewHolder {
            public static final int $stable = 8;
            private final ImageView imageView;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SlideViewHolder(ImageView imageView) {
                super(imageView);
                Intrinsics.checkNotNullParameter(imageView, "imageView");
                this.imageView = imageView;
            }

            public final ImageView getImageView() {
                return this.imageView;
            }
        }

        public SmartDeckPagerAdapter(List<Slide> slides) {
            Intrinsics.checkNotNullParameter(slides, "slides");
            this.slides = slides;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.slides.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(SlideViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.getImageView().setImageResource(this.slides.get(position).getDrawableRes());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public SlideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ImageView imageView = new ImageView(parent.getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClipToOutline(true);
            return new SlideViewHolder(imageView);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.SmartDeckConvertDialogFragment$startAutoScroll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SmartDeckConvertDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.SmartDeckConvertDialogFragment$startAutoScroll$1", f = "SmartDeckConvertDialogFragment.kt", i = {0}, l = {111}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
    static final class C12571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C12571(Continuation<? super C12571> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12571 c12571 = SmartDeckConvertDialogFragment.this.new C12571(continuation);
            c12571.L$0 = obj;
            return c12571;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
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
                ViewPager2 viewPager2 = SmartDeckConvertDialogFragment.this.viewPager;
                ViewPager2 viewPager22 = null;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager2 = null;
                }
                int currentItem = (viewPager2.getCurrentItem() + 1) % SmartDeckConvertDialogFragment.this.slides.size();
                ViewPager2 viewPager23 = SmartDeckConvertDialogFragment.this.viewPager;
                if (viewPager23 != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                } else {
                    viewPager22 = viewPager23;
                }
                viewPager22.setCurrentItem(currentItem, true);
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    if (DelayKt.delay(3500L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ViewPager2 viewPager24 = SmartDeckConvertDialogFragment.this.viewPager;
                    ViewPager2 viewPager222 = null;
                    if (viewPager24 == null) {
                    }
                    int currentItem2 = (viewPager24.getCurrentItem() + 1) % SmartDeckConvertDialogFragment.this.slides.size();
                    ViewPager2 viewPager232 = SmartDeckConvertDialogFragment.this.viewPager;
                    if (viewPager232 != null) {
                    }
                    viewPager222.setCurrentItem(currentItem2, true);
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }

    static final Unit onViewCreated$lambda$0(SmartDeckConvertDialogFragment smartDeckConvertDialogFragment) {
        smartDeckConvertDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$1(SmartDeckConvertDialogFragment smartDeckConvertDialogFragment) {
        smartDeckConvertDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$2(SmartDeckConvertDialogFragment smartDeckConvertDialogFragment) {
        smartDeckConvertDialogFragment.dismiss();
        Function0<Unit> function0 = smartDeckConvertDialogFragment.onConvert;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private final void startAutoScroll() {
        this.autoScrollJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C12571(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopAutoScroll() {
        Job job = this.autoScrollJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.autoScrollJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSlideLabels(int position) {
        if (position >= this.slides.size()) {
            return;
        }
        TextView textView = this.slideTitleText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slideTitleText");
            textView = null;
        }
        textView.setText(getString(this.slides.get(position).getTitleRes()));
        TextView textView3 = this.slideSubtitleText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slideSubtitleText");
        } else {
            textView2 = textView3;
        }
        textView2.setText(getString(this.slides.get(position).getSubtitleRes()));
    }

    public final Function0<Unit> getOnConvert() {
        return this.onConvert;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_smart_deck_convert, container, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        stopAutoScroll();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        int i = getResources().getDisplayMetrics().widthPixels;
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        window.setLayout(Math.min((int) (((double) i) * 0.95d), companion.dpToPx(420, contextRequireContext)), -2);
        window.setDimAmount(0.65f);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.smart_deck_pager);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.viewPager = (ViewPager2) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.smart_deck_dots);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.dotsIndicator = (WormDotsIndicator) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.smart_deck_slide_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.slideTitleText = (TextView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.smart_deck_slide_subtitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.slideSubtitleText = (TextView) viewFindViewById4;
        ViewPager2 viewPager2 = this.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setAdapter(new SmartDeckPagerAdapter(this.slides));
        WormDotsIndicator wormDotsIndicator = this.dotsIndicator;
        if (wormDotsIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dotsIndicator");
            wormDotsIndicator = null;
        }
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager23 = null;
        }
        wormDotsIndicator.setViewPager2(viewPager23);
        updateSlideLabels(0);
        ViewPager2 viewPager24 = this.viewPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager22 = viewPager24;
        }
        viewPager22.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.studiolaganne.lengendarylens.SmartDeckConvertDialogFragment.onViewCreated.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int state) {
                if (state == 1) {
                    SmartDeckConvertDialogFragment.this.stopAutoScroll();
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                SmartDeckConvertDialogFragment.this.updateSlideLabels(position);
            }
        });
        ((TextView) view.findViewById(R.id.smart_deck_warning)).setText("⚠️ " + getString(R.string.smart_deck_confirm_warning));
        View viewFindViewById5 = view.findViewById(R.id.smart_deck_close);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById5, new Function0() { // from class: com.studiolaganne.lengendarylens.SmartDeckConvertDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SmartDeckConvertDialogFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        View viewFindViewById6 = view.findViewById(R.id.smart_deck_cancel_btn);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById6, new Function0() { // from class: com.studiolaganne.lengendarylens.SmartDeckConvertDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SmartDeckConvertDialogFragment.onViewCreated$lambda$1(this.f$0);
            }
        });
        View viewFindViewById7 = view.findViewById(R.id.smart_deck_convert_btn);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById7, new Function0() { // from class: com.studiolaganne.lengendarylens.SmartDeckConvertDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SmartDeckConvertDialogFragment.onViewCreated$lambda$2(this.f$0);
            }
        });
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        startAutoScroll();
    }

    public final void setOnConvert(Function0<Unit> function0) {
        this.onConvert = function0;
    }
}
