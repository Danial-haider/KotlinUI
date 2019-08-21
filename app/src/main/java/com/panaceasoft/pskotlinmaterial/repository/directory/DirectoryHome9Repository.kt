package com.panaceasoft.pskotlinmaterial.repository.directory

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryHome9CategoryVO
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryHome9FlightsVO
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryHome9PopularVO
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryHome9ProductsVO
import com.panaceasoft.pskotlinmaterial.`object`.DirectoryHome9PromotionsVO

import java.util.ArrayList

object DirectoryHome9Repository {

    val categoryList: ArrayList<DirectoryHome9CategoryVO>
        get() = Gson().fromJson<ArrayList<DirectoryHome9CategoryVO>>(categoryJson, object : TypeToken<ArrayList<DirectoryHome9CategoryVO>>() {

        }.type)

    val flightsList: ArrayList<DirectoryHome9FlightsVO>
        get() = Gson().fromJson<ArrayList<DirectoryHome9FlightsVO>>(flightsJson, object : TypeToken<ArrayList<DirectoryHome9FlightsVO>>() {

        }.type)

    val popularList: ArrayList<DirectoryHome9PopularVO>
        get() = Gson().fromJson<ArrayList<DirectoryHome9PopularVO>>(popularJson, object : TypeToken<ArrayList<DirectoryHome9PopularVO>>() {

        }.type)

    val productsList: ArrayList<DirectoryHome9ProductsVO>
        get() = Gson().fromJson<ArrayList<DirectoryHome9ProductsVO>>(productsJson, object : TypeToken<ArrayList<DirectoryHome9ProductsVO>>() {

        }.type)

    val promotionsList: ArrayList<DirectoryHome9PromotionsVO>
        get() = Gson().fromJson<ArrayList<DirectoryHome9PromotionsVO>>(promotionsJson, object : TypeToken<ArrayList<DirectoryHome9PromotionsVO>>() {

        }.type)

    private val categoryJson = "[{\n" +
            "  \"id\": \"category1\",\n" +
            "  \"icon\": \"baseline_document_full_grey_24\",\n" +
            "  \"name\": \"Bills & Top-up\"\n" +
            "},\n" +
            "  {\n" +
            "    \"id\": \"category2\",\n" +
            "    \"icon\": \"baseline_topup_grey_24\",\n" +
            "    \"name\": \"Top-Up & Data Packages\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"category3\",\n" +
            "    \"icon\": \"baseline_movie_filter_grey_24\",\n" +
            "    \"name\": \"Movies\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"category4\",\n" +
            "    \"icon\": \"baseline_pay_later_24\",\n" +
            "    \"name\": \"Pay Later\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"category5\",\n" +
            "    \"icon\": \"baseline_save_card_black_24\",\n" +
            "    \"name\": \"International Data Plans\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"category6\",\n" +
            "    \"icon\": \"baseline_check_in_grey_24\",\n" +
            "    \"name\": \"Online Check-in\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"category7\",\n" +
            "    \"icon\": \"baseline_bell_40_grey_25\",\n" +
            "    \"name\": \"Price Alerts\"\n" +
            "  }\n" +
            "]"

    private val flightsJson = "[{\n" +
            "  \"id\": \"flight1\",\n" +
            "  \"image\": \"home9_city_5\",\n" +
            "  \"country\": \"Seoul\",\n" +
            "  \"price\": \"35 $\",\n" +
            "  \"duration\": \"25Aug 30May2018\",\n" +
            "  \"description\": \"pet person staring\"\n" +
            "},\n" +
            "  {\n" +
            "    \"id\": \"flight2\",\n" +
            "    \"image\": \"home9_city_6\",\n" +
            "    \"country\": \"Kuala Lumpur\",\n" +
            "    \"price\": \"20 $\",\n" +
            "    \"duration\": \"25Aug 30May2018\",\n" +
            "    \"description\": \"pet person staring\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"flight3\",\n" +
            "    \"image\": \"sg_clarke_quay\",\n" +
            "    \"country\": \"Singapore\",\n" +
            "    \"price\": \"35 $\",\n" +
            "    \"duration\": \"25Aug 30May2018\",\n" +
            "    \"description\": \"pet person staring\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"flight4\",\n" +
            "    \"image\": \"home9_city_1\",\n" +
            "    \"country\": \"Seoul\",\n" +
            "    \"price\": \"35 $\",\n" +
            "    \"duration\": \"25Aug 30May2018\",\n" +
            "    \"description\": \"pet person staring\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"flight5\",\n" +
            "    \"image\": \"home9_city_2\",\n" +
            "    \"country\": \"Kuala Lumpur\",\n" +
            "    \"price\": \"20 $\",\n" +
            "    \"duration\": \"25Aug 30May2018\",\n" +
            "    \"description\": \"pet person staring\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"flight6\",\n" +
            "    \"image\": \"sg_clarke_quay\",\n" +
            "    \"country\": \"Singapore\",\n" +
            "    \"price\": \"35 $\",\n" +
            "    \"duration\": \"25Aug 30May2018\",\n" +
            "    \"description\": \"pet person staring\"\n" +
            "  }\n" +
            "]"

