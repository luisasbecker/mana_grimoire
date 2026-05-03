package androidx.core.view.contentcapture;

import android.os.Build;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewStructureCompat;
import androidx.core.view.autofill.AutofillIdCompat;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class ContentCaptureSessionCompat {
    private static final String KEY_VIEW_TREE_APPEARED = "TREAT_AS_VIEW_TREE_APPEARED";
    private static final String KEY_VIEW_TREE_APPEARING = "TREAT_AS_VIEW_TREE_APPEARING";
    private final View mView;
    private final Object mWrappedObj;

    private static class Api29Impl {
        private Api29Impl() {
        }

        static AutofillId newAutofillId(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j) {
            return contentCaptureSession.newAutofillId(autofillId, j);
        }

        static ViewStructure newViewStructure(ContentCaptureSession contentCaptureSession, View view) {
            return contentCaptureSession.newViewStructure(view);
        }

        static ViewStructure newVirtualViewStructure(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j) {
            return contentCaptureSession.newVirtualViewStructure(autofillId, j);
        }

        static void notifyViewAppeared(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
            contentCaptureSession.notifyViewAppeared(viewStructure);
        }

        public static void notifyViewTextChanged(ContentCaptureSession contentCaptureSession, AutofillId autofillId, CharSequence charSequence) {
            contentCaptureSession.notifyViewTextChanged(autofillId, charSequence);
        }

        static void notifyViewsDisappeared(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] jArr) {
            contentCaptureSession.notifyViewsDisappeared(autofillId, jArr);
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        static void notifyViewsAppeared(ContentCaptureSession contentCaptureSession, List<ViewStructure> list) {
            contentCaptureSession.notifyViewsAppeared(list);
        }
    }

    private ContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        this.mWrappedObj = contentCaptureSession;
        this.mView = view;
    }

    public static ContentCaptureSessionCompat toContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        return new ContentCaptureSessionCompat(contentCaptureSession, view);
    }

    public AutofillId newAutofillId(long j) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.newAutofillId((ContentCaptureSession) this.mWrappedObj, ((AutofillIdCompat) Objects.requireNonNull(ViewCompat.getAutofillId(this.mView))).toAutofillId(), j);
        }
        return null;
    }

    public ViewStructureCompat newVirtualViewStructure(AutofillId autofillId, long j) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ViewStructureCompat.toViewStructureCompat(Api29Impl.newVirtualViewStructure((ContentCaptureSession) this.mWrappedObj, autofillId, j));
        }
        return null;
    }

    public void notifyViewTextChanged(AutofillId autofillId, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.notifyViewTextChanged((ContentCaptureSession) this.mWrappedObj, autofillId, charSequence);
        }
    }

    public void notifyViewsAppeared(List<ViewStructure> list) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.notifyViewsAppeared((ContentCaptureSession) this.mWrappedObj, list);
            return;
        }
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        ViewStructure viewStructureNewViewStructure = Api29Impl.newViewStructure((ContentCaptureSession) this.mWrappedObj, this.mView);
        viewStructureNewViewStructure.getExtras().putBoolean(KEY_VIEW_TREE_APPEARING, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, viewStructureNewViewStructure);
        int i = 0;
        while (true) {
            int size = list.size();
            Object obj = this.mWrappedObj;
            if (i >= size) {
                ViewStructure viewStructureNewViewStructure2 = Api29Impl.newViewStructure((ContentCaptureSession) obj, this.mView);
                viewStructureNewViewStructure2.getExtras().putBoolean(KEY_VIEW_TREE_APPEARED, true);
                Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, viewStructureNewViewStructure2);
                return;
            }
            Api29Impl.notifyViewAppeared((ContentCaptureSession) obj, list.get(i));
            i++;
        }
    }

    public void notifyViewsDisappeared(long[] jArr) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api29Impl.notifyViewsDisappeared((ContentCaptureSession) this.mWrappedObj, ((AutofillIdCompat) Objects.requireNonNull(ViewCompat.getAutofillId(this.mView))).toAutofillId(), jArr);
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            ViewStructure viewStructureNewViewStructure = Api29Impl.newViewStructure((ContentCaptureSession) this.mWrappedObj, this.mView);
            viewStructureNewViewStructure.getExtras().putBoolean(KEY_VIEW_TREE_APPEARING, true);
            Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, viewStructureNewViewStructure);
            Api29Impl.notifyViewsDisappeared((ContentCaptureSession) this.mWrappedObj, ((AutofillIdCompat) Objects.requireNonNull(ViewCompat.getAutofillId(this.mView))).toAutofillId(), jArr);
            ViewStructure viewStructureNewViewStructure2 = Api29Impl.newViewStructure((ContentCaptureSession) this.mWrappedObj, this.mView);
            viewStructureNewViewStructure2.getExtras().putBoolean(KEY_VIEW_TREE_APPEARED, true);
            Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, viewStructureNewViewStructure2);
        }
    }

    public ContentCaptureSession toContentCaptureSession() {
        return (ContentCaptureSession) this.mWrappedObj;
    }
}
