package com.texnopos.redbook.ui.animal

import com.texnopos.redbook.data.model.Animal

interface AnimalView {
    fun setData(models: List<Animal>)
}