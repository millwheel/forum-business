import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.Locale

class CountryCodePrintTest {

    @Test
    @DisplayName("ISO 국가들의 언어 코드 및 국가 코드 출력")
    fun getISOCountries() {
        val isoCountries = Locale.getISOCountries()
        for (country in isoCountries) {
            val primaryLocale = findPrimaryLocaleForCountry(country)
            if (primaryLocale != null) {
                println(
                    "언어 코드: ${primaryLocale.language} | " +
                            "2글자 국가 코드: ${primaryLocale.country} | " +
                            "3글자 국가 코드: ${primaryLocale.isO3Country} | " +
                            "한글 국가명: ${primaryLocale.getDisplayCountry(Locale.KOREAN)} | " +
                            "영문 국가명: ${primaryLocale.getDisplayCountry(Locale.ENGLISH)} | " +
                            "원국어 국가명: ${primaryLocale.getDisplayCountry(primaryLocale)}"
                )
            }
        }
    }

    private fun findPrimaryLocaleForCountry(country: String): Locale? {
        val availableLocales = Locale.getAvailableLocales()
        return availableLocales.firstOrNull { it.country == country && it.language.isNotEmpty() }
    }
}
