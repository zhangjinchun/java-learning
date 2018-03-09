package db;

/**
 * 动态数据源
 * @author Raye
 * @since 2016年10月25日15:20:40
 */
public class DynamicDataSource {
    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<DatabaseType>();

    protected Object determineCurrentLookupKey() {
        return contextHolder.get();
    }

    public static enum DatabaseType {
        Master, Slave
    }

    public static void master(){
        contextHolder.set(DatabaseType.Master);
    }

    public static void slave(){
        contextHolder.set(DatabaseType.Slave);
    }

    public static void setDatabaseType(DatabaseType type) {
        contextHolder.set(type);
    }

    public static DatabaseType getType(){
        return contextHolder.get();
    }
}