    private val popularJson = "[{\n" +
            "  \"id\": \"popular1\",\n" +
            "  \"image\": \"home9_city_1\",\n" +
            "  \"name\": \"Jakarta\",\n" +
            "  \"place\": \"Metropolis Charm\"\n" +
            "},\n" +
            "  {\n" +
            "    \"id\": \"popular2\",\n" +
            "    \"image\": \"home9_city_2\",\n" +
            "    \"name\": \"Ubud\",\n" +
            "    \"place\": \"Artists' Den\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"popular3\",\n" +
            "    \"image\": \"home9_city_3\",\n" +
            "    \"name\": \"Penang\",\n" +
            "    \"place\": \"Interesting Vibes\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"popular4\",\n" +
            "    \"image\": \"home9_city_4\",\n" +
            "    \"name\": \"Malacca\",\n" +
            "    \"place\": \"Museum City\"\n" +
            "  }\n" +
            "]"

    private val productsJson = "[{\n" +
            "  \"id\": \"product1\",\n" +
            "  \"icon\": \"home9_flight\",\n" +
            "  \"name\": \"Flights\"\n" +
            "},\n" +
            "  {\n" +
            "    \"id\": \"product2\",\n" +
            "    \"icon\": \"home9_hotel\",\n" +
            "    \"name\": \"Hotels\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"product3\",\n" +
            "    \"icon\": \"home9_flight_hotel\",\n" +
            "    \"name\": \"Flight + Hotel\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"product4\",\n" +
            "    \"icon\": \"home9_activities\",\n" +
            "    \"name\": \"Attractions & Activities\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"product5\",\n" +
            "    \"icon\": \"home9_eats\",\n" +
            "    \"name\": \"Eats\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"product6\",\n" +
            "    \"icon\": \"home9_train\",\n" +
            "    \"name\": \"Trains\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"product7\",\n" +
            "    \"icon\": \"home9_bus\",\n" +
            "    \"name\": \"Bus\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"product8\",\n" +
            "    \"icon\": \"home9_airport\",\n" +
            "    \"name\": \"Airport Transport\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"product9\",\n" +
            "    \"icon\": \"home9_rental\",\n" +
            "    \"name\": \"Car Rental\"\n" +
            "  },\n" +
            "  {\n" +
            "  \"id\": \"product10\",\n" +
            "  \"icon\": \"home9_rental\",\n" +
            "  \"name\": \"All Products\"\n" +
            "}\n" +
            "]"

    private val promotionsJson = "[\n" +
            "  {\n" +
            "    \"id\": \"promotion1\",\n" +
            "    \"image\": \"home9_promo_1\",\n" +
            "    \"name\": \"Discoutn Coupon\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"promotion2\",\n" +
            "    \"image\": \"home9_promo_2\",\n" +
            "    \"name\": \"Discoutn Coupon\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"promotion3\",\n" +
            "    \"image\": \"home9_promo_3\",\n" +
            "    \"name\": \"Discoutn Coupon\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"promotion4\",\n" +
            "    \"image\": \"home9_promo_1\",\n" +
            "    \"name\": \"Discoutn Coupon\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"promotion5\",\n" +
            "    \"image\": \"home9_promo_2\",\n" +
            "    \"name\": \"Discoutn Coupon\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"promotion6\",\n" +
            "    \"image\": \"home9_promo_3\",\n" +
            "    \"name\": \"Discoutn Coupon\"\n" +
            "  }\n" +
            "]"

}
