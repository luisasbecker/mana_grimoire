package com.studiolaganne.lengendarylens;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.TagDialogFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: SetDetailsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0012H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/studiolaganne/lengendarylens/SetDetailsActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "Lcom/studiolaganne/lengendarylens/TagClickHandler;", "Lcom/studiolaganne/lengendarylens/SubgamesClickListener;", "<init>", "()V", "currentGame", "Lcom/studiolaganne/lengendarylens/MTGame;", "currentSet", "Lcom/studiolaganne/lengendarylens/MTSet;", "subgames", "Lcom/studiolaganne/lengendarylens/MTSubgames;", "setModified", "", "gameDetailsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onGameClicked", "", "game", "tagClicked", ViewHierarchyConstants.TAG_KEY, "Lcom/studiolaganne/lengendarylens/MTTag;", "isEllipsized", "textView", "Landroid/widget/TextView;", "setNoteValue", "text", "", "editTags", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateUI", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SetDetailsActivity extends BaseActivity implements TagClickHandler, SubgamesClickListener {
    public static final int $stable = 8;
    private MTGame currentGame;
    private MTSet currentSet;
    private final ActivityResultLauncher<Intent> gameDetailsLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda0
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            SetDetailsActivity.gameDetailsLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });
    private boolean setModified;
    private MTSubgames subgames;

    private final void editTags() {
        final List<MTTag> listEmptyList;
        List<MTTag> listEmptyList2;
        if (isDestroyed() || isFinishing()) {
            return;
        }
        PreferencesManager preferencesManager = new PreferencesManager(this);
        preferencesManager.getCurrentUser();
        MTSet mTSet = this.currentSet;
        if (mTSet == null || (listEmptyList = mTSet.getTags()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        MTUserTags currentUserTags = preferencesManager.getCurrentUserTags();
        if (currentUserTags == null || (listEmptyList2 = currentUserTags.getGames()) == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        new TagDialogFragment.Builder().setInitialTags(listEmptyList).setUserTags(listEmptyList2).setListener(new TagDialogListener() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$editTags$dialog$1
            @Override // com.studiolaganne.lengendarylens.TagDialogListener
            public void onTagDialogSaveButton(List<String> tagsToRemove, List<String> tagsToAdd) {
                final PreferencesManager preferencesManager2;
                MTUser currentUser;
                Object next;
                Intrinsics.checkNotNullParameter(tagsToRemove, "tagsToRemove");
                Intrinsics.checkNotNullParameter(tagsToAdd, "tagsToAdd");
                if ((tagsToRemove.isEmpty() && tagsToAdd.isEmpty()) || (currentUser = (preferencesManager2 = new PreferencesManager(this.this$0)).getCurrentUser()) == null) {
                    return;
                }
                final SetDetailsActivity setDetailsActivity = this.this$0;
                List<MTTag> list = listEmptyList;
                MTSet mTSet2 = setDetailsActivity.currentSet;
                int id = mTSet2 != null ? mTSet2.getId() : -1;
                final ConstraintLayout constraintLayout = (ConstraintLayout) setDetailsActivity.findViewById(R.id.mtApiOverlay);
                constraintLayout.setVisibility(0);
                MTUpdateTagsBody mTUpdateTagsBody = new MTUpdateTagsBody(null, 1, null);
                ArrayList arrayList = new ArrayList();
                for (String str : tagsToRemove) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        String lowerCase = ((MTTag) next).getName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = str.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                            break;
                        }
                    }
                    MTTag mTTag = (MTTag) next;
                    if (mTTag != null) {
                        Integer id2 = mTTag.getId();
                        arrayList.add(Integer.valueOf(id2 != null ? id2.intValue() : -1));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (String str2 : tagsToAdd) {
                    MTTag mTTag2 = new MTTag(null, null, 3, null);
                    mTTag2.setId(null);
                    String lowerCase3 = str2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    mTTag2.setName(lowerCase3);
                    arrayList2.add(mTTag2);
                }
                mTUpdateTagsBody.getTags().setAdd(arrayList2);
                mTUpdateTagsBody.getTags().setRemove(arrayList);
                MTApiKt.getMtApi().updateTagsForSet(currentUser.getId(), id, mTUpdateTagsBody).enqueue(new Callback<MTTagsResponse>() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$editTags$dialog$1$onTagDialogSaveButton$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTTagsResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        Log.d("MTApi", "Error: " + t.getMessage());
                        constraintLayout.setVisibility(8);
                        Toast.makeText(setDetailsActivity, R.string.error_updating_tags, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTTagsResponse> call, Response<MTTagsResponse> response) {
                        ArrayList arrayList3;
                        String strValueOf;
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (response.isSuccessful()) {
                            if (setDetailsActivity.isFinishing() || setDetailsActivity.isDestroyed()) {
                                return;
                            }
                            MTTagsResponse mTTagsResponseBody = response.body();
                            List<MTTag> tags = mTTagsResponseBody != null ? mTTagsResponseBody.getTags() : null;
                            MTSet mTSet3 = setDetailsActivity.currentSet;
                            if (mTSet3 != null) {
                                mTSet3.setTags(tags);
                            }
                            setDetailsActivity.setModified = true;
                            if (tags != null) {
                                PreferencesManager preferencesManager3 = preferencesManager2;
                                SetDetailsActivity setDetailsActivity2 = setDetailsActivity;
                                MTUserTags currentUserTags2 = preferencesManager3.getCurrentUserTags();
                                if (currentUserTags2 == null) {
                                    currentUserTags2 = new MTUserTags(null, 1, null);
                                }
                                List<MTTag> games = currentUserTags2.getGames();
                                if (games == null || (arrayList3 = CollectionsKt.toMutableList((Collection) games)) == null) {
                                    arrayList3 = new ArrayList();
                                }
                                for (MTTag mTTag3 : tags) {
                                    if (!arrayList3.contains(mTTag3)) {
                                        arrayList3.add(mTTag3);
                                    }
                                }
                                currentUserTags2.setGames(arrayList3);
                                preferencesManager3.saveCurrentUserTags(currentUserTags2);
                                View viewFindViewById = setDetailsActivity2.findViewById(R.id.tagsFlexboxLayout);
                                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                                FlexboxLayout flexboxLayout = (FlexboxLayout) viewFindViewById;
                                View viewFindViewById2 = setDetailsActivity2.findViewById(R.id.emptyTagIcon);
                                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                                ImageView imageView = (ImageView) viewFindViewById2;
                                if (tags.isEmpty()) {
                                    flexboxLayout.setVisibility(4);
                                    imageView.setVisibility(0);
                                } else {
                                    imageView.setVisibility(8);
                                    flexboxLayout.setVisibility(0);
                                    flexboxLayout.removeAllViews();
                                    for (MTTag mTTag4 : tags) {
                                        View viewInflate = LayoutInflater.from(setDetailsActivity2).inflate(R.layout.tag_item, (ViewGroup) null);
                                        TextView textView = (TextView) viewInflate.findViewById(R.id.tagName);
                                        String name = mTTag4.getName();
                                        if (name.length() > 0) {
                                            StringBuilder sb = new StringBuilder();
                                            char cCharAt = name.charAt(0);
                                            if (Character.isLowerCase(cCharAt)) {
                                                Locale localeForLanguageTag = Locale.forLanguageTag("en");
                                                Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
                                                strValueOf = CharsKt.titlecase(cCharAt, localeForLanguageTag);
                                            } else {
                                                strValueOf = String.valueOf(cCharAt);
                                            }
                                            StringBuilder sbAppend = sb.append((Object) strValueOf);
                                            String strSubstring = name.substring(1);
                                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                            name = sbAppend.append(strSubstring).toString();
                                        }
                                        textView.setText(name);
                                        flexboxLayout.addView(viewInflate);
                                    }
                                }
                            } else {
                                SetDetailsActivity setDetailsActivity3 = setDetailsActivity;
                                View viewFindViewById3 = setDetailsActivity3.findViewById(R.id.tagsFlexboxLayout);
                                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                                View viewFindViewById4 = setDetailsActivity3.findViewById(R.id.emptyTagIcon);
                                Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                                ((FlexboxLayout) viewFindViewById3).setVisibility(4);
                                ((ImageView) viewFindViewById4).setVisibility(0);
                            }
                        }
                        constraintLayout.setVisibility(8);
                    }
                });
            }
        }).build().show(getSupportFragmentManager(), "tag_dialog");
    }

    static final void gameDetailsLauncher$lambda$0(SetDetailsActivity setDetailsActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        int i = -1;
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            String stringExtra = data != null ? data.getStringExtra("updatedGame") : null;
            if (stringExtra != null) {
                MTGame mTGame = (MTGame) new Gson().fromJson(stringExtra, MTGame.class);
                MTSubgames mTSubgames = setDetailsActivity.subgames;
                if (mTSubgames != null) {
                    Iterator<MTGame> it = mTSubgames.getSubgames().iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (it.next().getId() == mTGame.getId()) {
                            i = i2;
                            break;
                        }
                        i2++;
                    }
                    if (i >= 0) {
                        MTSubgames mTSubgames2 = setDetailsActivity.subgames;
                        if (mTSubgames2 != null) {
                            List<MTGame> subgames = mTSubgames2.getSubgames();
                            Intrinsics.checkNotNull(mTGame);
                            subgames.set(i, mTGame);
                        }
                        SubgamesAdapter subgamesAdapter = new SubgamesAdapter(mTSubgames.getSubgames(), setDetailsActivity);
                        View viewFindViewById = setDetailsActivity.findViewById(R.id.gamesRecyclerView);
                        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                        ((RecyclerView) viewFindViewById).setAdapter(subgamesAdapter);
                    }
                }
            }
        }
    }

    private final boolean isEllipsized(TextView textView) {
        Layout layout = textView.getLayout();
        if (layout == null) {
            return false;
        }
        int maxLines = textView.getMaxLines();
        int lineCount = layout.getLineCount();
        if (lineCount > maxLines) {
            return true;
        }
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    static final Unit onCreate$lambda$1(SetDetailsActivity setDetailsActivity) {
        if (setDetailsActivity.setModified) {
            String json = new Gson().toJson(setDetailsActivity.currentSet);
            Intent intent = new Intent();
            intent.putExtra("updatedSet", json);
            setDetailsActivity.setResult(-1, intent);
        }
        setDetailsActivity.finish();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$10(SetDetailsActivity setDetailsActivity) {
        setDetailsActivity.editTags();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$11$1(SetDetailsActivity setDetailsActivity) {
        setDetailsActivity.editTags();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$12(SetDetailsActivity setDetailsActivity) {
        setDetailsActivity.editTags();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$3(TextView textView, SetDetailsActivity setDetailsActivity) {
        textView.setText(setDetailsActivity.getResources().getString(R.string.tap_to_add_note));
        textView.setTextColor(ContextCompat.getColor(setDetailsActivity, R.color.dark_grey));
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$4(final SetDetailsActivity setDetailsActivity, final EditText editText, LinearLayout linearLayout, LinearLayout linearLayout2) {
        String note;
        MTSet mTSet = setDetailsActivity.currentSet;
        if (mTSet == null || (note = mTSet.getNote()) == null) {
            note = "";
        }
        editText.setText(note);
        linearLayout.setVisibility(8);
        linearLayout2.setVisibility(0);
        editText.requestFocus();
        editText.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                SetDetailsActivity.onCreate$lambda$4$0(this.f$0, editText);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4$0(SetDetailsActivity setDetailsActivity, EditText editText) {
        Object systemService = setDetailsActivity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
    }

    static final Unit onCreate$lambda$5(final SetDetailsActivity setDetailsActivity, final EditText editText, LinearLayout linearLayout, LinearLayout linearLayout2) {
        String note;
        MTSet mTSet = setDetailsActivity.currentSet;
        if (mTSet == null || (note = mTSet.getNote()) == null) {
            note = "";
        }
        editText.setText(note);
        linearLayout.setVisibility(8);
        linearLayout2.setVisibility(0);
        editText.requestFocus();
        editText.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                SetDetailsActivity.onCreate$lambda$5$0(this.f$0, editText);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5$0(SetDetailsActivity setDetailsActivity, EditText editText) {
        Object systemService = setDetailsActivity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
    }

    static final Unit onCreate$lambda$6(LinearLayout linearLayout, LinearLayout linearLayout2, SetDetailsActivity setDetailsActivity, EditText editText) {
        linearLayout.setVisibility(0);
        linearLayout2.setVisibility(8);
        Object systemService = setDetailsActivity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$7(TextView textView, ConstraintLayout constraintLayout) {
        textView.setMaxLines(Integer.MAX_VALUE);
        textView.setEllipsize(null);
        constraintLayout.setVisibility(8);
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$8(final SetDetailsActivity setDetailsActivity, final TextView textView, final LinearLayout linearLayout, final LinearLayout linearLayout2, final ConstraintLayout constraintLayout, final ConstraintLayout constraintLayout2) {
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = setDetailsActivity.getResources().getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = setDetailsActivity.getResources().getString(R.string.delete_note_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = setDetailsActivity.getResources().getString(R.string.delete);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SetDetailsActivity.onCreate$lambda$8$0(this.f$0, textView, linearLayout, linearLayout2, constraintLayout, constraintLayout2, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = setDetailsActivity.getResources().getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SetDetailsActivity.onCreate$lambda$8$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager = setDetailsActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        negativeButton.show(supportFragmentManager, "CustomDialogFragment");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$8$0(SetDetailsActivity setDetailsActivity, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        MTUser currentUser = new PreferencesManager(setDetailsActivity).getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout3 = (ConstraintLayout) setDetailsActivity.findViewById(R.id.mtApiOverlay);
            constraintLayout3.setVisibility(0);
            MTApi mtApi = MTApiKt.getMtApi();
            int id = currentUser.getId();
            MTSet mTSet = setDetailsActivity.currentSet;
            mtApi.deleteNoteForSet(id, mTSet != null ? mTSet.getId() : -1).enqueue(new SetDetailsActivity$onCreate$9$1$1$1(setDetailsActivity, textView, linearLayout, linearLayout2, constraintLayout, constraintLayout2, constraintLayout3));
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$8$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$9(final EditText editText, final LinearLayout linearLayout, final LinearLayout linearLayout2, final SetDetailsActivity setDetailsActivity) {
        final String string = editText.getText().toString();
        if (string.length() == 0) {
            linearLayout.setVisibility(0);
            linearLayout2.setVisibility(8);
            Object systemService = setDetailsActivity.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
            return Unit.INSTANCE;
        }
        final ConstraintLayout constraintLayout = (ConstraintLayout) setDetailsActivity.findViewById(R.id.mtApiOverlay);
        constraintLayout.setVisibility(0);
        MTUser currentUser = new PreferencesManager(setDetailsActivity).getCurrentUser();
        if (currentUser != null) {
            MTSet mTSet = setDetailsActivity.currentSet;
            int id = mTSet != null ? mTSet.getId() : -1;
            MTNoteBody mTNoteBody = new MTNoteBody(null, 1, null);
            mTNoteBody.setContent(string);
            MTSet mTSet2 = setDetailsActivity.currentSet;
            if ((mTSet2 != null ? mTSet2.getNote() : null) != null) {
                MTApiKt.getMtApi().editNoteForSet(currentUser.getId(), id, mTNoteBody).enqueue(new Callback<MTSuccessResponse>() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$onCreate$10$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTSuccessResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        Log.d("MTApi", "Error: " + t.getMessage());
                        constraintLayout.setVisibility(8);
                        linearLayout.setVisibility(0);
                        linearLayout2.setVisibility(8);
                        Object systemService2 = setDetailsActivity.getSystemService("input_method");
                        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                        ((InputMethodManager) systemService2).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                        Toast.makeText(setDetailsActivity, R.string.error_saving_note, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTSuccessResponse> call, Response<MTSuccessResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (response.isSuccessful()) {
                            linearLayout.setVisibility(0);
                            linearLayout2.setVisibility(8);
                            setDetailsActivity.setNoteValue(string);
                        }
                        constraintLayout.setVisibility(8);
                        Object systemService2 = setDetailsActivity.getSystemService("input_method");
                        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                        ((InputMethodManager) systemService2).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                    }
                });
            } else {
                MTApiKt.getMtApi().addNoteToSet(currentUser.getId(), id, mTNoteBody).enqueue(new Callback<MTSuccessResponse>() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$onCreate$10$1$2
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTSuccessResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        Log.d("MTApi", "Error: " + t.getMessage());
                        constraintLayout.setVisibility(8);
                        linearLayout.setVisibility(0);
                        linearLayout2.setVisibility(8);
                        Object systemService2 = setDetailsActivity.getSystemService("input_method");
                        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                        ((InputMethodManager) systemService2).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                        Toast.makeText(setDetailsActivity, R.string.error_saving_note, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTSuccessResponse> call, Response<MTSuccessResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (response.isSuccessful()) {
                            linearLayout.setVisibility(0);
                            linearLayout2.setVisibility(8);
                            setDetailsActivity.setNoteValue(string);
                        }
                        constraintLayout.setVisibility(8);
                        Object systemService2 = setDetailsActivity.getSystemService("input_method");
                        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                        ((InputMethodManager) systemService2).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setNoteValue(String text) {
        MTSet mTSet = this.currentSet;
        if (mTSet != null) {
            mTSet.setNote(text);
        }
        this.setModified = true;
        View viewFindViewById = findViewById(R.id.noteText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final TextView textView = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.arrowLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.deleteNoteLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        textView.setText(text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.text_color));
        ((ConstraintLayout) viewFindViewById3).setVisibility(0);
        textView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                SetDetailsActivity.setNoteValue$lambda$0(this.f$0, textView, constraintLayout);
            }
        });
    }

    static final void setNoteValue$lambda$0(SetDetailsActivity setDetailsActivity, TextView textView, ConstraintLayout constraintLayout) {
        if (setDetailsActivity.isEllipsized(textView)) {
            constraintLayout.setVisibility(0);
        } else {
            constraintLayout.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x046c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateUI() {
        MTGame mTGame;
        String string;
        MTGame mTGame2;
        boolean z;
        boolean z2;
        boolean z3;
        MTGame mTGame3;
        Iterator it;
        int i;
        Integer resultid;
        Integer resultid2;
        if (isDestroyed() || isFinishing() || (mTGame = this.currentGame) == null) {
            return;
        }
        TextView textView = (TextView) findViewById(R.id.gameNameLabel);
        MTSet mTSet = this.currentSet;
        if (mTSet == null) {
            string = "";
        } else if (mTSet.getOutOf() == 5) {
            string = getResources().getString(R.string.match_type_bo5);
            Intrinsics.checkNotNull(string);
        } else {
            string = getResources().getString(R.string.match_type_bo3);
            Intrinsics.checkNotNull(string);
        }
        String str = string;
        MTGameFormat format = mTGame.getFormat();
        if (format != null) {
            String string2 = getResources().getString(R.string.set_name_format);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            textView.setText(StringsKt.replace$default(StringsKt.replace$default(string2, "{1}", str, false, 4, (Object) null), "{2}", format.getName(), false, 4, (Object) null));
        }
        MTGameSubformat subformat = mTGame.getSubformat();
        if (subformat != null && subformat.getId() > 0 && subformat.getName().length() > 0) {
            String name = subformat.getName();
            if (subformat.getId() == 5) {
                name = getResources().getString(R.string.two_headed_giant);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
            }
            if (subformat.getId() == 6) {
                name = getResources().getString(R.string.three_headed_giant);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
            }
            String str2 = name;
            String string3 = getResources().getString(R.string.set_name_format);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            textView.setText(StringsKt.replace$default(StringsKt.replace$default(string3, "{1}", str, false, 4, (Object) null), "{2}", str2, false, 4, (Object) null));
        }
        MTGamePlaygroup playgroup = mTGame.getPlaygroup();
        if (playgroup != null) {
            TextView textView2 = (TextView) findViewById(R.id.gameSummaryLabel);
            String relativeTimestamp = ServerUtils.INSTANCE.getInstance().formatRelativeTimestamp(mTGame.getStarted_at(), this);
            String andFormatTimestamp = ServerUtils.INSTANCE.getInstance().parseAndFormatTimestamp(mTGame.getStarted_at());
            String string4 = getResources().getString(R.string.game_summary_date_time);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(string4, "{1}", relativeTimestamp, false, 4, (Object) null), "{2}", andFormatTimestamp, false, 4, (Object) null);
            String string5 = getResources().getString(R.string.game_summary_start);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            textView2.setText(StringsKt.replace$default(string5, "{1}", playgroup.getName(), false, 4, (Object) null) + " - " + strReplace$default);
        } else {
            TextView textView3 = (TextView) findViewById(R.id.gameSummaryLabel);
            String andFormatTimestamp2 = ServerUtils.INSTANCE.getInstance().parseAndFormatTimestamp(mTGame.getStarted_at());
            String string6 = getResources().getString(R.string.game_summary_start);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            textView3.setText(StringsKt.replace$default(string6, "{1}", andFormatTimestamp2, false, 4, (Object) null));
        }
        View viewFindViewById = findViewById(R.id.player1Label);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextView textView4 = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.player2Label);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView5 = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.player1Score);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        TextView textView6 = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.player2Score);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        TextView textView7 = (TextView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.player1WinnerHeaderLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        TextView textView8 = (TextView) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.player2WinnerHeaderLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        TextView textView9 = (TextView) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.player1RecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.player2RecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        RecyclerView recyclerView2 = (RecyclerView) viewFindViewById8;
        TextView textView10 = (TextView) findViewById(R.id.victoryLabel);
        MTSubgames mTSubgames = this.subgames;
        int iIntValue = 0;
        if (mTSubgames != null) {
            List<MTGame> subgames = mTSubgames.getSubgames();
            MTGamePlayer mTGamePlayer = mTGame.getPlayers().get(0);
            MTGamePlayer mTGamePlayer2 = mTGame.getPlayers().get(1);
            Iterator it2 = subgames.iterator();
            int i2 = 0;
            int i3 = 0;
            while (it2.hasNext()) {
                MTGame mTGame4 = (MTGame) it2.next();
                if (mTGame4.getPlayers().size() == 2) {
                    MTGamePlayer mTGamePlayer3 = mTGame4.getPlayers().get(0);
                    List<MTGamePlayer> players = mTGame4.getPlayers();
                    mTGame3 = mTGame;
                    MTGamePlayer mTGamePlayer4 = players.get(1);
                    Integer resultid3 = mTGamePlayer3.getResultid();
                    it = it2;
                    if ((resultid3 != null && resultid3.intValue() == 1) || ((resultid = mTGamePlayer4.getResultid()) != null && resultid.intValue() == 2)) {
                        i = i2;
                        int i4 = i3;
                        if (mTGamePlayer.getId() == mTGamePlayer3.getId()) {
                            i2 = i + 1;
                            i3 = i4;
                        } else {
                            i3 = i4 + 1;
                            i2 = i;
                        }
                    } else {
                        Integer resultid4 = mTGamePlayer4.getResultid();
                        if ((resultid4 != null && resultid4.intValue() == 1) || ((resultid2 = mTGamePlayer3.getResultid()) != null && resultid2.intValue() == 2)) {
                            if (mTGamePlayer.getId() == mTGamePlayer4.getId()) {
                                i2++;
                            } else {
                                i3++;
                            }
                        }
                    }
                    mTGame = mTGame3;
                    it2 = it;
                } else {
                    mTGame3 = mTGame;
                    it = it2;
                }
                i = i2;
                i3 = i3;
                i2 = i;
                mTGame = mTGame3;
                it2 = it;
            }
            mTGame2 = mTGame;
            int i5 = i2;
            int i6 = i3;
            textView8.setVisibility(4);
            textView9.setVisibility(4);
            boolean z4 = i5 > i6;
            boolean z5 = i5 == i6;
            textView6.setText(String.valueOf(i5));
            textView7.setText(String.valueOf(i6));
            if (z5) {
                SetDetailsActivity setDetailsActivity = this;
                textView4.setTextColor(ContextCompat.getColor(setDetailsActivity, R.color.draw_orange));
                textView5.setTextColor(ContextCompat.getColor(setDetailsActivity, R.color.draw_orange));
                textView7.setTextColor(ContextCompat.getColor(setDetailsActivity, R.color.draw_orange));
                textView6.setTextColor(ContextCompat.getColor(setDetailsActivity, R.color.draw_orange));
                textView8.setVisibility(4);
                textView9.setVisibility(4);
            } else if (z4) {
                SetDetailsActivity setDetailsActivity2 = this;
                textView4.setTextColor(ContextCompat.getColor(setDetailsActivity2, R.color.winner_green));
                textView5.setTextColor(ContextCompat.getColor(setDetailsActivity2, R.color.loser_red));
                textView6.setTextColor(ContextCompat.getColor(setDetailsActivity2, R.color.winner_green));
                textView7.setTextColor(ContextCompat.getColor(setDetailsActivity2, R.color.loser_red));
                textView8.setVisibility(0);
                textView9.setVisibility(4);
            } else {
                SetDetailsActivity setDetailsActivity3 = this;
                textView4.setTextColor(ContextCompat.getColor(setDetailsActivity3, R.color.loser_red));
                textView5.setTextColor(ContextCompat.getColor(setDetailsActivity3, R.color.winner_green));
                textView7.setTextColor(ContextCompat.getColor(setDetailsActivity3, R.color.winner_green));
                textView6.setTextColor(ContextCompat.getColor(setDetailsActivity3, R.color.loser_red));
                textView8.setVisibility(4);
                textView9.setVisibility(0);
            }
            textView4.setText(mTGamePlayer.getFirstname());
            textView5.setText(mTGamePlayer2.getFirstname());
            recyclerView.setAdapter(new MiddleGamePlayerAdapter(CollectionsKt.listOf(mTGamePlayer)));
            SetDetailsActivity setDetailsActivity4 = this;
            recyclerView.setLayoutManager(new LinearLayoutManager(setDetailsActivity4, 0, false));
            recyclerView2.setAdapter(new MiddleGamePlayerAdapter(CollectionsKt.listOf(mTGamePlayer2)));
            recyclerView2.setLayoutManager(new LinearLayoutManager(setDetailsActivity4, 0, false));
            MTUser currentUser = new PreferencesManager(setDetailsActivity4).getCurrentUser();
            if (currentUser != null) {
                Boolean published = mTGame2.getPublished();
                if (published != null) {
                    z = true;
                    z2 = !published.booleanValue();
                } else {
                    z = true;
                    z2 = false;
                }
                boolean z6 = (!(z4 && mTGamePlayer.getId() == currentUser.getId()) && (z4 || mTGamePlayer2.getId() != currentUser.getId())) ? false : z;
                List<MTGamePlayer> players2 = mTGame2.getPlayers();
                if ((players2 instanceof Collection) && players2.isEmpty()) {
                    z3 = false;
                    if (!z2) {
                    }
                } else {
                    Iterator<T> it3 = players2.iterator();
                    while (it3.hasNext()) {
                        if (((MTGamePlayer) it3.next()).getId() == currentUser.getId()) {
                            z3 = z;
                            break;
                        }
                    }
                    z3 = false;
                    if (!z2) {
                        textView10.setText(getResources().getString(R.string.unpublished_caps));
                        textView10.setBackgroundResource(R.drawable.grey_box);
                        textView10.setTextColor(ContextCompat.getColor(setDetailsActivity4, R.color.almost_white));
                        iIntValue = 0;
                        textView10.setVisibility(0);
                    } else if (z5) {
                        textView10.setText(getResources().getString(R.string.draw));
                        textView10.setBackgroundResource(R.drawable.orange_box);
                        textView10.setTextColor(ContextCompat.getColor(setDetailsActivity4, R.color.almost_white));
                        iIntValue = 0;
                        textView10.setVisibility(0);
                    } else if (z6) {
                        textView10.setText(getResources().getString(R.string.victory));
                        textView10.setBackgroundResource(R.drawable.green_box);
                        textView10.setTextColor(ContextCompat.getColor(setDetailsActivity4, R.color.almost_black));
                        iIntValue = 0;
                        textView10.setVisibility(0);
                    } else if (z3) {
                        textView10.setText(getResources().getString(R.string.defeat));
                        textView10.setBackgroundResource(R.drawable.red_box);
                        textView10.setTextColor(ContextCompat.getColor(setDetailsActivity4, R.color.almost_white));
                        iIntValue = 0;
                        textView10.setVisibility(0);
                    } else {
                        iIntValue = 0;
                        textView10.setVisibility(4);
                    }
                }
            } else {
                iIntValue = 0;
            }
        } else {
            mTGame2 = mTGame;
        }
        TextView textView11 = (TextView) findViewById(R.id.durationLabel);
        ServerUtils companion = ServerUtils.INSTANCE.getInstance();
        SetDetailsActivity setDetailsActivity5 = this;
        String started_at = mTGame2.getStarted_at();
        String ended_at = mTGame2.getEnded_at();
        Integer pausetime = mTGame2.getPausetime();
        if (pausetime != null) {
            iIntValue = pausetime.intValue();
        }
        textView11.setText(ServerUtils.formatDuration$default(companion, setDetailsActivity5, started_at, ended_at, iIntValue, false, 16, null));
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        List<MTGame> listEmptyList;
        List<MTTag> tags;
        String strValueOf;
        String note;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_details);
        String stringExtra = getIntent().getStringExtra("setJson");
        if (stringExtra != null) {
            this.currentSet = (MTSet) new Gson().fromJson(stringExtra, MTSet.class);
        }
        String stringExtra2 = getIntent().getStringExtra("subgamesJson");
        if (stringExtra2 != null) {
            MTSubgames mTSubgames = (MTSubgames) new Gson().fromJson(stringExtra2, MTSubgames.class);
            this.subgames = mTSubgames;
            if (mTSubgames != null) {
                this.currentGame = (MTGame) CollectionsKt.firstOrNull((List) mTSubgames.getSubgames());
            }
        }
        View viewFindViewById = findViewById(R.id.backLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SetDetailsActivity.onCreate$lambda$1(this.f$0);
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$onCreate$callback$1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (this.this$0.setModified) {
                    String json = new Gson().toJson(this.this$0.currentSet);
                    Intent intent = new Intent();
                    intent.putExtra("updatedSet", json);
                    this.this$0.setResult(-1, intent);
                }
                this.this$0.finish();
            }
        });
        View viewFindViewById2 = findViewById(R.id.noteText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final TextView textView = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.noteIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.noteEditLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        final LinearLayout linearLayout = (LinearLayout) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.noteEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        final EditText editText = (EditText) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.saveNoteButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        MaterialButton materialButton = (MaterialButton) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.cancelNoteButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        MaterialButton materialButton2 = (MaterialButton) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.arrowLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById8;
        View viewFindViewById9 = findViewById(R.id.deleteNoteLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        final ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById9;
        View viewFindViewById10 = findViewById(R.id.noteContentLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        final LinearLayout linearLayout2 = (LinearLayout) viewFindViewById10;
        constraintLayout.setVisibility(8);
        constraintLayout2.setVisibility(8);
        linearLayout2.setVisibility(0);
        MTSet mTSet = this.currentSet;
        if (mTSet == null || (note = mTSet.getNote()) == null) {
            new Function0() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SetDetailsActivity.onCreate$lambda$3(textView, this);
                }
            };
        } else {
            setNoteValue(note);
        }
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SetDetailsActivity.onCreate$lambda$4(this.f$0, editText, linearLayout2, linearLayout);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SetDetailsActivity.onCreate$lambda$5(this.f$0, editText, linearLayout2, linearLayout);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SetDetailsActivity.onCreate$lambda$6(linearLayout2, linearLayout, this, editText);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SetDetailsActivity.onCreate$lambda$7(textView, constraintLayout);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SetDetailsActivity.onCreate$lambda$8(this.f$0, textView, linearLayout2, linearLayout, constraintLayout2, constraintLayout);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SetDetailsActivity.onCreate$lambda$9(editText, linearLayout2, linearLayout, this);
            }
        });
        View viewFindViewById11 = findViewById(R.id.tagsFlexboxLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        FlexboxLayout flexboxLayout = (FlexboxLayout) viewFindViewById11;
        ViewExtensionsKt.setOnClickWithFade(flexboxLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SetDetailsActivity.onCreate$lambda$10(this.f$0);
            }
        });
        flexboxLayout.setVisibility(4);
        MTSet mTSet2 = this.currentSet;
        if (mTSet2 != null && (tags = mTSet2.getTags()) != null && !tags.isEmpty()) {
            flexboxLayout.removeAllViews();
            for (MTTag mTTag : tags) {
                View viewInflate = LayoutInflater.from(this).inflate(R.layout.tag_item, (ViewGroup) null);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tagName);
                String name = mTTag.getName();
                if (name.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    char cCharAt = name.charAt(0);
                    if (Character.isLowerCase(cCharAt)) {
                        Locale localeForLanguageTag = Locale.forLanguageTag("en");
                        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
                        strValueOf = CharsKt.titlecase(cCharAt, localeForLanguageTag);
                    } else {
                        strValueOf = String.valueOf(cCharAt);
                    }
                    StringBuilder sbAppend = sb.append((Object) strValueOf);
                    String strSubstring = name.substring(1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    name = sbAppend.append(strSubstring).toString();
                }
                textView2.setText(name);
                flexboxLayout.addView(viewInflate);
                Intrinsics.checkNotNull(viewInflate);
                ViewExtensionsKt.setOnClickWithFade(viewInflate, new Function0() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SetDetailsActivity.onCreate$lambda$11$1(this.f$0);
                    }
                });
            }
            View viewFindViewById12 = findViewById(R.id.emptyTagIcon);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
            ((ImageView) viewFindViewById12).setVisibility(8);
            flexboxLayout.setVisibility(0);
        }
        View viewFindViewById13 = findViewById(R.id.tagsLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((LinearLayout) viewFindViewById13, new Function0() { // from class: com.studiolaganne.lengendarylens.SetDetailsActivity$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SetDetailsActivity.onCreate$lambda$12(this.f$0);
            }
        });
        updateUI();
        View viewFindViewById14 = findViewById(R.id.gamesRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById14;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MTSubgames mTSubgames2 = this.subgames;
        if (mTSubgames2 == null || (listEmptyList = mTSubgames2.getSubgames()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        recyclerView.setAdapter(new SubgamesAdapter(listEmptyList, this));
    }

    @Override // com.studiolaganne.lengendarylens.SubgamesClickListener
    public void onGameClicked(MTGame game) {
        Intrinsics.checkNotNullParameter(game, "game");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) GameDetailsActivity.class);
        intent.putExtra("gameJson", new Gson().toJson(game));
        this.gameDetailsLauncher.launch(intent);
    }

    @Override // com.studiolaganne.lengendarylens.TagClickHandler
    public void tagClicked(MTTag tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        editTags();
    }
}
