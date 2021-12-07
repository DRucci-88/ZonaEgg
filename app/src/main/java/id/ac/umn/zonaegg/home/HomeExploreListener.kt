package id.ac.umn.zonaegg.home

import id.ac.umn.zonaegg.data.Eatery

interface HomeExploreListener {
    fun onChangeNav(category: String)
    fun goToDetailEatery(data: Eatery)
}