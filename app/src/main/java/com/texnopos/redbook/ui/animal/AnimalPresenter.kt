package com.texnopos.redbook.ui.animal

import com.texnopos.redbook.data.dao.AnimalDao
import com.texnopos.redbook.data.model.Animal


class AnimalPresenter(private val dao: AnimalDao) {

    private var setData : (models: List<Animal>) -> Unit = {
        println("setData ele realizatsiya qilinbadi")
    }

    fun setFunctionBody(qalegen: (a: List<Animal>) -> Unit) {
        this.setData = qalegen
    }

    fun getAllAnimals(type: Int) {
        setData.invoke(dao.getAllAnimals(type))
    }
}