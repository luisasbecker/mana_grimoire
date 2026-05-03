package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetRun implements Dependency {
    protected ConstraintWidget.DimensionBehaviour mDimensionBehavior;
    RunGroup mRunGroup;
    ConstraintWidget mWidget;
    public int matchConstraintsType;
    DimensionDependency mDimension = new DimensionDependency(this);
    public int orientation = 0;
    boolean mResolved = false;
    public DependencyNode start = new DependencyNode(this);
    public DependencyNode end = new DependencyNode(this);
    protected RunType mRunType = RunType.NONE;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.WidgetRun$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.mWidget = constraintWidget;
    }

    private void resolveDimension(int i, int i2) {
        int i3 = this.matchConstraintsType;
        if (i3 == 0) {
            this.mDimension.resolve(getLimitedDimension(i2, i));
            return;
        }
        if (i3 == 1) {
            this.mDimension.resolve(Math.min(getLimitedDimension(this.mDimension.wrapValue, i), i2));
            return;
        }
        if (i3 == 2) {
            ConstraintWidget parent = this.mWidget.getParent();
            if (parent != null) {
                if ((i == 0 ? parent.mHorizontalRun : parent.mVerticalRun).mDimension.resolved) {
                    ConstraintWidget constraintWidget = this.mWidget;
                    this.mDimension.resolve(getLimitedDimension((int) ((r6.mDimension.value * (i == 0 ? constraintWidget.mMatchConstraintPercentWidth : constraintWidget.mMatchConstraintPercentHeight)) + 0.5f), i));
                    return;
                }
                return;
            }
            return;
        }
        if (i3 != 3) {
            return;
        }
        if (this.mWidget.mHorizontalRun.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.mWidget.mHorizontalRun.matchConstraintsType == 3 && this.mWidget.mVerticalRun.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.mWidget.mVerticalRun.matchConstraintsType == 3) {
            return;
        }
        ConstraintWidget constraintWidget2 = this.mWidget;
        if ((i == 0 ? constraintWidget2.mVerticalRun : constraintWidget2.mHorizontalRun).mDimension.resolved) {
            float dimensionRatio = this.mWidget.getDimensionRatio();
            this.mDimension.resolve(i == 1 ? (int) ((r6.mDimension.value / dimensionRatio) + 0.5f) : (int) ((dimensionRatio * r6.mDimension.value) + 0.5f));
        }
    }

    protected final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i) {
        dependencyNode.mTargets.add(dependencyNode2);
        dependencyNode.mMargin = i;
        dependencyNode2.mDependencies.add(dependencyNode);
    }

    protected final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i, DimensionDependency dimensionDependency) {
        dependencyNode.mTargets.add(dependencyNode2);
        dependencyNode.mTargets.add(this.mDimension);
        dependencyNode.mMarginFactor = i;
        dependencyNode.mMarginDependency = dimensionDependency;
        dependencyNode2.mDependencies.add(dependencyNode);
        dimensionDependency.mDependencies.add(dependencyNode);
    }

    abstract void apply();

    abstract void applyToWidget();

    abstract void clear();

    protected final int getLimitedDimension(int i, int i2) {
        ConstraintWidget constraintWidget = this.mWidget;
        if (i2 == 0) {
            int i3 = constraintWidget.mMatchConstraintMaxWidth;
            int iMax = Math.max(this.mWidget.mMatchConstraintMinWidth, i);
            if (i3 > 0) {
                iMax = Math.min(i3, i);
            }
            if (iMax != i) {
                return iMax;
            }
        } else {
            int i4 = constraintWidget.mMatchConstraintMaxHeight;
            int iMax2 = Math.max(this.mWidget.mMatchConstraintMinHeight, i);
            if (i4 > 0) {
                iMax2 = Math.min(i4, i);
            }
            if (iMax2 != i) {
                return iMax2;
            }
        }
        return i;
    }

    protected final DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor.mTarget.mOwner;
        int i = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[constraintAnchor.mTarget.mType.ordinal()];
        if (i == 1) {
            return constraintWidget.mHorizontalRun.start;
        }
        if (i == 2) {
            return constraintWidget.mHorizontalRun.end;
        }
        if (i == 3) {
            return constraintWidget.mVerticalRun.start;
        }
        if (i == 4) {
            return constraintWidget.mVerticalRun.baseline;
        }
        if (i != 5) {
            return null;
        }
        return constraintWidget.mVerticalRun.end;
    }

    protected final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i) {
        if (constraintAnchor.mTarget == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor.mTarget.mOwner;
        WidgetRun widgetRun = i == 0 ? constraintWidget.mHorizontalRun : constraintWidget.mVerticalRun;
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[constraintAnchor.mTarget.mType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.end;
        }
        return widgetRun.start;
    }

    public long getWrapDimension() {
        if (this.mDimension.resolved) {
            return this.mDimension.value;
        }
        return 0L;
    }

    public boolean isCenterConnection() {
        int size = this.start.mTargets.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (this.start.mTargets.get(i2).mRun != this) {
                i++;
            }
        }
        int size2 = this.end.mTargets.size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (this.end.mTargets.get(i3).mRun != this) {
                i++;
            }
        }
        return i >= 2;
    }

    public boolean isDimensionResolved() {
        return this.mDimension.resolved;
    }

    public boolean isResolved() {
        return this.mResolved;
    }

    abstract void reset();

    abstract boolean supportsWrapComputation();

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
    }

    protected void updateRunCenter(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        DependencyNode target = getTarget(constraintAnchor);
        DependencyNode target2 = getTarget(constraintAnchor2);
        if (target.resolved && target2.resolved) {
            int margin = target.value + constraintAnchor.getMargin();
            int margin2 = target2.value - constraintAnchor2.getMargin();
            int i2 = margin2 - margin;
            if (!this.mDimension.resolved && this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                resolveDimension(i, i2);
            }
            if (this.mDimension.resolved) {
                if (this.mDimension.value == i2) {
                    this.start.resolve(margin);
                    this.end.resolve(margin2);
                    return;
                }
                ConstraintWidget constraintWidget = this.mWidget;
                float horizontalBiasPercent = i == 0 ? constraintWidget.getHorizontalBiasPercent() : constraintWidget.getVerticalBiasPercent();
                if (target == target2) {
                    margin = target.value;
                    margin2 = target2.value;
                    horizontalBiasPercent = 0.5f;
                }
                this.start.resolve((int) (margin + 0.5f + (((margin2 - margin) - this.mDimension.value) * horizontalBiasPercent)));
                this.end.resolve(this.start.value + this.mDimension.value);
            }
        }
    }

    protected void updateRunEnd(Dependency dependency) {
    }

    protected void updateRunStart(Dependency dependency) {
    }

    public long wrapSize(int i) {
        if (!this.mDimension.resolved) {
            return 0L;
        }
        long j = this.mDimension.value;
        return isCenterConnection() ? j + ((long) (this.start.mMargin - this.end.mMargin)) : i == 0 ? j + ((long) this.start.mMargin) : j - ((long) this.end.mMargin);
    }
}
