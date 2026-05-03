package com.vanniktech.ui;

import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ArgbEvaluator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/vanniktech/ui/ArgbEvaluator;", "", "<init>", "()V", "evaluate", "Lcom/vanniktech/ui/Color;", "fraction", "", "startValue", "endValue", "evaluate-o6NmsjE", "(FII)I", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ArgbEvaluator {
    public static final ArgbEvaluator INSTANCE = new ArgbEvaluator();

    private ArgbEvaluator() {
    }

    /* JADX INFO: renamed from: evaluate-o6NmsjE, reason: not valid java name */
    public final int m11359evaluateo6NmsjE(float fraction, int startValue, int endValue) {
        float fM11368alphaimpl$ui_release = Color.m11368alphaimpl$ui_release(startValue) / 255.0f;
        float fM11384redimpl$ui_release = Color.m11384redimpl$ui_release(startValue) / 255.0f;
        float fM11380greenimpl$ui_release = Color.m11380greenimpl$ui_release(startValue) / 255.0f;
        float fM11368alphaimpl$ui_release2 = Color.m11368alphaimpl$ui_release(endValue) / 255.0f;
        float fM11384redimpl$ui_release2 = Color.m11384redimpl$ui_release(endValue) / 255.0f;
        float fM11380greenimpl$ui_release2 = Color.m11380greenimpl$ui_release(endValue) / 255.0f;
        float fPow = (float) Math.pow(fM11384redimpl$ui_release, 2.200000047683716d);
        float fPow2 = (float) Math.pow(fM11380greenimpl$ui_release, 2.200000047683716d);
        float fPow3 = (float) Math.pow(Color.m11369blueimpl$ui_release(startValue) / 255.0f, 2.200000047683716d);
        float fPow4 = (float) Math.pow(fM11384redimpl$ui_release2, 2.200000047683716d);
        return Color.m11372constructorimpl((MathKt.roundToInt((fM11368alphaimpl$ui_release + ((fM11368alphaimpl$ui_release2 - fM11368alphaimpl$ui_release) * fraction)) * 255.0f) << 24) | (MathKt.roundToInt(((float) Math.pow(fPow + ((fPow4 - fPow) * fraction), 0.45454543828964233d)) * 255.0f) << 16) | (MathKt.roundToInt(((float) Math.pow(fPow2 + ((((float) Math.pow(fM11380greenimpl$ui_release2, 2.200000047683716d)) - fPow2) * fraction), 0.45454543828964233d)) * 255.0f) << 8) | MathKt.roundToInt(((float) Math.pow(fPow3 + (fraction * (((float) Math.pow(Color.m11369blueimpl$ui_release(endValue) / 255.0f, 2.200000047683716d)) - fPow3)), 0.45454543828964233d)) * 255.0f));
    }
}
