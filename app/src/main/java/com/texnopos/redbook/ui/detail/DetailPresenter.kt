package com.texnopos.redbook.ui.detail

import com.texnopos.redbook.data.dao.AnimalDao
import com.texnopos.redbook.data.model.Animal

class DetailPresenter(private val dao: AnimalDao, private val view: DetailView) {

    fun getAnimalById(id: Int) {
        view.setDetailInfo(dao.getAnimalById(id))
    }

    fun updateAnimal(animal: Animal) {
        dao.updateAnimal(animal)
    }
}