package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020>HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014¨\u0006?"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDBsResponse;", "", "cards", "Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;", "glossary", "rules", "rulings", "sets", "embeddings_cards", "embeddings_sets", "model_card_art", "model_card_classifier", "model_card_detection", "model_plist_detector", "model_set_symbols", "<init>", "(Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;)V", "getCards", "()Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;", "setCards", "(Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;)V", "getGlossary", "setGlossary", "getRules", "setRules", "getRulings", "setRulings", "getSets", "setSets", "getEmbeddings_cards", "setEmbeddings_cards", "getEmbeddings_sets", "setEmbeddings_sets", "getModel_card_art", "setModel_card_art", "getModel_card_classifier", "setModel_card_classifier", "getModel_card_detection", "setModel_card_detection", "getModel_plist_detector", "setModel_plist_detector", "getModel_set_symbols", "setModel_set_symbols", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDBsResponse {
    public static final int $stable = 8;
    private MTLanguagesAndUpdates cards;
    private MTLanguagesAndUpdates embeddings_cards;
    private MTLanguagesAndUpdates embeddings_sets;
    private MTLanguagesAndUpdates glossary;
    private MTLanguagesAndUpdates model_card_art;
    private MTLanguagesAndUpdates model_card_classifier;
    private MTLanguagesAndUpdates model_card_detection;
    private MTLanguagesAndUpdates model_plist_detector;
    private MTLanguagesAndUpdates model_set_symbols;
    private MTLanguagesAndUpdates rules;
    private MTLanguagesAndUpdates rulings;
    private MTLanguagesAndUpdates sets;

    public MTDBsResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public MTDBsResponse(MTLanguagesAndUpdates cards, MTLanguagesAndUpdates glossary, MTLanguagesAndUpdates rules, MTLanguagesAndUpdates rulings, MTLanguagesAndUpdates sets, MTLanguagesAndUpdates embeddings_cards, MTLanguagesAndUpdates embeddings_sets, MTLanguagesAndUpdates model_card_art, MTLanguagesAndUpdates model_card_classifier, MTLanguagesAndUpdates model_card_detection, MTLanguagesAndUpdates model_plist_detector, MTLanguagesAndUpdates model_set_symbols) {
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

    public /* synthetic */ MTDBsResponse(MTLanguagesAndUpdates mTLanguagesAndUpdates, MTLanguagesAndUpdates mTLanguagesAndUpdates2, MTLanguagesAndUpdates mTLanguagesAndUpdates3, MTLanguagesAndUpdates mTLanguagesAndUpdates4, MTLanguagesAndUpdates mTLanguagesAndUpdates5, MTLanguagesAndUpdates mTLanguagesAndUpdates6, MTLanguagesAndUpdates mTLanguagesAndUpdates7, MTLanguagesAndUpdates mTLanguagesAndUpdates8, MTLanguagesAndUpdates mTLanguagesAndUpdates9, MTLanguagesAndUpdates mTLanguagesAndUpdates10, MTLanguagesAndUpdates mTLanguagesAndUpdates11, MTLanguagesAndUpdates mTLanguagesAndUpdates12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new MTLanguagesAndUpdates(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndUpdates, (i & 2) != 0 ? new MTLanguagesAndUpdates(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndUpdates2, (i & 4) != 0 ? new MTLanguagesAndUpdates(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndUpdates3, (i & 8) != 0 ? new MTLanguagesAndUpdates(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndUpdates4, (i & 16) != 0 ? new MTLanguagesAndUpdates(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndUpdates5, (i & 32) != 0 ? new MTLanguagesAndUpdates(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndUpdates6, (i & 64) != 0 ? new MTLanguagesAndUpdates(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndUpdates7, (i & 128) != 0 ? new MTLanguagesAndUpdates(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndUpdates8, (i & 256) != 0 ? new MTLanguagesAndUpdates(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndUpdates9, (i & 512) != 0 ? new MTLanguagesAndUpdates(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndUpdates10, (i & 1024) != 0 ? new MTLanguagesAndUpdates(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndUpdates11, (i & 2048) != 0 ? new MTLanguagesAndUpdates(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : mTLanguagesAndUpdates12);
    }

    public static /* synthetic */ MTDBsResponse copy$default(MTDBsResponse mTDBsResponse, MTLanguagesAndUpdates mTLanguagesAndUpdates, MTLanguagesAndUpdates mTLanguagesAndUpdates2, MTLanguagesAndUpdates mTLanguagesAndUpdates3, MTLanguagesAndUpdates mTLanguagesAndUpdates4, MTLanguagesAndUpdates mTLanguagesAndUpdates5, MTLanguagesAndUpdates mTLanguagesAndUpdates6, MTLanguagesAndUpdates mTLanguagesAndUpdates7, MTLanguagesAndUpdates mTLanguagesAndUpdates8, MTLanguagesAndUpdates mTLanguagesAndUpdates9, MTLanguagesAndUpdates mTLanguagesAndUpdates10, MTLanguagesAndUpdates mTLanguagesAndUpdates11, MTLanguagesAndUpdates mTLanguagesAndUpdates12, int i, Object obj) {
        if ((i & 1) != 0) {
            mTLanguagesAndUpdates = mTDBsResponse.cards;
        }
        if ((i & 2) != 0) {
            mTLanguagesAndUpdates2 = mTDBsResponse.glossary;
        }
        if ((i & 4) != 0) {
            mTLanguagesAndUpdates3 = mTDBsResponse.rules;
        }
        if ((i & 8) != 0) {
            mTLanguagesAndUpdates4 = mTDBsResponse.rulings;
        }
        if ((i & 16) != 0) {
            mTLanguagesAndUpdates5 = mTDBsResponse.sets;
        }
        if ((i & 32) != 0) {
            mTLanguagesAndUpdates6 = mTDBsResponse.embeddings_cards;
        }
        if ((i & 64) != 0) {
            mTLanguagesAndUpdates7 = mTDBsResponse.embeddings_sets;
        }
        if ((i & 128) != 0) {
            mTLanguagesAndUpdates8 = mTDBsResponse.model_card_art;
        }
        if ((i & 256) != 0) {
            mTLanguagesAndUpdates9 = mTDBsResponse.model_card_classifier;
        }
        if ((i & 512) != 0) {
            mTLanguagesAndUpdates10 = mTDBsResponse.model_card_detection;
        }
        if ((i & 1024) != 0) {
            mTLanguagesAndUpdates11 = mTDBsResponse.model_plist_detector;
        }
        if ((i & 2048) != 0) {
            mTLanguagesAndUpdates12 = mTDBsResponse.model_set_symbols;
        }
        MTLanguagesAndUpdates mTLanguagesAndUpdates13 = mTLanguagesAndUpdates11;
        MTLanguagesAndUpdates mTLanguagesAndUpdates14 = mTLanguagesAndUpdates12;
        MTLanguagesAndUpdates mTLanguagesAndUpdates15 = mTLanguagesAndUpdates9;
        MTLanguagesAndUpdates mTLanguagesAndUpdates16 = mTLanguagesAndUpdates10;
        MTLanguagesAndUpdates mTLanguagesAndUpdates17 = mTLanguagesAndUpdates7;
        MTLanguagesAndUpdates mTLanguagesAndUpdates18 = mTLanguagesAndUpdates8;
        MTLanguagesAndUpdates mTLanguagesAndUpdates19 = mTLanguagesAndUpdates5;
        MTLanguagesAndUpdates mTLanguagesAndUpdates20 = mTLanguagesAndUpdates6;
        return mTDBsResponse.copy(mTLanguagesAndUpdates, mTLanguagesAndUpdates2, mTLanguagesAndUpdates3, mTLanguagesAndUpdates4, mTLanguagesAndUpdates19, mTLanguagesAndUpdates20, mTLanguagesAndUpdates17, mTLanguagesAndUpdates18, mTLanguagesAndUpdates15, mTLanguagesAndUpdates16, mTLanguagesAndUpdates13, mTLanguagesAndUpdates14);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTLanguagesAndUpdates getCards() {
        return this.cards;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final MTLanguagesAndUpdates getModel_card_detection() {
        return this.model_card_detection;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final MTLanguagesAndUpdates getModel_plist_detector() {
        return this.model_plist_detector;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final MTLanguagesAndUpdates getModel_set_symbols() {
        return this.model_set_symbols;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTLanguagesAndUpdates getGlossary() {
        return this.glossary;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTLanguagesAndUpdates getRules() {
        return this.rules;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTLanguagesAndUpdates getRulings() {
        return this.rulings;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTLanguagesAndUpdates getSets() {
        return this.sets;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MTLanguagesAndUpdates getEmbeddings_cards() {
        return this.embeddings_cards;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MTLanguagesAndUpdates getEmbeddings_sets() {
        return this.embeddings_sets;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final MTLanguagesAndUpdates getModel_card_art() {
        return this.model_card_art;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final MTLanguagesAndUpdates getModel_card_classifier() {
        return this.model_card_classifier;
    }

    public final MTDBsResponse copy(MTLanguagesAndUpdates cards, MTLanguagesAndUpdates glossary, MTLanguagesAndUpdates rules, MTLanguagesAndUpdates rulings, MTLanguagesAndUpdates sets, MTLanguagesAndUpdates embeddings_cards, MTLanguagesAndUpdates embeddings_sets, MTLanguagesAndUpdates model_card_art, MTLanguagesAndUpdates model_card_classifier, MTLanguagesAndUpdates model_card_detection, MTLanguagesAndUpdates model_plist_detector, MTLanguagesAndUpdates model_set_symbols) {
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
        return new MTDBsResponse(cards, glossary, rules, rulings, sets, embeddings_cards, embeddings_sets, model_card_art, model_card_classifier, model_card_detection, model_plist_detector, model_set_symbols);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDBsResponse)) {
            return false;
        }
        MTDBsResponse mTDBsResponse = (MTDBsResponse) other;
        return Intrinsics.areEqual(this.cards, mTDBsResponse.cards) && Intrinsics.areEqual(this.glossary, mTDBsResponse.glossary) && Intrinsics.areEqual(this.rules, mTDBsResponse.rules) && Intrinsics.areEqual(this.rulings, mTDBsResponse.rulings) && Intrinsics.areEqual(this.sets, mTDBsResponse.sets) && Intrinsics.areEqual(this.embeddings_cards, mTDBsResponse.embeddings_cards) && Intrinsics.areEqual(this.embeddings_sets, mTDBsResponse.embeddings_sets) && Intrinsics.areEqual(this.model_card_art, mTDBsResponse.model_card_art) && Intrinsics.areEqual(this.model_card_classifier, mTDBsResponse.model_card_classifier) && Intrinsics.areEqual(this.model_card_detection, mTDBsResponse.model_card_detection) && Intrinsics.areEqual(this.model_plist_detector, mTDBsResponse.model_plist_detector) && Intrinsics.areEqual(this.model_set_symbols, mTDBsResponse.model_set_symbols);
    }

    public final MTLanguagesAndUpdates getCards() {
        return this.cards;
    }

    public final MTLanguagesAndUpdates getEmbeddings_cards() {
        return this.embeddings_cards;
    }

    public final MTLanguagesAndUpdates getEmbeddings_sets() {
        return this.embeddings_sets;
    }

    public final MTLanguagesAndUpdates getGlossary() {
        return this.glossary;
    }

    public final MTLanguagesAndUpdates getModel_card_art() {
        return this.model_card_art;
    }

    public final MTLanguagesAndUpdates getModel_card_classifier() {
        return this.model_card_classifier;
    }

    public final MTLanguagesAndUpdates getModel_card_detection() {
        return this.model_card_detection;
    }

    public final MTLanguagesAndUpdates getModel_plist_detector() {
        return this.model_plist_detector;
    }

    public final MTLanguagesAndUpdates getModel_set_symbols() {
        return this.model_set_symbols;
    }

    public final MTLanguagesAndUpdates getRules() {
        return this.rules;
    }

    public final MTLanguagesAndUpdates getRulings() {
        return this.rulings;
    }

    public final MTLanguagesAndUpdates getSets() {
        return this.sets;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.cards.hashCode() * 31) + this.glossary.hashCode()) * 31) + this.rules.hashCode()) * 31) + this.rulings.hashCode()) * 31) + this.sets.hashCode()) * 31) + this.embeddings_cards.hashCode()) * 31) + this.embeddings_sets.hashCode()) * 31) + this.model_card_art.hashCode()) * 31) + this.model_card_classifier.hashCode()) * 31) + this.model_card_detection.hashCode()) * 31) + this.model_plist_detector.hashCode()) * 31) + this.model_set_symbols.hashCode();
    }

    public final void setCards(MTLanguagesAndUpdates mTLanguagesAndUpdates) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndUpdates, "<set-?>");
        this.cards = mTLanguagesAndUpdates;
    }

    public final void setEmbeddings_cards(MTLanguagesAndUpdates mTLanguagesAndUpdates) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndUpdates, "<set-?>");
        this.embeddings_cards = mTLanguagesAndUpdates;
    }

    public final void setEmbeddings_sets(MTLanguagesAndUpdates mTLanguagesAndUpdates) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndUpdates, "<set-?>");
        this.embeddings_sets = mTLanguagesAndUpdates;
    }

    public final void setGlossary(MTLanguagesAndUpdates mTLanguagesAndUpdates) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndUpdates, "<set-?>");
        this.glossary = mTLanguagesAndUpdates;
    }

    public final void setModel_card_art(MTLanguagesAndUpdates mTLanguagesAndUpdates) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndUpdates, "<set-?>");
        this.model_card_art = mTLanguagesAndUpdates;
    }

    public final void setModel_card_classifier(MTLanguagesAndUpdates mTLanguagesAndUpdates) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndUpdates, "<set-?>");
        this.model_card_classifier = mTLanguagesAndUpdates;
    }

    public final void setModel_card_detection(MTLanguagesAndUpdates mTLanguagesAndUpdates) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndUpdates, "<set-?>");
        this.model_card_detection = mTLanguagesAndUpdates;
    }

    public final void setModel_plist_detector(MTLanguagesAndUpdates mTLanguagesAndUpdates) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndUpdates, "<set-?>");
        this.model_plist_detector = mTLanguagesAndUpdates;
    }

    public final void setModel_set_symbols(MTLanguagesAndUpdates mTLanguagesAndUpdates) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndUpdates, "<set-?>");
        this.model_set_symbols = mTLanguagesAndUpdates;
    }

    public final void setRules(MTLanguagesAndUpdates mTLanguagesAndUpdates) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndUpdates, "<set-?>");
        this.rules = mTLanguagesAndUpdates;
    }

    public final void setRulings(MTLanguagesAndUpdates mTLanguagesAndUpdates) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndUpdates, "<set-?>");
        this.rulings = mTLanguagesAndUpdates;
    }

    public final void setSets(MTLanguagesAndUpdates mTLanguagesAndUpdates) {
        Intrinsics.checkNotNullParameter(mTLanguagesAndUpdates, "<set-?>");
        this.sets = mTLanguagesAndUpdates;
    }

    public String toString() {
        return "MTDBsResponse(cards=" + this.cards + ", glossary=" + this.glossary + ", rules=" + this.rules + ", rulings=" + this.rulings + ", sets=" + this.sets + ", embeddings_cards=" + this.embeddings_cards + ", embeddings_sets=" + this.embeddings_sets + ", model_card_art=" + this.model_card_art + ", model_card_classifier=" + this.model_card_classifier + ", model_card_detection=" + this.model_card_detection + ", model_plist_detector=" + this.model_plist_detector + ", model_set_symbols=" + this.model_set_symbols + ")";
    }
}
