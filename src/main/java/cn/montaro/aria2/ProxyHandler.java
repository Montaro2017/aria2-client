package cn.montaro.aria2;

import cn.montaro.aria2.utils.MethodHandlesUtil;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class ProxyHandler implements InvocationHandler {

    private static final Map<String, Invocation> INVOCATION_MAP = new HashMap<>();

    static {
        INVOCATION_MAP.put("getClass", (self, args) -> self.getClass());
        INVOCATION_MAP.put("hashCode", (self, args) -> self.hashCode());
        INVOCATION_MAP.put("equals", (self, args) -> self.equals(args[0]));
        INVOCATION_MAP.put("clone", (self, args) -> self.clone());
        INVOCATION_MAP.put("toString", (self, args) -> self.toString());
        INVOCATION_MAP.put("notify", (self, args) -> {
            self.notify();
            return null;
        });
        INVOCATION_MAP.put("notifyAll", (self, args) -> {
            self.notifyAll();
            return null;
        });
        INVOCATION_MAP.put("wait", (self, args) -> {
            if (args == null) self.wait();
            else if (args.length == 1) {
                long timeout = Long.parseLong(String.valueOf(args[0]));
                self.wait(timeout);
            } else {
                long timeout = Long.parseLong(String.valueOf(args[0]));
                int nanos = Integer.parseInt(String.valueOf(args[1]));
                self.wait(timeout, nanos);
            }
            return null;
        });
    }

    private final Class<?> interfaceClass;
    private final MethodHandles.Lookup defaultMethodLookup;

    public ProxyHandler(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
        this.defaultMethodLookup = getDefaultMethodLookup(interfaceClass);
    }

    private MethodHandles.Lookup getDefaultMethodLookup(Class<?> interfaceClass) {
        return MethodHandlesUtil.lookup(interfaceClass);
    }

    private Object invokeDefaultMethod(Object proxy, Method method, Object[] args) throws Throwable {
        return defaultMethodLookup.findSpecial(
                interfaceClass,
                method.getName(),
                MethodType.methodType(method.getReturnType(), method.getParameterTypes()),
                interfaceClass
        ).bindTo(proxy).invokeWithArguments(args);
    }

    private boolean isObjectMethod(Method method) {
        return INVOCATION_MAP.containsKey(method.getName());
    }

    private Object invokeObjectMethod(Method method, Object[] args) throws Throwable {
        return INVOCATION_MAP.getOrDefault(method.getName(), (self, args1) -> {
            throw new UnsupportedOperationException(method.getName());
        }).invoke(this, args);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isDefault()) {
            return invokeDefaultMethod(proxy, method, args);
        }
        if (isObjectMethod(method)) {
            return invokeObjectMethod(method, args);
        }
        return invoke0(proxy, method, args);
    }

    public abstract Object invoke0(Object proxy, Method method, Object[] args) throws Throwable;

    @SuppressWarnings("all")
    protected interface Invocation {
        Object invoke(ProxyHandler self, Object[] args) throws Throwable;
    }
}
