package com.skydoves.colorpickerview.flag;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.ImageViewCompat;
import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.R;

/* JADX INFO: loaded from: classes6.dex */
public class BubbleFlag extends FlagView {
    private final AppCompatImageView bubble;

    public BubbleFlag(Context context) {
        super(context, R.layout.colorpickerview_flag_bubble);
        this.bubble = (AppCompatImageView) findViewById(R.id.bubble);
    }

    @Override // com.skydoves.colorpickerview.flag.FlagView
    public void onFlipped(Boolean bool) {
    }

    @Override // com.skydoves.colorpickerview.flag.FlagView
    public void onRefresh(ColorEnvelope colorEnvelope) {
        ImageViewCompat.setImageTintList(this.bubble, ColorStateList.valueOf(colorEnvelope.getColor()));
    }
}
