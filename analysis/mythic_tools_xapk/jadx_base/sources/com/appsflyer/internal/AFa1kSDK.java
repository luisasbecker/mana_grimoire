package com.appsflyer.internal;

import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.PointerIconCompat;
import androidx.media3.muxer.WebmConstants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.base.Ascii;
import com.google.mlkit.common.MlKitException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.ZipFile;
import org.apache.commons.io.FilenameUtils;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes3.dex */
public class AFa1kSDK {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int $12 = 0;
    private static int $13 = 1;
    public static final Map AFInAppEventType;
    private static int afDebugLog;
    private static long afErrorLog;
    private static int afInfoLog;
    private static int afLogForce;
    private static byte[] d;
    private static Object e;
    private static long force;
    public static final Map i;
    private static byte[] unregisterClient;
    private static long v;
    private static Object w;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0038 -> B:14:0x003d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String $$c(int i2, byte b, byte b2) {
        int i3;
        int i4;
        int i5 = 2 % 2;
        byte[] bArr = $$a;
        int i6 = b2 + 1;
        int i7 = 119 - b;
        int i8 = i2 + 4;
        byte[] bArr2 = new byte[i6];
        if (bArr == null) {
            int i9 = $13 + 65;
            $12 = i9 % 128;
            int i10 = i9 % 2;
            int i11 = i7;
            i4 = 0;
            int i12 = i8;
            int i13 = i12 + 1;
            i7 = (i8 + (-i11)) - 1;
            i8 = i13;
            i3 = i4;
            i4 = i3 + 1;
            bArr2[i3] = (byte) i7;
            if (i4 == i6) {
                String str = new String(bArr2, 0);
                int i14 = $12 + 71;
                $13 = i14 % 128;
                if (i14 % 2 != 0) {
                    return str;
                }
                throw null;
            }
            i11 = bArr[i8];
            int i15 = i7;
            i12 = i8;
            i8 = i15;
            int i132 = i12 + 1;
            i7 = (i8 + (-i11)) - 1;
            i8 = i132;
            i3 = i4;
            i4 = i3 + 1;
            bArr2[i3] = (byte) i7;
            if (i4 == i6) {
            }
        } else {
            i3 = 0;
            i4 = i3 + 1;
            bArr2[i3] = (byte) i7;
            if (i4 == i6) {
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(33:874|8|(1:10)(1:12)|13|774|14|(2:794|18)|19|(5:932|21|22|890|23)(2:26|25)|(6:28|867|29|30|869|31)(2:34|33)|(8:762|36|37|748|38|39|746|40)(2:44|43)|(1:46)(1:(3:49|(3:51|928|52)|56)(23:57|58|801|59|(7:62|63|790|64|65|782|66)|67|(1:78)(3:70|937|71)|79|778|80|81|780|82|83|808|84|85|(1:87)(1:88)|89|(2:91|(9:93|(1:95)(1:96)|812|97|98|(1:100)(1:101)|102|(1:104)(1:105)|106)(0))(0)|111|(5:115|(32:117|768|118|(8:120|(20:122|796|123|124|792|125|(0)|253|254|255|256|689|693|(2:695|(2:953|697)(1:698))|950|699|700|913|701|702)(1:136)|137|138|877|139|140|945)(1:146)|(10:864|148|858|149|150|151|152|(9:(1:155)(2:156|(1:158)(1:(1:160)(1:161)))|850|162|163|(2:(5:166|167|(1:169)(3:170|847|171)|172|965)(2:173|964)|174)|963|175|(5:177|862|178|179|961)(5:185|(4:187|902|188|189)(1:(4:198|776|199|200)(14:206|835|207|208|805|209|210|908|211|896|212|213|191|962))|190|191|962)|214)|960|247)(1:257)|755|258|924|259|904|260|261|262|900|263|264|265|888|266|267|879|268|871|269|860|270|271|848|272|273|(22:274|275|(4:277|784|278|279)|954|283|284|285|818|286|287|(15:839|289|290|831|291|292|829|293|294|810|295|296|806|297|298)(15:318|803|319|320|786|321|322|766|323|324|764|325|326|760|327)|758|328|(34:854|330|(3:332|(3:334|856|335)|339)(1:340)|(1:342)(1:343)|344|345|941|346|347|939|348|(5:772|350|351|770|352)(1:364)|365|921|366|(2:368|(1:370)(1:958))|959|371|372|852|373|374|845|375|376|377|833|378|379|816|380|381|(4:383|799|384|385)|391)(44:461|756|462|463|750|464|465|466|930|467|468|469|922|470|471|(2:472|(3:474|475|(2:477|478)(2:956|479))(2:955|482))|483|865|484|485|898|486|487|881|488|489|883|490|491|492|493|494|495|496|814|497|498|499|(2:501|502)|957|503|504|505|(1:507))|(8:798|509|510|788|511|512|(2:514|515)|516)(4:915|522|885|523)|(21:530|837|531|(1:533)(1:534)|535|536|753|537|935|538|926|539|540|919|541|542|917|543|906|544|545)(1:887)|663|668|894|669|949|966)|710)(1:708)|709|951|710)|968))|47|(0)|67|(1:78)(0)|79|778|80|81|780|82|83|808|84|85|(0)(0)|89|(0)(0)|111|(6:113|115|(0)(0)|709|951|710)|943|967) */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x04e7, code lost:
    
        r26 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x04e9, code lost:
    
        r27 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x04eb, code lost:
    
        r14 = r22 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:571:0x1828, code lost:
    
        r7 = r53;
        r27 = 8;
        r33 = 5;
        r0 = r54.getDeclaredConstructor(java.lang.Object.class, java.lang.Boolean.TYPE);
        r0.setAccessible(true);
        com.appsflyer.internal.AFa1kSDK.w = r0.newInstance(r2, java.lang.Boolean.valueOf(!r31));
     */
    /* JADX WARN: Code restructure failed: missing block: B:572:0x1855, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:573:0x1858, code lost:
    
        r5 = 2;
        r6 = 1;
        r11 = 1;
        r22 = false;
        r37 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:686:0x1a24, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0369 A[Catch: Exception -> 0x1b5f, TRY_ENTER, TRY_LEAVE, TryCatch #71 {Exception -> 0x1b5f, blocks: (B:8:0x0131, B:10:0x0146, B:62:0x0369, B:713:0x1b45, B:715:0x1b4b, B:716:0x1b4c, B:718:0x1b4e, B:720:0x1b54, B:721:0x1b55, B:70:0x03d7, B:79:0x0427, B:80:0x046f, B:82:0x047a, B:84:0x047f, B:97:0x04ce, B:102:0x04da, B:106:0x04e4, B:115:0x04f7, B:693:0x1a49, B:695:0x1a9c, B:697:0x1aa0, B:710:0x1b23, B:698:0x1aac, B:699:0x1abd, B:704:0x1b01, B:706:0x1b07, B:707:0x1b08, B:74:0x041d, B:76:0x0423, B:77:0x0424, B:52:0x0311, B:57:0x0318, B:723:0x1b57, B:725:0x1b5d, B:726:0x1b5e, B:66:0x03b0, B:64:0x0377, B:59:0x0344, B:701:0x1ace, B:702:0x1aff, B:71:0x03e5), top: B:874:0x0131, inners: #19, #23, #29, #94, #107 }] */
    /* JADX WARN: Removed duplicated region for block: B:630:0x1948 A[Catch: all -> 0x19d9, TryCatch #80 {all -> 0x19d9, blocks: (B:545:0x17d9, B:547:0x17fb, B:549:0x1801, B:550:0x1802, B:555:0x1808, B:557:0x180e, B:558:0x180f, B:560:0x1811, B:562:0x1819, B:563:0x181a, B:565:0x181c, B:567:0x1824, B:568:0x1825, B:571:0x1828, B:576:0x1869, B:578:0x186f, B:579:0x1870, B:589:0x1887, B:594:0x18ec, B:596:0x18f2, B:597:0x18f3, B:599:0x18f5, B:601:0x1901, B:602:0x1902, B:606:0x1909, B:608:0x1914, B:609:0x1915, B:611:0x1917, B:613:0x1922, B:614:0x1923, B:628:0x193a, B:630:0x1948, B:631:0x1949, B:639:0x1967, B:641:0x197b, B:642:0x197c, B:644:0x197e, B:646:0x1992, B:647:0x1993, B:649:0x1995, B:651:0x19a9, B:652:0x19aa, B:654:0x19ac, B:656:0x19c0, B:657:0x19c1, B:659:0x19c3, B:661:0x19d7, B:662:0x19d8, B:286:0x0c06, B:272:0x0aef, B:270:0x0abd, B:269:0x0a8e, B:268:0x0a5b, B:591:0x18bb, B:592:0x18ea, B:486:0x14b2, B:544:0x17b7, B:470:0x1373, B:539:0x174a, B:467:0x1329, B:538:0x1715), top: B:887:0x1828, inners: #38, #54, #63, #69, #74, #83, #86, #90, #99, #101, #103, #106 }] */
    /* JADX WARN: Removed duplicated region for block: B:631:0x1949 A[Catch: all -> 0x19d9, TryCatch #80 {all -> 0x19d9, blocks: (B:545:0x17d9, B:547:0x17fb, B:549:0x1801, B:550:0x1802, B:555:0x1808, B:557:0x180e, B:558:0x180f, B:560:0x1811, B:562:0x1819, B:563:0x181a, B:565:0x181c, B:567:0x1824, B:568:0x1825, B:571:0x1828, B:576:0x1869, B:578:0x186f, B:579:0x1870, B:589:0x1887, B:594:0x18ec, B:596:0x18f2, B:597:0x18f3, B:599:0x18f5, B:601:0x1901, B:602:0x1902, B:606:0x1909, B:608:0x1914, B:609:0x1915, B:611:0x1917, B:613:0x1922, B:614:0x1923, B:628:0x193a, B:630:0x1948, B:631:0x1949, B:639:0x1967, B:641:0x197b, B:642:0x197c, B:644:0x197e, B:646:0x1992, B:647:0x1993, B:649:0x1995, B:651:0x19a9, B:652:0x19aa, B:654:0x19ac, B:656:0x19c0, B:657:0x19c1, B:659:0x19c3, B:661:0x19d7, B:662:0x19d8, B:286:0x0c06, B:272:0x0aef, B:270:0x0abd, B:269:0x0a8e, B:268:0x0a5b, B:591:0x18bb, B:592:0x18ea, B:486:0x14b2, B:544:0x17b7, B:470:0x1373, B:539:0x174a, B:467:0x1329, B:538:0x1715), top: B:887:0x1828, inners: #38, #54, #63, #69, #74, #83, #86, #90, #99, #101, #103, #106 }] */
    /* JADX WARN: Removed duplicated region for block: B:695:0x1a9c A[Catch: Exception -> 0x1b5f, TryCatch #71 {Exception -> 0x1b5f, blocks: (B:8:0x0131, B:10:0x0146, B:62:0x0369, B:713:0x1b45, B:715:0x1b4b, B:716:0x1b4c, B:718:0x1b4e, B:720:0x1b54, B:721:0x1b55, B:70:0x03d7, B:79:0x0427, B:80:0x046f, B:82:0x047a, B:84:0x047f, B:97:0x04ce, B:102:0x04da, B:106:0x04e4, B:115:0x04f7, B:693:0x1a49, B:695:0x1a9c, B:697:0x1aa0, B:710:0x1b23, B:698:0x1aac, B:699:0x1abd, B:704:0x1b01, B:706:0x1b07, B:707:0x1b08, B:74:0x041d, B:76:0x0423, B:77:0x0424, B:52:0x0311, B:57:0x0318, B:723:0x1b57, B:725:0x1b5d, B:726:0x1b5e, B:66:0x03b0, B:64:0x0377, B:59:0x0344, B:701:0x1ace, B:702:0x1aff, B:71:0x03e5), top: B:874:0x0131, inners: #19, #23, #29, #94, #107 }] */
    /* JADX WARN: Removed duplicated region for block: B:708:0x1b09  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x04cc  */
    /* JADX WARN: Type inference failed for: r0v49, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v88, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r0v90 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r11v16, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r11v78, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r14v154 */
    /* JADX WARN: Type inference failed for: r14v41 */
    /* JADX WARN: Type inference failed for: r14v50, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r14v80 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v122, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v123, types: [java.lang.reflect.Constructor] */
    /* JADX WARN: Type inference failed for: r1v125 */
    /* JADX WARN: Type inference failed for: r1v126 */
    /* JADX WARN: Type inference failed for: r1v127 */
    /* JADX WARN: Type inference failed for: r1v128 */
    /* JADX WARN: Type inference failed for: r1v129 */
    /* JADX WARN: Type inference failed for: r1v130 */
    /* JADX WARN: Type inference failed for: r1v131 */
    /* JADX WARN: Type inference failed for: r1v132 */
    /* JADX WARN: Type inference failed for: r1v133 */
    /* JADX WARN: Type inference failed for: r1v134 */
    /* JADX WARN: Type inference failed for: r1v135 */
    /* JADX WARN: Type inference failed for: r1v139 */
    /* JADX WARN: Type inference failed for: r1v147 */
    /* JADX WARN: Type inference failed for: r1v148 */
    /* JADX WARN: Type inference failed for: r1v149 */
    /* JADX WARN: Type inference failed for: r1v150 */
    /* JADX WARN: Type inference failed for: r1v151 */
    /* JADX WARN: Type inference failed for: r1v152 */
    /* JADX WARN: Type inference failed for: r1v153 */
    /* JADX WARN: Type inference failed for: r1v154 */
    /* JADX WARN: Type inference failed for: r1v155 */
    /* JADX WARN: Type inference failed for: r1v156 */
    /* JADX WARN: Type inference failed for: r1v157 */
    /* JADX WARN: Type inference failed for: r1v158 */
    /* JADX WARN: Type inference failed for: r1v159 */
    /* JADX WARN: Type inference failed for: r1v160 */
    /* JADX WARN: Type inference failed for: r1v161 */
    /* JADX WARN: Type inference failed for: r1v162 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r1v69, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v72, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v75 */
    /* JADX WARN: Type inference failed for: r1v76 */
    /* JADX WARN: Type inference failed for: r1v77 */
    /* JADX WARN: Type inference failed for: r1v78 */
    /* JADX WARN: Type inference failed for: r1v79, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r1v82 */
    /* JADX WARN: Type inference failed for: r1v87, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r1v91 */
    /* JADX WARN: Type inference failed for: r1v92, types: [int] */
    /* JADX WARN: Type inference failed for: r1v93 */
    /* JADX WARN: Type inference failed for: r1v96, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v98, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v99 */
    /* JADX WARN: Type inference failed for: r22v31 */
    /* JADX WARN: Type inference failed for: r22v79 */
    /* JADX WARN: Type inference failed for: r22v9 */
    /* JADX WARN: Type inference failed for: r2v130 */
    /* JADX WARN: Type inference failed for: r2v131 */
    /* JADX WARN: Type inference failed for: r2v136, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v148, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v209, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r2v244, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v263, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r2v33, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v47, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v51, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r32v1 */
    /* JADX WARN: Type inference failed for: r3v128, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r3v135 */
    /* JADX WARN: Type inference failed for: r3v167 */
    /* JADX WARN: Type inference failed for: r3v173 */
    /* JADX WARN: Type inference failed for: r3v177, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v198 */
    /* JADX WARN: Type inference failed for: r3v199 */
    /* JADX WARN: Type inference failed for: r3v200 */
    /* JADX WARN: Type inference failed for: r43v1 */
    /* JADX WARN: Type inference failed for: r43v2 */
    /* JADX WARN: Type inference failed for: r43v21 */
    /* JADX WARN: Type inference failed for: r43v22 */
    /* JADX WARN: Type inference failed for: r43v23 */
    /* JADX WARN: Type inference failed for: r43v24 */
    /* JADX WARN: Type inference failed for: r43v25 */
    /* JADX WARN: Type inference failed for: r43v26 */
    /* JADX WARN: Type inference failed for: r43v27 */
    /* JADX WARN: Type inference failed for: r43v28 */
    /* JADX WARN: Type inference failed for: r43v29 */
    /* JADX WARN: Type inference failed for: r43v3 */
    /* JADX WARN: Type inference failed for: r43v30 */
    /* JADX WARN: Type inference failed for: r43v31, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r43v32 */
    /* JADX WARN: Type inference failed for: r43v33 */
    /* JADX WARN: Type inference failed for: r43v34 */
    /* JADX WARN: Type inference failed for: r43v35 */
    /* JADX WARN: Type inference failed for: r43v36, types: [long] */
    /* JADX WARN: Type inference failed for: r43v37 */
    /* JADX WARN: Type inference failed for: r43v38 */
    /* JADX WARN: Type inference failed for: r43v4 */
    /* JADX WARN: Type inference failed for: r43v46 */
    /* JADX WARN: Type inference failed for: r43v47 */
    /* JADX WARN: Type inference failed for: r43v48 */
    /* JADX WARN: Type inference failed for: r43v49 */
    /* JADX WARN: Type inference failed for: r43v5 */
    /* JADX WARN: Type inference failed for: r43v50 */
    /* JADX WARN: Type inference failed for: r43v51 */
    /* JADX WARN: Type inference failed for: r43v53 */
    /* JADX WARN: Type inference failed for: r43v55 */
    /* JADX WARN: Type inference failed for: r43v56 */
    /* JADX WARN: Type inference failed for: r43v57 */
    /* JADX WARN: Type inference failed for: r43v58 */
    /* JADX WARN: Type inference failed for: r43v6 */
    /* JADX WARN: Type inference failed for: r43v60 */
    /* JADX WARN: Type inference failed for: r43v61 */
    /* JADX WARN: Type inference failed for: r43v62 */
    /* JADX WARN: Type inference failed for: r43v63 */
    /* JADX WARN: Type inference failed for: r43v64 */
    /* JADX WARN: Type inference failed for: r43v65 */
    /* JADX WARN: Type inference failed for: r43v66 */
    /* JADX WARN: Type inference failed for: r43v67 */
    /* JADX WARN: Type inference failed for: r43v68 */
    /* JADX WARN: Type inference failed for: r43v69 */
    /* JADX WARN: Type inference failed for: r43v70 */
    /* JADX WARN: Type inference failed for: r43v71 */
    /* JADX WARN: Type inference failed for: r43v72 */
    /* JADX WARN: Type inference failed for: r43v73 */
    /* JADX WARN: Type inference failed for: r43v74 */
    /* JADX WARN: Type inference failed for: r43v75 */
    /* JADX WARN: Type inference failed for: r43v76 */
    /* JADX WARN: Type inference failed for: r43v77 */
    /* JADX WARN: Type inference failed for: r43v78 */
    /* JADX WARN: Type inference failed for: r47v11 */
    /* JADX WARN: Type inference failed for: r48v49 */
    /* JADX WARN: Type inference failed for: r4v128, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v129, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r4v144, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r4v186, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v85, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r50v1 */
    /* JADX WARN: Type inference failed for: r50v2 */
    /* JADX WARN: Type inference failed for: r50v3 */
    /* JADX WARN: Type inference failed for: r50v4 */
    /* JADX WARN: Type inference failed for: r50v5 */
    /* JADX WARN: Type inference failed for: r53v0 */
    /* JADX WARN: Type inference failed for: r53v1 */
    /* JADX WARN: Type inference failed for: r53v2 */
    /* JADX WARN: Type inference failed for: r53v3 */
    /* JADX WARN: Type inference failed for: r53v4 */
    /* JADX WARN: Type inference failed for: r53v5 */
    /* JADX WARN: Type inference failed for: r53v6 */
    /* JADX WARN: Type inference failed for: r53v7 */
    /* JADX WARN: Type inference failed for: r6v164, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r6v231, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v236 */
    /* JADX WARN: Type inference failed for: r6v91 */
    /* JADX WARN: Type inference failed for: r6v92 */
    /* JADX WARN: Type inference failed for: r7v114, types: [int] */
    /* JADX WARN: Type inference failed for: r7v115 */
    /* JADX WARN: Type inference failed for: r7v119, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r7v120 */
    /* JADX WARN: Type inference failed for: r7v131 */
    /* JADX WARN: Type inference failed for: r7v132 */
    /* JADX WARN: Type inference failed for: r7v133 */
    /* JADX WARN: Type inference failed for: r7v134 */
    /* JADX WARN: Type inference failed for: r7v139 */
    /* JADX WARN: Type inference failed for: r7v181, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r7v188, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r7v203 */
    /* JADX WARN: Type inference failed for: r7v204 */
    /* JADX WARN: Type inference failed for: r7v209 */
    /* JADX WARN: Type inference failed for: r7v210, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r7v211 */
    /* JADX WARN: Type inference failed for: r7v212 */
    /* JADX WARN: Type inference failed for: r7v219, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r7v223 */
    /* JADX WARN: Type inference failed for: r7v236 */
    /* JADX WARN: Type inference failed for: r7v238 */
    /* JADX WARN: Type inference failed for: r7v239 */
    /* JADX WARN: Type inference failed for: r7v246, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r7v247 */
    /* JADX WARN: Type inference failed for: r7v248, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r7v249 */
    /* JADX WARN: Type inference failed for: r7v250 */
    /* JADX WARN: Type inference failed for: r7v252, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r7v253 */
    /* JADX WARN: Type inference failed for: r7v258, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v259 */
    /* JADX WARN: Type inference failed for: r7v260 */
    /* JADX WARN: Type inference failed for: r7v264 */
    /* JADX WARN: Type inference failed for: r7v266 */
    /* JADX WARN: Type inference failed for: r7v267 */
    /* JADX WARN: Type inference failed for: r7v274 */
    /* JADX WARN: Type inference failed for: r7v276 */
    /* JADX WARN: Type inference failed for: r7v282, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r7v283 */
    /* JADX WARN: Type inference failed for: r7v284 */
    /* JADX WARN: Type inference failed for: r7v285, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r7v286 */
    /* JADX WARN: Type inference failed for: r7v287 */
    /* JADX WARN: Type inference failed for: r7v343 */
    /* JADX WARN: Type inference failed for: r7v344 */
    /* JADX WARN: Type inference failed for: r7v345 */
    /* JADX WARN: Type inference failed for: r7v346 */
    /* JADX WARN: Type inference failed for: r7v347 */
    /* JADX WARN: Type inference failed for: r7v348 */
    /* JADX WARN: Type inference failed for: r7v349 */
    /* JADX WARN: Type inference failed for: r7v350 */
    /* JADX WARN: Type inference failed for: r7v351 */
    /* JADX WARN: Type inference failed for: r7v352 */
    /* JADX WARN: Type inference failed for: r7v81 */
    /* JADX WARN: Type inference failed for: r7v82 */
    /* JADX WARN: Type inference failed for: r7v83 */
    /* JADX WARN: Type inference failed for: r7v84 */
    /* JADX WARN: Type inference failed for: r7v85, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r7v86 */
    /* JADX WARN: Type inference failed for: r7v89, types: [byte] */
    /* JADX WARN: Type inference failed for: r7v93, types: [byte] */
    /* JADX WARN: Type inference failed for: r7v96, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r8v92, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r9v116 */
    /* JADX WARN: Type inference failed for: r9v117 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v49, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r9v55 */
    static {
        char c;
        char c2;
        char c3;
        String str$$c;
        Object objInvoke;
        char c4;
        Object objInvoke2;
        char c5;
        char c6;
        Object objNewInstance;
        char c7;
        Object obj;
        boolean z;
        Object objInvoke3;
        char c8;
        char c9;
        Object objNewInstance2;
        int i2;
        char c10;
        int i3;
        boolean[] zArr;
        boolean[] zArr2;
        int i4;
        boolean[] zArr3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        ?? r9;
        Class<byte[]> cls;
        boolean[] zArr4;
        int i10;
        int i11;
        boolean[] zArr5;
        ?? r43;
        Class<?>[] clsArr;
        int i12;
        String str;
        boolean[] zArr6;
        ?? Invoke;
        int i13;
        int i14;
        boolean z3;
        int i15;
        boolean z4;
        ?? r0;
        boolean z5;
        char c11;
        int i16;
        Object objNewInstance3;
        Object obj2;
        Object obj3;
        int i17;
        int i18;
        Random random;
        int i19;
        int i20;
        int i21;
        byte[] bArr;
        String str$$c2;
        Throwable th;
        ?? r7;
        int i22;
        String str$$c3;
        Class cls2;
        byte[] bArr2;
        ?? r22;
        ?? r14;
        ?? r92;
        ?? r3;
        ?? r50;
        ?? r72;
        ?? r432;
        ?? r1;
        Object objNewInstance4;
        Object obj4;
        ?? r433;
        ?? r73;
        ?? r12;
        ?? r434;
        ?? r74;
        ?? r13;
        ?? r10;
        char c12;
        Object objInvoke4;
        ?? r53;
        Class cls3;
        Object obj5;
        Object objInvoke5;
        boolean z6;
        ?? r532;
        int i23;
        Throwable cause;
        ?? r435;
        ?? r75;
        ?? r15;
        int i24;
        boolean z7;
        Class<?> cls4;
        short s;
        byte[] bArr3;
        Class<byte[]> cls5 = byte[].class;
        init$0();
        int i25 = $11;
        int i26 = 1;
        int i27 = (i25 ^ 97) + ((i25 & 97) << 1);
        $10 = i27 % 128;
        int i28 = 2;
        int i29 = i27 % 2;
        try {
            byte[] bArr4 = $$a;
            Class<?>[] clsArr2 = null;
            int iIntValue = ((Integer) Class.forName($$c(bArr4[112], bArr4[287], bArr4[282])).getMethod($$c(bArr4[282], bArr4[8], bArr4[7]), Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, 38, 40, 106)).intValue();
            int iCurrentTimeMillis = (int) System.currentTimeMillis();
            int i30 = ((-202706953) | (~iCurrentTimeMillis)) * (-490);
            int i31 = ((-293994192) ^ i30) + ((i30 & (-293994192)) << 1) + (((~((iCurrentTimeMillis & (-1818194153)) | ((-1818194153) ^ iCurrentTimeMillis))) | 1615487200) * Videoio.CAP_PROP_XI_CC_MATRIX_23);
            int i32 = ((i31 | 762112198) << 1) - (762112198 ^ i31);
            int i33 = ((-2023572438) ^ iIntValue) | ((-2023572438) & iIntValue);
            int i34 = (i33 & 291186941) | (i33 ^ 291186941);
            int i35 = i34 * (-627);
            int iCurrentTimeMillis2 = (int) System.currentTimeMillis();
            int i36 = i34 * 593769;
            int i37 = -(-(i32 * 949));
            int i38 = (i36 & i37) + (i37 | i36);
            int i39 = ~i35;
            int i40 = ~i32;
            int i41 = -(-(((~((i40 ^ iCurrentTimeMillis2) | (i40 & iCurrentTimeMillis2))) | i39) * (-948)));
            int i42 = ~i32;
            int i43 = i39 | i42;
            int i44 = ~iCurrentTimeMillis2;
            int i45 = (i38 & i41) + (i38 | i41) + ((~((i44 & i43) | (i43 ^ i44))) * (-948)) + (((i35 ^ i42) | (i35 & i42)) * 948) + (((~((2023572437 & iIntValue) | (2023572437 ^ iIntValue))) | (-291186942)) * (-627));
            int i46 = ~((~iIntValue) | (-2023572438));
            int i47 = ~(iIntValue | (-291186942));
            int i48 = ((i47 & i46) | (i46 ^ i47)) * 627;
            if ((i45 ^ i48) + ((i45 & i48) << 1) == 0) {
                return;
            }
            force = -694760234487655886L;
            afLogForce = -6;
            AFInAppEventType = new HashMap();
            i = new HashMap();
            try {
                String str$$c4 = $$c(bArr4[324], bArr4[200], bArr4[175]);
                if (w == null) {
                    byte b = bArr4[230];
                    int iCurrentTimeMillis3 = (int) System.currentTimeMillis();
                    int i49 = b * (-903);
                    int i50 = ((-905) ^ i49) + (((-905) & i49) << 1);
                    int i51 = ~iCurrentTimeMillis3;
                    c = 324;
                    int i52 = ~iCurrentTimeMillis3;
                    int i53 = ((~((i52 ^ b) | (i52 & b))) | i51) * (-1808);
                    int i54 = ((i50 | i53) << 1) - (i50 ^ i53);
                    int i55 = ~b;
                    c2 = 200;
                    int i56 = ~((i55 ^ iCurrentTimeMillis3) | (i55 & iCurrentTimeMillis3));
                    c3 = 287;
                    int i57 = ~iCurrentTimeMillis3;
                    int i58 = ~((i57 ^ (-1)) | i57 | b);
                    int i59 = -(-(((i56 ^ i58) | (i56 & i58)) * TypedValues.Custom.TYPE_BOOLEAN));
                    int i60 = ~b;
                    int i61 = ~(i55 | iCurrentTimeMillis3);
                    str$$c = $$c((short) ((i54 ^ i59) + ((i59 & i54) << 1) + (((i60 & i61) | (i60 ^ i61)) * TypedValues.Custom.TYPE_BOOLEAN)), bArr4[200], bArr4[34]);
                } else {
                    c = 324;
                    c2 = 200;
                    c3 = 287;
                    str$$c = null;
                }
                try {
                    objInvoke = Class.forName($$c(bArr4[367], bArr4[c3], (byte) (-bArr4[205]))).getMethod($$c(92, bArr4[c2], bArr4[602]), new Class[0]).invoke(null, null);
                } catch (Exception unused) {
                    objInvoke = null;
                }
                if (objInvoke == null) {
                    try {
                        byte[] bArr5 = $$a;
                        objInvoke = Class.forName($$c(109, bArr5[c3], bArr5[282])).getMethod($$c(130, bArr5[13], bArr5[c2]), new Class[0]).invoke(null, null);
                    } catch (Exception unused2) {
                    }
                }
                if (objInvoke != null) {
                    try {
                        Class<?> cls6 = objInvoke.getClass();
                        byte[] bArr6 = $$a;
                        c4 = 25;
                        try {
                            String str$$c5 = $$c(150, bArr6[13], bArr6[25]);
                            Method method = cls6.getMethod(str$$c5, null);
                            objInvoke2 = method.invoke(objInvoke, null);
                            c5 = 25;
                        } catch (Exception unused3) {
                            objInvoke2 = null;
                            c5 = c4;
                        }
                    } catch (Exception unused4) {
                        c4 = 25;
                    }
                } else {
                    c4 = 25;
                    objInvoke2 = null;
                    c5 = c4;
                }
                if (objInvoke != null) {
                    System.currentTimeMillis();
                    System.currentTimeMillis();
                    try {
                        cls4 = objInvoke.getClass();
                        s = (short) ($$b & PointerIconCompat.TYPE_TEXT);
                        bArr3 = $$a;
                        c6 = '\r';
                    } catch (Exception unused5) {
                        c6 = '\r';
                    }
                    try {
                        String str$$c6 = $$c(s, bArr3[13], bArr3[43]);
                        Method method2 = cls4.getMethod(str$$c6, null);
                        objNewInstance = method2.invoke(objInvoke, null);
                        c7 = '\r';
                    } catch (Exception unused6) {
                        objNewInstance = null;
                        c7 = c6;
                    }
                } else {
                    c6 = '\r';
                    objNewInstance = null;
                    c7 = c6;
                }
                if (objInvoke != null) {
                    try {
                        Class<?> cls7 = objInvoke.getClass();
                        int i62 = $$b;
                        obj = objInvoke2;
                        try {
                            int iCurrentTimeMillis4 = (int) System.currentTimeMillis();
                            int i63 = 329 - (~(-(-(i62 * (-163)))));
                            z = false;
                            int i64 = ~iCurrentTimeMillis4;
                            int i65 = ~((i64 ^ i62) | (i64 & i62));
                            int i66 = i63 + (((i65 ^ 2) | (i65 & 2)) * (-328));
                            int i67 = ((iCurrentTimeMillis4 ^ 2) | (iCurrentTimeMillis4 & 2)) * 164;
                            int i68 = (i66 & i67) + (i66 | i67);
                            int i69 = ~i62;
                            int i70 = ~(((-3) ^ i69) | (i69 & (-3)));
                            int i71 = ~i62;
                            int i72 = ~((i71 ^ iCurrentTimeMillis4) | (i71 & iCurrentTimeMillis4));
                            int i73 = (i70 ^ i72) | (i70 & i72);
                            int i74 = ~iCurrentTimeMillis4;
                            int i75 = (i74 & 2) | (i74 ^ 2);
                            int i76 = ~((i75 & i62) | (i75 ^ i62));
                            int i77 = ((i76 & i73) | (i73 ^ i76)) * 164;
                            short s2 = (short) ((i68 ^ i77) + ((i68 & i77) << 1));
                            try {
                                byte[] bArr7 = $$a;
                                String str$$c7 = $$c(s2, bArr7[c7], bArr7[c5]);
                                objInvoke3 = cls7.getMethod(str$$c7, null).invoke(objInvoke, null);
                            } catch (Exception unused7) {
                                objInvoke3 = null;
                            }
                        } catch (Exception unused8) {
                            z = false;
                        }
                    } catch (Exception unused9) {
                        z = false;
                        obj = objInvoke2;
                    }
                } else {
                    z = false;
                    obj = objInvoke2;
                    objInvoke3 = null;
                }
                if (obj != null) {
                    objNewInstance2 = obj;
                } else {
                    if (str$$c != null) {
                        c8 = 219;
                        c9 = 356;
                        String string = new StringBuilder().append($$c(184, (byte) (-$$a[727]), r13[c5])).append(str$$c).toString();
                        System.currentTimeMillis();
                        System.currentTimeMillis();
                        try {
                            Class<?> cls8 = Class.forName($$c(194, r13[356], r13[219]));
                            Class<?>[] clsArr3 = new Class[1];
                            clsArr3[z ? 1 : 0] = String.class;
                            objNewInstance2 = cls8.getDeclaredConstructor(clsArr3).newInstance(string);
                            if (objInvoke3 == null) {
                                byte b2 = $$a[c9];
                                int i78 = 2 % 2;
                                try {
                                    Object[] objArr = {$$c(MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, b2, b2)};
                                    Class<?> cls9 = Class.forName($$c(218, r0[c9], r0[608]));
                                    String str$$c8 = $$c(233, r0[c7], r0[c5]);
                                    Class<?>[] clsArr4 = new Class[1];
                                    clsArr4[z ? 1 : 0] = String.class;
                                    Object objInvoke6 = cls9.getMethod(str$$c8, clsArr4).invoke(null, objArr);
                                    int i79 = $11 + 73;
                                    $10 = i79 % 128;
                                    int i80 = i79 % 2;
                                    try {
                                        Class<?> cls10 = Class.forName($$c(194, r0[c9], r0[c8]));
                                        Class<?>[] clsArr5 = new Class[1];
                                        clsArr5[z ? 1 : 0] = String.class;
                                        objInvoke3 = cls10.getDeclaredConstructor(clsArr5).newInstance(objInvoke6);
                                    } catch (Throwable th2) {
                                        Throwable cause2 = th2.getCause();
                                        if (cause2 == null) {
                                            throw th2;
                                        }
                                        throw cause2;
                                    }
                                } catch (Throwable th3) {
                                    Throwable cause3 = th3.getCause();
                                    if (cause3 == null) {
                                        throw th3;
                                    }
                                    throw cause3;
                                }
                            }
                            i2 = 5;
                            if (objNewInstance == null || objNewInstance2 == null) {
                                c10 = 'p';
                            } else {
                                byte[] bArr8 = $$a;
                                try {
                                    Object[] objArr2 = new Object[2];
                                    objArr2[1] = $$c(243, bArr8[c2], bArr8[5]);
                                    objArr2[z ? 1 : 0] = objNewInstance2;
                                    Class<?> cls11 = Class.forName($$c(194, bArr8[c9], bArr8[c8]));
                                    Class<?>[] clsArr6 = new Class[2];
                                    c10 = 'p';
                                    clsArr6[z ? 1 : 0] = Class.forName($$c(194, bArr8[c9], bArr8[c8]));
                                    clsArr6[1] = String.class;
                                    objNewInstance = cls11.getDeclaredConstructor(clsArr6).newInstance(objArr2);
                                } catch (Throwable th4) {
                                    Throwable cause4 = th4.getCause();
                                    if (cause4 == null) {
                                        throw th4;
                                    }
                                    throw cause4;
                                }
                            }
                            byte[] bArr9 = $$a;
                            i3 = 194;
                            Object[] objArr3 = (Object[]) Array.newInstance(Class.forName($$c(194, bArr9[c9], bArr9[c8])), 7);
                            objArr3[z ? 1 : 0] = null;
                            objArr3[1] = objNewInstance;
                            objArr3[2] = objNewInstance2;
                            objArr3[3] = objInvoke3;
                            objArr3[4] = objNewInstance;
                            objArr3[5] = objNewInstance2;
                            objArr3[6] = objInvoke3;
                            zArr = new boolean[]{false, true, true, true, true, true, true};
                            zArr2 = new boolean[]{false, false, false, false, true, true, true};
                            i4 = 4;
                            zArr3 = new boolean[7];
                            zArr3[z ? 1 : 0] = z;
                            zArr3[1] = z;
                            zArr3[2] = true;
                            zArr3[3] = true;
                            zArr3[4] = z;
                            zArr3[5] = true;
                            zArr3[6] = true;
                            int i81 = $$b;
                            short s3 = (short) ((i81 ^ 80) | (i81 & 80));
                            i5 = 6;
                            int i82 = 8;
                            Class<?> cls12 = Class.forName($$c(s3, bArr9[c3], bArr9[c]));
                            i24 = cls12.getDeclaredField($$c(275, bArr9[90], bArr9[159])).getInt(cls12);
                            if (i24 < 34) {
                                int i83 = $10 + 81;
                                $11 = i83 % 128;
                                int i84 = i83 % 2;
                                i6 = 1;
                            } else {
                                i6 = z ? 1 : 0;
                            }
                            if (i24 != 29) {
                                int i85 = $10;
                                int i86 = ((i85 | 61) << 1) - (i85 ^ 61);
                                $11 = i86 % 128;
                                if (i86 % 2 == 0) {
                                    boolean z8 = i24 >= 26 ? true : z ? 1 : 0;
                                    try {
                                        zArr3[z ? 1 : 0] = z8;
                                        if (i24 >= 21) {
                                            int i87 = 2 % 2;
                                            z7 = true;
                                        } else {
                                            z7 = z ? 1 : 0;
                                        }
                                        zArr3[1] = z7;
                                        zArr3[4] = i24 >= 21 ? true : z ? 1 : 0;
                                    } catch (ClassNotFoundException unused10) {
                                    }
                                }
                            }
                            i7 = i6;
                            i8 = z ? 1 : 0;
                            i9 = i8 == true ? 1 : 0;
                            r9 = objArr3;
                            z2 = z;
                            while (i8 == 0 && i9 < 9) {
                                if (zArr3[i9 == true ? 1 : 0]) {
                                    cls = cls5;
                                    zArr4 = zArr;
                                    i10 = i2;
                                    i11 = i7 == true ? 1 : 0;
                                    zArr5 = zArr2;
                                    r43 = r9;
                                    clsArr = clsArr2;
                                    i12 = i8 == true ? 1 : 0;
                                    str = str$$c4;
                                    zArr6 = zArr3;
                                    Invoke = i9 == true ? 1 : 0;
                                    i13 = i26;
                                    i14 = i28;
                                    z3 = z2;
                                } else {
                                    try {
                                        z4 = zArr[i9 == true ? 1 : 0];
                                        r0 = r9[i9 == true ? 1 : 0];
                                        z5 = zArr2[i9 == true ? 1 : 0];
                                    } catch (Throwable th5) {
                                        th = th5;
                                        cls = cls5;
                                        zArr4 = zArr;
                                        i10 = i2;
                                        i11 = i7 == true ? 1 : 0;
                                    }
                                    if (z4) {
                                        int i88 = $11;
                                        int i89 = i88 & 51;
                                        i10 = i88 | 51;
                                        c11 = '\t';
                                        int i90 = i89 + i10;
                                        $10 = i90 % 128;
                                        int i91 = i90 % i28;
                                        if (r0 != 0) {
                                            System.currentTimeMillis();
                                            System.currentTimeMillis();
                                            try {
                                                byte[] bArr10 = $$a;
                                                i16 = i28;
                                                try {
                                                    if (((Boolean) Class.forName($$c(i3, bArr10[c9], bArr10[c8])).getMethod($$c(281, bArr10[c2], bArr10[15]), clsArr2).invoke(r0, clsArr2)).booleanValue()) {
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    Throwable cause5 = th.getCause();
                                                    if (cause5 == null) {
                                                        throw th;
                                                    }
                                                    throw cause5;
                                                }
                                            } catch (Throwable th7) {
                                                th = th7;
                                            }
                                            th = th;
                                            cls = cls5;
                                            zArr4 = zArr;
                                            i11 = i7;
                                            zArr5 = zArr2;
                                            r43 = r9;
                                            i12 = i8 == true ? 1 : 0;
                                            str = str$$c4;
                                            zArr6 = zArr3;
                                            Invoke = i9 == true ? 1 : 0;
                                            i10 = 5;
                                            int iCurrentTimeMillis5 = (int) System.currentTimeMillis();
                                            int i92 = 369 - (~(-(-((Invoke == true ? 1 : 0) * 370))));
                                            int i93 = (~Invoke ? 1 : 0) | ((Invoke == true ? 1 : 0) & 1);
                                            int i94 = ~iCurrentTimeMillis5;
                                            int i95 = (i92 - (~(-(-((i93 | i94) * (-369)))))) - 1;
                                            int i96 = ~(((-2) & i94) | ((-2) ^ i94));
                                            int i97 = i95 + (((i96 & (Invoke == true ? 1 : 0)) | ((Invoke == true ? 1 : 0) ^ i96)) * (-369));
                                            int i98 = ~(Invoke == true ? 1 : 0);
                                            int i99 = ~((i98 & 1) | (i98 ^ 1));
                                            int i100 = ~((iCurrentTimeMillis5 ^ 1) | (iCurrentTimeMillis5 & 1));
                                            int i101 = (i99 & i100) | (i99 ^ i100);
                                            int i102 = ~iCurrentTimeMillis5;
                                            int i103 = (i102 & (-2)) | ((-2) ^ i102);
                                            int i104 = ~((i103 & (Invoke == true ? 1 : 0)) | (i103 ^ (Invoke == true ? 1 : 0)));
                                            int i105 = ((i104 & i101) | (i101 ^ i104)) * 369;
                                            i15 = (i97 ^ i105) + ((i105 & i97) << 1);
                                            while (i15 < 7) {
                                                if (zArr6[i15]) {
                                                    clsArr = null;
                                                    w = null;
                                                    e = null;
                                                    i14 = 2;
                                                    i13 = 1;
                                                    z3 = false;
                                                    Invoke = Invoke;
                                                    r43 = r43;
                                                } else {
                                                    int i106 = ((i15 | 77) << 1) - (i15 ^ 77);
                                                    i15 = ((i106 | (-76)) << 1) - (i106 ^ (-76));
                                                }
                                            }
                                            byte[] bArr11 = $$a;
                                            try {
                                                throw ((Throwable) Class.forName($$c(292, bArr11[c9], bArr11[191])).getDeclaredConstructor(String.class, Throwable.class).newInstance($$c(1106, bArr11[102], bArr11[c3]), th));
                                            } catch (Throwable th8) {
                                                Throwable cause6 = th8.getCause();
                                                if (cause6 == null) {
                                                    throw th8;
                                                }
                                                throw cause6;
                                            }
                                        }
                                        StringBuilder sb = new StringBuilder();
                                        byte[] bArr12 = $$a;
                                        String string2 = sb.append($$c(288, bArr12[102], bArr12[9])).append(r0).append($$c(292, bArr12[1116], bArr12[c10])).toString();
                                        int i107 = $10;
                                        int i108 = ((i107 | 107) << i26) - (i107 ^ 107);
                                        $11 = i108 % 128;
                                        int i109 = i108 % 2;
                                        try {
                                            Class<?> cls13 = Class.forName($$c(292, bArr12[c9], bArr12[191]));
                                            Class<?>[] clsArr7 = new Class[i26];
                                            clsArr7[z2 ? 1 : 0] = String.class;
                                            throw ((Throwable) cls13.getDeclaredConstructor(clsArr7).newInstance(string2));
                                        } catch (Throwable th9) {
                                            Throwable cause7 = th9.getCause();
                                            if (cause7 == null) {
                                                throw th9;
                                            }
                                            throw cause7;
                                        }
                                    }
                                    c11 = '\t';
                                    i16 = i28;
                                    if (z4) {
                                        try {
                                            Random random2 = new Random();
                                            try {
                                                byte[] bArr13 = $$a;
                                                int i110 = i26;
                                                random2.setSeed(((Long) Class.forName($$c(218, bArr13[c9], bArr13[608])).getMethod($$c(310, bArr13[c2], bArr13[c7]), null).invoke(null, null)).longValue() ^ (-1617463033));
                                                Object obj6 = null;
                                                Object objNewInstance5 = null;
                                                Object objNewInstance6 = null;
                                                objNewInstance3 = null;
                                                Random random3 = random2;
                                                ?? r436 = r43;
                                                while (obj6 == null) {
                                                    if (objNewInstance5 == null) {
                                                        cls = cls5;
                                                        i17 = i110;
                                                        i18 = i5;
                                                    } else {
                                                        cls = cls5;
                                                        i17 = i110;
                                                        i18 = objNewInstance6 == null ? 5 : objNewInstance3 == null ? i4 : 3;
                                                    }
                                                    try {
                                                        Object obj7 = obj6;
                                                        Object obj8 = objNewInstance5;
                                                        int iCurrentTimeMillis6 = (int) System.currentTimeMillis();
                                                        int i111 = 235 - (~(i18 * Videoio.CAP_PROP_XI_APPLY_CMS));
                                                        int i112 = ~((-2) | (~iCurrentTimeMillis6));
                                                        int i113 = (i111 - (~(-(-(((i18 ^ i112) | (i112 & i18)) * (-235)))))) - 1;
                                                        int i114 = ~(((-2) ^ iCurrentTimeMillis6) | ((-2) & iCurrentTimeMillis6));
                                                        int i115 = -(-(((i18 ^ i114) | (i114 & i18)) * (-470)));
                                                        int i116 = (i113 & i115) + (i115 | i113);
                                                        int i117 = ~i18;
                                                        int i118 = ~((i117 & 1) | (i117 ^ 1));
                                                        int i119 = ((-2) ^ i18) | ((-2) & i18);
                                                        int i120 = ~((i119 ^ iCurrentTimeMillis6) | (i119 & iCurrentTimeMillis6));
                                                        StringBuilder sb2 = new StringBuilder(i116 + (((i118 ^ i120) | (i118 & i120)) * 235));
                                                        sb2.append(FilenameUtils.EXTENSION_SEPARATOR);
                                                        int i121 = i16 % i16;
                                                        int i122 = z2 ? 1 : 0;
                                                        while (i122 < i18) {
                                                            if (z5) {
                                                                int iNextInt = random3.nextInt(26);
                                                                if (random3.nextBoolean()) {
                                                                    int i123 = $11;
                                                                    i19 = i122;
                                                                    int i124 = (i123 ^ 25) + ((i123 & 25) << 1);
                                                                    zArr4 = zArr;
                                                                    $10 = i124 % 128;
                                                                    int i125 = i124 % 2;
                                                                    int i126 = -(-iNextInt);
                                                                    i21 = (i126 & 65) + (i126 | 65);
                                                                    i20 = i18;
                                                                } else {
                                                                    i19 = i122;
                                                                    zArr4 = zArr;
                                                                    int i127 = i18;
                                                                    try {
                                                                        int iCurrentTimeMillis7 = (int) System.currentTimeMillis();
                                                                        int i128 = iNextInt * (-337);
                                                                        i20 = i127;
                                                                        int i129 = ((i128 | 32544) << 1) - (i128 ^ 32544);
                                                                        int i130 = ~iNextInt;
                                                                        int i131 = ~iCurrentTimeMillis7;
                                                                        int i132 = ~((i130 ^ i131) | (i131 & i130));
                                                                        int i133 = ~(((-97) ^ iNextInt) | ((-97) & iNextInt));
                                                                        i12 = (i132 ^ i133) | (i132 & i133);
                                                                        int i134 = ~((iNextInt ^ iCurrentTimeMillis7) | (iNextInt & iCurrentTimeMillis7));
                                                                        int i135 = i129 + ((((i12 == true ? 1 : 0) ^ i134) | ((i12 == true ? 1 : 0) & i134)) * (-338));
                                                                        int i136 = ~iNextInt;
                                                                        i11 = i135 + ((~((i136 ^ 96) | (i136 & 96))) * 338);
                                                                        int i137 = ~iCurrentTimeMillis7;
                                                                        int i138 = iNextInt | 96;
                                                                        int i139 = ((~((i130 ^ i137) | (i137 & i130))) | (~((i138 & iCurrentTimeMillis7) | (i138 ^ iCurrentTimeMillis7)))) * 338;
                                                                        i21 = (((i11 == true ? 1 : 0) | i139) << 1) - ((i11 == true ? 1 : 0) ^ i139);
                                                                    } catch (Throwable th10) {
                                                                        th = th10;
                                                                    }
                                                                }
                                                                sb2.append((char) i21);
                                                            } else {
                                                                i19 = i122;
                                                                zArr4 = zArr;
                                                                i20 = i18;
                                                                int iNextInt2 = random3.nextInt(12);
                                                                sb2.append((char) ((iNextInt2 ^ 8192) + ((iNextInt2 & 8192) << 1)));
                                                            }
                                                            i122 = i19 + 1;
                                                            zArr = zArr4;
                                                            i18 = i20;
                                                        }
                                                        zArr4 = zArr;
                                                        String string3 = sb2.toString();
                                                        if (obj8 == null) {
                                                            try {
                                                                ?? r4 = new Object[i16];
                                                                r4[i17] = string3;
                                                                r4[z2 ? 1 : 0] = r0;
                                                                byte[] bArr14 = $$a;
                                                                Class<?> cls14 = Class.forName($$c(194, bArr14[c9], bArr14[c8]));
                                                                Class<?>[] clsArr8 = new Class[2];
                                                                random = random3;
                                                                clsArr8[z2 ? 1 : 0] = Class.forName($$c(194, bArr14[c9], bArr14[c8]));
                                                                clsArr8[i17] = String.class;
                                                                objNewInstance5 = cls14.getDeclaredConstructor(clsArr8).newInstance(r4);
                                                                i11 = i7 == true ? 1 : 0;
                                                                obj6 = obj7;
                                                            } catch (Throwable th11) {
                                                                Throwable cause8 = th11.getCause();
                                                                if (cause8 == null) {
                                                                    throw th11;
                                                                }
                                                                throw cause8;
                                                            }
                                                        } else {
                                                            random = random3;
                                                            if (objNewInstance6 == null) {
                                                                int i140 = $10;
                                                                int i141 = ((i140 | 11) << 1) - (i140 ^ 11);
                                                                $11 = i141 % 128;
                                                                int i142 = i141 % 2;
                                                                try {
                                                                    ?? r2 = new Object[2];
                                                                    r2[i17] = string3;
                                                                    r2[z2 ? 1 : 0] = r0;
                                                                    byte[] bArr15 = $$a;
                                                                    Class<?> cls15 = Class.forName($$c(194, bArr15[c9], bArr15[c8]));
                                                                    Class<?>[] clsArr9 = new Class[2];
                                                                    clsArr9[z2 ? 1 : 0] = Class.forName($$c(194, bArr15[c9], bArr15[c8]));
                                                                    clsArr9[i17] = String.class;
                                                                    objNewInstance6 = cls15.getDeclaredConstructor(clsArr9).newInstance(r2);
                                                                } catch (Throwable th12) {
                                                                    Throwable cause9 = th12.getCause();
                                                                    if (cause9 == null) {
                                                                        throw th12;
                                                                    }
                                                                    throw cause9;
                                                                }
                                                            } else if (objNewInstance3 == null) {
                                                                try {
                                                                    ?? r23 = new Object[2];
                                                                    r23[i17] = string3;
                                                                    r23[z2 ? 1 : 0] = r0;
                                                                    byte[] bArr16 = $$a;
                                                                    Class<?> cls16 = Class.forName($$c(194, bArr16[c9], bArr16[c8]));
                                                                    Class<?>[] clsArr10 = new Class[2];
                                                                    clsArr10[z2 ? 1 : 0] = Class.forName($$c(194, bArr16[c9], bArr16[c8]));
                                                                    clsArr10[i17] = String.class;
                                                                    objNewInstance3 = cls16.getDeclaredConstructor(clsArr10).newInstance(r23);
                                                                } catch (Throwable th13) {
                                                                    Throwable cause10 = th13.getCause();
                                                                    if (cause10 == null) {
                                                                        throw th13;
                                                                    }
                                                                    throw cause10;
                                                                }
                                                            } else {
                                                                try {
                                                                    ?? r24 = new Object[2];
                                                                    r24[i17] = string3;
                                                                    r24[z2 ? 1 : 0] = r0;
                                                                    byte[] bArr17 = $$a;
                                                                    Class<?> cls17 = Class.forName($$c(194, bArr17[c9], bArr17[c8]));
                                                                    Class<?>[] clsArr11 = new Class[2];
                                                                    clsArr11[z2 ? 1 : 0] = Class.forName($$c(194, bArr17[c9], bArr17[c8]));
                                                                    clsArr11[i17] = String.class;
                                                                    Object objNewInstance7 = cls17.getDeclaredConstructor(clsArr11).newInstance(r24);
                                                                    System.currentTimeMillis();
                                                                    System.currentTimeMillis();
                                                                    try {
                                                                        try {
                                                                            Object[] objArr4 = {objNewInstance7};
                                                                            Class<?> cls18 = Class.forName($$c(326, bArr17[c9], bArr17[c]));
                                                                            Class<?>[] clsArr12 = new Class[i17];
                                                                            byte b3 = bArr17[c9];
                                                                            byte b4 = bArr17[c8];
                                                                            i11 = i7 == true ? 1 : 0;
                                                                            try {
                                                                                clsArr12[z2 ? 1 : 0] = Class.forName($$c(194, b3, b4));
                                                                                try {
                                                                                    Class.forName($$c(326, bArr17[c9], bArr17[c])).getMethod($$c(349, bArr17[c2], bArr17[c11]), null).invoke(cls18.getDeclaredConstructor(clsArr12).newInstance(objArr4), null);
                                                                                    obj6 = objNewInstance7;
                                                                                    objNewInstance5 = obj8;
                                                                                } catch (Throwable th14) {
                                                                                    Throwable cause11 = th14.getCause();
                                                                                    if (cause11 == null) {
                                                                                        throw th14;
                                                                                    }
                                                                                    throw cause11;
                                                                                }
                                                                            } catch (Throwable th15) {
                                                                                th = th15;
                                                                                Throwable cause12 = th.getCause();
                                                                                if (cause12 == null) {
                                                                                    throw th;
                                                                                }
                                                                                throw cause12;
                                                                            }
                                                                        } catch (Exception e2) {
                                                                            StringBuilder sb3 = new StringBuilder();
                                                                            byte[] bArr18 = $$a;
                                                                            String string4 = sb3.append($$c(353, bArr18[102], bArr18[c11])).append(objNewInstance7).append($$c(292, bArr18[1116], bArr18[c10])).toString();
                                                                            try {
                                                                                Object[] objArr5 = new Object[2];
                                                                                objArr5[1] = e2;
                                                                                objArr5[z2 ? 1 : 0] = string4;
                                                                                Class<?> cls19 = Class.forName($$c(292, bArr18[c9], bArr18[191]));
                                                                                Class<?>[] clsArr13 = new Class[2];
                                                                                clsArr13[z2 ? 1 : 0] = String.class;
                                                                                clsArr13[1] = Throwable.class;
                                                                                throw ((Throwable) cls19.getDeclaredConstructor(clsArr13).newInstance(objArr5));
                                                                            } catch (Throwable th16) {
                                                                                Throwable cause13 = th16.getCause();
                                                                                if (cause13 == null) {
                                                                                    throw th16;
                                                                                }
                                                                                throw cause13;
                                                                            }
                                                                        }
                                                                    } catch (Throwable th17) {
                                                                        th = th17;
                                                                        boolean z9 = i7 == true ? 1 : 0;
                                                                    }
                                                                } catch (Throwable th18) {
                                                                    boolean z10 = i7 == true ? 1 : 0;
                                                                    Throwable cause14 = th18.getCause();
                                                                    if (cause14 == null) {
                                                                        throw th18;
                                                                    }
                                                                    throw cause14;
                                                                }
                                                            }
                                                            i11 = i7 == true ? 1 : 0;
                                                            obj6 = obj7;
                                                            objNewInstance5 = obj8;
                                                        }
                                                        cls5 = cls;
                                                        zArr = zArr4;
                                                        random3 = random;
                                                        i7 = i11 == true ? 1 : 0;
                                                        i110 = 1;
                                                        i16 = 2;
                                                        r436 = random;
                                                    } catch (Throwable th19) {
                                                        th = th19;
                                                        zArr4 = zArr;
                                                    }
                                                }
                                                cls = cls5;
                                                obj2 = obj6;
                                                Invoke = objNewInstance6;
                                                obj3 = objNewInstance5;
                                                r43 = r436;
                                            } catch (Throwable th20) {
                                                boolean z11 = i7 == true ? 1 : 0;
                                                Throwable cause15 = th20.getCause();
                                                if (cause15 == null) {
                                                    throw th20;
                                                }
                                                throw cause15;
                                            }
                                        } catch (Throwable th21) {
                                            th = th21;
                                            cls = cls5;
                                        }
                                    } else {
                                        cls = cls5;
                                        Invoke = 0;
                                        obj3 = null;
                                        objNewInstance3 = null;
                                        obj2 = null;
                                        r43 = r43;
                                    }
                                    try {
                                        zArr4 = zArr;
                                        i11 = i7;
                                        bArr = $$a;
                                        str$$c2 = $$c(357, (byte) (-bArr[727]), bArr[52]);
                                    } catch (Throwable th22) {
                                        th = th22;
                                        zArr5 = zArr2;
                                        r43 = r9;
                                        i12 = i8 == true ? 1 : 0;
                                        str = str$$c4;
                                        zArr6 = zArr3;
                                        Invoke = i9 == true ? 1 : 0;
                                        i10 = 5;
                                    }
                                    try {
                                        ?? r32 = Invoke;
                                        String str$$c9 = $$c(Videoio.CAP_PROP_XI_TRG_SOFTWARE, bArr[c7], bArr[c5]);
                                        Class[] clsArr14 = new Class[1];
                                        clsArr14[z2 ? 1 : 0] = String.class;
                                        Invoke = Class.class.getMethod(str$$c9, clsArr14).invoke(AFa1kSDK.class, str$$c2);
                                        try {
                                            Invoke = (String) Class.forName($$c(Videoio.CAP_PROP_XI_AEAG, bArr[c9], bArr[c8])).getMethod($$c(Videoio.CAP_PROP_XI_DOWNSAMPLING_TYPE, bArr[c7], bArr[159]), null).invoke(Invoke, null);
                                            ?? method3 = 432;
                                            try {
                                                ZipFile zipFile = new ZipFile(Invoke.substring(5, Invoke.lastIndexOf($$c(Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, (byte) ($$b >>> 1), bArr[c10]) + str$$c2)));
                                                try {
                                                    Invoke = new byte[7440];
                                                    InputStream inputStream = zipFile.getInputStream(zipFile.getEntry(str$$c2.substring(1)));
                                                    int i143 = $11;
                                                    int i144 = (i143 & 49) + (i143 | 49);
                                                    $10 = i144 % 128;
                                                    int i145 = i144 % 2;
                                                    try {
                                                        Class<?> cls20 = Class.forName($$c(Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, bArr[c9], bArr[451]));
                                                        Class<?>[] clsArr15 = new Class[1];
                                                        byte b5 = bArr[c9];
                                                        method3 = bArr[191];
                                                        r43 = Invoke;
                                                        Invoke = 458;
                                                        Invoke = 458;
                                                        clsArr15[z2 ? 1 : 0] = Class.forName($$c(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, b5, method3));
                                                        try {
                                                            Object[] objArr6 = {cls20.getDeclaredConstructor(clsArr15).newInstance(inputStream)};
                                                            Class<?> cls21 = Class.forName($$c(Videoio.CAP_PROP_XI_GAMMAY, bArr[c9], bArr[c3]));
                                                            Class<?>[] clsArr16 = new Class[1];
                                                            byte b6 = bArr[c9];
                                                            method3 = bArr[191];
                                                            clsArr16[z2 ? 1 : 0] = Class.forName($$c(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, b6, method3));
                                                            Invoke = cls21.getDeclaredConstructor(clsArr16).newInstance(objArr6);
                                                            try {
                                                                ?? cls22 = Class.forName($$c(Videoio.CAP_PROP_XI_GAMMAY, bArr[c9], bArr[c3]));
                                                                String str$$c10 = $$c(Videoio.CAP_PROP_XI_TRG_SELECTOR, bArr[i82], bArr[198]);
                                                                method3 = new Class[1];
                                                                method3[z2 ? 1 : 0] = cls;
                                                                cls22.getMethod(str$$c10, method3).invoke(Invoke, r43);
                                                                int i146 = 2 % 2;
                                                                try {
                                                                    Class.forName($$c(Videoio.CAP_PROP_XI_GAMMAY, bArr[c9], bArr[c3])).getMethod($$c(349, bArr[c2], bArr[c11]), null).invoke(Invoke, null);
                                                                    i22 = 7400;
                                                                    str$$c3 = str$$c4;
                                                                    cls2 = null;
                                                                    Invoke = 16;
                                                                    bArr2 = r43;
                                                                    r3 = zipFile;
                                                                    r92 = r9;
                                                                    r14 = i9;
                                                                    r22 = z2;
                                                                } catch (Throwable th23) {
                                                                    boolean z12 = i8 == true ? 1 : 0;
                                                                    boolean z13 = i9 == true ? 1 : 0;
                                                                    Throwable cause16 = th23.getCause();
                                                                    if (cause16 == null) {
                                                                        throw th23;
                                                                    }
                                                                    throw cause16;
                                                                }
                                                            } catch (Throwable th24) {
                                                                boolean z14 = i8 == true ? 1 : 0;
                                                                boolean z15 = i9 == true ? 1 : 0;
                                                                Throwable cause17 = th24.getCause();
                                                                if (cause17 == null) {
                                                                    throw th24;
                                                                }
                                                                throw cause17;
                                                            }
                                                        } catch (Throwable th25) {
                                                            boolean z16 = i8 == true ? 1 : 0;
                                                            boolean z17 = i9 == true ? 1 : 0;
                                                            Throwable cause18 = th25.getCause();
                                                            if (cause18 == null) {
                                                                throw th25;
                                                            }
                                                            throw cause18;
                                                        }
                                                    } catch (Throwable th26) {
                                                        boolean z18 = i8 == true ? 1 : 0;
                                                        boolean z19 = i9 == true ? 1 : 0;
                                                        Throwable cause19 = th26.getCause();
                                                        if (cause19 == null) {
                                                            throw th26;
                                                        }
                                                        throw cause19;
                                                    }
                                                } catch (Throwable th27) {
                                                    th = th27;
                                                    method3 = zipFile;
                                                    zArr5 = zArr2;
                                                    r43 = r9;
                                                    i12 = i8 == true ? 1 : 0;
                                                    str = str$$c4;
                                                    zArr6 = zArr3;
                                                    Invoke = i9 == true ? 1 : 0;
                                                }
                                                while (true) {
                                                    int length = bArr2.length;
                                                    r43 = 1;
                                                    ?? r6 = r22;
                                                    while (r6 < length) {
                                                        int i147 = i22;
                                                        try {
                                                            ?? r48 = r6;
                                                            long j = ((((long) bArr2[r6]) + (r43 << i5)) + (r43 << 16)) - r43;
                                                            r6 = (~r48 ? 1 : 0) + (((r48 == true ? 1 : 0) & 1) << 1);
                                                            i22 = i147;
                                                            length = length;
                                                            r43 = j;
                                                        } catch (Throwable th28) {
                                                            th = th28;
                                                            r75 = r3;
                                                            zArr5 = zArr2;
                                                            r435 = r92;
                                                            i12 = i8;
                                                            str = str$$c4;
                                                            zArr6 = zArr3;
                                                            r15 = r14;
                                                            i10 = 5;
                                                            Invoke = r15;
                                                            r7 = r75;
                                                            r43 = r435;
                                                            r7.close();
                                                            throw th;
                                                        }
                                                    }
                                                    int i148 = i22;
                                                    int iCurrentTimeMillis8 = (int) System.currentTimeMillis();
                                                    int i149 = (-130416) + (Invoke * (-494));
                                                    int i150 = -(-((~((Invoke ^ 264) | (Invoke & 264))) * (-495)));
                                                    int i151 = (i149 ^ i150) + ((i150 & i149) << 1);
                                                    int i152 = ~iCurrentTimeMillis8;
                                                    int i153 = ((i152 ^ 264) | (i152 & 264)) * Videoio.CAP_PROP_XI_DEFAULT_CC_MATRIX;
                                                    int i154 = (i151 & i153) + (i151 | i153);
                                                    int i155 = ~Invoke;
                                                    int i156 = ~(((-265) ^ i155) | ((-265) & i155));
                                                    int i157 = ~iCurrentTimeMillis8;
                                                    int i158 = ~((i157 & 264) | (i157 ^ 264));
                                                    int i159 = (i154 - (~(-(-(((i156 & i158) | (i156 ^ i158)) * Videoio.CAP_PROP_XI_DEFAULT_CC_MATRIX))))) - 1;
                                                    int iCurrentTimeMillis9 = (int) System.currentTimeMillis();
                                                    int i160 = Invoke * (-159);
                                                    int i161 = ((-1180257) ^ i160) + (((-1180257) & i160) << 1) + (((Invoke & (-7424)) | (Invoke ^ (-7424))) * WebmConstants.MkvEbmlElement.BLOCK_GROUP);
                                                    int i162 = ~iCurrentTimeMillis9;
                                                    int i163 = ~((i162 ^ 7423) | (i162 & 7423));
                                                    int i164 = ~((Invoke & 7423) | (Invoke ^ 7423));
                                                    i12 = i161 + (((i164 & i163) | (i163 ^ i164)) * (-160));
                                                    int i165 = ~(i155 | i162);
                                                    int i166 = -(-(((i165 & 7423) | (i165 ^ 7423)) * WebmConstants.MkvEbmlElement.BLOCK_GROUP));
                                                    bArr2[i159] = (byte) (bArr2[(i12 & i166) + (i12 | i166)] + 37);
                                                    int length2 = bArr2.length;
                                                    int i167 = -Invoke;
                                                    method3 = (length2 ^ i167) + ((length2 & i167) << 1);
                                                    try {
                                                        Object[] objArr7 = new Object[3];
                                                        objArr7[2] = Integer.valueOf((int) method3);
                                                        objArr7[1] = Integer.valueOf((int) Invoke);
                                                        objArr7[r22] = bArr2;
                                                        byte[] bArr19 = $$a;
                                                        ?? r47 = Invoke;
                                                        ?? cls23 = Class.forName($$c(TypedValues.PositionType.TYPE_PERCENT_X, bArr19[c9], bArr19[952]));
                                                        method3 = new Class[3];
                                                        method3[r22] = cls;
                                                        method3[1] = Integer.TYPE;
                                                        method3[2] = Integer.TYPE;
                                                        Invoke = cls23.getDeclaredConstructor(method3).newInstance(objArr7);
                                                        Object obj9 = w;
                                                        if (obj9 == null) {
                                                            try {
                                                                v = r43;
                                                                int zoomControlsTimeout = (int) (r43 ^ ((-7044840232484646124L) - (ViewConfiguration.getZoomControlsTimeout() >> 32)));
                                                                int iUptimeMillis = (int) (v ^ ((SystemClock.uptimeMillis() >> 48) - 7044840231777098748L));
                                                                byte[] bArr20 = new byte[i82];
                                                                // fill-array-data instruction
                                                                bArr20[0] = 124;
                                                                bArr20[1] = 55;
                                                                bArr20[2] = 83;
                                                                bArr20[3] = -50;
                                                                bArr20[4] = 77;
                                                                bArr20[5] = 91;
                                                                bArr20[6] = 57;
                                                                bArr20[7] = -123;
                                                                int[] iArr = new int[(int) (v ^ ((SystemClock.elapsedRealtime() >> 48) - 7044840232484646124L))];
                                                                ?? r25 = r22;
                                                                int iArgb = Color.argb(r25 == true ? 1 : 0, r25 == true ? 1 : 0, r25 == true ? 1 : 0, r25 == true ? 1 : 0);
                                                                ?? r26 = r14;
                                                                try {
                                                                    long j2 = force;
                                                                    byte b7 = (byte) (30 - (~(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))));
                                                                    r50 = r26 == true ? 1 : 0;
                                                                    int i168 = (int) (j2 >>> b7);
                                                                    try {
                                                                        iArr[iArgb] = ((~i168) & iUptimeMillis) | ((~iUptimeMillis) & i168);
                                                                        int zoomControlsTimeout2 = (int) (v ^ ((-7044840232484646121L) - (ViewConfiguration.getZoomControlsTimeout() >> 32)));
                                                                        int i169 = (int) force;
                                                                        iArr[zoomControlsTimeout2] = (i169 | iUptimeMillis) & (~(i169 & iUptimeMillis));
                                                                        int i170 = afLogForce;
                                                                        ?? NormalizeMetaState = KeyEvent.normalizeMetaState(0);
                                                                        try {
                                                                            ?? r142 = new Object[i5];
                                                                            r142[5] = Integer.valueOf(zoomControlsTimeout);
                                                                            r142[i4] = Boolean.valueOf((boolean) NormalizeMetaState);
                                                                            r142[3] = Integer.valueOf(i170);
                                                                            r142[2] = bArr20;
                                                                            r142[1] = iArr;
                                                                            r142[0] = Invoke;
                                                                            ?? cls24 = Class.forName($$c(Videoio.CAP_PROP_XI_SENSOR_CLOCK_FREQ_INDEX, bArr19[c2], (byte) (-bArr19[488])));
                                                                            Class[] clsArr17 = new Class[6];
                                                                            zArr5 = zArr2;
                                                                            try {
                                                                                clsArr17[0] = Class.forName($$c(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, bArr19[c9], bArr19[191]));
                                                                                clsArr17[1] = int[].class;
                                                                                clsArr17[2] = cls;
                                                                                clsArr17[3] = Integer.TYPE;
                                                                                clsArr17[i4] = Boolean.TYPE;
                                                                                i10 = 5;
                                                                                clsArr17[5] = Integer.TYPE;
                                                                                objNewInstance4 = cls24.getDeclaredConstructor(clsArr17).newInstance(r142);
                                                                                r43 = r92;
                                                                                obj4 = obj3;
                                                                                i12 = i8;
                                                                                Invoke = r50 == true ? 1 : 0;
                                                                            } catch (Throwable th29) {
                                                                                th = th29;
                                                                                try {
                                                                                    Throwable cause20 = th.getCause();
                                                                                    if (cause20 == null) {
                                                                                        throw th;
                                                                                    }
                                                                                    throw cause20;
                                                                                } catch (Throwable th30) {
                                                                                    th = th30;
                                                                                    th = th;
                                                                                    r72 = r3;
                                                                                    r432 = r92;
                                                                                    i12 = i8;
                                                                                    str = str$$c4;
                                                                                    zArr6 = zArr3;
                                                                                    r1 = r50;
                                                                                    i82 = 8;
                                                                                    r15 = r1;
                                                                                    r75 = r72;
                                                                                    r435 = r432;
                                                                                    i10 = 5;
                                                                                    Invoke = r15;
                                                                                    r7 = r75;
                                                                                    r43 = r435;
                                                                                    r7.close();
                                                                                    throw th;
                                                                                }
                                                                            }
                                                                        } catch (Throwable th31) {
                                                                            th = th31;
                                                                            zArr5 = zArr2;
                                                                        }
                                                                    } catch (Throwable th32) {
                                                                        th = th32;
                                                                        zArr5 = zArr2;
                                                                        th = th;
                                                                        r72 = r3;
                                                                        r432 = r92;
                                                                        i12 = i8;
                                                                        str = str$$c4;
                                                                        zArr6 = zArr3;
                                                                        r1 = r50;
                                                                        i82 = 8;
                                                                        r15 = r1;
                                                                        r75 = r72;
                                                                        r435 = r432;
                                                                        i10 = 5;
                                                                        Invoke = r15;
                                                                        r7 = r75;
                                                                        r43 = r435;
                                                                        r7.close();
                                                                        throw th;
                                                                    }
                                                                } catch (Throwable th33) {
                                                                    th = th33;
                                                                    r50 = r26 == true ? 1 : 0;
                                                                }
                                                            } catch (Throwable th34) {
                                                                th = th34;
                                                                zArr5 = zArr2;
                                                                r50 = r14;
                                                            }
                                                        } else {
                                                            zArr5 = zArr2;
                                                            ?? r16 = r14;
                                                            try {
                                                                afErrorLog = r43;
                                                                int zoomControlsTimeout3 = (int) (r43 ^ ((ViewConfiguration.getZoomControlsTimeout() >> 32) - 100439625434093874L));
                                                                int iCurrentThreadTimeMillis = (int) (afErrorLog ^ (100439625206759766L - (SystemClock.currentThreadTimeMillis() >> 48)));
                                                                try {
                                                                    try {
                                                                        ?? r62 = new Object[i4];
                                                                        r62[3] = new byte[]{-17, 39, -108, -97, -84, 4, -1, 109, Ascii.ETB, 5, -123, 60, -111, 10, 114, 125};
                                                                        r62[2] = Integer.valueOf(iCurrentThreadTimeMillis);
                                                                        r62[1] = Integer.valueOf(zoomControlsTimeout3);
                                                                        r62[0] = Invoke;
                                                                        ?? cls25 = Class.forName($$c(Videoio.CAP_PROP_XI_KNEEPOINT1, bArr19[c2], bArr19[175]), true, (ClassLoader) e);
                                                                        r43 = r92;
                                                                        try {
                                                                            String str$$c11 = $$c(Videoio.CAP_PROP_XI_REGION_MODE, (byte) (-bArr19[188]), bArr19[43]);
                                                                            Class[] clsArr18 = new Class[4];
                                                                            obj4 = obj3;
                                                                            i12 = i8;
                                                                            try {
                                                                                clsArr18[0] = Class.forName($$c(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, bArr19[c9], bArr19[191]));
                                                                                clsArr18[1] = Integer.TYPE;
                                                                                clsArr18[2] = Integer.TYPE;
                                                                                clsArr18[3] = cls;
                                                                                objNewInstance4 = cls25.getMethod(str$$c11, clsArr18).invoke(obj9, r62);
                                                                                Invoke = r16;
                                                                            } catch (Throwable th35) {
                                                                                th = th35;
                                                                                cause = th.getCause();
                                                                                if (cause != null) {
                                                                                    throw th;
                                                                                }
                                                                                throw cause;
                                                                            }
                                                                        } catch (Throwable th36) {
                                                                            th = th36;
                                                                            cause = th.getCause();
                                                                            if (cause != null) {
                                                                            }
                                                                        }
                                                                    } catch (Throwable th37) {
                                                                        th = th37;
                                                                    }
                                                                } catch (Throwable th38) {
                                                                    th = th38;
                                                                    method3 = r3;
                                                                    r43 = r92;
                                                                    i12 = i8;
                                                                    str = str$$c4;
                                                                    zArr6 = zArr3;
                                                                    i82 = 8;
                                                                    Invoke = r16;
                                                                    i10 = 5;
                                                                    th = th;
                                                                    Invoke = Invoke;
                                                                    r7 = method3;
                                                                    r43 = r43;
                                                                    r7.close();
                                                                    throw th;
                                                                }
                                                            } catch (Throwable th39) {
                                                                th = th39;
                                                                r73 = r3;
                                                                r433 = r92;
                                                                i12 = i8;
                                                                r12 = r16;
                                                                str = str$$c4;
                                                                zArr6 = zArr3;
                                                                r13 = r12;
                                                                r74 = r73;
                                                                r434 = r433;
                                                                i82 = 8;
                                                                Invoke = r13;
                                                                method3 = r74;
                                                                r43 = r434;
                                                                i10 = 5;
                                                                th = th;
                                                                Invoke = Invoke;
                                                                r7 = method3;
                                                                r43 = r43;
                                                                r7.close();
                                                                throw th;
                                                            }
                                                        }
                                                        try {
                                                            Class.forName($$c(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, bArr19[c9], bArr19[191])).getMethod($$c(TypedValues.MotionType.TYPE_POLAR_RELATIVETO, bArr19[c11], bArr19[45]), Long.TYPE).invoke(objNewInstance4, 16);
                                                            if (z4) {
                                                                try {
                                                                    Object obj10 = w;
                                                                    if (obj10 == null) {
                                                                        int i171 = $11 + 115;
                                                                        $10 = i171 % 128;
                                                                        if (i171 % 2 != 0) {
                                                                            try {
                                                                                int i172 = 19 / 0;
                                                                            } catch (Throwable th40) {
                                                                                th = th40;
                                                                                r72 = r3;
                                                                                str = str$$c4;
                                                                                zArr6 = zArr3;
                                                                                r1 = Invoke;
                                                                                r432 = r43;
                                                                                i82 = 8;
                                                                                r15 = r1;
                                                                                r75 = r72;
                                                                                r435 = r432;
                                                                                i10 = 5;
                                                                                Invoke = r15;
                                                                                r7 = r75;
                                                                                r43 = r435;
                                                                                r7.close();
                                                                                throw th;
                                                                            }
                                                                        }
                                                                        r10 = obj4;
                                                                    } else {
                                                                        r10 = r32;
                                                                    }
                                                                    Object obj11 = obj10 == null ? objNewInstance3 : obj2;
                                                                    c12 = '%';
                                                                    Method method4 = Class.forName($$c(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, bArr19[c9], bArr19[191])).getMethod($$c(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, bArr19[8], bArr19[45]), cls, Integer.TYPE, Integer.TYPE);
                                                                    ?? cls26 = Class.forName($$c(326, bArr19[c9], bArr19[c]));
                                                                    try {
                                                                        Class[] clsArr19 = new Class[1];
                                                                        str = str$$c4;
                                                                        try {
                                                                            clsArr19[0] = Class.forName($$c(194, bArr19[c9], bArr19[c8]));
                                                                            Object objNewInstance8 = cls26.getConstructor(clsArr19).newInstance(r10);
                                                                            if (i11 != 0) {
                                                                                try {
                                                                                    zArr6 = zArr3;
                                                                                    try {
                                                                                        ((Boolean) Class.forName($$c(194, bArr19[c9], bArr19[c8])).getMethod($$c(615, bArr19[c11], bArr19[c5]), null).invoke(r10, null)).booleanValue();
                                                                                    } catch (Throwable th41) {
                                                                                        th = th41;
                                                                                        try {
                                                                                            Throwable cause21 = th.getCause();
                                                                                            if (cause21 == null) {
                                                                                                throw th;
                                                                                            }
                                                                                            throw cause21;
                                                                                        } catch (Exception e3) {
                                                                                            e = e3;
                                                                                            StringBuilder sb4 = new StringBuilder();
                                                                                            byte[] bArr21 = $$a;
                                                                                            try {
                                                                                                throw ((Throwable) Class.forName($$c(292, bArr21[c9], bArr21[191])).getDeclaredConstructor(String.class, Throwable.class).newInstance(sb4.append($$c(625, bArr21[102], bArr21[c11])).append(r10).append($$c(292, bArr21[1116], bArr21[c10])).toString(), e));
                                                                                            } catch (Throwable th42) {
                                                                                                Throwable cause22 = th42.getCause();
                                                                                                if (cause22 == null) {
                                                                                                    throw th42;
                                                                                                }
                                                                                                throw cause22;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                } catch (Throwable th43) {
                                                                                    th = th43;
                                                                                }
                                                                            } else {
                                                                                zArr6 = zArr3;
                                                                            }
                                                                            int i173 = 1024;
                                                                            try {
                                                                                byte[] bArr22 = new byte[1024];
                                                                                Method method5 = cls26.getMethod($$c(629, bArr19[c10], bArr19[c11]), cls, Integer.TYPE, Integer.TYPE);
                                                                                int i174 = i148;
                                                                                while (i174 > 0) {
                                                                                    int iIntValue2 = ((Integer) method4.invoke(objNewInstance4, bArr22, 0, Integer.valueOf(Math.min(i173, i174)))).intValue();
                                                                                    if (iIntValue2 == -1) {
                                                                                        break;
                                                                                    }
                                                                                    Object obj12 = objNewInstance4;
                                                                                    method5.invoke(objNewInstance8, bArr22, 0, Integer.valueOf(iIntValue2));
                                                                                    int i175 = -iIntValue2;
                                                                                    i174 = ((i174 | i175) << 1) - (i175 ^ i174);
                                                                                    objNewInstance4 = obj12;
                                                                                    i173 = 1024;
                                                                                }
                                                                                byte[] bArr23 = $$a;
                                                                                Class.forName($$c(637, bArr23[c9], bArr23[282])).getMethod($$c(658, bArr23[c11], bArr23[45]), new Class[0]).invoke(cls26.getMethod($$c(633, bArr23[c7], bArr23[c11]), new Class[0]).invoke(objNewInstance8, new Object[0]), new Object[0]);
                                                                                cls26.getMethod($$c(349, bArr23[c2], bArr23[c11]), new Class[0]).invoke(objNewInstance8, new Object[0]);
                                                                                Method declaredMethod = Class.forName($$c(661, bArr23[37], bArr23[c2])).getDeclaredMethod($$c(681, bArr23[c8], bArr23[159]), String.class, String.class, Integer.TYPE);
                                                                                int i176 = $10 + 67;
                                                                                $11 = i176 % 128;
                                                                                int i177 = i176 % 2;
                                                                                try {
                                                                                    Class<?> cls27 = Class.forName($$c(194, bArr23[c9], bArr23[c8]));
                                                                                    int i178 = $$b;
                                                                                    Object objInvoke7 = cls27.getMethod($$c((short) (i178 | Videoio.CAP_PROP_XI_LENS_FOCUS_DISTANCE), bArr23[c7], bArr23[43]), null).invoke(r10, null);
                                                                                    int i179 = $11;
                                                                                    int i180 = (i179 & 17) + (i179 | 17);
                                                                                    $10 = i180 % 128;
                                                                                    int i181 = i180 % 2;
                                                                                    try {
                                                                                        objInvoke4 = declaredMethod.invoke(null, objInvoke7, Class.forName($$c(194, bArr23[c9], bArr23[c8])).getMethod($$c((short) ((i178 ^ Videoio.CAP_PROP_XI_LENS_FOCUS_DISTANCE) | (i178 & Videoio.CAP_PROP_XI_LENS_FOCUS_DISTANCE)), bArr23[c7], bArr23[43]), null).invoke(obj11, null), 0);
                                                                                        try {
                                                                                            ((Boolean) Class.forName($$c(194, bArr23[c9], bArr23[c8])).getMethod($$c((short) ((i178 ^ Videoio.CAP_PROP_XI_IMAGE_DATA_FORMAT_RGB32_ALPHA) | (i178 & Videoio.CAP_PROP_XI_IMAGE_DATA_FORMAT_RGB32_ALPHA)), bArr23[37], bArr23[8]), null).invoke(r10, null)).booleanValue();
                                                                                            int i182 = $10 + 69;
                                                                                            $11 = i182 % 128;
                                                                                            int i183 = i182 % 2;
                                                                                            try {
                                                                                                i82 = 8;
                                                                                                ((Boolean) Class.forName($$c(194, bArr23[c9], bArr23[c8])).getMethod($$c((short) ((i178 & Videoio.CAP_PROP_XI_IMAGE_DATA_FORMAT_RGB32_ALPHA) | (i178 ^ Videoio.CAP_PROP_XI_IMAGE_DATA_FORMAT_RGB32_ALPHA)), bArr23[37], bArr23[8]), null).invoke(obj11, null)).booleanValue();
                                                                                                if (e == null) {
                                                                                                    try {
                                                                                                        try {
                                                                                                            e = Class.class.getMethod($$c(TypedValues.TransitionType.TYPE_STAGGERED, bArr23[c7], bArr23[c9]), null).invoke(AFa1kSDK.class, null);
                                                                                                        } catch (Throwable th44) {
                                                                                                            Throwable cause23 = th44.getCause();
                                                                                                            if (cause23 == null) {
                                                                                                                throw th44;
                                                                                                            }
                                                                                                            throw cause23;
                                                                                                        }
                                                                                                    } catch (Throwable th45) {
                                                                                                        th = th45;
                                                                                                        th = th;
                                                                                                        r72 = r3;
                                                                                                        r1 = Invoke;
                                                                                                        r432 = r43;
                                                                                                        i82 = 8;
                                                                                                        r15 = r1;
                                                                                                        r75 = r72;
                                                                                                        r435 = r432;
                                                                                                        i10 = 5;
                                                                                                        Invoke = r15;
                                                                                                        r7 = r75;
                                                                                                        r43 = r435;
                                                                                                        r7.close();
                                                                                                        throw th;
                                                                                                    }
                                                                                                }
                                                                                                r53 = r3;
                                                                                                cls3 = cls2;
                                                                                                obj5 = objNewInstance3;
                                                                                            } catch (Throwable th46) {
                                                                                                Throwable cause24 = th46.getCause();
                                                                                                if (cause24 == null) {
                                                                                                    throw th46;
                                                                                                }
                                                                                                throw cause24;
                                                                                            }
                                                                                        } catch (Throwable th47) {
                                                                                            Throwable cause25 = th47.getCause();
                                                                                            if (cause25 == null) {
                                                                                                throw th47;
                                                                                            }
                                                                                            throw cause25;
                                                                                        }
                                                                                    } catch (Throwable th48) {
                                                                                        Throwable cause26 = th48.getCause();
                                                                                        if (cause26 == null) {
                                                                                            throw th48;
                                                                                        }
                                                                                        throw cause26;
                                                                                    }
                                                                                } catch (Throwable th49) {
                                                                                    Throwable cause27 = th49.getCause();
                                                                                    if (cause27 == null) {
                                                                                        throw th49;
                                                                                    }
                                                                                    throw cause27;
                                                                                }
                                                                            } catch (Throwable th50) {
                                                                                th = th50;
                                                                                try {
                                                                                    byte[] bArr24 = $$a;
                                                                                    try {
                                                                                        Class<?> cls28 = Class.forName($$c(194, bArr24[c9], bArr24[c8]));
                                                                                        int i184 = $$b;
                                                                                        ((Boolean) cls28.getMethod($$c((short) ((i184 ^ Videoio.CAP_PROP_XI_IMAGE_DATA_FORMAT_RGB32_ALPHA) | (i184 & Videoio.CAP_PROP_XI_IMAGE_DATA_FORMAT_RGB32_ALPHA)), bArr24[37], bArr24[8]), null).invoke(r10, null)).booleanValue();
                                                                                        try {
                                                                                            try {
                                                                                                ((Boolean) Class.forName($$c(194, bArr24[c9], bArr24[c8])).getMethod($$c((short) (i184 | Videoio.CAP_PROP_XI_IMAGE_DATA_FORMAT_RGB32_ALPHA), bArr24[37], bArr24[8]), null).invoke(obj11, null)).booleanValue();
                                                                                                throw th;
                                                                                            } catch (Throwable th51) {
                                                                                                th = th51;
                                                                                                Throwable cause28 = th.getCause();
                                                                                                if (cause28 == null) {
                                                                                                    throw th;
                                                                                                }
                                                                                                throw cause28;
                                                                                            }
                                                                                        } catch (Throwable th52) {
                                                                                            th = th52;
                                                                                        }
                                                                                    } catch (Throwable th53) {
                                                                                        th = th53;
                                                                                        Throwable cause29 = th.getCause();
                                                                                        if (cause29 == null) {
                                                                                            throw th;
                                                                                        }
                                                                                        throw cause29;
                                                                                    }
                                                                                } catch (Throwable th54) {
                                                                                    th = th54;
                                                                                }
                                                                            }
                                                                        } catch (Exception e4) {
                                                                            e = e4;
                                                                            StringBuilder sb42 = new StringBuilder();
                                                                            byte[] bArr212 = $$a;
                                                                            throw ((Throwable) Class.forName($$c(292, bArr212[c9], bArr212[191])).getDeclaredConstructor(String.class, Throwable.class).newInstance(sb42.append($$c(625, bArr212[102], bArr212[c11])).append(r10).append($$c(292, bArr212[1116], bArr212[c10])).toString(), e));
                                                                        } catch (Throwable th55) {
                                                                            th = th55;
                                                                            byte[] bArr242 = $$a;
                                                                            Class<?> cls282 = Class.forName($$c(194, bArr242[c9], bArr242[c8]));
                                                                            int i1842 = $$b;
                                                                            ((Boolean) cls282.getMethod($$c((short) ((i1842 ^ Videoio.CAP_PROP_XI_IMAGE_DATA_FORMAT_RGB32_ALPHA) | (i1842 & Videoio.CAP_PROP_XI_IMAGE_DATA_FORMAT_RGB32_ALPHA)), bArr242[37], bArr242[8]), null).invoke(r10, null)).booleanValue();
                                                                            ((Boolean) Class.forName($$c(194, bArr242[c9], bArr242[c8])).getMethod($$c((short) (i1842 | Videoio.CAP_PROP_XI_IMAGE_DATA_FORMAT_RGB32_ALPHA), bArr242[37], bArr242[8]), null).invoke(obj11, null)).booleanValue();
                                                                            throw th;
                                                                        }
                                                                    } catch (Exception e5) {
                                                                        e = e5;
                                                                    } catch (Throwable th56) {
                                                                        th = th56;
                                                                    }
                                                                } catch (Throwable th57) {
                                                                    th = th57;
                                                                    str = str$$c4;
                                                                    zArr6 = zArr3;
                                                                }
                                                            } else {
                                                                Object obj13 = objNewInstance4;
                                                                str = str$$c4;
                                                                zArr6 = zArr3;
                                                                c12 = '%';
                                                                try {
                                                                    ?? cls29 = Class.forName($$c(719, bArr19[c9], bArr19[952]));
                                                                    ?? cls30 = Class.forName($$c(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, bArr19[c9], bArr19[191]));
                                                                    Object objNewInstance9 = cls29.getConstructor(new Class[]{cls30}).newInstance(obj13);
                                                                    Object objInvoke8 = cls29.getMethod($$c(746, bArr19[c7], bArr19[c8]), new Class[0]).invoke(objNewInstance9, new Object[0]);
                                                                    Method method6 = Class.forName($$c(757, bArr19[c9], bArr19[282])).getMethod($$c(778, bArr19[c7], bArr19[159]), new Class[0]);
                                                                    i82 = 8;
                                                                    try {
                                                                        method3 = cls30.getMethod($$c(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, bArr19[8], bArr19[45]), cls);
                                                                        try {
                                                                            Object objNewInstance10 = Class.forName($$c(Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, bArr19[c9], bArr19[451])).getDeclaredConstructor(Class.forName($$c(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, bArr19[c9], bArr19[191]))).newInstance(objNewInstance9);
                                                                            int i185 = $10;
                                                                            int i186 = (i185 ^ 37) + ((i185 & 37) << 1);
                                                                            $11 = i186 % 128;
                                                                            int i187 = i186 % 2;
                                                                            try {
                                                                                Object objInvoke9 = Class.class.getMethod($$c(TypedValues.TransitionType.TYPE_STAGGERED, bArr19[c7], bArr19[c9]), null).invoke(AFa1kSDK.class, null);
                                                                                ?? cls31 = Class.forName($$c(784, bArr19[c9], (byte) (-bArr19[288])));
                                                                                Object objNewInstance11 = cls31.getConstructor(new Class[0]).newInstance(new Object[0]);
                                                                                Method method7 = cls31.getMethod($$c(629, bArr19[c10], bArr19[c11]), cls, Integer.TYPE, Integer.TYPE);
                                                                                obj5 = objNewInstance3;
                                                                                Method method8 = cls31.getMethod($$c(812, bArr19[45], bArr19[c5]), new Class[0]);
                                                                                Method method9 = Class.forName($$c(822, bArr19[c9], bArr19[c7])).getMethod($$c(349, bArr19[c2], bArr19[c11]), new Class[0]);
                                                                                byte[] bArr25 = new byte[1024];
                                                                                int i188 = 0;
                                                                                ?? r33 = r3;
                                                                                while (true) {
                                                                                    int iIntValue3 = ((Integer) method3.invoke(objNewInstance10, bArr25)).intValue();
                                                                                    if (iIntValue3 <= 0) {
                                                                                        r532 = r33;
                                                                                        cls3 = cls2;
                                                                                        i23 = 0;
                                                                                        break;
                                                                                    }
                                                                                    ?? r533 = r33;
                                                                                    cls3 = cls2;
                                                                                    if (i188 >= ((Long) method6.invoke(objInvoke8, new Object[0])).longValue()) {
                                                                                        i23 = 0;
                                                                                        r532 = r533;
                                                                                        break;
                                                                                    } else {
                                                                                        method7.invoke(objNewInstance11, bArr25, 0, Integer.valueOf(iIntValue3));
                                                                                        int i189 = -(-iIntValue3);
                                                                                        i188 = ((i188 | i189) << 1) - (i189 ^ i188);
                                                                                        r33 = r533;
                                                                                        cls2 = cls3;
                                                                                    }
                                                                                }
                                                                                byte[] bArr26 = (byte[]) method8.invoke(objNewInstance11, new Object[i23]);
                                                                                try {
                                                                                    method9.invoke(objNewInstance10, new Object[i23]);
                                                                                    method9.invoke(objNewInstance11, new Object[i23]);
                                                                                } catch (Exception unused11) {
                                                                                }
                                                                                byte[] bArr27 = $$a;
                                                                                ?? cls32 = Class.forName($$c(838, bArr27[37], bArr27[239]));
                                                                                method3 = new Class[]{Class.forName($$c(873, bArr27[c9], bArr27[191])), Class.forName($$c(891, bArr27[c9], bArr27[c2]))};
                                                                                Constructor declaredConstructor = cls32.getDeclaredConstructor(method3);
                                                                                try {
                                                                                    ?? cls33 = Class.forName($$c(873, bArr27[c9], bArr27[191]));
                                                                                    method3 = $$c(911, bArr27[c10], bArr27[45]);
                                                                                    objInvoke4 = declaredConstructor.newInstance(cls33.getMethod(method3, cls).invoke(null, bArr26), objInvoke9);
                                                                                    try {
                                                                                        Class<?> cls34 = Class.forName($$c(914, bArr27[37], bArr27[320]));
                                                                                        byte b8 = bArr27[15];
                                                                                        Field declaredField = cls34.getDeclaredField($$c(945, b8, b8));
                                                                                        declaredField.setAccessible(true);
                                                                                        Object obj14 = declaredField.get(objInvoke9);
                                                                                        Class<?> cls35 = obj14.getClass();
                                                                                        i10 = 5;
                                                                                        try {
                                                                                            Field declaredField2 = cls35.getDeclaredField($$c(952, bArr27[5], bArr27[c]));
                                                                                            declaredField2.setAccessible(true);
                                                                                            i10 = 5;
                                                                                            Field declaredField3 = cls35.getDeclaredField($$c(975, bArr27[5], bArr27[961]));
                                                                                            declaredField3.setAccessible(true);
                                                                                            Object obj15 = declaredField2.get(obj14);
                                                                                            Object obj16 = declaredField3.get(obj14);
                                                                                            Object obj17 = declaredField.get(objInvoke4);
                                                                                            ArrayList arrayList = new ArrayList((List) obj15);
                                                                                            try {
                                                                                                Class cls36 = (Class) Class.class.getMethod($$c(999, bArr27[c7], bArr27[608]), null).invoke(obj16.getClass(), null);
                                                                                                int length3 = Array.getLength(obj16);
                                                                                                Object objNewInstance12 = Array.newInstance((Class<?>) cls36, length3);
                                                                                                for (int i190 = 0; i190 < length3; i190 = ((i190 | 1) << 1) - (i190 ^ 1)) {
                                                                                                    Array.set(objNewInstance12, i190, Array.get(obj16, i190));
                                                                                                }
                                                                                                declaredField2.set(obj17, arrayList);
                                                                                                declaredField3.set(obj17, objNewInstance12);
                                                                                                int i191 = 2 % 2;
                                                                                                int i192 = $10 + 57;
                                                                                                $11 = i192 % 128;
                                                                                                int i193 = i192 % 2;
                                                                                                r53 = r532;
                                                                                                if (e == null) {
                                                                                                    e = objInvoke4;
                                                                                                    r53 = r532;
                                                                                                }
                                                                                            } catch (Throwable th58) {
                                                                                                method3 = r532;
                                                                                                i82 = 8;
                                                                                                i10 = 5;
                                                                                                try {
                                                                                                    Throwable cause30 = th58.getCause();
                                                                                                    if (cause30 == null) {
                                                                                                        throw th58;
                                                                                                    }
                                                                                                    throw cause30;
                                                                                                } catch (Exception e6) {
                                                                                                    e = e6;
                                                                                                    StringBuilder sb5 = new StringBuilder();
                                                                                                    byte[] bArr28 = $$a;
                                                                                                    try {
                                                                                                        throw ((Throwable) Class.forName($$c(292, bArr28[c9], bArr28[191])).getDeclaredConstructor(String.class, Throwable.class).newInstance(sb5.append($$c(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, bArr28[102], bArr28[c11])).append(objInvoke9).append($$c(292, bArr28[1116], bArr28[c10])).toString(), e));
                                                                                                    } catch (Throwable th59) {
                                                                                                        Throwable cause31 = th59.getCause();
                                                                                                        if (cause31 == null) {
                                                                                                            throw th59;
                                                                                                        }
                                                                                                        throw cause31;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        } catch (Exception e7) {
                                                                                            e = e7;
                                                                                            method3 = r532;
                                                                                            i82 = 8;
                                                                                        }
                                                                                    } catch (Exception e8) {
                                                                                        e = e8;
                                                                                        method3 = r532;
                                                                                        i82 = 8;
                                                                                        i10 = 5;
                                                                                    }
                                                                                } catch (Throwable th60) {
                                                                                    Throwable cause32 = th60.getCause();
                                                                                    if (cause32 == null) {
                                                                                        throw th60;
                                                                                    }
                                                                                    throw cause32;
                                                                                }
                                                                            } catch (Throwable th61) {
                                                                                Throwable cause33 = th61.getCause();
                                                                                if (cause33 == null) {
                                                                                    throw th61;
                                                                                }
                                                                                throw cause33;
                                                                            }
                                                                        } catch (Throwable th62) {
                                                                            Throwable cause34 = th62.getCause();
                                                                            if (cause34 == null) {
                                                                                throw th62;
                                                                            }
                                                                            throw cause34;
                                                                        }
                                                                    } catch (Throwable th63) {
                                                                        th = th63;
                                                                        method3 = r3;
                                                                        Invoke = Invoke;
                                                                        r43 = r43;
                                                                        i10 = 5;
                                                                    }
                                                                } catch (Throwable th64) {
                                                                    th = th64;
                                                                    r74 = r3;
                                                                    r13 = Invoke;
                                                                    r434 = r43;
                                                                    i82 = 8;
                                                                    Invoke = r13;
                                                                    method3 = r74;
                                                                    r43 = r434;
                                                                    i10 = 5;
                                                                    th = th;
                                                                    Invoke = Invoke;
                                                                    r7 = method3;
                                                                    r43 = r43;
                                                                    r7.close();
                                                                    throw th;
                                                                }
                                                            }
                                                            if (z4) {
                                                                try {
                                                                    byte[] bArr29 = $$a;
                                                                    Class<?> cls37 = Class.forName($$c(661, bArr29[c12], bArr29[c2]));
                                                                    Method declaredMethod2 = cls37.getDeclaredMethod($$c(PointerIconCompat.TYPE_ZOOM_IN, bArr29[c8], bArr29[198]), String.class, Class.forName($$c(891, bArr29[c9], bArr29[c2])));
                                                                    declaredMethod2.setAccessible(true);
                                                                    int i194 = $10;
                                                                    int i195 = (i194 & 123) + (i194 | 123);
                                                                    $11 = i195 % 128;
                                                                    int i196 = i195 % 2;
                                                                    try {
                                                                        Object objInvoke10 = Class.class.getMethod($$c(TypedValues.TransitionType.TYPE_STAGGERED, bArr29[c7], bArr29[c9]), null).invoke(AFa1kSDK.class, null);
                                                                        Object objInvoke11 = declaredMethod2.invoke(objInvoke4, str$$c3, objInvoke10);
                                                                        ?? r76 = objInvoke10;
                                                                        if (objInvoke11 != null) {
                                                                            int i197 = $10 + 43;
                                                                            $11 = i197 % 128;
                                                                            int i198 = i197 % 2;
                                                                            r76 = 349;
                                                                            cls37.getDeclaredMethod($$c(349, bArr29[c2], bArr29[c11]), new Class[0]).invoke(objInvoke4, new Object[0]);
                                                                        }
                                                                        objInvoke5 = objInvoke11;
                                                                        method3 = r76;
                                                                    } catch (Throwable th65) {
                                                                        Throwable cause35 = th65.getCause();
                                                                        if (cause35 == null) {
                                                                            throw th65;
                                                                        }
                                                                        throw cause35;
                                                                    }
                                                                } catch (Throwable th66) {
                                                                    th = th66;
                                                                    r72 = r53;
                                                                    r1 = Invoke;
                                                                    r432 = r43;
                                                                    i82 = 8;
                                                                    r15 = r1;
                                                                    r75 = r72;
                                                                    r435 = r432;
                                                                    i10 = 5;
                                                                    Invoke = r15;
                                                                    r7 = r75;
                                                                    r43 = r435;
                                                                    r7.close();
                                                                    throw th;
                                                                }
                                                            } else {
                                                                try {
                                                                    byte[] bArr30 = $$a;
                                                                    Method declaredMethod3 = Class.forName($$c(891, bArr30[c9], bArr30[c2])).getDeclaredMethod($$c(PointerIconCompat.TYPE_ZOOM_IN, bArr30[c8], bArr30[198]), String.class);
                                                                    try {
                                                                        declaredMethod3.setAccessible(true);
                                                                        objInvoke5 = declaredMethod3.invoke(objInvoke4, str$$c3);
                                                                        method3 = String.class;
                                                                    } catch (InvocationTargetException e9) {
                                                                        try {
                                                                            throw ((Exception) e9.getCause());
                                                                        } catch (ClassNotFoundException unused12) {
                                                                            objInvoke5 = null;
                                                                            method3 = String.class;
                                                                        }
                                                                    }
                                                                } catch (Throwable th67) {
                                                                    th = th67;
                                                                    r74 = r53;
                                                                    r13 = Invoke;
                                                                    r434 = r43;
                                                                    i82 = 8;
                                                                    Invoke = r13;
                                                                    method3 = r74;
                                                                    r43 = r434;
                                                                    i10 = 5;
                                                                }
                                                            }
                                                            if (objInvoke5 != null) {
                                                                int i199 = $10;
                                                                i10 = 5;
                                                                int i200 = ((i199 | 5) << 1) - (i199 ^ 5);
                                                                $11 = i200 % 128;
                                                                int i201 = i200 % 2;
                                                                try {
                                                                    cls2 = (Class) objInvoke5;
                                                                    byte[] bArr31 = $$a;
                                                                    str$$c3 = $$c(Imgcodecs.IMWRITE_GIF_QUALITY, bArr31[c2], bArr31[175]);
                                                                    Constructor declaredConstructor2 = cls2.getDeclaredConstructor(Object.class, Boolean.TYPE);
                                                                    declaredConstructor2.setAccessible(true);
                                                                    if (z4) {
                                                                        z6 = false;
                                                                    } else {
                                                                        int i202 = $10 + 57;
                                                                        $11 = i202 % 128;
                                                                        int i203 = i202 % 2;
                                                                        z6 = true;
                                                                    }
                                                                    w = declaredConstructor2.newInstance(objInvoke4, Boolean.valueOf(z6));
                                                                    byte[] bArr32 = new byte[13648];
                                                                    method3 = r53;
                                                                    try {
                                                                        try {
                                                                            try {
                                                                                Object objNewInstance13 = Class.forName($$c(Videoio.CAP_PROP_XI_GAMMAY, bArr31[c9], bArr31[c3])).getDeclaredConstructor(Class.forName($$c(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, bArr31[c9], bArr31[191]))).newInstance(Class.forName($$c(Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, bArr31[c9], bArr31[451])).getDeclaredConstructor(Class.forName($$c(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, bArr31[c9], bArr31[191]))).newInstance(method3.getInputStream(method3.getEntry($$c(1058, (byte) (-bArr31[727]), bArr31[52]).substring(1)))));
                                                                                int i204 = 2 % 2;
                                                                                System.currentTimeMillis();
                                                                                System.currentTimeMillis();
                                                                                try {
                                                                                    i82 = 8;
                                                                                    try {
                                                                                        Class.forName($$c(Videoio.CAP_PROP_XI_GAMMAY, bArr31[c9], bArr31[c3])).getMethod($$c(Videoio.CAP_PROP_XI_TRG_SELECTOR, bArr31[8], bArr31[198]), cls).invoke(objNewInstance13, bArr32);
                                                                                        try {
                                                                                            Class.forName($$c(Videoio.CAP_PROP_XI_GAMMAY, bArr31[c9], bArr31[c3])).getMethod($$c(349, bArr31[c2], bArr31[c11]), null).invoke(objNewInstance13, null);
                                                                                            r14 = Invoke;
                                                                                            zArr2 = zArr5;
                                                                                            r92 = r43;
                                                                                            obj3 = obj4;
                                                                                            i8 = i12;
                                                                                            objNewInstance3 = obj5;
                                                                                            str$$c4 = str;
                                                                                            zArr3 = zArr6;
                                                                                            r22 = 0;
                                                                                            i4 = 4;
                                                                                            i5 = 6;
                                                                                            Invoke = Math.abs(r47 == true ? 1 : 0);
                                                                                            bArr2 = bArr32;
                                                                                            i22 = 13609;
                                                                                            r3 = method3;
                                                                                        } catch (Throwable th68) {
                                                                                            Throwable cause36 = th68.getCause();
                                                                                            if (cause36 == null) {
                                                                                                throw th68;
                                                                                            }
                                                                                            throw cause36;
                                                                                        }
                                                                                    } catch (Throwable th69) {
                                                                                        th = th69;
                                                                                        Throwable cause37 = th.getCause();
                                                                                        if (cause37 == null) {
                                                                                            throw th;
                                                                                        }
                                                                                        throw cause37;
                                                                                    }
                                                                                } catch (Throwable th70) {
                                                                                    th = th70;
                                                                                }
                                                                            } catch (Throwable th71) {
                                                                                Throwable cause38 = th71.getCause();
                                                                                if (cause38 == null) {
                                                                                    throw th71;
                                                                                }
                                                                                throw cause38;
                                                                            }
                                                                        } catch (Throwable th72) {
                                                                            Throwable cause39 = th72.getCause();
                                                                            if (cause39 == null) {
                                                                                throw th72;
                                                                            }
                                                                            throw cause39;
                                                                        }
                                                                    } catch (Throwable th73) {
                                                                        th = th73;
                                                                        method3 = method3;
                                                                        i82 = 8;
                                                                        th = th;
                                                                        Invoke = Invoke;
                                                                        r7 = method3;
                                                                        r43 = r43;
                                                                        r7.close();
                                                                        throw th;
                                                                    }
                                                                } catch (Throwable th74) {
                                                                    th = th74;
                                                                    method3 = r53;
                                                                }
                                                            } else {
                                                                try {
                                                                    break;
                                                                } catch (Throwable th75) {
                                                                    th = th75;
                                                                }
                                                            }
                                                        } catch (Throwable th76) {
                                                            th = th76;
                                                            r73 = r3;
                                                            r12 = Invoke;
                                                            r433 = r43;
                                                            str = str$$c4;
                                                            zArr6 = zArr3;
                                                            r13 = r12;
                                                            r74 = r73;
                                                            r434 = r433;
                                                            i82 = 8;
                                                            Invoke = r13;
                                                            method3 = r74;
                                                            r43 = r434;
                                                            i10 = 5;
                                                            th = th;
                                                            Invoke = Invoke;
                                                            r7 = method3;
                                                            r43 = r43;
                                                            r7.close();
                                                            throw th;
                                                        }
                                                    } catch (Throwable th77) {
                                                        Throwable cause40 = th77.getCause();
                                                        if (cause40 == null) {
                                                            throw th77;
                                                        }
                                                        throw cause40;
                                                    }
                                                    th = th75;
                                                    th = th;
                                                    Invoke = Invoke;
                                                    r7 = method3;
                                                    r43 = r43;
                                                    try {
                                                        r7.close();
                                                        throw th;
                                                    } catch (Throwable th78) {
                                                        th.addSuppressed(th78);
                                                        throw th;
                                                    }
                                                }
                                            } catch (Throwable th79) {
                                                th = th79;
                                                i10 = 5;
                                                zArr5 = zArr2;
                                                r43 = r9;
                                                i12 = i8 == true ? 1 : 0;
                                                str = str$$c4;
                                                zArr6 = zArr3;
                                                Invoke = i9 == true ? 1 : 0;
                                                int iCurrentTimeMillis52 = (int) System.currentTimeMillis();
                                                int i922 = 369 - (~(-(-((Invoke == true ? 1 : 0) * 370))));
                                                int i932 = (~Invoke ? 1 : 0) | ((Invoke == true ? 1 : 0) & 1);
                                                int i942 = ~iCurrentTimeMillis52;
                                                int i952 = (i922 - (~(-(-((i932 | i942) * (-369)))))) - 1;
                                                int i962 = ~(((-2) & i942) | ((-2) ^ i942));
                                                int i972 = i952 + (((i962 & (Invoke == true ? 1 : 0)) | ((Invoke == true ? 1 : 0) ^ i962)) * (-369));
                                                int i982 = ~(Invoke == true ? 1 : 0);
                                                int i992 = ~((i982 & 1) | (i982 ^ 1));
                                                int i1002 = ~((iCurrentTimeMillis52 ^ 1) | (iCurrentTimeMillis52 & 1));
                                                int i1012 = (i992 & i1002) | (i992 ^ i1002);
                                                int i1022 = ~iCurrentTimeMillis52;
                                                int i1032 = (i1022 & (-2)) | ((-2) ^ i1022);
                                                int i1042 = ~((i1032 & (Invoke == true ? 1 : 0)) | (i1032 ^ (Invoke == true ? 1 : 0)));
                                                int i1052 = ((i1042 & i1012) | (i1012 ^ i1042)) * 369;
                                                i15 = (i972 ^ i1052) + ((i1052 & i972) << 1);
                                                while (i15 < 7) {
                                                }
                                                byte[] bArr112 = $$a;
                                                throw ((Throwable) Class.forName($$c(292, bArr112[c9], bArr112[191])).getDeclaredConstructor(String.class, Throwable.class).newInstance($$c(1106, bArr112[102], bArr112[c3]), th));
                                            }
                                            i9 = Invoke + 1;
                                            i28 = i14;
                                            i26 = i13;
                                            zArr2 = zArr5;
                                            i2 = i10;
                                            clsArr2 = clsArr;
                                            cls5 = cls;
                                            zArr = zArr4;
                                            r9 = r43;
                                            i7 = i11 == true ? 1 : 0;
                                            str$$c4 = str;
                                            zArr3 = zArr6;
                                            i3 = 194;
                                            i4 = 4;
                                            i5 = 6;
                                            z2 = z3;
                                        } catch (Throwable th80) {
                                            boolean z20 = i8 == true ? 1 : 0;
                                            boolean z21 = i9 == true ? 1 : 0;
                                            Throwable cause41 = th80.getCause();
                                            if (cause41 == null) {
                                                throw th80;
                                            }
                                            throw cause41;
                                        }
                                    } catch (Throwable th81) {
                                        boolean z22 = i8 == true ? 1 : 0;
                                        boolean z23 = i9 == true ? 1 : 0;
                                        Throwable cause42 = th81.getCause();
                                        if (cause42 == null) {
                                            throw th81;
                                        }
                                        throw cause42;
                                    }
                                }
                                i8 = i12;
                                i9 = Invoke + 1;
                                i28 = i14;
                                i26 = i13;
                                zArr2 = zArr5;
                                i2 = i10;
                                clsArr2 = clsArr;
                                cls5 = cls;
                                zArr = zArr4;
                                r9 = r43;
                                i7 = i11 == true ? 1 : 0;
                                str$$c4 = str;
                                zArr3 = zArr6;
                                i3 = 194;
                                i4 = 4;
                                i5 = 6;
                                z2 = z3;
                            }
                            return;
                        } catch (Throwable th82) {
                            Throwable cause43 = th82.getCause();
                            if (cause43 == null) {
                                throw th82;
                            }
                            throw cause43;
                        }
                    }
                    int i205 = $11;
                    int i206 = (i205 & 91) + (i205 | 91);
                    $10 = i206 % 128;
                    if (i206 % 2 != 0) {
                        int i207 = 48 / 0;
                    }
                    objNewInstance2 = null;
                }
                c8 = 219;
                c9 = 356;
                if (objInvoke3 == null) {
                }
                i2 = 5;
                if (objNewInstance == null) {
                    c10 = 'p';
                }
                byte[] bArr92 = $$a;
                i3 = 194;
                Object[] objArr32 = (Object[]) Array.newInstance(Class.forName($$c(194, bArr92[c9], bArr92[c8])), 7);
                objArr32[z ? 1 : 0] = null;
                objArr32[1] = objNewInstance;
                objArr32[2] = objNewInstance2;
                objArr32[3] = objInvoke3;
                objArr32[4] = objNewInstance;
                objArr32[5] = objNewInstance2;
                objArr32[6] = objInvoke3;
                zArr = new boolean[]{false, true, true, true, true, true, true};
                zArr2 = new boolean[]{false, false, false, false, true, true, true};
                i4 = 4;
                zArr3 = new boolean[7];
                zArr3[z ? 1 : 0] = z;
                zArr3[1] = z;
                zArr3[2] = true;
                zArr3[3] = true;
                zArr3[4] = z;
                zArr3[5] = true;
                zArr3[6] = true;
                int i812 = $$b;
                short s32 = (short) ((i812 ^ 80) | (i812 & 80));
                i5 = 6;
                int i822 = 8;
                Class<?> cls122 = Class.forName($$c(s32, bArr92[c3], bArr92[c]));
                i24 = cls122.getDeclaredField($$c(275, bArr92[90], bArr92[159])).getInt(cls122);
                if (i24 < 34) {
                }
                if (i24 != 29) {
                }
                i7 = i6;
                i8 = z ? 1 : 0;
                i9 = i8 == true ? 1 : 0;
                r9 = objArr32;
                z2 = z;
                while (i8 == 0) {
                    if (zArr3[i9 == true ? 1 : 0]) {
                    }
                    i8 = i12;
                    i9 = Invoke + 1;
                    i28 = i14;
                    i26 = i13;
                    zArr2 = zArr5;
                    i2 = i10;
                    clsArr2 = clsArr;
                    cls5 = cls;
                    zArr = zArr4;
                    r9 = r43;
                    i7 = i11 == true ? 1 : 0;
                    str$$c4 = str;
                    zArr3 = zArr6;
                    i3 = 194;
                    i4 = 4;
                    i5 = 6;
                    z2 = z3;
                }
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        } catch (Throwable th83) {
            Throwable cause44 = th83.getCause();
            if (cause44 == null) {
                throw th83;
            }
            throw cause44;
        }
    }

    private AFa1kSDK() {
    }

    public static int getMediationNetwork(Object obj) throws Throwable {
        int i2 = 2 % 2;
        int i3 = $10;
        int i4 = (i3 ^ 59) + ((i3 & 59) << 1);
        $11 = i4 % 128;
        int i5 = i4 % 2;
        Object obj2 = w;
        int i6 = (i3 & 53) + (i3 | 53);
        int i7 = i6 % 128;
        $11 = i7;
        int i8 = i6 % 2;
        int i9 = i7 + 33;
        $10 = i9 % 128;
        int i10 = i9 % 2;
        try {
            byte[] bArr = $$a;
            return ((Integer) Class.forName($$c(Videoio.CAP_PROP_XI_KNEEPOINT1, bArr[200], bArr[175]), true, (ClassLoader) e).getMethod($$c(1128, bArr[13], bArr[282]), Object.class).invoke(obj2, obj)).intValue();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static Object getMediationNetwork(char c, int i2, int i3) throws Throwable {
        int i4 = 2 % 2;
        int i5 = $10 + 33;
        int i6 = i5 % 128;
        $11 = i6;
        if (i5 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        Object obj2 = w;
        int i7 = i6 + 33;
        $10 = i7 % 128;
        int i8 = i7 % 2;
        int i9 = (i6 & 109) + (i6 | 109);
        $10 = i9 % 128;
        int i10 = i9 % 2;
        try {
            return Class.forName($$c(Videoio.CAP_PROP_XI_KNEEPOINT1, r7[200], r7[175]), true, (ClassLoader) e).getMethod($$c(Videoio.CAP_PROP_XI_REGION_MODE, (byte) (-$$a[188]), r7[43]), Character.TYPE, Integer.TYPE, Integer.TYPE).invoke(obj2, Character.valueOf(c), Integer.valueOf(i2), Integer.valueOf(i3));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static void getMonetizationNetwork(int i2, int i3) {
        int i4 = 2 % 2;
        int i5 = $10 + 67;
        $11 = i5 % 128;
        if (i5 % 2 == 0) {
            throw null;
        }
    }

    public static int getRevenue(int i2) throws Throwable {
        int i3 = 2 % 2;
        int i4 = $10;
        int i5 = (i4 ^ 91) + ((i4 & 91) << 1);
        $11 = i5 % 128;
        if (i5 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        Object obj2 = w;
        int i6 = (i4 & 95) + (i4 | 95);
        int i7 = i6 % 128;
        $11 = i7;
        int i8 = i6 % 2;
        int i9 = ((i7 | 25) << 1) - (i7 ^ 25);
        $10 = i9 % 128;
        int i10 = i9 % 2;
        try {
            int iIntValue = ((Integer) Class.forName($$c(Videoio.CAP_PROP_XI_KNEEPOINT1, r1[200], r1[175]), true, (ClassLoader) e).getMethod($$c(Videoio.CAP_PROP_XI_REGION_MODE, (byte) (-$$a[188]), r1[43]), Integer.TYPE).invoke(obj2, Integer.valueOf(i2))).intValue();
            int i11 = $11 + 115;
            $10 = i11 % 128;
            if (i11 % 2 != 0) {
                int i12 = 11 / 0;
            }
            return iIntValue;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    static void init$0() {
        int i2;
        int i3 = 2 % 2;
        int i4 = $10 + 97;
        $11 = i4 % 128;
        if (i4 % 2 == 0) {
            byte[] bArr = new byte[1153];
            System.arraycopy("j¢®Pò\tñ\u0002\u0005\u00045Æô\u0010ð\u0007þ\u0005ïDêÓ\u0002üü\n\u0004ó\u0001=Íðÿü\fùò\u0013òBÅúù\u000eò\u0003\fô<íúã0·%\u000eø÷ÿó\u0001>Ìðÿü\fùò\u0013òò\tñ\u0002\u0005\u00045ÌðÿAìÝî\nò\fôú$ëõ\f\u0003üí\u0002ÿ\föù2Ðÿ\u0003\u0002\u0005\u0001ì\nù\u0000ò\tñ\u0002\u0005\u00045ÌðÿAìÐÿ(Úü\f\u0000ôø\u0001ð*Ú\u0004ô\n\u0007ô*Ðÿ\u0003\u0002\u0005\u0001ì\nù\u0000\u0001ð-Üü\u0006ñ.Úö\u0001ð0Ó\nþ!áýú\u0002 Úö\u0001ð0áýú\u0002 ÚöÊ\u0002ì\u00121Ê\u0002ì\u00121\bê\u00142Äù@çÜü\u0006\bê\u00142Äù@¹\u0006ü\u000búö\bê\u00142Á\nò\u00068ÚÙ\u0005þ\u000e÷\u0001ð#Ý\u0002þ\nòýúó\nþ\u0005û\u0001ýú\u0002ò\tñ\u0002\u0005\u00045¾ûDëÌ\u000bü\u0007?Í\u0010òþ\tù\u0000\u000eøë\u0015úù\u0001ò\u0016ä\bô\u000e\u0014ù\u0015÷\bê\u00142Äù@äù\tÌ\u0014ýôû\nù\u0000í\u0002ÿ\föù\u001fêû\u0007\u0017ãüÿ\u0002õ\bê\u00142Äù@çÜü\u0006\u0015Ù\u0000\u0003ú\u0000 Þ\u0001\f\u0003óöüû\r\u0014ü\u0012÷Ííÿ\rð\u0000CËó\u0001=Íðÿü\fùò\u0013òBÅúù\u000eò\u0003\fô<ú\u0002Ë1úÿÓý5Í/Ë-ÿþ\u0000Ö3\u0001ð!ìñ\u0003ù\u0002\u000eý\bê\u00142¿\bðEØ\u0002\u0005\u0001ð#îì\u000b\bê\u00142Äù@ëÌ\u000eÿ\u0000ò\f\u0000\u001aÚýú\u0000 Þ\u0001\f\u0003ó\bê\u00142Äù@äÚýú\u0000 Þ\u0001\f\u0003ó\bê\u00142Äù@éâì\u0012\u0017Úýú\u0000 Þ\u0001\f\u0003ó\f\u0003ü\u001dÐ\bÿò\bê\u00142Äù@ëÈ\u0004\u000e#Îÿ\u0010ç/Úýú\u0000 Þ\u0001\f\u0003óó\u0001>Ìðÿü\fùò\u0013òCÄúù\u000eò\u0003\fô=ìúÚ9¼ \u000eøó\u0001>Ìðÿü\fùò\u0013òCÄúù\u000eò\u0003\fô=ìúã0·%\u000eø÷ÿú\u0004Ü\u0011ìî\u0010öø\u000f âì\u0012\u0007\u0001ø\f\u0003ü\rð!ì\u0003ü\u0014à\u0001ò\u0014û\u0013÷\u0004\bô\u000e\u0001ð-\u0001\bê\u00142Äù@çÜü\u0006 Þñ\u000fð\bøû\u0004üù\n\n\u0002ôõ\fý<ºù\u0005þ\u000e÷>éÞì1Üü\u0006ü\rü\u001fÞì\u0001ð2Þî\u0003\u0002ö\u0000\u000e\u0014îì\u000bþø\u0006ð\u000e\u0001ð0Ö\níÿ&Ü\rüþò\bê\u00142¸\u0000\nü=³\u0010øAÓðø&Úýú\u0000 Þ\u0001\f\u0003ó\u0001ð%èì\u0003.Öù\u0001ø\bê\u00142¸\u0000\nü=³\u0010øAÓðø*Öù\u0001ø\u0001ð éî\u0014\bê\u00142Äù@ëÈ\u0004\u000e#Îÿ\u0010ç)Ù\u0000\u0003ú\u0000 Þ\u0001\f\u0003ó\u0004,È\u0004\u000e#Îÿ\u0010ç\bê\u00142Äù@êÖüû\r\u0003þõ\u0006\u0002ôõ\fý<ºù\u0005þ\u000e÷>äÚ ç÷ýüø4Þì4Ö\níÿ&Ü\rüþò\bê\u00142¿\u0004ù@ëÈ\u0004\u000e\"Ì\u000eÿ\u0000ò\bê\u00142Á\nò\u00068êÖ\níÿ&Ü\rüþò\u0004\u0010ð\u0002ôõ\fý<ºù\u0005þ\u000e÷>ëàí\r Þì4Ö\níÿ&Ü\rüþò\u000eì\u000b\u001bâõþ\fì\nò\u0010\u0018â\u0006ï\u0010îø4Úö\f\u0001î\u0004ü\b\u0003ñ\fì\nò\u0010\u0018â\u0006ï\u0010îø(îì\u000b\"Ø\u0006÷\u0007öù\u0000\u0001ð0Ó\u0001ü\u0000\u0000\böù\u001fÚ\b\n\u0014÷\u0017÷ü\rü Ö\níÿó\u0001=Íðÿü\fùò\u0013òBÅúù\u000eò\u0003\fô<íúä/Å\u0017\u000eø&¯Ííÿ\rð\u0000CËó\u0001=Íðÿü\fùò\u0013òBÅúù\u000eò\u0003\fô<úÍ\u0002+\u0005þù\u0003ÿÑ,Ð3ø\u0006öÖ4\u0014ø\u0016÷¹þN¹\u0004ôÿ\t\u0000ý÷÷R³\u0006þñJ\u0001ð0Í\u0002ÿ\fö\né/Õ\u0003:\u0001\u0000ùóÓ\nþ".getBytes("ISO-8859-1"), 0, bArr, 0, 1153);
            $$a = bArr;
            i2 = 24963;
        } else {
            byte[] bArr2 = new byte[1153];
            System.arraycopy("j¢®Pò\tñ\u0002\u0005\u00045Æô\u0010ð\u0007þ\u0005ïDêÓ\u0002üü\n\u0004ó\u0001=Íðÿü\fùò\u0013òBÅúù\u000eò\u0003\fô<íúã0·%\u000eø÷ÿó\u0001>Ìðÿü\fùò\u0013òò\tñ\u0002\u0005\u00045ÌðÿAìÝî\nò\fôú$ëõ\f\u0003üí\u0002ÿ\föù2Ðÿ\u0003\u0002\u0005\u0001ì\nù\u0000ò\tñ\u0002\u0005\u00045ÌðÿAìÐÿ(Úü\f\u0000ôø\u0001ð*Ú\u0004ô\n\u0007ô*Ðÿ\u0003\u0002\u0005\u0001ì\nù\u0000\u0001ð-Üü\u0006ñ.Úö\u0001ð0Ó\nþ!áýú\u0002 Úö\u0001ð0áýú\u0002 ÚöÊ\u0002ì\u00121Ê\u0002ì\u00121\bê\u00142Äù@çÜü\u0006\bê\u00142Äù@¹\u0006ü\u000búö\bê\u00142Á\nò\u00068ÚÙ\u0005þ\u000e÷\u0001ð#Ý\u0002þ\nòýúó\nþ\u0005û\u0001ýú\u0002ò\tñ\u0002\u0005\u00045¾ûDëÌ\u000bü\u0007?Í\u0010òþ\tù\u0000\u000eøë\u0015úù\u0001ò\u0016ä\bô\u000e\u0014ù\u0015÷\bê\u00142Äù@äù\tÌ\u0014ýôû\nù\u0000í\u0002ÿ\föù\u001fêû\u0007\u0017ãüÿ\u0002õ\bê\u00142Äù@çÜü\u0006\u0015Ù\u0000\u0003ú\u0000 Þ\u0001\f\u0003óöüû\r\u0014ü\u0012÷Ííÿ\rð\u0000CËó\u0001=Íðÿü\fùò\u0013òBÅúù\u000eò\u0003\fô<ú\u0002Ë1úÿÓý5Í/Ë-ÿþ\u0000Ö3\u0001ð!ìñ\u0003ù\u0002\u000eý\bê\u00142¿\bðEØ\u0002\u0005\u0001ð#îì\u000b\bê\u00142Äù@ëÌ\u000eÿ\u0000ò\f\u0000\u001aÚýú\u0000 Þ\u0001\f\u0003ó\bê\u00142Äù@äÚýú\u0000 Þ\u0001\f\u0003ó\bê\u00142Äù@éâì\u0012\u0017Úýú\u0000 Þ\u0001\f\u0003ó\f\u0003ü\u001dÐ\bÿò\bê\u00142Äù@ëÈ\u0004\u000e#Îÿ\u0010ç/Úýú\u0000 Þ\u0001\f\u0003óó\u0001>Ìðÿü\fùò\u0013òCÄúù\u000eò\u0003\fô=ìúÚ9¼ \u000eøó\u0001>Ìðÿü\fùò\u0013òCÄúù\u000eò\u0003\fô=ìúã0·%\u000eø÷ÿú\u0004Ü\u0011ìî\u0010öø\u000f âì\u0012\u0007\u0001ø\f\u0003ü\rð!ì\u0003ü\u0014à\u0001ò\u0014û\u0013÷\u0004\bô\u000e\u0001ð-\u0001\bê\u00142Äù@çÜü\u0006 Þñ\u000fð\bøû\u0004üù\n\n\u0002ôõ\fý<ºù\u0005þ\u000e÷>éÞì1Üü\u0006ü\rü\u001fÞì\u0001ð2Þî\u0003\u0002ö\u0000\u000e\u0014îì\u000bþø\u0006ð\u000e\u0001ð0Ö\níÿ&Ü\rüþò\bê\u00142¸\u0000\nü=³\u0010øAÓðø&Úýú\u0000 Þ\u0001\f\u0003ó\u0001ð%èì\u0003.Öù\u0001ø\bê\u00142¸\u0000\nü=³\u0010øAÓðø*Öù\u0001ø\u0001ð éî\u0014\bê\u00142Äù@ëÈ\u0004\u000e#Îÿ\u0010ç)Ù\u0000\u0003ú\u0000 Þ\u0001\f\u0003ó\u0004,È\u0004\u000e#Îÿ\u0010ç\bê\u00142Äù@êÖüû\r\u0003þõ\u0006\u0002ôõ\fý<ºù\u0005þ\u000e÷>äÚ ç÷ýüø4Þì4Ö\níÿ&Ü\rüþò\bê\u00142¿\u0004ù@ëÈ\u0004\u000e\"Ì\u000eÿ\u0000ò\bê\u00142Á\nò\u00068êÖ\níÿ&Ü\rüþò\u0004\u0010ð\u0002ôõ\fý<ºù\u0005þ\u000e÷>ëàí\r Þì4Ö\níÿ&Ü\rüþò\u000eì\u000b\u001bâõþ\fì\nò\u0010\u0018â\u0006ï\u0010îø4Úö\f\u0001î\u0004ü\b\u0003ñ\fì\nò\u0010\u0018â\u0006ï\u0010îø(îì\u000b\"Ø\u0006÷\u0007öù\u0000\u0001ð0Ó\u0001ü\u0000\u0000\böù\u001fÚ\b\n\u0014÷\u0017÷ü\rü Ö\níÿó\u0001=Íðÿü\fùò\u0013òBÅúù\u000eò\u0003\fô<íúä/Å\u0017\u000eø&¯Ííÿ\rð\u0000CËó\u0001=Íðÿü\fùò\u0013òBÅúù\u000eò\u0003\fô<úÍ\u0002+\u0005þù\u0003ÿÑ,Ð3ø\u0006öÖ4\u0014ø\u0016÷¹þN¹\u0004ôÿ\t\u0000ý÷÷R³\u0006þñJ\u0001ð0Í\u0002ÿ\fö\né/Õ\u0003:\u0001\u0000ùóÓ\nþ".getBytes("ISO-8859-1"), 0, bArr2, 0, 1153);
            $$a = bArr2;
            i2 = 172;
        }
        $$b = i2;
    }
}
