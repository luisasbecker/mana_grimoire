package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.Gson;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.revenuecat.purchases.common.Constants;
import com.studiolaganne.lengendarylens.MessagesDBHelper;
import com.studiolaganne.lengendarylens.ProfileBottomSheetFragment;
import com.studiolaganne.lengendarylens.SendCardDialogFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentPlaygroupMessagesBinding;
import com.vanniktech.emoji.EmojiPopup;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: PlaygroupMessagesFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010*\u001a\u00020\u001eH\u0016J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u000f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u000e\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020\u001eJ\b\u00102\u001a\u00020\u001eH\u0002J\u0010\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\rH\u0016J\u0010\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020%H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupMessagesFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/MessagesClickListener;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentPlaygroupMessagesBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentPlaygroupMessagesBinding;", "currentPlaygroup", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "currentUser", "Lcom/studiolaganne/lengendarylens/MTUser;", "currentMessages", "", "Lcom/studiolaganne/lengendarylens/MTMessage;", "messagesDBHelper", "Lcom/studiolaganne/lengendarylens/MessagesDBHelper;", "lastMessagesUpdateTime", "Ljava/time/ZonedDateTime;", "parentActivity", "Lcom/studiolaganne/lengendarylens/PlaygroupDetailsActivity;", "currentProfileSheet", "Lcom/studiolaganne/lengendarylens/ProfileBottomSheetFragment;", "pickCardLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "groupMessagesWithSeparators", "Lcom/studiolaganne/lengendarylens/MessageItemHolder;", "messages", "updateUI", "scrollToBottom", "", "updateUIFromRemote", "loadOlderMessages", "onProfileClick", "user", "showNormalKeyboard", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupMessagesFragment extends Fragment implements MessagesClickListener {
    private FragmentPlaygroupMessagesBinding _binding;
    private List<MTMessage> currentMessages = CollectionsKt.emptyList();
    private MTPlaygroup currentPlaygroup;
    private ProfileBottomSheetFragment currentProfileSheet;
    private MTUser currentUser;
    private ZonedDateTime lastMessagesUpdateTime;
    private MessagesDBHelper messagesDBHelper;
    private PlaygroupDetailsActivity parentActivity;
    private final ActivityResultLauncher<Intent> pickCardLauncher;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: PlaygroupMessagesFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupMessagesFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/PlaygroupMessagesFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PlaygroupMessagesFragment newInstance() {
            PlaygroupMessagesFragment playgroupMessagesFragment = new PlaygroupMessagesFragment();
            playgroupMessagesFragment.setArguments(new Bundle());
            return playgroupMessagesFragment;
        }
    }

    public PlaygroupMessagesFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PlaygroupMessagesFragment.pickCardLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.pickCardLauncher = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MessageItemHolder> groupMessagesWithSeparators(List<MTMessage> messages) {
        if (getContext() == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        String str = null;
        for (MTMessage mTMessage : messages) {
            ServerUtils companion = ServerUtils.INSTANCE.getInstance();
            String timestamp = mTMessage.getTimestamp();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            String relativeTimestamp = companion.formatRelativeTimestamp(timestamp, contextRequireContext);
            if (!Intrinsics.areEqual(relativeTimestamp, str)) {
                arrayList.add(new MessageItemHolder(2, null, relativeTimestamp, 2, null));
                str = relativeTimestamp;
            }
            arrayList.add(new MessageItemHolder(1, mTMessage, null, 4, null));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadOlderMessages() {
        final MTMessage mTMessage;
        final MessagesDBHelper messagesDBHelper;
        MTMessage message;
        if (getContext() == null || (mTMessage = (MTMessage) CollectionsKt.firstOrNull((List) this.currentMessages)) == null) {
            return;
        }
        String timestamp = mTMessage.getTimestamp();
        final MTPlaygroup mTPlaygroup = this.currentPlaygroup;
        if (mTPlaygroup == null || (messagesDBHelper = this.messagesDBHelper) == null) {
            return;
        }
        List<MTMessage> last100MessagesForPlaygroupBeforeTimestamp = messagesDBHelper.getLast100MessagesForPlaygroupBeforeTimestamp(mTPlaygroup.getId(), timestamp);
        if (last100MessagesForPlaygroupBeforeTimestamp.isEmpty()) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            final MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
            if (currentUser != null) {
                MTApiKt.getMtApi().getMessagesFromPlaygroupBeforeTimestamp(currentUser.getId(), mTPlaygroup.getId(), timestamp).enqueue(new Callback<MTMessagesResponse>() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment$loadOlderMessages$1$1$1$2$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTMessagesResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        this.this$0.getBinding().swipeRefreshLayout.setRefreshing(false);
                        this.this$0.getBinding().swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(this.this$0.requireContext(), "Failed to get messages: " + t.getLocalizedMessage(), 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTMessagesResponse> call, Response<MTMessagesResponse> response) throws IOException {
                        MTMessage message2;
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        int i = 0;
                        this.this$0.getBinding().swipeRefreshLayout.setRefreshing(false);
                        ResponseBody responseBodyErrorBody = response.errorBody();
                        if (responseBodyErrorBody != null) {
                            responseBodyErrorBody.string();
                        }
                        if (response.isSuccessful()) {
                            MTMessagesResponse mTMessagesResponseBody = response.body();
                            List<MTMessage> messages = mTMessagesResponseBody != null ? mTMessagesResponseBody.getMessages() : null;
                            if (messages != null) {
                                MessagesDBHelper messagesDBHelper2 = messagesDBHelper;
                                MTPlaygroup mTPlaygroup2 = mTPlaygroup;
                                PlaygroupMessagesFragment playgroupMessagesFragment = this.this$0;
                                MTUser mTUser = currentUser;
                                MTMessage mTMessage2 = mTMessage;
                                messagesDBHelper2.addMessagesForPlaygroup(mTPlaygroup2.getId(), messages);
                                playgroupMessagesFragment.currentMessages = CollectionsKt.plus((Collection) messages, (Iterable) playgroupMessagesFragment.currentMessages);
                                playgroupMessagesFragment.currentMessages = CollectionsKt.sortedWith(playgroupMessagesFragment.currentMessages, new Comparator() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment$loadOlderMessages$1$1$1$2$1$onResponse$lambda$0$$inlined$sortedBy$1
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.util.Comparator
                                    public final int compare(T t, T t2) {
                                        return ComparisonsKt.compareValues(((MTMessage) t).getTimestamp(), ((MTMessage) t2).getTimestamp());
                                    }
                                });
                                List listGroupMessagesWithSeparators = playgroupMessagesFragment.groupMessagesWithSeparators(playgroupMessagesFragment.currentMessages);
                                MessagesAdapter messagesAdapter = new MessagesAdapter(listGroupMessagesWithSeparators, mTUser, playgroupMessagesFragment);
                                RecyclerView messagesRecyclerView = playgroupMessagesFragment.getBinding().messagesRecyclerView;
                                Intrinsics.checkNotNullExpressionValue(messagesRecyclerView, "messagesRecyclerView");
                                messagesRecyclerView.setLayoutManager(new LinearLayoutManager(playgroupMessagesFragment.requireContext()));
                                messagesRecyclerView.setAdapter(messagesAdapter);
                                Iterator it = listGroupMessagesWithSeparators.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        i = -1;
                                        break;
                                    }
                                    MessageItemHolder messageItemHolder = (MessageItemHolder) it.next();
                                    if (messageItemHolder.getType() == 1 && (message2 = messageItemHolder.getMessage()) != null && message2.getId() == mTMessage2.getId()) {
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                                if (i >= 0) {
                                    messagesRecyclerView.scrollToPosition(i);
                                }
                            }
                        }
                    }
                });
                return;
            } else {
                getBinding().swipeRefreshLayout.setRefreshing(false);
                return;
            }
        }
        List<MTMessage> listPlus = CollectionsKt.plus((Collection) last100MessagesForPlaygroupBeforeTimestamp, (Iterable) this.currentMessages);
        this.currentMessages = listPlus;
        List<MTMessage> listSortedWith = CollectionsKt.sortedWith(listPlus, new Comparator() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment$loadOlderMessages$lambda$0$0$0$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((MTMessage) t).getTimestamp(), ((MTMessage) t2).getTimestamp());
            }
        });
        this.currentMessages = listSortedWith;
        List<MessageItemHolder> listGroupMessagesWithSeparators = groupMessagesWithSeparators(listSortedWith);
        MTUser mTUser = this.currentUser;
        if (mTUser == null) {
            mTUser = new MTUser(false, 0, null, null, null, null, null, null, null, null, 1023, null);
        }
        MessagesAdapter messagesAdapter = new MessagesAdapter(listGroupMessagesWithSeparators, mTUser, this);
        RecyclerView messagesRecyclerView = getBinding().messagesRecyclerView;
        Intrinsics.checkNotNullExpressionValue(messagesRecyclerView, "messagesRecyclerView");
        messagesRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        messagesRecyclerView.setAdapter(messagesAdapter);
        Iterator<MessageItemHolder> it = listGroupMessagesWithSeparators.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            MessageItemHolder next = it.next();
            if (next.getType() == 1 && (message = next.getMessage()) != null && message.getId() == mTMessage.getId()) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            messagesRecyclerView.scrollToPosition(i);
        }
        getBinding().swipeRefreshLayout.setRefreshing(false);
    }

    @JvmStatic
    public static final PlaygroupMessagesFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final Unit onCreateView$lambda$1(PlaygroupMessagesFragment playgroupMessagesFragment) {
        playgroupMessagesFragment.pickCardLauncher.launch(new Intent(playgroupMessagesFragment.requireContext(), (Class<?>) PickACardActivity.class));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$0(EmojiPopup emojiPopup) {
        if (emojiPopup.isShowing()) {
            emojiPopup.dismiss();
        } else {
            emojiPopup.toggle();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$1(EmojiPopup emojiPopup, PlaygroupMessagesFragment playgroupMessagesFragment, View view) {
        if (emojiPopup.isShowing()) {
            emojiPopup.dismiss();
            EditText messageInput = playgroupMessagesFragment.getBinding().messageInput;
            Intrinsics.checkNotNullExpressionValue(messageInput, "messageInput");
            playgroupMessagesFragment.showNormalKeyboard(messageInput);
        }
    }

    static final Unit onCreateView$lambda$3(PlaygroupMessagesFragment playgroupMessagesFragment) {
        if (playgroupMessagesFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        MTPlaygroup mTPlaygroup = playgroupMessagesFragment.currentPlaygroup;
        if (mTPlaygroup != null) {
            String string = StringsKt.trim((CharSequence) playgroupMessagesFragment.getBinding().messageInput.getText().toString()).toString();
            if (string.length() > 0) {
                Context contextRequireContext = playgroupMessagesFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
                if (preferencesManager.hasValidUser()) {
                    playgroupMessagesFragment.getBinding().sendButtonLayout.setEnabled(false);
                    playgroupMessagesFragment.getBinding().sendButtonLayout.setBackground(ContextCompat.getDrawable(playgroupMessagesFragment.requireContext(), R.drawable.add_friend_background_disabled));
                    playgroupMessagesFragment.getBinding().sendHintLayout.setVisibility(0);
                    MTUser currentUser = preferencesManager.getCurrentUser();
                    MTApiKt.getMtApi().postMessageToPlaygroup(currentUser != null ? currentUser.getId() : -1, mTPlaygroup.getId(), new MTMessageBody(string)).enqueue(new PlaygroupMessagesFragment$onCreateView$4$1$1(playgroupMessagesFragment, preferencesManager));
                }
            }
        }
        return Unit.INSTANCE;
    }

    static final void pickCardLauncher$lambda$0(final PlaygroupMessagesFragment playgroupMessagesFragment, ActivityResult result) {
        MTFullCard mTFullCard;
        Intrinsics.checkNotNullParameter(result, "result");
        if (playgroupMessagesFragment.isDetached() || playgroupMessagesFragment.getContext() == null || result.getData() == null) {
            return;
        }
        Intent data = result.getData();
        String stringExtra = data != null ? data.getStringExtra("cardPicked") : null;
        Intent data2 = result.getData();
        final int intExtra = data2 != null ? data2.getIntExtra(OptionalModuleUtils.FACE, 0) : 0;
        if (stringExtra == null || (mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class)) == null) {
            return;
        }
        final String scryfallid = mTFullCard.getScryfallid();
        if (scryfallid == null) {
            scryfallid = "";
        }
        String imageUrl = mTFullCard.getImageUrl(intExtra);
        SendCardDialogFragment.Builder builder = new SendCardDialogFragment.Builder();
        String string = playgroupMessagesFragment.getString(R.string.send_card_image);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        builder.setTitle(string).setCardImageURL(imageUrl).setPositiveButtonRed().setPositiveButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaygroupMessagesFragment.pickCardLauncher$lambda$0$0$0$0(scryfallid, intExtra, playgroupMessagesFragment, (SendCardDialogFragment) obj);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaygroupMessagesFragment.pickCardLauncher$lambda$0$0$0$1((SendCardDialogFragment) obj);
            }
        }).build().show(playgroupMessagesFragment.getChildFragmentManager(), "send_card_dialog");
        Unit unit = Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pickCardLauncher$lambda$0$0$0$0(String str, int i, PlaygroupMessagesFragment playgroupMessagesFragment, SendCardDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.dismiss();
        MTMessageBody mTMessageBody = new MTMessageBody("[[card:" + str + "]]");
        if (i != 0) {
            mTMessageBody = new MTMessageBody("[[card:" + str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + i + "]]");
        }
        Context contextRequireContext = playgroupMessagesFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (preferencesManager.hasValidUser()) {
            playgroupMessagesFragment.getBinding().sendButtonLayout.setEnabled(false);
            playgroupMessagesFragment.getBinding().sendButtonLayout.setBackground(ContextCompat.getDrawable(playgroupMessagesFragment.requireContext(), R.drawable.add_friend_background_disabled));
            playgroupMessagesFragment.getBinding().sendHintLayout.setVisibility(0);
            MTUser currentUser = preferencesManager.getCurrentUser();
            int id = currentUser != null ? currentUser.getId() : -1;
            MTPlaygroup mTPlaygroup = playgroupMessagesFragment.currentPlaygroup;
            MTApiKt.getMtApi().postMessageToPlaygroup(id, mTPlaygroup != null ? mTPlaygroup.getId() : -1, mTMessageBody).enqueue(new PlaygroupMessagesFragment$pickCardLauncher$1$1$1$dialog$1$1(playgroupMessagesFragment, preferencesManager));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pickCardLauncher$lambda$0$0$0$1(SendCardDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.dismiss();
        return Unit.INSTANCE;
    }

    private final void showNormalKeyboard(View view) {
        if (getContext() == null) {
            return;
        }
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(view, 1);
    }

    public final FragmentPlaygroupMessagesBinding getBinding() {
        FragmentPlaygroupMessagesBinding fragmentPlaygroupMessagesBinding = this._binding;
        Intrinsics.checkNotNull(fragmentPlaygroupMessagesBinding);
        return fragmentPlaygroupMessagesBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.PlaygroupDetailsActivity");
            this.parentActivity = (PlaygroupDetailsActivity) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Object next;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt("playgroupId");
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            MTUser currentUser = preferencesManager.getCurrentUser();
            if (currentUser != null) {
                List<MTPlaygroup> currentUserPlaygroups = preferencesManager.getCurrentUserPlaygroups();
                this.currentUser = currentUser;
                Iterator<T> it = currentUserPlaygroups.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (((MTPlaygroup) next).getId() == i) {
                            break;
                        }
                    }
                }
                this.currentPlaygroup = (MTPlaygroup) next;
            }
            MessagesDBHelper.Companion companion = MessagesDBHelper.INSTANCE;
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            this.messagesDBHelper = companion.getInstance(contextRequireContext2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentPlaygroupMessagesBinding.inflate(inflater, container, false);
        updateUI(true);
        SwipeRefreshLayout swipeRefreshLayout = getBinding().swipeRefreshLayout;
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment$$ExternalSyntheticLambda3
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                this.f$0.loadOlderMessages();
            }
        });
        ImageFilterView cardsIcon = getBinding().cardsIcon;
        Intrinsics.checkNotNullExpressionValue(cardsIcon, "cardsIcon");
        ViewExtensionsKt.setOnClickWithFade(cardsIcon, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupMessagesFragment.onCreateView$lambda$1(this.f$0);
            }
        });
        ImageFilterView emojiIcon = getBinding().emojiIcon;
        Intrinsics.checkNotNullExpressionValue(emojiIcon, "emojiIcon");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            View viewFindViewById = activity.findViewById(android.R.id.content);
            Intrinsics.checkNotNull(viewFindViewById);
            EditText messageInput = getBinding().messageInput;
            Intrinsics.checkNotNullExpressionValue(messageInput, "messageInput");
            final EmojiPopup emojiPopup = new EmojiPopup(viewFindViewById, messageInput, null, null, null, null, null, 0, 0, null, null, null, null, null, null, 32764, null);
            ViewExtensionsKt.setOnClickWithFade(emojiIcon, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlaygroupMessagesFragment.onCreateView$lambda$2$0(emojiPopup);
                }
            });
            getBinding().messageInput.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlaygroupMessagesFragment.onCreateView$lambda$2$1(emojiPopup, this, view);
                }
            });
        }
        ConstraintLayout sendButtonLayout = getBinding().sendButtonLayout;
        Intrinsics.checkNotNullExpressionValue(sendButtonLayout, "sendButtonLayout");
        ViewExtensionsKt.setOnClickWithFade(sendButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupMessagesFragment.onCreateView$lambda$3(this.f$0);
            }
        });
        return getBinding().getRoot();
    }

    @Override // com.studiolaganne.lengendarylens.MessagesClickListener
    public void onProfileClick(MTUser user) {
        Intrinsics.checkNotNullParameter(user, "user");
        ProfileBottomSheetFragment profileBottomSheetFragmentNewInstance$default = ProfileBottomSheetFragment.Companion.newInstance$default(ProfileBottomSheetFragment.INSTANCE, new ProfileCallback() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment$onProfileClick$bottomSheet$1
            @Override // com.studiolaganne.lengendarylens.ProfileCallback
            public void onProfileClose() {
                ProfileBottomSheetFragment profileBottomSheetFragment = this.this$0.currentProfileSheet;
                if (profileBottomSheetFragment != null) {
                    profileBottomSheetFragment.dismiss();
                }
                this.this$0.currentProfileSheet = null;
            }

            @Override // com.studiolaganne.lengendarylens.ProfileCallback
            public void onProfileLogout() {
            }

            @Override // com.studiolaganne.lengendarylens.ProfileCallback
            public void onProfilePictureUpdated() {
            }
        }, user, true, null, 8, null);
        this.currentProfileSheet = profileBottomSheetFragmentNewInstance$default;
        profileBottomSheetFragmentNewInstance$default.show(getChildFragmentManager(), ProfileBottomSheetFragment.TAG);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        boolean z = false;
        if (preferencesManager.getBoolean(PreferencesManager.UPDATE_MESSAGES, false)) {
            preferencesManager.setBoolean(PreferencesManager.UPDATE_MESSAGES, false);
            z = true;
        }
        ZonedDateTime zonedDateTime = this.lastMessagesUpdateTime;
        if (zonedDateTime != null) {
            z = ChronoUnit.MINUTES.between(zonedDateTime, ZonedDateTime.now()) <= 5 ? z : true;
        }
        if (z) {
            updateUIFromRemote();
        }
    }

    public final void updateUI(boolean scrollToBottom) {
        MessagesDBHelper messagesDBHelper;
        MTPlaygroup mTPlaygroup = this.currentPlaygroup;
        if (mTPlaygroup == null || (messagesDBHelper = this.messagesDBHelper) == null) {
            return;
        }
        for (MTMessage mTMessage : messagesDBHelper.getLast100MessagesForPlaygroup(mTPlaygroup.getId())) {
            List<MTMessage> list = this.currentMessages;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((MTMessage) it.next()).getId() == mTMessage.getId()) {
                        break;
                    }
                }
            }
            this.currentMessages = CollectionsKt.plus((Collection<? extends MTMessage>) this.currentMessages, mTMessage);
        }
        List<MTMessage> listSortedWith = CollectionsKt.sortedWith(this.currentMessages, new Comparator() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment$updateUI$lambda$0$0$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((MTMessage) t).getTimestamp(), ((MTMessage) t2).getTimestamp());
            }
        });
        this.currentMessages = listSortedWith;
        MTMessage mTMessage2 = (MTMessage) CollectionsKt.lastOrNull((List) listSortedWith);
        if (mTMessage2 != null) {
            messagesDBHelper.setLastReadTimestampForPlaygroup(mTPlaygroup.getId(), mTMessage2.getTimestamp());
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
            if (currentUser != null) {
                MTApiKt.getMtApi().setLastReadMessageIdForPlaygroup(currentUser.getId(), mTPlaygroup.getId(), mTMessage2.getId()).enqueue(new Callback<MTIdResponse>() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment$updateUI$1$1$3$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTIdResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTIdResponse> call, Response<MTIdResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                    }
                });
            }
        }
        List<MessageItemHolder> listGroupMessagesWithSeparators = groupMessagesWithSeparators(this.currentMessages);
        MTUser mTUser = this.currentUser;
        if (mTUser == null) {
            mTUser = new MTUser(false, 0, null, null, null, null, null, null, null, null, 1023, null);
        }
        MessagesAdapter messagesAdapter = new MessagesAdapter(listGroupMessagesWithSeparators, mTUser, this);
        RecyclerView messagesRecyclerView = getBinding().messagesRecyclerView;
        Intrinsics.checkNotNullExpressionValue(messagesRecyclerView, "messagesRecyclerView");
        messagesRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        messagesRecyclerView.setAdapter(messagesAdapter);
        if (scrollToBottom) {
            messagesRecyclerView.scrollToPosition(messagesAdapter.getItemCount() - 1);
        }
    }

    public final void updateUIFromRemote() {
        if (getContext() == null) {
            return;
        }
        MessagesManager companion = MessagesManager.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        companion.updateAllMessages(contextRequireContext, new MessagesManagerListener() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment.updateUIFromRemote.1
            @Override // com.studiolaganne.lengendarylens.MessagesManagerListener
            public void onMessagesUpdated(int playgroupId) {
                if (PlaygroupMessagesFragment.this.getContext() == null || PlaygroupMessagesFragment.this._binding == null) {
                    return;
                }
                PlaygroupMessagesFragment.this.lastMessagesUpdateTime = ZonedDateTime.now();
                PlaygroupMessagesFragment.this.updateUI(true);
            }
        });
    }
}
