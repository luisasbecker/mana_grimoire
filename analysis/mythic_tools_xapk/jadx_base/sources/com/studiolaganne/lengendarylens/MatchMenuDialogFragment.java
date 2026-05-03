package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.MatchMenuDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatchMenuDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010/\u001a\u00020\u0012H\u0016J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R&\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R&\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R&\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R&\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R&\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R&\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R&\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016¨\u00069"}, d2 = {"Lcom/studiolaganne/lengendarylens/MatchMenuDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", Key.ROTATION, "", "getRotation", "()I", "setRotation", "(I)V", "saveEnabled", "", "getSaveEnabled", "()Z", "setSaveEnabled", "(Z)V", "player1ConcedeButtonCallback", "Lkotlin/Function1;", "", "getPlayer1ConcedeButtonCallback", "()Lkotlin/jvm/functions/Function1;", "setPlayer1ConcedeButtonCallback", "(Lkotlin/jvm/functions/Function1;)V", "player1DrawButtonCallback", "getPlayer1DrawButtonCallback", "setPlayer1DrawButtonCallback", "player1WinButtonCallback", "getPlayer1WinButtonCallback", "setPlayer1WinButtonCallback", "player1LoseButtonCallback", "getPlayer1LoseButtonCallback", "setPlayer1LoseButtonCallback", "player2ConcedeButtonCallback", "getPlayer2ConcedeButtonCallback", "setPlayer2ConcedeButtonCallback", "player2DrawButtonCallback", "getPlayer2DrawButtonCallback", "setPlayer2DrawButtonCallback", "player2WinButtonCallback", "getPlayer2WinButtonCallback", "setPlayer2WinButtonCallback", "player2LoseButtonCallback", "getPlayer2LoseButtonCallback", "setPlayer2LoseButtonCallback", "endGameAndSaveButtonCallback", "getEndGameAndSaveButtonCallback", "setEndGameAndSaveButtonCallback", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MatchMenuDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    public Function1<? super MatchMenuDialogFragment, Unit> endGameAndSaveButtonCallback;
    public Function1<? super MatchMenuDialogFragment, Unit> player1ConcedeButtonCallback;
    public Function1<? super MatchMenuDialogFragment, Unit> player1DrawButtonCallback;
    public Function1<? super MatchMenuDialogFragment, Unit> player1LoseButtonCallback;
    public Function1<? super MatchMenuDialogFragment, Unit> player1WinButtonCallback;
    public Function1<? super MatchMenuDialogFragment, Unit> player2ConcedeButtonCallback;
    public Function1<? super MatchMenuDialogFragment, Unit> player2DrawButtonCallback;
    public Function1<? super MatchMenuDialogFragment, Unit> player2LoseButtonCallback;
    public Function1<? super MatchMenuDialogFragment, Unit> player2WinButtonCallback;
    private int rotation;
    private boolean saveEnabled = true;

    /* JADX INFO: compiled from: MatchMenuDialogFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0007J\u001a\u0010\u0017\u001a\u00020\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\u001a\u0010\u0019\u001a\u00020\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\u001a\u0010\u001a\u001a\u00020\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\u001a\u0010\u001b\u001a\u00020\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\u001a\u0010\u001c\u001a\u00020\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\u001a\u0010\u001d\u001a\u00020\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\u001a\u0010\u001e\u001a\u00020\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\u001a\u0010\u001f\u001a\u00020\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\u001a\u0010 \u001a\u00020\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\u0006\u0010!\u001a\u00020\nJ\u0016\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/studiolaganne/lengendarylens/MatchMenuDialogFragment$Builder;", "", "<init>", "()V", Key.ROTATION, "", "saveEnabled", "", "player1ConcedeButtonCallback", "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/MatchMenuDialogFragment;", "", "player1DrawButtonCallback", "player1WinButtonCallback", "player1LoseButtonCallback", "player2ConcedeButtonCallback", "player2DrawButtonCallback", "player2WinButtonCallback", "player2LoseButtonCallback", "endGameAndSaveButtonCallback", "setRotation", "setSaveEnabled", "enabled", "setPlayer1ConcedeButtonCallback", "callback", "setPlayer1DrawButtonCallback", "setPlayer1WinButtonCallback", "setPlayer1LoseButtonCallback", "setPlayer2ConcedeButtonCallback", "setPlayer2DrawButtonCallback", "setPlayer2WinButtonCallback", "setPlayer2LoseButtonCallback", "setEndGameButtonCallback", "build", "show", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private int rotation;
        private boolean saveEnabled = true;
        private Function1<? super MatchMenuDialogFragment, Unit> player1ConcedeButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MatchMenuDialogFragment.Builder.player1ConcedeButtonCallback$lambda$0((MatchMenuDialogFragment) obj);
            }
        };
        private Function1<? super MatchMenuDialogFragment, Unit> player1DrawButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$Builder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MatchMenuDialogFragment.Builder.player1DrawButtonCallback$lambda$0((MatchMenuDialogFragment) obj);
            }
        };
        private Function1<? super MatchMenuDialogFragment, Unit> player1WinButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$Builder$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MatchMenuDialogFragment.Builder.player1WinButtonCallback$lambda$0((MatchMenuDialogFragment) obj);
            }
        };
        private Function1<? super MatchMenuDialogFragment, Unit> player1LoseButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$Builder$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MatchMenuDialogFragment.Builder.player1LoseButtonCallback$lambda$0((MatchMenuDialogFragment) obj);
            }
        };
        private Function1<? super MatchMenuDialogFragment, Unit> player2ConcedeButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$Builder$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MatchMenuDialogFragment.Builder.player2ConcedeButtonCallback$lambda$0((MatchMenuDialogFragment) obj);
            }
        };
        private Function1<? super MatchMenuDialogFragment, Unit> player2DrawButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$Builder$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MatchMenuDialogFragment.Builder.player2DrawButtonCallback$lambda$0((MatchMenuDialogFragment) obj);
            }
        };
        private Function1<? super MatchMenuDialogFragment, Unit> player2WinButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$Builder$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MatchMenuDialogFragment.Builder.player2WinButtonCallback$lambda$0((MatchMenuDialogFragment) obj);
            }
        };
        private Function1<? super MatchMenuDialogFragment, Unit> player2LoseButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$Builder$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MatchMenuDialogFragment.Builder.player2LoseButtonCallback$lambda$0((MatchMenuDialogFragment) obj);
            }
        };
        private Function1<? super MatchMenuDialogFragment, Unit> endGameAndSaveButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$Builder$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MatchMenuDialogFragment.Builder.endGameAndSaveButtonCallback$lambda$0((MatchMenuDialogFragment) obj);
            }
        };

        static final Unit endGameAndSaveButtonCallback$lambda$0(MatchMenuDialogFragment matchMenuDialogFragment) {
            Intrinsics.checkNotNullParameter(matchMenuDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit player1ConcedeButtonCallback$lambda$0(MatchMenuDialogFragment matchMenuDialogFragment) {
            Intrinsics.checkNotNullParameter(matchMenuDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit player1DrawButtonCallback$lambda$0(MatchMenuDialogFragment matchMenuDialogFragment) {
            Intrinsics.checkNotNullParameter(matchMenuDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit player1LoseButtonCallback$lambda$0(MatchMenuDialogFragment matchMenuDialogFragment) {
            Intrinsics.checkNotNullParameter(matchMenuDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit player1WinButtonCallback$lambda$0(MatchMenuDialogFragment matchMenuDialogFragment) {
            Intrinsics.checkNotNullParameter(matchMenuDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit player2ConcedeButtonCallback$lambda$0(MatchMenuDialogFragment matchMenuDialogFragment) {
            Intrinsics.checkNotNullParameter(matchMenuDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit player2DrawButtonCallback$lambda$0(MatchMenuDialogFragment matchMenuDialogFragment) {
            Intrinsics.checkNotNullParameter(matchMenuDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit player2LoseButtonCallback$lambda$0(MatchMenuDialogFragment matchMenuDialogFragment) {
            Intrinsics.checkNotNullParameter(matchMenuDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit player2WinButtonCallback$lambda$0(MatchMenuDialogFragment matchMenuDialogFragment) {
            Intrinsics.checkNotNullParameter(matchMenuDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        public final MatchMenuDialogFragment build() {
            MatchMenuDialogFragment matchMenuDialogFragment = new MatchMenuDialogFragment();
            matchMenuDialogFragment.setRotation(this.rotation);
            matchMenuDialogFragment.setSaveEnabled(this.saveEnabled);
            matchMenuDialogFragment.setPlayer1ConcedeButtonCallback(this.player1ConcedeButtonCallback);
            matchMenuDialogFragment.setPlayer1DrawButtonCallback(this.player1DrawButtonCallback);
            matchMenuDialogFragment.setPlayer1WinButtonCallback(this.player1WinButtonCallback);
            matchMenuDialogFragment.setPlayer1LoseButtonCallback(this.player1LoseButtonCallback);
            matchMenuDialogFragment.setPlayer2ConcedeButtonCallback(this.player2ConcedeButtonCallback);
            matchMenuDialogFragment.setPlayer2DrawButtonCallback(this.player2DrawButtonCallback);
            matchMenuDialogFragment.setPlayer2WinButtonCallback(this.player2WinButtonCallback);
            matchMenuDialogFragment.setPlayer2LoseButtonCallback(this.player2LoseButtonCallback);
            matchMenuDialogFragment.setEndGameAndSaveButtonCallback(this.endGameAndSaveButtonCallback);
            return matchMenuDialogFragment;
        }

        public final Builder setEndGameButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.endGameAndSaveButtonCallback = callback;
            return this;
        }

        public final Builder setPlayer1ConcedeButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.player1ConcedeButtonCallback = callback;
            return this;
        }

        public final Builder setPlayer1DrawButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.player1DrawButtonCallback = callback;
            return this;
        }

        public final Builder setPlayer1LoseButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.player1LoseButtonCallback = callback;
            return this;
        }

        public final Builder setPlayer1WinButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.player1WinButtonCallback = callback;
            return this;
        }

        public final Builder setPlayer2ConcedeButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.player2ConcedeButtonCallback = callback;
            return this;
        }

        public final Builder setPlayer2DrawButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.player2DrawButtonCallback = callback;
            return this;
        }

        public final Builder setPlayer2LoseButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.player2LoseButtonCallback = callback;
            return this;
        }

        public final Builder setPlayer2WinButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.player2WinButtonCallback = callback;
            return this;
        }

        public final Builder setRotation(int rotation) {
            this.rotation = rotation;
            return this;
        }

        public final Builder setSaveEnabled(boolean enabled) {
            this.saveEnabled = enabled;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    static final Unit onCreateView$lambda$0(MatchMenuDialogFragment matchMenuDialogFragment) {
        matchMenuDialogFragment.getPlayer1ConcedeButtonCallback().invoke(matchMenuDialogFragment);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$1(MatchMenuDialogFragment matchMenuDialogFragment) {
        matchMenuDialogFragment.getPlayer2ConcedeButtonCallback().invoke(matchMenuDialogFragment);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$2(MatchMenuDialogFragment matchMenuDialogFragment) {
        matchMenuDialogFragment.getPlayer1DrawButtonCallback().invoke(matchMenuDialogFragment);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$3(MatchMenuDialogFragment matchMenuDialogFragment) {
        matchMenuDialogFragment.getPlayer1WinButtonCallback().invoke(matchMenuDialogFragment);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$4(MatchMenuDialogFragment matchMenuDialogFragment) {
        matchMenuDialogFragment.getPlayer1LoseButtonCallback().invoke(matchMenuDialogFragment);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$5(MatchMenuDialogFragment matchMenuDialogFragment) {
        matchMenuDialogFragment.getPlayer2DrawButtonCallback().invoke(matchMenuDialogFragment);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$6(MatchMenuDialogFragment matchMenuDialogFragment) {
        matchMenuDialogFragment.getPlayer2WinButtonCallback().invoke(matchMenuDialogFragment);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$7(MatchMenuDialogFragment matchMenuDialogFragment) {
        matchMenuDialogFragment.getPlayer2LoseButtonCallback().invoke(matchMenuDialogFragment);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$8(MatchMenuDialogFragment matchMenuDialogFragment) {
        if (!matchMenuDialogFragment.saveEnabled) {
            return Unit.INSTANCE;
        }
        matchMenuDialogFragment.getEndGameAndSaveButtonCallback().invoke(matchMenuDialogFragment);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$9(MatchMenuDialogFragment matchMenuDialogFragment) {
        matchMenuDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    public final Function1<MatchMenuDialogFragment, Unit> getEndGameAndSaveButtonCallback() {
        Function1 function1 = this.endGameAndSaveButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("endGameAndSaveButtonCallback");
        return null;
    }

    public final Function1<MatchMenuDialogFragment, Unit> getPlayer1ConcedeButtonCallback() {
        Function1 function1 = this.player1ConcedeButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("player1ConcedeButtonCallback");
        return null;
    }

    public final Function1<MatchMenuDialogFragment, Unit> getPlayer1DrawButtonCallback() {
        Function1 function1 = this.player1DrawButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("player1DrawButtonCallback");
        return null;
    }

    public final Function1<MatchMenuDialogFragment, Unit> getPlayer1LoseButtonCallback() {
        Function1 function1 = this.player1LoseButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("player1LoseButtonCallback");
        return null;
    }

    public final Function1<MatchMenuDialogFragment, Unit> getPlayer1WinButtonCallback() {
        Function1 function1 = this.player1WinButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("player1WinButtonCallback");
        return null;
    }

    public final Function1<MatchMenuDialogFragment, Unit> getPlayer2ConcedeButtonCallback() {
        Function1 function1 = this.player2ConcedeButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("player2ConcedeButtonCallback");
        return null;
    }

    public final Function1<MatchMenuDialogFragment, Unit> getPlayer2DrawButtonCallback() {
        Function1 function1 = this.player2DrawButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("player2DrawButtonCallback");
        return null;
    }

    public final Function1<MatchMenuDialogFragment, Unit> getPlayer2LoseButtonCallback() {
        Function1 function1 = this.player2LoseButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("player2LoseButtonCallback");
        return null;
    }

    public final Function1<MatchMenuDialogFragment, Unit> getPlayer2WinButtonCallback() {
        Function1 function1 = this.player2WinButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("player2WinButtonCallback");
        return null;
    }

    public final int getRotation() {
        return this.rotation;
    }

    public final boolean getSaveEnabled() {
        return this.saveEnabled;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_match_menu, container, false);
        ((ConstraintLayout) viewInflate.findViewById(R.id.rootLayout)).setRotation(this.rotation);
        if (!this.saveEnabled) {
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.endGameButton);
            materialButton.setEnabled(false);
            materialButton.setBackgroundResource(R.drawable.custom_button_background_grey);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.concedeLayout);
        Intrinsics.checkNotNull(constraintLayout);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MatchMenuDialogFragment.onCreateView$lambda$0(this.f$0);
            }
        });
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewInflate.findViewById(R.id.concedeLayout_2);
        Intrinsics.checkNotNull(constraintLayout2);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MatchMenuDialogFragment.onCreateView$lambda$1(this.f$0);
            }
        });
        ConstraintLayout constraintLayout3 = (ConstraintLayout) viewInflate.findViewById(R.id.drawLayout);
        Intrinsics.checkNotNull(constraintLayout3);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout3, new Function0() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MatchMenuDialogFragment.onCreateView$lambda$2(this.f$0);
            }
        });
        ConstraintLayout constraintLayout4 = (ConstraintLayout) viewInflate.findViewById(R.id.winLayout);
        Intrinsics.checkNotNull(constraintLayout4);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout4, new Function0() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MatchMenuDialogFragment.onCreateView$lambda$3(this.f$0);
            }
        });
        ConstraintLayout constraintLayout5 = (ConstraintLayout) viewInflate.findViewById(R.id.loseLayout);
        Intrinsics.checkNotNull(constraintLayout5);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout5, new Function0() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MatchMenuDialogFragment.onCreateView$lambda$4(this.f$0);
            }
        });
        ConstraintLayout constraintLayout6 = (ConstraintLayout) viewInflate.findViewById(R.id.drawLayout_2);
        Intrinsics.checkNotNull(constraintLayout6);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout6, new Function0() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MatchMenuDialogFragment.onCreateView$lambda$5(this.f$0);
            }
        });
        ConstraintLayout constraintLayout7 = (ConstraintLayout) viewInflate.findViewById(R.id.winLayout_2);
        Intrinsics.checkNotNull(constraintLayout7);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout7, new Function0() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MatchMenuDialogFragment.onCreateView$lambda$6(this.f$0);
            }
        });
        ConstraintLayout constraintLayout8 = (ConstraintLayout) viewInflate.findViewById(R.id.loseLayout_2);
        Intrinsics.checkNotNull(constraintLayout8);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout8, new Function0() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MatchMenuDialogFragment.onCreateView$lambda$7(this.f$0);
            }
        });
        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.endGameButton);
        Intrinsics.checkNotNull(materialButton2);
        ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MatchMenuDialogFragment.onCreateView$lambda$8(this.f$0);
            }
        });
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.closeImage);
        Intrinsics.checkNotNull(imageView);
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.MatchMenuDialogFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MatchMenuDialogFragment.onCreateView$lambda$9(this.f$0);
            }
        });
        setCancelable(true);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setDimAmount(0.9f);
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.95d), -2);
    }

    public final void setEndGameAndSaveButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.endGameAndSaveButtonCallback = function1;
    }

    public final void setPlayer1ConcedeButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.player1ConcedeButtonCallback = function1;
    }

    public final void setPlayer1DrawButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.player1DrawButtonCallback = function1;
    }

    public final void setPlayer1LoseButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.player1LoseButtonCallback = function1;
    }

    public final void setPlayer1WinButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.player1WinButtonCallback = function1;
    }

    public final void setPlayer2ConcedeButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.player2ConcedeButtonCallback = function1;
    }

    public final void setPlayer2DrawButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.player2DrawButtonCallback = function1;
    }

    public final void setPlayer2LoseButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.player2LoseButtonCallback = function1;
    }

    public final void setPlayer2WinButtonCallback(Function1<? super MatchMenuDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.player2WinButtonCallback = function1;
    }

    public final void setRotation(int i) {
        this.rotation = i;
    }

    public final void setSaveEnabled(boolean z) {
        this.saveEnabled = z;
    }
}
