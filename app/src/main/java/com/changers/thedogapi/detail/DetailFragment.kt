package com.changers.thedogapi.detail


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.changers.thedogapi.Constants.IMG_URL
import com.changers.thedogapi.R
import com.changers.thedogapi.databinding.FragmentDetailBinding
import com.changers.thedogapi.main.MainViewModel
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {
    private lateinit var binding:FragmentDetailBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel= ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        viewModel.person.observe(viewLifecycleOwner, { o ->
                Log.d("List_of_selected: ", o.toString())

                binding.breedDetail = o

            val imageView: ImageView = view.findViewById(R.id.imageView)
            val url = IMG_URL+o.reference_image_id+".jpg"
            Picasso.with(activity).load(url).into(imageView)
        })
    }

}
