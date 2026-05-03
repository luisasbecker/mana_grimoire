package com.studiolaganne.lengendarylens;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: AcceptPlaygroupBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/AcceptPlaygroupCallback;", "", "onPlaygroupAccepted", "", "playgroups", "", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "onPlaygroupDeclined", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AcceptPlaygroupCallback {
    void onPlaygroupAccepted(List<MTPlaygroup> playgroups);

    void onPlaygroupDeclined(List<MTPlaygroup> playgroups);
}
