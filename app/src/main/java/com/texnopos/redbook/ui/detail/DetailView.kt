package com.texnopos.redbook.ui.detail

import com.texnopos.redbook.data.model.Animal

interface DetailView {
    fun setDetailInfo(animal: Animal)
}