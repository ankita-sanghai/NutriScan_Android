package com.ankita.nutriscan.core.database.di;

import com.ankita.nutriscan.core.database.NutriScanDatabase;
import com.ankita.nutriscan.core.database.dao.FoodCacheDao;
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
public final class DatabaseModule_ProvideFoodCacheDaoFactory implements Factory<FoodCacheDao> {
  private final Provider<NutriScanDatabase> dbProvider;

  public DatabaseModule_ProvideFoodCacheDaoFactory(Provider<NutriScanDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public FoodCacheDao get() {
    return provideFoodCacheDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideFoodCacheDaoFactory create(
      javax.inject.Provider<NutriScanDatabase> dbProvider) {
    return new DatabaseModule_ProvideFoodCacheDaoFactory(Providers.asDaggerProvider(dbProvider));
  }

  public static DatabaseModule_ProvideFoodCacheDaoFactory create(
      Provider<NutriScanDatabase> dbProvider) {
    return new DatabaseModule_ProvideFoodCacheDaoFactory(dbProvider);
  }

  public static FoodCacheDao provideFoodCacheDao(NutriScanDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideFoodCacheDao(db));
  }
}
