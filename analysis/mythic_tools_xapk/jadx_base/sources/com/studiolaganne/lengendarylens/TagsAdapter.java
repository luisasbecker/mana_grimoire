package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.TagsAdapter;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: TagsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/TagsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "tags", "", "Lcom/studiolaganne/lengendarylens/MTTag;", "tagClickHandler", "Lcom/studiolaganne/lengendarylens/TagClickHandler;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/TagClickHandler;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "getItemViewType", "Companion", "TypeTagViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TagsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_TAG = 1;
    private final TagClickHandler tagClickHandler;
    private final List<MTTag> tags;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: TagsAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/TagsAdapter$TypeTagViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tagName", "Landroid/widget/TextView;", "bind", "", "position", "", ViewHierarchyConstants.TAG_KEY, "Lcom/studiolaganne/lengendarylens/MTTag;", "tagClickHandler", "Lcom/studiolaganne/lengendarylens/TagClickHandler;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TypeTagViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final TextView tagName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TypeTagViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.tagName);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.tagName = (TextView) viewFindViewById;
        }

        static final void bind$lambda$0(TagClickHandler tagClickHandler, MTTag mTTag, View view) {
            if (tagClickHandler != null) {
                tagClickHandler.tagClicked(mTTag);
            }
        }

        public final void bind(int position, final MTTag tag, final TagClickHandler tagClickHandler) {
            String strValueOf;
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.TagsAdapter$TypeTagViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TagsAdapter.TypeTagViewHolder.bind$lambda$0(tagClickHandler, tag, view);
                }
            });
            TextView textView = this.tagName;
            String name = tag.getName();
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
        }
    }

    public TagsAdapter(List<MTTag> tags, TagClickHandler tagClickHandler) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.tags = tags;
        this.tagClickHandler = tagClickHandler;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.tags.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof TypeTagViewHolder) {
            ((TypeTagViewHolder) holder).bind(position, this.tags.get(position), this.tagClickHandler);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = layoutInflaterFrom.inflate(R.layout.tag_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new TypeTagViewHolder(viewInflate);
    }
}
