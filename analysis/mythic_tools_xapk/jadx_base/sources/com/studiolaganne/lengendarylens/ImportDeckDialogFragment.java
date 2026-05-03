package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: ImportDeckDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u0000 <2\u00020\u0001:\u0002;<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0016J&\u0010\"\u001a\u0004\u0018\u00010\u001a2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020!H\u0002J\b\u0010,\u001a\u00020!H\u0002J\b\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020!H\u0002J\b\u0010/\u001a\u00020!H\u0002J\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\tH\u0002J\b\u00103\u001a\u00020!H\u0002J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\u0007H\u0002J\u0010\u00106\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0002J\b\u00107\u001a\u00020!H\u0002J\b\u00108\u001a\u00020!H\u0002J\u0010\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/studiolaganne/lengendarylens/ImportDeckDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/ImportDeckDialogListener;", "selectedFileUri", "Landroid/net/Uri;", "selectedFileName", "", "txtParser", "Lcom/studiolaganne/lengendarylens/DeckListTxtParser;", "tabLayout", "Landroid/widget/TabHost;", "txtInput", "Landroid/widget/EditText;", "urlInput", "moxfieldIssueTextView", "Landroid/widget/TextView;", "fileSelectionArea", "Landroidx/constraintlayout/widget/ConstraintLayout;", "selectedFileNameTextView", "selectFilePrompt", "replaceAllCheckbox", "Landroid/widget/CheckBox;", "importButton", "Landroid/view/View;", "cancelButton", "getContent", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onStart", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initializeViews", ViewHierarchyConstants.VIEW_KEY, "setupTabs", "setupFileSelection", "setupButtons", "setupTextInput", "setupUrlInput", "isValidDeckUrl", "", "url", "openFilePicker", "updateSelectedFileUI", "uri", "getFileNameFromUri", "updateImportButtonState", "handleImport", "showError", "errorMessage", "Builder", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImportDeckDialogFragment extends DialogFragment {
    public static final String TAG = "ImportDeckDialogFragment";
    private View cancelButton;
    private ConstraintLayout fileSelectionArea;
    private final ActivityResultLauncher<Intent> getContent;
    private View importButton;
    private ImportDeckDialogListener listener;
    private TextView moxfieldIssueTextView;
    private CheckBox replaceAllCheckbox;
    private TextView selectFilePrompt;
    private String selectedFileName;
    private TextView selectedFileNameTextView;
    private Uri selectedFileUri;
    private TabHost tabLayout;
    private EditText txtInput;
    private final DeckListTxtParser txtParser = new DeckListTxtParser();
    private EditText urlInput;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ImportDeckDialogFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/studiolaganne/lengendarylens/ImportDeckDialogFragment$Builder;", "", "<init>", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/ImportDeckDialogListener;", InAppPurchaseConstants.METHOD_SET_LISTENER, "build", "Lcom/studiolaganne/lengendarylens/ImportDeckDialogFragment;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private ImportDeckDialogListener listener;

        public final ImportDeckDialogFragment build() {
            ImportDeckDialogFragment importDeckDialogFragment = new ImportDeckDialogFragment();
            importDeckDialogFragment.listener = this.listener;
            return importDeckDialogFragment;
        }

        public final Builder setListener(ImportDeckDialogListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    public ImportDeckDialogFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.ImportDeckDialogFragment$$ExternalSyntheticLambda3
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ImportDeckDialogFragment.getContent$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.getContent = activityResultLauncherRegisterForActivityResult;
    }

    static final void getContent$lambda$0(ImportDeckDialogFragment importDeckDialogFragment, ActivityResult result) {
        Intent data;
        Uri data2;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() != -1 || (data = result.getData()) == null || (data2 = data.getData()) == null) {
            return;
        }
        importDeckDialogFragment.selectedFileUri = data2;
        importDeckDialogFragment.updateSelectedFileUI(data2);
    }

    private final String getFileNameFromUri(Uri uri) {
        int columnIndex;
        Cursor cursorQuery = requireContext().getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery != null) {
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst() && (columnIndex = cursor2.getColumnIndex("_display_name")) != -1) {
                    String string = cursor2.getString(columnIndex);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    CloseableKt.closeFinally(cursor, null);
                    return string;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursor, th);
                    throw th2;
                }
            }
        }
        String lastPathSegment = uri.getLastPathSegment();
        return lastPathSegment == null ? "unknown.txt" : lastPathSegment;
    }

    private final void handleImport() {
        CheckBox checkBox = this.replaceAllCheckbox;
        EditText editText = null;
        if (checkBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("replaceAllCheckbox");
            checkBox = null;
        }
        boolean zIsChecked = checkBox.isChecked();
        TabHost tabHost = this.tabLayout;
        if (tabHost == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost = null;
        }
        int currentTab = tabHost.getCurrentTab();
        if (currentTab == 0) {
            EditText editText2 = this.txtInput;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("txtInput");
            } else {
                editText = editText2;
            }
            String string = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
            if (string.length() > 0) {
                DeckImportResult deckImportResult = new DeckImportResult(null, this.txtParser.parseText(string), null, null, zIsChecked, null, 45, null);
                ImportDeckDialogListener importDeckDialogListener = this.listener;
                if (importDeckDialogListener != null) {
                    importDeckDialogListener.onImportDeck(deckImportResult);
                }
                dismiss();
                return;
            }
            return;
        }
        if (currentTab != 1) {
            if (currentTab != 2) {
                return;
            }
            EditText editText3 = this.urlInput;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("urlInput");
            } else {
                editText = editText3;
            }
            String string2 = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
            if (!isValidDeckUrl(string2)) {
                String string3 = getString(R.string.invalid_url);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                showError(string3);
                return;
            } else {
                DeckImportResult deckImportResult2 = new DeckImportResult(null, null, null, null, zIsChecked, string2, 15, null);
                ImportDeckDialogListener importDeckDialogListener2 = this.listener;
                if (importDeckDialogListener2 != null) {
                    importDeckDialogListener2.onImportDeck(deckImportResult2);
                }
                dismiss();
                return;
            }
        }
        Uri uri = this.selectedFileUri;
        if (uri == null) {
            String string4 = getString(R.string.no_file_selected);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            showError(string4);
            return;
        }
        try {
            InputStream inputStreamOpenInputStream = requireContext().getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                String string5 = getString(R.string.error_reading_file);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                showError(string5);
            } else {
                DeckImportResult deckImportResult3 = new DeckImportResult(null, null, inputStreamOpenInputStream, this.selectedFileName, zIsChecked, null, 35, null);
                ImportDeckDialogListener importDeckDialogListener3 = this.listener;
                if (importDeckDialogListener3 != null) {
                    importDeckDialogListener3.onImportDeck(deckImportResult3);
                }
                dismiss();
            }
        } catch (Exception e) {
            showError(getString(R.string.error_reading_file) + ": " + e.getMessage());
        }
    }

    private final void initializeViews(View view) {
        View viewFindViewById = view.findViewById(R.id.tabHost);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.tabLayout = (TabHost) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.txtInput);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.txtInput = (EditText) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.urlInput);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.urlInput = (EditText) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.moxfieldIssueTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.moxfieldIssueTextView = (TextView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.fileSelectionArea);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.fileSelectionArea = (ConstraintLayout) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.selectedFileNameTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.selectedFileNameTextView = (TextView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.selectFilePrompt);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.selectFilePrompt = (TextView) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.replaceAllCheckbox);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.replaceAllCheckbox = (CheckBox) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.importButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.importButton = viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.cancelButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.cancelButton = viewFindViewById10;
    }

    private final boolean isValidDeckUrl(String url) {
        String str = url;
        if (str != null && !StringsKt.isBlank(str)) {
            try {
                String host = Uri.parse(url).getHost();
                if (host == null) {
                    return false;
                }
                List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{"moxfield.com", "archidekt.com", "manabox.com", "manabox.app"});
                if ((listListOf instanceof Collection) && listListOf.isEmpty()) {
                    return false;
                }
                for (String str2 : listListOf) {
                    if (StringsKt.equals(host, str2, true) || StringsKt.endsWith(host, "." + str2, true)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private final void openFilePicker() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        this.getContent.launch(intent);
    }

    private final void setupButtons() {
        View view = this.cancelButton;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
            view = null;
        }
        ViewExtensionsKt.setOnClickWithFade(view, new Function0() { // from class: com.studiolaganne.lengendarylens.ImportDeckDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImportDeckDialogFragment.setupButtons$lambda$0(this.f$0);
            }
        });
        View view3 = this.importButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("importButton");
        } else {
            view2 = view3;
        }
        ViewExtensionsKt.setOnClickWithFade(view2, new Function0() { // from class: com.studiolaganne.lengendarylens.ImportDeckDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImportDeckDialogFragment.setupButtons$lambda$1(this.f$0);
            }
        });
    }

    static final Unit setupButtons$lambda$0(ImportDeckDialogFragment importDeckDialogFragment) {
        importDeckDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit setupButtons$lambda$1(ImportDeckDialogFragment importDeckDialogFragment) {
        importDeckDialogFragment.handleImport();
        return Unit.INSTANCE;
    }

    private final void setupFileSelection() {
        ConstraintLayout constraintLayout = this.fileSelectionArea;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileSelectionArea");
            constraintLayout = null;
        }
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ImportDeckDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImportDeckDialogFragment.setupFileSelection$lambda$0(this.f$0);
            }
        });
    }

    static final Unit setupFileSelection$lambda$0(ImportDeckDialogFragment importDeckDialogFragment) {
        importDeckDialogFragment.openFilePicker();
        return Unit.INSTANCE;
    }

    private final void setupTabs() {
        TabHost tabHost = this.tabLayout;
        TabHost tabHost2 = null;
        if (tabHost == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost = null;
        }
        tabHost.setup();
        TabHost tabHost3 = this.tabLayout;
        if (tabHost3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost3 = null;
        }
        TabHost.TabSpec tabSpecNewTabSpec = tabHost3.newTabSpec("txt");
        Intrinsics.checkNotNullExpressionValue(tabSpecNewTabSpec, "newTabSpec(...)");
        tabSpecNewTabSpec.setContent(R.id.txtTabContent);
        tabSpecNewTabSpec.setIndicator(getString(R.string.txt_input_tab));
        TabHost tabHost4 = this.tabLayout;
        if (tabHost4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost4 = null;
        }
        tabHost4.addTab(tabSpecNewTabSpec);
        TabHost tabHost5 = this.tabLayout;
        if (tabHost5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost5 = null;
        }
        TabHost.TabSpec tabSpecNewTabSpec2 = tabHost5.newTabSpec("file");
        Intrinsics.checkNotNullExpressionValue(tabSpecNewTabSpec2, "newTabSpec(...)");
        tabSpecNewTabSpec2.setContent(R.id.fileTabContent);
        tabSpecNewTabSpec2.setIndicator(getString(R.string.file_import_tab));
        TabHost tabHost6 = this.tabLayout;
        if (tabHost6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost6 = null;
        }
        tabHost6.addTab(tabSpecNewTabSpec2);
        TabHost tabHost7 = this.tabLayout;
        if (tabHost7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost7 = null;
        }
        TabHost.TabSpec tabSpecNewTabSpec3 = tabHost7.newTabSpec("url");
        Intrinsics.checkNotNullExpressionValue(tabSpecNewTabSpec3, "newTabSpec(...)");
        tabSpecNewTabSpec3.setContent(R.id.urlTabContent);
        tabSpecNewTabSpec3.setIndicator(getString(R.string.url_import_tab));
        TabHost tabHost8 = this.tabLayout;
        if (tabHost8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost8 = null;
        }
        tabHost8.addTab(tabSpecNewTabSpec3);
        TabHost tabHost9 = this.tabLayout;
        if (tabHost9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        } else {
            tabHost2 = tabHost9;
        }
        tabHost2.setCurrentTab(0);
    }

    private final void setupTextInput() {
        EditText editText = this.txtInput;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("txtInput");
            editText = null;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.ImportDeckDialogFragment.setupTextInput.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ImportDeckDialogFragment.this.updateImportButtonState();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    private final void setupUrlInput() {
        EditText editText = this.urlInput;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("urlInput");
            editText = null;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.ImportDeckDialogFragment.setupUrlInput.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                TextView textView = ImportDeckDialogFragment.this.moxfieldIssueTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("moxfieldIssueTextView");
                    textView = null;
                }
                textView.setVisibility(8);
                ImportDeckDialogFragment.this.updateImportButtonState();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    private final void showError(String errorMessage) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateImportButtonState() {
        EditText editText = this.txtInput;
        View view = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("txtInput");
            editText = null;
        }
        boolean z = false;
        boolean z2 = StringsKt.trim((CharSequence) editText.getText().toString()).toString().length() > 0;
        boolean z3 = this.selectedFileUri != null;
        EditText editText2 = this.urlInput;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("urlInput");
            editText2 = null;
        }
        boolean zIsValidDeckUrl = isValidDeckUrl(StringsKt.trim((CharSequence) editText2.getText().toString()).toString());
        TabHost tabHost = this.tabLayout;
        if (tabHost == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost = null;
        }
        int currentTab = tabHost.getCurrentTab();
        if (currentTab == 0) {
            z = z2;
        } else if (currentTab == 1) {
            z = z3;
        } else if (currentTab == 2) {
            z = zIsValidDeckUrl;
        }
        View view2 = this.importButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("importButton");
            view2 = null;
        }
        view2.setEnabled(z);
        View view3 = this.importButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("importButton");
        } else {
            view = view3;
        }
        view.setAlpha(z ? 1.0f : 0.5f);
    }

    private final void updateSelectedFileUI(Uri uri) {
        TextView textView;
        String fileNameFromUri = getFileNameFromUri(uri);
        this.selectedFileName = fileNameFromUri;
        String lowerCase = StringsKt.substringAfterLast(fileNameFromUri, FilenameUtils.EXTENSION_SEPARATOR, "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (CollectionsKt.listOf((Object[]) new String[]{"txt", "csv", "dek", "xml"}).contains(lowerCase) || lowerCase.length() == 0) {
            TextView textView2 = this.selectedFileNameTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedFileNameTextView");
                textView2 = null;
            }
            textView2.setText(fileNameFromUri);
            TextView textView3 = this.selectedFileNameTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedFileNameTextView");
                textView3 = null;
            }
            textView3.setVisibility(0);
            TextView textView4 = this.selectFilePrompt;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectFilePrompt");
                textView4 = null;
            }
            textView4.setText(getString(R.string.tap_to_change_file));
        } else {
            TextView textView5 = this.selectedFileNameTextView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedFileNameTextView");
                textView5 = null;
            }
            textView5.setText(fileNameFromUri + " (" + getString(R.string.unsupported_file_format) + ")");
            TextView textView6 = this.selectedFileNameTextView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedFileNameTextView");
                textView6 = null;
            }
            textView6.setVisibility(0);
            TextView textView7 = this.selectFilePrompt;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectFilePrompt");
                textView7 = null;
            }
            textView7.setText(getString(R.string.tap_to_change_file));
        }
        ConstraintLayout constraintLayout = this.fileSelectionArea;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileSelectionArea");
            constraintLayout = null;
        }
        constraintLayout.setBackgroundResource(R.drawable.dashed_border_background_selected);
        TextView textView8 = this.selectedFileNameTextView;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedFileNameTextView");
            textView8 = null;
        }
        textView8.setTextColor(getResources().getColor(R.color.selected_color_new, null));
        View view = getView();
        if (view != null && (textView = (TextView) view.findViewById(R.id.selectFileIcon)) != null) {
            textView.setTextColor(getResources().getColor(R.color.selected_color_new, null));
        }
        updateImportButtonState();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.import_deck_dialog, container, false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Intrinsics.checkNotNull(viewInflate);
        initializeViews(viewInflate);
        setupTabs();
        setupFileSelection();
        setupButtons();
        setupTextInput();
        setupUrlInput();
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
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
    }
}
