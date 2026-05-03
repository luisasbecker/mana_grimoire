package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020>HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014¨\u0006?"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDBsBody;", "", "cards", "Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;", "glossary", "rules", "rulings", "sets", "embeddings_cards", "embeddings_sets", "model_card_art", "model_card_classifier", "model_card_detection", "model_plist_detector", "model_set_symbols", "<init>", "(Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;)V", "getCards", "()Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;", "setCards", "(Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;)V", "getGlossary", "setGlossary", "getRules", "setRules", "getRulings", "setRulings", "getSets", "setSets", "getEmbeddings_cards", "setEmbeddings_cards", "getEmbeddings_sets", "setEmbeddings_sets", "getModel_card_art", "setModel_card_art", "getModel_card_classifier", "setModel_card_classifier", "getModel_card_detection", "setModel_card_detection", "getModel_plist_detector", "setModel_plist_detector", "getModel_set_symbols", "setModel_set_symbols", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDBsBody {
    public static final int $stable = 8;
    private MTLanguagesAndVersions cards;
    private MTLanguagesAndVersions embeddings_cards;
    private MTLanguagesAndVersions embeddings_sets;
    private MTLanguagesAndVersions glossary;
    private MTLanguagesAndVersions model_card_art;
    private MTLanguagesAndVersions model_card_classifier;
    private MTLanguagesAndVersions model_card_detection;
    private MTLanguagesAndVersions model_plist_detector;
    private MTLanguagesAndVersions model_set_symbols;
    private MTLanguagesAndVersions rules;
    private MTLanguagesAndVersions rulings;
    private MTLanguagesAndVersions sets;

    public MTDBsBody() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public MTDBsBody(MTLanguagesAndVersions cards, MTLanguagesAndVersions glossary, MTLanguagesAndVersions rules, MTLanguagesAndVersions rulings, MTLanguagesAndVersions sets, MTLanguagesAndVersions embeddings_cards, MTLanguagesAndVersions embeddings_sets, MTLanguagesAndVersions model_card_art, MTLanguagesAndVersions model_card_classifier, MTLanguagesAndVersions model_card_detection, MTLanguagesAndVersions model_plist_detector, MTLanguagesAndVersions model_set_symbols) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(glossary, "glossary");
        Intrinsics.checkNotNullParameter(rules, "rules");
        Intrinsics.checkNotNullParameter(rulings, "rulings");
        Intrinsics.checkNotNullParameter(sets, "sets");
        Intrinsics.checkNotNullParameter(embeddings_cards, "embeddings_cards");
        Intrinsics.checkNotNullParameter(embeddings_sets, "embeddings_sets");
        Intrinsics.checkNotNullParameter(model_card_art, "model_card_art");
        Intrinsics.checkNotNullParameter(model_card_classifier, "model_card_classifier");
        Intrinsics.checkNotNullParameter(model_card_detection, "model_card_detection");
        Intrinsics.checkNotNullParameter(model_plist_detector, "model_plist_detector");
        Intrinsics.checkNotNullParameter(model_set_symbols, "model_set_symbols");
        this.cards = cards;
        this.glossary = glossary;
        this.rules = rules;
        this.rulings = rulings;
        this.sets = sets;
        this.embeddings_cards = embeddings_cards;
        this.embeddings_sets = embeddings_sets;
        this.model_card_art = model_card_art;
        this.model_card_classifier = model_card_classifier;
        this.model_card_detection = model_card_detection;
        this.model_plist_detector = model_plist_detector;
        this.model_set_symbols = model_set_symbols;
    }

    public /* synthetic */ MTDBsBody(MTLanguagesAndVersions mTLanguagesAndVersions, MTLanguagesAndVersions mTLanguagesAndVersions2, MTLanguagesAndVersions mTLanguagesAndVersions3, MTLanguagesAndVersions mTLanguagesAndVersions4, MTLanguagesAndVersions mTLanguagesAndVersions5, MTLanguagesAndVersions mTLanguagesAndVersions6, MTLanguagesAndVersions mTLanguagesAndVersions7, MTLanguagesAndVersions mTLanguagesAndVersions8, MTLanguagesAndVersions mTLanguagesAndVersions9, MTLanguagesAndVersions mTLanguagesAndVersions10, MTLanguagesAndVersions mTLanguagesAndVersions11, MTLanguagesAndVersions mTLanguagesAndVersions12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new MTLanguagesAndVersions(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndVersions, (i & 2) != 0 ? new MTLanguagesAndVersions(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndVersions2, (i & 4) != 0 ? new MTLanguagesAndVersions(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndVersions3, (i & 8) != 0 ? new MTLanguagesAndVersions(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndVersions4, (i & 16) != 0 ? new MTLanguagesAndVersions(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndVersions5, (i & 32) != 0 ? new MTLanguagesAndVersions(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndVersions6, (i & 64) != 0 ? new MTLanguagesAndVersions(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndVersions7, (i & 128) != 0 ? new MTLanguagesAndVersions(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndVersions8, (i & 256) != 0 ? new MTLanguagesAndVersions(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndVersions9, (i & 512) != 0 ? new MTLanguagesAndVersions(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndVersions10, (i & 1024) != 0 ? new MTLanguagesAndVersions(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndVersions11, (i & 2048) != 0 ? new MTLanguagesAndVersions(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndVersions12);
    }

    public static /* synthetic */ MTDBsBody copy$default(MTDBsBody mTDBsBody, MTLanguagesAndVersions mTLanguagesAndVersions, MTLanguagesAndVersions mTLanguagesAndVersions2, MTLanguagesAndVersions mTLanguagesAndVersions3, MTLanguagesAndVersions mTLanguagesAndVersions4, MTLanguagesAndVersions mTLanguagesAndVersions5, MTLanguagesAndVersions mTLanguagesAndVersions6, MTLanguagesAndVersions mTLanguagesAndVersions7, MTLanguagesAndVersions mTLanguagesAndVersions8, MTLanguagesAndVersions mTLanguagesAndVersions9, MTLanguagesAndVersions mTLanguagesAndVersions10, MTLanguagesAndVersions mTLanguagesAndVersions11, MTLanguagesAndVersions mTLanguagesAndVersions12, int i, Object obj) {
        if ((i & 1) != 0) {
            mTLanguagesAndVersions = mTDBsBody.cards;
        }
        if ((i & 2) != 0) {
            mTLanguagesAndVersions2 = mTDBsBody.glossary;
        }
        if ((i & 4) != 0) {
            mTLanguagesAndVersions3 = mTDBsBody.rules;
        }
        if ((i & 8) != 0) {
            mTLanguagesAndVersions4 = mTDBsBody.rulings;
        }
        if ((i & 16) != 0) {
            mTLanguagesAndVersions5 = mTDBsBody.sets;
        }
        if ((i & 32) != 0) {
            mTLanguagesAndVersions6 = mTDBsBody.embeddings_cards;
        }
        if ((i & 64) != 0) {
            mTLanguagesAndVersions7 = mTDBsBody.embeddings_sets;
        }
        if ((i & 128) != 0) {
            mTLanguagesAndVersions8 = mTDBsBody.model_card_art;
        }
        if ((i & 256) != 0) {
            mTLanguagesAndVersions9 = mTDBsBody.model_card_classifier;
        }
        if ((i & 512) != 0) {
            mTLanguagesAndVersions10 = mTDBsBody.model_card_detection;
        }
        if ((i & 1024) != 0) {
            mTLanguagesAndVersions11 = mTDBsBody.model_plist_detector;
        }
        if ((i & 2048) != 0) {
            mTLanguagesAndVersions12 = mTDBsBody.model_set_symbols;
        }
        MTLanguagesAndVersions mTLanguagesAndVersions13 = mTLanguagesAndVersions11;
        MTLanguagesAndVersions mTLanguagesAndVersions14 = mTLanguagesAndVersions12;
        MTLanguagesAndVersions mTLanguagesAndVersions15 = mTLanguagesAndVersions9;
        MTLanguagesAndVersions mTLanguagesAndVersions16 = mTLanguagesAndVersions10;
        MTLanguagesAndVersions mTLanguagesAndVersions17 = mTLanguagesAndVersions7;
        MTLanguagesAndVersions mTLanguagesAndVersions18 = mTLanguagesAndVersions8;
        MTLanguagesAndVersions mTLanguagesAndVersions19 = mTLanguagesAndVersions5;
        MTLanguagesAndVersions mTLanguagesAndVersions20 = mTLanguagesAndVersions6;
        return mTDBsBody.copy(mTLanguagesAndVersions, mTLanguagesAndVersions2, mTLanguagesAndVersions3, mTLanguagesAndVersions4, mTLanguagesAndVersions19, mTLanguagesAndVersions20, mTLanguagesAndVersions17, mTLanguagesAndVersions18, mTLanguagesAndVersions15, mTLanguagesAndVersions16, mTLanguagesAndVersions13, mTLanguagesAndVersions14);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTLanguagesAndVersions getCards() {
        return this.cards;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final MTLanguagesAndVersions getModel_card_detection() {
        return this.model_card_detection;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final MTLanguagesAndVersions getModel_plist_detector() {
        return this.model_plist_detector;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final MTLanguagesAndVersions getModel_set_symbols() {
        return this.model_set_symbols;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTLanguagesAndVersions getGlossary() {
        return this.glossary;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTLanguagesAndVersions getRules() {
        return this.rules;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTLanguagesAndVersions getRulings() {
        return this.rulings;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTLanguagesAndVersions getSets() {
        return this.sets;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MTLanguagesAndVersions getEmbeddings_cards() {
        return this.embeddings_cards;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MTLanguagesAndVersions getEmbeddings_sets() {
        return this.embeddings_sets;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final MTLanguagesAndVersions getModel_card_art() {
        return this.model_card_art;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final MTLanguagesAndVersions getModel_card_classifier() {
        return this.model_card_classifier;
    }

    public final MTDBsBody copy(MTLanguagesAndVersions cards, MTLanguagesAndVersions glossary, MTLanguagesAndVersions rules, MTLanguagesAndVersions rulings, MTLanguagesAndVersions sets, MTLanguagesAndVersions embeddings_cards, MTLanguagesAndVersions embeddings_sets, MTLanguagesAndVersions model_card_art, MTLanguagesAndVersions model_card_classifier, MTLanguagesAndVersions model_card_detection, MTLanguagesAndVersions model_plist_detector, MTLanguagesAndVersions model_set_symbols) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(glossary, "glossary");
        Intrinsics.checkNotNullParameter(rules, "rules");
        Intrinsics.checkNotNullParameter(rulings, "rulings");
        Intrinsics.checkNotNullParameter(sets, "sets");
        Intrinsics.checkNotNullParameter(embeddings_cards, "embeddings_cards");
        Intrinsics.checkNotNullParameter(embeddings_sets, "embeddings_sets");
        Intrinsics.checkNotNullParameter(model_card_art, "model_card_art");
        Intrinsics.checkNotNullParameter(model_card_classifier, "model_card_classifier");
        Intrinsics.checkNotNullParameter(model_card_detection, "model_card_detection");
        Intrinsics.checkNotNullParameter(model_plist_detector, "model_plist_detector");
        Intrinsics.checkNotNullParameter(model_set_symbols, "model_set_symbols");
        return new MTDBsBody(cards, glossary, rules, rulings, sets, embeddings_cards, embeddings_sets, model_card_art, model_card_classifier, model_card_detection, model_plist_detector, model_set_symbols);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDBsBody)) {
            return false;
        }
        MTDBsBody mTDBsBody = (MTDBsBody) other;
        return Intrinsics.areEqual(this.cards, mTDBsBody.cards) && Intrinsics.areEqual(this.glossary, mTDBsBody.glossary) && Intrinsics.areEqual(this.rules, mTDBsBody.rules) && Intrinsics.areEqual(this.rulings, mTDBsBody.rulings) && Intrinsics.areEqual(this.sets, mTDBsBody.sets) && Intrinsics.areEqual(this.embeddings_cards, mTDBsBody.embeddings_cards) && Intrinsics.areEqual(this.embeddings_sets, mTDBsBody.embeddings_sets) && Intrinsics.areEqual(this.model_card_art, mTDBsBody.model_card_art) && Intrinsics.areEqual(this.model_card_classifier, mTDBsBody.model_card_classifier) && Intrinsics.areEqual(this.model_card_detection, mTDBsBody.model_card_detection) && Intrinsics.areEqual(this.model_plist_detector, mTDBsBody.model_plist_detector) && Intrinsics.areEqual(this.model_set_symbols, mTDBsBody.model_set_symbols);
    }

    public final MTLanguagesAndVersions getCards() {
        return this.cards;
    }

    public final MTLanguagesAndVersions getEmbeddings_cards() {
        return this.embeddings_cards;
    }

    public final MTLanguagesAndVersions getEmbeddings_sets() {
        return this.embeddings_sets;
    }

    public final MTLanguagesAndVersions getGlossary() {
        return this.glossary;
    }

    public final MTLanguagesAndVersions getModel_card_art() {
        return this.model_card_art;
    }

    public final MTLanguagesAndVersions getModel_card_classifier() {
        return this.model_card_classifier;
    }

    public final MTLanguagesAndVersions getModel_card_detection() {
        return this.model_card_detection;
    }

    public final MTLanguagesAndVersions getModel_plist_detector() {
        return this.model_plist_detector;
    }

    public final MTLanguagesAndVersions getModel_set_symbols() {
        return this.model_set_symbols;
    }

    public final MTLanguagesAndVersions getRules() {
        return this.rules;
    }

    public final MTLanguagesAndVersions getRulings() {
        return this.rulings;
    }

    public final MTLanguagesAndVersions getSets() {
        return this.sets;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.cards.hashCode() * 31) + this.glossary.hashCode()) * 31) + this.rules.hashCode()) * 31) + this.rulings.hashCode()) * 31) + this.sets.hashCode()) * 31) + this.embeddings_cards.hashCode()) * 31) + this.embeddings_sets.hashCode()) * 31) + this.model_card_art.hashCode()) * 31) + this.model_card_classifier.hashCode()) * 31) + this.model_card_detection.hashCode()) * 31) + this.model_plist_detector.hashCode()) * 31) + this.model_set_symbols.hashCode();
    }

    public final void setCards(MTLanguagesAndVersions mTLanguagesAndVersions) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndVersions, "<set-?>");
        this.cards = mTLanguagesAndVersions;
    }

    public final void setEmbeddings_cards(MTLanguagesAndVersions mTLanguagesAndVersions) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndVersions, "<set-?>");
        this.embeddings_cards = mTLanguagesAndVersions;
    }

    public final void setEmbeddings_sets(MTLanguagesAndVersions mTLanguagesAndVersions) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndVersions, "<set-?>");
        this.embeddings_sets = mTLanguagesAndVersions;
    }

    public final void setGlossary(MTLanguagesAndVersions mTLanguagesAndVersions) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndVersions, "<set-?>");
        this.glossary = mTLanguagesAndVersions;
    }

    public final void setModel_card_art(MTLanguagesAndVersions mTLanguagesAndVersions) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndVersions, "<set-?>");
        this.model_card_art = mTLanguagesAndVersions;
    }

    public final void setModel_card_classifier(MTLanguagesAndVersions mTLanguagesAndVersions) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndVersions, "<set-?>");
        this.model_card_classifier = mTLanguagesAndVersions;
    }

    public final void setModel_card_detection(MTLanguagesAndVersions mTLanguagesAndVersions) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndVersions, "<set-?>");
        this.model_card_detection = mTLanguagesAndVersions;
    }

    public final void setModel_plist_detector(MTLanguagesAndVersions mTLanguagesAndVersions) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndVersions, "<set-?>");
        this.model_plist_detector = mTLanguagesAndVersions;
    }

    public final void setModel_set_symbols(MTLanguagesAndVersions mTLanguagesAndVersions) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndVersions, "<set-?>");
        this.model_set_symbols = mTLanguagesAndVersions;
    }

    public final void setRules(MTLanguagesAndVersions mTLanguagesAndVersions) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndVersions, "<set-?>");
        this.rules = mTLanguagesAndVersions;
    }

    public final void setRulings(MTLanguagesAndVersions mTLanguagesAndVersions) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndVersions, "<set-?>");
        this.rulings = mTLanguagesAndVersions;
    }

    public final void setSets(MTLanguagesAndVersions mTLanguagesAndVersions) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndVersions, "<set-?>");
        this.sets = mTLanguagesAndVersions;
    }

    public String toString() {
        return "MTDBsBody(cards=" + this.cards + ", glossary=" + this.glossary + ", rules=" + this.rules + ", rulings=" + this.rulings + ", sets=" + this.sets + ", embeddings_cards=" + this.embeddings_cards + ", embeddings_sets=" + this.embeddings_sets + ", model_card_art=" + this.model_card_art + ", model_card_classifier=" + this.model_card_classifier + ", model_card_detection=" + this.model_card_detection + ", model_plist_detector=" + this.model_plist_detector + ", model_set_symbols=" + this.model_set_symbols + ")";
    }
}
