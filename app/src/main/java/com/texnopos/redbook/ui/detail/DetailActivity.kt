package com.texnopos.redbook.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.texnopos.redbook.R
import com.texnopos.redbook.data.RedBookDatabase
import com.texnopos.redbook.data.dao.AnimalDao
import com.texnopos.redbook.data.model.Animal
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailView {

    companion object {
        const val ANIMAL_ID = "animalId"
    }

    private var animalId: Int = 0
    private lateinit var currentAnimal: Animal
    private lateinit var dao: AnimalDao
    private lateinit var presenter: DetailPresenter
    private var menuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Details"

        dao = RedBookDatabase.getInstance(this).dao()
        presenter = DetailPresenter(dao, this)
        animalId = intent.getIntExtra(ANIMAL_ID, 0)
        presenter.getAnimalById(animalId)
    }

    override fun setDetailInfo(animal: Animal) {
        Log.d("xaywan", animal.habitat)
        currentAnimal = animal
        tvStatusContent.text = animal.status
        tvHabitatContent.text = animal.habitat
        tvPropagationContent.text = animal.propagation
        tvQuantityContent.text = animal.quantity
        tvLifestyleContent.text = animal.lifestyle
        tvLimitingFactorsContent.text = animal.limitingFactors
        tvBreedingContent.text = animal.breeding
        tvSecurityContent.text = animal.security

        Glide
            .with(this)
            .load(resources.getIdentifier("picture$animalId", "drawable", packageName))
            .into(ivDetail)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        menuItem = menu?.findItem(R.id.item_bookmark)
        setFavoriteIcon()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> finish()
            R.id.item_bookmark -> setFavorite()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavorite() {
        if (currentAnimal.isFavorite == null) currentAnimal.isFavorite = 1
        else currentAnimal.isFavorite = 1 - currentAnimal.isFavorite!!
        setFavoriteIcon()
        presenter.updateAnimal(currentAnimal)
    }

    private fun setFavoriteIcon() {
        if(currentAnimal.isFavorite == 1) {
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark_24)
        } else {
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark_border_24)
        }
    }
}