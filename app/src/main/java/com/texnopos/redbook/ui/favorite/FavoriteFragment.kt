package com.texnopos.redbook.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.texnopos.redbook.R
import com.texnopos.redbook.data.RedBookDatabase
import com.texnopos.redbook.data.dao.AnimalDao
import com.texnopos.redbook.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment(R.layout.fragment_favorite), AnimalItemClickListener {

    private val adapter: FavoriteListAdapter = FavoriteListAdapter(this)
    private lateinit var dao: AnimalDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoriteList.adapter = adapter
        favoriteList.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        dao = RedBookDatabase.getInstance(requireContext()).dao()
    }

    override fun onStart() {
        super.onStart()
        setData()
    }

    private fun setData() {
        adapter.models = dao.getFavorites()
    }

    override fun onAnimalItemClick(id: Int) {
        val mIntent = Intent(requireActivity(), DetailActivity::class.java)
        mIntent.putExtra(DetailActivity.ANIMAL_ID, id)
        startActivity(mIntent)
    }
}