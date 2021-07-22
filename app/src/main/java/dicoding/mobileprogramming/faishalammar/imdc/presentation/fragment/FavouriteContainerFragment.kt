package dicoding.mobileprogramming.faishalammar.imdc.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.dynamicfeatures.DynamicExtras
import androidx.navigation.dynamicfeatures.DynamicInstallMonitor
import dicoding.mobileprogramming.faishalammar.imdc.databinding.FragmentFavouriteContainerBinding

class FavouriteContainerFragment : Fragment() {
    private var _binding: FragmentFavouriteContainerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentFavouriteContainerBinding.inflate(layoutInflater)

        Log.d("Ready to go to : ", "Favourite Modules")

        val installMonitor = DynamicInstallMonitor()
        val dynamicExtras = DynamicExtras(installMonitor)

        return binding.root
    }

}