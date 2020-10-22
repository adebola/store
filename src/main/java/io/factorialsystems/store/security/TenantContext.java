package io.factorialsystems.store.security;


public class TenantContext {
    private static ThreadLocal<Context> ctx = new ThreadLocal<>();

    public static String getCurrentTenant() {

        return ctx.get().getCurrentTenant();
    }

    public static String getCurrentUser() {

        return ctx.get().getCurrentUser();
    }

    public static void setContext(Context context ) {

       ctx.set(context);
    }

    public static void setUser(String username) {

        ctx.get().setCurrentUser(username);
    }

    public static void setTenant(String tenant) {

        ctx.get().setCurrentTenant(tenant);
    }

    public static void clear() {

        ctx.set(null);
    }
}
