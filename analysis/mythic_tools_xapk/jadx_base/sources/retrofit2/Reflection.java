package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes7.dex */
class Reflection {

    static final class Android24 extends Reflection {
        Android24() {
        }

        @Override // retrofit2.Reflection
        Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, @Nullable Object[] objArr) throws Throwable {
            return DefaultMethodSupport.invoke(method, cls, obj, objArr);
        }

        @Override // retrofit2.Reflection
        boolean isDefaultMethod(Method method) {
            return method.isDefault();
        }
    }

    static class Java8 extends Reflection {
        Java8() {
        }

        @Override // retrofit2.Reflection
        String describeMethodParameter(Method method, int i) {
            Parameter parameter = method.getParameters()[i];
            return parameter.isNamePresent() ? "parameter '" + parameter.getName() + '\'' : super.describeMethodParameter(method, i);
        }

        @Override // retrofit2.Reflection
        Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, @Nullable Object[] objArr) throws Throwable {
            return DefaultMethodSupport.invoke(method, cls, obj, objArr);
        }

        @Override // retrofit2.Reflection
        boolean isDefaultMethod(Method method) {
            return method.isDefault();
        }
    }

    Reflection() {
    }

    String describeMethodParameter(Method method, int i) {
        return "parameter #" + (i + 1);
    }

    @Nullable
    Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, @Nullable Object[] objArr) throws Throwable {
        throw new AssertionError();
    }

    boolean isDefaultMethod(Method method) {
        return false;
    }
}
