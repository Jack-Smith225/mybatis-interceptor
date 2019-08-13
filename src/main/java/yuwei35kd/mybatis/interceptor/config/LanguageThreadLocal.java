package yuwei35kd.mybatis.interceptor.config;

public class LanguageThreadLocal {
    private static final ThreadLocal<String> THREAD_LANGUAGE = new ThreadLocal<String>();

    public static String getLanguage() {
        return THREAD_LANGUAGE.get();
    }

    public static void setLanguage(String language) {
        THREAD_LANGUAGE.set(language);
    }

    public static void clearLanguage() {
        THREAD_LANGUAGE.remove();
    }
}
