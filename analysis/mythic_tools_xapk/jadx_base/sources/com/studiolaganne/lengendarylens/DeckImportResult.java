package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImportDeckDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003JU\u0010!\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\nHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017¨\u0006'"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckImportResult;", "", "cards", "", "Lcom/studiolaganne/lengendarylens/ParsedCard;", "parsedDeckList", "Lcom/studiolaganne/lengendarylens/ParsedDeckList;", "inputStream", "Ljava/io/InputStream;", "fileName", "", "replaceAllCards", "", "url", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/ParsedDeckList;Ljava/io/InputStream;Ljava/lang/String;ZLjava/lang/String;)V", "getCards", "()Ljava/util/List;", "getParsedDeckList", "()Lcom/studiolaganne/lengendarylens/ParsedDeckList;", "getInputStream", "()Ljava/io/InputStream;", "getFileName", "()Ljava/lang/String;", "getReplaceAllCards", "()Z", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DeckImportResult {
    public static final int $stable = 8;
    private final List<ParsedCard> cards;
    private final String fileName;
    private final InputStream inputStream;
    private final ParsedDeckList parsedDeckList;
    private final boolean replaceAllCards;
    private final String url;

    public DeckImportResult() {
        this(null, null, null, null, false, null, 63, null);
    }

    public DeckImportResult(List<ParsedCard> list, ParsedDeckList parsedDeckList, InputStream inputStream, String str, boolean z, String str2) {
        this.cards = list;
        this.parsedDeckList = parsedDeckList;
        this.inputStream = inputStream;
        this.fileName = str;
        this.replaceAllCards = z;
        this.url = str2;
    }

    public /* synthetic */ DeckImportResult(List list, ParsedDeckList parsedDeckList, InputStream inputStream, String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : parsedDeckList, (i & 4) != 0 ? null : inputStream, (i & 8) != 0 ? null : str, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeckImportResult copy$default(DeckImportResult deckImportResult, List list, ParsedDeckList parsedDeckList, InputStream inputStream, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = deckImportResult.cards;
        }
        if ((i & 2) != 0) {
            parsedDeckList = deckImportResult.parsedDeckList;
        }
        if ((i & 4) != 0) {
            inputStream = deckImportResult.inputStream;
        }
        if ((i & 8) != 0) {
            str = deckImportResult.fileName;
        }
        if ((i & 16) != 0) {
            z = deckImportResult.replaceAllCards;
        }
        if ((i & 32) != 0) {
            str2 = deckImportResult.url;
        }
        boolean z2 = z;
        String str3 = str2;
        return deckImportResult.copy(list, parsedDeckList, inputStream, str, z2, str3);
    }

    public final List<ParsedCard> component1() {
        return this.cards;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ParsedDeckList getParsedDeckList() {
        return this.parsedDeckList;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final InputStream getInputStream() {
        return this.inputStream;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getReplaceAllCards() {
        return this.replaceAllCards;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final DeckImportResult copy(List<ParsedCard> cards, ParsedDeckList parsedDeckList, InputStream inputStream, String fileName, boolean replaceAllCards, String url) {
        return new DeckImportResult(cards, parsedDeckList, inputStream, fileName, replaceAllCards, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeckImportResult)) {
            return false;
        }
        DeckImportResult deckImportResult = (DeckImportResult) other;
        return Intrinsics.areEqual(this.cards, deckImportResult.cards) && Intrinsics.areEqual(this.parsedDeckList, deckImportResult.parsedDeckList) && Intrinsics.areEqual(this.inputStream, deckImportResult.inputStream) && Intrinsics.areEqual(this.fileName, deckImportResult.fileName) && this.replaceAllCards == deckImportResult.replaceAllCards && Intrinsics.areEqual(this.url, deckImportResult.url);
    }

    public final List<ParsedCard> getCards() {
        return this.cards;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final InputStream getInputStream() {
        return this.inputStream;
    }

    public final ParsedDeckList getParsedDeckList() {
        return this.parsedDeckList;
    }

    public final boolean getReplaceAllCards() {
        return this.replaceAllCards;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        List<ParsedCard> list = this.cards;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        ParsedDeckList parsedDeckList = this.parsedDeckList;
        int iHashCode2 = (iHashCode + (parsedDeckList == null ? 0 : parsedDeckList.hashCode())) * 31;
        InputStream inputStream = this.inputStream;
        int iHashCode3 = (iHashCode2 + (inputStream == null ? 0 : inputStream.hashCode())) * 31;
        String str = this.fileName;
        int iHashCode4 = (((iHashCode3 + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.replaceAllCards)) * 31;
        String str2 = this.url;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DeckImportResult(cards=" + this.cards + ", parsedDeckList=" + this.parsedDeckList + ", inputStream=" + this.inputStream + ", fileName=" + this.fileName + ", replaceAllCards=" + this.replaceAllCards + ", url=" + this.url + ")";
    }
}
