package fr.purplegiraffe.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    interface HomeFragmentProtocol {
        fun maSuperFonction()
    }

    private val viewModel:HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_SayHello.setOnClickListener { onButtonClick() }
        viewModel.loadedShow.observe(this, Observer { show -> updateDisplay(show) })
    }

    private fun updateDisplay(show: Show?) {
        if (show != null) {
            lbl_hello.text = show.name
        } else {
            lbl_hello.text = ""
        }
    }

    private fun onButtonClick() {
//        val direction = HomeFragmentDirections.actionHomeFragmentToSettingsFragment("Hello")
//        findNavController().navigate(direction)
        viewModel.startLoadingShow()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activity = activity as? HomeFragmentProtocol ?: return
        activity.maSuperFonction()
    }
}
