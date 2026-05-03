package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SwipeCountersAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/studiolaganne/lengendarylens/SwipeCountersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "poison", "", "currentPlayer", "Lcom/studiolaganne/lengendarylens/Player;", Key.ROTATION, "", "clickListener", "Lcom/studiolaganne/lengendarylens/SwipeCountersClickListener;", "<init>", "(Landroid/content/Context;ZLcom/studiolaganne/lengendarylens/Player;ILcom/studiolaganne/lengendarylens/SwipeCountersClickListener;)V", "counters", "", "Lcom/studiolaganne/lengendarylens/CounterDefinition;", "dpToPx", "dp", "setPoison", "", "enabled", "setEnergy", "setStorm", "setExperience", "setTax", "setRadiation", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SwipeCountersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_BACK = 1;
    private static final int VIEW_TYPE_COUNTER = 2;
    private final SwipeCountersClickListener clickListener;
    private final Context context;
    private final List<CounterDefinition> counters;
    private final Player currentPlayer;
    private boolean poison;
    private int rotation;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: SwipeCountersAdapter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CounterType.values().length];
            try {
                iArr[CounterType.Poison.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CounterType.Energy.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CounterType.Storm.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CounterType.Tax.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CounterType.Experience.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CounterType.Radiation.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SwipeCountersAdapter(Context context, boolean z, Player currentPlayer, int i, SwipeCountersClickListener clickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(currentPlayer, "currentPlayer");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.context = context;
        this.poison = z;
        this.currentPlayer = currentPlayer;
        this.rotation = i;
        this.clickListener = clickListener;
        this.counters = GameUtils.INSTANCE.getInstance().getCounters(context);
    }

    private final int dpToPx(Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    static final Unit onBindViewHolder$lambda$0(SwipeCountersBackViewHolder swipeCountersBackViewHolder) {
        swipeCountersBackViewHolder.getClickListener().onCountersBackTapped();
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$1(SwipeCounterViewHolder swipeCounterViewHolder, CounterDefinition counterDefinition) {
        swipeCounterViewHolder.getClickListener().onCounterToggled(counterDefinition.getType());
        return Unit.INSTANCE;
    }

    static final void onBindViewHolder$lambda$2(SwipeCountersAdapter swipeCountersAdapter, View view) {
        int i = swipeCountersAdapter.rotation;
        if (i == 90 || i == 270) {
            int width = view.getWidth();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = width;
            view.setLayoutParams(layoutParams);
            return;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        layoutParams2.width = height;
        view.setLayoutParams(layoutParams2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.counters.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position == 0 ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position == 0) {
            final SwipeCountersBackViewHolder swipeCountersBackViewHolder = (SwipeCountersBackViewHolder) holder;
            ViewExtensionsKt.setOnClickWithFade(swipeCountersBackViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SwipeCountersAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SwipeCountersAdapter.onBindViewHolder$lambda$0(swipeCountersBackViewHolder);
                }
            });
            return;
        }
        final SwipeCounterViewHolder swipeCounterViewHolder = (SwipeCounterViewHolder) holder;
        final CounterDefinition counterDefinition = this.counters.get(position - 1);
        swipeCounterViewHolder.getCounterName().setText(counterDefinition.getName());
        ViewExtensionsKt.setOnClickWithFade(swipeCounterViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SwipeCountersAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SwipeCountersAdapter.onBindViewHolder$lambda$1(swipeCounterViewHolder, counterDefinition);
            }
        });
        switch (WhenMappings.$EnumSwitchMapping$0[counterDefinition.getType().ordinal()]) {
            case 1:
                if (!this.poison) {
                    swipeCounterViewHolder.getIconImage().setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.poison_white));
                } else {
                    swipeCounterViewHolder.getIconImage().setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.poison_on));
                }
                break;
            case 2:
                if (!this.currentPlayer.getEnergyEnabled()) {
                    swipeCounterViewHolder.getIconImage().setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.energy_off));
                } else {
                    swipeCounterViewHolder.getIconImage().setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.energy_on));
                }
                break;
            case 3:
                if (!this.currentPlayer.getStormEnabled()) {
                    swipeCounterViewHolder.getIconImage().setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.storm_off));
                } else {
                    swipeCounterViewHolder.getIconImage().setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.storm_on));
                }
                break;
            case 4:
                if (!this.currentPlayer.getTaxEnabled()) {
                    swipeCounterViewHolder.getIconImage().setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.tax_off));
                } else {
                    swipeCounterViewHolder.getIconImage().setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.tax_on));
                }
                break;
            case 5:
                if (!this.currentPlayer.getExperienceEnabled()) {
                    swipeCounterViewHolder.getIconImage().setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.experience_off));
                } else {
                    swipeCounterViewHolder.getIconImage().setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.experience_on));
                }
                break;
            case 6:
                if (!this.currentPlayer.getRadiationEnabled()) {
                    swipeCounterViewHolder.getIconImage().setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.radiation_off));
                } else {
                    swipeCounterViewHolder.getIconImage().setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.radiation_on));
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        final View itemView = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        itemView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.SwipeCountersAdapter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SwipeCountersAdapter.onBindViewHolder$lambda$2(this.f$0, itemView);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            if (viewType != 2) {
                throw new IllegalArgumentException("Invalid view type");
            }
            int i = this.rotation;
            View viewInflate = (i == 0 || (i != 90 && (i == 180 || i != 270))) ? LayoutInflater.from(parent.getContext()).inflate(R.layout.square_counter_item, parent, false) : LayoutInflater.from(parent.getContext()).inflate(R.layout.square_counter_item_rotated, parent, false);
            viewInflate.setRotation(this.rotation);
            Intrinsics.checkNotNull(viewInflate);
            return new SwipeCounterViewHolder(viewInflate, this.clickListener);
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.back_item, parent, false);
        viewInflate2.setRotation(this.rotation);
        int i2 = this.rotation;
        if (i2 == 0 || i2 == 180) {
            ViewGroup.LayoutParams layoutParams = viewInflate2.getLayoutParams();
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            layoutParams.height = dpToPx(context, 130);
            viewInflate2.setLayoutParams(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams2 = viewInflate2.getLayoutParams();
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            layoutParams2.width = dpToPx(context2, 130);
            viewInflate2.setLayoutParams(layoutParams2);
        }
        Intrinsics.checkNotNull(viewInflate2);
        return new SwipeCountersBackViewHolder(viewInflate2, this.clickListener);
    }

    public final void setEnergy(boolean enabled) {
        this.currentPlayer.setEnergyEnabled(enabled);
        notifyDataSetChanged();
    }

    public final void setExperience(boolean enabled) {
        this.currentPlayer.setExperienceEnabled(enabled);
        notifyDataSetChanged();
    }

    public final void setPoison(boolean enabled) {
        this.poison = enabled;
        notifyDataSetChanged();
    }

    public final void setRadiation(boolean enabled) {
        this.currentPlayer.setRadiationEnabled(enabled);
        notifyDataSetChanged();
    }

    public final void setStorm(boolean enabled) {
        this.currentPlayer.setStormEnabled(enabled);
        notifyDataSetChanged();
    }

    public final void setTax(boolean enabled) {
        this.currentPlayer.setTaxEnabled(enabled);
        notifyDataSetChanged();
    }
}
