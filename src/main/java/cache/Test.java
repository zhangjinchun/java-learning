package cache;

/**
 * @author zhangjinchun
 * @date 2018/2/22
 */ //测试类，
class Test {
    public static void main(String[] args) {
        System.out.println(CacheManager.getSimpleFlag("alksd"));

        CacheManager.putCache("abc", new Cache());
        CacheManager.putCache("def", new Cache());
        CacheManager.putCache("ccc", new Cache());
        CacheManager.clearOnly("");
        Cache c = new Cache();
        for (int i = 0; i < 10; i++) {
            CacheManager.putCache("" + i, c);
        }
        CacheManager.putCache("aaaaaaaa", c);
        CacheManager.setSimpleFlag("alksd", true);
        CacheManager.putCache("abchcy;alskd", c);
        CacheManager.putCache("cccccccc", c);
        CacheManager.putCache("abcoqiwhcy", c);
        System.out.println("删除前的大小："+CacheManager.getCacheSize());
        CacheManager.getCacheAllkey();
        CacheManager.clearAll("aaaa");
        System.out.println("删除后的大小："+CacheManager.getCacheSize());
        CacheManager.getCacheAllkey();


        System.out.println(CacheManager.getSimpleFlag("alksd"));
    }
}
