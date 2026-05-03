package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextInputServiceAndroid.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0000\u001a\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"DEBUG_CLASS", "", "updateWithEmojiCompat", "", "Landroid/view/inputmethod/EditorInfo;", "update", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "asExecutor", "Ljava/util/concurrent/Executor;", "Landroid/view/Choreographer;", "hasFlag", "", "bits", "", "flag", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    public static final Executor asExecutor(final Choreographer choreographer) {
        return new Executor() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                choreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1
                    @Override // android.view.Choreographer.FrameCallback
                    public final void doFrame(long j) {
                        runnable.run();
                    }
                });
            }
        };
    }

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    public static final void update(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        String privateImeOptions;
        int imeAction = imeOptions.getImeAction();
        int i = 6;
        if (ImeAction.m8730equalsimpl0(imeAction, ImeAction.INSTANCE.m8743getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m8730equalsimpl0(imeAction, ImeAction.INSTANCE.m8747getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m8730equalsimpl0(imeAction, ImeAction.INSTANCE.m8745getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m8730equalsimpl0(imeAction, ImeAction.INSTANCE.m8746getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m8730equalsimpl0(imeAction, ImeAction.INSTANCE.m8748getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m8730equalsimpl0(imeAction, ImeAction.INSTANCE.m8749getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m8730equalsimpl0(imeAction, ImeAction.INSTANCE.m8750getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m8730equalsimpl0(imeAction, ImeAction.INSTANCE.m8744getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i;
        PlatformImeOptions platformImeOptions = imeOptions.getPlatformImeOptions();
        if (platformImeOptions != null && (privateImeOptions = platformImeOptions.getPrivateImeOptions()) != null) {
            editorInfo.privateImeOptions = privateImeOptions;
        }
        int keyboardType = imeOptions.getKeyboardType();
        if (KeyboardType.m8783equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8804getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m8783equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8797getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m8783equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8800getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m8783equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8803getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m8783equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8806getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m8783equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8799getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m8783equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8802getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m8783equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8801getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else {
            if (!KeyboardType.m8783equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8798getDecimalPjHm6EE())) {
                throw new IllegalStateException("Invalid Keyboard Type".toString());
            }
            editorInfo.inputType = 8194;
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m8730equalsimpl0(imeOptions.getImeAction(), ImeAction.INSTANCE.m8743getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int capitalization = imeOptions.getCapitalization();
            if (KeyboardCapitalization.m8766equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m8775getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m8766equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m8779getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m8766equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m8777getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m8556getStartimpl(textFieldValue.getSelection());
        editorInfo.initialSelEnd = TextRange.m8551getEndimpl(textFieldValue.getSelection());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }
}
