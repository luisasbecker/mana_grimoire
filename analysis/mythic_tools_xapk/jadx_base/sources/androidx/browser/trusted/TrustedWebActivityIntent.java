package androidx.browser.trusted;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.core.content.IntentCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TrustedWebActivityIntent {
    private final List<Uri> mFileHandlingUris;
    private final Intent mIntent;
    private final List<Uri> mSharedFileUris;

    TrustedWebActivityIntent(Intent intent, List<Uri> list, List<Uri> list2) {
        this.mIntent = intent;
        this.mSharedFileUris = list;
        this.mFileHandlingUris = list2;
    }

    private void grantUriPermissionToProvider(Context context) {
        Iterator<Uri> it = this.mSharedFileUris.iterator();
        while (it.hasNext()) {
            context.grantUriPermission(this.mIntent.getPackage(), it.next(), 1);
        }
        for (Uri uri : this.mFileHandlingUris) {
            if (context.checkCallingOrSelfUriPermission(uri, 1) == 0) {
                int iCheckCallingOrSelfUriPermission = context.checkCallingOrSelfUriPermission(uri, 2);
                Intent intent = this.mIntent;
                if (iCheckCallingOrSelfUriPermission == 0) {
                    context.grantUriPermission(intent.getPackage(), uri, 3);
                } else {
                    context.grantUriPermission(intent.getPackage(), uri, 1);
                }
            }
        }
    }

    public List<TrustedWebActivityDisplayMode> getDisplayOverrideList() {
        ArrayList parcelableArrayListExtra = IntentCompat.getParcelableArrayListExtra(getIntent(), TrustedWebActivityIntentBuilder.EXTRA_DISPLAY_OVERRIDE, Bundle.class);
        if (parcelableArrayListExtra == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            arrayList.add(TrustedWebActivityDisplayMode.fromBundle((Bundle) it.next()));
        }
        return arrayList;
    }

    public FileHandlingData getFileHandlingData() {
        return FileHandlingData.fromBundle(getIntent().getBundleExtra(TrustedWebActivityIntentBuilder.EXTRA_FILE_HANDLING_DATA));
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public int getLaunchHandlerClientMode() {
        return getIntent().getIntExtra(TrustedWebActivityIntentBuilder.EXTRA_LAUNCH_HANDLER_CLIENT_MODE, 0);
    }

    public Uri getOriginalLaunchUrl() {
        return (Uri) IntentCompat.getParcelableExtra(getIntent(), TrustedWebActivityIntentBuilder.EXTRA_ORIGINAL_LAUNCH_URL, Uri.class);
    }

    public void launchTrustedWebActivity(Context context) {
        grantUriPermissionToProvider(context);
        ContextCompat.startActivity(context, this.mIntent, null);
    }
}
