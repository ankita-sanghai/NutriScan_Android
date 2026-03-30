-keepnames class com.ankita.nutriscan.core.network.model.OpenFoodFactsSearchResponse
-if class com.ankita.nutriscan.core.network.model.OpenFoodFactsSearchResponse
-keep class com.ankita.nutriscan.core.network.model.OpenFoodFactsSearchResponseJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.ankita.nutriscan.core.network.model.OpenFoodFactsSearchResponse
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-keepclassmembers class com.ankita.nutriscan.core.network.model.OpenFoodFactsSearchResponse {
    public synthetic <init>(java.util.List,int,int,int,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
