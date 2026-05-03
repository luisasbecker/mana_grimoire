package com.studiolaganne.lengendarylens;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.revenuecat.purchases.common.Constants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CmdAssignView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u00109\u001a\u00020:J\b\u0010;\u001a\u00020:H\u0002J\b\u0010<\u001a\u00020:H\u0002J\b\u0010=\u001a\u00020:H\u0002J\b\u0010>\u001a\u00020:H\u0002J\u0006\u0010?\u001a\u00020@J\u0010\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020\u0007H\u0002J\u0010\u0010C\u001a\u00020:2\u0006\u0010B\u001a\u00020\u0007H\u0002J\u0010\u0010D\u001a\u00020:2\u0006\u0010E\u001a\u00020\u0007H\u0002J\u0006\u0010F\u001a\u00020:J\u000e\u0010G\u001a\u00020:2\u0006\u0010H\u001a\u00020\u0007J:\u0010I\u001a\u00020:2\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020M2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010N\u001a\u0004\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010QJ\u0010\u0010R\u001a\u00020M2\u0006\u0010S\u001a\u00020MH\u0002J\b\u0010T\u001a\u00020:H\u0014J\b\u0010U\u001a\u00020:H\u0002J\b\u0010V\u001a\u00020:H\u0002J\b\u0010W\u001a\u00020:H\u0002J\b\u0010X\u001a\u00020:H\u0002J\b\u0010Y\u001a\u00020:H\u0002J\b\u0010Z\u001a\u00020:H\u0002J\b\u0010[\u001a\u00020:H\u0002J\b\u0010\\\u001a\u00020:H\u0002J\u0006\u0010]\u001a\u00020:J\u0010\u0010^\u001a\u00020\u00112\u0006\u0010_\u001a\u00020`H\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b/\u0010-R\u001e\u00100\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b1\u0010-R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/studiolaganne/lengendarylens/CmdAssignView;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callback", "Lcom/studiolaganne/lengendarylens/CmdAssignViewCallback;", "getCallback", "()Lcom/studiolaganne/lengendarylens/CmdAssignViewCallback;", "setCallback", "(Lcom/studiolaganne/lengendarylens/CmdAssignViewCallback;)V", "partners", "", "lifeTotalTextView", "Landroid/widget/TextView;", "increaseLifeTotal", "Landroid/widget/ImageView;", "decreaseLifeTotal", "playerNameTextView", "runningTotalTextViewUp", "runningTotalTextViewDown", "runningTotal", "runningTotalTimer", "Landroid/os/Handler;", "backgroundImage", "overlay", "Landroid/view/View;", "doubleValueLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "singleValueLayout", "lifeTotalTextViewLeft", "lifeTotalTextViewRight", "partnerName1TextView", "partnerName2TextView", "commanderNameTextView", "internalRotation", "hitLeft", "value", "intValue", "setIntValue", "(I)V", "leftValue", "setLeftValue", "rightValue", "setRightValue", "incrementRunnable", "Ljava/lang/Runnable;", "decrementRunnable", "handler", "increaseLifeTotalOnLongPress", "decreaseLifeTotalOnLongPress", "disabled", "disableInput", "", "startIncrementRunnable", "stopIncrementRunnable", "startDecrementRunnable", "stopDecrementRunnable", "textSize", "", "increaseLife", "amount", "decreaseLife", "updateRunningTotal", "delta", "updateTextSize", "setRotation", Key.ROTATION, "setState", "currentValue", "currentValue2", "playerName", "", "playmatImage", "Landroid/graphics/drawable/Drawable;", "player", "Lcom/studiolaganne/lengendarylens/Player;", "processCardName", "cardName", "onDetachedFromWindow", "animateTopHalf", "animateBottomHalf", "animateLeftHalf", "animateRightHalf", "animateTopLeftHalf", "animateBottomLeftHalf", "animateTopRightHalf", "animateBottomRightHalf", "addOneDamage", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CmdAssignView extends CardView {
    public static final int $stable = 8;
    private ImageView backgroundImage;
    private CmdAssignViewCallback callback;
    private TextView commanderNameTextView;
    private ImageView decreaseLifeTotal;
    private boolean decreaseLifeTotalOnLongPress;
    private Runnable decrementRunnable;
    private boolean disabled;
    private ConstraintLayout doubleValueLayout;
    private Handler handler;
    private boolean hitLeft;
    private ImageView increaseLifeTotal;
    private boolean increaseLifeTotalOnLongPress;
    private Runnable incrementRunnable;
    private int intValue;
    private int internalRotation;
    private int leftValue;
    private TextView lifeTotalTextView;
    private TextView lifeTotalTextViewLeft;
    private TextView lifeTotalTextViewRight;
    private View overlay;
    private TextView partnerName1TextView;
    private TextView partnerName2TextView;
    private boolean partners;
    private TextView playerNameTextView;
    private int rightValue;
    private int runningTotal;
    private TextView runningTotalTextViewDown;
    private TextView runningTotalTextViewUp;
    private Handler runningTotalTimer;
    private ConstraintLayout singleValueLayout;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CmdAssignView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CmdAssignView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CmdAssignView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.hitLeft = true;
        this.handler = new Handler(Looper.getMainLooper());
        this.internalRotation = 0;
        CardView.inflate(context, R.layout.cmd_damage_assign_view, this);
        setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
        View viewFindViewById = findViewById(R.id.lifeTotalTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.lifeTotalTextView = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.increaseLifeTotal);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.increaseLifeTotal = (ImageView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.decreaseLifeTotal);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.decreaseLifeTotal = (ImageView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.playerNameLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.playerNameTextView = (TextView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.runningTotalTextViewUp);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.runningTotalTextViewUp = (TextView) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.runningTotalTextViewDown);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.runningTotalTextViewDown = (TextView) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.card_background_image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.backgroundImage = (ImageView) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.overlay = viewFindViewById8;
        View viewFindViewById9 = findViewById(R.id.doubleValueLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.doubleValueLayout = (ConstraintLayout) viewFindViewById9;
        View viewFindViewById10 = findViewById(R.id.singleValueLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.singleValueLayout = (ConstraintLayout) viewFindViewById10;
        View viewFindViewById11 = findViewById(R.id.lifeTotalTextViewLeft);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.lifeTotalTextViewLeft = (TextView) viewFindViewById11;
        View viewFindViewById12 = findViewById(R.id.lifeTotalTextViewRight);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.lifeTotalTextViewRight = (TextView) viewFindViewById12;
        View viewFindViewById13 = findViewById(R.id.partnerName1TextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.partnerName1TextView = (TextView) viewFindViewById13;
        View viewFindViewById14 = findViewById(R.id.partnerName2TextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.partnerName2TextView = (TextView) viewFindViewById14;
        View viewFindViewById15 = findViewById(R.id.commanderNameTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.commanderNameTextView = (TextView) viewFindViewById15;
        this.partnerName1TextView.setVisibility(4);
        this.partnerName2TextView.setVisibility(4);
        this.commanderNameTextView.setVisibility(4);
        this.lifeTotalTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.studiolaganne.lengendarylens.CmdAssignView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                CmdAssignView.this.lifeTotalTextView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                CmdAssignView.this.updateTextSize();
                CmdAssignView.this.requestLayout();
            }
        });
    }

    public /* synthetic */ CmdAssignView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void animateBottomHalf() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.bottomHalf);
        int iArgb = Color.argb(30, 255, 255, 255);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), 0, Integer.valueOf(iArgb));
        objectAnimatorOfObject.setDuration(60L);
        ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), Integer.valueOf(iArgb), 0);
        objectAnimatorOfObject2.setStartDelay(60L);
        objectAnimatorOfObject2.setDuration(60L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfObject).before(objectAnimatorOfObject2);
        animatorSet.start();
    }

    private final void animateBottomLeftHalf() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.bottomLeftHalf);
        int iArgb = Color.argb(30, 255, 255, 255);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), 0, Integer.valueOf(iArgb));
        objectAnimatorOfObject.setDuration(60L);
        ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), Integer.valueOf(iArgb), 0);
        objectAnimatorOfObject2.setStartDelay(60L);
        objectAnimatorOfObject2.setDuration(60L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfObject).before(objectAnimatorOfObject2);
        animatorSet.start();
    }

    private final void animateBottomRightHalf() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.bottomRightHalf);
        int iArgb = Color.argb(30, 255, 255, 255);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), 0, Integer.valueOf(iArgb));
        objectAnimatorOfObject.setDuration(60L);
        ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), Integer.valueOf(iArgb), 0);
        objectAnimatorOfObject2.setStartDelay(60L);
        objectAnimatorOfObject2.setDuration(60L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfObject).before(objectAnimatorOfObject2);
        animatorSet.start();
    }

    private final void animateLeftHalf() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.leftHalf);
        int iArgb = Color.argb(30, 255, 255, 255);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), 0, Integer.valueOf(iArgb));
        objectAnimatorOfObject.setDuration(60L);
        ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), Integer.valueOf(iArgb), 0);
        objectAnimatorOfObject2.setStartDelay(60L);
        objectAnimatorOfObject2.setDuration(60L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfObject).before(objectAnimatorOfObject2);
        animatorSet.start();
    }

    private final void animateRightHalf() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.rightHalf);
        int iArgb = Color.argb(30, 255, 255, 255);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), 0, Integer.valueOf(iArgb));
        objectAnimatorOfObject.setDuration(60L);
        ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), Integer.valueOf(iArgb), 0);
        objectAnimatorOfObject2.setStartDelay(60L);
        objectAnimatorOfObject2.setDuration(60L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfObject).before(objectAnimatorOfObject2);
        animatorSet.start();
    }

    private final void animateTopHalf() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.topHalf);
        int iArgb = Color.argb(30, 255, 255, 255);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), 0, Integer.valueOf(iArgb));
        objectAnimatorOfObject.setDuration(60L);
        ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), Integer.valueOf(iArgb), 0);
        objectAnimatorOfObject2.setStartDelay(60L);
        objectAnimatorOfObject2.setDuration(60L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfObject).before(objectAnimatorOfObject2);
        animatorSet.start();
    }

    private final void animateTopLeftHalf() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.topLeftHalf);
        int iArgb = Color.argb(30, 255, 255, 255);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), 0, Integer.valueOf(iArgb));
        objectAnimatorOfObject.setDuration(60L);
        ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), Integer.valueOf(iArgb), 0);
        objectAnimatorOfObject2.setStartDelay(60L);
        objectAnimatorOfObject2.setDuration(60L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfObject).before(objectAnimatorOfObject2);
        animatorSet.start();
    }

    private final void animateTopRightHalf() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.topRightHalf);
        int iArgb = Color.argb(30, 255, 255, 255);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), 0, Integer.valueOf(iArgb));
        objectAnimatorOfObject.setDuration(60L);
        ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(frameLayout, "backgroundColor", new ArgbEvaluator(), Integer.valueOf(iArgb), 0);
        objectAnimatorOfObject2.setStartDelay(60L);
        objectAnimatorOfObject2.setDuration(60L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfObject).before(objectAnimatorOfObject2);
        animatorSet.start();
    }

    private final void decreaseLife(int amount) {
        if (!this.partners) {
            int i = this.intValue;
            if (i <= 0) {
                return;
            }
            setIntValue(i - amount);
            CmdAssignViewCallback cmdAssignViewCallback = this.callback;
            if (cmdAssignViewCallback != null) {
                cmdAssignViewCallback.cmdDamageDecremented(this.intValue);
            }
        } else if (this.hitLeft) {
            int i2 = this.leftValue;
            if (i2 <= 0) {
                return;
            }
            setLeftValue(i2 - amount);
            CmdAssignViewCallback cmdAssignViewCallback2 = this.callback;
            if (cmdAssignViewCallback2 != null) {
                cmdAssignViewCallback2.cmdDamageDecremented(this.leftValue);
            }
        } else {
            int i3 = this.rightValue;
            if (i3 <= 0) {
                return;
            }
            setRightValue(i3 - amount);
            CmdAssignViewCallback cmdAssignViewCallback3 = this.callback;
            if (cmdAssignViewCallback3 != null) {
                cmdAssignViewCallback3.cmdDamagePartnerDecremented(this.rightValue);
            }
        }
        updateRunningTotal(-amount);
        boolean z = this.partners;
        int i4 = this.internalRotation;
        if (!z) {
            if (i4 == 0) {
                animateBottomHalf();
                return;
            }
            if (i4 == 90) {
                animateLeftHalf();
                return;
            } else if (i4 == 180) {
                animateTopHalf();
                return;
            } else {
                if (i4 != 270) {
                    return;
                }
                animateRightHalf();
                return;
            }
        }
        if (i4 == 0) {
            if (this.hitLeft) {
                animateBottomLeftHalf();
                return;
            } else {
                animateBottomRightHalf();
                return;
            }
        }
        if (i4 == 90) {
            if (this.hitLeft) {
                animateTopLeftHalf();
                return;
            } else {
                animateBottomLeftHalf();
                return;
            }
        }
        if (i4 == 180) {
            if (this.hitLeft) {
                animateTopRightHalf();
                return;
            } else {
                animateTopLeftHalf();
                return;
            }
        }
        if (i4 != 270) {
            return;
        }
        if (this.hitLeft) {
            animateBottomRightHalf();
        } else {
            animateTopRightHalf();
        }
    }

    private final void increaseLife(int amount) {
        if (!this.partners) {
            setIntValue(this.intValue + amount);
            CmdAssignViewCallback cmdAssignViewCallback = this.callback;
            if (cmdAssignViewCallback != null) {
                cmdAssignViewCallback.cmdDamageIncremented(this.intValue);
            }
        } else if (this.hitLeft) {
            setLeftValue(this.leftValue + amount);
            CmdAssignViewCallback cmdAssignViewCallback2 = this.callback;
            if (cmdAssignViewCallback2 != null) {
                cmdAssignViewCallback2.cmdDamageIncremented(this.leftValue);
            }
        } else {
            setRightValue(this.rightValue + amount);
            CmdAssignViewCallback cmdAssignViewCallback3 = this.callback;
            if (cmdAssignViewCallback3 != null) {
                cmdAssignViewCallback3.cmdDamagePartnerIncremented(this.rightValue);
            }
        }
        updateRunningTotal(amount);
        boolean z = this.partners;
        int i = this.internalRotation;
        if (!z) {
            if (i == 0) {
                animateTopHalf();
                return;
            }
            if (i == 90) {
                animateRightHalf();
                return;
            } else if (i == 180) {
                animateBottomHalf();
                return;
            } else {
                if (i != 270) {
                    return;
                }
                animateLeftHalf();
                return;
            }
        }
        if (i == 0) {
            if (this.hitLeft) {
                animateTopLeftHalf();
                return;
            } else {
                animateTopRightHalf();
                return;
            }
        }
        if (i == 90) {
            if (this.hitLeft) {
                animateTopRightHalf();
                return;
            } else {
                animateBottomRightHalf();
                return;
            }
        }
        if (i == 180) {
            if (this.hitLeft) {
                animateBottomRightHalf();
                return;
            } else {
                animateBottomLeftHalf();
                return;
            }
        }
        if (i != 270) {
            return;
        }
        if (this.hitLeft) {
            animateBottomLeftHalf();
        } else {
            animateTopLeftHalf();
        }
    }

    private final String processCardName(String cardName) {
        List listSplit$default = StringsKt.split$default((CharSequence) cardName, new String[]{","}, false, 0, 6, (Object) null);
        return listSplit$default.size() > 1 ? (String) listSplit$default.get(0) : cardName;
    }

    private final void setIntValue(int i) {
        this.intValue = i;
        this.lifeTotalTextView.setText(String.valueOf(i));
    }

    private final void setLeftValue(int i) {
        this.leftValue = i;
        this.lifeTotalTextViewLeft.setText(String.valueOf(i));
    }

    private final void setRightValue(int i) {
        this.rightValue = i;
        this.lifeTotalTextViewRight.setText(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setState$lambda$0$3$0(CmdAssignView cmdAssignView, CardRecord cardRecord) {
        if (cardRecord != null) {
            cmdAssignView.partnerName2TextView.setVisibility(0);
            cmdAssignView.partnerName2TextView.setText(cmdAssignView.processCardName(cardRecord.getTitle()));
        } else {
            cmdAssignView.partnerName2TextView.setVisibility(4);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setState$lambda$0$3$1(CmdAssignView cmdAssignView, CardRecord cardRecord) {
        if (cardRecord != null) {
            cmdAssignView.partnerName1TextView.setVisibility(0);
            cmdAssignView.partnerName1TextView.setText(cmdAssignView.processCardName(cardRecord.getTitle()));
        } else {
            cmdAssignView.partnerName1TextView.setVisibility(4);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setState$lambda$1$3$0(CmdAssignView cmdAssignView, CardRecord cardRecord) {
        if (cardRecord != null) {
            cmdAssignView.commanderNameTextView.setVisibility(0);
            cmdAssignView.commanderNameTextView.setText(cmdAssignView.processCardName(cardRecord.getTitle()));
        } else {
            cmdAssignView.commanderNameTextView.setVisibility(4);
        }
        return Unit.INSTANCE;
    }

    private final void startDecrementRunnable() {
        Runnable runnable = new Runnable() { // from class: com.studiolaganne.lengendarylens.CmdAssignView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                CmdAssignView.startDecrementRunnable$lambda$0(this.f$0);
            }
        };
        this.decrementRunnable = runnable;
        Handler handler = this.handler;
        Intrinsics.checkNotNull(runnable);
        handler.postDelayed(runnable, 150L);
    }

    static final void startDecrementRunnable$lambda$0(CmdAssignView cmdAssignView) {
        Runnable runnable;
        if (cmdAssignView.isAttachedToWindow()) {
            cmdAssignView.decreaseLifeTotalOnLongPress = true;
            cmdAssignView.decreaseLife(1);
            Handler handler = cmdAssignView.handler;
            if (handler == null || (runnable = cmdAssignView.decrementRunnable) == null) {
                return;
            }
            handler.postDelayed(runnable, 80L);
        }
    }

    private final void startIncrementRunnable() {
        Runnable runnable = new Runnable() { // from class: com.studiolaganne.lengendarylens.CmdAssignView$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                CmdAssignView.startIncrementRunnable$lambda$0(this.f$0);
            }
        };
        this.incrementRunnable = runnable;
        Handler handler = this.handler;
        Intrinsics.checkNotNull(runnable);
        handler.postDelayed(runnable, 150L);
    }

    static final void startIncrementRunnable$lambda$0(CmdAssignView cmdAssignView) {
        Runnable runnable;
        if (cmdAssignView.isAttachedToWindow()) {
            cmdAssignView.increaseLifeTotalOnLongPress = true;
            cmdAssignView.increaseLife(1);
            Handler handler = cmdAssignView.handler;
            if (handler == null || (runnable = cmdAssignView.incrementRunnable) == null) {
                return;
            }
            handler.postDelayed(runnable, 80L);
        }
    }

    private final void stopDecrementRunnable() {
        Runnable runnable = this.decrementRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
            if (!this.decreaseLifeTotalOnLongPress) {
                decreaseLife(1);
            }
            this.decreaseLifeTotalOnLongPress = false;
            this.decrementRunnable = null;
        }
    }

    private final void stopIncrementRunnable() {
        Runnable runnable = this.incrementRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
            if (!this.increaseLifeTotalOnLongPress) {
                increaseLife(1);
            }
            this.increaseLifeTotalOnLongPress = false;
            this.incrementRunnable = null;
        }
    }

    private final void updateRunningTotal(int delta) {
        int i = this.runningTotal + delta;
        this.runningTotal = i;
        if (i > 0) {
            this.runningTotalTextViewUp.setText("+" + i);
        } else if (i < 0) {
            this.runningTotalTextViewDown.setText(String.valueOf(i));
        }
        int i2 = this.runningTotal;
        if (i2 == 0) {
            this.runningTotalTextViewUp.setVisibility(8);
            this.runningTotalTextViewDown.setVisibility(8);
        } else {
            TextView textView = this.runningTotalTextViewUp;
            if (i2 > 0) {
                textView.setVisibility(0);
                this.runningTotalTextViewDown.setVisibility(8);
                this.playerNameTextView.setVisibility(4);
            } else {
                textView.setVisibility(8);
                this.runningTotalTextViewDown.setVisibility(0);
                this.playerNameTextView.setVisibility(4);
            }
        }
        Handler handler = this.runningTotalTimer;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        handler2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.CmdAssignView$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                CmdAssignView.updateRunningTotal$lambda$0$0(this.f$0);
            }
        }, 2500L);
        this.runningTotalTimer = handler2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRunningTotal$lambda$0$0(CmdAssignView cmdAssignView) {
        cmdAssignView.runningTotal = 0;
        cmdAssignView.runningTotalTextViewUp.setVisibility(8);
        cmdAssignView.runningTotalTextViewDown.setVisibility(8);
        cmdAssignView.playerNameTextView.setVisibility(0);
    }

    public final void addOneDamage() {
        increaseLife(1);
    }

    public final void disableInput() {
        this.disabled = true;
    }

    public final CmdAssignViewCallback getCallback() {
        return this.callback;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Handler handler;
        Handler handler2;
        super.onDetachedFromWindow();
        Runnable runnable = this.decrementRunnable;
        if (runnable != null && (handler2 = this.handler) != null) {
            handler2.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.incrementRunnable;
        if (runnable2 == null || (handler = this.handler) == null) {
            return;
        }
        handler.removeCallbacks(runnable2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.disabled) {
            return false;
        }
        int action = event.getAction();
        if (action != 0) {
            if (action == 1) {
                stopIncrementRunnable();
                stopDecrementRunnable();
                return true;
            }
            if (action == 3) {
                stopIncrementRunnable();
                stopDecrementRunnable();
                return true;
            }
            if (action != 4) {
                return super.onTouchEvent(event);
            }
            stopIncrementRunnable();
            stopDecrementRunnable();
            return true;
        }
        float x = event.getX();
        float y = event.getY();
        int width = getWidth() / 2;
        float height = getHeight() / 2;
        boolean z = y < height;
        float f = width;
        boolean z2 = x < f;
        boolean z3 = x > f;
        boolean z4 = y > height;
        this.hitLeft = true;
        int i = this.internalRotation;
        if (i == 0) {
            boolean z5 = this.partners;
            if (z) {
                if (z5 && z3) {
                    this.hitLeft = false;
                }
                startIncrementRunnable();
            } else {
                if (z5 && z3) {
                    this.hitLeft = false;
                }
                startDecrementRunnable();
            }
        } else if (i == 90) {
            boolean z6 = this.partners;
            if (z3) {
                if (z6 && z4) {
                    this.hitLeft = false;
                }
                startIncrementRunnable();
            } else {
                if (z6 && z4) {
                    this.hitLeft = false;
                }
                startDecrementRunnable();
            }
        } else if (i == 180) {
            boolean z7 = this.partners;
            if (z4) {
                if (z7 && z2) {
                    this.hitLeft = false;
                }
                startIncrementRunnable();
            } else {
                if (z7 && z2) {
                    this.hitLeft = false;
                }
                startDecrementRunnable();
            }
        } else if (i == 270) {
            boolean z8 = this.partners;
            if (z2) {
                if (z8 && z) {
                    this.hitLeft = false;
                }
                startIncrementRunnable();
            } else {
                if (z8 && z) {
                    this.hitLeft = false;
                }
                startDecrementRunnable();
            }
        }
        return true;
    }

    public final void setCallback(CmdAssignViewCallback cmdAssignViewCallback) {
        this.callback = cmdAssignViewCallback;
    }

    public final void setRotation(int rotation) {
        this.internalRotation = rotation;
        this.runningTotalTextViewUp.setRotation(rotation);
        this.runningTotalTextViewDown.setRotation(this.internalRotation);
        this.decreaseLifeTotal.setRotation(this.internalRotation);
        this.increaseLifeTotal.setRotation(this.internalRotation);
        this.playerNameTextView.setRotation(this.internalRotation);
        this.doubleValueLayout.setRotation(this.internalRotation);
        this.singleValueLayout.setRotation(this.internalRotation);
        int i = this.internalRotation;
        if (i == 90) {
            ViewGroup.LayoutParams layoutParams = this.increaseLifeTotal.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            ViewGroup.LayoutParams layoutParams3 = this.decreaseLifeTotal.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            ViewGroup.LayoutParams layoutParams5 = this.runningTotalTextViewUp.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
            ViewGroup.LayoutParams layoutParams7 = this.runningTotalTextViewDown.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
            ViewGroup.LayoutParams layoutParams9 = this.playerNameTextView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams9, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) layoutParams9;
            layoutParams2.removeRule(10);
            layoutParams2.addRule(12);
            layoutParams4.removeRule(21);
            layoutParams4.addRule(20);
            layoutParams6.removeRule(14);
            layoutParams6.addRule(15);
            layoutParams6.removeRule(10);
            layoutParams6.addRule(11);
            layoutParams8.removeRule(14);
            layoutParams8.addRule(15);
            layoutParams8.removeRule(12);
            layoutParams8.addRule(9);
            layoutParams10.removeRule(9);
            layoutParams10.addRule(11);
            this.increaseLifeTotal.setLayoutParams(layoutParams2);
            this.decreaseLifeTotal.setLayoutParams(layoutParams4);
            this.runningTotalTextViewUp.setLayoutParams(layoutParams6);
            this.runningTotalTextViewDown.setLayoutParams(layoutParams8);
            this.playerNameTextView.setLayoutParams(layoutParams10);
        } else if (i == 180) {
            ViewGroup.LayoutParams layoutParams11 = this.increaseLifeTotal.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams11, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) layoutParams11;
            ViewGroup.LayoutParams layoutParams13 = this.decreaseLifeTotal.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams13, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams14 = (RelativeLayout.LayoutParams) layoutParams13;
            ViewGroup.LayoutParams layoutParams15 = this.runningTotalTextViewUp.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams15, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams16 = (RelativeLayout.LayoutParams) layoutParams15;
            ViewGroup.LayoutParams layoutParams17 = this.runningTotalTextViewDown.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams17, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams18 = (RelativeLayout.LayoutParams) layoutParams17;
            ViewGroup.LayoutParams layoutParams19 = this.playerNameTextView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams19, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams20 = (RelativeLayout.LayoutParams) layoutParams19;
            layoutParams12.removeRule(21);
            layoutParams12.addRule(20);
            layoutParams12.removeRule(10);
            layoutParams12.addRule(12);
            layoutParams14.removeRule(21);
            layoutParams14.addRule(20);
            layoutParams14.removeRule(12);
            layoutParams14.addRule(10);
            layoutParams16.removeRule(10);
            layoutParams16.addRule(12);
            layoutParams18.removeRule(12);
            layoutParams18.addRule(10);
            layoutParams20.removeRule(9);
            layoutParams20.removeRule(10);
            layoutParams20.addRule(11);
            layoutParams20.addRule(12);
            this.increaseLifeTotal.setLayoutParams(layoutParams12);
            this.decreaseLifeTotal.setLayoutParams(layoutParams14);
            this.runningTotalTextViewUp.setLayoutParams(layoutParams16);
            this.runningTotalTextViewDown.setLayoutParams(layoutParams18);
            this.playerNameTextView.setLayoutParams(layoutParams20);
        } else if (i == 270) {
            ViewGroup.LayoutParams layoutParams21 = this.increaseLifeTotal.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams21, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams22 = (RelativeLayout.LayoutParams) layoutParams21;
            ViewGroup.LayoutParams layoutParams23 = this.decreaseLifeTotal.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams23, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams24 = (RelativeLayout.LayoutParams) layoutParams23;
            ViewGroup.LayoutParams layoutParams25 = this.runningTotalTextViewUp.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams25, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams26 = (RelativeLayout.LayoutParams) layoutParams25;
            ViewGroup.LayoutParams layoutParams27 = this.runningTotalTextViewDown.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams27, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams28 = (RelativeLayout.LayoutParams) layoutParams27;
            ViewGroup.LayoutParams layoutParams29 = this.playerNameTextView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams29, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams30 = (RelativeLayout.LayoutParams) layoutParams29;
            layoutParams22.removeRule(21);
            layoutParams22.addRule(20);
            layoutParams24.removeRule(12);
            layoutParams24.addRule(10);
            layoutParams26.removeRule(14);
            layoutParams26.addRule(15);
            layoutParams26.removeRule(10);
            layoutParams26.addRule(9);
            layoutParams28.removeRule(14);
            layoutParams28.addRule(15);
            layoutParams28.removeRule(12);
            layoutParams28.addRule(11);
            layoutParams30.removeRule(10);
            layoutParams30.addRule(12);
            this.increaseLifeTotal.setLayoutParams(layoutParams22);
            this.decreaseLifeTotal.setLayoutParams(layoutParams24);
            this.runningTotalTextViewUp.setLayoutParams(layoutParams26);
            this.runningTotalTextViewDown.setLayoutParams(layoutParams28);
            this.playerNameTextView.setLayoutParams(layoutParams30);
        }
        requestLayout();
    }

    public final void setState(int currentValue, int currentValue2, String playerName, boolean partners, Drawable playmatImage, Player player) {
        Object next;
        int i;
        MTUser currentUser;
        Object next2;
        int i2;
        int i3;
        MTUser currentUser2;
        Intrinsics.checkNotNullParameter(playerName, "playerName");
        setIntValue(currentValue);
        setLeftValue(currentValue);
        setRightValue(currentValue2);
        this.partners = partners;
        ConstraintLayout constraintLayout = this.singleValueLayout;
        if (partners) {
            constraintLayout.setVisibility(4);
            this.doubleValueLayout.setVisibility(0);
            if (player != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                PreferencesManager preferencesManager = new PreferencesManager(context);
                List<MTDeck> currentUserDecks = preferencesManager.getAllUsersDecks().get(Integer.valueOf(player.getUserId()));
                if (currentUserDecks == null) {
                    currentUserDecks = CollectionsKt.emptyList();
                }
                if (currentUserDecks.isEmpty() && (currentUser2 = preferencesManager.getCurrentUser()) != null && player.getUserId() == currentUser2.getId()) {
                    currentUserDecks = preferencesManager.getCurrentUserDecks();
                }
                Iterator<T> it = currentUserDecks.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next2 = null;
                        break;
                    } else {
                        next2 = it.next();
                        if (((MTDeck) next2).getId() == player.getDeckId()) {
                            break;
                        }
                    }
                }
                MTDeck mTDeck = (MTDeck) next2;
                if (mTDeck != null) {
                    String commander = mTDeck.getCommander();
                    if (commander != null) {
                        Pair<String, Integer> pairExtractIdAndFace = DeckUtils.INSTANCE.extractIdAndFace(commander);
                        String strComponent1 = pairExtractIdAndFace.component1();
                        int iIntValue = pairExtractIdAndFace.component2().intValue();
                        GameUtils companion = GameUtils.INSTANCE.getInstance();
                        Context context2 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                        CardRecord cardLocal = companion.getCardLocal(context2, strComponent1, iIntValue);
                        if (cardLocal != null) {
                            this.partnerName2TextView.setVisibility(0);
                            this.partnerName2TextView.setText(processCardName(cardLocal.getTitle()));
                        } else {
                            this.partnerName2TextView.setVisibility(4);
                        }
                    } else {
                        this.partnerName2TextView.setVisibility(4);
                    }
                    String partner = mTDeck.getPartner();
                    if (partner != null) {
                        Pair<String, Integer> pairExtractIdAndFace2 = DeckUtils.INSTANCE.extractIdAndFace(partner);
                        String strComponent12 = pairExtractIdAndFace2.component1();
                        int iIntValue2 = pairExtractIdAndFace2.component2().intValue();
                        GameUtils companion2 = GameUtils.INSTANCE.getInstance();
                        Context context3 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                        CardRecord cardLocal2 = companion2.getCardLocal(context3, strComponent12, iIntValue2);
                        if (cardLocal2 != null) {
                            this.partnerName1TextView.setVisibility(0);
                            this.partnerName1TextView.setText(processCardName(cardLocal2.getTitle()));
                        } else {
                            this.partnerName1TextView.setVisibility(4);
                        }
                    } else {
                        this.partnerName1TextView.setVisibility(4);
                    }
                } else {
                    if (player.getBackgroundType() == BackgroundType.SCRYFALL_ID) {
                        String scryfallId = player.getScryfallId();
                        String str = scryfallId;
                        if (StringsKt.contains$default((CharSequence) str, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                            List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                            String str2 = (String) listSplit$default.get(0);
                            i3 = Integer.parseInt((String) listSplit$default.get(1));
                            scryfallId = str2;
                        } else {
                            i3 = 0;
                        }
                        GameUtils companion3 = GameUtils.INSTANCE.getInstance();
                        Context context4 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                        companion3.getCard(context4, scryfallId, i3, new Function1() { // from class: com.studiolaganne.lengendarylens.CmdAssignView$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CmdAssignView.setState$lambda$0$3$0(this.f$0, (CardRecord) obj);
                            }
                        });
                    } else {
                        this.partnerName2TextView.setVisibility(4);
                    }
                    if (player.getLeftBackgroundType() == BackgroundType.SCRYFALL_ID) {
                        String leftScryfallId = player.getLeftScryfallId();
                        String str3 = leftScryfallId;
                        if (StringsKt.contains$default((CharSequence) str3, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                            List listSplit$default2 = StringsKt.split$default((CharSequence) str3, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                            String str4 = (String) listSplit$default2.get(0);
                            i2 = Integer.parseInt((String) listSplit$default2.get(1));
                            leftScryfallId = str4;
                        } else {
                            i2 = 0;
                        }
                        GameUtils companion4 = GameUtils.INSTANCE.getInstance();
                        Context context5 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
                        companion4.getCard(context5, leftScryfallId, i2, new Function1() { // from class: com.studiolaganne.lengendarylens.CmdAssignView$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CmdAssignView.setState$lambda$0$3$1(this.f$0, (CardRecord) obj);
                            }
                        });
                    } else {
                        this.partnerName1TextView.setVisibility(4);
                    }
                }
            }
        } else {
            constraintLayout.setVisibility(0);
            this.doubleValueLayout.setVisibility(4);
            this.commanderNameTextView.setVisibility(4);
            if (player != null) {
                Context context6 = getContext();
                Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
                PreferencesManager preferencesManager2 = new PreferencesManager(context6);
                List<MTDeck> currentUserDecks2 = preferencesManager2.getAllUsersDecks().get(Integer.valueOf(player.getUserId()));
                if (currentUserDecks2 == null) {
                    currentUserDecks2 = CollectionsKt.emptyList();
                }
                if (currentUserDecks2.isEmpty() && (currentUser = preferencesManager2.getCurrentUser()) != null && player.getUserId() == currentUser.getId()) {
                    currentUserDecks2 = preferencesManager2.getCurrentUserDecks();
                }
                Iterator<T> it2 = currentUserDecks2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it2.next();
                        if (((MTDeck) next).getId() == player.getDeckId()) {
                            break;
                        }
                    }
                }
                MTDeck mTDeck2 = (MTDeck) next;
                if (mTDeck2 != null) {
                    String commander2 = mTDeck2.getCommander();
                    if (commander2 != null) {
                        Pair<String, Integer> pairExtractIdAndFace3 = DeckUtils.INSTANCE.extractIdAndFace(commander2);
                        String strComponent13 = pairExtractIdAndFace3.component1();
                        int iIntValue3 = pairExtractIdAndFace3.component2().intValue();
                        GameUtils companion5 = GameUtils.INSTANCE.getInstance();
                        Context context7 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context7, "getContext(...)");
                        CardRecord cardLocal3 = companion5.getCardLocal(context7, strComponent13, iIntValue3);
                        if (cardLocal3 != null) {
                            this.partnerName2TextView.setVisibility(0);
                            this.partnerName2TextView.setText(processCardName(cardLocal3.getTitle()));
                        } else {
                            this.partnerName2TextView.setVisibility(4);
                        }
                    } else {
                        this.partnerName2TextView.setVisibility(4);
                    }
                } else if (player.getBackgroundType() == BackgroundType.SCRYFALL_ID) {
                    String scryfallId2 = player.getScryfallId();
                    String str5 = scryfallId2;
                    if (StringsKt.contains$default((CharSequence) str5, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                        List listSplit$default3 = StringsKt.split$default((CharSequence) str5, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                        String str6 = (String) listSplit$default3.get(0);
                        i = Integer.parseInt((String) listSplit$default3.get(1));
                        scryfallId2 = str6;
                    } else {
                        i = 0;
                    }
                    GameUtils companion6 = GameUtils.INSTANCE.getInstance();
                    Context context8 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context8, "getContext(...)");
                    companion6.getCard(context8, scryfallId2, i, new Function1() { // from class: com.studiolaganne.lengendarylens.CmdAssignView$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CmdAssignView.setState$lambda$1$3$0(this.f$0, (CardRecord) obj);
                        }
                    });
                } else {
                    this.commanderNameTextView.setVisibility(4);
                }
            }
        }
        ImageView imageView = this.backgroundImage;
        if (playmatImage != null) {
            imageView.setVisibility(0);
            this.overlay.setVisibility(0);
            this.backgroundImage.setImageDrawable(playmatImage);
        } else {
            imageView.setVisibility(8);
            this.overlay.setVisibility(8);
        }
        TextView textView = this.playerNameTextView;
        String string = getResources().getString(R.string.commander_damage_from_linebreak);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textView.setText(StringsKt.replace$default(string, "{1}", playerName, false, 4, (Object) null));
    }

    public final float textSize() {
        return this.lifeTotalTextView.getTextSize();
    }

    public final void updateTextSize() {
        float textSize = this.lifeTotalTextView.getTextSize();
        TextView textView = this.lifeTotalTextView;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setTextSize(textSize / ViewExtensionsKt.getScaledDensity(context));
        TextView textView2 = this.runningTotalTextViewUp;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        textView2.setTextSize(textSize / (ViewExtensionsKt.getScaledDensity(context2) * 3.0f));
        TextView textView3 = this.runningTotalTextViewDown;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        textView3.setTextSize(textSize / (ViewExtensionsKt.getScaledDensity(context3) * 3.0f));
        TextView textView4 = this.playerNameTextView;
        Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
        textView4.setTextSize(textSize / ((long) (ViewExtensionsKt.getScaledDensity(r2) * 5.5f)));
        TextView textView5 = this.lifeTotalTextViewLeft;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        textView5.setTextSize(textSize / (ViewExtensionsKt.getScaledDensity(context4) * 1.15f));
        TextView textView6 = this.lifeTotalTextViewRight;
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
        textView6.setTextSize(textSize / (ViewExtensionsKt.getScaledDensity(context5) * 1.15f));
    }
}
