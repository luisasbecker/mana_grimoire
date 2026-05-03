package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.InspectionCompanion;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<LinearLayoutCompat> {
        private int mBaselineAlignedChildIndexId;
        private int mBaselineAlignedId;
        private int mDividerId;
        private int mDividerPaddingId;
        private int mGravityId;
        private int mMeasureWithLargestChildId;
        private int mOrientationId;
        private boolean mPropertiesMapped = false;
        private int mShowDividersId;
        private int mWeightSumId;

        @Override // android.view.inspector.InspectionCompanion
        public void mapProperties(PropertyMapper propertyMapper) {
            this.mBaselineAlignedId = propertyMapper.mapBoolean("baselineAligned", R.attr.baselineAligned);
            this.mBaselineAlignedChildIndexId = propertyMapper.mapInt("baselineAlignedChildIndex", R.attr.baselineAlignedChildIndex);
            this.mGravityId = propertyMapper.mapGravity("gravity", R.attr.gravity);
            this.mOrientationId = propertyMapper.mapIntEnum("orientation", R.attr.orientation, new IntFunction<String>() { // from class: androidx.appcompat.widget.LinearLayoutCompat.InspectionCompanion.1
                @Override // java.util.function.IntFunction
                public String apply(int i) {
                    return i != 0 ? i != 1 ? String.valueOf(i) : "vertical" : "horizontal";
                }
            });
            this.mWeightSumId = propertyMapper.mapFloat("weightSum", R.attr.weightSum);
            this.mDividerId = propertyMapper.mapObject("divider", androidx.appcompat.R.attr.divider);
            this.mDividerPaddingId = propertyMapper.mapInt("dividerPadding", androidx.appcompat.R.attr.dividerPadding);
            this.mMeasureWithLargestChildId = propertyMapper.mapBoolean("measureWithLargestChild", androidx.appcompat.R.attr.measureWithLargestChild);
            this.mShowDividersId = propertyMapper.mapIntFlag("showDividers", androidx.appcompat.R.attr.showDividers, new IntFunction<Set<String>>() { // from class: androidx.appcompat.widget.LinearLayoutCompat.InspectionCompanion.2
                @Override // java.util.function.IntFunction
                public Set<String> apply(int i) {
                    HashSet hashSet = new HashSet();
                    if (i == 0) {
                        hashSet.add("none");
                    }
                    if (i == 1) {
                        hashSet.add("beginning");
                    }
                    if (i == 2) {
                        hashSet.add("middle");
                    }
                    if (i == 4) {
                        hashSet.add("end");
                    }
                    return hashSet;
                }
            });
            this.mPropertiesMapped = true;
        }

        @Override // android.view.inspector.InspectionCompanion
        public void readProperties(LinearLayoutCompat linearLayoutCompat, PropertyReader propertyReader) {
            if (!this.mPropertiesMapped) {
                throw new InspectionCompanion.UninitializedPropertyMapException();
            }
            propertyReader.readBoolean(this.mBaselineAlignedId, linearLayoutCompat.isBaselineAligned());
            propertyReader.readInt(this.mBaselineAlignedChildIndexId, linearLayoutCompat.getBaselineAlignedChildIndex());
            propertyReader.readGravity(this.mGravityId, linearLayoutCompat.getGravity());
            propertyReader.readIntEnum(this.mOrientationId, linearLayoutCompat.getOrientation());
            propertyReader.readFloat(this.mWeightSumId, linearLayoutCompat.getWeightSum());
            propertyReader.readObject(this.mDividerId, linearLayoutCompat.getDividerDrawable());
            propertyReader.readInt(this.mDividerPaddingId, linearLayoutCompat.getDividerPadding());
            propertyReader.readBoolean(this.mMeasureWithLargestChildId, linearLayoutCompat.isMeasureWithLargestChildEnabled());
            propertyReader.readIntFlag(this.mShowDividersId, linearLayoutCompat.getShowDividers());
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, androidx.appcompat.R.styleable.LinearLayoutCompat, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, androidx.appcompat.R.styleable.LinearLayoutCompat, attributeSet, tintTypedArrayObtainStyledAttributes.getWrappedTypeArray(), i, 0);
        int i2 = tintTypedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = tintTypedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = tintTypedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = tintTypedArrayObtainStyledAttributes.getFloat(androidx.appcompat.R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = tintTypedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = tintTypedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = tintTypedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.LinearLayoutCompat_dividerPadding, 0);
        tintTypedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void forceUniformHeight(int i, int i2) {
        LinearLayoutCompat linearLayoutCompat;
        int i3;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int i4 = 0;
        while (i4 < i) {
            View virtualChildAt = this.getVirtualChildAt(i4);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i5 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    linearLayoutCompat = this;
                    i3 = i2;
                    linearLayoutCompat.measureChildWithMargins(virtualChildAt, i3, 0, iMakeMeasureSpec, 0);
                    layoutParams.width = i5;
                } else {
                    linearLayoutCompat = this;
                    i3 = i2;
                }
            }
            i4++;
            this = linearLayoutCompat;
            i2 = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void forceUniformWidth(int i, int i2) {
        LinearLayoutCompat linearLayoutCompat;
        int i3;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int i4 = 0;
        while (i4 < i) {
            View virtualChildAt = this.getVirtualChildAt(i4);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i5 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    linearLayoutCompat = this;
                    i3 = i2;
                    linearLayoutCompat.measureChildWithMargins(virtualChildAt, iMakeMeasureSpec, 0, i3, 0);
                    layoutParams.height = i5;
                } else {
                    linearLayoutCompat = this;
                    i3 = i2;
                }
            }
            i4++;
            this = linearLayoutCompat;
            i2 = i3;
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int i;
        int virtualChildCount = getVirtualChildCount();
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View virtualChildAt = getVirtualChildAt(i2);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, zIsLayoutRtl ? virtualChildAt.getRight() + layoutParams.rightMargin : (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (zIsLayoutRtl) {
                    left = virtualChildAt2.getLeft() - layoutParams2.leftMargin;
                    i = this.mDividerWidth;
                    right = left - i;
                } else {
                    right = virtualChildAt2.getRight() + layoutParams2.rightMargin;
                }
            } else if (zIsLayoutRtl) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.mDividerWidth;
                right = left - i;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View virtualChildAt = getVirtualChildAt(i);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            drawHorizontalDivider(canvas, virtualChildAt2 == null ? (getHeight() - getPaddingBottom()) - this.mDividerHeight : virtualChildAt2.getBottom() + ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return bottom + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    protected boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        int childCount = getChildCount();
        int i2 = this.mShowDividers;
        if (i == childCount) {
            return (i2 & 4) != 0;
        }
        if ((i2 & 2) != 0) {
            for (int i3 = i - 1; i3 >= 0; i3--) {
                if (getChildAt(i3).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutHorizontal(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        char c;
        char c2;
        int i7;
        int childrenSkipCount;
        int i8;
        int i9;
        int i10;
        int i11;
        int measuredHeight;
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i12 = i4 - i2;
        int paddingBottom = i12 - getPaddingBottom();
        int paddingBottom2 = (i12 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i13 = this.mGravity;
        int i14 = i13 & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i13, getLayoutDirection());
        char c3 = 2;
        char c4 = 1;
        int paddingLeft = absoluteGravity != 1 ? absoluteGravity != 5 ? getPaddingLeft() : ((getPaddingLeft() + i3) - i) - this.mTotalLength : getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        if (zIsLayoutRtl) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i15 = 0;
        while (i15 < virtualChildCount) {
            int i16 = i5 + (i6 * i15);
            int i17 = i15;
            View virtualChildAt = getVirtualChildAt(i16);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i16);
                childrenSkipCount = i17;
                i7 = paddingTop;
                c = c3;
                c2 = c4;
            } else {
                c = c3;
                c2 = c4;
                if (virtualChildAt.getVisibility() != 8) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight2 = virtualChildAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i18 = paddingLeft;
                    if (z) {
                        i8 = measuredHeight2;
                        int baseline = layoutParams.height != -1 ? virtualChildAt.getBaseline() : -1;
                        i9 = layoutParams.gravity;
                        if (i9 < 0) {
                            i9 = i14;
                        }
                        i10 = i9 & 112;
                        i7 = paddingTop;
                        if (i10 == 16) {
                            if (i10 == 48) {
                                i11 = i7 + layoutParams.topMargin;
                                if (baseline != -1) {
                                    i11 += iArr[c2] - baseline;
                                }
                            } else if (i10 != 80) {
                                i11 = i7;
                            } else {
                                i11 = (paddingBottom - i8) - layoutParams.bottomMargin;
                                if (baseline != -1) {
                                    measuredHeight = iArr2[c] - (virtualChildAt.getMeasuredHeight() - baseline);
                                }
                            }
                            int i19 = layoutParams.leftMargin + (hasDividerBeforeChildAt(i16) ? i18 + this.mDividerWidth : i18);
                            setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i19, i11, measuredWidth, i8);
                            int nextLocationOffset = i19 + layoutParams.rightMargin + measuredWidth + getNextLocationOffset(virtualChildAt);
                            childrenSkipCount = getChildrenSkipCount(virtualChildAt, i16) + i17;
                            paddingLeft = nextLocationOffset;
                        } else {
                            i11 = i7 + ((paddingBottom2 - i8) / 2) + layoutParams.topMargin;
                            measuredHeight = layoutParams.bottomMargin;
                        }
                        i11 -= measuredHeight;
                        int i192 = layoutParams.leftMargin + (hasDividerBeforeChildAt(i16) ? i18 + this.mDividerWidth : i18);
                        setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i192, i11, measuredWidth, i8);
                        int nextLocationOffset2 = i192 + layoutParams.rightMargin + measuredWidth + getNextLocationOffset(virtualChildAt);
                        childrenSkipCount = getChildrenSkipCount(virtualChildAt, i16) + i17;
                        paddingLeft = nextLocationOffset2;
                    } else {
                        i8 = measuredHeight2;
                    }
                    i9 = layoutParams.gravity;
                    if (i9 < 0) {
                    }
                    i10 = i9 & 112;
                    i7 = paddingTop;
                    if (i10 == 16) {
                    }
                    i11 -= measuredHeight;
                    int i1922 = layoutParams.leftMargin + (hasDividerBeforeChildAt(i16) ? i18 + this.mDividerWidth : i18);
                    setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i1922, i11, measuredWidth, i8);
                    int nextLocationOffset22 = i1922 + layoutParams.rightMargin + measuredWidth + getNextLocationOffset(virtualChildAt);
                    childrenSkipCount = getChildrenSkipCount(virtualChildAt, i16) + i17;
                    paddingLeft = nextLocationOffset22;
                } else {
                    i7 = paddingTop;
                    childrenSkipCount = i17;
                }
            }
            i15 = childrenSkipCount + 1;
            c3 = c;
            c4 = c2;
            paddingTop = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutVertical(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        LinearLayoutCompat linearLayoutCompat;
        int paddingLeft = getPaddingLeft();
        int i8 = i3 - i;
        int paddingRight = i8 - getPaddingRight();
        int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i9 = this.mGravity;
        int i10 = i9 & 112;
        int i11 = i9 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int paddingTop = i10 != 16 ? i10 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.mTotalLength : getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
        int childrenSkipCount = 0;
        while (childrenSkipCount < virtualChildCount) {
            View virtualChildAt = this.getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt == null) {
                paddingTop += this.measureNullChild(childrenSkipCount);
            } else {
                if (virtualChildAt.getVisibility() != 8) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight = virtualChildAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i12 = layoutParams.gravity;
                    if (i12 < 0) {
                        i12 = i11;
                    }
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(i12, this.getLayoutDirection()) & 7;
                    if (absoluteGravity == 1) {
                        i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                        i6 = layoutParams.rightMargin;
                    } else if (absoluteGravity != 5) {
                        i7 = layoutParams.leftMargin + paddingLeft;
                        int i13 = i7;
                        if (this.hasDividerBeforeChildAt(childrenSkipCount)) {
                            paddingTop += this.mDividerHeight;
                        }
                        int i14 = paddingTop + layoutParams.topMargin;
                        linearLayoutCompat = this;
                        linearLayoutCompat.setChildFrame(virtualChildAt, i13, i14 + this.getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                        paddingTop = i14 + measuredHeight + layoutParams.bottomMargin + linearLayoutCompat.getNextLocationOffset(virtualChildAt);
                        childrenSkipCount += linearLayoutCompat.getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                    } else {
                        i5 = paddingRight - measuredWidth;
                        i6 = layoutParams.rightMargin;
                    }
                    i7 = i5 - i6;
                    int i132 = i7;
                    if (this.hasDividerBeforeChildAt(childrenSkipCount)) {
                    }
                    int i142 = paddingTop + layoutParams.topMargin;
                    linearLayoutCompat = this;
                    linearLayoutCompat.setChildFrame(virtualChildAt, i132, i142 + this.getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                    paddingTop = i142 + measuredHeight + layoutParams.bottomMargin + linearLayoutCompat.getNextLocationOffset(virtualChildAt);
                    childrenSkipCount += linearLayoutCompat.getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                }
                childrenSkipCount++;
                this = linearLayoutCompat;
            }
            linearLayoutCompat = this;
            childrenSkipCount++;
            this = linearLayoutCompat;
        }
    }

    void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:205:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0456  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void measureHorizontal(int i, int i2) {
        int i3;
        int i4;
        float f;
        int i5;
        int i6;
        int i7;
        int iMax;
        int i8;
        int i9;
        int baseline;
        int i10;
        float f2;
        byte b;
        int i11;
        boolean z;
        int i12;
        int i13;
        int i14;
        int[] iArr;
        int i15;
        int i16;
        boolean z2;
        int[] iArr2;
        View view;
        boolean z3;
        boolean z4;
        int baseline2;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr3 = this.mMaxAscent;
        int[] iArr4 = this.mMaxDescent;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        iArr4[3] = -1;
        iArr4[2] = -1;
        iArr4[1] = -1;
        iArr4[0] = -1;
        boolean z5 = this.mBaselineAligned;
        boolean z6 = this.mUseLargestChild;
        int i17 = 1073741824;
        boolean z7 = mode == 1073741824;
        boolean z8 = z6;
        int childrenSkipCount = 0;
        int i18 = 0;
        int iMax2 = 0;
        boolean z9 = false;
        int iCombineMeasuredStates = 0;
        boolean z10 = false;
        boolean z11 = true;
        float f3 = 0.0f;
        int iMax3 = 0;
        int iMax4 = 0;
        while (true) {
            i3 = i18;
            if (childrenSkipCount >= virtualChildCount) {
                break;
            }
            boolean z12 = z5;
            View virtualChildAt = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(childrenSkipCount);
            } else if (virtualChildAt.getVisibility() == 8) {
                childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
            } else {
                if (hasDividerBeforeChildAt(childrenSkipCount)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                float f4 = f3 + layoutParams.weight;
                if (mode == i17 && layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                    int i19 = this.mTotalLength;
                    if (z7) {
                        this.mTotalLength = i19 + layoutParams.leftMargin + layoutParams.rightMargin;
                    } else {
                        this.mTotalLength = Math.max(i19, layoutParams.leftMargin + i19 + layoutParams.rightMargin);
                    }
                    if (z12) {
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        i13 = virtualChildCount;
                        i14 = mode;
                        iArr = iArr3;
                        iArr2 = iArr4;
                    } else {
                        i13 = virtualChildCount;
                        i14 = mode;
                        iArr = iArr3;
                        iArr2 = iArr4;
                        z9 = true;
                    }
                    i15 = i3;
                    i16 = 1073741824;
                    z2 = z8;
                    view = virtualChildAt;
                } else {
                    if (layoutParams.width != 0 || layoutParams.weight <= 0.0f) {
                        b = -2;
                        i11 = Integer.MIN_VALUE;
                    } else {
                        b = -2;
                        layoutParams.width = -2;
                        i11 = 0;
                    }
                    if (f4 == 0.0f) {
                        z = z8;
                        i12 = this.mTotalLength;
                    } else {
                        z = z8;
                        i12 = 0;
                    }
                    i13 = virtualChildCount;
                    i14 = mode;
                    iArr = iArr3;
                    i15 = i3;
                    i16 = 1073741824;
                    z2 = z;
                    iArr2 = iArr4;
                    int i20 = i11;
                    measureChildBeforeLayout(virtualChildAt, childrenSkipCount, i, i12, i2, 0);
                    view = virtualChildAt;
                    if (i20 != Integer.MIN_VALUE) {
                        layoutParams.width = i20;
                    }
                    int measuredWidth = view.getMeasuredWidth();
                    int i21 = this.mTotalLength;
                    if (z7) {
                        this.mTotalLength = i21 + layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(view);
                    } else {
                        this.mTotalLength = Math.max(i21, i21 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(view));
                    }
                    if (z2) {
                        iMax2 = Math.max(measuredWidth, iMax2);
                    }
                }
                if (mode2 == i16 || layoutParams.height != -1) {
                    z3 = false;
                } else {
                    z3 = true;
                    z10 = true;
                }
                int i22 = layoutParams.topMargin + layoutParams.bottomMargin;
                int measuredHeight = view.getMeasuredHeight() + i22;
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                if (!z12 || (baseline2 = view.getBaseline()) == -1) {
                    z4 = z3;
                } else {
                    int i23 = ((((layoutParams.gravity < 0 ? this.mGravity : layoutParams.gravity) & 112) >> 4) & (-2)) >> 1;
                    z4 = z3;
                    iArr[i23] = Math.max(iArr[i23], baseline2);
                    iArr2[i23] = Math.max(iArr2[i23], measuredHeight - baseline2);
                }
                int iMax5 = Math.max(i15, measuredHeight);
                z11 = z11 && layoutParams.height == -1;
                if (layoutParams.weight > 0.0f) {
                    if (!z4) {
                        i22 = measuredHeight;
                    }
                    iMax4 = Math.max(iMax4, i22);
                } else {
                    if (!z4) {
                        i22 = measuredHeight;
                    }
                    iMax3 = Math.max(iMax3, i22);
                }
                childrenSkipCount += getChildrenSkipCount(view, childrenSkipCount);
                i18 = iMax5;
                f3 = f4;
                childrenSkipCount++;
                z8 = z2;
                iArr4 = iArr2;
                z5 = z12;
                mode = i14;
                iArr3 = iArr;
                virtualChildCount = i13;
                i17 = 1073741824;
            }
            i13 = virtualChildCount;
            i14 = mode;
            iArr = iArr3;
            iArr2 = iArr4;
            i18 = i3;
            z2 = z8;
            childrenSkipCount++;
            z8 = z2;
            iArr4 = iArr2;
            z5 = z12;
            mode = i14;
            iArr3 = iArr;
            virtualChildCount = i13;
            i17 = 1073741824;
        }
        boolean z13 = z5;
        int i24 = virtualChildCount;
        int i25 = mode;
        int[] iArr5 = iArr3;
        int[] iArr6 = iArr4;
        int iCombineMeasuredStates2 = iCombineMeasuredStates;
        boolean z14 = z8;
        if (this.mTotalLength > 0) {
            i4 = i24;
            if (hasDividerBeforeChildAt(i4)) {
                this.mTotalLength += this.mDividerWidth;
            }
        } else {
            i4 = i24;
        }
        int i26 = iArr5[1];
        int iMax6 = (i26 == -1 && iArr5[0] == -1 && iArr5[2] == -1 && iArr5[3] == -1) ? i3 : Math.max(i3, Math.max(iArr5[3], Math.max(iArr5[0], Math.max(i26, iArr5[2]))) + Math.max(iArr6[3], Math.max(iArr6[0], Math.max(iArr6[1], iArr6[2]))));
        if (z14) {
            i5 = i25;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                this.mTotalLength = 0;
                int childrenSkipCount2 = 0;
                while (childrenSkipCount2 < i4) {
                    View virtualChildAt2 = getVirtualChildAt(childrenSkipCount2);
                    if (virtualChildAt2 == null) {
                        this.mTotalLength += measureNullChild(childrenSkipCount2);
                    } else if (virtualChildAt2.getVisibility() == 8) {
                        childrenSkipCount2 += getChildrenSkipCount(virtualChildAt2, childrenSkipCount2);
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                        int i27 = this.mTotalLength;
                        if (z7) {
                            f2 = f3;
                            this.mTotalLength = i27 + layoutParams2.leftMargin + iMax2 + layoutParams2.rightMargin + getNextLocationOffset(virtualChildAt2);
                        } else {
                            f2 = f3;
                            this.mTotalLength = Math.max(i27, i27 + iMax2 + layoutParams2.leftMargin + layoutParams2.rightMargin + getNextLocationOffset(virtualChildAt2));
                        }
                        childrenSkipCount2++;
                        f3 = f2;
                    }
                    f2 = f3;
                    childrenSkipCount2++;
                    f3 = f2;
                }
            }
            f = f3;
        } else {
            f = f3;
            i5 = i25;
        }
        int paddingLeft = this.mTotalLength + getPaddingLeft() + getPaddingRight();
        this.mTotalLength = paddingLeft;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0);
        int i28 = (16777215 & iResolveSizeAndState) - this.mTotalLength;
        if (z9 || (i28 != 0 && f > 0.0f)) {
            float f5 = this.mWeightSum;
            if (f5 > 0.0f) {
                f = f5;
            }
            iArr5[3] = -1;
            iArr5[2] = -1;
            iArr5[1] = -1;
            iArr5[0] = -1;
            iArr6[3] = -1;
            iArr6[2] = -1;
            iArr6[1] = -1;
            iArr6[0] = -1;
            this.mTotalLength = 0;
            iMax6 = -1;
            int i29 = 0;
            while (i29 < i4) {
                View virtualChildAt3 = getVirtualChildAt(i29);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    i8 = iResolveSizeAndState;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f6 = layoutParams3.weight;
                    if (f6 > 0.0f) {
                        int i30 = (int) ((i28 * f6) / f);
                        f -= f6;
                        i28 -= i30;
                        i8 = iResolveSizeAndState;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin, layoutParams3.height);
                        if (layoutParams3.width == 0) {
                            i10 = 1073741824;
                            if (i5 == 1073741824) {
                                if (i30 <= 0) {
                                    i30 = 0;
                                }
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i30, 1073741824), childMeasureSpec);
                            }
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, virtualChildAt3.getMeasuredState() & (-16777216));
                        } else {
                            i10 = 1073741824;
                        }
                        int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i30;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i10), childMeasureSpec);
                        iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, virtualChildAt3.getMeasuredState() & (-16777216));
                    } else {
                        i8 = iResolveSizeAndState;
                    }
                    int i31 = this.mTotalLength;
                    if (z7) {
                        this.mTotalLength = i31 + virtualChildAt3.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3);
                    } else {
                        this.mTotalLength = Math.max(i31, virtualChildAt3.getMeasuredWidth() + i31 + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3));
                    }
                    boolean z15 = mode2 != 1073741824 && layoutParams3.height == -1;
                    int i32 = layoutParams3.topMargin + layoutParams3.bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i32;
                    iMax6 = Math.max(iMax6, measuredHeight2);
                    if (!z15) {
                        i32 = measuredHeight2;
                    }
                    int iMax7 = Math.max(iMax3, i32);
                    if (z11) {
                        i9 = -1;
                        boolean z16 = layoutParams3.height == -1;
                        if (z13 && (baseline = virtualChildAt3.getBaseline()) != i9) {
                            int i33 = ((((layoutParams3.gravity >= 0 ? this.mGravity : layoutParams3.gravity) & 112) >> 4) & (-2)) >> 1;
                            iArr5[i33] = Math.max(iArr5[i33], baseline);
                            iArr6[i33] = Math.max(iArr6[i33], measuredHeight2 - baseline);
                        }
                        iMax3 = iMax7;
                        z11 = z16;
                    } else {
                        i9 = -1;
                    }
                    if (z13) {
                        int i332 = ((((layoutParams3.gravity >= 0 ? this.mGravity : layoutParams3.gravity) & 112) >> 4) & (-2)) >> 1;
                        iArr5[i332] = Math.max(iArr5[i332], baseline);
                        iArr6[i332] = Math.max(iArr6[i332], measuredHeight2 - baseline);
                    }
                    iMax3 = iMax7;
                    z11 = z16;
                }
                i29++;
                iResolveSizeAndState = i8;
            }
            i6 = iResolveSizeAndState;
            i7 = -16777216;
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            int i34 = iArr5[1];
            if (i34 != -1 || iArr5[0] != -1 || iArr5[2] != -1 || iArr5[3] != -1) {
                iMax6 = Math.max(iMax6, Math.max(iArr5[3], Math.max(iArr5[0], Math.max(i34, iArr5[2]))) + Math.max(iArr6[3], Math.max(iArr6[0], Math.max(iArr6[1], iArr6[2]))));
            }
            iMax = iMax3;
        } else {
            iMax = Math.max(iMax3, iMax4);
            if (z14 && i5 != 1073741824) {
                for (int i35 = 0; i35 < i4; i35++) {
                    View virtualChildAt4 = getVirtualChildAt(i35);
                    if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((LayoutParams) virtualChildAt4.getLayoutParams()).weight > 0.0f) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i6 = iResolveSizeAndState;
            i7 = -16777216;
        }
        int i36 = iCombineMeasuredStates2;
        if (!z11 && mode2 != 1073741824) {
            iMax6 = iMax;
        }
        setMeasuredDimension(i6 | (i36 & i7), View.resolveSizeAndState(Math.max(iMax6 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i36 << 16));
        if (z10) {
            forceUniformHeight(i4, i);
        }
    }

    int measureNullChild(int i) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void measureVertical(int i, int i2) {
        int i3;
        int iMax;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f;
        int i11;
        boolean z;
        int i12;
        int i13;
        View view;
        int i14;
        int i15;
        boolean z2;
        int iMax2;
        int i16;
        int i17;
        int iMax3;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i18 = this.mBaselineAlignedChildIndex;
        boolean z3 = this.mUseLargestChild;
        int childrenSkipCount = 0;
        int i19 = 0;
        int iMax4 = 0;
        int i20 = 0;
        int i21 = 0;
        int iMax5 = 0;
        boolean z4 = false;
        boolean z5 = false;
        float f2 = 0.0f;
        boolean z6 = true;
        while (true) {
            int i22 = 8;
            if (childrenSkipCount >= virtualChildCount) {
                float f3 = f2;
                int i23 = iMax4;
                int i24 = virtualChildCount;
                int i25 = mode2;
                boolean z7 = z3;
                int i26 = i19;
                int iMax6 = i20;
                int iCombineMeasuredStates = i21;
                if (this.mTotalLength > 0) {
                    i3 = i24;
                    if (hasDividerBeforeChildAt(i3)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i3 = i24;
                }
                int i27 = i25;
                if (z7 && (i27 == Integer.MIN_VALUE || i27 == 0)) {
                    this.mTotalLength = 0;
                    int childrenSkipCount2 = 0;
                    while (childrenSkipCount2 < i3) {
                        View virtualChildAt = getVirtualChildAt(childrenSkipCount2);
                        if (virtualChildAt == null) {
                            this.mTotalLength += measureNullChild(childrenSkipCount2);
                        } else if (virtualChildAt.getVisibility() == i22) {
                            childrenSkipCount2 += getChildrenSkipCount(virtualChildAt, childrenSkipCount2);
                        } else {
                            LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                            int i28 = this.mTotalLength;
                            this.mTotalLength = Math.max(i28, i28 + i23 + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt));
                        }
                        childrenSkipCount2++;
                        i22 = 8;
                    }
                }
                int paddingTop = this.mTotalLength + getPaddingTop() + getPaddingBottom();
                this.mTotalLength = paddingTop;
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0);
                int i29 = (16777215 & iResolveSizeAndState) - this.mTotalLength;
                if (z4 || (i29 != 0 && f3 > 0.0f)) {
                    float f4 = this.mWeightSum;
                    if (f4 > 0.0f) {
                        f3 = f4;
                    }
                    this.mTotalLength = 0;
                    int i30 = i29;
                    int i31 = 0;
                    while (i31 < i3) {
                        View virtualChildAt2 = getVirtualChildAt(i31);
                        if (virtualChildAt2.getVisibility() == 8) {
                            i5 = i27;
                            i4 = i31;
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                            float f5 = layoutParams2.weight;
                            if (f5 > 0.0f) {
                                int i32 = (int) ((i30 * f5) / f3);
                                f3 -= f5;
                                i30 -= i32;
                                i4 = i31;
                                int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams2.leftMargin + layoutParams2.rightMargin, layoutParams2.width);
                                if (layoutParams2.height == 0) {
                                    i7 = 1073741824;
                                    if (i27 == 1073741824) {
                                        if (i32 <= 0) {
                                            i32 = 0;
                                        }
                                        virtualChildAt2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i32, 1073741824));
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, virtualChildAt2.getMeasuredState() & (-256));
                                } else {
                                    i7 = 1073741824;
                                }
                                int measuredHeight = virtualChildAt2.getMeasuredHeight() + i32;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                virtualChildAt2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i7));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, virtualChildAt2.getMeasuredState() & (-256));
                            } else {
                                i4 = i31;
                            }
                            int i33 = layoutParams2.leftMargin + layoutParams2.rightMargin;
                            int measuredWidth = virtualChildAt2.getMeasuredWidth() + i33;
                            iMax6 = Math.max(iMax6, measuredWidth);
                            if (mode != 1073741824) {
                                i5 = i27;
                                i6 = -1;
                                if (layoutParams2.width != -1) {
                                }
                                int iMax7 = Math.max(iMax5, i33);
                                boolean z8 = !z6 && layoutParams2.width == i6;
                                int i34 = this.mTotalLength;
                                this.mTotalLength = Math.max(i34, virtualChildAt2.getMeasuredHeight() + i34 + layoutParams2.topMargin + layoutParams2.bottomMargin + getNextLocationOffset(virtualChildAt2));
                                iMax5 = iMax7;
                                z6 = z8;
                            } else {
                                i5 = i27;
                                i6 = -1;
                            }
                            i33 = measuredWidth;
                            int iMax72 = Math.max(iMax5, i33);
                            if (z6) {
                                int i342 = this.mTotalLength;
                                this.mTotalLength = Math.max(i342, virtualChildAt2.getMeasuredHeight() + i342 + layoutParams2.topMargin + layoutParams2.bottomMargin + getNextLocationOffset(virtualChildAt2));
                                iMax5 = iMax72;
                                z6 = z8;
                            }
                        }
                        i31 = i4 + 1;
                        i27 = i5;
                    }
                    this.mTotalLength += getPaddingTop() + getPaddingBottom();
                    iMax = iMax5;
                } else {
                    iMax = Math.max(iMax5, i26);
                    if (z7 && i27 != 1073741824) {
                        for (int i35 = 0; i35 < i3; i35++) {
                            View virtualChildAt3 = getVirtualChildAt(i35);
                            if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LayoutParams) virtualChildAt3.getLayoutParams()).weight > 0.0f) {
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i23, 1073741824));
                            }
                        }
                    }
                }
                if (!z6 && mode != 1073741824) {
                    iMax6 = iMax;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax6 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, iCombineMeasuredStates), iResolveSizeAndState);
                if (z5) {
                    forceUniformWidth(i3, i2);
                    return;
                }
                return;
            }
            float f6 = f2;
            View virtualChildAt4 = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt4 == null) {
                this.mTotalLength += measureNullChild(childrenSkipCount);
            } else if (virtualChildAt4.getVisibility() == 8) {
                childrenSkipCount += getChildrenSkipCount(virtualChildAt4, childrenSkipCount);
            } else {
                if (hasDividerBeforeChildAt(childrenSkipCount)) {
                    this.mTotalLength += this.mDividerHeight;
                }
                LayoutParams layoutParams3 = (LayoutParams) virtualChildAt4.getLayoutParams();
                float f7 = f6 + layoutParams3.weight;
                if (mode2 == 1073741824 && layoutParams3.height == 0 && layoutParams3.weight > 0.0f) {
                    int i36 = this.mTotalLength;
                    this.mTotalLength = Math.max(i36, layoutParams3.topMargin + i36 + layoutParams3.bottomMargin);
                    i11 = virtualChildCount;
                    z = z3;
                    f = f7;
                    z4 = true;
                    view = virtualChildAt4;
                    i13 = i19;
                    i12 = i21;
                    i14 = mode2;
                    i15 = i20;
                } else {
                    if (layoutParams3.height != 0 || layoutParams3.weight <= 0.0f) {
                        i8 = Integer.MIN_VALUE;
                    } else {
                        layoutParams3.height = -2;
                        i8 = 0;
                    }
                    if (f7 == 0.0f) {
                        int i37 = i21;
                        i10 = this.mTotalLength;
                        i9 = i37;
                    } else {
                        i9 = i21;
                        i10 = 0;
                    }
                    int i38 = iMax4;
                    f = f7;
                    i11 = virtualChildCount;
                    z = z3;
                    i12 = i9;
                    i13 = i19;
                    view = virtualChildAt4;
                    i14 = mode2;
                    i15 = i20;
                    measureChildBeforeLayout(view, childrenSkipCount, i, 0, i2, i10);
                    if (i8 != Integer.MIN_VALUE) {
                        layoutParams3.height = i8;
                    }
                    int measuredHeight2 = view.getMeasuredHeight();
                    int i39 = this.mTotalLength;
                    this.mTotalLength = Math.max(i39, i39 + measuredHeight2 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(view));
                    iMax4 = z ? Math.max(measuredHeight2, i38) : i38;
                }
                if (i18 >= 0 && i18 == childrenSkipCount + 1) {
                    this.mBaselineChildTop = this.mTotalLength;
                }
                if (childrenSkipCount < i18 && layoutParams3.weight > 0.0f) {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
                if (mode == 1073741824 || layoutParams3.width != -1) {
                    z2 = false;
                } else {
                    z2 = true;
                    z5 = true;
                }
                int i40 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                int measuredWidth2 = view.getMeasuredWidth() + i40;
                iMax2 = Math.max(i15, measuredWidth2);
                i16 = iMax4;
                int iCombineMeasuredStates2 = View.combineMeasuredStates(i12, view.getMeasuredState());
                if (z6) {
                    i17 = iCombineMeasuredStates2;
                    z6 = layoutParams3.width == -1;
                    if (layoutParams3.weight <= 0.0f) {
                        if (!z2) {
                            i40 = measuredWidth2;
                        }
                        iMax3 = Math.max(i13, i40);
                    } else {
                        if (!z2) {
                            i40 = measuredWidth2;
                        }
                        iMax5 = Math.max(iMax5, i40);
                        iMax3 = i13;
                    }
                    childrenSkipCount += getChildrenSkipCount(view, childrenSkipCount);
                    f2 = f;
                    i21 = i17;
                    childrenSkipCount++;
                    i19 = iMax3;
                    i20 = iMax2;
                    iMax4 = i16;
                    mode2 = i14;
                    z3 = z;
                    virtualChildCount = i11;
                } else {
                    i17 = iCombineMeasuredStates2;
                }
                if (layoutParams3.weight <= 0.0f) {
                }
                childrenSkipCount += getChildrenSkipCount(view, childrenSkipCount);
                f2 = f;
                i21 = i17;
                childrenSkipCount++;
                i19 = iMax3;
                i20 = iMax2;
                iMax4 = i16;
                mode2 = i14;
                z3 = z;
                virtualChildCount = i11;
            }
            i16 = iMax4;
            i11 = virtualChildCount;
            i14 = mode2;
            z = z3;
            f2 = f6;
            iMax3 = i19;
            iMax2 = i20;
            childrenSkipCount++;
            i19 = iMax3;
            i20 = iMax2;
            iMax4 = i16;
            mode2 = i14;
            z3 = z;
            virtualChildCount = i11;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
