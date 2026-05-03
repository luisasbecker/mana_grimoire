package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class BadgeState {
    private static final String BADGE_RESOURCE_TAG = "badge";
    int badgeFixedEdge;
    final float badgeHeight;
    final float badgeRadius;
    final float badgeWidth;
    final float badgeWithTextHeight;
    final float badgeWithTextRadius;
    final float badgeWithTextWidth;
    private final State currentState;
    final int horizontalInset;
    final int horizontalInsetWithText;
    int offsetAlignmentMode;
    private final State overridingState;

    public static final class State implements Parcelable {
        private static final int BADGE_NUMBER_NONE = -1;
        public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator<State>() { // from class: com.google.android.material.badge.BadgeState.State.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public State createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public State[] newArray(int i) {
                return new State[i];
            }
        };
        private static final int NOT_SET = -2;
        private Integer additionalHorizontalOffset;
        private Integer additionalVerticalOffset;
        private int alpha;
        private Boolean autoAdjustToWithinGrandparentBounds;
        private Integer backgroundColor;
        private Integer badgeFixedEdge;
        private Integer badgeGravity;
        private Integer badgeHorizontalPadding;
        private int badgeResId;
        private Integer badgeShapeAppearanceOverlayResId;
        private Integer badgeShapeAppearanceResId;
        private Integer badgeTextAppearanceResId;
        private Integer badgeTextColor;
        private Integer badgeVerticalPadding;
        private Integer badgeWithTextShapeAppearanceOverlayResId;
        private Integer badgeWithTextShapeAppearanceResId;
        private int contentDescriptionExceedsMaxBadgeNumberRes;
        private CharSequence contentDescriptionForText;
        private CharSequence contentDescriptionNumberless;
        private int contentDescriptionQuantityStrings;
        private Integer horizontalOffsetWithText;
        private Integer horizontalOffsetWithoutText;
        private Boolean isVisible;
        private Integer largeFontVerticalOffsetAdjustment;
        private int maxCharacterCount;
        private int maxNumber;
        private int number;
        private Locale numberLocale;
        private String text;
        private Integer verticalOffsetWithText;
        private Integer verticalOffsetWithoutText;

        public State() {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.maxNumber = -2;
            this.isVisible = true;
        }

        State(Parcel parcel) {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.maxNumber = -2;
            this.isVisible = true;
            this.badgeResId = parcel.readInt();
            this.backgroundColor = (Integer) parcel.readSerializable();
            this.badgeTextColor = (Integer) parcel.readSerializable();
            this.badgeTextAppearanceResId = (Integer) parcel.readSerializable();
            this.badgeShapeAppearanceResId = (Integer) parcel.readSerializable();
            this.badgeShapeAppearanceOverlayResId = (Integer) parcel.readSerializable();
            this.badgeWithTextShapeAppearanceResId = (Integer) parcel.readSerializable();
            this.badgeWithTextShapeAppearanceOverlayResId = (Integer) parcel.readSerializable();
            this.alpha = parcel.readInt();
            this.text = parcel.readString();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.maxNumber = parcel.readInt();
            this.contentDescriptionForText = parcel.readString();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = (Integer) parcel.readSerializable();
            this.badgeHorizontalPadding = (Integer) parcel.readSerializable();
            this.badgeVerticalPadding = (Integer) parcel.readSerializable();
            this.horizontalOffsetWithoutText = (Integer) parcel.readSerializable();
            this.verticalOffsetWithoutText = (Integer) parcel.readSerializable();
            this.horizontalOffsetWithText = (Integer) parcel.readSerializable();
            this.verticalOffsetWithText = (Integer) parcel.readSerializable();
            this.largeFontVerticalOffsetAdjustment = (Integer) parcel.readSerializable();
            this.additionalHorizontalOffset = (Integer) parcel.readSerializable();
            this.additionalVerticalOffset = (Integer) parcel.readSerializable();
            this.isVisible = (Boolean) parcel.readSerializable();
            this.numberLocale = (Locale) parcel.readSerializable();
            this.autoAdjustToWithinGrandparentBounds = (Boolean) parcel.readSerializable();
            this.badgeFixedEdge = (Integer) parcel.readSerializable();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.badgeResId);
            parcel.writeSerializable(this.backgroundColor);
            parcel.writeSerializable(this.badgeTextColor);
            parcel.writeSerializable(this.badgeTextAppearanceResId);
            parcel.writeSerializable(this.badgeShapeAppearanceResId);
            parcel.writeSerializable(this.badgeShapeAppearanceOverlayResId);
            parcel.writeSerializable(this.badgeWithTextShapeAppearanceResId);
            parcel.writeSerializable(this.badgeWithTextShapeAppearanceOverlayResId);
            parcel.writeInt(this.alpha);
            parcel.writeString(this.text);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            parcel.writeInt(this.maxNumber);
            CharSequence charSequence = this.contentDescriptionForText;
            parcel.writeString(charSequence != null ? charSequence.toString() : null);
            CharSequence charSequence2 = this.contentDescriptionNumberless;
            parcel.writeString(charSequence2 != null ? charSequence2.toString() : null);
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeSerializable(this.badgeGravity);
            parcel.writeSerializable(this.badgeHorizontalPadding);
            parcel.writeSerializable(this.badgeVerticalPadding);
            parcel.writeSerializable(this.horizontalOffsetWithoutText);
            parcel.writeSerializable(this.verticalOffsetWithoutText);
            parcel.writeSerializable(this.horizontalOffsetWithText);
            parcel.writeSerializable(this.verticalOffsetWithText);
            parcel.writeSerializable(this.largeFontVerticalOffsetAdjustment);
            parcel.writeSerializable(this.additionalHorizontalOffset);
            parcel.writeSerializable(this.additionalVerticalOffset);
            parcel.writeSerializable(this.isVisible);
            parcel.writeSerializable(this.numberLocale);
            parcel.writeSerializable(this.autoAdjustToWithinGrandparentBounds);
            parcel.writeSerializable(this.badgeFixedEdge);
        }
    }

    BadgeState(Context context, int i, int i2, int i3, State state) {
        State state2 = new State();
        this.currentState = state2;
        state = state == null ? new State() : state;
        if (i != 0) {
            state.badgeResId = i;
        }
        TypedArray typedArrayGenerateTypedArray = generateTypedArray(context, state.badgeResId, i2, i3);
        Resources resources = context.getResources();
        this.badgeRadius = typedArrayGenerateTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeRadius, -1);
        this.horizontalInset = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.horizontalInsetWithText = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.badgeWithTextRadius = typedArrayGenerateTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeWithTextRadius, -1);
        this.badgeWidth = typedArrayGenerateTypedArray.getDimension(R.styleable.Badge_badgeWidth, resources.getDimension(R.dimen.m3_badge_size));
        this.badgeWithTextWidth = typedArrayGenerateTypedArray.getDimension(R.styleable.Badge_badgeWithTextWidth, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.badgeHeight = typedArrayGenerateTypedArray.getDimension(R.styleable.Badge_badgeHeight, resources.getDimension(R.dimen.m3_badge_size));
        this.badgeWithTextHeight = typedArrayGenerateTypedArray.getDimension(R.styleable.Badge_badgeWithTextHeight, resources.getDimension(R.dimen.m3_badge_with_text_size));
        boolean z = true;
        this.offsetAlignmentMode = typedArrayGenerateTypedArray.getInt(R.styleable.Badge_offsetAlignmentMode, 1);
        this.badgeFixedEdge = typedArrayGenerateTypedArray.getInt(R.styleable.Badge_badgeFixedEdge, 0);
        state2.alpha = state.alpha == -2 ? 255 : state.alpha;
        if (state.number != -2) {
            state2.number = state.number;
        } else if (typedArrayGenerateTypedArray.hasValue(R.styleable.Badge_number)) {
            state2.number = typedArrayGenerateTypedArray.getInt(R.styleable.Badge_number, 0);
        } else {
            state2.number = -1;
        }
        if (state.text != null) {
            state2.text = state.text;
        } else if (typedArrayGenerateTypedArray.hasValue(R.styleable.Badge_badgeText)) {
            state2.text = typedArrayGenerateTypedArray.getString(R.styleable.Badge_badgeText);
        }
        state2.contentDescriptionForText = state.contentDescriptionForText;
        state2.contentDescriptionNumberless = state.contentDescriptionNumberless == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : state.contentDescriptionNumberless;
        state2.contentDescriptionQuantityStrings = state.contentDescriptionQuantityStrings == 0 ? R.plurals.mtrl_badge_content_description : state.contentDescriptionQuantityStrings;
        state2.contentDescriptionExceedsMaxBadgeNumberRes = state.contentDescriptionExceedsMaxBadgeNumberRes == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : state.contentDescriptionExceedsMaxBadgeNumberRes;
        if (state.isVisible != null && !state.isVisible.booleanValue()) {
            z = false;
        }
        state2.isVisible = Boolean.valueOf(z);
        state2.maxCharacterCount = state.maxCharacterCount == -2 ? typedArrayGenerateTypedArray.getInt(R.styleable.Badge_maxCharacterCount, -2) : state.maxCharacterCount;
        state2.maxNumber = state.maxNumber == -2 ? typedArrayGenerateTypedArray.getInt(R.styleable.Badge_maxNumber, -2) : state.maxNumber;
        state2.badgeShapeAppearanceResId = Integer.valueOf(state.badgeShapeAppearanceResId == null ? typedArrayGenerateTypedArray.getResourceId(R.styleable.Badge_badgeShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : state.badgeShapeAppearanceResId.intValue());
        state2.badgeShapeAppearanceOverlayResId = Integer.valueOf(state.badgeShapeAppearanceOverlayResId == null ? typedArrayGenerateTypedArray.getResourceId(R.styleable.Badge_badgeShapeAppearanceOverlay, 0) : state.badgeShapeAppearanceOverlayResId.intValue());
        state2.badgeWithTextShapeAppearanceResId = Integer.valueOf(state.badgeWithTextShapeAppearanceResId == null ? typedArrayGenerateTypedArray.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : state.badgeWithTextShapeAppearanceResId.intValue());
        state2.badgeWithTextShapeAppearanceOverlayResId = Integer.valueOf(state.badgeWithTextShapeAppearanceOverlayResId == null ? typedArrayGenerateTypedArray.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearanceOverlay, 0) : state.badgeWithTextShapeAppearanceOverlayResId.intValue());
        state2.backgroundColor = Integer.valueOf(state.backgroundColor == null ? readColorFromAttributes(context, typedArrayGenerateTypedArray, R.styleable.Badge_backgroundColor) : state.backgroundColor.intValue());
        state2.badgeTextAppearanceResId = Integer.valueOf(state.badgeTextAppearanceResId == null ? typedArrayGenerateTypedArray.getResourceId(R.styleable.Badge_badgeTextAppearance, R.style.TextAppearance_MaterialComponents_Badge) : state.badgeTextAppearanceResId.intValue());
        if (state.badgeTextColor != null) {
            state2.badgeTextColor = state.badgeTextColor;
        } else if (typedArrayGenerateTypedArray.hasValue(R.styleable.Badge_badgeTextColor)) {
            state2.badgeTextColor = Integer.valueOf(readColorFromAttributes(context, typedArrayGenerateTypedArray, R.styleable.Badge_badgeTextColor));
        } else {
            state2.badgeTextColor = Integer.valueOf(new TextAppearance(context, state2.badgeTextAppearanceResId.intValue()).getTextColor().getDefaultColor());
        }
        state2.badgeGravity = Integer.valueOf(state.badgeGravity == null ? typedArrayGenerateTypedArray.getInt(R.styleable.Badge_badgeGravity, 8388661) : state.badgeGravity.intValue());
        state2.badgeHorizontalPadding = Integer.valueOf(state.badgeHorizontalPadding == null ? typedArrayGenerateTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeWidePadding, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding)) : state.badgeHorizontalPadding.intValue());
        state2.badgeVerticalPadding = Integer.valueOf(state.badgeVerticalPadding == null ? typedArrayGenerateTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeVerticalPadding, resources.getDimensionPixelSize(R.dimen.m3_badge_with_text_vertical_padding)) : state.badgeVerticalPadding.intValue());
        state2.horizontalOffsetWithoutText = Integer.valueOf(state.horizontalOffsetWithoutText == null ? typedArrayGenerateTypedArray.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0) : state.horizontalOffsetWithoutText.intValue());
        state2.verticalOffsetWithoutText = Integer.valueOf(state.verticalOffsetWithoutText == null ? typedArrayGenerateTypedArray.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0) : state.verticalOffsetWithoutText.intValue());
        state2.horizontalOffsetWithText = Integer.valueOf(state.horizontalOffsetWithText == null ? typedArrayGenerateTypedArray.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, state2.horizontalOffsetWithoutText.intValue()) : state.horizontalOffsetWithText.intValue());
        state2.verticalOffsetWithText = Integer.valueOf(state.verticalOffsetWithText == null ? typedArrayGenerateTypedArray.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, state2.verticalOffsetWithoutText.intValue()) : state.verticalOffsetWithText.intValue());
        state2.largeFontVerticalOffsetAdjustment = Integer.valueOf(state.largeFontVerticalOffsetAdjustment == null ? typedArrayGenerateTypedArray.getDimensionPixelOffset(R.styleable.Badge_largeFontVerticalOffsetAdjustment, 0) : state.largeFontVerticalOffsetAdjustment.intValue());
        state2.additionalHorizontalOffset = Integer.valueOf(state.additionalHorizontalOffset == null ? 0 : state.additionalHorizontalOffset.intValue());
        state2.additionalVerticalOffset = Integer.valueOf(state.additionalVerticalOffset == null ? 0 : state.additionalVerticalOffset.intValue());
        state2.autoAdjustToWithinGrandparentBounds = Boolean.valueOf(state.autoAdjustToWithinGrandparentBounds == null ? typedArrayGenerateTypedArray.getBoolean(R.styleable.Badge_autoAdjustToWithinGrandparentBounds, false) : state.autoAdjustToWithinGrandparentBounds.booleanValue());
        typedArrayGenerateTypedArray.recycle();
        if (state.numberLocale == null) {
            state2.numberLocale = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            state2.numberLocale = state.numberLocale;
        }
        this.overridingState = state;
    }

    private TypedArray generateTypedArray(Context context, int i, int i2, int i3) {
        AttributeSet drawableXml;
        int styleAttribute;
        if (i != 0) {
            drawableXml = DrawableUtils.parseDrawableXml(context, i, BADGE_RESOURCE_TAG);
            styleAttribute = drawableXml.getStyleAttribute();
        } else {
            drawableXml = null;
            styleAttribute = 0;
        }
        return ThemeEnforcement.obtainStyledAttributes(context, drawableXml, R.styleable.Badge, i2, styleAttribute == 0 ? i3 : styleAttribute, new int[0]);
    }

    private static int readColorFromAttributes(Context context, TypedArray typedArray, int i) {
        return MaterialResources.getColorStateList(context, typedArray, i).getDefaultColor();
    }

    void clearNumber() {
        setNumber(-1);
    }

    void clearText() {
        setText(null);
    }

    int getAdditionalHorizontalOffset() {
        return this.currentState.additionalHorizontalOffset.intValue();
    }

    int getAdditionalVerticalOffset() {
        return this.currentState.additionalVerticalOffset.intValue();
    }

    int getAlpha() {
        return this.currentState.alpha;
    }

    int getBackgroundColor() {
        return this.currentState.backgroundColor.intValue();
    }

    int getBadgeGravity() {
        return this.currentState.badgeGravity.intValue();
    }

    int getBadgeHorizontalPadding() {
        return this.currentState.badgeHorizontalPadding.intValue();
    }

    int getBadgeShapeAppearanceOverlayResId() {
        return this.currentState.badgeShapeAppearanceOverlayResId.intValue();
    }

    int getBadgeShapeAppearanceResId() {
        return this.currentState.badgeShapeAppearanceResId.intValue();
    }

    int getBadgeTextColor() {
        return this.currentState.badgeTextColor.intValue();
    }

    int getBadgeVerticalPadding() {
        return this.currentState.badgeVerticalPadding.intValue();
    }

    int getBadgeWithTextShapeAppearanceOverlayResId() {
        return this.currentState.badgeWithTextShapeAppearanceOverlayResId.intValue();
    }

    int getBadgeWithTextShapeAppearanceResId() {
        return this.currentState.badgeWithTextShapeAppearanceResId.intValue();
    }

    int getContentDescriptionExceedsMaxBadgeNumberStringResource() {
        return this.currentState.contentDescriptionExceedsMaxBadgeNumberRes;
    }

    CharSequence getContentDescriptionForText() {
        return this.currentState.contentDescriptionForText;
    }

    CharSequence getContentDescriptionNumberless() {
        return this.currentState.contentDescriptionNumberless;
    }

    int getContentDescriptionQuantityStrings() {
        return this.currentState.contentDescriptionQuantityStrings;
    }

    int getHorizontalOffsetWithText() {
        return this.currentState.horizontalOffsetWithText.intValue();
    }

    int getHorizontalOffsetWithoutText() {
        return this.currentState.horizontalOffsetWithoutText.intValue();
    }

    int getLargeFontVerticalOffsetAdjustment() {
        return this.currentState.largeFontVerticalOffsetAdjustment.intValue();
    }

    int getMaxCharacterCount() {
        return this.currentState.maxCharacterCount;
    }

    int getMaxNumber() {
        return this.currentState.maxNumber;
    }

    int getNumber() {
        return this.currentState.number;
    }

    Locale getNumberLocale() {
        return this.currentState.numberLocale;
    }

    State getOverridingState() {
        return this.overridingState;
    }

    String getText() {
        return this.currentState.text;
    }

    int getTextAppearanceResId() {
        return this.currentState.badgeTextAppearanceResId.intValue();
    }

    int getVerticalOffsetWithText() {
        return this.currentState.verticalOffsetWithText.intValue();
    }

    int getVerticalOffsetWithoutText() {
        return this.currentState.verticalOffsetWithoutText.intValue();
    }

    boolean hasNumber() {
        return this.currentState.number != -1;
    }

    boolean hasText() {
        return this.currentState.text != null;
    }

    @Deprecated
    boolean isAutoAdjustedToGrandparentBounds() {
        return this.currentState.autoAdjustToWithinGrandparentBounds.booleanValue();
    }

    boolean isVisible() {
        return this.currentState.isVisible.booleanValue();
    }

    void setAdditionalHorizontalOffset(int i) {
        this.overridingState.additionalHorizontalOffset = Integer.valueOf(i);
        this.currentState.additionalHorizontalOffset = Integer.valueOf(i);
    }

    void setAdditionalVerticalOffset(int i) {
        this.overridingState.additionalVerticalOffset = Integer.valueOf(i);
        this.currentState.additionalVerticalOffset = Integer.valueOf(i);
    }

    void setAlpha(int i) {
        this.overridingState.alpha = i;
        this.currentState.alpha = i;
    }

    @Deprecated
    void setAutoAdjustToGrandparentBounds(boolean z) {
        this.overridingState.autoAdjustToWithinGrandparentBounds = Boolean.valueOf(z);
        this.currentState.autoAdjustToWithinGrandparentBounds = Boolean.valueOf(z);
    }

    void setBackgroundColor(int i) {
        this.overridingState.backgroundColor = Integer.valueOf(i);
        this.currentState.backgroundColor = Integer.valueOf(i);
    }

    void setBadgeGravity(int i) {
        this.overridingState.badgeGravity = Integer.valueOf(i);
        this.currentState.badgeGravity = Integer.valueOf(i);
    }

    void setBadgeHorizontalPadding(int i) {
        this.overridingState.badgeHorizontalPadding = Integer.valueOf(i);
        this.currentState.badgeHorizontalPadding = Integer.valueOf(i);
    }

    void setBadgeShapeAppearanceOverlayResId(int i) {
        this.overridingState.badgeShapeAppearanceOverlayResId = Integer.valueOf(i);
        this.currentState.badgeShapeAppearanceOverlayResId = Integer.valueOf(i);
    }

    void setBadgeShapeAppearanceResId(int i) {
        this.overridingState.badgeShapeAppearanceResId = Integer.valueOf(i);
        this.currentState.badgeShapeAppearanceResId = Integer.valueOf(i);
    }

    void setBadgeTextColor(int i) {
        this.overridingState.badgeTextColor = Integer.valueOf(i);
        this.currentState.badgeTextColor = Integer.valueOf(i);
    }

    void setBadgeVerticalPadding(int i) {
        this.overridingState.badgeVerticalPadding = Integer.valueOf(i);
        this.currentState.badgeVerticalPadding = Integer.valueOf(i);
    }

    void setBadgeWithTextShapeAppearanceOverlayResId(int i) {
        this.overridingState.badgeWithTextShapeAppearanceOverlayResId = Integer.valueOf(i);
        this.currentState.badgeWithTextShapeAppearanceOverlayResId = Integer.valueOf(i);
    }

    void setBadgeWithTextShapeAppearanceResId(int i) {
        this.overridingState.badgeWithTextShapeAppearanceResId = Integer.valueOf(i);
        this.currentState.badgeWithTextShapeAppearanceResId = Integer.valueOf(i);
    }

    void setContentDescriptionExceedsMaxBadgeNumberStringResource(int i) {
        this.overridingState.contentDescriptionExceedsMaxBadgeNumberRes = i;
        this.currentState.contentDescriptionExceedsMaxBadgeNumberRes = i;
    }

    void setContentDescriptionForText(CharSequence charSequence) {
        this.overridingState.contentDescriptionForText = charSequence;
        this.currentState.contentDescriptionForText = charSequence;
    }

    void setContentDescriptionNumberless(CharSequence charSequence) {
        this.overridingState.contentDescriptionNumberless = charSequence;
        this.currentState.contentDescriptionNumberless = charSequence;
    }

    void setContentDescriptionQuantityStringsResource(int i) {
        this.overridingState.contentDescriptionQuantityStrings = i;
        this.currentState.contentDescriptionQuantityStrings = i;
    }

    void setHorizontalOffsetWithText(int i) {
        this.overridingState.horizontalOffsetWithText = Integer.valueOf(i);
        this.currentState.horizontalOffsetWithText = Integer.valueOf(i);
    }

    void setHorizontalOffsetWithoutText(int i) {
        this.overridingState.horizontalOffsetWithoutText = Integer.valueOf(i);
        this.currentState.horizontalOffsetWithoutText = Integer.valueOf(i);
    }

    void setLargeFontVerticalOffsetAdjustment(int i) {
        this.overridingState.largeFontVerticalOffsetAdjustment = Integer.valueOf(i);
        this.currentState.largeFontVerticalOffsetAdjustment = Integer.valueOf(i);
    }

    void setMaxCharacterCount(int i) {
        this.overridingState.maxCharacterCount = i;
        this.currentState.maxCharacterCount = i;
    }

    void setMaxNumber(int i) {
        this.overridingState.maxNumber = i;
        this.currentState.maxNumber = i;
    }

    void setNumber(int i) {
        this.overridingState.number = i;
        this.currentState.number = i;
    }

    void setNumberLocale(Locale locale) {
        this.overridingState.numberLocale = locale;
        this.currentState.numberLocale = locale;
    }

    void setText(String str) {
        this.overridingState.text = str;
        this.currentState.text = str;
    }

    void setTextAppearanceResId(int i) {
        this.overridingState.badgeTextAppearanceResId = Integer.valueOf(i);
        this.currentState.badgeTextAppearanceResId = Integer.valueOf(i);
    }

    void setVerticalOffsetWithText(int i) {
        this.overridingState.verticalOffsetWithText = Integer.valueOf(i);
        this.currentState.verticalOffsetWithText = Integer.valueOf(i);
    }

    void setVerticalOffsetWithoutText(int i) {
        this.overridingState.verticalOffsetWithoutText = Integer.valueOf(i);
        this.currentState.verticalOffsetWithoutText = Integer.valueOf(i);
    }

    void setVisible(boolean z) {
        this.overridingState.isVisible = Boolean.valueOf(z);
        this.currentState.isVisible = Boolean.valueOf(z);
    }
}
