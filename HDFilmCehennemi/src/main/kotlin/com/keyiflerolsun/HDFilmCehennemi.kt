// ! https://github.com/hexated/cloudstream-extensions-hexated/blob/master/Hdfilmcehennemi/src/main/kotlin/com/hexated/Hdfilmcehennemi.kt

package com.keyiflerolsun

import android.util.Log
import org.jsoup.nodes.Element
import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*
import com.lagradost.cloudstream3.LoadResponse.Companion.addActors
import com.lagradost.cloudstream3.LoadResponse.Companion.addTrailer
import com.fasterxml.jackson.annotation.JsonProperty
import org.jsoup.Jsoup

class HDFilmCehennemi : MainAPI() {
    override var mainUrl              = "https://hdfilmcehennemi.com"
    override var name                 = "HDFilmCehennemi"
    override val hasMainPage          = true
    override var lang                 = "tr"
    override val hasQuickSearch       = true
    override val supportedTypes       = setOf(TvType.Movie, TvType.TvSeries)

    override val mainPage = mainPageOf(
        mainUrl to "Yeni Eklenen Filmler",
        "${mainUrl}/yabancidiziizle-2"                    to "Yeni Eklenen Diziler",
        "${mainUrl}/category/tavsiye-filmler-izle2"       to "Tavsiye Filmler",
        "${mainUrl}/imdb-7-puan-uzeri-filmler"            to "IMDB 7+ Filmler",
        "${mainUrl}/en-cok-yorumlananlar-1"               to "En Çok Yorumlananlar",
        "${mainUrl}/en-cok-begenilen-filmleri-izle"       to "En Çok Beğenilenler",
        "${mainUrl}/tur/aile-filmleri-izleyin-6"          to "Aile Filmleri",
        "${mainUrl}/tur/aksiyon-filmleri-izleyin-3"       to "Aksiyon Filmleri",
        "${mainUrl}/tur/animasyon-filmlerini-izleyin-4"   to "Animasyon Filmleri",
        "${mainUrl}/tur/belgesel-filmlerini-izle-1"       to "Belgesel Filmleri",
        "${mainUrl}/tur/bilim-kurgu-filmlerini-izleyin-2" to "Bilim Kurgu Filmleri",
        "${mainUrl}/tur/komedi-filmlerini-izleyin-1"      to "Komedi Filmleri",
        "${mainUrl}/tur/korku-filmlerini-izleyin-5"       to "Korku Filmleri",
        "${mainUrl}/tur/macera-filmlerini-izleyin-7"      to "Macera Filmleri",
        "${mainUrl}/tur/romantik-filmlerini-izleyin-8"    to "Romantik Filmleri",
        "${mainUrl}/tur/savas-filmlerini-izleyin-9"       to "Savaş Filmleri",
        "${mainUrl}/tur/gerilim-filmlerini-izleyin-10"    to "Gerilim Filmleri",
        "${mainUrl}/tur/gizem-filmlerini-izleyin-11"      to "Gizem Filmleri",
        "${mainUrl}/tur/fantastik-filmlerini-izleyin-12"  to "Fantastik Filmleri",
        "${mainUrl}/tur/dram-filmlerini-izleyin-13"       to "Dram Filmleri",
        "${mainUrl}/tur/suc-filmlerini-izleyin-14"        to "Suç Filmleri",
        "${mainUrl}/tur/tarih-filmlerini-izleyin-15"      to "Tarih Filmleri",
        "${mainUrl}/tur/spor-filmlerini-izleyin-16"       to "Spor Filmleri",
        "${mainUrl}/tur/muzikal-filmlerini-izleyin-17"    to "Müzikal Filmleri",
        "${mainUrl}/tur/biyografi-filmlerini-izleyin-18"  to "Biyografi Filmleri",
        "${mainUrl}/tur/western-filmlerini-izleyin-19"    to "Western Filmleri",
        "${mainUrl}/tur/kisa-film-izleyin-20"             to "Kısa Filmler",
        "${mainUrl}/tur/yerli-filmler-izleyin-21"         to "Yerli Filmler",
        "${mainUrl}/tur/yabanci-filmler-izleyin-22"       to "Yabancı Filmler",
        "${mainUrl}/tur/netflix-filmleri-izleyin-23"      to "Netflix Filmleri",
        "${mainUrl}/tur/disney-plus-filmleri-izleyin-24"  to "Disney+ Filmleri",
        "${mainUrl}/tur/amazon-prime-filmleri-izleyin-25" to "Amazon Prime Filmleri",
        "${mainUrl}/tur/blu-tv-filmleri-izleyin-26"        to "BluTV Filmleri",
        "${mainUrl}/tur/exxen-filmleri-izleyin-27"        to "Exxen Filmleri",
        "${mainUrl}/tur/puhu-tv-filmleri-izleyin-28"      to "PuhuTV Filmleri",
        "${mainUrl}/tur/tod-filmleri-izleyin-29"          to "TOD Filmleri",
        "${mainUrl}/tur/gain-filmleri-izleyin-30"         to "Gain Filmleri",
        "${mainUrl}/tur/hbo-max-filmleri-izleyin-31"      to "HBO Max Filmleri",
        "${mainUrl}/tur/tabii-filmleri-izleyin-32"        to "Tabii Filmleri",
        "${mainUrl}/tur/mubi-filmleri-izleyin-33"         to "Mubi Filmleri",
        "${mainUrl}/tur/bein-connect-filmleri-izleyin-34" to "Bein Connect Filmleri",
        "${mainUrl}/tur/4k-filmler-izleyin-35"            to "4K Filmler",
        "${mainUrl}/tur/3d-filmler-izleyin-36"            to "3D Filmler",
        "${mainUrl}/tur/2023-cikan-filmler-izleyin-37"    to "2023 Çıkan Filmler",
        "${mainUrl}/tur/2022-cikan-filmler-izleyin-38"    to "2022 Çıkan Filmler",
        "${mainUrl}/tur/2021-cikan-filmler-izleyin-39"    to "2021 Çıkan Filmler",
        "${mainUrl}/tur/2020-cikan-filmler-izleyin-40"    to "2020 Çıkan Filmler",
        "${mainUrl}/tur/2019-cikan-filmler-izleyin-41"    to "2019 Çıkan Filmler",
        "${mainUrl}/tur/2018-cikan-filmler-izleyin-42"    to "2018 Çıkan Filmler",
        "${mainUrl}/tur/2017-cikan-filmler-izleyin-43"    to "2017 Çıkan Filmler",
        "${mainUrl}/tur/2016-cikan-filmler-izleyin-44"    to "2016 Çıkan Filmler",
        "${mainUrl}/tur/2015-cikan-filmler-izleyin-45"    to "2015 Çıkan Filmler",
        "${mainUrl}/tur/2014-cikan-filmler-izleyin-46"    to "2014 Çıkan Filmler",
        "${mainUrl}/tur/2013-cikan-filmler-izleyin-47"    to "2013 Çıkan Filmler",
        "${mainUrl}/tur/2012-cikan-filmler-izleyin-48"    to "2012 Çıkan Filmler",
        "${mainUrl}/tur/2011-cikan-filmler-izleyin-49"    to "2011 Çıkan Filmler",
        "${mainUrl}/tur/2010-cikan-filmler-izleyin-50"    to "2010 Çıkan Filmler",
        "${mainUrl}/tur/2009-cikan-filmler-izleyin-51"    to "2009 Çıkan Filmler",
        "${mainUrl}/tur/2008-cikan-filmler-izleyin-52"    to "2008 Çıkan Filmler",
        "${mainUrl}/tur/2007-cikan-filmler-izleyin-53"    to "2007 Çıkan Filmler",
        "${mainUrl}/tur/2006-cikan-filmler-izleyin-54"    to "2006 Çıkan Filmler",
        "${mainUrl}/tur/2005-cikan-filmler-izleyin-55"    to "2005 Çıkan Filmler",
        "${mainUrl}/tur/2004-cikan-filmler-izleyin-56"    to "2004 Çıkan Filmler",
        "${mainUrl}/tur/2003-cikan-filmler-izleyin-57"    to "2003 Çıkan Filmler",
        "${mainUrl}/tur/2002-cikan-filmler-izleyin-58"    to "2002 Çıkan Filmler",
        "${mainUrl}/tur/2001-cikan-filmler-izleyin-59"    to "2001 Çıkan Filmler",
        "${mainUrl}/tur/2000-cikan-filmler-izleyin-60"    to "2000 Çıkan Filmler",
        "${mainUrl}/tur/1990-lu-yillar-filmleri-izleyin-61" to "1990'lu Yıllar Filmleri",
        "${mainUrl}/tur/1980-li-yillar-filmleri-izleyin-62" to "1980'li Yıllar Filmleri",
        "${mainUrl}/tur/1970-li-yillar-filmleri-izleyin-63" to "1970'li Yıllar Filmleri",
        "${mainUrl}/tur/1960-li-yillar-filmleri-izleyin-64" to "1960'lı Yıllar Filmleri",
        "${mainUrl}/tur/1950-li-yillar-filmleri-izleyin-65" to "1950'li Yıllar Filmleri",
        "${mainUrl}/tur/1940-li-yillar-filmleri-izleyin-66" to "1940'lı Yıllar Filmleri",
        "${mainUrl}/tur/1930-lu-yillar-filmleri-izleyin-67" to "1930'lu Yıllar Filmleri",
        "${mainUrl}/tur/1920-li-yillar-filmleri-izleyin-68" to "1920'li Yıllar Filmleri",
        "${mainUrl}/tur/1910-lu-yillar-filmleri-izleyin-69" to "1910'lu Yıllar Filmleri",
        "${mainUrl}/tur/1900-lu-yillar-filmleri-izleyin-70" to "1900'lu Yıllar Filmleri"
    )

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        val document = app.get("${request.data}/page/$page").document
        val home     = document.select("div.section-content article").mapNotNull { it.toSearchResult() }

