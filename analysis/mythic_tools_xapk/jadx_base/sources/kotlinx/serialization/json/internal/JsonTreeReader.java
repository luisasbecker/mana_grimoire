package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.DeepRecursiveScope;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: JsonTreeReader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\r\u001a\u00020\u000eH\u0082\u0080\u0004J\u001f\u0010\r\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\u000fH\u0082À\u0004¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015H\u0082\u0088\u0004J\n\u0010\u0016\u001a\u00020\u000eH\u0082\u0080\u0004J\u0012\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0082\u0080\u0004J\n\u0010\u001a\u001a\u00020\u000eH\u0086\u0080\u0004J\n\u0010\u001b\u001a\u00020\u000eH\u0082\u0080\u0004R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\tX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\tX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000b\u001a\u00020\fX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeReader;", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "lexer", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/AbstractJsonLexer;)V", "isLenient", "", "trailingCommaAllowed", "stackDepth", "", "readObject", "Lkotlinx/serialization/json/JsonElement;", "Lkotlin/DeepRecursiveScope;", "", "(Lkotlin/DeepRecursiveScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readObjectImpl", "Lkotlinx/serialization/json/JsonObject;", "reader", "Lkotlin/Function0;", "readArray", "readValue", "Lkotlinx/serialization/json/JsonPrimitive;", "isString", "read", "readDeepRecursive", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonTreeReader {
    private final boolean isLenient;
    private final AbstractJsonLexer lexer;
    private int stackDepth;
    private final boolean trailingCommaAllowed;

    /* JADX INFO: renamed from: kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1, reason: invalid class name */
    /* JADX INFO: compiled from: JsonTreeReader.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlinx/serialization/json/JsonElement;", "Lkotlin/DeepRecursiveScope;", "", "it"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", i = {0}, l = {113}, m = "invokeSuspend", n = {"$this$DeepRecursiveFunction"}, nl = {114}, s = {"L$0"}, v = 2)
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, JsonElement>, Unit, Continuation<? super JsonElement>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope, Unit unit, Continuation<? super JsonElement> continuation) {
            AnonymousClass1 anonymousClass1 = JsonTreeReader.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = deepRecursiveScope;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DeepRecursiveScope deepRecursiveScope = (DeepRecursiveScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                byte bPeekNextToken = JsonTreeReader.this.lexer.peekNextToken();
                if (bPeekNextToken == 1) {
                    return JsonTreeReader.this.readValue(true);
                }
                if (bPeekNextToken == 0) {
                    return JsonTreeReader.this.readValue(false);
                }
                if (bPeekNextToken != 6) {
                    JsonTreeReader jsonTreeReader = JsonTreeReader.this;
                    if (bPeekNextToken == 8) {
                        return jsonTreeReader.readArray();
                    }
                    AbstractJsonLexer.fail$default(jsonTreeReader.lexer, "Can't begin reading element, unexpected token", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(deepRecursiveScope);
                this.label = 1;
                obj = JsonTreeReader.this.readObject(deepRecursiveScope, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return (JsonElement) obj;
        }
    }

    /* JADX INFO: renamed from: kotlinx.serialization.json.internal.JsonTreeReader$readObject$2, reason: invalid class name */
    /* JADX INFO: compiled from: JsonTreeReader.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader", f = "JsonTreeReader.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {22}, m = "readObject", n = {"$this$readObject", "this_$iv", "result$iv", "key$iv", "$i$f$readObjectImpl", "lastToken$iv", "$i$a$-readObjectImpl-JsonTreeReader$readObject$3"}, nl = {127}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "B$0", "I$1"}, v = 2)
    static final class AnonymousClass2 extends ContinuationImpl {
        byte B$0;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JsonTreeReader.this.readObject(null, this);
        }
    }

    public JsonTreeReader(JsonConfiguration configuration, AbstractJsonLexer lexer) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        this.lexer = lexer;
        this.isLenient = configuration.getIsLenient();
        this.trailingCommaAllowed = configuration.getAllowTrailingComma();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonElement readArray() {
        byte bConsumeNextToken = this.lexer.consumeNextToken();
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        ArrayList arrayList = new ArrayList();
        while (this.lexer.canConsumeValue()) {
            arrayList.add(read());
            bConsumeNextToken = this.lexer.consumeNextToken();
            if (bConsumeNextToken != 4) {
                AbstractJsonLexer abstractJsonLexer = this.lexer;
                boolean z = bConsumeNextToken == 9;
                int i = abstractJsonLexer.currentPosition;
                if (!z) {
                    AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected end of the array or comma", i, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (bConsumeNextToken == 8) {
            this.lexer.consumeNextToken((byte) 9);
        } else if (bConsumeNextToken == 4) {
            boolean z2 = this.trailingCommaAllowed;
            AbstractJsonLexer abstractJsonLexer2 = this.lexer;
            if (!z2) {
                JsonExceptionsKt.invalidTrailingComma(abstractJsonLexer2, "array");
                throw new KotlinNothingValueException();
            }
            abstractJsonLexer2.consumeNextToken((byte) 9);
        }
        return new JsonArray(arrayList);
    }

    private final JsonElement readDeepRecursive() {
        return (JsonElement) DeepRecursiveKt.invoke(new DeepRecursiveFunction(new AnonymousClass1(null)), Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ab -> B:27:0x00b1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readObject(DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope, Continuation<? super JsonElement> continuation) {
        AnonymousClass2 anonymousClass2;
        AnonymousClass2 anonymousClass22;
        LinkedHashMap linkedHashMap;
        int i;
        byte bConsumeNextToken;
        DeepRecursiveScope deepRecursiveScope2;
        JsonTreeReader jsonTreeReader = this;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            if ((anonymousClass2.label & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass2 = jsonTreeReader.new AnonymousClass2(continuation);
            }
        }
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            byte bConsumeNextToken2 = jsonTreeReader.lexer.consumeNextToken((byte) 6);
            if (jsonTreeReader.lexer.peekNextToken() == 4) {
                AbstractJsonLexer.fail$default(jsonTreeReader.lexer, "Unexpected leading comma", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            anonymousClass22 = anonymousClass2;
            linkedHashMap = new LinkedHashMap();
            i = 0;
            bConsumeNextToken = bConsumeNextToken2;
            deepRecursiveScope2 = deepRecursiveScope;
            if (jsonTreeReader.lexer.canConsumeValue()) {
            }
            if (bConsumeNextToken == 6) {
            }
            return new JsonObject(linkedHashMap);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i3 = anonymousClass2.I$1;
        byte b = anonymousClass2.B$0;
        int i4 = anonymousClass2.I$0;
        String str = (String) anonymousClass2.L$3;
        LinkedHashMap linkedHashMap2 = (LinkedHashMap) anonymousClass2.L$2;
        JsonTreeReader jsonTreeReader2 = (JsonTreeReader) anonymousClass2.L$1;
        DeepRecursiveScope deepRecursiveScope3 = (DeepRecursiveScope) anonymousClass2.L$0;
        ResultKt.throwOnFailure(obj);
        AnonymousClass2 anonymousClass23 = anonymousClass2;
        i = i4;
        jsonTreeReader = jsonTreeReader2;
        linkedHashMap = linkedHashMap2;
        anonymousClass22 = anonymousClass23;
        linkedHashMap.put(str, (JsonElement) obj);
        bConsumeNextToken = jsonTreeReader.lexer.consumeNextToken();
        if (bConsumeNextToken == 4) {
            if (bConsumeNextToken != 7) {
                AbstractJsonLexer.fail$default(jsonTreeReader.lexer, "Expected end of the object or comma", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            if (bConsumeNextToken == 6) {
                jsonTreeReader.lexer.consumeNextToken((byte) 7);
            } else if (bConsumeNextToken == 4) {
                if (!jsonTreeReader.trailingCommaAllowed) {
                    JsonExceptionsKt.invalidTrailingComma$default(jsonTreeReader.lexer, null, 1, null);
                    throw new KotlinNothingValueException();
                }
                jsonTreeReader.lexer.consumeNextToken((byte) 7);
            }
            return new JsonObject(linkedHashMap);
        }
        deepRecursiveScope2 = deepRecursiveScope3;
        if (jsonTreeReader.lexer.canConsumeValue()) {
            String strConsumeStringLenient = jsonTreeReader.isLenient ? jsonTreeReader.lexer.consumeStringLenient() : jsonTreeReader.lexer.consumeString();
            jsonTreeReader.lexer.consumeNextToken((byte) 5);
            Unit unit = Unit.INSTANCE;
            anonymousClass22.L$0 = deepRecursiveScope2;
            anonymousClass22.L$1 = jsonTreeReader;
            anonymousClass22.L$2 = linkedHashMap;
            anonymousClass22.L$3 = strConsumeStringLenient;
            anonymousClass22.I$0 = i;
            anonymousClass22.B$0 = bConsumeNextToken;
            anonymousClass22.I$1 = 0;
            anonymousClass22.label = 1;
            Object objCallRecursive = deepRecursiveScope2.callRecursive(unit, anonymousClass22);
            if (objCallRecursive == coroutine_suspended) {
                return coroutine_suspended;
            }
            String str2 = strConsumeStringLenient;
            deepRecursiveScope3 = deepRecursiveScope2;
            obj = objCallRecursive;
            str = str2;
            linkedHashMap.put(str, (JsonElement) obj);
            bConsumeNextToken = jsonTreeReader.lexer.consumeNextToken();
            if (bConsumeNextToken == 4) {
            }
        }
        if (bConsumeNextToken == 6) {
        }
        return new JsonObject(linkedHashMap);
    }

    private final JsonElement readObject() {
        byte bConsumeNextToken = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            if (!this.lexer.canConsumeValue()) {
                break;
            }
            boolean z = this.isLenient;
            AbstractJsonLexer abstractJsonLexer = this.lexer;
            String strConsumeStringLenient = z ? abstractJsonLexer.consumeStringLenient() : abstractJsonLexer.consumeString();
            this.lexer.consumeNextToken((byte) 5);
            linkedHashMap.put(strConsumeStringLenient, read());
            bConsumeNextToken = this.lexer.consumeNextToken();
            if (bConsumeNextToken != 4) {
                if (bConsumeNextToken != 7) {
                    AbstractJsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (bConsumeNextToken == 6) {
            this.lexer.consumeNextToken((byte) 7);
        } else if (bConsumeNextToken == 4) {
            boolean z2 = this.trailingCommaAllowed;
            AbstractJsonLexer abstractJsonLexer2 = this.lexer;
            if (!z2) {
                JsonExceptionsKt.invalidTrailingComma$default(abstractJsonLexer2, null, 1, null);
                throw new KotlinNothingValueException();
            }
            abstractJsonLexer2.consumeNextToken((byte) 7);
        }
        return new JsonObject(linkedHashMap);
    }

    private final JsonObject readObjectImpl(Function0<? extends JsonElement> reader) {
        byte bConsumeNextToken = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            if (!this.lexer.canConsumeValue()) {
                break;
            }
            boolean z = this.isLenient;
            AbstractJsonLexer abstractJsonLexer = this.lexer;
            String strConsumeStringLenient = z ? abstractJsonLexer.consumeStringLenient() : abstractJsonLexer.consumeString();
            this.lexer.consumeNextToken((byte) 5);
            linkedHashMap.put(strConsumeStringLenient, reader.invoke());
            bConsumeNextToken = this.lexer.consumeNextToken();
            if (bConsumeNextToken != 4) {
                if (bConsumeNextToken != 7) {
                    AbstractJsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (bConsumeNextToken == 6) {
            this.lexer.consumeNextToken((byte) 7);
        } else if (bConsumeNextToken == 4) {
            boolean z2 = this.trailingCommaAllowed;
            AbstractJsonLexer abstractJsonLexer2 = this.lexer;
            if (!z2) {
                JsonExceptionsKt.invalidTrailingComma$default(abstractJsonLexer2, null, 1, null);
                throw new KotlinNothingValueException();
            }
            abstractJsonLexer2.consumeNextToken((byte) 7);
        }
        return new JsonObject(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonPrimitive readValue(boolean isString) {
        String strConsumeStringLenient = (this.isLenient || !isString) ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
        return (isString || !Intrinsics.areEqual(strConsumeStringLenient, AbstractJsonLexerKt.NULL)) ? new JsonLiteral(strConsumeStringLenient, isString, null, 4, null) : JsonNull.INSTANCE;
    }

    public final JsonElement read() {
        byte bPeekNextToken = this.lexer.peekNextToken();
        if (bPeekNextToken == 1) {
            return readValue(true);
        }
        if (bPeekNextToken == 0) {
            return readValue(false);
        }
        if (bPeekNextToken != 6) {
            if (bPeekNextToken == 8) {
                return readArray();
            }
            AbstractJsonLexer.fail$default(this.lexer, "Cannot read Json element because of unexpected " + AbstractJsonLexerKt.tokenDescription(bPeekNextToken), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i = this.stackDepth + 1;
        this.stackDepth = i;
        this.stackDepth--;
        return i == 200 ? readDeepRecursive() : readObject();
    }
}
