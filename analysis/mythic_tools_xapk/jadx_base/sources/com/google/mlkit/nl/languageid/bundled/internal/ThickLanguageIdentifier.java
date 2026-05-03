package com.google.mlkit.nl.languageid.bundled.internal;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.nl.languageid.IdentifiedLanguage;
import com.google.mlkit.nl.languageid.LanguageIdentificationOptions;
import com.google.mlkit.nl.languageid.internal.LanguageIdentifierDelegate;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:language-id@@17.0.6 */
/* JADX INFO: loaded from: classes5.dex */
public class ThickLanguageIdentifier implements LanguageIdentifierDelegate {
    private static boolean zba;
    private final Context zbb;
    private long zbc;

    ThickLanguageIdentifier(Context context, LanguageIdentificationOptions languageIdentificationOptions) {
        this.zbb = context;
    }

    private native void nativeDestroy(long j);

    private native IdentifiedLanguage[] nativeIdentifyPossibleLanguages(long j, byte[] bArr, float f);

    private native long nativeInitFromBuffer(MappedByteBuffer mappedByteBuffer, long j);

    public static synchronized void zba() throws MlKitException {
        if (zba) {
            return;
        }
        try {
            System.loadLibrary("language_id_l2c_jni");
            zba = true;
        } catch (UnsatisfiedLinkError e) {
            throw new MlKitException("Couldn't load language identification library.", 13, e);
        }
    }

    @Override // com.google.mlkit.nl.languageid.internal.LanguageIdentifierDelegate
    public final List identifyPossibleLanguages(String str, float f) {
        Preconditions.checkState(this.zbc != 0);
        IdentifiedLanguage[] identifiedLanguageArrNativeIdentifyPossibleLanguages = nativeIdentifyPossibleLanguages(this.zbc, str.getBytes(StandardCharsets.UTF_8), f);
        ArrayList arrayList = new ArrayList();
        for (IdentifiedLanguage identifiedLanguage : identifiedLanguageArrNativeIdentifyPossibleLanguages) {
            arrayList.add(new IdentifiedLanguage(identifiedLanguage.getLanguageTag(), identifiedLanguage.getConfidence()));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[Catch: IOException -> 0x0075, DONT_GENERATE, FINALLY_INSNS, SYNTHETIC, TRY_LEAVE, TryCatch #2 {IOException -> 0x0075, blocks: (B:7:0x0013, B:15:0x004f, B:34:0x0074, B:33:0x0071, B:30:0x006c, B:8:0x001f, B:13:0x004a, B:26:0x0067, B:25:0x0064), top: B:42:0x0013, inners: #0, #3 }] */
    @Override // com.google.mlkit.nl.languageid.internal.LanguageIdentifierDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void init() throws MlKitException {
        Preconditions.checkState(this.zbc == 0);
        zba();
        try {
            AssetFileDescriptor assetFileDescriptorOpenFd = this.zbb.getAssets().openFd("tflite_langid.tflite.jpg");
            try {
                FileChannel channel = new FileInputStream(assetFileDescriptorOpenFd.getFileDescriptor()).getChannel();
                try {
                    long jNativeInitFromBuffer = nativeInitFromBuffer(channel.map(FileChannel.MapMode.READ_ONLY, assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getDeclaredLength()), assetFileDescriptorOpenFd.getDeclaredLength());
                    this.zbc = jNativeInitFromBuffer;
                    if (jNativeInitFromBuffer == 0) {
                        throw new MlKitException("Couldn't load language identification model", 13);
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    if (assetFileDescriptorOpenFd != null) {
                        assetFileDescriptorOpenFd.close();
                        return;
                    }
                    return;
                } finally {
                    throw new MlKitException("Couldn't open language identification model file", 13, e);
                }
            } finally {
            }
        } catch (IOException e) {
            throw new MlKitException("Couldn't open language identification model file", 13, e);
        }
    }

    @Override // com.google.mlkit.nl.languageid.internal.LanguageIdentifierDelegate
    public final void release() {
        long j = this.zbc;
        if (j == 0) {
            return;
        }
        nativeDestroy(j);
        this.zbc = 0L;
    }
}
