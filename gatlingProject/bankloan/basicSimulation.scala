package bankloan

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class basicSimulation extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://opensource-demo.orangehrmlive.com")
    .inferHtmlResources()
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36 Edg/118.0.2088.61")
  
  private val headers_0 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Cache-Control" -> "max-age=0",
  		"Origin" -> "https://opensource-demo.orangehrmlive.com",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"sec-ch-ua" -> """Chromium";v="118", "Microsoft Edge";v="118", "Not=A?Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val headers_1 = Map(
  		"Accept" -> "application/json",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Cache-Control" -> "max-age=0",
  		"If-None-Match" -> "x9HGOWLJ9iCPDjepLIQUkrSqG3F/k3SDk2ySrkUfKpg=",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"contentType" -> "application/json",
  		"sec-ch-ua" -> """Chromium";v="118", "Microsoft Edge";v="118", "Not=A?Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val headers_2 = Map(
  		"Origin" -> "https://opensource-demo.orangehrmlive.com",
  		"sec-ch-ua" -> """Chromium";v="118", "Microsoft Edge";v="118", "Not=A?Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val headers_5 = Map(
  		"Accept" -> "image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Sec-Fetch-Dest" -> "image",
  		"Sec-Fetch-Mode" -> "no-cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"sec-ch-ua" -> """Chromium";v="118", "Microsoft Edge";v="118", "Not=A?Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val headers_9 = Map(
  		"Accept" -> "application/json",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Origin" -> "https://opensource-demo.orangehrmlive.com",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"sec-ch-ua" -> """Chromium";v="118", "Microsoft Edge";v="118", "Not=A?Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val headers_10 = Map(
  		"Accept" -> "*/*",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Origin" -> "https://opensource-demo.orangehrmlive.com",
  		"Sec-Fetch-Dest" -> "font",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"sec-ch-ua" -> """Chromium";v="118", "Microsoft Edge";v="118", "Not=A?Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val headers_11 = Map(
  		"Accept" -> "application/json, text/plain, */*",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"sec-ch-ua" -> """Chromium";v="118", "Microsoft Edge";v="118", "Not=A?Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val headers_13 = Map(
  		"Accept" -> "application/json",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Cache-Control" -> "no-store, no-cache, must-revalidate, post-check=0, pre-check=0",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"sec-ch-ua" -> """Chromium";v="118", "Microsoft Edge";v="118", "Not=A?Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )


  private val scn = scenario("basicSimulation")
    .exec(
      http("request_0")
        .post("/web/index.php/auth/validate")
        .headers(headers_0)
        .formParam("_token", "9504b68f1e7c3781d.kMMLOfqY1fP8EY2sO42hN5p5TEarR5uvbi4ps7I-T44.w6gmbJnR4IeLQPjaWvTTRMsPf3GdBNKWP0hP2MsJGsvKiERzrKCausxazA")
        .formParam("username", "admin")
        .formParam("password", "admin123")
        .resources(
          http("request_1")
            .get("/web/index.php/core/i18n/messages")
            .headers(headers_1),
          http("request_2")
            .get("/web/dist/fonts/nunito-sans-v6-latin-ext_latin-regular.woff2")
            .headers(headers_2),
          http("request_3")
            .get("/web/dist/fonts/nunito-sans-v6-latin-ext_latin-600.woff2")
            .headers(headers_2),
          http("request_4")
            .get("/web/dist/fonts/bootstrap-icons.woff2")
            .headers(headers_2),
          http("request_5")
            .get("/web/images/orange.png?v=1689053487449")
            .headers(headers_5),
          http("request_6")
            .get("/web/images/orangehrm-logo.png?v=1689053487449")
            .headers(headers_5),
          http("request_7")
            .get("/web/index.php/pim/viewPhoto/empNumber/7")
            .headers(headers_5),
          http("request_8")
            .get("/web/images/dashboard_empty_widget_watermark.png")
            .headers(headers_5),
          http("request_9")
            .post("/web/index.php/events/push")
            .headers(headers_9),
          http("request_10")
            .get("/web/dist/fonts/nunito-sans-v6-latin-ext_latin-700.woff2")
            .headers(headers_10),
          http("request_11")
            .get("/web/index.php/api/v2/buzz/feed?limit=5&offset=0&sortOrder=DESC&sortField=share.createdAtUtc")
            .headers(headers_11),
          http("request_12")
            .get("/web/dist/fonts/nunito-sans-v6-latin-ext_latin-italic.woff2")
            .headers(headers_10),
          http("request_13")
            .get("/web/index.php/api/v2/dashboard/employees/time-at-work?timezoneOffset=2&currentDate=2023-10-23&currentTime=22:31")
            .headers(headers_13),
          http("request_14")
            .get("/web/index.php/api/v2/dashboard/employees/action-summary")
            .headers(headers_13),
          http("request_15")
            .get("/web/index.php/api/v2/dashboard/shortcuts")
            .headers(headers_13),
          http("request_16")
            .get("/web/index.php/api/v2/dashboard/employees/leaves?date=2023-10-23")
            .headers(headers_13),
          http("request_17")
            .get("/web/index.php/api/v2/dashboard/employees/locations")
            .headers(headers_13),
          http("request_18")
            .get("/web/index.php/api/v2/dashboard/employees/subunit")
            .headers(headers_13),
          http("request_19")
            .get("/web/index.php/pim/viewPhoto/empNumber/48")
            .headers(headers_5)
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
