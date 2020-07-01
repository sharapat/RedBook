package com.texnopos.redbook.ui.animal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.texnopos.redbook.R
import com.texnopos.redbook.data.RedBookDatabase
import com.texnopos.redbook.data.dao.AnimalDao
import com.texnopos.redbook.data.model.Animal
import com.texnopos.redbook.ui.MainActivity
import com.texnopos.redbook.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_animal.*

class AnimalFragment : Fragment(R.layout.fragment_animal) {

    private val myAdapter = AnimalListAdapter()
    private lateinit var dao: AnimalDao
    private lateinit var presenter: AnimalPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myAdapter.setOnItemClickListener {
            val mIntent = Intent(requireActivity(), DetailActivity::class.java)
            mIntent.putExtra(DetailActivity.ANIMAL_ID, id)
            startActivity(mIntent)
        }
        recyclerView.adapter = myAdapter
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        val type = requireArguments().getInt(MainActivity.TYPE_ID)
        dao = RedBookDatabase.getInstance(requireContext()).dao()
        presenter = AnimalPresenter(dao)
        presenter.setFunctionBody {
            myAdapter.models = it
        }
        presenter.getAllAnimals(type)
    }

}