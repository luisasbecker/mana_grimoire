package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilterBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/FilterBottomSheetFragment;", "Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "<init>", "()V", "callback", "Lcom/studiolaganne/lengendarylens/FilterCallback;", "originalFilter", "Lcom/studiolaganne/lengendarylens/FilterDefinition;", "filter", "formats", "", "Lcom/studiolaganne/lengendarylens/MTFormat;", "currentSubformats", "Lcom/studiolaganne/lengendarylens/MTSubformat;", "userTags", "Lcom/studiolaganne/lengendarylens/MTTag;", "formatsPopupMenu", "Landroid/widget/PopupMenu;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilterBottomSheetFragment extends TransparentBottomSheet {
    private static final String ARG_FILTER_JSON = "filter_json";
    public static final String TAG = "FilterBottomSheetFragment";
    private FilterCallback callback;
    private List<MTSubformat> currentSubformats;
    private FilterDefinition filter;
    private List<MTFormat> formats;
    private PopupMenu formatsPopupMenu;
    private FilterDefinition originalFilter;
    private List<MTTag> userTags;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: FilterBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/studiolaganne/lengendarylens/FilterBottomSheetFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_FILTER_JSON", "newInstance", "Lcom/studiolaganne/lengendarylens/FilterBottomSheetFragment;", "callback", "Lcom/studiolaganne/lengendarylens/FilterCallback;", "originalFilter", "Lcom/studiolaganne/lengendarylens/FilterDefinition;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FilterBottomSheetFragment newInstance(FilterCallback callback, FilterDefinition originalFilter) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(originalFilter, "originalFilter");
            FilterBottomSheetFragment filterBottomSheetFragment = new FilterBottomSheetFragment();
            filterBottomSheetFragment.callback = callback;
            filterBottomSheetFragment.originalFilter = originalFilter;
            filterBottomSheetFragment.filter = originalFilter;
            return filterBottomSheetFragment;
        }
    }

    public FilterBottomSheetFragment() {
        FilterDefinition filterDefinition = new FilterDefinition(null, null, null, null, null, null, 63, null);
        this.originalFilter = filterDefinition;
        this.filter = filterDefinition;
        this.formats = CollectionsKt.emptyList();
        this.currentSubformats = CollectionsKt.emptyList();
        this.userTags = CollectionsKt.emptyList();
    }

    static final Unit onViewCreated$lambda$0(FilterBottomSheetFragment filterBottomSheetFragment) {
        filterBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$10(TextView textView, FilterBottomSheetFragment filterBottomSheetFragment, ImageView imageView) {
        textView.setText(filterBottomSheetFragment.getResources().getString(R.string.tag));
        textView.setTextColor(ContextCompat.getColor(filterBottomSheetFragment.requireContext(), R.color.text_color));
        imageView.setVisibility(8);
        filterBottomSheetFragment.filter.setTagId(null);
        filterBottomSheetFragment.filter.setTagName(null);
        return Unit.INSTANCE;
    }

    static final boolean onViewCreated$lambda$12(FilterBottomSheetFragment filterBottomSheetFragment, TextView textView, ImageView imageView, DecksDBHelper decksDBHelper, MenuItem menuItem) {
        Object next;
        if (filterBottomSheetFragment.getContext() == null) {
            return true;
        }
        Iterator<T> it = filterBottomSheetFragment.formats.iterator();
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
        if (mTFormat != null) {
            textView.setText(mTFormat.getName());
            textView.setTextColor(ContextCompat.getColor(filterBottomSheetFragment.requireContext(), R.color.almost_white));
            imageView.setVisibility(0);
            filterBottomSheetFragment.filter.setFormatId(Integer.valueOf(mTFormat.getId()));
            filterBottomSheetFragment.currentSubformats = decksDBHelper.getSubformats(mTFormat.getId());
        }
        return true;
    }

    static final Unit onViewCreated$lambda$13(FilterBottomSheetFragment filterBottomSheetFragment) {
        PopupMenu popupMenu = filterBottomSheetFragment.formatsPopupMenu;
        if (popupMenu != null) {
            popupMenu.show();
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$14(final FilterBottomSheetFragment filterBottomSheetFragment, LinearLayout linearLayout, final TextView textView, final ImageView imageView) {
        if (filterBottomSheetFragment.filter.getFormatId() == null) {
            return Unit.INSTANCE;
        }
        PopupMenu popupMenu = new PopupMenu(filterBottomSheetFragment.requireContext(), linearLayout);
        Menu menu = popupMenu.getMenu();
        for (MTSubformat mTSubformat : filterBottomSheetFragment.currentSubformats) {
            String name = mTSubformat.getName();
            if (mTSubformat.getId() == 5) {
                name = filterBottomSheetFragment.getResources().getString(R.string.two_headed_giant);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
            }
            if (mTSubformat.getId() == 6) {
                name = filterBottomSheetFragment.getResources().getString(R.string.three_headed_giant);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
            }
            menu.add(0, mTSubformat.getId(), 0, name);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda0
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return FilterBottomSheetFragment.onViewCreated$lambda$14$1(this.f$0, textView, imageView, menuItem);
            }
        });
        popupMenu.show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$14$1(FilterBottomSheetFragment filterBottomSheetFragment, TextView textView, ImageView imageView, MenuItem menuItem) {
        Object next;
        if (filterBottomSheetFragment.getContext() == null) {
            return true;
        }
        Iterator<T> it = filterBottomSheetFragment.currentSubformats.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((MTSubformat) next).getId() == menuItem.getItemId()) {
                break;
            }
        }
        MTSubformat mTSubformat = (MTSubformat) next;
        if (mTSubformat != null) {
            String name = mTSubformat.getName();
            if (mTSubformat.getId() == 5) {
                name = filterBottomSheetFragment.getResources().getString(R.string.two_headed_giant);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
            }
            if (mTSubformat.getId() == 6) {
                name = filterBottomSheetFragment.getResources().getString(R.string.three_headed_giant);
                Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
            }
            textView.setText(name);
            textView.setTextColor(ContextCompat.getColor(filterBottomSheetFragment.requireContext(), R.color.almost_white));
            imageView.setVisibility(0);
            filterBottomSheetFragment.filter.setSubformatId(Integer.valueOf(mTSubformat.getId()));
            filterBottomSheetFragment.filter.setSubformatName(name);
        }
        return true;
    }

    static final Unit onViewCreated$lambda$15(final FilterBottomSheetFragment filterBottomSheetFragment, LinearLayout linearLayout, final TextView textView, final ImageView imageView) {
        PopupMenu popupMenu = new PopupMenu(filterBottomSheetFragment.requireContext(), linearLayout);
        Menu menu = popupMenu.getMenu();
        for (MTTag mTTag : filterBottomSheetFragment.userTags) {
            Integer id = mTTag.getId();
            int iIntValue = id != null ? id.intValue() : 0;
            String name = mTTag.getName();
            if (name.length() > 0) {
                StringBuilder sb = new StringBuilder();
                String strValueOf = String.valueOf(name.charAt(0));
                Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                StringBuilder sbAppend = sb.append((Object) upperCase);
                String strSubstring = name.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                name = sbAppend.append(strSubstring).toString();
            }
            menu.add(0, iIntValue, 0, name);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda3
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return FilterBottomSheetFragment.onViewCreated$lambda$15$1(this.f$0, textView, imageView, menuItem);
            }
        });
        popupMenu.show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$15$1(FilterBottomSheetFragment filterBottomSheetFragment, TextView textView, ImageView imageView, MenuItem menuItem) {
        Object next;
        if (filterBottomSheetFragment.getContext() == null) {
            return true;
        }
        Iterator<T> it = filterBottomSheetFragment.userTags.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Integer id = ((MTTag) next).getId();
            int itemId = menuItem.getItemId();
            if (id != null && id.intValue() == itemId) {
                break;
            }
        }
        MTTag mTTag = (MTTag) next;
        if (mTTag != null) {
            String name = mTTag.getName();
            if (name.length() > 0) {
                StringBuilder sb = new StringBuilder();
                String strValueOf = String.valueOf(name.charAt(0));
                Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                StringBuilder sbAppend = sb.append((Object) upperCase);
                String strSubstring = name.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                name = sbAppend.append(strSubstring).toString();
            }
            textView.setText(name);
            textView.setTextColor(ContextCompat.getColor(filterBottomSheetFragment.requireContext(), R.color.almost_white));
            imageView.setVisibility(0);
            filterBottomSheetFragment.filter.setTagId(mTTag.getId());
            filterBottomSheetFragment.filter.setTagName(mTTag.getName());
        }
        return true;
    }

    static final Unit onViewCreated$lambda$16(FilterBottomSheetFragment filterBottomSheetFragment) {
        if (filterBottomSheetFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        filterBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$17(FilterBottomSheetFragment filterBottomSheetFragment) {
        if (filterBottomSheetFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        FilterCallback filterCallback = filterBottomSheetFragment.callback;
        if (filterCallback != null) {
            filterCallback.onApplyFilter(filterBottomSheetFragment.filter);
        }
        filterBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$8(TextView textView, FilterBottomSheetFragment filterBottomSheetFragment, ImageView imageView, TextView textView2, ImageView imageView2) {
        textView.setText(filterBottomSheetFragment.getResources().getString(R.string.format));
        textView.setTextColor(ContextCompat.getColor(filterBottomSheetFragment.requireContext(), R.color.text_color));
        imageView.setVisibility(8);
        textView2.setText(filterBottomSheetFragment.getResources().getString(R.string.subformat));
        textView2.setTextColor(ContextCompat.getColor(filterBottomSheetFragment.requireContext(), R.color.text_color));
        imageView2.setVisibility(8);
        filterBottomSheetFragment.filter.setFormatId(null);
        filterBottomSheetFragment.filter.setSubformatId(null);
        filterBottomSheetFragment.filter.setFormatName(null);
        filterBottomSheetFragment.filter.setSubformatName(null);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$9(TextView textView, FilterBottomSheetFragment filterBottomSheetFragment, ImageView imageView) {
        textView.setText(filterBottomSheetFragment.getResources().getString(R.string.subformat));
        textView.setTextColor(ContextCompat.getColor(filterBottomSheetFragment.requireContext(), R.color.text_color));
        imageView.setVisibility(8);
        filterBottomSheetFragment.filter.setSubformatId(null);
        filterBottomSheetFragment.filter.setSubformatName(null);
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.bottom_sheet_filter, container, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02b5 A[LOOP:3: B:66:0x02af->B:68:0x02b5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02d8  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView textView;
        Integer tagId;
        Iterator it;
        PopupMenu popupMenu;
        Object next;
        Object next2;
        Unit unit;
        Object next3;
        Unit unit2;
        List<MTTag> games;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.chevron_down);
        String str = "findViewById(...)";
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FilterBottomSheetFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUserTags currentUserTags = new PreferencesManager(contextRequireContext).getCurrentUserTags();
        if (currentUserTags != null && (games = currentUserTags.getGames()) != null) {
            this.userTags = games;
        }
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        final DecksDBHelper companion2 = companion.getInstance(contextRequireContext2);
        this.formats = companion2.getFormats();
        TextView textView2 = (TextView) view.findViewById(R.id.formatTextView);
        final TextView textView3 = (TextView) view.findViewById(R.id.subformatTextView);
        final TextView textView4 = (TextView) view.findViewById(R.id.tagTextView);
        final ImageView imageView = (ImageView) view.findViewById(R.id.deleteFormatImage);
        final ImageView imageView2 = (ImageView) view.findViewById(R.id.deleteSubformatImage);
        final ImageView imageView3 = (ImageView) view.findViewById(R.id.deleteTagImage);
        View viewFindViewById2 = view.findViewById(R.id.formatLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.subformatLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        final LinearLayout linearLayout2 = (LinearLayout) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.tagLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        final LinearLayout linearLayout3 = (LinearLayout) viewFindViewById4;
        Integer formatId = this.filter.getFormatId();
        if (formatId != null) {
            int iIntValue = formatId.intValue();
            Iterator<T> it2 = this.formats.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next3 = null;
                    break;
                } else {
                    next3 = it2.next();
                    if (((MTFormat) next3).getId() == iIntValue) {
                        break;
                    }
                }
            }
            MTFormat mTFormat = (MTFormat) next3;
            if (mTFormat != null) {
                textView2.setText(mTFormat.getName());
                textView2.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
                imageView.setVisibility(0);
                this.currentSubformats = companion2.getSubformats(mTFormat.getId());
                unit2 = Unit.INSTANCE;
            } else {
                unit2 = null;
            }
            if (unit2 == null) {
                textView2.setText(getResources().getString(R.string.format));
                textView2.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
                imageView.setVisibility(8);
            }
        }
        Integer subformatId = this.filter.getSubformatId();
        if (subformatId != null) {
            int iIntValue2 = subformatId.intValue();
            Iterator<T> it3 = this.currentSubformats.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    textView = textView2;
                    next2 = null;
                    break;
                } else {
                    next2 = it3.next();
                    textView = textView2;
                    if (((MTSubformat) next2).getId() == iIntValue2) {
                        break;
                    } else {
                        textView2 = textView;
                    }
                }
            }
            MTSubformat mTSubformat = (MTSubformat) next2;
            if (mTSubformat != null) {
                textView3.setText(mTSubformat.getName());
                textView3.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
                imageView2.setVisibility(0);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
            }
            tagId = this.filter.getTagId();
            if (tagId == null) {
                int iIntValue3 = tagId.intValue();
                Iterator<T> it4 = this.userTags.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it4.next();
                    Integer id = ((MTTag) next).getId();
                    if (id != null && id.intValue() == iIntValue3) {
                        break;
                    }
                }
                MTTag mTTag = (MTTag) next;
                String name = mTTag != null ? mTTag.getName() : null;
                if (name == null) {
                    name = "";
                    textView4.setText(name);
                    textView4.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
                    imageView3.setVisibility(0);
                } else {
                    if (name.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        String strValueOf = String.valueOf(name.charAt(0));
                        Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                        String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                        StringBuilder sbAppend = sb.append((Object) upperCase);
                        String strSubstring = name.substring(1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        name = sbAppend.append(strSubstring).toString();
                    }
                    if (name == null) {
                    }
                    textView4.setText(name);
                    textView4.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_white));
                    imageView3.setVisibility(0);
                }
            } else {
                textView4.setText(getResources().getString(R.string.tag));
                textView4.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
                imageView3.setVisibility(8);
            }
            Intrinsics.checkNotNull(imageView);
            final TextView textView5 = textView;
            ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FilterBottomSheetFragment.onViewCreated$lambda$8(textView5, this, imageView, textView3, imageView2);
                }
            });
            Intrinsics.checkNotNull(imageView2);
            ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FilterBottomSheetFragment.onViewCreated$lambda$9(textView3, this, imageView2);
                }
            });
            Intrinsics.checkNotNull(imageView3);
            ViewExtensionsKt.setOnClickWithFade(imageView3, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FilterBottomSheetFragment.onViewCreated$lambda$10(textView4, this, imageView3);
                }
            });
            LinearLayout linearLayout4 = linearLayout;
            PopupMenu popupMenu2 = new PopupMenu(requireContext(), linearLayout4);
            this.formatsPopupMenu = popupMenu2;
            Menu menu = popupMenu2.getMenu();
            it = this.formats.iterator();
            while (it.hasNext()) {
                MTFormat mTFormat2 = (MTFormat) it.next();
                menu.add(0, mTFormat2.getId(), 0, mTFormat2.getName());
                it = it;
                str = str;
            }
            String str2 = str;
            popupMenu = this.formatsPopupMenu;
            if (popupMenu != null) {
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda8
                    @Override // android.widget.PopupMenu.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        return FilterBottomSheetFragment.onViewCreated$lambda$12(this.f$0, textView5, imageView, companion2, menuItem);
                    }
                });
            }
            ViewExtensionsKt.setOnClickWithFade(linearLayout4, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FilterBottomSheetFragment.onViewCreated$lambda$13(this.f$0);
                }
            });
            ViewExtensionsKt.setOnClickWithFade(linearLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FilterBottomSheetFragment.onViewCreated$lambda$14(this.f$0, linearLayout2, textView3, imageView2);
                }
            });
            ViewExtensionsKt.setOnClickWithFade(linearLayout3, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FilterBottomSheetFragment.onViewCreated$lambda$15(this.f$0, linearLayout3, textView4, imageView3);
                }
            });
            View viewFindViewById5 = view.findViewById(R.id.cancelButtonLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, str2);
            ViewExtensionsKt.setOnClickWithFade(viewFindViewById5, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FilterBottomSheetFragment.onViewCreated$lambda$16(this.f$0);
                }
            });
            View viewFindViewById6 = view.findViewById(R.id.filterButtonLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, str2);
            ViewExtensionsKt.setOnClickWithFade(viewFindViewById6, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FilterBottomSheetFragment.onViewCreated$lambda$17(this.f$0);
                }
            });
        }
        textView = textView2;
        textView3.setText(getResources().getString(R.string.subformat));
        textView3.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
        imageView2.setVisibility(8);
        tagId = this.filter.getTagId();
        if (tagId == null) {
        }
        Intrinsics.checkNotNull(imageView);
        final TextView textView52 = textView;
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FilterBottomSheetFragment.onViewCreated$lambda$8(textView52, this, imageView, textView3, imageView2);
            }
        });
        Intrinsics.checkNotNull(imageView2);
        ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FilterBottomSheetFragment.onViewCreated$lambda$9(textView3, this, imageView2);
            }
        });
        Intrinsics.checkNotNull(imageView3);
        ViewExtensionsKt.setOnClickWithFade(imageView3, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FilterBottomSheetFragment.onViewCreated$lambda$10(textView4, this, imageView3);
            }
        });
        LinearLayout linearLayout42 = linearLayout;
        PopupMenu popupMenu22 = new PopupMenu(requireContext(), linearLayout42);
        this.formatsPopupMenu = popupMenu22;
        Menu menu2 = popupMenu22.getMenu();
        it = this.formats.iterator();
        while (it.hasNext()) {
        }
        String str22 = str;
        popupMenu = this.formatsPopupMenu;
        if (popupMenu != null) {
        }
        ViewExtensionsKt.setOnClickWithFade(linearLayout42, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FilterBottomSheetFragment.onViewCreated$lambda$13(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(linearLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FilterBottomSheetFragment.onViewCreated$lambda$14(this.f$0, linearLayout2, textView3, imageView2);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(linearLayout3, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FilterBottomSheetFragment.onViewCreated$lambda$15(this.f$0, linearLayout3, textView4, imageView3);
            }
        });
        View viewFindViewById52 = view.findViewById(R.id.cancelButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById52, str22);
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById52, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FilterBottomSheetFragment.onViewCreated$lambda$16(this.f$0);
            }
        });
        View viewFindViewById62 = view.findViewById(R.id.filterButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById62, str22);
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById62, new Function0() { // from class: com.studiolaganne.lengendarylens.FilterBottomSheetFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FilterBottomSheetFragment.onViewCreated$lambda$17(this.f$0);
            }
        });
    }
}
