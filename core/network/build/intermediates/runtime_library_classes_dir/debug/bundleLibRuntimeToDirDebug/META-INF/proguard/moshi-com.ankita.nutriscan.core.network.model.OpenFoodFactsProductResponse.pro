-keepnames class com.ankita.nutriscan.core.network.model.OpenFoodFactsProductResponse
-if class com.ankita.nutriscan.core.network.model.OpenFoodFactsProductResponse
-keep class com.ankita.nutriscan.core.network.model.OpenFoodFactsProductResponseJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.ankita.nutriscan.core.network.model.OpenFoodFactsProductResponse
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-keepclassmembers class com.ankita.nutriscan.core.network.model.OpenFoodFactsProductResponse {
    public synthetic <init>(com.ankita.nutriscan.core.network.model.NetworkFood,int,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
