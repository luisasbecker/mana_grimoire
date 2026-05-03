package com.studiolaganne.lengendarylens;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: MoveCardDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J9\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/MoveCardDialogListener;", "", "onCancelMoveCard", "", "onMoveCard", "destinationContainerId", "", FirebaseAnalytics.Param.QUANTITY, "isNewContainer", "", "newContainerName", "", "newContainerType", "(IIZLjava/lang/String;Ljava/lang/Integer;)V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MoveCardDialogListener {
    void onCancelMoveCard();

    void onMoveCard(int destinationContainerId, int quantity, boolean isNewContainer, String newContainerName, Integer newContainerType);
}
