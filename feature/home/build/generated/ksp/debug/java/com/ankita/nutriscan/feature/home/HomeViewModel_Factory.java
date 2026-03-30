package com.ankita.nutriscan.feature.home;

import com.ankita.nutriscan.core.database.dao.FoodLogDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<FoodLogDao> foodLogDaoProvider;

  public HomeViewModel_Factory(Provider<FoodLogDao> foodLogDaoProvider) {
    this.foodLogDaoProvider = foodLogDaoProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(foodLogDaoProvider.get());
  }

  public static HomeViewModel_Factory create(javax.inject.Provider<FoodLogDao> foodLogDaoProvider) {
    return new HomeViewModel_Factory(Providers.asDaggerProvider(foodLogDaoProvider));
  }

  public static HomeViewModel_Factory create(Provider<FoodLogDao> foodLogDaoProvider) {
    return new HomeViewModel_Factory(foodLogDaoProvider);
  }

  public static HomeViewModel newInstance(FoodLogDao foodLogDao) {
    return new HomeViewModel(foodLogDao);
  }
}
