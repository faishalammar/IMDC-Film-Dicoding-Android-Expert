package dicoding.mobileprogramming.faishalammar.imdc.presentation.activity

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

}