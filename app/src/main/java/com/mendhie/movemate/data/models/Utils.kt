package com.mendhie.movemate.data.models

import androidx.recyclerview.widget.DiffUtil
import com.mendhie.movemate.data.models.Shipment

object Utils {
    val shipments = listOf(
        Shipment(
            1, "in-progress", "today",
            "$1400 USD", "#NEJ20089934122231", "Sep 20,2023"
        ),
        Shipment(
            2, "pending", "today",
            "$650 USD", "#NEJ20089934122231", "Sep 20,2023"
        ),
        Shipment(
            3, "pending", "today",
            "$650 USD", "#NEJ20089934122231", "Sep 20,2023"
        ),
        Shipment(
            4, "loading", "today",
            "$230 USD", "#NEJ20089934122231", "Sep 20,2023"
        ),
        Shipment(
            5, "loading", "today",
            "$230 USD", "#NEJ20089934122231", "Sep 20,2023"
        ),
        Shipment(
            6, "in-progress", "today",
            "$370 USD", "#NEJ20089934122231", "Sep 20,2023"
        ),
        Shipment(
            7, "in-progress", "today",
            "$370 USD", "#NEJ20089934122231", "Sep 20,2023"
        ),
        Shipment(
            8, "pending", "today",
            "$840 USD", "#NEJ20089934122231", "Sep 20,2023"
        ),
        Shipment(
            9, "pending", "today",
            "$840 USD", "#NEJ20089934122231", "Sep 20,2023"
        ),
        Shipment(
            10, "loading", "today",
            "$920 USD", "#NEJ20089934122231", "Sep 20,2023"
        ),
        Shipment(
            11, "loading", "today",
            "$920 USD", "#NEJ20089934122231", "Sep 20,2023"
        ),
        Shipment(
            12, "loading", "today",
            "$9200 USD", "#NEJ20089934122231", "Sep 20,2023"
        ),
    )

    val searchResults = listOf(
        SearchResult(
            1, "Macbook pro M2", "#NE43857340857904",
            "Paris", "Morocco"
        ),
        SearchResult(
            2, "Summer linen jacket", "#NEJ20089934122231",
            "Barcelona", "Paris"
        ),
        SearchResult(
            3, "Tapered-fit jeans AW", "#NEJ35870264978659",
            "Colombia", "Paris"
        ),
        SearchResult(
            4, "Slim fit jeans AW", "#NEJ35870264978659",
            "Bogota", "Dhaka"
        ),
        SearchResult(
            5, "Office setup desk", "#NEJ23481570754963",
            "France", "German"
        ),
    )
}