package dicoding.mobileprogramming.faishalammar.imdc.presentation.activity

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dicoding.mobileprogramming.faishalammar.imdc.MyApplication
import dicoding.mobileprogramming.faishalammar.imdc.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)

        // removing toolbar elevation
        supportActionBar?.elevation = 0F

        setContentView(binding.root)
    }

    override fun onBackPressed() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q &&
            isTaskRoot &&
            supportFragmentManager.primaryNavigationFragment?.childFragmentManager?.backStackEntryCount ?: 0 == 0 &&
            supportFragmentManager.backStackEntryCount == 0
        ) {
            finishAfterTransition()
        } else {
            super.onBackPressed()
        }
    }
    override fun onPause() {
        super.onPause()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}