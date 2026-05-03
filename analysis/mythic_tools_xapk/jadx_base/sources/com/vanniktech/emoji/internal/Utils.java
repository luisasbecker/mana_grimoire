package com.vanniktech.emoji.internal;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nJ\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0015\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J\u0015\u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000eH\u0002J\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u000eH\u0002J\u0015\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b J\u001d\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0019H\u0000¢\u0006\u0002\b&J)\u0010'\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010(\u001a\u00020\u00052\b\b\u0001\u0010)\u001a\u00020\u0005H\u0001¢\u0006\u0002\b*¨\u0006+"}, d2 = {"Lcom/vanniktech/emoji/internal/Utils;", "", "<init>", "()V", "dpToPx", "", "context", "Landroid/content/Context;", "dp", "", "dpToPx$emoji_release", "getOrientation", "getProperWidth", "activity", "Landroid/app/Activity;", "getProperWidth$emoji_release", "shouldOverrideRegularCondition", "", "editText", "Landroid/widget/EditText;", "shouldOverrideRegularCondition$emoji_release", "getProperHeight", "getProperHeight$emoji_release", "getScreenWidth", "locationOnScreen", "Landroid/graphics/Point;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "locationOnScreen$emoji_release", "windowVisibleDisplayFrame", "Landroid/graphics/Rect;", "asActivity", "asActivity$emoji_release", "fixPopupLocation", "", "popupWindow", "Landroid/widget/PopupWindow;", "desiredLocation", "fixPopupLocation$emoji_release", "resolveColor", "resource", "fallback", "resolveColor$emoji_release", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    static final void fixPopupLocation$lambda$0(PopupWindow popupWindow, Point point) {
        Utils utils = INSTANCE;
        View contentView = popupWindow.getContentView();
        Intrinsics.checkNotNullExpressionValue(contentView, "getContentView(...)");
        Point pointLocationOnScreen$emoji_release = utils.locationOnScreen$emoji_release(contentView);
        if (pointLocationOnScreen$emoji_release.x == point.x && pointLocationOnScreen$emoji_release.y == point.y) {
            return;
        }
        int i = pointLocationOnScreen$emoji_release.x - point.x;
        int i2 = pointLocationOnScreen$emoji_release.y - point.y;
        popupWindow.update(pointLocationOnScreen$emoji_release.x > point.x ? point.x - i : point.x + i, pointLocationOnScreen$emoji_release.y > point.y ? point.y - i2 : point.y + i2, -1, -1);
    }

    private final int getOrientation(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    private final int getScreenWidth(Activity context) {
        return dpToPx$emoji_release(context, context.getResources().getConfiguration().screenWidthDp);
    }

    private final Rect windowVisibleDisplayFrame(Activity context) {
        Rect rect = new Rect();
        context.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    public final Activity asActivity$emoji_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        throw new IllegalStateException("The passed Context is not an Activity.".toString());
    }

    public final int dpToPx$emoji_release(Context context, float dp) {
        Intrinsics.checkNotNullParameter(context, "context");
        return MathKt.roundToInt(TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public final void fixPopupLocation$emoji_release(final PopupWindow popupWindow, final Point desiredLocation) {
        Intrinsics.checkNotNullParameter(popupWindow, "popupWindow");
        Intrinsics.checkNotNullParameter(desiredLocation, "desiredLocation");
        popupWindow.getContentView().post(new Runnable() { // from class: com.vanniktech.emoji.internal.Utils$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Utils.fixPopupLocation$lambda$0(popupWindow, desiredLocation);
            }
        });
    }

    public final int getProperHeight$emoji_release(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return windowVisibleDisplayFrame(activity).bottom;
    }

    public final int getProperWidth$emoji_release(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return getOrientation(activity) == 1 ? windowVisibleDisplayFrame(activity).right : getScreenWidth(activity);
    }

    public final Point locationOnScreen$emoji_release(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new Point(iArr[0], iArr[1]);
    }

    public final int resolveColor$emoji_release(Context context, int resource, int fallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(resource, typedValue, true);
        int color = typedValue.resourceId != 0 ? ContextCompat.getColor(context, typedValue.resourceId) : typedValue.data;
        return color != 0 ? color : ContextCompat.getColor(context, fallback);
    }

    public final boolean shouldOverrideRegularCondition$emoji_release(Context context, EditText editText) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(editText, "editText");
        return (editText.getImeOptions() & 268435456) == 0 && getOrientation(context) == 2;
    }
}
