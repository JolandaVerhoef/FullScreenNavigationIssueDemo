package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BottomNavigationFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BottomNavigationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomNavigationFragment : Fragment() {

    var currentNavController: LiveData<NavController>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_navigation, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupBottomNavigationBar()
    }

    /**
     * Called on first creation and when restoring state.
     */
    private fun setupBottomNavigationBar() {
        activity?.apply {
            val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)

            val navGraphIds = listOf(R.navigation.tab2, R.navigation.tab1)

            // Setup the bottom navigation view with a list of navigation graphs
            val controller = bottomNavigationView?.setupWithNavController(
                navGraphIds = navGraphIds,
                fragmentManager = childFragmentManager,
                containerId = R.id.nav_host_container,
                intent = intent
            )
            currentNavController = controller
        }
    }
}
