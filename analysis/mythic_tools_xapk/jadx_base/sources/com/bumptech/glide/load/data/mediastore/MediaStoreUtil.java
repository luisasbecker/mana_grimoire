package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import com.caverock.androidsvg.SVGParser;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes3.dex */
public final class MediaStoreUtil {
    private static final int MINI_THUMB_HEIGHT = 384;
    private static final int MINI_THUMB_WIDTH = 512;
    public static final int MIN_EXTENSION_VERSION_FOR_OPEN_FILE_APIS = 17;

    private MediaStoreUtil() {
    }

    @Deprecated
    public static boolean isAndroidPickerUri(Uri uri) {
        if (!isMediaStoreUri(uri)) {
            return false;
        }
        for (String str : uri.getPathSegments()) {
            if (str != null && str.startsWith("picker")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMediaStoreImageUri(Uri uri) {
        return isMediaStoreUri(uri) && !isVideoUri(uri);
    }

    public static boolean isMediaStoreOpenFileApisAvailable() {
        return Build.VERSION.SDK_INT >= 30 && SdkExtensions.getExtensionVersion(30) >= 17;
    }

    public static boolean isMediaStoreUri(Uri uri) {
        return uri != null && FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme()) && SVGParser.XML_STYLESHEET_ATTR_MEDIA.equals(uri.getAuthority());
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        return isMediaStoreUri(uri) && isVideoUri(uri);
    }

    public static boolean isThumbnailSize(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= MINI_THUMB_HEIGHT;
    }

    private static boolean isVideoUri(Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    public static AssetFileDescriptor openAssetFileDescriptor(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return MediaStore.openAssetFileDescriptor(contentResolver, uri, "r", null);
    }
}
