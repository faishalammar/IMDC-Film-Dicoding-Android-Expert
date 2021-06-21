package dicoding.mobileprogramming.faishalammar.imdc.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.navigation.dynamicfeatures.DynamicExtras
import androidx.navigation.dynamicfeatures.DynamicInstallMonitor
import androidx.navigation.findNavController
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import dicoding.mobileprogramming.faishalammar.imdc.R
import dicoding.mobileprogramming.faishalammar.imdc.databinding.ActivityHomeBinding
import dicoding.mobileprogramming.faishalammar.imdc.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {


        _binding = FragmentHomeBinding.inflate(layoutInflater)

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, MovieListFragment(), MovieListFragment::class.java.simpleName)
            .addToBackStack("fav users")
            .commit()



        val bottomNavigationView = binding.bottomNavigation

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, MovieListFragment(), MovieListFragment::class.java.simpleName)
                        .addToBackStack("list movie")
                        .commit()
                    // Respond to navigation item 1 click
                    true
                }
                R.id.page_2 -> {
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container,TvSeriesListFragment(), TvSeriesListFragment::class.java.simpleName)
                        .addToBackStack("list series")
                        .commit()
                    true
                }
                R.id.page_3 -> {
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container,FavouriteContainerFragment(), FavouriteContainerFragment::class.java.simpleName)
                        .addToBackStack("list fav")
                        .commit()
                    true
                }

                else -> false
            }
        }

        return binding.root
    }


}