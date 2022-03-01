package com.itacademy.roomdatabase.fragments

import android.app.DatePickerDialog
import java.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.itacademy.roomdatabase.App
import android.R
import com.itacademy.roomdatabase.databinding.FragmentFirstBinding
import com.itacademy.roomdatabase.entities.Book
import java.util.*


class AddBookFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    var idGenre: Int? = null
    var formatDate = SimpleDateFormat("dd MMMM ")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbBook = App.instance?.getDatabase()?.bookDao()
        val dbGenre = App.instance?.getDatabase()?.genreDao()
        val getGenreName = dbGenre?.getNameGenre()
        selectDate()

        spinnerGenre(binding.genreSelect, getGenreName!!)
        binding.genreSelect.onItemSelectedListener = this


        binding.addBookBtn.setOnClickListener {
            val book = Book(
                idBook = null,
                bookName = binding.bookName.text.toString(),
                author = binding.bookAuthor.text.toString(),
                date = binding.bookPublicationDate.text.toString(),
                pageAmount = binding.bookAmountPage.text.toString().toInt(),
                amount = binding.bookAmount.text.toString().toInt(),
                place = binding.bookPlace.text.toString(),
                genreID = id
            )
            dbBook?.addBook(book)

            Log.e("Get", "${dbBook?.getAllBooks()}")
        }

    }

    fun spinnerGenre(spinner: Spinner, list: List<String>) {
        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, list)
        spinner.adapter = adapter
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val dbGenre = App.instance?.getDatabase()?.genreDao()
        val genre = dbGenre?.getAllGenre()
        for (i in genre!!) {
            if (parent?.selectedItem == i.name) {
                idGenre = i.id

                Log.e("DDDD", idGenre.toString())
            }
        }
        Log.e("Err", genre.size.toString())
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    fun selectDate() {
        val dateSelect = binding.bookPublicationDate
        dateSelect.setOnClickListener {
            val getDate = Calendar.getInstance()
            val datePicker = DatePickerDialog(
                requireContext(),
                R.style.Theme_Holo_Light_Dialog_MinWidth,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val selectDate = Calendar.getInstance()
                    selectDate.set(Calendar.YEAR, year)
                    selectDate.set(Calendar.MONTH, monthOfYear)
                    selectDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    val date = formatDate.format(selectDate.time)
                    dateSelect.text = date.toString()
                },
                getDate.get(Calendar.YEAR),
                getDate.get(Calendar.MONTH),
                getDate.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }
    }
}