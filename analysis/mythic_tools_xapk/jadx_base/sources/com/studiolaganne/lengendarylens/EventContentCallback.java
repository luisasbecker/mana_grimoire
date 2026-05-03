package com.studiolaganne.lengendarylens;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: EventContentFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventContentCallback;", "", "moveToDeckBuilding", "", "moveToRoundOne", "load", "", "submitStandings", "createFinals", ViewHierarchyConstants.DIMENSION_TOP_KEY, "", "matchType", "Lcom/studiolaganne/lengendarylens/MatchType;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface EventContentCallback {

    /* JADX INFO: compiled from: EventContentFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void moveToRoundOne$default(EventContentCallback eventContentCallback, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveToRoundOne");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        eventContentCallback.moveToRoundOne(z);
    }

    void createFinals(int top, MatchType matchType);

    void moveToDeckBuilding();

    void moveToRoundOne(boolean load);

    void submitStandings();
}