        return newHomePageResponse(request.name, home)
    }

    private fun Element.toSearchResult(): SearchResponse? {
        val title     = selectFirst("h3 a")?.text()?.trim() ?: return null
        val href      = fixUrlNull(selectFirst("h3 a")?.attr("href")) ?: return null
        val posterUrl = fixUrlNull(selectFirst("img")?.attr("data-src"))

        return newMovieSearchResponse(title, href, TvType.Movie) { this.posterUrl = posterUrl }
    }

    override suspend fun search(query: String): List<SearchResponse> {
        val document = app.get("${mainUrl}/?s=$query").document

        return document.select("div.section-content article").mapNotNull { it.toSearchResult() }
    }

    override suspend fun quickSearch(query: String): List<SearchResponse> = search(query)

    override suspend fun load(url: String): LoadResponse? {
        val document = app.get(url).document

        val title       = document.selectFirst("h1.section-title")?.text()?.substringBefore(" izle") ?: return null
        val poster      = fixUrlNull(document.select("aside.post-info-poster img.lazyload").lastOrNull()?.attr("data-src"))
        val tags        = document.select("div.post-info-genres a").map { it.text() }
        val year        = document.selectFirst("div.post-info-year-country a")?.text()?.trim()?.toIntOrNull()
        val tvType      = if (document.select("div.seasons").isEmpty()) TvType.Movie else TvType.TvSeries
        val description = document.selectFirst("article.post-info-content > p")?.text()?.trim()
        val rating      = document.selectFirst("div.post-info-imdb-rating span")?.text()?.substringBefore("(")?.trim()?.toRatingInt()
        val actors      = document.select("div.post-info-cast a").map {
            Actor(it.selectFirst("strong")!!.text(), it.select("img").attr("data-src"))
        }

        val recommendations = document.select("div.section-slider-container div.slider-slide").mapNotNull {
                val recName      = it.selectFirst("a")?.attr("title") ?: return@mapNotNull null
                val recHref      = fixUrlNull(it.selectFirst("a")?.attr("href")) ?: return@mapNotNull null
                val recPosterUrl = fixUrlNull(it.selectFirst("img")?.attr("data-src")) ?: fixUrlNull(it.selectFirst("img")?.attr("src"))

                newMovieSearchResponse(recName, recHref, TvType.Movie) { this.posterUrl = recPosterUrl }
            }

        return if (tvType == TvType.TvSeries) {
            val episodes = mutableListOf<Episode>()

            document.select("div.seasons div.season").forEach { season ->
                val seasonNumber = season.selectFirst("h3")?.text()?.substringAfter("Sezon ")?.toIntOrNull() ?: 1

                season.select("div.episodes a").forEach { ep ->
                    val epHref  = fixUrlNull(ep.attr("href")) ?: return@forEach
                    val epName  = ep.selectFirst("span.episode-title")?.text()?.trim() ?: return@forEach
                    val epNum   = Regex("""(\d+)\. ?Bölüm""").find(epName)?.groupValues?.get(1)?.toIntOrNull() ?: 1
                    val epSeason  = Regex("""(\d+)\. ?Sezon""").find(epName)?.groupValues?.get(1)?.toIntOrNull() ?: 1

                    newEpisode(epHref) {
                        this.name = epName
                        this.season = epSeason
                        this.episode = epEpisode
                    }
                }
            }

            newTvSeriesLoadResponse(title, url, TvType.TvSeries, episodes) {
                this.posterUrl       = poster
                this.year            = year
                this.plot            = description
                this.tags            = tags
                this.rating          = rating
                this.recommendations = recommendations
                addActors(actors)
                addTrailer(trailer)
            }
        } else {
            val trailer = document.selectFirst("div.post-info-trailer button")?.attr("data-modal")?.substringAfter("trailer/")?.let { "https://www.youtube.com/embed/$it" }

            newMovieLoadResponse(title, url, TvType.Movie, url) {
                this.posterUrl       = poster
                this.year            = year
                this.plot            = description
                this.tags            = tags
                this.rating          = rating
                this.recommendations = recommendations
                addActors(actors)
                addTrailer(trailer)
            }
        }
    }

    private suspend fun invokeLocalSource(source: String, url: String, subtitleCallback: (SubtitleFile) -> Unit, callback: (ExtractorLink) -> Unit ) {
        val script    = app.get(url, referer = "${mainUrl}/").document.select("script").find { it.data().contains("sources:") }?.data() ?: return
        val videoData = getAndUnpack(script).substringAfter("file_link=\"").substringBefore("\";")
        val subData   = script.substringAfter("tracks: [").substringBefore("]")

        callback.invoke(
            ExtractorLink(
                source  = source,
                name    = source,
                url     = base64Decode(videoData),
                referer = "${mainUrl}/",
                quality = Qualities.Unknown.value,
                isM3u8  = false
            )
        )

        tryParseJson<List<Subtitles>>("$subData")?.forEach { subtitle ->
            subtitleCallback.invoke(
                SubtitleFile(subtitle.label ?: "", subtitle.file ?: "")
            )
        }
    }

    override suspend fun loadLinks(data: String, isCasting: Boolean, subtitleCallback: (SubtitleFile) -> Unit, callback: (ExtractorLink) -> Unit): Boolean {
        val document = app.get(data).document

        document.select("div.video-players iframe").forEach { iframe ->
            val iframeUrl = fixUrlNull(iframe.attr("data-src")) ?: return@forEach
            loadExtractor(iframeUrl, data, subtitleCallback, callback)
        }

        document.select("div.video-players a").forEach { link ->
            val linkUrl = fixUrlNull(link.attr("href")) ?: return@forEach
            if (linkUrl.contains("hdfilmcehennemi")) {
                invokeLocalSource("HDFilmCehennemi", linkUrl, subtitleCallback, callback)
            } else {
                loadExtractor(linkUrl, data, subtitleCallback, callback)
            }
        }

        return true
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Subtitles(
        @JsonProperty("file")  val file: String?  = null,
        @JsonProperty("label") val label: String? = null,
        @JsonProperty("kind")  val kind: String?  = null
    )

    data class Results(
        @JsonProperty("results") val results: List<String> = arrayListOf()
    )
}