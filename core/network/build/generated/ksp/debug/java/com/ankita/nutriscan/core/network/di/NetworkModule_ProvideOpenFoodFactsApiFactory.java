package com.ankita.nutriscan.core.network.di;

import com.ankita.nutriscan.core.network.api.OpenFoodFactsApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
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
public final class NetworkModule_ProvideOpenFoodFactsApiFactory implements Factory<OpenFoodFactsApi> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideOpenFoodFactsApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public OpenFoodFactsApi get() {
    return provideOpenFoodFactsApi(retrofitProvider.get());
  }

  public static NetworkModule_ProvideOpenFoodFactsApiFactory create(
      javax.inject.Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideOpenFoodFactsApiFactory(Providers.asDaggerProvider(retrofitProvider));
  }

  public static NetworkModule_ProvideOpenFoodFactsApiFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideOpenFoodFactsApiFactory(retrofitProvider);
  }

  public static OpenFoodFactsApi provideOpenFoodFactsApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideOpenFoodFactsApi(retrofit));
  }
}
