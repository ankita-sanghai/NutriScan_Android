-keepnames class com.ankita.nutriscan.core.network.model.NetworkFood
-if class com.ankita.nutriscan.core.network.model.NetworkFood
-keep class com.ankita.nutriscan.core.network.model.NetworkFoodJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.ankita.nutriscan.core.network.model.NetworkFood
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-keepclassmembers class com.ankita.nutriscan.core.network.model.NetworkFood {
    public synthetic <init>(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,com.ankita.nutriscan.core.network.model.NetworkNutriments,java.lang.String,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
