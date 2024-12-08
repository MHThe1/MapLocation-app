package com.example.maploca

data class MapEntries(val id: String,
                      val title: String,
                      val lat: String,
                      val lon: String,
                      val image: String,)



typealias MapEntriesResponse = List<MapEntries>
