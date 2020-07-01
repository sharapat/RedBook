package com.texnopos.redbook.ui.favorite

import com.texnopos.redbook.data.dao.AnimalDao

class FavoritePresenter(private val dao: AnimalDao, private val view: FavoriteView) {
    fun getFavorites() {
        view.setFavorites(dao.getFavorites())
    }
}