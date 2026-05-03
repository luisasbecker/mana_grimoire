package com.studiolaganne.lengendarylens;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.revenuecat.purchases.common.Constants;
import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;
import com.studiolaganne.lengendarylens.ArchenemyDialogFragment;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelperLocalized;
import com.studiolaganne.lengendarylens.NewPlayerDialogFragment;
import com.studiolaganne.lengendarylens.OwnCmdDialogFragment;
import com.studiolaganne.lengendarylens.PlanechaseDialogFragment;
import com.studiolaganne.lengendarylens.QRScanBottomSheetFragment;
import com.studiolaganne.lengendarylens.StreamingConverter;
import com.studiolaganne.lengendarylens.TheRingDialogFragment;
import com.studiolaganne.lengendarylens.UndercityDialogFragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: GameFragmentBase.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000×\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bG*\u0001x\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020OJ\u0010\u0010r\u001a\u00020f2\u0006\u0010s\u001a\u00020tH\u0016J\b\u0010u\u001a\u00020fH\u0016J\b\u0010v\u001a\u00020fH\u0016J\b\u0010z\u001a\u00020fH\u0016J\b\u0010{\u001a\u00020fH\u0016J\u0018\u0010|\u001a\u00020f2\u000e\u0010}\u001a\n\u0012\u0004\u0012\u00020\u007f\u0018\u00010~H\u0016J\u0012\u0010\u0080\u0001\u001a\u00020f2\u0007\u0010\u0081\u0001\u001a\u00020\u007fH\u0016J\u001b\u0010\u0082\u0001\u001a\u00020f2\u0007\u0010\u0081\u0001\u001a\u00020\u007f2\u0007\u0010\u0083\u0001\u001a\u00020(H\u0016J\u0012\u0010\u0084\u0001\u001a\u00020f2\u0007\u0010\u0081\u0001\u001a\u00020\u007fH\u0016J\u0012\u0010\u0085\u0001\u001a\u00020f2\u0007\u0010\u0083\u0001\u001a\u00020(H\u0016J\t\u0010\u0086\u0001\u001a\u00020fH\u0016J\u0012\u0010\u0087\u0001\u001a\u00020f2\u0007\u0010\u0088\u0001\u001a\u00020`H\u0016J\u0007\u0010\u008a\u0001\u001a\u00020fJ\u0017\u0010\u008b\u0001\u001a\u00020f2\u000e\u0010\u008c\u0001\u001a\t\u0012\u0005\u0012\u00030\u008d\u00010~J\u0007\u0010\u008e\u0001\u001a\u00020fJ\t\u0010\u008f\u0001\u001a\u00020fH\u0002J\t\u0010\u0090\u0001\u001a\u00020fH\u0002J\t\u0010\u0091\u0001\u001a\u00020fH\u0002J\t\u0010\u0092\u0001\u001a\u00020fH\u0002J\t\u0010\u0093\u0001\u001a\u00020fH\u0002J\t\u0010\u0094\u0001\u001a\u00020fH\u0002J\t\u0010\u0095\u0001\u001a\u00020fH\u0002J\t\u0010\u0096\u0001\u001a\u00020fH\u0016J\t\u0010\u0097\u0001\u001a\u00020fH\u0016J\t\u0010\u0098\u0001\u001a\u00020fH\u0016J\t\u0010\u0099\u0001\u001a\u00020fH\u0016J\t\u0010\u009a\u0001\u001a\u00020fH\u0016J\u001b\u0010\u009b\u0001\u001a\u00020f2\u0007\u0010\u009c\u0001\u001a\u00020(2\u0007\u0010\u009d\u0001\u001a\u00020(H\u0016J\t\u0010\u009e\u0001\u001a\u00020fH\u0016J\t\u0010\u009f\u0001\u001a\u00020fH\u0016J\t\u0010 \u0001\u001a\u00020fH\u0016J\t\u0010¡\u0001\u001a\u00020fH\u0016J\t\u0010¢\u0001\u001a\u00020fH\u0016J\u0012\u0010£\u0001\u001a\u00020f2\u0007\u0010¤\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010¥\u0001\u001a\u00020f2\u0007\u0010¤\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010¦\u0001\u001a\u00020f2\u0007\u0010¤\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010§\u0001\u001a\u00020f2\u0007\u0010¤\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010¨\u0001\u001a\u00020f2\u0007\u0010¤\u0001\u001a\u00020\u000eH\u0016J\t\u0010©\u0001\u001a\u00020fH\u0016J\t\u0010ª\u0001\u001a\u00020fH\u0016J\u0012\u0010«\u0001\u001a\u00020f2\u0007\u0010¬\u0001\u001a\u00020(H\u0016J\t\u0010\u00ad\u0001\u001a\u00020fH\u0016J\t\u0010®\u0001\u001a\u00020fH\u0016J\u0014\u0010¯\u0001\u001a\u00020f2\t\u0010°\u0001\u001a\u0004\u0018\u00010tH\u0016J\u001d\u0010±\u0001\u001a\u00020f2\u0007\u0010²\u0001\u001a\u00020l2\t\u0010°\u0001\u001a\u0004\u0018\u00010tH\u0016J\u000f\u0010³\u0001\u001a\u00020fH\u0000¢\u0006\u0003\b´\u0001J\u0012\u0010µ\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010·\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u001b\u0010¸\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020\u000eH\u0016J\u001b\u0010º\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020\u000eH\u0016J\u001b\u0010»\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020\u000eH\u0016J\u001b\u0010¼\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020\u000eH\u0016J\u001b\u0010½\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020\u000eH\u0016J\u001b\u0010¾\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020\u000eH\u0016J\u001b\u0010¿\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020(H\u0016J\u001b\u0010À\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010Á\u0001\u001a\u00020(H\u0016J\u001b\u0010Â\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010Á\u0001\u001a\u00020(H\u0016J\u001b\u0010Ã\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010Á\u0001\u001a\u00020(H\u0016J\u001b\u0010Ä\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010Á\u0001\u001a\u00020(H\u0016J\u001b\u0010Å\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010Á\u0001\u001a\u00020(H\u0016J\u0007\u0010Æ\u0001\u001a\u00020fJ\u0012\u0010Ç\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010È\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J%\u0010É\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\b\u0010Ê\u0001\u001a\u00030Ë\u00012\u0007\u0010Ì\u0001\u001a\u00020(H\u0016J\u001b\u0010Í\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010Î\u0001\u001a\u00020(H\u0016J\u0012\u0010Ï\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010Ð\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\t\u0010Ñ\u0001\u001a\u00020fH\u0002J\u0012\u0010Ò\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J$\u0010Ó\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010Ô\u0001\u001a\u00020)2\u0007\u0010Ì\u0001\u001a\u00020(H\u0016J\u001b\u0010Õ\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010Î\u0001\u001a\u00020(H\u0016J\u0012\u0010Ö\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J-\u0010×\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010\u0081\u0001\u001a\u00020\u007f2\u0007\u0010\u0083\u0001\u001a\u00020(2\u0007\u0010Ø\u0001\u001a\u00020\u000eH\u0016J\u0007\u0010Ù\u0001\u001a\u00020fJ\u0007\u0010Ú\u0001\u001a\u00020fJ\u001b\u0010Û\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010Ü\u0001\u001a\u00020(H\u0016J\u0007\u0010Ý\u0001\u001a\u00020fJ\u001b\u0010Þ\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010ß\u0001\u001a\u00020(H\u0016J\u0012\u0010à\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010á\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u001b\u0010â\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010\u0083\u0001\u001a\u00020(H\u0016J\u001b\u0010ã\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010\u0083\u0001\u001a\u00020(H\u0016J\u001b\u0010ä\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010Á\u0001\u001a\u00020(H\u0016J\u001b\u0010å\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010Á\u0001\u001a\u00020(H\u0016J\u001b\u0010æ\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010ç\u0001\u001a\u00020\u000eH\u0016J\u001b\u0010è\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010é\u0001\u001a\u00020`H\u0016J\u001c\u0010ê\u0001\u001a\u00020f2\b\u0010ë\u0001\u001a\u00030ì\u00012\u0007\u0010í\u0001\u001a\u00020(H\u0002J\u001c\u0010ê\u0001\u001a\u00020f2\b\u0010î\u0001\u001a\u00030ï\u00012\u0007\u0010í\u0001\u001a\u00020(H\u0002J\u0007\u0010ð\u0001\u001a\u00020fJ\u0012\u0010ñ\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u001b\u0010ò\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010ó\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010ô\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010õ\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010ö\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010÷\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010ø\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010ù\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010ú\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u0007\u0010û\u0001\u001a\u00020fJ\u0012\u0010ü\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010ý\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u001b\u0010þ\u0001\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010ÿ\u0001\u001a\u00020`H\u0016J\u001b\u0010\u0080\u0002\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010\u0081\u0002\u001a\u00020(H\u0016J\u0012\u0010\u0082\u0002\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010\u0083\u0002\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010\u0084\u0002\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u001b\u0010\u0085\u0002\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010\u0086\u0002\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\t\u0010\u0087\u0002\u001a\u00020fH\u0016J\u0012\u0010\u0088\u0002\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\t\u0010\u0089\u0002\u001a\u00020fH\u0016J\u0012\u0010\u008a\u0002\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\t\u0010\u008b\u0002\u001a\u00020fH\u0016J\u0012\u0010\u008c\u0002\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\t\u0010\u008d\u0002\u001a\u00020fH\u0016J\u0012\u0010\u008e\u0002\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u0019H\u0016J\u0010\u0010\u008f\u0002\u001a\u00020(2\u0007\u0010\u0090\u0002\u001a\u00020(J\u001b\u0010\u0091\u0002\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020(H\u0016J\u001b\u0010\u0092\u0002\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020(H\u0016J\u001b\u0010\u0093\u0002\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010\u0094\u0002\u001a\u00020`H\u0016J\u001b\u0010\u0095\u0002\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020(H\u0016J\u001b\u0010\u0096\u0002\u001a\u00020f2\u0007\u0010¶\u0001\u001a\u00020\u00192\u0007\u0010¹\u0001\u001a\u00020(H\u0016J\u001b\u0010\u0093\u0002\u001a\u00020f2\u0007\u0010\u0090\u0002\u001a\u00020(2\u0007\u0010\u0094\u0002\u001a\u00020`H\u0002J\u0007\u0010\u0097\u0002\u001a\u00020fJ\u0007\u0010\u0098\u0002\u001a\u00020fJ\u0007\u0010\u0099\u0002\u001a\u00020fJ\t\u0010\u009a\u0002\u001a\u00020fH\u0002J\u0012\u0010\u009b\u0002\u001a\u00020f2\t\b\u0002\u0010\u009c\u0002\u001a\u00020\u000eJ\t\u0010\u009d\u0002\u001a\u00020fH\u0002J\t\u0010\u009e\u0002\u001a\u00020fH\u0002J\u0007\u0010\u009f\u0002\u001a\u00020fJ\u0007\u0010 \u0002\u001a\u00020fJ\u0007\u0010¡\u0002\u001a\u00020fJ\u0010\u0010¢\u0002\u001a\u00020f2\u0007\u0010\u0088\u0001\u001a\u00020\u000eJ\u0010\u0010£\u0002\u001a\u00020f2\u0007\u0010\u0088\u0001\u001a\u00020\u000eJ\u0010\u0010¤\u0002\u001a\u00020f2\u0007\u0010\u0088\u0001\u001a\u00020\u000eJ\u0010\u0010¥\u0002\u001a\u00020f2\u0007\u0010\u0088\u0001\u001a\u00020\u000eJ\u0010\u0010¦\u0002\u001a\u00020f2\u0007\u0010\u0088\u0001\u001a\u00020\u000eJ\u0007\u0010§\u0002\u001a\u00020fJ\u0019\u0010¨\u0002\u001a\u00020f2\u0007\u0010©\u0002\u001a\u00020(2\u0007\u0010ç\u0001\u001a\u00020\u000eJ\u0012\u0010ô\u0001\u001a\u00020f2\u0007\u0010\u0090\u0002\u001a\u00020(H\u0002J\u0012\u0010õ\u0001\u001a\u00020f2\u0007\u0010\u0090\u0002\u001a\u00020(H\u0002J\u0012\u0010ý\u0001\u001a\u00020f2\u0007\u0010\u0090\u0002\u001a\u00020(H\u0002J\u001b\u0010þ\u0001\u001a\u00020f2\u0007\u0010\u0090\u0002\u001a\u00020(2\u0007\u0010ÿ\u0001\u001a\u00020`H\u0002J\u001b\u0010\u0080\u0002\u001a\u00020f2\u0007\u0010\u0090\u0002\u001a\u00020(2\u0007\u0010\u0081\u0002\u001a\u00020(H\u0002J\u0012\u0010\u0082\u0002\u001a\u00020f2\u0007\u0010©\u0002\u001a\u00020(H\u0002J\u0012\u0010\u0083\u0002\u001a\u00020f2\u0007\u0010©\u0002\u001a\u00020(H\u0002J\u0012\u0010ª\u0002\u001a\u00020f2\u0007\u0010\u0090\u0002\u001a\u00020(H\u0002J\u001b\u0010\u0085\u0002\u001a\u00020f2\u0007\u0010\u0090\u0002\u001a\u00020(2\u0007\u0010¹\u0001\u001a\u00020\u000eH\u0002J\u001b\u0010«\u0002\u001a\u00020f2\u0007\u0010\u0090\u0002\u001a\u00020(2\u0007\u0010\u0081\u0002\u001a\u00020(H\u0002J\u0007\u0010¬\u0002\u001a\u00020fJ\u0007\u0010\u00ad\u0002\u001a\u00020fJ\u0007\u0010®\u0002\u001a\u00020fJ\u0007\u0010¯\u0002\u001a\u00020fJ\u0007\u0010°\u0002\u001a\u00020fJ\u0007\u0010±\u0002\u001a\u00020fJ\u0007\u0010²\u0002\u001a\u00020fJ\u0007\u0010³\u0002\u001a\u00020fJ\u0007\u0010´\u0002\u001a\u00020fJ\u0007\u0010µ\u0002\u001a\u00020fR\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001c\u0010&\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020+\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020(0\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\f\u001a\u0004\b4\u00105R\u000e\u00107\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020(X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020.X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020(0\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020(0\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020V0UX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020V0UX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\b\u0012\u0004\u0012\u00020V0UX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010Y\u001a\u0010\u0012\f\u0012\n Z*\u0004\u0018\u00010V0V0UX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010[\u001a\u0010\u0012\f\u0012\n Z*\u0004\u0018\u00010V0V0UX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020`X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u00010iX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010iX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010lX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u00020xX\u0082\u0004¢\u0006\u0004\n\u0002\u0010yR\u001d\u0010\u0089\u0001\u001a\u0010\u0012\f\u0012\n Z*\u0004\u0018\u00010`0`0UX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¶\u0002"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameFragmentBase;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/LifeTotalViewCallback;", "Lcom/studiolaganne/lengendarylens/QRScanCallback;", "Lcom/studiolaganne/lengendarylens/CreateDeckCallback;", "<init>", "()V", "sharedViewModel", "Lcom/studiolaganne/lengendarylens/SharedViewModel;", "getSharedViewModel", "()Lcom/studiolaganne/lengendarylens/SharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "tutorialMode", "", "getTutorialMode", "()Z", "setTutorialMode", "(Z)V", "showSeconds", "getShowSeconds", "setShowSeconds", "hasCustomMenuImage", "lifeViews", "", "Lcom/studiolaganne/lengendarylens/LifeTotalView;", "getLifeViews", "()Ljava/util/List;", "setLifeViews", "(Ljava/util/List;)V", "lifeViewTeam1", "getLifeViewTeam1", "()Lcom/studiolaganne/lengendarylens/LifeTotalView;", "setLifeViewTeam1", "(Lcom/studiolaganne/lengendarylens/LifeTotalView;)V", "lifeViewTeam2", "getLifeViewTeam2", "setLifeViewTeam2", "seatedUsers", "", "", "Lcom/studiolaganne/lengendarylens/MTUser;", "seatedPlayers", "Lcom/studiolaganne/lengendarylens/Player;", "notStartingGameIndexes", "lastTurnStartTime", "", "lastTurnPauseTime", "currentTurnPenaltyIndex", "currentPenaltyTimeOffset", "soundPool", "Landroid/media/SoundPool;", "getSoundPool", "()Landroid/media/SoundPool;", "soundPool$delegate", "penaltySoundId", "handler", "Landroid/os/Handler;", "totalAnimationSteps", "delayMillis", "randomPlayerIndex", "currentStep", "currentHighlightIndex", "isTossRunning", "currentQRScanIndex", "currentGuestDeckIndex", "currentGuestUserId", "currentMythicUserDeckIndex", "currentMythicUserId", "stopIntroLoop", "currentCommanderDamageIndex", "getCurrentCommanderDamageIndex", "()I", "setCurrentCommanderDamageIndex", "(I)V", "currentOwnCommanderDamageValue", "currentCommanderDamageStack", "currentPartnerDamageStack", "fragmentReadyListener", "Lcom/studiolaganne/lengendarylens/FragmentReadyListener;", "getFragmentReadyListener", "()Lcom/studiolaganne/lengendarylens/FragmentReadyListener;", "setFragmentReadyListener", "(Lcom/studiolaganne/lengendarylens/FragmentReadyListener;)V", "pickCardLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "pickPhotoLauncher", "purchaseLauncher", "pickCardLauncherForGuestDeck", "kotlin.jvm.PlatformType", "searchActivityLauncherForGuestDeck", "currentScanIndex", "currentPhotoIndex", "currentColorIndex", "lastScanId", "", "currentPhotoUri", "Landroid/net/Uri;", "currentPlaymatId", "currentColorHex", "setOnFragmentReadyListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "tutorialLottieAnimationView", "Lcom/airbnb/lottie/LottieAnimationView;", "tutorialLottieAnimationView2", "tutorialTextView", "Landroid/view/View;", "tutorialButtonDisabled", "instanceSaved", "clockExpired", "clockShowing", "clockHandler", "onSaveInstanceState", "outState", "Landroid/os/Bundle;", "onStop", "onStart", "clockRunnable", "com/studiolaganne/lengendarylens/GameFragmentBase$clockRunnable$1", "Lcom/studiolaganne/lengendarylens/GameFragmentBase$clockRunnable$1;", "onResume", "onPause", "onDeckCreated", "decks", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "onDeckEdited", "deck", "onDeckCreatedForUser", "userId", "onGhostDeckCreated", "onFriendCodeConfirmed", "onQRClosed", "onQRScanned", "value", "requestCameraPermissionLauncher", "exitGamePlayerSummaryMode", "enterGamePlayerSummaryMode", "results", "Lcom/studiolaganne/lengendarylens/PlayerResultItem;", "startTutorialAnimations", "showTutorialStart", "showTutorialStep2", "showTutorialStep3", "showTutorialStep3B", "showTutorialStep4", "showTutorialEnd", "updateBoScoreEarlyIfNeeded", "tutorialComplete", "gameFinished", "nonSyncableGameFinished", "showStartGameButton", "hideStartGameButton", "showBestOfScore", "player1Score", "player2Score", "hideBestOfScore", "showBestOfHelp", "updateLifeHistory", "showLifeHistory", "hideLifeHistory", "commanderDamageToggled", "isOn", "poisonCounterToggled", "dayNightToggled", "planechaseToggled", "archenemyToggled", "setupTeams", "updateTeams", "showTurnCounterUI", "currentTurn", "hideTurnCounterUI", "toggleTimerPause", "onCreate", "savedInstanceState", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "updateStreamingState", "updateStreamingState$app_release", "leftPicked", "sender", "rightPicked", "energyToggled", "newValue", "stormToggled", "experienceToggled", "taxToggled", "radiationToggled", "poisonToggled", "lifeTotalChanged", "energyCounterTapped", Key.ROTATION, "stormCounterTapped", "experienceCounterTapped", "taxCounterTapped", "radiationCounterTapped", "gameEventsEdited", "guestUserSelected", "guestUserUnselected", "mythicUserSelected", "friend", "Lcom/studiolaganne/lengendarylens/MTFriend;", "previousUserId", "mythicUserUnselected", "currentUserId", "currentUserSelected", "currentUserUnselected", "openAppSettings", "qrScanSelected", "playgroupUserSelected", "user", "playgroupUserUnselected", "deckCleared", "playgroupDeckSelected", "endOfGame", "applySeatingAndDecks", "checkIfGameIsReady", "lifeTotalChangeCommitted", "delta", "showTreacheryUnknownRoles", "treacheryRoleRevealed", "role", "swipeMenuClosed", "swipeMenuOpened", "createDeckForGuest", "createDeckForMythicUser", "poisonCounterTapped", "commanderDamageTapped", "confirmPlayerDeath", "fromMenu", "playerIsKO", "contextStr", "addEventIfNeeded", "type", "Lcom/studiolaganne/lengendarylens/MTEvent;", "playerId", NotificationCompat.CATEGORY_EVENT, "Lcom/studiolaganne/lengendarylens/MTGameEvent;", "closeCurrentTurn", "playerIsWin", "playerIsPlayingFirst", "playingFirst", "undoPlayerDeath", "confirmPlayerWin", "confirmPlayerConcede", "confirmPlayerDraw", "pauseTimerToggled", "undoNextTurnTapped", "endTurnTapped", "dismissTurnTimerPromptManually", "playerTapToStartTapped", "undoPlayerWin", "playmatSelected", "id", "ownCmdDamageTapped", "orientation", "signalCardScanInProgress", "signalPhotoPickInProgress", "pickAColor", "partnersToggled", "cityCoinDropped", "cityCoinRejected", "monarchCoinDropped", "monarchCoinRejected", "initiativeCoinDropped", "initiativeCoinRejected", "theRingCoinDropped", "theRingCoinRejected", "commanderDamageClosed", "commanderDamageValueToShowFor", "playerIndex", "commanderDamageValueChanged", "commanderDamagePartnerValueChanged", "editPlayerNameTapped", "currentName", "commanderDamageRunningTotalChanged", "commanderDamagePartnerRunningTotalChanged", "runPlayerTossIntroLoop", "stopPlayerTossIntroLoop", "playerTossSkipped", "highlightNextLifeViewSimple", "runPlayerToss", "gameStart", "highlightNextLifeView", "highlightFinalLifeView", "triggerDeckSelection", "resetGame", "enableCommanderTaxGlobally", "enablePoisonCounters", "enableCommanderDamage", "enableDayNight", "enablePlanechase", "enableArchenemy", "setupLifeViews", "askForPlayerKO", FirebaseAnalytics.Param.INDEX, "showColorPicker", "showCommanderDamageUI", "showPlanechaseUI", "updateClock", "showClock", "hideClock", "hideMenu", "showMenu", "showMenuAsClose", "hideMenuAsClose", "enableBatterySaving", "disableBatterySaving", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class GameFragmentBase extends Fragment implements LifeTotalViewCallback, QRScanCallback, CreateDeckCallback {
    public static final int $stable = 8;
    private boolean clockExpired;
    private final Handler clockHandler;
    private final GameFragmentBase$clockRunnable$1 clockRunnable;
    private boolean clockShowing;
    private String currentColorHex;
    private int currentColorIndex;
    private int currentCommanderDamageIndex;
    private int currentGuestDeckIndex;
    private int currentGuestUserId;
    private int currentHighlightIndex;
    private int currentMythicUserDeckIndex;
    private int currentMythicUserId;
    private int currentOwnCommanderDamageValue;
    private int currentPenaltyTimeOffset;
    private int currentPhotoIndex;
    private Uri currentPhotoUri;
    private String currentPlaymatId;
    private int currentQRScanIndex;
    private int currentScanIndex;
    private int currentStep;
    private int currentTurnPenaltyIndex;
    private FragmentReadyListener fragmentReadyListener;
    private boolean hasCustomMenuImage;
    private boolean instanceSaved;
    private boolean isTossRunning;
    private String lastScanId;
    private long lastTurnPauseTime;
    private long lastTurnStartTime;
    private LifeTotalView lifeViewTeam1;
    private LifeTotalView lifeViewTeam2;
    private int penaltySoundId;
    private ActivityResultLauncher<Intent> pickCardLauncher;
    private final ActivityResultLauncher<Intent> pickCardLauncherForGuestDeck;
    private ActivityResultLauncher<Intent> pickPhotoLauncher;
    private ActivityResultLauncher<Intent> purchaseLauncher;
    private int randomPlayerIndex;
    private final ActivityResultLauncher<String> requestCameraPermissionLauncher;
    private final ActivityResultLauncher<Intent> searchActivityLauncherForGuestDeck;
    private Map<Integer, Player> seatedPlayers;
    private Map<Integer, MTUser> seatedUsers;

    /* JADX INFO: renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy sharedViewModel;
    private boolean showSeconds;
    private boolean stopIntroLoop;
    private boolean tutorialButtonDisabled;
    private LottieAnimationView tutorialLottieAnimationView;
    private LottieAnimationView tutorialLottieAnimationView2;
    private boolean tutorialMode;
    private View tutorialTextView;
    private List<LifeTotalView> lifeViews = new ArrayList();
    private List<Integer> notStartingGameIndexes = new ArrayList();

    /* JADX INFO: renamed from: soundPool$delegate, reason: from kotlin metadata */
    private final Lazy soundPool = LazyKt.lazy(new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda122
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return new SoundPool.Builder().setMaxStreams(2).setAudioAttributes(new AudioAttributes.Builder().setUsage(13).setContentType(4).build()).build();
        }
    });
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final int totalAnimationSteps = 20;
    private final long delayMillis = 30;
    private List<Integer> currentCommanderDamageStack = new ArrayList();
    private List<Integer> currentPartnerDamageStack = new ArrayList();

    public GameFragmentBase() {
        final GameFragmentBase gameFragmentBase = this;
        final Function0 function0 = null;
        this.sharedViewModel = FragmentViewModelLazyKt.createViewModelLazy(gameFragmentBase, Reflection.getOrCreateKotlinClass(SharedViewModel.class), new Function0<ViewModelStore>() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return gameFragmentBase.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? gameFragmentBase.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return gameFragmentBase.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda123
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GameFragmentBase.pickCardLauncherForGuestDeck$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.pickCardLauncherForGuestDeck = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda124
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GameFragmentBase.searchActivityLauncherForGuestDeck$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.searchActivityLauncherForGuestDeck = activityResultLauncherRegisterForActivityResult2;
        this.currentColorIndex = -1;
        this.lastScanId = "";
        this.currentPlaymatId = "";
        this.currentColorHex = "";
        this.clockHandler = new Handler(Looper.getMainLooper());
        this.clockRunnable = new GameFragmentBase$clockRunnable$1(this);
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda125
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GameFragmentBase.requestCameraPermissionLauncher$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(...)");
        this.requestCameraPermissionLauncher = activityResultLauncherRegisterForActivityResult3;
    }

    private final void addEventIfNeeded(MTEvent type, int playerId) {
        Object next;
        Iterator<T> it = getSharedViewModel().getGameState().getEvents().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            MTGameEvent mTGameEvent = (MTGameEvent) next;
            if (Intrinsics.areEqual(mTGameEvent.getType(), type.getValue()) && mTGameEvent.getPlayerid() == playerId) {
                break;
            }
        }
        if (next == null) {
            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, type.getValue(), playerId, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
        }
    }

    private final void addEventIfNeeded(MTGameEvent event, int playerId) {
        Object next;
        MTGameEvent mTGameEventCopy$default = MTGameEvent.copy$default(event, null, null, 0, null, 0, null, 63, null);
        mTGameEventCopy$default.setPlayerid(playerId);
        Iterator<T> it = getSharedViewModel().getGameState().getEvents().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            MTGameEvent mTGameEvent = (MTGameEvent) next;
            if (Intrinsics.areEqual(mTGameEvent.getType(), event.getType()) && mTGameEvent.getPlayerid() == playerId && mTGameEvent.getValue() == event.getValue()) {
                break;
            }
        }
        if (next == null) {
            getSharedViewModel().getGameState().getEvents().add(mTGameEventCopy$default);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit commanderDamageClosed$lambda$0$0(GameFragmentBase gameFragmentBase) {
        if (gameFragmentBase.getContext() == null) {
            return Unit.INSTANCE;
        }
        gameFragmentBase.toggleTimerPause();
        return Unit.INSTANCE;
    }

    static final void commanderDamageClosed$lambda$1(GameFragmentBase gameFragmentBase) {
        int numberOfPlayers = gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers();
        boolean z = false;
        for (int i = 0; i < numberOfPlayers; i++) {
            List<Integer> list = gameFragmentBase.currentCommanderDamageStack;
            if (list != null && !list.isEmpty()) {
                int iIntValue = gameFragmentBase.currentCommanderDamageStack.get(i).intValue();
                if (iIntValue != 0) {
                    gameFragmentBase.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.CommanderDamage.getValue(), gameFragmentBase.currentCommanderDamageIndex, Integer.valueOf(i), iIntValue, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    if (iIntValue > 0) {
                        z = true;
                    }
                }
                int iIntValue2 = gameFragmentBase.currentPartnerDamageStack.get(i).intValue();
                if (iIntValue2 != 0) {
                    gameFragmentBase.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PartnerDamage.getValue(), gameFragmentBase.currentCommanderDamageIndex, Integer.valueOf(i), iIntValue2, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    if (iIntValue2 > 0) {
                        z = true;
                    }
                }
                if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 5) {
                    if (gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
                        int i2 = gameFragmentBase.currentCommanderDamageIndex;
                        if (i2 == 0 || i2 == 3) {
                            LifeTotalView lifeTotalView = gameFragmentBase.lifeViewTeam1;
                            if (lifeTotalView != null) {
                                lifeTotalView.applyCommanderDamageOffset(iIntValue + iIntValue2);
                            }
                        } else {
                            LifeTotalView lifeTotalView2 = gameFragmentBase.lifeViewTeam2;
                            if (lifeTotalView2 != null) {
                                lifeTotalView2.applyCommanderDamageOffset(iIntValue + iIntValue2);
                            }
                        }
                    }
                } else if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() != 6) {
                    gameFragmentBase.lifeViews.get(gameFragmentBase.currentCommanderDamageIndex).applyCommanderDamageOffset(iIntValue + iIntValue2);
                } else if (gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
                    int i3 = gameFragmentBase.currentCommanderDamageIndex;
                    if (i3 == 0 || i3 == 1 || i3 == 5) {
                        LifeTotalView lifeTotalView3 = gameFragmentBase.lifeViewTeam1;
                        if (lifeTotalView3 != null) {
                            lifeTotalView3.applyCommanderDamageOffset(iIntValue + iIntValue2);
                        }
                    } else {
                        LifeTotalView lifeTotalView4 = gameFragmentBase.lifeViewTeam2;
                        if (lifeTotalView4 != null) {
                            lifeTotalView4.applyCommanderDamageOffset(iIntValue + iIntValue2);
                        }
                    }
                }
            }
        }
        if (z) {
            gameFragmentBase.lifeViews.get(gameFragmentBase.currentCommanderDamageIndex).showCommanderDamageAnimation();
        }
        Context context = gameFragmentBase.getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
        }
        gameFragmentBase.updateStreamingState$app_release();
    }

    static final void commanderDamageClosed$lambda$2(GameFragmentBase gameFragmentBase) {
        LifeTotalView lifeTotalView = gameFragmentBase.lifeViewTeam1;
        if (lifeTotalView != null) {
            lifeTotalView.setVisibility(0);
        }
        LifeTotalView lifeTotalView2 = gameFragmentBase.lifeViewTeam2;
        if (lifeTotalView2 != null) {
            lifeTotalView2.setVisibility(0);
        }
        int numberOfPlayers = gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers();
        for (int i = 0; i < numberOfPlayers; i++) {
            gameFragmentBase.lifeViews.get(i).setVisibility(4);
        }
    }

    static final void commanderDamageClosed$lambda$3(GameFragmentBase gameFragmentBase) {
        LifeTotalView lifeTotalView = gameFragmentBase.lifeViewTeam1;
        if (lifeTotalView != null) {
            lifeTotalView.setVisibility(0);
        }
        LifeTotalView lifeTotalView2 = gameFragmentBase.lifeViewTeam2;
        if (lifeTotalView2 != null) {
            lifeTotalView2.setVisibility(0);
        }
        int numberOfPlayers = gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers();
        for (int i = 0; i < numberOfPlayers; i++) {
            gameFragmentBase.lifeViews.get(i).setVisibility(4);
        }
    }

    private final void confirmPlayerWin(int playerIndex) {
        this.lifeViews.get(playerIndex).triggerPlayerWinQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean currentUserUnselected$lambda$0$1(MTUser mTUser, MTUser it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId() == mTUser.getId();
    }

    private final void editPlayerNameTapped(final int playerIndex, String currentName) {
        NewPlayerDialogFragment.Builder builder = new NewPlayerDialogFragment.Builder();
        String string = getString(R.string.edit_player_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        NewPlayerDialogFragment newPlayerDialogFragmentBuild = builder.setTitle(string).setDefaultValue(currentName).setPositiveButtonCallback(new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameFragmentBase.editPlayerNameTapped$lambda$0(this.f$0, playerIndex, (String) obj, (NewPlayerDialogFragment) obj2);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragmentBase.editPlayerNameTapped$lambda$1((NewPlayerDialogFragment) obj);
            }
        }).setOutsideTouchCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragmentBase.editPlayerNameTapped$lambda$2((NewPlayerDialogFragment) obj);
            }
        }).build();
        View view = newPlayerDialogFragmentBuild.getView();
        EditText editText = view != null ? (EditText) view.findViewById(R.id.player_name_edit_text) : null;
        newPlayerDialogFragmentBuild.show(getChildFragmentManager(), "EditPlayerDialog");
        if (editText != null) {
            editText.requestFocus();
        }
    }

    static final Unit editPlayerNameTapped$lambda$0(GameFragmentBase gameFragmentBase, int i, String str, NewPlayerDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        String str2 = str;
        if (str2 != null && str2.length() != 0) {
            String string = StringsKt.trim((CharSequence) str2).toString();
            if (string.length() > 0) {
                gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(i).setName(string);
                Context context = gameFragmentBase.getContext();
                if (context != null) {
                    new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
                }
                gameFragmentBase.lifeViews.get(i).setPlayerName(string);
                gameFragmentBase.updateStreamingState$app_release();
            }
            dialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    static final Unit editPlayerNameTapped$lambda$1(NewPlayerDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit editPlayerNameTapped$lambda$2(NewPlayerDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    static final Unit energyCounterTapped$lambda$0(GameFragmentBase gameFragmentBase, Ref.IntRef intRef, int i, boolean z) {
        gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef.element).setEnergyCounters(i);
        gameFragmentBase.lifeViews.get(intRef.element).setEnergyCounters(i);
        Context context = gameFragmentBase.getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
        }
        if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 5 && gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            LifeTotalView lifeTotalView = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView != null) {
                lifeTotalView.setEnergyCounters(Math.max(gameFragmentBase.lifeViews.get(0).getEnergyCounters(), gameFragmentBase.lifeViews.get(3).getEnergyCounters()));
            }
            LifeTotalView lifeTotalView2 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView2 != null) {
                lifeTotalView2.setEnergyCounters(Math.max(gameFragmentBase.lifeViews.get(1).getEnergyCounters(), gameFragmentBase.lifeViews.get(2).getEnergyCounters()));
            }
        }
        if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 6 && gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            LifeTotalView lifeTotalView3 = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView3 != null) {
                lifeTotalView3.setEnergyCounters(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.lifeViews.get(0).getEnergyCounters(), gameFragmentBase.lifeViews.get(1).getEnergyCounters(), gameFragmentBase.lifeViews.get(5).getEnergyCounters()}));
            }
            LifeTotalView lifeTotalView4 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView4 != null) {
                lifeTotalView4.setEnergyCounters(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.lifeViews.get(2).getEnergyCounters(), gameFragmentBase.lifeViews.get(3).getEnergyCounters(), gameFragmentBase.lifeViews.get(4).getEnergyCounters()}));
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit energyCounterTapped$lambda$1(GameFragmentBase gameFragmentBase, Ref.IntRef intRef, int i) {
        int energyCounters = gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef.element).getEnergyCounters() - i;
        if (energyCounters != 0) {
            gameFragmentBase.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Energy.getValue(), intRef.element, null, energyCounters, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            Context context = gameFragmentBase.getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit experienceCounterTapped$lambda$0(GameFragmentBase gameFragmentBase, Ref.IntRef intRef, int i, boolean z) {
        gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef.element).setExperienceCount(i);
        gameFragmentBase.lifeViews.get(intRef.element).setExperienceCounters(i);
        Context context = gameFragmentBase.getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
        }
        if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 5 && gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            LifeTotalView lifeTotalView = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView != null) {
                lifeTotalView.setExperienceCounters(Math.max(gameFragmentBase.lifeViews.get(0).getExperienceCounters(), gameFragmentBase.lifeViews.get(3).getExperienceCounters()));
            }
            LifeTotalView lifeTotalView2 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView2 != null) {
                lifeTotalView2.setExperienceCounters(Math.max(gameFragmentBase.lifeViews.get(1).getExperienceCounters(), gameFragmentBase.lifeViews.get(2).getExperienceCounters()));
            }
        }
        if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 6 && gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            LifeTotalView lifeTotalView3 = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView3 != null) {
                lifeTotalView3.setExperienceCounters(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.lifeViews.get(0).getExperienceCounters(), gameFragmentBase.lifeViews.get(1).getExperienceCounters(), gameFragmentBase.lifeViews.get(5).getExperienceCounters()}));
            }
            LifeTotalView lifeTotalView4 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView4 != null) {
                lifeTotalView4.setExperienceCounters(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.lifeViews.get(2).getExperienceCounters(), gameFragmentBase.lifeViews.get(3).getExperienceCounters(), gameFragmentBase.lifeViews.get(4).getExperienceCounters()}));
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit experienceCounterTapped$lambda$1(GameFragmentBase gameFragmentBase, Ref.IntRef intRef, int i) {
        int experienceCount = gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef.element).getExperienceCount() - i;
        if (experienceCount != 0) {
            gameFragmentBase.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Experience.getValue(), intRef.element, null, experienceCount, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            Context context = gameFragmentBase.getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SoundPool getSoundPool() {
        Object value = this.soundPool.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SoundPool) value;
    }

    private final void highlightFinalLifeView() {
        LifeTotalView lifeTotalView;
        LifeTotalView lifeTotalView2;
        LifeTotalView lifeTotalView3;
        LifeTotalView lifeTotalView4;
        boolean turnTimerEnabled = getSharedViewModel().getGameState().getTurnTimerEnabled();
        this.lifeViews.get(this.randomPlayerIndex).animateHighlight(turnTimerEnabled);
        if (getSharedViewModel().getGameState().getSubformatId() == 5) {
            if (getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
                int i = this.randomPlayerIndex;
                if (i == 0 || i == 3) {
                    LifeTotalView lifeTotalView5 = this.lifeViewTeam1;
                    if (lifeTotalView5 != null) {
                        lifeTotalView5.animateHighlight(turnTimerEnabled);
                    }
                    if (getSharedViewModel().getGameState().getTurnTimerEnabled() && !getSharedViewModel().getGameState().getTurnTimerPromptDismissed() && (lifeTotalView3 = this.lifeViewTeam1) != null) {
                        lifeTotalView3.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda24
                            @Override // java.lang.Runnable
                            public final void run() {
                                GameFragmentBase.highlightFinalLifeView$lambda$0(this.f$0);
                            }
                        }, 1250L);
                    }
                } else {
                    LifeTotalView lifeTotalView6 = this.lifeViewTeam2;
                    if (lifeTotalView6 != null) {
                        lifeTotalView6.animateHighlight(turnTimerEnabled);
                    }
                    if (getSharedViewModel().getGameState().getTurnTimerEnabled() && !getSharedViewModel().getGameState().getTurnTimerPromptDismissed() && (lifeTotalView4 = this.lifeViewTeam2) != null) {
                        lifeTotalView4.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda25
                            @Override // java.lang.Runnable
                            public final void run() {
                                GameFragmentBase.highlightFinalLifeView$lambda$1(this.f$0);
                            }
                        }, 1250L);
                    }
                }
            }
        } else if (getSharedViewModel().getGameState().getSubformatId() == 6) {
            if (getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
                int i2 = this.randomPlayerIndex;
                if (i2 == 0 || i2 == 1 || i2 == 5) {
                    LifeTotalView lifeTotalView7 = this.lifeViewTeam1;
                    if (lifeTotalView7 != null) {
                        lifeTotalView7.animateHighlight(turnTimerEnabled);
                    }
                    if (getSharedViewModel().getGameState().getTurnTimerEnabled() && !getSharedViewModel().getGameState().getTurnTimerPromptDismissed() && (lifeTotalView = this.lifeViewTeam1) != null) {
                        lifeTotalView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda26
                            @Override // java.lang.Runnable
                            public final void run() {
                                GameFragmentBase.highlightFinalLifeView$lambda$2(this.f$0);
                            }
                        }, 1250L);
                    }
                } else {
                    LifeTotalView lifeTotalView8 = this.lifeViewTeam2;
                    if (lifeTotalView8 != null) {
                        lifeTotalView8.animateHighlight(turnTimerEnabled);
                    }
                    if (getSharedViewModel().getGameState().getTurnTimerEnabled() && !getSharedViewModel().getGameState().getTurnTimerPromptDismissed() && (lifeTotalView2 = this.lifeViewTeam2) != null) {
                        lifeTotalView2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda27
                            @Override // java.lang.Runnable
                            public final void run() {
                                GameFragmentBase.highlightFinalLifeView$lambda$3(this.f$0);
                            }
                        }, 1250L);
                    }
                }
            }
        } else if (getSharedViewModel().getGameState().getTurnTimerEnabled() && !getSharedViewModel().getGameState().getTurnTimerPromptDismissed()) {
            if (getSharedViewModel().getGameState().getNumberOfPlayers() > 2) {
                this.lifeViews.get(this.randomPlayerIndex).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda28
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameFragmentBase gameFragmentBase = this.f$0;
                        gameFragmentBase.lifeViews.get(gameFragmentBase.randomPlayerIndex).showFirstTurnPrompt();
                    }
                }, 1000L);
            }
            if (getSharedViewModel().getGameState().getNumberOfPlayers() == 2 && !getSharedViewModel().getGameState().getGameSyncable()) {
                this.lifeViews.get(this.randomPlayerIndex).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda29
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameFragmentBase gameFragmentBase = this.f$0;
                        gameFragmentBase.lifeViews.get(gameFragmentBase.randomPlayerIndex).showFirstTurnPrompt();
                    }
                }, 1000L);
            }
        }
        this.lifeViews.get(this.randomPlayerIndex).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                GameFragmentBase.highlightFinalLifeView$lambda$6(this.f$0);
            }
        }, 1000L);
        final int size = (this.randomPlayerIndex + 1) % this.lifeViews.size();
        this.lifeViews.get(size).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                GameFragmentBase.highlightFinalLifeView$lambda$7(this.f$0, size);
            }
        }, 3000L);
        this.lifeViews.get(this.randomPlayerIndex).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                GameFragmentBase.highlightFinalLifeView$lambda$8(this.f$0);
            }
        }, 3500L);
    }

    static final void highlightFinalLifeView$lambda$0(GameFragmentBase gameFragmentBase) {
        LifeTotalView lifeTotalView = gameFragmentBase.lifeViewTeam1;
        if (lifeTotalView != null) {
            lifeTotalView.showFirstTurnPrompt();
        }
    }

    static final void highlightFinalLifeView$lambda$1(GameFragmentBase gameFragmentBase) {
        LifeTotalView lifeTotalView = gameFragmentBase.lifeViewTeam2;
        if (lifeTotalView != null) {
            lifeTotalView.showFirstTurnPrompt();
        }
    }

    static final void highlightFinalLifeView$lambda$2(GameFragmentBase gameFragmentBase) {
        LifeTotalView lifeTotalView = gameFragmentBase.lifeViewTeam1;
        if (lifeTotalView != null) {
            lifeTotalView.showFirstTurnPrompt();
        }
    }

    static final void highlightFinalLifeView$lambda$3(GameFragmentBase gameFragmentBase) {
        LifeTotalView lifeTotalView = gameFragmentBase.lifeViewTeam2;
        if (lifeTotalView != null) {
            lifeTotalView.showFirstTurnPrompt();
        }
    }

    static final void highlightFinalLifeView$lambda$6(GameFragmentBase gameFragmentBase) {
        if (gameFragmentBase.getContext() == null) {
            return;
        }
        for (LifeTotalView lifeTotalView : gameFragmentBase.lifeViews) {
            lifeTotalView.setUserInteractionEnabled(true);
            lifeTotalView.setCmdDamageDisabled(false);
            lifeTotalView.setSwipeDisabled(false);
        }
    }

    static final void highlightFinalLifeView$lambda$7(final GameFragmentBase gameFragmentBase, final int i) {
        if (gameFragmentBase.getContext() == null) {
            return;
        }
        Context contextRequireContext = gameFragmentBase.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (preferencesManager.getBoolean(PreferencesManager.SWIPE_TUTORIAL_DONE, false)) {
            return;
        }
        preferencesManager.setBoolean(PreferencesManager.SWIPE_TUTORIAL_DONE, true);
        gameFragmentBase.lifeViews.get(i).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                GameFragmentBase.highlightFinalLifeView$lambda$7$0(this.f$0, i);
            }
        }, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void highlightFinalLifeView$lambda$7$0(GameFragmentBase gameFragmentBase, int i) {
        gameFragmentBase.lifeViews.get(i).showSwipeHint();
    }

    static final void highlightFinalLifeView$lambda$8(GameFragmentBase gameFragmentBase) {
        if (gameFragmentBase.getContext() == null) {
            return;
        }
        Context contextRequireContext = gameFragmentBase.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (preferencesManager.getCurrentSet() == null || gameFragmentBase.getSharedViewModel().getGameState().getPlayers().size() != 2 || preferencesManager.getBoolean(PreferencesManager.BO_HELP_DISMISSED, false)) {
            return;
        }
        gameFragmentBase.showBestOfHelp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void highlightNextLifeView() {
        this.lifeViews.get(this.currentHighlightIndex).hideHighlight();
        if (getSharedViewModel().getGameState().getSubformatId() == 5 && getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            int i = this.currentHighlightIndex;
            if (i == 0 || i == 3) {
                LifeTotalView lifeTotalView = this.lifeViewTeam1;
                if (lifeTotalView != null) {
                    lifeTotalView.hideHighlight();
                }
            } else {
                LifeTotalView lifeTotalView2 = this.lifeViewTeam2;
                if (lifeTotalView2 != null) {
                    lifeTotalView2.hideHighlight();
                }
            }
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            int i2 = this.currentHighlightIndex;
            if (i2 == 0 || i2 == 1 || i2 == 5) {
                LifeTotalView lifeTotalView3 = this.lifeViewTeam1;
                if (lifeTotalView3 != null) {
                    lifeTotalView3.hideHighlight();
                }
            } else {
                LifeTotalView lifeTotalView4 = this.lifeViewTeam2;
                if (lifeTotalView4 != null) {
                    lifeTotalView4.hideHighlight();
                }
            }
        }
        int size = (this.currentHighlightIndex + 1) % this.lifeViews.size();
        this.currentHighlightIndex = size;
        this.lifeViews.get(size).showHighlight();
        if (getSharedViewModel().getGameState().getSubformatId() == 5 && getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            int i3 = this.currentHighlightIndex;
            if (i3 == 0 || i3 == 3) {
                LifeTotalView lifeTotalView5 = this.lifeViewTeam1;
                if (lifeTotalView5 != null) {
                    lifeTotalView5.showHighlight();
                }
            } else {
                LifeTotalView lifeTotalView6 = this.lifeViewTeam2;
                if (lifeTotalView6 != null) {
                    lifeTotalView6.showHighlight();
                }
            }
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            int i4 = this.currentHighlightIndex;
            if (i4 == 0 || i4 == 1 || i4 == 5) {
                LifeTotalView lifeTotalView7 = this.lifeViewTeam1;
                if (lifeTotalView7 != null) {
                    lifeTotalView7.showHighlight();
                }
            } else {
                LifeTotalView lifeTotalView8 = this.lifeViewTeam2;
                if (lifeTotalView8 != null) {
                    lifeTotalView8.showHighlight();
                }
            }
        }
        int i5 = this.currentStep + 1;
        this.currentStep = i5;
        if (i5 < this.totalAnimationSteps) {
            this.handler.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda121
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.highlightNextLifeView();
                }
            }, this.delayMillis + ((long) ((i5 * i5) / 2)));
        } else if (this.currentHighlightIndex == this.randomPlayerIndex) {
            this.isTossRunning = false;
            highlightFinalLifeView();
        } else {
            this.handler.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda121
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.highlightNextLifeView();
                }
            }, this.delayMillis + ((long) ((i5 * i5) / 2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void highlightNextLifeViewSimple() {
        if (this.stopIntroLoop) {
            return;
        }
        this.lifeViews.get(this.currentHighlightIndex).hideHighlight();
        if (getSharedViewModel().getGameState().getSubformatId() == 5 && getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            int i = this.currentHighlightIndex;
            if (i == 0 || i == 3) {
                LifeTotalView lifeTotalView = this.lifeViewTeam1;
                if (lifeTotalView != null) {
                    lifeTotalView.hideHighlight();
                }
            } else {
                LifeTotalView lifeTotalView2 = this.lifeViewTeam2;
                if (lifeTotalView2 != null) {
                    lifeTotalView2.hideHighlight();
                }
            }
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            int i2 = this.currentHighlightIndex;
            if (i2 == 0 || i2 == 1 || i2 == 5) {
                LifeTotalView lifeTotalView3 = this.lifeViewTeam1;
                if (lifeTotalView3 != null) {
                    lifeTotalView3.hideHighlight();
                }
            } else {
                LifeTotalView lifeTotalView4 = this.lifeViewTeam2;
                if (lifeTotalView4 != null) {
                    lifeTotalView4.hideHighlight();
                }
            }
        }
        int size = (this.currentHighlightIndex + 1) % this.lifeViews.size();
        this.currentHighlightIndex = size;
        this.lifeViews.get(size).showHighlight();
        if (getSharedViewModel().getGameState().getSubformatId() == 5 && getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            int i3 = this.currentHighlightIndex;
            if (i3 == 0 || i3 == 3) {
                LifeTotalView lifeTotalView5 = this.lifeViewTeam1;
                if (lifeTotalView5 != null) {
                    lifeTotalView5.showHighlight();
                }
            } else {
                LifeTotalView lifeTotalView6 = this.lifeViewTeam2;
                if (lifeTotalView6 != null) {
                    lifeTotalView6.showHighlight();
                }
            }
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            int i4 = this.currentHighlightIndex;
            if (i4 == 0 || i4 == 1 || i4 == 5) {
                LifeTotalView lifeTotalView7 = this.lifeViewTeam1;
                if (lifeTotalView7 != null) {
                    lifeTotalView7.showHighlight();
                }
            } else {
                LifeTotalView lifeTotalView8 = this.lifeViewTeam2;
                if (lifeTotalView8 != null) {
                    lifeTotalView8.showHighlight();
                }
            }
        }
        if (this.stopIntroLoop) {
            return;
        }
        this.handler.postDelayed(new GameFragmentBase$$ExternalSyntheticLambda5(this), 750L);
    }

    static final Unit initiativeCoinDropped$lambda$0(GameFragmentBase gameFragmentBase, int i, int i2) {
        if (i2 != -1) {
            gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(i).setUndercityRoomId(i2);
            Context context = gameFragmentBase.getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
            }
        }
        return Unit.INSTANCE;
    }

    static final boolean mythicUserUnselected$lambda$0(int i, MTUser it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId() == i;
    }

    static final void onCreate$lambda$0(GameFragmentBase gameFragmentBase, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        Uri data2 = data != null ? data.getData() : null;
        if (data2 != null) {
            gameFragmentBase.currentPhotoUri = data2;
            gameFragmentBase.lifeViews.get(gameFragmentBase.currentPhotoIndex).photoPicked(data2);
        }
    }

    static final void onCreate$lambda$1(GameFragmentBase gameFragmentBase, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        String stringExtra = data != null ? data.getStringExtra("cardPicked") : null;
        if (stringExtra != null) {
            MTFullCard mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class);
            String scryfallid = mTFullCard.getScryfallid();
            if (scryfallid == null) {
                scryfallid = "";
            }
            gameFragmentBase.lastScanId = scryfallid;
            LifeTotalView lifeTotalView = gameFragmentBase.lifeViews.get(gameFragmentBase.currentScanIndex);
            String scryfallid2 = mTFullCard.getScryfallid();
            lifeTotalView.cardPicked(scryfallid2 != null ? scryfallid2 : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onGhostDeckCreated$lambda$7$1(GameFragmentBase gameFragmentBase, MTGDBHelper mTGDBHelper, Ref.ObjectRef objectRef, Ref.IntRef intRef, Ref.ObjectRef objectRef2) {
        Player player;
        SearchDataUtils companion = SearchDataUtils.INSTANCE.getInstance();
        ArrayList<MTGDBHelperLocalized> arrayList = new ArrayList();
        Context contextRequireContext = gameFragmentBase.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        for (String str : new PreferencesManager(contextRequireContext).getEnabledLanguages()) {
            if (!Intrinsics.areEqual(str, "en")) {
                MTGDBHelperLocalized.Companion companion2 = MTGDBHelperLocalized.INSTANCE;
                Context contextRequireContext2 = gameFragmentBase.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                arrayList.add(companion2.getInstance(contextRequireContext2, str));
            }
        }
        for (MTGDBHelperLocalized mTGDBHelperLocalized : arrayList) {
            CardRecord cardByScryFallId = mTGDBHelper.getCardByScryFallId((String) objectRef.element, intRef.element);
            if (cardByScryFallId != null) {
                String lowerCase = cardByScryFallId.getType_line().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) companion.translateTag("creature", mTGDBHelperLocalized.getLocale()), false, 2, (Object) null) && (player = (Player) objectRef2.element) != null) {
                    player.setHasPartners(true);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onQRScanned$lambda$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void openAppSettings() {
        if (getContext() == null) {
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", requireContext().getPackageName(), null));
        startActivity(intent);
    }

    private final void ownCmdDamageTapped(final int playerIndex, int orientation) {
        if (playerIndex < 0 || playerIndex >= getSharedViewModel().getGameState().getPlayers().size()) {
            return;
        }
        int i = this.currentOwnCommanderDamageValue;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i;
        OwnCmdDialogFragment.Builder onValueChangeListener = new OwnCmdDialogFragment.Builder().setInitialValue(getSharedViewModel().getGameState().getPlayers().get(playerIndex).getCommanderDamageList().get(playerIndex).intValue()).setRotationAngle(orientation).setOnDismissListener(new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda70
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragmentBase.ownCmdDamageTapped$lambda$0(this.f$0, playerIndex, intRef);
            }
        }).setOnValueChangeListener(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda71
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragmentBase.ownCmdDamageTapped$lambda$1(intRef, ((Integer) obj).intValue());
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        onValueChangeListener.show(childFragmentManager);
    }

    static final Unit ownCmdDamageTapped$lambda$0(GameFragmentBase gameFragmentBase, int i, Ref.IntRef intRef) {
        gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(i).getCommanderDamageList().set(i, Integer.valueOf(intRef.element));
        Context context = gameFragmentBase.getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
        }
        gameFragmentBase.currentCommanderDamageStack.set(i, Integer.valueOf(intRef.element - gameFragmentBase.currentOwnCommanderDamageValue));
        gameFragmentBase.lifeViews.get(i).setDisplayedCommanderDamage(gameFragmentBase.commanderDamageValueToShowFor(i));
        if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 5 && gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            LifeTotalView lifeTotalView = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView != null) {
                lifeTotalView.setDisplayedCommanderDamage(Math.max(gameFragmentBase.commanderDamageValueToShowFor(0), gameFragmentBase.commanderDamageValueToShowFor(3)));
            }
            LifeTotalView lifeTotalView2 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView2 != null) {
                lifeTotalView2.setDisplayedCommanderDamage(Math.max(gameFragmentBase.commanderDamageValueToShowFor(1), gameFragmentBase.commanderDamageValueToShowFor(2)));
            }
            LifeTotalView lifeTotalView3 = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView3 != null) {
                lifeTotalView3.checkVitals();
            }
            LifeTotalView lifeTotalView4 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView4 != null) {
                lifeTotalView4.checkVitals();
            }
        }
        if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 6 && gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            LifeTotalView lifeTotalView5 = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView5 != null) {
                lifeTotalView5.setDisplayedCommanderDamage(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.commanderDamageValueToShowFor(0), gameFragmentBase.commanderDamageValueToShowFor(1), gameFragmentBase.commanderDamageValueToShowFor(5)}));
            }
            LifeTotalView lifeTotalView6 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView6 != null) {
                lifeTotalView6.setDisplayedCommanderDamage(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.commanderDamageValueToShowFor(2), gameFragmentBase.commanderDamageValueToShowFor(3), gameFragmentBase.commanderDamageValueToShowFor(4)}));
            }
            LifeTotalView lifeTotalView7 = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView7 != null) {
                lifeTotalView7.checkVitals();
            }
            LifeTotalView lifeTotalView8 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView8 != null) {
                lifeTotalView8.checkVitals();
            }
        }
        gameFragmentBase.lifeViews.get(i).updateOwnCmdDamage(intRef.element);
        gameFragmentBase.updateStreamingState$app_release();
        return Unit.INSTANCE;
    }

    static final Unit ownCmdDamageTapped$lambda$1(Ref.IntRef intRef, int i) {
        intRef.element = i;
        return Unit.INSTANCE;
    }

    private final void partnersToggled(int playerIndex, boolean newValue) {
        getSharedViewModel().getGameState().getPlayers().get(playerIndex).setHasPartners(newValue);
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
    }

    static final void pickCardLauncherForGuestDeck$lambda$0(GameFragmentBase gameFragmentBase, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        String stringExtra = data != null ? data.getStringExtra("cardPicked") : null;
        Intent data2 = result.getData();
        int intExtra = data2 != null ? data2.getIntExtra(OptionalModuleUtils.FACE, 0) : 0;
        if (stringExtra != null) {
            MTFullCard mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class);
            Fragment fragmentFindFragmentByTag = gameFragmentBase.getChildFragmentManager().findFragmentByTag(CreateDeckBottomSheetFragment.TAG);
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment = fragmentFindFragmentByTag instanceof CreateDeckBottomSheetFragment ? (CreateDeckBottomSheetFragment) fragmentFindFragmentByTag : null;
            if (createDeckBottomSheetFragment != null) {
                Intrinsics.checkNotNull(mTFullCard);
                createDeckBottomSheetFragment.cardScanned(mTFullCard, intExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playerIsKO$lambda$11$0(GameFragmentBase gameFragmentBase, PreferencesManager preferencesManager) {
        final FragmentActivity activity;
        Context context = gameFragmentBase.getContext();
        if (context == null || (activity = gameFragmentBase.getActivity()) == null) {
            return;
        }
        preferencesManager.setBoolean(PreferencesManager.GAME_RATING_PROMPT_SHOWN, true);
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("rating_prompt_finish_game", null);
        final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(context);
        Intrinsics.checkNotNullExpressionValue(reviewManagerCreate, "create(...)");
        reviewManagerCreate.requestReviewFlow().addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda99
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                GameFragmentBase.playerIsKO$lambda$11$0$0$0$0(reviewManagerCreate, activity, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playerIsKO$lambda$11$0$0$0$0(ReviewManager reviewManager, FragmentActivity fragmentActivity, Task it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isSuccessful()) {
            reviewManager.launchReviewFlow(fragmentActivity, (ReviewInfo) it.getResult());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit playgroupDeckSelected$lambda$0$5$1(GameFragmentBase gameFragmentBase, MTGDBHelper mTGDBHelper, Ref.ObjectRef objectRef, Ref.IntRef intRef, Map map, Ref.IntRef intRef2) {
        Player player;
        SearchDataUtils companion = SearchDataUtils.INSTANCE.getInstance();
        ArrayList<MTGDBHelperLocalized> arrayList = new ArrayList();
        Context contextRequireContext = gameFragmentBase.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        for (String str : new PreferencesManager(contextRequireContext).getEnabledLanguages()) {
            if (!Intrinsics.areEqual(str, "en")) {
                MTGDBHelperLocalized.Companion companion2 = MTGDBHelperLocalized.INSTANCE;
                Context contextRequireContext2 = gameFragmentBase.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                arrayList.add(companion2.getInstance(contextRequireContext2, str));
            }
        }
        for (MTGDBHelperLocalized mTGDBHelperLocalized : arrayList) {
            CardRecord cardByScryFallId = mTGDBHelper.getCardByScryFallId((String) objectRef.element, intRef.element);
            if (cardByScryFallId != null) {
                String lowerCase = cardByScryFallId.getType_line().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) companion.translateTag("creature", mTGDBHelperLocalized.getLocale()), false, 2, (Object) null) && (player = (Player) map.get(Integer.valueOf(intRef2.element))) != null) {
                    player.setHasPartners(true);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit playgroupDeckSelected$lambda$1$5$1(GameFragmentBase gameFragmentBase, MTGDBHelper mTGDBHelper, Ref.ObjectRef objectRef, Ref.IntRef intRef, Ref.IntRef intRef2) {
        SearchDataUtils companion = SearchDataUtils.INSTANCE.getInstance();
        ArrayList<MTGDBHelperLocalized> arrayList = new ArrayList();
        Context contextRequireContext = gameFragmentBase.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        for (String str : new PreferencesManager(contextRequireContext).getEnabledLanguages()) {
            if (!Intrinsics.areEqual(str, "en")) {
                MTGDBHelperLocalized.Companion companion2 = MTGDBHelperLocalized.INSTANCE;
                Context contextRequireContext2 = gameFragmentBase.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                arrayList.add(companion2.getInstance(contextRequireContext2, str));
            }
        }
        for (MTGDBHelperLocalized mTGDBHelperLocalized : arrayList) {
            CardRecord cardByScryFallId = mTGDBHelper.getCardByScryFallId((String) objectRef.element, intRef.element);
            if (cardByScryFallId != null) {
                String lowerCase = cardByScryFallId.getType_line().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) companion.translateTag("creature", mTGDBHelperLocalized.getLocale()), false, 2, (Object) null)) {
                    gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef2.element).setHasPartners(true);
                }
            }
        }
        return Unit.INSTANCE;
    }

    private final void playmatSelected(int playerIndex, String id) {
        this.currentPlaymatId = id;
        this.lifeViews.get(playerIndex).playmatPicked(id);
    }

    static final Unit poisonCounterTapped$lambda$0(GameFragmentBase gameFragmentBase, Ref.IntRef intRef, int i, boolean z) {
        gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef.element).setPoisonCounters(i);
        gameFragmentBase.lifeViews.get(intRef.element).setPoisonCounters(i);
        gameFragmentBase.lifeViews.get(intRef.element).checkVitals();
        if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 5 && gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            LifeTotalView lifeTotalView = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView != null) {
                lifeTotalView.setPoisonCounters(Math.max(gameFragmentBase.lifeViews.get(0).getPoisonCounters(), gameFragmentBase.lifeViews.get(3).getPoisonCounters()));
            }
            LifeTotalView lifeTotalView2 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView2 != null) {
                lifeTotalView2.setPoisonCounters(Math.max(gameFragmentBase.lifeViews.get(1).getPoisonCounters(), gameFragmentBase.lifeViews.get(2).getPoisonCounters()));
            }
            LifeTotalView lifeTotalView3 = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView3 != null) {
                lifeTotalView3.checkVitals();
            }
            LifeTotalView lifeTotalView4 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView4 != null) {
                lifeTotalView4.checkVitals();
            }
        }
        if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 6 && gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            LifeTotalView lifeTotalView5 = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView5 != null) {
                lifeTotalView5.setPoisonCounters(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.lifeViews.get(0).getPoisonCounters(), gameFragmentBase.lifeViews.get(1).getPoisonCounters(), gameFragmentBase.lifeViews.get(5).getPoisonCounters()}));
            }
            LifeTotalView lifeTotalView6 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView6 != null) {
                lifeTotalView6.setPoisonCounters(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.lifeViews.get(2).getPoisonCounters(), gameFragmentBase.lifeViews.get(3).getPoisonCounters(), gameFragmentBase.lifeViews.get(4).getPoisonCounters()}));
            }
            LifeTotalView lifeTotalView7 = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView7 != null) {
                lifeTotalView7.checkVitals();
            }
            LifeTotalView lifeTotalView8 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView8 != null) {
                lifeTotalView8.checkVitals();
            }
        }
        Context context = gameFragmentBase.getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
        }
        gameFragmentBase.updateStreamingState$app_release();
        return Unit.INSTANCE;
    }

    static final Unit poisonCounterTapped$lambda$1(GameFragmentBase gameFragmentBase, Ref.IntRef intRef, int i) {
        int poisonCounters = gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef.element).getPoisonCounters() - i;
        if (poisonCounters != 0) {
            gameFragmentBase.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Poison.getValue(), intRef.element, null, poisonCounters, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            Context context = gameFragmentBase.getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
            }
            if (poisonCounters > 0) {
                gameFragmentBase.lifeViews.get(intRef.element).showPoisonAnimation();
            }
        }
        if (gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef.element).getPoisonCounters() >= ((gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 5 || gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 6) ? 15 : 10)) {
            gameFragmentBase.confirmPlayerDeath(gameFragmentBase.lifeViews.get(intRef.element), false);
        }
        gameFragmentBase.updateStreamingState$app_release();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit qrScanSelected$lambda$0$0(GameFragmentBase gameFragmentBase, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        gameFragmentBase.requestCameraPermissionLauncher.launch("android.permission.CAMERA");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit qrScanSelected$lambda$0$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit qrScanSelected$lambda$0$2(GameFragmentBase gameFragmentBase, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        gameFragmentBase.openAppSettings();
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit qrScanSelected$lambda$0$3(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit radiationCounterTapped$lambda$0(GameFragmentBase gameFragmentBase, Ref.IntRef intRef, int i, boolean z) {
        gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef.element).setRadiationCount(i);
        gameFragmentBase.lifeViews.get(intRef.element).setRadiationCounters(i);
        Context context = gameFragmentBase.getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
        }
        if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 5 && gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            LifeTotalView lifeTotalView = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView != null) {
                lifeTotalView.setRadiationCounters(Math.max(gameFragmentBase.lifeViews.get(0).getRadiationCounters(), gameFragmentBase.lifeViews.get(3).getRadiationCounters()));
            }
            LifeTotalView lifeTotalView2 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView2 != null) {
                lifeTotalView2.setRadiationCounters(Math.max(gameFragmentBase.lifeViews.get(1).getRadiationCounters(), gameFragmentBase.lifeViews.get(2).getRadiationCounters()));
            }
        }
        if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 6 && gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            LifeTotalView lifeTotalView3 = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView3 != null) {
                lifeTotalView3.setRadiationCounters(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.lifeViews.get(0).getRadiationCounters(), gameFragmentBase.lifeViews.get(1).getRadiationCounters(), gameFragmentBase.lifeViews.get(5).getRadiationCounters()}));
            }
            LifeTotalView lifeTotalView4 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView4 != null) {
                lifeTotalView4.setRadiationCounters(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.lifeViews.get(2).getRadiationCounters(), gameFragmentBase.lifeViews.get(3).getRadiationCounters(), gameFragmentBase.lifeViews.get(4).getRadiationCounters()}));
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit radiationCounterTapped$lambda$1(GameFragmentBase gameFragmentBase, Ref.IntRef intRef, int i) {
        int experienceCount = gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef.element).getExperienceCount() - i;
        if (experienceCount != 0) {
            gameFragmentBase.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Radiation.getValue(), intRef.element, null, experienceCount, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            Context context = gameFragmentBase.getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
            }
        }
        return Unit.INSTANCE;
    }

    static final void requestCameraPermissionLauncher$lambda$0(GameFragmentBase gameFragmentBase, boolean z) {
        if (gameFragmentBase.getContext() == null) {
            return;
        }
        Context contextRequireContext = gameFragmentBase.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).setBoolean(PreferencesManager.CAMERA_PERMISSION_ASKED_BEFORE, true);
        if (!z) {
            Toast.makeText(gameFragmentBase.requireContext(), gameFragmentBase.getString(R.string.camera_permission_denied_qr), 1).show();
            return;
        }
        Context contextRequireContext2 = gameFragmentBase.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext2);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (!preferencesManager.hasValidUser() || currentUser == null) {
            return;
        }
        QRScanBottomSheetFragment.INSTANCE.newInstance(gameFragmentBase, currentUser, true).show(gameFragmentBase.getChildFragmentManager(), QRScanBottomSheetFragment.TAG);
    }

    public static /* synthetic */ void runPlayerToss$default(GameFragmentBase gameFragmentBase, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: runPlayerToss");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        gameFragmentBase.runPlayerToss(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runPlayerToss$lambda$0$0$0$0(TossButtonsView tossButtonsView, GameFragmentBase gameFragmentBase, View view) {
        PlayerToss customPlayerToss;
        if (tossButtonsView.getContext() == null) {
            return;
        }
        SkinManager companion = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext = gameFragmentBase.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        SkinDefinition currentSkinDefinition = companion.getCurrentSkinDefinition(contextRequireContext);
        if (currentSkinDefinition == null || (customPlayerToss = currentSkinDefinition.getCustomPlayerToss()) == null || !Intrinsics.areEqual(customPlayerToss.getType(), ClientData.KEY_CHALLENGE)) {
            return;
        }
        Context contextRequireContext2 = gameFragmentBase.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        List<String> frChallenges = Intrinsics.areEqual(new PreferencesManager(contextRequireContext2).getDeviceLanguage(), "fr") ? customPlayerToss.getFrChallenges() : customPlayerToss.getEnChallenges();
        if (frChallenges.isEmpty()) {
            frChallenges = customPlayerToss.getEnChallenges();
        }
        List<String> list = frChallenges;
        if (list.isEmpty()) {
            return;
        }
        String str = (String) CollectionsKt.random(list, Random.INSTANCE);
        Iterator<LifeTotalView> it = gameFragmentBase.lifeViews.iterator();
        while (it.hasNext()) {
            it.next().showCustomMessage(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runPlayerToss$lambda$0$0$0$1(ConstraintLayout constraintLayout, TossButtonsView tossButtonsView, final GameFragmentBase gameFragmentBase, View view) {
        constraintLayout.removeView(tossButtonsView);
        Iterator<LifeTotalView> it = gameFragmentBase.lifeViews.iterator();
        while (it.hasNext()) {
            it.next().removeCustomMessage();
        }
        constraintLayout.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda74
            @Override // java.lang.Runnable
            public final void run() {
                GameFragmentBase.runPlayerToss$lambda$0$0$0$1$0(this.f$0);
            }
        }, 200L);
        gameFragmentBase.showClock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runPlayerToss$lambda$0$0$0$1$0(GameFragmentBase gameFragmentBase) {
        Iterator<LifeTotalView> it = gameFragmentBase.lifeViews.iterator();
        while (it.hasNext()) {
            it.next().triggerPlayerStartQ();
        }
    }

    static final void runPlayerToss$lambda$1(GameFragmentBase gameFragmentBase) {
        gameFragmentBase.lifeViews.get(gameFragmentBase.randomPlayerIndex).triggerPlayerStartQ();
        gameFragmentBase.stopPlayerTossIntroLoop();
    }

    static final void searchActivityLauncherForGuestDeck$lambda$0(GameFragmentBase gameFragmentBase, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        String stringExtra = data != null ? data.getStringExtra("cardPicked") : null;
        Intent data2 = result.getData();
        int intExtra = data2 != null ? data2.getIntExtra(OptionalModuleUtils.FACE, 0) : 0;
        if (stringExtra != null) {
            MTFullCard mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class);
            Fragment fragmentFindFragmentByTag = gameFragmentBase.getChildFragmentManager().findFragmentByTag(CreateDeckBottomSheetFragment.TAG);
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment = fragmentFindFragmentByTag instanceof CreateDeckBottomSheetFragment ? (CreateDeckBottomSheetFragment) fragmentFindFragmentByTag : null;
            if (createDeckBottomSheetFragment != null) {
                Intrinsics.checkNotNull(mTFullCard);
                createDeckBottomSheetFragment.updateCardId(mTFullCard, intExtra);
            }
        }
    }

    static final Unit showClock$lambda$0(GameFragmentBase gameFragmentBase) {
        if (gameFragmentBase.getContext() == null) {
            return Unit.INSTANCE;
        }
        gameFragmentBase.toggleTimerPause();
        return Unit.INSTANCE;
    }

    private final void showColorPicker(int playerIndex) {
        this.currentColorIndex = playerIndex;
        new ColorPickerDialog.Builder(requireContext()).setTitle((CharSequence) getString(R.string.pick_a_color)).setPreferenceName("ColorPickerDialog").setPositiveButton(getString(R.string.confirm), new ColorEnvelopeListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda136
            @Override // com.skydoves.colorpickerview.listeners.ColorEnvelopeListener
            public final void onColorSelected(ColorEnvelope colorEnvelope, boolean z) {
                GameFragmentBase.showColorPicker$lambda$0(this.f$0, colorEnvelope, z);
            }
        }).attachAlphaSlideBar(true).attachBrightnessSlideBar(true).setBottomSpace(12).show();
    }

    static final void showColorPicker$lambda$0(GameFragmentBase gameFragmentBase, ColorEnvelope colorEnvelope, boolean z) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(colorEnvelope.getColor())}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        gameFragmentBase.currentColorHex = str;
        gameFragmentBase.lifeViews.get(gameFragmentBase.currentColorIndex).colorPicked(str);
    }

    private final void showCommanderDamageUI(int playerIndex, int orientation) {
        if (getSharedViewModel().getGameState().getNumberOfPlayers() == this.lifeViews.size() && getSharedViewModel().getGameState().getNumberOfPlayers() == getSharedViewModel().getGameState().getPlayers().size()) {
            hideMenu();
            hideLifeHistory();
            dayNightToggled(false);
            planechaseToggled(false);
            archenemyToggled(false);
            if (this.clockShowing) {
                View view = getView();
                CustomCircleView customCircleView = view != null ? (CustomCircleView) view.findViewById(R.id.circleView) : null;
                if (customCircleView != null) {
                    customCircleView.setVisibility(4);
                }
                View view2 = getView();
                TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.timerTextView) : null;
                if (textView != null) {
                    textView.setVisibility(4);
                }
                View view3 = getView();
                TextView textView2 = view3 != null ? (TextView) view3.findViewById(R.id.timerPausedTextView) : null;
                View view4 = getView();
                TextView textView3 = view4 != null ? (TextView) view4.findViewById(R.id.timerTurnTextView) : null;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            }
            this.currentCommanderDamageIndex = playerIndex;
            int size = getSharedViewModel().getGameState().getPlayers().size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(0);
            }
            this.currentCommanderDamageStack = arrayList;
            int size2 = getSharedViewModel().getGameState().getPlayers().size();
            ArrayList arrayList2 = new ArrayList(size2);
            for (int i2 = 0; i2 < size2; i2++) {
                arrayList2.add(0);
            }
            this.currentPartnerDamageStack = arrayList2;
            int i3 = 0;
            for (LifeTotalView lifeTotalView : this.lifeViews) {
                int i4 = i3 + 1;
                lifeTotalView.setUserInteractionEnabled(false);
                if (i3 == playerIndex) {
                    lifeTotalView.showCommanderDamageMainUI(getSharedViewModel().getGameState().getPlayers().get(playerIndex).getCommanderDamageList().get(playerIndex).intValue());
                } else {
                    lifeTotalView.showCommanderDamageAssignUI(orientation, getSharedViewModel().getGameState().getPlayers().get(playerIndex).getCommanderDamageList().get(i3).intValue(), getSharedViewModel().getGameState().getPlayers().get(playerIndex).getCommanderDamageListPartner().get(i3).intValue());
                }
                i3 = i4;
            }
        }
    }

    static final Unit showPlanechaseUI$lambda$0(GameFragmentBase gameFragmentBase, PlanechaseDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (gameFragmentBase.getContext() == null) {
            return Unit.INSTANCE;
        }
        int currentPlaneIndex = gameFragmentBase.getSharedViewModel().getGameState().getCurrentPlaneIndex() + 1;
        if (currentPlaneIndex < GameUtils.INSTANCE.getInstance().getPlanarDeck().size()) {
            gameFragmentBase.getSharedViewModel().getGameState().setCurrentPlaneIndex(currentPlaneIndex);
        } else {
            gameFragmentBase.getSharedViewModel().getGameState().setCurrentPlaneIndex(0);
            GameUtils.INSTANCE.getInstance().setPlanarDeck(CollectionsKt.emptyList());
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = gameFragmentBase.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            gameFragmentBase.getSharedViewModel().getGameState().setPlanechaseSeed(companion.ensurePlanarDeck(contextRequireContext, gameFragmentBase.getSharedViewModel().getGameState()));
        }
        Context contextRequireContext2 = gameFragmentBase.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        new PreferencesManager(contextRequireContext2).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
        Fragment fragmentFindFragmentByTag = gameFragmentBase.getChildFragmentManager().findFragmentByTag("PlanechaseDialogFragment");
        PlanechaseDialogFragment planechaseDialogFragment = fragmentFindFragmentByTag instanceof PlanechaseDialogFragment ? (PlanechaseDialogFragment) fragmentFindFragmentByTag : null;
        if (planechaseDialogFragment != null) {
            Context contextRequireContext3 = gameFragmentBase.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
            planechaseDialogFragment.updateState(contextRequireContext3, gameFragmentBase.getSharedViewModel().getGameState());
        }
        return Unit.INSTANCE;
    }

    static final Unit showPlanechaseUI$lambda$2(GameFragmentBase gameFragmentBase, ArchenemyDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (gameFragmentBase.getContext() == null) {
            return Unit.INSTANCE;
        }
        if (gameFragmentBase.getSharedViewModel().getGameState().getCurrentSchemeIndex() > 0) {
            gameFragmentBase.getSharedViewModel().getGameState().setCurrentSchemeIndex(r3.getCurrentSchemeIndex() - 1);
            Context contextRequireContext = gameFragmentBase.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            new PreferencesManager(contextRequireContext).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
            Fragment fragmentFindFragmentByTag = gameFragmentBase.getChildFragmentManager().findFragmentByTag("ArchenemyDialogFragment");
            ArchenemyDialogFragment archenemyDialogFragment = fragmentFindFragmentByTag instanceof ArchenemyDialogFragment ? (ArchenemyDialogFragment) fragmentFindFragmentByTag : null;
            if (archenemyDialogFragment != null) {
                Context contextRequireContext2 = gameFragmentBase.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                archenemyDialogFragment.updateState(contextRequireContext2, gameFragmentBase.getSharedViewModel().getGameState());
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit showPlanechaseUI$lambda$3(GameFragmentBase gameFragmentBase, ArchenemyDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (gameFragmentBase.getContext() == null) {
            return Unit.INSTANCE;
        }
        int currentSchemeIndex = gameFragmentBase.getSharedViewModel().getGameState().getCurrentSchemeIndex() + 1;
        if (currentSchemeIndex < GameUtils.INSTANCE.getInstance().getSchemeDeck().size()) {
            gameFragmentBase.getSharedViewModel().getGameState().setCurrentSchemeIndex(currentSchemeIndex);
        } else {
            gameFragmentBase.getSharedViewModel().getGameState().setCurrentSchemeIndex(0);
            GameUtils.INSTANCE.getInstance().setSchemeDeck(CollectionsKt.emptyList());
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = gameFragmentBase.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            gameFragmentBase.getSharedViewModel().getGameState().setArchenemySeed(companion.ensureSchemeDeck(contextRequireContext, gameFragmentBase.getSharedViewModel().getGameState()));
        }
        String str = GameUtils.INSTANCE.getInstance().getSchemeDeck().get(gameFragmentBase.getSharedViewModel().getGameState().getCurrentSchemeIndex());
        GameUtils companion2 = GameUtils.INSTANCE.getInstance();
        Context contextRequireContext2 = gameFragmentBase.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        CardRecord cardLocal$default = GameUtils.getCardLocal$default(companion2, contextRequireContext2, str, 0, 4, null);
        if (cardLocal$default != null) {
            String lowerCase = cardLocal$default.getType_line().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "ongoing", false, 2, (Object) null) && !gameFragmentBase.getSharedViewModel().getGameState().getOngoingSchemes().contains(cardLocal$default.getScryfall_id())) {
                gameFragmentBase.getSharedViewModel().getGameState().getOngoingSchemes().add(cardLocal$default.getScryfall_id());
            }
        }
        Context contextRequireContext3 = gameFragmentBase.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        new PreferencesManager(contextRequireContext3).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
        Fragment fragmentFindFragmentByTag = gameFragmentBase.getChildFragmentManager().findFragmentByTag("ArchenemyDialogFragment");
        ArchenemyDialogFragment archenemyDialogFragment = fragmentFindFragmentByTag instanceof ArchenemyDialogFragment ? (ArchenemyDialogFragment) fragmentFindFragmentByTag : null;
        if (archenemyDialogFragment != null) {
            Context contextRequireContext4 = gameFragmentBase.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
            archenemyDialogFragment.updateState(contextRequireContext4, gameFragmentBase.getSharedViewModel().getGameState());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTutorialEnd() {
        if (getContext() == null) {
            return;
        }
        final View view = this.tutorialTextView;
        if (view != null) {
            this.tutorialTextView = null;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(250L);
            Intrinsics.checkNotNull(objectAnimatorOfFloat);
            objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialEnd$lambda$0$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.this$0.getContext() == null) {
                        return;
                    }
                    View view2 = this.this$0.getView();
                    ConstraintLayout constraintLayout = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.constraintLayout) : null;
                    if (constraintLayout != null) {
                        constraintLayout.removeView(view);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            objectAnimatorOfFloat.start();
        }
        final LottieAnimationView lottieAnimationView = this.tutorialLottieAnimationView;
        if (lottieAnimationView != null) {
            this.tutorialLottieAnimationView = null;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(lottieAnimationView, "alpha", lottieAnimationView.getAlpha(), 0.0f);
            objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat2.setDuration(250L);
            Intrinsics.checkNotNull(objectAnimatorOfFloat2);
            objectAnimatorOfFloat2.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialEnd$lambda$1$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.this$0.getContext() == null) {
                        return;
                    }
                    View view2 = this.this$0.getView();
                    ConstraintLayout constraintLayout = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.constraintLayout) : null;
                    if (constraintLayout != null) {
                        constraintLayout.removeView(lottieAnimationView);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            objectAnimatorOfFloat2.start();
        }
        final View view2 = getView();
        if (view2 != null) {
            view2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda126
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragmentBase.showTutorialEnd$lambda$2$0(this.f$0, view2);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTutorialEnd$lambda$2$0(final GameFragmentBase gameFragmentBase, View view) {
        if (gameFragmentBase.getContext() == null) {
            return;
        }
        int numberOfPlayers = gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers();
        for (int i = 0; i < numberOfPlayers; i++) {
            gameFragmentBase.lifeViews.get(i).unDim();
        }
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.tutorialComplete();
            }
        }, 250L);
    }

    private final void showTutorialStart() {
        final View view;
        if (getContext() == null || (view = getView()) == null) {
            return;
        }
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda115
            @Override // java.lang.Runnable
            public final void run() {
                GameFragmentBase.showTutorialStart$lambda$0$0(this.f$0, view);
            }
        }, 850L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTutorialStart$lambda$0$0(final GameFragmentBase gameFragmentBase, View view) {
        if (gameFragmentBase.getContext() == null) {
            return;
        }
        LifeTotalView lifeTotalView = (LifeTotalView) view.findViewById(R.id.lifeTotalView1);
        View viewFindViewById = view.findViewById(R.id.constraintLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        LottieAnimationView lottieAnimationView = new LottieAnimationView(gameFragmentBase.getContext());
        lottieAnimationView.setAnimation(R.raw.arrow);
        lottieAnimationView.setElevation(100.0f);
        lottieAnimationView.setRotation(30.0f);
        lottieAnimationView.setScaleX(-1.0f);
        lottieAnimationView.setRepeatCount(0);
        lottieAnimationView.setSpeed(2.0f);
        lottieAnimationView.setId(View.generateViewId());
        constraintLayout.addView(lottieAnimationView);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(lifeTotalView.getHeight() / 2, lifeTotalView.getHeight());
        layoutParams.leftMargin = 100;
        layoutParams.bottomMargin = 0;
        lottieAnimationView.setLayoutParams(layoutParams);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(lottieAnimationView.getId(), 6, 0, 6);
        constraintSet.connect(lottieAnimationView.getId(), 4, R.id.lifeTotalView1, 3);
        constraintSet.applyTo(constraintLayout);
        lottieAnimationView.playAnimation();
        gameFragmentBase.tutorialLottieAnimationView = lottieAnimationView;
        View viewInflate = LayoutInflater.from(gameFragmentBase.getContext()).inflate(R.layout.tutorial_info_view, (ViewGroup) constraintLayout, false);
        viewInflate.setElevation(100.0f);
        viewInflate.setId(View.generateViewId());
        constraintLayout.addView(viewInflate);
        viewInflate.setLayoutParams(new ConstraintLayout.LayoutParams((lifeTotalView.getWidth() * 3) / 4, -2));
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(constraintLayout);
        constraintSet2.connect(viewInflate.getId(), 2, 0, 2);
        constraintSet2.connect(viewInflate.getId(), 1, 0, 1);
        constraintSet2.connect(viewInflate.getId(), 3, lottieAnimationView.getId(), 3);
        constraintSet2.connect(viewInflate.getId(), 4, lottieAnimationView.getId(), 3);
        constraintSet2.applyTo(constraintLayout);
        viewInflate.setAlpha(0.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewInflate, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.start();
        gameFragmentBase.tutorialTextView = viewInflate;
        ((ImageView) viewInflate.findViewById(R.id.next_image)).setRotation(270.0f);
        final LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) viewInflate.findViewById(R.id.next_layout);
        Intrinsics.checkNotNull(linearLayoutCompat);
        ViewExtensionsKt.setOnClickWithFade(linearLayoutCompat, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda81
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragmentBase.showTutorialStart$lambda$0$0$3(this.f$0, linearLayoutCompat);
            }
        });
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda82
            @Override // java.lang.Runnable
            public final void run() {
                GameFragmentBase.showTutorialStart$lambda$0$0$4(this.f$0, linearLayoutCompat);
            }
        }, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showTutorialStart$lambda$0$0$3(final GameFragmentBase gameFragmentBase, LinearLayoutCompat linearLayoutCompat) {
        if (gameFragmentBase.tutorialButtonDisabled) {
            return Unit.INSTANCE;
        }
        gameFragmentBase.tutorialButtonDisabled = true;
        linearLayoutCompat.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                GameFragmentBase.showTutorialStart$lambda$0$0$3$0(this.f$0);
            }
        }, 200L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTutorialStart$lambda$0$0$3$0(GameFragmentBase gameFragmentBase) {
        if (gameFragmentBase.getContext() == null) {
            return;
        }
        gameFragmentBase.showTutorialStep2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTutorialStart$lambda$0$0$4(GameFragmentBase gameFragmentBase, LinearLayoutCompat linearLayoutCompat) {
        if (gameFragmentBase.getContext() == null) {
            return;
        }
        linearLayoutCompat.setAlpha(0.0f);
        linearLayoutCompat.setVisibility(0);
        gameFragmentBase.tutorialButtonDisabled = false;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(linearLayoutCompat, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.start();
    }

    private final void showTutorialStep2() {
        if (getContext() == null) {
            return;
        }
        final LottieAnimationView lottieAnimationView = this.tutorialLottieAnimationView;
        if (lottieAnimationView != null) {
            this.tutorialLottieAnimationView = null;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(lottieAnimationView, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(250L);
            Intrinsics.checkNotNull(objectAnimatorOfFloat);
            objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep2$lambda$0$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.this$0.getContext() == null) {
                        return;
                    }
                    View view = this.this$0.getView();
                    ConstraintLayout constraintLayout = view != null ? (ConstraintLayout) view.findViewById(R.id.constraintLayout) : null;
                    if (constraintLayout != null) {
                        constraintLayout.removeView(lottieAnimationView);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            objectAnimatorOfFloat.start();
        }
        final View view = this.tutorialTextView;
        if (view != null) {
            this.tutorialTextView = null;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat2.setDuration(250L);
            Intrinsics.checkNotNull(objectAnimatorOfFloat2);
            objectAnimatorOfFloat2.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep2$lambda$1$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.this$0.getContext() == null) {
                        return;
                    }
                    View view2 = this.this$0.getView();
                    ConstraintLayout constraintLayout = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.constraintLayout) : null;
                    if (constraintLayout != null) {
                        constraintLayout.removeView(view);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            objectAnimatorOfFloat2.start();
        }
        final View view2 = getView();
        if (view2 != null) {
            view2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda73
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragmentBase.showTutorialStep2$lambda$2$0(this.f$0, view2);
                }
            }, 350L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTutorialStep2$lambda$2$0(final GameFragmentBase gameFragmentBase, final View view) {
        if (gameFragmentBase.getContext() == null) {
            return;
        }
        LifeTotalView lifeTotalView = (LifeTotalView) view.findViewById(R.id.lifeTotalView1);
        View viewFindViewById = view.findViewById(R.id.constraintLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        View viewInflate = LayoutInflater.from(gameFragmentBase.getContext()).inflate(R.layout.tutorial_info_view, (ViewGroup) constraintLayout, false);
        viewInflate.setElevation(100.0f);
        viewInflate.setId(View.generateViewId());
        final TextView textView = (TextView) viewInflate.findViewById(R.id.tutorial_text);
        textView.setText(gameFragmentBase.getResources().getString(R.string.string_tutorial_text_2));
        constraintLayout.addView(viewInflate);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams((lifeTotalView.getWidth() * 3) / 4, -2);
        layoutParams.bottomMargin = 40;
        viewInflate.setLayoutParams(layoutParams);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(viewInflate.getId(), 2, 0, 2);
        constraintSet.connect(viewInflate.getId(), 1, 0, 1);
        constraintSet.connect(viewInflate.getId(), 4, lifeTotalView.getId(), 3);
        constraintSet.applyTo(constraintLayout);
        viewInflate.setAlpha(0.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewInflate, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.start();
        gameFragmentBase.tutorialTextView = viewInflate;
        final LottieAnimationView lottieAnimationView = new LottieAnimationView(gameFragmentBase.getContext());
        lottieAnimationView.setAnimation(R.raw.tap);
        lottieAnimationView.setElevation(100.0f);
        lottieAnimationView.setRepeatCount(1);
        lottieAnimationView.setSpeed(2.0f);
        lottieAnimationView.setId(View.generateViewId());
        lottieAnimationView.setBackground(ContextCompat.getDrawable(lottieAnimationView.getContext(), R.drawable.custom_lottie_background));
        constraintLayout.addView(lottieAnimationView);
        final int height = (lifeTotalView.getHeight() * 2) / 3;
        final int height2 = (lifeTotalView.getHeight() * 2) / 3;
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(height2, height);
        layoutParams2.topMargin = 16;
        layoutParams2.rightMargin = 80;
        lottieAnimationView.setLayoutParams(layoutParams2);
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(constraintLayout);
        constraintSet2.connect(lottieAnimationView.getId(), 7, 0, 7);
        constraintSet2.connect(lottieAnimationView.getId(), 3, R.id.lifeTotalView1, 3);
        constraintSet2.applyTo(constraintLayout);
        lottieAnimationView.setAlpha(0.0f);
        gameFragmentBase.tutorialLottieAnimationView = lottieAnimationView;
        ((ImageView) viewInflate.findViewById(R.id.next_image)).setRotation(270.0f);
        final LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) viewInflate.findViewById(R.id.next_layout);
        Intrinsics.checkNotNull(linearLayoutCompat);
        ViewExtensionsKt.setOnClickWithFade(linearLayoutCompat, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda61
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragmentBase.showTutorialStep2$lambda$2$0$3(this.f$0, linearLayoutCompat);
            }
        });
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda72
            @Override // java.lang.Runnable
            public final void run() {
                GameFragmentBase.showTutorialStep2$lambda$2$0$4(lottieAnimationView, gameFragmentBase, view, textView, height2, height, constraintLayout, linearLayoutCompat);
            }
        }, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showTutorialStep2$lambda$2$0$3(final GameFragmentBase gameFragmentBase, LinearLayoutCompat linearLayoutCompat) {
        if (gameFragmentBase.tutorialButtonDisabled) {
            return Unit.INSTANCE;
        }
        gameFragmentBase.tutorialButtonDisabled = true;
        linearLayoutCompat.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda128
            @Override // java.lang.Runnable
            public final void run() {
                GameFragmentBase.showTutorialStep2$lambda$2$0$3$0(this.f$0);
            }
        }, 200L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTutorialStep2$lambda$2$0$3$0(GameFragmentBase gameFragmentBase) {
        gameFragmentBase.lifeViews.get(0).setUserInteractionEnabled(false);
        gameFragmentBase.showTutorialStep3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTutorialStep2$lambda$2$0$4(final LottieAnimationView lottieAnimationView, final GameFragmentBase gameFragmentBase, final View view, final TextView textView, final int i, final int i2, final ConstraintLayout constraintLayout, final LinearLayoutCompat linearLayoutCompat) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(lottieAnimationView, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(250L);
        Intrinsics.checkNotNull(objectAnimatorOfFloat);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep2$lambda$2$0$4$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (this.this$0.getContext() == null) {
                    return;
                }
                lottieAnimationView.playAnimation();
                View view2 = view;
                final GameFragmentBase gameFragmentBase2 = this.this$0;
                view2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep2$3$1$2$1$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LifeTotalView.increaseLife$default(gameFragmentBase2.getLifeViews().get(0), 1, false, 2, null);
                    }
                }, 150L);
                View view3 = view;
                final GameFragmentBase gameFragmentBase3 = this.this$0;
                view3.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep2$3$1$2$1$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        LifeTotalView.increaseLife$default(gameFragmentBase3.getLifeViews().get(0), 1, false, 2, null);
                    }
                }, 850L);
                View view4 = view;
                final LottieAnimationView lottieAnimationView2 = lottieAnimationView;
                final TextView textView2 = textView;
                final View view5 = view;
                final GameFragmentBase gameFragmentBase4 = this.this$0;
                final int i3 = i;
                final int i4 = i2;
                final ConstraintLayout constraintLayout2 = constraintLayout;
                final LinearLayoutCompat linearLayoutCompat2 = linearLayoutCompat;
                view4.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep2$3$1$2$1$3
                    @Override // java.lang.Runnable
                    public final void run() {
                        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(lottieAnimationView2, "alpha", 1.0f, 0.0f);
                        objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
                        objectAnimatorOfFloat2.setDuration(150L);
                        objectAnimatorOfFloat2.start();
                        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(textView2, "alpha", 1.0f, 0.0f);
                        objectAnimatorOfFloat3.setInterpolator(new DecelerateInterpolator());
                        objectAnimatorOfFloat3.setDuration(250L);
                        Intrinsics.checkNotNull(objectAnimatorOfFloat3);
                        final GameFragmentBase gameFragmentBase5 = gameFragmentBase4;
                        final TextView textView3 = textView2;
                        objectAnimatorOfFloat3.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep2$3$1$2$1$3$run$$inlined$doOnEnd$1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                if (gameFragmentBase5.getContext() == null) {
                                    return;
                                }
                                textView3.setText(gameFragmentBase5.getResources().getString(R.string.string_tutorial_text_3));
                                ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(textView3, "alpha", 0.0f, 1.0f);
                                objectAnimatorOfFloat4.setInterpolator(new DecelerateInterpolator());
                                objectAnimatorOfFloat4.setDuration(250L);
                                objectAnimatorOfFloat4.start();
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator2) {
                            }
                        });
                        objectAnimatorOfFloat3.start();
                        View view6 = view5;
                        final LottieAnimationView lottieAnimationView3 = lottieAnimationView2;
                        final int i5 = i3;
                        final int i6 = i4;
                        final ConstraintLayout constraintLayout3 = constraintLayout2;
                        final GameFragmentBase gameFragmentBase6 = gameFragmentBase4;
                        final View view7 = view5;
                        final LinearLayoutCompat linearLayoutCompat3 = linearLayoutCompat2;
                        view6.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep2$3$1$2$1$3.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                lottieAnimationView3.setScaleY(-1.0f);
                                lottieAnimationView3.setScaleX(-1.0f);
                                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(i5, i6);
                                layoutParams.bottomMargin = 16;
                                layoutParams.leftMargin = 80;
                                lottieAnimationView3.setLayoutParams(layoutParams);
                                ConstraintSet constraintSet = new ConstraintSet();
                                ConstraintLayout constraintLayout4 = constraintLayout3;
                                LottieAnimationView lottieAnimationView4 = lottieAnimationView3;
                                constraintSet.clone(constraintLayout4);
                                constraintSet.connect(lottieAnimationView4.getId(), 6, 0, 6);
                                constraintSet.connect(lottieAnimationView4.getId(), 4, R.id.lifeTotalView1, 4);
                                constraintSet.applyTo(constraintLayout3);
                                lottieAnimationView3.setAlpha(0.0f);
                                ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(lottieAnimationView3, "alpha", 0.0f, 1.0f);
                                objectAnimatorOfFloat4.setInterpolator(new DecelerateInterpolator());
                                objectAnimatorOfFloat4.setDuration(250L);
                                Intrinsics.checkNotNull(objectAnimatorOfFloat4);
                                final GameFragmentBase gameFragmentBase7 = gameFragmentBase6;
                                final LottieAnimationView lottieAnimationView5 = lottieAnimationView3;
                                final View view8 = view7;
                                final LinearLayoutCompat linearLayoutCompat4 = linearLayoutCompat3;
                                objectAnimatorOfFloat4.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep2$3$1$2$1$3$2$run$$inlined$doOnEnd$1
                                    @Override // android.animation.Animator.AnimatorListener
                                    public void onAnimationCancel(Animator animator2) {
                                    }

                                    @Override // android.animation.Animator.AnimatorListener
                                    public void onAnimationEnd(Animator animator2) {
                                        if (gameFragmentBase7.getContext() == null) {
                                            return;
                                        }
                                        lottieAnimationView5.playAnimation();
                                        View view9 = view8;
                                        final GameFragmentBase gameFragmentBase8 = gameFragmentBase7;
                                        view9.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep2$3$1$2$1$3$2$1$1
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                LifeTotalView.decreaseLife$default(gameFragmentBase8.getLifeViews().get(0), 1, false, 2, null);
                                            }
                                        }, 150L);
                                        View view10 = view8;
                                        final GameFragmentBase gameFragmentBase9 = gameFragmentBase7;
                                        view10.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep2$3$1$2$1$3$2$1$2
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                LifeTotalView.decreaseLife$default(gameFragmentBase9.getLifeViews().get(0), 1, false, 2, null);
                                            }
                                        }, 850L);
                                        View view11 = view8;
                                        final LottieAnimationView lottieAnimationView6 = lottieAnimationView5;
                                        final View view12 = view8;
                                        final LinearLayoutCompat linearLayoutCompat5 = linearLayoutCompat4;
                                        final GameFragmentBase gameFragmentBase10 = gameFragmentBase7;
                                        view11.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep2$3$1$2$1$3$2$1$3
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(lottieAnimationView6, "alpha", 1.0f, 0.0f);
                                                objectAnimatorOfFloat5.setInterpolator(new DecelerateInterpolator());
                                                objectAnimatorOfFloat5.setDuration(150L);
                                                objectAnimatorOfFloat5.start();
                                                View view13 = view12;
                                                final LinearLayoutCompat linearLayoutCompat6 = linearLayoutCompat5;
                                                final GameFragmentBase gameFragmentBase11 = gameFragmentBase10;
                                                view13.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep2$3$1$2$1$3$2$1$3.1
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        linearLayoutCompat6.setAlpha(0.0f);
                                                        linearLayoutCompat6.setVisibility(0);
                                                        gameFragmentBase11.tutorialButtonDisabled = false;
                                                        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(linearLayoutCompat6, "alpha", 0.0f, 1.0f);
                                                        objectAnimatorOfFloat6.setInterpolator(new DecelerateInterpolator());
                                                        objectAnimatorOfFloat6.setDuration(250L);
                                                        objectAnimatorOfFloat6.start();
                                                    }
                                                }, 400L);
                                            }
                                        }, 1500L);
                                    }

                                    @Override // android.animation.Animator.AnimatorListener
                                    public void onAnimationRepeat(Animator animator2) {
                                    }

                                    @Override // android.animation.Animator.AnimatorListener
                                    public void onAnimationStart(Animator animator2) {
                                    }
                                });
                                objectAnimatorOfFloat4.start();
                            }
                        }, 1000L);
                    }
                }, 2500L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        objectAnimatorOfFloat.start();
    }

    private final void showTutorialStep3() {
        if (getContext() == null) {
            return;
        }
        final View view = this.tutorialTextView;
        if (view != null) {
            this.tutorialTextView = null;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(250L);
            Intrinsics.checkNotNull(objectAnimatorOfFloat);
            objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep3$lambda$0$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.this$0.getContext() == null) {
                        return;
                    }
                    View view2 = this.this$0.getView();
                    ConstraintLayout constraintLayout = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.constraintLayout) : null;
                    if (constraintLayout != null) {
                        constraintLayout.removeView(view);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            objectAnimatorOfFloat.start();
        }
        final LottieAnimationView lottieAnimationView = this.tutorialLottieAnimationView;
        if (lottieAnimationView != null) {
            this.tutorialLottieAnimationView = null;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(lottieAnimationView, "alpha", lottieAnimationView.getAlpha(), 0.0f);
            objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat2.setDuration(250L);
            Intrinsics.checkNotNull(objectAnimatorOfFloat2);
            objectAnimatorOfFloat2.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep3$lambda$1$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.this$0.getContext() == null) {
                        return;
                    }
                    View view2 = this.this$0.getView();
                    ConstraintLayout constraintLayout = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.constraintLayout) : null;
                    if (constraintLayout != null) {
                        constraintLayout.removeView(lottieAnimationView);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            objectAnimatorOfFloat2.start();
        }
        final View view2 = getView();
        if (view2 != null) {
            view2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda75
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragmentBase.showTutorialStep3$lambda$2$0(this.f$0, view2);
                }
            }, 350L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTutorialStep3$lambda$2$0(final GameFragmentBase gameFragmentBase, View view) {
        if (gameFragmentBase.getContext() == null) {
            return;
        }
        LifeTotalView lifeTotalView = (LifeTotalView) view.findViewById(R.id.lifeTotalView1);
        View viewFindViewById = view.findViewById(R.id.constraintLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        LottieAnimationView lottieAnimationView = new LottieAnimationView(gameFragmentBase.getContext());
        lottieAnimationView.setAnimation(R.raw.arrow);
        lottieAnimationView.setElevation(100.0f);
        lottieAnimationView.setRotation(330.0f);
        lottieAnimationView.setRepeatCount(0);
        lottieAnimationView.setSpeed(2.0f);
        lottieAnimationView.setId(View.generateViewId());
        constraintLayout.addView(lottieAnimationView);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(lifeTotalView.getHeight() / 2, lifeTotalView.getHeight());
        layoutParams.leftMargin = 80;
        layoutParams.bottomMargin = -50;
        lottieAnimationView.setLayoutParams(layoutParams);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(lottieAnimationView.getId(), 6, 0, 6);
        constraintSet.connect(lottieAnimationView.getId(), 4, R.id.lifeTotalView1, 3);
        constraintSet.applyTo(constraintLayout);
        lottieAnimationView.playAnimation();
        gameFragmentBase.tutorialLottieAnimationView = lottieAnimationView;
        View viewInflate = LayoutInflater.from(gameFragmentBase.getContext()).inflate(R.layout.tutorial_info_view, (ViewGroup) constraintLayout, false);
        viewInflate.setElevation(100.0f);
        viewInflate.setId(View.generateViewId());
        ((TextView) viewInflate.findViewById(R.id.tutorial_text)).setText(gameFragmentBase.getResources().getString(R.string.string_tutorial_text_4));
        constraintLayout.addView(viewInflate);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams((lifeTotalView.getWidth() * 3) / 4, -2);
        layoutParams2.bottomMargin = 40;
        viewInflate.setLayoutParams(layoutParams2);
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(constraintLayout);
        constraintSet2.connect(viewInflate.getId(), 2, 0, 2);
        constraintSet2.connect(viewInflate.getId(), 1, 0, 1);
        constraintSet2.connect(viewInflate.getId(), 3, lottieAnimationView.getId(), 3);
        constraintSet2.connect(viewInflate.getId(), 4, lottieAnimationView.getId(), 3);
        constraintSet2.applyTo(constraintLayout);
        LottieAnimationView lottieAnimationView2 = new LottieAnimationView(gameFragmentBase.getContext());
        lottieAnimationView2.setAnimation(R.raw.sharpie);
        lottieAnimationView2.setElevation(100.0f);
        lottieAnimationView2.setRepeatCount(0);
        lottieAnimationView2.setSpeed(1.5f);
        lottieAnimationView2.setId(View.generateViewId());
        constraintLayout.addView(lottieAnimationView2);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(lifeTotalView.getHeight() / 3, lifeTotalView.getHeight() / 3);
        layoutParams3.leftMargin = 5;
        layoutParams3.topMargin = lifeTotalView.getHeight() / 6;
        lottieAnimationView2.setLayoutParams(layoutParams3);
        ConstraintSet constraintSet3 = new ConstraintSet();
        constraintSet3.clone(constraintLayout);
        constraintSet3.connect(lottieAnimationView2.getId(), 6, R.id.lifeTotalView1, 6);
        constraintSet3.connect(lottieAnimationView2.getId(), 3, R.id.lifeTotalView1, 3);
        constraintSet3.applyTo(constraintLayout);
        lottieAnimationView2.playAnimation();
        gameFragmentBase.tutorialLottieAnimationView2 = lottieAnimationView2;
        viewInflate.setAlpha(0.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewInflate, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.start();
        gameFragmentBase.tutorialTextView = viewInflate;
        ((ImageView) viewInflate.findViewById(R.id.next_image)).setRotation(270.0f);
        final LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) viewInflate.findViewById(R.id.next_layout);
        Intrinsics.checkNotNull(linearLayoutCompat);
        ViewExtensionsKt.setOnClickWithFade(linearLayoutCompat, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragmentBase.showTutorialStep3$lambda$2$0$5(this.f$0, linearLayoutCompat);
            }
        });
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                GameFragmentBase.showTutorialStep3$lambda$2$0$6(linearLayoutCompat, gameFragmentBase);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showTutorialStep3$lambda$2$0$5(final GameFragmentBase gameFragmentBase, LinearLayoutCompat linearLayoutCompat) {
        if (gameFragmentBase.tutorialButtonDisabled) {
            return Unit.INSTANCE;
        }
        gameFragmentBase.tutorialButtonDisabled = true;
        linearLayoutCompat.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showTutorialStep3B();
            }
        }, 200L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTutorialStep3$lambda$2$0$6(LinearLayoutCompat linearLayoutCompat, GameFragmentBase gameFragmentBase) {
        linearLayoutCompat.setAlpha(0.0f);
        linearLayoutCompat.setVisibility(0);
        gameFragmentBase.tutorialButtonDisabled = false;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(linearLayoutCompat, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTutorialStep3B() {
        if (getContext() == null) {
            return;
        }
        final View view = this.tutorialTextView;
        if (view != null) {
            this.tutorialTextView = null;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(250L);
            Intrinsics.checkNotNull(objectAnimatorOfFloat);
            objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep3B$lambda$0$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.this$0.getContext() == null) {
                        return;
                    }
                    View view2 = this.this$0.getView();
                    ConstraintLayout constraintLayout = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.constraintLayout) : null;
                    if (constraintLayout != null) {
                        constraintLayout.removeView(view);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            objectAnimatorOfFloat.start();
        }
        final LottieAnimationView lottieAnimationView = this.tutorialLottieAnimationView;
        if (lottieAnimationView != null) {
            this.tutorialLottieAnimationView = null;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(lottieAnimationView, "alpha", lottieAnimationView.getAlpha(), 0.0f);
            objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat2.setDuration(250L);
            Intrinsics.checkNotNull(objectAnimatorOfFloat2);
            objectAnimatorOfFloat2.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep3B$lambda$1$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.this$0.getContext() == null) {
                        return;
                    }
                    View view2 = this.this$0.getView();
                    ConstraintLayout constraintLayout = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.constraintLayout) : null;
                    if (constraintLayout != null) {
                        constraintLayout.removeView(lottieAnimationView);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            objectAnimatorOfFloat2.start();
        }
        final LottieAnimationView lottieAnimationView2 = this.tutorialLottieAnimationView2;
        if (lottieAnimationView2 != null) {
            this.tutorialLottieAnimationView2 = null;
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(lottieAnimationView2, "alpha", lottieAnimationView2.getAlpha(), 0.0f);
            objectAnimatorOfFloat3.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat3.setDuration(250L);
            Intrinsics.checkNotNull(objectAnimatorOfFloat3);
            objectAnimatorOfFloat3.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep3B$lambda$2$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.this$0.getContext() == null) {
                        return;
                    }
                    View view2 = this.this$0.getView();
                    ConstraintLayout constraintLayout = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.constraintLayout) : null;
                    if (constraintLayout != null) {
                        constraintLayout.removeView(lottieAnimationView2);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            objectAnimatorOfFloat3.start();
        }
        final View view2 = getView();
        if (view2 != null) {
            view2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda34
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragmentBase.showTutorialStep3B$lambda$3$0(this.f$0, view2);
                }
            }, 350L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTutorialStep3B$lambda$3$0(final GameFragmentBase gameFragmentBase, final View view) {
        if (gameFragmentBase.getContext() == null) {
            return;
        }
        final LifeTotalView lifeTotalView = (LifeTotalView) view.findViewById(R.id.lifeTotalView1);
        final LifeTotalView lifeTotalView2 = (LifeTotalView) view.findViewById(R.id.lifeTotalView2);
        View viewFindViewById = view.findViewById(R.id.constraintLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        int numberOfPlayers = gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers();
        for (int i = 0; i < numberOfPlayers; i++) {
            gameFragmentBase.lifeViews.get(i).unDim();
        }
        final LottieAnimationView lottieAnimationView = new LottieAnimationView(gameFragmentBase.getContext());
        lottieAnimationView.setAnimation(R.raw.tap);
        lottieAnimationView.setElevation(100.0f);
        lottieAnimationView.setRepeatCount(0);
        lottieAnimationView.setSpeed(2.0f);
        lottieAnimationView.setId(View.generateViewId());
        lottieAnimationView.setBackground(ContextCompat.getDrawable(lottieAnimationView.getContext(), R.drawable.custom_lottie_background));
        constraintLayout.addView(lottieAnimationView);
        lottieAnimationView.setLayoutParams(new ConstraintLayout.LayoutParams((lifeTotalView.getHeight() * 2) / 3, (lifeTotalView.getHeight() * 2) / 3));
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(lottieAnimationView.getId(), 6, 0, 6);
        constraintSet.connect(lottieAnimationView.getId(), 3, R.id.lifeTotalView1, 3);
        constraintSet.applyTo(constraintLayout);
        lottieAnimationView.setAlpha(0.0f);
        gameFragmentBase.tutorialLottieAnimationView = lottieAnimationView;
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                GameFragmentBase.showTutorialStep3B$lambda$3$0$2(this.f$0, lottieAnimationView, view, constraintLayout, lifeTotalView2, lifeTotalView);
            }
        }, 450L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTutorialStep3B$lambda$3$0$2(final GameFragmentBase gameFragmentBase, final LottieAnimationView lottieAnimationView, final View view, final ConstraintLayout constraintLayout, final LifeTotalView lifeTotalView, final LifeTotalView lifeTotalView2) {
        if (gameFragmentBase.getContext() == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(lottieAnimationView, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(250L);
        Intrinsics.checkNotNull(objectAnimatorOfFloat);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep3B$lambda$3$0$2$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (this.this$0.getContext() == null) {
                    return;
                }
                lottieAnimationView.playAnimation();
                View view2 = view;
                final GameFragmentBase gameFragmentBase2 = this.this$0;
                view2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep3B$4$1$1$1$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        gameFragmentBase2.getLifeViews().get(0).tutorialCmdDamageTapped();
                    }
                }, 300L);
                View view3 = view;
                final ConstraintLayout constraintLayout2 = constraintLayout;
                final LottieAnimationView lottieAnimationView2 = lottieAnimationView;
                final LifeTotalView lifeTotalView3 = lifeTotalView;
                view3.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep3B$4$1$1$1$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.clone(constraintLayout2);
                        constraintSet.connect(lottieAnimationView2.getId(), 6, lifeTotalView3.getId(), 6, 0);
                        constraintSet.connect(lottieAnimationView2.getId(), 7, lifeTotalView3.getId(), 7, 0);
                        constraintSet.connect(lottieAnimationView2.getId(), 3, lifeTotalView3.getId(), 3, 0);
                        ChangeBounds changeBounds = new ChangeBounds();
                        changeBounds.setDuration(600L);
                        TransitionManager.beginDelayedTransition(constraintLayout2, changeBounds);
                        constraintSet.applyTo(constraintLayout2);
                    }
                }, 550L);
                View view4 = view;
                final LottieAnimationView lottieAnimationView3 = lottieAnimationView;
                final View view5 = view;
                final GameFragmentBase gameFragmentBase3 = this.this$0;
                final ConstraintLayout constraintLayout3 = constraintLayout;
                final LifeTotalView lifeTotalView4 = lifeTotalView2;
                view4.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep3B$4$1$1$1$3
                    @Override // java.lang.Runnable
                    public final void run() {
                        lottieAnimationView3.playAnimation();
                        View view6 = view5;
                        final GameFragmentBase gameFragmentBase4 = gameFragmentBase3;
                        view6.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep3B$4$1$1$1$3.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                gameFragmentBase4.getLifeViews().get(3).tutorialAddOneCmdDamage();
                            }
                        }, 300L);
                        View view7 = view5;
                        final LottieAnimationView lottieAnimationView4 = lottieAnimationView3;
                        final View view8 = view5;
                        final GameFragmentBase gameFragmentBase5 = gameFragmentBase3;
                        final ConstraintLayout constraintLayout4 = constraintLayout3;
                        final LifeTotalView lifeTotalView5 = lifeTotalView4;
                        view7.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep3B$4$1$1$1$3.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                lottieAnimationView4.playAnimation();
                                View view9 = view8;
                                final GameFragmentBase gameFragmentBase6 = gameFragmentBase5;
                                final View view10 = view8;
                                final ConstraintLayout constraintLayout5 = constraintLayout4;
                                final LottieAnimationView lottieAnimationView5 = lottieAnimationView4;
                                final LifeTotalView lifeTotalView6 = lifeTotalView5;
                                view9.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase.showTutorialStep3B.4.1.1.1.3.2.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        gameFragmentBase6.getLifeViews().get(3).tutorialAddSecondCmdDamage();
                                        View view11 = view10;
                                        final GameFragmentBase gameFragmentBase7 = gameFragmentBase6;
                                        final ConstraintLayout constraintLayout6 = constraintLayout5;
                                        final LottieAnimationView lottieAnimationView6 = lottieAnimationView5;
                                        final LifeTotalView lifeTotalView7 = lifeTotalView6;
                                        final View view12 = view10;
                                        view11.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase.showTutorialStep3B.4.1.1.1.3.2.1.1
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                if (gameFragmentBase7.getContext() == null) {
                                                    return;
                                                }
                                                ConstraintSet constraintSet = new ConstraintSet();
                                                constraintSet.clone(constraintLayout6);
                                                constraintSet.clear(lottieAnimationView6.getId(), 3);
                                                constraintSet.connect(lottieAnimationView6.getId(), 6, lifeTotalView7.getId(), 6, 0);
                                                constraintSet.connect(lottieAnimationView6.getId(), 7, lifeTotalView7.getId(), 7, 0);
                                                constraintSet.connect(lottieAnimationView6.getId(), 4, lifeTotalView7.getId(), 4, 0);
                                                ChangeBounds changeBounds = new ChangeBounds();
                                                changeBounds.setDuration(600L);
                                                TransitionManager.beginDelayedTransition(constraintLayout6, changeBounds);
                                                constraintSet.applyTo(constraintLayout6);
                                                View view13 = view12;
                                                final LottieAnimationView lottieAnimationView7 = lottieAnimationView6;
                                                final View view14 = view12;
                                                final GameFragmentBase gameFragmentBase8 = gameFragmentBase7;
                                                final ConstraintLayout constraintLayout7 = constraintLayout6;
                                                final LifeTotalView lifeTotalView8 = lifeTotalView7;
                                                view13.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase.showTutorialStep3B.4.1.1.1.3.2.1.1.1
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        lottieAnimationView7.playAnimation();
                                                        View view15 = view14;
                                                        final GameFragmentBase gameFragmentBase9 = gameFragmentBase8;
                                                        view15.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase.showTutorialStep3B.4.1.1.1.3.2.1.1.1.1
                                                            @Override // java.lang.Runnable
                                                            public final void run() {
                                                                if (gameFragmentBase9.getContext() == null) {
                                                                    return;
                                                                }
                                                                gameFragmentBase9.getLifeViews().get(0).tutorialCloseCmdDamage();
                                                            }
                                                        }, 300L);
                                                        View view16 = view14;
                                                        final GameFragmentBase gameFragmentBase10 = gameFragmentBase8;
                                                        final LottieAnimationView lottieAnimationView8 = lottieAnimationView7;
                                                        final ConstraintLayout constraintLayout8 = constraintLayout7;
                                                        final LifeTotalView lifeTotalView9 = lifeTotalView8;
                                                        final View view17 = view14;
                                                        view16.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase.showTutorialStep3B.4.1.1.1.3.2.1.1.1.2
                                                            @Override // java.lang.Runnable
                                                            public final void run() {
                                                                if (gameFragmentBase10.getContext() == null) {
                                                                    return;
                                                                }
                                                                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(lottieAnimationView8, "alpha", 1.0f, 0.0f);
                                                                objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
                                                                objectAnimatorOfFloat2.setDuration(350L);
                                                                Intrinsics.checkNotNull(objectAnimatorOfFloat2);
                                                                final GameFragmentBase gameFragmentBase11 = gameFragmentBase10;
                                                                final ConstraintLayout constraintLayout9 = constraintLayout8;
                                                                final LifeTotalView lifeTotalView10 = lifeTotalView9;
                                                                final View view18 = view17;
                                                                objectAnimatorOfFloat2.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep3B$4$1$1$1$3$2$1$1$1$2$run$$inlined$doOnEnd$1
                                                                    @Override // android.animation.Animator.AnimatorListener
                                                                    public void onAnimationCancel(Animator animator2) {
                                                                    }

                                                                    @Override // android.animation.Animator.AnimatorListener
                                                                    public void onAnimationEnd(Animator animator2) {
                                                                        if (gameFragmentBase11.getContext() == null) {
                                                                            return;
                                                                        }
                                                                        int numberOfPlayers = gameFragmentBase11.getSharedViewModel().getGameState().getNumberOfPlayers();
                                                                        for (int i = 0; i < numberOfPlayers; i++) {
                                                                            if (i != 0) {
                                                                                gameFragmentBase11.getLifeViews().get(i).dim();
                                                                            }
                                                                        }
                                                                        View viewInflate = LayoutInflater.from(gameFragmentBase11.getContext()).inflate(R.layout.tutorial_info_view, (ViewGroup) constraintLayout9, false);
                                                                        viewInflate.setElevation(100.0f);
                                                                        viewInflate.setId(View.generateViewId());
                                                                        ((TextView) viewInflate.findViewById(R.id.tutorial_text)).setText(gameFragmentBase11.getResources().getString(R.string.string_tutorial_text_5));
                                                                        constraintLayout9.addView(viewInflate);
                                                                        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams((lifeTotalView10.getWidth() * 3) / 4, -2);
                                                                        layoutParams.bottomMargin = 40;
                                                                        viewInflate.setLayoutParams(layoutParams);
                                                                        ConstraintSet constraintSet2 = new ConstraintSet();
                                                                        constraintSet2.clone(constraintLayout9);
                                                                        constraintSet2.connect(viewInflate.getId(), 2, 0, 2);
                                                                        constraintSet2.connect(viewInflate.getId(), 1, 0, 1);
                                                                        constraintSet2.connect(viewInflate.getId(), 4, lifeTotalView10.getId(), 3);
                                                                        constraintSet2.applyTo(constraintLayout9);
                                                                        viewInflate.setAlpha(0.0f);
                                                                        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(viewInflate, "alpha", 0.0f, 1.0f);
                                                                        objectAnimatorOfFloat3.setDuration(500L);
                                                                        objectAnimatorOfFloat3.start();
                                                                        gameFragmentBase11.tutorialTextView = viewInflate;
                                                                        ((ImageView) viewInflate.findViewById(R.id.next_image)).setRotation(270.0f);
                                                                        final LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) viewInflate.findViewById(R.id.next_layout);
                                                                        Intrinsics.checkNotNull(linearLayoutCompat);
                                                                        final GameFragmentBase gameFragmentBase12 = gameFragmentBase11;
                                                                        ViewExtensionsKt.setOnClickWithFade(linearLayoutCompat, new Function0<Unit>() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep3B$4$1$1$1$3$2$1$1$1$2$1$1
                                                                            @Override // kotlin.jvm.functions.Function0
                                                                            public /* bridge */ /* synthetic */ Unit invoke() {
                                                                                invoke2();
                                                                                return Unit.INSTANCE;
                                                                            }

                                                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                            public final void invoke2() {
                                                                                if (gameFragmentBase12.tutorialButtonDisabled) {
                                                                                    return;
                                                                                }
                                                                                gameFragmentBase12.tutorialButtonDisabled = true;
                                                                                LinearLayoutCompat linearLayoutCompat2 = linearLayoutCompat;
                                                                                final GameFragmentBase gameFragmentBase13 = gameFragmentBase12;
                                                                                linearLayoutCompat2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep3B$4$1$1$1$3$2$1$1$1$2$1$1.1
                                                                                    @Override // java.lang.Runnable
                                                                                    public final void run() {
                                                                                        gameFragmentBase13.showTutorialStep4();
                                                                                    }
                                                                                }, 200L);
                                                                            }
                                                                        });
                                                                        View view19 = view18;
                                                                        final GameFragmentBase gameFragmentBase13 = gameFragmentBase11;
                                                                        view19.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep3B$4$1$1$1$3$2$1$1$1$2$1$2
                                                                            @Override // java.lang.Runnable
                                                                            public final void run() {
                                                                                if (gameFragmentBase13.getContext() == null) {
                                                                                    return;
                                                                                }
                                                                                linearLayoutCompat.setAlpha(0.0f);
                                                                                linearLayoutCompat.setVisibility(0);
                                                                                gameFragmentBase13.tutorialButtonDisabled = false;
                                                                                ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(linearLayoutCompat, "alpha", 0.0f, 1.0f);
                                                                                objectAnimatorOfFloat4.setInterpolator(new DecelerateInterpolator());
                                                                                objectAnimatorOfFloat4.setDuration(250L);
                                                                                objectAnimatorOfFloat4.start();
                                                                            }
                                                                        }, 1500L);
                                                                    }

                                                                    @Override // android.animation.Animator.AnimatorListener
                                                                    public void onAnimationRepeat(Animator animator2) {
                                                                    }

                                                                    @Override // android.animation.Animator.AnimatorListener
                                                                    public void onAnimationStart(Animator animator2) {
                                                                    }
                                                                });
                                                                objectAnimatorOfFloat2.start();
                                                            }
                                                        }, 650L);
                                                    }
                                                }, 950L);
                                            }
                                        }, 450L);
                                    }
                                }, 350L);
                            }
                        }, 450L);
                    }
                }, 1250L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        objectAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTutorialStep4() {
        if (getContext() == null) {
            return;
        }
        final View view = this.tutorialTextView;
        if (view != null) {
            this.tutorialTextView = null;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(250L);
            Intrinsics.checkNotNull(objectAnimatorOfFloat);
            objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep4$lambda$0$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.this$0.getContext() == null) {
                        return;
                    }
                    View view2 = this.this$0.getView();
                    ConstraintLayout constraintLayout = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.constraintLayout) : null;
                    if (constraintLayout != null) {
                        constraintLayout.removeView(view);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            objectAnimatorOfFloat.start();
        }
        final LottieAnimationView lottieAnimationView = this.tutorialLottieAnimationView;
        if (lottieAnimationView != null) {
            this.tutorialLottieAnimationView = null;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(lottieAnimationView, "alpha", lottieAnimationView.getAlpha(), 0.0f);
            objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat2.setDuration(250L);
            Intrinsics.checkNotNull(objectAnimatorOfFloat2);
            objectAnimatorOfFloat2.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep4$lambda$1$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.this$0.getContext() == null) {
                        return;
                    }
                    View view2 = this.this$0.getView();
                    ConstraintLayout constraintLayout = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.constraintLayout) : null;
                    if (constraintLayout != null) {
                        constraintLayout.removeView(lottieAnimationView);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            objectAnimatorOfFloat2.start();
        }
        final View view2 = getView();
        if (view2 != null) {
            view2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragmentBase.showTutorialStep4$lambda$2$0(this.f$0, view2);
                }
            }, 350L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTutorialStep4$lambda$2$0(final GameFragmentBase gameFragmentBase, final View view) {
        if (gameFragmentBase.getContext() == null) {
            return;
        }
        LifeTotalView lifeTotalView = (LifeTotalView) view.findViewById(R.id.lifeTotalView1);
        View viewFindViewById = view.findViewById(R.id.constraintLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        View viewInflate = LayoutInflater.from(gameFragmentBase.getContext()).inflate(R.layout.tutorial_info_view, (ViewGroup) constraintLayout, false);
        viewInflate.setElevation(100.0f);
        viewInflate.setId(View.generateViewId());
        ((TextView) viewInflate.findViewById(R.id.tutorial_text)).setText(gameFragmentBase.getResources().getString(R.string.string_tutorial_text_6));
        constraintLayout.addView(viewInflate);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams((lifeTotalView.getWidth() * 3) / 4, -2);
        layoutParams.bottomMargin = 40;
        viewInflate.setLayoutParams(layoutParams);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(viewInflate.getId(), 2, 0, 2);
        constraintSet.connect(viewInflate.getId(), 1, 0, 1);
        constraintSet.connect(viewInflate.getId(), 4, lifeTotalView.getId(), 3);
        constraintSet.applyTo(constraintLayout);
        ((ImageView) viewInflate.findViewById(R.id.next_image)).setRotation(270.0f);
        ((TextView) viewInflate.findViewById(R.id.next_label)).setText(gameFragmentBase.getResources().getString(R.string.got_it));
        final LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) viewInflate.findViewById(R.id.next_layout);
        Intrinsics.checkNotNull(linearLayoutCompat);
        ViewExtensionsKt.setOnClickWithFade(linearLayoutCompat, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragmentBase.showTutorialStep4$lambda$2$0$1(this.f$0, linearLayoutCompat);
            }
        });
        final LottieAnimationView lottieAnimationView = new LottieAnimationView(gameFragmentBase.getContext());
        lottieAnimationView.setAnimation(R.raw.swipe);
        lottieAnimationView.setElevation(100.0f);
        lottieAnimationView.setRepeatCount(0);
        lottieAnimationView.setBackground(ContextCompat.getDrawable(lottieAnimationView.getContext(), R.drawable.custom_lottie_background));
        lottieAnimationView.setSpeed(1.0f);
        lottieAnimationView.setId(View.generateViewId());
        constraintLayout.addView(lottieAnimationView);
        lottieAnimationView.setLayoutParams(new ConstraintLayout.LayoutParams(lifeTotalView.getWidth(), lifeTotalView.getHeight()));
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(constraintLayout);
        constraintSet2.connect(lottieAnimationView.getId(), 6, 0, 6);
        constraintSet2.connect(lottieAnimationView.getId(), 7, 0, 7);
        constraintSet2.connect(lottieAnimationView.getId(), 3, R.id.lifeTotalView1, 3);
        constraintSet2.connect(lottieAnimationView.getId(), 4, R.id.lifeTotalView1, 4);
        constraintSet2.applyTo(constraintLayout);
        lottieAnimationView.setAlpha(0.0f);
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                GameFragmentBase.showTutorialStep4$lambda$2$0$4(this.f$0, lottieAnimationView, view, linearLayoutCompat);
            }
        }, 2000L);
        gameFragmentBase.tutorialLottieAnimationView = lottieAnimationView;
        viewInflate.setAlpha(0.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewInflate, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.start();
        gameFragmentBase.tutorialTextView = viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showTutorialStep4$lambda$2$0$1(final GameFragmentBase gameFragmentBase, LinearLayoutCompat linearLayoutCompat) {
        if (gameFragmentBase.tutorialButtonDisabled) {
            return Unit.INSTANCE;
        }
        gameFragmentBase.tutorialButtonDisabled = true;
        linearLayoutCompat.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda84
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showTutorialEnd();
            }
        }, 200L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTutorialStep4$lambda$2$0$4(final GameFragmentBase gameFragmentBase, final LottieAnimationView lottieAnimationView, final View view, final LinearLayoutCompat linearLayoutCompat) {
        if (gameFragmentBase.getContext() == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(lottieAnimationView, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(200L);
        Intrinsics.checkNotNull(objectAnimatorOfFloat);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep4$lambda$2$0$4$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (this.this$0.getContext() == null) {
                    return;
                }
                lottieAnimationView.playAnimation();
                View view2 = view;
                final GameFragmentBase gameFragmentBase2 = this.this$0;
                final LottieAnimationView lottieAnimationView2 = lottieAnimationView;
                final View view3 = view;
                final LinearLayoutCompat linearLayoutCompat2 = linearLayoutCompat;
                view2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep4$3$1$2$1$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (gameFragmentBase2.getContext() == null) {
                            return;
                        }
                        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(lottieAnimationView2, "alpha", 1.0f, 0.0f);
                        objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
                        objectAnimatorOfFloat2.setDuration(200L);
                        Intrinsics.checkNotNull(objectAnimatorOfFloat2);
                        final GameFragmentBase gameFragmentBase3 = gameFragmentBase2;
                        final View view4 = view3;
                        final LottieAnimationView lottieAnimationView3 = lottieAnimationView2;
                        final LinearLayoutCompat linearLayoutCompat3 = linearLayoutCompat2;
                        objectAnimatorOfFloat2.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep4$3$1$2$1$1$run$$inlined$doOnEnd$1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                if (gameFragmentBase3.getContext() == null) {
                                    return;
                                }
                                gameFragmentBase3.getLifeViews().get(0).tutorialOpenSwipeMenu();
                                View view5 = view4;
                                final LottieAnimationView lottieAnimationView4 = lottieAnimationView3;
                                final GameFragmentBase gameFragmentBase4 = gameFragmentBase3;
                                final View view6 = view4;
                                final LinearLayoutCompat linearLayoutCompat4 = linearLayoutCompat3;
                                view5.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep4$3$1$2$1$1$1$1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(lottieAnimationView4, "alpha", 0.0f, 1.0f);
                                        objectAnimatorOfFloat3.setInterpolator(new DecelerateInterpolator());
                                        objectAnimatorOfFloat3.setDuration(200L);
                                        Intrinsics.checkNotNull(objectAnimatorOfFloat3);
                                        final GameFragmentBase gameFragmentBase5 = gameFragmentBase4;
                                        final LottieAnimationView lottieAnimationView5 = lottieAnimationView4;
                                        final View view7 = view6;
                                        final LinearLayoutCompat linearLayoutCompat5 = linearLayoutCompat4;
                                        objectAnimatorOfFloat3.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep4$3$1$2$1$1$1$1$run$$inlined$doOnEnd$1
                                            @Override // android.animation.Animator.AnimatorListener
                                            public void onAnimationCancel(Animator animator3) {
                                            }

                                            @Override // android.animation.Animator.AnimatorListener
                                            public void onAnimationEnd(Animator animator3) {
                                                if (gameFragmentBase5.getContext() == null) {
                                                    return;
                                                }
                                                lottieAnimationView5.playAnimation();
                                                View view8 = view7;
                                                final GameFragmentBase gameFragmentBase6 = gameFragmentBase5;
                                                final LottieAnimationView lottieAnimationView6 = lottieAnimationView5;
                                                final View view9 = view7;
                                                final LinearLayoutCompat linearLayoutCompat6 = linearLayoutCompat5;
                                                view8.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep4$3$1$2$1$1$1$1$1$1
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        if (gameFragmentBase6.getContext() == null) {
                                                            return;
                                                        }
                                                        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(lottieAnimationView6, "alpha", 1.0f, 0.0f);
                                                        objectAnimatorOfFloat4.setInterpolator(new DecelerateInterpolator());
                                                        objectAnimatorOfFloat4.setDuration(200L);
                                                        Intrinsics.checkNotNull(objectAnimatorOfFloat4);
                                                        final GameFragmentBase gameFragmentBase7 = gameFragmentBase6;
                                                        final View view10 = view9;
                                                        final LinearLayoutCompat linearLayoutCompat7 = linearLayoutCompat6;
                                                        objectAnimatorOfFloat4.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep4$3$1$2$1$1$1$1$1$1$run$$inlined$doOnEnd$1
                                                            @Override // android.animation.Animator.AnimatorListener
                                                            public void onAnimationCancel(Animator animator4) {
                                                            }

                                                            @Override // android.animation.Animator.AnimatorListener
                                                            public void onAnimationEnd(Animator animator4) {
                                                                if (gameFragmentBase7.getContext() == null) {
                                                                    return;
                                                                }
                                                                gameFragmentBase7.getLifeViews().get(0).swipeClose(gameFragmentBase7.getLifeViews().get(0).getLastSwipeDirection());
                                                                gameFragmentBase7.getLifeViews().get(0).setUserInteractionEnabled(false);
                                                                View view11 = view10;
                                                                final LinearLayoutCompat linearLayoutCompat8 = linearLayoutCompat7;
                                                                final GameFragmentBase gameFragmentBase8 = gameFragmentBase7;
                                                                view11.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$showTutorialStep4$3$1$2$1$1$1$1$1$1$1$1
                                                                    @Override // java.lang.Runnable
                                                                    public final void run() {
                                                                        linearLayoutCompat8.setAlpha(0.0f);
                                                                        linearLayoutCompat8.setVisibility(0);
                                                                        gameFragmentBase8.tutorialButtonDisabled = false;
                                                                        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(linearLayoutCompat8, "alpha", 0.0f, 1.0f);
                                                                        objectAnimatorOfFloat5.setInterpolator(new DecelerateInterpolator());
                                                                        objectAnimatorOfFloat5.setDuration(250L);
                                                                        objectAnimatorOfFloat5.start();
                                                                    }
                                                                }, 500L);
                                                            }

                                                            @Override // android.animation.Animator.AnimatorListener
                                                            public void onAnimationRepeat(Animator animator4) {
                                                            }

                                                            @Override // android.animation.Animator.AnimatorListener
                                                            public void onAnimationStart(Animator animator4) {
                                                            }
                                                        });
                                                        objectAnimatorOfFloat4.start();
                                                    }
                                                }, 1000L);
                                            }

                                            @Override // android.animation.Animator.AnimatorListener
                                            public void onAnimationRepeat(Animator animator3) {
                                            }

                                            @Override // android.animation.Animator.AnimatorListener
                                            public void onAnimationStart(Animator animator3) {
                                            }
                                        });
                                        objectAnimatorOfFloat3.start();
                                    }
                                }, 1500L);
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator2) {
                            }
                        });
                        objectAnimatorOfFloat2.start();
                    }
                }, 1000L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        objectAnimatorOfFloat.start();
    }

    private final void signalCardScanInProgress(int index) {
        this.currentScanIndex = index;
    }

    private final void signalPhotoPickInProgress(int index) {
        this.currentPhotoIndex = index;
    }

    static final void startTutorialAnimations$lambda$0(GameFragmentBase gameFragmentBase) {
        int numberOfPlayers = gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers();
        for (int i = 0; i < numberOfPlayers; i++) {
            if (i != 0) {
                gameFragmentBase.lifeViews.get(i).dim();
            }
        }
        gameFragmentBase.showTutorialStart();
    }

    static final Unit stormCounterTapped$lambda$0(GameFragmentBase gameFragmentBase, Ref.IntRef intRef, int i, boolean z) {
        gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef.element).setStormCount(i);
        gameFragmentBase.lifeViews.get(intRef.element).setStormCount(i);
        Context context = gameFragmentBase.getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
        }
        if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 5 && gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            LifeTotalView lifeTotalView = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView != null) {
                lifeTotalView.setStormCount(Math.max(gameFragmentBase.lifeViews.get(0).getStormCount(), gameFragmentBase.lifeViews.get(3).getStormCount()));
            }
            LifeTotalView lifeTotalView2 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView2 != null) {
                lifeTotalView2.setStormCount(Math.max(gameFragmentBase.lifeViews.get(1).getStormCount(), gameFragmentBase.lifeViews.get(2).getStormCount()));
            }
        }
        if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 6 && gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            LifeTotalView lifeTotalView3 = gameFragmentBase.lifeViewTeam1;
            if (lifeTotalView3 != null) {
                lifeTotalView3.setStormCount(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.lifeViews.get(0).getStormCount(), gameFragmentBase.lifeViews.get(1).getStormCount(), gameFragmentBase.lifeViews.get(5).getStormCount()}));
            }
            LifeTotalView lifeTotalView4 = gameFragmentBase.lifeViewTeam2;
            if (lifeTotalView4 != null) {
                lifeTotalView4.setStormCount(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.lifeViews.get(2).getStormCount(), gameFragmentBase.lifeViews.get(3).getStormCount(), gameFragmentBase.lifeViews.get(4).getStormCount()}));
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit stormCounterTapped$lambda$1(GameFragmentBase gameFragmentBase, Ref.IntRef intRef, int i) {
        int stormCount = gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef.element).getStormCount() - i;
        if (stormCount != 0) {
            gameFragmentBase.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Storm.getValue(), intRef.element, null, stormCount, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            Context context = gameFragmentBase.getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit swipeMenuClosed$lambda$0$0(GameFragmentBase gameFragmentBase) {
        if (gameFragmentBase.getContext() == null) {
            return Unit.INSTANCE;
        }
        gameFragmentBase.toggleTimerPause();
        return Unit.INSTANCE;
    }

    static final Unit taxCounterTapped$lambda$0(GameFragmentBase gameFragmentBase, Ref.IntRef intRef, int i, boolean z) {
        if (z) {
            gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef.element).setTaxCountPartner(i);
            gameFragmentBase.lifeViews.get(intRef.element).setTaxCountPartner(i);
        } else {
            gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef.element).setTaxCount(i);
            gameFragmentBase.lifeViews.get(intRef.element).setTaxCount(i);
        }
        Context context = gameFragmentBase.getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
        }
        if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 5 && gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            if (z) {
                LifeTotalView lifeTotalView = gameFragmentBase.lifeViewTeam1;
                if (lifeTotalView != null) {
                    lifeTotalView.setTaxCountPartner(Math.max(gameFragmentBase.lifeViews.get(0).getTaxCountPartner(), gameFragmentBase.lifeViews.get(3).getTaxCountPartner()));
                }
                LifeTotalView lifeTotalView2 = gameFragmentBase.lifeViewTeam2;
                if (lifeTotalView2 != null) {
                    lifeTotalView2.setTaxCountPartner(Math.max(gameFragmentBase.lifeViews.get(1).getTaxCountPartner(), gameFragmentBase.lifeViews.get(2).getTaxCountPartner()));
                }
            } else {
                LifeTotalView lifeTotalView3 = gameFragmentBase.lifeViewTeam1;
                if (lifeTotalView3 != null) {
                    lifeTotalView3.setTaxCount(Math.max(gameFragmentBase.lifeViews.get(0).getTaxCount(), gameFragmentBase.lifeViews.get(3).getTaxCount()));
                }
                LifeTotalView lifeTotalView4 = gameFragmentBase.lifeViewTeam2;
                if (lifeTotalView4 != null) {
                    lifeTotalView4.setTaxCount(Math.max(gameFragmentBase.lifeViews.get(1).getTaxCount(), gameFragmentBase.lifeViews.get(2).getTaxCount()));
                }
            }
        }
        if (gameFragmentBase.getSharedViewModel().getGameState().getSubformatId() == 6 && gameFragmentBase.getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            if (z) {
                LifeTotalView lifeTotalView5 = gameFragmentBase.lifeViewTeam1;
                if (lifeTotalView5 != null) {
                    lifeTotalView5.setTaxCountPartner(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.lifeViews.get(0).getTaxCountPartner(), gameFragmentBase.lifeViews.get(1).getTaxCountPartner(), gameFragmentBase.lifeViews.get(5).getTaxCountPartner()}));
                }
                LifeTotalView lifeTotalView6 = gameFragmentBase.lifeViewTeam2;
                if (lifeTotalView6 != null) {
                    lifeTotalView6.setTaxCountPartner(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.lifeViews.get(2).getTaxCountPartner(), gameFragmentBase.lifeViews.get(3).getTaxCountPartner(), gameFragmentBase.lifeViews.get(4).getTaxCountPartner()}));
                }
            } else {
                LifeTotalView lifeTotalView7 = gameFragmentBase.lifeViewTeam1;
                if (lifeTotalView7 != null) {
                    lifeTotalView7.setTaxCount(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.lifeViews.get(0).getTaxCount(), gameFragmentBase.lifeViews.get(1).getTaxCount(), gameFragmentBase.lifeViews.get(5).getTaxCount()}));
                }
                LifeTotalView lifeTotalView8 = gameFragmentBase.lifeViewTeam2;
                if (lifeTotalView8 != null) {
                    lifeTotalView8.setTaxCount(ArraysKt.maxOrThrow(new int[]{gameFragmentBase.lifeViews.get(2).getTaxCount(), gameFragmentBase.lifeViews.get(3).getTaxCount(), gameFragmentBase.lifeViews.get(4).getTaxCount()}));
                }
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit taxCounterTapped$lambda$1(GameFragmentBase gameFragmentBase, Ref.IntRef intRef, int i, int i2) {
        int taxCount = gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef.element).getTaxCount() - i;
        if (taxCount != 0) {
            gameFragmentBase.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Tax.getValue(), intRef.element, null, taxCount, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
        }
        int taxCountPartner = gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(intRef.element).getTaxCountPartner() - i2;
        if (taxCountPartner != 0) {
            gameFragmentBase.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.TaxPartner.getValue(), intRef.element, null, taxCountPartner, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
        }
        Context context = gameFragmentBase.getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
        }
        return Unit.INSTANCE;
    }

    static final Unit theRingCoinDropped$lambda$0(GameFragmentBase gameFragmentBase, int i, int i2) {
        if (i2 != -1) {
            gameFragmentBase.getSharedViewModel().getGameState().getPlayers().get(i).setTheRingLevel(i2);
            Context context = gameFragmentBase.getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(gameFragmentBase.getSharedViewModel().getGameState());
            }
        }
        return Unit.INSTANCE;
    }

    static final boolean undoNextTurnTapped$lambda$0(int i, int i2, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == i && it.getValue() == i2;
    }

    static final boolean undoNextTurnTapped$lambda$10(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 1 && it.getValue() == i;
    }

    static final boolean undoNextTurnTapped$lambda$12(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 5 && it.getValue() == i;
    }

    static final boolean undoNextTurnTapped$lambda$14(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 0 && it.getValue() == i;
    }

    static final boolean undoNextTurnTapped$lambda$16(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 5 && it.getValue() == i;
    }

    static final boolean undoNextTurnTapped$lambda$18(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 0 && it.getValue() == i;
    }

    static final boolean undoNextTurnTapped$lambda$2(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 3 && it.getValue() == i;
    }

    static final boolean undoNextTurnTapped$lambda$20(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 1 && it.getValue() == i;
    }

    static final boolean undoNextTurnTapped$lambda$22(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 3 && it.getValue() == i;
    }

    static final boolean undoNextTurnTapped$lambda$24(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 4 && it.getValue() == i;
    }

    static final boolean undoNextTurnTapped$lambda$26(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 2 && it.getValue() == i;
    }

    static final boolean undoNextTurnTapped$lambda$28(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 4 && it.getValue() == i;
    }

    static final boolean undoNextTurnTapped$lambda$30(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 2 && it.getValue() == i;
    }

    static final boolean undoNextTurnTapped$lambda$32(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 3 && it.getValue() == i;
    }

    static final boolean undoNextTurnTapped$lambda$4(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 0 && it.getValue() == i;
    }

    static final boolean undoNextTurnTapped$lambda$6(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 2 && it.getValue() == i;
    }

    static final boolean undoNextTurnTapped$lambda$8(int i, MTGameEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getType(), MTEvent.TurnStart.getValue()) && it.getPlayerid() == 1 && it.getValue() == i;
    }

    private final void undoPlayerDeath(int playerIndex) {
        List<LifeTotalView> list;
        Object obj;
        Object next;
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        boolean z = true;
        if (getSharedViewModel().getGameState().getPlayers().size() > 1) {
            int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
            int i = 0;
            for (int i2 = 0; i2 < numberOfPlayers; i2++) {
                if (getSharedViewModel().getGameState().getPlayers().get(i2).isKO()) {
                    i++;
                }
            }
            boolean z2 = i == getSharedViewModel().getGameState().getPlayers().size() - 1;
            if (getSharedViewModel().getGameState().getSubformatId() == 5 && i == 2) {
                z2 = true;
            }
            if (getSharedViewModel().getGameState().getSubformatId() != 6 || i != 3) {
                z = z2;
            }
        } else {
            z = false;
        }
        getSharedViewModel().getGameState().getPlayers().get(playerIndex).setKO(false);
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        int size = this.lifeViews.size();
        int i3 = 0;
        while (true) {
            list = this.lifeViews;
            if (i3 >= size) {
                break;
            }
            list.get(i3).setDisplayedCommanderDamage(commanderDamageValueToShowFor(i3));
            this.lifeViews.get(i3).checkVitals();
            i3++;
        }
        list.get(playerIndex).undoKO();
        getSharedViewModel().getGameState().getPlayers().get(playerIndex).setResultid(-1);
        Iterator<T> it = getSharedViewModel().getGameState().getEvents().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            MTGameEvent mTGameEvent = (MTGameEvent) next;
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.PlayerLose.getValue()) && mTGameEvent.getPlayerid() == playerIndex) {
                break;
            }
        }
        MTGameEvent mTGameEvent2 = (MTGameEvent) next;
        if (mTGameEvent2 != null) {
            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent2);
        }
        if (z) {
            int numberOfPlayers2 = getSharedViewModel().getGameState().getNumberOfPlayers();
            for (int i4 = 0; i4 < numberOfPlayers2; i4++) {
                if (this.lifeViews.get(i4).getIsWin()) {
                    this.lifeViews.get(i4).undoWin();
                    getSharedViewModel().getGameState().getPlayers().get(i4).setResultid(-1);
                }
            }
            Iterator<T> it2 = getSharedViewModel().getGameState().getEvents().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                if (Intrinsics.areEqual(((MTGameEvent) next2).getType(), MTEvent.PlayerWin.getValue())) {
                    obj = next2;
                    break;
                }
            }
            MTGameEvent mTGameEvent3 = (MTGameEvent) obj;
            if (mTGameEvent3 != null) {
                getSharedViewModel().getGameState().getEvents().remove(mTGameEvent3);
            }
        }
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
        updateStreamingState$app_release();
    }

    private final void undoPlayerWin(int playerIndex) {
        Object obj;
        int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
        int i = 0;
        while (true) {
            obj = null;
            if (i >= numberOfPlayers) {
                break;
            }
            if (i == playerIndex) {
                this.lifeViews.get(i).undoWin();
            } else if (getSharedViewModel().getGameState().getPlayers().get(i).isKO()) {
                getSharedViewModel().getGameState().getPlayers().get(i).setKO(false);
                this.lifeViews.get(i).undoKO();
                Iterator<T> it = getSharedViewModel().getGameState().getEvents().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    MTGameEvent mTGameEvent = (MTGameEvent) next;
                    if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.PlayerLose.getValue()) && mTGameEvent.getPlayerid() == i) {
                        obj = next;
                        break;
                    }
                }
                MTGameEvent mTGameEvent2 = (MTGameEvent) obj;
                if (mTGameEvent2 != null) {
                    getSharedViewModel().getGameState().getEvents().remove(mTGameEvent2);
                }
            }
            i++;
        }
        Iterator<T> it2 = getSharedViewModel().getGameState().getEvents().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            MTGameEvent mTGameEvent3 = (MTGameEvent) next2;
            if (Intrinsics.areEqual(mTGameEvent3.getType(), MTEvent.PlayerWin.getValue()) && mTGameEvent3.getPlayerid() == playerIndex) {
                obj = next2;
                break;
            }
        }
        MTGameEvent mTGameEvent4 = (MTGameEvent) obj;
        if (mTGameEvent4 != null) {
            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent4);
        }
        showLifeHistory();
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        updateStreamingState$app_release();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d2 A[EDGE_INSN: B:32:0x00d2->B:30:0x00d2 BREAK  A[LOOP:0: B:25:0x00ba->B:34:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateBoScoreEarlyIfNeeded() {
        GameSet currentSet;
        Iterator<T> it;
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (getSharedViewModel().getGameState().getPlayers().size() != 2 || (currentSet = preferencesManager.getCurrentSet()) == null) {
            return;
        }
        int playerScore = GameUtils.INSTANCE.getInstance().getPlayerScore(0, currentSet);
        int playerScore2 = GameUtils.INSTANCE.getInstance().getPlayerScore(1, currentSet);
        Player player = getSharedViewModel().getGameState().getPlayers().get(0);
        Player player2 = getSharedViewModel().getGameState().getPlayers().get(1);
        List<Integer> gameWinners = GameUtils.INSTANCE.getInstance().getGameWinners(getSharedViewModel().getGameState());
        boolean z = gameWinners instanceof Collection;
        if (!z || !gameWinners.isEmpty()) {
            Iterator<T> it2 = gameWinners.iterator();
            while (it2.hasNext()) {
                if (((Number) it2.next()).intValue() == player.getUserId()) {
                    playerScore++;
                    break;
                }
            }
            if (z || !gameWinners.isEmpty()) {
                it = gameWinners.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((Number) it.next()).intValue() == player2.getUserId()) {
                        playerScore2++;
                        break;
                    }
                }
            }
        } else if (z) {
            it = gameWinners.iterator();
            while (true) {
                if (!it.hasNext()) {
                }
            }
        }
        showBestOfScore(playerScore, playerScore2);
    }

    public final void applySeatingAndDecks() {
        List<String> playmats;
        int i;
        Map<Integer, Player> map;
        boolean z;
        List<String> playmats2;
        Boolean overridePlaymats;
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        getSharedViewModel().getGameState().setUsersSeated(true);
        getSharedViewModel().getGameState().setDecksSelected(true);
        int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
        Map<Integer, Player> map2 = this.seatedPlayers;
        int i2 = 0;
        if (map2 != null) {
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            ArrayList arrayList = new ArrayList();
            PlaymatCategory playmatCategoryPickRandomCategory = companion.pickRandomCategory();
            while (i2 < numberOfPlayers) {
                Player player = map2.get(Integer.valueOf(i2));
                if (player != null) {
                    getSharedViewModel().getGameState().getPlayers().set(i2, player);
                    SkinManager companion2 = SkinManager.INSTANCE.getInstance();
                    Context contextRequireContext2 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                    SkinDefinition currentSkinDefinition = companion2.getCurrentSkinDefinition(contextRequireContext2);
                    if (currentSkinDefinition == null || (overridePlaymats = currentSkinDefinition.getOverridePlaymats()) == null) {
                        i = numberOfPlayers;
                        map = map2;
                        z = true;
                    } else {
                        boolean zBooleanValue = overridePlaymats.booleanValue();
                        z = !zBooleanValue;
                        if (zBooleanValue) {
                            List<String> playmats3 = currentSkinDefinition.getPlaymats();
                            SkinManager companion3 = SkinManager.INSTANCE.getInstance();
                            map = map2;
                            Context contextRequireContext3 = requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                            String currentSkinCode = companion3.getCurrentSkinCode(contextRequireContext3);
                            if (playmats3 == null || playmats3.isEmpty()) {
                                i = numberOfPlayers;
                            } else {
                                String strRandomPlaymatFromSkin = GameUtils.INSTANCE.getInstance().randomPlaymatFromSkin(playmats3, arrayList);
                                String str = currentSkinCode + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + strRandomPlaymatFromSkin;
                                i = numberOfPlayers;
                                getSharedViewModel().getGameState().getPlayers().get(i2).setBackgroundType(BackgroundType.PLAYMAT);
                                getSharedViewModel().getGameState().getPlayers().get(i2).setPlaymatId(str);
                                arrayList.add(strRandomPlaymatFromSkin);
                            }
                        } else {
                            i = numberOfPlayers;
                            map = map2;
                        }
                    }
                    if ((getSharedViewModel().getGameState().getPlayers().get(i2).getUserId() < 0 || getSharedViewModel().getGameState().getPlayers().get(i2).getDeckId() == -1) && z && getContext() != null) {
                        String string = preferencesManager.getString(PreferencesManager.BACKGROUND_BY_DEFAULT, PreferencesManager.BACKGROUND_PLAYMAT);
                        if (Intrinsics.areEqual(string, PreferencesManager.BACKGROUND_PLAYMAT) && getSharedViewModel().getGameState().getPlayers().get(i2).getBackgroundType() == BackgroundType.PLAIN_COLOR) {
                            getSharedViewModel().getGameState().getPlayers().get(i2).setBackgroundType(BackgroundType.PLAYMAT);
                            SkinManager companion4 = SkinManager.INSTANCE.getInstance();
                            Context contextRequireContext4 = requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                            String currentSkinCode2 = companion4.getCurrentSkinCode(contextRequireContext4);
                            SkinManager companion5 = SkinManager.INSTANCE.getInstance();
                            Context contextRequireContext5 = requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
                            SkinDefinition currentSkinDefinition2 = companion5.getCurrentSkinDefinition(contextRequireContext5);
                            if (currentSkinDefinition2 == null || (playmats2 = currentSkinDefinition2.getPlaymats()) == null || playmats2.isEmpty()) {
                                getSharedViewModel().getGameState().getPlayers().get(i2).setPlaymatId(companion.randomPlaymat(playmatCategoryPickRandomCategory, arrayList));
                                arrayList.add(getSharedViewModel().getGameState().getPlayers().get(i2).getPlaymatId());
                            } else {
                                String strRandomPlaymatFromSkin2 = GameUtils.INSTANCE.getInstance().randomPlaymatFromSkin(playmats2, arrayList);
                                getSharedViewModel().getGameState().getPlayers().get(i2).setPlaymatId(currentSkinCode2 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + strRandomPlaymatFromSkin2);
                                arrayList.add(strRandomPlaymatFromSkin2);
                            }
                            preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
                        }
                        if (Intrinsics.areEqual(string, PreferencesManager.BACKGROUND_BLACK) && getSharedViewModel().getGameState().getPlayers().get(i2).getBackgroundType() == BackgroundType.PLAIN_COLOR) {
                            getSharedViewModel().getGameState().getPlayers().get(i2).setBackgroundType(BackgroundType.BLACK);
                        }
                    }
                    this.lifeViews.get(i2).updatePlayer(player);
                } else {
                    i = numberOfPlayers;
                    map = map2;
                }
                i2++;
                map2 = map;
                numberOfPlayers = i;
            }
        } else {
            GameUtils companion6 = GameUtils.INSTANCE.getInstance();
            ArrayList arrayList2 = new ArrayList();
            PlaymatCategory playmatCategoryPickRandomCategory2 = companion6.pickRandomCategory();
            while (i2 < numberOfPlayers) {
                if (getSharedViewModel().getGameState().getPlayers().get(i2).getUserId() < 0 || getSharedViewModel().getGameState().getPlayers().get(i2).getDeckId() == -1) {
                    if (getContext() != null) {
                        String string2 = preferencesManager.getString(PreferencesManager.BACKGROUND_BY_DEFAULT, PreferencesManager.BACKGROUND_PLAYMAT);
                        if (Intrinsics.areEqual(string2, PreferencesManager.BACKGROUND_PLAYMAT) && getSharedViewModel().getGameState().getPlayers().get(i2).getBackgroundType() == BackgroundType.PLAIN_COLOR) {
                            getSharedViewModel().getGameState().getPlayers().get(i2).setBackgroundType(BackgroundType.PLAYMAT);
                            SkinManager companion7 = SkinManager.INSTANCE.getInstance();
                            Context contextRequireContext6 = requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext6, "requireContext(...)");
                            String currentSkinCode3 = companion7.getCurrentSkinCode(contextRequireContext6);
                            SkinManager companion8 = SkinManager.INSTANCE.getInstance();
                            Context contextRequireContext7 = requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext7, "requireContext(...)");
                            SkinDefinition currentSkinDefinition3 = companion8.getCurrentSkinDefinition(contextRequireContext7);
                            if (currentSkinDefinition3 == null || (playmats = currentSkinDefinition3.getPlaymats()) == null || playmats.isEmpty()) {
                                getSharedViewModel().getGameState().getPlayers().get(i2).setPlaymatId(companion6.randomPlaymat(playmatCategoryPickRandomCategory2, arrayList2));
                                arrayList2.add(getSharedViewModel().getGameState().getPlayers().get(i2).getPlaymatId());
                            } else {
                                String strRandomPlaymatFromSkin3 = GameUtils.INSTANCE.getInstance().randomPlaymatFromSkin(playmats, arrayList2);
                                getSharedViewModel().getGameState().getPlayers().get(i2).setPlaymatId(currentSkinCode3 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + strRandomPlaymatFromSkin3);
                                arrayList2.add(strRandomPlaymatFromSkin3);
                            }
                            preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
                        }
                        if (Intrinsics.areEqual(string2, PreferencesManager.BACKGROUND_BLACK) && getSharedViewModel().getGameState().getPlayers().get(i2).getBackgroundType() == BackgroundType.PLAIN_COLOR) {
                            getSharedViewModel().getGameState().getPlayers().get(i2).setBackgroundType(BackgroundType.BLACK);
                        }
                    }
                }
                this.lifeViews.get(i2).updatePlayer(getSharedViewModel().getGameState().getPlayers().get(i2));
                i2++;
            }
        }
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
        updateStreamingState$app_release();
        this.seatedUsers = null;
        this.seatedPlayers = null;
    }

    public void archenemyToggled(boolean isOn) {
    }

    public final void askForPlayerKO(int index, boolean fromMenu) {
        if (getSharedViewModel().getGameState().getNumberOfPlayers() == this.lifeViews.size() && getSharedViewModel().getGameState().getNumberOfPlayers() == getSharedViewModel().getGameState().getPlayers().size() && index < this.lifeViews.size()) {
            if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                if (getSharedViewModel().getGameState().getPlayers().size() == 4) {
                    if (index == 0 || index == 3) {
                        LifeTotalView lifeTotalView = this.lifeViewTeam1;
                        if (lifeTotalView != null) {
                            lifeTotalView.triggerPlayerDeadQ("", fromMenu);
                            return;
                        }
                        return;
                    }
                    LifeTotalView lifeTotalView2 = this.lifeViewTeam2;
                    if (lifeTotalView2 != null) {
                        lifeTotalView2.triggerPlayerDeadQ("", fromMenu);
                        return;
                    }
                    return;
                }
                return;
            }
            if (getSharedViewModel().getGameState().getSubformatId() != 6) {
                this.lifeViews.get(index).triggerPlayerDeadQ("", fromMenu);
                return;
            }
            if (getSharedViewModel().getGameState().getPlayers().size() == 6) {
                if (index == 0 || index == 1 || index == 5) {
                    LifeTotalView lifeTotalView3 = this.lifeViewTeam1;
                    if (lifeTotalView3 != null) {
                        lifeTotalView3.triggerPlayerDeadQ("", fromMenu);
                        return;
                    }
                    return;
                }
                LifeTotalView lifeTotalView4 = this.lifeViewTeam2;
                if (lifeTotalView4 != null) {
                    lifeTotalView4.triggerPlayerDeadQ("", fromMenu);
                }
            }
        }
    }

    public final void checkIfGameIsReady() {
        Map<Integer, Player> map;
        if (getSharedViewModel().getGameState().getPlaygroupId() == -1) {
            showStartGameButton();
            return;
        }
        Map<Integer, MTUser> map2 = this.seatedUsers;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = map2 == null || map2.size() == getSharedViewModel().getGameState().getNumberOfPlayers();
        Map<Integer, Player> map3 = this.seatedPlayers;
        if (map3 != null && map3.size() != getSharedViewModel().getGameState().getNumberOfPlayers()) {
            z3 = false;
        }
        if (z3 && (map = this.seatedPlayers) != null) {
            Intrinsics.checkNotNull(map);
            Iterator<Map.Entry<Integer, Player>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Player value = it.next().getValue();
                if (value.getUserId() > 0 && value.getDeckId() == -1) {
                    z = false;
                    break;
                }
            }
            if (z && !getSharedViewModel().getGameState().getDecksSelected()) {
                showStartGameButton();
            }
        }
        if (z3 && this.seatedPlayers == null) {
            Iterator<T> it2 = getSharedViewModel().getGameState().getPlayers().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = z;
                    break;
                }
                Player player = (Player) it2.next();
                if (player.getUserId() > 0 && player.getDeckId() == -1) {
                    break;
                }
            }
            if (!z2 || getSharedViewModel().getGameState().getDecksSelected()) {
                return;
            }
            showStartGameButton();
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void cityCoinDropped(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                this.lifeViews.get(i).showCityCoin();
                if (getContext() == null) {
                    return;
                }
                Breadcrumbs.INSTANCE.leaveBreadcrumb("city_coin_dropped");
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                firebaseAnalytics.logEvent("city_coin_dropped", null);
                getSharedViewModel().getGameState().getPlayers().get(i).setCityBlessing(true);
                getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.CityBlessing.getValue(), i, null, 1, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).saveCurrentGame(getSharedViewModel().getGameState());
        updateStreamingState$app_release();
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void cityCoinRejected() {
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            boolean hasBlessing = this.lifeViews.get(i).getHasBlessing();
            List<LifeTotalView> list = this.lifeViews;
            if (hasBlessing) {
                list.get(i).showCityCoin();
            } else {
                list.get(i).hideCityCoin();
            }
        }
    }

    public final void closeCurrentTurn() {
        if (getSharedViewModel().getGameState().getSubformatId() == 5) {
            if (getSharedViewModel().getGameState().getNumberOfPlayers() == 4 && getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                int currentTurnPlayerIndex = getSharedViewModel().getGameState().getCurrentTurnPlayerIndex();
                long currentTurnStartTime = getSharedViewModel().getGameState().getCurrentTurnStartTime();
                MTGameEvent mTGameEvent = new MTGameEvent(null, MTEvent.TurnEnd.getValue(), currentTurnPlayerIndex, null, (int) (((System.currentTimeMillis() - currentTurnStartTime) / 1000) - ((long) getSharedViewModel().getGameState().getCurrentTurnPauseTime())), GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
                getSharedViewModel().getGameState().getEvents().add(mTGameEvent);
                if (currentTurnPlayerIndex == 0 || currentTurnPlayerIndex == 3) {
                    addEventIfNeeded(mTGameEvent, 0);
                    addEventIfNeeded(mTGameEvent, 3);
                    return;
                } else {
                    addEventIfNeeded(mTGameEvent, 1);
                    addEventIfNeeded(mTGameEvent, 2);
                    return;
                }
            }
            return;
        }
        if (getSharedViewModel().getGameState().getSubformatId() != 6) {
            if (getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                long currentTurnStartTime2 = getSharedViewModel().getGameState().getCurrentTurnStartTime();
                getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.TurnEnd.getValue(), getSharedViewModel().getGameState().getCurrentTurnPlayerIndex(), null, (int) (((System.currentTimeMillis() - currentTurnStartTime2) / 1000) - ((long) getSharedViewModel().getGameState().getCurrentTurnPauseTime())), GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                return;
            }
            return;
        }
        if (getSharedViewModel().getGameState().getNumberOfPlayers() == 6 && getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            int currentTurnPlayerIndex2 = getSharedViewModel().getGameState().getCurrentTurnPlayerIndex();
            long currentTurnStartTime3 = getSharedViewModel().getGameState().getCurrentTurnStartTime();
            MTGameEvent mTGameEvent2 = new MTGameEvent(null, MTEvent.TurnEnd.getValue(), currentTurnPlayerIndex2, null, (int) (((System.currentTimeMillis() - currentTurnStartTime3) / 1000) - ((long) getSharedViewModel().getGameState().getCurrentTurnPauseTime())), GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
            getSharedViewModel().getGameState().getEvents().add(mTGameEvent2);
            if (currentTurnPlayerIndex2 == 0 || currentTurnPlayerIndex2 == 1 || currentTurnPlayerIndex2 == 5) {
                addEventIfNeeded(mTGameEvent2, 0);
                addEventIfNeeded(mTGameEvent2, 1);
                addEventIfNeeded(mTGameEvent2, 5);
            } else {
                addEventIfNeeded(mTGameEvent2, 2);
                addEventIfNeeded(mTGameEvent2, 3);
                addEventIfNeeded(mTGameEvent2, 4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0295  */
    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void commanderDamageClosed(LifeTotalView sender) {
        List<LifeTotalView> list;
        List<Integer> commanderDamageListPartner;
        Iterator<T> it;
        LifeTotalView lifeTotalView;
        LifeTotalView lifeTotalView2;
        Intrinsics.checkNotNullParameter(sender, "sender");
        final Ref.IntRef intRef = new Ref.IntRef();
        int size = this.lifeViews.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                intRef.element = i2;
                break;
            }
            i2++;
        }
        if (getSharedViewModel().getGameState().getNumberOfPlayers() == this.lifeViews.size() && getSharedViewModel().getGameState().getNumberOfPlayers() == getSharedViewModel().getGameState().getPlayers().size()) {
            if (!this.tutorialMode) {
                showMenu();
                showLifeHistory();
                if (getSharedViewModel().getGameState().getHasDayNight()) {
                    dayNightToggled(getSharedViewModel().getGameState().getHasDayNight());
                }
                if (getSharedViewModel().getGameState().getHasPlanechase()) {
                    planechaseToggled(getSharedViewModel().getGameState().getHasPlanechase());
                }
                if (getSharedViewModel().getGameState().getHasArchenemy()) {
                    archenemyToggled(getSharedViewModel().getGameState().getHasArchenemy());
                }
                if (this.clockShowing) {
                    if (!this.hasCustomMenuImage) {
                        View view = getView();
                        CustomCircleView customCircleView = view != null ? (CustomCircleView) view.findViewById(R.id.circleView) : null;
                        if (customCircleView != null) {
                            customCircleView.setVisibility(0);
                        }
                    }
                    Context context = getContext();
                    if (context != null && (new PreferencesManager(context).getBoolean(PreferencesManager.ALWAYS_SHOW_TIMER, true) || getSharedViewModel().getGameState().getTurnTimerEnabled())) {
                        View view2 = getView();
                        TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.timerTextView) : null;
                        if (textView != null) {
                            textView.setVisibility(0);
                        }
                        if (textView != null) {
                            textView.setClickable(true);
                        }
                        if (textView != null) {
                            textView.setFocusable(true);
                        }
                        if (textView != null) {
                            textView.setEnabled(true);
                        }
                        if (textView != null) {
                            ViewExtensionsKt.setOnClickWithBounce(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda76
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return GameFragmentBase.commanderDamageClosed$lambda$0$0(this.f$0);
                                }
                            });
                        }
                        View view3 = getView();
                        TextView textView2 = view3 != null ? (TextView) view3.findViewById(R.id.timerPausedTextView) : null;
                        View view4 = getView();
                        TextView textView3 = view4 != null ? (TextView) view4.findViewById(R.id.timerTurnTextView) : null;
                        if (getSharedViewModel().getGameState().getTurnTimerEnabled() && textView3 != null) {
                            textView3.setVisibility(0);
                        }
                        if (getSharedViewModel().getGameState().getTimerPaused() && textView2 != null) {
                            textView2.setVisibility(0);
                        }
                    }
                }
            }
            int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
            while (true) {
                list = this.lifeViews;
                if (i >= numberOfPlayers) {
                    break;
                }
                if (!list.get(i).getIsKO()) {
                    this.lifeViews.get(i).setUserInteractionEnabled(true);
                }
                this.lifeViews.get(i).hideAllCommanderDamageUI();
                i++;
            }
            list.get(this.currentCommanderDamageIndex).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda77
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragmentBase.commanderDamageClosed$lambda$1(this.f$0);
                }
            }, 400L);
            if (getSharedViewModel().getGameState().getSubformatId() == 5 && getSharedViewModel().getGameState().getNumberOfPlayers() == 4 && (lifeTotalView2 = this.lifeViewTeam1) != null) {
                lifeTotalView2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda78
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameFragmentBase.commanderDamageClosed$lambda$2(this.f$0);
                    }
                }, 175L);
            }
            if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6 && (lifeTotalView = this.lifeViewTeam1) != null) {
                lifeTotalView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda79
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameFragmentBase.commanderDamageClosed$lambda$3(this.f$0);
                    }
                }, 175L);
            }
            int i3 = getSharedViewModel().getGameState().getFormatId() != 16 ? 21 : 16;
            List<Integer> commanderDamageList = getSharedViewModel().getGameState().getPlayers().get(intRef.element).getCommanderDamageList();
            if ((commanderDamageList instanceof Collection) && commanderDamageList.isEmpty()) {
                commanderDamageListPartner = getSharedViewModel().getGameState().getPlayers().get(intRef.element).getCommanderDamageListPartner();
                if (commanderDamageListPartner instanceof Collection) {
                }
                it = commanderDamageListPartner.iterator();
                while (it.hasNext()) {
                }
                return;
            }
            Iterator<T> it2 = commanderDamageList.iterator();
            while (it2.hasNext()) {
                if (((Number) it2.next()).intValue() >= i3) {
                    break;
                }
            }
            commanderDamageListPartner = getSharedViewModel().getGameState().getPlayers().get(intRef.element).getCommanderDamageListPartner();
            if ((commanderDamageListPartner instanceof Collection) || !commanderDamageListPartner.isEmpty()) {
                it = commanderDamageListPartner.iterator();
                while (it.hasNext()) {
                    if (((Number) it.next()).intValue() >= i3) {
                    }
                }
                return;
            }
            return;
            this.lifeViews.get(intRef.element).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda80
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragmentBase gameFragmentBase = this.f$0;
                    gameFragmentBase.confirmPlayerDeath(gameFragmentBase.lifeViews.get(intRef.element), false);
                }
            }, 100L);
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void commanderDamagePartnerRunningTotalChanged(LifeTotalView sender, int newValue) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                this.currentPartnerDamageStack.set(i, Integer.valueOf(newValue));
                return;
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void commanderDamagePartnerValueChanged(LifeTotalView sender, int newValue) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = 0;
                break;
            } else if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                break;
            } else {
                i++;
            }
        }
        getSharedViewModel().getGameState().getPlayers().get(this.currentCommanderDamageIndex).getCommanderDamageListPartner().set(i, Integer.valueOf(newValue));
        this.lifeViews.get(this.currentCommanderDamageIndex).setDisplayedCommanderDamage(commanderDamageValueToShowFor(this.currentCommanderDamageIndex));
        this.lifeViews.get(this.currentCommanderDamageIndex).checkVitals();
        if (getSharedViewModel().getGameState().getSubformatId() == 5 && getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            LifeTotalView lifeTotalView = this.lifeViewTeam1;
            if (lifeTotalView != null) {
                lifeTotalView.setDisplayedCommanderDamage(Math.max(commanderDamageValueToShowFor(0), commanderDamageValueToShowFor(3)));
            }
            LifeTotalView lifeTotalView2 = this.lifeViewTeam2;
            if (lifeTotalView2 != null) {
                lifeTotalView2.setDisplayedCommanderDamage(Math.max(commanderDamageValueToShowFor(1), commanderDamageValueToShowFor(2)));
            }
            LifeTotalView lifeTotalView3 = this.lifeViewTeam1;
            if (lifeTotalView3 != null) {
                lifeTotalView3.checkVitals();
            }
            LifeTotalView lifeTotalView4 = this.lifeViewTeam2;
            if (lifeTotalView4 != null) {
                lifeTotalView4.checkVitals();
            }
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            LifeTotalView lifeTotalView5 = this.lifeViewTeam1;
            if (lifeTotalView5 != null) {
                lifeTotalView5.setDisplayedCommanderDamage(ArraysKt.maxOrThrow(new int[]{commanderDamageValueToShowFor(0), commanderDamageValueToShowFor(1), commanderDamageValueToShowFor(5)}));
            }
            LifeTotalView lifeTotalView6 = this.lifeViewTeam2;
            if (lifeTotalView6 != null) {
                lifeTotalView6.setDisplayedCommanderDamage(ArraysKt.maxOrThrow(new int[]{commanderDamageValueToShowFor(2), commanderDamageValueToShowFor(3), commanderDamageValueToShowFor(4)}));
            }
            LifeTotalView lifeTotalView7 = this.lifeViewTeam1;
            if (lifeTotalView7 != null) {
                lifeTotalView7.checkVitals();
            }
            LifeTotalView lifeTotalView8 = this.lifeViewTeam2;
            if (lifeTotalView8 != null) {
                lifeTotalView8.checkVitals();
            }
        }
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        updateStreamingState$app_release();
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void commanderDamageRunningTotalChanged(LifeTotalView sender, int newValue) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                this.currentCommanderDamageStack.set(i, Integer.valueOf(newValue));
                return;
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void commanderDamageTapped(LifeTotalView sender, int rotation) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                i = i2;
                break;
            }
            i2++;
        }
        this.currentOwnCommanderDamageValue = getSharedViewModel().getGameState().getPlayers().get(i).getCommanderDamageList().get(i).intValue();
        if (i >= getSharedViewModel().getGameState().getPlayers().size()) {
            return;
        }
        showCommanderDamageUI(i, rotation);
    }

    public void commanderDamageToggled(boolean isOn) {
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void commanderDamageValueChanged(LifeTotalView sender, int newValue) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = 0;
                break;
            } else if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                break;
            } else {
                i++;
            }
        }
        getSharedViewModel().getGameState().getPlayers().get(this.currentCommanderDamageIndex).getCommanderDamageList().set(i, Integer.valueOf(newValue));
        this.lifeViews.get(this.currentCommanderDamageIndex).setDisplayedCommanderDamage(commanderDamageValueToShowFor(this.currentCommanderDamageIndex));
        this.lifeViews.get(this.currentCommanderDamageIndex).checkVitals();
        if (getSharedViewModel().getGameState().getSubformatId() == 5 && getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            LifeTotalView lifeTotalView = this.lifeViewTeam1;
            if (lifeTotalView != null) {
                lifeTotalView.setDisplayedCommanderDamage(Math.max(commanderDamageValueToShowFor(0), commanderDamageValueToShowFor(3)));
            }
            LifeTotalView lifeTotalView2 = this.lifeViewTeam2;
            if (lifeTotalView2 != null) {
                lifeTotalView2.setDisplayedCommanderDamage(Math.max(commanderDamageValueToShowFor(1), commanderDamageValueToShowFor(2)));
            }
            LifeTotalView lifeTotalView3 = this.lifeViewTeam1;
            if (lifeTotalView3 != null) {
                lifeTotalView3.checkVitals();
            }
            LifeTotalView lifeTotalView4 = this.lifeViewTeam2;
            if (lifeTotalView4 != null) {
                lifeTotalView4.checkVitals();
            }
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            LifeTotalView lifeTotalView5 = this.lifeViewTeam1;
            if (lifeTotalView5 != null) {
                lifeTotalView5.setDisplayedCommanderDamage(ArraysKt.maxOrThrow(new int[]{commanderDamageValueToShowFor(0), commanderDamageValueToShowFor(1), commanderDamageValueToShowFor(5)}));
            }
            LifeTotalView lifeTotalView6 = this.lifeViewTeam2;
            if (lifeTotalView6 != null) {
                lifeTotalView6.setDisplayedCommanderDamage(ArraysKt.maxOrThrow(new int[]{commanderDamageValueToShowFor(2), commanderDamageValueToShowFor(3), commanderDamageValueToShowFor(4)}));
            }
            LifeTotalView lifeTotalView7 = this.lifeViewTeam1;
            if (lifeTotalView7 != null) {
                lifeTotalView7.checkVitals();
            }
            LifeTotalView lifeTotalView8 = this.lifeViewTeam2;
            if (lifeTotalView8 != null) {
                lifeTotalView8.checkVitals();
            }
        }
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        updateStreamingState$app_release();
    }

    public final int commanderDamageValueToShowFor(int playerIndex) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = getSharedViewModel().getGameState().getPlayers().get(playerIndex).getCommanderDamageList().iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            int iIntValue = ((Number) it.next()).intValue();
            if (!getSharedViewModel().getGameState().getPlayers().get(i).isKO()) {
                arrayList.add(Integer.valueOf(iIntValue));
            }
            i = i2;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = getSharedViewModel().getGameState().getPlayers().get(playerIndex).getCommanderDamageListPartner().iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            int i4 = i3 + 1;
            int iIntValue2 = ((Number) it2.next()).intValue();
            if (!getSharedViewModel().getGameState().getPlayers().get(i3).isKO()) {
                arrayList2.add(Integer.valueOf(iIntValue2));
            }
            i3 = i4;
        }
        Integer num = (Integer) CollectionsKt.maxOrNull((Iterable) CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void confirmPlayerConcede(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                i = i2;
                break;
            }
            i2++;
        }
        if (getSharedViewModel().getGameState().getNumberOfPlayers() == this.lifeViews.size() && getSharedViewModel().getGameState().getNumberOfPlayers() == getSharedViewModel().getGameState().getPlayers().size()) {
            this.lifeViews.get(i).triggerPlayerDeadQ("concede", true);
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void confirmPlayerDeath(LifeTotalView sender, boolean fromMenu) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i < getSharedViewModel().getGameState().getPlayers().size() && getActivity() != null) {
            askForPlayerKO(i, fromMenu);
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void confirmPlayerDraw(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                i = i2;
                break;
            }
            i2++;
        }
        if (getSharedViewModel().getGameState().getNumberOfPlayers() == this.lifeViews.size() && getSharedViewModel().getGameState().getNumberOfPlayers() == getSharedViewModel().getGameState().getPlayers().size()) {
            this.lifeViews.get(i).triggerPlayerDeadQ("draw", true);
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void confirmPlayerWin(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                confirmPlayerWin(i);
                return;
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void createDeckForGuest(LifeTotalView sender, int userId) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getContext() == null) {
            return;
        }
        int size = this.lifeViews.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                i = i2;
                break;
            }
            i2++;
        }
        this.currentGuestDeckIndex = i;
        this.currentGuestUserId = userId;
        int formatId = getSharedViewModel().getGameState().getFormatId();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("create_deck_for_guest", null);
            CreateDeckBottomSheetFragment.INSTANCE.newInstanceForGuest(this, this.searchActivityLauncherForGuestDeck, this.pickCardLauncherForGuestDeck, currentUser, formatId).show(getChildFragmentManager(), CreateDeckBottomSheetFragment.TAG);
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void createDeckForMythicUser(LifeTotalView sender, int userId) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getContext() == null) {
            return;
        }
        int size = this.lifeViews.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                i = i2;
                break;
            }
            i2++;
        }
        this.currentMythicUserDeckIndex = i;
        this.currentMythicUserId = userId;
        int formatId = getSharedViewModel().getGameState().getFormatId();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("create_deck_for_user", null);
            CreateDeckBottomSheetFragment.INSTANCE.newInstanceForMTUser(this, this.searchActivityLauncherForGuestDeck, this.pickCardLauncherForGuestDeck, currentUser, userId, formatId).show(getChildFragmentManager(), CreateDeckBottomSheetFragment.TAG);
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void currentUserSelected(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getContext() == null) {
            return;
        }
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = 0;
                break;
            } else if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                break;
            } else {
                i++;
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
            for (int i2 = 0; i2 < numberOfPlayers; i2++) {
                if (i2 != i) {
                    this.lifeViews.get(i2).removeCurrentUserAvailable();
                }
            }
            this.lifeViews.get(i).setUserData(currentUser, getSharedViewModel().getGameState().getFormatId());
            this.lifeViews.get(i).showUserAndDecks();
            if (this.seatedUsers == null) {
                this.seatedUsers = new LinkedHashMap();
            }
            Map<Integer, MTUser> map = this.seatedUsers;
            if (map != null) {
                map.put(Integer.valueOf(i), currentUser);
            }
            if (this.seatedPlayers == null) {
                this.seatedPlayers = new LinkedHashMap();
            }
            Map<Integer, Player> map2 = this.seatedPlayers;
            if (map2 != null) {
                int numberOfPlayers2 = getSharedViewModel().getGameState().getNumberOfPlayers();
                Player player = new Player(null, null, 0, 0, 0, 0, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 0, 0, null, null, false, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, 0, -1, 8191, null);
                String firstname = currentUser.getFirstname();
                if (firstname == null) {
                    firstname = getResources().getString(R.string.player) + " " + (i + 1);
                }
                player.setName(firstname);
                ArrayList arrayList = new ArrayList(numberOfPlayers2);
                for (int i3 = 0; i3 < numberOfPlayers2; i3++) {
                    arrayList.add(0);
                }
                player.setCommanderDamageList(arrayList);
                ArrayList arrayList2 = new ArrayList(numberOfPlayers2);
                for (int i4 = 0; i4 < numberOfPlayers2; i4++) {
                    arrayList2.add(0);
                }
                player.setCommanderDamageListPartner(arrayList2);
                player.setStartingLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
                player.setLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
                player.setUserId(currentUser.getId());
                map2.put(Integer.valueOf(i), player);
            }
            List<MTUser> gameParticipantUsers = GameUtils.INSTANCE.getInstance().getGameParticipantUsers();
            if ((gameParticipantUsers instanceof Collection) && gameParticipantUsers.isEmpty()) {
                GameUtils.INSTANCE.getInstance().getGameParticipantUsers().add(currentUser);
            } else {
                Iterator<T> it = gameParticipantUsers.iterator();
                while (it.hasNext()) {
                    if (((MTUser) it.next()).getId() == currentUser.getId()) {
                        break;
                    }
                }
                GameUtils.INSTANCE.getInstance().getGameParticipantUsers().add(currentUser);
            }
        }
        checkIfGameIsReady();
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void currentUserUnselected(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getContext() == null) {
            return;
        }
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = 0;
                break;
            } else if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                break;
            } else {
                i++;
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            Map<Integer, MTUser> map = this.seatedUsers;
            if (map != null) {
                MTUser mTUser = map.get(Integer.valueOf(i));
                if (mTUser != null && mTUser.getId() == currentUser.getId()) {
                    map.remove(Integer.valueOf(i));
                }
                int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
                for (int i2 = 0; i2 < numberOfPlayers; i2++) {
                    this.lifeViews.get(i2).putBackCurrentUserAvailable();
                    if (i2 == i) {
                        this.lifeViews.get(i2).clearUserData();
                        this.lifeViews.get(i2).showUserAndGuestSelection(true);
                    }
                }
            }
            Map<Integer, Player> map2 = this.seatedPlayers;
            if (map2 != null) {
                map2.remove(Integer.valueOf(i));
            }
            CollectionsKt.removeAll((List) GameUtils.INSTANCE.getInstance().getGameParticipantUsers(), new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda110
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(GameFragmentBase.currentUserUnselected$lambda$0$1(currentUser, (MTUser) obj));
                }
            });
        }
        checkIfGameIsReady();
    }

    public void dayNightToggled(boolean isOn) {
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void deckCleared(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getContext() == null) {
            return;
        }
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = 0;
                break;
            } else if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                break;
            } else {
                i++;
            }
        }
        Map<Integer, Player> map = this.seatedPlayers;
        if (map == null) {
            getSharedViewModel().getGameState().getPlayers().get(i).setDeckId(-1);
            getSharedViewModel().getGameState().getPlayers().get(i).setPlaneswalker(false);
            getSharedViewModel().getGameState().getPlayers().get(i).setBackgroundType(BackgroundType.PLAIN_COLOR);
            getSharedViewModel().getGameState().getPlayers().get(i).setScryfallId("");
            getSharedViewModel().getGameState().getPlayers().get(i).setLeftIsPlaneswalker(false);
            getSharedViewModel().getGameState().getPlayers().get(i).setLeftBackgroundType(BackgroundType.NONE);
            getSharedViewModel().getGameState().getPlayers().get(i).setLeftScryfallId("");
            getSharedViewModel().getGameState().getPlayers().get(i).setHasPartners(false);
            this.lifeViews.get(i).hasPartners(false);
            this.lifeViews.get(i).clearDeckData();
            this.lifeViews.get(i).updatePlayer(getSharedViewModel().getGameState().getPlayers().get(i));
            checkIfGameIsReady();
            return;
        }
        Player player = map.get(Integer.valueOf(i));
        if (player != null) {
            player.setDeckId(-1);
        }
        Player player2 = map.get(Integer.valueOf(i));
        if (player2 != null) {
            player2.setPlaneswalker(false);
        }
        Player player3 = map.get(Integer.valueOf(i));
        if (player3 != null) {
            player3.setBackgroundType(BackgroundType.PLAIN_COLOR);
        }
        Player player4 = map.get(Integer.valueOf(i));
        if (player4 != null) {
            player4.setScryfallId("");
        }
        Player player5 = map.get(Integer.valueOf(i));
        if (player5 != null) {
            player5.setLeftIsPlaneswalker(false);
        }
        Player player6 = map.get(Integer.valueOf(i));
        if (player6 != null) {
            player6.setLeftBackgroundType(BackgroundType.NONE);
        }
        Player player7 = map.get(Integer.valueOf(i));
        if (player7 != null) {
            player7.setLeftScryfallId("");
        }
        Player player8 = map.get(Integer.valueOf(i));
        if (player8 != null) {
            player8.setHasPartners(false);
        }
        this.lifeViews.get(i).hasPartners(false);
        this.lifeViews.get(i).clearDeckData();
        Player player9 = map.get(Integer.valueOf(i));
        if (player9 != null) {
            this.lifeViews.get(i).updatePlayer(player9);
        }
        checkIfGameIsReady();
    }

    public final void disableBatterySaving() {
        for (LifeTotalView lifeTotalView : this.lifeViews) {
            lifeTotalView.batterySavingModeDisabled();
            lifeTotalView.checkVitals();
        }
    }

    public final void dismissTurnTimerPromptManually() {
        if (getContext() == null) {
            return;
        }
        LifeTotalView lifeTotalView = (getSharedViewModel().getGameState().getStartingPlayerIndex() < 0 || getSharedViewModel().getGameState().getStartingPlayerIndex() >= this.lifeViews.size()) ? null : this.lifeViews.get(getSharedViewModel().getGameState().getStartingPlayerIndex());
        if (lifeTotalView != null) {
            lifeTotalView.hideFirstTurnPrompt();
            playerTapToStartTapped(lifeTotalView);
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void editPlayerNameTapped(LifeTotalView sender, String currentName) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(currentName, "currentName");
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                editPlayerNameTapped(i, currentName);
                return;
            }
        }
    }

    public final void enableArchenemy(boolean value) {
        archenemyToggled(value);
    }

    public final void enableBatterySaving() {
        Iterator<LifeTotalView> it = this.lifeViews.iterator();
        while (it.hasNext()) {
            it.next().batterySavingModeEnabled();
        }
    }

    public final void enableCommanderDamage(boolean value) {
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            this.lifeViews.get(i).showCommanderDamage(value);
        }
        LifeTotalView lifeTotalView = this.lifeViewTeam1;
        if (lifeTotalView != null) {
            lifeTotalView.showCommanderDamage(value);
        }
        LifeTotalView lifeTotalView2 = this.lifeViewTeam2;
        if (lifeTotalView2 != null) {
            lifeTotalView2.showCommanderDamage(value);
        }
        commanderDamageToggled(value);
    }

    public final void enableCommanderTaxGlobally() {
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            this.lifeViews.get(i).taxToggled(true);
        }
        LifeTotalView lifeTotalView = this.lifeViewTeam1;
        if (lifeTotalView != null) {
            lifeTotalView.taxToggled(true);
        }
        LifeTotalView lifeTotalView2 = this.lifeViewTeam2;
        if (lifeTotalView2 != null) {
            lifeTotalView2.taxToggled(true);
        }
    }

    public final void enableDayNight(boolean value) {
        dayNightToggled(value);
    }

    public final void enablePlanechase(boolean value) {
        planechaseToggled(value);
    }

    public final void enablePoisonCounters(boolean value) {
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            this.lifeViews.get(i).showPoisonCounters(value);
        }
        LifeTotalView lifeTotalView = this.lifeViewTeam1;
        if (lifeTotalView != null) {
            lifeTotalView.showPoisonCounters(value);
        }
        LifeTotalView lifeTotalView2 = this.lifeViewTeam2;
        if (lifeTotalView2 != null) {
            lifeTotalView2.showPoisonCounters(value);
        }
        poisonCounterToggled(value);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008c  */
    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void endTurnTapped(LifeTotalView sender) {
        boolean z;
        boolean z2;
        List<LifeTotalView> list;
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getContext() != null && getSharedViewModel().getGameState().getNumberOfPlayers() == this.lifeViews.size() && getSharedViewModel().getGameState().getNumberOfPlayers() == getSharedViewModel().getGameState().getPlayers().size()) {
            if (getSharedViewModel().getGameState().getTimerPaused()) {
                toggleTimerPause();
            }
            int currentTurnPlayerIndex = getSharedViewModel().getGameState().getCurrentTurnPlayerIndex();
            int numberOfPlayers = (currentTurnPlayerIndex + 1) % getSharedViewModel().getGameState().getNumberOfPlayers();
            if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                numberOfPlayers = (currentTurnPlayerIndex == 0 || currentTurnPlayerIndex == 3) ? 1 : 0;
            } else if (getSharedViewModel().getGameState().getSubformatId() != 6) {
                int i = 0;
                while (getSharedViewModel().getGameState().getPlayers().get(numberOfPlayers).isKO()) {
                    if (numberOfPlayers == getSharedViewModel().getGameState().getStartingPlayerIndex()) {
                        GameState gameState = getSharedViewModel().getGameState();
                        gameState.setCurrentGameTurn(gameState.getCurrentGameTurn() + 1);
                        showTurnCounterUI(getSharedViewModel().getGameState().getCurrentGameTurn());
                    }
                    numberOfPlayers = (numberOfPlayers + 1) % getSharedViewModel().getGameState().getNumberOfPlayers();
                    i++;
                    if (i >= getSharedViewModel().getGameState().getNumberOfPlayers()) {
                        return;
                    }
                }
            } else if (currentTurnPlayerIndex == 0 || currentTurnPlayerIndex == 1 || currentTurnPlayerIndex == 5) {
                numberOfPlayers = 2;
            }
            long currentTurnStartTime = getSharedViewModel().getGameState().getCurrentTurnStartTime();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long currentTurnPauseTime = getSharedViewModel().getGameState().getCurrentTurnPauseTime();
            this.lastTurnStartTime = currentTurnStartTime;
            this.lastTurnPauseTime = currentTurnPauseTime;
            MTGameEvent mTGameEvent = new MTGameEvent(null, MTEvent.TurnEnd.getValue(), currentTurnPlayerIndex, null, (int) (((jCurrentTimeMillis - currentTurnStartTime) / 1000) - currentTurnPauseTime), GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
            getSharedViewModel().getGameState().getEvents().add(mTGameEvent);
            if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                if (currentTurnPlayerIndex == 0 || currentTurnPlayerIndex == 3) {
                    addEventIfNeeded(mTGameEvent, 0);
                    addEventIfNeeded(mTGameEvent, 3);
                } else {
                    addEventIfNeeded(mTGameEvent, 1);
                    addEventIfNeeded(mTGameEvent, 2);
                }
            }
            if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                if (currentTurnPlayerIndex == 0 || currentTurnPlayerIndex == 1 || currentTurnPlayerIndex == 5) {
                    addEventIfNeeded(mTGameEvent, 0);
                    addEventIfNeeded(mTGameEvent, 1);
                    addEventIfNeeded(mTGameEvent, 5);
                } else {
                    addEventIfNeeded(mTGameEvent, 2);
                    addEventIfNeeded(mTGameEvent, 3);
                    addEventIfNeeded(mTGameEvent, 4);
                }
            }
            if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                z = numberOfPlayers == 0 || numberOfPlayers == 3;
                z2 = numberOfPlayers == 1 || numberOfPlayers == 2;
                boolean z3 = getSharedViewModel().getGameState().getStartingPlayerIndex() == 0 || getSharedViewModel().getGameState().getStartingPlayerIndex() == 3;
                boolean z4 = getSharedViewModel().getGameState().getStartingPlayerIndex() == 1 || getSharedViewModel().getGameState().getStartingPlayerIndex() == 2;
                if ((z && z3) || (z2 && z4)) {
                    GameState gameState2 = getSharedViewModel().getGameState();
                    gameState2.setCurrentGameTurn(gameState2.getCurrentGameTurn() + 1);
                    showTurnCounterUI(getSharedViewModel().getGameState().getCurrentGameTurn());
                }
            } else if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                z = numberOfPlayers == 0 || numberOfPlayers == 1 || numberOfPlayers == 5;
                z2 = numberOfPlayers == 2 || numberOfPlayers == 3 || numberOfPlayers == 4;
                boolean z5 = getSharedViewModel().getGameState().getStartingPlayerIndex() == 0 || getSharedViewModel().getGameState().getStartingPlayerIndex() == 1 || getSharedViewModel().getGameState().getStartingPlayerIndex() == 5;
                boolean z6 = getSharedViewModel().getGameState().getStartingPlayerIndex() == 2 || getSharedViewModel().getGameState().getStartingPlayerIndex() == 3 || getSharedViewModel().getGameState().getStartingPlayerIndex() == 4;
                if ((z && z5) || (z2 && z6)) {
                    GameState gameState3 = getSharedViewModel().getGameState();
                    gameState3.setCurrentGameTurn(gameState3.getCurrentGameTurn() + 1);
                    showTurnCounterUI(getSharedViewModel().getGameState().getCurrentGameTurn());
                }
            } else {
                if (numberOfPlayers == getSharedViewModel().getGameState().getStartingPlayerIndex()) {
                    GameState gameState4 = getSharedViewModel().getGameState();
                    gameState4.setCurrentGameTurn(gameState4.getCurrentGameTurn() + 1);
                    showTurnCounterUI(getSharedViewModel().getGameState().getCurrentGameTurn());
                }
                z = false;
                z2 = false;
            }
            MTGameEvent mTGameEvent2 = new MTGameEvent(null, MTEvent.TurnStart.getValue(), numberOfPlayers, null, getSharedViewModel().getGameState().getCurrentGameTurn(), GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
            getSharedViewModel().getGameState().getEvents().add(mTGameEvent2);
            if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                if (numberOfPlayers == 0 || numberOfPlayers == 3) {
                    addEventIfNeeded(mTGameEvent2, 0);
                    addEventIfNeeded(mTGameEvent2, 3);
                } else {
                    addEventIfNeeded(mTGameEvent2, 1);
                    addEventIfNeeded(mTGameEvent2, 2);
                }
            } else if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                if (numberOfPlayers == 0 || numberOfPlayers == 1 || numberOfPlayers == 5) {
                    addEventIfNeeded(mTGameEvent2, 0);
                    addEventIfNeeded(mTGameEvent2, 1);
                    addEventIfNeeded(mTGameEvent2, 5);
                } else {
                    addEventIfNeeded(mTGameEvent2, 2);
                    addEventIfNeeded(mTGameEvent2, 3);
                    addEventIfNeeded(mTGameEvent2, 4);
                }
            }
            int value = 0;
            for (MTGameEvent mTGameEvent3 : getSharedViewModel().getGameState().getEvents()) {
                if (Intrinsics.areEqual(mTGameEvent3.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent3.getPlayerid() == numberOfPlayers) {
                    value += mTGameEvent3.getValue();
                }
            }
            getSharedViewModel().getGameState().setCurrentTurnPauseTime(0);
            getSharedViewModel().getGameState().setCurrentTurnStartTime(System.currentTimeMillis());
            getSharedViewModel().getGameState().setCurrentTurnPlayerIndex(numberOfPlayers);
            this.currentTurnPenaltyIndex = 0;
            this.currentPenaltyTimeOffset = 0;
            int size = this.lifeViews.size();
            int i2 = 0;
            while (true) {
                list = this.lifeViews;
                if (i2 >= size) {
                    break;
                }
                list.get(i2).hideUndoNextTurnUI();
                i2++;
            }
            list.get(currentTurnPlayerIndex).setIsCurrentPlayerTurn(false, 0);
            this.lifeViews.get(numberOfPlayers).setIsCurrentPlayerTurn(true, value);
            if (getSharedViewModel().getGameState().getSubformatId() == 5 || getSharedViewModel().getGameState().getSubformatId() == 6) {
                LifeTotalView lifeTotalView = this.lifeViewTeam1;
                if (lifeTotalView != null) {
                    lifeTotalView.setIsCurrentPlayerTurn(z, z ? value : 0);
                }
                LifeTotalView lifeTotalView2 = this.lifeViewTeam2;
                if (lifeTotalView2 != null) {
                    lifeTotalView2.setIsCurrentPlayerTurn(z2, z2 ? value : 0);
                }
                LifeTotalView lifeTotalView3 = this.lifeViewTeam1;
                if (lifeTotalView3 != null) {
                    lifeTotalView3.hideUndoNextTurnUI();
                }
                LifeTotalView lifeTotalView4 = this.lifeViewTeam2;
                if (lifeTotalView4 != null) {
                    lifeTotalView4.hideUndoNextTurnUI();
                }
            }
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            new PreferencesManager(contextRequireContext).saveCurrentGame(getSharedViewModel().getGameState());
            updateStreamingState$app_release();
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void energyCounterTapped(LifeTotalView sender, int rotation) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        final Ref.IntRef intRef = new Ref.IntRef();
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                intRef.element = i;
                break;
            }
            i++;
        }
        if (intRef.element >= getSharedViewModel().getGameState().getPlayers().size()) {
            return;
        }
        final int energyCounters = getSharedViewModel().getGameState().getPlayers().get(intRef.element).getEnergyCounters();
        this.lifeViews.get(intRef.element).showCountersDialog(CounterType.Energy, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameFragmentBase.energyCounterTapped$lambda$0(this.f$0, intRef, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        }, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragmentBase.energyCounterTapped$lambda$1(this.f$0, intRef, energyCounters);
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void energyToggled(LifeTotalView sender, boolean newValue) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                i = i2;
                break;
            }
            i2++;
        }
        getSharedViewModel().getGameState().getPlayers().get(i).setEnergyEnabled(newValue);
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        updateStreamingState$app_release();
    }

    public final void enterGamePlayerSummaryMode(List<PlayerResultItem> results) {
        Intrinsics.checkNotNullParameter(results, "results");
        hideMenu();
        Iterator<T> it = this.lifeViews.iterator();
        int i = 0;
        while (it.hasNext()) {
            ((LifeTotalView) it.next()).enterGamePlayerSummaryMode(results.get(i));
            i++;
        }
    }

    public final void exitGamePlayerSummaryMode() {
        Iterator<LifeTotalView> it = this.lifeViews.iterator();
        while (it.hasNext()) {
            it.next().exitGamePlayerSummaryMode();
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void experienceCounterTapped(LifeTotalView sender, int rotation) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        final Ref.IntRef intRef = new Ref.IntRef();
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                intRef.element = i;
                break;
            }
            i++;
        }
        if (intRef.element >= getSharedViewModel().getGameState().getPlayers().size()) {
            return;
        }
        final int experienceCount = getSharedViewModel().getGameState().getPlayers().get(intRef.element).getExperienceCount();
        this.lifeViews.get(intRef.element).showCountersDialog(CounterType.Experience, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameFragmentBase.experienceCounterTapped$lambda$0(this.f$0, intRef, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        }, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragmentBase.experienceCounterTapped$lambda$1(this.f$0, intRef, experienceCount);
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void experienceToggled(LifeTotalView sender, boolean newValue) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                i = i2;
                break;
            }
            i2++;
        }
        getSharedViewModel().getGameState().getPlayers().get(i).setExperienceEnabled(newValue);
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        updateStreamingState$app_release();
    }

    public final void gameEventsEdited() {
        LifeTotalView lifeTotalView;
        LifeTotalView lifeTotalView2;
        LifeTotalView lifeTotalView3;
        LifeTotalView lifeTotalView4;
        LifeTotalView lifeTotalView5;
        LifeTotalView lifeTotalView6;
        LifeTotalView lifeTotalView7;
        LifeTotalView lifeTotalView8;
        Integer source_playerid;
        Integer source_playerid2;
        if (getContext() == null) {
            return;
        }
        int size = getSharedViewModel().getGameState().getPlayers().size();
        for (int i = 0; i < size; i++) {
            getSharedViewModel().getGameState().getPlayers().get(i).setLifeTotal(getSharedViewModel().getGameState().getPlayers().get(i).getStartingLifeTotal());
            getSharedViewModel().getGameState().getPlayers().get(i).setPoisonCounters(0);
            getSharedViewModel().getGameState().getPlayers().get(i).setEnergyCounters(0);
            getSharedViewModel().getGameState().getPlayers().get(i).setStormCount(0);
            getSharedViewModel().getGameState().getPlayers().get(i).setRadiationCount(0);
            getSharedViewModel().getGameState().getPlayers().get(i).setTaxCount(0);
            getSharedViewModel().getGameState().getPlayers().get(i).setTaxCountPartner(0);
            getSharedViewModel().getGameState().getPlayers().get(i).setExperienceCount(0);
            Player player = getSharedViewModel().getGameState().getPlayers().get(i);
            int size2 = getSharedViewModel().getGameState().getPlayers().size();
            ArrayList arrayList = new ArrayList(size2);
            for (int i2 = 0; i2 < size2; i2++) {
                arrayList.add(0);
            }
            player.setCommanderDamageList(arrayList);
            Player player2 = getSharedViewModel().getGameState().getPlayers().get(i);
            int size3 = getSharedViewModel().getGameState().getPlayers().size();
            ArrayList arrayList2 = new ArrayList(size3);
            for (int i3 = 0; i3 < size3; i3++) {
                arrayList2.add(0);
            }
            player2.setCommanderDamageListPartner(arrayList2);
            getSharedViewModel().getGameState().getPlayers().get(i).setMonarch(false);
            getSharedViewModel().getGameState().getPlayers().get(i).setInitiative(false);
            getSharedViewModel().getGameState().getPlayers().get(i).setCityBlessing(false);
            getSharedViewModel().getGameState().getPlayers().get(i).setTheRing(false);
        }
        int startingPlayerIndex = getSharedViewModel().getGameState().getStartingPlayerIndex();
        int value = 0;
        for (MTGameEvent mTGameEvent : getSharedViewModel().getGameState().getEvents()) {
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.LifeOffset.getValue())) {
                Player player3 = getSharedViewModel().getGameState().getPlayers().get(mTGameEvent.getPlayerid());
                player3.setLifeTotal(player3.getLifeTotal() + mTGameEvent.getValue());
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.CommanderDamage.getValue()) && (source_playerid2 = mTGameEvent.getSource_playerid()) != null) {
                int iIntValue = source_playerid2.intValue();
                List<Integer> commanderDamageList = getSharedViewModel().getGameState().getPlayers().get(mTGameEvent.getPlayerid()).getCommanderDamageList();
                commanderDamageList.set(iIntValue, Integer.valueOf(commanderDamageList.get(iIntValue).intValue() + mTGameEvent.getValue()));
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.PartnerDamage.getValue()) && (source_playerid = mTGameEvent.getSource_playerid()) != null) {
                int iIntValue2 = source_playerid.intValue();
                List<Integer> commanderDamageListPartner = getSharedViewModel().getGameState().getPlayers().get(mTGameEvent.getPlayerid()).getCommanderDamageListPartner();
                commanderDamageListPartner.set(iIntValue2, Integer.valueOf(commanderDamageListPartner.get(iIntValue2).intValue() + mTGameEvent.getValue()));
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.Poison.getValue())) {
                Player player4 = getSharedViewModel().getGameState().getPlayers().get(mTGameEvent.getPlayerid());
                player4.setPoisonCounters(player4.getPoisonCounters() + mTGameEvent.getValue());
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.Storm.getValue())) {
                Player player5 = getSharedViewModel().getGameState().getPlayers().get(mTGameEvent.getPlayerid());
                player5.setStormCount(player5.getStormCount() + mTGameEvent.getValue());
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.Energy.getValue())) {
                Player player6 = getSharedViewModel().getGameState().getPlayers().get(mTGameEvent.getPlayerid());
                player6.setEnergyCounters(player6.getEnergyCounters() + mTGameEvent.getValue());
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.Tax.getValue())) {
                Player player7 = getSharedViewModel().getGameState().getPlayers().get(mTGameEvent.getPlayerid());
                player7.setTaxCount(player7.getTaxCount() + mTGameEvent.getValue());
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TaxPartner.getValue())) {
                Player player8 = getSharedViewModel().getGameState().getPlayers().get(mTGameEvent.getPlayerid());
                player8.setTaxCountPartner(player8.getTaxCountPartner() + mTGameEvent.getValue());
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.Experience.getValue())) {
                Player player9 = getSharedViewModel().getGameState().getPlayers().get(mTGameEvent.getPlayerid());
                player9.setExperienceCount(player9.getExperienceCount() + mTGameEvent.getValue());
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.Radiation.getValue())) {
                Player player10 = getSharedViewModel().getGameState().getPlayers().get(mTGameEvent.getPlayerid());
                player10.setRadiationCount(player10.getRadiationCount() + mTGameEvent.getValue());
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.Monarch.getValue())) {
                int size4 = getSharedViewModel().getGameState().getPlayers().size();
                int i4 = 0;
                while (i4 < size4) {
                    getSharedViewModel().getGameState().getPlayers().get(i4).setMonarch(i4 == mTGameEvent.getPlayerid());
                    i4++;
                }
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.Initiative.getValue())) {
                int size5 = getSharedViewModel().getGameState().getPlayers().size();
                int i5 = 0;
                while (i5 < size5) {
                    getSharedViewModel().getGameState().getPlayers().get(i5).setInitiative(i5 == mTGameEvent.getPlayerid());
                    i5++;
                }
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.CityBlessing.getValue())) {
                getSharedViewModel().getGameState().getPlayers().get(mTGameEvent.getPlayerid()).setCityBlessing(true);
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TheRing.getValue())) {
                getSharedViewModel().getGameState().getPlayers().get(mTGameEvent.getPlayerid()).setTheRing(true);
            }
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TurnStart.getValue())) {
                value = mTGameEvent.getValue();
                startingPlayerIndex = mTGameEvent.getPlayerid();
            }
        }
        int value2 = 0;
        for (MTGameEvent mTGameEvent2 : getSharedViewModel().getGameState().getEvents()) {
            if (Intrinsics.areEqual(mTGameEvent2.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent2.getPlayerid() == startingPlayerIndex) {
                value2 += mTGameEvent2.getValue();
            }
        }
        getSharedViewModel().getGameState().setCurrentGameTurn(value);
        getSharedViewModel().getGameState().setCurrentTurnStartTime(System.currentTimeMillis());
        getSharedViewModel().getGameState().setCurrentTurnPauseTime(0);
        getSharedViewModel().getGameState().setCurrentTurnPlayerIndex(startingPlayerIndex);
        if (getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            showTurnCounterUI(value);
            int size6 = getSharedViewModel().getGameState().getPlayers().size();
            for (int i6 = 0; i6 < size6; i6++) {
                this.lifeViews.get(i6).hideUndoNextTurnUI();
                List<LifeTotalView> list = this.lifeViews;
                if (i6 == startingPlayerIndex) {
                    list.get(i6).setIsCurrentPlayerTurn(true, value2);
                } else {
                    list.get(i6).setIsCurrentPlayerTurn(false, 0);
                }
            }
            if (getSharedViewModel().getGameState().getSubformatId() == 5 && getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
                LifeTotalView lifeTotalView9 = this.lifeViewTeam1;
                if (lifeTotalView9 != null) {
                    lifeTotalView9.hideUndoNextTurnUI();
                }
                LifeTotalView lifeTotalView10 = this.lifeViewTeam2;
                if (lifeTotalView10 != null) {
                    lifeTotalView10.hideUndoNextTurnUI();
                }
                if (startingPlayerIndex == 0 || startingPlayerIndex == 3) {
                    LifeTotalView lifeTotalView11 = this.lifeViewTeam1;
                    if (lifeTotalView11 != null) {
                        lifeTotalView11.setIsCurrentPlayerTurn(true, value2);
                    }
                    LifeTotalView lifeTotalView12 = this.lifeViewTeam2;
                    if (lifeTotalView12 != null) {
                        lifeTotalView12.setIsCurrentPlayerTurn(false, 0);
                    }
                } else {
                    LifeTotalView lifeTotalView13 = this.lifeViewTeam1;
                    if (lifeTotalView13 != null) {
                        lifeTotalView13.setIsCurrentPlayerTurn(false, 0);
                    }
                    LifeTotalView lifeTotalView14 = this.lifeViewTeam2;
                    if (lifeTotalView14 != null) {
                        lifeTotalView14.setIsCurrentPlayerTurn(true, value2);
                    }
                }
            }
            if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
                LifeTotalView lifeTotalView15 = this.lifeViewTeam1;
                if (lifeTotalView15 != null) {
                    lifeTotalView15.hideUndoNextTurnUI();
                }
                LifeTotalView lifeTotalView16 = this.lifeViewTeam2;
                if (lifeTotalView16 != null) {
                    lifeTotalView16.hideUndoNextTurnUI();
                }
                if (startingPlayerIndex == 0 || startingPlayerIndex == 1 || startingPlayerIndex == 5) {
                    LifeTotalView lifeTotalView17 = this.lifeViewTeam1;
                    if (lifeTotalView17 != null) {
                        lifeTotalView17.setIsCurrentPlayerTurn(true, value2);
                    }
                    LifeTotalView lifeTotalView18 = this.lifeViewTeam2;
                    if (lifeTotalView18 != null) {
                        lifeTotalView18.setIsCurrentPlayerTurn(false, 0);
                    }
                } else {
                    LifeTotalView lifeTotalView19 = this.lifeViewTeam1;
                    if (lifeTotalView19 != null) {
                        lifeTotalView19.setIsCurrentPlayerTurn(false, 0);
                    }
                    LifeTotalView lifeTotalView20 = this.lifeViewTeam2;
                    if (lifeTotalView20 != null) {
                        lifeTotalView20.setIsCurrentPlayerTurn(true, value2);
                    }
                }
            }
        }
        int size7 = getSharedViewModel().getGameState().getPlayers().size();
        for (int i7 = 0; i7 < size7; i7++) {
            this.lifeViews.get(i7).setLifeTotal(getSharedViewModel().getGameState().getPlayers().get(i7).getLifeTotal());
            this.lifeViews.get(i7).setPoisonCounters(getSharedViewModel().getGameState().getPlayers().get(i7).getPoisonCounters());
            this.lifeViews.get(i7).setEnergyCounters(getSharedViewModel().getGameState().getPlayers().get(i7).getEnergyCounters());
            this.lifeViews.get(i7).setStormCount(getSharedViewModel().getGameState().getPlayers().get(i7).getStormCount());
            this.lifeViews.get(i7).setTaxCount(getSharedViewModel().getGameState().getPlayers().get(i7).getTaxCount());
            this.lifeViews.get(i7).setTaxCountPartner(getSharedViewModel().getGameState().getPlayers().get(i7).getTaxCountPartner());
            this.lifeViews.get(i7).setExperienceCounters(getSharedViewModel().getGameState().getPlayers().get(i7).getExperienceCount());
            this.lifeViews.get(i7).setRadiationCounters(getSharedViewModel().getGameState().getPlayers().get(i7).getRadiationCount());
            this.lifeViews.get(i7).setMonarch(getSharedViewModel().getGameState().getPlayers().get(i7).getMonarch());
            boolean isMonarch = this.lifeViews.get(i7).getIsMonarch();
            List<LifeTotalView> list2 = this.lifeViews;
            if (isMonarch) {
                list2.get(i7).showMonarchCoin();
            } else {
                list2.get(i7).hideMonarchCoin();
            }
            boolean hasInitiative = this.lifeViews.get(i7).getHasInitiative();
            List<LifeTotalView> list3 = this.lifeViews;
            if (hasInitiative) {
                list3.get(i7).showInitiativeCoin();
            } else {
                list3.get(i7).hideInitiativeCoin();
            }
            this.lifeViews.get(i7).setDisplayedCommanderDamage(commanderDamageValueToShowFor(i7));
            this.lifeViews.get(i7).checkVitals();
        }
        updateTeams();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        List<Integer> undoKOs = preferencesManager.getUndoKOs();
        Iterator<Integer> it = undoKOs.iterator();
        while (it.hasNext()) {
            int iIntValue3 = it.next().intValue();
            this.lifeViews.get(iIntValue3).undoKO();
            getSharedViewModel().getGameState().getPlayers().get(iIntValue3).setKO(false);
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 5 && getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            if ((undoKOs.contains(0) || undoKOs.contains(3)) && (lifeTotalView7 = this.lifeViewTeam1) != null) {
                lifeTotalView7.undoKO();
            }
            if ((undoKOs.contains(1) || undoKOs.contains(2)) && (lifeTotalView8 = this.lifeViewTeam2) != null) {
                lifeTotalView8.undoKO();
            }
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            if ((undoKOs.contains(0) || undoKOs.contains(1) || undoKOs.contains(5)) && (lifeTotalView5 = this.lifeViewTeam1) != null) {
                lifeTotalView5.undoKO();
            }
            if ((undoKOs.contains(2) || undoKOs.contains(3) || undoKOs.contains(4)) && (lifeTotalView6 = this.lifeViewTeam2) != null) {
                lifeTotalView6.undoKO();
            }
        }
        List<Integer> undoWins = preferencesManager.getUndoWins();
        Iterator<Integer> it2 = undoWins.iterator();
        while (it2.hasNext()) {
            this.lifeViews.get(it2.next().intValue()).undoWin();
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 5 && getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            if ((undoWins.contains(0) || undoWins.contains(3)) && (lifeTotalView3 = this.lifeViewTeam1) != null) {
                lifeTotalView3.undoWin();
            }
            if ((undoWins.contains(1) || undoWins.contains(2)) && (lifeTotalView4 = this.lifeViewTeam2) != null) {
                lifeTotalView4.undoWin();
            }
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            if ((undoWins.contains(0) || undoWins.contains(1) || undoWins.contains(5)) && (lifeTotalView = this.lifeViewTeam1) != null) {
                lifeTotalView.undoWin();
            }
            if ((undoWins.contains(2) || undoWins.contains(3) || undoWins.contains(4)) && (lifeTotalView2 = this.lifeViewTeam2) != null) {
                lifeTotalView2.undoWin();
            }
        }
        preferencesManager.clearUndoKOs();
        preferencesManager.clearUndoWins();
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
        updateStreamingState$app_release();
        updateLifeHistory();
    }

    public void gameFinished() {
    }

    public final int getCurrentCommanderDamageIndex() {
        return this.currentCommanderDamageIndex;
    }

    public final FragmentReadyListener getFragmentReadyListener() {
        return this.fragmentReadyListener;
    }

    public final LifeTotalView getLifeViewTeam1() {
        return this.lifeViewTeam1;
    }

    public final LifeTotalView getLifeViewTeam2() {
        return this.lifeViewTeam2;
    }

    public final List<LifeTotalView> getLifeViews() {
        return this.lifeViews;
    }

    public final SharedViewModel getSharedViewModel() {
        return (SharedViewModel) this.sharedViewModel.getValue();
    }

    public final boolean getShowSeconds() {
        return this.showSeconds;
    }

    public final boolean getTutorialMode() {
        return this.tutorialMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void guestUserSelected(LifeTotalView sender) {
        Map<Integer, MTUser> map;
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getContext() == null) {
            return;
        }
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = 0;
                break;
            } else if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                break;
            } else {
                i++;
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (this.seatedUsers == null) {
            this.seatedUsers = new LinkedHashMap();
        }
        if (this.seatedPlayers == null) {
            this.seatedPlayers = new LinkedHashMap();
        }
        if (currentUser != null && (map = this.seatedUsers) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<Integer, MTUser>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MTUser value = it.next().getValue();
                MTUser mTUser = value instanceof MTUser ? value : null;
                if (mTUser != null && mTUser.getId() < 0) {
                    arrayList.add(Integer.valueOf(mTUser.getId()));
                }
            }
            int i2 = -1;
            while (arrayList.contains(Integer.valueOf(i2))) {
                i2--;
            }
            MTUser mTUser2 = new MTUser(false, 0, null, null, null, null, null, null, null, null, 1023, null);
            mTUser2.setId(i2);
            mTUser2.setPicture(null);
            String string = getResources().getString(R.string.string_guest_user);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            mTUser2.setFirstname(StringsKt.replace$default(string, "{1}", String.valueOf(Math.abs(i2)), false, 4, (Object) null));
            mTUser2.setUsername("@guest" + Math.abs(i2));
            map.put(Integer.valueOf(i), mTUser2);
            int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
            Player player = new Player(null, null, 0, 0, 0, 0, 0, false, false, null == true ? 1 : 0, null == true ? 1 : 0, null == true ? 1 : 0, null, null == true ? 1 : 0, null, null, null, null, null, null, null, null, null, false, false, false, false, 0, 0, null, null, false, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, 0, -1, 8191, null);
            player.setUserId(i2);
            String string2 = getResources().getString(R.string.string_guest_user);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            player.setName(StringsKt.replace$default(string2, "{1}", String.valueOf(Math.abs(i2)), false, 4, (Object) null));
            ArrayList arrayList2 = new ArrayList(numberOfPlayers);
            for (int i3 = 0; i3 < numberOfPlayers; i3++) {
                arrayList2.add(0);
            }
            player.setCommanderDamageList(arrayList2);
            ArrayList arrayList3 = new ArrayList(numberOfPlayers);
            for (int i4 = 0; i4 < numberOfPlayers; i4++) {
                arrayList3.add(0);
            }
            player.setCommanderDamageListPartner(arrayList3);
            player.setStartingLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
            player.setLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
            Map<Integer, Player> map2 = this.seatedPlayers;
            if (map2 != null) {
                map2.put(Integer.valueOf(i), player);
            }
            this.lifeViews.get(i).showUserAsGuest(i2);
        }
        checkIfGameIsReady();
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void guestUserUnselected(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getContext() == null) {
            return;
        }
        int size = this.lifeViews.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                i = i2;
                break;
            }
            i2++;
        }
        Map<Integer, MTUser> map = this.seatedUsers;
        if (map != null) {
            map.remove(Integer.valueOf(i));
            this.lifeViews.get(i).removeUserAsGuest();
        }
        Map<Integer, Player> map2 = this.seatedPlayers;
        if (map2 != null) {
            map2.remove(Integer.valueOf(i));
        }
        checkIfGameIsReady();
    }

    public void hideBestOfScore() {
    }

    public final void hideClock() {
        this.clockShowing = false;
        if (!this.hasCustomMenuImage) {
            View view = getView();
            TextView textView = view != null ? (TextView) view.findViewById(R.id.menu_button) : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
        View view2 = getView();
        TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.menu_button_white) : null;
        if (textView2 != null) {
            textView2.setTextSize(40.0f);
        }
        View view3 = getView();
        CustomCircleView customCircleView = view3 != null ? (CustomCircleView) view3.findViewById(R.id.circleView) : null;
        if (customCircleView != null) {
            customCircleView.setVisibility(4);
        }
        View view4 = getView();
        TextView textView3 = view4 != null ? (TextView) view4.findViewById(R.id.timerTextView) : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        View view5 = getView();
        TextView textView4 = view5 != null ? (TextView) view5.findViewById(R.id.timerTurnTextView) : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        this.clockHandler.removeCallbacks(this.clockRunnable);
    }

    public void hideLifeHistory() {
    }

    public final void hideMenu() {
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.menu_button_black) : null;
        if (textView != null) {
            textView.setVisibility(4);
        }
        View view2 = getView();
        TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.menu_button_white) : null;
        if (textView2 != null) {
            textView2.setVisibility(4);
        }
        View view3 = getView();
        TextView textView3 = view3 != null ? (TextView) view3.findViewById(R.id.menu_button) : null;
        if (textView3 != null) {
            textView3.setVisibility(4);
        }
        View view4 = getView();
        View viewFindViewById = view4 != null ? view4.findViewById(R.id.overlayView1) : null;
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(4);
        }
        View view5 = getView();
        ImageView imageView = view5 != null ? (ImageView) view5.findViewById(R.id.customMenuButtonImage) : null;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public final void hideMenuAsClose() {
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.menu_button) : null;
        if (textView != null) {
            textView.setText("\uf0c9");
        }
    }

    public void hideStartGameButton() {
    }

    public void hideTurnCounterUI() {
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.timerTurnTextView) : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void initiativeCoinDropped(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        for (final int i = 0; i < size; i++) {
            boolean zAreEqual = Intrinsics.areEqual(sender, this.lifeViews.get(i));
            List<LifeTotalView> list = this.lifeViews;
            if (zAreEqual) {
                list.get(i).showInitiativeCoin();
                if (getContext() == null) {
                    return;
                }
                Breadcrumbs.INSTANCE.leaveBreadcrumb("initiative_coin_dropped");
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                firebaseAnalytics.logEvent("initiative_coin_dropped", null);
                getSharedViewModel().getGameState().getPlayers().get(i).setInitiative(true);
                new UndercityDialogFragment.Builder().setState(getSharedViewModel().getGameState()).setCurrentPlayerIndex(i).setOnDismissCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GameFragmentBase.initiativeCoinDropped$lambda$0(this.f$0, i, ((Integer) obj).intValue());
                    }
                }).build().show(getChildFragmentManager(), "undercity_dialog");
                getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Initiative.getValue(), i, null, 1, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            } else {
                list.get(i).hideInitiativeCoin();
                getSharedViewModel().getGameState().getPlayers().get(i).setInitiative(false);
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).saveCurrentGame(getSharedViewModel().getGameState());
        updateStreamingState$app_release();
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void initiativeCoinRejected() {
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (this.lifeViews.get(i).getHasInitiative()) {
                this.lifeViews.get(i).showInitiativeCoin();
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void leftPicked(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                i = i2;
                break;
            }
            i2++;
        }
        if (this.currentPlaymatId.length() > 0) {
            getSharedViewModel().getGameState().getPlayers().get(i).setLeftBackgroundType(BackgroundType.PLAYMAT);
            getSharedViewModel().getGameState().getPlayers().get(i).setLeftPlaymatId(this.currentPlaymatId);
            Context context = getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
            }
            this.lifeViews.get(i).updatePlayer(getSharedViewModel().getGameState().getPlayers().get(i));
            this.currentPlaymatId = "";
        }
        Uri uri = this.currentPhotoUri;
        if (uri != null) {
            getSharedViewModel().getGameState().getPlayers().get(i).setLeftBackgroundType(BackgroundType.PHOTO);
            Player player = getSharedViewModel().getGameState().getPlayers().get(i);
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            player.setLeftPhotoUri(string);
            Context context2 = getContext();
            if (context2 != null) {
                new PreferencesManager(context2).saveCurrentGame(getSharedViewModel().getGameState());
            }
            this.lifeViews.get(i).updatePlayer(getSharedViewModel().getGameState().getPlayers().get(i));
            this.currentPhotoUri = null;
        }
        if (this.lastScanId.length() > 0) {
            getSharedViewModel().getGameState().getPlayers().get(i).setLeftBackgroundType(BackgroundType.SCRYFALL_ID);
            getSharedViewModel().getGameState().getPlayers().get(i).setLeftScryfallId(this.lastScanId);
            Context context3 = getContext();
            if (context3 != null) {
                new PreferencesManager(context3).saveCurrentGame(getSharedViewModel().getGameState());
            }
            this.lifeViews.get(i).updatePlayer(getSharedViewModel().getGameState().getPlayers().get(i));
            this.lastScanId = "";
        }
        if (this.currentColorHex.length() > 0) {
            getSharedViewModel().getGameState().getPlayers().get(i).setLeftBackgroundType(BackgroundType.SOLID_COLOR);
            getSharedViewModel().getGameState().getPlayers().get(i).setLeftBackgroundColor(this.currentColorHex);
            Context context4 = getContext();
            if (context4 != null) {
                new PreferencesManager(context4).saveCurrentGame(getSharedViewModel().getGameState());
            }
            this.lifeViews.get(i).updatePlayer(getSharedViewModel().getGameState().getPlayers().get(i));
            this.currentColorHex = "";
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void lifeTotalChangeCommitted(LifeTotalView sender, int delta) {
        int i;
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getSharedViewModel().getGameState().getPlayers().isEmpty() || this.lifeViews.isEmpty()) {
            return;
        }
        int size = this.lifeViews.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else {
                if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                    i = i2;
                    break;
                }
                i2++;
            }
        }
        if (delta != 0) {
            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.LifeOffset.getValue(), i, null, delta, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            Context context = getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
            }
            updateStreamingState$app_release();
            updateLifeHistory();
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void lifeTotalChanged(LifeTotalView sender, int newValue) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                if (i >= getSharedViewModel().getGameState().getPlayers().size()) {
                    return;
                }
                getSharedViewModel().getGameState().getPlayers().get(i).setLifeTotal(newValue);
                Context context = getContext();
                if (context != null) {
                    new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
                }
                updateStreamingState$app_release();
                return;
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void monarchCoinDropped(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            boolean zAreEqual = Intrinsics.areEqual(sender, this.lifeViews.get(i));
            List<LifeTotalView> list = this.lifeViews;
            if (zAreEqual) {
                list.get(i).showMonarchCoin();
                if (getContext() == null) {
                    return;
                }
                Breadcrumbs.INSTANCE.leaveBreadcrumb("monarch_coin_dropped");
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                firebaseAnalytics.logEvent("monarch_coin_dropped", null);
                getSharedViewModel().getGameState().getPlayers().get(i).setMonarch(true);
                getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Monarch.getValue(), i, null, 1, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            } else {
                list.get(i).hideMonarchCoin();
                getSharedViewModel().getGameState().getPlayers().get(i).setMonarch(false);
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).saveCurrentGame(getSharedViewModel().getGameState());
        updateStreamingState$app_release();
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void monarchCoinRejected() {
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (this.lifeViews.get(i).getIsMonarch()) {
                this.lifeViews.get(i).showMonarchCoin();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0218  */
    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mythicUserSelected(LifeTotalView sender, MTFriend friend, int previousUserId) {
        int numberOfPlayers;
        Map<Integer, MTUser> map;
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(friend, "friend");
        if (getContext() == null) {
            return;
        }
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = 0;
                break;
            } else if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                break;
            } else {
                i++;
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null || currentUser.getId() != friend.getId()) {
            if (this.seatedUsers == null) {
                this.seatedUsers = new LinkedHashMap();
            }
            if (this.seatedPlayers == null) {
                this.seatedPlayers = new LinkedHashMap();
            }
            final MTUser mTUser = new MTUser(false, 0, null, null, null, null, null, null, null, null, 1023, null);
            mTUser.setId(friend.getId());
            mTUser.setPicture(friend.getPicture());
            mTUser.setFirstname(friend.getFirstname());
            mTUser.setUsername(friend.getUsername());
            List<MTUser> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getCurrentUserCache());
            mutableList.add(mTUser);
            preferencesManager.saveCurrentUserCache(mutableList);
            Map<Integer, Player> map2 = this.seatedPlayers;
            if (map2 != null) {
                int numberOfPlayers2 = getSharedViewModel().getGameState().getNumberOfPlayers();
                Player player = new Player(null, null, 0, 0, 0, 0, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 0, 0, null, null, false, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, 0, -1, 8191, null);
                player.setUserId(friend.getId());
                player.setName(friend.getFirstname());
                ArrayList arrayList = new ArrayList(numberOfPlayers2);
                for (int i2 = 0; i2 < numberOfPlayers2; i2++) {
                    arrayList.add(0);
                }
                player.setCommanderDamageList(arrayList);
                ArrayList arrayList2 = new ArrayList(numberOfPlayers2);
                for (int i3 = 0; i3 < numberOfPlayers2; i3++) {
                    arrayList2.add(0);
                }
                player.setCommanderDamageListPartner(arrayList2);
                player.setStartingLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
                player.setLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
                map2.put(Integer.valueOf(i), player);
                if (!GameUtils.INSTANCE.getInstance().getUnavailableUserIds().contains(Integer.valueOf(friend.getId()))) {
                    GameUtils.INSTANCE.getInstance().getUnavailableUserIds().add(Integer.valueOf(friend.getId()));
                }
                List<MTUser> gameParticipantUsers = GameUtils.INSTANCE.getInstance().getGameParticipantUsers();
                if ((gameParticipantUsers instanceof Collection) && gameParticipantUsers.isEmpty()) {
                    GameUtils.INSTANCE.getInstance().getGameParticipantUsers().add(mTUser);
                    numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
                    while (i < numberOfPlayers) {
                    }
                    map = this.seatedUsers;
                    if (map != null) {
                    }
                    if (currentUser != null) {
                    }
                    this.lifeViews.get(i).setUserData(mTUser, getSharedViewModel().getGameState().getFormatId());
                    this.lifeViews.get(i).showUserAndDecks();
                } else {
                    Iterator<T> it = gameParticipantUsers.iterator();
                    while (it.hasNext()) {
                        if (((MTUser) it.next()).getId() == mTUser.getId()) {
                            break;
                        }
                    }
                    GameUtils.INSTANCE.getInstance().getGameParticipantUsers().add(mTUser);
                    numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
                    for (int i4 = 0; i4 < numberOfPlayers; i4++) {
                        if (i4 != i) {
                            this.lifeViews.get(i4).updateAvailableMythicUsers();
                        }
                    }
                    map = this.seatedUsers;
                    if (map != null) {
                        map.put(Integer.valueOf(i), mTUser);
                    }
                    if (currentUser != null) {
                        MTApiKt.getMtApi().getUserDecks(currentUser.getId(), mTUser.getId()).enqueue(new Callback<MTDecksResponse>() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$mythicUserSelected$2$5$1
                            @Override // retrofit2.Callback
                            public void onFailure(Call<MTDecksResponse> call, Throwable t) {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(t, "t");
                            }

                            @Override // retrofit2.Callback
                            public void onResponse(Call<MTDecksResponse> call, Response<MTDecksResponse> response) {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(response, "response");
                                if (this.this$0.getContext() != null && response.isSuccessful()) {
                                    MTDecksResponse mTDecksResponseBody = response.body();
                                    List<MTDeck> decks = mTDecksResponseBody != null ? mTDecksResponseBody.getDecks() : null;
                                    if (decks != null) {
                                        PreferencesManager preferencesManager2 = preferencesManager;
                                        MTUser mTUser2 = mTUser;
                                        Map<Integer, ? extends List<MTDeck>> mutableMap = MapsKt.toMutableMap(preferencesManager2.getAllUsersDecks());
                                        mutableMap.put(Integer.valueOf(mTUser2.getId()), decks);
                                        preferencesManager2.saveAllUsersDecks(mutableMap);
                                    }
                                }
                            }
                        });
                    }
                    this.lifeViews.get(i).setUserData(mTUser, getSharedViewModel().getGameState().getFormatId());
                    this.lifeViews.get(i).showUserAndDecks();
                }
            }
            checkIfGameIsReady();
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void mythicUserUnselected(LifeTotalView sender, final int currentUserId) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getContext() == null) {
            return;
        }
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = 0;
                break;
            } else if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                break;
            } else {
                i++;
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        GameUtils.INSTANCE.getInstance().getUnavailableUserIds().remove(Integer.valueOf(currentUserId));
        CollectionsKt.removeAll((List) GameUtils.INSTANCE.getInstance().getGameParticipantUsers(), new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda100
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(GameFragmentBase.mythicUserUnselected$lambda$0(currentUserId, (MTUser) obj));
            }
        });
        Map<Integer, MTUser> map = this.seatedUsers;
        if (map != null) {
            map.remove(Integer.valueOf(i));
            Iterator<Map.Entry<Integer, MTUser>> it = map.entrySet().iterator();
            boolean z = true;
            while (it.hasNext()) {
                MTUser value = it.next().getValue();
                if (!(value instanceof MTUser)) {
                    value = null;
                }
                if (value != null && currentUser != null && value.getId() == currentUser.getId()) {
                    z = false;
                }
            }
            int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
            for (int i2 = 0; i2 < numberOfPlayers; i2++) {
                this.lifeViews.get(i2).updateAvailableMythicUsers();
                if (i2 == i) {
                    this.lifeViews.get(i2).clearUserData();
                    this.lifeViews.get(i2).showUserAndGuestSelection(z);
                }
            }
        }
        Map<Integer, Player> map2 = this.seatedPlayers;
        if (map2 != null) {
            map2.remove(Integer.valueOf(i));
        }
        checkIfGameIsReady();
    }

    public void nonSyncableGameFinished() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda37
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GameFragmentBase.onCreate$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.pickPhotoLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda38
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GameFragmentBase.onCreate$lambda$1(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.pickCardLauncher = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda39
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Intrinsics.checkNotNullParameter((ActivityResult) obj, "<unused var>");
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(...)");
        this.purchaseLauncher = activityResultLauncherRegisterForActivityResult3;
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onDeckCreated(List<MTDeck> decks) {
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onDeckCreatedForUser(MTDeck deck, int userId) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        LifeTotalViewCallback.playgroupDeckSelected$default(this, this.lifeViews.get(this.currentMythicUserDeckIndex), deck, userId, false, 8, null);
        Map<Integer, ? extends List<MTDeck>> mutableMap = MapsKt.toMutableMap(preferencesManager.getAllUsersDecks());
        List<MTDeck> list = mutableMap.get(Integer.valueOf(userId));
        if (list != null) {
            List mutableList = CollectionsKt.toMutableList((Collection) list);
            mutableList.add(deck);
            mutableMap.put(Integer.valueOf(userId), mutableList);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(deck);
            mutableMap.put(Integer.valueOf(userId), arrayList);
        }
        preferencesManager.saveAllUsersDecks(mutableMap);
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onDeckEdited(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }

    @Override // com.studiolaganne.lengendarylens.QRScanCallback
    public void onFriendCodeConfirmed(int userId) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v43, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v96, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v3, types: [T, java.lang.Object] */
    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onGhostDeckCreated(MTDeck deck) {
        PreferencesManager preferencesManager;
        int i;
        Integer num;
        MTDeck mTDeck;
        int i2;
        Player player;
        String str;
        int i3;
        Player player2;
        Boolean overridePlaymats;
        Intrinsics.checkNotNullParameter(deck, "deck");
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager2 = new PreferencesManager(contextRequireContext);
        int i4 = this.currentGuestDeckIndex;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Map<Integer, Player> map = this.seatedPlayers;
        if (map != null) {
            objectRef.element = map.get(Integer.valueOf(i4));
        } else {
            objectRef.element = getSharedViewModel().getGameState().getPlayers().get(i4);
        }
        Player player3 = (Player) objectRef.element;
        if (player3 != null) {
            player3.setDeckId(deck.getId());
        }
        deck.setFormatid(getSharedViewModel().getGameState().getFormatId());
        SkinManager companion = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        SkinDefinition currentSkinDefinition = companion.getCurrentSkinDefinition(contextRequireContext2);
        boolean z = (currentSkinDefinition == null || (overridePlaymats = currentSkinDefinition.getOverridePlaymats()) == null) ? true : !overridePlaymats.booleanValue();
        String rightplaymat = deck.getRightplaymat();
        boolean z2 = z;
        if (rightplaymat == null) {
            preferencesManager = preferencesManager2;
            i = i4;
            Player player4 = (Player) objectRef.element;
            if (player4 != null) {
                player4.setPlaneswalker(false);
            }
            Player player5 = (Player) objectRef.element;
            if (player5 != null) {
                player5.setBackgroundType(BackgroundType.NONE);
            }
            Player player6 = (Player) objectRef.element;
            if (player6 != null) {
                player6.setScryfallId("");
            }
        } else if (StringsKt.startsWith$default(rightplaymat, "id:", false, 2, (Object) null) && z2) {
            String strSubstring = rightplaymat.substring(3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String str2 = strSubstring;
            preferencesManager = preferencesManager2;
            if (StringsKt.contains$default((CharSequence) str2, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                List listSplit$default = StringsKt.split$default((CharSequence) str2, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                String str3 = (String) listSplit$default.get(0);
                i3 = Integer.parseInt((String) listSplit$default.get(1));
                str = str3;
            } else {
                str = strSubstring;
                i3 = 0;
            }
            GameUtils companion2 = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
            CardRecord cardLocal = companion2.getCardLocal(contextRequireContext3, str, i3);
            if (cardLocal != null) {
                String strTranslateTag = SearchDataUtils.INSTANCE.getInstance().translateTag("planeswalker", cardLocal.getLang());
                String lowerCase = cardLocal.getType_line().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                i = i4;
                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) strTranslateTag, false, 2, (Object) null) && (player2 = (Player) objectRef.element) != null) {
                    player2.setPlaneswalker(true);
                }
            } else {
                i = i4;
            }
            Player player7 = (Player) objectRef.element;
            if (player7 != null) {
                player7.setBackgroundType(BackgroundType.SCRYFALL_ID);
            }
            Player player8 = (Player) objectRef.element;
            if (player8 != null) {
                player8.setScryfallId(str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + i3);
            }
        } else {
            preferencesManager = preferencesManager2;
            i = i4;
        }
        String leftplaymat = deck.getLeftplaymat();
        if (leftplaymat == null) {
            Player player9 = (Player) objectRef.element;
            if (player9 != null) {
                player9.setLeftIsPlaneswalker(false);
            }
            Player player10 = (Player) objectRef.element;
            if (player10 != null) {
                player10.setLeftBackgroundType(BackgroundType.NONE);
            }
            Player player11 = (Player) objectRef.element;
            if (player11 != null) {
                player11.setLeftScryfallId("");
            }
        } else if (StringsKt.startsWith$default(leftplaymat, "id:", false, 2, (Object) null) && z2) {
            String strSubstring2 = leftplaymat.substring(3);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            String str4 = strSubstring2;
            if (StringsKt.contains$default((CharSequence) str4, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                List listSplit$default2 = StringsKt.split$default((CharSequence) str4, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                String str5 = (String) listSplit$default2.get(0);
                i2 = Integer.parseInt((String) listSplit$default2.get(1));
                strSubstring2 = str5;
            } else {
                i2 = 0;
            }
            GameUtils companion3 = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext4 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
            CardRecord cardLocal2 = companion3.getCardLocal(contextRequireContext4, strSubstring2, i2);
            if (cardLocal2 != null) {
                String strTranslateTag2 = SearchDataUtils.INSTANCE.getInstance().translateTag("planeswalker", cardLocal2.getLang());
                String lowerCase2 = cardLocal2.getType_line().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) strTranslateTag2, false, 2, (Object) null) && (player = (Player) objectRef.element) != null) {
                    player.setLeftIsPlaneswalker(true);
                }
            }
            Player player12 = (Player) objectRef.element;
            if (player12 != null) {
                player12.setLeftBackgroundType(BackgroundType.SCRYFALL_ID);
            }
            Player player13 = (Player) objectRef.element;
            if (player13 != null) {
                player13.setLeftScryfallId(strSubstring2 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + i2);
            }
        }
        Player player14 = (Player) objectRef.element;
        if (player14 != null) {
            player14.setHasPartners(false);
        }
        int i5 = i;
        this.lifeViews.get(i5).hasPartners(false);
        ?? partner = deck.getPartner();
        if (partner != 0) {
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = partner;
            final Ref.IntRef intRef = new Ref.IntRef();
            CharSequence charSequence = (CharSequence) partner;
            if (StringsKt.contains$default(charSequence, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                List listSplit$default3 = StringsKt.split$default(charSequence, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                objectRef2.element = listSplit$default3.get(0);
                intRef.element = Integer.parseInt((String) listSplit$default3.get(1));
            }
            MTGDBHelper.Companion companion4 = MTGDBHelper.INSTANCE;
            Context contextRequireContext5 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
            final MTGDBHelper companion5 = companion4.getInstance(contextRequireContext5);
            CardRecord cardByScryFallId = companion5.getCardByScryFallId((String) objectRef2.element, intRef.element);
            if (cardByScryFallId != null) {
                String lowerCase3 = cardByScryFallId.getType_line().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                num = null;
                if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "creature", false, 2, (Object) null)) {
                    Player player15 = (Player) objectRef.element;
                    if (player15 != null) {
                        player15.setHasPartners(true);
                    }
                    this.lifeViews.get(i5).hasPartners(true);
                }
            } else {
                num = null;
                new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GameFragmentBase.onGhostDeckCreated$lambda$7$1(this.f$0, companion5, objectRef2, intRef, objectRef);
                    }
                };
            }
        } else {
            num = null;
        }
        Map<Integer, ? extends List<MTDeck>> mutableMap = MapsKt.toMutableMap(preferencesManager.getAllUsersDecks());
        Player player16 = (Player) objectRef.element;
        Integer numValueOf = player16 != null ? Integer.valueOf(player16.getUserId()) : num;
        if (numValueOf != null) {
            int iIntValue = numValueOf.intValue();
            List<MTDeck> list = mutableMap.get(Integer.valueOf(iIntValue));
            if (list != null) {
                List mutableList = CollectionsKt.toMutableList((Collection) list);
                mTDeck = deck;
                mutableList.add(mTDeck);
                mutableMap.put(Integer.valueOf(iIntValue), mutableList);
            } else {
                mTDeck = deck;
                ArrayList arrayList = new ArrayList();
                arrayList.add(mTDeck);
                mutableMap.put(Integer.valueOf(iIntValue), arrayList);
            }
        } else {
            mTDeck = deck;
        }
        preferencesManager.saveAllUsersDecks(mutableMap);
        this.lifeViews.get(i5).setDeckData(mTDeck);
        Player player17 = (Player) objectRef.element;
        if (player17 != null) {
            this.lifeViews.get(i5).updatePlayer(player17);
        }
        checkIfGameIsReady();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        if (getContext() == null) {
            return;
        }
        super.onPause();
        if (this.clockShowing) {
            this.clockHandler.removeCallbacks(this.clockRunnable);
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            if (getSharedViewModel().getGameState().getTimerEnabled() && preferencesManager.getBoolean(PreferencesManager.ALWAYS_SHOW_TIMER, false) && ((!getSharedViewModel().getGameState().getTurnTimerEnabled() || getSharedViewModel().getGameState().getTurnTimerPromptDismissed()) && !getSharedViewModel().getGameState().getTimerPaused())) {
                toggleTimerPause();
            }
            if (getSharedViewModel().getGameState().getTimerEnabled() || !getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                return;
            }
            if ((!getSharedViewModel().getGameState().getTurnTimerEnabled() || getSharedViewModel().getGameState().getTurnTimerPromptDismissed()) && !getSharedViewModel().getGameState().getTimerPaused()) {
                toggleTimerPause();
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.QRScanCallback
    public void onQRClosed() {
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(QRScanBottomSheetFragment.TAG);
        QRScanBottomSheetFragment qRScanBottomSheetFragment = fragmentFindFragmentByTag instanceof QRScanBottomSheetFragment ? (QRScanBottomSheetFragment) fragmentFindFragmentByTag : null;
        if (qRScanBottomSheetFragment != null) {
            qRScanBottomSheetFragment.dismiss();
        }
    }

    @Override // com.studiolaganne.lengendarylens.QRScanCallback
    public void onQRScanned(String value) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(value, "value");
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (preferencesManager.hasValidUser() && currentUser != null) {
            byte[] bArrDecode = Base64.decode(StringsKt.substringAfterLast$default(value, DomExceptionUtils.SEPARATOR, (String) null, 2, (Object) null), 0);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
            String str = new String(bArrDecode, Charsets.UTF_8);
            if (str.length() == 0) {
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string = getString(R.string.qr_error_title);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CustomDialogFragment.Builder title = builder.setTitle(string);
                String string2 = getString(R.string.qr_error_body);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder body = title.setBody(string2);
                String string3 = getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GameFragmentBase.onQRScanned$lambda$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                });
                FragmentManager childFragmentManager = getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                positiveButton.show(childFragmentManager, "qr_code_error_dialog");
                return;
            }
            Integer intOrNull = StringsKt.toIntOrNull(str);
            if (intOrNull != null && (iIntValue = intOrNull.intValue()) != -1 && iIntValue != currentUser.getId()) {
                MTApiKt.getMtApi().getUserById(currentUser.getId(), iIntValue).enqueue(new Callback<MTUserResponse>() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$onQRScanned$1$2$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTUserResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTUserResponse> call, Response<MTUserResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (this.this$0.getContext() != null && response.isSuccessful()) {
                            MTUserResponse mTUserResponseBody = response.body();
                            MTUser user = mTUserResponseBody != null ? mTUserResponseBody.getUser() : null;
                            if (user != null) {
                                GameFragmentBase gameFragmentBase = this.this$0;
                                MTFriend mTFriend = new MTFriend(0, null, null, null, null, null, false, false, 255, null);
                                mTFriend.setId(user.getId());
                                String firstname = user.getFirstname();
                                if (firstname == null) {
                                    firstname = "MT User";
                                }
                                mTFriend.setFirstname(firstname);
                                String username = user.getUsername();
                                if (username == null) {
                                    username = "@mtuser";
                                }
                                mTFriend.setUsername(username);
                                mTFriend.setPicture(user.getPicture());
                                gameFragmentBase.mythicUserSelected(gameFragmentBase.getLifeViews().get(gameFragmentBase.currentQRScanIndex), mTFriend, -1);
                            }
                        }
                    }
                });
            }
        }
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(QRScanBottomSheetFragment.TAG);
        QRScanBottomSheetFragment qRScanBottomSheetFragment = fragmentFindFragmentByTag instanceof QRScanBottomSheetFragment ? (QRScanBottomSheetFragment) fragmentFindFragmentByTag : null;
        if (qRScanBottomSheetFragment != null) {
            qRScanBottomSheetFragment.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.clockShowing) {
            this.clockHandler.post(this.clockRunnable);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        this.instanceSaved = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.instanceSaved = false;
        this.penaltySoundId = getSoundPool().load(getContext(), R.raw.buzzer, 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.instanceSaved = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String menuImage;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.hasCustomMenuImage = false;
        SkinManager companion = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        SkinDefinition currentSkinDefinition = companion.getCurrentSkinDefinition(contextRequireContext);
        if (currentSkinDefinition == null || (menuImage = currentSkinDefinition.getMenuImage()) == null || menuImage.length() <= 0) {
            return;
        }
        this.hasCustomMenuImage = true;
        SkinManager companion2 = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        String currentSkinCode = companion2.getCurrentSkinCode(contextRequireContext2);
        SkinManager companion3 = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        Bitmap imageFromSkin = companion3.getImageFromSkin(contextRequireContext3, currentSkinCode, menuImage);
        if (imageFromSkin != null && (imageView = (ImageView) view.findViewById(R.id.customMenuButtonImage)) != null) {
            imageView.setImageBitmap(imageFromSkin);
            Float menuScale = currentSkinDefinition.getMenuScale();
            float fFloatValue = menuScale != null ? menuScale.floatValue() : 1.0f;
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            GameUtils companion4 = GameUtils.INSTANCE.getInstance();
            Intrinsics.checkNotNullExpressionValue(requireContext(), "requireContext(...)");
            int iDpToPx = (int) (companion4.dpToPx(60, r3) * fFloatValue);
            layoutParams.width = iDpToPx;
            layoutParams.height = iDpToPx;
            imageView.setLayoutParams(layoutParams);
        }
        showMenu();
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void ownCmdDamageTapped(LifeTotalView sender, int orientation) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                ownCmdDamageTapped(i, orientation);
                return;
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void partnersToggled(LifeTotalView sender, boolean newValue) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                partnersToggled(i, newValue);
                return;
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void pauseTimerToggled(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        toggleTimerPause();
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void pickAColor(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(this.lifeViews.get(i), sender)) {
                showColorPicker(i);
                return;
            }
        }
    }

    public void planechaseToggled(boolean isOn) {
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void playerIsKO(LifeTotalView sender, String contextStr) {
        Object next;
        View view;
        int i;
        Object next2;
        Object next3;
        Object next4;
        Object next5;
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(contextStr, "contextStr");
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (this.lifeViews.isEmpty() || getSharedViewModel().getGameState().getPlayers().isEmpty()) {
            return;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        int size = this.lifeViews.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                intRef.element = i2;
                break;
            }
            i2++;
        }
        if (Intrinsics.areEqual(contextStr, "draw")) {
            int size2 = getSharedViewModel().getGameState().getPlayers().size();
            for (int i3 = 0; i3 < size2; i3++) {
                if (getSharedViewModel().getGameState().getPlayers().get(i3).getResultid() != 2 && getSharedViewModel().getGameState().getPlayers().get(i3).getResultid() != 0) {
                    getSharedViewModel().getGameState().getPlayers().get(i3).setResultid(3);
                }
            }
            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.GameDraw.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            closeCurrentTurn();
            Context context = getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            updateStreamingState$app_release();
            int size3 = this.lifeViews.size();
            for (int i4 = 0; i4 < size3; i4++) {
                if (getSharedViewModel().getGameState().getPlayers().get(i4).getResultid() != 2 && getSharedViewModel().getGameState().getPlayers().get(i4).getResultid() != 0) {
                    this.lifeViews.get(i4).triggerPlayerDraw();
                }
            }
            LifeTotalView lifeTotalView = this.lifeViewTeam1;
            if (lifeTotalView != null) {
                lifeTotalView.triggerPlayerDraw();
                Unit unit3 = Unit.INSTANCE;
            }
            LifeTotalView lifeTotalView2 = this.lifeViewTeam2;
            if (lifeTotalView2 != null) {
                lifeTotalView2.triggerPlayerDraw();
                Unit unit4 = Unit.INSTANCE;
            }
            if (getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                int size4 = this.lifeViews.size();
                for (int i5 = 0; i5 < size4; i5++) {
                    this.lifeViews.get(i5).hidePlayerTurnUI();
                    this.lifeViews.get(i5).hideUndoNextTurnUI();
                }
                LifeTotalView lifeTotalView3 = this.lifeViewTeam1;
                if (lifeTotalView3 != null) {
                    lifeTotalView3.hidePlayerTurnUI();
                    Unit unit5 = Unit.INSTANCE;
                }
                LifeTotalView lifeTotalView4 = this.lifeViewTeam1;
                if (lifeTotalView4 != null) {
                    lifeTotalView4.hideUndoNextTurnUI();
                    Unit unit6 = Unit.INSTANCE;
                }
                LifeTotalView lifeTotalView5 = this.lifeViewTeam2;
                if (lifeTotalView5 != null) {
                    lifeTotalView5.hidePlayerTurnUI();
                    Unit unit7 = Unit.INSTANCE;
                }
                LifeTotalView lifeTotalView6 = this.lifeViewTeam2;
                if (lifeTotalView6 != null) {
                    lifeTotalView6.hideUndoNextTurnUI();
                    Unit unit8 = Unit.INSTANCE;
                }
            }
            View view2 = getView();
            if (view2 != null) {
                Boolean.valueOf(view2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda87
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.gameFinished();
                    }
                }, 3000L));
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(contextStr, "concede")) {
            getSharedViewModel().getGameState().getPlayers().get(intRef.element).setResultid(2);
            if (getSharedViewModel().getGameState().getSubformatId() == 5 && getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
                if (intRef.element == 0 || intRef.element == 3) {
                    getSharedViewModel().getGameState().getPlayers().get(0).setResultid(2);
                    getSharedViewModel().getGameState().getPlayers().get(3).setResultid(2);
                } else {
                    getSharedViewModel().getGameState().getPlayers().get(1).setResultid(2);
                    getSharedViewModel().getGameState().getPlayers().get(2).setResultid(2);
                }
            }
            if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
                if (intRef.element == 0 || intRef.element == 1 || intRef.element == 5) {
                    getSharedViewModel().getGameState().getPlayers().get(0).setResultid(2);
                    getSharedViewModel().getGameState().getPlayers().get(1).setResultid(2);
                    getSharedViewModel().getGameState().getPlayers().get(5).setResultid(2);
                } else {
                    getSharedViewModel().getGameState().getPlayers().get(2).setResultid(2);
                    getSharedViewModel().getGameState().getPlayers().get(3).setResultid(2);
                    getSharedViewModel().getGameState().getPlayers().get(4).setResultid(2);
                }
            }
            Context context2 = getContext();
            if (context2 != null) {
                new PreferencesManager(context2).saveCurrentGame(getSharedViewModel().getGameState());
                Unit unit9 = Unit.INSTANCE;
                Unit unit10 = Unit.INSTANCE;
            }
            updateStreamingState$app_release();
        } else {
            getSharedViewModel().getGameState().getPlayers().get(intRef.element).setResultid(0);
            if (getSharedViewModel().getGameState().getSubformatId() == 5 && getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
                if (intRef.element == 0 || intRef.element == 3) {
                    getSharedViewModel().getGameState().getPlayers().get(0).setResultid(0);
                    getSharedViewModel().getGameState().getPlayers().get(3).setResultid(0);
                } else {
                    getSharedViewModel().getGameState().getPlayers().get(1).setResultid(0);
                    getSharedViewModel().getGameState().getPlayers().get(2).setResultid(0);
                }
            }
            if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
                if (intRef.element == 0 || intRef.element == 1 || intRef.element == 5) {
                    getSharedViewModel().getGameState().getPlayers().get(0).setResultid(0);
                    getSharedViewModel().getGameState().getPlayers().get(1).setResultid(0);
                    getSharedViewModel().getGameState().getPlayers().get(5).setResultid(0);
                } else {
                    getSharedViewModel().getGameState().getPlayers().get(2).setResultid(0);
                    getSharedViewModel().getGameState().getPlayers().get(3).setResultid(0);
                    getSharedViewModel().getGameState().getPlayers().get(4).setResultid(0);
                }
            }
            Context context3 = getContext();
            if (context3 != null) {
                new PreferencesManager(context3).saveCurrentGame(getSharedViewModel().getGameState());
                Unit unit11 = Unit.INSTANCE;
                Unit unit12 = Unit.INSTANCE;
            }
            updateStreamingState$app_release();
        }
        getSharedViewModel().getGameState().getPlayers().get(intRef.element).setKO(true);
        if (getSharedViewModel().getGameState().getSubformatId() == 5 && getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
            if (intRef.element == 0 || intRef.element == 3) {
                getSharedViewModel().getGameState().getPlayers().get(0).setKO(true);
                getSharedViewModel().getGameState().getPlayers().get(3).setKO(true);
            } else {
                getSharedViewModel().getGameState().getPlayers().get(1).setKO(true);
                getSharedViewModel().getGameState().getPlayers().get(2).setKO(true);
            }
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            if (intRef.element == 0 || intRef.element == 1 || intRef.element == 5) {
                getSharedViewModel().getGameState().getPlayers().get(0).setKO(true);
                getSharedViewModel().getGameState().getPlayers().get(1).setKO(true);
                getSharedViewModel().getGameState().getPlayers().get(5).setKO(true);
            } else {
                getSharedViewModel().getGameState().getPlayers().get(2).setKO(true);
                getSharedViewModel().getGameState().getPlayers().get(3).setKO(true);
                getSharedViewModel().getGameState().getPlayers().get(4).setKO(true);
            }
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 3) {
            Iterator<T> it = getSharedViewModel().getGameState().getEvents().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next3 = null;
                    break;
                }
                next3 = it.next();
                MTGameEvent mTGameEvent = (MTGameEvent) next3;
                if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TreacheryRole.getValue()) && mTGameEvent.getPlayerid() == intRef.element) {
                    break;
                }
            }
            if (next3 == null) {
                View view3 = getView();
                if (view3 != null) {
                    Boolean.valueOf(view3.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda88
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lifeViews.get(intRef.element).triggerChooseTreacheryRole();
                        }
                    }, 1000L));
                }
            } else {
                Iterator<T> it2 = getSharedViewModel().getGameState().getEvents().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next4 = null;
                        break;
                    }
                    next4 = it2.next();
                    MTGameEvent mTGameEvent2 = (MTGameEvent) next4;
                    if (Intrinsics.areEqual(mTGameEvent2.getType(), MTEvent.TreacheryRole.getValue()) && mTGameEvent2.getPlayerid() == intRef.element && mTGameEvent2.getValue() == 0) {
                        break;
                    }
                }
                if (next4 != null && !GameUtils.INSTANCE.getInstance().allPlayersHaveRole(getSharedViewModel().getGameState())) {
                    int size5 = this.lifeViews.size();
                    int i6 = 0;
                    while (i6 < size5) {
                        Iterator<T> it3 = getSharedViewModel().getGameState().getEvents().iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                next5 = null;
                                break;
                            }
                            next5 = it3.next();
                            MTGameEvent mTGameEvent3 = (MTGameEvent) next5;
                            if (Intrinsics.areEqual(mTGameEvent3.getType(), MTEvent.TreacheryRole.getValue()) && mTGameEvent3.getPlayerid() == i6) {
                                break;
                            }
                        }
                        if (next5 == null) {
                            this.lifeViews.get(i6).triggerChooseTreacheryRole();
                        }
                        i6++;
                    }
                }
                Unit unit13 = Unit.INSTANCE;
            }
        }
        Iterator<T> it4 = getSharedViewModel().getGameState().getEvents().iterator();
        while (true) {
            if (!it4.hasNext()) {
                next = null;
                break;
            }
            next = it4.next();
            MTGameEvent mTGameEvent4 = (MTGameEvent) next;
            if (Intrinsics.areEqual(mTGameEvent4.getType(), MTEvent.PlayerLose.getValue()) && mTGameEvent4.getPlayerid() == intRef.element) {
                break;
            }
        }
        if (next == null) {
            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, (Intrinsics.areEqual(contextStr, "concede") ? MTEvent.PlayerConcede : MTEvent.PlayerLose).getValue(), intRef.element, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 5) {
            if (getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
                if (intRef.element == 0 || intRef.element == 3) {
                    addEventIfNeeded(Intrinsics.areEqual(contextStr, "concede") ? MTEvent.PlayerConcede : MTEvent.PlayerLose, 0);
                    addEventIfNeeded(Intrinsics.areEqual(contextStr, "concede") ? MTEvent.PlayerConcede : MTEvent.PlayerLose, 3);
                    addEventIfNeeded(MTEvent.PlayerWin, 1);
                    addEventIfNeeded(MTEvent.PlayerWin, 2);
                } else {
                    addEventIfNeeded(Intrinsics.areEqual(contextStr, "concede") ? MTEvent.PlayerConcede : MTEvent.PlayerLose, 1);
                    addEventIfNeeded(Intrinsics.areEqual(contextStr, "concede") ? MTEvent.PlayerConcede : MTEvent.PlayerLose, 2);
                    addEventIfNeeded(MTEvent.PlayerWin, 0);
                    addEventIfNeeded(MTEvent.PlayerWin, 3);
                }
            }
            if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
                if (intRef.element == 0 || intRef.element == 1 || intRef.element == 5) {
                    addEventIfNeeded(Intrinsics.areEqual(contextStr, "concede") ? MTEvent.PlayerConcede : MTEvent.PlayerLose, 0);
                    addEventIfNeeded(Intrinsics.areEqual(contextStr, "concede") ? MTEvent.PlayerConcede : MTEvent.PlayerLose, 1);
                    addEventIfNeeded(Intrinsics.areEqual(contextStr, "concede") ? MTEvent.PlayerConcede : MTEvent.PlayerLose, 5);
                    addEventIfNeeded(MTEvent.PlayerWin, 2);
                    addEventIfNeeded(MTEvent.PlayerWin, 3);
                    addEventIfNeeded(MTEvent.PlayerWin, 4);
                } else {
                    addEventIfNeeded(Intrinsics.areEqual(contextStr, "concede") ? MTEvent.PlayerConcede : MTEvent.PlayerLose, 2);
                    addEventIfNeeded(Intrinsics.areEqual(contextStr, "concede") ? MTEvent.PlayerConcede : MTEvent.PlayerLose, 3);
                    addEventIfNeeded(Intrinsics.areEqual(contextStr, "concede") ? MTEvent.PlayerConcede : MTEvent.PlayerLose, 4);
                    addEventIfNeeded(MTEvent.PlayerWin, 0);
                    addEventIfNeeded(MTEvent.PlayerWin, 1);
                    addEventIfNeeded(MTEvent.PlayerWin, 5);
                }
            }
        }
        int size6 = this.lifeViews.size();
        for (int i7 = 0; i7 < size6; i7++) {
            this.lifeViews.get(i7).setDisplayedCommanderDamage(commanderDamageValueToShowFor(i7));
            this.lifeViews.get(i7).checkVitals();
        }
        getSharedViewModel().getGameState().getPlayers().get(intRef.element).setMonarch(false);
        getSharedViewModel().getGameState().getPlayers().get(intRef.element).setInitiative(false);
        getSharedViewModel().getGameState().getPlayers().get(intRef.element).setCityBlessing(false);
        getSharedViewModel().getGameState().getPlayers().get(intRef.element).setTheRing(false);
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
        if (getSharedViewModel().getGameState().getSubformatId() == 3) {
            List<Player> players = getSharedViewModel().getGameState().getPlayers();
            if ((players instanceof Collection) && players.isEmpty()) {
                i = 0;
            } else {
                Iterator<T> it5 = players.iterator();
                int i8 = 0;
                while (it5.hasNext()) {
                    if (!((Player) it5.next()).isKO() && (i8 = i8 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
                i = i8;
            }
            if (i == 1) {
                int size7 = this.lifeViews.size();
                int i9 = 0;
                while (i9 < size7) {
                    Iterator<T> it6 = getSharedViewModel().getGameState().getEvents().iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it6.next();
                        MTGameEvent mTGameEvent5 = (MTGameEvent) next2;
                        if (Intrinsics.areEqual(mTGameEvent5.getType(), MTEvent.TreacheryRole.getValue()) && mTGameEvent5.getPlayerid() == i9) {
                            break;
                        }
                    }
                    if (next2 == null) {
                        this.lifeViews.get(i9).triggerChooseTreacheryRole();
                    }
                    i9++;
                }
            }
        }
        List<Integer> gameWinners = GameUtils.INSTANCE.getInstance().getGameWinners(getSharedViewModel().getGameState());
        if (gameWinners.isEmpty()) {
            if (getSharedViewModel().getGameState().getTurnTimerEnabled() && getSharedViewModel().getGameState().getSubformatId() != 5 && getSharedViewModel().getGameState().getSubformatId() != 6 && intRef.element == getSharedViewModel().getGameState().getCurrentTurnPlayerIndex()) {
                endTurnTapped(sender);
            }
            Unit unit14 = Unit.INSTANCE;
        } else {
            int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
            boolean z = false;
            for (int i10 = 0; i10 < numberOfPlayers; i10++) {
                if (gameWinners.contains(Integer.valueOf(getSharedViewModel().getGameState().getPlayers().get(i10).getUserId()))) {
                    addEventIfNeeded(MTEvent.PlayerWin, i10);
                    this.lifeViews.get(i10).triggerPlayerWin();
                    if (getSharedViewModel().getGameState().getSubformatId() == 5 && getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
                        if (i10 == 0 || i10 == 3) {
                            if (!z) {
                                LifeTotalView lifeTotalView7 = this.lifeViewTeam1;
                                if (lifeTotalView7 != null) {
                                    lifeTotalView7.triggerPlayerWin();
                                    Unit unit15 = Unit.INSTANCE;
                                }
                                z = true;
                            }
                            Unit unit16 = Unit.INSTANCE;
                        } else {
                            if (!z) {
                                LifeTotalView lifeTotalView8 = this.lifeViewTeam2;
                                if (lifeTotalView8 != null) {
                                    lifeTotalView8.triggerPlayerWin();
                                    Unit unit17 = Unit.INSTANCE;
                                }
                                z = true;
                            }
                            Unit unit18 = Unit.INSTANCE;
                        }
                    }
                    if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
                        if (i10 == 0 || i10 == 1 || i10 == 5) {
                            if (!z) {
                                LifeTotalView lifeTotalView9 = this.lifeViewTeam1;
                                if (lifeTotalView9 != null) {
                                    lifeTotalView9.triggerPlayerWin();
                                    Unit unit19 = Unit.INSTANCE;
                                }
                                z = true;
                            }
                            Unit unit20 = Unit.INSTANCE;
                        } else {
                            if (!z) {
                                LifeTotalView lifeTotalView10 = this.lifeViewTeam2;
                                if (lifeTotalView10 != null) {
                                    lifeTotalView10.triggerPlayerWin();
                                    Unit unit21 = Unit.INSTANCE;
                                }
                                z = true;
                            }
                            Unit unit22 = Unit.INSTANCE;
                        }
                    }
                }
            }
            updateBoScoreEarlyIfNeeded();
            hideLifeHistory();
            if (getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                int size8 = this.lifeViews.size();
                for (int i11 = 0; i11 < size8; i11++) {
                    this.lifeViews.get(i11).hidePlayerTurnUI();
                    this.lifeViews.get(i11).hideUndoNextTurnUI();
                }
                LifeTotalView lifeTotalView11 = this.lifeViewTeam1;
                if (lifeTotalView11 != null) {
                    lifeTotalView11.hidePlayerTurnUI();
                    Unit unit23 = Unit.INSTANCE;
                }
                LifeTotalView lifeTotalView12 = this.lifeViewTeam1;
                if (lifeTotalView12 != null) {
                    lifeTotalView12.hideUndoNextTurnUI();
                    Unit unit24 = Unit.INSTANCE;
                }
                LifeTotalView lifeTotalView13 = this.lifeViewTeam2;
                if (lifeTotalView13 != null) {
                    lifeTotalView13.hidePlayerTurnUI();
                    Unit unit25 = Unit.INSTANCE;
                }
                LifeTotalView lifeTotalView14 = this.lifeViewTeam2;
                if (lifeTotalView14 != null) {
                    lifeTotalView14.hideUndoNextTurnUI();
                    Unit unit26 = Unit.INSTANCE;
                }
            }
            if (getContext() != null) {
                int i12 = preferencesManager.getInt(PreferencesManager.NUM_GAMES, 0);
                if (!preferencesManager.getBoolean(PreferencesManager.GAME_RATING_PROMPT_SHOWN, false) && i12 >= 1 && (view = getView()) != null) {
                    Boolean.valueOf(view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda89
                        @Override // java.lang.Runnable
                        public final void run() {
                            GameFragmentBase.playerIsKO$lambda$11$0(this.f$0, preferencesManager);
                        }
                    }, 5000L));
                }
                closeCurrentTurn();
                if ((getSharedViewModel().getGameState().getPlaygroupId() == -1 && currentUser == null) || !getSharedViewModel().getGameState().getGameSyncable() || getSharedViewModel().getGameState().getGameSynced()) {
                    View view4 = getView();
                    if (view4 != null) {
                        Boolean.valueOf(view4.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda91
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.nonSyncableGameFinished();
                            }
                        }, 3000L));
                    }
                } else {
                    View view5 = getView();
                    if (view5 != null) {
                        Boolean.valueOf(view5.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda90
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.gameFinished();
                            }
                        }, 3000L));
                    }
                }
            }
        }
        updateStreamingState$app_release();
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void playerIsPlayingFirst(LifeTotalView sender, boolean playingFirst) {
        int i;
        int i2;
        int i3;
        boolean zAdd;
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        int size = this.lifeViews.size();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                i = 0;
                break;
            } else {
                if (Intrinsics.areEqual(sender, this.lifeViews.get(i5))) {
                    i = i5;
                    break;
                }
                i5++;
            }
        }
        if (!getSharedViewModel().getGameState().getTurnTimerEnabled() || getSharedViewModel().getGameState().getNumberOfPlayers() <= 2) {
            if (getSharedViewModel().getGameState().getPlayers().size() == 2) {
                int i6 = !playingFirst ? i == 0 ? 1 : 0 : i;
                if (i6 < getSharedViewModel().getGameState().getPlayers().size()) {
                    getSharedViewModel().getGameState().setStartingPlayerIndex(i6);
                    getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), i6, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
                    if (getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                        int size2 = this.lifeViews.size();
                        while (i4 < size2) {
                            this.lifeViews.get(i4).undoPlayerDeadQ();
                            if (i4 == i6) {
                                this.lifeViews.get(i4).showFirstTurnPrompt();
                            }
                            i4++;
                        }
                    }
                }
            } else {
                if (!playingFirst) {
                    this.notStartingGameIndexes.add(Integer.valueOf(i));
                    if (this.notStartingGameIndexes.size() == getSharedViewModel().getGameState().getNumberOfPlayers() - 1) {
                        int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= numberOfPlayers) {
                                i2 = 0;
                                break;
                            } else {
                                if (!this.notStartingGameIndexes.contains(Integer.valueOf(i7))) {
                                    i2 = i7;
                                    break;
                                }
                                i7++;
                            }
                        }
                        if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                            if (getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
                                if (i2 == 0 || i2 == 3) {
                                    LifeTotalView lifeTotalView = this.lifeViewTeam2;
                                    if (lifeTotalView != null) {
                                        lifeTotalView.undoPlayerDeadQ();
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                                    getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 3, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                                } else {
                                    LifeTotalView lifeTotalView2 = this.lifeViewTeam1;
                                    if (lifeTotalView2 != null) {
                                        lifeTotalView2.undoPlayerDeadQ();
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                    getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 1, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                                    getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 2, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                                }
                            }
                            Unit unit3 = Unit.INSTANCE;
                        } else if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                            if (getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
                                if (i2 == 0 || i2 == 1 || i2 == 5) {
                                    LifeTotalView lifeTotalView3 = this.lifeViewTeam2;
                                    if (lifeTotalView3 != null) {
                                        lifeTotalView3.undoPlayerDeadQ();
                                        Unit unit4 = Unit.INSTANCE;
                                    }
                                    getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                                    getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 1, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                                    getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 5, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                                } else {
                                    LifeTotalView lifeTotalView4 = this.lifeViewTeam1;
                                    if (lifeTotalView4 != null) {
                                        lifeTotalView4.undoPlayerDeadQ();
                                        Unit unit5 = Unit.INSTANCE;
                                    }
                                    getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 2, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                                    getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 3, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                                    getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 4, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                                }
                            }
                            Unit unit6 = Unit.INSTANCE;
                        } else {
                            int size3 = this.lifeViews.size();
                            while (i4 < size3) {
                                this.lifeViews.get(i4).undoPlayerDeadQ();
                                i4++;
                            }
                            Boolean.valueOf(getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), i2, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp())));
                        }
                        getSharedViewModel().getGameState().setStartingPlayerIndex(i2);
                        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
                        return;
                    }
                    return;
                }
                if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                    if (getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
                        if (i == 0 || i == 3) {
                            LifeTotalView lifeTotalView5 = this.lifeViewTeam2;
                            if (lifeTotalView5 != null) {
                                lifeTotalView5.undoPlayerDeadQ();
                                Unit unit7 = Unit.INSTANCE;
                            }
                            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 3, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        } else {
                            LifeTotalView lifeTotalView6 = this.lifeViewTeam1;
                            if (lifeTotalView6 != null) {
                                lifeTotalView6.undoPlayerDeadQ();
                                Unit unit8 = Unit.INSTANCE;
                            }
                            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 1, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 2, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        }
                    }
                    Unit unit9 = Unit.INSTANCE;
                } else if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                    if (getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
                        if (i == 0 || i == 1 || i == 5) {
                            LifeTotalView lifeTotalView7 = this.lifeViewTeam2;
                            if (lifeTotalView7 != null) {
                                lifeTotalView7.undoPlayerDeadQ();
                                Unit unit10 = Unit.INSTANCE;
                            }
                            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 1, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 5, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        } else {
                            LifeTotalView lifeTotalView8 = this.lifeViewTeam1;
                            if (lifeTotalView8 != null) {
                                lifeTotalView8.undoPlayerDeadQ();
                                Unit unit11 = Unit.INSTANCE;
                            }
                            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 2, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 3, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 4, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        }
                    }
                    Unit unit12 = Unit.INSTANCE;
                } else {
                    int size4 = this.lifeViews.size();
                    while (i4 < size4) {
                        this.lifeViews.get(i4).undoPlayerDeadQ();
                        i4++;
                    }
                    Boolean.valueOf(getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), i, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp())));
                }
                getSharedViewModel().getGameState().setStartingPlayerIndex(i);
                preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
            }
        } else {
            if (!playingFirst) {
                this.notStartingGameIndexes.add(Integer.valueOf(i));
                if (this.notStartingGameIndexes.size() == getSharedViewModel().getGameState().getNumberOfPlayers() - 1) {
                    int numberOfPlayers2 = getSharedViewModel().getGameState().getNumberOfPlayers();
                    int i8 = 0;
                    while (true) {
                        if (i8 >= numberOfPlayers2) {
                            i3 = 0;
                            break;
                        } else {
                            if (!this.notStartingGameIndexes.contains(Integer.valueOf(i8))) {
                                i3 = i8;
                                break;
                            }
                            i8++;
                        }
                    }
                    if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                        if (getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
                            if (i3 == 0 || i3 == 3) {
                                LifeTotalView lifeTotalView9 = this.lifeViewTeam1;
                                if (lifeTotalView9 != null) {
                                    lifeTotalView9.showFirstTurnPrompt();
                                    Unit unit13 = Unit.INSTANCE;
                                }
                                LifeTotalView lifeTotalView10 = this.lifeViewTeam2;
                                if (lifeTotalView10 != null) {
                                    lifeTotalView10.undoPlayerDeadQ();
                                    Unit unit14 = Unit.INSTANCE;
                                }
                            } else {
                                LifeTotalView lifeTotalView11 = this.lifeViewTeam2;
                                if (lifeTotalView11 != null) {
                                    lifeTotalView11.showFirstTurnPrompt();
                                    Unit unit15 = Unit.INSTANCE;
                                }
                                LifeTotalView lifeTotalView12 = this.lifeViewTeam1;
                                if (lifeTotalView12 != null) {
                                    lifeTotalView12.undoPlayerDeadQ();
                                    Unit unit16 = Unit.INSTANCE;
                                }
                            }
                        }
                        if (i3 == 0 || i3 == 3) {
                            LifeTotalView lifeTotalView13 = this.lifeViewTeam2;
                            if (lifeTotalView13 != null) {
                                lifeTotalView13.undoPlayerDeadQ();
                                Unit unit17 = Unit.INSTANCE;
                            }
                            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                            zAdd = getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 3, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        } else {
                            LifeTotalView lifeTotalView14 = this.lifeViewTeam1;
                            if (lifeTotalView14 != null) {
                                lifeTotalView14.undoPlayerDeadQ();
                                Unit unit18 = Unit.INSTANCE;
                            }
                            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 1, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                            zAdd = getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 2, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        }
                        Boolean.valueOf(zAdd);
                    } else if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                        if (getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
                            if (i3 == 0 || i3 == 1 || i3 == 5) {
                                LifeTotalView lifeTotalView15 = this.lifeViewTeam1;
                                if (lifeTotalView15 != null) {
                                    lifeTotalView15.showFirstTurnPrompt();
                                    Unit unit19 = Unit.INSTANCE;
                                }
                                LifeTotalView lifeTotalView16 = this.lifeViewTeam2;
                                if (lifeTotalView16 != null) {
                                    lifeTotalView16.undoPlayerDeadQ();
                                    Unit unit20 = Unit.INSTANCE;
                                }
                            } else {
                                LifeTotalView lifeTotalView17 = this.lifeViewTeam2;
                                if (lifeTotalView17 != null) {
                                    lifeTotalView17.showFirstTurnPrompt();
                                    Unit unit21 = Unit.INSTANCE;
                                }
                                LifeTotalView lifeTotalView18 = this.lifeViewTeam1;
                                if (lifeTotalView18 != null) {
                                    lifeTotalView18.undoPlayerDeadQ();
                                    Unit unit22 = Unit.INSTANCE;
                                }
                            }
                            if (i3 == 0 || i3 == 1 || i3 == 5) {
                                LifeTotalView lifeTotalView19 = this.lifeViewTeam2;
                                if (lifeTotalView19 != null) {
                                    lifeTotalView19.undoPlayerDeadQ();
                                    Unit unit23 = Unit.INSTANCE;
                                }
                                getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                                getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 1, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                                getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 5, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                            } else {
                                LifeTotalView lifeTotalView20 = this.lifeViewTeam1;
                                if (lifeTotalView20 != null) {
                                    lifeTotalView20.undoPlayerDeadQ();
                                    Unit unit24 = Unit.INSTANCE;
                                }
                                getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 2, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                                getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 3, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                                getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 4, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                            }
                        }
                        Unit unit25 = Unit.INSTANCE;
                    } else {
                        int size5 = this.lifeViews.size();
                        while (i4 < size5) {
                            this.lifeViews.get(i4).undoPlayerDeadQ();
                            if (i4 == i3) {
                                this.lifeViews.get(i4).showFirstTurnPrompt();
                            }
                            i4++;
                        }
                        Boolean.valueOf(getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), i3, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp())));
                    }
                    getSharedViewModel().getGameState().setStartingPlayerIndex(i3);
                    preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
                    return;
                }
                return;
            }
            if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                if (getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
                    if (i == 0 || i == 3) {
                        LifeTotalView lifeTotalView21 = this.lifeViewTeam1;
                        if (lifeTotalView21 != null) {
                            lifeTotalView21.showFirstTurnPrompt();
                            Unit unit26 = Unit.INSTANCE;
                        }
                        LifeTotalView lifeTotalView22 = this.lifeViewTeam2;
                        if (lifeTotalView22 != null) {
                            lifeTotalView22.undoPlayerDeadQ();
                            Unit unit27 = Unit.INSTANCE;
                        }
                    } else {
                        LifeTotalView lifeTotalView23 = this.lifeViewTeam2;
                        if (lifeTotalView23 != null) {
                            lifeTotalView23.showFirstTurnPrompt();
                            Unit unit28 = Unit.INSTANCE;
                        }
                        LifeTotalView lifeTotalView24 = this.lifeViewTeam1;
                        if (lifeTotalView24 != null) {
                            lifeTotalView24.undoPlayerDeadQ();
                            Unit unit29 = Unit.INSTANCE;
                        }
                    }
                    if (i == 0 || i == 3) {
                        LifeTotalView lifeTotalView25 = this.lifeViewTeam2;
                        if (lifeTotalView25 != null) {
                            lifeTotalView25.undoPlayerDeadQ();
                            Unit unit30 = Unit.INSTANCE;
                        }
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 3, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    } else {
                        LifeTotalView lifeTotalView26 = this.lifeViewTeam1;
                        if (lifeTotalView26 != null) {
                            lifeTotalView26.undoPlayerDeadQ();
                            Unit unit31 = Unit.INSTANCE;
                        }
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 1, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 2, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    }
                }
                Unit unit32 = Unit.INSTANCE;
            } else if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                if (getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
                    if (i == 0 || i == 1 || i == 5) {
                        LifeTotalView lifeTotalView27 = this.lifeViewTeam1;
                        if (lifeTotalView27 != null) {
                            lifeTotalView27.showFirstTurnPrompt();
                            Unit unit33 = Unit.INSTANCE;
                        }
                        LifeTotalView lifeTotalView28 = this.lifeViewTeam2;
                        if (lifeTotalView28 != null) {
                            lifeTotalView28.undoPlayerDeadQ();
                            Unit unit34 = Unit.INSTANCE;
                        }
                    } else {
                        LifeTotalView lifeTotalView29 = this.lifeViewTeam2;
                        if (lifeTotalView29 != null) {
                            lifeTotalView29.showFirstTurnPrompt();
                            Unit unit35 = Unit.INSTANCE;
                        }
                        LifeTotalView lifeTotalView30 = this.lifeViewTeam1;
                        if (lifeTotalView30 != null) {
                            lifeTotalView30.undoPlayerDeadQ();
                            Unit unit36 = Unit.INSTANCE;
                        }
                    }
                    if (i == 0 || i == 1 || i == 5) {
                        LifeTotalView lifeTotalView31 = this.lifeViewTeam2;
                        if (lifeTotalView31 != null) {
                            lifeTotalView31.undoPlayerDeadQ();
                            Unit unit37 = Unit.INSTANCE;
                        }
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 1, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 5, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    } else {
                        LifeTotalView lifeTotalView32 = this.lifeViewTeam1;
                        if (lifeTotalView32 != null) {
                            lifeTotalView32.undoPlayerDeadQ();
                            Unit unit38 = Unit.INSTANCE;
                        }
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 2, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 3, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 4, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    }
                }
                Unit unit39 = Unit.INSTANCE;
            } else {
                int size6 = this.lifeViews.size();
                while (i4 < size6) {
                    this.lifeViews.get(i4).undoPlayerDeadQ();
                    if (i4 == i) {
                        this.lifeViews.get(i4).showFirstTurnPrompt();
                    }
                    i4++;
                }
                Boolean.valueOf(getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), i, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp())));
            }
            getSharedViewModel().getGameState().setStartingPlayerIndex(i);
            preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
        }
        updateStreamingState$app_release();
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void playerIsWin(LifeTotalView sender) {
        int i;
        Object next;
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        int size = this.lifeViews.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else {
                if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                    i = i2;
                    break;
                }
                i2++;
            }
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 5) {
            if (getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
                if (i == 0 || i == 3) {
                    addEventIfNeeded(MTEvent.PlayerLose, 1);
                    addEventIfNeeded(MTEvent.PlayerLose, 2);
                    getSharedViewModel().getGameState().getPlayers().get(1).setKO(true);
                    getSharedViewModel().getGameState().getPlayers().get(2).setKO(true);
                    addEventIfNeeded(MTEvent.PlayerWin, 0);
                    addEventIfNeeded(MTEvent.PlayerWin, 3);
                    LifeTotalView lifeTotalView = this.lifeViewTeam2;
                    if (lifeTotalView != null) {
                        lifeTotalView.triggerPlayerKO();
                    }
                } else {
                    addEventIfNeeded(MTEvent.PlayerLose, 0);
                    addEventIfNeeded(MTEvent.PlayerLose, 3);
                    getSharedViewModel().getGameState().getPlayers().get(0).setKO(true);
                    getSharedViewModel().getGameState().getPlayers().get(3).setKO(true);
                    addEventIfNeeded(MTEvent.PlayerWin, 1);
                    addEventIfNeeded(MTEvent.PlayerWin, 2);
                    LifeTotalView lifeTotalView2 = this.lifeViewTeam1;
                    if (lifeTotalView2 != null) {
                        lifeTotalView2.triggerPlayerKO();
                    }
                }
                closeCurrentTurn();
            }
        } else if (getSharedViewModel().getGameState().getSubformatId() != 6) {
            int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
            for (int i3 = 0; i3 < numberOfPlayers; i3++) {
                if (i3 == i) {
                    getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerWin.getValue(), i, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                } else {
                    getSharedViewModel().getGameState().getPlayers().get(i3).setKO(true);
                    this.lifeViews.get(i3).triggerPlayerKO();
                    addEventIfNeeded(MTEvent.PlayerLose, i3);
                }
            }
            closeCurrentTurn();
        } else if (getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
            if (i == 0 || i == 1 || i == 5) {
                addEventIfNeeded(MTEvent.PlayerLose, 2);
                addEventIfNeeded(MTEvent.PlayerLose, 3);
                addEventIfNeeded(MTEvent.PlayerLose, 4);
                getSharedViewModel().getGameState().getPlayers().get(2).setKO(true);
                getSharedViewModel().getGameState().getPlayers().get(3).setKO(true);
                getSharedViewModel().getGameState().getPlayers().get(4).setKO(true);
                addEventIfNeeded(MTEvent.PlayerWin, 0);
                addEventIfNeeded(MTEvent.PlayerWin, 1);
                addEventIfNeeded(MTEvent.PlayerWin, 5);
                LifeTotalView lifeTotalView3 = this.lifeViewTeam2;
                if (lifeTotalView3 != null) {
                    lifeTotalView3.triggerPlayerKO();
                }
            } else {
                addEventIfNeeded(MTEvent.PlayerLose, 0);
                addEventIfNeeded(MTEvent.PlayerLose, 1);
                addEventIfNeeded(MTEvent.PlayerLose, 5);
                getSharedViewModel().getGameState().getPlayers().get(0).setKO(true);
                getSharedViewModel().getGameState().getPlayers().get(1).setKO(true);
                getSharedViewModel().getGameState().getPlayers().get(5).setKO(true);
                addEventIfNeeded(MTEvent.PlayerWin, 2);
                addEventIfNeeded(MTEvent.PlayerWin, 3);
                addEventIfNeeded(MTEvent.PlayerWin, 4);
                LifeTotalView lifeTotalView4 = this.lifeViewTeam1;
                if (lifeTotalView4 != null) {
                    lifeTotalView4.triggerPlayerKO();
                }
            }
            closeCurrentTurn();
        }
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
        updateBoScoreEarlyIfNeeded();
        if (getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            int size2 = this.lifeViews.size();
            for (int i4 = 0; i4 < size2; i4++) {
                this.lifeViews.get(i4).hidePlayerTurnUI();
                this.lifeViews.get(i4).hideUndoNextTurnUI();
            }
            LifeTotalView lifeTotalView5 = this.lifeViewTeam1;
            if (lifeTotalView5 != null) {
                lifeTotalView5.hidePlayerTurnUI();
            }
            LifeTotalView lifeTotalView6 = this.lifeViewTeam1;
            if (lifeTotalView6 != null) {
                lifeTotalView6.hideUndoNextTurnUI();
            }
            LifeTotalView lifeTotalView7 = this.lifeViewTeam2;
            if (lifeTotalView7 != null) {
                lifeTotalView7.hidePlayerTurnUI();
            }
            LifeTotalView lifeTotalView8 = this.lifeViewTeam2;
            if (lifeTotalView8 != null) {
                lifeTotalView8.hideUndoNextTurnUI();
            }
        }
        if (getSharedViewModel().getGameState().getSubformatId() == 3 && !GameUtils.INSTANCE.getInstance().allPlayersHaveRole(getSharedViewModel().getGameState())) {
            int size3 = this.lifeViews.size();
            for (int i5 = 0; i5 < size3; i5++) {
                Iterator<T> it = getSharedViewModel().getGameState().getEvents().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    MTGameEvent mTGameEvent = (MTGameEvent) next;
                    if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TreacheryRole.getValue()) && mTGameEvent.getPlayerid() == i5) {
                        break;
                    }
                }
                if (next == null) {
                    this.lifeViews.get(i5).triggerChooseTreacheryRole();
                }
            }
        }
        if ((getSharedViewModel().getGameState().getPlaygroupId() == -1 && currentUser == null) || !getSharedViewModel().getGameState().getGameSyncable() || getSharedViewModel().getGameState().getGameSynced()) {
            View view = getView();
            if (view != null) {
                view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda50
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.nonSyncableGameFinished();
                    }
                }, 3000L);
            }
        } else {
            View view2 = getView();
            if (view2 != null) {
                view2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.gameFinished();
                    }
                }, 3000L);
            }
        }
        updateStreamingState$app_release();
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void playerTapToStartTapped(LifeTotalView sender) {
        int i;
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getContext() == null) {
            return;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("turn_timer_tap_to_start", null);
        int size = this.lifeViews.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else {
                if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                    i = i2;
                    break;
                }
                i2++;
            }
        }
        if (getSharedViewModel().getGameState().getNumberOfPlayers() == this.lifeViews.size() && getSharedViewModel().getGameState().getNumberOfPlayers() == getSharedViewModel().getGameState().getPlayers().size() && i == getSharedViewModel().getGameState().getStartingPlayerIndex()) {
            getSharedViewModel().getGameState().setTurnTimerPromptDismissed(true);
            getSharedViewModel().getGameState().setCurrentGameTurn(0);
            getSharedViewModel().getGameState().setCurrentTurnStartTime(System.currentTimeMillis());
            getSharedViewModel().getGameState().setCurrentTurnPlayerIndex(i);
            getSharedViewModel().getGameState().setCurrentTurnPauseTime(0);
            this.currentTurnPenaltyIndex = 0;
            this.currentPenaltyTimeOffset = 0;
            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.TimerStart.getValue(), 0, null, getSharedViewModel().getGameState().getTimerTotalTime(), GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            getSharedViewModel().getGameState().setTimerStartTime(System.currentTimeMillis());
            MTGameEvent mTGameEvent = new MTGameEvent(null, MTEvent.TurnStart.getValue(), i, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
            getSharedViewModel().getGameState().getEvents().add(mTGameEvent);
            if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                if (i == 0 || i == 3) {
                    addEventIfNeeded(mTGameEvent, 0);
                    addEventIfNeeded(mTGameEvent, 3);
                } else {
                    addEventIfNeeded(mTGameEvent, 1);
                    addEventIfNeeded(mTGameEvent, 2);
                }
            }
            if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                if (i == 0 || i == 1 || i == 5) {
                    addEventIfNeeded(mTGameEvent, 0);
                    addEventIfNeeded(mTGameEvent, 1);
                    addEventIfNeeded(mTGameEvent, 5);
                } else {
                    addEventIfNeeded(mTGameEvent, 2);
                    addEventIfNeeded(mTGameEvent, 3);
                    addEventIfNeeded(mTGameEvent, 4);
                }
            }
            showClock();
            updateClock();
            Context context = getContext();
            if (context != null && !new PreferencesManager(context).getBoolean(PreferencesManager.AUTO_START_TIMER, true)) {
                toggleTimerPause();
            }
            showTurnCounterUI(getSharedViewModel().getGameState().getCurrentGameTurn());
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            new PreferencesManager(contextRequireContext).saveCurrentGame(getSharedViewModel().getGameState());
            this.lifeViews.get(i).setIsCurrentPlayerTurn(true, 0);
            if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                if (i == 0 || i == 3) {
                    LifeTotalView lifeTotalView = this.lifeViewTeam1;
                    if (lifeTotalView != null) {
                        lifeTotalView.setIsCurrentPlayerTurn(true, 0);
                    }
                } else {
                    LifeTotalView lifeTotalView2 = this.lifeViewTeam2;
                    if (lifeTotalView2 != null) {
                        lifeTotalView2.setIsCurrentPlayerTurn(true, 0);
                    }
                }
            }
            if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                if (i == 0 || i == 1 || i == 5) {
                    LifeTotalView lifeTotalView3 = this.lifeViewTeam1;
                    if (lifeTotalView3 != null) {
                        lifeTotalView3.setIsCurrentPlayerTurn(true, 0);
                    }
                } else {
                    LifeTotalView lifeTotalView4 = this.lifeViewTeam2;
                    if (lifeTotalView4 != null) {
                        lifeTotalView4.setIsCurrentPlayerTurn(true, 0);
                    }
                }
            }
            updateStreamingState$app_release();
        }
    }

    public final void playerTossSkipped() {
        final int i = 0;
        if (!getSharedViewModel().getGameState().getGameSyncable() || getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            if (!getSharedViewModel().getGameState().getTurnTimerEnabled() || getSharedViewModel().getGameState().getTurnTimerPromptDismissed()) {
                return;
            }
            int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
            while (i < numberOfPlayers) {
                this.lifeViews.get(i).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda133
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lifeViews.get(i).triggerPlayerStartQ();
                    }
                }, 350L);
                i++;
            }
            final LifeTotalView lifeTotalView = this.lifeViewTeam1;
            if (lifeTotalView != null) {
                lifeTotalView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda134
                    @Override // java.lang.Runnable
                    public final void run() {
                        lifeTotalView.triggerPlayerStartQ();
                    }
                }, 350L);
            }
            final LifeTotalView lifeTotalView2 = this.lifeViewTeam2;
            if (lifeTotalView2 != null) {
                lifeTotalView2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda135
                    @Override // java.lang.Runnable
                    public final void run() {
                        lifeTotalView2.triggerPlayerStartQ();
                    }
                }, 350L);
                return;
            }
            return;
        }
        if (getSharedViewModel().getGameState().getNumberOfPlayers() == 2) {
            this.lifeViews.get(0).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda129
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lifeViews.get(0).triggerPlayerStartQ();
                }
            }, 350L);
            return;
        }
        int numberOfPlayers2 = getSharedViewModel().getGameState().getNumberOfPlayers();
        while (i < numberOfPlayers2) {
            this.lifeViews.get(i).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda130
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lifeViews.get(i).triggerPlayerStartQ();
                }
            }, 350L);
            i++;
        }
        final LifeTotalView lifeTotalView3 = this.lifeViewTeam1;
        if (lifeTotalView3 != null) {
            lifeTotalView3.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda131
                @Override // java.lang.Runnable
                public final void run() {
                    lifeTotalView3.triggerPlayerStartQ();
                }
            }, 350L);
        }
        final LifeTotalView lifeTotalView4 = this.lifeViewTeam2;
        if (lifeTotalView4 != null) {
            lifeTotalView4.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda132
                @Override // java.lang.Runnable
                public final void run() {
                    lifeTotalView4.triggerPlayerStartQ();
                }
            }, 350L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v56, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v67, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v19, types: [T, java.lang.Object] */
    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void playgroupDeckSelected(LifeTotalView sender, MTDeck deck, int userId, boolean endOfGame) {
        boolean z;
        boolean z2;
        String str;
        int i;
        int i2;
        Boolean overridePlaymats;
        boolean z3;
        CharSequence charSequence;
        boolean z4;
        String str2;
        int i3;
        Player player;
        String str3;
        int i4;
        Player player2;
        Boolean overridePlaymats2;
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(deck, "deck");
        if (getContext() == null) {
            return;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        int size = this.lifeViews.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i5))) {
                intRef.element = i5;
                break;
            }
            i5++;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).saveGameSelectedDeck(deck);
        final Map<Integer, Player> map = this.seatedPlayers;
        if (map == null) {
            getSharedViewModel().getGameState().getPlayers().get(intRef.element).setDeckId(deck.getId());
            SkinManager companion = SkinManager.INSTANCE.getInstance();
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            SkinDefinition currentSkinDefinition = companion.getCurrentSkinDefinition(contextRequireContext2);
            if (currentSkinDefinition == null || (overridePlaymats = currentSkinDefinition.getOverridePlaymats()) == null) {
                z = true;
            } else {
                z = !overridePlaymats.booleanValue();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            String rightplaymat = deck.getRightplaymat();
            if (rightplaymat != null) {
                if (StringsKt.startsWith$default(rightplaymat, "id:", false, 2, (Object) null) && z) {
                    String strSubstring = rightplaymat.substring(3);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    String str4 = strSubstring;
                    z2 = z;
                    if (StringsKt.contains$default((CharSequence) str4, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                        List listSplit$default = StringsKt.split$default((CharSequence) str4, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                        String str5 = (String) listSplit$default.get(0);
                        i2 = Integer.parseInt((String) listSplit$default.get(1));
                        strSubstring = str5;
                    } else {
                        i2 = 0;
                    }
                    GameUtils companion2 = GameUtils.INSTANCE.getInstance();
                    Context contextRequireContext3 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                    CardRecord cardLocal = companion2.getCardLocal(contextRequireContext3, strSubstring, i2);
                    if (cardLocal != null) {
                        String strTranslateTag = SearchDataUtils.INSTANCE.getInstance().translateTag("planeswalker", cardLocal.getLang());
                        String lowerCase = cardLocal.getType_line().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) strTranslateTag, false, 2, (Object) null)) {
                            getSharedViewModel().getGameState().getPlayers().get(intRef.element).setPlaneswalker(true);
                        }
                        Unit unit3 = Unit.INSTANCE;
                        Unit unit4 = Unit.INSTANCE;
                    }
                    getSharedViewModel().getGameState().getPlayers().get(intRef.element).setBackgroundType(BackgroundType.SCRYFALL_ID);
                    getSharedViewModel().getGameState().getPlayers().get(intRef.element).setScryfallId(strSubstring + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + i2);
                } else {
                    z2 = z;
                }
                Unit unit5 = Unit.INSTANCE;
            } else {
                z2 = z;
                getSharedViewModel().getGameState().getPlayers().get(intRef.element).setPlaneswalker(false);
                getSharedViewModel().getGameState().getPlayers().get(intRef.element).setBackgroundType(BackgroundType.NONE);
                getSharedViewModel().getGameState().getPlayers().get(intRef.element).setScryfallId("");
                Unit unit6 = Unit.INSTANCE;
            }
            String leftplaymat = deck.getLeftplaymat();
            if (leftplaymat != null) {
                if (StringsKt.startsWith$default(leftplaymat, "id:", false, 2, (Object) null) && z2) {
                    String strSubstring2 = leftplaymat.substring(3);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    String str6 = strSubstring2;
                    if (StringsKt.contains$default((CharSequence) str6, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                        List listSplit$default2 = StringsKt.split$default((CharSequence) str6, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                        str = (String) listSplit$default2.get(0);
                        i = Integer.parseInt((String) listSplit$default2.get(1));
                    } else {
                        str = strSubstring2;
                        i = 0;
                    }
                    GameUtils companion3 = GameUtils.INSTANCE.getInstance();
                    Context contextRequireContext4 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                    CardRecord cardLocal2 = companion3.getCardLocal(contextRequireContext4, str, i);
                    if (cardLocal2 != null) {
                        String strTranslateTag2 = SearchDataUtils.INSTANCE.getInstance().translateTag("planeswalker", cardLocal2.getLang());
                        String lowerCase2 = cardLocal2.getType_line().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) strTranslateTag2, false, 2, (Object) null)) {
                            getSharedViewModel().getGameState().getPlayers().get(intRef.element).setLeftIsPlaneswalker(true);
                        }
                        Unit unit7 = Unit.INSTANCE;
                        Unit unit8 = Unit.INSTANCE;
                    }
                    getSharedViewModel().getGameState().getPlayers().get(intRef.element).setLeftBackgroundType(BackgroundType.SCRYFALL_ID);
                    getSharedViewModel().getGameState().getPlayers().get(intRef.element).setLeftScryfallId(str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + i);
                }
                Unit unit9 = Unit.INSTANCE;
            } else {
                getSharedViewModel().getGameState().getPlayers().get(intRef.element).setLeftIsPlaneswalker(false);
                getSharedViewModel().getGameState().getPlayers().get(intRef.element).setLeftBackgroundType(BackgroundType.NONE);
                getSharedViewModel().getGameState().getPlayers().get(intRef.element).setLeftScryfallId("");
                Unit unit10 = Unit.INSTANCE;
            }
            getSharedViewModel().getGameState().getPlayers().get(intRef.element).setHasPartners(false);
            this.lifeViews.get(intRef.element).hasPartners(false);
            ?? partner = deck.getPartner();
            if (partner != 0) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = partner;
                final Ref.IntRef intRef2 = new Ref.IntRef();
                CharSequence charSequence2 = (CharSequence) partner;
                if (StringsKt.contains$default(charSequence2, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                    List listSplit$default3 = StringsKt.split$default(charSequence2, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                    objectRef.element = listSplit$default3.get(0);
                    intRef2.element = Integer.parseInt((String) listSplit$default3.get(1));
                }
                MTGDBHelper.Companion companion4 = MTGDBHelper.INSTANCE;
                Context contextRequireContext5 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
                final MTGDBHelper companion5 = companion4.getInstance(contextRequireContext5);
                CardRecord cardByScryFallId = companion5.getCardByScryFallId((String) objectRef.element, intRef2.element);
                if (cardByScryFallId != null) {
                    String lowerCase3 = cardByScryFallId.getType_line().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "creature", false, 2, (Object) null)) {
                        getSharedViewModel().getGameState().getPlayers().get(intRef.element).setHasPartners(true);
                        this.lifeViews.get(intRef.element).hasPartners(true);
                    }
                    Unit unit11 = Unit.INSTANCE;
                    Unit unit12 = Unit.INSTANCE;
                } else {
                    new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda98
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GameFragmentBase.playgroupDeckSelected$lambda$1$5$1(this.f$0, companion5, objectRef, intRef2, intRef);
                        }
                    };
                }
            }
            this.lifeViews.get(intRef.element).setDeckData(deck);
            this.lifeViews.get(intRef.element).updatePlayer(getSharedViewModel().getGameState().getPlayers().get(intRef.element));
            if (!getSharedViewModel().getGameState().getDecksSelected()) {
                checkIfGameIsReady();
            }
            Unit unit13 = Unit.INSTANCE;
            return;
        }
        Player player3 = map.get(Integer.valueOf(intRef.element));
        if (player3 != null) {
            player3.setDeckId(deck.getId());
            Unit unit14 = Unit.INSTANCE;
        }
        SkinManager companion6 = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext6 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext6, "requireContext(...)");
        SkinDefinition currentSkinDefinition2 = companion6.getCurrentSkinDefinition(contextRequireContext6);
        if (currentSkinDefinition2 == null || (overridePlaymats2 = currentSkinDefinition2.getOverridePlaymats()) == null) {
            z3 = true;
        } else {
            z3 = !overridePlaymats2.booleanValue();
            Unit unit15 = Unit.INSTANCE;
            Unit unit16 = Unit.INSTANCE;
        }
        String rightplaymat2 = deck.getRightplaymat();
        if (rightplaymat2 != null) {
            charSequence = "creature";
            if (StringsKt.startsWith$default(rightplaymat2, "id:", false, 2, (Object) null) && z3) {
                String strSubstring3 = rightplaymat2.substring(3);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                String str7 = strSubstring3;
                z4 = z3;
                if (StringsKt.contains$default((CharSequence) str7, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                    List listSplit$default4 = StringsKt.split$default((CharSequence) str7, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                    str3 = (String) listSplit$default4.get(0);
                    i4 = Integer.parseInt((String) listSplit$default4.get(1));
                } else {
                    str3 = strSubstring3;
                    i4 = 0;
                }
                GameUtils companion7 = GameUtils.INSTANCE.getInstance();
                Context contextRequireContext7 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext7, "requireContext(...)");
                CardRecord cardLocal3 = companion7.getCardLocal(contextRequireContext7, str3, i4);
                if (cardLocal3 != null) {
                    String strTranslateTag3 = SearchDataUtils.INSTANCE.getInstance().translateTag("planeswalker", cardLocal3.getLang());
                    String lowerCase4 = cardLocal3.getType_line().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) strTranslateTag3, false, 2, (Object) null) && (player2 = map.get(Integer.valueOf(intRef.element))) != null) {
                        player2.setPlaneswalker(true);
                        Unit unit17 = Unit.INSTANCE;
                    }
                    Unit unit18 = Unit.INSTANCE;
                    Unit unit19 = Unit.INSTANCE;
                }
                Player player4 = map.get(Integer.valueOf(intRef.element));
                if (player4 != null) {
                    player4.setBackgroundType(BackgroundType.SCRYFALL_ID);
                    Unit unit20 = Unit.INSTANCE;
                }
                Player player5 = map.get(Integer.valueOf(intRef.element));
                if (player5 != null) {
                    player5.setScryfallId(str3 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + i4);
                    Unit unit21 = Unit.INSTANCE;
                }
            } else {
                z4 = z3;
            }
            Unit unit22 = Unit.INSTANCE;
        } else {
            charSequence = "creature";
            z4 = z3;
            Player player6 = map.get(Integer.valueOf(intRef.element));
            if (player6 != null) {
                player6.setPlaneswalker(false);
                Unit unit23 = Unit.INSTANCE;
            }
            Player player7 = map.get(Integer.valueOf(intRef.element));
            if (player7 != null) {
                player7.setBackgroundType(BackgroundType.NONE);
                Unit unit24 = Unit.INSTANCE;
            }
            Player player8 = map.get(Integer.valueOf(intRef.element));
            if (player8 != null) {
                player8.setScryfallId("");
                Unit unit25 = Unit.INSTANCE;
            }
            Unit unit26 = Unit.INSTANCE;
        }
        String leftplaymat2 = deck.getLeftplaymat();
        if (leftplaymat2 != null) {
            if (StringsKt.startsWith$default(leftplaymat2, "id:", false, 2, (Object) null) && z4) {
                String strSubstring4 = leftplaymat2.substring(3);
                Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                String str8 = strSubstring4;
                if (StringsKt.contains$default((CharSequence) str8, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                    List listSplit$default5 = StringsKt.split$default((CharSequence) str8, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                    str2 = (String) listSplit$default5.get(0);
                    i3 = Integer.parseInt((String) listSplit$default5.get(1));
                } else {
                    str2 = strSubstring4;
                    i3 = 0;
                }
                GameUtils companion8 = GameUtils.INSTANCE.getInstance();
                Context contextRequireContext8 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext8, "requireContext(...)");
                CardRecord cardLocal4 = companion8.getCardLocal(contextRequireContext8, str2, i3);
                if (cardLocal4 != null) {
                    String strTranslateTag4 = SearchDataUtils.INSTANCE.getInstance().translateTag("planeswalker", cardLocal4.getLang());
                    String lowerCase5 = cardLocal4.getType_line().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) strTranslateTag4, false, 2, (Object) null) && (player = map.get(Integer.valueOf(intRef.element))) != null) {
                        player.setLeftIsPlaneswalker(true);
                        Unit unit27 = Unit.INSTANCE;
                    }
                    Unit unit28 = Unit.INSTANCE;
                    Unit unit29 = Unit.INSTANCE;
                }
                Player player9 = map.get(Integer.valueOf(intRef.element));
                if (player9 != null) {
                    player9.setLeftBackgroundType(BackgroundType.SCRYFALL_ID);
                    Unit unit30 = Unit.INSTANCE;
                }
                Player player10 = map.get(Integer.valueOf(intRef.element));
                if (player10 != null) {
                    player10.setLeftScryfallId(str2 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + i3);
                    Unit unit31 = Unit.INSTANCE;
                }
            }
            Unit unit32 = Unit.INSTANCE;
        } else {
            Player player11 = map.get(Integer.valueOf(intRef.element));
            if (player11 != null) {
                player11.setLeftIsPlaneswalker(false);
                Unit unit33 = Unit.INSTANCE;
            }
            Player player12 = map.get(Integer.valueOf(intRef.element));
            if (player12 != null) {
                player12.setLeftBackgroundType(BackgroundType.NONE);
                Unit unit34 = Unit.INSTANCE;
            }
            Player player13 = map.get(Integer.valueOf(intRef.element));
            if (player13 != null) {
                player13.setLeftScryfallId("");
                Unit unit35 = Unit.INSTANCE;
            }
            Unit unit36 = Unit.INSTANCE;
        }
        Player player14 = map.get(Integer.valueOf(intRef.element));
        if (player14 != null) {
            player14.setHasPartners(false);
            Unit unit37 = Unit.INSTANCE;
        }
        this.lifeViews.get(intRef.element).hasPartners(false);
        ?? partner2 = deck.getPartner();
        if (partner2 != 0) {
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = partner2;
            final Ref.IntRef intRef3 = new Ref.IntRef();
            CharSequence charSequence3 = (CharSequence) partner2;
            if (StringsKt.contains$default(charSequence3, (CharSequence) Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
                List listSplit$default6 = StringsKt.split$default(charSequence3, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
                objectRef2.element = listSplit$default6.get(0);
                intRef3.element = Integer.parseInt((String) listSplit$default6.get(1));
            }
            MTGDBHelper.Companion companion9 = MTGDBHelper.INSTANCE;
            Context contextRequireContext9 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext9, "requireContext(...)");
            final MTGDBHelper companion10 = companion9.getInstance(contextRequireContext9);
            CardRecord cardByScryFallId2 = companion10.getCardByScryFallId((String) objectRef2.element, intRef3.element);
            if (cardByScryFallId2 != null) {
                String lowerCase6 = cardByScryFallId2.getType_line().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase6, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase6, charSequence, false, 2, (Object) null)) {
                    Player player15 = map.get(Integer.valueOf(intRef.element));
                    if (player15 != null) {
                        player15.setHasPartners(true);
                        Unit unit38 = Unit.INSTANCE;
                    }
                    this.lifeViews.get(intRef.element).hasPartners(true);
                }
                Unit unit39 = Unit.INSTANCE;
                Unit unit40 = Unit.INSTANCE;
            } else {
                new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda97
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GameFragmentBase.playgroupDeckSelected$lambda$0$5$1(this.f$0, companion10, objectRef2, intRef3, map, intRef);
                    }
                };
                map = map;
                intRef = intRef;
            }
        }
        this.lifeViews.get(intRef.element).setDeckData(deck);
        Player player16 = map.get(Integer.valueOf(intRef.element));
        if (player16 != null) {
            this.lifeViews.get(intRef.element).updatePlayer(player16);
            Unit unit41 = Unit.INSTANCE;
            Unit unit42 = Unit.INSTANCE;
        }
        checkIfGameIsReady();
        Unit unit43 = Unit.INSTANCE;
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void playgroupUserSelected(LifeTotalView sender, MTUser user, int previousUserId) {
        List<LifeTotalView> list;
        Object obj;
        Object next;
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(user, "user");
        if (getContext() == null) {
            return;
        }
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = 0;
                break;
            } else if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                break;
            } else {
                i++;
            }
        }
        List<MTUser> unseatedUsers = GameUtils.INSTANCE.getInstance().getUnseatedUsers();
        unseatedUsers.remove(user);
        if (previousUserId > 0) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            Iterator<T> it = new PreferencesManager(contextRequireContext).getCurrentUserPlaygroups().iterator();
            while (true) {
                obj = null;
                if (it.hasNext()) {
                    next = it.next();
                    if (((MTPlaygroup) next).getId() == getSharedViewModel().getGameState().getPlaygroupId()) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            MTPlaygroup mTPlaygroup = (MTPlaygroup) next;
            if (mTPlaygroup != null) {
                Iterator<T> it2 = mTPlaygroup.getUsers().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    if (((MTUser) next2).getId() == previousUserId) {
                        obj = next2;
                        break;
                    }
                }
                MTUser mTUser = (MTUser) obj;
                if (mTUser != null) {
                    List<MTUser> list2 = unseatedUsers;
                    if ((list2 instanceof Collection) && list2.isEmpty()) {
                        unseatedUsers.add(mTUser);
                    } else {
                        Iterator<T> it3 = list2.iterator();
                        while (it3.hasNext()) {
                            if (((MTUser) it3.next()).getId() == mTUser.getId()) {
                                break;
                            }
                        }
                        unseatedUsers.add(mTUser);
                    }
                }
            }
        }
        int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
        int i2 = 0;
        while (true) {
            list = this.lifeViews;
            if (i2 >= numberOfPlayers) {
                break;
            }
            list.get(i2).refreshUsersAdapter();
            i2++;
        }
        list.get(i).setUserData(user, getSharedViewModel().getGameState().getFormatId());
        this.lifeViews.get(i).showUserAndDecks();
        if (this.seatedUsers == null) {
            this.seatedUsers = new LinkedHashMap();
        }
        Map<Integer, MTUser> map = this.seatedUsers;
        if (map != null) {
            map.put(Integer.valueOf(i), user);
        }
        if (this.seatedPlayers == null) {
            this.seatedPlayers = new LinkedHashMap();
        }
        Map<Integer, Player> map2 = this.seatedPlayers;
        if (map2 != null) {
            int numberOfPlayers2 = getSharedViewModel().getGameState().getNumberOfPlayers();
            Player player = new Player(null, null, 0, 0, 0, 0, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, 0, 0, null, null, false, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, 0, -1, 8191, null);
            String firstname = user.getFirstname();
            if (firstname == null) {
                firstname = getResources().getString(R.string.player) + " " + (i + 1);
            }
            player.setName(firstname);
            ArrayList arrayList = new ArrayList(numberOfPlayers2);
            for (int i3 = 0; i3 < numberOfPlayers2; i3++) {
                arrayList.add(0);
            }
            player.setCommanderDamageList(arrayList);
            ArrayList arrayList2 = new ArrayList(numberOfPlayers2);
            for (int i4 = 0; i4 < numberOfPlayers2; i4++) {
                arrayList2.add(0);
            }
            player.setCommanderDamageListPartner(arrayList2);
            player.setStartingLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
            player.setLifeTotal(getSharedViewModel().getGameState().getStartingLifeTotal());
            player.setUserId(user.getId());
            map2.put(Integer.valueOf(i), player);
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void playgroupUserUnselected(LifeTotalView sender, int currentUserId) {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getContext() == null) {
            return;
        }
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = 0;
                break;
            } else if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                break;
            } else {
                i++;
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        List<MTUser> unseatedUsers = GameUtils.INSTANCE.getInstance().getUnseatedUsers();
        if (currentUserId > 0) {
            Iterator<T> it = preferencesManager.getCurrentUserPlaygroups().iterator();
            while (true) {
                if (it.hasNext()) {
                    next3 = it.next();
                    if (((MTPlaygroup) next3).getId() == getSharedViewModel().getGameState().getPlaygroupId()) {
                        break;
                    }
                } else {
                    next3 = null;
                    break;
                }
            }
            MTPlaygroup mTPlaygroup = (MTPlaygroup) next3;
            if (mTPlaygroup != null) {
                Iterator<T> it2 = mTPlaygroup.getUsers().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        next4 = it2.next();
                        if (((MTUser) next4).getId() == currentUserId) {
                            break;
                        }
                    } else {
                        next4 = null;
                        break;
                    }
                }
                MTUser mTUser = (MTUser) next4;
                if (mTUser != null) {
                    List<MTUser> list = unseatedUsers;
                    if ((list instanceof Collection) && list.isEmpty()) {
                        unseatedUsers.add(mTUser);
                    } else {
                        Iterator<T> it3 = list.iterator();
                        while (it3.hasNext()) {
                            if (((MTUser) it3.next()).getId() == mTUser.getId()) {
                                break;
                            }
                        }
                        unseatedUsers.add(mTUser);
                    }
                }
            }
        }
        Map<Integer, MTUser> map = this.seatedUsers;
        if (map != null) {
            map.remove(Integer.valueOf(i));
            ArrayList arrayList = new ArrayList();
            if (getSharedViewModel().getGameState().getPlaygroupId() != -1) {
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                Iterator<T> it4 = new PreferencesManager(contextRequireContext2).getCurrentUserPlaygroups().iterator();
                while (true) {
                    if (it4.hasNext()) {
                        next = it4.next();
                        if (((MTPlaygroup) next).getId() == getSharedViewModel().getGameState().getPlaygroupId()) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                MTPlaygroup mTPlaygroup2 = (MTPlaygroup) next;
                if (mTPlaygroup2 != null) {
                    for (Player player : getSharedViewModel().getGameState().getPlayers()) {
                        Iterator<T> it5 = mTPlaygroup2.getUsers().iterator();
                        while (true) {
                            if (it5.hasNext()) {
                                next2 = it5.next();
                                if (((MTUser) next2).getId() == player.getUserId()) {
                                    break;
                                }
                            } else {
                                next2 = null;
                                break;
                            }
                        }
                        MTUser mTUser2 = (MTUser) next2;
                        if (mTUser2 != null) {
                            arrayList.add(mTUser2);
                        }
                    }
                }
            }
            int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
            for (int i2 = 0; i2 < numberOfPlayers; i2++) {
                this.lifeViews.get(i2).refreshUsersAdapter();
                if (i2 == i) {
                    this.lifeViews.get(i2).clearUserData();
                    LifeTotalView.showUserSelection$default(this.lifeViews.get(i2), true, null, arrayList, 2, null);
                }
            }
        }
        Map<Integer, Player> map2 = this.seatedPlayers;
        if (map2 != null) {
            map2.remove(Integer.valueOf(i));
        }
        checkIfGameIsReady();
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void playmatSelected(LifeTotalView sender, String id) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                playmatSelected(i, id);
                return;
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void poisonCounterTapped(LifeTotalView sender, int rotation) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        final Ref.IntRef intRef = new Ref.IntRef();
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                intRef.element = i;
                break;
            }
            i++;
        }
        if (intRef.element >= getSharedViewModel().getGameState().getPlayers().size()) {
            return;
        }
        final int poisonCounters = getSharedViewModel().getGameState().getPlayers().get(intRef.element).getPoisonCounters();
        this.lifeViews.get(intRef.element).showCountersDialog(CounterType.Poison, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda117
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameFragmentBase.poisonCounterTapped$lambda$0(this.f$0, intRef, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        }, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda118
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragmentBase.poisonCounterTapped$lambda$1(this.f$0, intRef, poisonCounters);
            }
        });
    }

    public void poisonCounterToggled(boolean isOn) {
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void poisonToggled(LifeTotalView sender, boolean newValue) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        getSharedViewModel().getGameState().setHasPoisonCounters(newValue);
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        enablePoisonCounters(newValue);
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void qrScanSelected(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getContext() == null) {
            return;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("qr_scan_from_game", null);
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = 0;
                break;
            } else if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                break;
            } else {
                i++;
            }
        }
        this.currentQRScanIndex = i;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (!preferencesManager.hasValidUser() || currentUser == null) {
            return;
        }
        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.CAMERA") == 0) {
            QRScanBottomSheetFragment.Companion.newInstance$default(QRScanBottomSheetFragment.INSTANCE, this, currentUser, false, 4, null).show(getChildFragmentManager(), QRScanBottomSheetFragment.TAG);
            return;
        }
        if (!preferencesManager.getBoolean(PreferencesManager.CAMERA_PERMISSION_ASKED_BEFORE, false)) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = getString(R.string.permissions_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = getString(R.string.camera_permission_rationale);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
            String string3 = getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda111
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GameFragmentBase.qrScanSelected$lambda$0$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string4 = getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda112
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragmentBase.qrScanSelected$lambda$0$1((CustomDialogFragment) obj);
                }
            });
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            negativeButton.show(childFragmentManager, "camera_permission_dialog");
            return;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.CAMERA")) {
            this.requestCameraPermissionLauncher.launch("android.permission.CAMERA");
            return;
        }
        CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
        String string5 = getString(R.string.permissions_title);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        CustomDialogFragment.Builder title2 = builder2.setTitle(string5);
        String string6 = getString(R.string.camera_permission_denied_message);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed2 = title2.setBody(string6).setPositiveButtonRed();
        String string7 = getString(R.string.open_settings);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        CustomDialogFragment.Builder positiveButton2 = positiveButtonRed2.setPositiveButton(string7, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda113
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameFragmentBase.qrScanSelected$lambda$0$2(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string8 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        CustomDialogFragment.Builder negativeButton2 = positiveButton2.setNegativeButton(string8, new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda114
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragmentBase.qrScanSelected$lambda$0$3((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        negativeButton2.show(childFragmentManager2, "camera_permission_settings_dialog");
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void radiationCounterTapped(LifeTotalView sender, int rotation) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        final Ref.IntRef intRef = new Ref.IntRef();
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                intRef.element = i;
                break;
            }
            i++;
        }
        if (intRef.element >= getSharedViewModel().getGameState().getPlayers().size()) {
            return;
        }
        final int radiationCount = getSharedViewModel().getGameState().getPlayers().get(intRef.element).getRadiationCount();
        this.lifeViews.get(intRef.element).showCountersDialog(CounterType.Radiation, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda119
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameFragmentBase.radiationCounterTapped$lambda$0(this.f$0, intRef, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        }, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda120
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragmentBase.radiationCounterTapped$lambda$1(this.f$0, intRef, radiationCount);
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void radiationToggled(LifeTotalView sender, boolean newValue) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                i = i2;
                break;
            }
            i2++;
        }
        getSharedViewModel().getGameState().getPlayers().get(i).setRadiationEnabled(newValue);
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        updateStreamingState$app_release();
    }

    public final void resetGame() {
        if (getSharedViewModel().getGameState().getNumberOfPlayers() == this.lifeViews.size() && getSharedViewModel().getGameState().getNumberOfPlayers() == getSharedViewModel().getGameState().getPlayers().size()) {
            int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
            for (int i = 0; i < numberOfPlayers; i++) {
                this.lifeViews.get(i).setStartTime(getSharedViewModel().getGameState().getTimerStartTime());
                this.lifeViews.get(i).setLifeTotal(getSharedViewModel().getGameState().getPlayers().get(i).getStartingLifeTotal());
                this.lifeViews.get(i).setPoisonCounters(0);
                this.lifeViews.get(i).setEnergyCounters(0);
                this.lifeViews.get(i).setStormCount(0);
                this.lifeViews.get(i).setRadiationCounters(0);
                this.lifeViews.get(i).setTaxCount(0);
                this.lifeViews.get(i).setTaxCountPartner(0);
                this.lifeViews.get(i).setExperienceCounters(0);
                this.lifeViews.get(i).setDisplayedCommanderDamage(0);
                this.lifeViews.get(i).fullReset();
                this.lifeViews.get(i).undoPlayerDeadQ();
                this.lifeViews.get(i).undoKO();
                this.lifeViews.get(i).undoDraw();
                this.lifeViews.get(i).undoWin();
                this.lifeViews.get(i).updatePlayer(getSharedViewModel().getGameState().getPlayers().get(i));
                this.lifeViews.get(i).refreshSettings();
                this.lifeViews.get(i).checkVitals();
                this.lifeViews.get(i).hideMonarchCoin();
                this.lifeViews.get(i).hideInitiativeCoin();
                this.lifeViews.get(i).hideCityCoin();
                this.lifeViews.get(i).showPoisonCounters(getSharedViewModel().getGameState().getHasPoisonCounters());
                this.lifeViews.get(i).hasPartners(getSharedViewModel().getGameState().getPlayers().get(i).getHasPartners());
                this.lifeViews.get(i).hasEnergy(getSharedViewModel().getGameState().getPlayers().get(i).getEnergyEnabled());
                this.lifeViews.get(i).hasStorm(getSharedViewModel().getGameState().getPlayers().get(i).getStormEnabled());
                this.lifeViews.get(i).hasExperience(getSharedViewModel().getGameState().getPlayers().get(i).getExperienceEnabled());
                this.lifeViews.get(i).hasTax(getSharedViewModel().getGameState().getPlayers().get(i).getTaxEnabled());
                this.lifeViews.get(i).hasRadiation(getSharedViewModel().getGameState().getPlayers().get(i).getRadiationEnabled());
                this.lifeViews.get(i).showCommanderDamage(getSharedViewModel().getGameState().getHasCommanderDamage());
                this.lifeViews.get(i).updateCountersLayout();
                this.lifeViews.get(i).hideUndoNextTurnUI();
                this.lifeViews.get(i).hideFirstTurnPrompt();
                this.lifeViews.get(i).setIsCurrentPlayerTurn(false, 0);
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void rightPicked(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                i = i2;
                break;
            }
            i2++;
        }
        if (this.currentPlaymatId.length() > 0) {
            getSharedViewModel().getGameState().getPlayers().get(i).setBackgroundType(BackgroundType.PLAYMAT);
            getSharedViewModel().getGameState().getPlayers().get(i).setPlaymatId(this.currentPlaymatId);
            Context context = getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
            }
            this.lifeViews.get(i).updatePlayer(getSharedViewModel().getGameState().getPlayers().get(i));
            this.currentPlaymatId = "";
        }
        Uri uri = this.currentPhotoUri;
        if (uri != null) {
            getSharedViewModel().getGameState().getPlayers().get(i).setBackgroundType(BackgroundType.PHOTO);
            Player player = getSharedViewModel().getGameState().getPlayers().get(i);
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            player.setPhotoUri(string);
            Context context2 = getContext();
            if (context2 != null) {
                new PreferencesManager(context2).saveCurrentGame(getSharedViewModel().getGameState());
            }
            this.lifeViews.get(i).updatePlayer(getSharedViewModel().getGameState().getPlayers().get(i));
            this.currentPhotoUri = null;
        }
        if (this.lastScanId.length() > 0) {
            getSharedViewModel().getGameState().getPlayers().get(i).setBackgroundType(BackgroundType.SCRYFALL_ID);
            getSharedViewModel().getGameState().getPlayers().get(i).setScryfallId(this.lastScanId);
            Context context3 = getContext();
            if (context3 != null) {
                new PreferencesManager(context3).saveCurrentGame(getSharedViewModel().getGameState());
            }
            this.lifeViews.get(i).updatePlayer(getSharedViewModel().getGameState().getPlayers().get(i));
            this.lastScanId = "";
        }
        if (this.currentColorHex.length() > 0) {
            getSharedViewModel().getGameState().getPlayers().get(i).setBackgroundType(BackgroundType.SOLID_COLOR);
            getSharedViewModel().getGameState().getPlayers().get(i).setBackgroundColor(this.currentColorHex);
            Context context4 = getContext();
            if (context4 != null) {
                new PreferencesManager(context4).saveCurrentGame(getSharedViewModel().getGameState());
            }
            this.lifeViews.get(i).updatePlayer(getSharedViewModel().getGameState().getPlayers().get(i));
            this.currentColorHex = "";
        }
    }

    public final void runPlayerToss(boolean gameStart) {
        PlayerToss customPlayerToss;
        final ConstraintLayout constraintLayout;
        if (getContext() == null) {
            return;
        }
        stopPlayerTossIntroLoop();
        SkinManager companion = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        SkinDefinition currentSkinDefinition = companion.getCurrentSkinDefinition(contextRequireContext);
        if (currentSkinDefinition != null && (customPlayerToss = currentSkinDefinition.getCustomPlayerToss()) != null && Intrinsics.areEqual(customPlayerToss.getType(), ClientData.KEY_CHALLENGE)) {
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            List<String> frChallenges = Intrinsics.areEqual(new PreferencesManager(contextRequireContext2).getDeviceLanguage(), "fr") ? customPlayerToss.getFrChallenges() : customPlayerToss.getEnChallenges();
            if (frChallenges.isEmpty()) {
                frChallenges = customPlayerToss.getEnChallenges();
            }
            List<String> list = frChallenges;
            if (!list.isEmpty()) {
                String str = (String) CollectionsKt.random(list, Random.INSTANCE);
                Iterator<LifeTotalView> it = this.lifeViews.iterator();
                while (it.hasNext()) {
                    it.next().showCustomMessage(str);
                }
                View view = getView();
                if (view == null || (constraintLayout = (ConstraintLayout) view.findViewById(R.id.constraintLayout)) == null) {
                    return;
                }
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                final TossButtonsView tossButtonsView = new TossButtonsView(contextRequireContext3, null, 0, 6, null);
                tossButtonsView.setElevation(300.0f);
                tossButtonsView.setCustomRotation((getSharedViewModel().getGameState().getPlayers().size() == 2 && (getSharedViewModel().getGameState().getLayoutType() == LayoutType.TYPE_1 || getSharedViewModel().getGameState().getLayoutType() == LayoutType.TYPE_3)) ? 0.0f : 90.0f);
                tossButtonsView.setOnRerollClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda93
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        GameFragmentBase.runPlayerToss$lambda$0$0$0$0(tossButtonsView, this, view2);
                    }
                });
                tossButtonsView.setOnDoneClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda95
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        GameFragmentBase.runPlayerToss$lambda$0$0$0$1(constraintLayout, tossButtonsView, this, view2);
                    }
                });
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
                layoutParams.startToStart = 0;
                layoutParams.endToEnd = 0;
                layoutParams.topToTop = 0;
                layoutParams.bottomToBottom = 0;
                constraintLayout.addView(tossButtonsView, layoutParams);
                hideClock();
                return;
            }
        }
        for (LifeTotalView lifeTotalView : this.lifeViews) {
            lifeTotalView.setUserInteractionEnabled(false);
            lifeTotalView.setCmdDamageDisabled(true);
            lifeTotalView.setSwipeDisabled(true);
        }
        this.currentStep = 0;
        this.currentHighlightIndex = 0;
        this.randomPlayerIndex = Random.INSTANCE.nextInt(getSharedViewModel().getGameState().getNumberOfPlayers());
        if (gameStart) {
            getSharedViewModel().getGameState().setStartingPlayerIndex(this.randomPlayerIndex);
            if (getSharedViewModel().getGameState().getNumberOfPlayers() > 2 || !getSharedViewModel().getGameState().getGameSyncable()) {
                getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), this.randomPlayerIndex, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                if (getSharedViewModel().getGameState().getSubformatId() == 5 && getSharedViewModel().getGameState().getNumberOfPlayers() == 4) {
                    int i = this.randomPlayerIndex;
                    if (i == 0) {
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 3, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    } else if (i == 1) {
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 2, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    } else if (i == 2) {
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 1, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    } else if (i == 3) {
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    }
                }
                if (getSharedViewModel().getGameState().getSubformatId() == 6 && getSharedViewModel().getGameState().getNumberOfPlayers() == 6) {
                    int i2 = this.randomPlayerIndex;
                    if (i2 == 0) {
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 1, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 5, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    } else if (i2 == 1) {
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 5, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    } else if (i2 == 2) {
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 3, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 4, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    } else if (i2 == 3) {
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 2, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 4, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    } else if (i2 == 4) {
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 2, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 3, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    } else if (i2 == 5) {
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerStart.getValue(), 1, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    }
                }
            }
            if (getSharedViewModel().getGameState().getGameSyncable() && getSharedViewModel().getGameState().getNumberOfPlayers() == 2) {
                this.lifeViews.get(this.randomPlayerIndex).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda96
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameFragmentBase.runPlayerToss$lambda$1(this.f$0);
                    }
                }, 4500L);
            }
        } else {
            getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerToss.getValue(), this.randomPlayerIndex, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
        }
        Context contextRequireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
        new PreferencesManager(contextRequireContext4).saveCurrentGame(getSharedViewModel().getGameState());
        updateStreamingState$app_release();
        if (this.isTossRunning) {
            return;
        }
        this.isTossRunning = true;
        highlightNextLifeView();
    }

    public final void runPlayerTossIntroLoop() {
        this.stopIntroLoop = false;
        this.currentHighlightIndex = 0;
        highlightNextLifeViewSimple();
    }

    public final void setCurrentCommanderDamageIndex(int i) {
        this.currentCommanderDamageIndex = i;
    }

    public final void setFragmentReadyListener(FragmentReadyListener fragmentReadyListener) {
        this.fragmentReadyListener = fragmentReadyListener;
    }

    public final void setLifeViewTeam1(LifeTotalView lifeTotalView) {
        this.lifeViewTeam1 = lifeTotalView;
    }

    public final void setLifeViewTeam2(LifeTotalView lifeTotalView) {
        this.lifeViewTeam2 = lifeTotalView;
    }

    public final void setLifeViews(List<LifeTotalView> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.lifeViews = list;
    }

    public final void setOnFragmentReadyListener(FragmentReadyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.fragmentReadyListener = listener;
    }

    public final void setShowSeconds(boolean z) {
        this.showSeconds = z;
    }

    public final void setTutorialMode(boolean z) {
        this.tutorialMode = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x07ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setupLifeViews() {
        MTPlaygroup mTPlaygroup;
        String string;
        String string2;
        Object next;
        GameUtils gameUtils;
        Object next2;
        Object next3;
        Object next4;
        Unit unit;
        Boolean overridePlaymats;
        List<String> playmats;
        Boolean overridePlaymats2;
        List<String> playmats2;
        boolean z;
        List<String> playmats3;
        Object next5;
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (getSharedViewModel().getGameState().getNumberOfPlayers() == this.lifeViews.size() && getSharedViewModel().getGameState().getNumberOfPlayers() == getSharedViewModel().getGameState().getPlayers().size()) {
            boolean firstSetupDone = getSharedViewModel().getGameState().getFirstSetupDone();
            if (!firstSetupDone) {
                getSharedViewModel().getGameState().setFirstSetupDone(true);
                preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
            }
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            updateStreamingState$app_release();
            if (getSharedViewModel().getGameState().getHasPlanechase()) {
                if ((getSharedViewModel().getGameState().getPlaygroupId() == -1 && !preferencesManager.hasValidUser()) || !getSharedViewModel().getGameState().getGameSyncable() || (getSharedViewModel().getGameState().getUsersSeated() && getSharedViewModel().getGameState().getDecksSelected())) {
                    enablePlanechase(true);
                }
                Context context = getContext();
                if (context != null) {
                    int iEnsurePlanarDeck = companion.ensurePlanarDeck(context, getSharedViewModel().getGameState());
                    if (getSharedViewModel().getGameState().getPlanechaseSeed() == 0) {
                        getSharedViewModel().getGameState().setPlanechaseSeed(iEnsurePlanarDeck);
                        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
                    }
                    Unit unit2 = Unit.INSTANCE;
                    Unit unit3 = Unit.INSTANCE;
                }
            }
            if (getSharedViewModel().getGameState().getHasArchenemy()) {
                if ((getSharedViewModel().getGameState().getPlaygroupId() == -1 && !preferencesManager.hasValidUser()) || !getSharedViewModel().getGameState().getGameSyncable() || (getSharedViewModel().getGameState().getUsersSeated() && getSharedViewModel().getGameState().getDecksSelected())) {
                    enableArchenemy(true);
                }
                Context context2 = getContext();
                if (context2 != null) {
                    int iEnsureSchemeDeck = companion.ensureSchemeDeck(context2, getSharedViewModel().getGameState());
                    if (getSharedViewModel().getGameState().getArchenemySeed() == 0) {
                        getSharedViewModel().getGameState().setArchenemySeed(iEnsureSchemeDeck);
                        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
                    }
                    Unit unit4 = Unit.INSTANCE;
                    Unit unit5 = Unit.INSTANCE;
                }
            }
            if (getSharedViewModel().getGameState().getPlaygroupId() != -1) {
                Iterator<T> it = preferencesManager.getCurrentUserPlaygroups().iterator();
                while (true) {
                    if (it.hasNext()) {
                        next5 = it.next();
                        if (((MTPlaygroup) next5).getId() == getSharedViewModel().getGameState().getPlaygroupId()) {
                            break;
                        }
                    } else {
                        next5 = null;
                        break;
                    }
                }
                mTPlaygroup = (MTPlaygroup) next5;
            } else {
                mTPlaygroup = null;
            }
            ArrayList arrayList = new ArrayList();
            PlaymatCategory playmatCategoryPickRandomCategory = companion.pickRandomCategory();
            int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
            int i = 0;
            while (i < numberOfPlayers) {
                GameUtils gameUtils2 = companion;
                this.lifeViews.get(i).setStartTime(getSharedViewModel().getGameState().getTimerStartTime());
                this.lifeViews.get(i).setCallback(this);
                this.lifeViews.get(i).setLifeTotal(getSharedViewModel().getGameState().getPlayers().get(i).getLifeTotal());
                this.lifeViews.get(i).setPoisonCounters(getSharedViewModel().getGameState().getPlayers().get(i).getPoisonCounters());
                LifeTotalView lifeTotalView = this.lifeViews.get(i);
                ActivityResultLauncher<Intent> activityResultLauncher = this.pickCardLauncher;
                if (activityResultLauncher == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickCardLauncher");
                    activityResultLauncher = null;
                }
                lifeTotalView.setPickCardLauncher(activityResultLauncher);
                LifeTotalView lifeTotalView2 = this.lifeViews.get(i);
                ActivityResultLauncher<Intent> activityResultLauncher2 = this.pickPhotoLauncher;
                if (activityResultLauncher2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickPhotoLauncher");
                    activityResultLauncher2 = null;
                }
                lifeTotalView2.setPickPhotoLauncher(activityResultLauncher2);
                LifeTotalView lifeTotalView3 = this.lifeViews.get(i);
                ActivityResultLauncher<Intent> activityResultLauncher3 = this.purchaseLauncher;
                if (activityResultLauncher3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("purchaseLauncher");
                    activityResultLauncher3 = null;
                }
                lifeTotalView3.setPurchaseLauncher(activityResultLauncher3);
                this.lifeViews.get(i).setDisplayedCommanderDamage(commanderDamageValueToShowFor(i));
                this.lifeViews.get(i).showPoisonCounters(getSharedViewModel().getGameState().getHasPoisonCounters());
                this.lifeViews.get(i).showCommanderDamage(getSharedViewModel().getGameState().getHasCommanderDamage());
                this.lifeViews.get(i).hasPartners(getSharedViewModel().getGameState().getPlayers().get(i).getHasPartners());
                this.lifeViews.get(i).hasEnergy(getSharedViewModel().getGameState().getPlayers().get(i).getEnergyEnabled());
                this.lifeViews.get(i).hasStorm(getSharedViewModel().getGameState().getPlayers().get(i).getStormEnabled());
                this.lifeViews.get(i).hasExperience(getSharedViewModel().getGameState().getPlayers().get(i).getExperienceEnabled());
                this.lifeViews.get(i).hasTax(getSharedViewModel().getGameState().getPlayers().get(i).getTaxEnabled());
                this.lifeViews.get(i).hasRadiation(getSharedViewModel().getGameState().getPlayers().get(i).getRadiationEnabled());
                this.lifeViews.get(i).refreshSettings();
                this.lifeViews.get(i).setPlainBackgroundColor(gameUtils2.getDefaultColors().get(i).intValue());
                this.lifeViews.get(i).updateCountersLayout();
                if (getContext() != null) {
                    String string3 = preferencesManager.getString(PreferencesManager.BACKGROUND_BY_DEFAULT, PreferencesManager.BACKGROUND_PLAYMAT);
                    if (Intrinsics.areEqual(string3, PreferencesManager.BACKGROUND_PLAYMAT) && !firstSetupDone && getSharedViewModel().getGameState().getPlayers().get(i).getBackgroundType() == BackgroundType.PLAIN_COLOR) {
                        getSharedViewModel().getGameState().getPlayers().get(i).setBackgroundType(BackgroundType.PLAYMAT);
                        SkinManager companion2 = SkinManager.INSTANCE.getInstance();
                        Context contextRequireContext2 = requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        String currentSkinCode = companion2.getCurrentSkinCode(contextRequireContext2);
                        SkinManager companion3 = SkinManager.INSTANCE.getInstance();
                        Context contextRequireContext3 = requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                        SkinDefinition currentSkinDefinition = companion3.getCurrentSkinDefinition(contextRequireContext3);
                        if (currentSkinDefinition == null || (playmats3 = currentSkinDefinition.getPlaymats()) == null) {
                            z = true;
                        } else {
                            if (playmats3.isEmpty()) {
                                z = true;
                            } else {
                                String strRandomPlaymatFromSkin = GameUtils.INSTANCE.getInstance().randomPlaymatFromSkin(playmats3, arrayList);
                                getSharedViewModel().getGameState().getPlayers().get(i).setPlaymatId(currentSkinCode + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + strRandomPlaymatFromSkin);
                                arrayList.add(strRandomPlaymatFromSkin);
                                z = false;
                            }
                            Unit unit6 = Unit.INSTANCE;
                            Unit unit7 = Unit.INSTANCE;
                        }
                        if (z) {
                            gameUtils = gameUtils2;
                            getSharedViewModel().getGameState().getPlayers().get(i).setPlaymatId(gameUtils.randomPlaymat(playmatCategoryPickRandomCategory, arrayList));
                            arrayList.add(getSharedViewModel().getGameState().getPlayers().get(i).getPlaymatId());
                        } else {
                            gameUtils = gameUtils2;
                        }
                        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
                    } else {
                        gameUtils = gameUtils2;
                    }
                    if (Intrinsics.areEqual(string3, "color") && !firstSetupDone) {
                        SkinManager companion4 = SkinManager.INSTANCE.getInstance();
                        Context contextRequireContext4 = requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                        String currentSkinCode2 = companion4.getCurrentSkinCode(contextRequireContext4);
                        SkinManager companion5 = SkinManager.INSTANCE.getInstance();
                        Context contextRequireContext5 = requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
                        SkinDefinition currentSkinDefinition2 = companion5.getCurrentSkinDefinition(contextRequireContext5);
                        if (currentSkinDefinition2 != null && (overridePlaymats2 = currentSkinDefinition2.getOverridePlaymats()) != null) {
                            if (overridePlaymats2.booleanValue() && (playmats2 = currentSkinDefinition2.getPlaymats()) != null) {
                                if (!playmats2.isEmpty()) {
                                    String strRandomPlaymatFromSkin2 = GameUtils.INSTANCE.getInstance().randomPlaymatFromSkin(playmats2, arrayList);
                                    getSharedViewModel().getGameState().getPlayers().get(i).setPlaymatId(currentSkinCode2 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + strRandomPlaymatFromSkin2);
                                    getSharedViewModel().getGameState().getPlayers().get(i).setBackgroundType(BackgroundType.PLAYMAT);
                                    arrayList.add(strRandomPlaymatFromSkin2);
                                }
                                Unit unit8 = Unit.INSTANCE;
                                Unit unit9 = Unit.INSTANCE;
                            }
                            Unit unit10 = Unit.INSTANCE;
                            Unit unit11 = Unit.INSTANCE;
                        }
                    }
                    if (Intrinsics.areEqual(string3, PreferencesManager.BACKGROUND_BLACK) && !firstSetupDone) {
                        if (getSharedViewModel().getGameState().getPlayers().get(i).getBackgroundType() == BackgroundType.PLAIN_COLOR) {
                            getSharedViewModel().getGameState().getPlayers().get(i).setBackgroundType(BackgroundType.BLACK);
                        }
                        SkinManager companion6 = SkinManager.INSTANCE.getInstance();
                        Context contextRequireContext6 = requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext6, "requireContext(...)");
                        String currentSkinCode3 = companion6.getCurrentSkinCode(contextRequireContext6);
                        SkinManager companion7 = SkinManager.INSTANCE.getInstance();
                        Context contextRequireContext7 = requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext7, "requireContext(...)");
                        SkinDefinition currentSkinDefinition3 = companion7.getCurrentSkinDefinition(contextRequireContext7);
                        if (currentSkinDefinition3 != null && (overridePlaymats = currentSkinDefinition3.getOverridePlaymats()) != null) {
                            if (overridePlaymats.booleanValue() && (playmats = currentSkinDefinition3.getPlaymats()) != null) {
                                if (!playmats.isEmpty()) {
                                    String strRandomPlaymatFromSkin3 = GameUtils.INSTANCE.getInstance().randomPlaymatFromSkin(playmats, arrayList);
                                    getSharedViewModel().getGameState().getPlayers().get(i).setPlaymatId(currentSkinCode3 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + strRandomPlaymatFromSkin3);
                                    getSharedViewModel().getGameState().getPlayers().get(i).setBackgroundType(BackgroundType.PLAYMAT);
                                    arrayList.add(strRandomPlaymatFromSkin3);
                                }
                                Unit unit12 = Unit.INSTANCE;
                                Unit unit13 = Unit.INSTANCE;
                            }
                            Unit unit14 = Unit.INSTANCE;
                            Unit unit15 = Unit.INSTANCE;
                        }
                    }
                    Unit unit16 = Unit.INSTANCE;
                    Unit unit17 = Unit.INSTANCE;
                } else {
                    gameUtils = gameUtils2;
                }
                this.lifeViews.get(i).updatePlayer(getSharedViewModel().getGameState().getPlayers().get(i));
                this.lifeViews.get(i).setEnergyCounters(getSharedViewModel().getGameState().getPlayers().get(i).getEnergyCounters());
                this.lifeViews.get(i).setStormCount(getSharedViewModel().getGameState().getPlayers().get(i).getStormCount());
                this.lifeViews.get(i).setTaxCount(getSharedViewModel().getGameState().getPlayers().get(i).getTaxCount());
                this.lifeViews.get(i).setTaxCountPartner(getSharedViewModel().getGameState().getPlayers().get(i).getTaxCountPartner());
                this.lifeViews.get(i).setExperienceCounters(getSharedViewModel().getGameState().getPlayers().get(i).getExperienceCount());
                this.lifeViews.get(i).setRadiationCounters(getSharedViewModel().getGameState().getPlayers().get(i).getRadiationCount());
                if (getSharedViewModel().getGameState().getUsersSeated()) {
                    if (mTPlaygroup != null) {
                        Iterator<T> it2 = mTPlaygroup.getUsers().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                next4 = it2.next();
                                if (((MTUser) next4).getId() == getSharedViewModel().getGameState().getPlayers().get(i).getUserId()) {
                                    break;
                                }
                            } else {
                                next4 = null;
                                break;
                            }
                        }
                        MTUser mTUser = (MTUser) next4;
                        if (mTUser != null) {
                            this.lifeViews.get(i).setUserData(mTUser, getSharedViewModel().getGameState().getFormatId());
                            if (getSharedViewModel().getGameState().getPlayers().get(i).getDeckId() > 0) {
                                this.lifeViews.get(i).setCurrentDeckId(getSharedViewModel().getGameState().getPlayers().get(i).getDeckId());
                            }
                            Unit unit18 = Unit.INSTANCE;
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            if (currentUser != null) {
                                if (currentUser.getId() == getSharedViewModel().getGameState().getPlayers().get(i).getUserId()) {
                                    this.lifeViews.get(i).setUserData(currentUser, getSharedViewModel().getGameState().getFormatId());
                                    if (getSharedViewModel().getGameState().getPlayers().get(i).getDeckId() > 0) {
                                        this.lifeViews.get(i).setCurrentDeckId(getSharedViewModel().getGameState().getPlayers().get(i).getDeckId());
                                    }
                                    Unit unit19 = Unit.INSTANCE;
                                } else {
                                    Iterator<T> it3 = preferencesManager.getCurrentUserFriends().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            next3 = it3.next();
                                            if (((MTFriend) next3).getId() == getSharedViewModel().getGameState().getPlayers().get(i).getUserId()) {
                                                break;
                                            }
                                        } else {
                                            next3 = null;
                                            break;
                                        }
                                    }
                                    MTFriend mTFriend = (MTFriend) next3;
                                    if (mTFriend != null) {
                                        this.lifeViews.get(i).setUserData(new MTUser(false, mTFriend.getId(), mTFriend.getFirstname(), mTFriend.getEmail(), mTFriend.getUsername(), mTFriend.getPicture(), null, null, null, null, 961, null), getSharedViewModel().getGameState().getFormatId());
                                        if (getSharedViewModel().getGameState().getPlayers().get(i).getDeckId() > 0) {
                                            this.lifeViews.get(i).setCurrentDeckId(getSharedViewModel().getGameState().getPlayers().get(i).getDeckId());
                                        }
                                        Unit unit20 = Unit.INSTANCE;
                                        Unit unit21 = Unit.INSTANCE;
                                    }
                                }
                            }
                        }
                    }
                }
                if (getSharedViewModel().getGameState().getSubformatId() == 3) {
                    Iterator<T> it4 = getSharedViewModel().getGameState().getEvents().iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it4.next();
                        MTGameEvent mTGameEvent = (MTGameEvent) next2;
                        if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TreacheryRole.getValue()) && mTGameEvent.getPlayerid() == i) {
                            break;
                        }
                    }
                    MTGameEvent mTGameEvent2 = (MTGameEvent) next2;
                    if (mTGameEvent2 != null) {
                        this.lifeViews.get(i).showTreacheryRole(mTGameEvent2.getValue());
                        Unit unit22 = Unit.INSTANCE;
                    } else {
                        this.lifeViews.get(i).showTreacheryRole(-1);
                        Unit unit23 = Unit.INSTANCE;
                    }
                } else {
                    this.lifeViews.get(i).hideTreacheryRole();
                }
                if (getSharedViewModel().getGameState().getPlayers().get(i).getMonarch()) {
                    this.lifeViews.get(i).showMonarchCoin();
                }
                if (getSharedViewModel().getGameState().getPlayers().get(i).getCityBlessing()) {
                    this.lifeViews.get(i).showCityCoin();
                }
                if (getSharedViewModel().getGameState().getPlayers().get(i).getTheRing()) {
                    this.lifeViews.get(i).showTheRingCoin();
                }
                if (getSharedViewModel().getGameState().getPlayers().get(i).getInitiative()) {
                    this.lifeViews.get(i).showInitiativeCoin();
                }
                boolean zIsKO = getSharedViewModel().getGameState().getPlayers().get(i).isKO();
                List<LifeTotalView> list = this.lifeViews;
                if (zIsKO) {
                    list.get(i).triggerPlayerKO();
                } else {
                    list.get(i).checkVitals();
                }
                i++;
                companion = gameUtils;
            }
            getSharedViewModel().getGameState().getSubformatId();
            if (getSharedViewModel().getGameState().getPlaygroupId() == -1) {
                if (preferencesManager.hasValidUser() && !this.tutorialMode && getSharedViewModel().getGameState().getGameSyncable()) {
                    GameUtils companion8 = GameUtils.INSTANCE.getInstance();
                    companion8.setUnavailableUserIds(new ArrayList());
                    companion8.setGameParticipantUsers(new ArrayList());
                    if (!getSharedViewModel().getGameState().getUsersSeated()) {
                        int numberOfPlayers2 = getSharedViewModel().getGameState().getNumberOfPlayers();
                        for (int i2 = 0; i2 < numberOfPlayers2; i2++) {
                            if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                                if (i2 == 0) {
                                    string = getResources().getString(R.string.team_1_player_1);
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                } else {
                                    string = "";
                                }
                                if (i2 == 3) {
                                    string = getResources().getString(R.string.team_1_player_2);
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                }
                                if (i2 == 1) {
                                    string = getResources().getString(R.string.team_2_player_2);
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                }
                                if (i2 == 2) {
                                    string = getResources().getString(R.string.team_2_player_1);
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                }
                            } else {
                                string = "";
                            }
                            if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                                if (i2 == 0) {
                                    string = getResources().getString(R.string.team_1_player_2);
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                }
                                if (i2 == 1) {
                                    string = getResources().getString(R.string.team_1_player_1);
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                }
                                if (i2 == 5) {
                                    string = getResources().getString(R.string.team_1_player_3);
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                }
                                if (i2 == 2) {
                                    string = getResources().getString(R.string.team_2_player_3);
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                }
                                if (i2 == 3) {
                                    string = getResources().getString(R.string.team_2_player_2);
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                }
                                if (i2 == 4) {
                                    string = getResources().getString(R.string.team_2_player_1);
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                }
                            }
                            LifeTotalView.showUserSelection$default(this.lifeViews.get(i2), false, string, null, 4, null);
                        }
                    }
                }
                Unit unit24 = Unit.INSTANCE;
            } else if (getSharedViewModel().getGameState().getUsersSeated()) {
                if (!getSharedViewModel().getGameState().getDecksSelected()) {
                    int numberOfPlayers3 = getSharedViewModel().getGameState().getNumberOfPlayers();
                    for (int i3 = 0; i3 < numberOfPlayers3; i3++) {
                        this.lifeViews.get(i3).showUserAndDecks();
                    }
                }
                Unit unit25 = Unit.INSTANCE;
            } else {
                ArrayList arrayList2 = new ArrayList();
                if (mTPlaygroup != null) {
                    for (Player player : getSharedViewModel().getGameState().getPlayers()) {
                        Iterator<T> it5 = mTPlaygroup.getUsers().iterator();
                        while (true) {
                            if (it5.hasNext()) {
                                next = it5.next();
                                if (((MTUser) next).getId() == player.getUserId()) {
                                    break;
                                }
                            } else {
                                next = null;
                                break;
                            }
                        }
                        MTUser mTUser2 = (MTUser) next;
                        if (mTUser2 != null) {
                            Boolean.valueOf(arrayList2.add(mTUser2));
                        }
                    }
                    Unit unit26 = Unit.INSTANCE;
                    Unit unit27 = Unit.INSTANCE;
                }
                int numberOfPlayers4 = getSharedViewModel().getGameState().getNumberOfPlayers();
                for (int i4 = 0; i4 < numberOfPlayers4; i4++) {
                    if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                        if (i4 == 0) {
                            string2 = getResources().getString(R.string.team_1_player_1);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        } else {
                            string2 = "";
                        }
                        if (i4 == 3) {
                            string2 = getResources().getString(R.string.team_1_player_2);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        }
                        if (i4 == 1) {
                            string2 = getResources().getString(R.string.team_2_player_2);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        }
                        if (i4 == 2) {
                            string2 = getResources().getString(R.string.team_2_player_1);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        }
                    } else {
                        string2 = "";
                    }
                    if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                        if (i4 == 0) {
                            string2 = getResources().getString(R.string.team_1_player_2);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        }
                        if (i4 == 1) {
                            string2 = getResources().getString(R.string.team_1_player_1);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        }
                        if (i4 == 5) {
                            string2 = getResources().getString(R.string.team_1_player_3);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        }
                        if (i4 == 2) {
                            string2 = getResources().getString(R.string.team_2_player_3);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        }
                        if (i4 == 3) {
                            string2 = getResources().getString(R.string.team_2_player_2);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        }
                        if (i4 == 4) {
                            string2 = getResources().getString(R.string.team_2_player_1);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        }
                    }
                    this.lifeViews.get(i4).showUserSelection(true, string2, arrayList2);
                }
                GameUtils companion9 = GameUtils.INSTANCE.getInstance();
                companion9.setUnseatedUsers(new ArrayList());
                Boolean.valueOf(companion9.getUnseatedUsers().addAll(arrayList2));
            }
            if (this.tutorialMode) {
                int numberOfPlayers5 = getSharedViewModel().getGameState().getNumberOfPlayers();
                for (int i5 = 0; i5 < numberOfPlayers5; i5++) {
                    this.lifeViews.get(i5).setUserInteractionEnabled(false);
                    this.lifeViews.get(i5).setCmdDamageDisabled(true);
                    this.lifeViews.get(i5).setSwipeDisabled(true);
                }
            } else if ((!getSharedViewModel().getGameState().getGameSyncable() || (getSharedViewModel().getGameState().getUsersSeated() && getSharedViewModel().getGameState().getDecksSelected())) && getSharedViewModel().getGameState().getTossAlreadyDone() && !preferencesManager.getBoolean(PreferencesManager.SWIPE_TUTORIAL_DONE, false)) {
                preferencesManager.setBoolean(PreferencesManager.SWIPE_TUTORIAL_DONE, true);
                this.lifeViews.get(0).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda101
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lifeViews.get(0).showSwipeHint();
                    }
                }, 1000L);
            }
            if (getSharedViewModel().getGameState().getPlaygroupId() == -1 || !getSharedViewModel().getGameState().getGameSyncable()) {
                if (!preferencesManager.hasValidUser() || !getSharedViewModel().getGameState().getGameSyncable()) {
                    GameSet currentSet = preferencesManager.getCurrentSet();
                    if (currentSet != null) {
                        if (getSharedViewModel().getGameState().getPlayers().size() == 2) {
                            showBestOfScore(GameUtils.INSTANCE.getInstance().getPlayerScore(0, currentSet), GameUtils.INSTANCE.getInstance().getPlayerScore(1, currentSet));
                        }
                        Unit unit28 = Unit.INSTANCE;
                        Unit unit29 = Unit.INSTANCE;
                    }
                } else if (getSharedViewModel().getGameState().getUsersSeated() && getSharedViewModel().getGameState().getDecksSelected()) {
                    GameSet currentSet2 = preferencesManager.getCurrentSet();
                    if (currentSet2 != null) {
                        if (getSharedViewModel().getGameState().getPlayers().size() == 2) {
                            showBestOfScore(GameUtils.INSTANCE.getInstance().getPlayerScore(0, currentSet2), GameUtils.INSTANCE.getInstance().getPlayerScore(1, currentSet2));
                        }
                        Unit unit30 = Unit.INSTANCE;
                        Unit unit31 = Unit.INSTANCE;
                    }
                } else {
                    showStartGameButton();
                    Unit unit32 = Unit.INSTANCE;
                }
            } else if (!getSharedViewModel().getGameState().getUsersSeated()) {
                Boolean.valueOf(this.lifeViews.get(0).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda102
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.showMenuAsClose();
                    }
                }));
            } else if (getSharedViewModel().getGameState().getDecksSelected()) {
                GameSet currentSet3 = preferencesManager.getCurrentSet();
                if (currentSet3 != null) {
                    if (getSharedViewModel().getGameState().getPlayers().size() == 2) {
                        showBestOfScore(GameUtils.INSTANCE.getInstance().getPlayerScore(0, currentSet3), GameUtils.INSTANCE.getInstance().getPlayerScore(1, currentSet3));
                    }
                    Unit unit33 = Unit.INSTANCE;
                    Unit unit34 = Unit.INSTANCE;
                }
            } else {
                Boolean.valueOf(this.lifeViews.get(0).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda103
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.showMenuAsClose();
                    }
                }));
            }
            List<Integer> gameWinners = GameUtils.INSTANCE.getInstance().getGameWinners(getSharedViewModel().getGameState());
            if (!gameWinners.isEmpty()) {
                int numberOfPlayers6 = getSharedViewModel().getGameState().getNumberOfPlayers();
                for (final int i6 = 0; i6 < numberOfPlayers6; i6++) {
                    if (gameWinners.contains(Integer.valueOf(getSharedViewModel().getGameState().getPlayers().get(i6).getUserId()))) {
                        this.lifeViews.get(i6).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda104
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lifeViews.get(i6).triggerPlayerWin();
                            }
                        });
                    }
                }
                hideLifeHistory();
                if (getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                    int size = this.lifeViews.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        this.lifeViews.get(i7).hidePlayerTurnUI();
                        this.lifeViews.get(i7).hideUndoNextTurnUI();
                    }
                    LifeTotalView lifeTotalView4 = this.lifeViewTeam1;
                    if (lifeTotalView4 != null) {
                        lifeTotalView4.hidePlayerTurnUI();
                        Unit unit35 = Unit.INSTANCE;
                    }
                    LifeTotalView lifeTotalView5 = this.lifeViewTeam1;
                    if (lifeTotalView5 != null) {
                        lifeTotalView5.hideUndoNextTurnUI();
                        Unit unit36 = Unit.INSTANCE;
                    }
                    LifeTotalView lifeTotalView6 = this.lifeViewTeam2;
                    if (lifeTotalView6 != null) {
                        lifeTotalView6.hidePlayerTurnUI();
                        Unit unit37 = Unit.INSTANCE;
                    }
                    LifeTotalView lifeTotalView7 = this.lifeViewTeam2;
                    if (lifeTotalView7 != null) {
                        lifeTotalView7.hideUndoNextTurnUI();
                        Unit unit38 = Unit.INSTANCE;
                    }
                }
                this.lifeViews.get(0).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda106
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.gameFinished();
                    }
                }, 3000L);
            }
            if ((getSharedViewModel().getGameState().getSubformatId() == 5 || getSharedViewModel().getGameState().getSubformatId() == 6) && (!getSharedViewModel().getGameState().getGameSyncable() || (getSharedViewModel().getGameState().getUsersSeated() && getSharedViewModel().getGameState().getDecksSelected()))) {
                setupTeams();
            }
            updateStreamingState$app_release();
        }
    }

    public void setupTeams() {
    }

    public void showBestOfHelp() {
    }

    public void showBestOfScore(int player1Score, int player2Score) {
    }

    public final void showClock() {
        String borderColor;
        Drawable background;
        if (getContext() == null) {
            return;
        }
        this.clockShowing = true;
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.timerTextView) : null;
        View view2 = getView();
        TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.timerPausedTextView) : null;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (textView != null) {
            ViewExtensionsKt.setOnClickWithBounce(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda137
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameFragmentBase.showClock$lambda$0(this.f$0);
                }
            });
        }
        SkinManager companion = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        SkinDefinition currentSkinDefinition = companion.getCurrentSkinDefinition(contextRequireContext2);
        if (currentSkinDefinition != null && (borderColor = currentSkinDefinition.getBorderColor()) != null) {
            int colorFromHex = SkinManager.INSTANCE.getInstance().getColorFromHex(borderColor);
            if (((int) ((((double) ((colorFromHex >> 16) & 255)) * 0.299d) + (((double) ((colorFromHex >> 8) & 255)) * 0.587d) + (((double) (colorFromHex & 255)) * 0.114d))) < 17) {
                colorFromHex = ContextCompat.getColor(requireContext(), R.color.almost_white);
            }
            Drawable drawableMutate = (textView == null || (background = textView.getBackground()) == null) ? null : background.mutate();
            GradientDrawable gradientDrawable = drawableMutate instanceof GradientDrawable ? (GradientDrawable) drawableMutate : null;
            if (gradientDrawable != null) {
                GameUtils companion2 = GameUtils.INSTANCE.getInstance();
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                gradientDrawable.setStroke(companion2.dpToPx(2, contextRequireContext3), colorFromHex);
                if (textView != null) {
                    textView.setBackground(gradientDrawable);
                }
            }
        }
        if (preferencesManager.getBoolean(PreferencesManager.ALWAYS_SHOW_TIMER, true) || getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (getSharedViewModel().getGameState().getTimerPaused()) {
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                if (textView != null) {
                    textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color_transparent));
                }
                if (getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                    int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
                    for (int i = 0; i < numberOfPlayers; i++) {
                        int iCurrentTimeMillis = 0;
                        for (MTGameEvent mTGameEvent : getSharedViewModel().getGameState().getEvents()) {
                            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent.getPlayerid() == i) {
                                iCurrentTimeMillis += mTGameEvent.getValue();
                            }
                        }
                        if (i == getSharedViewModel().getGameState().getCurrentTurnPlayerIndex()) {
                            iCurrentTimeMillis += (int) (((System.currentTimeMillis() - getSharedViewModel().getGameState().getCurrentTurnStartTime()) / 1000) - ((long) getSharedViewModel().getGameState().getCurrentTurnPauseTime()));
                        }
                        this.lifeViews.get(i).showPauseUI(iCurrentTimeMillis);
                    }
                }
            } else {
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                if (textView != null) {
                    textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color_opaque));
                }
            }
        } else {
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        if (getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            View view3 = getView();
            TextView textView3 = view3 != null ? (TextView) view3.findViewById(R.id.timerTurnTextView) : null;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        }
        int iTimeLeft = GameUtils.INSTANCE.getInstance().timeLeft(getSharedViewModel().getGameState());
        if (!this.hasCustomMenuImage) {
            View view4 = getView();
            TextView textView4 = view4 != null ? (TextView) view4.findViewById(R.id.menu_button_white) : null;
            if (textView4 != null) {
                textView4.setTextSize(36.0f);
            }
            View view5 = getView();
            CustomCircleView customCircleView = view5 != null ? (CustomCircleView) view5.findViewById(R.id.circleView) : null;
            float timerTotalTime = iTimeLeft / getSharedViewModel().getGameState().getTimerTotalTime();
            if (customCircleView != null) {
                customCircleView.setFillAmount(timerTotalTime);
            }
            if (customCircleView != null) {
                customCircleView.setVisibility(0);
            }
        }
        if (preferencesManager.getBoolean(PreferencesManager.TIMER_SHOW_SECONDS, false)) {
            this.showSeconds = true;
            int iTimeLeftSeconds = GameUtils.INSTANCE.getInstance().timeLeftSeconds(getSharedViewModel().getGameState());
            if (textView != null) {
                int i2 = iTimeLeftSeconds / 3600;
                int i3 = iTimeLeftSeconds - (i2 * 3600);
                int i4 = i3 / 60;
                int i5 = i3 % 60;
                if (i2 == 0) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i4), Integer.valueOf(i5)}, 2));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    textView.setText(str);
                } else {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String str2 = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5)}, 3));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    textView.setText(str2);
                }
            }
        } else {
            this.showSeconds = false;
            if (textView != null) {
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String str3 = String.format("%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(iTimeLeft / 60), Integer.valueOf(iTimeLeft % 60)}, 2));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                textView.setText(str3);
            }
        }
        this.clockHandler.post(this.clockRunnable);
    }

    public void showLifeHistory() {
    }

    public final void showMenu() {
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.menu_button_black) : null;
        View view2 = getView();
        TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.menu_button_white) : null;
        View view3 = getView();
        TextView textView3 = view3 != null ? (TextView) view3.findViewById(R.id.menu_button) : null;
        View view4 = getView();
        View viewFindViewById = view4 != null ? view4.findViewById(R.id.overlayView1) : null;
        if (textView != null) {
            textView.setVisibility(0);
        }
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
        if (this.hasCustomMenuImage) {
            View view5 = getView();
            ImageView imageView = view5 != null ? (ImageView) view5.findViewById(R.id.customMenuButtonImage) : null;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (textView != null) {
                textView.setVisibility(4);
            }
            if (textView2 != null) {
                textView2.setVisibility(4);
            }
            if (textView3 != null) {
                textView3.setVisibility(4);
            }
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(4);
            }
        }
    }

    public final void showMenuAsClose() {
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.menu_button) : null;
        if (textView != null) {
            textView.setText("\uf00d");
        }
    }

    public final void showPlanechaseUI() {
        if (getContext() == null) {
            return;
        }
        if (getSharedViewModel().getGameState().getHasPlanechase()) {
            new PlanechaseDialogFragment.Builder().setState(getSharedViewModel().getGameState()).setPlaneswalkButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda107
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragmentBase.showPlanechaseUI$lambda$0(this.f$0, (PlanechaseDialogFragment) obj);
                }
            }).build().show(getChildFragmentManager(), "PlanechaseDialogFragment");
        }
        if (getSharedViewModel().getGameState().getHasArchenemy()) {
            int currentSchemeIndex = getSharedViewModel().getGameState().getCurrentSchemeIndex();
            if (currentSchemeIndex < GameUtils.INSTANCE.getInstance().getSchemeDeck().size()) {
                String str = GameUtils.INSTANCE.getInstance().getSchemeDeck().get(currentSchemeIndex);
                GameUtils companion = GameUtils.INSTANCE.getInstance();
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                CardRecord cardLocal$default = GameUtils.getCardLocal$default(companion, contextRequireContext, str, 0, 4, null);
                if (cardLocal$default != null) {
                    String lowerCase = cardLocal$default.getType_line().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "ongoing", false, 2, (Object) null) && !getSharedViewModel().getGameState().getOngoingSchemes().contains(cardLocal$default.getScryfall_id())) {
                        getSharedViewModel().getGameState().getOngoingSchemes().add(cardLocal$default.getScryfall_id());
                    }
                }
            }
            new ArchenemyDialogFragment.Builder().setState(getSharedViewModel().getGameState()).setPreviousSchemeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda108
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragmentBase.showPlanechaseUI$lambda$2(this.f$0, (ArchenemyDialogFragment) obj);
                }
            }).setNextSchemeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda109
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragmentBase.showPlanechaseUI$lambda$3(this.f$0, (ArchenemyDialogFragment) obj);
                }
            }).build().show(getChildFragmentManager(), "ArchenemyDialogFragment");
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            new PreferencesManager(contextRequireContext2).saveCurrentGame(getSharedViewModel().getGameState());
        }
    }

    public void showStartGameButton() {
    }

    public final void showTreacheryUnknownRoles() {
        if (getSharedViewModel().getGameState().getPlayers().isEmpty() || this.lifeViews.isEmpty()) {
            return;
        }
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            this.lifeViews.get(i).showTreacheryRole(-1);
        }
    }

    public void showTurnCounterUI(int currentTurn) {
        if (this.clockShowing) {
            View view = getView();
            TextView textView = view != null ? (TextView) view.findViewById(R.id.timerTurnTextView) : null;
            if (textView != null) {
                String string = getString(R.string.turn_x);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                textView.setText(StringsKt.replace$default(string, "{1}", String.valueOf(currentTurn + 1), false, 4, (Object) null));
            }
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void signalCardScanInProgress(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                signalCardScanInProgress(i);
                return;
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void signalPhotoPickInProgress(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                signalPhotoPickInProgress(i);
                return;
            }
        }
    }

    public final void startTutorialAnimations() {
        if (this.tutorialMode) {
            View view = getView();
            TextView textView = view != null ? (TextView) view.findViewById(R.id.menu_button_black) : null;
            if (textView != null) {
                textView.setVisibility(4);
            }
            View view2 = getView();
            TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.menu_button_white) : null;
            if (textView2 != null) {
                textView2.setVisibility(4);
            }
            View view3 = getView();
            TextView textView3 = view3 != null ? (TextView) view3.findViewById(R.id.menu_button) : null;
            if (textView3 != null) {
                textView3.setVisibility(4);
            }
            View view4 = getView();
            View viewFindViewById = view4 != null ? view4.findViewById(R.id.overlayView1) : null;
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(4);
            }
            View view5 = getView();
            if (view5 != null) {
                view5.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameFragmentBase.startTutorialAnimations$lambda$0(this.f$0);
                    }
                }, 1000L);
            }
        }
    }

    public final void stopPlayerTossIntroLoop() {
        this.stopIntroLoop = true;
        int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
        for (int i = 0; i < numberOfPlayers; i++) {
            this.lifeViews.get(i).hideHighlight();
        }
        LifeTotalView lifeTotalView = this.lifeViewTeam1;
        if (lifeTotalView != null) {
            lifeTotalView.hideHighlight();
        }
        LifeTotalView lifeTotalView2 = this.lifeViewTeam2;
        if (lifeTotalView2 != null) {
            lifeTotalView2.hideHighlight();
        }
        this.handler.removeCallbacks(new GameFragmentBase$$ExternalSyntheticLambda5(this));
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void stormCounterTapped(LifeTotalView sender, int rotation) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        final Ref.IntRef intRef = new Ref.IntRef();
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                intRef.element = i;
                break;
            }
            i++;
        }
        if (intRef.element >= getSharedViewModel().getGameState().getPlayers().size()) {
            return;
        }
        final int stormCount = getSharedViewModel().getGameState().getPlayers().get(intRef.element).getStormCount();
        this.lifeViews.get(intRef.element).showCountersDialog(CounterType.Storm, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameFragmentBase.stormCounterTapped$lambda$0(this.f$0, intRef, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        }, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragmentBase.stormCounterTapped$lambda$1(this.f$0, intRef, stormCount);
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void stormToggled(LifeTotalView sender, boolean newValue) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                i = i2;
                break;
            }
            i2++;
        }
        getSharedViewModel().getGameState().getPlayers().get(i).setStormEnabled(newValue);
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        updateStreamingState$app_release();
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void swipeMenuClosed(LifeTotalView sender) {
        Context context;
        Intrinsics.checkNotNullParameter(sender, "sender");
        showLifeHistory();
        if (getSharedViewModel().getGameState().getHasDayNight()) {
            dayNightToggled(getSharedViewModel().getGameState().getHasDayNight());
        }
        if (getSharedViewModel().getGameState().getHasPlanechase()) {
            planechaseToggled(getSharedViewModel().getGameState().getHasPlanechase());
        }
        if (getSharedViewModel().getGameState().getHasArchenemy()) {
            archenemyToggled(getSharedViewModel().getGameState().getHasArchenemy());
        }
        if (!this.clockShowing || (context = getContext()) == null) {
            return;
        }
        if (new PreferencesManager(context).getBoolean(PreferencesManager.ALWAYS_SHOW_TIMER, true) || getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            View view = getView();
            TextView textView = view != null ? (TextView) view.findViewById(R.id.timerTextView) : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (textView != null) {
                textView.setClickable(true);
            }
            if (textView != null) {
                textView.setFocusable(true);
            }
            if (textView != null) {
                textView.setEnabled(true);
            }
            if (textView != null) {
                ViewExtensionsKt.setOnClickWithBounce(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda92
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GameFragmentBase.swipeMenuClosed$lambda$0$0(this.f$0);
                    }
                });
            }
            View view2 = getView();
            TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.timerPausedTextView) : null;
            View view3 = getView();
            TextView textView3 = view3 != null ? (TextView) view3.findViewById(R.id.timerTurnTextView) : null;
            if (getSharedViewModel().getGameState().getTurnTimerEnabled() && textView3 != null) {
                textView3.setVisibility(0);
            }
            if (!getSharedViewModel().getGameState().getTimerPaused() || textView2 == null) {
                return;
            }
            textView2.setVisibility(0);
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void swipeMenuOpened(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        hideLifeHistory();
        dayNightToggled(false);
        planechaseToggled(false);
        archenemyToggled(false);
        if (this.clockShowing) {
            View view = getView();
            TextView textView = view != null ? (TextView) view.findViewById(R.id.timerTextView) : null;
            if (textView != null) {
                textView.setVisibility(4);
            }
            View view2 = getView();
            TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.timerPausedTextView) : null;
            View view3 = getView();
            TextView textView3 = view3 != null ? (TextView) view3.findViewById(R.id.timerTurnTextView) : null;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void taxCounterTapped(LifeTotalView sender, int rotation) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        final Ref.IntRef intRef = new Ref.IntRef();
        int size = this.lifeViews.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                intRef.element = i;
                break;
            }
            i++;
        }
        if (intRef.element >= getSharedViewModel().getGameState().getPlayers().size()) {
            return;
        }
        final int taxCount = getSharedViewModel().getGameState().getPlayers().get(intRef.element).getTaxCount();
        final int taxCountPartner = getSharedViewModel().getGameState().getPlayers().get(intRef.element).getTaxCountPartner();
        this.lifeViews.get(intRef.element).showCountersDialog(CounterType.Tax, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda85
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameFragmentBase.taxCounterTapped$lambda$0(this.f$0, intRef, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        }, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda86
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragmentBase.taxCounterTapped$lambda$1(this.f$0, intRef, taxCount, taxCountPartner);
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void taxToggled(LifeTotalView sender, boolean newValue) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                i = i2;
                break;
            }
            i2++;
        }
        getSharedViewModel().getGameState().getPlayers().get(i).setTaxEnabled(newValue);
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        updateStreamingState$app_release();
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void theRingCoinDropped(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        for (final int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                this.lifeViews.get(i).showTheRingCoin();
                if (getContext() == null) {
                    return;
                }
                Breadcrumbs.INSTANCE.leaveBreadcrumb("the_ring_coin_dropped");
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                firebaseAnalytics.logEvent("the_ring_coin_dropped", null);
                getSharedViewModel().getGameState().getPlayers().get(i).setTheRing(true);
                new TheRingDialogFragment.Builder().setState(getSharedViewModel().getGameState()).setCurrentPlayerIndex(i).setOnDismissCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GameFragmentBase.theRingCoinDropped$lambda$0(this.f$0, i, ((Integer) obj).intValue());
                    }
                }).build().show(getChildFragmentManager(), "the_ring_dialog");
                getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.TheRing.getValue(), i, null, 1, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).saveCurrentGame(getSharedViewModel().getGameState());
        updateStreamingState$app_release();
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void theRingCoinRejected() {
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (this.lifeViews.get(i).getTheRing()) {
                this.lifeViews.get(i).showTheRingCoin();
            }
        }
    }

    public void toggleTimerPause() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (getSharedViewModel().getGameState().getTimerPaused()) {
            getSharedViewModel().getGameState().setTimerPaused(false);
            long jCurrentTimeMillis = System.currentTimeMillis() - getSharedViewModel().getGameState().getTimerPausedAt();
            GameState gameState = getSharedViewModel().getGameState();
            int i = (int) (jCurrentTimeMillis / 1000);
            gameState.setPauseTime(gameState.getPauseTime() + i);
            GameState gameState2 = getSharedViewModel().getGameState();
            gameState2.setCurrentTurnPauseTime(gameState2.getCurrentTurnPauseTime() + i);
            if (getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
                for (int i2 = 0; i2 < numberOfPlayers; i2++) {
                    this.lifeViews.get(i2).hidePauseUI();
                }
            }
        } else {
            getSharedViewModel().getGameState().setTimerPaused(true);
            getSharedViewModel().getGameState().setTimerPausedAt(System.currentTimeMillis());
            if (getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                int numberOfPlayers2 = getSharedViewModel().getGameState().getNumberOfPlayers();
                for (int i3 = 0; i3 < numberOfPlayers2; i3++) {
                    int iCurrentTimeMillis = 0;
                    for (MTGameEvent mTGameEvent : getSharedViewModel().getGameState().getEvents()) {
                        if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent.getPlayerid() == i3) {
                            iCurrentTimeMillis += mTGameEvent.getValue();
                        }
                    }
                    if (i3 == getSharedViewModel().getGameState().getCurrentTurnPlayerIndex()) {
                        iCurrentTimeMillis += (int) (((System.currentTimeMillis() - getSharedViewModel().getGameState().getCurrentTurnStartTime()) / 1000) - ((long) getSharedViewModel().getGameState().getCurrentTurnPauseTime()));
                    }
                    this.lifeViews.get(i3).showPauseUI(iCurrentTimeMillis);
                }
            }
        }
        preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
        updateStreamingState$app_release();
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.timerPausedTextView) : null;
        View view2 = getView();
        TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.timerTextView) : null;
        if (getSharedViewModel().getGameState().getTimerPaused()) {
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (textView2 != null) {
                textView2.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color_transparent));
                return;
            }
            return;
        }
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (textView2 != null) {
            textView2.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color_opaque));
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void treacheryRoleRevealed(LifeTotalView sender, int role) {
        int i;
        Object next;
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getSharedViewModel().getGameState().getPlayers().isEmpty() || this.lifeViews.isEmpty()) {
            return;
        }
        int size = this.lifeViews.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = 0;
                break;
            } else {
                if (Intrinsics.areEqual(sender, this.lifeViews.get(i2))) {
                    i = i2;
                    break;
                }
                i2++;
            }
        }
        if (i >= getSharedViewModel().getGameState().getPlayers().size()) {
            return;
        }
        Iterator<T> it = getSharedViewModel().getGameState().getEvents().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            MTGameEvent mTGameEvent = (MTGameEvent) next;
            if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TreacheryRole.getValue()) && mTGameEvent.getPlayerid() == i) {
                break;
            }
        }
        MTGameEvent mTGameEvent2 = (MTGameEvent) next;
        if (mTGameEvent2 != null) {
            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent2);
        }
        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.TreacheryRole.getValue(), i, null, role, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        this.lifeViews.get(i).showTreacheryRole(role);
        if (GameUtils.INSTANCE.getInstance().allPlayersHaveRole(getSharedViewModel().getGameState())) {
            List<Integer> gameWinners = GameUtils.INSTANCE.getInstance().getGameWinners(getSharedViewModel().getGameState());
            if (gameWinners.isEmpty()) {
                return;
            }
            int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
            for (int i3 = 0; i3 < numberOfPlayers; i3++) {
                if (gameWinners.contains(Integer.valueOf(getSharedViewModel().getGameState().getPlayers().get(i3).getUserId()))) {
                    getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.PlayerWin.getValue(), i3, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
                    this.lifeViews.get(i3).triggerPlayerWin();
                    updateBoScoreEarlyIfNeeded();
                    hideLifeHistory();
                }
            }
            closeCurrentTurn();
            Context context2 = getContext();
            if (context2 != null) {
                new PreferencesManager(context2).saveCurrentGame(getSharedViewModel().getGameState());
            }
            if (getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                int size2 = this.lifeViews.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    this.lifeViews.get(i4).hidePlayerTurnUI();
                    this.lifeViews.get(i4).hideUndoNextTurnUI();
                }
                LifeTotalView lifeTotalView = this.lifeViewTeam1;
                if (lifeTotalView != null) {
                    lifeTotalView.hidePlayerTurnUI();
                }
                LifeTotalView lifeTotalView2 = this.lifeViewTeam1;
                if (lifeTotalView2 != null) {
                    lifeTotalView2.hideUndoNextTurnUI();
                }
                LifeTotalView lifeTotalView3 = this.lifeViewTeam2;
                if (lifeTotalView3 != null) {
                    lifeTotalView3.hidePlayerTurnUI();
                }
                LifeTotalView lifeTotalView4 = this.lifeViewTeam2;
                if (lifeTotalView4 != null) {
                    lifeTotalView4.hideUndoNextTurnUI();
                }
            }
            View view = getView();
            if (view != null) {
                view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda36
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.gameFinished();
                    }
                }, 3000L);
            }
        }
    }

    public final void triggerDeckSelection() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (getSharedViewModel().getGameState().getNumberOfPlayers() != this.lifeViews.size()) {
            return;
        }
        hideClock();
        hideBestOfScore();
        int numberOfPlayers = getSharedViewModel().getGameState().getNumberOfPlayers();
        for (int i = 0; i < numberOfPlayers; i++) {
            this.lifeViews.get(i).showUserAndDecks();
            Player player = getSharedViewModel().getGameState().getPlayers().get(i);
            if (player.getUserId() <= 0) {
                this.lifeViews.get(i).showUserAsGuest(player.getUserId());
            }
            if (player.getDeckId() != -1) {
                List<MTDeck> list = preferencesManager.getAllUsersDecks().get(Integer.valueOf(player.getUserId()));
                MTDeck mTDeck = null;
                Object obj = null;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (((MTDeck) next).getId() == player.getDeckId()) {
                            obj = next;
                            break;
                        }
                    }
                    mTDeck = (MTDeck) obj;
                }
                if (mTDeck != null) {
                    this.lifeViews.get(i).setDeckData(mTDeck);
                }
            }
        }
        showStartGameButton();
    }

    public void tutorialComplete() {
    }

    /* JADX WARN: Removed duplicated region for block: B:97:0x0227 A[PHI: r4 r12
      0x0227: PHI (r4v40 boolean) = (r4v33 boolean), (r4v43 boolean) binds: [B:113:0x0253, B:96:0x0225] A[DONT_GENERATE, DONT_INLINE]
      0x0227: PHI (r12v28 boolean) = (r12v24 boolean), (r12v31 boolean) binds: [B:113:0x0253, B:96:0x0225] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void undoNextTurnTapped(LifeTotalView sender) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        List<LifeTotalView> list;
        Intrinsics.checkNotNullParameter(sender, "sender");
        if (getContext() != null && getSharedViewModel().getGameState().getNumberOfPlayers() == this.lifeViews.size() && getSharedViewModel().getGameState().getNumberOfPlayers() == getSharedViewModel().getGameState().getPlayers().size()) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            if (getSharedViewModel().getGameState().getTimerPaused()) {
                toggleTimerPause();
            }
            final int currentTurnPlayerIndex = getSharedViewModel().getGameState().getCurrentTurnPlayerIndex();
            final int currentGameTurn = getSharedViewModel().getGameState().getCurrentGameTurn();
            if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                boolean z5 = currentTurnPlayerIndex == 0 || currentTurnPlayerIndex == 3;
                boolean z6 = currentTurnPlayerIndex == 1 || currentTurnPlayerIndex == 2;
                boolean z7 = getSharedViewModel().getGameState().getStartingPlayerIndex() == 0 || getSharedViewModel().getGameState().getStartingPlayerIndex() == 3;
                boolean z8 = getSharedViewModel().getGameState().getStartingPlayerIndex() == 1 || getSharedViewModel().getGameState().getStartingPlayerIndex() == 2;
                if ((z5 && z7) || (z6 && z8)) {
                    GameState gameState = getSharedViewModel().getGameState();
                    gameState.setCurrentGameTurn(gameState.getCurrentGameTurn() - 1);
                    showTurnCounterUI(getSharedViewModel().getGameState().getCurrentGameTurn());
                }
            } else if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                boolean z9 = currentTurnPlayerIndex == 0 || currentTurnPlayerIndex == 1 || currentTurnPlayerIndex == 5;
                boolean z10 = currentTurnPlayerIndex == 2 || currentTurnPlayerIndex == 3 || currentTurnPlayerIndex == 4;
                boolean z11 = getSharedViewModel().getGameState().getStartingPlayerIndex() == 0 || getSharedViewModel().getGameState().getStartingPlayerIndex() == 1 || getSharedViewModel().getGameState().getStartingPlayerIndex() == 5;
                boolean z12 = getSharedViewModel().getGameState().getStartingPlayerIndex() == 2 || getSharedViewModel().getGameState().getStartingPlayerIndex() == 3 || getSharedViewModel().getGameState().getStartingPlayerIndex() == 4;
                if ((z9 && z11) || (z10 && z12)) {
                    GameState gameState2 = getSharedViewModel().getGameState();
                    gameState2.setCurrentGameTurn(gameState2.getCurrentGameTurn() - 1);
                    showTurnCounterUI(getSharedViewModel().getGameState().getCurrentGameTurn());
                }
            } else if (currentTurnPlayerIndex == getSharedViewModel().getGameState().getStartingPlayerIndex()) {
                GameState gameState3 = getSharedViewModel().getGameState();
                gameState3.setCurrentGameTurn(gameState3.getCurrentGameTurn() - 1);
                showTurnCounterUI(getSharedViewModel().getGameState().getCurrentGameTurn());
            }
            int currentTurnPlayerIndex2 = ((getSharedViewModel().getGameState().getCurrentTurnPlayerIndex() - 1) + getSharedViewModel().getGameState().getNumberOfPlayers()) % getSharedViewModel().getGameState().getNumberOfPlayers();
            if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                z3 = currentTurnPlayerIndex2 == 0 || currentTurnPlayerIndex2 == 3;
                z4 = currentTurnPlayerIndex2 == 1 || currentTurnPlayerIndex2 == 2;
                if (z3) {
                    z2 = z3;
                    z = z4;
                    currentTurnPlayerIndex2 = 0;
                } else {
                    z2 = z3;
                    z = z4;
                    currentTurnPlayerIndex2 = 1;
                }
            } else if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                z3 = currentTurnPlayerIndex2 == 0 || currentTurnPlayerIndex2 == 1 || currentTurnPlayerIndex2 == 5;
                z4 = currentTurnPlayerIndex2 == 2 || currentTurnPlayerIndex2 == 3 || currentTurnPlayerIndex2 == 4;
                if (!z3) {
                    z2 = z3;
                    z = z4;
                    currentTurnPlayerIndex2 = 2;
                }
            } else {
                int i = 0;
                while (getSharedViewModel().getGameState().getPlayers().get(currentTurnPlayerIndex2).isKO()) {
                    if (currentTurnPlayerIndex2 == getSharedViewModel().getGameState().getStartingPlayerIndex()) {
                        GameState gameState4 = getSharedViewModel().getGameState();
                        gameState4.setCurrentGameTurn(gameState4.getCurrentGameTurn() - 1);
                        showTurnCounterUI(getSharedViewModel().getGameState().getCurrentGameTurn());
                    }
                    currentTurnPlayerIndex2 = ((currentTurnPlayerIndex2 - 1) + getSharedViewModel().getGameState().getNumberOfPlayers()) % getSharedViewModel().getGameState().getNumberOfPlayers();
                    i++;
                    if (i >= getSharedViewModel().getGameState().getNumberOfPlayers()) {
                        return;
                    }
                }
                z = false;
                z2 = false;
            }
            List<MTGameEvent> events = getSharedViewModel().getGameState().getEvents();
            final Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda83
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$0(currentTurnPlayerIndex, currentGameTurn, (MTGameEvent) obj));
                }
            };
            events.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda45
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((Boolean) function1.invoke(obj)).booleanValue();
                }
            });
            Iterator it = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MTGameEvent mTGameEvent = (MTGameEvent) it.next();
                if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent.getPlayerid() == currentTurnPlayerIndex2) {
                    getSharedViewModel().getGameState().getEvents().remove(mTGameEvent);
                    break;
                }
            }
            if (getSharedViewModel().getGameState().getSubformatId() == 5) {
                if (currentTurnPlayerIndex == 0) {
                    List<MTGameEvent> events2 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function12 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda57
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$2(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events2.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda63
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function12.invoke(obj)).booleanValue();
                        }
                    });
                } else if (currentTurnPlayerIndex == 1) {
                    List<MTGameEvent> events3 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function13 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda66
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$6(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events3.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda67
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function13.invoke(obj)).booleanValue();
                        }
                    });
                } else if (currentTurnPlayerIndex == 2) {
                    List<MTGameEvent> events4 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function14 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda68
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$8(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events4.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda69
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function14.invoke(obj)).booleanValue();
                        }
                    });
                } else if (currentTurnPlayerIndex == 3) {
                    List<MTGameEvent> events5 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function15 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda64
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$4(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events5.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda65
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function15.invoke(obj)).booleanValue();
                        }
                    });
                }
                if (currentTurnPlayerIndex2 == 0) {
                    Iterator it2 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent2 = (MTGameEvent) it2.next();
                        if (Intrinsics.areEqual(mTGameEvent2.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent2.getPlayerid() == 3) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent2);
                            break;
                        }
                    }
                } else if (currentTurnPlayerIndex2 == 1) {
                    Iterator it3 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent3 = (MTGameEvent) it3.next();
                        if (Intrinsics.areEqual(mTGameEvent3.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent3.getPlayerid() == 2) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent3);
                            break;
                        }
                    }
                } else if (currentTurnPlayerIndex2 == 2) {
                    Iterator it4 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent4 = (MTGameEvent) it4.next();
                        if (Intrinsics.areEqual(mTGameEvent4.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent4.getPlayerid() == 1) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent4);
                            break;
                        }
                    }
                } else if (currentTurnPlayerIndex2 == 3) {
                    Iterator it5 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent5 = (MTGameEvent) it5.next();
                        if (Intrinsics.areEqual(mTGameEvent5.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent5.getPlayerid() == 0) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent5);
                            break;
                        }
                    }
                }
            }
            if (getSharedViewModel().getGameState().getSubformatId() == 6) {
                if (currentTurnPlayerIndex == 0) {
                    List<MTGameEvent> events6 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function16 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda94
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$10(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events6.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda105
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function16.invoke(obj)).booleanValue();
                        }
                    });
                    List<MTGameEvent> events7 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function17 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda116
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$12(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events7.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda127
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function17.invoke(obj)).booleanValue();
                        }
                    });
                } else if (currentTurnPlayerIndex == 1) {
                    List<MTGameEvent> events8 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function18 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda138
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$14(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events8.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda11
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function18.invoke(obj)).booleanValue();
                        }
                    });
                    List<MTGameEvent> events9 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function19 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$16(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events9.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda33
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function19.invoke(obj)).booleanValue();
                        }
                    });
                } else if (currentTurnPlayerIndex == 2) {
                    List<MTGameEvent> events10 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function110 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda48
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$22(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events10.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda49
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function110.invoke(obj)).booleanValue();
                        }
                    });
                    List<MTGameEvent> events11 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function111 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda51
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$24(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events11.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda52
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function111.invoke(obj)).booleanValue();
                        }
                    });
                } else if (currentTurnPlayerIndex == 3) {
                    List<MTGameEvent> events12 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function112 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda53
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$26(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events12.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda54
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function112.invoke(obj)).booleanValue();
                        }
                    });
                    List<MTGameEvent> events13 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function113 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda55
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$28(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events13.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda56
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function113.invoke(obj)).booleanValue();
                        }
                    });
                } else if (currentTurnPlayerIndex == 4) {
                    List<MTGameEvent> events14 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function114 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda58
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$30(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events14.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda59
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function114.invoke(obj)).booleanValue();
                        }
                    });
                    List<MTGameEvent> events15 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function115 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda60
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$32(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events15.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda62
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function115.invoke(obj)).booleanValue();
                        }
                    });
                } else if (currentTurnPlayerIndex == 5) {
                    List<MTGameEvent> events16 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function116 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda43
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$18(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events16.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda44
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function116.invoke(obj)).booleanValue();
                        }
                    });
                    List<MTGameEvent> events17 = getSharedViewModel().getGameState().getEvents();
                    final Function1 function117 = new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda46
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(GameFragmentBase.undoNextTurnTapped$lambda$20(currentGameTurn, (MTGameEvent) obj));
                        }
                    };
                    events17.removeIf(new Predicate() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$$ExternalSyntheticLambda47
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) function117.invoke(obj)).booleanValue();
                        }
                    });
                }
                if (currentTurnPlayerIndex2 == 0) {
                    Iterator it6 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent6 = (MTGameEvent) it6.next();
                        if (Intrinsics.areEqual(mTGameEvent6.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent6.getPlayerid() == 1) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent6);
                            break;
                        }
                    }
                    Iterator it7 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it7.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent7 = (MTGameEvent) it7.next();
                        if (Intrinsics.areEqual(mTGameEvent7.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent7.getPlayerid() == 5) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent7);
                            break;
                        }
                    }
                } else if (currentTurnPlayerIndex2 == 1) {
                    Iterator it8 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it8.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent8 = (MTGameEvent) it8.next();
                        if (Intrinsics.areEqual(mTGameEvent8.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent8.getPlayerid() == 0) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent8);
                            break;
                        }
                    }
                    Iterator it9 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it9.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent9 = (MTGameEvent) it9.next();
                        if (Intrinsics.areEqual(mTGameEvent9.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent9.getPlayerid() == 5) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent9);
                            break;
                        }
                    }
                } else if (currentTurnPlayerIndex2 == 2) {
                    Iterator it10 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it10.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent10 = (MTGameEvent) it10.next();
                        if (Intrinsics.areEqual(mTGameEvent10.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent10.getPlayerid() == 3) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent10);
                            break;
                        }
                    }
                    Iterator it11 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it11.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent11 = (MTGameEvent) it11.next();
                        if (Intrinsics.areEqual(mTGameEvent11.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent11.getPlayerid() == 4) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent11);
                            break;
                        }
                    }
                } else if (currentTurnPlayerIndex2 == 3) {
                    Iterator it12 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it12.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent12 = (MTGameEvent) it12.next();
                        if (Intrinsics.areEqual(mTGameEvent12.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent12.getPlayerid() == 2) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent12);
                            break;
                        }
                    }
                    Iterator it13 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it13.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent13 = (MTGameEvent) it13.next();
                        if (Intrinsics.areEqual(mTGameEvent13.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent13.getPlayerid() == 4) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent13);
                            break;
                        }
                    }
                } else if (currentTurnPlayerIndex2 == 4) {
                    Iterator it14 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it14.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent14 = (MTGameEvent) it14.next();
                        if (Intrinsics.areEqual(mTGameEvent14.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent14.getPlayerid() == 2) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent14);
                            break;
                        }
                    }
                    Iterator it15 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it15.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent15 = (MTGameEvent) it15.next();
                        if (Intrinsics.areEqual(mTGameEvent15.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent15.getPlayerid() == 3) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent15);
                            break;
                        }
                    }
                } else if (currentTurnPlayerIndex2 == 5) {
                    Iterator it16 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it16.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent16 = (MTGameEvent) it16.next();
                        if (Intrinsics.areEqual(mTGameEvent16.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent16.getPlayerid() == 0) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent16);
                            break;
                        }
                    }
                    Iterator it17 = CollectionsKt.reversed(getSharedViewModel().getGameState().getEvents()).iterator();
                    while (true) {
                        if (!it17.hasNext()) {
                            break;
                        }
                        MTGameEvent mTGameEvent17 = (MTGameEvent) it17.next();
                        if (Intrinsics.areEqual(mTGameEvent17.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent17.getPlayerid() == 1) {
                            getSharedViewModel().getGameState().getEvents().remove(mTGameEvent17);
                            break;
                        }
                    }
                }
            }
            int value = 0;
            for (MTGameEvent mTGameEvent18 : getSharedViewModel().getGameState().getEvents()) {
                if (Intrinsics.areEqual(mTGameEvent18.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent18.getPlayerid() == currentTurnPlayerIndex2) {
                    value += mTGameEvent18.getValue();
                }
            }
            getSharedViewModel().getGameState().setCurrentTurnPlayerIndex(currentTurnPlayerIndex2);
            getSharedViewModel().getGameState().setCurrentTurnStartTime(this.lastTurnStartTime);
            getSharedViewModel().getGameState().setCurrentTurnPauseTime((int) this.lastTurnPauseTime);
            int size = this.lifeViews.size();
            int i2 = 0;
            while (true) {
                list = this.lifeViews;
                if (i2 >= size) {
                    break;
                }
                list.get(i2).hideUndoNextTurnUI();
                i2++;
            }
            list.get(currentTurnPlayerIndex).setIsCurrentPlayerTurn(false, 0);
            this.lifeViews.get(currentTurnPlayerIndex2).setIsCurrentPlayerTurn(true, value);
            if (getSharedViewModel().getGameState().getSubformatId() == 5 || getSharedViewModel().getGameState().getSubformatId() == 6) {
                LifeTotalView lifeTotalView = this.lifeViewTeam1;
                if (lifeTotalView != null) {
                    lifeTotalView.setIsCurrentPlayerTurn(z2, z2 ? value : 0);
                }
                LifeTotalView lifeTotalView2 = this.lifeViewTeam2;
                if (lifeTotalView2 != null) {
                    lifeTotalView2.setIsCurrentPlayerTurn(z, z ? value : 0);
                }
                LifeTotalView lifeTotalView3 = this.lifeViewTeam1;
                if (lifeTotalView3 != null) {
                    lifeTotalView3.hideUndoNextTurnUI();
                }
                LifeTotalView lifeTotalView4 = this.lifeViewTeam2;
                if (lifeTotalView4 != null) {
                    lifeTotalView4.hideUndoNextTurnUI();
                }
            }
            preferencesManager.saveCurrentGame(getSharedViewModel().getGameState());
            updateStreamingState$app_release();
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void undoPlayerDeath(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                undoPlayerDeath(i);
                return;
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.LifeTotalViewCallback
    public void undoPlayerWin(LifeTotalView sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        int size = this.lifeViews.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(sender, this.lifeViews.get(i))) {
                undoPlayerWin(i);
                return;
            }
        }
    }

    public final void updateClock() {
        if (getContext() == null) {
            return;
        }
        View view = getView();
        CustomCircleView customCircleView = view != null ? (CustomCircleView) view.findViewById(R.id.circleView) : null;
        int iTimeLeft = GameUtils.INSTANCE.getInstance().timeLeft(getSharedViewModel().getGameState());
        float timerTotalTime = iTimeLeft / getSharedViewModel().getGameState().getTimerTotalTime();
        if (customCircleView != null) {
            customCircleView.setFillAmount(timerTotalTime);
        }
        View view2 = getView();
        TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.timerTextView) : null;
        if (getSharedViewModel().getGameState().getTimerEnabled() || !getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            if (!this.showSeconds) {
                if (textView != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format("%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(iTimeLeft / 60), Integer.valueOf(iTimeLeft % 60)}, 2));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    textView.setText(str);
                    return;
                }
                return;
            }
            int iTimeLeftSeconds = GameUtils.INSTANCE.getInstance().timeLeftSeconds(getSharedViewModel().getGameState());
            if (textView != null) {
                int i = iTimeLeftSeconds / 3600;
                int i2 = iTimeLeftSeconds - (i * 3600);
                int i3 = i2 / 60;
                int i4 = i2 % 60;
                if (i == 0) {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String str2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}, 2));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    textView.setText(str2);
                    return;
                }
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String str3 = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4)}, 3));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                textView.setText(str3);
                return;
            }
            return;
        }
        if (!this.showSeconds) {
            int iTimeElapsed = GameUtils.INSTANCE.getInstance().timeElapsed(getSharedViewModel().getGameState());
            if (textView != null) {
                StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                String str4 = String.format("%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(iTimeElapsed / 60), Integer.valueOf(iTimeElapsed % 60)}, 2));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                textView.setText(str4);
                return;
            }
            return;
        }
        int iTimeElapsedSeconds = GameUtils.INSTANCE.getInstance().timeElapsedSeconds(getSharedViewModel().getGameState());
        if (textView != null) {
            int i5 = iTimeElapsedSeconds / 3600;
            int i6 = iTimeElapsedSeconds - (i5 * 3600);
            int i7 = i6 / 60;
            int i8 = i6 % 60;
            if (i5 == 0) {
                StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                String str5 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i7), Integer.valueOf(i8)}, 2));
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                textView.setText(str5);
                return;
            }
            StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
            String str6 = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i5), Integer.valueOf(i7), Integer.valueOf(i8)}, 3));
            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
            textView.setText(str6);
        }
    }

    public void updateLifeHistory() {
    }

    public final void updateStreamingState$app_release() {
        if (getContext() != null && getSharedViewModel().getGameState().getStreamingEnabled() && getSharedViewModel().getGameState().getStreamingToken().length() > 0) {
            StreamingConverter.Companion companion = StreamingConverter.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            StreamingManager.INSTANCE.getInstance().sendGameUpdate(companion.convertToStreamingData(contextRequireContext, getSharedViewModel().getGameState()));
        }
    }

    public void updateTeams() {
    }
}
