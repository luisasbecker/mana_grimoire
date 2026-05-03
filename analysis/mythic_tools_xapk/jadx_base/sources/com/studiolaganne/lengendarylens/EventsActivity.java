package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.studiolaganne.lengendarylens.databinding.ActivityEventsBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventsActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "<init>", "()V", "binding", "Lcom/studiolaganne/lengendarylens/databinding/ActivityEventsBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EventsActivity extends BaseActivity {
    public static final int $stable = 8;
    private ActivityEventsBinding binding;

    static final Unit onCreate$lambda$0(EventsActivity eventsActivity) {
        eventsActivity.finish();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$1(EventsActivity eventsActivity) {
        eventsActivity.finish();
        return Unit.INSTANCE;
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityEventsBinding activityEventsBindingInflate = ActivityEventsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityEventsBindingInflate, "inflate(...)");
        this.binding = activityEventsBindingInflate;
        ActivityEventsBinding activityEventsBinding = null;
        if (activityEventsBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEventsBindingInflate = null;
        }
        setContentView(activityEventsBindingInflate.getRoot());
        ActivityEventsBinding activityEventsBinding2 = this.binding;
        if (activityEventsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEventsBinding2 = null;
        }
        ImageView backButton = activityEventsBinding2.backButton;
        Intrinsics.checkNotNullExpressionValue(backButton, "backButton");
        ViewExtensionsKt.setOnClickWithFade(backButton, new Function0() { // from class: com.studiolaganne.lengendarylens.EventsActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventsActivity.onCreate$lambda$0(this.f$0);
            }
        });
        ActivityEventsBinding activityEventsBinding3 = this.binding;
        if (activityEventsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityEventsBinding = activityEventsBinding3;
        }
        TextView backLabel = activityEventsBinding.backLabel;
        Intrinsics.checkNotNullExpressionValue(backLabel, "backLabel");
        ViewExtensionsKt.setOnClickWithFade(backLabel, new Function0() { // from class: com.studiolaganne.lengendarylens.EventsActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventsActivity.onCreate$lambda$1(this.f$0);
            }
        });
    }
}
