package com.studiolaganne.lengendarylens;

import com.bumptech.glide.load.Key;
import com.facebook.appevents.AppEventsConstants;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: DeckListDekParser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckListDekParser;", "", "<init>", "()V", "parseInputStream", "Lcom/studiolaganne/lengendarylens/ParsedDeckList;", "inputStream", "Ljava/io/InputStream;", "parseInputStreamLegacy", "", "Lcom/studiolaganne/lengendarylens/ParsedCard;", "parseCardElement", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckListDekParser {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: DeckListDekParser.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardSection.values().length];
            try {
                iArr[CardSection.MAIN_DECK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CardSection.SIDEBOARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CardSection.MAYBEBOARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final ParsedCard parseCardElement(XmlPullParser parser) {
        Integer intOrNull;
        try {
            String attributeValue = parser.getAttributeValue(null, "Quantity");
            int iIntValue = (attributeValue == null || (intOrNull = StringsKt.toIntOrNull(attributeValue)) == null) ? 1 : intOrNull.intValue();
            String attributeValue2 = parser.getAttributeValue(null, "Name");
            if (attributeValue2 == null) {
                return null;
            }
            String attributeValue3 = parser.getAttributeValue(null, "CatID");
            String str = (attributeValue3 == null || Intrinsics.areEqual(attributeValue3, AppEventsConstants.EVENT_PARAM_VALUE_NO)) ? null : attributeValue3;
            String attributeValue4 = parser.getAttributeValue(null, "Sideboard");
            return new ParsedCard(iIntValue, attributeValue2, null, null, null, str, attributeValue4 != null ? StringsKt.equals(attributeValue4, "true", true) : false ? CardSection.SIDEBOARD : CardSection.MAIN_DECK, 28, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final ParsedDeckList parseInputStream(InputStream inputStream) {
        XmlPullParser xmlPullParserNewPullParser;
        int eventType;
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, Key.STRING_CHARSET_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
            if (eventType == 2 && Intrinsics.areEqual(xmlPullParserNewPullParser.getName(), "Cards")) {
                Intrinsics.checkNotNull(xmlPullParserNewPullParser);
                ParsedCard cardElement = parseCardElement(xmlPullParserNewPullParser);
                if (cardElement != null) {
                    int i = WhenMappings.$EnumSwitchMapping$0[cardElement.getSection().ordinal()];
                    if (i == 1) {
                        arrayList.add(cardElement);
                    } else {
                        if (i != 2) {
                            if (i != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            arrayList.add(cardElement);
                            return new ParsedDeckList(arrayList, arrayList2, CollectionsKt.emptyList());
                        }
                        arrayList2.add(cardElement);
                    }
                } else {
                    continue;
                }
            }
        }
        return new ParsedDeckList(arrayList, arrayList2, CollectionsKt.emptyList());
    }

    public final List<ParsedCard> parseInputStreamLegacy(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return parseInputStream(inputStream).getMainDeckCards();
    }
}
