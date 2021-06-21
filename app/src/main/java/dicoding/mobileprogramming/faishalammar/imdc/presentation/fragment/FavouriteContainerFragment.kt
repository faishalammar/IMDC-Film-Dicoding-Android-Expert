package dicoding.mobileprogramming.faishalammar.imdc.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.dynamicfeatures.DynamicExtras
import androidx.navigation.dynamicfeatures.DynamicInstallMonitor
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import dicoding.mobileprogramming.faishalammar.imdc.R
import dicoding.mobileprogramming.faishalammar.imdc.databinding.FragmentFavouriteContainerBinding
import dicoding.mobileprogramming.faishalammar.imdc.databinding.FragmentHomeBinding

class FavouriteContainerFragment : Fragment() {
    private var _binding: FragmentFavouriteContainerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentFavouriteContainerBinding.inflate(layoutInflater)

        Log.d("Ready to go to : ", "Favourite Modules")

        val installMonitor = DynamicInstallMonitor()
        val dynamicExtras = DynamicExtras(installMonitor)

        return binding.root
    }

}