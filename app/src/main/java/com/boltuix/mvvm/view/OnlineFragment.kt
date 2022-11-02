package com.boltuix.mvvm.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.boltuix.mvvm.R
import com.boltuix.mvvm.adapter.NewsAdapter
import com.boltuix.mvvm.databinding.FragmentOnlineBinding
/*import com.boltuix.mvvm.utils.DataHandler*/
import com.boltuix.mvvm.utils.LogData
import com.boltuix.mvvm.utils.Resource
import com.boltuix.mvvm.viewModel.OnlineViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class OnlineFragment : Fragment() {

    private var _binding: FragmentOnlineBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    @Inject
    lateinit var newsAdapter: NewsAdapter

    private val viewModel: OnlineViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentOnlineBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        lifecycleScope.launchWhenStarted {
            viewModel.topHeadlines.collect { dataHandler ->

                when (dataHandler) {
                    is Resource.Success<*> -> {
                        binding.progressBar.visibility = View.GONE
                        newsAdapter.differ.submitList(dataHandler.data?.articles)
                    }
                    is Resource.Error<*> -> {
                        binding.progressBar.visibility = View.GONE
                        dataHandler.message?.let { showSnackbar(it) }
                        //Toast.makeText(requireContext(),"${dataHandler.message}",Toast.LENGTH_LONG).show()
                        LogData("onViewCreated: ERROR " + dataHandler.message)
                    }
                    is Resource.Loading<*> -> {
                        binding.progressBar.visibility = View.VISIBLE
                        LogData("onViewCreated: LOADING..")
                    }
                    else -> {}
                }
            }
        }
        viewModel.getTopHeadlines()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun init() {

        newsAdapter.onArticleClicked {
            it.title?.let { it1 -> showSnackbar(it1) }

            viewModel.addToFavorite(it)
        }

        binding.recyclerView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
    
    
    private fun showSnackbar(message :String) {
        try{
            val snackbar = Snackbar.make(binding.coordinator, message, Snackbar.LENGTH_INDEFINITE)
            snackbar.setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.md_theme_light_primary))
            snackbar.show()
        }catch (e:java.lang.Exception){
        }
    }
}