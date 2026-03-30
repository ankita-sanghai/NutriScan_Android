package com.ankita.nutriscan.core.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.ankita.nutriscan.core.database.dao.FoodCacheDao;
import com.ankita.nutriscan.core.database.dao.FoodCacheDao_Impl;
import com.ankita.nutriscan.core.database.dao.FoodLogDao;
import com.ankita.nutriscan.core.database.dao.FoodLogDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class NutriScanDatabase_Impl extends NutriScanDatabase {
  private volatile FoodLogDao _foodLogDao;

  private volatile FoodCacheDao _foodCacheDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `food_log` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `foodId` TEXT NOT NULL, `foodName` TEXT NOT NULL, `brandName` TEXT, `calories` REAL NOT NULL, `protein` REAL NOT NULL, `carbs` REAL NOT NULL, `fat` REAL NOT NULL, `fiber` REAL NOT NULL, `servingSize` REAL NOT NULL, `servingUnit` TEXT NOT NULL, `mealType` TEXT NOT NULL, `loggedAt` INTEGER NOT NULL, `dateKey` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `food_cache` (`foodId` TEXT NOT NULL, `foodName` TEXT NOT NULL, `brandName` TEXT, `calories` REAL NOT NULL, `protein` REAL NOT NULL, `carbs` REAL NOT NULL, `fat` REAL NOT NULL, `fiber` REAL NOT NULL, `servingSize` REAL NOT NULL, `servingUnit` TEXT NOT NULL, `barcode` TEXT, `imageUrl` TEXT, `cachedAt` INTEGER NOT NULL, PRIMARY KEY(`foodId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `user_goal` (`id` INTEGER NOT NULL, `dailyCalories` INTEGER NOT NULL, `dailyProtein` INTEGER NOT NULL, `dailyCarbs` INTEGER NOT NULL, `dailyFat` INTEGER NOT NULL, `dailyFiber` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '81f80cccae363119e8fd10271ac15cb4')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `food_log`");
        db.execSQL("DROP TABLE IF EXISTS `food_cache`");
        db.execSQL("DROP TABLE IF EXISTS `user_goal`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsFoodLog = new HashMap<String, TableInfo.Column>(14);
        _columnsFoodLog.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodLog.put("foodId", new TableInfo.Column("foodId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodLog.put("foodName", new TableInfo.Column("foodName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodLog.put("brandName", new TableInfo.Column("brandName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodLog.put("calories", new TableInfo.Column("calories", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodLog.put("protein", new TableInfo.Column("protein", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodLog.put("carbs", new TableInfo.Column("carbs", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodLog.put("fat", new TableInfo.Column("fat", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodLog.put("fiber", new TableInfo.Column("fiber", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodLog.put("servingSize", new TableInfo.Column("servingSize", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodLog.put("servingUnit", new TableInfo.Column("servingUnit", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodLog.put("mealType", new TableInfo.Column("mealType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodLog.put("loggedAt", new TableInfo.Column("loggedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodLog.put("dateKey", new TableInfo.Column("dateKey", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFoodLog = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFoodLog = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFoodLog = new TableInfo("food_log", _columnsFoodLog, _foreignKeysFoodLog, _indicesFoodLog);
        final TableInfo _existingFoodLog = TableInfo.read(db, "food_log");
        if (!_infoFoodLog.equals(_existingFoodLog)) {
          return new RoomOpenHelper.ValidationResult(false, "food_log(com.ankita.nutriscan.core.database.entity.FoodLogEntity).\n"
                  + " Expected:\n" + _infoFoodLog + "\n"
                  + " Found:\n" + _existingFoodLog);
        }
        final HashMap<String, TableInfo.Column> _columnsFoodCache = new HashMap<String, TableInfo.Column>(13);
        _columnsFoodCache.put("foodId", new TableInfo.Column("foodId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodCache.put("foodName", new TableInfo.Column("foodName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodCache.put("brandName", new TableInfo.Column("brandName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodCache.put("calories", new TableInfo.Column("calories", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodCache.put("protein", new TableInfo.Column("protein", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodCache.put("carbs", new TableInfo.Column("carbs", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodCache.put("fat", new TableInfo.Column("fat", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodCache.put("fiber", new TableInfo.Column("fiber", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodCache.put("servingSize", new TableInfo.Column("servingSize", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodCache.put("servingUnit", new TableInfo.Column("servingUnit", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodCache.put("barcode", new TableInfo.Column("barcode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodCache.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodCache.put("cachedAt", new TableInfo.Column("cachedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFoodCache = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFoodCache = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFoodCache = new TableInfo("food_cache", _columnsFoodCache, _foreignKeysFoodCache, _indicesFoodCache);
        final TableInfo _existingFoodCache = TableInfo.read(db, "food_cache");
        if (!_infoFoodCache.equals(_existingFoodCache)) {
          return new RoomOpenHelper.ValidationResult(false, "food_cache(com.ankita.nutriscan.core.database.entity.FoodCacheEntity).\n"
                  + " Expected:\n" + _infoFoodCache + "\n"
                  + " Found:\n" + _existingFoodCache);
        }
        final HashMap<String, TableInfo.Column> _columnsUserGoal = new HashMap<String, TableInfo.Column>(6);
        _columnsUserGoal.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserGoal.put("dailyCalories", new TableInfo.Column("dailyCalories", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserGoal.put("dailyProtein", new TableInfo.Column("dailyProtein", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserGoal.put("dailyCarbs", new TableInfo.Column("dailyCarbs", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserGoal.put("dailyFat", new TableInfo.Column("dailyFat", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserGoal.put("dailyFiber", new TableInfo.Column("dailyFiber", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserGoal = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserGoal = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserGoal = new TableInfo("user_goal", _columnsUserGoal, _foreignKeysUserGoal, _indicesUserGoal);
        final TableInfo _existingUserGoal = TableInfo.read(db, "user_goal");
        if (!_infoUserGoal.equals(_existingUserGoal)) {
          return new RoomOpenHelper.ValidationResult(false, "user_goal(com.ankita.nutriscan.core.database.entity.UserGoalEntity).\n"
                  + " Expected:\n" + _infoUserGoal + "\n"
                  + " Found:\n" + _existingUserGoal);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "81f80cccae363119e8fd10271ac15cb4", "47a20b2012d7f5e2ff4bdfdd2a1cc1f3");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "food_log","food_cache","user_goal");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `food_log`");
      _db.execSQL("DELETE FROM `food_cache`");
      _db.execSQL("DELETE FROM `user_goal`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(FoodLogDao.class, FoodLogDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FoodCacheDao.class, FoodCacheDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public FoodLogDao foodLogDao() {
    if (_foodLogDao != null) {
      return _foodLogDao;
    } else {
      synchronized(this) {
        if(_foodLogDao == null) {
          _foodLogDao = new FoodLogDao_Impl(this);
        }
        return _foodLogDao;
      }
    }
  }

  @Override
  public FoodCacheDao foodCacheDao() {
    if (_foodCacheDao != null) {
      return _foodCacheDao;
    } else {
      synchronized(this) {
        if(_foodCacheDao == null) {
          _foodCacheDao = new FoodCacheDao_Impl(this);
        }
        return _foodCacheDao;
      }
    }
  }
}
