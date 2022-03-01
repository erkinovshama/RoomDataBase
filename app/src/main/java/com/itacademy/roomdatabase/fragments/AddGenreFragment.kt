package com.itacademy.roomdatabase.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.itacademy.roomdatabase.App
import com.itacademy.roomdatabase.databinding.FragmentSecondBinding
import com.itacademy.roomdatabase.entities.Genre


class AddGenreFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = App.instance?.getDatabase()?.genreDao()

        binding.saveGenreBtn.setOnClickListener {
            val genre = Genre(
                id = null,
                name = binding.genreName.text.toString()
            )
            db?.addGenre(genre)
            Log.d("Get", "${db?.getAllGenre()}")
        }
    }
}