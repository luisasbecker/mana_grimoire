package com.studiolaganne.lengendarylens;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HomeFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$updateUserProfile$2$1$1", f = "HomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class HomeFragment$updateUserProfile$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $userId;
    final /* synthetic */ MTUserResponse $userResponse;
    int label;
    final /* synthetic */ HomeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeFragment$updateUserProfile$2$1$1(HomeFragment homeFragment, MTUserResponse mTUserResponse, int i, Continuation<? super HomeFragment$updateUserProfile$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = homeFragment;
        this.$userResponse = mTUserResponse;
        this.$userId = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeFragment$updateUserProfile$2$1$1(this.this$0, this.$userResponse, this.$userId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeFragment$updateUserProfile$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object next;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Context contextRequireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser user = this.$userResponse.getUser();
        if (user != null) {
            HomeFragment homeFragment = this.this$0;
            preferencesManager.saveCurrentUser(user);
            homeFragment.updateProfile(user);
        }
        MTUserState state = this.$userResponse.getState();
        if (state != null) {
            this.this$0.checkState(state);
        }
        MTFavorites favorites = this.$userResponse.getFavorites();
        if (favorites != null) {
            preferencesManager.saveCurrentUserFavorites(favorites);
        }
        MTUserTags tags = this.$userResponse.getTags();
        if (tags != null) {
            preferencesManager.saveCurrentUserTags(tags);
        }
        List<MTTrophy> trophies = this.$userResponse.getTrophies();
        if (trophies != null) {
            preferencesManager.saveCurrentUserTrophies(trophies);
        }
        MTUserPrivacy privacy = this.$userResponse.getPrivacy();
        if (privacy != null) {
            preferencesManager.saveCurrentUserPrivacy(privacy);
        }
        MTCollection collection = this.$userResponse.getCollection();
        if (collection != null) {
            preferencesManager.saveCurrentUserCollection(collection);
        }
        MTUserLists lists = this.$userResponse.getLists();
        if (lists != null) {
            HomeFragment homeFragment2 = this.this$0;
            preferencesManager.saveCurrentUserLists(lists);
            List<MTCardContainer> global = lists.getGlobal();
            if (global != null) {
                Iterator<T> it = global.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(((MTCardContainer) next).getName(), PreferencesManager.RECENT_CARDS_LIST_NAME)) {
                        break;
                    }
                }
                MTCardContainer mTCardContainer = (MTCardContainer) next;
                if (mTCardContainer != null) {
                    homeFragment2.processRecentCards(mTCardContainer);
                }
            }
        }
        MTCommunityEvent event = this.$userResponse.getEvent();
        if (event != null) {
            this.this$0.showEventBanner(event);
        }
        MTOnboarding onboarding = this.$userResponse.getOnboarding();
        if (onboarding == null) {
            return null;
        }
        HomeFragment homeFragment3 = this.this$0;
        int i = this.$userId;
        if (!preferencesManager.wasOnboardingSeen(onboarding.getId())) {
            homeFragment3.showOnboardingDialog(onboarding);
            homeFragment3.markOnboardingSeen(i, onboarding.getId());
        }
        return Unit.INSTANCE;
    }
}
