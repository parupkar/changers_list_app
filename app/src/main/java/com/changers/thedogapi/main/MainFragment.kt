package com.changers.thedogapi.main

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.changers.thedogapi.Breed
import com.changers.thedogapi.R
import com.changers.thedogapi.adapter.BreedAdapter
import com.changers.thedogapi.databinding.FragmentMainBinding

class MainFragment : Fragment() {


    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)


        val breedList: List<Breed> = emptyList()

        val adapter: BreedAdapter =
            BreedAdapter(breedList, object : BreedAdapter.OnItemClickListener {
                override fun onClick(breed: Breed) {
                    viewModel.setSelectItem(breed)
                    findNavController().navigate(R.id.action_showDetail)
                }

            })
        binding.recyclerView.adapter = adapter
        viewModel.breed.observe(viewLifecycleOwner, Observer { list ->
            adapter.setBreedList(list)
            Log.d(TAG, list.toString())
        })
    }

    companion object {
        const val TAG = "MainFragment"
    }
}
