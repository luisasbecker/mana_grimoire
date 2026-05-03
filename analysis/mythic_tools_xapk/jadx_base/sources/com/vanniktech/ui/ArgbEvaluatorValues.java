package com.vanniktech.ui;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: internal.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u000bJ8\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\""}, d2 = {"Lcom/vanniktech/ui/ArgbEvaluatorValues;", "", "expected", "Lcom/vanniktech/ui/Color;", "fraction", "", "start", "end", "<init>", "(IFIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getExpected-oEAH0UE", "()I", "I", "getFraction", "()F", "getStart-oEAH0UE", "getEnd-oEAH0UE", "component1", "component1-oEAH0UE", "component2", "component3", "component3-oEAH0UE", "component4", "component4-oEAH0UE", "copy", "copy-0-jpEGs", "(IFII)Lcom/vanniktech/ui/ArgbEvaluatorValues;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class ArgbEvaluatorValues {
    private final int end;
    private final int expected;
    private final float fraction;
    private final int start;

    private ArgbEvaluatorValues(int i, float f, int i2, int i3) {
        this.expected = i;
        this.fraction = f;
        this.start = i2;
        this.end = i3;
    }

    public /* synthetic */ ArgbEvaluatorValues(int i, float f, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, f, i2, i3);
    }

    /* JADX INFO: renamed from: copy-0-jpEGs$default, reason: not valid java name */
    public static /* synthetic */ ArgbEvaluatorValues m11360copy0jpEGs$default(ArgbEvaluatorValues argbEvaluatorValues, int i, float f, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = argbEvaluatorValues.expected;
        }
        if ((i4 & 2) != 0) {
            f = argbEvaluatorValues.fraction;
        }
        if ((i4 & 4) != 0) {
            i2 = argbEvaluatorValues.start;
        }
        if ((i4 & 8) != 0) {
            i3 = argbEvaluatorValues.end;
        }
        return argbEvaluatorValues.m11364copy0jpEGs(i, f, i2, i3);
    }

    /* JADX INFO: renamed from: component1-oEAH0UE, reason: not valid java name and from getter */
    public final int getExpected() {
        return this.expected;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getFraction() {
        return this.fraction;
    }

    /* JADX INFO: renamed from: component3-oEAH0UE, reason: not valid java name and from getter */
    public final int getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: component4-oEAH0UE, reason: not valid java name and from getter */
    public final int getEnd() {
        return this.end;
    }

    /* JADX INFO: renamed from: copy-0-jpEGs, reason: not valid java name */
    public final ArgbEvaluatorValues m11364copy0jpEGs(int expected, float fraction, int start, int end) {
        return new ArgbEvaluatorValues(expected, fraction, start, end, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArgbEvaluatorValues)) {
            return false;
        }
        ArgbEvaluatorValues argbEvaluatorValues = (ArgbEvaluatorValues) other;
        return Color.m11379equalsimpl0(this.expected, argbEvaluatorValues.expected) && Float.compare(this.fraction, argbEvaluatorValues.fraction) == 0 && Color.m11379equalsimpl0(this.start, argbEvaluatorValues.start) && Color.m11379equalsimpl0(this.end, argbEvaluatorValues.end);
    }

    /* JADX INFO: renamed from: getEnd-oEAH0UE, reason: not valid java name */
    public final int m11365getEndoEAH0UE() {
        return this.end;
    }

    /* JADX INFO: renamed from: getExpected-oEAH0UE, reason: not valid java name */
    public final int m11366getExpectedoEAH0UE() {
        return this.expected;
    }

    public final float getFraction() {
        return this.fraction;
    }

    /* JADX INFO: renamed from: getStart-oEAH0UE, reason: not valid java name */
    public final int m11367getStartoEAH0UE() {
        return this.start;
    }

    public int hashCode() {
        return (((((Color.m11381hashCodeimpl(this.expected) * 31) + Float.hashCode(this.fraction)) * 31) + Color.m11381hashCodeimpl(this.start)) * 31) + Color.m11381hashCodeimpl(this.end);
    }

    public String toString() {
        return "ArgbEvaluatorValues(expected=" + Color.m11386toStringimpl(this.expected) + ", fraction=" + this.fraction + ", start=" + Color.m11386toStringimpl(this.start) + ", end=" + Color.m11386toStringimpl(this.end) + ")";
    }
}
