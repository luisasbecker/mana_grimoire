package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ChainRun extends WidgetRun {
    private int mChainStyle;
    ArrayList<WidgetRun> mWidgets;

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        this.mWidgets = new ArrayList<>();
        this.orientation = i;
        build();
    }

    private void build() {
        ConstraintWidget constraintWidget;
        ArrayList<WidgetRun> arrayList;
        ConstraintWidget constraintWidget2 = this.mWidget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
            }
        }
        this.mWidget = constraintWidget;
        this.mWidgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (true) {
            arrayList = this.mWidgets;
            if (nextChainMember == null) {
                break;
            }
            arrayList.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        for (WidgetRun widgetRun : arrayList) {
            if (this.orientation == 0) {
                widgetRun.mWidget.horizontalChainRun = this;
            } else if (this.orientation == 1) {
                widgetRun.mWidget.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.mWidget.getParent()).isRtl() && this.mWidgets.size() > 1) {
            ArrayList<WidgetRun> arrayList2 = this.mWidgets;
            this.mWidget = arrayList2.get(arrayList2.size() - 1).mWidget;
        }
        this.mChainStyle = this.orientation == 0 ? this.mWidget.getHorizontalChainStyle() : this.mWidget.getVerticalChainStyle();
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i = 0; i < this.mWidgets.size(); i++) {
            WidgetRun widgetRun = this.mWidgets.get(i);
            if (widgetRun.mWidget.getVisibility() != 8) {
                return widgetRun.mWidget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.mWidgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.mWidgets.get(size);
            if (widgetRun.mWidget.getVisibility() != 8) {
                return widgetRun.mWidget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        Iterator<WidgetRun> it = this.mWidgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.mWidgets.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.mWidgets.get(0).mWidget;
        ConstraintWidget constraintWidget2 = this.mWidgets.get(size - 1).mWidget;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target = getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin = firstVisibleWidget.mLeft.getMargin();
            }
            if (target != null) {
                addTarget(this.start, target, margin);
            }
            DependencyNode target2 = getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin2 = lastVisibleWidget.mRight.getMargin();
            }
            if (target2 != null) {
                addTarget(this.end, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                addTarget(this.start, target3, margin3);
            }
            DependencyNode target4 = getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin4 = lastVisibleWidget2.mBottom.getMargin();
            }
            if (target4 != null) {
                addTarget(this.end, target4, -margin4);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i = 0; i < this.mWidgets.size(); i++) {
            this.mWidgets.get(i).applyToWidget();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.mRunGroup = null;
        Iterator<WidgetRun> it = this.mWidgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.mWidgets.size();
        long wrapDimension = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = this.mWidgets.get(i);
            wrapDimension = wrapDimension + ((long) widgetRun.start.mMargin) + widgetRun.getWrapDimension() + ((long) widgetRun.end.mMargin);
        }
        return wrapDimension;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        int size = this.mWidgets.size();
        for (int i = 0; i < size; i++) {
            if (!this.mWidgets.get(i).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        for (WidgetRun widgetRun : this.mWidgets) {
            sb.append("<");
            sb.append(widgetRun);
            sb.append("> ");
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        int i;
        int i2;
        float f;
        float f2;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        float f3;
        int i7;
        int i8;
        int i9;
        float f4;
        int i10;
        int i11;
        int i12;
        if (this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.mWidget.getParent();
            boolean zIsRtl = parent instanceof ConstraintWidgetContainer ? ((ConstraintWidgetContainer) parent).isRtl() : false;
            int i13 = this.end.value - this.start.value;
            int size = this.mWidgets.size();
            int i14 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i14 >= size) {
                    i14 = -1;
                    break;
                } else if (this.mWidgets.get(i14).mWidget.getVisibility() != 8) {
                    break;
                } else {
                    i14++;
                }
            }
            int i15 = size - 1;
            int i16 = i15;
            while (true) {
                if (i16 < 0) {
                    break;
                }
                if (this.mWidgets.get(i16).mWidget.getVisibility() != 8) {
                    i = i16;
                    break;
                }
                i16--;
            }
            int i17 = 0;
            while (i17 < 2) {
                int i18 = 0;
                i4 = 0;
                i5 = 0;
                int i19 = 0;
                f2 = 0.0f;
                while (i18 < size) {
                    WidgetRun widgetRun = this.mWidgets.get(i18);
                    if (widgetRun.mWidget.getVisibility() != i2) {
                        i19++;
                        if (i18 > 0 && i18 >= i14) {
                            i4 += widgetRun.start.mMargin;
                        }
                        int i20 = widgetRun.mDimension.value;
                        boolean z2 = widgetRun.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (!z2) {
                            if (widgetRun.matchConstraintsType == 1 && i17 == 0) {
                                i20 = widgetRun.mDimension.wrapValue;
                                i5++;
                            } else if (widgetRun.mDimension.resolved) {
                            }
                            z2 = true;
                        } else {
                            if (this.orientation == 0 && !widgetRun.mWidget.mHorizontalRun.mDimension.resolved) {
                                return;
                            }
                            if (this.orientation == 1 && !widgetRun.mWidget.mVerticalRun.mDimension.resolved) {
                                return;
                            }
                        }
                        if (z2) {
                            i4 += i20;
                        } else {
                            i5++;
                            float f5 = widgetRun.mWidget.mWeight[this.orientation];
                            if (f5 >= 0.0f) {
                                f2 += f5;
                            }
                        }
                        if (i18 < i15 && i18 < i) {
                            i4 += -widgetRun.end.mMargin;
                        }
                    }
                    i18++;
                    i2 = 8;
                }
                f = 0.0f;
                if (i4 < i13 || i5 == 0) {
                    i3 = i19;
                    break;
                } else {
                    i17++;
                    i2 = 8;
                }
            }
            f = 0.0f;
            f2 = 0.0f;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            int i21 = this.start.value;
            if (zIsRtl) {
                i21 = this.end.value;
            }
            float f6 = 0.5f;
            if (i4 > i13) {
                i21 = zIsRtl ? i21 + ((int) (((i4 - i13) / 2.0f) + 0.5f)) : i21 - ((int) (((i4 - i13) / 2.0f) + 0.5f));
            }
            if (i5 > 0) {
                float f7 = i13 - i4;
                int i22 = (int) ((f7 / i5) + 0.5f);
                int i23 = 0;
                int i24 = 0;
                while (i23 < size) {
                    float f8 = f6;
                    WidgetRun widgetRun2 = this.mWidgets.get(i23);
                    boolean z3 = zIsRtl;
                    if (widgetRun2.mWidget.getVisibility() == 8 || widgetRun2.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || widgetRun2.mDimension.resolved) {
                        i9 = i21;
                        f4 = f7;
                        i10 = i22;
                    } else {
                        int i25 = f2 > f ? (int) (((widgetRun2.mWidget.mWeight[this.orientation] * f7) / f2) + f8) : i22;
                        if (this.orientation == 0) {
                            i11 = widgetRun2.mWidget.mMatchConstraintMaxWidth;
                            i9 = i21;
                            i12 = widgetRun2.mWidget.mMatchConstraintMinWidth;
                        } else {
                            i9 = i21;
                            i11 = widgetRun2.mWidget.mMatchConstraintMaxHeight;
                            i12 = widgetRun2.mWidget.mMatchConstraintMinHeight;
                        }
                        f4 = f7;
                        i10 = i22;
                        int iMax = Math.max(i12, widgetRun2.matchConstraintsType == 1 ? Math.min(i25, widgetRun2.mDimension.wrapValue) : i25);
                        if (i11 > 0) {
                            iMax = Math.min(i11, iMax);
                        }
                        if (iMax != i25) {
                            i24++;
                            i25 = iMax;
                        }
                        widgetRun2.mDimension.resolve(i25);
                    }
                    i23++;
                    f6 = f8;
                    zIsRtl = z3;
                    i21 = i9;
                    f7 = f4;
                    i22 = i10;
                }
                z = zIsRtl;
                i6 = i21;
                f3 = f6;
                if (i24 > 0) {
                    i5 -= i24;
                    int i26 = 0;
                    for (int i27 = 0; i27 < size; i27++) {
                        WidgetRun widgetRun3 = this.mWidgets.get(i27);
                        if (widgetRun3.mWidget.getVisibility() != 8) {
                            if (i27 > 0 && i27 >= i14) {
                                i26 += widgetRun3.start.mMargin;
                            }
                            i26 += widgetRun3.mDimension.value;
                            if (i27 < i15 && i27 < i) {
                                i26 += -widgetRun3.end.mMargin;
                            }
                        }
                    }
                    i4 = i26;
                }
                i8 = 2;
                if (this.mChainStyle == 2 && i24 == 0) {
                    i7 = 0;
                    this.mChainStyle = 0;
                } else {
                    i7 = 0;
                }
            } else {
                z = zIsRtl;
                i6 = i21;
                f3 = 0.5f;
                i7 = 0;
                i8 = 2;
            }
            if (i4 > i13) {
                this.mChainStyle = i8;
            }
            if (i3 > 0 && i5 == 0 && i14 == i) {
                this.mChainStyle = i8;
            }
            int i28 = this.mChainStyle;
            if (i28 == 1) {
                int i29 = i3 > 1 ? (i13 - i4) / (i3 - 1) : i3 == 1 ? (i13 - i4) / 2 : i7;
                if (i5 > 0) {
                    i29 = i7;
                }
                int i30 = i6;
                for (int i31 = i7; i31 < size; i31++) {
                    WidgetRun widgetRun4 = this.mWidgets.get(z ? size - (i31 + 1) : i31);
                    if (widgetRun4.mWidget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i30);
                        widgetRun4.end.resolve(i30);
                    } else {
                        if (i31 > 0) {
                            i30 = z ? i30 - i29 : i30 + i29;
                        }
                        if (i31 > 0 && i31 >= i14) {
                            i30 = z ? i30 - widgetRun4.start.mMargin : i30 + widgetRun4.start.mMargin;
                        }
                        if (z) {
                            widgetRun4.end.resolve(i30);
                        } else {
                            widgetRun4.start.resolve(i30);
                        }
                        int i32 = widgetRun4.mDimension.value;
                        if (widgetRun4.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i32 = widgetRun4.mDimension.wrapValue;
                        }
                        i30 = z ? i30 - i32 : i30 + i32;
                        if (z) {
                            widgetRun4.start.resolve(i30);
                        } else {
                            widgetRun4.end.resolve(i30);
                        }
                        widgetRun4.mResolved = true;
                        if (i31 < i15 && i31 < i) {
                            i30 = z ? i30 - (-widgetRun4.end.mMargin) : i30 + (-widgetRun4.end.mMargin);
                        }
                    }
                }
                return;
            }
            if (i28 == 0) {
                int i33 = (i13 - i4) / (i3 + 1);
                if (i5 > 0) {
                    i33 = i7;
                }
                int i34 = i6;
                for (int i35 = i7; i35 < size; i35++) {
                    WidgetRun widgetRun5 = this.mWidgets.get(z ? size - (i35 + 1) : i35);
                    if (widgetRun5.mWidget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i34);
                        widgetRun5.end.resolve(i34);
                    } else {
                        int i36 = z ? i34 - i33 : i34 + i33;
                        if (i35 > 0 && i35 >= i14) {
                            i36 = z ? i36 - widgetRun5.start.mMargin : i36 + widgetRun5.start.mMargin;
                        }
                        if (z) {
                            widgetRun5.end.resolve(i36);
                        } else {
                            widgetRun5.start.resolve(i36);
                        }
                        int iMin = widgetRun5.mDimension.value;
                        if (widgetRun5.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            iMin = Math.min(iMin, widgetRun5.mDimension.wrapValue);
                        }
                        i34 = z ? i36 - iMin : i36 + iMin;
                        if (z) {
                            widgetRun5.start.resolve(i34);
                        } else {
                            widgetRun5.end.resolve(i34);
                        }
                        if (i35 < i15 && i35 < i) {
                            i34 = z ? i34 - (-widgetRun5.end.mMargin) : i34 + (-widgetRun5.end.mMargin);
                        }
                    }
                }
                return;
            }
            if (i28 == 2) {
                float horizontalBiasPercent = this.orientation == 0 ? this.mWidget.getHorizontalBiasPercent() : this.mWidget.getVerticalBiasPercent();
                if (z) {
                    horizontalBiasPercent = 1.0f - horizontalBiasPercent;
                }
                int i37 = (int) (((i13 - i4) * horizontalBiasPercent) + f3);
                if (i37 < 0 || i5 > 0) {
                    i37 = i7;
                }
                int i38 = z ? i6 - i37 : i6 + i37;
                for (int i39 = i7; i39 < size; i39++) {
                    WidgetRun widgetRun6 = this.mWidgets.get(z ? size - (i39 + 1) : i39);
                    if (widgetRun6.mWidget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i38);
                        widgetRun6.end.resolve(i38);
                    } else {
                        if (i39 > 0 && i39 >= i14) {
                            i38 = z ? i38 - widgetRun6.start.mMargin : i38 + widgetRun6.start.mMargin;
                        }
                        if (z) {
                            widgetRun6.end.resolve(i38);
                        } else {
                            widgetRun6.start.resolve(i38);
                        }
                        int i40 = widgetRun6.mDimension.value;
                        if (widgetRun6.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i40 = widgetRun6.mDimension.wrapValue;
                        }
                        i38 = z ? i38 - i40 : i38 + i40;
                        if (z) {
                            widgetRun6.start.resolve(i38);
                        } else {
                            widgetRun6.end.resolve(i38);
                        }
                        if (i39 < i15 && i39 < i) {
                            i38 = z ? i38 - (-widgetRun6.end.mMargin) : i38 + (-widgetRun6.end.mMargin);
                        }
                    }
                }
            }
        }
    }
}
