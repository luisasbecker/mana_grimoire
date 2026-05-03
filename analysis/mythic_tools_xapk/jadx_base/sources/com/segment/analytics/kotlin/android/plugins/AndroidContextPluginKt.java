package com.segment.analytics.kotlin.android.plugins;

import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: AndroidContextPlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\u001a&\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\u0006\u001a\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u001a\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005\u001a\u0016\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005\u001a\n\u0010\r\u001a\u00020\u0005*\u00020\u000e¨\u0006\u000f"}, d2 = {"getSystemService", ExifInterface.GPS_DIRECTION_TRUE, "context", "Landroid/content/Context;", "serviceConstant", "", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;", "getUniqueID", "hasFeature", "", "feature", "hasPermission", "permission", "toHexString", "", "android_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidContextPluginKt {
    public static final /* synthetic */ <T> T getSystemService(Context context, String serviceConstant) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serviceConstant, "serviceConstant");
        T t = (T) context.getSystemService(serviceConstant);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final String getUniqueID() throws Throwable {
        MediaDrm mediaDrm;
        MediaDrm mediaDrm2 = null;
        try {
            mediaDrm = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L));
            try {
                byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
                Intrinsics.checkNotNullExpressionValue(propertyByteArray, "wvDrm.getPropertyByteArr…ROPERTY_DEVICE_UNIQUE_ID)");
                MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
                messageDigest.update(propertyByteArray);
                byte[] bArrDigest = messageDigest.digest();
                Intrinsics.checkNotNullExpressionValue(bArrDigest, "md.digest()");
                String hexString = toHexString(bArrDigest);
                if (Build.VERSION.SDK_INT >= 28) {
                    mediaDrm.release();
                    return hexString;
                }
                mediaDrm.release();
                return hexString;
            } catch (Exception unused) {
                if (Build.VERSION.SDK_INT >= 28) {
                    if (mediaDrm != null) {
                        mediaDrm.release();
                    }
                } else if (mediaDrm != null) {
                    mediaDrm.release();
                }
                return null;
            } catch (Throwable th) {
                th = th;
                mediaDrm2 = mediaDrm;
                if (Build.VERSION.SDK_INT >= 28) {
                    if (mediaDrm2 != null) {
                        mediaDrm2.release();
                    }
                } else if (mediaDrm2 != null) {
                    mediaDrm2.release();
                }
                throw th;
            }
        } catch (Exception unused2) {
            mediaDrm = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final boolean hasFeature(Context context, String feature) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feature, "feature");
        return context.getPackageManager().hasSystemFeature(feature);
    }

    public static final boolean hasPermission(Context context, String permission) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permission, "permission");
        return context.checkCallingOrSelfPermission(permission) == 0;
    }

    public static final String toHexString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.segment.analytics.kotlin.android.plugins.AndroidContextPluginKt.toHexString.1
            public final CharSequence invoke(byte b) {
                String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
                return str;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                return invoke(b.byteValue());
            }
        }, 30, (Object) null);
    }
}
