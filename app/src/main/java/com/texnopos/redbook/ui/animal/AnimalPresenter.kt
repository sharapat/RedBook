package com.texnopos.redbook.ui.animal

import com.texnopos.redbook.data.dao.AnimalDao


class AnimalPresenter(private val dao: AnimalDao, private val view: AnimalView) {

    fun getAllAnimals(type: Int) {
        view.setData(dao.getAllAnimals(type))
    }
}