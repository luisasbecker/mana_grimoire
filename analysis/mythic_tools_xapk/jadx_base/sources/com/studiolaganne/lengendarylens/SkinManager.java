package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SkinManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J \u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006J \u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\u001e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006J \u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/SkinManager;", "", "<init>", "()V", "fonts", "", "", "Landroid/graphics/Typeface;", "isSkinValid", "", "context", "Landroid/content/Context;", "code", "getColorFromHex", "", "hexColor", "getFontFromSkin", "fontName", "getImageFromSkin", "Landroid/graphics/Bitmap;", "imageName", "getLottieFromSkin", "lottieName", "getWebpFileFromSkin", "Ljava/io/File;", "fileName", "getSkinDefinition", "Lcom/studiolaganne/lengendarylens/SkinDefinition;", "getCurrentSkinCode", "getCurrentSkinDefinition", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SkinManager {
    private static SkinManager instance;
    private Map<String, Typeface> fonts;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: SkinManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/SkinManager$Companion;", "", "<init>", "()V", "instance", "Lcom/studiolaganne/lengendarylens/SkinManager;", "getInstance", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized SkinManager getInstance() {
            SkinManager skinManager;
            if (SkinManager.instance == null) {
                SkinManager.instance = new SkinManager(null);
            }
            skinManager = SkinManager.instance;
            Intrinsics.checkNotNull(skinManager);
            return skinManager;
        }
    }

    private SkinManager() {
        this.fonts = new LinkedHashMap();
    }

    public /* synthetic */ SkinManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final int getColorFromHex(String hexColor) {
        Intrinsics.checkNotNullParameter(hexColor, "hexColor");
        if (hexColor.length() == 0 || Intrinsics.areEqual(hexColor, AbstractJsonLexerKt.NULL)) {
            return 0;
        }
        return Color.parseColor(hexColor);
    }

    public final String getCurrentSkinCode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PreferencesManager(context).getString(PreferencesManager.CREATOR_CODE, "default");
    }

    public final SkinDefinition getCurrentSkinDefinition(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = new PreferencesManager(context).getString(PreferencesManager.CREATOR_CODE, "default");
        if (string.length() == 0 || Intrinsics.areEqual(string, "default")) {
            return null;
        }
        return getSkinDefinition(context, string);
    }

    public final Typeface getFontFromSkin(Context context, String code, String fontName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(fontName, "fontName");
        if (this.fonts.containsKey(fontName)) {
            return this.fonts.get(fontName);
        }
        File file = new File(context.getExternalFilesDir(null), "themes");
        if (!file.exists()) {
            return null;
        }
        File file2 = new File(file, code);
        if (!file2.exists()) {
            return null;
        }
        File file3 = new File(file2, fontName + ".ttf");
        if (!file3.exists()) {
            file3 = new File(file2, fontName + ".otf");
            if (!file3.exists()) {
                return null;
            }
        }
        try {
            Typeface typefaceCreateFromFile = Typeface.createFromFile(file3);
            this.fonts.put(fontName, typefaceCreateFromFile);
            return typefaceCreateFromFile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final Bitmap getImageFromSkin(Context context, String code, String imageName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(imageName, "imageName");
        File file = new File(context.getExternalFilesDir(null), "themes");
        if (!file.exists()) {
            return null;
        }
        File file2 = new File(file, code);
        if (!file2.exists()) {
            return null;
        }
        File file3 = new File(file2, imageName + ".png");
        if (file3.exists()) {
            try {
                return BitmapFactory.decodeFileDescriptor(new FileInputStream(file3).getFD());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        File file4 = new File(file2, imageName + ".jpg");
        if (!file4.exists()) {
            return null;
        }
        try {
            return BitmapFactory.decodeFileDescriptor(new FileInputStream(file4).getFD());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final String getLottieFromSkin(Context context, String code, String lottieName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(lottieName, "lottieName");
        File file = new File(context.getExternalFilesDir(null), "themes");
        if (!file.exists()) {
            return "";
        }
        File file2 = new File(file, code);
        if (!file2.exists()) {
            return "";
        }
        File file3 = new File(file2, lottieName + ".json");
        return !file3.exists() ? "" : FilesKt.readText$default(file3, null, 1, null);
    }

    public final SkinDefinition getSkinDefinition(Context context, String code) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(code, "code");
        File file = new File(context.getExternalFilesDir(null), "themes");
        if (!file.exists()) {
            return null;
        }
        File file2 = new File(file, code);
        if (!file2.exists()) {
            return null;
        }
        File file3 = new File(file2, "theme.json");
        if (!file3.exists()) {
            return null;
        }
        return (SkinDefinition) new Gson().fromJson(FilesKt.readText$default(file3, null, 1, null), SkinDefinition.class);
    }

    public final File getWebpFileFromSkin(Context context, String code, String fileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        File file = new File(context.getExternalFilesDir(null), "themes");
        if (!file.exists()) {
            return null;
        }
        File file2 = new File(file, code);
        if (!file2.exists()) {
            return null;
        }
        File file3 = new File(file2, fileName + ".webp");
        if (file3.exists()) {
            return file3;
        }
        return null;
    }

    public final boolean isSkinValid(Context context, String code) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(code, "code");
        return getSkinDefinition(context, code) != null;
    }
}
