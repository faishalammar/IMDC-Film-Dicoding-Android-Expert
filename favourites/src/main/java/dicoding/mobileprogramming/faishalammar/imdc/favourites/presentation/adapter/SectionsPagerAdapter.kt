package dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.adapter

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import dicoding.mobileprogramming.faishalammar.imdc.R
import dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.fragment.MovieFavouriteFragment
import dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.fragment.TvSeriesFavouriteFragment


class SectionsPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    private val mContext :Context = fragmentActivity.applicationContext

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies_page, R.string.tv_series_page)
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment = Fragment()
        when (position) {
            0 -> fragment = MovieFavouriteFragment()
            1 -> fragment = TvSeriesFavouriteFragment()
            else -> Fragment()
        }
        return fragment
    }




    override fun getItemCount(): Int = 2

}