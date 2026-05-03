package com.studiolaganne.lengendarylens;

import androidx.constraintlayout.motion.widget.Key;
import kotlin.Metadata;

/* JADX INFO: compiled from: LifeTotalView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH&J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0019H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0019H&J\u0018\u0010(\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0007H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010,\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH&J\u0018\u0010-\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH&J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH&J\u0018\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH&J\u0018\u00100\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH&J\u0018\u00101\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u00102\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u00103\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u00104\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u00105\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J \u00106\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0007H&J\u0018\u0010:\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0007H&J\u0010\u0010<\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010=\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010>\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@2\u0006\u00109\u001a\u00020\u0007H&J\u0018\u0010A\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0007H&J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010C\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010D\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J*\u0010E\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u00020\rH&J\u0010\u0010J\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010K\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0007H&J\u0018\u0010M\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u0007H&J\u0010\u0010O\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010P\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010Q\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0007H&J\u0018\u0010R\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0007H&J\u0018\u0010S\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\rH&J\u0010\u0010U\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010V\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010W\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010X\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010Y\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010Z\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010[\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH&J\u0010\u0010\\\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010]\u001a\u00020\u0003H&¨\u0006^À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/LifeTotalViewCallback;", "", "lifeTotalChanged", "", "sender", "Lcom/studiolaganne/lengendarylens/LifeTotalView;", "newValue", "", "poisonCounterTapped", Key.ROTATION, "commanderDamageTapped", "confirmPlayerDeath", "fromMenu", "", "monarchCoinDropped", "monarchCoinRejected", "cityCoinDropped", "cityCoinRejected", "theRingCoinDropped", "theRingCoinRejected", "commanderDamageClosed", "commanderDamageValueChanged", "commanderDamageRunningTotalChanged", "playerIsKO", "contextStr", "", "undoPlayerDeath", "confirmPlayerWin", "undoPlayerWin", "playerIsWin", "partnersToggled", "playmatSelected", "id", "signalCardScanInProgress", "signalPhotoPickInProgress", "pickAColor", "commanderDamagePartnerValueChanged", "commanderDamagePartnerRunningTotalChanged", "editPlayerNameTapped", "currentName", "ownCmdDamageTapped", "orientation", "leftPicked", "rightPicked", "energyToggled", "stormToggled", "experienceToggled", "taxToggled", "radiationToggled", "energyCounterTapped", "stormCounterTapped", "experienceCounterTapped", "taxCounterTapped", "radiationCounterTapped", "playgroupUserSelected", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "previousUserId", "playgroupUserUnselected", "currentUserId", "currentUserSelected", "currentUserUnselected", "mythicUserSelected", "friend", "Lcom/studiolaganne/lengendarylens/MTFriend;", "mythicUserUnselected", "guestUserSelected", "guestUserUnselected", "qrScanSelected", "playgroupDeckSelected", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "userId", "endOfGame", "deckCleared", "lifeTotalChangeCommitted", "delta", "treacheryRoleRevealed", "role", "swipeMenuOpened", "swipeMenuClosed", "createDeckForGuest", "createDeckForMythicUser", "playerIsPlayingFirst", "playingFirst", "confirmPlayerConcede", "confirmPlayerDraw", "playerTapToStartTapped", "pauseTimerToggled", "endTurnTapped", "undoNextTurnTapped", "poisonToggled", "initiativeCoinDropped", "initiativeCoinRejected", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface LifeTotalViewCallback {

    /* JADX INFO: compiled from: LifeTotalView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void playgroupDeckSelected$default(LifeTotalViewCallback lifeTotalViewCallback, LifeTotalView lifeTotalView, MTDeck mTDeck, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playgroupDeckSelected");
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        lifeTotalViewCallback.playgroupDeckSelected(lifeTotalView, mTDeck, i, z);
    }

    void cityCoinDropped(LifeTotalView sender);

    void cityCoinRejected();

    void commanderDamageClosed(LifeTotalView sender);

    void commanderDamagePartnerRunningTotalChanged(LifeTotalView sender, int newValue);

    void commanderDamagePartnerValueChanged(LifeTotalView sender, int newValue);

    void commanderDamageRunningTotalChanged(LifeTotalView sender, int newValue);

    void commanderDamageTapped(LifeTotalView sender, int rotation);

    void commanderDamageValueChanged(LifeTotalView sender, int newValue);

    void confirmPlayerConcede(LifeTotalView sender);

    void confirmPlayerDeath(LifeTotalView sender, boolean fromMenu);

    void confirmPlayerDraw(LifeTotalView sender);

    void confirmPlayerWin(LifeTotalView sender);

    void createDeckForGuest(LifeTotalView sender, int userId);

    void createDeckForMythicUser(LifeTotalView sender, int userId);

    void currentUserSelected(LifeTotalView sender);

    void currentUserUnselected(LifeTotalView sender);

    void deckCleared(LifeTotalView sender);

    void editPlayerNameTapped(LifeTotalView sender, String currentName);

    void endTurnTapped(LifeTotalView sender);

    void energyCounterTapped(LifeTotalView sender, int rotation);

    void energyToggled(LifeTotalView sender, boolean newValue);

    void experienceCounterTapped(LifeTotalView sender, int rotation);

    void experienceToggled(LifeTotalView sender, boolean newValue);

    void guestUserSelected(LifeTotalView sender);

    void guestUserUnselected(LifeTotalView sender);

    void initiativeCoinDropped(LifeTotalView sender);

    void initiativeCoinRejected();

    void leftPicked(LifeTotalView sender);

    void lifeTotalChangeCommitted(LifeTotalView sender, int delta);

    void lifeTotalChanged(LifeTotalView sender, int newValue);

    void monarchCoinDropped(LifeTotalView sender);

    void monarchCoinRejected();

    void mythicUserSelected(LifeTotalView sender, MTFriend friend, int previousUserId);

    void mythicUserUnselected(LifeTotalView sender, int currentUserId);

    void ownCmdDamageTapped(LifeTotalView sender, int orientation);

    void partnersToggled(LifeTotalView sender, boolean newValue);

    void pauseTimerToggled(LifeTotalView sender);

    void pickAColor(LifeTotalView sender);

    void playerIsKO(LifeTotalView sender, String contextStr);

    void playerIsPlayingFirst(LifeTotalView sender, boolean playingFirst);

    void playerIsWin(LifeTotalView sender);

    void playerTapToStartTapped(LifeTotalView sender);

    void playgroupDeckSelected(LifeTotalView sender, MTDeck deck, int userId, boolean endOfGame);

    void playgroupUserSelected(LifeTotalView sender, MTUser user, int previousUserId);

    void playgroupUserUnselected(LifeTotalView sender, int currentUserId);

    void playmatSelected(LifeTotalView sender, String id);

    void poisonCounterTapped(LifeTotalView sender, int rotation);

    void poisonToggled(LifeTotalView sender, boolean newValue);

    void qrScanSelected(LifeTotalView sender);

    void radiationCounterTapped(LifeTotalView sender, int rotation);

    void radiationToggled(LifeTotalView sender, boolean newValue);

    void rightPicked(LifeTotalView sender);

    void signalCardScanInProgress(LifeTotalView sender);

    void signalPhotoPickInProgress(LifeTotalView sender);

    void stormCounterTapped(LifeTotalView sender, int rotation);

    void stormToggled(LifeTotalView sender, boolean newValue);

    void swipeMenuClosed(LifeTotalView sender);

    void swipeMenuOpened(LifeTotalView sender);

    void taxCounterTapped(LifeTotalView sender, int rotation);

    void taxToggled(LifeTotalView sender, boolean newValue);

    void theRingCoinDropped(LifeTotalView sender);

    void theRingCoinRejected();

    void treacheryRoleRevealed(LifeTotalView sender, int role);

    void undoNextTurnTapped(LifeTotalView sender);

    void undoPlayerDeath(LifeTotalView sender);

    void undoPlayerWin(LifeTotalView sender);
}
