package androidx.compose.ui.text.googlefonts;

import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import androidx.compose.ui.text.googlefonts.GoogleFont;
import androidx.core.content.res.FontResourcesParserCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FontProviderHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0003\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002\u001a$\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n0\n*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\u00020\u00042\u0006\u0010\u0011\u001a\u00020\rH\u0002\u001a!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0002\u0010\u0019\".\u0010\u0012\u001a\"\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u000b0\u000b0\u0013j\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u000b0\u000b`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"checkAvailable", "", "Landroidx/compose/ui/text/googlefonts/GoogleFont$Provider;", "packageManager", "Landroid/content/pm/PackageManager;", "resources", "Landroid/content/res/Resources;", "throwFormattedCertsMissError", "", "signatures", "", "", "repr", "", "b", "loadCertsIfNeeded", "getSignatures", "packageName", "ByteArrayComparator", "Ljava/util/Comparator;", "kotlin.jvm.PlatformType", "Lkotlin/Comparator;", "convertToByteArrayList", "", "Landroid/content/pm/Signature;", "([Landroid/content/pm/Signature;)Ljava/util/List;", "ui-text-google-fonts"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FontProviderHelperKt {
    private static final Comparator<byte[]> ByteArrayComparator = new Comparator() { // from class: androidx.compose.ui.text.googlefonts.FontProviderHelperKt$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return FontProviderHelperKt.ByteArrayComparator$lambda$0((byte[]) obj, (byte[]) obj2);
        }
    };

    static final int ByteArrayComparator$lambda$0(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            byte b2 = bArr2[i];
            if (b != b2) {
                return b - b2;
            }
        }
        return 0;
    }

    public static final boolean checkAvailable(GoogleFont.Provider provider, PackageManager packageManager, Resources resources) {
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(provider.getProviderAuthority(), 0);
        if (providerInfoResolveContentProvider == null || !Intrinsics.areEqual(providerInfoResolveContentProvider.packageName, provider.getProviderPackage())) {
            return false;
        }
        List<byte[]> signatures = getSignatures(packageManager, providerInfoResolveContentProvider.packageName);
        List listSortedWith = CollectionsKt.sortedWith(signatures, ByteArrayComparator);
        List<List<byte[]>> listLoadCertsIfNeeded = loadCertsIfNeeded(provider, resources);
        if (!(listLoadCertsIfNeeded instanceof Collection) || !listLoadCertsIfNeeded.isEmpty()) {
            Iterator<T> it = listLoadCertsIfNeeded.iterator();
            while (it.hasNext()) {
                List list = (List) it.next();
                List listSortedWith2 = list != null ? CollectionsKt.sortedWith(list, ByteArrayComparator) : null;
                if (listSortedWith2 != null && listSortedWith2.size() == listSortedWith.size()) {
                    int size = listSortedWith2.size();
                    for (int i = 0; i < size; i++) {
                        if (!Arrays.equals((byte[]) listSortedWith2.get(i), (byte[]) listSortedWith.get(i))) {
                            break;
                        }
                    }
                    return true;
                }
            }
        }
        throwFormattedCertsMissError(signatures);
        throw new KotlinNothingValueException();
    }

    private static final List<byte[]> convertToByteArrayList(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static final List<byte[]> getSignatures(PackageManager packageManager, String str) {
        Signature[] signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        Intrinsics.checkNotNull(signatureArr);
        return convertToByteArrayList(signatureArr);
    }

    private static final List<List<byte[]>> loadCertsIfNeeded(GoogleFont.Provider provider, Resources resources) {
        return provider.getCertificates$ui_text_google_fonts() != null ? provider.getCertificates$ui_text_google_fonts() : FontResourcesParserCompat.readCerts(resources, provider.getCertificatesRes());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String repr(byte[] bArr) {
        return ArraysKt.joinToString$default(bArr, (CharSequence) ",", (CharSequence) "byteArrayOf(", (CharSequence) ")", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    private static final Void throwFormattedCertsMissError(List<byte[]> list) {
        throw new IllegalStateException("Provided signatures did not match. Actual signatures of package are:\n\n" + CollectionsKt.joinToString$default(list, ",", "listOf(listOf(", "))", 0, null, new Function1() { // from class: androidx.compose.ui.text.googlefonts.FontProviderHelperKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FontProviderHelperKt.repr((byte[]) obj);
            }
        }, 24, null));
    }
}
