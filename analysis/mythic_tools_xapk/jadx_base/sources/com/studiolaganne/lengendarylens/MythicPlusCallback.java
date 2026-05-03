package com.studiolaganne.lengendarylens;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MythicPlusBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusCallback;", "", "onAddCardToDeck", "", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "listType", "", "onRemoveCardFromDeck", "onMoveCard", "onMythicPlusClosed", "onDeckChanged", "onConvertSmartDeck", "onSubscribeMythicPlus", FirebaseAnalytics.Param.LOCATION, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MythicPlusCallback {

    /* JADX INFO: compiled from: MythicPlusBottomSheetFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onConvertSmartDeck(MythicPlusCallback mythicPlusCallback) {
            MythicPlusCallback.super.onConvertSmartDeck();
        }

        @Deprecated
        public static void onDeckChanged(MythicPlusCallback mythicPlusCallback) {
            MythicPlusCallback.super.onDeckChanged();
        }

        @Deprecated
        public static void onMoveCard(MythicPlusCallback mythicPlusCallback, MTFullCard card, String listType) {
            Intrinsics.checkNotNullParameter(card, "card");
            Intrinsics.checkNotNullParameter(listType, "listType");
            MythicPlusCallback.super.onMoveCard(card, listType);
        }

        @Deprecated
        public static void onRemoveCardFromDeck(MythicPlusCallback mythicPlusCallback, MTFullCard card) {
            Intrinsics.checkNotNullParameter(card, "card");
            MythicPlusCallback.super.onRemoveCardFromDeck(card);
        }

        @Deprecated
        public static void onSubscribeMythicPlus(MythicPlusCallback mythicPlusCallback, String location) {
            Intrinsics.checkNotNullParameter(location, "location");
            MythicPlusCallback.super.onSubscribeMythicPlus(location);
        }
    }

    void onAddCardToDeck(MTFullCard card, String listType);

    default void onConvertSmartDeck() {
    }

    default void onDeckChanged() {
    }

    default void onMoveCard(MTFullCard card, String listType) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(listType, "listType");
    }

    void onMythicPlusClosed();

    default void onRemoveCardFromDeck(MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
    }

    default void onSubscribeMythicPlus(String location) {
        Intrinsics.checkNotNullParameter(location, "location");
    }
}
