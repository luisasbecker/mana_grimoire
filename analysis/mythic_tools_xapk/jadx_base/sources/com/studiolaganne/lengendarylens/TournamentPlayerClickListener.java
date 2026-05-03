package com.studiolaganne.lengendarylens;

import kotlin.Metadata;

/* JADX INFO: compiled from: TournamentPlayersAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/TournamentPlayerClickListener;", "", "onAddPlayerClick", "", "onPlayerRemoved", "id", "", "name", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface TournamentPlayerClickListener {
    void onAddPlayerClick();

    void onPlayerRemoved(String id, String name);
}
