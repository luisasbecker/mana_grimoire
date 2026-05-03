package com.studiolaganne.lengendarylens;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.revenuecat.purchases.common.Constants;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: MessagesAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MessagesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "messages", "", "Lcom/studiolaganne/lengendarylens/MessageItemHolder;", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "clickListener", "Lcom/studiolaganne/lengendarylens/MessagesClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTUser;Lcom/studiolaganne/lengendarylens/MessagesClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "parseAndSetLinks", "", "context", "Landroid/content/Context;", "textView", "Landroid/widget/TextView;", "messageContent", "", "onBindViewHolder", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_TYPE_MESSAGE = 1;
    public static final int VIEW_TYPE_SEPARATOR = 2;
    private final MessagesClickListener clickListener;
    private final List<MessageItemHolder> messages;
    private MTUser user;
    public static final int $stable = 8;

    public MessagesAdapter(List<MessageItemHolder> messages, MTUser user, MessagesClickListener clickListener) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.messages = messages;
        this.user = user;
        this.clickListener = clickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$0(final MessageViewHolder messageViewHolder, final Ref.IntRef intRef, MessagesAdapter messagesAdapter, final CardRecord cardRecord) {
        if (cardRecord != null) {
            CardImageCache cardImageCache = CardImageCache.INSTANCE;
            Context context = messageViewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            String imageUrl = cardImageCache.getImageUrl(context, cardRecord.getScryfall_id(), intRef.element);
            if (imageUrl == null) {
                MTApiKt.getMtApi().getCardByScryfallId(cardRecord.getScryfall_id()).enqueue(new Callback<MTCardResponse>() { // from class: com.studiolaganne.lengendarylens.MessagesAdapter$onBindViewHolder$1$1$1$2$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCardResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCardResponse> call, Response<MTCardResponse> response) {
                        String scryfall_id;
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (response.isSuccessful()) {
                            MTCardResponse mTCardResponseBody = response.body();
                            MTFullCard card = mTCardResponseBody != null ? mTCardResponseBody.getCard() : null;
                            String imageUrl2 = card != null ? card.getImageUrl(intRef.element) : null;
                            String str = imageUrl2;
                            if (str == null || str.length() == 0) {
                                return;
                            }
                            messageViewHolder.getCardImage().loadImage(imageUrl2);
                            CardImageCache cardImageCache2 = CardImageCache.INSTANCE;
                            Context context2 = messageViewHolder.itemView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                            if (card == null || (scryfall_id = card.getScryfallid()) == null) {
                                scryfall_id = cardRecord.getScryfall_id();
                            }
                            cardImageCache2.saveImageUrl(context2, scryfall_id, imageUrl2, intRef.element);
                        }
                    }
                });
            } else if (imageUrl.length() > 0) {
                messageViewHolder.getCardImage().loadImage(imageUrl);
            }
        }
        ViewExtensionsKt.setOnClickWithFade(messageViewHolder.getCardImage(), new Function0() { // from class: com.studiolaganne.lengendarylens.MessagesAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MessagesAdapter.onBindViewHolder$lambda$0$0$1(cardRecord, messageViewHolder);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$0$1(CardRecord cardRecord, MessageViewHolder messageViewHolder) {
        if (cardRecord != null) {
            MTGDBHelper.Companion companion = MTGDBHelper.INSTANCE;
            Context context = messageViewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            CardRecord cardByOracleIdAndPrintData = companion.getInstance(context).getCardByOracleIdAndPrintData(cardRecord.getOracle_id(), cardRecord.getSet(), cardRecord.getNumber(), cardRecord.getFace());
            String scryfall_id = cardByOracleIdAndPrintData != null ? cardByOracleIdAndPrintData.getScryfall_id() : "";
            Intent intent = new Intent(messageViewHolder.itemView.getContext(), (Class<?>) CardActivity.class);
            intent.putExtra("scryfallId", cardRecord.getScryfall_id());
            intent.putExtra("enScryfallId", scryfall_id);
            intent.putExtra("oracleId", cardRecord.getOracle_id());
            intent.putExtra("lang", "fr");
            messageViewHolder.itemView.getContext().startActivity(intent);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$1(MessageViewHolder messageViewHolder, MTMessage mTMessage) {
        Object systemService = messageViewHolder.itemView.getContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("message", mTMessage.getContent()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$0$2(MessageViewHolder messageViewHolder, final Function0 function0, View view) {
        Context context = messageViewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        IconPopupMenu.addItem$default(new IconPopupMenu(context), R.string.action_copy, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.MessagesAdapter$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MessagesAdapter.onBindViewHolder$lambda$0$2$0(function0);
            }
        }, 30, (Object) null).show(messageViewHolder.getRootLayout());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$2$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$0$3(MessageViewHolder messageViewHolder, final Function0 function0, View view) {
        Context context = messageViewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        IconPopupMenu.addItem$default(new IconPopupMenu(context), R.string.action_copy, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.MessagesAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MessagesAdapter.onBindViewHolder$lambda$0$3$0(function0);
            }
        }, 30, (Object) null).show(messageViewHolder.getRootLayout());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$3$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$4(MTMessage mTMessage, MessagesAdapter messagesAdapter) {
        if (!Intrinsics.areEqual(mTMessage.getUsername(), messagesAdapter.user.getUsername())) {
            messagesAdapter.clickListener.onProfileClick(new MTUser(false, mTMessage.getUserid(), mTMessage.getFirstname(), "", mTMessage.getUsername(), mTMessage.getPicture(), null, null, null, null, 961, null));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$5(MTMessage mTMessage, MessagesAdapter messagesAdapter) {
        if (Intrinsics.areEqual(mTMessage.getUsername(), messagesAdapter.user.getUsername())) {
            messagesAdapter.clickListener.onProfileClick(messagesAdapter.user);
        }
        return Unit.INSTANCE;
    }

    private final void parseAndSetLinks(final Context context, TextView textView, String messageContent) {
        String str = messageContent;
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Patterns.WEB_URL.matcher(str);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            final String strGroup = matcher.group();
            spannableString.setSpan(new ClickableSpan() { // from class: com.studiolaganne.lengendarylens.MessagesAdapter$parseAndSetLinks$clickableSpan$1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    Intent intent = new Intent(context, (Class<?>) WebActivity.class);
                    intent.setFlags(603979776);
                    intent.putExtra("url", strGroup);
                    context.startActivity(intent);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.checkNotNullParameter(ds, "ds");
                    super.updateDrawState(ds);
                    ds.setUnderlineText(true);
                    ds.setColor(ContextCompat.getColor(context, R.color.link_color));
                }
            }, iStart, iEnd, 33);
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.messages.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.messages.get(position).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String separator;
        Intrinsics.checkNotNullParameter(holder, "holder");
        MessageItemHolder messageItemHolder = this.messages.get(position);
        if (!(holder instanceof MessageViewHolder)) {
            if (!(holder instanceof MessageSeparatorViewHolder) || (separator = messageItemHolder.getSeparator()) == null) {
                return;
            }
            ((MessageSeparatorViewHolder) holder).getSeparatorText().setText(separator);
            return;
        }
        final MessageViewHolder messageViewHolder = (MessageViewHolder) holder;
        final MTMessage message = messageItemHolder.getMessage();
        if (message != null) {
            if (StringsKt.startsWith$default(message.getContent(), "[[card:", false, 2, (Object) null)) {
                messageViewHolder.getMessage().setVisibility(8);
                messageViewHolder.getCardImage().setVisibility(0);
                final Ref.IntRef intRef = new Ref.IntRef();
                String strSubstring = message.getContent().substring(7, message.getContent().length() - 2);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String str = strSubstring;
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                    List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                    strSubstring = (String) listSplit$default.get(0);
                    intRef.element = Integer.parseInt((String) listSplit$default.get(1));
                }
                messageViewHolder.getCardImage().reset();
                messageViewHolder.getCardImage().setAutoLoad(false);
                GameUtils companion = GameUtils.INSTANCE.getInstance();
                Context context = messageViewHolder.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                companion.getCard(context, strSubstring, intRef.element, new Function1() { // from class: com.studiolaganne.lengendarylens.MessagesAdapter$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MessagesAdapter.onBindViewHolder$lambda$0$0(messageViewHolder, intRef, this, (CardRecord) obj);
                    }
                });
            } else {
                messageViewHolder.getMessage().setVisibility(0);
                messageViewHolder.getCardImage().setVisibility(8);
                Context context2 = messageViewHolder.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                parseAndSetLinks(context2, messageViewHolder.getMessage(), message.getContent());
            }
            final Function0 function0 = new Function0() { // from class: com.studiolaganne.lengendarylens.MessagesAdapter$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MessagesAdapter.onBindViewHolder$lambda$0$1(messageViewHolder, message);
                }
            };
            messageViewHolder.getRootLayout().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.studiolaganne.lengendarylens.MessagesAdapter$$ExternalSyntheticLambda4
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return MessagesAdapter.onBindViewHolder$lambda$0$2(messageViewHolder, function0, view);
                }
            });
            messageViewHolder.getMessage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.studiolaganne.lengendarylens.MessagesAdapter$$ExternalSyntheticLambda5
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return MessagesAdapter.onBindViewHolder$lambda$0$3(messageViewHolder, function0, view);
                }
            });
            messageViewHolder.getUserNameText().setText("@" + message.getUsername());
            messageViewHolder.getUserFirstName().setText(message.getFirstname());
            if (Intrinsics.areEqual(message.getUsername(), this.user.getUsername())) {
                messageViewHolder.getUserFirstName().setText(messageViewHolder.itemView.getResources().getString(R.string.you_capitalized));
            }
            messageViewHolder.getMessageTime().setText(ServerUtils.INSTANCE.getInstance().parseAndFormatTimestamp(message.getTimestamp()));
            messageViewHolder.getProfileLayoutLeft().setOutlineProvider(new CircularOutlineProvider());
            messageViewHolder.getProfileLayoutRight().setOutlineProvider(new CircularOutlineProvider());
            messageViewHolder.getProfileLayoutLeft().setClipToOutline(true);
            messageViewHolder.getProfileLayoutRight().setClipToOutline(true);
            messageViewHolder.getProfilePictureLeft().setOutlineProvider(new CircularOutlineProvider());
            messageViewHolder.getProfilePictureRight().setOutlineProvider(new CircularOutlineProvider());
            messageViewHolder.getProfilePictureLeft().setClipToOutline(true);
            messageViewHolder.getProfilePictureRight().setClipToOutline(true);
            messageViewHolder.getSpacerLeft().setVisibility(8);
            messageViewHolder.getSpacerRight().setVisibility(8);
            if (Intrinsics.areEqual(message.getUsername(), this.user.getUsername())) {
                messageViewHolder.getProfileLayoutLeft().setVisibility(8);
                messageViewHolder.getProfileLayoutRight().setVisibility(0);
                messageViewHolder.getNoPhotoRight().setVisibility(0);
                messageViewHolder.getProfilePictureRight().setVisibility(8);
                String picture = message.getPicture();
                String str2 = picture;
                if (str2 == null || str2.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
                    messageViewHolder.getProfilePictureRight().setVisibility(4);
                    messageViewHolder.getNoPhotoRight().setVisibility(0);
                } else {
                    messageViewHolder.getProfilePictureRight().setVisibility(0);
                    messageViewHolder.getNoPhotoRight().setVisibility(4);
                    messageViewHolder.getProfilePictureRight().reset();
                    messageViewHolder.getProfilePictureRight().setAutoLoad(false);
                    messageViewHolder.getProfilePictureRight().loadImage(picture);
                }
                if (position > 0) {
                    MTMessage message2 = this.messages.get(position - 1).getMessage();
                    if (Intrinsics.areEqual(message2 != null ? message2.getUsername() : null, message.getUsername())) {
                        messageViewHolder.getSpacerRight().setVisibility(0);
                        messageViewHolder.getProfileLayoutRight().setVisibility(8);
                        messageViewHolder.getUserNameText().setVisibility(8);
                        messageViewHolder.getUserFirstName().setVisibility(8);
                    }
                }
            } else {
                messageViewHolder.getProfileLayoutRight().setVisibility(8);
                messageViewHolder.getProfileLayoutLeft().setVisibility(0);
                messageViewHolder.getNoPhotoLeft().setVisibility(0);
                messageViewHolder.getProfilePictureLeft().setVisibility(8);
                String picture2 = message.getPicture();
                String str3 = picture2;
                if (str3 == null || str3.length() == 0 || Intrinsics.areEqual(picture2, AbstractJsonLexerKt.NULL)) {
                    messageViewHolder.getProfilePictureLeft().setVisibility(4);
                    messageViewHolder.getNoPhotoLeft().setVisibility(0);
                } else {
                    messageViewHolder.getProfilePictureLeft().setVisibility(0);
                    messageViewHolder.getNoPhotoLeft().setVisibility(4);
                    messageViewHolder.getProfilePictureLeft().reset();
                    messageViewHolder.getProfilePictureLeft().setAutoLoad(false);
                    messageViewHolder.getProfilePictureLeft().loadImage(picture2);
                }
                if (position > 0) {
                    MessageItemHolder messageItemHolder2 = this.messages.get(position - 1);
                    MTMessage message3 = messageItemHolder2 != null ? messageItemHolder2.getMessage() : null;
                    if (Intrinsics.areEqual(message3 != null ? message3.getUsername() : null, message.getUsername())) {
                        messageViewHolder.getSpacerLeft().setVisibility(0);
                        messageViewHolder.getProfileLayoutLeft().setVisibility(8);
                        messageViewHolder.getUserNameText().setVisibility(8);
                        messageViewHolder.getUserFirstName().setVisibility(8);
                    }
                }
            }
            ViewExtensionsKt.setOnClickWithFade(messageViewHolder.getProfileLayoutLeft(), new Function0() { // from class: com.studiolaganne.lengendarylens.MessagesAdapter$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MessagesAdapter.onBindViewHolder$lambda$0$4(message, this);
                }
            });
            ViewExtensionsKt.setOnClickWithFade(messageViewHolder.getProfileLayoutRight(), new Function0() { // from class: com.studiolaganne.lengendarylens.MessagesAdapter$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MessagesAdapter.onBindViewHolder$lambda$0$5(message, this);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new MessageViewHolder(viewInflate, this.clickListener);
        }
        if (viewType != 2) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_separator_item, parent, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new MessageSeparatorViewHolder(viewInflate2, this.clickListener);
    }
}
