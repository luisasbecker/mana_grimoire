package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProgressBarPreference.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/ProgressBarPreference;", "Landroidx/preference/Preference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "progressBar", "Landroid/widget/ProgressBar;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "visible", "", "onBindViewHolder", "", "holder", "Landroidx/preference/PreferenceViewHolder;", "updateProgress", "progress", "", "setIsVisible", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ProgressBarPreference extends Preference {
    public static final int $stable = 8;
    private ProgressBar progressBar;
    private View view;
    private boolean visible;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.visible = true;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder holder) {
        View view;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        this.view = holder.itemView;
        this.progressBar = (ProgressBar) holder.itemView.findViewById(R.id.progress_bar);
        if (this.visible || (view = this.view) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void setIsVisible(boolean visible) {
        this.visible = visible;
        View view = this.view;
        if (view != null) {
            view.setVisibility(visible ? 0 : 8);
        }
    }

    public final void updateProgress(int progress) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setProgress(progress);
        }
    }
}
