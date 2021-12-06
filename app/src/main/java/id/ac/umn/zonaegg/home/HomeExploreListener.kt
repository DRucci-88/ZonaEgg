package id.ac.umn.zonaegg.home

import id.ac.umn.zonaegg.data.EateryFireStore

interface HomeExploreListener {
    fun onChangeNav(category: String)
    fun goToDetailEatery(data: EateryFireStore)
}