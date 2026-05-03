package androidx.core.view;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.ReplaceWith;
import androidx.collection.SimpleArrayMap;
import androidx.core.R;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.autofill.AutofillIdCompat;
import androidx.core.view.contentcapture.ContentCaptureSessionCompat;
import androidx.core.viewtree.ViewTree;
import androidx.webkit.ProxyConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;

    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;

    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;

    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;

    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_AUTO = 0;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO = 2;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO_EXCLUDE_DESCENDANTS = 8;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES_EXCLUDE_DESCENDANTS = 4;

    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;

    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;

    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;

    @Deprecated
    public static final int LAYOUT_DIRECTION_INHERIT = 2;

    @Deprecated
    public static final int LAYOUT_DIRECTION_LOCALE = 3;

    @Deprecated
    public static final int LAYOUT_DIRECTION_LTR = 0;

    @Deprecated
    public static final int LAYOUT_DIRECTION_RTL = 1;

    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;

    @Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;

    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;

    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;

    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;

    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;

    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    private static boolean sAccessibilityDelegateCheckFailed = false;
    private static Field sAccessibilityDelegateField = null;
    private static Method sChildrenDrawingOrderMethod = null;
    private static Method sDispatchFinishTemporaryDetach = null;
    private static Method sDispatchStartTemporaryDetach = null;
    private static boolean sTempDetachBound = false;
    private static boolean sTryHiddenViewTransformMatrixToGlobal = true;
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap;
    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    private static final OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = new OnReceiveContentViewBehavior() { // from class: androidx.core.view.ViewCompat$$ExternalSyntheticLambda0
        @Override // androidx.core.view.OnReceiveContentViewBehavior
        public final ContentInfoCompat onReceiveContent(ContentInfoCompat contentInfoCompat) {
            return ViewCompat.lambda$static$0(contentInfoCompat);
        }
    };
    private static final AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();

    static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private final WeakHashMap<View, Boolean> mPanesToVisible = new WeakHashMap<>();

        AccessibilityPaneVisibilityManager() {
        }

        private void checkPaneVisibility(Map.Entry<View, Boolean> entry) {
            View key = entry.getKey();
            boolean zBooleanValue = entry.getValue().booleanValue();
            boolean z = key.isShown() && key.getWindowVisibility() == 0;
            if (zBooleanValue != z) {
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(key, z ? 16 : 32);
                entry.setValue(Boolean.valueOf(z));
            }
        }

        private void registerForLayoutCallback(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void unregisterForLayoutCallback(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        void addAccessibilityPane(View view) {
            this.mPanesToVisible.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                registerForLayoutCallback(view);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                Iterator<Map.Entry<View, Boolean>> it = this.mPanesToVisible.entrySet().iterator();
                while (it.hasNext()) {
                    checkPaneVisibility(it.next());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            registerForLayoutCallback(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        void removeAccessibilityPane(View view) {
            this.mPanesToVisible.remove(view);
            view.removeOnAttachStateChangeListener(this);
            unregisterForLayoutCallback(view);
        }
    }

    static abstract class AccessibilityViewProperty<T> {
        private final int mContentChangeType;
        private final int mFrameworkMinimumSdk;
        private final int mTagKey;
        private final Class<T> mType;

        AccessibilityViewProperty(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        AccessibilityViewProperty(int i, Class<T> cls, int i2, int i3) {
            this.mTagKey = i;
            this.mType = cls;
            this.mContentChangeType = i2;
            this.mFrameworkMinimumSdk = i3;
        }

        private boolean frameworkAvailable() {
            return Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk;
        }

        boolean booleanNullToFalseEquals(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        abstract T frameworkGet(View view);

        abstract void frameworkSet(View view, T t);

        T get(View view) {
            if (frameworkAvailable()) {
                return frameworkGet(view);
            }
            T t = (T) view.getTag(this.mTagKey);
            if (this.mType.isInstance(t)) {
                return t;
            }
            return null;
        }

        void set(View view, T t) {
            if (frameworkAvailable()) {
                frameworkSet(view, t);
            } else if (shouldUpdate(get(view), t)) {
                ViewCompat.ensureAccessibilityDelegateCompat(view);
                view.setTag(this.mTagKey, t);
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, this.mContentChangeType);
            }
        }

        boolean shouldUpdate(T t, T t2) {
            return !t2.equals(t);
        }
    }

    static class Api20Impl {
        private Api20Impl() {
        }

        static WindowInsets dispatchApplyWindowInsets(View view, WindowInsets windowInsets) {
            return ViewGroupCompat.sCompatInsetsDispatchInstalled ? ViewGroupCompat.dispatchApplyWindowInsets(view, windowInsets) : view.dispatchApplyWindowInsets(windowInsets);
        }
    }

    private static class Api21Impl {
        private Api21Impl() {
        }

        static void callCompatInsetAnimationCallback(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static WindowInsetsCompat computeSystemWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        static void setOnApplyWindowInsetsListener(final View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener2 = onApplyWindowInsetsListener != null ? new View.OnApplyWindowInsetsListener() { // from class: androidx.core.view.ViewCompat.Api21Impl.1
                WindowInsetsCompat mLastInsets = null;

                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                    WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view2);
                    if (Build.VERSION.SDK_INT < 30) {
                        Api21Impl.callCompatInsetAnimationCallback(windowInsets, view);
                        if (windowInsetsCompat.equals(this.mLastInsets)) {
                            return onApplyWindowInsetsListener.onApplyWindowInsets(view2, windowInsetsCompat).toWindowInsets();
                        }
                    }
                    this.mLastInsets = windowInsetsCompat;
                    WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view2, windowInsetsCompat);
                    if (Build.VERSION.SDK_INT >= 30) {
                        return windowInsetsCompatOnApplyWindowInsets.toWindowInsets();
                    }
                    ViewCompat.requestApplyInsets(view2);
                    return windowInsetsCompatOnApplyWindowInsets.toWindowInsets();
                }
            } : null;
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, onApplyWindowInsetsListener2);
            }
            if (view.getTag(R.id.tag_compat_insets_dispatch) != null) {
                return;
            }
            if (onApplyWindowInsetsListener2 != null) {
                view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListener2);
            } else {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            }
        }
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        public static WindowInsetsCompat getRootWindowInsets(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets);
            windowInsetsCompat.setRootWindowInsets(windowInsetsCompat);
            windowInsetsCompat.init(view.getRootView());
            return windowInsetsCompat;
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static void cancelDragAndDrop(View view) {
            view.cancelDragAndDrop();
        }

        static void dispatchFinishTemporaryDetach(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        static void dispatchStartTemporaryDetach(View view) {
            view.dispatchStartTemporaryDetach();
        }

        static void setPointerIcon(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        static boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
        }

        static void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void addKeyboardNavigationClusters(View view, Collection<View> collection, int i) {
            view.addKeyboardNavigationClusters(collection, i);
        }

        public static AutofillId getAutofillId(View view) {
            return view.getAutofillId();
        }

        static int getImportantForAutofill(View view) {
            return view.getImportantForAutofill();
        }

        static int getNextClusterForwardId(View view) {
            return view.getNextClusterForwardId();
        }

        static boolean hasExplicitFocusable(View view) {
            return view.hasExplicitFocusable();
        }

        static boolean isFocusedByDefault(View view) {
            return view.isFocusedByDefault();
        }

        static boolean isImportantForAutofill(View view) {
            return view.isImportantForAutofill();
        }

        static boolean isKeyboardNavigationCluster(View view) {
            return view.isKeyboardNavigationCluster();
        }

        static View keyboardNavigationClusterSearch(View view, View view2, int i) {
            return view.keyboardNavigationClusterSearch(view2, i);
        }

        static boolean restoreDefaultFocus(View view) {
            return view.restoreDefaultFocus();
        }

        static void setAutofillHints(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        static void setFocusedByDefault(View view, boolean z) {
            view.setFocusedByDefault(z);
        }

        static void setImportantForAutofill(View view, int i) {
            view.setImportantForAutofill(i);
        }

        static void setKeyboardNavigationCluster(View view, boolean z) {
            view.setKeyboardNavigationCluster(z);
        }

        static void setNextClusterForwardId(View view, int i) {
            view.setNextClusterForwardId(i);
        }

        static void setTooltipText(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static void addOnUnhandledKeyEventListener(View view, final OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.tag_unhandled_key_listeners);
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap();
                view.setTag(R.id.tag_unhandled_key_listeners, simpleArrayMap);
            }
            Objects.requireNonNull(onUnhandledKeyEventListenerCompat);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener() { // from class: androidx.core.view.ViewCompat$Api28Impl$$ExternalSyntheticLambda0
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return onUnhandledKeyEventListenerCompat.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            simpleArrayMap.put(onUnhandledKeyEventListenerCompat, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static CharSequence getAccessibilityPaneTitle(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean isAccessibilityHeading(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean isScreenReaderFocusable(View view) {
            return view.isScreenReaderFocusable();
        }

        static void removeOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.tag_unhandled_key_listeners);
            if (simpleArrayMap == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.get(onUnhandledKeyEventListenerCompat)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static <T> T requireViewById(View view, int i) {
            return (T) view.requireViewById(i);
        }

        static void setAccessibilityHeading(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        static void setAccessibilityPaneTitle(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void setAutofillId(View view, AutofillIdCompat autofillIdCompat) {
            view.setAutofillId(autofillIdCompat == null ? null : autofillIdCompat.toAutofillId());
        }

        static void setScreenReaderFocusable(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static View.AccessibilityDelegate getAccessibilityDelegate(View view) {
            return view.getAccessibilityDelegate();
        }

        static ContentCaptureSession getContentCaptureSession(View view) {
            return view.getContentCaptureSession();
        }

        static List<Rect> getSystemGestureExclusionRects(View view) {
            return view.getSystemGestureExclusionRects();
        }

        static void saveAttributeDataForStyleable(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }

        static void setContentCaptureSession(View view, ContentCaptureSessionCompat contentCaptureSessionCompat) {
            view.setContentCaptureSession(contentCaptureSessionCompat == null ? null : contentCaptureSessionCompat.toContentCaptureSession());
        }

        static void setSystemGestureExclusionRects(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }

        static void transformMatrixToGlobal(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static WindowInsets dispatchApplyWindowInsets(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static int getImportantForContentCapture(View view) {
            return view.getImportantForContentCapture();
        }

        static CharSequence getStateDescription(View view) {
            return view.getStateDescription();
        }

        public static WindowInsetsControllerCompat getWindowInsetsController(View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(windowInsetsController);
            }
            return null;
        }

        static boolean isImportantForContentCapture(View view) {
            return view.isImportantForContentCapture();
        }

        static void setImportantForContentCapture(View view, int i) {
            view.setImportantForContentCapture(i);
        }

        static void setStateDescription(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    private static final class Api31Impl {
        private Api31Impl() {
        }

        public static String[] getReceiveContentMimeTypes(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static ContentInfoCompat performReceiveContent(View view, ContentInfoCompat contentInfoCompat) {
            ContentInfo contentInfo = contentInfoCompat.toContentInfo();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfo);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfo ? contentInfoCompat : ContentInfoCompat.toContentInfoCompat(contentInfoPerformReceiveContent);
        }

        public static void setOnReceiveContentListener(View view, String[] strArr, OnReceiveContentListener onReceiveContentListener) {
            if (onReceiveContentListener == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new OnReceiveContentListenerAdapter(onReceiveContentListener));
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NestedScrollType {
    }

    private static final class OnReceiveContentListenerAdapter implements android.view.OnReceiveContentListener {
        private final OnReceiveContentListener mJetpackListener;

        OnReceiveContentListenerAdapter(OnReceiveContentListener onReceiveContentListener) {
            this.mJetpackListener = onReceiveContentListener;
        }

        @Override // android.view.OnReceiveContentListener
        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            ContentInfoCompat contentInfoCompat = ContentInfoCompat.toContentInfoCompat(contentInfo);
            ContentInfoCompat contentInfoCompatOnReceiveContent = this.mJetpackListener.onReceiveContent(view, contentInfoCompat);
            if (contentInfoCompatOnReceiveContent == null) {
                return null;
            }
            return contentInfoCompatOnReceiveContent == contentInfoCompat ? contentInfo : contentInfoCompatOnReceiveContent.toContentInfo();
        }
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollIndicators {
    }

    static class UnhandledKeyEventManager {
        private static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList<>();
        private WeakHashMap<View, Boolean> mViewsContainingListeners = null;
        private SparseArray<WeakReference<View>> mCapturedKeys = null;
        private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;

        UnhandledKeyEventManager() {
        }

        static UnhandledKeyEventManager at(View view) {
            UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(R.id.tag_unhandled_key_event_manager);
            if (unhandledKeyEventManager != null) {
                return unhandledKeyEventManager;
            }
            UnhandledKeyEventManager unhandledKeyEventManager2 = new UnhandledKeyEventManager();
            view.setTag(R.id.tag_unhandled_key_event_manager, unhandledKeyEventManager2);
            return unhandledKeyEventManager2;
        }

        private View dispatchInOrder(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewDispatchInOrder = dispatchInOrder(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewDispatchInOrder != null) {
                            return viewDispatchInOrder;
                        }
                    }
                }
                if (onUnhandledKeyEvent(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> getCapturedKeys() {
            if (this.mCapturedKeys == null) {
                this.mCapturedKeys = new SparseArray<>();
            }
            return this.mCapturedKeys;
        }

        private boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void recalcViewsWithUnhandled() {
            WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.mViewsContainingListeners == null) {
                    this.mViewsContainingListeners = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = sViewsWithListeners;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.mViewsContainingListeners.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.mViewsContainingListeners.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        static void registerListeningView(View view) {
            ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
            synchronized (arrayList) {
                Iterator<WeakReference<View>> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().get() == view) {
                        return;
                    }
                }
                sViewsWithListeners.add(new WeakReference<>(view));
            }
        }

        static void unregisterListeningView(View view) {
            synchronized (sViewsWithListeners) {
                int i = 0;
                while (true) {
                    ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
                    if (i >= arrayList.size()) {
                        return;
                    }
                    if (arrayList.get(i).get() == view) {
                        arrayList.remove(i);
                        return;
                    }
                    i++;
                }
            }
        }

        boolean dispatch(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                recalcViewsWithUnhandled();
            }
            View viewDispatchInOrder = dispatchInOrder(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewDispatchInOrder != null && !KeyEvent.isModifierKey(keyCode)) {
                    getCapturedKeys().put(keyCode, new WeakReference<>(viewDispatchInOrder));
                }
            }
            return viewDispatchInOrder != null;
        }

        boolean preDispatch(KeyEvent keyEvent) {
            WeakReference<View> weakReferenceValueAt;
            int iIndexOfKey;
            WeakReference<KeyEvent> weakReference = this.mLastDispatchedPreViewKeyEvent;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.mLastDispatchedPreViewKeyEvent = new WeakReference<>(keyEvent);
            SparseArray<WeakReference<View>> capturedKeys = getCapturedKeys();
            if (keyEvent.getAction() != 1 || (iIndexOfKey = capturedKeys.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReferenceValueAt = null;
            } else {
                weakReferenceValueAt = capturedKeys.valueAt(iIndexOfKey);
                capturedKeys.removeAt(iIndexOfKey);
            }
            if (weakReferenceValueAt == null) {
                weakReferenceValueAt = capturedKeys.get(keyEvent.getKeyCode());
            }
            if (weakReferenceValueAt == null) {
                return false;
            }
            View view = weakReferenceValueAt.get();
            if (view != null && view.isAttachedToWindow()) {
                onUnhandledKeyEvent(view, keyEvent);
            }
            return true;
        }
    }

    @Deprecated
    protected ViewCompat() {
    }

    private static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        return new AccessibilityViewProperty<Boolean>(R.id.tag_accessibility_heading, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public Boolean frameworkGet(View view) {
                return Boolean.valueOf(Api28Impl.isAccessibilityHeading(view));
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public void frameworkSet(View view, Boolean bool) {
                Api28Impl.setAccessibilityHeading(view, bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(Boolean bool, Boolean bool2) {
                return !booleanNullToFalseEquals(bool, bool2);
            }
        };
    }

    public static int addAccessibilityAction(View view, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        int availableActionIdFromResources = getAvailableActionIdFromResources(view, charSequence);
        if (availableActionIdFromResources != -1) {
            addAccessibilityAction(view, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(availableActionIdFromResources, charSequence, accessibilityViewCommand));
        }
        return availableActionIdFromResources;
    }

    private static void addAccessibilityAction(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        ensureAccessibilityDelegateCompat(view);
        removeActionWithId(accessibilityActionCompat.getId(), view);
        getActionList(view).add(accessibilityActionCompat);
        notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    public static void addKeyboardNavigationClusters(View view, Collection<View> collection, int i) {
        Api26Impl.addKeyboardNavigationClusters(view, collection, i);
    }

    public static void addOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.addOnUnhandledKeyEventListener(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(R.id.tag_unhandled_key_listeners, arrayList);
        }
        arrayList.add(onUnhandledKeyEventListenerCompat);
        if (arrayList.size() == 1) {
            UnhandledKeyEventManager.registerListeningView(view);
        }
    }

    public static void addOverlayView(ViewGroup viewGroup, View view) {
        viewGroup.getOverlay().add(view);
        ViewTree.setViewTreeDisjointParent((View) view.getParent(), viewGroup);
    }

    @Deprecated
    public static ViewPropertyAnimatorCompat animate(View view) {
        if (sViewPropertyAnimatorMap == null) {
            sViewPropertyAnimatorMap = new WeakHashMap<>();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = sViewPropertyAnimatorMap.get(view);
        if (viewPropertyAnimatorCompat != null) {
            return viewPropertyAnimatorCompat;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
        sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat2);
        return viewPropertyAnimatorCompat2;
    }

    private static void bindTempDetach() {
        try {
            sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
            sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "Couldn't find method", e);
        }
        sTempDetachBound = true;
    }

    @ReplaceWith(expression = "view.canScrollHorizontally(direction)")
    @Deprecated
    public static boolean canScrollHorizontally(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    @ReplaceWith(expression = "view.canScrollVertically(direction)")
    @Deprecated
    public static boolean canScrollVertically(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void cancelDragAndDrop(View view) {
        Api24Impl.cancelDragAndDrop(view);
    }

    @Deprecated
    public static int combineMeasuredStates(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    public static WindowInsetsCompat computeSystemWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
        return Api21Impl.computeSystemWindowInsets(view, windowInsetsCompat, rect);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets windowInsetsDispatchApplyWindowInsets = Build.VERSION.SDK_INT >= 30 ? Api30Impl.dispatchApplyWindowInsets(view, windowInsets) : Api20Impl.dispatchApplyWindowInsets(view, windowInsets);
            if (!windowInsetsDispatchApplyWindowInsets.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(windowInsetsDispatchApplyWindowInsets, view);
            }
        }
        return windowInsetsCompat;
    }

    public static void dispatchFinishTemporaryDetach(View view) {
        Api24Impl.dispatchFinishTemporaryDetach(view);
    }

    public static boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
        return view.dispatchNestedFling(f, f2, z);
    }

    public static boolean dispatchNestedPreFling(View view, float f, float f2) {
        return view.dispatchNestedPreFling(f, f2);
    }

    public static boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2, int i3) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
        }
        if (i3 == 0) {
            return dispatchNestedPreScroll(view, i, i2, iArr, iArr2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        if (view instanceof NestedScrollingChild3) {
            ((NestedScrollingChild3) view).dispatchNestedScroll(i, i2, i3, i4, iArr, i5, iArr2);
        } else {
            dispatchNestedScroll(view, i, i2, i3, i4, iArr, i5);
        }
    }

    public static boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
        return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr, int i5) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        }
        if (i5 == 0) {
            return dispatchNestedScroll(view, i, i2, i3, i4, iArr);
        }
        return false;
    }

    public static void dispatchStartTemporaryDetach(View view) {
        Api24Impl.dispatchStartTemporaryDetach(view);
    }

    static boolean dispatchUnhandledKeyEventBeforeCallback(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.at(view).dispatch(view, keyEvent);
    }

    static boolean dispatchUnhandledKeyEventBeforeHierarchy(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.at(view).preDispatch(keyEvent);
    }

    public static void enableAccessibleClickableSpanSupport(View view) {
        ensureAccessibilityDelegateCompat(view);
    }

    static void ensureAccessibilityDelegateCompat(View view) {
        AccessibilityDelegateCompat accessibilityDelegate = getAccessibilityDelegate(view);
        if (accessibilityDelegate == null) {
            accessibilityDelegate = new AccessibilityDelegateCompat();
        }
        setAccessibilityDelegate(view, accessibilityDelegate);
    }

    static void fallbackTransformMatrixToGlobal(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            fallbackTransformMatrixToGlobal((View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        matrix.preConcat(view.getMatrix());
    }

    @Deprecated
    public static int generateViewId() {
        return View.generateViewId();
    }

    public static AccessibilityDelegateCompat getAccessibilityDelegate(View view) {
        View.AccessibilityDelegate accessibilityDelegateInternal = getAccessibilityDelegateInternal(view);
        if (accessibilityDelegateInternal == null) {
            return null;
        }
        return accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter ? ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat : new AccessibilityDelegateCompat(accessibilityDelegateInternal);
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(View view) {
        return Build.VERSION.SDK_INT >= 29 ? Api29Impl.getAccessibilityDelegate(view) : getAccessibilityDelegateThroughReflection(view);
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(View view) {
        if (sAccessibilityDelegateCheckFailed) {
            return null;
        }
        if (sAccessibilityDelegateField == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                sAccessibilityDelegateField = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                sAccessibilityDelegateCheckFailed = true;
                return null;
            }
        }
        try {
            Object obj = sAccessibilityDelegateField.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            sAccessibilityDelegateCheckFailed = true;
            return null;
        }
    }

    @ReplaceWith(expression = "view.getAccessibilityLiveRegion()")
    @Deprecated
    public static int getAccessibilityLiveRegion(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = view.getAccessibilityNodeProvider();
        if (accessibilityNodeProvider != null) {
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }

    public static CharSequence getAccessibilityPaneTitle(View view) {
        return paneTitleProperty().get(view);
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    @ReplaceWith(expression = "view.getAlpha()")
    @Deprecated
    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    public static AutofillIdCompat getAutofillId(View view) {
        return AutofillIdCompat.toAutofillIdCompat(Api26Impl.getAutofillId(view));
    }

    private static int getAvailableActionIdFromResources(View view, CharSequence charSequence) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
        for (int i = 0; i < actionList.size(); i++) {
            if (TextUtils.equals(charSequence, actionList.get(i).getLabel())) {
                return actionList.get(i).getId();
            }
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[] iArr = ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
            if (i3 >= iArr.length || i2 != -1) {
                break;
            }
            int i4 = iArr[i3];
            boolean z = true;
            for (int i5 = 0; i5 < actionList.size(); i5++) {
                z &= actionList.get(i5).getId() != i4;
            }
            if (z) {
                i2 = i4;
            }
            i3++;
        }
        return i2;
    }

    public static ColorStateList getBackgroundTintList(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode getBackgroundTintMode(View view) {
        return view.getBackgroundTintMode();
    }

    @ReplaceWith(expression = "view.getClipBounds()")
    @Deprecated
    public static Rect getClipBounds(View view) {
        return view.getClipBounds();
    }

    public static ContentCaptureSessionCompat getContentCaptureSession(View view) {
        ContentCaptureSession contentCaptureSession;
        if (Build.VERSION.SDK_INT < 29 || (contentCaptureSession = Api29Impl.getContentCaptureSession(view)) == null) {
            return null;
        }
        return ContentCaptureSessionCompat.toContentCaptureSessionCompat(contentCaptureSession, view);
    }

    @ReplaceWith(expression = "view.getDisplay()")
    @Deprecated
    public static Display getDisplay(View view) {
        return view.getDisplay();
    }

    public static float getElevation(View view) {
        return view.getElevation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static OnReceiveContentViewBehavior getFallback(View view) {
        return view instanceof OnReceiveContentViewBehavior ? (OnReceiveContentViewBehavior) view : NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    @ReplaceWith(expression = "view.getFitsSystemWindows()")
    @Deprecated
    public static boolean getFitsSystemWindows(View view) {
        return view.getFitsSystemWindows();
    }

    @ReplaceWith(expression = "view.getImportantForAccessibility()")
    @Deprecated
    public static int getImportantForAccessibility(View view) {
        return view.getImportantForAccessibility();
    }

    public static int getImportantForAutofill(View view) {
        return Api26Impl.getImportantForAutofill(view);
    }

    public static int getImportantForContentCapture(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getImportantForContentCapture(view);
        }
        return 0;
    }

    @ReplaceWith(expression = "view.getLabelFor()")
    @Deprecated
    public static int getLabelFor(View view) {
        return view.getLabelFor();
    }

    @ReplaceWith(expression = "view.getLayerType()")
    @Deprecated
    public static int getLayerType(View view) {
        return view.getLayerType();
    }

    @ReplaceWith(expression = "view.getLayoutDirection()")
    @Deprecated
    public static int getLayoutDirection(View view) {
        return view.getLayoutDirection();
    }

    @ReplaceWith(expression = "view.getMatrix()")
    @Deprecated
    public static Matrix getMatrix(View view) {
        return view.getMatrix();
    }

    @ReplaceWith(expression = "view.getMeasuredHeightAndState()")
    @Deprecated
    public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    @ReplaceWith(expression = "view.getMeasuredState()")
    @Deprecated
    public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    @ReplaceWith(expression = "view.getMeasuredWidthAndState()")
    @Deprecated
    public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    @ReplaceWith(expression = "view.getMinimumHeight()")
    @Deprecated
    public static int getMinimumHeight(View view) {
        return view.getMinimumHeight();
    }

    @ReplaceWith(expression = "view.getMinimumWidth()")
    @Deprecated
    public static int getMinimumWidth(View view) {
        return view.getMinimumWidth();
    }

    public static int getNextClusterForwardId(View view) {
        return Api26Impl.getNextClusterForwardId(view);
    }

    public static String[] getOnReceiveContentMimeTypes(View view) {
        return Build.VERSION.SDK_INT >= 31 ? Api31Impl.getReceiveContentMimeTypes(view) : (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    @ReplaceWith(expression = "view.getOverScrollMode()")
    @Deprecated
    public static int getOverScrollMode(View view) {
        return view.getOverScrollMode();
    }

    @ReplaceWith(expression = "view.getPaddingEnd()")
    @Deprecated
    public static int getPaddingEnd(View view) {
        return view.getPaddingEnd();
    }

    @ReplaceWith(expression = "view.getPaddingStart()")
    @Deprecated
    public static int getPaddingStart(View view) {
        return view.getPaddingStart();
    }

    @ReplaceWith(expression = "view.getParentForAccessibility()")
    @Deprecated
    public static ViewParent getParentForAccessibility(View view) {
        return view.getParentForAccessibility();
    }

    @ReplaceWith(expression = "view.getPivotX()")
    @Deprecated
    public static float getPivotX(View view) {
        return view.getPivotX();
    }

    @ReplaceWith(expression = "view.getPivotY()")
    @Deprecated
    public static float getPivotY(View view) {
        return view.getPivotY();
    }

    public static WindowInsetsCompat getRootWindowInsets(View view) {
        return Api23Impl.getRootWindowInsets(view);
    }

    @ReplaceWith(expression = "view.getRotation()")
    @Deprecated
    public static float getRotation(View view) {
        return view.getRotation();
    }

    @ReplaceWith(expression = "view.getRotationX()")
    @Deprecated
    public static float getRotationX(View view) {
        return view.getRotationX();
    }

    @ReplaceWith(expression = "view.getRotationY()")
    @Deprecated
    public static float getRotationY(View view) {
        return view.getRotationY();
    }

    @ReplaceWith(expression = "view.getScaleX()")
    @Deprecated
    public static float getScaleX(View view) {
        return view.getScaleX();
    }

    @ReplaceWith(expression = "view.getScaleY()")
    @Deprecated
    public static float getScaleY(View view) {
        return view.getScaleY();
    }

    public static int getScrollIndicators(View view) {
        return view.getScrollIndicators();
    }

    public static CharSequence getStateDescription(View view) {
        return stateDescriptionProperty().get(view);
    }

    public static List<Rect> getSystemGestureExclusionRects(View view) {
        return Build.VERSION.SDK_INT >= 29 ? Api29Impl.getSystemGestureExclusionRects(view) : Collections.emptyList();
    }

    public static String getTransitionName(View view) {
        return view.getTransitionName();
    }

    @ReplaceWith(expression = "view.getTranslationX()")
    @Deprecated
    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    @ReplaceWith(expression = "view.getTranslationY()")
    @Deprecated
    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    public static float getTranslationZ(View view) {
        return view.getTranslationZ();
    }

    @Deprecated
    public static WindowInsetsControllerCompat getWindowInsetsController(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getWindowInsetsController(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return WindowCompat.getInsetsController(window, view);
                }
                return null;
            }
        }
        return null;
    }

    @ReplaceWith(expression = "view.getWindowSystemUiVisibility()")
    @Deprecated
    public static int getWindowSystemUiVisibility(View view) {
        return view.getWindowSystemUiVisibility();
    }

    @ReplaceWith(expression = "view.getX()")
    @Deprecated
    public static float getX(View view) {
        return view.getX();
    }

    @ReplaceWith(expression = "view.getY()")
    @Deprecated
    public static float getY(View view) {
        return view.getY();
    }

    public static float getZ(View view) {
        return view.getZ();
    }

    public static boolean hasAccessibilityDelegate(View view) {
        return getAccessibilityDelegateInternal(view) != null;
    }

    public static boolean hasExplicitFocusable(View view) {
        return Api26Impl.hasExplicitFocusable(view);
    }

    public static boolean hasNestedScrollingParent(View view) {
        return view.hasNestedScrollingParent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean hasNestedScrollingParent(View view, int i) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).hasNestedScrollingParent(i);
            return false;
        }
        if (i == 0) {
            return hasNestedScrollingParent(view);
        }
        return false;
    }

    @ReplaceWith(expression = "view.hasOnClickListeners()")
    @Deprecated
    public static boolean hasOnClickListeners(View view) {
        return view.hasOnClickListeners();
    }

    @ReplaceWith(expression = "view.hasOverlappingRendering()")
    @Deprecated
    public static boolean hasOverlappingRendering(View view) {
        return view.hasOverlappingRendering();
    }

    @ReplaceWith(expression = "view.hasTransientState()")
    @Deprecated
    public static boolean hasTransientState(View view) {
        return view.hasTransientState();
    }

    public static boolean isAccessibilityHeading(View view) {
        Boolean bool = accessibilityHeadingProperty().get(view);
        return bool != null && bool.booleanValue();
    }

    @ReplaceWith(expression = "view.isAttachedToWindow()")
    @Deprecated
    public static boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean isFocusedByDefault(View view) {
        return Api26Impl.isFocusedByDefault(view);
    }

    public static boolean isImportantForAccessibility(View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean isImportantForAutofill(View view) {
        return Api26Impl.isImportantForAutofill(view);
    }

    public static boolean isImportantForContentCapture(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.isImportantForContentCapture(view);
        }
        return false;
    }

    @ReplaceWith(expression = "view.isInLayout()")
    @Deprecated
    public static boolean isInLayout(View view) {
        return view.isInLayout();
    }

    public static boolean isKeyboardNavigationCluster(View view) {
        return Api26Impl.isKeyboardNavigationCluster(view);
    }

    @ReplaceWith(expression = "view.isLaidOut()")
    @Deprecated
    public static boolean isLaidOut(View view) {
        return view.isLaidOut();
    }

    @ReplaceWith(expression = "view.isLayoutDirectionResolved()")
    @Deprecated
    public static boolean isLayoutDirectionResolved(View view) {
        return view.isLayoutDirectionResolved();
    }

    public static boolean isNestedScrollingEnabled(View view) {
        return view.isNestedScrollingEnabled();
    }

    @ReplaceWith(expression = "view.isOpaque()")
    @Deprecated
    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    @ReplaceWith(expression = "view.isPaddingRelative()")
    @Deprecated
    public static boolean isPaddingRelative(View view) {
        return view.isPaddingRelative();
    }

    public static boolean isScreenReaderFocusable(View view) {
        Boolean bool = screenReaderFocusableProperty().get(view);
        return bool != null && bool.booleanValue();
    }

    @ReplaceWith(expression = "view.jumpDrawablesToCurrentState()")
    @Deprecated
    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static View keyboardNavigationClusterSearch(View view, View view2, int i) {
        return Api26Impl.keyboardNavigationClusterSearch(view, view2, i);
    }

    static /* synthetic */ ContentInfoCompat lambda$static$0(ContentInfoCompat contentInfoCompat) {
        return contentInfoCompat;
    }

    static void notifyViewAccessibilityStateChangedIfNeeded(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = getAccessibilityPaneTitle(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z) {
                    accessibilityEventObtain.getText().add(getAccessibilityPaneTitle(view));
                    setImportantForAccessibilityIfNeeded(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError e) {
                        Log.e(TAG, view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(getAccessibilityPaneTitle(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static void offsetLeftAndRight(View view, int i) {
        view.offsetLeftAndRight(i);
    }

    public static void offsetTopAndBottom(View view, int i) {
        view.offsetTopAndBottom(i);
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (!windowInsetsOnApplyWindowInsets.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(windowInsetsOnApplyWindowInsets, view);
            }
        }
        return windowInsetsCompat;
    }

    @ReplaceWith(expression = "v.onInitializeAccessibilityEvent(event)")
    @Deprecated
    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @ReplaceWith(expression = "v.onInitializeAccessibilityNodeInfo(info.unwrap())")
    @Deprecated
    public static void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
    }

    @ReplaceWith(expression = "v.onPopulateAccessibilityEvent(event)")
    @Deprecated
    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    private static AccessibilityViewProperty<CharSequence> paneTitleProperty() {
        return new AccessibilityViewProperty<CharSequence>(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28) { // from class: androidx.core.view.ViewCompat.2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public CharSequence frameworkGet(View view) {
                return Api28Impl.getAccessibilityPaneTitle(view);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public void frameworkSet(View view, CharSequence charSequence) {
                Api28Impl.setAccessibilityPaneTitle(view, charSequence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    @ReplaceWith(expression = "view.performAccessibilityAction(action, arguments)")
    @Deprecated
    public static boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return view.performAccessibilityAction(i, bundle);
    }

    public static boolean performHapticFeedback(View view, int i) {
        int feedbackConstantOrFallback = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(i);
        if (feedbackConstantOrFallback == -1) {
            return false;
        }
        return view.performHapticFeedback(feedbackConstantOrFallback);
    }

    public static boolean performHapticFeedback(View view, int i, int i2) {
        int feedbackConstantOrFallback = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(i);
        if (feedbackConstantOrFallback == -1) {
            return false;
        }
        return view.performHapticFeedback(feedbackConstantOrFallback, i2);
    }

    public static ContentInfoCompat performReceiveContent(View view, ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "performReceiveContent: " + contentInfoCompat + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.performReceiveContent(view, contentInfoCompat);
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view.getTag(R.id.tag_on_receive_content_listener);
        if (onReceiveContentListener == null) {
            return getFallback(view).onReceiveContent(contentInfoCompat);
        }
        ContentInfoCompat contentInfoCompatOnReceiveContent = onReceiveContentListener.onReceiveContent(view, contentInfoCompat);
        if (contentInfoCompatOnReceiveContent == null) {
            return null;
        }
        return getFallback(view).onReceiveContent(contentInfoCompatOnReceiveContent);
    }

    @ReplaceWith(expression = "view.postInvalidateOnAnimation()")
    @Deprecated
    public static void postInvalidateOnAnimation(View view) {
        view.postInvalidateOnAnimation();
    }

    @ReplaceWith(expression = "view.postInvalidateOnAnimation(left, top, right, bottom)")
    @Deprecated
    public static void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4) {
        view.postInvalidateOnAnimation(i, i2, i3, i4);
    }

    @ReplaceWith(expression = "view.postOnAnimation(action)")
    @Deprecated
    public static void postOnAnimation(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    @ReplaceWith(expression = "view.postOnAnimationDelayed(action, delayMillis)")
    @Deprecated
    public static void postOnAnimationDelayed(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static void removeAccessibilityAction(View view, int i) {
        removeActionWithId(i, view);
        notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    private static void removeActionWithId(int i, View view) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
        for (int i2 = 0; i2 < actionList.size(); i2++) {
            if (actionList.get(i2).getId() == i) {
                actionList.remove(i2);
                return;
            }
        }
    }

    public static void removeOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.removeOnUnhandledKeyEventListener(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList != null) {
            arrayList.remove(onUnhandledKeyEventListenerCompat);
            if (arrayList.size() == 0) {
                UnhandledKeyEventManager.unregisterListeningView(view);
            }
        }
    }

    public static void replaceAccessibilityAction(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            removeAccessibilityAction(view, accessibilityActionCompat.getId());
        } else {
            addAccessibilityAction(view, accessibilityActionCompat.createReplacementAction(charSequence, accessibilityViewCommand));
        }
    }

    public static void requestApplyInsets(View view) {
        view.requestApplyInsets();
    }

    public static <T extends View> T requireViewById(View view, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) Api28Impl.requireViewById(view, i);
        }
        T t = (T) view.findViewById(i);
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    @Deprecated
    public static int resolveSizeAndState(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static boolean restoreDefaultFocus(View view) {
        return Api26Impl.restoreDefaultFocus(view);
    }

    public static void saveAttributeDataForStyleable(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.saveAttributeDataForStyleable(view, context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    private static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        return new AccessibilityViewProperty<Boolean>(R.id.tag_screen_reader_focusable, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public Boolean frameworkGet(View view) {
                return Boolean.valueOf(Api28Impl.isScreenReaderFocusable(view));
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public void frameworkSet(View view, Boolean bool) {
                Api28Impl.setScreenReaderFocusable(view, bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(Boolean bool, Boolean bool2) {
                return !booleanNullToFalseEquals(bool, bool2);
            }
        };
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        if (accessibilityDelegateCompat == null && (getAccessibilityDelegateInternal(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        setImportantForAccessibilityIfNeeded(view);
        view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.getBridge());
    }

    public static void setAccessibilityHeading(View view, boolean z) {
        accessibilityHeadingProperty().set(view, Boolean.valueOf(z));
    }

    @ReplaceWith(expression = "view.setAccessibilityLiveRegion(mode)")
    @Deprecated
    public static void setAccessibilityLiveRegion(View view, int i) {
        view.setAccessibilityLiveRegion(i);
    }

    public static void setAccessibilityPaneTitle(View view, CharSequence charSequence) {
        paneTitleProperty().set(view, charSequence);
        if (charSequence != null) {
            sAccessibilityPaneVisibilityManager.addAccessibilityPane(view);
        } else {
            sAccessibilityPaneVisibilityManager.removeAccessibilityPane(view);
        }
    }

    @ReplaceWith(expression = "view.setActivated(activated)")
    @Deprecated
    public static void setActivated(View view, boolean z) {
        view.setActivated(z);
    }

    @ReplaceWith(expression = "view.setAlpha(value)")
    @Deprecated
    public static void setAlpha(View view, float f) {
        view.setAlpha(f);
    }

    public static void setAutofillHints(View view, String... strArr) {
        Api26Impl.setAutofillHints(view, strArr);
    }

    public static void setAutofillId(View view, AutofillIdCompat autofillIdCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setAutofillId(view, autofillIdCompat);
        }
    }

    @ReplaceWith(expression = "view.setBackground(background)")
    @Deprecated
    public static void setBackground(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
        if (sChildrenDrawingOrderMethod == null) {
            try {
                sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e) {
                Log.e(TAG, "Unable to find childrenDrawingOrderEnabled", e);
            }
            sChildrenDrawingOrderMethod.setAccessible(true);
        }
        try {
            sChildrenDrawingOrderMethod.invoke(viewGroup, Boolean.valueOf(z));
        } catch (IllegalAccessException e2) {
            Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (IllegalArgumentException e3) {
            Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e3);
        } catch (InvocationTargetException e4) {
            Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e4);
        }
    }

    @ReplaceWith(expression = "view.setClipBounds(clipBounds)")
    @Deprecated
    public static void setClipBounds(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static void setContentCaptureSession(View view, ContentCaptureSessionCompat contentCaptureSessionCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setContentCaptureSession(view, contentCaptureSessionCompat);
        }
    }

    public static void setElevation(View view, float f) {
        view.setElevation(f);
    }

    @ReplaceWith(expression = "view.setFitsSystemWindows(fitSystemWindows)")
    @Deprecated
    public static void setFitsSystemWindows(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void setFocusedByDefault(View view, boolean z) {
        Api26Impl.setFocusedByDefault(view, z);
    }

    @ReplaceWith(expression = "view.setHasTransientState(hasTransientState)")
    @Deprecated
    public static void setHasTransientState(View view, boolean z) {
        view.setHasTransientState(z);
    }

    @ReplaceWith(expression = "view.setImportantForAccessibility(mode)")
    @Deprecated
    public static void setImportantForAccessibility(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    private static void setImportantForAccessibilityIfNeeded(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static void setImportantForAutofill(View view, int i) {
        Api26Impl.setImportantForAutofill(view, i);
    }

    public static void setImportantForContentCapture(View view, int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setImportantForContentCapture(view, i);
        }
    }

    public static void setKeyboardNavigationCluster(View view, boolean z) {
        Api26Impl.setKeyboardNavigationCluster(view, z);
    }

    @ReplaceWith(expression = "view.setLabelFor(labeledId)")
    @Deprecated
    public static void setLabelFor(View view, int i) {
        view.setLabelFor(i);
    }

    @ReplaceWith(expression = "view.setLayerPaint(paint)")
    @Deprecated
    public static void setLayerPaint(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    @ReplaceWith(expression = "view.setLayerType(layerType, paint)")
    @Deprecated
    public static void setLayerType(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    @ReplaceWith(expression = "view.setLayoutDirection(layoutDirection)")
    @Deprecated
    public static void setLayoutDirection(View view, int i) {
        view.setLayoutDirection(i);
    }

    public static void setNestedScrollingEnabled(View view, boolean z) {
        view.setNestedScrollingEnabled(z);
    }

    public static void setNextClusterForwardId(View view, int i) {
        Api26Impl.setNextClusterForwardId(view, i);
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Api21Impl.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
    }

    public static void setOnReceiveContentListener(View view, String[] strArr, OnReceiveContentListener onReceiveContentListener) {
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.setOnReceiveContentListener(view, strArr, onReceiveContentListener);
            return;
        }
        if (strArr == null || strArr.length == 0) {
            strArr = null;
        }
        boolean z = false;
        if (onReceiveContentListener != null) {
            Preconditions.checkArgument(strArr != null, "When the listener is set, MIME types must also be set");
        }
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (strArr[i].startsWith(ProxyConfig.MATCH_ALL_SCHEMES)) {
                    z = true;
                    break;
                }
                i++;
            }
            Preconditions.checkArgument(!z, "A MIME type set here must not start with *: " + Arrays.toString(strArr));
        }
        view.setTag(R.id.tag_on_receive_content_mime_types, strArr);
        view.setTag(R.id.tag_on_receive_content_listener, onReceiveContentListener);
    }

    @ReplaceWith(expression = "view.setOverScrollMode(overScrollMode)")
    @Deprecated
    public static void setOverScrollMode(View view, int i) {
        view.setOverScrollMode(i);
    }

    @ReplaceWith(expression = "view.setPaddingRelative(start, top, end, bottom)")
    @Deprecated
    public static void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    @ReplaceWith(expression = "view.setPivotX(value)")
    @Deprecated
    public static void setPivotX(View view, float f) {
        view.setPivotX(f);
    }

    @ReplaceWith(expression = "view.setPivotY(value)")
    @Deprecated
    public static void setPivotY(View view, float f) {
        view.setPivotY(f);
    }

    public static void setPointerIcon(View view, PointerIconCompat pointerIconCompat) {
        Api24Impl.setPointerIcon(view, (PointerIcon) (pointerIconCompat != null ? pointerIconCompat.getPointerIcon() : null));
    }

    @ReplaceWith(expression = "view.setRotation(value)")
    @Deprecated
    public static void setRotation(View view, float f) {
        view.setRotation(f);
    }

    @ReplaceWith(expression = "view.setRotationX(value)")
    @Deprecated
    public static void setRotationX(View view, float f) {
        view.setRotationX(f);
    }

    @ReplaceWith(expression = "view.setRotationY(value)")
    @Deprecated
    public static void setRotationY(View view, float f) {
        view.setRotationY(f);
    }

    @ReplaceWith(expression = "view.setSaveFromParentEnabled(enabled)")
    @Deprecated
    public static void setSaveFromParentEnabled(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    @ReplaceWith(expression = "view.setScaleX(value)")
    @Deprecated
    public static void setScaleX(View view, float f) {
        view.setScaleX(f);
    }

    @ReplaceWith(expression = "view.setScaleY(value)")
    @Deprecated
    public static void setScaleY(View view, float f) {
        view.setScaleY(f);
    }

    public static void setScreenReaderFocusable(View view, boolean z) {
        screenReaderFocusableProperty().set(view, Boolean.valueOf(z));
    }

    public static void setScrollIndicators(View view, int i) {
        view.setScrollIndicators(i);
    }

    public static void setScrollIndicators(View view, int i, int i2) {
        view.setScrollIndicators(i, i2);
    }

    public static void setStateDescription(View view, CharSequence charSequence) {
        stateDescriptionProperty().set(view, charSequence);
    }

    public static void setSystemGestureExclusionRects(View view, List<Rect> list) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setSystemGestureExclusionRects(view, list);
        }
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        Api26Impl.setTooltipText(view, charSequence);
    }

    public static void setTransitionName(View view, String str) {
        view.setTransitionName(str);
    }

    @ReplaceWith(expression = "view.setTranslationX(value)")
    @Deprecated
    public static void setTranslationX(View view, float f) {
        view.setTranslationX(f);
    }

    @ReplaceWith(expression = "view.setTranslationY(value)")
    @Deprecated
    public static void setTranslationY(View view, float f) {
        view.setTranslationY(f);
    }

    public static void setTranslationZ(View view, float f) {
        view.setTranslationZ(f);
    }

    public static void setWindowInsetsAnimationCallback(View view, WindowInsetsAnimationCompat.Callback callback) {
        WindowInsetsAnimationCompat.setCallback(view, callback);
    }

    @ReplaceWith(expression = "view.setX(value)")
    @Deprecated
    public static void setX(View view, float f) {
        view.setX(f);
    }

    @ReplaceWith(expression = "view.setY(value)")
    @Deprecated
    public static void setY(View view, float f) {
        view.setY(f);
    }

    public static void setZ(View view, float f) {
        view.setZ(f);
    }

    public static boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        return Api24Impl.startDragAndDrop(view, clipData, dragShadowBuilder, obj, i);
    }

    public static boolean startNestedScroll(View view, int i) {
        return view.startNestedScroll(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean startNestedScroll(View view, int i, int i2) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).startNestedScroll(i, i2);
        }
        if (i2 == 0) {
            return startNestedScroll(view, i);
        }
        return false;
    }

    private static AccessibilityViewProperty<CharSequence> stateDescriptionProperty() {
        return new AccessibilityViewProperty<CharSequence>(R.id.tag_state_description, CharSequence.class, 64, 30) { // from class: androidx.core.view.ViewCompat.3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public CharSequence frameworkGet(View view) {
                return Api30Impl.getStateDescription(view);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public void frameworkSet(View view, CharSequence charSequence) {
                Api30Impl.setStateDescription(view, charSequence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static void stopNestedScroll(View view) {
        view.stopNestedScroll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void stopNestedScroll(View view, int i) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).stopNestedScroll(i);
        } else if (i == 0) {
            stopNestedScroll(view);
        }
    }

    public static void transformMatrixToGlobal(View view, Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.transformMatrixToGlobal(view, matrix);
            return;
        }
        if (sTryHiddenViewTransformMatrixToGlobal) {
            try {
                Api29Impl.transformMatrixToGlobal(view, matrix);
                return;
            } catch (NoSuchMethodError unused) {
                sTryHiddenViewTransformMatrixToGlobal = false;
            }
        }
        fallbackTransformMatrixToGlobal(view, matrix);
    }

    public static void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder) {
        Api24Impl.updateDragShadow(view, dragShadowBuilder);
    }
}
