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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
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

/* JADX INFO: compiled from: GameDetailsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\rH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameDetailsActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "Lcom/studiolaganne/lengendarylens/TagClickHandler;", "<init>", "()V", "currentGame", "Lcom/studiolaganne/lengendarylens/MTGame;", "fragmentList", "", "Landroidx/fragment/app/Fragment;", "gameModified", "", "tagClicked", "", ViewHierarchyConstants.TAG_KEY, "Lcom/studiolaganne/lengendarylens/MTTag;", "isEllipsized", "textView", "Landroid/widget/TextView;", "setNoteValue", "text", "", "editTags", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateUI", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameDetailsActivity extends BaseActivity implements TagClickHandler {
    public static final int $stable = 8;
    private MTGame currentGame;
    private List<Fragment> fragmentList = new ArrayList();
    private boolean gameModified;

    private final void editTags() {
        final List<MTTag> listEmptyList;
        List<MTTag> listEmptyList2;
        if (isDestroyed() || isFinishing()) {
            return;
        }
        PreferencesManager preferencesManager = new PreferencesManager(this);
        preferencesManager.getCurrentUser();
        MTGame mTGame = this.currentGame;
        if (mTGame == null || (listEmptyList = mTGame.getTags()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        MTUserTags currentUserTags = preferencesManager.getCurrentUserTags();
        if (currentUserTags == null || (listEmptyList2 = currentUserTags.getGames()) == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        new TagDialogFragment.Builder().setInitialTags(listEmptyList).setUserTags(listEmptyList2).setListener(new TagDialogListener() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$editTags$dialog$1
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
                final GameDetailsActivity gameDetailsActivity = this.this$0;
                List<MTTag> list = listEmptyList;
                MTGame mTGame2 = gameDetailsActivity.currentGame;
                int id = mTGame2 != null ? mTGame2.getId() : -1;
                final ConstraintLayout constraintLayout = (ConstraintLayout) gameDetailsActivity.findViewById(R.id.mtApiOverlay);
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
                MTApiKt.getMtApi().updateTagsForGame(currentUser.getId(), id, mTUpdateTagsBody).enqueue(new Callback<MTTagsResponse>() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$editTags$dialog$1$onTagDialogSaveButton$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTTagsResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        if (gameDetailsActivity.isDestroyed() || gameDetailsActivity.isFinishing()) {
                            return;
                        }
                        Log.d("MTApi", "Error: " + t.getMessage());
                        constraintLayout.setVisibility(8);
                        Toast.makeText(gameDetailsActivity, R.string.error_updating_tags, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTTagsResponse> call, Response<MTTagsResponse> response) {
                        ArrayList arrayList3;
                        String strValueOf;
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (response.isSuccessful()) {
                            if (gameDetailsActivity.isFinishing() || gameDetailsActivity.isDestroyed()) {
                                return;
                            }
                            MTTagsResponse mTTagsResponseBody = response.body();
                            List<MTTag> tags = mTTagsResponseBody != null ? mTTagsResponseBody.getTags() : null;
                            MTGame mTGame3 = gameDetailsActivity.currentGame;
                            if (mTGame3 != null) {
                                mTGame3.setTags(tags);
                            }
                            gameDetailsActivity.gameModified = true;
                            if (tags != null) {
                                PreferencesManager preferencesManager3 = preferencesManager2;
                                GameDetailsActivity gameDetailsActivity2 = gameDetailsActivity;
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
                                View viewFindViewById = gameDetailsActivity2.findViewById(R.id.tagsFlexboxLayout);
                                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                                FlexboxLayout flexboxLayout = (FlexboxLayout) viewFindViewById;
                                View viewFindViewById2 = gameDetailsActivity2.findViewById(R.id.emptyTagIcon);
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
                                        View viewInflate = LayoutInflater.from(gameDetailsActivity2).inflate(R.layout.tag_item, (ViewGroup) null);
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
                                GameDetailsActivity gameDetailsActivity3 = gameDetailsActivity;
                                View viewFindViewById3 = gameDetailsActivity3.findViewById(R.id.tagsFlexboxLayout);
                                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                                View viewFindViewById4 = gameDetailsActivity3.findViewById(R.id.emptyTagIcon);
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

    static final Unit onCreate$lambda$0(GameDetailsActivity gameDetailsActivity) {
        if (gameDetailsActivity.gameModified) {
            String json = new Gson().toJson(gameDetailsActivity.currentGame);
            Intent intent = new Intent();
            intent.putExtra("updatedGame", json);
            gameDetailsActivity.setResult(-1, intent);
        }
        gameDetailsActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$1(GameDetailsActivity gameDetailsActivity) {
        gameDetailsActivity.editTags();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$11(GameDetailsActivity gameDetailsActivity) {
        gameDetailsActivity.editTags();
        return Unit.INSTANCE;
    }

    static final void onCreate$lambda$15(GameDetailsActivity gameDetailsActivity, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setText(i != 0 ? i != 1 ? null : gameDetailsActivity.getString(R.string.game_events_tab) : gameDetailsActivity.getString(R.string.result_tab));
    }

    static final Unit onCreate$lambda$2(TextView textView, GameDetailsActivity gameDetailsActivity) {
        textView.setText(gameDetailsActivity.getResources().getString(R.string.tap_to_add_note));
        textView.setTextColor(ContextCompat.getColor(gameDetailsActivity, R.color.dark_grey));
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$3(final GameDetailsActivity gameDetailsActivity, final EditText editText, LinearLayout linearLayout, LinearLayout linearLayout2) {
        String note;
        MTGame mTGame = gameDetailsActivity.currentGame;
        if (mTGame == null || (note = mTGame.getNote()) == null) {
            note = "";
        }
        editText.setText(note);
        linearLayout.setVisibility(8);
        linearLayout2.setVisibility(0);
        editText.requestFocus();
        editText.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                GameDetailsActivity.onCreate$lambda$3$0(this.f$0, editText);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3$0(GameDetailsActivity gameDetailsActivity, EditText editText) {
        Object systemService = gameDetailsActivity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
    }

    static final Unit onCreate$lambda$4(final GameDetailsActivity gameDetailsActivity, final EditText editText, LinearLayout linearLayout, LinearLayout linearLayout2) {
        String note;
        MTGame mTGame = gameDetailsActivity.currentGame;
        if (mTGame == null || (note = mTGame.getNote()) == null) {
            note = "";
        }
        editText.setText(note);
        linearLayout.setVisibility(8);
        linearLayout2.setVisibility(0);
        editText.requestFocus();
        editText.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GameDetailsActivity.onCreate$lambda$4$0(this.f$0, editText);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4$0(GameDetailsActivity gameDetailsActivity, EditText editText) {
        Object systemService = gameDetailsActivity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
    }

    static final Unit onCreate$lambda$5(LinearLayout linearLayout, LinearLayout linearLayout2, GameDetailsActivity gameDetailsActivity, EditText editText) {
        linearLayout.setVisibility(0);
        linearLayout2.setVisibility(8);
        Object systemService = gameDetailsActivity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$6(TextView textView, ConstraintLayout constraintLayout) {
        textView.setMaxLines(Integer.MAX_VALUE);
        textView.setEllipsize(null);
        constraintLayout.setVisibility(8);
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$7(final GameDetailsActivity gameDetailsActivity, final TextView textView, final LinearLayout linearLayout, final LinearLayout linearLayout2, final ConstraintLayout constraintLayout, final ConstraintLayout constraintLayout2) {
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = gameDetailsActivity.getResources().getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = gameDetailsActivity.getResources().getString(R.string.delete_note_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = gameDetailsActivity.getResources().getString(R.string.delete);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameDetailsActivity.onCreate$lambda$7$0(this.f$0, textView, linearLayout, linearLayout2, constraintLayout, constraintLayout2, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = gameDetailsActivity.getResources().getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameDetailsActivity.onCreate$lambda$7$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager = gameDetailsActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        negativeButton.show(supportFragmentManager, "CustomDialogFragment");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$7$0(GameDetailsActivity gameDetailsActivity, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        MTUser currentUser = new PreferencesManager(gameDetailsActivity).getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout3 = (ConstraintLayout) gameDetailsActivity.findViewById(R.id.mtApiOverlay);
            constraintLayout3.setVisibility(0);
            MTApi mtApi = MTApiKt.getMtApi();
            int id = currentUser.getId();
            MTGame mTGame = gameDetailsActivity.currentGame;
            mtApi.deleteNoteForGame(id, mTGame != null ? mTGame.getId() : -1).enqueue(new GameDetailsActivity$onCreate$8$1$1$1(gameDetailsActivity, textView, linearLayout, linearLayout2, constraintLayout, constraintLayout2, constraintLayout3));
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$7$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$8(final EditText editText, final LinearLayout linearLayout, final LinearLayout linearLayout2, final GameDetailsActivity gameDetailsActivity) {
        final String string = editText.getText().toString();
        if (string.length() == 0) {
            linearLayout.setVisibility(0);
            linearLayout2.setVisibility(8);
            Object systemService = gameDetailsActivity.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
            return Unit.INSTANCE;
        }
        final ConstraintLayout constraintLayout = (ConstraintLayout) gameDetailsActivity.findViewById(R.id.mtApiOverlay);
        constraintLayout.setVisibility(0);
        MTUser currentUser = new PreferencesManager(gameDetailsActivity).getCurrentUser();
        if (currentUser != null) {
            MTGame mTGame = gameDetailsActivity.currentGame;
            int id = mTGame != null ? mTGame.getId() : -1;
            MTNoteBody mTNoteBody = new MTNoteBody(null, 1, null);
            mTNoteBody.setContent(string);
            MTGame mTGame2 = gameDetailsActivity.currentGame;
            if ((mTGame2 != null ? mTGame2.getNote() : null) != null) {
                MTApiKt.getMtApi().editNoteForGame(currentUser.getId(), id, mTNoteBody).enqueue(new Callback<MTSuccessResponse>() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$onCreate$9$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTSuccessResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        if (gameDetailsActivity.isDestroyed() || gameDetailsActivity.isFinishing()) {
                            return;
                        }
                        Log.d("MTApi", "Error: " + t.getMessage());
                        constraintLayout.setVisibility(8);
                        linearLayout.setVisibility(0);
                        linearLayout2.setVisibility(8);
                        Object systemService2 = gameDetailsActivity.getSystemService("input_method");
                        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                        ((InputMethodManager) systemService2).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                        Toast.makeText(gameDetailsActivity, R.string.error_saving_note, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTSuccessResponse> call, Response<MTSuccessResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (response.isSuccessful()) {
                            linearLayout.setVisibility(0);
                            linearLayout2.setVisibility(8);
                            gameDetailsActivity.setNoteValue(string);
                        }
                        constraintLayout.setVisibility(8);
                        Object systemService2 = gameDetailsActivity.getSystemService("input_method");
                        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                        ((InputMethodManager) systemService2).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                    }
                });
            } else {
                MTApiKt.getMtApi().addNoteToGame(currentUser.getId(), id, mTNoteBody).enqueue(new Callback<MTSuccessResponse>() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$onCreate$9$1$2
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTSuccessResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        if (gameDetailsActivity.isDestroyed() || gameDetailsActivity.isFinishing()) {
                            return;
                        }
                        Log.d("MTApi", "Error: " + t.getMessage());
                        constraintLayout.setVisibility(8);
                        linearLayout.setVisibility(0);
                        linearLayout2.setVisibility(8);
                        Object systemService2 = gameDetailsActivity.getSystemService("input_method");
                        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                        ((InputMethodManager) systemService2).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                        Toast.makeText(gameDetailsActivity, R.string.error_saving_note, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTSuccessResponse> call, Response<MTSuccessResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (response.isSuccessful()) {
                            linearLayout.setVisibility(0);
                            linearLayout2.setVisibility(8);
                            gameDetailsActivity.setNoteValue(string);
                        }
                        constraintLayout.setVisibility(8);
                        Object systemService2 = gameDetailsActivity.getSystemService("input_method");
                        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                        ((InputMethodManager) systemService2).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$9(GameDetailsActivity gameDetailsActivity) {
        gameDetailsActivity.editTags();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setNoteValue(String text) {
        MTGame mTGame = this.currentGame;
        if (mTGame != null) {
            mTGame.setNote(text);
        }
        this.gameModified = true;
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
        textView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                GameDetailsActivity.setNoteValue$lambda$0(this.f$0, textView, constraintLayout);
            }
        });
    }

    static final void setNoteValue$lambda$0(GameDetailsActivity gameDetailsActivity, TextView textView, ConstraintLayout constraintLayout) {
        if (gameDetailsActivity.isEllipsized(textView)) {
            constraintLayout.setVisibility(0);
        } else {
            constraintLayout.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateUI() {
        MTGame mTGame;
        boolean z;
        int i;
        boolean z2;
        List<MTGamePlayer> players;
        Iterator<T> it;
        if (isDestroyed() || isFinishing() || (mTGame = this.currentGame) == null) {
            return;
        }
        TextView textView = (TextView) findViewById(R.id.gameNameLabel);
        MTGameFormat format = mTGame.getFormat();
        if (format != null) {
            String string = getResources().getString(R.string.game_name_format);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textView.setText(StringsKt.replace$default(string, "{1}", format.getName(), false, 4, (Object) null));
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
            String string2 = getResources().getString(R.string.game_name_format);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            textView.setText(StringsKt.replace$default(string2, "{1}", name, false, 4, (Object) null));
        }
        MTGamePlaygroup playgroup = mTGame.getPlaygroup();
        if (playgroup != null) {
            TextView textView2 = (TextView) findViewById(R.id.gameSummaryLabel);
            String relativeTimestamp = ServerUtils.INSTANCE.getInstance().formatRelativeTimestamp(mTGame.getStarted_at(), this);
            String andFormatTimestamp = ServerUtils.INSTANCE.getInstance().parseAndFormatTimestamp(mTGame.getStarted_at());
            String string3 = getResources().getString(R.string.game_summary_date_time);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(string3, "{1}", relativeTimestamp, false, 4, (Object) null), "{2}", andFormatTimestamp, false, 4, (Object) null);
            String string4 = getResources().getString(R.string.game_summary_start);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            textView2.setText(StringsKt.replace$default(string4, "{1}", playgroup.getName(), false, 4, (Object) null) + " - " + strReplace$default);
        } else {
            TextView textView3 = (TextView) findViewById(R.id.gameSummaryLabel);
            String andFormatTimestamp2 = ServerUtils.INSTANCE.getInstance().parseAndFormatTimestamp(mTGame.getStarted_at());
            String string5 = getResources().getString(R.string.game_summary_start);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            textView3.setText(StringsKt.replace$default(string5, "{1}", andFormatTimestamp2, false, 4, (Object) null));
        }
        ArrayList arrayList = new ArrayList();
        Iterator<MTGamePlayer> it2 = mTGame.getPlayers().iterator();
        while (true) {
            z = true;
            if (!it2.hasNext()) {
                break;
            }
            MTGamePlayer next = it2.next();
            Integer resultid = next.getResultid();
            if (resultid != null && resultid.intValue() == 1) {
                arrayList.add(next);
            }
        }
        int size = arrayList.size();
        TextView textView4 = (TextView) findViewById(R.id.winnersHeaderLabel);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.winnersRecyclerView);
        TextView textView5 = (TextView) findViewById(R.id.winnerNamesLabel);
        if (size > 0) {
            textView4.setVisibility(0);
            recyclerView.setVisibility(0);
            textView5.setVisibility(0);
            recyclerView.setAdapter(new BigGamePlayerAdapter(arrayList));
            GameDetailsActivity gameDetailsActivity = this;
            recyclerView.setLayoutManager(new LinearLayoutManager(gameDetailsActivity, 0, false));
            OverlapDecoration overlapDecoration = new OverlapDecoration(GameUtils.INSTANCE.getInstance().dpToPx(22, gameDetailsActivity));
            int itemDecorationCount = recyclerView.getItemDecorationCount();
            for (int i2 = 0; i2 < itemDecorationCount; i2++) {
                recyclerView.removeItemDecorationAt(0);
            }
            recyclerView.addItemDecoration(overlapDecoration);
            if (size > 1) {
                textView4.setText(getResources().getString(R.string.winners));
            } else {
                textView4.setText(getResources().getString(R.string.winner));
            }
            textView5.setText(CollectionsKt.joinToString$default(arrayList, " & ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameDetailsActivity.updateUI$lambda$0$4((MTGamePlayer) obj);
                }
            }, 30, null));
        } else {
            textView4.setVisibility(8);
            recyclerView.setVisibility(8);
            textView5.setVisibility(8);
        }
        GameDetailsActivity gameDetailsActivity2 = this;
        MTUser currentUser = new PreferencesManager(gameDetailsActivity2).getCurrentUser();
        if (currentUser != null) {
            List<MTGamePlayer> players2 = mTGame.getPlayers();
            if ((players2 instanceof Collection) && players2.isEmpty()) {
                i = 0;
            } else {
                Iterator<T> it3 = players2.iterator();
                i = 0;
                while (it3.hasNext()) {
                    Integer resultid2 = ((MTGamePlayer) it3.next()).getResultid();
                    if ((resultid2 != null && resultid2.intValue() == 3) && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            boolean z3 = i >= 2;
            ArrayList arrayList2 = arrayList;
            if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
                z2 = false;
                players = mTGame.getPlayers();
                if (players instanceof Collection) {
                    it = players.iterator();
                    while (it.hasNext()) {
                    }
                    z = false;
                    TextView textView6 = (TextView) findViewById(R.id.victoryLabel);
                    if (z3) {
                    }
                }
            } else {
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    if (((MTGamePlayer) it4.next()).getId() == currentUser.getId()) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                players = mTGame.getPlayers();
                if ((players instanceof Collection) || !players.isEmpty()) {
                    it = players.iterator();
                    while (it.hasNext()) {
                        if (((MTGamePlayer) it.next()).getId() == currentUser.getId()) {
                            break;
                        }
                    }
                    z = false;
                    TextView textView62 = (TextView) findViewById(R.id.victoryLabel);
                    if (z3) {
                        textView62.setText(getResources().getString(R.string.draw));
                        textView62.setBackgroundResource(R.drawable.orange_box);
                        textView62.setTextColor(ContextCompat.getColor(gameDetailsActivity2, R.color.almost_white));
                        textView62.setVisibility(0);
                    } else if (z2) {
                        textView62.setText(getResources().getString(R.string.victory));
                        textView62.setBackgroundResource(R.drawable.green_box);
                        textView62.setTextColor(ContextCompat.getColor(gameDetailsActivity2, R.color.almost_black));
                        textView62.setVisibility(0);
                    } else if (z) {
                        textView62.setText(getResources().getString(R.string.defeat));
                        textView62.setBackgroundResource(R.drawable.red_box);
                        textView62.setTextColor(ContextCompat.getColor(gameDetailsActivity2, R.color.almost_white));
                        textView62.setVisibility(0);
                    } else {
                        textView62.setVisibility(4);
                    }
                } else {
                    z = false;
                    TextView textView622 = (TextView) findViewById(R.id.victoryLabel);
                    if (z3) {
                    }
                }
            }
        }
        TextView textView7 = (TextView) findViewById(R.id.durationLabel);
        ServerUtils companion = ServerUtils.INSTANCE.getInstance();
        String started_at = mTGame.getStarted_at();
        String ended_at = mTGame.getEnded_at();
        Integer pausetime = mTGame.getPausetime();
        textView7.setText(ServerUtils.formatDuration$default(companion, gameDetailsActivity2, started_at, ended_at, pausetime != null ? pausetime.intValue() : 0, false, 16, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence updateUI$lambda$0$4(MTGamePlayer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getFirstname();
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        List<MTTag> tags;
        String strValueOf;
        String note;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);
        String stringExtra = getIntent().getStringExtra("gameJson");
        if (stringExtra != null) {
            this.currentGame = (MTGame) new Gson().fromJson(stringExtra, MTGame.class);
        }
        View viewFindViewById = findViewById(R.id.backLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameDetailsActivity.onCreate$lambda$0(this.f$0);
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$onCreate$callback$1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (this.this$0.gameModified) {
                    String json = new Gson().toJson(this.this$0.currentGame);
                    Intent intent = new Intent();
                    intent.putExtra("updatedGame", json);
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
        MTGame mTGame = this.currentGame;
        if (mTGame == null || (note = mTGame.getNote()) == null) {
            new Function0() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameDetailsActivity.onCreate$lambda$2(textView, this);
                }
            };
        } else {
            setNoteValue(note);
        }
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameDetailsActivity.onCreate$lambda$3(this.f$0, editText, linearLayout2, linearLayout);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameDetailsActivity.onCreate$lambda$4(this.f$0, editText, linearLayout2, linearLayout);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameDetailsActivity.onCreate$lambda$5(linearLayout2, linearLayout, this, editText);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameDetailsActivity.onCreate$lambda$6(textView, constraintLayout);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameDetailsActivity.onCreate$lambda$7(this.f$0, textView, linearLayout2, linearLayout, constraintLayout2, constraintLayout);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameDetailsActivity.onCreate$lambda$8(editText, linearLayout2, linearLayout, this);
            }
        });
        View viewFindViewById11 = findViewById(R.id.tagsFlexboxLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        FlexboxLayout flexboxLayout = (FlexboxLayout) viewFindViewById11;
        ViewExtensionsKt.setOnClickWithFade(flexboxLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameDetailsActivity.onCreate$lambda$9(this.f$0);
            }
        });
        flexboxLayout.setVisibility(4);
        MTGame mTGame2 = this.currentGame;
        if (mTGame2 != null && (tags = mTGame2.getTags()) != null && !tags.isEmpty()) {
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
                ViewExtensionsKt.setOnClickWithFade(viewInflate, new Function0() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GameDetailsActivity.onCreate$lambda$10$1(this.f$0);
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
        ViewExtensionsKt.setOnClickWithFade((LinearLayout) viewFindViewById13, new Function0() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameDetailsActivity.onCreate$lambda$11(this.f$0);
            }
        });
        updateUI();
        Bundle bundle = new Bundle();
        bundle.putString("gameJson", stringExtra);
        GameResultFragment gameResultFragment = new GameResultFragment();
        gameResultFragment.setArguments(bundle);
        Unit unit = Unit.INSTANCE;
        GameEventsFragment gameEventsFragment = new GameEventsFragment();
        gameEventsFragment.setArguments(bundle);
        Unit unit2 = Unit.INSTANCE;
        this.fragmentList = CollectionsKt.mutableListOf(gameResultFragment, gameEventsFragment);
        View viewFindViewById14 = findViewById(R.id.tabs);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        View viewFindViewById15 = findViewById(R.id.view_pager);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        ViewPager2 viewPager2 = (ViewPager2) viewFindViewById15;
        viewPager2.setAdapter(new FragmentStateAdapter() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity.onCreate.15
            {
                super(GameDetailsActivity.this);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            public Fragment createFragment(int position) {
                return position != 0 ? position != 1 ? new Fragment() : (Fragment) GameDetailsActivity.this.fragmentList.get(1) : (Fragment) GameDetailsActivity.this.fragmentList.get(0);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return GameDetailsActivity.this.fragmentList.size();
            }
        });
        new TabLayoutMediator((TabLayout) viewFindViewById14, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$$ExternalSyntheticLambda11
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                GameDetailsActivity.onCreate$lambda$15(this.f$0, tab, i);
            }
        }).attach();
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        MTGame mTGame3 = this.currentGame;
        int id = mTGame3 != null ? mTGame3.getId() : -1;
        if (currentUser != null) {
            MTApiKt.getMtApi().getGameById(currentUser.getId(), id).enqueue(new Callback<MTCreateGameResponse>() { // from class: com.studiolaganne.lengendarylens.GameDetailsActivity$onCreate$17$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCreateGameResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.isDestroyed() || this.this$0.isFinishing()) {
                        return;
                    }
                    Log.d("MTApi", "Error: " + t.getMessage());
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCreateGameResponse> call, Response<MTCreateGameResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (response.isSuccessful()) {
                        MTCreateGameResponse mTCreateGameResponseBody = response.body();
                        MTCreateGame game = mTCreateGameResponseBody != null ? mTCreateGameResponseBody.getGame() : null;
                        if (game != null) {
                            for (Fragment fragment : this.this$0.fragmentList) {
                                GameEventsFragment gameEventsFragment2 = fragment instanceof GameEventsFragment ? (GameEventsFragment) fragment : null;
                                if (gameEventsFragment2 != null) {
                                    gameEventsFragment2.setCurrentGame(game);
                                    gameEventsFragment2.updateUI();
                                }
                                GameResultFragment gameResultFragment2 = fragment instanceof GameResultFragment ? (GameResultFragment) fragment : null;
                                if (gameResultFragment2 != null) {
                                    gameResultFragment2.setCurrentGame(game);
                                    gameResultFragment2.updateUI();
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.studiolaganne.lengendarylens.TagClickHandler
    public void tagClicked(MTTag tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        editTags();
    }
}
