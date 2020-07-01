package com.texnopos.redbook.ui.favorite

import com.texnopos.redbook.data.model.Animal

interface FavoriteView {
    fun setFavorites(models: List<Animal>)
}