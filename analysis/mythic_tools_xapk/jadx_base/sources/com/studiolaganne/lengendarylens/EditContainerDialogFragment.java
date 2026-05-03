package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Size;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputLayout;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import com.studiolaganne.lengendarylens.EditContainerDialogFragment;
import com.studiolaganne.lengendarylens.ListColorPickerDialogFragment;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelperLocalized;
import com.vanniktech.ui.ColorKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: EditContainerDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0002\u009e\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0087\u0001\u001a\u00020\u000bH\u0016J\u001c\u0010\u0088\u0001\u001a\u00020\u00072\b\u0010\u0089\u0001\u001a\u00030\u0080\u00012\u0007\u0010\u008a\u0001\u001a\u00020\rH\u0002J\u0019\u0010\u008b\u0001\u001a\u00020\u000b2\u0007\u0010\u008c\u0001\u001a\u00020\rH\u0082@¢\u0006\u0003\u0010\u008d\u0001J\u0013\u0010\u008e\u0001\u001a\u00020\u000b2\b\u0010\u0089\u0001\u001a\u00030\u0080\u0001H\u0002J\u0019\u0010\u008f\u0001\u001a\u00020\u000b2\u0007\u0010\u008c\u0001\u001a\u00020\rH\u0082@¢\u0006\u0003\u0010\u008d\u0001J-\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\t\u0010\u0004\u001a\u0005\u0018\u00010\u0094\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0017J\t\u0010\u0097\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u0098\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u0099\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u009a\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u009b\u0001\u001a\u00020\u000bH\u0002J\u001f\u0010\u009c\u0001\u001a\u00020\u000b2\b\u0010\u009d\u0001\u001a\u00030\u0091\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001c\u0010'\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001c\u0010*\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u001c\u0010-\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R\u001c\u00100\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\u001c\u00103\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\u001c\u00106\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u001e\u00109\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001e\"\u0004\b@\u0010 R\u001e\u0010A\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\bB\u0010;\"\u0004\bC\u0010=R\u001a\u0010D\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\b#\u0010FR\u001a\u0010G\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010E\"\u0004\bH\u0010FR\u001a\u0010I\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010FR\u001a\u0010K\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010E\"\u0004\bL\u0010FR\u001a\u0010M\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010E\"\u0004\bN\u0010FR\u001a\u0010O\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010E\"\u0004\bP\u0010FR\u001a\u0010Q\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u001e\"\u0004\bS\u0010 R\u001a\u0010T\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u001e\"\u0004\bV\u0010 R\u000e\u0010W\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010X\u001a\u0004\u0018\u00010YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u000e\u0010^\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010_\u001a\u0004\u0018\u00010YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010[\"\u0004\ba\u0010]R\u001c\u0010b\u001a\u0004\u0018\u00010cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR \u0010n\u001a\b\u0012\u0004\u0012\u00020i0oX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001c\u0010t\u001a\u0004\u0018\u00010uX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001c\u0010z\u001a\u0004\u0018\u00010uX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010w\"\u0004\b|\u0010yR\u000e\u0010}\u001a\u00020~X\u0082.¢\u0006\u0002\n\u0000R\u0015\u0010\u007f\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0081\u0001\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020~X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0083\u0001\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0084\u0001\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u009f\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/EditContainerDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "container", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "isCollection", "", "onEditClicked", "Lkotlin/Function2;", "Lcom/studiolaganne/lengendarylens/MTEditListBody;", "", "selectedColor", "", "colorExplicitlyCleared", "convertList", "convertDeck", "convertType", "", "faceCard", "Lcom/studiolaganne/lengendarylens/MTSimpleCard;", "selectedDeckId", "Ljava/lang/Integer;", "creatingDeck", "replaceAllCards", "format", "Lcom/studiolaganne/lengendarylens/MTFormat;", "buttonEnabled", "commander", "getCommander", "()Ljava/lang/String;", "setCommander", "(Ljava/lang/String;)V", "partner", "getPartner", "setPartner", "signaturespell", "getSignaturespell", "setSignaturespell", "partnersignaturespell", "getPartnersignaturespell", "setPartnersignaturespell", "commanderCardId", "getCommanderCardId", "setCommanderCardId", "partnerCardId", "getPartnerCardId", "setPartnerCardId", "signatureSpellCardId", "getSignatureSpellCardId", "setSignatureSpellCardId", "partnerSignatureSpellCardId", "getPartnerSignatureSpellCardId", "setPartnerSignatureSpellCardId", "rightplaymatCardId", "getRightplaymatCardId", "setRightplaymatCardId", "rightplaymatFaceIndex", "getRightplaymatFaceIndex", "()Ljava/lang/Integer;", "setRightplaymatFaceIndex", "(Ljava/lang/Integer;)V", "leftplaymatCardId", "getLeftplaymatCardId", "setLeftplaymatCardId", "leftplaymatFaceIndex", "getLeftplaymatFaceIndex", "setLeftplaymatFaceIndex", "isPartner", "()Z", "(Z)V", "isBackground", "setBackground", "isDoctor", "setDoctor", "isDoctorCompanion", "setDoctorCompanion", "isFriendsForever", "setFriendsForever", "isSignatureSpell", "setSignatureSpell", "commanderLang", "getCommanderLang", "setCommanderLang", "partnerLang", "getPartnerLang", "setPartnerLang", "lastCommanderQuery", "searchCommanderJob", "Lkotlinx/coroutines/Job;", "getSearchCommanderJob", "()Lkotlinx/coroutines/Job;", "setSearchCommanderJob", "(Lkotlinx/coroutines/Job;)V", "lastPartnerQuery", "searchPartnerJob", "getSearchPartnerJob", "setSearchPartnerJob", "dbHelper", "Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "getDbHelper", "()Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "setDbHelper", "(Lcom/studiolaganne/lengendarylens/MTGDBHelper;)V", "localizedHelper", "Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "getLocalizedHelper", "()Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "setLocalizedHelper", "(Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;)V", "localizedHelpers", "", "getLocalizedHelpers", "()Ljava/util/List;", "setLocalizedHelpers", "(Ljava/util/List;)V", "commanderPopupWindow", "Landroid/widget/PopupWindow;", "getCommanderPopupWindow", "()Landroid/widget/PopupWindow;", "setCommanderPopupWindow", "(Landroid/widget/PopupWindow;)V", "partnerPopupWindow", "getPartnerPopupWindow", "setPartnerPopupWindow", "searchViewModel", "Lcom/studiolaganne/lengendarylens/MTCardSearchViewModel;", "currentLocalCommanderCards", "Lcom/studiolaganne/lengendarylens/MTGCardRecord;", "currentOnlineCommanderCards", "partnerSearchViewModel", "currentLocalPartnerCards", "currentOnlinePartnerCards", "colorImageView", "Landroid/widget/ImageView;", "onStart", "applyMTCardId", "card", "role", "performCommanderSearch", SearchIntents.EXTRA_QUERY, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acceptCommanderCard", "performPartnerSearch", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "showCardSelectionInterface", "updateEditButtonState", "updateFaceCardUI", "updateColorCircle", "showColorPickerDialog", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EditContainerDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private boolean colorExplicitlyCleared;
    private ImageView colorImageView;
    private String commander;
    private String commanderCardId;
    private PopupWindow commanderPopupWindow;
    private MTCardContainer container;
    private boolean convertDeck;
    private boolean convertList;
    private boolean creatingDeck;
    private MTGDBHelper dbHelper;
    private MTSimpleCard faceCard;
    private MTFormat format;
    private boolean isBackground;
    private boolean isDoctor;
    private boolean isDoctorCompanion;
    private boolean isFriendsForever;
    private boolean isPartner;
    private boolean isSignatureSpell;
    private String leftplaymatCardId;
    private Integer leftplaymatFaceIndex;
    private MTGDBHelperLocalized localizedHelper;
    private Function2<? super MTEditListBody, ? super Boolean, Unit> onEditClicked;
    private String partner;
    private String partnerCardId;
    private PopupWindow partnerPopupWindow;
    private MTCardSearchViewModel partnerSearchViewModel;
    private String partnerSignatureSpellCardId;
    private String partnersignaturespell;
    private boolean replaceAllCards;
    private String rightplaymatCardId;
    private Integer rightplaymatFaceIndex;
    private Job searchCommanderJob;
    private Job searchPartnerJob;
    private MTCardSearchViewModel searchViewModel;
    private String selectedColor;
    private Integer selectedDeckId;
    private String signatureSpellCardId;
    private String signaturespell;
    private boolean isCollection = true;
    private int convertType = 2;
    private boolean buttonEnabled = true;
    private String commanderLang = "en";
    private String partnerLang = "en";
    private String lastCommanderQuery = "";
    private String lastPartnerQuery = "";
    private List<MTGDBHelperLocalized> localizedHelpers = new ArrayList();
    private List<MTGCardRecord> currentLocalCommanderCards = new ArrayList();
    private List<MTGCardRecord> currentOnlineCommanderCards = new ArrayList();
    private List<MTGCardRecord> currentLocalPartnerCards = new ArrayList();
    private List<MTGCardRecord> currentOnlinePartnerCards = new ArrayList();

    /* JADX INFO: compiled from: EditContainerDialogFragment.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\u000e\u001a\u00020\u00002\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/EditContainerDialogFragment$Builder;", "", "<init>", "()V", "container", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "isCollection", "", "onEditClicked", "Lkotlin/Function2;", "Lcom/studiolaganne/lengendarylens/MTEditListBody;", "", "setContainer", "setIsCollection", "setOnEditClickedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "build", "Lcom/studiolaganne/lengendarylens/EditContainerDialogFragment;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private MTCardContainer container;
        private boolean isCollection = true;
        private Function2<? super MTEditListBody, ? super Boolean, Unit> onEditClicked;

        public final EditContainerDialogFragment build() {
            EditContainerDialogFragment editContainerDialogFragment = new EditContainerDialogFragment();
            editContainerDialogFragment.container = this.container;
            editContainerDialogFragment.isCollection = this.isCollection;
            editContainerDialogFragment.onEditClicked = this.onEditClicked;
            return editContainerDialogFragment;
        }

        public final Builder setContainer(MTCardContainer container) {
            Intrinsics.checkNotNullParameter(container, "container");
            this.container = container;
            return this;
        }

        public final Builder setIsCollection(boolean isCollection) {
            this.isCollection = isCollection;
            return this;
        }

        public final Builder setOnEditClickedListener(Function2<? super MTEditListBody, ? super Boolean, Unit> listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.onEditClicked = listener;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.EditContainerDialogFragment$performCommanderSearch$3, reason: invalid class name */
    /* JADX INFO: compiled from: EditContainerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.EditContainerDialogFragment$performCommanderSearch$3", f = "EditContainerDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(String str, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        static final void invokeSuspend$lambda$1(final EditContainerDialogFragment editContainerDialogFragment, final List list) {
            if (editContainerDialogFragment.getContext() == null) {
                return;
            }
            editContainerDialogFragment.currentLocalCommanderCards = list;
            View view = editContainerDialogFragment.getView();
            final EditText editText = view != null ? (EditText) view.findViewById(R.id.commanderEditText) : null;
            if (editText != null) {
                PopupWindow commanderPopupWindow = editContainerDialogFragment.getCommanderPopupWindow();
                if (commanderPopupWindow != null) {
                    commanderPopupWindow.dismiss();
                    editContainerDialogFragment.setCommanderPopupWindow(null);
                }
                Object systemService = editContainerDialogFragment.requireContext().getSystemService("layout_inflater");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.popup_suggestions, (ViewGroup) null);
                editContainerDialogFragment.setCommanderPopupWindow(new PopupWindow(viewInflate, -2, -2, true));
                ListView listView = (ListView) viewInflate.findViewById(R.id.suggestions_list);
                List list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((MTGCardRecord) it.next()).getTitle());
                }
                final ArrayList arrayList2 = arrayList;
                listView.setAdapter((ListAdapter) new ArrayAdapter(editContainerDialogFragment.requireContext(), android.R.layout.simple_list_item_1, arrayList2));
                final EditText editText2 = editText;
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$performCommanderSearch$3$$ExternalSyntheticLambda2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                        EditContainerDialogFragment.AnonymousClass3.invokeSuspend$lambda$1$0$2(editContainerDialogFragment, arrayList2, editText, list, editText2, adapterView, view2, i, j);
                    }
                });
                PopupWindow commanderPopupWindow2 = editContainerDialogFragment.getCommanderPopupWindow();
                if (commanderPopupWindow2 != null) {
                    commanderPopupWindow2.setOutsideTouchable(true);
                }
                PopupWindow commanderPopupWindow3 = editContainerDialogFragment.getCommanderPopupWindow();
                if (commanderPopupWindow3 != null) {
                    commanderPopupWindow3.setFocusable(false);
                }
                PopupWindow commanderPopupWindow4 = editContainerDialogFragment.getCommanderPopupWindow();
                if (commanderPopupWindow4 != null) {
                    int[] iArr = new int[2];
                    editText.getLocationOnScreen(iArr);
                    View contentView = commanderPopupWindow4.getContentView();
                    contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    Size size = new Size(contentView.getMeasuredWidth(), contentView.getMeasuredHeight() * arrayList2.size());
                    int height = iArr[1] - editText.getHeight();
                    if (size.getHeight() > height) {
                        commanderPopupWindow4.setHeight(height);
                        size = new Size(commanderPopupWindow4.getContentView().getMeasuredWidth(), height);
                    }
                    if (size.getHeight() > 0) {
                        commanderPopupWindow4.setHeight(size.getHeight());
                    }
                    commanderPopupWindow4.showAtLocation(editText, 8388659, iArr[0], iArr[1] - size.getHeight());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1$0$2(EditContainerDialogFragment editContainerDialogFragment, List list, EditText editText, List list2, EditText editText2, AdapterView adapterView, View view, int i, long j) {
            if (editContainerDialogFragment.getContext() == null) {
                return;
            }
            String str = (String) list.get(i);
            editContainerDialogFragment.lastCommanderQuery = str;
            editText.setText(str);
            MTGCardRecord mTGCardRecord = (MTGCardRecord) list2.get(i);
            editContainerDialogFragment.setCommanderLang(mTGCardRecord.getLang());
            String scryfallId = mTGCardRecord.getScryfallId();
            if (scryfallId.length() <= 0) {
                scryfallId = null;
            }
            if (scryfallId == null) {
                GameUtils companion = GameUtils.INSTANCE.getInstance();
                Context contextRequireContext = editContainerDialogFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                scryfallId = companion.getFirstPrintScryfallId(contextRequireContext, mTGCardRecord);
            }
            if (scryfallId != null) {
                mTGCardRecord.setScryfallId(scryfallId);
                editContainerDialogFragment.setCommander(scryfallId);
                editContainerDialogFragment.applyMTCardId(mTGCardRecord, "commander");
                editText2.setBackground(ContextCompat.getDrawable(editContainerDialogFragment.requireContext(), R.drawable.black_box_valid));
                editText2.clearFocus();
                editContainerDialogFragment.updateEditButtonState();
            }
            editContainerDialogFragment.acceptCommanderCard(mTGCardRecord);
            Object systemService = editContainerDialogFragment.requireActivity().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(editText2.getWindowToken(), 0);
            PopupWindow commanderPopupWindow = editContainerDialogFragment.getCommanderPopupWindow();
            if (commanderPopupWindow != null) {
                commanderPopupWindow.dismiss();
            }
        }

        static final void invokeSuspend$lambda$2(EditContainerDialogFragment editContainerDialogFragment) {
            if (editContainerDialogFragment.getContext() == null) {
                return;
            }
            Log.d(CreateDeckBottomSheetFragment.TAG, "****** NO LOCAL RESULTS *******");
            editContainerDialogFragment.currentLocalCommanderCards = new ArrayList();
            View view = editContainerDialogFragment.getView();
            EditText editText = view != null ? (EditText) view.findViewById(R.id.commanderEditText) : null;
            if (editText != null) {
                editText.setBackground(ContextCompat.getDrawable(editContainerDialogFragment.requireContext(), R.drawable.black_box_not_ok));
                PopupWindow commanderPopupWindow = editContainerDialogFragment.getCommanderPopupWindow();
                if (commanderPopupWindow != null) {
                    commanderPopupWindow.dismiss();
                    editContainerDialogFragment.setCommanderPopupWindow(null);
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EditContainerDialogFragment.this.new AnonymousClass3(this.$query, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int iD;
            MTGDBHelperLocalized localizedHelper;
            Object next;
            MTGDBHelperLocalized localizedHelper2;
            Object next2;
            MTGDBHelperLocalized localizedHelper3;
            Object next3;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Log.d(CreateDeckBottomSheetFragment.TAG, "------ Resetting");
            EditContainerDialogFragment.this.currentOnlineCommanderCards = new ArrayList();
            EditContainerDialogFragment.this.currentLocalCommanderCards = new ArrayList();
            final ArrayList arrayList = new ArrayList();
            Log.d(CreateDeckBottomSheetFragment.TAG, "Searching commander : " + this.$query);
            MTGDBHelper dbHelper = EditContainerDialogFragment.this.getDbHelper();
            if (dbHelper != null) {
                EditContainerDialogFragment editContainerDialogFragment = EditContainerDialogFragment.this;
                String str = this.$query;
                MTFormat mTFormat = editContainerDialogFragment.format;
                if (Intrinsics.areEqual(mTFormat != null ? mTFormat.getScryfallid() : null, "oathbreaker")) {
                    arrayList.addAll(dbHelper.searchForPlaneswalker(str));
                    Context contextRequireContext = editContainerDialogFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext).getDeviceLanguage(), "fr") && (localizedHelper3 = editContainerDialogFragment.getLocalizedHelper()) != null) {
                        for (MTGCardRecord mTGCardRecord : localizedHelper3.searchForPlaneswalker(str)) {
                            Iterator it = arrayList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    next3 = null;
                                    break;
                                }
                                next3 = it.next();
                                if (Intrinsics.areEqual(((MTGCardRecord) next3).getTitle(), mTGCardRecord.getTitle())) {
                                    break;
                                }
                            }
                            if (next3 == null) {
                                arrayList.add(mTGCardRecord);
                            }
                        }
                    }
                    MTCardSearchViewModel mTCardSearchViewModel = editContainerDialogFragment.searchViewModel;
                    if (mTCardSearchViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchViewModel");
                        mTCardSearchViewModel = null;
                    }
                    MTCardSearchType mTCardSearchType = MTCardSearchType.COMMANDER;
                    MTFormat mTFormat2 = editContainerDialogFragment.format;
                    mTCardSearchViewModel.performSearch(str, mTCardSearchType, mTFormat2 != null ? Boxing.boxInt(mTFormat2.getId()) : null);
                    iD = Log.d("EditContainerDialogFragment", "Searching online for commander: " + str);
                } else {
                    MTFormat mTFormat3 = editContainerDialogFragment.format;
                    if (Intrinsics.areEqual(mTFormat3 != null ? mTFormat3.getScryfallid() : null, "paupercommander")) {
                        arrayList.addAll(dbHelper.searchForUncommonCreature(str));
                        Context contextRequireContext2 = editContainerDialogFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext2).getDeviceLanguage(), "fr") && (localizedHelper2 = editContainerDialogFragment.getLocalizedHelper()) != null) {
                            for (MTGCardRecord mTGCardRecord2 : localizedHelper2.searchForUncommonCreature(str)) {
                                Iterator it2 = arrayList.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        next2 = null;
                                        break;
                                    }
                                    next2 = it2.next();
                                    if (Intrinsics.areEqual(((MTGCardRecord) next2).getTitle(), mTGCardRecord2.getTitle())) {
                                        break;
                                    }
                                }
                                if (next2 == null) {
                                    arrayList.add(mTGCardRecord2);
                                }
                            }
                        }
                        MTCardSearchViewModel mTCardSearchViewModel2 = editContainerDialogFragment.searchViewModel;
                        if (mTCardSearchViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("searchViewModel");
                            mTCardSearchViewModel2 = null;
                        }
                        MTCardSearchType mTCardSearchType2 = MTCardSearchType.COMMANDER;
                        MTFormat mTFormat4 = editContainerDialogFragment.format;
                        mTCardSearchViewModel2.performSearch(str, mTCardSearchType2, mTFormat4 != null ? Boxing.boxInt(mTFormat4.getId()) : null);
                        iD = Log.d("EditContainerDialogFragment", "Searching online for commander: " + str);
                    } else {
                        arrayList.addAll(dbHelper.searchForLegendaryCreatureOrPlaneswalker(str));
                        arrayList.addAll(dbHelper.searchForCanBeYourCommander(str));
                        Context contextRequireContext3 = editContainerDialogFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                        if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext3).getDeviceLanguage(), "fr") && (localizedHelper = editContainerDialogFragment.getLocalizedHelper()) != null) {
                            for (MTGCardRecord mTGCardRecord3 : localizedHelper.searchForLegendaryCreatureOrPlaneswalker(str)) {
                                Iterator it3 = arrayList.iterator();
                                while (true) {
                                    if (!it3.hasNext()) {
                                        next = null;
                                        break;
                                    }
                                    next = it3.next();
                                    if (Intrinsics.areEqual(((MTGCardRecord) next).getTitle(), mTGCardRecord3.getTitle())) {
                                        break;
                                    }
                                }
                                if (next == null) {
                                    arrayList.add(mTGCardRecord3);
                                }
                            }
                        }
                        MTCardSearchViewModel mTCardSearchViewModel3 = editContainerDialogFragment.searchViewModel;
                        if (mTCardSearchViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("searchViewModel");
                            mTCardSearchViewModel3 = null;
                        }
                        MTCardSearchType mTCardSearchType3 = MTCardSearchType.COMMANDER;
                        MTFormat mTFormat5 = editContainerDialogFragment.format;
                        mTCardSearchViewModel3.performSearch(str, mTCardSearchType3, mTFormat5 != null ? Boxing.boxInt(mTFormat5.getId()) : null);
                        iD = Log.d("EditContainerDialogFragment", "Searching online for commander: " + str);
                    }
                }
                Boxing.boxInt(iD);
            }
            boolean zIsEmpty = arrayList.isEmpty();
            EditContainerDialogFragment editContainerDialogFragment2 = EditContainerDialogFragment.this;
            if (zIsEmpty) {
                FragmentActivity activity = editContainerDialogFragment2.getActivity();
                if (activity != null) {
                    final EditContainerDialogFragment editContainerDialogFragment3 = EditContainerDialogFragment.this;
                    activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$performCommanderSearch$3$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            EditContainerDialogFragment.AnonymousClass3.invokeSuspend$lambda$2(editContainerDialogFragment3);
                        }
                    });
                }
            } else {
                FragmentActivity activity2 = editContainerDialogFragment2.getActivity();
                if (activity2 != null) {
                    final EditContainerDialogFragment editContainerDialogFragment4 = EditContainerDialogFragment.this;
                    activity2.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$performCommanderSearch$3$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            EditContainerDialogFragment.AnonymousClass3.invokeSuspend$lambda$1(editContainerDialogFragment4, arrayList);
                        }
                    });
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.EditContainerDialogFragment$performPartnerSearch$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EditContainerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.EditContainerDialogFragment$performPartnerSearch$3", f = "EditContainerDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11653 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11653(String str, Continuation<? super C11653> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        static final void invokeSuspend$lambda$7(final EditContainerDialogFragment editContainerDialogFragment, final List list) {
            if (editContainerDialogFragment.getContext() == null) {
                return;
            }
            editContainerDialogFragment.currentLocalPartnerCards = list;
            View view = editContainerDialogFragment.getView();
            final EditText editText = view != null ? (EditText) view.findViewById(R.id.partnerEditText) : null;
            if (editText != null) {
                PopupWindow partnerPopupWindow = editContainerDialogFragment.getPartnerPopupWindow();
                if (partnerPopupWindow != null) {
                    partnerPopupWindow.dismiss();
                    editContainerDialogFragment.setPartnerPopupWindow(null);
                }
                Object systemService = editContainerDialogFragment.requireContext().getSystemService("layout_inflater");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.popup_suggestions, (ViewGroup) null);
                editContainerDialogFragment.setPartnerPopupWindow(new PopupWindow(viewInflate, -2, -2, true));
                ListView listView = (ListView) viewInflate.findViewById(R.id.suggestions_list);
                List list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((MTGCardRecord) it.next()).getTitle());
                }
                final ArrayList arrayList2 = arrayList;
                listView.setAdapter((ListAdapter) new ArrayAdapter(editContainerDialogFragment.requireContext(), android.R.layout.simple_list_item_1, arrayList2));
                final EditText editText2 = editText;
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$performPartnerSearch$3$$ExternalSyntheticLambda2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                        EditContainerDialogFragment.C11653.invokeSuspend$lambda$7$0$2(arrayList2, editContainerDialogFragment, editText, list, editText2, adapterView, view2, i, j);
                    }
                });
                PopupWindow partnerPopupWindow2 = editContainerDialogFragment.getPartnerPopupWindow();
                if (partnerPopupWindow2 != null) {
                    partnerPopupWindow2.setOutsideTouchable(true);
                }
                PopupWindow partnerPopupWindow3 = editContainerDialogFragment.getPartnerPopupWindow();
                if (partnerPopupWindow3 != null) {
                    partnerPopupWindow3.setFocusable(false);
                }
                PopupWindow partnerPopupWindow4 = editContainerDialogFragment.getPartnerPopupWindow();
                if (partnerPopupWindow4 != null) {
                    int[] iArr = new int[2];
                    editText.getLocationOnScreen(iArr);
                    View contentView = partnerPopupWindow4.getContentView();
                    contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    Size size = new Size(contentView.getMeasuredWidth(), contentView.getMeasuredHeight() * arrayList2.size());
                    int height = iArr[1] - editText.getHeight();
                    if (size.getHeight() > height) {
                        partnerPopupWindow4.setHeight(height);
                        size = new Size(partnerPopupWindow4.getContentView().getMeasuredWidth(), height);
                    }
                    if (size.getHeight() > 0) {
                        partnerPopupWindow4.setHeight(size.getHeight());
                    }
                    partnerPopupWindow4.showAtLocation(editText, 8388659, iArr[0], iArr[1] - size.getHeight());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$7$0$2(List list, EditContainerDialogFragment editContainerDialogFragment, EditText editText, List list2, EditText editText2, AdapterView adapterView, View view, int i, long j) {
            String str = (String) list.get(i);
            editContainerDialogFragment.lastPartnerQuery = str;
            editText.setText(str);
            MTGCardRecord mTGCardRecord = (MTGCardRecord) list2.get(i);
            editContainerDialogFragment.setPartnerLang(mTGCardRecord.getLang());
            String scryfallId = mTGCardRecord.getScryfallId();
            if (scryfallId.length() <= 0) {
                scryfallId = null;
            }
            if (scryfallId == null) {
                GameUtils companion = GameUtils.INSTANCE.getInstance();
                Context contextRequireContext = editContainerDialogFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                scryfallId = companion.getFirstPrintScryfallId(contextRequireContext, mTGCardRecord);
            }
            if (scryfallId != null) {
                editContainerDialogFragment.setPartner(scryfallId);
                editContainerDialogFragment.applyMTCardId(mTGCardRecord, "partner");
                editText2.setBackground(editContainerDialogFragment.requireContext().getResources().getDrawable(R.drawable.black_box_valid, null));
                editText2.clearFocus();
            }
            Object systemService = editContainerDialogFragment.requireActivity().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(editText2.getWindowToken(), 0);
            PopupWindow partnerPopupWindow = editContainerDialogFragment.getPartnerPopupWindow();
            if (partnerPopupWindow != null) {
                partnerPopupWindow.dismiss();
            }
        }

        static final void invokeSuspend$lambda$8(EditContainerDialogFragment editContainerDialogFragment) {
            if (editContainerDialogFragment.getContext() == null) {
                return;
            }
            editContainerDialogFragment.currentLocalPartnerCards = new ArrayList();
            View view = editContainerDialogFragment.getView();
            EditText editText = view != null ? (EditText) view.findViewById(R.id.partnerEditText) : null;
            if (editText != null) {
                editText.setBackground(ContextCompat.getDrawable(editContainerDialogFragment.requireContext(), R.drawable.black_box_not_ok));
                PopupWindow partnerPopupWindow = editContainerDialogFragment.getPartnerPopupWindow();
                if (partnerPopupWindow != null) {
                    partnerPopupWindow.dismiss();
                    editContainerDialogFragment.setPartnerPopupWindow(null);
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EditContainerDialogFragment.this.new C11653(this.$query, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11653) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MTGDBHelper dbHelper;
            MTGDBHelperLocalized localizedHelper;
            Object next;
            MTGDBHelper dbHelper2;
            MTGDBHelperLocalized localizedHelper2;
            Object next2;
            MTGDBHelper dbHelper3;
            MTGDBHelperLocalized localizedHelper3;
            Object next3;
            MTGDBHelper dbHelper4;
            MTGDBHelper dbHelper5;
            MTGDBHelperLocalized localizedHelper4;
            Object next4;
            MTGDBHelperLocalized localizedHelper5;
            Object next5;
            MTGDBHelperLocalized localizedHelper6;
            Object next6;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            EditContainerDialogFragment.this.currentLocalPartnerCards = new ArrayList();
            EditContainerDialogFragment.this.currentOnlinePartnerCards = new ArrayList();
            final ArrayList arrayList = new ArrayList();
            if (EditContainerDialogFragment.this.getIsPartner()) {
                MTFormat mTFormat = EditContainerDialogFragment.this.format;
                boolean zAreEqual = Intrinsics.areEqual(mTFormat != null ? mTFormat.getScryfallid() : null, "paupercommander");
                EditContainerDialogFragment editContainerDialogFragment = EditContainerDialogFragment.this;
                if (zAreEqual) {
                    MTGDBHelper dbHelper6 = editContainerDialogFragment.getDbHelper();
                    if (dbHelper6 != null) {
                        String str = this.$query;
                        EditContainerDialogFragment editContainerDialogFragment2 = EditContainerDialogFragment.this;
                        arrayList.addAll(dbHelper6.searchForUncommonCreature(str));
                        Context contextRequireContext = editContainerDialogFragment2.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                        if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext).getDeviceLanguage(), "fr") && (localizedHelper6 = editContainerDialogFragment2.getLocalizedHelper()) != null) {
                            for (MTGCardRecord mTGCardRecord : localizedHelper6.searchForUncommonCreature(str)) {
                                Iterator it = arrayList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        next6 = null;
                                        break;
                                    }
                                    next6 = it.next();
                                    if (Intrinsics.areEqual(((MTGCardRecord) next6).getTitle(), mTGCardRecord.getTitle())) {
                                        break;
                                    }
                                }
                                if (next6 == null) {
                                    arrayList.add(mTGCardRecord);
                                }
                            }
                        }
                        MTCardSearchViewModel mTCardSearchViewModel = editContainerDialogFragment2.partnerSearchViewModel;
                        if (mTCardSearchViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("partnerSearchViewModel");
                            mTCardSearchViewModel = null;
                        }
                        MTCardSearchType mTCardSearchType = MTCardSearchType.PARTNER;
                        MTFormat mTFormat2 = editContainerDialogFragment2.format;
                        mTCardSearchViewModel.performSearch(str, mTCardSearchType, mTFormat2 != null ? Boxing.boxInt(mTFormat2.getId()) : null);
                        Boxing.boxInt(Log.d("EditContainerDialogFragment", "Searching online for partner: " + str));
                    }
                } else {
                    MTGDBHelper dbHelper7 = editContainerDialogFragment.getDbHelper();
                    if (dbHelper7 != null) {
                        String str2 = this.$query;
                        EditContainerDialogFragment editContainerDialogFragment3 = EditContainerDialogFragment.this;
                        arrayList.addAll(dbHelper7.searchForLegendaryCreatureOrPlaneswalker(str2));
                        Context contextRequireContext2 = editContainerDialogFragment3.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext2).getDeviceLanguage(), "fr") && (localizedHelper5 = editContainerDialogFragment3.getLocalizedHelper()) != null) {
                            for (MTGCardRecord mTGCardRecord2 : localizedHelper5.searchForLegendaryCreatureOrPlaneswalker(str2)) {
                                Iterator it2 = arrayList.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        next5 = null;
                                        break;
                                    }
                                    next5 = it2.next();
                                    if (Intrinsics.areEqual(((MTGCardRecord) next5).getTitle(), mTGCardRecord2.getTitle())) {
                                        break;
                                    }
                                }
                                if (next5 == null) {
                                    arrayList.add(mTGCardRecord2);
                                }
                            }
                        }
                        MTCardSearchViewModel mTCardSearchViewModel2 = editContainerDialogFragment3.partnerSearchViewModel;
                        if (mTCardSearchViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("partnerSearchViewModel");
                            mTCardSearchViewModel2 = null;
                        }
                        MTCardSearchType mTCardSearchType2 = MTCardSearchType.PARTNER;
                        MTFormat mTFormat3 = editContainerDialogFragment3.format;
                        mTCardSearchViewModel2.performSearch(str2, mTCardSearchType2, mTFormat3 != null ? Boxing.boxInt(mTFormat3.getId()) : null);
                        Boxing.boxInt(Log.d("EditContainerDialogFragment", "Searching online for partner: " + str2));
                    }
                }
            }
            if (EditContainerDialogFragment.this.getIsBackground() && (dbHelper5 = EditContainerDialogFragment.this.getDbHelper()) != null) {
                String str3 = this.$query;
                EditContainerDialogFragment editContainerDialogFragment4 = EditContainerDialogFragment.this;
                arrayList.addAll(dbHelper5.searchForBackground(str3));
                Context contextRequireContext3 = editContainerDialogFragment4.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext3).getDeviceLanguage(), "fr") && (localizedHelper4 = editContainerDialogFragment4.getLocalizedHelper()) != null) {
                    for (MTGCardRecord mTGCardRecord3 : localizedHelper4.searchForBackground(str3)) {
                        Iterator it3 = arrayList.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                next4 = null;
                                break;
                            }
                            next4 = it3.next();
                            if (Intrinsics.areEqual(((MTGCardRecord) next4).getTitle(), mTGCardRecord3.getTitle())) {
                                break;
                            }
                        }
                        if (next4 == null) {
                            arrayList.add(mTGCardRecord3);
                        }
                    }
                }
                MTCardSearchViewModel mTCardSearchViewModel3 = editContainerDialogFragment4.partnerSearchViewModel;
                if (mTCardSearchViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partnerSearchViewModel");
                    mTCardSearchViewModel3 = null;
                }
                MTCardSearchType mTCardSearchType3 = MTCardSearchType.PARTNER;
                MTFormat mTFormat4 = editContainerDialogFragment4.format;
                mTCardSearchViewModel3.performSearch(str3, mTCardSearchType3, mTFormat4 != null ? Boxing.boxInt(mTFormat4.getId()) : null);
                Boxing.boxInt(Log.d("EditContainerDialogFragment", "Searching online for partner/background: " + str3));
            }
            if (EditContainerDialogFragment.this.getIsFriendsForever() && (dbHelper4 = EditContainerDialogFragment.this.getDbHelper()) != null) {
                Boxing.boxBoolean(arrayList.addAll(dbHelper4.searchForFriendsForever(this.$query)));
            }
            if (EditContainerDialogFragment.this.getIsDoctor() && (dbHelper3 = EditContainerDialogFragment.this.getDbHelper()) != null) {
                String str4 = this.$query;
                EditContainerDialogFragment editContainerDialogFragment5 = EditContainerDialogFragment.this;
                arrayList.addAll(dbHelper3.searchForDoctorCompanion(str4));
                Context contextRequireContext4 = editContainerDialogFragment5.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext4).getDeviceLanguage(), "fr") && (localizedHelper3 = editContainerDialogFragment5.getLocalizedHelper()) != null) {
                    for (MTGCardRecord mTGCardRecord4 : localizedHelper3.searchForDoctorCompanion(str4)) {
                        Iterator it4 = arrayList.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                next3 = null;
                                break;
                            }
                            next3 = it4.next();
                            if (Intrinsics.areEqual(((MTGCardRecord) next3).getTitle(), mTGCardRecord4.getTitle())) {
                                break;
                            }
                        }
                        if (next3 == null) {
                            arrayList.add(mTGCardRecord4);
                        }
                    }
                }
            }
            if (EditContainerDialogFragment.this.getIsDoctorCompanion() && (dbHelper2 = EditContainerDialogFragment.this.getDbHelper()) != null) {
                String str5 = this.$query;
                EditContainerDialogFragment editContainerDialogFragment6 = EditContainerDialogFragment.this;
                arrayList.addAll(dbHelper2.searchForDoctor(str5));
                Context contextRequireContext5 = editContainerDialogFragment6.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
                if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext5).getDeviceLanguage(), "fr") && (localizedHelper2 = editContainerDialogFragment6.getLocalizedHelper()) != null) {
                    for (MTGCardRecord mTGCardRecord5 : localizedHelper2.searchForDoctor(str5)) {
                        Iterator it5 = arrayList.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it5.next();
                            if (Intrinsics.areEqual(((MTGCardRecord) next2).getTitle(), mTGCardRecord5.getTitle())) {
                                break;
                            }
                        }
                        if (next2 == null) {
                            arrayList.add(mTGCardRecord5);
                        }
                    }
                }
            }
            if (EditContainerDialogFragment.this.getIsSignatureSpell() && (dbHelper = EditContainerDialogFragment.this.getDbHelper()) != null) {
                String str6 = this.$query;
                EditContainerDialogFragment editContainerDialogFragment7 = EditContainerDialogFragment.this;
                arrayList.addAll(dbHelper.searchForInstantOrSorcery(str6));
                Context contextRequireContext6 = editContainerDialogFragment7.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext6, "requireContext(...)");
                if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext6).getDeviceLanguage(), "fr") && (localizedHelper = editContainerDialogFragment7.getLocalizedHelper()) != null) {
                    for (MTGCardRecord mTGCardRecord6 : localizedHelper.searchForInstantOrSorcery(str6)) {
                        Iterator it6 = arrayList.iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it6.next();
                            if (Intrinsics.areEqual(((MTGCardRecord) next).getTitle(), mTGCardRecord6.getTitle())) {
                                break;
                            }
                        }
                        if (next == null) {
                            arrayList.add(mTGCardRecord6);
                        }
                    }
                }
                MTCardSearchViewModel mTCardSearchViewModel4 = editContainerDialogFragment7.partnerSearchViewModel;
                if (mTCardSearchViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("partnerSearchViewModel");
                    mTCardSearchViewModel4 = null;
                }
                MTCardSearchType mTCardSearchType4 = MTCardSearchType.SIGNATURE_SPELL;
                MTFormat mTFormat5 = editContainerDialogFragment7.format;
                mTCardSearchViewModel4.performSearch(str6, mTCardSearchType4, mTFormat5 != null ? Boxing.boxInt(mTFormat5.getId()) : null);
                Boxing.boxInt(Log.d("EditContainerDialogFragment", "Searching online for signature spell: " + str6));
            }
            boolean zIsEmpty = arrayList.isEmpty();
            EditContainerDialogFragment editContainerDialogFragment8 = EditContainerDialogFragment.this;
            if (zIsEmpty) {
                FragmentActivity activity = editContainerDialogFragment8.getActivity();
                if (activity != null) {
                    final EditContainerDialogFragment editContainerDialogFragment9 = EditContainerDialogFragment.this;
                    activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$performPartnerSearch$3$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            EditContainerDialogFragment.C11653.invokeSuspend$lambda$8(editContainerDialogFragment9);
                        }
                    });
                }
            } else {
                FragmentActivity activity2 = editContainerDialogFragment8.getActivity();
                if (activity2 != null) {
                    final EditContainerDialogFragment editContainerDialogFragment10 = EditContainerDialogFragment.this;
                    activity2.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$performPartnerSearch$3$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            EditContainerDialogFragment.C11653.invokeSuspend$lambda$7(editContainerDialogFragment10, arrayList);
                        }
                    });
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void acceptCommanderCard(MTGCardRecord card) {
        boolean z;
        MTFormat mTFormat = this.format;
        boolean zAreEqual = Intrinsics.areEqual(mTFormat != null ? mTFormat.getScryfallid() : null, "oathbreaker");
        String strTranslateTag = Intrinsics.areEqual(card.getLang(), "en") ? "doctor" : SearchDataUtils.INSTANCE.getInstance().translateTag("doctor", card.getLang());
        String keywords = card.getKeywords();
        if (keywords != null) {
            String lowerCase = keywords.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "partner", false, 2, (Object) null) || zAreEqual) {
                z = false;
            } else {
                this.isPartner = true;
                this.isBackground = false;
                this.isDoctor = false;
                this.isDoctorCompanion = false;
                this.isFriendsForever = false;
                this.isSignatureSpell = false;
                View view = getView();
                EditText editText = view != null ? (EditText) view.findViewById(R.id.partnerEditText) : null;
                if (editText != null) {
                    editText.setVisibility(0);
                }
                if (editText != null) {
                    editText.setHint(getString(R.string.partner_hint));
                }
                z = true;
            }
            String lowerCase2 = keywords.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "choose a background", false, 2, (Object) null) && !zAreEqual) {
                this.isPartner = false;
                this.isBackground = true;
                this.isDoctor = false;
                this.isDoctorCompanion = false;
                this.isFriendsForever = false;
                this.isSignatureSpell = false;
                View view2 = getView();
                EditText editText2 = view2 != null ? (EditText) view2.findViewById(R.id.partnerEditText) : null;
                if (editText2 != null) {
                    editText2.setVisibility(0);
                }
                if (editText2 != null) {
                    editText2.setHint(getString(R.string.background_hint));
                }
                z = true;
            }
            String lowerCase3 = keywords.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "friends forever", false, 2, (Object) null) && !zAreEqual) {
                this.isPartner = false;
                this.isBackground = false;
                this.isFriendsForever = true;
                this.isDoctor = false;
                this.isDoctorCompanion = false;
                this.isSignatureSpell = false;
                View view3 = getView();
                EditText editText3 = view3 != null ? (EditText) view3.findViewById(R.id.partnerEditText) : null;
                if (editText3 != null) {
                    editText3.setVisibility(0);
                }
                if (editText3 != null) {
                    editText3.setHint(getString(R.string.friends_forever_hint));
                }
                z = true;
            }
            String lowerCase4 = keywords.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) "doctor's companion", false, 2, (Object) null) && !zAreEqual) {
                this.isPartner = false;
                this.isBackground = false;
                this.isFriendsForever = false;
                this.isDoctor = false;
                this.isDoctorCompanion = true;
                this.isSignatureSpell = false;
                View view4 = getView();
                EditText editText4 = view4 != null ? (EditText) view4.findViewById(R.id.partnerEditText) : null;
                if (editText4 != null) {
                    editText4.setVisibility(0);
                }
                if (editText4 != null) {
                    editText4.setHint(getString(R.string.time_lord_hint));
                }
                z = true;
            }
        } else {
            z = false;
        }
        String type_line = card.getType_line();
        if (type_line != null) {
            String lowerCase5 = type_line.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) "time", false, 2, (Object) null)) {
                String lowerCase6 = type_line.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase6, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase6, (CharSequence) "lord", false, 2, (Object) null)) {
                    String lowerCase7 = type_line.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase7, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase7, (CharSequence) strTranslateTag, false, 2, (Object) null) && !zAreEqual) {
                        this.isPartner = false;
                        this.isBackground = false;
                        this.isDoctor = true;
                        this.isDoctorCompanion = false;
                        this.isFriendsForever = false;
                        this.isSignatureSpell = false;
                        View view5 = getView();
                        EditText editText5 = view5 != null ? (EditText) view5.findViewById(R.id.partnerEditText) : null;
                        if (editText5 != null) {
                            editText5.setVisibility(0);
                        }
                        if (editText5 != null) {
                            editText5.setHint(getString(R.string.doctor_hint));
                        }
                        z = true;
                    }
                }
            }
        }
        if (zAreEqual) {
            this.isSignatureSpell = true;
            this.isPartner = false;
            this.isBackground = false;
            this.isFriendsForever = false;
            this.isDoctor = false;
            this.isDoctorCompanion = false;
            View view6 = getView();
            EditText editText6 = view6 != null ? (EditText) view6.findViewById(R.id.partnerEditText) : null;
            if (editText6 != null) {
                editText6.setVisibility(0);
            }
            if (editText6 != null) {
                editText6.setHint(getString(R.string.signature_spell_hint));
            }
        }
        if (z || zAreEqual) {
            return;
        }
        this.partner = null;
        this.lastPartnerQuery = "";
        View view7 = getView();
        EditText editText7 = view7 != null ? (EditText) view7.findViewById(R.id.partnerEditText) : null;
        if (editText7 != null) {
            editText7.setText("");
        }
        if (editText7 != null) {
            editText7.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final boolean applyMTCardId(MTGCardRecord card, String role) {
        String mtCardId = card.getMtCardId();
        if (mtCardId.length() <= 0) {
            mtCardId = null;
        }
        if (mtCardId == null) {
            return false;
        }
        switch (role.hashCode()) {
            case -1498725064:
                if (!role.equals("commander")) {
                    return true;
                }
                this.commanderCardId = mtCardId;
                this.rightplaymatCardId = mtCardId;
                this.rightplaymatFaceIndex = Integer.valueOf(card.getFace());
                return true;
            case -792929080:
                if (!role.equals("partner")) {
                    return true;
                }
                this.partnerCardId = mtCardId;
                this.leftplaymatCardId = mtCardId;
                this.leftplaymatFaceIndex = Integer.valueOf(card.getFace());
                return true;
            case -683271312:
                if (!role.equals("signaturespell")) {
                    return true;
                }
                this.signatureSpellCardId = mtCardId;
                return true;
            case 1908210232:
                if (!role.equals("partnersignaturespell")) {
                    return true;
                }
                this.partnerSignatureSpellCardId = mtCardId;
                return true;
            default:
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$0(EditText editText, EditContainerDialogFragment editContainerDialogFragment) {
        Window window;
        editText.requestFocus();
        Object systemService = editContainerDialogFragment.requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        Dialog dialog = editContainerDialogFragment.getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setSoftInputMode(4);
    }

    static final void onCreateView$lambda$10(CheckBox checkBox, EditContainerDialogFragment editContainerDialogFragment, LinearLayout linearLayout, CompoundButton compoundButton, boolean z) {
        Integer type;
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (!z) {
            editContainerDialogFragment.convertList = false;
            linearLayout.setVisibility(8);
            editContainerDialogFragment.updateEditButtonState();
            return;
        }
        checkBox.setChecked(false);
        editContainerDialogFragment.convertList = true;
        MTCardContainer mTCardContainer = editContainerDialogFragment.container;
        if (mTCardContainer != null) {
            Integer type2 = mTCardContainer.getType();
            if ((type2 != null && type2.intValue() == 2) || ((type = mTCardContainer.getType()) != null && type.intValue() == 1)) {
                editContainerDialogFragment.convertType = 0;
                linearLayout.setVisibility(8);
            } else {
                editContainerDialogFragment.convertType = 2;
                linearLayout.setVisibility(0);
            }
        }
        editContainerDialogFragment.updateEditButtonState();
    }

    static final void onCreateView$lambda$11(EditContainerDialogFragment editContainerDialogFragment, CheckBox checkBox, LinearLayout linearLayout, RadioButton radioButton, RadioButton radioButton2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, CheckBox checkBox2, CompoundButton compoundButton, boolean z) {
        Integer count;
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (!z) {
            editContainerDialogFragment.convertDeck = false;
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(8);
            linearLayout3.setVisibility(8);
            editContainerDialogFragment.updateEditButtonState();
            return;
        }
        MTCardContainer mTCardContainer = editContainerDialogFragment.container;
        if (mTCardContainer != null && (count = mTCardContainer.getCount()) != null && count.intValue() >= 1000) {
            checkBox2.setChecked(false);
            Toast.makeText(editContainerDialogFragment.requireContext(), editContainerDialogFragment.getString(R.string.cannot_convert_large_list_to_deck), 0).show();
            return;
        }
        checkBox.setChecked(false);
        linearLayout.setVisibility(0);
        radioButton.setChecked(true);
        radioButton2.setChecked(false);
        linearLayout2.setVisibility(0);
        linearLayout3.setVisibility(8);
        editContainerDialogFragment.convertDeck = true;
        editContainerDialogFragment.convertList = false;
        linearLayout4.setVisibility(8);
        Context context = editContainerDialogFragment.getContext();
        if (context != null) {
            new PreferencesManager(context).setForcedApiUpdate(true);
        }
        editContainerDialogFragment.updateEditButtonState();
    }

    static final boolean onCreateView$lambda$13(TextView textView, EditContainerDialogFragment editContainerDialogFragment, MenuItem menuItem) {
        if (menuItem.getItemId() == -1) {
            return true;
        }
        textView.setText(menuItem.getTitle());
        editContainerDialogFragment.selectedDeckId = Integer.valueOf(menuItem.getItemId());
        editContainerDialogFragment.creatingDeck = false;
        textView.setTextColor(ContextCompat.getColor(editContainerDialogFragment.requireContext(), R.color.almost_white));
        editContainerDialogFragment.updateEditButtonState();
        return true;
    }

    static final Unit onCreateView$lambda$14(PopupMenu popupMenu) {
        popupMenu.show();
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$15(EditContainerDialogFragment editContainerDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        editContainerDialogFragment.replaceAllCards = z;
    }

    static final void onCreateView$lambda$16(EditContainerDialogFragment editContainerDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            editContainerDialogFragment.convertType = 2;
        }
    }

    static final void onCreateView$lambda$17(EditContainerDialogFragment editContainerDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            editContainerDialogFragment.convertType = 1;
        }
    }

    static final Unit onCreateView$lambda$2(EditContainerDialogFragment editContainerDialogFragment) {
        editContainerDialogFragment.showColorPickerDialog();
        return Unit.INSTANCE;
    }

    static final boolean onCreateView$lambda$22(TextView textView, EditContainerDialogFragment editContainerDialogFragment, List list, EditText editText, MenuItem menuItem) {
        Object next;
        textView.setText(menuItem.getTitle());
        textView.setTextColor(ContextCompat.getColor(editContainerDialogFragment.requireContext(), R.color.almost_white));
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((MTFormat) next).getId() == menuItem.getItemId()) {
                break;
            }
        }
        MTFormat mTFormat = (MTFormat) next;
        editContainerDialogFragment.format = mTFormat;
        if (mTFormat != null) {
            if (mTFormat.getHascommander()) {
                Log.d("CREATE_DECK", "Format with commander.");
                editText.setVisibility(0);
                if (Intrinsics.areEqual(mTFormat.getScryfallid(), "oathbreaker")) {
                    editText.setHint(editContainerDialogFragment.getString(R.string.oathbreaker_hint));
                } else {
                    editText.setHint(editContainerDialogFragment.getString(R.string.commander_hint));
                }
            } else {
                Log.d("CREATE_DECK", "Format with NO commander.");
                editText.setVisibility(8);
            }
        }
        editContainerDialogFragment.updateEditButtonState();
        return true;
    }

    static final boolean onCreateView$lambda$23(PopupMenu popupMenu, TextView textView, EditContainerDialogFragment editContainerDialogFragment, List list, EditText editText, MenuItem menuItem) {
        Object next;
        if (menuItem.getItemId() == -1) {
            popupMenu.show();
            return true;
        }
        textView.setText(menuItem.getTitle());
        textView.setTextColor(ContextCompat.getColor(editContainerDialogFragment.requireContext(), R.color.almost_white));
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((MTFormat) next).getId() == menuItem.getItemId()) {
                break;
            }
        }
        MTFormat mTFormat = (MTFormat) next;
        editContainerDialogFragment.format = mTFormat;
        if (mTFormat != null) {
            if (mTFormat.getHascommander()) {
                editText.setVisibility(0);
                if (Intrinsics.areEqual(mTFormat.getScryfallid(), "oathbreaker")) {
                    editText.setHint(editContainerDialogFragment.getString(R.string.oathbreaker_hint));
                } else {
                    editText.setHint(editContainerDialogFragment.getString(R.string.commander_hint));
                }
            } else {
                editText.setVisibility(8);
            }
            editContainerDialogFragment.updateEditButtonState();
        }
        return true;
    }

    static final Unit onCreateView$lambda$24(PopupMenu popupMenu) {
        popupMenu.show();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$25(EditContainerDialogFragment editContainerDialogFragment) {
        editContainerDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$26(EditContainerDialogFragment editContainerDialogFragment, EditText editText, EditText editText2) {
        String string;
        String str;
        String str2;
        if (!editContainerDialogFragment.buttonEnabled) {
            return Unit.INSTANCE;
        }
        Editable text = editText.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (text.length() == 0) {
            return Unit.INSTANCE;
        }
        MTEditListBody mTEditListBody = new MTEditListBody(null, null, null, null, null, null, 63, null);
        String str3 = editContainerDialogFragment.selectedColor;
        mTEditListBody.setColor(str3 != null ? StringsKt.replace$default(str3, ColorKt.HEX_PREFIX, "", false, 4, (Object) null) : null);
        mTEditListBody.setIncludeNullColor(editContainerDialogFragment.colorExplicitlyCleared);
        mTEditListBody.setName(editText.getText().toString());
        mTEditListBody.setFaceCard(editContainerDialogFragment.faceCard);
        mTEditListBody.setType(Integer.valueOf(editContainerDialogFragment.convertType));
        if (editContainerDialogFragment.convertDeck) {
            mTEditListBody.setType(3);
            if (editContainerDialogFragment.creatingDeck) {
                MTEditListBodyDeckSettings mTEditListBodyDeckSettings = new MTEditListBodyDeckSettings(null, false, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
                MTFormat mTFormat = editContainerDialogFragment.format;
                mTEditListBodyDeckSettings.setFormatid(mTFormat != null ? Integer.valueOf(mTFormat.getId()) : null);
                mTEditListBodyDeckSettings.setCommander(editContainerDialogFragment.commander);
                mTEditListBodyDeckSettings.setPartner(editContainerDialogFragment.partner);
                mTEditListBodyDeckSettings.setCommander_card_id(editContainerDialogFragment.commanderCardId);
                mTEditListBodyDeckSettings.setPartner_card_id(editContainerDialogFragment.partnerCardId);
                mTEditListBodyDeckSettings.setSignature_spell_card_id(editContainerDialogFragment.signatureSpellCardId);
                mTEditListBodyDeckSettings.setPartner_signature_spell_card_id(editContainerDialogFragment.partnerSignatureSpellCardId);
                mTEditListBodyDeckSettings.setRightplaymat_card_id(editContainerDialogFragment.rightplaymatCardId);
                mTEditListBodyDeckSettings.setRightplaymat_face_index(editContainerDialogFragment.rightplaymatFaceIndex);
                mTEditListBodyDeckSettings.setLeftplaymat_card_id(editContainerDialogFragment.leftplaymatCardId);
                mTEditListBodyDeckSettings.setLeftplaymat_face_index(editContainerDialogFragment.leftplaymatFaceIndex);
                if (editContainerDialogFragment.rightplaymatCardId == null && (str2 = editContainerDialogFragment.commander) != null) {
                    mTEditListBodyDeckSettings.setRightplaymat("id:" + str2);
                }
                if (editContainerDialogFragment.leftplaymatCardId == null && (str = editContainerDialogFragment.partner) != null) {
                    mTEditListBodyDeckSettings.setLeftplaymat("id:" + str);
                }
                if (editContainerDialogFragment.commander != null) {
                    string = editText2.getText().toString();
                } else {
                    MTFormat mTFormat2 = editContainerDialogFragment.format;
                    if (mTFormat2 != null) {
                        string = "Deck " + (mTFormat2 != null ? mTFormat2.getName() : null);
                    } else {
                        string = "New Deck";
                    }
                }
                mTEditListBodyDeckSettings.setName(string);
                mTEditListBody.setDeck(mTEditListBodyDeckSettings);
            } else {
                Integer num = editContainerDialogFragment.selectedDeckId;
                if (num != null) {
                    int iIntValue = num.intValue();
                    MTEditListBodyDeckSettings mTEditListBodyDeckSettings2 = new MTEditListBodyDeckSettings(null, false, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
                    mTEditListBodyDeckSettings2.setId(Integer.valueOf(iIntValue));
                    mTEditListBodyDeckSettings2.setReplace(editContainerDialogFragment.replaceAllCards);
                    mTEditListBody.setDeck(mTEditListBodyDeckSettings2);
                }
            }
        }
        Function2<? super MTEditListBody, ? super Boolean, Unit> function2 = editContainerDialogFragment.onEditClicked;
        if (function2 != null) {
            function2.invoke(mTEditListBody, Boolean.valueOf(editContainerDialogFragment.convertList));
        }
        editContainerDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.util.List] */
    static final void onCreateView$lambda$27(final EditContainerDialogFragment editContainerDialogFragment, final EditText editText, View view, final List list) {
        Intrinsics.checkNotNull(list);
        List list2 = list;
        if (list2.isEmpty()) {
            editContainerDialogFragment.currentOnlineCommanderCards = new ArrayList();
            return;
        }
        editContainerDialogFragment.currentOnlineCommanderCards = CollectionsKt.toMutableList((Collection) list2);
        List list3 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        Iterator it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(((MTGCardRecord) it.next()).getTitle());
        }
        ArrayList<String> arrayList2 = arrayList;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        List<MTGCardRecord> list4 = editContainerDialogFragment.currentLocalCommanderCards;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        Iterator<T> it2 = list4.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((MTGCardRecord) it2.next()).getTitle());
        }
        objectRef.element = CollectionsKt.toMutableList((Collection) arrayList3);
        for (String str : arrayList2) {
            if (!((List) objectRef.element).contains(str)) {
                ((List) objectRef.element).add(str);
            }
        }
        PopupWindow popupWindow = editContainerDialogFragment.commanderPopupWindow;
        if (popupWindow != null) {
            Log.d(CreateDeckBottomSheetFragment.TAG, "Popup menu already up, updating... (commander)");
            ListView listView = (ListView) popupWindow.getContentView().findViewById(R.id.suggestions_list);
            listView.setAdapter((ListAdapter) new ArrayAdapter(editContainerDialogFragment.requireContext(), android.R.layout.simple_list_item_1, (List) objectRef.element));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda24
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                    EditContainerDialogFragment.onCreateView$lambda$27$2$0(objectRef, editContainerDialogFragment, editText, adapterView, view2, i, j);
                }
            });
            return;
        }
        Log.d(CreateDeckBottomSheetFragment.TAG, "Creating new popup menu (commander)");
        final EditText editText2 = view != null ? (EditText) view.findViewById(R.id.commanderEditText) : null;
        if (editText2 != null) {
            Object systemService = editContainerDialogFragment.requireContext().getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.popup_suggestions, (ViewGroup) null);
            editContainerDialogFragment.commanderPopupWindow = new PopupWindow(viewInflate, -2, -2, true);
            ListView listView2 = (ListView) viewInflate.findViewById(R.id.suggestions_list);
            listView2.setAdapter((ListAdapter) new ArrayAdapter(editContainerDialogFragment.requireContext(), android.R.layout.simple_list_item_1, (List) objectRef.element));
            final EditText editText3 = editText2;
            listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda25
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                    EditContainerDialogFragment.onCreateView$lambda$27$3$0$0(list, editContainerDialogFragment, editText2, editContainerDialogFragment, editText3, adapterView, view2, i, j);
                }
            });
            PopupWindow popupWindow2 = editContainerDialogFragment.commanderPopupWindow;
            if (popupWindow2 != null) {
                popupWindow2.setOutsideTouchable(true);
            }
            PopupWindow popupWindow3 = editContainerDialogFragment.commanderPopupWindow;
            if (popupWindow3 != null) {
                popupWindow3.setFocusable(false);
            }
            PopupWindow popupWindow4 = editContainerDialogFragment.commanderPopupWindow;
            if (popupWindow4 != null) {
                int[] iArr = new int[2];
                editText2.getLocationOnScreen(iArr);
                View contentView = popupWindow4.getContentView();
                contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                Size size = new Size(contentView.getMeasuredWidth(), contentView.getMeasuredHeight() * ((List) objectRef.element).size());
                int height = iArr[1] - editText2.getHeight();
                if (size.getHeight() > height) {
                    popupWindow4.setHeight(height);
                    size = new Size(popupWindow4.getContentView().getMeasuredWidth(), height);
                }
                if (size.getHeight() > 0) {
                    popupWindow4.setHeight(size.getHeight());
                }
                popupWindow4.showAtLocation(editText2, 8388659, iArr[0], iArr[1] - size.getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$27$2$0(Ref.ObjectRef objectRef, EditContainerDialogFragment editContainerDialogFragment, EditText editText, AdapterView adapterView, View view, int i, long j) {
        Object next;
        String str = (String) ((List) objectRef.element).get(i);
        Iterator<T> it = editContainerDialogFragment.currentLocalCommanderCards.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((MTGCardRecord) next).getTitle(), str)) {
                    break;
                }
            }
        }
        if (next == null) {
            Iterator<T> it2 = editContainerDialogFragment.currentOnlineCommanderCards.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    if (Intrinsics.areEqual(((MTGCardRecord) next).getTitle(), str)) {
                        break;
                    }
                }
            }
        }
        MTGCardRecord mTGCardRecord = (MTGCardRecord) next;
        if (mTGCardRecord == null || editText == null) {
            return;
        }
        editContainerDialogFragment.commanderLang = mTGCardRecord.getLang();
        editContainerDialogFragment.lastCommanderQuery = mTGCardRecord.getTitle();
        editText.setText(mTGCardRecord.getTitle());
        String scryfallId = mTGCardRecord.getScryfallId();
        if (scryfallId.length() <= 0) {
            scryfallId = null;
        }
        if (scryfallId == null) {
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = editContainerDialogFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            scryfallId = companion.getFirstPrintScryfallId(contextRequireContext, mTGCardRecord);
        }
        if (scryfallId != null) {
            mTGCardRecord.setScryfallId(scryfallId);
            editContainerDialogFragment.commander = scryfallId;
            editContainerDialogFragment.applyMTCardId(mTGCardRecord, "commander");
            editText.setBackground(editContainerDialogFragment.requireContext().getResources().getDrawable(R.drawable.black_box_valid, null));
            editText.clearFocus();
            editContainerDialogFragment.updateEditButtonState();
        }
        editContainerDialogFragment.acceptCommanderCard(mTGCardRecord);
        Object systemService = editContainerDialogFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        PopupWindow popupWindow = editContainerDialogFragment.commanderPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$27$3$0$0(List list, EditContainerDialogFragment editContainerDialogFragment, EditText editText, EditContainerDialogFragment editContainerDialogFragment2, EditText editText2, AdapterView adapterView, View view, int i, long j) {
        MTGCardRecord mTGCardRecord = (MTGCardRecord) list.get(i);
        editContainerDialogFragment.commanderLang = mTGCardRecord.getLang();
        editContainerDialogFragment.lastCommanderQuery = mTGCardRecord.getTitle();
        editText.setText(mTGCardRecord.getTitle());
        String scryfallId = mTGCardRecord.getScryfallId();
        if (scryfallId.length() <= 0) {
            scryfallId = null;
        }
        if (scryfallId == null) {
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = editContainerDialogFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            scryfallId = companion.getFirstPrintScryfallId(contextRequireContext, mTGCardRecord);
        }
        if (scryfallId != null) {
            mTGCardRecord.setScryfallId(scryfallId);
            editContainerDialogFragment2.commander = scryfallId;
            editContainerDialogFragment.applyMTCardId(mTGCardRecord, "commander");
            editText2.setBackground(editContainerDialogFragment.requireContext().getResources().getDrawable(R.drawable.black_box_valid, null));
            editText2.clearFocus();
            editContainerDialogFragment.updateEditButtonState();
        }
        editContainerDialogFragment2.acceptCommanderCard(mTGCardRecord);
        Object systemService = editContainerDialogFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText2.getWindowToken(), 0);
        PopupWindow popupWindow = editContainerDialogFragment2.commanderPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    static final boolean onCreateView$lambda$28(EditContainerDialogFragment editContainerDialogFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        Object systemService = editContainerDialogFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
        return true;
    }

    static final boolean onCreateView$lambda$29(EditText editText, EditContainerDialogFragment editContainerDialogFragment, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 || editText.getCompoundDrawables()[2] == null || motionEvent.getRawX() < editText.getRight() - (editText.getCompoundDrawables()[2].getBounds().width() * 2.0f)) {
            return false;
        }
        if (editContainerDialogFragment.getContext() == null) {
            return true;
        }
        editText.setText("");
        editContainerDialogFragment.commander = null;
        editContainerDialogFragment.updateEditButtonState();
        editText.requestFocus();
        Object systemService = editContainerDialogFragment.requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.util.List] */
    static final void onCreateView$lambda$30(final EditContainerDialogFragment editContainerDialogFragment, final View view, final List list) {
        Intrinsics.checkNotNull(list);
        List list2 = list;
        if (list2.isEmpty()) {
            editContainerDialogFragment.currentOnlinePartnerCards = new ArrayList();
            return;
        }
        editContainerDialogFragment.currentOnlinePartnerCards = CollectionsKt.toMutableList((Collection) list2);
        List list3 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        Iterator it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(((MTGCardRecord) it.next()).getTitle());
        }
        ArrayList<String> arrayList2 = arrayList;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        List<MTGCardRecord> list4 = editContainerDialogFragment.currentLocalPartnerCards;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        Iterator<T> it2 = list4.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((MTGCardRecord) it2.next()).getTitle());
        }
        objectRef.element = CollectionsKt.toMutableList((Collection) arrayList3);
        for (String str : arrayList2) {
            if (!((List) objectRef.element).contains(str)) {
                ((List) objectRef.element).add(str);
            }
        }
        PopupWindow popupWindow = editContainerDialogFragment.partnerPopupWindow;
        if (popupWindow != null) {
            ListView listView = (ListView) popupWindow.getContentView().findViewById(R.id.suggestions_list);
            listView.setAdapter((ListAdapter) new ArrayAdapter(editContainerDialogFragment.requireContext(), android.R.layout.simple_list_item_1, (List) objectRef.element));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda22
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                    EditContainerDialogFragment.onCreateView$lambda$30$2$0(objectRef, editContainerDialogFragment, view, adapterView, view2, i, j);
                }
            });
            return;
        }
        final EditText editText = view != null ? (EditText) view.findViewById(R.id.partnerEditText) : null;
        if (editText != null) {
            Object systemService = editContainerDialogFragment.requireContext().getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.popup_suggestions, (ViewGroup) null);
            editContainerDialogFragment.partnerPopupWindow = new PopupWindow(viewInflate, -2, -2, true);
            ListView listView2 = (ListView) viewInflate.findViewById(R.id.suggestions_list);
            listView2.setAdapter((ListAdapter) new ArrayAdapter(editContainerDialogFragment.requireContext(), android.R.layout.simple_list_item_1, (List) objectRef.element));
            final EditText editText2 = editText;
            listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda23
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                    EditContainerDialogFragment.onCreateView$lambda$30$3$0$0(list, editContainerDialogFragment, editText, editText2, editContainerDialogFragment, adapterView, view2, i, j);
                }
            });
            PopupWindow popupWindow2 = editContainerDialogFragment.partnerPopupWindow;
            if (popupWindow2 != null) {
                popupWindow2.setOutsideTouchable(true);
            }
            PopupWindow popupWindow3 = editContainerDialogFragment.partnerPopupWindow;
            if (popupWindow3 != null) {
                popupWindow3.setFocusable(false);
            }
            PopupWindow popupWindow4 = editContainerDialogFragment.partnerPopupWindow;
            if (popupWindow4 != null) {
                int[] iArr = new int[2];
                editText.getLocationOnScreen(iArr);
                View contentView = popupWindow4.getContentView();
                contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                Size size = new Size(contentView.getMeasuredWidth(), contentView.getMeasuredHeight() * ((List) objectRef.element).size());
                int height = iArr[1] - editText.getHeight();
                if (size.getHeight() > height) {
                    popupWindow4.setHeight(height);
                    size = new Size(popupWindow4.getContentView().getMeasuredWidth(), height);
                }
                if (size.getHeight() > 0) {
                    popupWindow4.setHeight(size.getHeight());
                }
                popupWindow4.showAtLocation(editText, 8388659, iArr[0], iArr[1] - size.getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$30$2$0(Ref.ObjectRef objectRef, EditContainerDialogFragment editContainerDialogFragment, View view, AdapterView adapterView, View view2, int i, long j) {
        Object next;
        String str = (String) ((List) objectRef.element).get(i);
        Iterator<T> it = editContainerDialogFragment.currentLocalPartnerCards.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((MTGCardRecord) next).getTitle(), str)) {
                    break;
                }
            }
        }
        if (next == null) {
            Iterator<T> it2 = editContainerDialogFragment.currentOnlinePartnerCards.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    if (Intrinsics.areEqual(((MTGCardRecord) next).getTitle(), str)) {
                        break;
                    }
                }
            }
        }
        MTGCardRecord mTGCardRecord = (MTGCardRecord) next;
        if (mTGCardRecord != null) {
            EditText editText = view != null ? (EditText) view.findViewById(R.id.partnerEditText) : null;
            if (editText != null) {
                editContainerDialogFragment.lastPartnerQuery = mTGCardRecord.getTitle();
                editText.setText(mTGCardRecord.getTitle());
                editContainerDialogFragment.partnerLang = mTGCardRecord.getLang();
                String scryfallId = mTGCardRecord.getScryfallId();
                if (scryfallId.length() <= 0) {
                    scryfallId = null;
                }
                if (scryfallId == null) {
                    GameUtils companion = GameUtils.INSTANCE.getInstance();
                    Context contextRequireContext = editContainerDialogFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    scryfallId = companion.getFirstPrintScryfallId(contextRequireContext, mTGCardRecord);
                }
                if (scryfallId != null) {
                    editContainerDialogFragment.partner = scryfallId;
                    editContainerDialogFragment.applyMTCardId(mTGCardRecord, "partner");
                    editText.setBackground(editContainerDialogFragment.requireContext().getResources().getDrawable(R.drawable.black_box_valid, null));
                    editText.clearFocus();
                }
                Object systemService = editContainerDialogFragment.requireActivity().getSystemService("input_method");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                PopupWindow popupWindow = editContainerDialogFragment.partnerPopupWindow;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$30$3$0$0(List list, EditContainerDialogFragment editContainerDialogFragment, EditText editText, EditText editText2, EditContainerDialogFragment editContainerDialogFragment2, AdapterView adapterView, View view, int i, long j) {
        MTGCardRecord mTGCardRecord = (MTGCardRecord) list.get(i);
        editContainerDialogFragment.lastPartnerQuery = mTGCardRecord.getTitle();
        editText.setText(mTGCardRecord.getTitle());
        editContainerDialogFragment.partnerLang = mTGCardRecord.getLang();
        String scryfallId = mTGCardRecord.getScryfallId();
        if (scryfallId.length() <= 0) {
            scryfallId = null;
        }
        if (scryfallId == null) {
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = editContainerDialogFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            scryfallId = companion.getFirstPrintScryfallId(contextRequireContext, mTGCardRecord);
        }
        if (scryfallId != null) {
            editContainerDialogFragment2.partner = scryfallId;
            editContainerDialogFragment.applyMTCardId(mTGCardRecord, "partner");
            editText2.setBackground(editContainerDialogFragment.requireContext().getResources().getDrawable(R.drawable.black_box_valid, null));
            editText2.clearFocus();
        }
        Object systemService = editContainerDialogFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText2.getWindowToken(), 0);
        PopupWindow popupWindow = editContainerDialogFragment2.partnerPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    static final boolean onCreateView$lambda$31(EditContainerDialogFragment editContainerDialogFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        Object systemService = editContainerDialogFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
        return true;
    }

    static final boolean onCreateView$lambda$32(EditText editText, EditContainerDialogFragment editContainerDialogFragment, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 || editText.getCompoundDrawables()[2] == null || motionEvent.getRawX() < editText.getRight() - (editText.getCompoundDrawables()[2].getBounds().width() * 2.0f)) {
            return false;
        }
        if (editContainerDialogFragment.getContext() == null) {
            return true;
        }
        editText.setText("");
        editContainerDialogFragment.partner = null;
        editText.requestFocus();
        Object systemService = editContainerDialogFragment.requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        return true;
    }

    static final Unit onCreateView$lambda$4(EditContainerDialogFragment editContainerDialogFragment, ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        editContainerDialogFragment.faceCard = null;
        constraintLayout.setVisibility(8);
        textView.setVisibility(0);
        textView2.setText(editContainerDialogFragment.getResources().getString(R.string.select));
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$5(EditContainerDialogFragment editContainerDialogFragment) {
        editContainerDialogFragment.showCardSelectionInterface();
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$6(LinearLayout linearLayout, LinearLayout linearLayout2, EditContainerDialogFragment editContainerDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            linearLayout.setVisibility(0);
            linearLayout2.setVisibility(8);
            editContainerDialogFragment.updateEditButtonState();
        }
    }

    static final void onCreateView$lambda$7(LinearLayout linearLayout, LinearLayout linearLayout2, EditContainerDialogFragment editContainerDialogFragment, TextView textView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(0);
            editContainerDialogFragment.creatingDeck = true;
            textView.setText(editContainerDialogFragment.getResources().getString(R.string.deck_select));
            textView.setTextColor(ContextCompat.getColor(editContainerDialogFragment.requireContext(), R.color.text_color));
            editContainerDialogFragment.updateEditButtonState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performCommanderSearch(String str, Continuation<? super Unit> continuation) {
        if (getContext() == null) {
            return Unit.INSTANCE;
        }
        String str2 = str;
        if (StringsKt.trim((CharSequence) str2).toString().length() == 0) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        EditContainerDialogFragment.performCommanderSearch$lambda$0(this.f$0);
                    }
                });
            }
            return Unit.INSTANCE;
        }
        JobKt.ensureActive(GlobalScope.INSTANCE.getCoroutineContext());
        if (StringsKt.trim((CharSequence) str2).toString().length() >= 2) {
            Log.d(CreateDeckBottomSheetFragment.TAG, "------ NEW SEARCH : " + str);
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass3(str, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    static final void performCommanderSearch$lambda$0(EditContainerDialogFragment editContainerDialogFragment) {
        if (editContainerDialogFragment.getContext() == null) {
            return;
        }
        Log.d(CreateDeckBottomSheetFragment.TAG, "!!! Empty QUERY !!!");
        editContainerDialogFragment.currentOnlineCommanderCards = new ArrayList();
        editContainerDialogFragment.currentLocalCommanderCards = new ArrayList();
        View view = editContainerDialogFragment.getView();
        EditText editText = view != null ? (EditText) view.findViewById(R.id.commanderEditText) : null;
        if (editText != null) {
            editText.setBackground(ContextCompat.getDrawable(editContainerDialogFragment.requireContext(), R.drawable.black_box_not_ok));
            PopupWindow popupWindow = editContainerDialogFragment.commanderPopupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
                editContainerDialogFragment.commanderPopupWindow = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performPartnerSearch(String str, Continuation<? super Unit> continuation) {
        FragmentActivity activity;
        if (getContext() == null) {
            return Unit.INSTANCE;
        }
        String str2 = str;
        if (StringsKt.trim((CharSequence) str2).toString().length() == 0 && (activity = getActivity()) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    EditContainerDialogFragment.performPartnerSearch$lambda$0(this.f$0);
                }
            });
        }
        JobKt.ensureActive(GlobalScope.INSTANCE.getCoroutineContext());
        if (StringsKt.trim((CharSequence) str2).toString().length() >= 2) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C11653(str, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    static final void performPartnerSearch$lambda$0(EditContainerDialogFragment editContainerDialogFragment) {
        if (editContainerDialogFragment.getContext() == null) {
            return;
        }
        editContainerDialogFragment.currentLocalPartnerCards = new ArrayList();
        editContainerDialogFragment.currentOnlinePartnerCards = new ArrayList();
        View view = editContainerDialogFragment.getView();
        EditText editText = view != null ? (EditText) view.findViewById(R.id.partnerEditText) : null;
        if (editText != null) {
            editText.setBackground(ContextCompat.getDrawable(editContainerDialogFragment.requireContext(), R.drawable.black_box_not_ok));
            PopupWindow popupWindow = editContainerDialogFragment.partnerPopupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
                editContainerDialogFragment.partnerPopupWindow = null;
            }
        }
    }

    private final void showCardSelectionInterface() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        CardPickerBottomSheetFragment.INSTANCE.newInstance(new CardPickerCallback() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$showCardSelectionInterface$cardPickerBottomSheet$1
            @Override // com.studiolaganne.lengendarylens.CardPickerCallback
            public void onCardPickerClosed() {
            }

            @Override // com.studiolaganne.lengendarylens.CardPickerCallback
            public void onCardSelected(MTSimpleCard card, int face) {
                Intrinsics.checkNotNullParameter(card, "card");
                this.this$0.faceCard = card;
                this.this$0.updateFaceCardUI();
            }
        }, null, "_blank_", preferencesManager.getString(PreferencesManager.LAST_CARD_PICKER_LANGUAGE, preferencesManager.getDeviceLanguage())).show(getParentFragmentManager(), CardPickerBottomSheetFragment.TAG);
    }

    private final void showColorPickerDialog() {
        ListColorPickerDialogFragment listColorPickerDialogFragmentNewInstance = ListColorPickerDialogFragment.INSTANCE.newInstance();
        listColorPickerDialogFragmentNewInstance.setColorPickerListener(new ListColorPickerDialogFragment.ColorPickerListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment.showColorPickerDialog.1
            @Override // com.studiolaganne.lengendarylens.ListColorPickerDialogFragment.ColorPickerListener
            public void onColorCleared() {
                EditContainerDialogFragment.this.selectedColor = null;
                EditContainerDialogFragment.this.colorExplicitlyCleared = true;
                EditContainerDialogFragment.this.updateColorCircle();
            }

            @Override // com.studiolaganne.lengendarylens.ListColorPickerDialogFragment.ColorPickerListener
            public void onColorSelected(String colorHex) {
                Intrinsics.checkNotNullParameter(colorHex, "colorHex");
                EditContainerDialogFragment.this.selectedColor = colorHex;
                EditContainerDialogFragment.this.colorExplicitlyCleared = false;
                EditContainerDialogFragment.this.updateColorCircle();
            }
        });
        listColorPickerDialogFragmentNewInstance.show(getParentFragmentManager(), "colorPicker");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateColorCircle() {
        try {
            ImageView imageView = this.colorImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("colorImageView");
                imageView = null;
            }
            Drawable drawable = imageView.getDrawable();
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            String str = this.selectedColor;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                if (!StringsKt.startsWith$default(str, ColorKt.HEX_PREFIX, false, 2, (Object) null)) {
                    str = ColorKt.HEX_PREFIX + str;
                }
                gradientDrawable.setColor(Color.parseColor(str));
                return;
            }
            gradientDrawable.setColor(Color.parseColor("#FF979A9A"));
        } catch (Exception e) {
            Log.e("EditContainerDialog", "Error updating color: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEditButtonState() {
        this.buttonEnabled = true;
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.editButtonText) : null;
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
        }
        if (this.container == null || !this.convertDeck) {
            return;
        }
        if (!this.creatingDeck) {
            if (this.selectedDeckId == null) {
                this.buttonEnabled = false;
                if (textView != null) {
                    textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.middle_grey));
                    return;
                }
                return;
            }
            return;
        }
        MTFormat mTFormat = this.format;
        if (mTFormat == null || (mTFormat.getHascommander() && this.commander == null)) {
            this.buttonEnabled = false;
            if (textView != null) {
                textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.middle_grey));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFaceCardUI() {
        View view;
        String gatherer;
        if (getContext() == null || (view = getView()) == null) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.faceCardLayout);
        TextView textView = (TextView) view.findViewById(R.id.noFaceCardTextView);
        ImageView imageView = (ImageView) view.findViewById(R.id.faceCardImage);
        TextView textView2 = (TextView) view.findViewById(R.id.selectText);
        MTSimpleCard mTSimpleCard = this.faceCard;
        if (mTSimpleCard == null) {
            constraintLayout.setVisibility(8);
            textView.setVisibility(0);
            textView2.setText(getResources().getString(R.string.select));
            return;
        }
        constraintLayout.setVisibility(0);
        textView.setVisibility(8);
        textView2.setText(getResources().getString(R.string.change_face_card));
        MTImageURIs image_uris = mTSimpleCard.getImage_uris();
        if (image_uris == null || (gatherer = image_uris.getNormal()) == null) {
            MTImageURIs image_uris2 = mTSimpleCard.getImage_uris();
            gatherer = image_uris2 != null ? image_uris2.getGatherer() : null;
            if (gatherer == null) {
                gatherer = "";
            }
        }
        if (gatherer.length() == 0) {
            CardImageCache cardImageCache = CardImageCache.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            String scryfall_id = mTSimpleCard.getScryfall_id();
            if (scryfall_id == null) {
                scryfall_id = "";
            }
            String imageUrl = cardImageCache.getImageUrl(contextRequireContext, scryfall_id, 0);
            gatherer = imageUrl != null ? imageUrl : "";
        }
        if (gatherer.length() > 0) {
            Intrinsics.checkNotNull(Glide.with(requireContext()).load(gatherer).transform(new RoundedCorners(10)).placeholder(R.drawable.card_back).into(imageView));
        } else {
            imageView.setImageResource(R.drawable.card_fail);
        }
    }

    public final String getCommander() {
        return this.commander;
    }

    public final String getCommanderCardId() {
        return this.commanderCardId;
    }

    public final String getCommanderLang() {
        return this.commanderLang;
    }

    public final PopupWindow getCommanderPopupWindow() {
        return this.commanderPopupWindow;
    }

    public final MTGDBHelper getDbHelper() {
        return this.dbHelper;
    }

    public final String getLeftplaymatCardId() {
        return this.leftplaymatCardId;
    }

    public final Integer getLeftplaymatFaceIndex() {
        return this.leftplaymatFaceIndex;
    }

    public final MTGDBHelperLocalized getLocalizedHelper() {
        return this.localizedHelper;
    }

    public final List<MTGDBHelperLocalized> getLocalizedHelpers() {
        return this.localizedHelpers;
    }

    public final String getPartner() {
        return this.partner;
    }

    public final String getPartnerCardId() {
        return this.partnerCardId;
    }

    public final String getPartnerLang() {
        return this.partnerLang;
    }

    public final PopupWindow getPartnerPopupWindow() {
        return this.partnerPopupWindow;
    }

    public final String getPartnerSignatureSpellCardId() {
        return this.partnerSignatureSpellCardId;
    }

    public final String getPartnersignaturespell() {
        return this.partnersignaturespell;
    }

    public final String getRightplaymatCardId() {
        return this.rightplaymatCardId;
    }

    public final Integer getRightplaymatFaceIndex() {
        return this.rightplaymatFaceIndex;
    }

    public final Job getSearchCommanderJob() {
        return this.searchCommanderJob;
    }

    public final Job getSearchPartnerJob() {
        return this.searchPartnerJob;
    }

    public final String getSignatureSpellCardId() {
        return this.signatureSpellCardId;
    }

    public final String getSignaturespell() {
        return this.signaturespell;
    }

    /* JADX INFO: renamed from: isBackground, reason: from getter */
    public final boolean getIsBackground() {
        return this.isBackground;
    }

    /* JADX INFO: renamed from: isDoctor, reason: from getter */
    public final boolean getIsDoctor() {
        return this.isDoctor;
    }

    /* JADX INFO: renamed from: isDoctorCompanion, reason: from getter */
    public final boolean getIsDoctorCompanion() {
        return this.isDoctorCompanion;
    }

    /* JADX INFO: renamed from: isFriendsForever, reason: from getter */
    public final boolean getIsFriendsForever() {
        return this.isFriendsForever;
    }

    /* JADX INFO: renamed from: isPartner, reason: from getter */
    public final boolean getIsPartner() {
        return this.isPartner;
    }

    /* JADX INFO: renamed from: isSignatureSpell, reason: from getter */
    public final boolean getIsSignatureSpell() {
        return this.isSignatureSpell;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x02e8 A[PHI: r19
      0x02e8: PHI (r19v4 android.widget.RadioButton) = (r19v2 android.widget.RadioButton), (r19v5 android.widget.RadioButton) binds: [B:66:0x02c7, B:71:0x02d5] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout;
        RadioButton radioButton;
        char c;
        MTCardSearchViewModel mTCardSearchViewModel;
        int iIntValue;
        String gatherer;
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final View viewInflate = inflater.inflate(R.layout.edit_container_dialog, container, false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            Unit unit = Unit.INSTANCE;
        }
        final EditText editText = (EditText) viewInflate.findViewById(R.id.listNameEditText);
        View viewFindViewById = viewInflate.findViewById(R.id.listColorImageView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.colorImageView = (ImageView) viewFindViewById;
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.listNameInputLayout);
        MTCardContainer mTCardContainer = this.container;
        if (mTCardContainer != null) {
            editText.setText(mTCardContainer.getName());
            Integer type = mTCardContainer.getType();
            if (type != null && type.intValue() == 2) {
                textInputLayout.setHint(getResources().getString(R.string.box_name));
            } else {
                Integer type2 = mTCardContainer.getType();
                if (type2 != null && type2.intValue() == 1) {
                    textInputLayout.setHint(getResources().getString(R.string.binder_name));
                } else {
                    textInputLayout.setHint(getResources().getString(R.string.list_name));
                }
            }
            String color = mTCardContainer.getColor();
            this.selectedColor = color != null ? StringsKt.replace$default(color, ColorKt.HEX_PREFIX, "", false, 4, (Object) null) : null;
            updateColorCircle();
            updateEditButtonState();
            Unit unit2 = Unit.INSTANCE;
        } else {
            if (this.isCollection) {
                textInputLayout.setHint(getResources().getString(R.string.new_container_name));
            } else {
                textInputLayout.setHint(getResources().getString(R.string.new_list_name));
            }
            editText.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    EditContainerDialogFragment.onCreateView$lambda$1$0(editText, this);
                }
            }, 100L);
            View viewFindViewById2 = viewInflate.findViewById(R.id.editButtonText);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            ((TextView) viewFindViewById2).setText(getResources().getString(R.string.create));
            Unit unit3 = Unit.INSTANCE;
        }
        ImageView imageView = this.colorImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorImageView");
            imageView = null;
        }
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditContainerDialogFragment.onCreateView$lambda$2(this.f$0);
            }
        });
        View viewFindViewById3 = viewInflate.findViewById(R.id.faceCardLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.noFaceCardTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        final TextView textView = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.selectButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.selectText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        final TextView textView2 = (TextView) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.faceCardImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        ImageView imageView2 = (ImageView) viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(R.id.removeFaceCardImageView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        ImageView imageView3 = (ImageView) viewFindViewById8;
        View viewFindViewById9 = viewInflate.findViewById(R.id.convertToDeckCheckBox);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        final CheckBox checkBox = (CheckBox) viewFindViewById9;
        checkBox.setVisibility(8);
        constraintLayout.setVisibility(8);
        MTCardContainer mTCardContainer2 = this.container;
        if (mTCardContainer2 != null) {
            checkBox.setVisibility(0);
            MTSimpleCard faceCard = mTCardContainer2.getFaceCard();
            if (faceCard != null) {
                constraintLayout.setVisibility(0);
                textView.setVisibility(8);
                constraintLayout2.setVisibility(0);
                textView2.setText(getResources().getString(R.string.change_face_card));
                MTImageURIs image_uris = faceCard.getImage_uris();
                if (image_uris == null || (gatherer = image_uris.getNormal()) == null) {
                    MTImageURIs image_uris2 = faceCard.getImage_uris();
                    gatherer = image_uris2 != null ? image_uris2.getGatherer() : null;
                    if (gatherer == null) {
                        gatherer = "";
                    }
                }
                if (gatherer.length() > 0) {
                    Glide.with(requireContext()).load(gatherer).transform(new RoundedCorners(10)).placeholder(R.drawable.card_back).into(imageView2);
                    this.faceCard = faceCard;
                } else {
                    imageView2.setImageResource(R.drawable.card_fail);
                }
                Unit unit4 = Unit.INSTANCE;
            } else {
                constraintLayout.setVisibility(8);
                Unit unit5 = Unit.INSTANCE;
            }
            Unit unit6 = Unit.INSTANCE;
            Unit unit7 = Unit.INSTANCE;
        }
        ViewExtensionsKt.setOnClickWithFade(imageView3, new Function0() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditContainerDialogFragment.onCreateView$lambda$4(this.f$0, constraintLayout, textView, textView2);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditContainerDialogFragment.onCreateView$lambda$5(this.f$0);
            }
        });
        View viewFindViewById10 = viewInflate.findViewById(R.id.deckRadioButtonsLinearLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        LinearLayout linearLayout2 = (LinearLayout) viewFindViewById10;
        View viewFindViewById11 = viewInflate.findViewById(R.id.addToExistingDeckLinearLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        final LinearLayout linearLayout3 = (LinearLayout) viewFindViewById11;
        View viewFindViewById12 = viewInflate.findViewById(R.id.createDeckLinearLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        final LinearLayout linearLayout4 = (LinearLayout) viewFindViewById12;
        View viewFindViewById13 = viewInflate.findViewById(R.id.addToDeckButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        RadioButton radioButton2 = (RadioButton) viewFindViewById13;
        View viewFindViewById14 = viewInflate.findViewById(R.id.createNewDeckButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        final RadioButton radioButton3 = (RadioButton) viewFindViewById14;
        View viewFindViewById15 = viewInflate.findViewById(R.id.deckSelectionLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        LinearLayout linearLayout5 = (LinearLayout) viewFindViewById15;
        View viewFindViewById16 = viewInflate.findViewById(R.id.deckNameTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        final TextView textView3 = (TextView) viewFindViewById16;
        View viewFindViewById17 = viewInflate.findViewById(R.id.replaceCardsCheckBox);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        CheckBox checkBox2 = (CheckBox) viewFindViewById17;
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda16
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EditContainerDialogFragment.onCreateView$lambda$6(linearLayout3, linearLayout4, this, compoundButton, z);
            }
        });
        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda17
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EditContainerDialogFragment.onCreateView$lambda$7(linearLayout3, linearLayout4, this, textView3, compoundButton, z);
            }
        });
        View viewFindViewById18 = viewInflate.findViewById(R.id.moveToCheckBox);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        final CheckBox checkBox3 = (CheckBox) viewFindViewById18;
        checkBox3.setChecked(false);
        final LinearLayout linearLayout6 = (LinearLayout) viewInflate.findViewById(R.id.radioButtonsLinearLayout);
        linearLayout6.setVisibility(8);
        MTCardContainer mTCardContainer3 = this.container;
        if (mTCardContainer3 != null) {
            Integer type3 = mTCardContainer3.getType();
            if (type3 != null) {
                linearLayout = linearLayout2;
                iIntValue = type3.intValue();
            } else {
                linearLayout = linearLayout2;
                iIntValue = 2;
            }
            this.convertType = iIntValue;
            Integer type4 = mTCardContainer3.getType();
            if (type4 == null) {
                radioButton = radioButton2;
            } else {
                radioButton = radioButton2;
                if (type4.intValue() == 2) {
                    checkBox3.setText(getResources().getString(R.string.move_to_list));
                    Unit unit8 = Unit.INSTANCE;
                    c = 2;
                }
            }
            Integer type5 = mTCardContainer3.getType();
            if (type5 == null || type5.intValue() != 1) {
                checkBox3.setText(getResources().getString(R.string.move_to_collection));
            }
            Unit unit82 = Unit.INSTANCE;
            c = 2;
        } else {
            linearLayout = linearLayout2;
            radioButton = radioButton2;
            checkBox3.setVisibility(8);
            if (this.isCollection) {
                c = 2;
                this.convertType = 2;
                linearLayout6.setVisibility(0);
            } else {
                c = 2;
                this.convertType = 0;
                linearLayout6.setVisibility(8);
            }
            Unit unit9 = Unit.INSTANCE;
        }
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda18
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EditContainerDialogFragment.onCreateView$lambda$10(checkBox, this, linearLayout6, compoundButton, z);
            }
        });
        final LinearLayout linearLayout7 = linearLayout;
        final RadioButton radioButton4 = radioButton;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda19
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EditContainerDialogFragment.onCreateView$lambda$11(this.f$0, checkBox3, linearLayout7, radioButton4, radioButton3, linearLayout3, linearLayout4, linearLayout6, checkBox, compoundButton, z);
            }
        });
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        LinearLayout linearLayout8 = linearLayout5;
        final PopupMenu popupMenu = new PopupMenu(requireContext(), linearLayout8);
        if (preferencesManager.getCurrentUser() != null) {
            List<MTDeck> currentUserDecks = preferencesManager.getCurrentUserDecks();
            if (currentUserDecks.isEmpty()) {
                popupMenu.getMenu().add(0, -1, 0, getResources().getString(R.string.no_decks_available)).setEnabled(false);
            } else {
                for (MTDeck mTDeck : currentUserDecks) {
                    popupMenu.getMenu().add(0, mTDeck.getId(), 0, mTDeck.getName());
                }
            }
            Unit unit10 = Unit.INSTANCE;
            Unit unit11 = Unit.INSTANCE;
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda20
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return EditContainerDialogFragment.onCreateView$lambda$13(textView3, this, menuItem);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(linearLayout8, new Function0() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditContainerDialogFragment.onCreateView$lambda$14(popupMenu);
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda27
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EditContainerDialogFragment.onCreateView$lambda$15(this.f$0, compoundButton, z);
            }
        });
        View viewFindViewById19 = viewInflate.findViewById(R.id.boxButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        View viewFindViewById20 = viewInflate.findViewById(R.id.binderButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById20, "findViewById(...)");
        ((RadioButton) viewFindViewById19).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda28
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EditContainerDialogFragment.onCreateView$lambda$16(this.f$0, compoundButton, z);
            }
        });
        ((RadioButton) viewFindViewById20).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda29
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EditContainerDialogFragment.onCreateView$lambda$17(this.f$0, compoundButton, z);
            }
        });
        View viewFindViewById21 = viewInflate.findViewById(R.id.formatLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById21, "findViewById(...)");
        LinearLayout linearLayout9 = (LinearLayout) viewFindViewById21;
        View viewFindViewById22 = viewInflate.findViewById(R.id.formatTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById22, "findViewById(...)");
        final TextView textView4 = (TextView) viewFindViewById22;
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        final List mutableList = CollectionsKt.toMutableList((Collection) companion.getInstance(contextRequireContext2).getFormats());
        if (mutableList.size() > 1) {
            CollectionsKt.sortWith(mutableList, new Comparator() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$onCreateView$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((MTFormat) t).getName(), ((MTFormat) t2).getName());
                }
            });
        }
        LinearLayout linearLayout10 = linearLayout9;
        final PopupMenu popupMenu2 = new PopupMenu(requireContext(), linearLayout10);
        ArrayList<MTFormat> arrayList = new ArrayList();
        List<String> mainFormatIds = GameUtils.INSTANCE.getInstance().getMainFormatIds();
        List<MTFormat> list = mutableList;
        for (MTFormat mTFormat : list) {
            if (mainFormatIds.contains(mTFormat.getScryfallid())) {
                arrayList.add(mTFormat);
            }
        }
        for (MTFormat mTFormat2 : arrayList) {
            popupMenu2.getMenu().add(0, mTFormat2.getId(), 0, mTFormat2.getName());
        }
        popupMenu2.getMenu().add(-1, -1, 0, getResources().getString(R.string.other_formats));
        final PopupMenu popupMenu3 = new PopupMenu(requireContext(), linearLayout10);
        Menu menu = popupMenu3.getMenu();
        for (MTFormat mTFormat3 : list) {
            menu.add(0, mTFormat3.getId(), 0, mTFormat3.getName());
        }
        View viewFindViewById23 = viewInflate.findViewById(R.id.commanderEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById23, "findViewById(...)");
        final EditText editText2 = (EditText) viewFindViewById23;
        View viewFindViewById24 = viewInflate.findViewById(R.id.partnerEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById24, "findViewById(...)");
        final EditText editText3 = (EditText) viewFindViewById24;
        popupMenu3.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda1
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return EditContainerDialogFragment.onCreateView$lambda$22(textView4, this, mutableList, editText2, menuItem);
            }
        });
        popupMenu2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda2
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return EditContainerDialogFragment.onCreateView$lambda$23(popupMenu3, textView4, this, mutableList, editText2, menuItem);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(linearLayout10, new Function0() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditContainerDialogFragment.onCreateView$lambda$24(popupMenu2);
            }
        });
        ConstraintLayout constraintLayout3 = (ConstraintLayout) viewInflate.findViewById(R.id.cancelButtonLayout);
        Intrinsics.checkNotNull(constraintLayout3);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout3, new Function0() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditContainerDialogFragment.onCreateView$lambda$25(this.f$0);
            }
        });
        ConstraintLayout constraintLayout4 = (ConstraintLayout) viewInflate.findViewById(R.id.editButtonLayout);
        Intrinsics.checkNotNull(constraintLayout4);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout4, new Function0() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditContainerDialogFragment.onCreateView$lambda$26(this.f$0, editText, editText2);
            }
        });
        EditContainerDialogFragment editContainerDialogFragment = this;
        MTCardSearchViewModelFactory mTCardSearchViewModelFactory = new MTCardSearchViewModelFactory();
        this.searchViewModel = (MTCardSearchViewModel) new ViewModelProvider(editContainerDialogFragment, mTCardSearchViewModelFactory).get("commander", MTCardSearchViewModel.class);
        this.partnerSearchViewModel = (MTCardSearchViewModel) new ViewModelProvider(editContainerDialogFragment, mTCardSearchViewModelFactory).get("partner", MTCardSearchViewModel.class);
        String deviceLanguage = preferencesManager.getDeviceLanguage();
        MTGDBHelper.Companion companion2 = MTGDBHelper.INSTANCE;
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        this.dbHelper = companion2.getInstance(contextRequireContext3);
        MTGDBHelperLocalized.Companion companion3 = MTGDBHelperLocalized.INSTANCE;
        Context contextRequireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
        this.localizedHelper = companion3.getInstance(contextRequireContext4, deviceLanguage);
        MTCardSearchViewModel mTCardSearchViewModel2 = this.searchViewModel;
        if (mTCardSearchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchViewModel");
            mTCardSearchViewModel2 = null;
        }
        mTCardSearchViewModel2.getSearchResults().observe(requireActivity(), new Observer() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditContainerDialogFragment.onCreateView$lambda$27(this.f$0, editText2, viewInflate, (List) obj);
            }
        });
        editText2.setInputType(524288);
        editText2.setImportantForAutofill(2);
        editText2.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda7
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView5, int i, KeyEvent keyEvent) {
                return EditContainerDialogFragment.onCreateView$lambda$28(this.f$0, textView5, i, keyEvent);
            }
        });
        editText2.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return EditContainerDialogFragment.onCreateView$lambda$29(editText2, this, view, motionEvent);
            }
        });
        editText2.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment.onCreateView.30
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    editText2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {
                    editText2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_clear, 0);
                }
                String strValueOf = String.valueOf(s);
                if (Intrinsics.areEqual(strValueOf, "")) {
                    editText2.setBackground(ContextCompat.getDrawable(this.requireContext(), R.drawable.black_box_not_ok));
                    PopupWindow commanderPopupWindow = this.getCommanderPopupWindow();
                    if (commanderPopupWindow != null) {
                        commanderPopupWindow.dismiss();
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(strValueOf, this.lastCommanderQuery)) {
                    return;
                }
                this.lastCommanderQuery = strValueOf;
                Job searchCommanderJob = this.getSearchCommanderJob();
                if (searchCommanderJob != null) {
                    Job.DefaultImpls.cancel$default(searchCommanderJob, (CancellationException) null, 1, (Object) null);
                }
                EditContainerDialogFragment editContainerDialogFragment2 = this;
                editContainerDialogFragment2.setSearchCommanderJob(BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(editContainerDialogFragment2), Dispatchers.getIO(), null, new EditContainerDialogFragment$onCreateView$30$afterTextChanged$2(this, strValueOf, null), 2, null));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        MTCardSearchViewModel mTCardSearchViewModel3 = this.partnerSearchViewModel;
        if (mTCardSearchViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partnerSearchViewModel");
            mTCardSearchViewModel = null;
        } else {
            mTCardSearchViewModel = mTCardSearchViewModel3;
        }
        mTCardSearchViewModel.getSearchResults().observe(requireActivity(), new Observer() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditContainerDialogFragment.onCreateView$lambda$30(this.f$0, viewInflate, (List) obj);
            }
        });
        editText3.setInputType(524288);
        editText3.setImportantForAutofill(2);
        editText3.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda12
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView5, int i, KeyEvent keyEvent) {
                return EditContainerDialogFragment.onCreateView$lambda$31(this.f$0, textView5, i, keyEvent);
            }
        });
        editText3.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return EditContainerDialogFragment.onCreateView$lambda$32(editText3, this, view, motionEvent);
            }
        });
        editText3.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.EditContainerDialogFragment.onCreateView.34
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    editText3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {
                    editText3.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_clear, 0);
                }
                String strValueOf = String.valueOf(s);
                if (Intrinsics.areEqual(strValueOf, "")) {
                    editText3.setBackground(ContextCompat.getDrawable(this.requireContext(), R.drawable.black_box_not_ok));
                    PopupWindow partnerPopupWindow = this.getPartnerPopupWindow();
                    if (partnerPopupWindow != null) {
                        partnerPopupWindow.dismiss();
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(strValueOf, this.lastPartnerQuery)) {
                    return;
                }
                this.lastPartnerQuery = strValueOf;
                Job searchPartnerJob = this.getSearchPartnerJob();
                if (searchPartnerJob != null) {
                    Job.DefaultImpls.cancel$default(searchPartnerJob, (CancellationException) null, 1, (Object) null);
                }
                EditContainerDialogFragment editContainerDialogFragment2 = this;
                editContainerDialogFragment2.setSearchPartnerJob(BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(editContainerDialogFragment2), Dispatchers.getIO(), null, new EditContainerDialogFragment$onCreateView$34$afterTextChanged$2(this, strValueOf, null), 2, null));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    public final void setBackground(boolean z) {
        this.isBackground = z;
    }

    public final void setCommander(String str) {
        this.commander = str;
    }

    public final void setCommanderCardId(String str) {
        this.commanderCardId = str;
    }

    public final void setCommanderLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.commanderLang = str;
    }

    public final void setCommanderPopupWindow(PopupWindow popupWindow) {
        this.commanderPopupWindow = popupWindow;
    }

    public final void setDbHelper(MTGDBHelper mTGDBHelper) {
        this.dbHelper = mTGDBHelper;
    }

    public final void setDoctor(boolean z) {
        this.isDoctor = z;
    }

    public final void setDoctorCompanion(boolean z) {
        this.isDoctorCompanion = z;
    }

    public final void setFriendsForever(boolean z) {
        this.isFriendsForever = z;
    }

    public final void setLeftplaymatCardId(String str) {
        this.leftplaymatCardId = str;
    }

    public final void setLeftplaymatFaceIndex(Integer num) {
        this.leftplaymatFaceIndex = num;
    }

    public final void setLocalizedHelper(MTGDBHelperLocalized mTGDBHelperLocalized) {
        this.localizedHelper = mTGDBHelperLocalized;
    }

    public final void setLocalizedHelpers(List<MTGDBHelperLocalized> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.localizedHelpers = list;
    }

    public final void setPartner(String str) {
        this.partner = str;
    }

    public final void setPartner(boolean z) {
        this.isPartner = z;
    }

    public final void setPartnerCardId(String str) {
        this.partnerCardId = str;
    }

    public final void setPartnerLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.partnerLang = str;
    }

    public final void setPartnerPopupWindow(PopupWindow popupWindow) {
        this.partnerPopupWindow = popupWindow;
    }

    public final void setPartnerSignatureSpellCardId(String str) {
        this.partnerSignatureSpellCardId = str;
    }

    public final void setPartnersignaturespell(String str) {
        this.partnersignaturespell = str;
    }

    public final void setRightplaymatCardId(String str) {
        this.rightplaymatCardId = str;
    }

    public final void setRightplaymatFaceIndex(Integer num) {
        this.rightplaymatFaceIndex = num;
    }

    public final void setSearchCommanderJob(Job job) {
        this.searchCommanderJob = job;
    }

    public final void setSearchPartnerJob(Job job) {
        this.searchPartnerJob = job;
    }

    public final void setSignatureSpell(boolean z) {
        this.isSignatureSpell = z;
    }

    public final void setSignatureSpellCardId(String str) {
        this.signatureSpellCardId = str;
    }

    public final void setSignaturespell(String str) {
        this.signaturespell = str;
    }
}
