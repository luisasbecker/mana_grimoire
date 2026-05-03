package com.skydoves.colorpickerview.flag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.FadeUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class FlagView extends RelativeLayout {
    private FlagMode flagMode;
    private boolean flipAble;

    public FlagView(Context context, int i) {
        super(context);
        this.flagMode = FlagMode.ALWAYS;
        this.flipAble = true;
        initializeLayout(i);
    }

    private void initializeLayout(int i) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(i, this);
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        viewInflate.layout(0, 0, viewInflate.getWidth(), viewInflate.getMeasuredHeight());
    }

    public FlagMode getFlagMode() {
        return this.flagMode;
    }

    public void gone() {
        setVisibility(8);
    }

    public boolean isFlipAble() {
        return this.flipAble;
    }

    public abstract void onFlipped(Boolean bool);

    public abstract void onRefresh(ColorEnvelope colorEnvelope);

    public void receiveOnTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (getFlagMode() == FlagMode.LAST) {
                gone();
                return;
            } else {
                if (getFlagMode() == FlagMode.FADE) {
                    FadeUtils.fadeIn(this);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (getFlagMode() == FlagMode.LAST) {
                    gone();
                    return;
                }
                return;
            }
        } else if (getFlagMode() == FlagMode.LAST) {
            visible();
        } else if (getFlagMode() == FlagMode.FADE) {
            FadeUtils.fadeOut(this);
        }
        visible();
    }

    public void setFlagMode(FlagMode flagMode) {
        this.flagMode = flagMode;
    }

    public void setFlipAble(boolean z) {
        this.flipAble = z;
    }

    public void visible() {
        setVisibility(0);
    }
}
