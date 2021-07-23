package dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dicoding.mobileprogramming.faishalammar.core.di.DaggerCoreComponent
import dicoding.mobileprogramming.faishalammar.imdc.R
import dicoding.mobileprogramming.faishalammar.imdc.favourites.databinding.FragmentFavouriteBinding
import dicoding.mobileprogramming.faishalammar.imdc.favourites.di.DaggerFavouriteComponent
import dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.adapter.SectionsPagerAdapter


class FavouriteFragment : Fragment() {

    private var fragmentFavouriteBinding: FragmentFavouriteBinding? = null
    private var viewPager : ViewPager2? = null
    private var tabLayout : TabLayout? = null
    private var tabMediator : TabLayoutMediator? = null

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies_page, R.string.tv_series_page)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerFavouriteComponent
            .factory()
            .create(DaggerCoreComponent.factory().create(context))
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentFavouriteBinding = FragmentFavouriteBinding.inflate(layoutInflater, container, false)

        /*
        ----- Tab Layout ---
        */

        viewPager = fragmentFavouriteBinding!!.viewPager2
        tabLayout = fragmentFavouriteBinding!!.tabs

        viewPager!!.adapter = SectionsPagerAdapter(requireActivity())

        tabMediator = TabLayoutMediator(tabLayout!!, viewPager!!) { tab, position ->
            val tabText = resources.getString(TAB_TITLES[position])
            tab.text = tabText
        }

        tabMediator!!.attach()

        viewPager!!.isSaveEnabled = false

        // Inflate the layout for this fragment
        return fragmentFavouriteBinding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentFavouriteBinding = null
        viewPager = null
        tabLayout = null
        tabMediator?.detach()
        tabMediator = null
    }

}