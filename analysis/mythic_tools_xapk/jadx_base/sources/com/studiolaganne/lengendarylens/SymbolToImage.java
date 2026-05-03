package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.studiolaganne.lengendarylens.SymbolToImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchGroup;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SymbolToImage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ/\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016¢\u0006\u0002\u0010\u0017JK\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b0\u001a2\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/SymbolToImage;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "imageForSymbol", "Landroid/graphics/drawable/Drawable;", "name", "", "extractOutermostParenthesesWithRange", "", "Lcom/studiolaganne/lengendarylens/SymbolToImage$MatchInfo;", "text", "removeDuplicateParentheses", "stringToAttributedStringWithSymbols", "Landroid/text/SpannableString;", "input", "imageSize", "", "attrs", "", "Landroid/text/style/CharacterStyle;", "(Ljava/lang/String;I[Landroid/text/style/CharacterStyle;)Landroid/text/SpannableString;", "stringToAttributedStringWithSymbolsAndLinks", "onLinkClicked", "Lkotlin/Function1;", "", "(Ljava/lang/String;ILandroid/content/Context;Lkotlin/jvm/functions/Function1;[Landroid/text/style/CharacterStyle;)Landroid/text/SpannableString;", "MatchInfo", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SymbolToImage {
    public static final int $stable = 8;
    private final Context context;

    /* JADX INFO: compiled from: SymbolToImage.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/SymbolToImage$MatchInfo;", "", "text", "", "startIndex", "", "endIndex", "<init>", "(Ljava/lang/String;II)V", "getText", "()Ljava/lang/String;", "getStartIndex", "()I", "getEndIndex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MatchInfo {
        public static final int $stable = 0;
        private final int endIndex;
        private final int startIndex;
        private final String text;

        public MatchInfo(String text, int i, int i2) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.startIndex = i;
            this.endIndex = i2;
        }

        public static /* synthetic */ MatchInfo copy$default(MatchInfo matchInfo, String str, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = matchInfo.text;
            }
            if ((i3 & 2) != 0) {
                i = matchInfo.startIndex;
            }
            if ((i3 & 4) != 0) {
                i2 = matchInfo.endIndex;
            }
            return matchInfo.copy(str, i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getStartIndex() {
            return this.startIndex;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getEndIndex() {
            return this.endIndex;
        }

        public final MatchInfo copy(String text, int startIndex, int endIndex) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new MatchInfo(text, startIndex, endIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MatchInfo)) {
                return false;
            }
            MatchInfo matchInfo = (MatchInfo) other;
            return Intrinsics.areEqual(this.text, matchInfo.text) && this.startIndex == matchInfo.startIndex && this.endIndex == matchInfo.endIndex;
        }

        public final int getEndIndex() {
            return this.endIndex;
        }

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return (((this.text.hashCode() * 31) + Integer.hashCode(this.startIndex)) * 31) + Integer.hashCode(this.endIndex);
        }

        public String toString() {
            return "MatchInfo(text=" + this.text + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ")";
        }
    }

    public SymbolToImage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final List<MatchInfo> extractOutermostParenthesesWithRange(String text) {
        ArrayList arrayList = new ArrayList();
        int length = text.length();
        int i = 0;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = text.charAt(i3);
            if (cCharAt == '(') {
                if (i == 0) {
                    i2 = i3;
                }
                i++;
            } else if (cCharAt == ')' && i - 1 == 0 && i2 != -1) {
                String strSubstring = text.substring(i2 + 1, i3);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                arrayList.add(new MatchInfo(strSubstring, i2, i3));
                i2 = -1;
            }
        }
        return arrayList;
    }

    public final Drawable imageForSymbol(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Resources resources = this.context.getResources();
        String lowerCase = name.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int identifier = resources.getIdentifier("symbol_" + lowerCase, "drawable", this.context.getPackageName());
        if (identifier == 0) {
            return null;
        }
        return ContextCompat.getDrawable(this.context, identifier);
    }

    public final String removeDuplicateParentheses(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        List<MatchInfo> listExtractOutermostParenthesesWithRange = extractOutermostParenthesesWithRange(text);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList<MatchInfo> arrayList = new ArrayList();
        for (MatchInfo matchInfo : listExtractOutermostParenthesesWithRange) {
            if (!linkedHashSet.add(matchInfo.getText())) {
                arrayList.add(matchInfo);
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.SymbolToImage$removeDuplicateParentheses$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((SymbolToImage.MatchInfo) t2).getStartIndex()), Integer.valueOf(((SymbolToImage.MatchInfo) t).getStartIndex()));
                }
            });
        }
        StringBuilder sb = new StringBuilder(text);
        for (MatchInfo matchInfo2 : arrayList) {
            sb.delete(matchInfo2.getStartIndex(), matchInfo2.getEndIndex() + 1);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final SpannableString stringToAttributedStringWithSymbols(String input, int imageSize, CharacterStyle... attrs) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        String str = input;
        SpannableString spannableString = new SpannableString(str);
        for (CharacterStyle characterStyle : attrs) {
            spannableString.setSpan(CharacterStyle.wrap(characterStyle), 0, input.length(), 33);
        }
        for (kotlin.text.MatchResult matchResult : Regex.findAll$default(new Regex("\\{([^\\}]+)\\}"), str, 0, 2, null)) {
            Drawable drawableImageForSymbol = imageForSymbol(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(matchResult.getValue(), "{", "", false, 4, (Object) null), "}", "", false, 4, (Object) null), DomExceptionUtils.SEPARATOR, "", false, 4, (Object) null), "%", "", false, 4, (Object) null));
            if (drawableImageForSymbol != null) {
                drawableImageForSymbol.setBounds(0, 0, imageSize, imageSize);
                spannableString.setSpan(new ImageSpan(drawableImageForSymbol, 0), matchResult.getRange().getFirst(), matchResult.getRange().getLast() + 1, 33);
            }
        }
        return spannableString;
    }

    public final SpannableString stringToAttributedStringWithSymbolsAndLinks(String input, int imageSize, final Context context, final Function1<? super String, Unit> onLinkClicked, CharacterStyle... attrs) {
        int i;
        final String value;
        String value2;
        String input2 = input;
        Intrinsics.checkNotNullParameter(input2, "input");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onLinkClicked, "onLinkClicked");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        int last = 0;
        List<kotlin.text.MatchResult> list = SequencesKt.toList(Regex.findAll$default(new Regex("\\[\\[([^\\]]+)\\]\\]"), input2, 0, 2, null));
        Iterator it = list.iterator();
        int length = 0;
        while (true) {
            String str = "";
            i = 1;
            if (!it.hasNext()) {
                break;
            }
            kotlin.text.MatchResult matchResult = (kotlin.text.MatchResult) it.next();
            MatchGroup matchGroup = matchResult.getGroups().get(1);
            if (matchGroup != null && (value2 = matchGroup.getValue()) != null) {
                str = value2;
            }
            input2 = StringsKt.replaceRange((CharSequence) input2, matchResult.getRange().getFirst() - length, (matchResult.getRange().getLast() + 1) - length, (CharSequence) str).toString();
            length += matchResult.getValue().length() - str.length();
        }
        String str2 = input2;
        SpannableString spannableString = new SpannableString(str2);
        int length2 = attrs.length;
        int i2 = 0;
        while (i2 < length2) {
            spannableString.setSpan(CharacterStyle.wrap(attrs[i2]), 0, input2.length(), 33);
            i2++;
            i = i;
        }
        int i3 = i;
        for (kotlin.text.MatchResult matchResult2 : Regex.findAll$default(new Regex("\\{([^\\}]+)\\}"), str2, 0, 2, null)) {
            Drawable drawableImageForSymbol = imageForSymbol(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(matchResult2.getValue(), "{", "", false, 4, (Object) null), "}", "", false, 4, (Object) null), DomExceptionUtils.SEPARATOR, "", false, 4, (Object) null), "%", "", false, 4, (Object) null));
            if (drawableImageForSymbol != null) {
                drawableImageForSymbol.setBounds(0, 0, imageSize, imageSize);
                spannableString.setSpan(new ImageSpan(drawableImageForSymbol, 0), matchResult2.getRange().getFirst(), matchResult2.getRange().getLast() + 1, 33);
            }
        }
        for (kotlin.text.MatchResult matchResult3 : list) {
            MatchGroup matchGroup2 = matchResult3.getGroups().get(i3);
            if (matchGroup2 == null || (value = matchGroup2.getValue()) == null) {
                value = "";
            }
            int first = matchResult3.getRange().getFirst() - last;
            spannableString.setSpan(new ClickableSpan() { // from class: com.studiolaganne.lengendarylens.SymbolToImage$stringToAttributedStringWithSymbolsAndLinks$clickableSpan$1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    onLinkClicked.invoke(value);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.checkNotNullParameter(ds, "ds");
                    super.updateDrawState(ds);
                    ds.setUnderlineText(true);
                    ds.setColor(ContextCompat.getColor(context, R.color.link_color));
                }
            }, first, value.length() + first, 33);
            last += ((matchResult3.getRange().getLast() - matchResult3.getRange().getFirst()) - value.length()) + 1;
            i3 = 1;
        }
        return spannableString;
    }
}
