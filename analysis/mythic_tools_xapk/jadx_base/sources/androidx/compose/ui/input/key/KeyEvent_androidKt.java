package androidx.compose.ui.input.key;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: KeyEvent.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0015\u0010\u000b\u001a\u00020\f*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\n\"\u0015\u0010\u000e\u001a\u00020\u000f*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0015\u0010\u0012\u001a\u00020\u000f*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\"\u0015\u0010\u0014\u001a\u00020\u000f*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011\"\u0015\u0010\u0016\u001a\u00020\u000f*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0018"}, d2 = {"NativeKeyEvent", "Landroid/view/KeyEvent;", SubscriberAttributeKt.JSON_NAME_KEY, "Landroidx/compose/ui/input/key/Key;", "Landroidx/compose/ui/input/key/KeyEvent;", "getKey-ZmokQxo", "(Landroid/view/KeyEvent;)J", "utf16CodePoint", "", "getUtf16CodePoint-ZmokQxo", "(Landroid/view/KeyEvent;)I", "type", "Landroidx/compose/ui/input/key/KeyEventType;", "getType-ZmokQxo", "isAltPressed", "", "isAltPressed-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isCtrlPressed", "isCtrlPressed-ZmokQxo", "isMetaPressed", "isMetaPressed-ZmokQxo", "isShiftPressed", "isShiftPressed-ZmokQxo", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KeyEvent_androidKt {
    /* JADX INFO: renamed from: getKey-ZmokQxo, reason: not valid java name */
    public static final long m7481getKeyZmokQxo(android.view.KeyEvent keyEvent) {
        return Key_androidKt.Key(keyEvent.getKeyCode());
    }

    /* JADX INFO: renamed from: getType-ZmokQxo, reason: not valid java name */
    public static final int m7482getTypeZmokQxo(android.view.KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        return action != 0 ? action != 1 ? KeyEventType.INSTANCE.m7480getUnknownCS__XNY() : KeyEventType.INSTANCE.m7479getKeyUpCS__XNY() : KeyEventType.INSTANCE.m7478getKeyDownCS__XNY();
    }

    /* JADX INFO: renamed from: getUtf16CodePoint-ZmokQxo, reason: not valid java name */
    public static final int m7483getUtf16CodePointZmokQxo(android.view.KeyEvent keyEvent) {
        return keyEvent.getUnicodeChar();
    }

    /* JADX INFO: renamed from: isAltPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m7484isAltPressedZmokQxo(android.view.KeyEvent keyEvent) {
        return keyEvent.isAltPressed();
    }

    /* JADX INFO: renamed from: isCtrlPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m7485isCtrlPressedZmokQxo(android.view.KeyEvent keyEvent) {
        return keyEvent.isCtrlPressed();
    }

    /* JADX INFO: renamed from: isMetaPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m7486isMetaPressedZmokQxo(android.view.KeyEvent keyEvent) {
        return keyEvent.isMetaPressed();
    }

    /* JADX INFO: renamed from: isShiftPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m7487isShiftPressedZmokQxo(android.view.KeyEvent keyEvent) {
        return keyEvent.isShiftPressed();
    }
}
