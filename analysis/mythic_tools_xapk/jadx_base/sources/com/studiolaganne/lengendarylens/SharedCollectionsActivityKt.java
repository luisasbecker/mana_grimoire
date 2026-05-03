package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.AuthenticationTokenClaims;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SharedCollectionsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¨\u0006\b"}, d2 = {"buildMemberAvatarView", "Landroid/view/View;", "context", "Landroid/content/Context;", AuthenticationTokenClaims.JSON_KEY_PICTURE, "", "firstname", HintConstants.AUTOFILL_HINT_USERNAME, "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SharedCollectionsActivityKt {
    public static final View buildMemberAvatarView(Context context, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginEnd(buildMemberAvatarView$dpToPx(context, 12));
        linearLayout.setLayoutParams(layoutParams);
        int iBuildMemberAvatarView$dpToPx = buildMemberAvatarView$dpToPx(context, 50);
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setLayoutParams(new LinearLayout.LayoutParams(iBuildMemberAvatarView$dpToPx, iBuildMemberAvatarView$dpToPx));
        constraintLayout.setClipChildren(true);
        constraintLayout.setBackgroundResource(R.drawable.profile_circle_invite);
        constraintLayout.setOutlineProvider(new CircularOutlineProvider());
        constraintLayout.setClipToOutline(true);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.no_photo);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(buildMemberAvatarView$dpToPx(context, 22), buildMemberAvatarView$dpToPx(context, 22));
        layoutParams2.topToTop = 0;
        layoutParams2.bottomToBottom = 0;
        layoutParams2.startToStart = 0;
        layoutParams2.endToEnd = 0;
        imageView.setLayoutParams(layoutParams2);
        constraintLayout.addView(imageView);
        String str4 = str;
        if (str4 != null && str4.length() != 0 && !Intrinsics.areEqual(str, AbstractJsonLexerKt.NULL)) {
            CachedImageView cachedImageView = new CachedImageView(context, null, 0, 6, null);
            ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-1, -1);
            layoutParams3.topToTop = 0;
            layoutParams3.bottomToBottom = 0;
            layoutParams3.startToStart = 0;
            layoutParams3.endToEnd = 0;
            layoutParams3.setMargins(buildMemberAvatarView$dpToPx(context, 2), buildMemberAvatarView$dpToPx(context, 2), buildMemberAvatarView$dpToPx(context, 2), buildMemberAvatarView$dpToPx(context, 2));
            cachedImageView.setOutlineProvider(new CircularOutlineProvider());
            cachedImageView.setClipToOutline(true);
            cachedImageView.setLayoutParams(layoutParams3);
            cachedImageView.setAutoLoad(false);
            cachedImageView.loadImage(str);
            constraintLayout.addView(cachedImageView);
            imageView.setVisibility(4);
        }
        linearLayout.addView(constraintLayout);
        TextView textView = new TextView(context);
        textView.setText(str2 != null ? str2 : "");
        textView.setTextSize(13.0f);
        textView.setTypeface(context.getResources().getFont(R.font.be_vietnam_pro_semibold));
        textView.setTextColor(context.getResources().getColor(R.color.almost_white, context.getTheme()));
        textView.setTextAlignment(4);
        textView.setMaxLines(1);
        textView.setPadding(0, buildMemberAvatarView$dpToPx(context, 4), 0, 0);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setText("@" + (str3 != null ? str3 : ""));
        textView2.setTextSize(11.0f);
        textView2.setTypeface(context.getResources().getFont(R.font.be_vietnam_pro_regular));
        textView2.setTextColor(context.getResources().getColor(R.color.text_color, context.getTheme()));
        textView2.setTextAlignment(4);
        textView2.setMaxLines(1);
        linearLayout.addView(textView2);
        return linearLayout;
    }

    private static final int buildMemberAvatarView$dpToPx(Context context, int i) {
        return (int) (i * context.getResources().getDisplayMetrics().density);
    }
}
