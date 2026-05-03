package com.vanniktech.emoji.google;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import com.vanniktech.emoji.Emoji;
import com.vanniktech.emoji.EmojiAndroidProvider;
import com.vanniktech.emoji.EmojiCategory;
import com.vanniktech.emoji.EmojiProvider;
import com.vanniktech.emoji.google.category.ActivitiesCategory;
import com.vanniktech.emoji.google.category.AnimalsAndNatureCategory;
import com.vanniktech.emoji.google.category.FlagsCategory;
import com.vanniktech.emoji.google.category.FoodAndDrinkCategory;
import com.vanniktech.emoji.google.category.ObjectsCategory;
import com.vanniktech.emoji.google.category.SmileysAndPeopleCategory;
import com.vanniktech.emoji.google.category.SymbolsCategory;
import com.vanniktech.emoji.google.category.TravelAndPlacesCategory;
import java.lang.ref.SoftReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GoogleEmojiProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/vanniktech/emoji/google/GoogleEmojiProvider;", "Lcom/vanniktech/emoji/EmojiProvider;", "Lcom/vanniktech/emoji/EmojiAndroidProvider;", "<init>", "()V", "categories", "", "Lcom/vanniktech/emoji/EmojiCategory;", "getCategories", "()[Lcom/vanniktech/emoji/EmojiCategory;", "getIcon", "", "emojiCategory", "getDrawable", "Landroid/graphics/drawable/Drawable;", "emoji", "Lcom/vanniktech/emoji/Emoji;", "context", "Landroid/content/Context;", "loadStrip", "Landroid/graphics/Bitmap;", "x", "release", "", "Companion", "emoji-google_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleEmojiProvider implements EmojiProvider, EmojiAndroidProvider {
    private static final int CACHE_SIZE = 100;
    private static final int NUM_STRIPS = 62;
    private static final int SPRITE_SIZE = 64;
    private static final int SPRITE_SIZE_INC_BORDER = 66;
    private static final Companion Companion = new Companion(null);
    private static final List<Integer> SHEETS = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.emoji_google_sheet_0), Integer.valueOf(R.drawable.emoji_google_sheet_1), Integer.valueOf(R.drawable.emoji_google_sheet_2), Integer.valueOf(R.drawable.emoji_google_sheet_3), Integer.valueOf(R.drawable.emoji_google_sheet_4), Integer.valueOf(R.drawable.emoji_google_sheet_5), Integer.valueOf(R.drawable.emoji_google_sheet_6), Integer.valueOf(R.drawable.emoji_google_sheet_7), Integer.valueOf(R.drawable.emoji_google_sheet_8), Integer.valueOf(R.drawable.emoji_google_sheet_9), Integer.valueOf(R.drawable.emoji_google_sheet_10), Integer.valueOf(R.drawable.emoji_google_sheet_11), Integer.valueOf(R.drawable.emoji_google_sheet_12), Integer.valueOf(R.drawable.emoji_google_sheet_13), Integer.valueOf(R.drawable.emoji_google_sheet_14), Integer.valueOf(R.drawable.emoji_google_sheet_15), Integer.valueOf(R.drawable.emoji_google_sheet_16), Integer.valueOf(R.drawable.emoji_google_sheet_17), Integer.valueOf(R.drawable.emoji_google_sheet_18), Integer.valueOf(R.drawable.emoji_google_sheet_19), Integer.valueOf(R.drawable.emoji_google_sheet_20), Integer.valueOf(R.drawable.emoji_google_sheet_21), Integer.valueOf(R.drawable.emoji_google_sheet_22), Integer.valueOf(R.drawable.emoji_google_sheet_23), Integer.valueOf(R.drawable.emoji_google_sheet_24), Integer.valueOf(R.drawable.emoji_google_sheet_25), Integer.valueOf(R.drawable.emoji_google_sheet_26), Integer.valueOf(R.drawable.emoji_google_sheet_27), Integer.valueOf(R.drawable.emoji_google_sheet_28), Integer.valueOf(R.drawable.emoji_google_sheet_29), Integer.valueOf(R.drawable.emoji_google_sheet_30), Integer.valueOf(R.drawable.emoji_google_sheet_31), Integer.valueOf(R.drawable.emoji_google_sheet_32), Integer.valueOf(R.drawable.emoji_google_sheet_33), Integer.valueOf(R.drawable.emoji_google_sheet_34), Integer.valueOf(R.drawable.emoji_google_sheet_35), Integer.valueOf(R.drawable.emoji_google_sheet_36), Integer.valueOf(R.drawable.emoji_google_sheet_37), Integer.valueOf(R.drawable.emoji_google_sheet_38), Integer.valueOf(R.drawable.emoji_google_sheet_39), Integer.valueOf(R.drawable.emoji_google_sheet_40), Integer.valueOf(R.drawable.emoji_google_sheet_41), Integer.valueOf(R.drawable.emoji_google_sheet_42), Integer.valueOf(R.drawable.emoji_google_sheet_43), Integer.valueOf(R.drawable.emoji_google_sheet_44), Integer.valueOf(R.drawable.emoji_google_sheet_45), Integer.valueOf(R.drawable.emoji_google_sheet_46), Integer.valueOf(R.drawable.emoji_google_sheet_47), Integer.valueOf(R.drawable.emoji_google_sheet_48), Integer.valueOf(R.drawable.emoji_google_sheet_49), Integer.valueOf(R.drawable.emoji_google_sheet_50), Integer.valueOf(R.drawable.emoji_google_sheet_51), Integer.valueOf(R.drawable.emoji_google_sheet_52), Integer.valueOf(R.drawable.emoji_google_sheet_53), Integer.valueOf(R.drawable.emoji_google_sheet_54), Integer.valueOf(R.drawable.emoji_google_sheet_55), Integer.valueOf(R.drawable.emoji_google_sheet_56), Integer.valueOf(R.drawable.emoji_google_sheet_57), Integer.valueOf(R.drawable.emoji_google_sheet_58), Integer.valueOf(R.drawable.emoji_google_sheet_59), Integer.valueOf(R.drawable.emoji_google_sheet_60), Integer.valueOf(R.drawable.emoji_google_sheet_61)});
    private static final Object LOCK = new Object();
    private static final SoftReference<?>[] STRIP_REFS = new SoftReference[62];
    private static final LruCache<Point, Bitmap> BITMAP_CACHE = new LruCache<>(100);

    /* JADX INFO: compiled from: GoogleEmojiProvider.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/vanniktech/emoji/google/GoogleEmojiProvider$Companion;", "", "<init>", "()V", "CACHE_SIZE", "", "SPRITE_SIZE", "SPRITE_SIZE_INC_BORDER", "NUM_STRIPS", "SHEETS", "", "LOCK", "STRIP_REFS", "", "Ljava/lang/ref/SoftReference;", "[Ljava/lang/ref/SoftReference;", "BITMAP_CACHE", "Landroid/util/LruCache;", "Landroid/graphics/Point;", "Landroid/graphics/Bitmap;", "emoji-google_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        for (int i = 0; i < 62; i++) {
            STRIP_REFS[i] = new SoftReference<>(null);
        }
    }

    private final Bitmap loadStrip(int x, Context context) {
        Bitmap bitmapDecodeResource;
        SoftReference<?>[] softReferenceArr = STRIP_REFS;
        SoftReference<?> softReference = softReferenceArr[x];
        Bitmap bitmap = (Bitmap) (softReference != null ? softReference.get() : null);
        if (bitmap != null) {
            return bitmap;
        }
        synchronized (LOCK) {
            SoftReference<?> softReference2 = softReferenceArr[x];
            bitmapDecodeResource = (Bitmap) (softReference2 != null ? softReference2.get() : null);
            if (bitmapDecodeResource == null) {
                Intrinsics.checkNotNull(context);
                bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), SHEETS.get(x).intValue());
                softReferenceArr[x] = new SoftReference<>(bitmapDecodeResource);
            }
            Unit unit = Unit.INSTANCE;
        }
        return bitmapDecodeResource;
    }

    @Override // com.vanniktech.emoji.EmojiProvider
    public EmojiCategory[] getCategories() {
        return new EmojiCategory[]{new SmileysAndPeopleCategory(), new AnimalsAndNatureCategory(), new FoodAndDrinkCategory(), new ActivitiesCategory(), new TravelAndPlacesCategory(), new ObjectsCategory(), new SymbolsCategory(), new FlagsCategory()};
    }

    @Override // com.vanniktech.emoji.EmojiAndroidProvider
    public Drawable getDrawable(Emoji emoji, Context context) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(emoji instanceof GoogleEmoji)) {
            throw new IllegalArgumentException("emoji needs to be of type GoogleEmoji".toString());
        }
        GoogleEmoji googleEmoji = (GoogleEmoji) emoji;
        int x = googleEmoji.getX();
        int y = googleEmoji.getY();
        Point point = new Point(x, y);
        LruCache<Point, Bitmap> lruCache = BITMAP_CACHE;
        Bitmap bitmap = lruCache.get(point);
        if (bitmap != null) {
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            return new BitmapDrawable(resources, bitmap);
        }
        Bitmap bitmapLoadStrip = loadStrip(x, context);
        Intrinsics.checkNotNull(bitmapLoadStrip);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapLoadStrip, 1, (y * 66) + 1, 64, 64);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        lruCache.put(point, bitmapCreateBitmap);
        Resources resources2 = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        return new BitmapDrawable(resources2, bitmapCreateBitmap);
    }

    @Override // com.vanniktech.emoji.EmojiAndroidProvider
    public int getIcon(EmojiCategory emojiCategory) {
        Intrinsics.checkNotNullParameter(emojiCategory, "emojiCategory");
        if (emojiCategory instanceof SmileysAndPeopleCategory) {
            return R.drawable.emoji_google_category_smileysandpeople;
        }
        if (emojiCategory instanceof AnimalsAndNatureCategory) {
            return R.drawable.emoji_google_category_animalsandnature;
        }
        if (emojiCategory instanceof FoodAndDrinkCategory) {
            return R.drawable.emoji_google_category_foodanddrink;
        }
        if (emojiCategory instanceof ActivitiesCategory) {
            return R.drawable.emoji_google_category_activities;
        }
        if (emojiCategory instanceof TravelAndPlacesCategory) {
            return R.drawable.emoji_google_category_travelandplaces;
        }
        if (emojiCategory instanceof ObjectsCategory) {
            return R.drawable.emoji_google_category_objects;
        }
        if (emojiCategory instanceof SymbolsCategory) {
            return R.drawable.emoji_google_category_symbols;
        }
        if (emojiCategory instanceof FlagsCategory) {
            return R.drawable.emoji_google_category_flags;
        }
        throw new IllegalStateException(("Unknown " + emojiCategory).toString());
    }

    @Override // com.vanniktech.emoji.EmojiProvider
    public void release() {
        synchronized (LOCK) {
            BITMAP_CACHE.evictAll();
            for (int i = 0; i < 62; i++) {
                SoftReference<?> softReference = STRIP_REFS[i];
                Bitmap bitmap = (Bitmap) (softReference != null ? softReference.get() : null);
                if (bitmap != null) {
                    bitmap.recycle();
                }
                if (softReference != null) {
                    softReference.clear();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
