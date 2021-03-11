package ru.smak.graphics_09_862.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ru.smak.graphics_09_862.R
import ru.smak.graphics_09_862.ui.view.CartesianView

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var btnShow: Button? = null
    private var graphicsView: CartesianView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    private fun x2(x: Float) = x*x

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        activity?.apply{
            graphicsView = findViewById(R.id.cartesianView)
            btnShow = findViewById(R.id.btnShow)
            btnShow?.setOnClickListener {
                (it as Button).text = "OK"
                //graphicsView?.showRect = !((graphicsView?.showRect) ?: true)
                viewModel.boolValue = !viewModel.boolValue
                graphicsView?.function = ::x2
            }
            viewModel.setOnDataChangedListener(this){
                graphicsView?.showRect = it
            }
        }

    }

}