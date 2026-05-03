package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: PrivacySettingsDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001[B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u00107\u001a\u00020\u000fH\u0016J&\u00108\u001a\u0004\u0018\u00010\u00062\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u001a\u0010?\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010A\u001a\u00020\u000fH\u0002J\b\u0010B\u001a\u00020\u000fH\u0002J\b\u0010C\u001a\u00020\u000fH\u0002J\b\u0010D\u001a\u00020\u000fH\u0002J\b\u0010E\u001a\u00020\u000fH\u0002J\u0016\u0010F\u001a\u00020\u000f2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\b\u0010H\u001a\u00020\u000fH\u0002J\b\u0010I\u001a\u00020\u000fH\u0002J\b\u0010J\u001a\u00020\u000fH\u0002J\b\u0010K\u001a\u00020\u000fH\u0002J\b\u0010L\u001a\u00020\u000fH\u0002J\b\u0010M\u001a\u00020\u000fH\u0002J\u0018\u0010N\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020\u0015H\u0002J\b\u0010Q\u001a\u00020\u000fH\u0002J(\u0010R\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020T2\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010 2\u0006\u0010V\u001a\u00020WH\u0002J(\u0010X\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020T2\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010 2\u0006\u0010V\u001a\u00020WH\u0002J(\u0010Y\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020T2\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010 2\u0006\u0010V\u001a\u00020WH\u0002J\b\u0010Z\u001a\u00020\u000fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00100R\u0014\u00103\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00100R\u0014\u00105\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00100¨\u0006\\"}, d2 = {"Lcom/studiolaganne/lengendarylens/PrivacySettingsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/studiolaganne/lengendarylens/CreateCircleCallback;", "<init>", "()V", "rootView", "Landroid/view/View;", "privacyContext", "Lcom/studiolaganne/lengendarylens/PrivacyContext;", "listId", "", "currentPrivacy", "Lcom/studiolaganne/lengendarylens/MTContainerPrivacy;", "onPrivacyUpdated", "Lkotlin/Function1;", "", "deckId", "currentDeckPrivacy", "Lcom/studiolaganne/lengendarylens/MTDeckPrivacy;", "onDeckPrivacyUpdated", "shareStats", "", "shareGames", "currentUserPrivacy", "Lcom/studiolaganne/lengendarylens/MTUserPrivacy;", "onUserPrivacyUpdated", "profileShareStats", "profileShareGames", "profileShareFriendCode", "selectedType", "", "allCircles", "", "Lcom/studiolaganne/lengendarylens/MTCircle;", "selectedCircleIds", "", "privacySelectorContainer", "Landroid/widget/LinearLayout;", "privacyLabel", "Landroid/widget/TextView;", "privacyDescription", "circlesSection", "circlesSeparator", "circlesContainer", "saveButton", "Lcom/google/android/material/button/MaterialButton;", "entityName", "getEntityName", "()Ljava/lang/String;", "entityNameCapitalized", "getEntityNameCapitalized", "entityTitleForm", "getEntityTitleForm", "entityPronoun", "getEntityPronoun", "onStart", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "initializeViews", "setupInitialState", "setupClickListeners", "setupDeckOptions", "setupProfileOptions", "onCircleCreated", "circles", "updateSelectorAppearance", "updateCirclesSectionVisibility", "updateDeckOptionsSectionVisibility", "updateProfileOptionsSectionVisibility", "loadCircles", "populateCircles", "updateCircleRowBackground", "row", "isChecked", "savePrivacy", "saveListPrivacy", "currentUser", "Lcom/studiolaganne/lengendarylens/MTUser;", "circleIds", "ctx", "Landroid/content/Context;", "saveDeckPrivacy", "saveProfilePrivacy", "onDestroyView", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PrivacySettingsDialogFragment extends DialogFragment implements CreateCircleCallback {
    public static final int $stable = 8;
    private LinearLayout circlesContainer;
    private LinearLayout circlesSection;
    private View circlesSeparator;
    private MTDeckPrivacy currentDeckPrivacy;
    private MTContainerPrivacy currentPrivacy;
    private MTUserPrivacy currentUserPrivacy;
    private Function1<? super MTDeckPrivacy, Unit> onDeckPrivacyUpdated;
    private Function1<? super MTContainerPrivacy, Unit> onPrivacyUpdated;
    private Function1<? super MTUserPrivacy, Unit> onUserPrivacyUpdated;
    private TextView privacyDescription;
    private TextView privacyLabel;
    private LinearLayout privacySelectorContainer;
    private boolean profileShareFriendCode;
    private boolean profileShareGames;
    private boolean profileShareStats;
    private View rootView;
    private MaterialButton saveButton;
    private boolean shareGames;
    private boolean shareStats;
    private PrivacyContext privacyContext = PrivacyContext.LIST;
    private int listId = -1;
    private int deckId = -1;
    private String selectedType = MTApiKt.PRIVACY_TYPE_UNLISTED;
    private List<MTCircle> allCircles = CollectionsKt.emptyList();
    private Set<Integer> selectedCircleIds = new LinkedHashSet();

    /* JADX INFO: compiled from: PrivacySettingsDialogFragment.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u00020\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\u0011J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0016J\u001a\u0010\u0017\u001a\u00020\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u0011J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0019J\u001a\u0010\u001a\u001a\u00020\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0011J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/PrivacySettingsDialogFragment$Builder;", "", "<init>", "()V", "dialogFragment", "Lcom/studiolaganne/lengendarylens/PrivacySettingsDialogFragment;", "setPrivacyContext", "context", "Lcom/studiolaganne/lengendarylens/PrivacyContext;", "setListId", "listId", "", "setCurrentPrivacy", "privacy", "Lcom/studiolaganne/lengendarylens/MTContainerPrivacy;", "setOnPrivacyUpdated", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "setDeckId", "deckId", "setCurrentDeckPrivacy", "Lcom/studiolaganne/lengendarylens/MTDeckPrivacy;", "setOnDeckPrivacyUpdated", "setCurrentUserPrivacy", "Lcom/studiolaganne/lengendarylens/MTUserPrivacy;", "setOnUserPrivacyUpdated", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final PrivacySettingsDialogFragment dialogFragment = new PrivacySettingsDialogFragment();

        public final Builder setCurrentDeckPrivacy(MTDeckPrivacy privacy) {
            Intrinsics.checkNotNullParameter(privacy, "privacy");
            this.dialogFragment.currentDeckPrivacy = privacy;
            return this;
        }

        public final Builder setCurrentPrivacy(MTContainerPrivacy privacy) {
            Intrinsics.checkNotNullParameter(privacy, "privacy");
            this.dialogFragment.currentPrivacy = privacy;
            return this;
        }

        public final Builder setCurrentUserPrivacy(MTUserPrivacy privacy) {
            Intrinsics.checkNotNullParameter(privacy, "privacy");
            this.dialogFragment.currentUserPrivacy = privacy;
            return this;
        }

        public final Builder setDeckId(int deckId) {
            this.dialogFragment.deckId = deckId;
            return this;
        }

        public final Builder setListId(int listId) {
            this.dialogFragment.listId = listId;
            return this;
        }

        public final Builder setOnDeckPrivacyUpdated(Function1<? super MTDeckPrivacy, Unit> listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.dialogFragment.onDeckPrivacyUpdated = listener;
            return this;
        }

        public final Builder setOnPrivacyUpdated(Function1<? super MTContainerPrivacy, Unit> listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.dialogFragment.onPrivacyUpdated = listener;
            return this;
        }

        public final Builder setOnUserPrivacyUpdated(Function1<? super MTUserPrivacy, Unit> listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.dialogFragment.onUserPrivacyUpdated = listener;
            return this;
        }

        public final Builder setPrivacyContext(PrivacyContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.dialogFragment.privacyContext = context;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(this.dialogFragment, manager, tag);
        }
    }

    /* JADX INFO: compiled from: PrivacySettingsDialogFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrivacyContext.values().length];
            try {
                iArr[PrivacyContext.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrivacyContext.DECK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrivacyContext.PROFILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final String getEntityName() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.privacyContext.ordinal()];
        if (i == 1) {
            String string = getString(R.string.privacy_entity_list);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (i == 2) {
            String string2 = getString(R.string.privacy_entity_deck);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        String string3 = getString(R.string.privacy_entity_profile);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return string3;
    }

    private final String getEntityNameCapitalized() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.privacyContext.ordinal()];
        if (i == 1) {
            String string = getString(R.string.privacy_entity_list_capitalized);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (i == 2) {
            String string2 = getString(R.string.privacy_entity_deck_capitalized);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        String string3 = getString(R.string.privacy_entity_profile_capitalized);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return string3;
    }

    private final String getEntityPronoun() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.privacyContext.ordinal()];
        if (i == 1) {
            String string = getString(R.string.privacy_entity_list_pronoun);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (i == 2) {
            String string2 = getString(R.string.privacy_entity_deck_pronoun);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        String string3 = getString(R.string.privacy_entity_profile_pronoun);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return string3;
    }

    private final String getEntityTitleForm() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.privacyContext.ordinal()];
        if (i == 1) {
            String string = getString(R.string.privacy_entity_list_title_form);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (i == 2) {
            String string2 = getString(R.string.privacy_entity_deck_title_form);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        String string3 = getString(R.string.privacy_entity_profile_title_form);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return string3;
    }

    private final void initializeViews() {
        View view = this.rootView;
        if (view != null) {
            View viewFindViewById = view.findViewById(R.id.privacySelectorContainer);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.privacySelectorContainer = (LinearLayout) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.privacyLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.privacyLabel = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.privacyDescription);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.privacyDescription = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.circlesSection);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.circlesSection = (LinearLayout) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.circlesSeparator);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.circlesSeparator = viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.circlesContainer);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.circlesContainer = (LinearLayout) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.saveButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.saveButton = (MaterialButton) viewFindViewById7;
        }
    }

    private final void loadCircles() {
        MTUser currentUser;
        Context context = getContext();
        if (context == null || (currentUser = new PreferencesManager(context).getCurrentUser()) == null) {
            return;
        }
        MTApiKt.getMtApi().getCircles(currentUser.getId()).enqueue(new Callback<MTCirclesResponse>() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment.loadCircles.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCirclesResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCirclesResponse> call, Response<MTCirclesResponse> response) {
                List<MTCircle> listEmptyList;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (PrivacySettingsDialogFragment.this.rootView == null || PrivacySettingsDialogFragment.this.getContext() == null || !response.isSuccessful()) {
                    return;
                }
                PrivacySettingsDialogFragment privacySettingsDialogFragment = PrivacySettingsDialogFragment.this;
                MTCirclesResponse mTCirclesResponseBody = response.body();
                if (mTCirclesResponseBody == null || (listEmptyList = mTCirclesResponseBody.getCircles()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                privacySettingsDialogFragment.allCircles = listEmptyList;
                PrivacySettingsDialogFragment.this.populateCircles();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$0$0(Window window, int i, int i2) {
        if (window.getDecorView().getHeight() > i) {
            window.setLayout(i2, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010c A[PHI: r3
      0x010c: PHI (r3v1 java.lang.String) = (r3v0 java.lang.String), (r3v17 java.lang.String) binds: [B:23:0x0109, B:20:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void populateCircles() {
        String name;
        final Context context = getContext();
        if (context == null) {
            return;
        }
        LinearLayout linearLayout = this.circlesContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("circlesContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(PrivacySettingsDialogFragment.populateCircles$lambda$0(context, ((Float) obj).floatValue()));
            }
        };
        Typeface font = ResourcesCompat.getFont(context, R.font.be_vietnam_pro_semibold);
        for (final MTCircle mTCircle : this.allCircles) {
            boolean zContains = this.selectedCircleIds.contains(Integer.valueOf(mTCircle.getId()));
            final LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            linearLayout2.setPadding(((Number) function1.invoke(Float.valueOf(12.0f))).intValue(), ((Number) function1.invoke(Float.valueOf(10.0f))).intValue(), ((Number) function1.invoke(Float.valueOf(12.0f))).intValue(), ((Number) function1.invoke(Float.valueOf(10.0f))).intValue());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = ((Number) function1.invoke(Float.valueOf(6.0f))).intValue();
            linearLayout2.setLayoutParams(layoutParams);
            updateCircleRowBackground(linearLayout2, zContains);
            final CheckBox checkBox = new CheckBox(context);
            checkBox.setChecked(zContains);
            checkBox.setButtonTintList(ContextCompat.getColorStateList(context, R.color.selected_color_new));
            checkBox.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            String string = "";
            if (Intrinsics.areEqual((Object) mTCircle.is_auto_created(), (Object) true)) {
                String auto_update_type = mTCircle.getAuto_update_type();
                if (Intrinsics.areEqual(auto_update_type, MTApiKt.CIRCLE_AUTO_UPDATE_TYPE_ALL_FRIENDS)) {
                    string = getString(R.string.circle_all_friends);
                } else if (Intrinsics.areEqual(auto_update_type, MTApiKt.CIRCLE_AUTO_UPDATE_TYPE_ALL_PLAYGROUPS)) {
                    string = getString(R.string.circle_all_playgroups);
                } else {
                    name = mTCircle.getName();
                    if (name != null) {
                        string = name;
                    }
                }
            } else {
                name = mTCircle.getName();
                if (name != null) {
                }
            }
            Intrinsics.checkNotNull(string);
            TextView textView = new TextView(context);
            textView.setText(string);
            textView.setTextColor(ContextCompat.getColor(context, R.color.almost_white));
            textView.setTextSize(15.0f);
            textView.setTypeface(font);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams2.setMarginStart(((Number) function1.invoke(Float.valueOf(4.0f))).intValue());
            textView.setLayoutParams(layoutParams2);
            linearLayout2.addView(checkBox);
            linearLayout2.addView(textView);
            if (Intrinsics.areEqual((Object) mTCircle.is_auto_created(), (Object) true)) {
                TextView textView2 = new TextView(context);
                textView2.setText(getString(R.string.auto_label));
                textView2.setTextSize(11.0f);
                textView2.setTypeface(font);
                textView2.setTextColor(ContextCompat.getColor(context, R.color.selected_color_new));
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(0);
                gradientDrawable.setCornerRadius(((Number) function1.invoke(Float.valueOf(4.0f))).intValue());
                gradientDrawable.setStroke(((Number) function1.invoke(Float.valueOf(1.0f))).intValue(), ContextCompat.getColor(context, R.color.selected_color_new));
                textView2.setBackground(gradientDrawable);
                textView2.setPadding(((Number) function1.invoke(Float.valueOf(6.0f))).intValue(), ((Number) function1.invoke(Float.valueOf(2.0f))).intValue(), ((Number) function1.invoke(Float.valueOf(6.0f))).intValue(), ((Number) function1.invoke(Float.valueOf(2.0f))).intValue());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMarginStart(((Number) function1.invoke(Float.valueOf(8.0f))).intValue());
                textView2.setLayoutParams(layoutParams3);
                linearLayout2.addView(textView2);
            }
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment$$ExternalSyntheticLambda2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    PrivacySettingsDialogFragment.populateCircles$lambda$5(this.f$0, mTCircle, linearLayout2, compoundButton, z);
                }
            });
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    checkBox.setChecked(!r0.isChecked());
                }
            });
            LinearLayout linearLayout3 = this.circlesContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("circlesContainer");
                linearLayout3 = null;
            }
            linearLayout3.addView(linearLayout2);
        }
    }

    static final int populateCircles$lambda$0(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    static final void populateCircles$lambda$5(PrivacySettingsDialogFragment privacySettingsDialogFragment, MTCircle mTCircle, LinearLayout linearLayout, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            privacySettingsDialogFragment.selectedCircleIds.add(Integer.valueOf(mTCircle.getId()));
        } else {
            privacySettingsDialogFragment.selectedCircleIds.remove(Integer.valueOf(mTCircle.getId()));
        }
        privacySettingsDialogFragment.updateCircleRowBackground(linearLayout, z);
    }

    private final void saveDeckPrivacy(MTUser currentUser, List<Integer> circleIds, final Context ctx) {
        if (this.deckId == -1) {
            return;
        }
        MTApiKt.getMtApi().updateDeckPrivacy(currentUser.getId(), this.deckId, new MTUpdatePrivacyBody(this.selectedType, circleIds, MapsKt.mapOf(TuplesKt.to("share_stats", Boolean.valueOf(this.shareStats)), TuplesKt.to("share_games", Boolean.valueOf(this.shareGames))))).enqueue(new Callback<MTDeckPrivacyResponse>() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment.saveDeckPrivacy.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTDeckPrivacyResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (PrivacySettingsDialogFragment.this.rootView == null || PrivacySettingsDialogFragment.this.getContext() == null) {
                    return;
                }
                MaterialButton materialButton = PrivacySettingsDialogFragment.this.saveButton;
                if (materialButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("saveButton");
                    materialButton = null;
                }
                materialButton.setEnabled(true);
                Toast.makeText(ctx, R.string.privacy_update_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTDeckPrivacyResponse> call, Response<MTDeckPrivacyResponse> response) {
                ArrayList arrayList;
                String type;
                MTDeckPrivacyOptions mTDeckPrivacyOptions;
                List<MTCircle> circles;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (PrivacySettingsDialogFragment.this.rootView == null || PrivacySettingsDialogFragment.this.getContext() == null) {
                    return;
                }
                MaterialButton materialButton = null;
                if (!response.isSuccessful()) {
                    MaterialButton materialButton2 = PrivacySettingsDialogFragment.this.saveButton;
                    if (materialButton2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("saveButton");
                    } else {
                        materialButton = materialButton2;
                    }
                    materialButton.setEnabled(true);
                    Toast.makeText(ctx, R.string.privacy_update_error, 0).show();
                    return;
                }
                MTDeckPrivacyResponse mTDeckPrivacyResponseBody = response.body();
                MTDeckPrivacy privacy = mTDeckPrivacyResponseBody != null ? mTDeckPrivacyResponseBody.getPrivacy() : null;
                if (Intrinsics.areEqual(PrivacySettingsDialogFragment.this.selectedType, MTApiKt.PRIVACY_TYPE_SHARED)) {
                    List list = PrivacySettingsDialogFragment.this.allCircles;
                    PrivacySettingsDialogFragment privacySettingsDialogFragment = PrivacySettingsDialogFragment.this;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : list) {
                        if (privacySettingsDialogFragment.selectedCircleIds.contains(Integer.valueOf(((MTCircle) obj).getId()))) {
                            arrayList2.add(obj);
                        }
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = null;
                }
                if (privacy == null || (type = privacy.getType()) == null) {
                    type = PrivacySettingsDialogFragment.this.selectedType;
                }
                String str = type;
                if (privacy == null || (mTDeckPrivacyOptions = privacy.getOptions()) == null) {
                    mTDeckPrivacyOptions = new MTDeckPrivacyOptions(Boolean.valueOf(PrivacySettingsDialogFragment.this.shareStats), Boolean.valueOf(PrivacySettingsDialogFragment.this.shareGames));
                }
                MTDeckPrivacy mTDeckPrivacy = new MTDeckPrivacy(str, mTDeckPrivacyOptions, (privacy == null || (circles = privacy.getCircles()) == null) ? arrayList : circles, privacy != null ? privacy.getFriends() : null, privacy != null ? privacy.getPlaygroups() : null);
                Function1 function1 = PrivacySettingsDialogFragment.this.onDeckPrivacyUpdated;
                if (function1 != null) {
                    function1.invoke(mTDeckPrivacy);
                }
                PrivacySettingsDialogFragment.this.dismiss();
            }
        });
    }

    private final void saveListPrivacy(MTUser currentUser, List<Integer> circleIds, final Context ctx) {
        if (this.listId == -1) {
            return;
        }
        MTApiKt.getMtApi().updateListPrivacy(currentUser.getId(), this.listId, new MTUpdatePrivacyBody(this.selectedType, circleIds, null, 4, null)).enqueue(new Callback<MTContainerPrivacyResponse>() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment.saveListPrivacy.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTContainerPrivacyResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (PrivacySettingsDialogFragment.this.rootView == null || PrivacySettingsDialogFragment.this.getContext() == null) {
                    return;
                }
                MaterialButton materialButton = PrivacySettingsDialogFragment.this.saveButton;
                if (materialButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("saveButton");
                    materialButton = null;
                }
                materialButton.setEnabled(true);
                Toast.makeText(ctx, R.string.privacy_update_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTContainerPrivacyResponse> call, Response<MTContainerPrivacyResponse> response) {
                ArrayList arrayList;
                String type;
                List<MTCircle> circles;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (PrivacySettingsDialogFragment.this.rootView == null || PrivacySettingsDialogFragment.this.getContext() == null) {
                    return;
                }
                MaterialButton materialButton = null;
                if (!response.isSuccessful()) {
                    MaterialButton materialButton2 = PrivacySettingsDialogFragment.this.saveButton;
                    if (materialButton2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("saveButton");
                    } else {
                        materialButton = materialButton2;
                    }
                    materialButton.setEnabled(true);
                    Toast.makeText(ctx, R.string.privacy_update_error, 0).show();
                    return;
                }
                MTContainerPrivacyResponse mTContainerPrivacyResponseBody = response.body();
                MTContainerPrivacy privacy = mTContainerPrivacyResponseBody != null ? mTContainerPrivacyResponseBody.getPrivacy() : null;
                if (Intrinsics.areEqual(PrivacySettingsDialogFragment.this.selectedType, MTApiKt.PRIVACY_TYPE_SHARED)) {
                    List list = PrivacySettingsDialogFragment.this.allCircles;
                    PrivacySettingsDialogFragment privacySettingsDialogFragment = PrivacySettingsDialogFragment.this;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : list) {
                        if (privacySettingsDialogFragment.selectedCircleIds.contains(Integer.valueOf(((MTCircle) obj).getId()))) {
                            arrayList2.add(obj);
                        }
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = null;
                }
                if (privacy == null || (type = privacy.getType()) == null) {
                    type = PrivacySettingsDialogFragment.this.selectedType;
                }
                if (privacy != null && (circles = privacy.getCircles()) != null) {
                    arrayList = circles;
                }
                MTContainerPrivacy mTContainerPrivacy = new MTContainerPrivacy(type, arrayList, privacy != null ? privacy.getFriends() : null, privacy != null ? privacy.getPlaygroups() : null);
                Function1 function1 = PrivacySettingsDialogFragment.this.onPrivacyUpdated;
                if (function1 != null) {
                    function1.invoke(mTContainerPrivacy);
                }
                PrivacySettingsDialogFragment.this.dismiss();
            }
        });
    }

    private final void savePrivacy() {
        MTUser currentUser;
        Context context = getContext();
        if (context == null || (currentUser = new PreferencesManager(context).getCurrentUser()) == null) {
            return;
        }
        MaterialButton materialButton = this.saveButton;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            materialButton = null;
        }
        materialButton.setEnabled(false);
        List<Integer> list = Intrinsics.areEqual(this.selectedType, MTApiKt.PRIVACY_TYPE_SHARED) ? CollectionsKt.toList(this.selectedCircleIds) : null;
        int i = WhenMappings.$EnumSwitchMapping$0[this.privacyContext.ordinal()];
        if (i == 1) {
            saveListPrivacy(currentUser, list, context);
        } else if (i == 2) {
            saveDeckPrivacy(currentUser, list, context);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            saveProfilePrivacy(currentUser, list, context);
        }
    }

    private final void saveProfilePrivacy(MTUser currentUser, List<Integer> circleIds, final Context ctx) {
        MTApiKt.getMtApi().updateUserPrivacy(currentUser.getId(), new MTUpdatePrivacyBody(this.selectedType, circleIds, MapsKt.mapOf(TuplesKt.to("share_stats", Boolean.valueOf(this.profileShareStats)), TuplesKt.to("share_games", Boolean.valueOf(this.profileShareGames)), TuplesKt.to("share_friend_code", Boolean.valueOf(this.profileShareFriendCode))))).enqueue(new Callback<MTPrivacyResponse>() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment.saveProfilePrivacy.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTPrivacyResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (PrivacySettingsDialogFragment.this.rootView == null || PrivacySettingsDialogFragment.this.getContext() == null) {
                    return;
                }
                MaterialButton materialButton = PrivacySettingsDialogFragment.this.saveButton;
                if (materialButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("saveButton");
                    materialButton = null;
                }
                materialButton.setEnabled(true);
                Toast.makeText(ctx, R.string.privacy_update_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTPrivacyResponse> call, Response<MTPrivacyResponse> response) {
                String type;
                MTUserPrivacyOptions mTUserPrivacyOptions;
                List<MTCircle> circles;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (PrivacySettingsDialogFragment.this.rootView == null || PrivacySettingsDialogFragment.this.getContext() == null) {
                    return;
                }
                MaterialButton materialButton = null;
                ArrayList arrayList = null;
                if (!response.isSuccessful()) {
                    MaterialButton materialButton2 = PrivacySettingsDialogFragment.this.saveButton;
                    if (materialButton2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("saveButton");
                    } else {
                        materialButton = materialButton2;
                    }
                    materialButton.setEnabled(true);
                    Toast.makeText(ctx, R.string.privacy_update_error, 0).show();
                    return;
                }
                MTPrivacyResponse mTPrivacyResponseBody = response.body();
                MTUserPrivacy privacy = mTPrivacyResponseBody != null ? mTPrivacyResponseBody.getPrivacy() : null;
                if (Intrinsics.areEqual(PrivacySettingsDialogFragment.this.selectedType, MTApiKt.PRIVACY_TYPE_SHARED)) {
                    List list = PrivacySettingsDialogFragment.this.allCircles;
                    PrivacySettingsDialogFragment privacySettingsDialogFragment = PrivacySettingsDialogFragment.this;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : list) {
                        if (privacySettingsDialogFragment.selectedCircleIds.contains(Integer.valueOf(((MTCircle) obj).getId()))) {
                            arrayList2.add(obj);
                        }
                    }
                    arrayList = arrayList2;
                }
                if (privacy == null || (type = privacy.getType()) == null) {
                    type = PrivacySettingsDialogFragment.this.selectedType;
                }
                if (privacy == null || (mTUserPrivacyOptions = privacy.getOptions()) == null) {
                    mTUserPrivacyOptions = new MTUserPrivacyOptions(Boolean.valueOf(PrivacySettingsDialogFragment.this.profileShareFriendCode), Boolean.valueOf(PrivacySettingsDialogFragment.this.profileShareGames), Boolean.valueOf(PrivacySettingsDialogFragment.this.profileShareStats));
                }
                if (privacy != null && (circles = privacy.getCircles()) != null) {
                    arrayList = circles;
                }
                MTUserPrivacy mTUserPrivacy = new MTUserPrivacy(type, mTUserPrivacyOptions, arrayList);
                Function1 function1 = PrivacySettingsDialogFragment.this.onUserPrivacyUpdated;
                if (function1 != null) {
                    function1.invoke(mTUserPrivacy);
                }
                PrivacySettingsDialogFragment.this.dismiss();
            }
        });
    }

    private final void setupClickListeners() {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        View view = this.rootView;
        if (view != null && (viewFindViewById3 = view.findViewById(R.id.closeButton)) != null) {
            ViewExtensionsKt.setOnClickWithFade(viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PrivacySettingsDialogFragment.setupClickListeners$lambda$0(this.f$0);
                }
            });
        }
        View view2 = this.rootView;
        if (view2 != null && (viewFindViewById2 = view2.findViewById(R.id.cancelButton)) != null) {
            ViewExtensionsKt.setOnClickWithFade(viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PrivacySettingsDialogFragment.setupClickListeners$lambda$1(this.f$0);
                }
            });
        }
        LinearLayout linearLayout = this.privacySelectorContainer;
        MaterialButton materialButton = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacySelectorContainer");
            linearLayout = null;
        }
        ViewExtensionsKt.setOnClickWithFade(linearLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrivacySettingsDialogFragment.setupClickListeners$lambda$2(this.f$0);
            }
        });
        View view3 = this.rootView;
        if (view3 != null && (viewFindViewById = view3.findViewById(R.id.createCircleButton)) != null) {
            ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PrivacySettingsDialogFragment.setupClickListeners$lambda$3(this.f$0);
                }
            });
        }
        MaterialButton materialButton2 = this.saveButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        } else {
            materialButton = materialButton2;
        }
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PrivacySettingsDialogFragment.setupClickListeners$lambda$4(this.f$0);
            }
        });
    }

    static final Unit setupClickListeners$lambda$0(PrivacySettingsDialogFragment privacySettingsDialogFragment) {
        privacySettingsDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit setupClickListeners$lambda$1(PrivacySettingsDialogFragment privacySettingsDialogFragment) {
        privacySettingsDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit setupClickListeners$lambda$2(final PrivacySettingsDialogFragment privacySettingsDialogFragment) {
        Context contextRequireContext = privacySettingsDialogFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PrivacyPopupMenu privacyPopupMenu = new PrivacyPopupMenu(contextRequireContext, privacySettingsDialogFragment.selectedType, privacySettingsDialogFragment.privacyContext, new Function1() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PrivacySettingsDialogFragment.setupClickListeners$lambda$2$0(this.f$0, (String) obj);
            }
        });
        LinearLayout linearLayout = privacySettingsDialogFragment.privacySelectorContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacySelectorContainer");
            linearLayout = null;
        }
        PrivacyPopupMenu.show$default(privacyPopupMenu, linearLayout, false, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupClickListeners$lambda$2$0(PrivacySettingsDialogFragment privacySettingsDialogFragment, String newType) {
        Intrinsics.checkNotNullParameter(newType, "newType");
        if (!Intrinsics.areEqual(newType, privacySettingsDialogFragment.selectedType)) {
            privacySettingsDialogFragment.selectedType = newType;
            privacySettingsDialogFragment.updateSelectorAppearance();
            privacySettingsDialogFragment.updateCirclesSectionVisibility();
        }
        return Unit.INSTANCE;
    }

    static final Unit setupClickListeners$lambda$3(PrivacySettingsDialogFragment privacySettingsDialogFragment) {
        MTUser currentUser;
        Context context = privacySettingsDialogFragment.getContext();
        if (context != null && (currentUser = new PreferencesManager(context).getCurrentUser()) != null) {
            new CreateCircleBottomSheetFragment(privacySettingsDialogFragment, currentUser).show(privacySettingsDialogFragment.getChildFragmentManager(), CreateCircleBottomSheetFragment.TAG);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    static final Unit setupClickListeners$lambda$4(PrivacySettingsDialogFragment privacySettingsDialogFragment) {
        privacySettingsDialogFragment.savePrivacy();
        return Unit.INSTANCE;
    }

    private final void setupDeckOptions() {
        View view = this.rootView;
        if (view == null) {
            return;
        }
        if (this.privacyContext != PrivacyContext.DECK) {
            View viewFindViewById = view.findViewById(R.id.deckOptionsSection);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            View viewFindViewById2 = view.findViewById(R.id.deckOptionsSeparator);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(8);
                return;
            }
            return;
        }
        SwitchCompat switchCompat = (SwitchCompat) view.findViewById(R.id.shareStatsSwitch);
        if (switchCompat != null) {
            switchCompat.setChecked(this.shareStats);
            switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment$$ExternalSyntheticLambda4
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    PrivacySettingsDialogFragment.setupDeckOptions$lambda$0$0(this.f$0, compoundButton, z);
                }
            });
        }
        SwitchCompat switchCompat2 = (SwitchCompat) view.findViewById(R.id.shareGamesSwitch);
        if (switchCompat2 != null) {
            switchCompat2.setChecked(this.shareGames);
            switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment$$ExternalSyntheticLambda5
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    PrivacySettingsDialogFragment.setupDeckOptions$lambda$1$0(this.f$0, compoundButton, z);
                }
            });
        }
        updateDeckOptionsSectionVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDeckOptions$lambda$0$0(PrivacySettingsDialogFragment privacySettingsDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        privacySettingsDialogFragment.shareStats = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDeckOptions$lambda$1$0(PrivacySettingsDialogFragment privacySettingsDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        privacySettingsDialogFragment.shareGames = z;
    }

    private final void setupInitialState() {
        List<MTCircle> circles;
        String type;
        MTDeckPrivacyOptions options;
        Boolean share_games;
        MTDeckPrivacyOptions options2;
        Boolean share_stats;
        List<MTCircle> circles2;
        String type2;
        MTUserPrivacyOptions options3;
        Boolean share_friend_code;
        MTUserPrivacyOptions options4;
        Boolean share_games2;
        MTUserPrivacyOptions options5;
        Boolean share_stats2;
        List<MTCircle> circles3;
        String type3;
        TextView textView;
        View view = this.rootView;
        if (view != null && (textView = (TextView) view.findViewById(R.id.titleTextView)) != null) {
            textView.setText(getString(R.string.privacy_settings_title_generic, getEntityTitleForm()));
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.privacyContext.ordinal()];
        String str = MTApiKt.PRIVACY_TYPE_UNLISTED;
        if (i != 1) {
            boolean zBooleanValue = false;
            if (i == 2) {
                MTDeckPrivacy mTDeckPrivacy = this.currentDeckPrivacy;
                if (mTDeckPrivacy != null && (type2 = mTDeckPrivacy.getType()) != null) {
                    str = type2;
                }
                this.selectedType = str;
                MTDeckPrivacy mTDeckPrivacy2 = this.currentDeckPrivacy;
                if (mTDeckPrivacy2 != null && (circles2 = mTDeckPrivacy2.getCircles()) != null) {
                    Iterator<T> it = circles2.iterator();
                    while (it.hasNext()) {
                        this.selectedCircleIds.add(Integer.valueOf(((MTCircle) it.next()).getId()));
                    }
                }
                MTDeckPrivacy mTDeckPrivacy3 = this.currentDeckPrivacy;
                this.shareStats = (mTDeckPrivacy3 == null || (options2 = mTDeckPrivacy3.getOptions()) == null || (share_stats = options2.getShare_stats()) == null) ? false : share_stats.booleanValue();
                MTDeckPrivacy mTDeckPrivacy4 = this.currentDeckPrivacy;
                if (mTDeckPrivacy4 != null && (options = mTDeckPrivacy4.getOptions()) != null && (share_games = options.getShare_games()) != null) {
                    zBooleanValue = share_games.booleanValue();
                }
                this.shareGames = zBooleanValue;
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                MTUserPrivacy mTUserPrivacy = this.currentUserPrivacy;
                if (mTUserPrivacy != null && (type3 = mTUserPrivacy.getType()) != null) {
                    str = type3;
                }
                this.selectedType = str;
                MTUserPrivacy mTUserPrivacy2 = this.currentUserPrivacy;
                if (mTUserPrivacy2 != null && (circles3 = mTUserPrivacy2.getCircles()) != null) {
                    Iterator<T> it2 = circles3.iterator();
                    while (it2.hasNext()) {
                        this.selectedCircleIds.add(Integer.valueOf(((MTCircle) it2.next()).getId()));
                    }
                }
                MTUserPrivacy mTUserPrivacy3 = this.currentUserPrivacy;
                this.profileShareStats = (mTUserPrivacy3 == null || (options5 = mTUserPrivacy3.getOptions()) == null || (share_stats2 = options5.getShare_stats()) == null) ? false : share_stats2.booleanValue();
                MTUserPrivacy mTUserPrivacy4 = this.currentUserPrivacy;
                this.profileShareGames = (mTUserPrivacy4 == null || (options4 = mTUserPrivacy4.getOptions()) == null || (share_games2 = options4.getShare_games()) == null) ? false : share_games2.booleanValue();
                MTUserPrivacy mTUserPrivacy5 = this.currentUserPrivacy;
                if (mTUserPrivacy5 != null && (options3 = mTUserPrivacy5.getOptions()) != null && (share_friend_code = options3.getShare_friend_code()) != null) {
                    zBooleanValue = share_friend_code.booleanValue();
                }
                this.profileShareFriendCode = zBooleanValue;
            }
        } else {
            MTContainerPrivacy mTContainerPrivacy = this.currentPrivacy;
            if (mTContainerPrivacy != null && (type = mTContainerPrivacy.getType()) != null) {
                str = type;
            }
            this.selectedType = str;
            MTContainerPrivacy mTContainerPrivacy2 = this.currentPrivacy;
            if (mTContainerPrivacy2 != null && (circles = mTContainerPrivacy2.getCircles()) != null) {
                Iterator<T> it3 = circles.iterator();
                while (it3.hasNext()) {
                    this.selectedCircleIds.add(Integer.valueOf(((MTCircle) it3.next()).getId()));
                }
            }
        }
        updateSelectorAppearance();
        updateCirclesSectionVisibility();
    }

    private final void setupProfileOptions() {
        View view = this.rootView;
        if (view == null) {
            return;
        }
        if (this.privacyContext != PrivacyContext.PROFILE) {
            View viewFindViewById = view.findViewById(R.id.profileOptionsSection);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            View viewFindViewById2 = view.findViewById(R.id.profileOptionsSeparator);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(8);
                return;
            }
            return;
        }
        SwitchCompat switchCompat = (SwitchCompat) view.findViewById(R.id.shareProfileStatsSwitch);
        if (switchCompat != null) {
            switchCompat.setChecked(this.profileShareStats);
            switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    PrivacySettingsDialogFragment.setupProfileOptions$lambda$0$0(this.f$0, compoundButton, z);
                }
            });
        }
        SwitchCompat switchCompat2 = (SwitchCompat) view.findViewById(R.id.shareProfileGamesSwitch);
        if (switchCompat2 != null) {
            switchCompat2.setChecked(this.profileShareGames);
            switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment$$ExternalSyntheticLambda6
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    PrivacySettingsDialogFragment.setupProfileOptions$lambda$1$0(this.f$0, compoundButton, z);
                }
            });
        }
        SwitchCompat switchCompat3 = (SwitchCompat) view.findViewById(R.id.shareProfileFriendCodeSwitch);
        if (switchCompat3 != null) {
            switchCompat3.setChecked(this.profileShareFriendCode);
            switchCompat3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment$$ExternalSyntheticLambda7
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    PrivacySettingsDialogFragment.setupProfileOptions$lambda$2$0(this.f$0, compoundButton, z);
                }
            });
        }
        updateProfileOptionsSectionVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupProfileOptions$lambda$0$0(PrivacySettingsDialogFragment privacySettingsDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        privacySettingsDialogFragment.profileShareStats = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupProfileOptions$lambda$1$0(PrivacySettingsDialogFragment privacySettingsDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        privacySettingsDialogFragment.profileShareGames = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupProfileOptions$lambda$2$0(PrivacySettingsDialogFragment privacySettingsDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        privacySettingsDialogFragment.profileShareFriendCode = z;
    }

    private final void updateCircleRowBackground(LinearLayout row, boolean isChecked) {
        row.setBackgroundResource(isChecked ? R.drawable.black_box_with_orange_line_small : R.drawable.black_box_with_larger_line);
    }

    private final void updateCirclesSectionVisibility() {
        boolean zAreEqual = Intrinsics.areEqual(this.selectedType, MTApiKt.PRIVACY_TYPE_SHARED);
        LinearLayout linearLayout = this.circlesSection;
        View view = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("circlesSection");
            linearLayout = null;
        }
        linearLayout.setVisibility(zAreEqual ? 0 : 8);
        View view2 = this.circlesSeparator;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("circlesSeparator");
        } else {
            view = view2;
        }
        view.setVisibility(zAreEqual ? 0 : 8);
        updateDeckOptionsSectionVisibility();
        updateProfileOptionsSectionVisibility();
    }

    private final void updateDeckOptionsSectionVisibility() {
        View view;
        if (this.privacyContext == PrivacyContext.DECK && (view = this.rootView) != null) {
            boolean zAreEqual = Intrinsics.areEqual(this.selectedType, MTApiKt.PRIVACY_TYPE_PRIVATE);
            View viewFindViewById = view.findViewById(R.id.deckOptionsSection);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(zAreEqual ? 8 : 0);
            }
            View viewFindViewById2 = view.findViewById(R.id.deckOptionsSeparator);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(zAreEqual ? 8 : 0);
            }
        }
    }

    private final void updateProfileOptionsSectionVisibility() {
        View view;
        if (this.privacyContext == PrivacyContext.PROFILE && (view = this.rootView) != null) {
            boolean zAreEqual = Intrinsics.areEqual(this.selectedType, MTApiKt.PRIVACY_TYPE_PRIVATE);
            View viewFindViewById = view.findViewById(R.id.profileOptionsSection);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(zAreEqual ? 8 : 0);
            }
            View viewFindViewById2 = view.findViewById(R.id.profileOptionsSeparator);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(zAreEqual ? 8 : 0);
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void updateSelectorAppearance() {
        Triple triple;
        String str = this.selectedType;
        switch (str.hashCode()) {
            case -977423767:
                if (!str.equals(MTApiKt.PRIVACY_TYPE_PUBLIC)) {
                    return;
                } else {
                    triple = new Triple(Integer.valueOf(R.string.privacy_public), Integer.valueOf(R.string.privacy_public_description_generic), Integer.valueOf(R.drawable.privacy_selector_background_public));
                }
                break;
            case -903566235:
                if (!str.equals(MTApiKt.PRIVACY_TYPE_SHARED)) {
                    return;
                } else {
                    triple = new Triple(Integer.valueOf(R.string.privacy_shared), Integer.valueOf(R.string.privacy_shared_description_generic), Integer.valueOf(R.drawable.privacy_selector_background_shared));
                }
                break;
            case -314497661:
                if (!str.equals(MTApiKt.PRIVACY_TYPE_PRIVATE)) {
                    return;
                } else {
                    triple = new Triple(Integer.valueOf(R.string.privacy_private), Integer.valueOf(R.string.privacy_private_description_generic), Integer.valueOf(R.drawable.privacy_selector_background_private));
                }
                break;
            case -216005226:
                if (!str.equals(MTApiKt.PRIVACY_TYPE_UNLISTED)) {
                    return;
                } else {
                    triple = new Triple(Integer.valueOf(R.string.privacy_unlisted), Integer.valueOf(R.string.privacy_unlisted_description_generic), Integer.valueOf(R.drawable.privacy_selector_background_unlisted));
                }
                break;
            default:
                return;
        }
        int iIntValue = ((Number) triple.component1()).intValue();
        int iIntValue2 = ((Number) triple.component2()).intValue();
        int iIntValue3 = ((Number) triple.component3()).intValue();
        TextView textView = this.privacyLabel;
        LinearLayout linearLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyLabel");
            textView = null;
        }
        textView.setText(getString(iIntValue));
        TextView textView2 = this.privacyDescription;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyDescription");
            textView2 = null;
        }
        textView2.setText(getString(iIntValue2, getEntityName(), getEntityPronoun()));
        LinearLayout linearLayout2 = this.privacySelectorContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacySelectorContainer");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setBackgroundResource(iIntValue3);
    }

    @Override // com.studiolaganne.lengendarylens.CreateCircleCallback
    public void onCircleCreated(List<MTCircle> circles) {
        Intrinsics.checkNotNullParameter(circles, "circles");
        this.allCircles = circles;
        populateCircles();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_privacy_settings, container, false);
        this.rootView = viewInflate;
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.rootView = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        final Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        final int i = (int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.95d);
        final int i2 = (int) (((double) getResources().getDisplayMetrics().heightPixels) * 0.9d);
        window.setLayout(i, -2);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView().post(new Runnable() { // from class: com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                PrivacySettingsDialogFragment.onStart$lambda$0$0(window, i2, i);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initializeViews();
        setupInitialState();
        setupClickListeners();
        setupDeckOptions();
        setupProfileOptions();
        loadCircles();
    }
}
