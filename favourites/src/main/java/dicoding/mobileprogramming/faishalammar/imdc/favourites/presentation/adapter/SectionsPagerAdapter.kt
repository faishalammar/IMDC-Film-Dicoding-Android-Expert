package dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.adapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.fragment.MovieFavouriteFragment
import dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.fragment.TvSeriesFavouriteFragment


class SectionsPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MovieFavouriteFragment()
            1 -> TvSeriesFavouriteFragment()
            else -> Fragment()
        }
    }




    override fun getItemCount(): Int = 2

}