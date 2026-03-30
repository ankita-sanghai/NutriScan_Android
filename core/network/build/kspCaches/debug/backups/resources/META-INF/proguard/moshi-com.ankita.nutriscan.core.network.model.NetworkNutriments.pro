-keepnames class com.ankita.nutriscan.core.network.model.NetworkNutriments
-if class com.ankita.nutriscan.core.network.model.NetworkNutriments
-keep class com.ankita.nutriscan.core.network.model.NetworkNutrimentsJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.ankita.nutriscan.core.network.model.NetworkNutriments
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-keepclassmembers class com.ankita.nutriscan.core.network.model.NetworkNutriments {
    public synthetic <init>(java.lang.Float,java.lang.Float,java.lang.Float,java.lang.Float,java.lang.Float,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
