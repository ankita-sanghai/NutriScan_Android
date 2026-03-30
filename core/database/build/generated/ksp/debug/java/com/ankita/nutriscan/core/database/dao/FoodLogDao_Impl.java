package com.ankita.nutriscan.core.database.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ankita.nutriscan.core.database.entity.FoodLogEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Float;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class FoodLogDao_Impl implements FoodLogDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FoodLogEntity> __insertionAdapterOfFoodLogEntity;

  private final EntityDeletionOrUpdateAdapter<FoodLogEntity> __deletionAdapterOfFoodLogEntity;

  public FoodLogDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFoodLogEntity = new EntityInsertionAdapter<FoodLogEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `food_log` (`id`,`foodId`,`foodName`,`brandName`,`calories`,`protein`,`carbs`,`fat`,`fiber`,`servingSize`,`servingUnit`,`mealType`,`loggedAt`,`dateKey`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FoodLogEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getFoodId());
        statement.bindString(3, entity.getFoodName());
        if (entity.getBrandName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getBrandName());
        }
        statement.bindDouble(5, entity.getCalories());
        statement.bindDouble(6, entity.getProtein());
        statement.bindDouble(7, entity.getCarbs());
        statement.bindDouble(8, entity.getFat());
        statement.bindDouble(9, entity.getFiber());
        statement.bindDouble(10, entity.getServingSize());
        statement.bindString(11, entity.getServingUnit());
        statement.bindString(12, entity.getMealType());
        statement.bindLong(13, entity.getLoggedAt());
        statement.bindString(14, entity.getDateKey());
      }
    };
    this.__deletionAdapterOfFoodLogEntity = new EntityDeletionOrUpdateAdapter<FoodLogEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `food_log` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FoodLogEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public Object insertFoodLog(final FoodLogEntity foodLog,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfFoodLogEntity.insertAndReturnId(foodLog);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteFoodLog(final FoodLogEntity foodLog,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFoodLogEntity.handle(foodLog);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<FoodLogEntity>> getFoodLogsForDate(final String dateKey) {
    final String _sql = "SELECT * FROM food_log WHERE dateKey = ? ORDER BY loggedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, dateKey);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"food_log"}, new Callable<List<FoodLogEntity>>() {
      @Override
      @NonNull
      public List<FoodLogEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFoodId = CursorUtil.getColumnIndexOrThrow(_cursor, "foodId");
          final int _cursorIndexOfFoodName = CursorUtil.getColumnIndexOrThrow(_cursor, "foodName");
          final int _cursorIndexOfBrandName = CursorUtil.getColumnIndexOrThrow(_cursor, "brandName");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "carbs");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfServingSize = CursorUtil.getColumnIndexOrThrow(_cursor, "servingSize");
          final int _cursorIndexOfServingUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "servingUnit");
          final int _cursorIndexOfMealType = CursorUtil.getColumnIndexOrThrow(_cursor, "mealType");
          final int _cursorIndexOfLoggedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "loggedAt");
          final int _cursorIndexOfDateKey = CursorUtil.getColumnIndexOrThrow(_cursor, "dateKey");
          final List<FoodLogEntity> _result = new ArrayList<FoodLogEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FoodLogEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpFoodId;
            _tmpFoodId = _cursor.getString(_cursorIndexOfFoodId);
            final String _tmpFoodName;
            _tmpFoodName = _cursor.getString(_cursorIndexOfFoodName);
            final String _tmpBrandName;
            if (_cursor.isNull(_cursorIndexOfBrandName)) {
              _tmpBrandName = null;
            } else {
              _tmpBrandName = _cursor.getString(_cursorIndexOfBrandName);
            }
            final float _tmpCalories;
            _tmpCalories = _cursor.getFloat(_cursorIndexOfCalories);
            final float _tmpProtein;
            _tmpProtein = _cursor.getFloat(_cursorIndexOfProtein);
            final float _tmpCarbs;
            _tmpCarbs = _cursor.getFloat(_cursorIndexOfCarbs);
            final float _tmpFat;
            _tmpFat = _cursor.getFloat(_cursorIndexOfFat);
            final float _tmpFiber;
            _tmpFiber = _cursor.getFloat(_cursorIndexOfFiber);
            final float _tmpServingSize;
            _tmpServingSize = _cursor.getFloat(_cursorIndexOfServingSize);
            final String _tmpServingUnit;
            _tmpServingUnit = _cursor.getString(_cursorIndexOfServingUnit);
            final String _tmpMealType;
            _tmpMealType = _cursor.getString(_cursorIndexOfMealType);
            final long _tmpLoggedAt;
            _tmpLoggedAt = _cursor.getLong(_cursorIndexOfLoggedAt);
            final String _tmpDateKey;
            _tmpDateKey = _cursor.getString(_cursorIndexOfDateKey);
            _item = new FoodLogEntity(_tmpId,_tmpFoodId,_tmpFoodName,_tmpBrandName,_tmpCalories,_tmpProtein,_tmpCarbs,_tmpFat,_tmpFiber,_tmpServingSize,_tmpServingUnit,_tmpMealType,_tmpLoggedAt,_tmpDateKey);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<DailySummary>> getDailySummaries(final String startDate, final String endDate) {
    final String _sql = "\n"
            + "        SELECT dateKey, SUM(calories) as totalCalories, SUM(protein) as totalProtein,\n"
            + "        SUM(carbs) as totalCarbs, SUM(fat) as totalFat\n"
            + "        FROM food_log\n"
            + "        WHERE dateKey BETWEEN ? AND ?\n"
            + "        GROUP BY dateKey\n"
            + "        ORDER BY dateKey DESC\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindString(_argIndex, startDate);
    _argIndex = 2;
    _statement.bindString(_argIndex, endDate);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"food_log"}, new Callable<List<DailySummary>>() {
      @Override
      @NonNull
      public List<DailySummary> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDateKey = 0;
          final int _cursorIndexOfTotalCalories = 1;
          final int _cursorIndexOfTotalProtein = 2;
          final int _cursorIndexOfTotalCarbs = 3;
          final int _cursorIndexOfTotalFat = 4;
          final List<DailySummary> _result = new ArrayList<DailySummary>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DailySummary _item;
            final String _tmpDateKey;
            _tmpDateKey = _cursor.getString(_cursorIndexOfDateKey);
            final float _tmpTotalCalories;
            _tmpTotalCalories = _cursor.getFloat(_cursorIndexOfTotalCalories);
            final float _tmpTotalProtein;
            _tmpTotalProtein = _cursor.getFloat(_cursorIndexOfTotalProtein);
            final float _tmpTotalCarbs;
            _tmpTotalCarbs = _cursor.getFloat(_cursorIndexOfTotalCarbs);
            final float _tmpTotalFat;
            _tmpTotalFat = _cursor.getFloat(_cursorIndexOfTotalFat);
            _item = new DailySummary(_tmpDateKey,_tmpTotalCalories,_tmpTotalProtein,_tmpTotalCarbs,_tmpTotalFat);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Float> getTotalCaloriesForDate(final String dateKey) {
    final String _sql = "SELECT SUM(calories) FROM food_log WHERE dateKey = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, dateKey);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"food_log"}, new Callable<Float>() {
      @Override
      @Nullable
      public Float call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Float _result;
          if (_cursor.moveToFirst()) {
            final Float _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getFloat(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
