package com.studiolaganne.lengendarylens;

import kotlin.Metadata;

/* JADX INFO: compiled from: SwipeMenuView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\nH&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010!\u001a\u00020\u0003H&¨\u0006\"À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/SwipeMenuViewCallback;", "", "killTapped", "", "winTapped", "swipeClose", "direction", "Lcom/studiolaganne/lengendarylens/Direction;", "partnersToggled", "newValue", "", "playmatSelected", "id", "", "pickACardTapped", "pickAPhotoTapped", "plainColorTapped", "editPlayerNameTapped", "leftPicked", "rightPicked", "energyToggled", "stormToggled", "deckSelectedFromSwipe", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "endOfGame", "createDeckSelected", "concedeTapped", "drawTapped", "experienceToggled", "taxToggled", "radiationToggled", "poisonToggled", "createGuestDeckSelected", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SwipeMenuViewCallback {

    /* JADX INFO: compiled from: SwipeMenuView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void deckSelectedFromSwipe$default(SwipeMenuViewCallback swipeMenuViewCallback, MTDeck mTDeck, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deckSelectedFromSwipe");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        swipeMenuViewCallback.deckSelectedFromSwipe(mTDeck, z);
    }

    void concedeTapped();

    void createDeckSelected();

    void createGuestDeckSelected();

    void deckSelectedFromSwipe(MTDeck deck, boolean endOfGame);

    void drawTapped();

    void editPlayerNameTapped();

    void energyToggled(boolean newValue);

    void experienceToggled(boolean newValue);

    void killTapped();

    void leftPicked();

    void partnersToggled(boolean newValue);

    void pickACardTapped();

    void pickAPhotoTapped();

    void plainColorTapped();

    void playmatSelected(String id);

    void poisonToggled(boolean newValue);

    void radiationToggled(boolean newValue);

    void rightPicked();

    void stormToggled(boolean newValue);

    void swipeClose(Direction direction);

    void taxToggled(boolean newValue);

    void winTapped();
}
