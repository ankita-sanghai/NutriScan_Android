package com.ankita.nutriscan.core.database.di;

import com.ankita.nutriscan.core.database.NutriScanDatabase;
import com.ankita.nutriscan.core.database.dao.FoodLogDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class DatabaseModule_ProvideFoodLogDaoFactory implements Factory<FoodLogDao> {
  private final Provider<NutriScanDatabase> dbProvider;

  public DatabaseModule_ProvideFoodLogDaoFactory(Provider<NutriScanDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public FoodLogDao get() {
    return provideFoodLogDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideFoodLogDaoFactory create(
      javax.inject.Provider<NutriScanDatabase> dbProvider) {
    return new DatabaseModule_ProvideFoodLogDaoFactory(Providers.asDaggerProvider(dbProvider));
  }

  public static DatabaseModule_ProvideFoodLogDaoFactory create(
      Provider<NutriScanDatabase> dbProvider) {
    return new DatabaseModule_ProvideFoodLogDaoFactory(dbProvider);
  }

  public static FoodLogDao provideFoodLogDao(NutriScanDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideFoodLogDao(db));
  }
}
