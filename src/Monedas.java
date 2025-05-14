import com.google.gson.annotations.SerializedName;

public record Monedas(@SerializedName("USD") float usd,
                      @SerializedName("BRL") float brl,
                      @SerializedName("COP") float cop,
                      @SerializedName("ARS") float ars,
                      @SerializedName("BOB") float bob) {
}
/*
ARS - Peso argentino

BOB - Boliviano boliviano

BRL - Real brasileño

COP - Peso colombiano

USD - Dólar estadounidense
*/