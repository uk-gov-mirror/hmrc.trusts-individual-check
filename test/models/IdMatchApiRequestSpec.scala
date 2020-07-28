/*
 * Copyright 2020 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package models

import config.AppConfig
import play.api.libs.json.JsValue
//import org.scalatest.matchers.should.Matchers
import org.scalatest.matchers.must.{Matchers => MustMatchers}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.libs.json.Json
import play.api.test.{FakeRequest, Helpers}
import play.api.{Configuration, Environment}
import uk.gov.hmrc.play.bootstrap.config.ServicesConfig

class IdMatchApiRequestSpec extends AnyWordSpec with MustMatchers{

  private val exampleJson:String = "{\"nino\":\"AB123456A\",\"surname\":\"Bloggs\",\"forename\":\"Joe\",\"birthDate\":\"2000-02-29\"}"

  private val exampleObj:IdMatchApiRequest = IdMatchApiRequest(
    nino = "AB123456A",
    surname = "Bloggs",
    forename = "Joe",
    birthDate = "2000-02-29")

  "exampleRequest" should {

    "read correctly" in {
      val json = Json.parse(exampleJson)
      val obj = Json.fromJson[IdMatchApiRequest](json).get
      obj.mustBe(exampleObj)
    }

    "write correctly" in {
      val json:JsValue = Json.toJson(exampleObj)
      Json.stringify(json).mustBe(exampleJson)
    }
  }
}
